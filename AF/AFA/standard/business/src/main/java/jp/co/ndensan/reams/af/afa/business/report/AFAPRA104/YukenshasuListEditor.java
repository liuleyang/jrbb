/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA104;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.憲法改正国民投票;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA104.YukenshasuShirabeSource;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104Entity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link YukenshasuListSource}を編集します。
 *
 * @reamsid_L AF-0010-038 wangm
 */
public class YukenshasuListEditor implements IYukenshasuListEditor {

    private static final RString 帳票タイトル = new RString("有権者数調べ");
    private static final RString 見出し2 = new RString("法11条関連");

    private final YukenshasuListParam param;
    private final AFAPRA104Entity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 選挙種類;

    /**
     * コンストラクタです。
     *
     * @param param {@link YukenshasuListParam}
     *
     */
    public YukenshasuListEditor(YukenshasuListParam param) {
        this.param = param;
        this.帳票共通ヘッダー = param.get帳票共通ヘッダー();
        this.entity = param.getEntity();
        this.選挙種類 = entity.get選挙種類();
    }

    @Override
    public YukenshasuShirabeSource edit(YukenshasuShirabeSource source) {
        setヘッダ(source);
        if (!param.isEmpty()) {
            set明細(source);
        }
        setフッタ(source);
        return source;
    }

    private void setフッタ(YukenshasuShirabeSource source) {
        source.sakuseiJoken1 = 帳票共通ヘッダー.get作成条件();
    }

    private void setヘッダ(YukenshasuShirabeSource source) {
        source.meisaiTitle1 = param.get見出し1();
        source.subTitle = param.getサブタイトル();
        source.todofukenKubun = 帳票共通ヘッダー.get都道府県区分();
        source.title = 帳票タイトル;
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.senkyoMei = entity.get選挙名称();
        if (憲法改正国民投票.getCode().equals(選挙種類)) {
            source.meisaiTitle2 = RString.EMPTY;
        } else {
            source.meisaiTitle2 = 見出し2;
        }
    }

