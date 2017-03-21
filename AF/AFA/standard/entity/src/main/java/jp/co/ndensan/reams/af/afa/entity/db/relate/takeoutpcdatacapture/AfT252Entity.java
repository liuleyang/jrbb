/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者入力共有子div用エンティティクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
@lombok.Getter
@lombok.Setter
public class AfT252Entity implements Cloneable, Serializable {

    private RString tohyokuCode;

    private Code dataCreateKubun;

    private YMDHMS dataCreateYMD;

    private Code systemSendKubun;

    private YMDHMS systemSendYMD;

    private Code dataSendKubun;

    private YMDHMS dataSendYMD;

    private Code dataImportKubun;

    private YMDHMS dataImportYMD;

    private RString tohyokuName;

    private RString tohyojoName;

    private FlexibleDate tohyoYMD;

}
