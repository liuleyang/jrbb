/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AtenaHenshuSeal;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.dgNyujokenTohyokuSelect_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（一括）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public enum NyujokenSakuseiIkkatsuSpec implements IPredicate<NyujokenSakuseiIkkatsuDiv> {

    /**
     * 出力対象のチェックをチェックします。
     */
    出力対象のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean is印刷タイプ = true;
                    List<RString> 出力対象リスト = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho().getSelectedKeys();
                    if (出力対象リスト.isEmpty()) {
                        is印刷タイプ = false;
                    }
                    return is印刷タイプ;
                }
            },
    /**
     * 印刷タイプのチェックをチェックします。
     */
    印刷タイプのチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean is印刷タイプ = true;
                    RString 印刷タイプ = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().
                    getTxtNyujokenType().getValue();
                    if (印刷タイプ.isNullOrEmpty()) {
                        is印刷タイプ = false;
                    }
                    return is印刷タイプ;
                }
            },
    /**
     * 世帯印字人数のチェックをチェックします。
     */
    世帯印字人数のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean is世帯印字人数 = true;
                    Decimal 世帯印字人数 = div.getNyujokenSakuseiTaisho().getNyujokenSentaku()
                    .getTxtPrintNinzutxtNyujokenType().getValue();

                    if (世帯印字人数 == null) {
                        is世帯印字人数 = false;
                    }

                    return is世帯印字人数;
                }
            },
    /**
     * 投票区一覧のチェックをチェックします。
     */
    投票区一覧のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean is選挙人一覧 = true;
                    List<dgNyujokenTohyokuSelect_Row> row = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getDgNyujokenTohyokuSelect()
                    .getSelectedItems();

                    if (row.isEmpty()) {
                        is選挙人一覧 = false;
                    }
                    return is選挙人一覧;
                }
            },
    /**
     * 転出日Fromのチェックをチェックします。
     */
    転出日Fromのチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 転出日From = true;

                    if (BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体).equals(AtenaHenshuSeal.フリガナと本人.getKey())) {
                        RDate 転出日 = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                        .getTxtTenshutsuYMDRange().getFromValue();

                        if (null == 転出日) {
                            転出日From = false;
                        }
                    }
                    return 転出日From;
                }
            },
    /**
     * 転出日Toのチェックをチェックします。
     */
    転出日Toのチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 転出日To = true;
                    if (BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体).equals(AtenaHenshuSeal.フリガナと本人.getKey())) {
                        RDate 転出日 = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                        .getTxtTenshutsuYMDRange().getToValue();

                        if (null == 転出日) {
                            転出日To = false;
                        }
                    }
                    return 転出日To;
                }
            },
    /**
     * 転出日Toのチェックをチェックします。
     */
    転出日Fromと転出日Toのチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 転出日 = true;
                    RDate 転出日From = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                    .getTxtTenshutsuYMDRange().getFromValue();
                    RDate 転出日To = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                    .getTxtTenshutsuYMDRange().getToValue();

                    if (null != 転出日From && null != 転出日To && 転出日To.isBefore(転出日From)) {
                        転出日 = false;
                    }
                    return 転出日;
                }
            },
    /**
     * 転出日From不正をチェックします。
     */
    転出日From不正のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 転出日 = true;
                    RDate 転出日FromHidden = null;
                    if (!div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getHidden転出日From().isNullOrEmpty()) {
                        転出日FromHidden = new RDate(div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getHidden転出日From().toString());
                    }
                    RDate 転出日From = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                    .getTxtTenshutsuYMDRange().getFromValue();

                    if (null != 転出日FromHidden && null != 転出日From && 転出日From.isBefore(転出日FromHidden)) {
                        転出日 = false;
                    }
                    return 転出日;
                }
            },
    /**
     * 転出日From不正をチェックします。
     */
    転出日To不正のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 転出日Flag = true;
                    RDate 転出日ToHidden = null;
                    if (null != div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getHidden転出日To()) {
                        転出日ToHidden = new RDate(div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getHidden転出日To().toString());
                    }
                    RDate 転出日To = div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki()
                    .getTxtTenshutsuYMDRange().getToValue();

                    if (null != 転出日ToHidden && null != 転出日To && !転出日To.isBeforeOrEquals(転出日ToHidden)) {
                        転出日Flag = false;
                    }
                    return 転出日Flag;
                }
            },
    /**
     * 抽出対象世帯人数をチェックします。
     */
    抽出対象世帯人数のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    boolean 抽出対象 = true;
                    List<RString> 世帯で複数リスト = div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkSetaiIchiran().getSelectedKeys();
                    if (世帯で複数リスト.contains(AtenaHenshuSeal.本人.getKey())) {
                        Decimal 抽出対象世帯人数 = div.getNyujokenSakuseiTaisho().getNyujokenSentaku()
                        .getTxtPrintNinzutxtNyujokenType().getValue();

                        if (null == 抽出対象世帯人数) {
                            抽出対象 = false;
                        }
                    }
                    return 抽出対象;
                }
            },
    /**
     * 選挙バッチ実行確認のチェックをチェックします。
     */
    選挙バッチ実行確認のチェック {
                @Override
                public boolean apply(NyujokenSakuseiIkkatsuDiv div) {
                    return false;
                }
            }
}
