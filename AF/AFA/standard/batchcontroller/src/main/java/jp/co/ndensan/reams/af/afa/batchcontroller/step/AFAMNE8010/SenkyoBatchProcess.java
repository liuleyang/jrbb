/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.SenkyoBatchCsvEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.ShohonInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.SenkyoCsvEntity;
import jp.co.ndensan.reams.af.afa.service.core.mochidashipccreatedata.MochidashiPcCreateDataManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
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
 * 選挙ファイル出力のクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class SenkyoBatchProcess extends BatchKeyBreakBase<ShohonInfoEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata."
                    + "IMochidashiPcCreateDataMapper.select抄本対象");
    private AFABTE801SelectProcessParameter parameter;
    private MochidashiPcCreateDataMybatisParameter mybatisparameter;
    private SenkyoBatchCsvEditor editor;

    @BatchWriter
    private CsvWriter<SenkyoCsvEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private MochidashiPcCreateDataManager manager;
    private RString eucOutputFilePath;
    private Boolean shohonFlg;
    private List<RString> path;

    OutputParameter<List<RString>> filePath = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toMybatisParameter();
        manager = MochidashiPcCreateDataManager.createInstance();
        path = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        shohonFlg = true;
        editor = new SenkyoBatchCsvEditor();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.選挙ファイル.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), AFAEucEntityId.選挙ファイル.getFileName());
        this.csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build();
    }

    @Override
    protected void usualProcess(ShohonInfoEntity current) {
        if (shohonFlg) {
            csvWriter.writeLine(editor.usualProcessShohonNo(current,
                    manager.getMAX名簿基準年月日(current.get抄本Entity().getShohonNo())));
            shohonFlg = false;
        }
        csvWriter.writeLine(editor.usualProcessSenkyo(current));
    }

    @Override
    protected void keyBreakProcess(ShohonInfoEntity current) {
        SenkyoCsvEntity entity = editor.keyBreakProcessByShohonNo(getBefore(), current,
                manager.getMAX名簿基準年月日(current.get抄本Entity().getShohonNo()));
        if (null != entity) {
            csvWriter.writeLine(entity);
        }

    }

    @Override
    protected void afterExecute() {
        this.csvWriter.close();
        path.add(this.eucOutputFilePath);
        filePath.setValue(path);
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }
}
