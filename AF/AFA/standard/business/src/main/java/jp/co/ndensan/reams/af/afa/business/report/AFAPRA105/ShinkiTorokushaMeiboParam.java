/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新規登録者名簿のパラメータクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinkiTorokushaMeiboParam {

    private final TorokushaMeiboEntity entity;
    private final RString 帳票ID;
    private final RString 事由コード;
    private final RString 集計情報;
    private final Boolean is空白行;

    /**
     * コンストラクタです。
     *
     * @param entity TorokushaMeiboEntity
     * @param 帳票ID RString
     * @param 事由コード RString
     * @param 集計情報 RString
     * @param is空白行 boolean
     */
    public ShinkiTorokushaMeiboParam(TorokushaMeiboEntity entity, RString 帳票ID, RString 事由コード, RString 集計情報, boolean is空白行) {
        this.entity = entity;
        this.帳票ID = 帳票ID;
        this.事由コード = 事由コード;
        this.集計情報 = 集計情報;
        this.is空白行 = is空白行;
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
         * @param entity TorokushaMeiboEntity
         * @param 事由コード RString
         * @param is集計を行う boolean
         *
         * @return List<ShinkiTorokushaMeiboParam>
         */
        public ShinkiTorokushaMeiboParam addData(TorokushaMeiboEntity entity, RString 事由コード, boolean is集計を行う) {
            ShinkiTorokushaMeiboParam param = null;
            if (!is集計を行う) {

                集計.add(ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()));
                param = new ShinkiTorokushaMeiboParam(entity, 帳票ID, 事由コード, RString.EMPTY, false);
            } else {
                param = new ShinkiTorokushaMeiboParam(entity, 帳票ID, 事由コード, 集計.toRString(事由コード), false);
                集計.resetCount();
            }
            return param;

        }

    }

}
