/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokucodeselect;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区選択ダイアログ用モデルです。
 *
 * @reamsid_L AF-0070-015 qiuxy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyokuCodeSelectModel implements Serializable {

    private RString 選挙種類コード;
}
