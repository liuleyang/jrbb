/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.mochidashipcimportuketsukedata.enumeratedtype.MochidashiPcImportUketsukeDataRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.TohyoJokyoCsvEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.mochidashipcimportuketsukedata.TohyoJokyoCsvTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 当日受付データ取込バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public class ANTohyoJokyoReadFileInsertProcess extends BatchProcessBase<TohyoJokyoCsvEntity> {

    private OutputParameter<RString> outTempTableName;
    private AFABTE803SelectProcessParameter selectProcessParameter;
    private RString 投票状況_取込ファイル名;
    private RString filePath;
    private int count;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;
    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = MochidashiPcImportUketsukeDataRStringEnum.一時テーブル名.getKey();
    }

    @Override
    protected void initialize() {
        outTempTableName = new OutputParameter<>();
        投票状況_取込ファイル名 = selectProcessParameter.get投票状況ファイル名();
        RString tmpPath = Directory.createTmpDirectory();
        FilesystemName filesystemName = new FilesystemName(投票状況_取込ファイル名);
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        ReadOnlySharedFileEntryDescriptor entitydesc
                = new ReadOnlySharedFileEntryDescriptor(GyomuCode.AF選挙, filesystemName, selectProcessParameter.get投票状況ファイルId());
        tmpPath = new RString(SharedFile.copyToLocal(entitydesc, filesystemPath).toString());
        filePath = Path.combinePath(tmpPath, 投票状況_取込ファイル名);
        count = 0;

    }

    @Override
    protected IBatchReader createReader() {
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, TohyoJokyoCsvEntity.class)
                .setDelimiter(MochidashiPcImportUketsukeDataRStringEnum.COMMA.getKey())
                .setEnclosure(MochidashiPcImportUketsukeDataRStringEnum.SLASH.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(
                MochidashiPcImportUketsukeDataRStringEnum.TOHYOJOKYO_TEMP_TABLE_NAME.getKey(), TohyoJokyoCsvTempTableEntity.class);
    }

    @Override
    protected void process(TohyoJokyoCsvEntity entity) {
        count++;
        if (count != 1) {
            tempDbWriter.insert(create一時テーブル(entity));
        }

    }

    @Override
    protected void afterExecute() {
        outTempTableName.setValue(MochidashiPcImportUketsukeDataRStringEnum.TOHYOJOKYO_TEMP_TABLE_NAME.getKey());
    }

    private TohyoJokyoCsvTempTableEntity create一時テーブル(TohyoJokyoCsvEntity entity) {
        TohyoJokyoCsvTempTableEntity csvEntity = new TohyoJokyoCsvTempTableEntity();
        if (RString.isNullOrEmpty(entity.get抄本番号())) {
            csvEntity.setShohonNo(new ShohonNo(0));
        } else {
            csvEntity.setShohonNo(new ShohonNo(entity.get抄本番号()));
        }
        if (RString.isNullOrEmpty(entity.get選挙番号())) {
            csvEntity.setSenkyoNo(new SenkyoNo(0));
        } else {
            csvEntity.setSenkyoNo(new SenkyoNo(entity.get選挙番号()));
        }
        csvEntity.setTohyokuCode(entity.get投票区コード());
        csvEntity.setSatsu(entity.get冊());
        csvEntity.setPage(entity.get頁());
        csvEntity.setGyo(entity.get行());
        csvEntity.setJuminCode(entity.get住民コード());
        csvEntity.setSeikyuYMD(changeRStringToFlexibleDate(entity.get請求年月日()));
        csvEntity.setSeikyuHoho(entity.get請求方法());
        csvEntity.setSeikyuJiyu(entity.get請求事由());
        csvEntity.setKofuHyoji(entity.get交付表示());
        csvEntity.setKofuYMD(changeRStringToFlexibleDate(entity.get交付年月日()));
        csvEntity.setKofuTime(changeRStringToRTime(entity.get交付時刻()));
        csvEntity.setKofuKubun(entity.get交付区分());
        csvEntity.setKofuUketsukeNo(entity.get交付受付番号());
        csvEntity.setKofuHoho(entity.get交付方法());
        csvEntity.setKofuShisetsuCode(entity.get交付施設コード());
        csvEntity.setTenjiFlag(entity.get点字());
        csvEntity.setShomeishoPrintFlag(entity.get証明書の有無());
        csvEntity.setJuriHyoji(entity.get受理表示());
        csvEntity.setJuriYMD(changeRStringToFlexibleDate(entity.get受理年月日()));
        csvEntity.setJuriTime(changeRStringToRTime(entity.get受理時刻()));
        csvEntity.setJuriHoho(entity.get受理方法());
        csvEntity.setJuriShisetsuShubetsu(entity.get受理施設_投票場所());
        csvEntity.setHenkanYMD(changeRStringToFlexibleDate(entity.get返還年月日()));
        csvEntity.setHenkanTime(changeRStringToRTime(entity.get返還時刻()));
        csvEntity.setDairiTohyoAriFlag(entity.get代理投票区分());
        csvEntity.setHojoshaShimei1(entity.get補助者1());
        csvEntity.setHojoshaShimei2(entity.get補助者2());
        csvEntity.setTanmatsuId(entity.get端末ID());
        csvEntity.setIsDeleted(entity.get削除フラグ());
        csvEntity.setUpdateCount(entity.get更新カウンタ());
        csvEntity.setInsertDataLoginId(entity.get作成ユーザ());
        csvEntity.setInsertDataTimestamp(entity.get作成日時());
        csvEntity.setLastUpdateDataLoginId(entity.get更新ユーザ());
        csvEntity.setLastUpdateDataTimestamp(entity.get更新日時());
        return csvEntity;
    }

    private FlexibleDate changeRStringToFlexibleDate(RString 日付) {
        if (RString.isNullOrEmpty(日付)) {
            return FlexibleDate.EMPTY;
        } else {
            return new FlexibleDate(日付);
        }

    }

    private RTime changeRStringToRTime(RString 日付) {
        if (RString.isNullOrEmpty(日付)) {
            return RTime.now();
        } else {
            return new RTime(日付);
        }

    }
}
