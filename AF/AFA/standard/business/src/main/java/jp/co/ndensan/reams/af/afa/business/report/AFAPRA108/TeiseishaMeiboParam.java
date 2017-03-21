/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA108;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran.SyukeiJyouhou;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeiseishaMeiboEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 訂正者名簿のパラメータクラスです。
 *
 * @reamsid_L AF-0010-042 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class TeiseishaMeiboParam {

    private final boolean isEmpty;
    private final boolean is合計行;
    private final RString 合計行;

    private final TeiseishaMeiboEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param entity {@link TeiseishaMeiboEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    private TeiseishaMeiboParam(TeiseishaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
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
     * @param param {@link TeiseishaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    private TeiseishaMeiboParam(RString 合計行, TeiseishaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = true;
        this.合計行 = 合計行;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * コンストラクタです。
     *
     * @param param {@link TeiseishaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    private TeiseishaMeiboParam(TeiseishaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = true;
        this.is合計行 = false;
        this.合計行 = RString.EMPTY;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 訂正者名簿のパラメータbuilderクラスです。
     *
     */
    public static class TeiseishaMeiboParamBuilder {

        private final TeijiCommonJohoItem 帳票共通ヘッダー;
        private TeiseishaMeiboParam lastParam;
        private SyukeiJyouhou 集計情報;
        private final IdouSenkyoninIchiran idouSenkyoninIchiran;

        /**
         * コンストラクタです。
         *
         * @param 帳票共通ヘッダー TeijiCommonJohoItem
         */
        public TeiseishaMeiboParamBuilder(TeijiCommonJohoItem 帳票共通ヘッダー) {
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
        public List<TeiseishaMeiboParam> addData(TeiseishaMeiboEntity entity) {

            List<TeiseishaMeiboParam> rslt = new ArrayList<>();

            if (lastParam == null) {
                集計情報 = idouSenkyoninIchiran.get集計情報(ReportIdKeys.訂正者名簿.value(), get事由コード(entity));

            } else if (!lastParam.getEntity().is同じサブタイトル(entity)) {
                rslt.add(new TeiseishaMeiboParam(集計情報.toRString(), lastParam, 帳票共通ヘッダー));
                集計情報 = idouSenkyoninIchiran.get集計情報(ReportIdKeys.訂正者名簿.value(), get事由コード(entity));
            } else if (!lastParam.getEntity().is同じ投票区(entity)) {
                rslt.add(new TeiseishaMeiboParam(lastParam, 帳票共通ヘッダー));
            }
            lastParam = new TeiseishaMeiboParam(entity, 帳票共通ヘッダー);
            rslt.add(lastParam);
            集計情報.add(ShikibetsuTaishoFactory.createKojin(entity.getAfterUaft200()));
            return rslt;
        }

        /**
         * 最終の合計処理です。
         *
         * @return TeiseishaMeiboParam
         */
        public TeiseishaMeiboParam lastSum() {
            return lastParam == null ? null : new TeiseishaMeiboParam(集計情報.toRString(), lastParam, 帳票共通ヘッダー);
        }

        private RString get事由コード(TeiseishaMeiboEntity entity) {
            return entity.isIdoJiyuCodeIsTenKyo() ? JiyuCode.転居.getKey() : JiyuCode.訂正.getKey();
        }

    }

}
