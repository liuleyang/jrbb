/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA103Entity;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 登録者数リストのパラメータクラスです。
 *
 * @reamsid_L AF-0010-037 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class TorokushasuListParam {

    private final RString 帳票タイトル;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 明細タイトル住所;

    private final RString 選挙名称;
    private final RString senkyoNo;
    private final RString sumType;
    private final RString tohyokuCode;
    private final RString 投票区コード;
    private final RString 集計地区名;

    private Decimal 有権者_男数;
    private Decimal 有権者_女数;
    private Decimal 表示者_男数;
    private Decimal 表示者_女数;
    private Decimal 公民権停止者_男数;
    private Decimal 公民権停止者_女数;

    private final FlexibleDate 名簿基準年月日;
    private final FlexibleDate 投票日;

    private TorokushasuListParam(TeijiCommonJohoItem 帳票共通ヘッダー,
            RString 明細タイトル住所,
            RString 選挙名称,
            RString senkyoNo,
            RString sumType,
            RString tohyokuCode,
            RString 投票区コード,
            RString 集計地区名,
            Decimal 有権者_男数,
            Decimal 有権者_女数,
            Decimal 表示者_男数,
            Decimal 表示者_女数,
            Decimal 公民権停止者_男数,
            Decimal 公民権停止者_女数,
            FlexibleDate 名簿基準年月日,
            FlexibleDate 投票日,
            RString 帳票タイトル) {
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.明細タイトル住所 = 明細タイトル住所;
        this.選挙名称 = 選挙名称;
        this.senkyoNo = senkyoNo;
        this.sumType = sumType;
        this.tohyokuCode = tohyokuCode;
        this.投票区コード = 投票区コード;
        this.集計地区名 = 集計地区名;
        this.有権者_男数 = 有権者_男数;
        this.有権者_女数 = 有権者_女数;
        this.表示者_男数 = 表示者_男数;
        this.表示者_女数 = 表示者_女数;
        this.公民権停止者_男数 = 公民権停止者_男数;
        this.公民権停止者_女数 = 公民権停止者_女数;
        this.名簿基準年月日 = 名簿基準年月日;
        this.投票日 = 投票日;
        this.帳票タイトル = 帳票タイトル;
    }

    private void add(TorokushasuListParam other) {
        this.有権者_男数 = this.有権者_男数.add(other.有権者_男数);
        this.有権者_女数 = this.有権者_女数.add(other.有権者_女数);
        this.表示者_男数 = this.表示者_男数.add(other.表示者_男数);
        this.表示者_女数 = this.表示者_女数.add(other.表示者_女数);
        this.公民権停止者_男数 = this.公民権停止者_男数.add(other.公民権停止者_男数);
        this.公民権停止者_女数 = this.公民権停止者_女数.add(other.公民権停止者_女数);

    }

    /**
     * 同じ合計を判断します。
     *
     * @param entity AFAPRA103Entity
     * @return 判断結果
     */
    protected boolean same合計(AFAPRA103Entity entity) {
        return this.senkyoNo.equals(entity.getSenkyoNo()) && this.sumType.equals(entity.getSumType());
    }

    /**
     * 投票区計を判断します。
     *
     * @param entity AFAPRA103Entity
     * @return 判断結果
     */
    protected boolean same投票区計(AFAPRA103Entity entity) {
        return this.tohyokuCode.equals(entity.getTohyokuCode());
    }

    /**
     * 登録者数リストのパラメータbuilderクラスです。
     *
     */
    public static class TorokushasuListParamBuilder {

        private static final RString 出力順_住所コード = new RString("投票区コード ＞ 住所コード");
        private static final RString 出力順_行政区コード = new RString("投票区コード ＞ 行政区コード");
        private static final RString 出力順_地区コード1 = new RString("投票区コード ＞ 地区コード１");
        private static final RString 出力順_地区コード2 = new RString("投票区コード ＞ 地区コード２");
        private static final RString 出力順_地区コード3 = new RString("投票区コード ＞ 地区コード３");

        private final RString 帳票タイトル;
        private static final RString 印字_投票区名称 = new RString("投票区名称");

        private static final RString 印字_投票区計 = new RString("＊　投票区計　＊");
        private static final RString 印字_合計 = new RString("＊　合　　計　＊");
        private static final RString 印字_うち県内転出者 = new RString("(うち県内転出者)");

        private static final RString 明細タイトル住所_住所 = new RString("住所");
        private static final RString 明細タイトル住所_行政区 = new RString("行政区");

        private static final RString 投票区別合計ページ = new RString("2");

        private final TeijiCommonJohoItem 帳票共通ヘッダー;
        private final RString 明細タイトル住所;

        private List<TorokushasuListParam> 投票区計 = null;
        private List<TorokushasuListParam> 合計 = null;

        /**
         * コンストラクタです。
         *
         * @param 帳票共通ヘッダー TeijiCommonJohoItem
         * @param 帳票出力順 FlexibleDate
         * @param 帳票タイトル RString
         * @param senkyoShurui SenkyoShurui
         */
        public TorokushasuListParamBuilder(TeijiCommonJohoItem 帳票共通ヘッダー, RString 帳票出力順, RString 帳票タイトル, SenkyoShurui senkyoShurui) {
            this.帳票共通ヘッダー = 帳票共通ヘッダー;
            明細タイトル住所 = get明細タイトル住所(帳票出力順);
            帳票共通ヘッダー.set作成条件(
                    new RString("ソート順：投票区コード＞").concat(明細タイトル住所)
                    .concat(new RString(SenkyoShurui.定時登録.equals(senkyoShurui) ? "コード　　　改頁：なし" : "コード　　　改頁：選挙番号")));
            帳票共通ヘッダー.set出力順(帳票出力順);
            this.帳票タイトル = 帳票タイトル;
        }

        private RString get明細タイトル住所(RString 帳票出力順) {
            if (出力順_住所コード.equals(帳票出力順)) {
                return 明細タイトル住所_住所;
            } else if (出力順_行政区コード.equals(帳票出力順)) {
                return 明細タイトル住所_行政区;
            } else if (出力順_地区コード1.equals(帳票出力順)) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            } else if (出力順_地区コード2.equals(帳票出力順)) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
            } else if (出力順_地区コード3.equals(帳票出力順)) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
            } else {
                return 明細タイトル住所_行政区;
            }
        }

        /**
         * 検索データを追加します。
         *
         * @param entity AFAPRA103Entity
         * @return 登録者数リスト
         */
        public List<TorokushasuListParam> addData(AFAPRA103Entity entity) {

            List<TorokushasuListParam> outParam = new ArrayList<>();

            boolean isFirst = true;

            if (合計 == null) {
                合計 = newParam(entity, false, 印字_合計);
                投票区計 = newParam(entity, false, 印字_投票区計);
            } else if (!合計.get(0).same合計(entity)) {
                if (投票区計 != null) {
                    outParam.addAll(投票区計);
                }
                outParam.addAll(合計);
                投票区計 = newParam(entity, false, 印字_投票区計);
                合計 = newParam(entity, false, 印字_合計);
            } else {
                if (投票区計 == null) {
                    投票区計 = newParam(entity, false, 印字_投票区計);
                } else if (!投票区計.get(0).same投票区計(entity)) {
                    outParam.addAll(投票区計);
                    投票区計 = newParam(entity, false, 印字_投票区計);
                } else {
                    isFirst = false;
                }
            }

            List<TorokushasuListParam> currentParam = newParam(entity, isFirst, null);

            if (投票区計 != null) {
                for (int i = 0; i < 投票区計.size(); i++) {
                    投票区計.get(i).add(currentParam.get(i));
                }
            }
            for (int i = 0; i < 合計.size(); i++) {
                合計.get(i).add(currentParam.get(i));
            }

            outParam.addAll(currentParam);
            return deleteEmptyうち県内転出者(outParam);
        }

        /**
         * 最終の合計処理です。
         *
         * @return 登録者数リスト
         */
        public List<TorokushasuListParam> lastSum() {
            List<TorokushasuListParam> outParam = new ArrayList<>();
            if (投票区計 != null) {
                outParam.addAll(投票区計);
            }
            if (合計 != null) {
                outParam.addAll(合計);
            }
            return deleteEmptyうち県内転出者(outParam);
        }

        private List<TorokushasuListParam> deleteEmptyうち県内転出者(List<TorokushasuListParam> params) {
            List<TorokushasuListParam> outParams = new ArrayList<>();
            for (TorokushasuListParam torokushasuListParam : params) {
                if (印字_うち県内転出者.equals(torokushasuListParam.get集計地区名())) {
                    Decimal 合計数 = torokushasuListParam.get有権者_男数().add(
                            torokushasuListParam.get有権者_女数()).add(
                                    torokushasuListParam.get表示者_男数()).add(
                                    torokushasuListParam.get表示者_女数()).add(
                                    torokushasuListParam.get公民権停止者_男数()).add(
                                    torokushasuListParam.get公民権停止者_女数());

                    if (合計数.compareTo(Decimal.ZERO) > 0) {
                        outParams.add(torokushasuListParam);
                    }
                } else {
                    outParams.add(torokushasuListParam);
                }
            }
            return outParams;
        }

        private List<TorokushasuListParam> newParam(AFAPRA103Entity entity, boolean isFirst, RString sumTitle) {

            if (投票区別合計ページ.equals(entity.getSumType()) && 印字_投票区計.equals(sumTitle)) {
                return null;
            }

            TorokushasuListParam param;
            TorokushasuListParam paramうち県内転出者;

            RString 選挙名称 = entity.getSenkyoName();
            RString senkyoNo = entity.getSenkyoNo();
            RString sumType = entity.getSumType();
            RString 投票区コード = entity.getTohyokuCode();
            RString 明細タイトル = 投票区別合計ページ.equals(entity.getSumType()) ? 印字_投票区名称 : 明細タイトル住所;
            RString 集計地区名 = 投票区別合計ページ.equals(entity.getSumType()) ? entity.getTohyokuMeisho() : entity.getOrderCode();

            FlexibleDate 名簿基準年月日 = entity.getKijunYMD();
            FlexibleDate 投票日 = entity.getTohyoYMD();

            if (RString.isNullOrEmpty(sumTitle)) {
                param = new TorokushasuListParam(帳票共通ヘッダー,
                        明細タイトル,
                        選挙名称,
                        senkyoNo,
                        sumType,
                        投票区コード,
                        isFirst ? 投票区コード : RString.EMPTY,
                        集計地区名,
                        entity.getUkeshaMale(),
                        entity.getUkeshaFemale(),
                        entity.getHyojishaMale(),
                        entity.getHyojishaFemale(),
                        entity.getKominkenTeshishaMale(),
                        entity.getKominkenTeshishaFemale(),
                        名簿基準年月日,
                        投票日,
                        帳票タイトル);
                paramうち県内転出者 = new TorokushasuListParam(帳票共通ヘッダー,
                        明細タイトル,
                        選挙名称,
                        senkyoNo,
                        sumType,
                        投票区コード,
                        RString.EMPTY,
                        印字_うち県内転出者,
                        entity.getTenshuUkeshaMale(),
                        entity.getTenshuUkeshaFemale(),
                        entity.getTenshuHyojishaMale(),
                        entity.getTenshuHyojishaFemale(),
                        entity.getTenshuKominkenTeshishaMale(),
                        entity.getTenshuKominkenTeshishaFemale(),
                        名簿基準年月日,
                        投票日,
                        帳票タイトル);
            } else {
                param = new TorokushasuListParam(帳票共通ヘッダー,
                        明細タイトル,
                        選挙名称,
                        senkyoNo,
                        sumType,
                        投票区コード,
                        RString.EMPTY,
                        sumTitle,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        名簿基準年月日,
                        投票日,
                        帳票タイトル);
                paramうち県内転出者 = new TorokushasuListParam(帳票共通ヘッダー,
                        明細タイトル,
                        選挙名称,
                        senkyoNo,
                        sumType,
                        投票区コード,
                        RString.EMPTY,
                        印字_うち県内転出者,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        Decimal.ZERO,
                        名簿基準年月日,
                        投票日,
                        帳票タイトル);
            }
            return Arrays.asList(param, paramうち県内転出者);
        }
    }

}
