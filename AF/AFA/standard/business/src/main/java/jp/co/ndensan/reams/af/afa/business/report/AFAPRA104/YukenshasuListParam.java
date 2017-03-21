/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA104;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_住所コード;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード1;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード2;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード3;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_行政区コード;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104Entity;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 有権者数調べのパラメータクラスです。
 *
 * @reamsid_L AF-0010-038 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class YukenshasuListParam {

    private static final RString 明細行見出し1_合計 = new RString("　合計　");

    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString サブタイトル;
    private final RString 見出し1;
    private final RString 明細行見出し1;

    private final AFAPRA104Entity entity;
    private final boolean empty;

    /**
     * コンストラクタです。
     *
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param サブタイトル RString
     * @param 見出し1 RString
     * @param 明細行見出し1 RString
     * @param entity AFAPRA104Entity
     */
    public YukenshasuListParam(TeijiCommonJohoItem 帳票共通ヘッダー,
            RString サブタイトル,
            RString 見出し1,
            RString 明細行見出し1,
            AFAPRA104Entity entity) {
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.サブタイトル = サブタイトル;
        this.見出し1 = 見出し1;
        this.明細行見出し1 = 明細行見出し1;
        this.entity = entity;
        this.empty = false;
    }

    /**
     * コンストラクタです。
     *
     * @param param YukenshasuListParam
     * @param isEmpty boolean
     */
    public YukenshasuListParam(YukenshasuListParam param, boolean isEmpty) {
        this.帳票共通ヘッダー = param.get帳票共通ヘッダー();
        this.サブタイトル = param.getサブタイトル();
        this.見出し1 = param.get見出し1();
        this.明細行見出し1 = 明細行見出し1_合計;
        this.entity = param.getEntity();
        this.empty = isEmpty;
    }

    private void add(AFAPRA104Entity entity) {
        this.entity.add(entity);

    }

    /**
     * 同じ合計を判断します。
     *
     * @param entity AFAPRA103Entity
     * @return 判断結果
     */
    protected boolean same合計(AFAPRA104Entity entity) {
        return this.entity.get選挙番号().equals(entity.get選挙番号())
                && this.entity.is合計ページ() == entity.is合計ページ()
                && (this.entity.is合計ページ() || this.entity.get投票区コード().equals(entity.get投票区コード()));

    }

    /**
     * 有権者数調べのパラメータbuilderクラスです。
     *
     */
    public static class YukenshasuListParamBuilder {

        private static final int MAX_明細行目 = 20;

        private static final RString 作成条件_HEAD = new RString("ソート順：選挙番号＞投票区コード＞");
        private static final RString 作成条件_TAIL = new RString("　　　改頁：投票区コード");

        private static final RString 作成条件_住所コード = new RString("住登内町域コード");
        private static final RString 作成条件_行政区コード = new RString("行政区コード");
        private static final RString 作成条件_地区コード1 = new RString("地区コード1");
        private static final RString 作成条件_地区コード2 = new RString("地区コード2");
        private static final RString 作成条件_地区コード3 = new RString("地区コード3");

        private static final RString タイトル_投票区毎_HEAD = new RString("第");
        private static final RString タイトル_投票区毎_TAIL = new RString("投票区");
        private static final RString サブタイトル_合計頁 = new RString("全投票区");
        private static final RString 合計ページ_見出し1 = new RString("投票区名称");

        private final TeijiCommonJohoItem 帳票共通ヘッダー;
        private YukenshasuListParam 合計 = null;
        private final RString 合計ページではない_見出し1;

        private int line = 0;

        /**
         * コンストラクタです。
         *
         * @param 帳票共通ヘッダー TeijiCommonJohoItem
         */
        public YukenshasuListParamBuilder(TeijiCommonJohoItem 帳票共通ヘッダー) {
            this.帳票共通ヘッダー = 帳票共通ヘッダー;

            RStringBuilder 作成条件Builder = new RStringBuilder();
            作成条件Builder.append(作成条件_HEAD);

            RString 出力範囲指示 = BusinessConfig.get(ConfigKeysAFA.抄本_出力範囲指示, SubGyomuCode.AFA選挙本体);
            if (出力範囲指示_住所コード.getKey().equals(出力範囲指示)) {
                合計ページではない_見出し1 = 出力範囲指示_住所コード.getName();
                作成条件Builder.append(作成条件_住所コード);
            } else if (出力範囲指示_行政区コード.getKey().equals(出力範囲指示)) {
                合計ページではない_見出し1 = 出力範囲指示_行政区コード.getName();
                作成条件Builder.append(作成条件_行政区コード);
            } else if (出力範囲指示_地区コード1.getKey().equals(出力範囲指示)) {
                合計ページではない_見出し1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
                作成条件Builder.append(作成条件_地区コード1);
            } else if (出力範囲指示_地区コード2.getKey().equals(出力範囲指示)) {
                合計ページではない_見出し1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
                作成条件Builder.append(作成条件_地区コード2);
            } else if (出力範囲指示_地区コード3.getKey().equals(出力範囲指示)) {
                合計ページではない_見出し1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
                作成条件Builder.append(作成条件_地区コード3);
            } else {
                合計ページではない_見出し1 = RString.EMPTY;
            }
            作成条件Builder.append(作成条件_TAIL);
            帳票共通ヘッダー.set作成条件(作成条件Builder.toRString());
        }

        private YukenshasuListParam newParam(AFAPRA104Entity entity) {

            RString サブタイトル;
            RString 見出し1;
            RString 明細行見出し1;
            if (entity.is合計ページ()) {
                サブタイトル = サブタイトル_合計頁;
                見出し1 = 合計ページ_見出し1;
                明細行見出し1 = get投票区(entity.get投票区コード());
            } else {
                サブタイトル = get投票区(entity.get投票区コード());
                見出し1 = 合計ページではない_見出し1;
                明細行見出し1 = entity.get地区名称();
            }

            return new YukenshasuListParam(帳票共通ヘッダー, サブタイトル, 見出し1, 明細行見出し1, entity);

        }

        private RString get投票区(RString 投票区コード) {
            return タイトル_投票区毎_HEAD.concat(投票区コード).concat(タイトル_投票区毎_TAIL);
        }

        /**
         * 検索データを追加します。
         *
         * @param entity AFAPRA103Entity
         * @return List<YukenshasuListParam>
         */
        public List<YukenshasuListParam> addData(AFAPRA104Entity entity) {

            List<YukenshasuListParam> outParam = new ArrayList<>();
            YukenshasuListParam current;

            if (合計 == null) {
                current = newParam(entity);
                合計 = new YukenshasuListParam(current, false);
                line = 1;

            } else if (!合計.same合計(entity)) {
                int lastPagelines = (line + 1) % MAX_明細行目;
                if (lastPagelines != 0) {
                    for (int i = 0; i < MAX_明細行目 - lastPagelines; i++) {
                        outParam.add(new YukenshasuListParam(合計, true));
                    }
                }
                outParam.add(合計);
                current = newParam(entity);
                合計 = new YukenshasuListParam(current, false);
                line = 1;
            } else {
                current = newParam(entity);
                合計.add(entity);
                line++;
            }
            outParam.add(current);

            return outParam;
        }

        /**
         * 最終の合計処理です。
         *
         * @return List<YukenshasuListParam>
         */
        public List<YukenshasuListParam> lastSum() {
            List<YukenshasuListParam> outParam = new ArrayList<>();
            if (合計 != null) {
                int lastPagelines = (line + 1) % MAX_明細行目;
                if (lastPagelines != 0) {
                    for (int i = 0; i < MAX_明細行目 - lastPagelines; i++) {
                        outParam.add(new YukenshasuListParam(合計, true));
                    }
                }
                outParam.add(合計);
            }
            return outParam;
        }

    }

}
