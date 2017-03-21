/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.dgNyujokenKobetsuTaishosha_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 入場券発行（個別）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public enum NyujokenSakuseiKobetsuSpec implements IPredicate<NyujokenSakuseiKobetsuDiv> {

    /**
     * 印刷タイプのチェックをチェックします。
     */
    印刷タイプのチェック {
                @Override
                public boolean apply(NyujokenSakuseiKobetsuDiv div) {
                    boolean is印刷タイプ = true;
                    RString 印刷タイプ = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().
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
                public boolean apply(NyujokenSakuseiKobetsuDiv div) {
                    boolean is世帯印字人数 = true;
                    Decimal 世帯印字人数 = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku()
                    .getTxtPrintNinzutxtNyujokenType().getValue();

                    if (世帯印字人数 == null) {
                        is世帯印字人数 = false;
                    }

                    return is世帯印字人数;
                }
            },
    /**
     * 世帯印字人数のチェックをチェックします。
     */
    選挙人一覧のチェック {
                @Override
                public boolean apply(NyujokenSakuseiKobetsuDiv div) {
                    boolean is選挙人一覧 = true;
                    List<dgNyujokenKobetsuTaishosha_Row> row = div.getNyujokenKobetsuSakuseiTaisho()
                    .getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource();

                    if (row.isEmpty()) {
                        is選挙人一覧 = false;
                    }
                    return is選挙人一覧;
                }
            },
    /**
     * 同一世帯の人が複数選択のチェックをチェックします。
     */
    同一世帯の人が複数選択のチェック {
                @Override
                public boolean apply(NyujokenSakuseiKobetsuDiv div) {
                    boolean 同一世帯あり = false;
                    boolean is対象者を個々に作成 = true;
                    boolean 同一世帯無し = true;
                    List<dgNyujokenKobetsuTaishosha_Row> row = div.getNyujokenKobetsuSakuseiTaisho()
                    .getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource();
                    if (row.size() == 1) {
                        return 同一世帯無し;
                    }
                    RString selectedKey = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getRadHakkoTani().getSelectedKey();
                    if (!selectedKey.equals(new RString("key1"))) {
                        return is対象者を個々に作成;
                    }
                    if (row.size() > 1 && selectedKey.equals(new RString("key1"))) {
                        for (int i = 0; i < row.size(); i++) {
                            RString 世帯コード = row.get(i).getTxtSetaiCode();
                            for (int j = i + 1; j < row.size(); j++) {
                                RString 世帯コード1 = row.get(j).getTxtSetaiCode();
                                if (世帯コード.equals(世帯コード1)) {
                                    return 同一世帯あり;
                                }
                            }
                        }
                    }
                    return 同一世帯無し;
                }
            },
    /**
     * 選挙バッチ実行確認のチェックをチェックします。
     */
    選挙バッチ実行確認のチェック {
                @Override
                public boolean apply(NyujokenSakuseiKobetsuDiv div) {
                    return false;
                }
            }
}
