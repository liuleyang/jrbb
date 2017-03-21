/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku.SeikyushaTorokuJoho;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.Aft403ShomeiboResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.KensuJushoCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.KensuTohyokuCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.MukoJushoCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.MukoTohyokuCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.NendaiCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.NenreiCsvResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.NenreiNendaiResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.ShomeiboResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_100;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_3;
import jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.CSV_DELIMITER;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.FORMATDIVIDE;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.審査区分_0;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.審査区分_1;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.審査区分_2;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.有効;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.横線;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_01;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_02;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_03;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_04;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_05;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_06;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_07;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_08;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_09;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_10;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_11;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_12;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_13;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_14;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_15;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_16;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_17;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.無効事由_18;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.百分符;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.署名なし;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShomeishaIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiKensuJusho_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiKensuTohyoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiMukoJusho_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiMukoTohyoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiNendai_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShukeiNenrei_Row;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * AFABTG106BatchParameter
 *
 * @reamsid_L AF-0150-010 wangh
 */
public final class SeikyuShomeiboTorokuHandler {

    private final SeikyuShomeiboTorokuDiv div;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;

    /**
     * コンストラクタです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     */
    public SeikyuShomeiboTorokuHandler(SeikyuShomeiboTorokuDiv div) {
        this.div = div;
    }

    /**
     * 署名者一覧を設定処理。
     *
     * @param 署名者情報 List<Aft403ShomeiboResult>
     * @param 請求名 RString
     */
    public void set署名者一覧と請求名(List<Aft403ShomeiboResult> 署名者情報, RString 請求名) {
        div.getTxtSeikyuName().setValue(請求名);
        div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource().clear();
        List<dgSeikyuShomeiboShomeishaIchiran_Row> rows = new ArrayList<>();
        List<ShikibetsuCode> 識別コードlist = new ArrayList<>();
        if (null != 署名者情報 && !署名者情報.isEmpty()) {
            for (Aft403ShomeiboResult result : 署名者情報) {
                dgSeikyuShomeiboShomeishaIchiran_Row row = new dgSeikyuShomeiboShomeishaIchiran_Row();
                row.getTxtDaihitsushaJusho().setValue(result.getDaihitsushaJusho());
                row.getTxtDaihitsushaSeinengappiYMD().setValue(result.getDaihitsushaSeinengappiYMD());
                row.setTxtDaihitsushaShikibetsuCode(result.getDaihitsushaShikibetsuCode().getColumnValue());
                row.getTxtDaihitsushaShimei().setValue(result.getDaihitsushaKanjiShimei());

                row.getDdlDaihitsushaSeibetsu().setDataSource(get性別ドロップダウン());
                row.getDdlDaihitsushaSeibetsu().setSelectedKey(null == result.getDaihitsushaSeibetsuCode()
                        ? RString.EMPTY : result.getDaihitsushaSeibetsuCode());
                row.getTxtJusho().setValue(result.getJusho());
                row.getTxtKanaShimei().setValue(result.getKanaShimei());
                row.getTxtMukoJiyu().setDataSource(get無効事由ドロップダウン());
                row.getTxtMukoJiyu().setSelectedKey(result.getMukoJiyuCode().getColumnValue());
                row.setMukoJiyuselectedkey(result.getMukoJiyuCode().getColumnValue());
                row.getTxtSeibetsu().setDataSource(get性別ドロップダウン());
                row.getTxtSeibetsu().setSelectedKey(null == result.getSeibetsuCode()
                        ? RString.EMPTY : result.getSeibetsuCode());
                row.getTxtSeinengappiYMD().setValue(result.getSeinengappiYMD());
                row.setTxtSenkyoShikaku(edit選挙資格(result.get選挙資格区分()));
                row.setTxtShikibetsuCode(result.getShomeishaShikibetsuCode().getColumnValue());
                識別コードlist.add(result.getShomeishaShikibetsuCode());
                row.getTxtShimei().setValue(result.getKanjiShimei());
                row.getTxtShomeiYMD().setValue(result.getShomeiYMD());
                row.getDdlShomeiJokyo().setDataSource(get署名状況ドロップダウン());
                row.getDdlShomeiJokyo().setSelectedKey(null == result.getShinsaKubun() || result.getShinsaKubun().isEmpty()
                        ? 審査区分_0.getKey() : result.getShinsaKubun().getColumnValue());
                row.getTxtShimei().setDisabled(true);
                row.getTxtKanaShimei().setDisabled(true);
                row.getTxtSeinengappiYMD().setDisabled(true);
                row.getTxtSeibetsu().setDisabled(true);
                row.getTxtJusho().setDisabled(true);
                row.getTxtMukoJiyu().setDisabled(!row.getDdlShomeiJokyo().getSelectedKey().equals(審査区分_2.getKey()));
                rows.add(row);
            }
            out初期化アクセスログ出力(識別コードlist);
            div.getDgSeikyuShomeiboShomeishaIchiran().setDataSource(rows);
        }

    }

    /**
     * 署名件数表（投票区別）タグを設定処理。
     *
     * @param 署名件数表_投票区別データ List<ShomeiboResult>
     */
    public void set署名件数表_投票区別タグ(List<ShomeiboResult> 署名件数表_投票区別データ) {
        List<dgSeikyuShomeiboShukeiKensuTohyoku_Row> rows = new ArrayList();
        if (null != 署名件数表_投票区別データ && !署名件数表_投票区別データ.isEmpty()) {
            for (ShomeiboResult result : 署名件数表_投票区別データ) {
                dgSeikyuShomeiboShukeiKensuTohyoku_Row row = new dgSeikyuShomeiboShukeiKensuTohyoku_Row();
                row.setTxtTohyokuCode(result.get投票区コード());
                row.setTxtTohyojoName(result.get投票所名());
                row.getTxtYukenshasuMan().setValue(new Decimal(result.getYukenshasuMan()));
                row.getTxtYukenshasuWoman().setValue(new Decimal(result.getYukenshasuWoman()));
                row.getTxtYukenshasuTotal().setValue(new Decimal(result.get有権者計()));

                row.getTxtYukosuMan().setValue(new Decimal(result.getYukosuMan()));
                row.getTxtYukosuWoman().setValue(new Decimal(result.getYukosuWoman()));
                row.getTxtYukosuTotal().setValue(new Decimal(result.get署名有効計()));

                row.getTxtMukosuMan().setValue(new Decimal(result.getMukosuMan()));
                row.getTxtMukosuWoman().setValue(new Decimal(result.getMukosuWoman()));
                row.getTxtMukosuTotal().setValue(new Decimal(result.get署名無効計()));

                row.getTxtShomeisuMan().setValue(new Decimal(result.get署名合計_男()));
                row.getTxtShomeisuWoman().setValue(new Decimal(result.get署名合計_女()));
                row.getTxtShomeisuTotal().setValue(new Decimal(result.get署名合計()));
                rows.add(row);
            }
        }
        div.getDgSeikyuShomeiboShukeiKensuTohyoku().setDataSource(rows);
    }

