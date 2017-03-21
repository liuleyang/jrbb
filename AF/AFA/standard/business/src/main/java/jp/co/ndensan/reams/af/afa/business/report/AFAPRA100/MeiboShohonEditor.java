/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * {@link MeiboShohonSource}を編集します。
 *
 */
public class MeiboShohonEditor implements IMeiboShohonEditor {

    private static final RString 帳票タイトル = new RString("永久選挙人名簿抄本");
    private static final RString 帳票タイトル_縦覧 = new RString("永久選挙人名簿抄本（縦覧）");
    private static final RString 国民帳票タイトル = new RString("投票人名簿抄本");
    private static final RString 国民帳票タイトル_縦覧 = new RString("投票人名簿抄本（縦覧）");

    private static final int 住所１_LENGTH = getItemLength(new RString("listJusho3_1"));
    private static final int 住所２_LENGTH = getItemLength(new RString("listJusho4_1"));
    private static final int 住所３_LENGTH = getItemLength(new RString("listJusho5_1"));
    private static final int 生年月日_LENGTH = getItemLength(new RString("listSeinengappi_1"));
    private static final int 不在者投票資格_LENGTH = getItemLength(new RString("listFuzaishaShikaku_1"));
    private static final int 性別_LENGTH = getItemLength(new RString("listSeibetsu_1"));
    private static final int 世帯主_LENGTH = getItemLength(new RString("listSetainushi_1"));
    private static final int 氏名１_LENGTH = getItemLength(new RString("listShimei_1"));
    private static final int 氏名２_LENGTH = getItemLength(new RString("listShimeiKana_1"));
    private static final int 表示１_LENGTH = getItemLength(new RString("listHyoji1_1"));
    private static final int 表示２_LENGTH = getItemLength(new RString("listHyoji2_1"));
    private static final int 表示３_LENGTH = getItemLength(new RString("listHyoji3_1"));
    private static final int 受付１_LENGTH = getItemLength(new RString("listUketsuke1_1"));
    private static final int 受付２_LENGTH = getItemLength(new RString("listUketsuke2_1"));

    private static final List<Integer> 表示１_INDEX = Arrays.asList(0, 2);
    private static final List<Integer> 表示２_INDEX = Arrays.asList(3, 5);
    private static final List<Integer> 表示３_INDEX = Arrays.asList(6, 8);

    private final MeinoShohonParam param;
    private final boolean is国民投票;
    private static final CharSequence アスタリスク_半角 = new RString("*");
    private static final RString アスタリスク_全角 = new RString("＊");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");

    /**
     * コンストラクタです。
     *
     * @param param {@link MeinoShohonParam}
     * @param is国民投票 boolean
     */
    public MeiboShohonEditor(MeinoShohonParam param, boolean is国民投票) {
        this.param = param;
        this.is国民投票 = is国民投票;
    }

    @Override
    public MeiboShohonSource edit(MeiboShohonSource source) {

        editヘッダ(source);
        if (AFAConfigKeysValue.取扱注意者_出力方式_行をマスクする.isEqual(param.get取扱注意者出力方式())) {
            edit明細アスタリスク半角(source);
        } else if (!AFAConfigKeysValue.取扱注意者_出力方式_行を空白にする.isEqual(param.get取扱注意者出力方式())) {
            if (param.is抹消線()) {
                edit明細With抹消線(source);
            } else {
                edit明細(source);
            }
        }
        editフッタ(source);

        return source;
    }

    private void editヘッダ(MeiboShohonSource source) {
        source.title = getTitle(param.is縦覧());
        source.tohyokuMei = param.get投票区名();
        source.tohyokuCode = param.get投票区コード();
        source.jushoMeisho = param.getヘッダ項目名称見出し();
        source.jushoCode = param.getヘッダ項目コード();
        source.jusho = param.getヘッダ項目名称();
        source.totalPage = new RString(param.getTotalPage());
        source.page = new RString(param.getPage());
        source.realPage = new RString(param.getRealPage());
    }

    private RString getTitle(boolean is縦覧) {
        if (is縦覧) {
            return is国民投票 ? 国民帳票タイトル_縦覧 : 帳票タイトル_縦覧;
        } else {
            return is国民投票 ? 国民帳票タイトル : 帳票タイトル;
        }
    }

