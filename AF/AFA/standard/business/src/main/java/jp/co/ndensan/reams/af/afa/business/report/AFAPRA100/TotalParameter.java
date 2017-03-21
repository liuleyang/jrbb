/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙人名簿抄本関係のパラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TotalParameter {

    private RString 出力順;
    private int maleCount;
    private int feMaleCount;
    private int totalCount;
}
