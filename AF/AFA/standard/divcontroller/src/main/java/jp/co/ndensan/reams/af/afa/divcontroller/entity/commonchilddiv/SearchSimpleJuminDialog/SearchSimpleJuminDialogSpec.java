/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.ua.uax.definition.core.KensakuYoShikibetsuCode;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 【共有子Div】ShisetsuCodeSelectDivに対するSpecです。
 *
 * @reamsid_L AF-0170-020 lis
 */
public enum SearchSimpleJuminDialogSpec implements IPredicate<SearchSimpleJuminDialogDiv> {

    /**
     * 最大表示件数チェック。
     */
    最大表示件数チェック {
                @Override
                public boolean apply(SearchSimpleJuminDialogDiv div) {
                    boolean flag = true;
                    Decimal 最大表示件数 = new Decimal(Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_上限値,
                                            SubGyomuCode.AFA選挙本体).toString()));
                    Decimal 画面の最大表示件数 = div.getSearchSimpleJoken().getTxtMaxDisplayCount().getValue();
                    if (画面の最大表示件数.compareTo(最大表示件数) > 0) {
                        return false;
                    }
                    return flag;
                }
            },
    /**
     * 対象者選択チェック。
     */
    対象者選択チェック {
                @Override
                public boolean apply(SearchSimpleJuminDialogDiv div) {
                    boolean flag = true;
                    List<dgSearchSimpleKekkaList_Row> dataSource = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getSelectedItems();

                    if (dataSource.isEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 対象者が存在しないチェック。
     */
    対象者が存在しないチェック {
                @Override
                public boolean apply(SearchSimpleJuminDialogDiv div) {
                    boolean flag = true;
                    RString 件数 = div.getTxtHdnNumber();
                    if (件数.equals(new RString("0"))) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 検索条件入力チェック。
     */
    検索条件入力チェック {
                @Override
                public boolean apply(SearchSimpleJuminDialogDiv div) {
                    IShikibetsuTaishoPSMSearchKey psmSearchKey = div.getSearchSimpleJoken()
                    .getCcdSearchSimpleJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
                    RString 氏名 = psmSearchKey.get氏名();
                    if (氏名 != null && !氏名.isEmpty()) {
                        return true;
                    }

                    RString 氏名分割１ = psmSearchKey.get氏名分割１();
                    if (氏名分割１ != null && !氏名分割１.isEmpty()) {
                        return true;
                    }

                    RString get氏名分割２ = psmSearchKey.get氏名分割２();
                    if (get氏名分割２ != null && !get氏名分割２.isEmpty()) {
                        return true;
                    }

                    RString 氏名分割３ = psmSearchKey.get氏名分割３();
                    if (氏名分割３ != null && !氏名分割３.isEmpty()) {
                        return true;
                    }

                    FlexibleDate 生年月日 = psmSearchKey.get生年月日();
                    if (生年月日 != null && !生年月日.isEmpty()) {
                        return true;
                    }
//                    AtenaJusho 住所 = psmSearchKey.get町域();
//                    if (住所 != null && !住所.isEmpty()) {
//                        return true;
//                    }

                    KensakuYoShikibetsuCode 識別コード = psmSearchKey.get識別コード();
                    if (識別コード != null && !識別コード.isEmpty()) {
                        return true;
                    }

                    RString 投票区コード = div.getSearchSimpleJoken().getCcdTohyokuCode().get投票区コード();
                    if (投票区コード != null && !投票区コード.isEmpty()) {
                        return true;
                    }

//                    List 投票資格 = div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedKeys();
//
//                    return 投票資格 != null && !投票資格.isEmpty();
                    return psmSearchKey.get世帯コード() != null && !psmSearchKey.get世帯コード().isEmpty();
                }
            }

}