    private void edit明細(MeiboShohonSource source) {
        // 住所
        List<RString> 住所List = 文字切れ(param.get住所(), 住所１_LENGTH, 住所２_LENGTH, 住所３_LENGTH);
        if (!RString.isNullOrEmpty(param.get方書())) {
            if (住所List.size() <= 2) {
                住所List.add(param.get方書());
            } else {
                住所List.set(2, 住所List.get(2).concat(RString.FULL_SPACE).concat(param.get方書()));
            }
        }

        switch (住所List.size()) {
            case 2:
                source.listJusho1_1 = 住所List.get(0);
                source.listJusho2_1 = 住所List.get(1);
                break;
            case 1:
                source.listJusho1_1 = 住所List.get(0);
                break;
            case 0:
                break;
            default:
                source.listJusho3_1 = 住所List.get(0);
                source.listJusho4_1 = 住所List.get(1);
                source.listJusho5_1 = 住所List.get(2);
        }

        source.listSeinengappi_1 = param.get生年月日();
        source.listFuzaishaShikaku_1 = param.get不在者投票資格();
        source.listSeibetsu_1 = param.get性別().getCommonName();
        source.listSetainushi_1 = param.is世帯主() ? アスタリスク_全角 : RString.EMPTY;

        IName 氏名 = param.get氏名();
        source.listShimei_1 = 氏名.getName().getColumnValue();
        source.listShimeiKana_1 = edit氏名２(氏名.getKana().getColumnValue(), param.get識別コード().getColumnValue());

        edit明細表示と受付(source);
    }

    private void edit明細With抹消線(MeiboShohonSource source) {
        // 住所
        List<RString> 住所List = 文字切れ(param.get住所(), 住所１_LENGTH, 住所２_LENGTH, 住所３_LENGTH);

        if (!RString.isNullOrEmpty(param.get方書())) {
            if (住所List.size() <= 2) {
                住所List.add(param.get方書());
            } else {
                住所List.set(2, 住所List.get(2).concat(RString.FULL_SPACE).concat(param.get方書()));
            }
        }

        switch (住所List.size()) {
            case 2:
                source.listJusho1M_1 = 住所List.get(0);
                source.listJusho2M_1 = 住所List.get(1);
                break;
            case 1:
                source.listJusho1M_1 = 住所List.get(0);
                break;
            case 0:
                break;
            default:
                source.listJusho3M_1 = 住所List.get(0);
                source.listJusho4M_1 = 住所List.get(1);
                source.listJusho5M_1 = 住所List.get(2);
        }

        source.listSeinengappiM_1 = param.get生年月日();
        source.listFuzaishaShikakuM_1 = param.get不在者投票資格();
        source.listSeibetsuM_1 = param.get性別().getCommonName();
        source.listSetainushiM_1 = param.is世帯主() ? アスタリスク_全角 : RString.EMPTY;

        IName 氏名 = param.get氏名();
        source.listShimeiM_1 = 氏名.getName().getColumnValue();
        source.listShimeiKanaM_1 = edit氏名２(氏名.getKana().getColumnValue(), param.get識別コード().getColumnValue());

        edit明細表示と受付(source);
    }

    private void edit明細表示と受付(MeiboShohonSource source) {
        List<RString> 表示 = param.get表示();
        source.listHyoji1_1 = edit表示(表示, 表示１_INDEX);
        source.listHyoji2_1 = edit表示(表示, 表示２_INDEX);
        source.listHyoji3_1 = edit表示(表示, 表示３_INDEX);

        source.listUketsuke1_1 = param.get受付1();
        source.listUketsuke2_1 = param.get受付2();
    }

    private void edit明細アスタリスク半角(MeiboShohonSource source) {
        source.listJusho3_1 = getマスキング文字列(住所１_LENGTH);
        source.listJusho4_1 = getマスキング文字列(住所２_LENGTH);
        source.listJusho5_1 = getマスキング文字列(住所３_LENGTH);
        source.listSeinengappi_1 = getマスキング文字列(生年月日_LENGTH);
        source.listFuzaishaShikaku_1 = getマスキング文字列(不在者投票資格_LENGTH);
        source.listSeibetsu_1 = getマスキング文字列(性別_LENGTH);
        source.listSetainushi_1 = getマスキング文字列(世帯主_LENGTH);
        source.listShimei_1 = getマスキング文字列(氏名１_LENGTH);
        source.listShimeiKana_1 = getマスキング文字列(氏名２_LENGTH);
        source.listHyoji1_1 = getマスキング文字列(表示１_LENGTH);
        source.listHyoji2_1 = getマスキング文字列(表示２_LENGTH);
        source.listHyoji3_1 = getマスキング文字列(表示３_LENGTH);
        source.listUketsuke1_1 = getマスキング文字列(受付１_LENGTH);
        source.listUketsuke2_1 = getマスキング文字列(受付２_LENGTH);
    }

