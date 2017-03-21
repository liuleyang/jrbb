/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;

/**
 * 財産区議会議員選挙時登録用Entityクラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ZaisankuSenkyojiTorokuEntity {

    private AfT100ShohonEntity aft100Entity;
    private AfT111SenkyoEntity aft111Entity;
    private AfT141ZaisankuJuminTohyoConditionEntity aft141Entity;
}
