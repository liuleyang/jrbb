/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 投票資格検索条件のチェッククラスです。
 *
 * @reamsid_L AF-0180-011 liuyj
 */
public enum SearchShikakuSpec implements IPredicate<SearchShikakuDiv> {

    名簿登録日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getToText()) > 0);
                }
            },
    登録停止日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getToText()) > 0);
                }
            },
    抹消日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getToText()) > 0);
                }
            },
    表示日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getToText()) > 0);
                }
            },
    消除予定日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getToText()) > 0);
                }
            },
    表示消除日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchShojoYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchShojoYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchShojoYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchShojoYMD().getToText()) > 0);
                }
            },
    刑期終了日大小関係チェック {
                @Override
                public boolean apply(SearchShikakuDiv div) {
                    if (div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getFromText() == null
                    || div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getToText() == null) {
                        return true;
                    }
                    return !(div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getFromText().
                    compareTo(div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getToText()) > 0);
                }
            };

}
