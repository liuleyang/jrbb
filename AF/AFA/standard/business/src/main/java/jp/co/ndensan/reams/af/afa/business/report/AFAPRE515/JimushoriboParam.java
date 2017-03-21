package jp.co.ndensan.reams.af.afa.business.report.AFAPRE515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿のパラメータクラスです。
 *
 * @reamsid_L AF-0280-032 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JimushoriboParam {

    private static final RString 名簿番号_SEPARATOR = new RString("-");
    private static final int 投票区コード_LENGTH = 4;
    private static final int 冊_LENGTH = 3;
    private static final int 頁_LENGTH = 6;
    private static final int 行_LENGTH = 2;

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
    private final boolean is期日前投票;

    private final SenkyoNo 選挙番号;
    private final RString 選挙名称;
    private final int 連番;
    private final RString 氏名;
    private final Gender 性別;

    private final RString 投票区名;
    private final RString 行政区;
    private final RString 名簿番号;

    private final AfT201TohyoJokyoEntity 投票状況;
    private final RString 施設名称;

    private boolean is合計;
    private Decimal 合計人数男;
    private Decimal 合計人数女;
    private Decimal 合計人数計;

    private JimushoriboParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            boolean is期日前投票,
            AfT111SenkyoEntity 選挙,
            int 連番,
            RString 氏名,
            Gender 性別,
            RString 投票区名,
            RString 行政区,
            boolean is抄本冊区分管理使用しない,
            AfT112SenkyoninMeiboEntity 選挙人名簿情報,
            AfT201TohyoJokyoEntity 投票状況,
            AfT507ShisetsuEntity 施設) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.is期日前投票 = is期日前投票;
        this.選挙番号 = 選挙.getSenkyoNo();
        this.選挙名称 = 選挙.getSenkyoName();
        this.連番 = 連番;
        this.氏名 = 氏名;
        this.性別 = 性別;
        this.投票区名 = 投票区名;
        this.行政区 = 行政区;
        RStringBuilder builder = new RStringBuilder();
        builder.append(選挙人名簿情報.getTohyokuCode().padLeft(RString.HALF_SPACE, 投票区コード_LENGTH));
        if (!is抄本冊区分管理使用しない) {
            builder.append(名簿番号_SEPARATOR);
            builder.append(選挙人名簿情報.getSatsu().padLeft(RString.HALF_SPACE, 冊_LENGTH));
        }
        builder.append(名簿番号_SEPARATOR);
        builder.append(new RString(String.valueOf(選挙人名簿情報.getPage())).padLeft(RString.HALF_SPACE, 頁_LENGTH));
        builder.append(名簿番号_SEPARATOR);
        builder.append(new RString(String.valueOf(選挙人名簿情報.getGyo())).padLeft(RString.HALF_SPACE, 行_LENGTH));

        this.名簿番号 = builder.toRString();
        this.投票状況 = 投票状況;
        Code 投票状況Code = 投票状況.getTohyoJokyo();
        this.施設名称 = 施設 == null
                || 投票状況Code == null
                || !Arrays.asList(TohyoJokyo.受理.getCode(),
                        TohyoJokyo.期日前.getCode()).contains(投票状況Code.getColumnValue()) ? RString.EMPTY : 施設.getShisetsuName();

        is合計 = false;
    }

    /**
     * 合計を設定します。
     *
     * @param 合計人数男 Decimal
     * @param 合計人数女 Decimal
     * @param 合計人数計 Decimal
     */
    protected void set合計(Decimal 合計人数男, Decimal 合計人数女, Decimal 合計人数計) {
        is合計 = true;
        this.合計人数男 = 合計人数男;
        this.合計人数女 = 合計人数女;
        this.合計人数計 = 合計人数計;
    }

    /**
     * 帳票AFAPRE515_Jimushoribo_事務処理簿のパラメータbuilderクラスです。
     *
     */
    public static class JimushoriboParamBuilder {

        private static final int ONE_PAGE_COUNT = 10;

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
        private final boolean is期日前投票;
        private final boolean is抄本冊区分管理使用しない;

        private List<JimushoriboParam> paramList;
        private Decimal 合計人数男;
        private Decimal 合計人数女;
        private Decimal 合計人数計;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         * @param is期日前投票 boolean
         */
        public JimushoriboParamBuilder(ZenjitsuCommonJohoItem 選挙帳票共通情報, boolean is期日前投票) {

            this.選挙帳票共通情報 = 選挙帳票共通情報;
            this.is期日前投票 = is期日前投票;
            RString 抄本冊区分管理 = BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体);
            is抄本冊区分管理使用しない = 抄本_冊区分管理_使用しない.getValue().equals(抄本冊区分管理);

            initList();
        }

        /**
         * 検索データを追加します。
         *
         * @param 選挙 AfT111SenkyoEntity
         * @param 氏名 RString
         * @param 性別 Gender
         * @param 投票区名 RString
         * @param 行政区 RString
         * @param 選挙人名簿情報 AfT112SenkyoninMeiboEntity
         * @param 施設 AfT507ShisetsuEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         */
        public void addData(AfT111SenkyoEntity 選挙,
                RString 氏名,
                Gender 性別,
                RString 投票区名,
                RString 行政区,
                AfT112SenkyoninMeiboEntity 選挙人名簿情報,
                AfT201TohyoJokyoEntity 投票状況,
                AfT507ShisetsuEntity 施設) {

            Code 投票状況Code = 投票状況.getTohyoJokyo();
            if (投票状況Code == null
                    || (is期日前投票 && !TohyoJokyo.期日前.getCode().equals(投票状況Code.getColumnValue()))
                    || (!is期日前投票 && !Arrays.asList(TohyoJokyo.交付.getCode(),
                            TohyoJokyo.受理.getCode(),
                            TohyoJokyo.返還.getCode()).contains(投票状況Code.getColumnValue()))) {
                return;
            }
            paramList.add(new JimushoriboParam(選挙帳票共通情報,
                    is期日前投票,
                    選挙,
                    paramList.size() + 1,
                    氏名,
                    性別,
                    投票区名,
                    行政区,
                    is抄本冊区分管理使用しない,
                    選挙人名簿情報,
                    投票状況,
                    施設));

            switch (性別) {
                case FEMALE:
                    合計人数女 = 合計人数女.add(Decimal.ONE);
                    合計人数計 = 合計人数計.add(Decimal.ONE);
                    break;
                case MALE:
                    合計人数男 = 合計人数男.add(Decimal.ONE);
                    合計人数計 = 合計人数計.add(Decimal.ONE);
                    break;
                default:
            }
        }

        private void initList() {
            paramList = new ArrayList<>();
            合計人数男 = Decimal.ZERO;
            合計人数女 = Decimal.ZERO;
            合計人数計 = Decimal.ZERO;
        }

        /**
         * 合計の処理です。
         *
         * @return List<DairiTohyoShukeihyoParam>
         */
        public List<JimushoriboParam> 合計() {
            if (paramList == null || this.paramList.isEmpty()) {
                return new ArrayList<>();
            }

            paramList.get(paramList.size() - 1).set合計(合計人数男, 合計人数女, 合計人数計);
            List<JimushoriboParam> 合計 = paramList;
            initList();
            return 合計;
        }
    }
}
