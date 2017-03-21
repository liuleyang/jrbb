/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.shisetsucodeselect;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShisetsuCodeSelectとShisetsuSelectDialog間連携用モデルです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuCodeSelectModel implements Serializable {

    private RString 施設コード;
    private boolean 本庁支所区分;
    private boolean isUsing施設種別;
    private RString 施設名称;
    private RString 施設カナ名称;
    private RString 施設種別コード;

}
