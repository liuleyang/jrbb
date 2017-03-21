/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyojitoroku.ShohonJohoResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010.JuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * JuminTohyojiTorokuDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public class JuminTohyojiTorokuHandler {

    private final JuminTohyojiTorokuDiv div;
    private final RString チェック = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div JuminTohyojiTorokuDiv
     */
    public JuminTohyojiTorokuHandler(JuminTohyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param メニューID RString
     */
    public void onLoad(RString メニューID) {
    }

    /**
     * 状態をセットする。
     *
     */
    public void 表示制御() {
        div.getJuminTohyojiJoho().getTxtShohonName().clearValue();
        div.getJuminTohyojiJoho().getTxtTohyoYMD().clearValue();
        div.getJuminTohyojiJoho().getTxtTohyoKaishiYMD().clearValue();

        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJapanese().setSelectedItemsByKey(getSelectKeys(true));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkForeigner().setSelectedItemsByKey(getSelectKeys(false));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJumin().setSelectedItemsByKey(getSelectKeys(true));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTenshutsusha().setSelectedItemsByKey(getSelectKeys(false));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTennyusha().setSelectedItemsByKey(getSelectKeys(false));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTenshutsuYMD().clearValue();
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTennyuYMD().clearValue();
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTeishishaFukumu().setSelectedItemsByKey(getSelectKeys(false));

        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenreiKijunYmd().clearValue();
        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenrei().clearValue();
        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getChkNenreiKijun().setSelectedItemsByKey(getSelectKeys(true));

        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().clearFromValue();
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().clearToValue();
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtKyojuNensu().clearValue();
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getChkRenzokuKikan().setSelectedItemsByKey(getSelectKeys(false));
        div.getJuminTohyojiSakuseiChohyo().getJuminTohyojiSakuseiChohyoMeiboShohon().setIsPublish(true);
    }

    /**
     * 抄本情報から、画面内容をセットする。
     *
     * @param 抄本情報 ShohonJohoResult
     */
    public void 画面設定_抄本情報(ShohonJohoResult 抄本情報) {
        if (null == 抄本情報) {
            表示制御();
            return;
        }
        div.getJuminTohyojiJoho().getTxtShohonName().setValue(抄本情報.get抄本名());
        div.getJuminTohyojiJoho().getTxtTohyoYMD().setValue(toRDate(抄本情報.get投票年月日()));
        div.getJuminTohyojiJoho().getTxtTohyoKaishiYMD().setValue(toRDate(抄本情報.get投票受付開始年月日()));

        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJapanese().setSelectedItemsByKey(getSelectKeys(抄本情報.get日本人フラグ()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkForeigner().setSelectedItemsByKey(getSelectKeys(抄本情報.get外国人フラグ()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJumin().setSelectedItemsByKey(getSelectKeys(抄本情報.get住民フラグ()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTenshutsusha().setSelectedItemsByKey(getSelectKeys(抄本情報.get転出者フラグ()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTennyusha().setSelectedItemsByKey(getSelectKeys(抄本情報.get転入者フラグ()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTenshutsuYMD().setValue(toRDate(抄本情報.get転出期限年月日()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTennyuYMD().setValue(toRDate(抄本情報.get転入期限年月日()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTeishishaFukumu().setSelectedItemsByKey(getSelectKeys(抄本情報.get公民権停止者含フラグ()));

        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenreiKijunYmd().setValue((toRDate(抄本情報.get年齢計算基準年月日())));
        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenrei().setValue(toDecimal(抄本情報.get年齢()));
        div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getChkNenreiKijun().setSelectedItemsByKey((getSelectKeys(抄本情報.get誕生日含フラグ())));

        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().setFromValue(toRDate(抄本情報.get住定開始年月日()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().setToValue(toRDate(抄本情報.get住定終了年月日()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtKyojuNensu().setValue(toDecimal(抄本情報.get居住年数()));
        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getChkRenzokuKikan().setSelectedItemsByKey((getSelectKeys(null
                                != div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtKyojuNensu().getValue())));

    }

    private RDate toRDate(FlexibleDate 日付) {
        if (null == 日付 || 日付.isEmpty()) {
            return null;
        }
        return new RDate(日付.toString());
    }

    private Decimal toDecimal(Integer 年数) {
        if (null == 年数 || 0 == 年数) {
            return null;
        }
        return Decimal.valueOf(年数);
    }

    private List<RString> getSelectKeys(Boolean フラグ) {
        List<RString> keys = new ArrayList<>();
        if (null == フラグ) {
            return keys;
        } else if (フラグ) {
            keys.add(チェック);
        }
        return keys;
    }

}