    /**
     * 署名件数表（住所別）タグを設定処理。
     *
     * @param 署名件数表_住所別データ List<ShomeiboResult>
     */
    public void set署名件数表_住所別タグ(List<ShomeiboResult> 署名件数表_住所別データ) {
        List<dgSeikyuShomeiboShukeiKensuJusho_Row> rows = new ArrayList();
        if (null != 署名件数表_住所別データ && !署名件数表_住所別データ.isEmpty()) {
            for (ShomeiboResult result : 署名件数表_住所別データ) {
                dgSeikyuShomeiboShukeiKensuJusho_Row row = new dgSeikyuShomeiboShukeiKensuJusho_Row();
                row.setTxtJushoCode(result.get住登内町域コード());
                row.setTxtJushoName(result.get住登内住所());
                row.getTxtYukenshasuMan().setValue(new Decimal(result.getYukenshasuMan()));
                row.getTxtYukenshasuWoman().setValue(new Decimal(result.getYukenshasuWoman()));
                row.getTxtYukenshasuTotal().setValue(new Decimal(result.get有権者計()));

                row.getTxtYukosuMan().setValue(new Decimal(result.getYukosuMan()));
                row.getTxtYukosuWoman().setValue(new Decimal(result.getYukosuWoman()));
                row.getTxtYukosuTotal().setValue(new Decimal(result.get署名有効計()));

                row.getTxtMukosuMan().setValue(new Decimal(result.getMukosuMan()));
                row.getTxtMukosuWoman().setValue(new Decimal(result.getMukosuWoman()));
                row.getTxtMukosuTotal().setValue(new Decimal(result.get署名無効計()));

                row.getTxtShomeisuMan().setValue(new Decimal(result.get署名合計_男()));
                row.getTxtShomeisuWoman().setValue(new Decimal(result.get署名合計_女()));
                row.getTxtShomeisuTotal().setValue(new Decimal(result.get署名合計()));
                rows.add(row);
            }
        }
        div.getDgSeikyuShomeiboShukeiKensuJusho().setDataSource(rows);
    }

    /**
     * 無効件数無効事由内訳表（投票区別）タグを設定処理。
     *
     * @param 無効件数無効事由内訳表_投票区別データ List<ShomeiboResult>
     */
    public void set無効件数無効事由内訳表_投票区別タグ(List<ShomeiboResult> 無効件数無効事由内訳表_投票区別データ) {
        List<dgSeikyuShomeiboShukeiMukoTohyoku_Row> rows = new ArrayList();
        if (null != 無効件数無効事由内訳表_投票区別データ && !無効件数無効事由内訳表_投票区別データ.isEmpty()) {
            for (ShomeiboResult result : 無効件数無効事由内訳表_投票区別データ) {
                dgSeikyuShomeiboShukeiMukoTohyoku_Row row = new dgSeikyuShomeiboShukeiMukoTohyoku_Row();
                row.setTxtTohyokuCode(result.get投票区コード());
                row.setTxtTohyojoName(result.get投票所名());
                row.getTxtMukoJiyu01().setValue(new Decimal(result.getMukoJiyu01_名簿未登録()));
                row.getTxtMukoJiyu02().setValue(new Decimal(result.getMukoJiyu02_管外居住()));
                row.getTxtMukoJiyu03().setValue(new Decimal(result.getMukoJiyu03_署名日未記載()));
                row.getTxtMukoJiyu04().setValue(new Decimal(result.getMukoJiyu04_住所未記載()));
                row.getTxtMukoJiyu05().setValue(new Decimal(result.getMukoJiyu05_生年月日未記載()));
                row.getTxtMukoJiyu06().setValue(new Decimal(result.getMukoJiyu06_無捺印()));
                row.getTxtMukoJiyu07().setValue(new Decimal(result.getMukoJiyu07_自書と認めず()));
                row.getTxtMukoJiyu08().setValue(new Decimal(result.getMukoJiyu08_同一筆跡代筆()));
                row.getTxtMukoJiyu09().setValue(new Decimal(result.getMukoJiyu09_重複署名()));
                row.getTxtMukoJiyu10().setValue(new Decimal(result.getMukoJiyu10_何人か未確認()));
                row.getTxtMukoJiyu11().setValue(new Decimal(result.getMukoJiyu11_期間外署名()));
                row.getTxtMukoJiyu12().setValue(new Decimal(result.getMukoJiyu12_委任日前()));
                row.getTxtMukoJiyu13().setValue(new Decimal(result.getMukoJiyu13_無契印()));
                row.getTxtMukoJiyu14().setValue(new Decimal(result.getMukoJiyu14_欄外署名()));
                row.getTxtMukoJiyu15().setValue(new Decimal(result.getMukoJiyu15_委任状瑕疵()));
                row.getTxtMukoJiyu16().setValue(new Decimal(result.getMukoJiyu16_受任者未登録()));
                row.getTxtMukoJiyu17().setValue(new Decimal(result.getMukoJiyu17_委任届なし()));
                row.getTxtMukoJiyu18().setValue(new Decimal(result.getMukoJiyu18_その他()));
                rows.add(row);
            }
        }
        div.getDgSeikyuShomeiboShukeiMukoTohyoku().setDataSource(rows);
    }

    /**
     * 無効件数無効事由内訳表（住所別）タグを設定処理。
     *
     * @param 無効件数無効事由内訳表_住所別データ List<ShomeiboResult>
     */
    public void set無効件数無効事由内訳表_住所別タグ(List<ShomeiboResult> 無効件数無効事由内訳表_住所別データ) {
        List<dgSeikyuShomeiboShukeiMukoJusho_Row> rows = new ArrayList();
        if (null != 無効件数無効事由内訳表_住所別データ && !無効件数無効事由内訳表_住所別データ.isEmpty()) {
            for (ShomeiboResult result : 無効件数無効事由内訳表_住所別データ) {
                dgSeikyuShomeiboShukeiMukoJusho_Row row = new dgSeikyuShomeiboShukeiMukoJusho_Row();
                row.setTxtJushoCode(result.get住登内町域コード());
                row.setTxtJushoName(result.get住登内住所());
                row.getTxtMukoJiyu01().setValue(new Decimal(result.getMukoJiyu01_名簿未登録()));
                row.getTxtMukoJiyu02().setValue(new Decimal(result.getMukoJiyu02_管外居住()));
                row.getTxtMukoJiyu03().setValue(new Decimal(result.getMukoJiyu03_署名日未記載()));
                row.getTxtMukoJiyu04().setValue(new Decimal(result.getMukoJiyu04_住所未記載()));
                row.getTxtMukoJiyu05().setValue(new Decimal(result.getMukoJiyu05_生年月日未記載()));
                row.getTxtMukoJiyu06().setValue(new Decimal(result.getMukoJiyu06_無捺印()));
                row.getTxtMukoJiyu07().setValue(new Decimal(result.getMukoJiyu07_自書と認めず()));
                row.getTxtMukoJiyu08().setValue(new Decimal(result.getMukoJiyu08_同一筆跡代筆()));
                row.getTxtMukoJiyu09().setValue(new Decimal(result.getMukoJiyu09_重複署名()));
                row.getTxtMukoJiyu10().setValue(new Decimal(result.getMukoJiyu10_何人か未確認()));
                row.getTxtMukoJiyu11().setValue(new Decimal(result.getMukoJiyu11_期間外署名()));
                row.getTxtMukoJiyu12().setValue(new Decimal(result.getMukoJiyu12_委任日前()));
                row.getTxtMukoJiyu13().setValue(new Decimal(result.getMukoJiyu13_無契印()));
                row.getTxtMukoJiyu14().setValue(new Decimal(result.getMukoJiyu14_欄外署名()));
                row.getTxtMukoJiyu15().setValue(new Decimal(result.getMukoJiyu15_委任状瑕疵()));
                row.getTxtMukoJiyu16().setValue(new Decimal(result.getMukoJiyu16_受任者未登録()));
                row.getTxtMukoJiyu17().setValue(new Decimal(result.getMukoJiyu17_委任届なし()));
                row.getTxtMukoJiyu18().setValue(new Decimal(result.getMukoJiyu18_その他()));
                rows.add(row);
            }
        }
        div.getDgSeikyuShomeiboShukeiMukoJusho().setDataSource(rows);
    }

