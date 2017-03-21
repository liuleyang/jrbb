/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinkiTorokushaMeiboKaikuParam {

    private SenkyojiKaikuEntity entity;
    private RString 帳票ID;
    private RString 事由コード;
    private RString 集計情報;
    private Boolean is空白行;
    private RString key;

    /**
     * コンストラクタです。
     *
     * @param entity TorokushaMeibo
     * @param 帳票ID RString
     * @param 事由コード RString
     * @param 集計情報 RString
     * @param is空白行 boolean
     * @param key RString
     */
    public ShinkiTorokushaMeiboKaikuParam(SenkyojiKaikuEntity entity, RString 帳票ID, RString 事由コード, RString 集計情報, boolean is空白行, RString key) {
        this.entity = entity;
        this.帳票ID = 帳票ID;
        this.事由コード = 事由コード;
        this.集計情報 = 集計情報;
        this.is空白行 = is空白行;
        this.key = key;
    }

    /**
     * 新規登録者名簿のパラメータBuilderクラスです。
     */
    public static class ShinkiTorokushaMeiboParamBuilder {

        private final RString 帳票ID;
        private final IdouSenkyoninIchiran.SyukeiJyouhou 集計;

        /**
         * コンストラクタです。
         *
         * @param 帳票ID RString
         */
        public ShinkiTorokushaMeiboParamBuilder(RString 帳票ID) {
            this.帳票ID = 帳票ID;
            集計 = new IdouSenkyoninIchiran.SyukeiJyouhou(帳票ID, RString.EMPTY);
        }

        /**
         * 検索データを追加します。
         *
         * @param entity TorokushaMeibo
         * @param 事由コード RString
         * @param is集計を行う boolean
         * @param key RString
         *
         * @return List<ShinkiTorokushaMeiboParam>
         */
        public ShinkiTorokushaMeiboKaikuParam addData(SenkyojiKaikuEntity entity, RString 事由コード, boolean is集計を行う, RString key) {
            ShinkiTorokushaMeiboKaikuParam param = null;
            if (!is集計を行う) {
                集計.add(ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()));
                param = new ShinkiTorokushaMeiboKaikuParam(entity, 帳票ID, 事由コード, RString.EMPTY, false, key);
            } else {
                param = new ShinkiTorokushaMeiboKaikuParam(entity, 帳票ID, 事由コード, 集計.toRString(事由コード), false, key);
                集計.resetCount();
            }
            return param;

        }
    }
}
