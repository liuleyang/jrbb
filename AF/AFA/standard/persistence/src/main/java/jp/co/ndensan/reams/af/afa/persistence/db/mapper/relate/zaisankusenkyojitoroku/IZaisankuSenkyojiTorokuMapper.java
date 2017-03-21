/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaisankusenkyojitoroku;

import jp.co.ndensan.reams.af.afa.definition.mybatis.param.zaisankusenkyojitoroku.ZaisankuSenkyojiTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.ZaisankuSenkyojiTorokuEntity;

/**
 * 財産区議会議員選挙時登録のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public interface IZaisankuSenkyojiTorokuMapper {

    /**
     * 選挙情報を取得します。
     *
     * @param param ZaisankuSenkyojiTorokuParameter
     * @return 選挙情報 ZaisankuSenkyojiTorokuEntity
     */
    ZaisankuSenkyojiTorokuEntity select選挙情報(ZaisankuSenkyojiTorokuParameter param);

}
