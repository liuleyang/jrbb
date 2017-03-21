/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区情報です。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SenkyokuJoho implements Serializable {

    private RString 選挙種類;
    private RString 選挙区コード;
    private RString 選挙区名;
    private RString 登録端末数;
    private AfT503SenkyokuEntity 選挙区Entity;

}