    /**
     * 年齢別投票率集計表タグを設定処理。
     *
     * @param 年齢別データ_不明者 List<ShomeiboResult>
     * @param 署名者名簿データの件数 int
     */
    public void set年齢別投票率集計表タグ_不明者(List<ShomeiboResult> 年齢別データ_不明者, int 署名者名簿データの件数) {
        Map<RString, NenreiNendaiResult> 投票区投票所年齢別result = new HashMap<>();
        if (null == 年齢別データ_不明者 || 年齢別データ_不明者.isEmpty()) {
            return;
        }
        List<dgSeikyuShomeiboShukeiNenrei_Row> rows;
        List<dgSeikyuShomeiboShukeiNenrei_Row> rows1 = new ArrayList();
        for (ShomeiboResult result : 年齢別データ_不明者) {
            RString key = result.get年齢();
            if (投票区投票所年齢別result.containsKey(key)) {
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result.get(key).setYukosuMan(投票区投票所年齢別result.get(key).getYukosuMan() + 1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result.get(key).setYukosuWoman(投票区投票所年齢別result.get(key).getYukosuWoman() + 1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result.get(key).setMukosuMan(投票区投票所年齢別result.get(key).getMukosuMan() + 1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result.get(key).setMukosuWoman(投票区投票所年齢別result.get(key).getMukosuWoman() + 1);
                }
                投票区投票所年齢別result.get(key).set署名有効計(投票区投票所年齢別result.get(key).getYukosuMan()
                        + 投票区投票所年齢別result.get(key).getYukosuWoman());
                投票区投票所年齢別result.get(key).set署名無効計(投票区投票所年齢別result.get(key).getMukosuMan()
                        + 投票区投票所年齢別result.get(key).getMukosuWoman());
            } else {
                NenreiNendaiResult 出力対象 = new NenreiNendaiResult();
                出力対象.setKey(key);
                出力対象.setTohyokuCode(RString.EMPTY);
                出力対象.setTohyojoCode(RString.EMPTY);
                出力対象.setTohyojoName(result.get投票所名());
                出力対象.setNenrei(result.get年齢());
                出力対象.setYukenshasuMan(0);
                出力対象.setYukenshasuWoman(0);
                出力対象.setYukosuMan(0);
                出力対象.setYukosuWoman(0);
                出力対象.setMukosuMan(0);
                出力対象.setMukosuWoman(0);
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuMan(1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuWoman(1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuMan(1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuWoman(1);
                }
                出力対象.set有権者計(0);
                出力対象.set署名有効計(出力対象.getYukosuMan()
                        + 出力対象.getYukosuWoman());
                出力対象.set署名無効計(出力対象.getMukosuMan()
                        + 出力対象.getMukosuWoman());
                投票区投票所年齢別result.put(key, 出力対象);
            }
        }
        rows = createdatasource年齢別(rows1, 投票区投票所年齢別result.values(), 署名者名簿データの件数);
        div.getDgSeikyuShomeiboShukeiNenrei().setDataSource(rows);
    }

    /**
     * 年齢別投票率集計表タグを設定処理。
     *
     * @param 年齢別データ List<ShomeiboResult>
     * @param 署名者名簿データの件数 int
     */
    public void set年齢別投票率集計表タグ(List<ShomeiboResult> 年齢別データ, int 署名者名簿データの件数) {
        if (null == 年齢別データ || 年齢別データ.isEmpty()) {
            return;
        }
        List<dgSeikyuShomeiboShukeiNenrei_Row> rows;
        Map<RString, NenreiNendaiResult> 投票区投票所年齢別result2 = new HashMap<>();
        List<dgSeikyuShomeiboShukeiNenrei_Row> rows2 = div.getDgSeikyuShomeiboShukeiNenrei().getDataSource();
        for (ShomeiboResult result : 年齢別データ) {
            RString key = result.get投票区投票所年齢key();
            if (投票区投票所年齢別result2.containsKey(key)) {
                if (is男有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    投票区投票所年齢別result2.get(key).setYukenshasuMan(投票区投票所年齢別result2.get(key).getYukenshasuMan() + 1);
                } else if (is女有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    投票区投票所年齢別result2.get(key).setYukenshasuWoman(投票区投票所年齢別result2.get(key).getYukenshasuWoman() + 1);
                }
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result2.get(key).setYukosuMan(投票区投票所年齢別result2.get(key).getYukosuMan() + 1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result2.get(key).setYukosuWoman(投票区投票所年齢別result2.get(key).getYukosuWoman() + 1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result2.get(key).setMukosuMan(投票区投票所年齢別result2.get(key).getMukosuMan() + 1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年齢別result2.get(key).setMukosuWoman(投票区投票所年齢別result2.get(key).getMukosuWoman() + 1);
                }
                投票区投票所年齢別result2.get(key).set有権者計(投票区投票所年齢別result2.get(key).getYukenshasuMan()
                        + 投票区投票所年齢別result2.get(key).getYukenshasuWoman());
                投票区投票所年齢別result2.get(key).set署名有効計(投票区投票所年齢別result2.get(key).getYukosuMan()
                        + 投票区投票所年齢別result2.get(key).getYukosuWoman());
                投票区投票所年齢別result2.get(key).set署名無効計(投票区投票所年齢別result2.get(key).getMukosuMan()
                        + 投票区投票所年齢別result2.get(key).getMukosuWoman());
            } else {
                NenreiNendaiResult 出力対象 = new NenreiNendaiResult();
                出力対象.setKey(key);
                出力対象.setTohyokuCode(key.split(横線.getKey().toString()).get(0));
                出力対象.setTohyojoCode(key.split(横線.getKey().toString()).get(1));
                出力対象.setTohyojoName(result.get投票所名());
                出力対象.setNenrei(key.split(横線.getKey().toString()).get(2));
                出力対象.setYukenshasuMan(0);
                出力対象.setYukenshasuWoman(0);
                出力対象.setYukosuMan(0);
                出力対象.setYukosuWoman(0);
                出力対象.setMukosuMan(0);
                出力対象.setMukosuWoman(0);
                if (is男有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    出力対象.setYukenshasuMan(1);
                } else if (is女有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    出力対象.setYukenshasuWoman(1);
                }
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuMan(1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuWoman(1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuMan(1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuWoman(1);
                }
                出力対象.set有権者計(出力対象.getYukenshasuMan()
                        + 出力対象.getYukenshasuWoman());
                出力対象.set署名有効計(出力対象.getYukosuMan()
                        + 出力対象.getYukosuWoman());
                出力対象.set署名無効計(出力対象.getMukosuMan()
                        + 出力対象.getMukosuWoman());
                投票区投票所年齢別result2.put(key, 出力対象);
            }
        }
        rows = createdatasource年齢別(rows2, 投票区投票所年齢別result2.values(), 署名者名簿データの件数);
        div.getDgSeikyuShomeiboShukeiNenrei().setDataSource(rows);
    }

    private List<dgSeikyuShomeiboShukeiNenrei_Row> createdatasource年齢別(List<dgSeikyuShomeiboShukeiNenrei_Row> rows,
            Collection<NenreiNendaiResult> 投票区投票所年齢別result, int 署名者名簿データの件数) {
        for (NenreiNendaiResult result1 : 投票区投票所年齢別result) {
            dgSeikyuShomeiboShukeiNenrei_Row row = new dgSeikyuShomeiboShukeiNenrei_Row();
            row.setTxtTohyokuCode(result1.get投票区コード());
            row.setTxtTohyojoName(result1.get投票所名());
            row.getTxtNenrei().setValue(result1.getNenrei());
            row.getTxtYukenshasuMan().setValue(new Decimal(result1.getYukenshasuMan()));
            row.getTxtYukenshasuWoman().setValue(new Decimal(result1.getYukenshasuWoman()));
            row.getTxtYukenshasuTotal().setValue(new Decimal(result1.get有権者計()));

            row.getTxtYukosuMan().setValue(new Decimal(result1.getYukosuMan()));
            row.getTxtYukosuWoman().setValue(new Decimal(result1.getYukosuWoman()));
            row.getTxtYukosuTotal().setValue(new Decimal(result1.get署名有効計()));

            row.getTxtMukosuMan().setValue(new Decimal(result1.getMukosuMan()));
            row.getTxtMukosuWoman().setValue(new Decimal(result1.getMukosuWoman()));
            row.getTxtMukosuTotal().setValue(new Decimal(result1.get署名無効計()));

            row.getTxtTohyoritsuMan().setValue(format小数点(result1.getYukosuMan()
                    + result1.getMukosuMan(), 署名者名簿データの件数
            ));
            row.getTxtTohyoritsuWoman().setValue(format小数点(result1.getYukosuWoman()
                    + result1.getMukosuWoman(), 署名者名簿データの件数
            ));
            row.getTxtTohyoritsuTotal().setValue(format小数点(result1.get署名有効計()
                    + result1.get署名無効計(), 署名者名簿データの件数
            ));
            rows.add(row);
        }
        return rows;
    }

    /**
     * 年代別投票率集計表タグを設定処理。
     *
     * @param 年代別データ_不明者 List<ShomeiboResult>
     * @param 署名者名簿データの件数 int
     */
    public void set年代別投票率集計表タグ_不明者(List<ShomeiboResult> 年代別データ_不明者, int 署名者名簿データの件数) {
        Map<RString, NenreiNendaiResult> 投票区投票所年代別result = new HashMap<>();
        if (null == 年代別データ_不明者 || 年代別データ_不明者.isEmpty()) {
            return;
        }
        List<dgSeikyuShomeiboShukeiNendai_Row> rows;
        List<dgSeikyuShomeiboShukeiNendai_Row> rows1 = new ArrayList();
        for (ShomeiboResult result : 年代別データ_不明者) {
            RString key = result.get年代();
            if (投票区投票所年代別result.containsKey(key)) {
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setYukosuMan(投票区投票所年代別result.get(key).getYukosuMan() + 1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setYukosuWoman(投票区投票所年代別result.get(key).getYukosuWoman() + 1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setMukosuMan(投票区投票所年代別result.get(key).getMukosuMan() + 1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setMukosuWoman(投票区投票所年代別result.get(key).getMukosuWoman() + 1);
                }
                投票区投票所年代別result.get(key).set署名有効計(投票区投票所年代別result.get(key).getYukosuMan()
                        + 投票区投票所年代別result.get(key).getYukosuWoman());
                投票区投票所年代別result.get(key).set署名無効計(投票区投票所年代別result.get(key).getMukosuMan()
                        + 投票区投票所年代別result.get(key).getMukosuWoman());
            } else {
                NenreiNendaiResult 出力対象 = new NenreiNendaiResult();
                出力対象.setKey(key);
                出力対象.setTohyokuCode(RString.EMPTY);
                出力対象.setTohyojoCode(RString.EMPTY);
                出力対象.setTohyojoName(result.get投票所名());
                出力対象.setNendai(result.get年代());
                出力対象.setYukenshasuMan(0);
                出力対象.setYukenshasuWoman(0);
                出力対象.setYukosuMan(0);
                出力対象.setYukosuWoman(0);
                出力対象.setMukosuMan(0);
                出力対象.setMukosuWoman(0);
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuMan(1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuWoman(1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuMan(1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuWoman(1);
                }
                出力対象.set有権者計(0);
                出力対象.set署名有効計(出力対象.getYukosuMan()
                        + 出力対象.getYukosuWoman());
                出力対象.set署名無効計(出力対象.getMukosuMan()
                        + 出力対象.getMukosuWoman());
                投票区投票所年代別result.put(key, 出力対象);
            }
        }
        rows = createdatasource年代別(rows1, 投票区投票所年代別result.values(), 署名者名簿データの件数);
        div.getDgSeikyuShomeiboShukeiNendai().setDataSource(rows);
    }

    /**
     * 年代別投票率集計表タグを設定処理。
     *
     * @param 年代別データ List<ShomeiboResult>
     * @param 署名者名簿データの件数 int
     */
    public void set年代別投票率集計表タグ(List<ShomeiboResult> 年代別データ, int 署名者名簿データの件数) {
        Map<RString, NenreiNendaiResult> 投票区投票所年代別result = new HashMap<>();
        if (null == 年代別データ || 年代別データ.isEmpty()) {
            return;
        }
        List<dgSeikyuShomeiboShukeiNendai_Row> rows;
        List<dgSeikyuShomeiboShukeiNendai_Row> rows2 = div.getDgSeikyuShomeiboShukeiNendai().getDataSource();
        for (ShomeiboResult result : 年代別データ) {
            RString key = result.get投票区投票所年代key();
            if (投票区投票所年代別result.containsKey(key)) {
                if (is男有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    投票区投票所年代別result.get(key).setYukenshasuMan(投票区投票所年代別result.get(key).getYukenshasuMan() + 1);
                } else if (is女有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    投票区投票所年代別result.get(key).setYukenshasuWoman(投票区投票所年代別result.get(key).getYukenshasuWoman() + 1);
                }
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setYukosuMan(投票区投票所年代別result.get(key).getYukosuMan() + 1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setYukosuWoman(投票区投票所年代別result.get(key).getYukosuWoman() + 1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setMukosuMan(投票区投票所年代別result.get(key).getMukosuMan() + 1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    投票区投票所年代別result.get(key).setMukosuWoman(投票区投票所年代別result.get(key).getMukosuWoman() + 1);
                }
                投票区投票所年代別result.get(key).set有権者計(投票区投票所年代別result.get(key).getYukenshasuMan()
                        + 投票区投票所年代別result.get(key).getYukenshasuWoman());
                投票区投票所年代別result.get(key).set署名有効計(投票区投票所年代別result.get(key).getYukosuMan()
                        + 投票区投票所年代別result.get(key).getYukosuWoman());
                投票区投票所年代別result.get(key).set署名無効計(投票区投票所年代別result.get(key).getMukosuMan()
                        + 投票区投票所年代別result.get(key).getMukosuWoman());
            } else {
                NenreiNendaiResult 出力対象 = new NenreiNendaiResult();
                出力対象.setKey(key);
                出力対象.setTohyokuCode(key.split(横線.getKey().toString()).get(0));
                出力対象.setTohyojoCode(key.split(横線.getKey().toString()).get(1));
                出力対象.setTohyojoName(result.get投票所名());
                出力対象.setNendai(key.split(横線.getKey().toString()).get(2));
                出力対象.setYukenshasuMan(0);
                出力対象.setYukenshasuWoman(0);
                出力対象.setYukosuMan(0);
                出力対象.setYukosuWoman(0);
                出力対象.setMukosuMan(0);
                出力対象.setMukosuWoman(0);
                if (is男有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    出力対象.setYukenshasuMan(1);
                } else if (is女有権者(result.getSeibetsuCode(), result.get選挙資格区分())) {
                    出力対象.setYukenshasuWoman(1);
                }
                if (is男署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuMan(1);
                } else if (is女署名有効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setYukosuWoman(1);
                } else if (is男署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuMan(1);
                } else if (is女署名無効(result.getSeibetsuCode(), result.getShinsaKubun())) {
                    出力対象.setMukosuWoman(1);
                }
                出力対象.set有権者計(出力対象.getYukenshasuMan()
                        + 出力対象.getYukenshasuWoman());
                出力対象.set署名有効計(出力対象.getYukosuMan()
                        + 出力対象.getYukosuWoman());
                出力対象.set署名無効計(出力対象.getMukosuMan()
                        + 出力対象.getMukosuWoman());
                投票区投票所年代別result.put(key, 出力対象);
            }
        }
        rows = createdatasource年代別(rows2, 投票区投票所年代別result.values(), 署名者名簿データの件数);
        div.getDgSeikyuShomeiboShukeiNendai().setDataSource(rows);
    }

    private List<dgSeikyuShomeiboShukeiNendai_Row> createdatasource年代別(List<dgSeikyuShomeiboShukeiNendai_Row> rows,
            Collection<NenreiNendaiResult> 投票区投票所年代別result, int 署名者名簿データの件数) {
        for (NenreiNendaiResult result1 : 投票区投票所年代別result) {
            dgSeikyuShomeiboShukeiNendai_Row row = new dgSeikyuShomeiboShukeiNendai_Row();
            row.setTxtTohyokuCode(result1.get投票区コード());
            row.setTxtTohyojoName(result1.get投票所名());
            row.getTxtNendai().setValue(result1.getNendai());
            row.getTxtYukenshasuMan().setValue(new Decimal(result1.getYukenshasuMan()));
            row.getTxtYukenshasuWoman().setValue(new Decimal(result1.getYukenshasuWoman()));
            row.getTxtYukenshasuTotal().setValue(new Decimal(result1.get有権者計()));

            row.getTxtYukosuMan().setValue(new Decimal(result1.getYukosuMan()));
            row.getTxtYukosuWoman().setValue(new Decimal(result1.getYukosuWoman()));
            row.getTxtYukosuTotal().setValue(new Decimal(result1.get署名有効計()));

            row.getTxtMukosuMan().setValue(new Decimal(result1.getMukosuMan()));
            row.getTxtMukosuWoman().setValue(new Decimal(result1.getMukosuWoman()));
            row.getTxtMukosuTotal().setValue(new Decimal(result1.get署名無効計()));

            row.getTxtTohyoritsuMan().setValue(format小数点(result1.getYukosuMan()
                    + result1.getMukosuMan(), 署名者名簿データの件数
            ));
            row.getTxtTohyoritsuWoman().setValue(format小数点(result1.getYukosuWoman()
                    + result1.getMukosuWoman(), 署名者名簿データの件数
            ));
            row.getTxtTohyoritsuTotal().setValue(format小数点(result1.get署名有効計()
                    + result1.get署名無効計(), 署名者名簿データの件数));
            rows.add(row);
        }
        return rows;
    }

    /**
     * タグ出力順を設定処理。
     *
     */
    public void setタグ出力順() {
        div.getTabSeikyuShomeiboShukei().setSelectedItem(div.getTplSeikyuShomeiboShukeiKensuTohyoku());
        List<RString> list = new ArrayList<>();
        list.add(div.getTplSeikyuShomeiboShukeiKensuTohyoku().getSelectControlID());
        list.add(div.getTplSeikyuShomeiboShukeiKensuJusho().getSelectControlID());
        list.add(div.getTplSeikyuShomeiboShukeiMukoTohyoku().getSelectControlID());
        list.add(div.getTplSeikyuShomeiboShukeiMukoJusho().getSelectControlID());
        list.add(div.getTplSeikyuShomeiboShukeiNenrei().getSelectControlID());
        list.add(div.getTplSeikyuShomeiboShukeiNendai().getSelectControlID());
        div.getTabSeikyuShomeiboShukei().setTabpanelPosition(list);
    }

    /**
     * タグ出力順を設定処理。
     *
     * @return dgSeikyuShomeiboShomeishaIchiran_Row
     */
    public dgSeikyuShomeiboShomeishaIchiran_Row createEmptyRow() {
        dgSeikyuShomeiboShomeishaIchiran_Row row = new dgSeikyuShomeiboShomeishaIchiran_Row();
        row.getTxtShimei().setDisabled(false);
        row.getTxtKanaShimei().setDisabled(false);
        row.getTxtSeinengappiYMD().setDisabled(false);
        row.getTxtSeibetsu().setDataSource(get性別ドロップダウン());
        row.getTxtSeibetsu().setSelectedKey(RString.EMPTY);
        row.getTxtSeibetsu().setDisabled(false);
        row.getTxtJusho().setDisabled(false);
        row.getDdlShomeiJokyo().setDataSource(get署名状況ドロップダウン());
        row.getDdlShomeiJokyo().setSelectedKey(審査区分_2.getKey());
        row.getDdlShomeiJokyo().setDisabled(false);
        row.getTxtMukoJiyu().setDataSource(get無効事由ドロップダウン());
        row.getTxtMukoJiyu().setSelectedKey(RString.EMPTY);
        row.getTxtMukoJiyu().setDisabled(false);
        row.getTxtShomeiYMD().setDisabled(false);
        row.getTxtDaihitsushaShimei().setDisabled(false);
        row.getTxtDaihitsushaSeinengappiYMD().setDisabled(false);
        row.getDdlDaihitsushaSeibetsu().setDataSource(get性別ドロップダウン());
        row.getDdlDaihitsushaSeibetsu().setSelectedKey(RString.EMPTY);
        row.getDdlDaihitsushaSeibetsu().setDisabled(false);
        row.getTxtDaihitsushaJusho().setDisabled(false);
        return row;
    }

    /**
     * タグ出力順を設定処理。
     *
     * @param 署名者情報と代筆者選択情報 SeikyushaTorokuJoho
     * @return dgSeikyuShomeiboShomeishaIchiran_Row
     */
    public dgSeikyuShomeiboShomeishaIchiran_Row createRow_署名者(SeikyushaTorokuJoho 署名者情報と代筆者選択情報) {
        dgSeikyuShomeiboShomeishaIchiran_Row row = new dgSeikyuShomeiboShomeishaIchiran_Row();
        row.getTxtShimei().setValue(署名者情報と代筆者選択情報.get氏名());
        row.getTxtKanaShimei().setValue(署名者情報と代筆者選択情報.getカナ氏名());
        row.getTxtSeinengappiYMD().setValue(署名者情報と代筆者選択情報.getSeinengappiYMD());
        row.getTxtSeibetsu().setDataSource(get性別ドロップダウン());
        row.getTxtSeibetsu().setSelectedKey(署名者情報と代筆者選択情報.get性別());
        row.setTxtShikibetsuCode(署名者情報と代筆者選択情報.get識別コード());
        row.getTxtJusho().setValue(署名者情報と代筆者選択情報.get住所());
        row.setTxtSenkyoShikaku(署名者情報と代筆者選択情報.get選挙資格名称());
        row.getDdlShomeiJokyo().setDataSource(get署名状況ドロップダウン());
        row.getDdlShomeiJokyo().setSelectedKey(審査区分_0.getKey());
        row.getTxtMukoJiyu().setDataSource(get無効事由ドロップダウン());
        row.getTxtMukoJiyu().setSelectedKey(RString.EMPTY);
        row.getDdlDaihitsushaSeibetsu().setDataSource(get性別ドロップダウン());
        row.getDdlDaihitsushaSeibetsu().setSelectedKey(RString.EMPTY);
        row.getTxtShomeiYMD().setValue(FlexibleDate.EMPTY);
        row.getTxtShimei().setDisabled(true);
        row.getTxtKanaShimei().setDisabled(true);
        row.getTxtSeinengappiYMD().setDisabled(true);
        row.getTxtSeibetsu().setDisabled(true);
        row.getTxtJusho().setDisabled(true);
        row.getTxtMukoJiyu().setDisabled(true);
        return row;
    }

    /**
     * タグ出力順を設定処理。
     *
     * @param row dgSeikyuShomeiboShomeishaIchiran_Row
     * @param 署名者情報と代筆者選択情報 SeikyushaTorokuJoho
     * @return dgSeikyuShomeiboShomeishaIchiran_Row
     */
    public dgSeikyuShomeiboShomeishaIchiran_Row createRow_代筆者(dgSeikyuShomeiboShomeishaIchiran_Row row,
            SeikyushaTorokuJoho 署名者情報と代筆者選択情報) {
        row.getTxtDaihitsushaShimei().setDisabled(false);
        row.getTxtDaihitsushaShimei().setValue(署名者情報と代筆者選択情報.get氏名());
        row.getTxtDaihitsushaSeinengappiYMD().setDisabled(false);
        row.getTxtDaihitsushaSeinengappiYMD().setValue(署名者情報と代筆者選択情報.getSeinengappiYMD());
        row.getDdlDaihitsushaSeibetsu().setSelectedKey(署名者情報と代筆者選択情報.get性別());
        row.getDdlDaihitsushaSeibetsu().setDisabled(false);
        row.setTxtDaihitsushaShikibetsuCode(署名者情報と代筆者選択情報.get識別コード());
        row.getTxtDaihitsushaJusho().setDisabled(false);
        row.getTxtDaihitsushaJusho().setValue(署名者情報と代筆者選択情報.get住所());
        return row;
    }

    /**
     * タグ出力順を設定処理。
     *
     * @param 直接請求番号 int
     * @param datasource List<dgSeikyuShomeiboShomeishaIchiran_Row>
     * @return List< Aft403ShomeiboResult>
     */
    public List<Aft403ShomeiboResult> create更新データ(int 直接請求番号, List<dgSeikyuShomeiboShomeishaIchiran_Row> datasource) {
        List<Aft403ShomeiboResult> 署名者情報 = new ArrayList<>();
        RString 抄本_署名簿_ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_署名簿_ページ行数, RDate.getNowDate(), SubGyomuCode.AFA選挙本体);
        int 最大印字行 = RString.isNullOrEmpty(抄本_署名簿_ページ行数) ? 0 : Integer.valueOf(抄本_署名簿_ページ行数.toString());
        int 頁 = 1;
        int 行 = 1;
        for (dgSeikyuShomeiboShomeishaIchiran_Row row : datasource) {
            Aft403ShomeiboResult shomeiData = new Aft403ShomeiboResult();
            shomeiData.setAfT403ShomeiboEntity();
            shomeiData.getAfT403ShomeiboEntity().setDaihitsushaJusho(null == row.getTxtDaihitsushaJusho().getValue()
                    ? AtenaJusho.EMPTY : new AtenaJusho(row.getTxtDaihitsushaJusho().getValue()));
            shomeiData.getAfT403ShomeiboEntity().setDaihitsushaKanjiShimei(null == row.getTxtDaihitsushaShimei().getValue()
                    ? AtenaMeisho.EMPTY : new AtenaMeisho(row.getTxtDaihitsushaShimei().getValue()));
            shomeiData.getAfT403ShomeiboEntity().setDaihitsushaSeibetsuCode(row.getDdlDaihitsushaSeibetsu().getSelectedKey());
            shomeiData.getAfT403ShomeiboEntity().setDaihitsushaSeinengappiYMD(row.getTxtDaihitsushaSeinengappiYMD().getValue());
            shomeiData.getAfT403ShomeiboEntity().setDaihitsushaShikibetsuCode(null == row.getTxtDaihitsushaShikibetsuCode()
                    ? ShikibetsuCode.EMPTY : new ShikibetsuCode(row.getTxtDaihitsushaShikibetsuCode()));
            shomeiData.getAfT403ShomeiboEntity().setJusho(null == row.getTxtJusho().getValue()
                    ? AtenaJusho.EMPTY : new AtenaJusho(row.getTxtJusho().getValue()));
            shomeiData.getAfT403ShomeiboEntity().setKanaShimei(null == row.getTxtKanaShimei().getValue()
                    ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(row.getTxtKanaShimei().getValue()));
            shomeiData.getAfT403ShomeiboEntity().setKanjiShimei(null == row.getTxtShimei().getValue()
                    ? AtenaMeisho.EMPTY : new AtenaMeisho(row.getTxtShimei().getValue()));
            shomeiData.getAfT403ShomeiboEntity().setMukoJiyuCode(new Code(row.getTxtMukoJiyu().getSelectedKey()));
            if (行 <= 最大印字行) {
                shomeiData.getAfT403ShomeiboEntity().setPage(頁);
                shomeiData.getAfT403ShomeiboEntity().setGyo(行);
                行++;
            } else {
                頁++;
                行 = 1;
                shomeiData.getAfT403ShomeiboEntity().setPage(頁);
                shomeiData.getAfT403ShomeiboEntity().setGyo(行);
                行++;
            }
            shomeiData.getAfT403ShomeiboEntity().setSatsu(new RString("00"));
            shomeiData.getAfT403ShomeiboEntity().setSearchKanaShimei(null == row.getTxtKanaShimei().getValue()
                    ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(RStringUtil.convertTo清音化(row.getTxtKanaShimei().getValue())));
            shomeiData.getAfT403ShomeiboEntity().setSeibetsuCode(row.getTxtSeibetsu().getSelectedKey());
            shomeiData.getAfT403ShomeiboEntity().setSeikyuNo(直接請求番号);
            shomeiData.getAfT403ShomeiboEntity().setSeinengappiYMD(row.getTxtSeinengappiYMD().getValue());
            shomeiData.getAfT403ShomeiboEntity().setShinsaKubun(new Code(row.getDdlShomeiJokyo().getSelectedKey()));
            shomeiData.getAfT403ShomeiboEntity().setShomeiYMD(row.getTxtShomeiYMD().getValue());
            shomeiData.getAfT403ShomeiboEntity().setShomeishaShikibetsuCode(null == row.getTxtShikibetsuCode()
                    ? ShikibetsuCode.EMPTY : new ShikibetsuCode(row.getTxtShikibetsuCode()));
            署名者情報.add(shomeiData);

        }
        return 署名者情報;
    }

    private List<KeyValueDataSource> get性別ドロップダウン() {
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
        keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
        return keyList;
    }

    private List<KeyValueDataSource> get署名状況ドロップダウン() {
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(審査区分_0.getKey(), 署名なし.getKey()));
        keyList.add(new KeyValueDataSource(審査区分_1.getKey(), 有効.getKey()));
        keyList.add(new KeyValueDataSource(審査区分_2.getKey(), 無効.getKey()));
        return keyList;
    }

    private List<KeyValueDataSource> get無効事由ドロップダウン() {
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(無効事由_01.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_01.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_02.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_02.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_03.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_03.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_04.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_04.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_05.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_05.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_06.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_06.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_07.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_07.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_08.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_08.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_09.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_09.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_10.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_10.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_11.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_11.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_12.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_12.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_13.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_13.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_14.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_14.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_15.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_15.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_16.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_16.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_17.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_17.getKey()))));
        keyList.add(new KeyValueDataSource(無効事由_18.getKey(),
                getコード名称(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), new Code(無効事由_18.getKey()))));
        return keyList;
    }

    private RString edit選挙資格(Code 選挙資格区分コード) {
        return getコード名称(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分コード);
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード) {
        if (null == コード || コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード);
    }

//    private RString get性別(RString 性別コード) {
//        if (null != 性別コード && !性別コード.isEmpty()) {
//            if (SeikyuShomeiboTorokuRStringEnum.性別コード_男.getKey().equals(性別コード)
//                    || SeikyuShomeiboTorokuRStringEnum.性別コード_女.getKey().equals(性別コード)) {
//                return Gender.toValue(性別コード).getCommonName();
//            } else {
//                return Gender.未定義.getCommonName();
//            }
//        }
//        return RString.EMPTY;
//    }
    private boolean is男有権者(RString 性別コード, Code 選挙資格区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 選挙資格区分 && !選挙資格区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_男.getKey().equals(性別コード)
                    && SennkyoSikakuKubun.有権者.value().equals(選挙資格区分.getColumnValue());
        }
        return false;
    }

    private boolean is女有権者(RString 性別コード, Code 選挙資格区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 選挙資格区分 && !選挙資格区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_女.getKey().equals(性別コード)
                    && SennkyoSikakuKubun.有権者.value().equals(選挙資格区分.getColumnValue());
        }
        return false;
    }

    private boolean is男署名有効(RString 性別コード, Code 審査区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 審査区分 && !審査区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_男.getKey().equals(性別コード)
                    && SeikyuShomeiboTorokuRStringEnum.審査区分_1.getKey().equals(審査区分.getColumnValue());
        }
        return false;
    }

    private boolean is女署名有効(RString 性別コード, Code 審査区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 審査区分 && !審査区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_女.getKey().equals(性別コード)
                    && SeikyuShomeiboTorokuRStringEnum.審査区分_1.getKey().equals(審査区分.getColumnValue());
        }
        return false;
    }

    private boolean is男署名無効(RString 性別コード, Code 審査区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 審査区分 && !審査区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_男.getKey().equals(性別コード)
                    && SeikyuShomeiboTorokuRStringEnum.審査区分_2.getKey().equals(審査区分.getColumnValue());
        }
        return false;
    }

    private boolean is女署名無効(RString 性別コード, Code 審査区分) {
        if (null != 性別コード && !性別コード.isEmpty()
                && null != 審査区分 && !審査区分.isEmpty()) {
            return SeikyuShomeiboTorokuRStringEnum.性別コード_女.getKey().equals(性別コード)
                    && SeikyuShomeiboTorokuRStringEnum.審査区分_2.getKey().equals(審査区分.getColumnValue());
        }
        return false;
    }

    private void out初期化アクセスログ出力(List<ShikibetsuCode> 識別コードList) {
        List<PersonalData> personalDataList = new ArrayList<>();
        for (ShikibetsuCode 更新対象 : 識別コードList) {
            personalDataList.add(PersonalData.of(更新対象));
        }
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    private RString format小数点(Integer 計, Integer sum) {
        if (null == 計 || null == sum || new Decimal(sum).equals(Decimal.ZERO)) {
            return FORMATDIVIDE.getKey();
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(計).multiply(INT_100.getKey())
                .divide(new Decimal(sum)).roundHalfUpTo(INT_3.getKey()), 2).concat(百分符.getKey());
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    public void ファイル書込み() {
        署名件数表_投票区別ファイル書込み();
        署名件数表_住所別データファイル書込み();
        無効件数無効事由内訳表_投票区別ファイル書込み();
        無効件数無効事由内訳表_住所別ファイル書込み();
        年齢別ファイル書込み();
        年代別ファイル書込み();

    }

    private void 署名件数表_投票区別ファイル書込み() {
        List<KensuTohyokuCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiKensuTohyoku_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiKensuTohyoku().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiKensuTohyoku_Row row : 署名件数表_投票区別データ) {
            KensuTohyokuCsvResult result = new KensuTohyokuCsvResult();
            result.set投票区(row.getTxtTohyokuCode());
            result.set投票所名(row.getTxtTohyojoName());
            result.set有権者数_男(row.getTxtYukenshasuMan().getValue());
            result.set有権者数_女(row.getTxtYukenshasuWoman().getValue());
            result.set有権者数_計(row.getTxtYukenshasuTotal().getValue());
            result.set署名有効数_男(row.getTxtYukosuMan().getValue());
            result.set署名有効数_女(row.getTxtYukosuWoman().getValue());
            result.set署名有効数_計(row.getTxtYukosuTotal().getValue());
            result.set署名無効数_男(row.getTxtMukosuMan().getValue());
            result.set署名無効数_女(row.getTxtMukosuWoman().getValue());
            result.set署名無効数_計(row.getTxtMukosuTotal().getValue());
            result.set署名合計_男(row.getTxtShomeisuMan().getValue());
            result.set署名合計_女(row.getTxtShomeisuWoman().getValue());
            result.set署名合計_計(row.getTxtShomeisuTotal().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.署名件数表_投票区別);
        try (CsvWriter<KensuTohyokuCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (KensuTohyokuCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    private void 署名件数表_住所別データファイル書込み() {
        List<KensuJushoCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiKensuJusho_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiKensuJusho().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiKensuJusho_Row row : 署名件数表_投票区別データ) {
            KensuJushoCsvResult result = new KensuJushoCsvResult();
            result.setコード(row.getTxtJushoCode());
            result.set住所名(row.getTxtJushoName());
            result.set有権者数_男(row.getTxtYukenshasuMan().getValue());
            result.set有権者数_女(row.getTxtYukenshasuWoman().getValue());
            result.set有権者数_計(row.getTxtYukenshasuTotal().getValue());
            result.set署名有効数_男(row.getTxtYukosuMan().getValue());
            result.set署名有効数_女(row.getTxtYukosuWoman().getValue());
            result.set署名有効数_計(row.getTxtYukosuTotal().getValue());
            result.set署名無効数_男(row.getTxtMukosuMan().getValue());
            result.set署名無効数_女(row.getTxtMukosuWoman().getValue());
            result.set署名無効数_計(row.getTxtMukosuTotal().getValue());
            result.set署名合計_男(row.getTxtShomeisuMan().getValue());
            result.set署名合計_女(row.getTxtShomeisuWoman().getValue());
            result.set署名合計_計(row.getTxtShomeisuTotal().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.署名件数表_住所別);
        try (CsvWriter<KensuJushoCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (KensuJushoCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    private void 無効件数無効事由内訳表_投票区別ファイル書込み() {
        List<MukoTohyokuCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiMukoTohyoku_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiMukoTohyoku().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiMukoTohyoku_Row row : 署名件数表_投票区別データ) {
            MukoTohyokuCsvResult result = new MukoTohyokuCsvResult();
            result.set投票区(row.getTxtTohyokuCode());
            result.set投票所名(row.getTxtTohyojoName());
            result.set名簿未登録(row.getTxtMukoJiyu01().getValue());
            result.set管外居住(row.getTxtMukoJiyu02().getValue());
            result.set署名日未記載(row.getTxtMukoJiyu03().getValue());
            result.set住所未記載(row.getTxtMukoJiyu04().getValue());
            result.set生年月日未記載(row.getTxtMukoJiyu05().getValue());
            result.set無捺印(row.getTxtMukoJiyu06().getValue());
            result.set自書と認めず(row.getTxtMukoJiyu07().getValue());
            result.set同一筆跡代筆(row.getTxtMukoJiyu08().getValue());
            result.set重複署名(row.getTxtMukoJiyu09().getValue());
            result.set何人か未確認(row.getTxtMukoJiyu10().getValue());
            result.set期間外署名(row.getTxtMukoJiyu11().getValue());
            result.set委任日前(row.getTxtMukoJiyu12().getValue());
            result.set無契印(row.getTxtMukoJiyu13().getValue());
            result.set欄外署名(row.getTxtMukoJiyu14().getValue());
            result.set委任状瑕疵(row.getTxtMukoJiyu15().getValue());
            result.set受任者未登録(row.getTxtMukoJiyu16().getValue());
            result.set委任届なし(row.getTxtMukoJiyu17().getValue());
            result.setその他(row.getTxtMukoJiyu18().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.無効件数無効事由内訳表_投票区別);
        try (CsvWriter<MukoTohyokuCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (MukoTohyokuCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    private void 無効件数無効事由内訳表_住所別ファイル書込み() {
        List<MukoJushoCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiMukoJusho_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiMukoJusho().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiMukoJusho_Row row : 署名件数表_投票区別データ) {
            MukoJushoCsvResult result = new MukoJushoCsvResult();
            result.setコード(row.getTxtJushoCode());
            result.set住所(row.getTxtJushoName());
            result.set名簿未登録(row.getTxtMukoJiyu01().getValue());
            result.set管外居住(row.getTxtMukoJiyu02().getValue());
            result.set署名日未記載(row.getTxtMukoJiyu03().getValue());
            result.set住所未記載(row.getTxtMukoJiyu04().getValue());
            result.set生年月日未記載(row.getTxtMukoJiyu05().getValue());
            result.set無捺印(row.getTxtMukoJiyu06().getValue());
            result.set自書と認めず(row.getTxtMukoJiyu07().getValue());
            result.set同一筆跡代筆(row.getTxtMukoJiyu08().getValue());
            result.set重複署名(row.getTxtMukoJiyu09().getValue());
            result.set何人か未確認(row.getTxtMukoJiyu10().getValue());
            result.set期間外署名(row.getTxtMukoJiyu11().getValue());
            result.set委任日前(row.getTxtMukoJiyu12().getValue());
            result.set無契印(row.getTxtMukoJiyu13().getValue());
            result.set欄外署名(row.getTxtMukoJiyu14().getValue());
            result.set委任状瑕疵(row.getTxtMukoJiyu15().getValue());
            result.set受任者未登録(row.getTxtMukoJiyu16().getValue());
            result.set委任届なし(row.getTxtMukoJiyu17().getValue());
            result.setその他(row.getTxtMukoJiyu18().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.無効件数無効事由内訳表_住所別);
        try (CsvWriter<MukoJushoCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (MukoJushoCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    private void 年齢別ファイル書込み() {
        List<NenreiCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiNenrei_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiNenrei().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiNenrei_Row row : 署名件数表_投票区別データ) {
            NenreiCsvResult result = new NenreiCsvResult();
            result.set投票区(row.getTxtTohyokuCode());
            result.set投票所名(row.getTxtTohyojoName());
            result.set満年齢(new RString(row.getTxtNenrei().getValue().toString()));
            result.set有権者数_男(row.getTxtYukenshasuMan().getValue());
            result.set有権者数_女(row.getTxtYukenshasuWoman().getValue());
            result.set有権者数_計(row.getTxtYukenshasuTotal().getValue());
            result.set署名有効数_男(row.getTxtYukosuMan().getValue());
            result.set署名有効数_女(row.getTxtYukosuWoman().getValue());
            result.set署名有効数_計(row.getTxtYukosuTotal().getValue());
            result.set署名無効数_男(row.getTxtMukosuMan().getValue());
            result.set署名無効数_女(row.getTxtMukosuWoman().getValue());
            result.set署名無効数_計(row.getTxtMukosuTotal().getValue());
            result.set投票率_男(row.getTxtTohyoritsuMan().getValue());
            result.set投票率_女(row.getTxtTohyoritsuWoman().getValue());
            result.set投票率_計(row.getTxtTohyoritsuTotal().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.年齢別投票率);
        try (CsvWriter<NenreiCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (NenreiCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    /**
     * 署名件数表_投票区別ファイル書込みする。
     *
     */
    private void 年代別ファイル書込み() {
        List<NendaiCsvResult> resultList = new ArrayList();
        List<dgSeikyuShomeiboShukeiNendai_Row> 署名件数表_投票区別データ = div.getDgSeikyuShomeiboShukeiNendai().getDataSource();
        if (null == 署名件数表_投票区別データ || 署名件数表_投票区別データ.isEmpty()) {
            return;
        }
        for (dgSeikyuShomeiboShukeiNendai_Row row : 署名件数表_投票区別データ) {
            NendaiCsvResult result = new NendaiCsvResult();
            result.set投票区(row.getTxtTohyokuCode());
            result.set投票所名(row.getTxtTohyojoName());
            result.set満年代(row.getTxtNendai().getValue());
            result.set有権者数_男(row.getTxtYukenshasuMan().getValue());
            result.set有権者数_女(row.getTxtYukenshasuWoman().getValue());
            result.set有権者数_計(row.getTxtYukenshasuTotal().getValue());
            result.set署名有効数_男(row.getTxtYukosuMan().getValue());
            result.set署名有効数_女(row.getTxtYukosuWoman().getValue());
            result.set署名有効数_計(row.getTxtYukosuTotal().getValue());
            result.set署名無効数_男(row.getTxtMukosuMan().getValue());
            result.set署名無効数_女(row.getTxtMukosuWoman().getValue());
            result.set署名無効数_計(row.getTxtMukosuTotal().getValue());
            result.set投票率_男(row.getTxtTohyoritsuMan().getValue());
            result.set投票率_女(row.getTxtTohyoritsuWoman().getValue());
            result.set投票率_計(row.getTxtTohyoritsuTotal().getValue());
            resultList.add(result);
        }
        beforeWriter(AFAEucEntityId.年代別投票率);
        try (CsvWriter<NendaiCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER.getKey())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (NendaiCsvResult result : resultList) {
                csvWriter.writeLine(result);
            }
        }
    }

    private void beforeWriter(AFAEucEntityId aFAEucEntityId) {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.EucOther,
                aFAEucEntityId.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), aFAEucEntityId.getFileName());

    }
}