    private void set明細(YukenshasuShirabeSource source) {
        source.kijunYmd = edit日付(entity.get名簿基準年月日());
        source.tohyoYmd = edit日付(entity.get投票年月日());
        if (憲法改正国民投票.getCode().equals(選挙種類)) {
            source.listMeisai1_9 = RString.EMPTY;
            source.listMeisai2_9 = RString.EMPTY;
            source.listMeisai3_9 = RString.EMPTY;
        } else {
            source.listMeisai1_9 = editDecimal(entity.get法11条関連_男());
            source.listMeisai2_9 = editDecimal(entity.get法11条関連_女());
            source.listMeisai3_9 = editDecimal(entity.get法11条関連_男(), entity.get法11条関連_女());
        }
        source.listMeisaiJusho_1 = param.get明細行見出し1();
        source.listMeisai1_1 = editDecimal(entity.get登録者_男());
        source.listMeisai2_1 = editDecimal(entity.get登録者_女());
        source.listMeisai1_2 = editDecimal(entity.get追加登録者_男());
        source.listMeisai2_2 = editDecimal(entity.get追加登録者_女());
        source.listMeisai1_3 = editDecimal(entity.get死亡_男());
        source.listMeisai2_3 = editDecimal(entity.get死亡_女());
        source.listMeisai1_4 = editDecimal(entity.get四ヶ月抹消_男());
        source.listMeisai2_4 = editDecimal(entity.get四ヶ月抹消_女());
        source.listMeisai1_5 = editDecimal(entity.get当日四ヶ月抹消_男());
        source.listMeisai2_5 = editDecimal(entity.get当日四ヶ月抹消_女());
        source.listMeisai1_6 = editDecimal(entity.get誤載_男());
        source.listMeisai2_6 = editDecimal(entity.get誤載_女());
        source.listMeisai1_7 = editDecimal(entity.get国籍喪失_男());
        source.listMeisai2_7 = editDecimal(entity.get国籍喪失_女());
        source.listMeisai1_8 = editDecimal(entity.getその他抹消_男());
        source.listMeisai2_8 = editDecimal(entity.getその他抹消_女());
        source.listMeisai1_10 = editDecimal(entity.get二重登録_男());
        source.listMeisai2_10 = editDecimal(entity.get二重登録_女());
        source.listMeisai1_11 = editDecimal(entity.get抹消者総_男());
        source.listMeisai2_11 = editDecimal(entity.get抹消者総_女());
        source.listMeisai1_12 = editDecimal(entity.get失権失格者_男());
        source.listMeisai2_12 = editDecimal(entity.get失権失格者_女());
        source.listMeisai1_13 = editDecimal(entity.get選挙期日登録者_男());
        source.listMeisai2_13 = editDecimal(entity.get選挙期日登録者_女());
        source.listMeisai1_14 = editDecimal(entity.getN内転出者_男());
        source.listMeisai2_14 = editDecimal(entity.getN内転出者_女());
        source.listMeisai1_15 = editDecimal(entity.getN外転出者_男());
        source.listMeisai2_15 = editDecimal(entity.getN外転出者_女());
        source.listMeisai1_16 = editDecimal(entity.get国外転出者_男());
        source.listMeisai2_16 = editDecimal(entity.get国外転出者_女());
        source.listMeisai1_17 = editDecimal(entity.get職権削除者_男());
        source.listMeisai2_17 = editDecimal(entity.get職権削除者_女());
        source.listMeisai1_18 = editDecimal(entity.get加算有権者_抹消者_男());
        source.listMeisai2_18 = editDecimal(entity.get加算有権者_抹消者_女());
        source.listMeisai1_19 = editDecimal(entity.get加算有権者_失権者_男());
        source.listMeisai2_19 = editDecimal(entity.get加算有権者_失権者_女());
        source.listMeisai1_20 = editDecimal(entity.get加算有権者_計_男());
        source.listMeisai2_20 = editDecimal(entity.get加算有権者_計_女());
        source.listMeisai1_21 = editDecimal(entity.get当日有権者_男());
        source.listMeisai2_21 = editDecimal(entity.get当日有権者_女());
        source.listMeisai3_1 = editDecimal(entity.get登録者_男(), entity.get登録者_女());
        source.listMeisai3_2 = editDecimal(entity.get追加登録者_男(), entity.get追加登録者_女());
        source.listMeisai3_3 = editDecimal(entity.get死亡_男(), entity.get死亡_女());
        source.listMeisai3_4 = editDecimal(entity.get四ヶ月抹消_男(), entity.get四ヶ月抹消_女());
        source.listMeisai3_5 = editDecimal(entity.get当日四ヶ月抹消_男(), entity.get当日四ヶ月抹消_女());
        source.listMeisai3_6 = editDecimal(entity.get誤載_男(), entity.get誤載_女());
        source.listMeisai3_7 = editDecimal(entity.get国籍喪失_男(), entity.get国籍喪失_女());
        source.listMeisai3_8 = editDecimal(entity.getその他抹消_男(), entity.getその他抹消_女());
        source.listMeisai3_10 = editDecimal(entity.get二重登録_男(), entity.get二重登録_女());
        source.listMeisai3_11 = editDecimal(entity.get抹消者総_男(), entity.get抹消者総_女());
        source.listMeisai3_12 = editDecimal(entity.get失権失格者_男(), entity.get失権失格者_女());
        source.listMeisai3_13 = editDecimal(entity.get選挙期日登録者_男(), entity.get選挙期日登録者_女());
        source.listMeisai3_14 = editDecimal(entity.getN内転出者_男(), entity.getN内転出者_女());
        source.listMeisai3_15 = editDecimal(entity.getN外転出者_男(), entity.getN外転出者_女());
        source.listMeisai3_16 = editDecimal(entity.get国外転出者_男(), entity.get国外転出者_女());
        source.listMeisai3_17 = editDecimal(entity.get職権削除者_男(), entity.get職権削除者_女());
        source.listMeisai3_18 = editDecimal(entity.get加算有権者_抹消者_男(), entity.get加算有権者_抹消者_女());
        source.listMeisai3_19 = editDecimal(entity.get加算有権者_失権者_男(), entity.get加算有権者_失権者_女());
        source.listMeisai3_20 = editDecimal(entity.get加算有権者_計_男(), entity.get加算有権者_計_女());
        source.listMeisai3_21 = editDecimal(entity.get当日有権者_男(), entity.get当日有権者_女());
    }

    private RString editDecimal(Decimal trgt) {

        return new RString(trgt.toString("#,##0"));
    }

    private RString editDecimal(Decimal trgt1, Decimal trgt2) {

        return new RString(trgt1.add(trgt2).toString("#,##0"));
    }

    private RString edit日付(FlexibleDate 日付) {
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
