/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.TohyokuJohoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.core.tohyokuhenko.TohyokuHenkoManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.AssociationKey;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.ITohyokuFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.TohyokuFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.ConfigKeysDomain;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * TohyokuCodeSelectDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyokuCodeSelectDivの入力可否の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class TohyokuCodeSelectHandler {

    private final TohyokuCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票区コード選択Div
     */
    public TohyokuCodeSelectHandler(TohyokuCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。(選挙種類の指定なし)
     *
     */
    public void initialize() {
        //　投票受付を想定。抄本が決まらないと、選挙種類が決定しないため。
        clear();
    }

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param checkFlag RString 1:この共有子Divでチェックします。 0:この共有子Divでチェックしないで、親画面でチェックします。
     */
    public void initialize(SenkyoShurui senkyoShurui, RString checkFlag) {
        div.setTxtHdnSenkyoShurui(senkyoShurui.getCode());
        div.setIsNyuryokuCheckByCommonChildDiv(checkFlag);
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            div.getTxtTohyokuCode().setMaxLength(Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.投票区桁数_国民投票, SubGyomuCode.AFA選挙本体).toString()));
        } else if (senkyoShurui == SenkyoShurui.海区漁業調整委員会委員選挙) {
            div.getTxtTohyokuCode().setMaxLength(Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.投票区桁数_海区選挙, SubGyomuCode.AFA選挙本体).toString()));
        } else if (SenkyoShurui.定時登録.equals(senkyoShurui) || SenkyoShurui.国政選挙_地方選挙.equals(senkyoShurui)) {
            div.getTxtTohyokuCode().setMaxLength(Integer.valueOf(BusinessConfig.get(ConfigKeysDomain.コード有効桁_投票区コード, SubGyomuCode.UZAフレームワーク).toString()));
        }

        if ((div.isReadOnly()) || (div.getTxtTohyokuCode().isReadOnly())) {
            div.getTxtTohyokuCode().setDisabled(Boolean.TRUE);
            div.getBtnTohyokuCode().setDisplayNone(Boolean.TRUE);
        } else {
            div.getTxtTohyokuCode().setDisabled(Boolean.FALSE);
            div.getBtnTohyokuCode().setDisplayNone(Boolean.FALSE);
        }

    }

    /**
     * 引数のコードから、投票区名称を取得し初期表示を行います。
     *
     * @param code 投票区コード
     */
    public void initialize(RString code) {
        div.getTxtTohyokuCode().setValue(code);
        div.getTxtTohyokuName().setValue(get投票区名称());
    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    public void clear() {
        div.getTxtTohyokuCode().clearValue();
        div.getTxtTohyokuName().clearValue();
        div.setTxtHdnSenkyoShurui(RString.EMPTY);
        div.getTxtTohyokuCodeDomain().clearDomain();
    }

    /**
     * 投票区名称を取得します。
     *
     * @return 投票区名称
     */
    public RString get投票区名称() {
        RString senkyokuName = RString.EMPTY;
        RString senkyoShurui = div.getTxtHdnSenkyoShurui();
        RString senkyokuCode = div.getTxtTohyokuCode().getValue();
        if (RString.EMPTY.equals(senkyoShurui) || SenkyoShurui.toValue(senkyoShurui) == SenkyoShurui.定時登録 || SenkyoShurui.toValue(senkyoShurui) == SenkyoShurui.国政選挙_地方選挙) {
            ITohyokuFinder tohyokuFinder = TohyokuFinderFactory.createInstance();
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            List<Tohyoku> tohyokulist = tohyokuFinder.get投票区by地方公共団体and基準日(new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());
            if (tohyokulist == null || tohyokulist.isEmpty()) {
                senkyokuName = RString.EMPTY;
            } else {
                for (Tohyoku tohyoku : tohyokulist) {
                    if (senkyokuCode.equals(tohyoku.get投票区コード().getColumnValue())) {
                        senkyokuName = tohyoku.get漢字名称();
                        break;
                    }
                }
            }

        } else {
            TohyokuJohoSearchResult 投票区 = new TohyokuHenkoManager().get投票区(new Code(senkyoShurui), senkyokuCode);
            if (投票区 == null) {
                senkyokuName = RString.EMPTY;
            } else {
                senkyokuName = 投票区.getTohyokuName();
            }
        }
        return senkyokuName;
    }

    /**
     * 投票区コードチェックを行います。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 投票区コードチェック() {
        RString 投票区名称 = get投票区名称();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (投票区名称 == RString.EMPTY) {
            pairs.add(new ValidationMessageControlPair(TohyokuCodeSelectValidationMessage.投票区コード存在しない, div.getTxtTohyokuCode()));
        }
        return pairs;
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
        div.getBtnTohyokuCode().setDisplayNone(readOnlySetMode);
    }

}
