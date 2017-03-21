/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.mochidashipcimportuketsukedata.enumeratedtype.MochidashiPcImportUketsukeDataRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.ShohonCsvEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.mochidashipcimportuketsukedata.ShohonCsvTempTableEntity;
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

/**
 * 当日受付データ取込バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0795-020 lis
 */
public class ANShohonReadFileInsertProcess extends BatchProcessBase<ShohonCsvEntity> {

    private OutputParameter<RString> outTempTableName;

    private AFABTE803SelectProcessParameter selectProcessParameter;

    private RString 抄本_取込ファイル名;
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
        抄本_取込ファイル名 = selectProcessParameter.get抄本ファイル名();
        RString tmpPath = Directory.createTmpDirectory();
        FilesystemName filesystemName = new FilesystemName(抄本_取込ファイル名);
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        ReadOnlySharedFileEntryDescriptor entitydesc
                = new ReadOnlySharedFileEntryDescriptor(GyomuCode.AF選挙, filesystemName, selectProcessParameter.get抄本ファイルId());
        tmpPath = new RString(SharedFile.copyToLocal(entitydesc, filesystemPath).toString());
        filePath = Path.combinePath(tmpPath, 抄本_取込ファイル名);
        count = 0;
    }

    @Override
    protected IBatchReader createReader() {
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, ShohonCsvEntity.class)
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
                MochidashiPcImportUketsukeDataRStringEnum.SHOHON_TEMP_TABLE_NAME.getKey(), ShohonCsvTempTableEntity.class);
    }

    @Override
    protected void process(ShohonCsvEntity entity) {
        count++;
        if (count != 1) {
            tempDbWriter.insert(create一時テーブル(entity));
        }
    }

    @Override
    protected void afterExecute() {
        outTempTableName.setValue(MochidashiPcImportUketsukeDataRStringEnum.SHOHON_TEMP_TABLE_NAME.getKey());
    }

    private ShohonCsvTempTableEntity create一時テーブル(ShohonCsvEntity entity) {
        ShohonCsvTempTableEntity csvEntity = new ShohonCsvTempTableEntity();
        if (RString.isNullOrEmpty(entity.get抄本番号())) {
            csvEntity.setShohonNo(new ShohonNo(0));
        } else {
            csvEntity.setShohonNo(new ShohonNo(entity.get抄本番号()));
        }

        csvEntity.setGroupCode(entity.getグループコード());
        csvEntity.setSenkyokuCode(entity.get選挙区コード());
        csvEntity.setTohyokuCode(entity.get投票区コード());
        csvEntity.setSatsu(entity.get冊());
        csvEntity.setPage(entity.get頁());
        csvEntity.setGyo(entity.get行());
        csvEntity.setShichosonCode(entity.get市町村コード());
        csvEntity.setYubinNo(entity.get郵便番号());
        csvEntity.setJushoCode(entity.get住所コード());
        csvEntity.setJusho(entity.get住所());
        csvEntity.setGyoseikuCode(entity.get行政区コード());
        csvEntity.setGyoseikuMei(entity.get行政区名());
        csvEntity.setChikuCode1(entity.get地区コード1());
        csvEntity.setChikuName1(entity.get地区名1());
        csvEntity.setChikuCode2(entity.get地区コード2());
        csvEntity.setChikuName2(entity.get地区名2());
        csvEntity.setChikuCode3(entity.get地区コード3());
        csvEntity.setChikuName3(entity.get地区名3());
        csvEntity.setBanchiCode1(entity.get番地コード1());
        csvEntity.setBanchiCode2(entity.get番地コード2());
        csvEntity.setBanchiCode3(entity.get番地コード3());
        csvEntity.setBanchi(entity.get番地());
        csvEntity.setGatagakiCode(entity.get方書コード());
        csvEntity.setGatagaki(entity.get方書());
        csvEntity.setTennyumaeYubinNo(entity.get転入前郵便番号());
        csvEntity.setTennyumaeZenkokuJushoCode(entity.get転入前全国住所コード());
        csvEntity.setTennyumaeJusho(entity.get転入前住所());
        csvEntity.setTennyumaeBanchi(entity.get転入前番地());
        csvEntity.setTennyumaeKatagaki(entity.get転入前方書());
        csvEntity.setTenshutsuSakiYubinNo(entity.get転出先郵便番号());
        csvEntity.setTenshutsuSakiZenkokuJushoCode(entity.get転出先全国住所コード());
        csvEntity.setTenshutsuSakiJusho(entity.get転出先住所());
        csvEntity.setTenshutsuSakiBanchi(entity.get転出先番地());
        csvEntity.setTenshutsuSakiKatagaki(entity.get転出先方書());
        csvEntity.setTenshutsuSakiSetainushimei(entity.get転出先世帯主名());
        csvEntity.setJuminCode(entity.get住民コード());
        csvEntity.setMeisho(entity.get漢字氏名());
        csvEntity.setKanaMeisho(entity.getカナ氏名());
        csvEntity.setKensakukanaSeimei(entity.get検索用カナ姓名());
        csvEntity.setKensakukanaSei(entity.get検索用カナ姓());
        csvEntity.setKensakukanamei(entity.get検索用カナ名());
        csvEntity.setMeishoTsushomei(entity.get漢字通称名());
        csvEntity.setKanaTsushomei(entity.getカナ通称名());
        csvEntity.setSetaiCode(entity.get世帯コード());
        csvEntity.setSetainuShimei(entity.get世帯主名());
        csvEntity.setKanaSetainuShimei(entity.getカナ世帯主名());
        csvEntity.setJuminShubetsuCode(entity.get住民種別());
        csvEntity.setSeinengappiYMD(changeRStringToFlexibleDate(entity.get生年月日()));
        csvEntity.setSeibetsu(entity.get性別コード());
        csvEntity.setTsuzukigaraCode(entity.get続柄コード());
        csvEntity.setTsuzukigara(entity.get続柄());
        csvEntity.setJukiHyojijun(entity.get住基表示順());
        csvEntity.setJukiTorokuYMD(changeRStringToFlexibleDate(entity.get住基登録年月日()));
        csvEntity.setJukiShojoYMD(changeRStringToFlexibleDate(entity.get住基消除年月日()));
        csvEntity.setTennyuTodokedeYMD(changeRStringToFlexibleDate(entity.get転入届出年月日()));
        csvEntity.setTennyuIdoYMD(changeRStringToFlexibleDate(entity.get転入異動年月日()));
        csvEntity.setTennyuKubun(entity.get転入区分());
        csvEntity.setTenshutsuTodokedeYMD(changeRStringToFlexibleDate(entity.get転出届出年月日()));
        csvEntity.setTenshutsuIdoYMD(changeRStringToFlexibleDate(entity.get転出異動年月日()));
        csvEntity.setTenshutsuKubun(entity.get転出区分());
        csvEntity.setSenkyoShikakuKubun(entity.get選挙資格区分());
        csvEntity.setSenkyoTorokuYMD(changeRStringToFlexibleDate(entity.get選挙登録年月日()));
        csvEntity.setSenkyoTorokuJiyuCode(entity.get選挙登録理由コード());
        csvEntity.setHyojiYMD(changeRStringToFlexibleDate(entity.get表示年月日()));
        csvEntity.setHyojiJiyuCode(entity.get表示理由コード());
        csvEntity.setMasshoYMD(changeRStringToFlexibleDate(entity.get抹消年月日()));
        csvEntity.setMasshoJiyuCode(entity.get抹消理由コード());
        csvEntity.setTenshutsuHyojiKubun(entity.get転出表示区分());
        csvEntity.setCikkenKubun(entity.get失権区分());
        csvEntity.setKyojyuKubun(entity.get居住区分());
        csvEntity.setFuzaishaKijitsuzen1(entity.get不在者期日前１());
        csvEntity.setFuzaishaKijitsuzen2(entity.get不在者期日前２());
        csvEntity.setFuzaishaKijitsuzen3(entity.get不在者期日前３());
        csvEntity.setFuzaishaKijitsuzen4(entity.get不在者期日前４());
        csvEntity.setFuzaishaKijitsuzen5(entity.get不在者期日前５());
        csvEntity.setFuzaishaKijitsuzen6(entity.get不在者期日前６());
        csvEntity.setFuzaishaKijitsuzen7(entity.get不在者期日前７());
        csvEntity.setFuzaishaKijitsuzen8(entity.get不在者期日前８());
        csvEntity.setFuzaishaKijitsuzen9(entity.get不在者期日前９());
        csvEntity.setTohyoJyokyo1(entity.get投票状況１());
        csvEntity.setTohyoJyokyo2(entity.get投票状況２());
        csvEntity.setTohyoJyokyo3(entity.get投票状況３());
        csvEntity.setTohyoJyokyo4(entity.get投票状況４());
        csvEntity.setTohyoJyokyo5(entity.get投票状況５());
        csvEntity.setTohyoJyokyo6(entity.get投票状況６());
        csvEntity.setTohyoJyokyo7(entity.get投票状況７());
        csvEntity.setTohyoJyokyo8(entity.get投票状況８());
        csvEntity.setTohyoJyokyo9(entity.get投票状況９());
        csvEntity.setKoufuShisetsuCode1(entity.get交付施設コード１());
        csvEntity.setKoufuShisetsuCode2(entity.get交付施設コード２());
        csvEntity.setKoufuShisetsuCode3(entity.get交付施設コード３());
        csvEntity.setKoufuShisetsuCode4(entity.get交付施設コード４());
        csvEntity.setKoufuShisetsuCode5(entity.get交付施設コード５());
        csvEntity.setKoufuShisetsuCode6(entity.get交付施設コード６());
        csvEntity.setKoufuShisetsuCode7(entity.get交付施設コード７());
        csvEntity.setKoufuShisetsuCode8(entity.get交付施設コード８());
        csvEntity.setKoufuShisetsuCode9(entity.get交付施設コード９());
        csvEntity.setYoujyoTohyoshaKubun(entity.get洋上投票者区分());
        csvEntity.setKosakuMensaki(entity.get耕作面積());
        csvEntity.setHoujinmei(entity.get法人名());
        csvEntity.setKumiaiCode(entity.get組合コード());
        csvEntity.setKumiaimei(entity.get組合名());
        csvEntity.setTaihyoshaKubun(entity.get代表者区分());
        csvEntity.setJuujiNissu(entity.get従事日数());
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
        if (RString.isNullOrEmpty(日付) || !isDate(日付)) {
            return FlexibleDate.EMPTY;
        } else {
            return new FlexibleDate(日付);
        }

    }

    private boolean isDate(RString date) {
        return FlexibleDate.canConvert(date);
    }
}
