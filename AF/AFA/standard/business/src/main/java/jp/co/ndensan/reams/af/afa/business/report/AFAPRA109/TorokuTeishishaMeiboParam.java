/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA109;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import lombok.Getter;

/**
 *
 * 登録停止者名簿のパラメータクラスです。
 *
 * @reamsid_L AF-0010-043 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class TorokuTeishishaMeiboParam {

    private final boolean isEmpty;
    private final boolean is合計行;
    private final RString 合計行;
    private final RString 作成日時;

    private final EikyuSenkyoninMeiboEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param entity {@link EikyuSenkyoninMeiboEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 作成日時 RString
     */
    public TorokuTeishishaMeiboParam(EikyuSenkyoninMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー, RString 作成日時) {
        this.isEmpty = false;
        this.is合計行 = false;
        this.合計行 = RString.EMPTY;
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.作成日時 = 作成日時;
    }

    /**
     * コンストラクタです。
     *
     * @param 合計行 RString
     * @param param {@link TorokuTeishishaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    private TorokuTeishishaMeiboParam(RString 合計行, TorokuTeishishaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = false;
        this.is合計行 = true;
        this.合計行 = 合計行;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.作成日時 = param.get作成日時();
    }

    /**
     * コンストラクタです。
     *
     * @param param {@link TorokuTeishishaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    private TorokuTeishishaMeiboParam(TorokuTeishishaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.isEmpty = true;
        this.is合計行 = false;
        this.合計行 = RString.EMPTY;
        this.entity = param.getEntity();
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.作成日時 = param.get作成日時();
    }

    /**
     * 同じ投票区を判断します。
     *
     * @param other EikyuSenkyoninMeiboEntity
     * @return 同じ投票区
     */
    public boolean is同じ投票区(EikyuSenkyoninMeiboEntity other) {
        return entity.getSenkyoninMeiboEntity().getTohyokuCode().equals(other.getSenkyoninMeiboEntity().getTohyokuCode());
    }

    /**
     * 登録停止者名簿のパラメータbuilderクラスです。
     *
     */
    public static class TorokuTeishishaMeiboParamBuilder {

        private static final RString 作成日時_TAIL = new RString("作成");

        private final TeijiCommonJohoItem 帳票共通ヘッダー;
        private TorokuTeishishaMeiboParam lastParam;
        private final IdouSenkyoninIchiran.SyukeiJyouhou 集計情報;
        private final IdouSenkyoninIchiran idouSenkyoninIchiran;
        private final RString 作成日時;
        private final FlexibleDate kijunbi;
        private final ShikakuHantei shikakuHantei;

        /**
         * コンストラクタです。
         *
         * @param 帳票共通ヘッダー TeijiCommonJohoItem
         * @param kijunbi FlexibleDate
         */
        public TorokuTeishishaMeiboParamBuilder(TeijiCommonJohoItem 帳票共通ヘッダー, FlexibleDate kijunbi) {
            this.帳票共通ヘッダー = 帳票共通ヘッダー;
            idouSenkyoninIchiran = new IdouSenkyoninIchiran();
            this.集計情報 = idouSenkyoninIchiran.get集計情報(ReportIdKeys.登録停止者名簿.value(), RString.EMPTY);

            RStringBuilder 作成日時Builder = new RStringBuilder();
            作成日時Builder.append(FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            作成日時Builder.append(RString.FULL_SPACE);
            作成日時Builder.append(RTime.now().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
            作成日時Builder.append(作成日時_TAIL);

            作成日時 = 作成日時Builder.toRString();
            this.kijunbi = kijunbi;
            shikakuHantei = new ShikakuHantei();
        }

        /**
         * 検索データを追加します。
         *
         * @param entity AFAPRA103Entity
         * @return List<TorokuTeishishaMeiboParam>
         */
        public List<TorokuTeishishaMeiboParam> addData(EikyuSenkyoninMeiboEntity entity) {

            List<TorokuTeishishaMeiboParam> rslt = new ArrayList<>();
            SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
            senkyoninTohyoJokyoEntity.setSenkyoShikakuEntity(entity.getSenkyoShikakuEntity());
            if (!shikakuHantei.is登録停止者(senkyoninTohyoJokyoEntity, kijunbi)) {
                return rslt;
            }

            if (lastParam != null && !lastParam.is同じ投票区(entity)) {
                rslt.add(new TorokuTeishishaMeiboParam(lastParam, 帳票共通ヘッダー));
            }
            lastParam = new TorokuTeishishaMeiboParam(entity, 帳票共通ヘッダー, 作成日時);
            rslt.add(lastParam);
            集計情報.add(ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()));
            return rslt;
        }

        /**
         * 最終の合計処理です。
         *
         * @return TorokuTeishishaMeiboParam
         */
        public List<TorokuTeishishaMeiboParam> lastSum() {
            List<TorokuTeishishaMeiboParam> rslt = new ArrayList<>();
            if (lastParam != null) {
                rslt.add(new TorokuTeishishaMeiboParam(lastParam, 帳票共通ヘッダー));
                rslt.add(new TorokuTeishishaMeiboParam(集計情報.toRString(), lastParam, 帳票共通ヘッダー));
            }
            return rslt;
        }
    }
}
