/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran.SyukeiJyouhou;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.KaikuTeiseishaMeiboEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TeiseishaMeiboKaikuParam {

    private boolean isEmpty;
    private boolean is合計行;
    private RString 合計行;

    private KaikuTeiseishaMeiboEntity entity;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param isEmpty boolean
     * @param is合計行 boolean
     * @param 合計行 RString
     * @param entity KaikuTeiseishaMeiboEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeiseishaMeiboKaikuParam(boolean isEmpty, boolean is合計行, RString 合計行,
            KaikuTeiseishaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = isEmpty;
        this.is合計行 = is合計行;
        this.合計行 = 合計行;
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     *
     * コンストラクタです。
     *
     * @param entity KaikuTeiseishaMeiboEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeiseishaMeiboKaikuParam(KaikuTeiseishaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = false;
        this.合計行 = RString.EMPTY;
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * コンストラクタです。
     *
     * @param 合計行 RString
     * @param entity KaikuTeiseishaMeiboEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeiseishaMeiboKaikuParam(RString 合計行, KaikuTeiseishaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = false;
        this.合計行 = 合計行;
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * コンストラクタです。
     *
     * @param 合計行 RString
     * @param param TeiseishaMeiboKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeiseishaMeiboKaikuParam(RString 合計行, TeiseishaMeiboKaikuParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = false;
        this.合計行 = 合計行;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * コンストラクタです。
     *
     * @param param TeiseishaMeiboKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeiseishaMeiboKaikuParam(TeiseishaMeiboKaikuParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = false;
        this.合計行 = RString.EMPTY;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 訂正者名簿のパラメータbuilderクラスです。
     *
     */
    public static class TeiseishaMeiboKaikuParamBuilder {

        private TeijiCommonJohoItem 帳票共通ヘッダー;
        private TeiseishaMeiboKaikuParam lastParam;
        private SyukeiJyouhou 集計情報;
        private IdouSenkyoninIchiran idouSenkyoninIchiran;

        /**
         * コンストラクタです。
         *
         * @param 帳票共通ヘッダー TeijiCommonJohoItemSenkyoku
         */
        public TeiseishaMeiboKaikuParamBuilder(TeijiCommonJohoItem 帳票共通ヘッダー) {
            this.帳票共通ヘッダー = 帳票共通ヘッダー;
            idouSenkyoninIchiran = new IdouSenkyoninIchiran();
            this.集計情報 = null;
        }

        /**
         * 検索データを追加します。
         *
         * @param entity AFAPRA103Entity
         * @return List<TeiseishaMeiboParam>
         */
        public List<TeiseishaMeiboKaikuParam> addData(KaikuTeiseishaMeiboEntity entity) {

            List<TeiseishaMeiboKaikuParam> rslt = new ArrayList<>();

            if (lastParam == null) {
                集計情報 = idouSenkyoninIchiran.get集計情報(ReportIdKeys.訂正者名簿海区.value(), get事由コード(entity));

            } else if (!lastParam.getEntity().is同じサブタイトル(entity)) {
                rslt.add(new TeiseishaMeiboKaikuParam(集計情報.toRString(), lastParam, 帳票共通ヘッダー));
                集計情報 = idouSenkyoninIchiran.get集計情報(ReportIdKeys.訂正者名簿.value(), get事由コード(entity));
            } else if (!lastParam.getEntity().is同じ投票区(entity)) {
                rslt.add(new TeiseishaMeiboKaikuParam(lastParam, 帳票共通ヘッダー));
            }
            lastParam = new TeiseishaMeiboKaikuParam(entity, 帳票共通ヘッダー);
            rslt.add(lastParam);
            集計情報.add(ShikibetsuTaishoFactory.createKojin(entity.getAfterUaft200()));
            return rslt;
        }

        /**
         * 最終の合計処理です。
         *
         * @return TeiseishaMeiboParam
         */
        public TeiseishaMeiboKaikuParam lastSum() {
            return lastParam == null ? null : new TeiseishaMeiboKaikuParam(集計情報.toRString(), lastParam, 帳票共通ヘッダー);
        }

        private RString get事由コード(KaikuTeiseishaMeiboEntity entity) {
            return entity.isIdoJiyuCodeIsTenKyo() ? JiyuCode.転居.getKey() : JiyuCode.訂正.getKey();
        }

    }
}
