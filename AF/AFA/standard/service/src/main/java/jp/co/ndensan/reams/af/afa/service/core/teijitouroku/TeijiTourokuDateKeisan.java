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
 * 定時登録_日付を自動計算するの戻り値
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuDateKeisan {

    private FlexibleDate 登録日;

    private FlexibleDate 転出期限日;

    private FlexibleDate 転入期限日;

    private FlexibleDate 年齢期限日;

    private FlexibleDate 告示公示日;
}
