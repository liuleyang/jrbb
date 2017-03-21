/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.ISearchShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchJuminDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * SearchJuminに対応するSpecクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public enum SearchJuminSpec implements IPredicate<SearchJuminDiv> {

    /**
     * 検索条件入力チェック
     */
    検索条件入力チェック {
                @Override
                public boolean apply(SearchJuminDiv div) {
                    AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho();
                    ISearchShikakuDiv 資格検索Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
                    return !RString.isNullOrEmpty(宛名検索Div.getTxtAtenaMeisho().getText())
                    || !RString.isNullOrEmpty(宛名検索Div.getTxtSeinenGappi().getText())
                    || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode().getDomain().value())
                    || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName().getValue())
                    || !宛名検索Div.getTxtShikibetsuCodeSub().getDomain().isEmpty()
                    || !宛名検索Div.getTxtSetaiCodeSub().getDomain().isEmpty()
                    || !RString.isNullOrEmpty(資格検索Div.get投票区コード())
                    || !資格検索Div.getChkSearchTohyoShikaku().getSelectedKeys().isEmpty();
                }
            },
    /**
     * 検索条件入力チェック2
     */
    検索条件入力チェック2 {
                @Override
                public boolean apply(SearchJuminDiv div) {
                    AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho();
                    ISearchShikakuDiv 資格検索Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
                    RString 名称 = 宛名検索Div.getTxtAtenaMeisho().getText();
                    if (!RString.isNullOrEmpty(名称) && 名称.length() <= 2 && SpecHelper.is漢字以外(名称)) {
                        return !RString.isNullOrEmpty(宛名検索Div.getTxtSeinenGappi().getText())
                        || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode().getDomain().value())
                        || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName().getValue())
                        || !宛名検索Div.getTxtSetaiCodeSub().getDomain().isEmpty()
                        || !((GyoseikuInputDiv) 宛名検索Div.getCcdGyoseikuInputSub()).getTxtGyoseikuCode().getDomain().isEmpty()
                        || !RString.isNullOrEmpty(資格検索Div.get投票区コード());
                    }
                    return true;
                }
            };

    private static class SpecHelper {

        static boolean is漢字以外(RString 名称) {
            List<RString> splited名称List = new ArrayList<>();
            if (名称.length() == 1) {
                splited名称List.add(名称);
            } else {
                splited名称List.add(名称.substring(0, 1));
                splited名称List.add(名称.substring(1));
            }
            for (RString splited名称 : splited名称List) {
                if (RStringUtil.isひらがなOnly(splited名称) || RStringUtil.is半角カナOnly(splited名称) || RStringUtil.isHalfsizeNumberOnly(splited名称)) {
                    return true;
                }
            }
            return false;
        }
    }
}
