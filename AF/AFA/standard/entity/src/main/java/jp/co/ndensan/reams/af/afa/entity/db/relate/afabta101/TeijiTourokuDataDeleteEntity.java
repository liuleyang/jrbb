/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録データ削除Entityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuDataDeleteEntity {

    private int type;
    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT121ZaigaiSenkyoninMeiboEntity zaigaiSenkyoninMeiboEntity;

}
