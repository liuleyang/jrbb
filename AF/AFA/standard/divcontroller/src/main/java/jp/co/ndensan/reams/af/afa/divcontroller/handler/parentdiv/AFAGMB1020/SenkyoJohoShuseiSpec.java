/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.SenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.dgSenkyoShusei_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙修正のSpecクラスです。
 *
 */
public enum SenkyoJohoShuseiSpec implements IPredicate<SenkyoJohoShuseiDiv> {

    /**
     * 選挙追加の選挙レベル必須チェック。
     *
     */
    選挙追加の選挙レベル必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptySenkyoLevel(div);
                }
            },
    /**
     * 選挙追加の選挙名必須チェック。
     *
     */
    選挙追加の選挙名必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptySenkyoName(div);
                }
            },
    /**
     * 選挙追加の選挙略称必須チェック。
     *
     */
    選挙追加の選挙略称必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptySenkyoRyakusho(div);
                }
            },
    /**
     * 選挙追加の選挙マーク必須チェック。
     *
     */
    選挙追加の選挙マーク必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptySenkyoMark(div);
                }
            },
    /**
     * 選挙追加の基準日必須チェック。
     *
     */
    選挙追加の基準日必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptyKijunYMD(div);
                }
            },
    /**
     * 選挙追加の受付開始日必須チェック。
     *
     */
    選挙追加の受付開始日必須チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptyUketsukeYMD(div);
                }
            },
    /**
     * 選挙追加の基準日と投票日関連チェックです。
     *
     */
    選挙追加の基準日と投票日関連チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotKijunGeqDateTohyo(div);
                }
            },
    /**
     * 選挙追加の基準日と投票日関連チェックです。
     *
     */
    選挙追加の基準日と受付開始日関連チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotKijunGeqDateUketsuke(div);
                }
            },
    /**
     * 選挙追加の基準日と投票日関連チェックです。
     *
     */
    選挙追加の受付開始日と投票日関連チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotUketsukeGeqDateTohyo(div);
                }
            },
    /**
     * 選挙追加の基準日と投票日関連チェックです。
     *
     */
    抄本名必須入力チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotInputShohonName(div);
                }
            },
    /**
     * 選挙名必須入力チェックです。
     *
     */
    選挙名必須入力チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotInputSenkyoName(div);
                }
            },
    /**
     * 選挙略称必須入力チェックです。
     *
     */
    選挙略称必須入力チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotInputSenkyoRyakusho(div);
                }
            },
    /**
     * 選挙マーク入力チェックです。
     *
     */
    選挙マーク必須入力チェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotInputSenkyoMark(div);
                }
            },
    /**
     * 選挙マーク入力チェックです。
     *
     */
    最大登録選挙数のチェック {
                @Override
                public boolean apply(SenkyoJohoShuseiDiv div) {
                    return SpecHelper.isNotInputJyuSenkyo(div);
                }
            };

    private static class SpecHelper {

        private static final int 最大登録選挙数 = 9;

        public static boolean isNotEmptySenkyoLevel(SenkyoJohoShuseiDiv div) {
            return !RString.isNullOrEmpty(div.getSenkyoInput().getDdlSenkyoLevel().getSelectedKey());
        }

        public static boolean isNotEmptySenkyoName(SenkyoJohoShuseiDiv div) {
            return !RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoName().getValue());
        }

        public static boolean isNotEmptySenkyoRyakusho(SenkyoJohoShuseiDiv div) {
            return !RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoRyakusho().getValue());
        }

        public static boolean isNotEmptySenkyoMark(SenkyoJohoShuseiDiv div) {
            return !RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoMark().getValue());
        }

        public static boolean isNotEmptyKijunYMD(SenkyoJohoShuseiDiv div) {
            return null != div.getSenkyoInput().getTxtKijunYMD().getValue();
        }

        public static boolean isNotEmptyUketsukeYMD(SenkyoJohoShuseiDiv div) {
            return null != div.getSenkyoInput().getTxtUketsukeYMD().getValue();
        }

        public static boolean isNotKijunGeqDateTohyo(SenkyoJohoShuseiDiv div) {
            if (null == div.getSenkyoInput().getTxtKijunYMD().getValue()
                    || null == div.getCcdSenkyoShuseiShohon().getTxtTohyoYMD().getValue()) {
                return Boolean.TRUE;
            }
            return div.getSenkyoInput().getTxtKijunYMD().getValue().compareTo(
                    div.getCcdSenkyoShuseiShohon().getTxtTohyoYMD().getValue()) < 0;
        }

        public static boolean isNotKijunGeqDateUketsuke(SenkyoJohoShuseiDiv div) {
            if (null == div.getSenkyoInput().getTxtKijunYMD().getValue()
                    || null == div.getSenkyoInput().getTxtUketsukeYMD().getValue()) {
                return Boolean.TRUE;
            }
            return div.getSenkyoInput().getTxtKijunYMD().getValue().compareTo(
                    div.getSenkyoInput().getTxtUketsukeYMD().getValue()) < 0;
        }

        public static boolean isNotUketsukeGeqDateTohyo(SenkyoJohoShuseiDiv div) {
            if (null == div.getSenkyoInput().getTxtUketsukeYMD().getValue()
                    || null == div.getCcdSenkyoShuseiShohon().getTxtTohyoYMD().getValue()) {
                return Boolean.TRUE;
            }
            return div.getSenkyoInput().getTxtUketsukeYMD().getValue().compareTo(
                    div.getCcdSenkyoShuseiShohon().getTxtTohyoYMD().getValue()) < 0;
        }

        public static boolean isNotInputShohonName(SenkyoJohoShuseiDiv div) {
            return !RString.isNullOrEmpty(div.getCcdSenkyoShuseiShohon().getTxtShohonName().getValue());
        }

        public static boolean isNotInputSenkyoName(SenkyoJohoShuseiDiv div) {
            List<dgSenkyoShusei_Row> listRows = div.getSenkyoShusei().getDgSenkyoShusei().getDataSource();
            Boolean chkFlg = Boolean.TRUE;
            for (dgSenkyoShusei_Row row : listRows) {
                if (RString.isNullOrEmpty(row.getTxtSenkyoName().getValue())) {
                    chkFlg = Boolean.FALSE;
                    break;
                }
            }
            return chkFlg;
        }

        public static boolean isNotInputSenkyoRyakusho(SenkyoJohoShuseiDiv div) {
            List<dgSenkyoShusei_Row> listRows = div.getSenkyoShusei().getDgSenkyoShusei().getDataSource();
            Boolean chkFlg = Boolean.TRUE;
            for (dgSenkyoShusei_Row row : listRows) {
                if (RString.isNullOrEmpty(row.getTxtSenkyoRyakusho().getValue())) {
                    chkFlg = Boolean.FALSE;
                    break;
                }
            }
            return chkFlg;
        }

        public static boolean isNotInputSenkyoMark(SenkyoJohoShuseiDiv div) {
            List<dgSenkyoShusei_Row> listRows = div.getSenkyoShusei().getDgSenkyoShusei().getDataSource();
            Boolean chkFlg = Boolean.TRUE;
            for (dgSenkyoShusei_Row row : listRows) {
                if (RString.isNullOrEmpty(row.getTxtSenkyoMark().getValue())) {
                    chkFlg = Boolean.FALSE;
                    break;
                }
            }
            return chkFlg;
        }

        public static boolean isNotInputJyuSenkyo(SenkyoJohoShuseiDiv div) {
            return div.getSenkyoShusei().getDgSenkyoShusei().getDataSource().size() < 最大登録選挙数;
        }
    }
}
