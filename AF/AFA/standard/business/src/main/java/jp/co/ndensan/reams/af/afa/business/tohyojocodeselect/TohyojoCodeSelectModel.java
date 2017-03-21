/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyojocodeselect;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TohyojoCodeSelectとTohyojoCodeSelectDialog間連携用モデルです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyojoCodeSelectModel implements Serializable {

    private RString 投票区コード;
    private RString 投票区名称;

}
