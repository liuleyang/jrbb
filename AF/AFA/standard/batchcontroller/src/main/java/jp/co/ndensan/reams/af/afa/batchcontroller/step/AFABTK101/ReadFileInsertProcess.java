/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import java.io.File;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.euc.afabtk101.MeiboSakuseiKaikuCsvEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.TempCsvMeiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class ReadFileInsertProcess extends BatchProcessBase<MeiboSakuseiKaikuCsvEntity> {

    private OutputParameter<RString> outTempCsvMeibo;
    private RString filePath;

    private AFABTK101SelectProcessParameter processParameter;

    private RString 海区_取込ファイル名;
    private RString 作成方法;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempCsvMeibo");
    }

    private static final RString TEMP_TABLE_NAME = new RString("TempCsvMeibo");

    @Override
    protected void initialize() {
        海区_取込ファイル名 = BusinessConfig.get(
                ConfigKeysAFA.海区_取込ファイル名, SubGyomuCode.AFA選挙本体);
        作成方法 = processParameter.get作成方法();

    }

    @Override
    protected void beforeExecute() {
        outTempCsvMeibo = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        filePath = Path.getTmpDirectoryPath().concat(File.separator).concat(海区_取込ファイル名);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, MeiboSakuseiKaikuCsvEntity.class)
                .setDelimiter(OutputKeys.コンマ.getValue())
                .setEnclosure(OutputKeys.斜線.getValue())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, TempCsvMeiboEntity.class);
    }

    @Override
    protected void process(MeiboSakuseiKaikuCsvEntity entity) {
        tempDbWriter.insert(create一時テーブル(entity));

    }

    private TempCsvMeiboEntity create一時テーブル(MeiboSakuseiKaikuCsvEntity entity) {
        TempCsvMeiboEntity csvEntity = new TempCsvMeiboEntity();
        if (MeiboKaikuEdited.ファイルを指定して作成する.getKey().equals(作成方法)) {
            csvEntity.setShikibetsuCode(new ShikibetsuCode(entity.get識別コード()));
            csvEntity.setTohyokuCode(entity.get投票区コード());
            csvEntity.setYubinNo(new YubinNo(entity.get郵便番号()));
            csvEntity.setJusho(new AtenaJusho(entity.get住所()));
            csvEntity.setKanaShimei(new AtenaKanaMeisho(entity.getカナ氏名()));
            csvEntity.setKanjiShimei(new AtenaMeisho(entity.get氏名()));
            csvEntity.setSeinengappiYMD(new FlexibleDate(entity.get生年月日()));
            csvEntity.setSeibetsuCode(entity.get性別());
            csvEntity.setGyogyoshaNo(entity.get漁業者番号());
            csvEntity.setKumiaiCode(entity.get組合コード());
            csvEntity.setNissuGyogyosha(entity.get漁業日数漁業者());
            csvEntity.setNissuJujisha(entity.get漁業日数漁業従事者());
            csvEntity.setGyogyoShurui(entity.get漁業種類());
            csvEntity.setGyosenShubetsu(entity.get使用漁船種別());
            csvEntity.setSenmei(entity.get船名());
            csvEntity.setTorokuNo(entity.get登録番号());
        }
        return csvEntity;
    }

    @Override
    protected void afterExecute() {
        outTempCsvMeibo.setValue(TEMP_TABLE_NAME);
    }

}
