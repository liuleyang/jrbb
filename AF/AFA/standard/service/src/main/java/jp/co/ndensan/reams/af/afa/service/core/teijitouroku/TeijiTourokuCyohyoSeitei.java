/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.teijitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録_帳票の条件を設定する戻り値
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuCyohyoSeitei {

    private FlexibleDate 転入期間From;

    private FlexibleDate 転入期間To;

    private FlexibleDate 転出期間From;

    private FlexibleDate 転出期間To;

    private FlexibleDate 帰化期間From;

    private FlexibleDate 帰化期間To;
}
