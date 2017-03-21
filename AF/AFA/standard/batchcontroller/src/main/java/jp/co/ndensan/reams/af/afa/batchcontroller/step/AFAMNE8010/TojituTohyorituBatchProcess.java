/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.MochidashiPcCommonUtil;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.TojituTohyorituBatchCsvEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.TojituTohyorituEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.TojituTohyorituCsvEntity;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 当日投票率ファイル出力のクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class TojituTohyorituBatchProcess extends BatchKeyBreakBase<TojituTohyorituEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata."
                    + "IMochidashiPcCreateDataMapper.select当日投票率");
    private AFABTE801SelectProcessParameter parameter;
    private MochidashiPcCreateDataMybatisParameter mybatisparameter;
    private TojituTohyorituBatchCsvEditor editor;

    private CsvWriter<TojituTohyorituCsvEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;
    private RString shikibetsuCode;
    private Boolean firstFlg;
    private Association association;
    private MochidashiPcCommonUtil common;
    private Map<RString, RString> path;

    OutputParameter<Map<RString, RString>> filePath = new OutputParameter<>();

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        common = new MochidashiPcCommonUtil();
        mybatisparameter = parameter.toMybatisParameter();
        mybatisparameter.set地方公共団体コード(association.get地方公共団体コード().value());
        mybatisparameter.set地方公共団体コード連番(association.get連番());
        firstFlg = true;
        path = new HashMap<>();
        shikibetsuCode = RString.EMPTY;
    }

    @Override
    protected void beforeExecute() {
        editor = new TojituTohyorituBatchCsvEditor(parameter,
                UrControlDataFactory.createInstance().getLoginInfo().getUserId());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void usualProcess(TojituTohyorituEntity current) {
        if (firstFlg) {
            RString fileName = AFAEucEntityId.当日投票率ファイル.getFileName();
            fileName = fileName.replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get投票区Entity().getTohyokuCode()));
            firstFlg = false;
            createCsvWriter(fileName);
        }
        editor.usualProcess(current);
        if (null != current.get選挙人名簿Entity()) {
            shikibetsuCode = shikibetsuCode.concat(common.toRString(current.get選挙人名簿Entity().getShikibetsuCode()))
                    .concat(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString());
        }
    }

    @Override
    protected void keyBreakProcess(TojituTohyorituEntity current) {
        List<TojituTohyorituCsvEntity> list1 = editor.keyBreakProcessBySenkyo(current, getBefore());
        if (null != list1) {
            for (int i = 0; i < list1.size(); i++) {
                csvWriter.writeLine(list1.get(i));
            }
        }
        List<TojituTohyorituCsvEntity> list2 = editor.keyBreakProcessByTohyoku(current, getBefore());
        List<TojituTohyorituCsvEntity> list3 = editor.keyBreakProcessByShohonNo(current, getBefore());
        if (null != list2) {
            for (int i = 0; i < list2.size(); i++) {
                csvWriter.writeLine(list2.get(i));
            }
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
            RString fileName = AFAEucEntityId.当日投票率ファイル.getFileName();
            fileName = fileName.replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get投票区Entity().getTohyokuCode()));
            createCsvWriter(fileName);
        } else if (null != list3) {
            for (int i = 0; i < list3.size(); i++) {
                csvWriter.writeLine(list3.get(i));
            }
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);

            RString fileName = AFAEucEntityId.当日投票率ファイル.getFileName();
            fileName = fileName.replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get投票区Entity().getTohyokuCode()));
            createCsvWriter(fileName);
        }
    }

    @Override
    protected void afterExecute() {
        path.put(MochidashiPcCreateDataEnum.識別コード.getRString(), shikibetsuCode);
        filePath.setValue(path);
        if (!firstFlg) {
            List<TojituTohyorituCsvEntity> list = editor.createLastProcess();
            if (null != list) {
                for (int i = 0; i < list.size(); i++) {
                    csvWriter.writeLine(list.get(i));
                }
            }
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
        }
    }

    private void createCsvWriter(RString fileName) {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.投票状況ファイル.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), fileName);
        this.csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build();
        path.put(fileName.substring(0, fileName.lastIndexOf(MochidashiPcCreateDataEnum.UNDERLINE.getRString())), eucOutputFilePath);
    }
}
