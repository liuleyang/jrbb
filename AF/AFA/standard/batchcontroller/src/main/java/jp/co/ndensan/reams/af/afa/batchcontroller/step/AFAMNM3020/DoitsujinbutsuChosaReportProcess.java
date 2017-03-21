/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNM3020;

import jp.co.ndensan.reams.af.afa.business.euc.afamnm3020.DoitsujinbutsuChosaCsvEntityEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.doitsujinbutsuChosa.AFABTM107BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.doitsujinbutsuchosa.enumeratedtype.DoitsujinbutsuChosaRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.doitsujinbutsuchosa.DoitsujinbutsuChosaParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.doitsujinbutsuchosa.DoitsujinbutsuChosaEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afabtm107.DoitsujinbutsuChosaCsvEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 同一人物調査Process。
 *
 * @reamsid_L AF-0690-020 wanghj
 */
public class DoitsujinbutsuChosaReportProcess extends BatchKeyBreakBase<DoitsujinbutsuChosaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.doitsujinbutsuchosa.IDoitsujinbutsuChosaMapper.select同一人物調査");

    private DoitsujinbutsuChosaParameter mybatisParameter;
    private AFABTM107BatchParameter parameter;

    @BatchWriter
    private CsvWriter<DoitsujinbutsuChosaCsvEntity> eucCsvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;
    OutputParameter<Long> pageCount;
    private DoitsujinbutsuChosaCsvEntityEditor editor;

    @Override
    protected void initialize() {
        pageCount = new OutputParameter<>();
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        if (null != parameter.get投票年月日()) {
            build.set基準日(parameter.get投票年月日());
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = new DoitsujinbutsuChosaParameter(shikibetsuTaishoPSMSearchKey,
                null == parameter.get抄本番号() ? new ShohonNo(0) : new ShohonNo(parameter.get抄本番号()),
                parameter.get氏名(), parameter.get氏(),
                parameter.get名(), parameter.getカナ(), parameter.get漢字(), parameter.get生年月日(),
                parameter.get性別(), parameter.get住所(), parameter.get住所コード(),
                parameter.get番地コード());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void beforeExecute() {
        editor = new DoitsujinbutsuChosaCsvEntityEditor();
    }

    @Override
    protected void createWriter() {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.同一人物調査結果.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), AFAEucEntityId.同一人物調査結果.getFileName());
        this.eucCsvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(DoitsujinbutsuChosaRStringEnum.CSV_DELIMITER.getKey())
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build();
    }

    @Override
    protected void keyBreakProcess(DoitsujinbutsuChosaEntity current) {

    }

    @Override
    protected void usualProcess(DoitsujinbutsuChosaEntity current) {
        eucCsvWriter.writeLine(editor.usualProcess(current));
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(eucCsvWriter.getCount());
        this.eucCsvWriter.close();
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

}
