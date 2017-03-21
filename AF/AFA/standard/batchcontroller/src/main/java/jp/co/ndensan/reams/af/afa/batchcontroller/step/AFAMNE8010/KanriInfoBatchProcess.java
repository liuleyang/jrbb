/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata.KanriInfoBatchCsvEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.ConfigInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.KanriInfoCsvEntity;
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
 * 選挙区ファイル出力のクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class KanriInfoBatchProcess extends BatchKeyBreakBase<ConfigInfoEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata."
                    + "IMochidashiPcCreateDataMapper.select管理情報");
    private AFABTE801SelectProcessParameter parameter;
    private MochidashiPcCreateDataMybatisParameter mybatisparameter;
    private KanriInfoBatchCsvEditor editor;

    @BatchWriter
    private CsvWriter<KanriInfoCsvEntity> csvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;
    private List<RString> path;

    OutputParameter<List<RString>> filePath = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toMybatisParameter();
        path = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        editor = new KanriInfoBatchCsvEditor();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.管理情報ファイル.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), AFAEucEntityId.管理情報ファイル.getFileName());
        this.csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build();
    }

    @Override
    protected void usualProcess(ConfigInfoEntity current) {
        csvWriter.writeLine(editor.usualProcess(current));
    }

    @Override
    protected void keyBreakProcess(ConfigInfoEntity current) {
    }

    @Override
    protected void afterExecute() {
        this.csvWriter.close();
        path.add(this.eucOutputFilePath);
        filePath.setValue(path);
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }
}
