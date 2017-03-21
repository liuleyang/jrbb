/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 定時登録のための条件クラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TeijiTourokuParameter {

    private final FlexibleDate kijunbi;

    private TeijiTourokuParameter(FlexibleDate kijunbi) {
        this.kijunbi = requireNonNull(kijunbi, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
    }

    /**
     * 基準日に一番近い過去の選挙.名簿基準年月日を取得するためのパラメータクラスを作成します。
     *
     * @param kijunbi 基準日
     * @return 定時登録パラメータクラス
     */
    public static TeijiTourokuParameter createTeijiTourokuParam(FlexibleDate kijunbi) {
        return new TeijiTourokuParameter(kijunbi);
    }
}
