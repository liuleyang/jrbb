/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.MochidashiPcCommonUtil;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.ShohonBatchCsvEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.SenkyoninInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.ShohonCsvEntity;
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
 * 抄本ファイル出力のクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class ShohonBatchProcess extends BatchKeyBreakBase<SenkyoninInfoEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata."
                    + "IMochidashiPcCreateDataMapper.select選挙人情報");
    private AFABTE801SelectProcessParameter parameter;
    private MochidashiPcCreateDataMybatisParameter mybatisparameter;
    private ShohonBatchCsvEditor editor;

    private CsvWriter<ShohonCsvEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;
    private RString code;
    private RString shikibetsuCode;
    private Boolean firstFlg;
    private MochidashiPcCommonUtil common;
    private Map<RString, RString> path;

    OutputParameter<Map<RString, RString>> filePath = new OutputParameter<>();

    @Override
    protected void initialize() {
        common = new MochidashiPcCommonUtil();
        code = common.toRString(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().code市町村());
        mybatisparameter = parameter.toMybatisParameter();
        firstFlg = true;
        path = new HashMap<>();
        shikibetsuCode = RString.EMPTY;
    }

    @Override
    protected void beforeExecute() {
        editor = new ShohonBatchCsvEditor(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void usualProcess(SenkyoninInfoEntity current) {
        if (firstFlg) {
            RString fileName = AFAEucEntityId.抄本ファイル.getFileName().
                    replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get選挙人名簿Entity().getTohyokuCode()));
            createCsvWriter(fileName);
            firstFlg = false;
        }
        csvWriter.writeLine(editor.usualProcess(current, code));
        if (null != current.get選挙人名簿Entity()) {
            shikibetsuCode = shikibetsuCode.concat(common.toRString(current.get選挙人名簿Entity().getShikibetsuCode()))
                    .concat(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString());
        }
    }

    @Override
    protected void keyBreakProcess(SenkyoninInfoEntity current) {
        if (editor.keyBreakProcessByShohonNo(current, getBefore())) {
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);

            RString fileName = AFAEucEntityId.抄本ファイル.getFileName();
            fileName = fileName.replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get選挙人名簿Entity().getTohyokuCode()));
            createCsvWriter(fileName);
        } else if (editor.keyBreakProcessByTohyoku(current, getBefore())) {
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);

            RString fileName = AFAEucEntityId.抄本ファイル.getFileName();
            fileName = fileName.replace(MochidashiPcCreateDataEnum.抄本名.getRString(), current.get抄本Entity().getShohonName())
                    .replace(MochidashiPcCreateDataEnum.XXXX.getRString(), common.padZeroToLeft(current.get選挙人名簿Entity().getTohyokuCode()));
            createCsvWriter(fileName);
        }
    }

    @Override
    protected void afterExecute() {
        path.put(MochidashiPcCreateDataEnum.識別コード.getRString(), shikibetsuCode);
        filePath.setValue(path);
        if (!firstFlg) {
            this.csvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
        }
    }

    private void createCsvWriter(RString fileName) {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.抄本ファイル.getEucEntityId(),
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
