/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙人集計の集計条件クラス
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SyukeiJyouken {

    private RString 選挙別;
    private RString 投票区別;
    private RString 住所別;
    private RString 行政区別;
    private RString 地区1別;
    private RString 地区2別;
    private RString 地区3別;
    private RString 男女別;
    private RString 年齢別;
    private RString 年代別;

}
