package jp.co.ndensan.reams.af.afa.business.report.AFAPRK101;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishoCheckListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuEditor implements IShinseishoCheckListKaikuEditor {

    private static final int NUMBER_ZERO = 0;
    private static final RString 日本人 = new RString("1");
    private static final RString 外国人 = new RString("2");
    private static final RString 基準日 = new RString("（基準日:");
    private static final RString 全角スペース = new RString("　");
    private static final RString 右括弧 = new RString(")");
    private static final RString 住所 = new RString("listMeisai1_4");

    private final ShinseishoCheckListKaikuParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link ShinseishoCheckListKaikuParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public ShinseishoCheckListKaikuEditor(ShinseishoCheckListKaikuParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 申請書チェックリストエディットメソッド
     *
     * @param source 申請書チェックリスト
     * @return 申請書チェックリスト
     */
    @Override
    public ShinseishoCheckListKaikuSource edit(ShinseishoCheckListKaikuSource source) {
        editヘッダ(source);
        edit投票区コード(source);
        edit住所コード(source);
        edit世帯コード(source);
        edit住所(source);
        edit氏名(source);
        edit性別(source);
        edit生年月日(source);
        edit消除年月日(source);
        edit識別コード(source);
        edit日数(source);
        editエラー事由(source);
        edit作成条件(source);
        editログの出力(source);
        return source;
    }

    private void edit住所(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            RString 文字列 = changeNullToEmpty(data.get海区選挙人名簿().get住所()).concat(changeNullToEmpty(data.get海区選挙人名簿().get番地()))
                    .concat(全角スペース).concat(changeNullToEmpty(data.get海区選挙人名簿().get方書()));

            IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
            List<RString> 文字列リスト = idouSenkyoninIchiran.文字列分割(文字列, getItemLength(住所));
            source.listMeisai1_4 = 文字列リスト.get(NUMBER_ZERO);
        }
    }

    private void edit作成条件(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.selHani = changeNullToEmpty(data.get海区選挙人名簿().get選挙種類()).concat(基準日)
                    .concat(null == data.get海区選挙人名簿().get名簿基準年月日() ? RString.EMPTY : data.get海区選挙人名簿().get名簿基準年月日().wareki().toDateString())
                    .concat(右括弧);
        }
    }

    private void editログの出力(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.識別コード = data.get海区選挙人名簿().get識別コード();
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void editエラー事由(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai2_9 = data.get海区選挙人名簿().getエラー事由1();
            source.listMeisai2_10 = data.get海区選挙人名簿().getエラー事由2();
            source.listMeisai2_11 = data.get海区選挙人名簿().getエラー事由3();
        }
    }

    private void edit日数(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai2_6 = data.get海区選挙人名簿().get漁業日数_漁業者();
            source.listMeisai2_7 = data.get海区選挙人名簿().get漁業日数_漁業従事者();
        }
    }

    private void edit識別コード(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai2_3 = null == data.get海区選挙人名簿().get識別コード() ? RString.EMPTY : data.get海区選挙人名簿().get識別コード().getColumnValue();
        }
    }

    private void edit消除年月日(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿() && null != data.get海区選挙人名簿().get表示消除年月日()) {
            source.listMeisai1_8 = data.get海区選挙人名簿().get表示消除年月日().wareki().toDateString();
        }
    }

    private void edit生年月日(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿() && null != data.get海区選挙人名簿().get生年月日()) {
            if (日本人.equals(data.get海区選挙人名簿().get住民種別コード())) {
                source.listMeisai1_7 = data.get海区選挙人名簿().get生年月日().wareki().toDateString();
            }
            if (外国人.equals(data.get海区選挙人名簿().get住民種別コード())) {
                source.listMeisai1_7 = data.get海区選挙人名簿().get生年月日().seireki().toDateString();
            }
        }
    }

    private void edit氏名(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai1_5 = data.get海区選挙人名簿().get氏名();
        }
    }

    private void edit性別(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai1_6 = data.get海区選挙人名簿().get性別();
        }
    }

    private void edit世帯コード(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai1_3 = data.get海区選挙人名簿().get世帯コード();
        }
    }

    private void edit住所コード(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai1_2 = data.get海区選挙人名簿().get全国住所コード();
        }
    }

    private void edit投票区コード(ShinseishoCheckListKaikuSource source) {
        if (null != data.get海区選挙人名簿()) {
            source.listMeisai1_1 = data.get海区選挙人名簿().get投票区コード();
        }
    }

    private void editヘッダ(ShinseishoCheckListKaikuSource source) {
        source.shichosonmei = 帳票共通ヘッダー.get市町村名();
        source.shichosoncd = 帳票共通ヘッダー.get市町村コード();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.page = data.getページ();
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShinseishoCheckListKaikuSource.class, itemName);
    }
}