    private void editフッタ(MeiboShohonSource source) {
        source.listJusho = param.get住所();
        source.shikibetsuCode = param.get識別コード().getColumnValue();

        source.senkanMei = param.get選挙管理委員会名称();

        int i = 0;
        List<RString> 選挙 = param.get選挙();
        source.senkyoMei1 = 選挙.get(i++);
        source.senkyoMei2 = 選挙.get(i++);
        source.senkyoMei3 = 選挙.get(i++);
        source.senkyoMei4 = 選挙.get(i++);
        source.senkyoMei5 = 選挙.get(i++);
        source.senkyoMei6 = 選挙.get(i++);
        source.senkyoMei7 = 選挙.get(i++);
        source.senkyoMei8 = 選挙.get(i++);
        source.senkyoMei9 = 選挙.get(i++);

        if (!param.is縦覧()) {
            TotalParam 集計 = param.getページ計();
            if (集計 != null) {
                source.pageKeiMan = formatInt(集計.getMaleCount());
                source.pageKeiWoman = formatInt(集計.getFeMaleCount());
                source.pageKeiKei = formatInt(集計.getTotalCount());
            }

            集計 = param.get計1();
            if (集計 != null) {
                source.kei1Title = 集計.get集計印字();
                source.kei1Man = formatInt(集計.getMaleCount());
                source.kei1Woman = formatInt(集計.getFeMaleCount());
                source.kei1Kei = formatInt(集計.getTotalCount());
            }

            集計 = param.get計2();
            if (集計 != null) {
                source.kei2Title = 集計.get集計印字();
                source.kei2Man = formatInt(集計.getMaleCount());
                source.kei2Woman = formatInt(集計.getFeMaleCount());
                source.kei2Kei = formatInt(集計.getTotalCount());
            }

            集計 = param.get計3();
            if (集計 != null) {
                source.kei3Title = 集計.get集計印字();
                source.kei3Man = formatInt(集計.getMaleCount());
                source.kei3Woman = formatInt(集計.getFeMaleCount());
                source.kei3Kei = formatInt(集計.getTotalCount());
            }

            集計 = param.get計4();
            if (集計 != null) {
                source.kei4Title = 集計.get集計印字();
                source.kei4Man = formatInt(集計.getMaleCount());
                source.kei4Woman = formatInt(集計.getFeMaleCount());
                source.kei4Kei = formatInt(集計.getTotalCount());
            }

        }
    }

    private RString edit氏名２(RString kana, RString 識別コード) {
        RStringBuilder 氏名２Builder = new RStringBuilder();
        int kanaLength = 氏名２_LENGTH - 2;
        if (param.is印字有無_識別コード()) {
            氏名２Builder.append(識別コード);
            kanaLength -= 識別コード.length();
        }
        if (param.is印字有無_カナ名称()) {
            List<RString> カナ名称 = 文字切れ(kana, kanaLength);
            氏名２Builder.insert(0, 左括弧.concat(カナ名称.isEmpty() ? RString.EMPTY : カナ名称.get(0).padRight(kanaLength)).concat(右括弧));
        }
        return 氏名２Builder.toRString().padLeft(氏名２_LENGTH);
    }

    private RString edit表示(List<RString> 表示, List<Integer> index) {
        RStringBuilder 表示Builder = new RStringBuilder();
        for (int i = index.get(0); i < 表示.size() && i <= index.get(1); i++) {
            if (i != index.get(0)) {
                表示Builder.append(RString.FULL_SPACE);
            }
            表示Builder.append(表示.get(i));
        }
        return 表示Builder.toRString();
    }

    private List<RString> 文字切れ(RString trgt, int... lengths) {
        List<RString> rsltList = new ArrayList<>();
        int index = 0;
        List<RString> trgtList = trgt.toRStringList();
        for (int length : lengths) {

            RStringBuilder lineBuilder = new RStringBuilder();
            int lineLength = 0;
            while (index < trgtList.size()) {
                int 文字Size = RStringUtil.is全角Only(trgtList.get(index)) ? 2 : 1;
                if (lineLength + 文字Size > length) {
                    break;
                }
                lineBuilder.append(trgtList.get(index));
                index++;
                lineLength += 文字Size;
            }

            if (lineBuilder.length() == 0) {
                break;
            }
            rsltList.add(lineBuilder.toRString());
        }
        return rsltList;
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

    private RString getマスキング文字列(int length) {
        return RString.EMPTY.padRight(アスタリスク_半角, length);
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(MeiboShohonSource.class, itemName);
    }

}
