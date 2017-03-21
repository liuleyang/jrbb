/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1010;

import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1010.IdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * IdoShikakuIdoShoriの操作を担当するクラスです。
 *
 * @reamsid_L AF-0180-010 liuyj
 */
public class IdoShikakuIdoShoriHandler {

    private final IdoShikakuIdoShoriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙人資格異動Div
     */
    public IdoShikakuIdoShoriHandler(IdoShikakuIdoShoriDiv div) {
        this.div = div;
    }
    
    /**
     * 選挙資格が有無チェック。
     *@return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 選挙資格が有無チェック() {
        ValidationMessageControlPairs 選挙資格の有無チェック = div.getCcdIdoShikakuJoho().選挙資格の有無チェック();
        if (選挙資格の有無チェック.iterator().hasNext()) {
            return 選挙資格の有無チェック;
        }
        return null;
    }

    /**
     * 選挙資格が抹消者以外チェック。
     *
     * @param menuID RString
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 選挙資格が抹消者以外チェック(RString menuID) {
        ValidationMessageControlPairs valid3ヶ月経過日 = div.getCcdIdoShikakuJoho().経過日3ヶ月チェック();
        if (valid3ヶ月経過日.iterator().hasNext()) {
            return valid3ヶ月経過日;
        }
        ValidationMessageControlPairs valid表示日と表示事由 = div.getCcdIdoShikakuJoho().表示日と表示事由チェック();
        if (valid表示日と表示事由.iterator().hasNext()) {
            return valid表示日と表示事由;
        }
        ValidationMessageControlPairs valid登録停止者変更 = div.getCcdIdoShikakuJoho().登録停止者変更時のチェック();
        if (valid登録停止者変更.iterator().hasNext()) {
            return valid登録停止者変更;
        }
        ValidationMessageControlPairs valid表示消除予定年月日 = div.getCcdIdoShikakuJoho().表示消除予定年月日チェック();
        if (valid表示消除予定年月日.iterator().hasNext()) {
            return valid表示消除予定年月日;
        }
        ValidationMessageControlPairs valid表示消除年月日 = div.getCcdIdoShikakuJoho().表示消除年月日チェック();
        if (valid表示消除年月日.iterator().hasNext()) {
            return valid表示消除年月日;
        }
        ValidationMessageControlPairs valid転出時の住民種別 = div.getCcdIdoShikakuJoho().転出時の住民種別チェック();
        if (valid転出時の住民種別.iterator().hasNext()) {
            return valid転出時の住民種別;
        }
        ValidationMessageControlPairs valid同一日 = div.getCcdIdoShikakuJoho().同一日チェック();
        if (valid同一日.iterator().hasNext()) {
            return valid同一日;
        }
        ValidationMessageControlPairs valid登録年月日と表示年月日 = div.getCcdIdoShikakuJoho().登録年月日と表示年月日の関連チェック();
        if (valid登録年月日と表示年月日.iterator().hasNext()) {
            return valid登録年月日と表示年月日;
        }
        ValidationMessageControlPairs valid登録年月日と抹消年月日 = div.getCcdIdoShikakuJoho().登録年月日と抹消年月日の関連チェック();
        if (valid登録年月日と抹消年月日.iterator().hasNext()) {
            return valid登録年月日と抹消年月日;
        }
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs 転出時の住民種別Warning = div.getCcdIdoShikakuJoho().
                    転出時の住民種別ウォーニングチェック();
            if (転出時の住民種別Warning.iterator().hasNext()) {
                return 転出時の住民種別Warning;
            }
        }
        return null;
    }

    /**
     * 選挙資格が抹消者チェック。
     *
     * @param menuID RString
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 選挙資格が抹消者チェック(RString menuID) {
        ValidationMessageControlPairs valid抹消理由と抹消年月日 = div.getCcdIdoShikakuJoho().抹消理由と抹消年月日入力チェック();
        if (valid抹消理由と抹消年月日.iterator().hasNext()) {
            return valid抹消理由と抹消年月日;
        }
        ValidationMessageControlPairs valid抹消理由と住民種別 = div.getCcdIdoShikakuJoho().抹消理由と住民種別のチェック();
        if (valid抹消理由と住民種別.iterator().hasNext()) {
            return valid抹消理由と住民種別;
        }
        ValidationMessageControlPairs valid入力日付 = div.getCcdIdoShikakuJoho().入力日付のチェック();
        if (valid入力日付.iterator().hasNext()) {
            return valid入力日付;
        }
        ValidationMessageControlPairs valid抹消異動日関連 = div.getCcdIdoShikakuJoho().抹消異動日関連チェック();
        if (valid抹消異動日関連.iterator().hasNext()) {
            return valid抹消異動日関連;
        }
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs 入力日付Warning = div.getCcdIdoShikakuJoho().入力日付ウォーニングチェック();
            if (入力日付Warning.iterator().hasNext()) {
                return 入力日付Warning;
            }
        }
        return null;
    }
    
    /**
     * 住登外チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 住登外チェック() {
        ValidationMessageControlPairs 住登外チェック = div.getCcdIdoShikakuJoho().住登外チェック();
        if (住登外チェック.iterator().hasNext()) {
            return 住登外チェック;
        }
        return null;
    }

    /**
     * 登録対象外Warnチェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 登録対象外Warnチェック() {
        ValidationMessageControlPairs 登録対象外Warnチェック = div.getCcdIdoShikakuJoho().登録対象外Warnチェック();
        if (登録対象外Warnチェック.iterator().hasNext()) {
            return 登録対象外Warnチェック;
        }
        return null;
    }

    /**
     * 在外選挙資格更新引数を設定する。
     *
     * @param 資格情報DIV ShikakuJohoDiv
     * @param 在外選挙資格情報 ZaigaiSenkyoShikakuResult
     * @return ZaigaiSenkyoShikakuResult
     */
    public ZaigaiSenkyoShikakuResult set在外選挙資格更新引数(ShikakuJohoDiv 資格情報DIV, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        RDate 表示年月日 = 資格情報DIV.getTxtHyojiYMD().getValue();
        在外選挙資格情報.set表示年月日(表示年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示年月日.toDateString()));
        RString 表示事由 = 資格情報DIV.getCcdHyojiJiyu().getSelectJiyuCode();
        在外選挙資格情報.set表示事由コード(表示事由 == null ? Code.EMPTY : new Code(表示事由));
        return 在外選挙資格情報;
    }

    /**
     * 選挙資格更新引数を設定する。
     *
     * @param 資格情報DIV ShikakuJohoDiv
     * @param 選挙資格情報更新 ShikakuJohoResult
     * @return ShikakuJohoResult
     */
    public ShikakuJohoResult set選挙資格更新引数(ShikakuJohoDiv 資格情報DIV, ShikakuJohoResult 選挙資格情報更新) {
        RDate 表示年月日 = 資格情報DIV.getTxtHyojiYMD().getValue();
        選挙資格情報更新.set表示年月日(表示年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示年月日.toDateString()));
        RString 表示事由 = 資格情報DIV.getCcdHyojiJiyu().getSelectJiyuCode();
        選挙資格情報更新.set表示事由コード(表示事由 == null ? Code.EMPTY : new Code(表示事由));
        RDate 抹消年月日 = 資格情報DIV.getTxtMasshoYMD().getValue();
        選挙資格情報更新.set抹消年月日(抹消年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(抹消年月日.toDateString()));
        RString 抹消事由コード = 資格情報DIV.getCcdMasshoJiyu().getSelectJiyuCode();
        選挙資格情報更新.set抹消事由コード(抹消事由コード == null ? Code.EMPTY : new Code(抹消事由コード));
        RDate 表示消除年月日 = 資格情報DIV.getTxtHyojiShojoYMD().getValue();
        選挙資格情報更新.set表示消除年月日(表示消除年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示消除年月日.toDateString()));
        RDate 表示消除予定年月日 = 資格情報DIV.getTxtHyojiShojoYoteiYMD().getValue();
        選挙資格情報更新.set表示消除予定年月日(表示消除予定年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示消除予定年月日.toDateString()));
        RDate 刑期終了年月日 = 資格情報DIV.getTxtKeikiShuryoYMD().getValue();
        選挙資格情報更新.set刑期終了年月日(刑期終了年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(刑期終了年月日.toDateString()));
        選挙資格情報更新.set2刑持ちフラグ(資格情報DIV.getChk2keiMochi().isAllSelected());
        RString 選挙資格区分 = 資格情報DIV.getRadSenkyoShikaku().getSelectedKey();
        選挙資格情報更新.set選挙資格区分(選挙資格区分 == null ? Code.EMPTY : new Code(選挙資格区分));
        選挙資格情報更新.set投票区コード(資格情報DIV.getCcdTohyokuCode().get投票区コード());
        RDate 名簿登録年月日 = 資格情報DIV.getTxtMeiboTorokuYMD().getValue();
        選挙資格情報更新.set名簿登録年月日(名簿登録年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(名簿登録年月日.toDateString()));
        RString 登録事由コード = 資格情報DIV.getCcdMeiboTorokuJiyu().getSelectJiyuCode();
        選挙資格情報更新.set登録事由コード(登録事由コード == null ? Code.EMPTY : new Code(登録事由コード));
        RDate 登録停止年月日 = 資格情報DIV.getTxtTorokuTeishiYMD().getValue();
        選挙資格情報更新.set登録停止年月日(登録停止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(登録停止年月日.toDateString()));
        RString 登録停止事由コード = 資格情報DIV.getCcdTorokuTeishiJiyu().getSelectJiyuCode();
        選挙資格情報更新.set登録停止事由コード(登録停止事由コード == null ? Code.EMPTY : new Code(登録停止事由コード));
        return 選挙資格情報更新;
    }

    /**
     * 選挙資格更新引数を設定する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 選挙種類 Code
     * @param 資格情報DIV ShikakuJohoDiv
     * @return ShikakuJohoResult
     */
    public ShikakuJohoResult set選挙資格新規引数(ShikibetsuCode 識別コード, Code 選挙種類, ShikakuJohoDiv 資格情報DIV) {
        ShikakuJohoResult 選挙資格情報 = new ShikakuJohoResult();
        選挙資格情報.set識別コード(識別コード);
        選挙資格情報.set選挙種類(選挙種類);
        RString 選挙資格区分 = 資格情報DIV.getRadSenkyoShikaku().getSelectedKey();
        選挙資格情報.set選挙資格区分(選挙資格区分 == null ? Code.EMPTY : new Code(選挙資格区分));
        選挙資格情報.set投票区コード(資格情報DIV.getCcdTohyokuCode().get投票区コード());
        RDate 名簿登録年月日 = 資格情報DIV.getTxtMeiboTorokuYMD().getValue();
        選挙資格情報.set名簿登録年月日(名簿登録年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(名簿登録年月日.toDateString()));
        RString 登録事由コード = 資格情報DIV.getCcdMeiboTorokuJiyu().getSelectJiyuCode();
        選挙資格情報.set登録事由コード(登録事由コード == null ? Code.EMPTY : new Code(登録事由コード));
        RDate 登録停止年月日 = 資格情報DIV.getTxtTorokuTeishiYMD().getValue();
        選挙資格情報.set登録停止年月日(登録停止年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(登録停止年月日.toDateString()));
        RString 登録停止事由コード = 資格情報DIV.getCcdTorokuTeishiJiyu().getSelectJiyuCode();
        選挙資格情報.set登録停止事由コード(登録停止事由コード == null ? Code.EMPTY : new Code(登録停止事由コード));
        RDate 表示年月日 = 資格情報DIV.getTxtHyojiYMD().getValue();
        選挙資格情報.set表示年月日(表示年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示年月日.toDateString()));
        RString 表示事由 = 資格情報DIV.getCcdHyojiJiyu().getSelectJiyuCode();
        選挙資格情報.set表示事由コード(表示事由 == null ? Code.EMPTY : new Code(表示事由));
        RDate 表示消除年月日 = 資格情報DIV.getTxtHyojiShojoYMD().getValue();
        選挙資格情報.set表示消除年月日(表示消除年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示消除年月日.toDateString()));
        RDate 表示消除予定年月日 = 資格情報DIV.getTxtHyojiShojoYoteiYMD().getValue();
        選挙資格情報.set表示消除予定年月日(表示消除予定年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示消除予定年月日.toDateString()));
        RDate 抹消年月日 = 資格情報DIV.getTxtMasshoYMD().getValue();
        選挙資格情報.set抹消年月日(抹消年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(抹消年月日.toDateString()));
        RString 抹消事由コード = 資格情報DIV.getCcdMasshoJiyu().getSelectJiyuCode();
        選挙資格情報.set抹消事由コード(抹消事由コード == null ? Code.EMPTY : new Code(抹消事由コード));
        RDate 刑期終了年月日 = 資格情報DIV.getTxtKeikiShuryoYMD().getValue();
        選挙資格情報.set刑期終了年月日(刑期終了年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(刑期終了年月日.toDateString()));
        選挙資格情報.set2刑持ちフラグ(資格情報DIV.getChk2keiMochi().isAllSelected());
        選挙資格情報.setデータ登録年月日(FlexibleDate.getNowDate());
        return 選挙資格情報;
    }
}
