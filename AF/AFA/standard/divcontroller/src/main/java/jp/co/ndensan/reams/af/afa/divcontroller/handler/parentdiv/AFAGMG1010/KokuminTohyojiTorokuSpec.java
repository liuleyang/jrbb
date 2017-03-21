/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.dgKokuminTohyojiNyuryoku_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票時登録のSpecクラスです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public enum KokuminTohyojiTorokuSpec implements IPredicate<KokuminTohyojiTorokuDiv> {

    /**
     * 改正案一覧の必須入力チェック
     */
    新規の時改正案一覧グリッドに1件も明細に入力がない場合 {
                @Override
                public boolean apply(KokuminTohyojiTorokuDiv div) {
                    return KokuminTohyojiTorokuSpec.SpeckHelper.新規の時改正案一覧グリッドに1件も明細に入力がない場合(div);
                }
            },
    /**
     * 改正案一覧の改正案と略称の両方必須入力チェック
     */
    改正案一覧グリッドに改正案と略称は片方のみの入力場合 {
                @Override
                public boolean apply(KokuminTohyojiTorokuDiv div) {
                    return KokuminTohyojiTorokuSpec.SpeckHelper.改正案一覧グリッドに改正案と略称は片方のみの入力場合(div);
                }
            },
    /**
     * 実データ※の必須入力チェック
     */
    改正案と略称の両方が空白かつ実データ {
                @Override
                public boolean apply(KokuminTohyojiTorokuDiv div) {
                    return KokuminTohyojiTorokuSpec.SpeckHelper.改正案と略称の両方が空白かつ実データ(div);
                }
            },
    /**
     * 選挙バッチ実行確認のチェックをチェックします。
     */
    選挙バッチ実行確認のチェック {
                @Override
                public boolean apply(KokuminTohyojiTorokuDiv div) {
                    return false;
                }
            };

    private static class SpeckHelper {

        static boolean 新規の時改正案一覧グリッドに1件も明細に入力がない場合(KokuminTohyojiTorokuDiv div) {
            if (ShoriShubetsu.新規登録.getShoriShubetsu().equals(div.getCcdKokuminTohyojiMeiboKijun().getShoriMode())) {
                return !div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource().isEmpty();
            }
            return true;
        }

        static boolean 改正案一覧グリッドに改正案と略称は片方のみの入力場合(KokuminTohyojiTorokuDiv div) {
            for (dgKokuminTohyojiNyuryoku_Row row : div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource()) {
                if (RString.isNullOrEmpty(row.getTxtKaiseianName().getText()) || RString.isNullOrEmpty(row.getTxtRyakusho().getText())) {
                    return false;
                }
            }
            return true;
        }

        static boolean 改正案と略称の両方が空白かつ実データ(KokuminTohyojiTorokuDiv div) {
            if (ShoriShubetsu.再処理.getShoriShubetsu().equals(div.getCcdKokuminTohyojiMeiboKijun().getShoriMode())
                    && !div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource().isEmpty()) {
                for (dgKokuminTohyojiNyuryoku_Row row : div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource()) {
                    if (RString.isNullOrEmpty(row.getTxtKaiseianName().getText()) || RString.isNullOrEmpty(row.getTxtRyakusho().getText())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
