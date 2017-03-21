/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE503;

import jp.co.ndensan.reams.af.afa.business.core.TohyoshaListSenkyoAllParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllEditor implements ITohyoshaListSenkyoAllEditor {

    private static final RString 帳票タイトル_期日前 = new RString("期日前投票者一覧表");
    private static final RString 帳票タイトル_不在者 = new RString("不在者投票者一覧表");
    private static final RString 帳票タイトル_混在 = new RString("期日前・不在者投票者一覧表");
    private static final RString 期日前 = new RString("1");
    private static final RString 不在者 = new RString("2");
    private static final RString 混在 = new RString("3");
    private static final RString 全角スペース_1桁 = new RString("　");
    private static final RString 全角スペース_2桁 = new RString("　　");
    private static final RString 期日前投票日 = new RString("期日前投票日:");
    private static final RString 交付日 = new RString("交付日:");
    private static final RString 受理日 = new RString("受理日:");
    private static final RString 投票区コード = new RString("投票区コード:");
    private static final RString 施設コード = new RString("施設コード:");
    private static final RString 記号 = new RString("～");
    private static final RString 横線 = new RString("-");
    private static final RString 代理投票 = new RString("（代理投票）");
    private static final RString 点字投票 = new RString("（点字投票）");
    private static final RString 棄権 = new RString("（棄権）");
    private static final RString 受付拒否 = new RString("（受付拒否）");
    private static final RString 仮投票 = new RString("（仮投票）");
    private static final RString 請求 = new RString("（請求のみ）");
    private static final RString 未着者 = new RString("（未着者）");
    private static final RString 返還 = new RString("（返還）");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString 性別コード_1 = new RString("1");
    private static final RString 性別コード_2 = new RString("2");
    private static final RString 住民種別_日本人 = new RString("1");
    private static final RString 住民種別_外国人 = new RString("2");
    private static final RString 投票状況_1 = new RString("1");
    private static final RString 投票状況_2 = new RString("2");
    private static final RString 投票状況_3 = new RString("3");
    private static final RString 投票状況_4 = new RString("4");
    private static final RString 投票状況_5 = new RString("5");
    private static final RString 投票状況_6 = new RString("6");
    private static final RString 投票状況_8 = new RString("8");
    private static final RString 投票状況_9 = new RString("9");
    private static final RString 文字_代 = new RString("代");
    private static final RString 文字_点 = new RString("点");
    private static final RString 投票区コード名 = new RString("tohyokuCode");
    private static final RString 受付番号名 = new RString("uketsukeNo");
    private static final RString 交付日_タイトル = new RString("交付日");
    private static final RString 受理日_タイトル = new RString("受理日");
    private static final RString 投票日_タイトル = new RString("投票日");
    private static final RString 受理_投票日_タイトル = new RString("受理・投票日");
    private static final RString 投票時刻 = new RString("投票時刻：");
    private static final RString 受理時刻 = new RString("受理時刻：");
    private static final RString 投票事由 = new RString("投票事由：");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private RString 投票区コード_内容 = RString.EMPTY;
    private RString 施設コード_内容 = RString.EMPTY;
    private final TohyoshaListSenkyoAllParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link TohyoJiyuChoshoParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public TohyoshaListSenkyoAllEditor(TohyoshaListSenkyoAllParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public TohyoshaListSenkyoAllSource edit(TohyoshaListSenkyoAllSource source) {
        editタイトル(source);
        editサブタイトル(source);
        edit選挙マーク(source);
        edit日付タイトル(source);
        edit受付番号(source);
        edit名簿番号(source);
        edit氏名(source);
        edit性別(source);
        edit年齢(source);
        edit生年月日(source);
        edit事由(source);
        edit投票場所(source);
        edit投票状況(source);
        edit交付日(source);
        edit受理投票日(source);
        edit方法等(source);
        edit合計エリア１(source);
        edit合計エリア２(source);
        edit作成条件(source);
        edit改ページ(source);
        editアクセスログ出力(source);

        return source;
    }

    private void editタイトル(TohyoshaListSenkyoAllSource source) {
        if (期日前.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.title = 帳票タイトル_期日前;
        }
        if (不在者.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.title = 帳票タイトル_不在者;
        }
        if (混在.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.title = 帳票タイトル_混在;
        }
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void editサブタイトル(TohyoshaListSenkyoAllSource source) {
        source.subTitle = RString.EMPTY;
        if (混在.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.subTitle = new RString("");
        }
        if (期日前.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            if (data.get投票状況Entity().is代理投票有フラグ()) {
                source.subTitle = 代理投票;
            }
            if (data.get投票状況Entity().is点字フラグ()) {
                source.subTitle = 点字投票;
            }
            if (投票状況_5.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 棄権;
            }
            if (投票状況_8.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 受付拒否;
            }
            if (投票状況_9.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 仮投票;
            }
        }
        if (不在者.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            if (投票状況_1.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 請求;
            }
            if (投票状況_2.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 未着者;
            }
            if (data.get投票状況Entity().is代理投票有フラグ()) {
                source.subTitle = 代理投票;
            }
            if (data.get投票状況Entity().is点字フラグ()) {
                source.subTitle = 点字投票;
            }
            if (投票状況_4.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 返還;
            }
            if (投票状況_5.equals(data.get投票状況Entity().get投票状況())) {
                source.subTitle = 棄権;
            }
        }
    }

    private void edit選挙マーク(TohyoshaListSenkyoAllSource source) {
        source.senkyo1 = data.get選挙略称List().size() > ZERO ? data.get選挙略称List().get(ZERO) : RString.EMPTY;
        source.senkyo2 = data.get選挙略称List().size() > ONE ? data.get選挙略称List().get(ONE) : RString.EMPTY;
        source.senkyo3 = data.get選挙略称List().size() > TWO ? data.get選挙略称List().get(TWO) : RString.EMPTY;
        source.senkyo4 = data.get選挙略称List().size() > THREE ? data.get選挙略称List().get(THREE) : RString.EMPTY;
        source.senkyo5 = data.get選挙略称List().size() > FOUR ? data.get選挙略称List().get(FOUR) : RString.EMPTY;
        source.senkyo6 = data.get選挙略称List().size() > FIVE ? data.get選挙略称List().get(FIVE) : RString.EMPTY;
        source.senkyo7 = data.get選挙略称List().size() > SIX ? data.get選挙略称List().get(SIX) : RString.EMPTY;
        source.senkyo8 = data.get選挙略称List().size() > SEVEN ? data.get選挙略称List().get(SEVEN) : RString.EMPTY;
        source.senkyo9 = data.get選挙略称List().size() > EIGHT ? data.get選挙略称List().get(EIGHT) : RString.EMPTY;

    }

    private void edit日付タイトル(TohyoshaListSenkyoAllSource source) {
        if (混在.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.lblDate1 = 交付日_タイトル;
            source.lblDate2 = 受理_投票日_タイトル;
        }
        if (期日前.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.lblDate1 = RString.EMPTY;
            source.lblDate2 = 投票日_タイトル;

        }
        if (不在者.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.lblDate1 = 交付日_タイトル;
            source.lblDate2 = 受理日_タイトル;
        }
    }

    private void edit受付番号(TohyoshaListSenkyoAllSource source) {
        source.listMeisai1_1 = data.get投票状況Entity().get受付番号();
    }

    private void edit名簿番号(TohyoshaListSenkyoAllSource source) {
        RString 頁 = new RString(data.get投票状況Entity().get頁());
        RString 行 = new RString(data.get投票状況Entity().get行());
        RString 投票区 = data.get投票状況Entity().get投票区();
        source.listMeisai1_2 = 投票区.concat(横線).concat(頁).concat(横線).concat(行);
    }

    private void edit氏名(TohyoshaListSenkyoAllSource source) {
        source.listMeisai1_3 = data.get投票状況Entity().get名称();
    }

    private void edit性別(TohyoshaListSenkyoAllSource source) {
        RString 性別 = data.get投票状況Entity().get性別コード();
        if (性別コード_1.equals(性別)) {
            source.listMeisai1_4 = 男;
        }
        if (性別コード_2.equals(性別)) {
            source.listMeisai1_4 = 女;
        }
    }

    private void edit年齢(TohyoshaListSenkyoAllSource source) {
        RString 年齢 = get年齢(data.get投票状況Entity().get生年月日());
        source.listMeisai1_5 = 年齢;
    }

    private void edit生年月日(TohyoshaListSenkyoAllSource source) {
        RString 生年月日 = get生年月日(data.get投票状況Entity().get生年月日(), data.get投票状況Entity().get住民種別());
        source.listMeisai2_1 = 生年月日;
    }

    private void edit事由(TohyoshaListSenkyoAllSource source) {
        source.listMeisai1_6 = data.get投票状況Entity().get投票事由コード();
    }

    private void edit投票場所(TohyoshaListSenkyoAllSource source) {
        source.listMeisai1_7 = data.get投票場所();

    }

    private void edit投票状況(TohyoshaListSenkyoAllSource source) {
        RString 投票状況 = get投票状況(data.get投票状況Entity().get投票状況());
        source.listMeisai1_8 = data.get選挙略称List().size() > ZERO ? 投票状況 : RString.EMPTY;
        source.listMeisai1_9 = data.get選挙略称List().size() > ONE ? 投票状況 : RString.EMPTY;
        source.listMeisai1_10 = data.get選挙略称List().size() > TWO ? 投票状況 : RString.EMPTY;
        source.listMeisai1_11 = data.get選挙略称List().size() > THREE ? 投票状況 : RString.EMPTY;
        source.listMeisai1_12 = data.get選挙略称List().size() > FOUR ? 投票状況 : RString.EMPTY;
        source.listMeisai1_13 = data.get選挙略称List().size() > FIVE ? 投票状況 : RString.EMPTY;
        source.listMeisai1_14 = data.get選挙略称List().size() > SIX ? 投票状況 : RString.EMPTY;
        source.listMeisai1_15 = data.get選挙略称List().size() > SEVEN ? 投票状況 : RString.EMPTY;
        source.listMeisai1_16 = data.get選挙略称List().size() > EIGHT ? 投票状況 : RString.EMPTY;
    }

    private void edit交付日(TohyoshaListSenkyoAllSource source) {
        if (不在者.equals(data.get投票状況Entity().get期日前不在者_場合()) || 混在.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            source.listMeisai1_17 = data.get投票状況Entity().get交付年月日().wareki().toDateString();
        } else {
            source.listMeisai1_17 = new RString("");
        }
    }

    private void edit受理投票日(TohyoshaListSenkyoAllSource source) {
        source.listMeisai2_2 = data.get投票状況Entity().get受理年月日().wareki().toDateString();
    }

    private void edit方法等(TohyoshaListSenkyoAllSource source) {
        RString 方法等 = get方法等(data.get投票状況Entity().get交付方法(), data.get投票状況Entity().is代理投票有フラグ(), data.get投票状況Entity().is点字フラグ());
        source.listMeisai1_18 = 方法等;
    }

    private void edit合計エリア１(TohyoshaListSenkyoAllSource source) {
        source.gokeiArea1 = data.get合計エリア１();
    }

    private void edit合計エリア２(TohyoshaListSenkyoAllSource source) {
        source.gokeiArea2 = data.get合計エリア２();
    }

    private void edit作成条件(TohyoshaListSenkyoAllSource source) {
        source.sakuseiJoken1 = RString.EMPTY;
        source.sakuseiJoken2 = RString.EMPTY;

        if (混在.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            RString 投票区コード開始 = changeNullToEmpty(data.get画面Info().get投票区コード開始());
            RString 投票区コード終了 = changeNullToEmpty(data.get画面Info().get投票区コード開始());
            RString 施設コード開始 = changeNullToEmpty(data.get画面Info().get施設コード開始());
            RString 施設コード終了 = changeNullToEmpty(data.get画面Info().get施設コード終了());
            source.sakuseiJoken1 = get混在条件(投票区コード開始, 投票区コード終了, 施設コード開始, 施設コード終了);
        }

        if (期日前.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            RString 期日前投票日開始 = RString.EMPTY;
            RString 期日前投票日終了 = RString.EMPTY;
            if (data.get画面Info().get期日前投票日開始() != null && data.get画面Info().get期日前投票日終了() != null) {
                期日前投票日開始 = data.get画面Info().get期日前投票日開始().wareki().toDateString();
                期日前投票日終了 = data.get画面Info().get期日前投票日終了().wareki().toDateString();
            }
            RString 投票事由コード = changeNullToEmpty(data.get画面Info().get投票事由());
            RString 投票時刻開始 = changeNullToEmpty(data.get画面Info().get投票時刻開始());
            RString 投票時刻終了 = changeNullToEmpty(data.get画面Info().get投票時刻終了());
            edit期日前作成条件(source, 投票事由コード, 期日前投票日開始, 期日前投票日終了, 投票時刻開始, 投票時刻終了);
        }

        if (不在者.equals(data.get投票状況Entity().get期日前不在者_場合())) {
            RString 交付日開始 = RString.EMPTY;
            RString 交付日終了 = RString.EMPTY;
            RString 受理日開始 = RString.EMPTY;
            RString 受理日終了 = RString.EMPTY;
            if (data.get画面Info().get期日前投票日開始() != null && data.get画面Info().get期日前投票日終了() != null) {
                交付日開始 = data.get画面Info().get期日前投票日開始().wareki().toDateString();
                交付日終了 = data.get画面Info().get期日前投票日終了().wareki().toDateString();
            }
            if (data.get画面Info().get交付日開始() != null && data.get画面Info().get受理日終了() != null) {
                受理日開始 = data.get画面Info().get期日前投票日開始().wareki().toDateString();
                受理日終了 = data.get画面Info().get期日前投票日終了().wareki().toDateString();
            }
            RString 受理時刻開始 = changeNullToEmpty(data.get画面Info().get受理時刻開始());
            RString 受理時刻終了 = changeNullToEmpty(data.get画面Info().get受理時刻終了());
            edit不在者作成条件(source, 交付日開始, 交付日終了, 受理日開始, 受理日終了, 受理時刻開始, 受理時刻終了);
        }

    }

    private void edit期日前作成条件(TohyoshaListSenkyoAllSource source, RString 投票事由コード,
            RString 期日前投票日開始, RString 期日前投票日終了, RString 投票時刻開始, RString 投票時刻終了) {
        if (条件件数(投票事由コード, 投票時刻開始, 投票時刻終了) == ZERO) {
            source.sakuseiJoken1 = new RString("指定なし");
        } else if (条件件数(投票事由コード, 投票時刻開始, 投票時刻終了) == ONE) {
            source.sakuseiJoken1 = edit期日前作成条件１件書式(投票事由コード, 期日前投票日開始, 期日前投票日終了, 投票時刻開始, 投票時刻終了);
        } else if (条件件数(投票事由コード, 投票時刻開始, 投票時刻終了) == TWO) {
            source.sakuseiJoken1 = edit期日前作成条件２件書式(投票事由コード, 期日前投票日開始, 期日前投票日終了, 投票時刻開始, 投票時刻終了);
        } else if (条件件数(投票事由コード, 投票時刻開始, 投票時刻終了) == THREE) {
            source.sakuseiJoken1 = 投票事由.concat(投票事由コード).concat(全角スペース_2桁)
                    .concat(期日前投票日).concat(期日前投票日開始).concat(記号).concat(期日前投票日終了).concat(全角スペース_2桁)
                    .concat(投票時刻).concat(投票時刻開始).concat(記号).concat(投票時刻終了);
        }
    }

    private RString edit期日前作成条件１件書式(RString 投票事由コード, RString 期日前投票日開始, RString 期日前投票日終了, RString 投票時刻開始, RString 投票時刻終了) {
        RString 文字列 = RString.EMPTY;
        if (!投票事由コード.isEmpty() && 期日前投票日開始.isEmpty() && 投票時刻開始.isEmpty()) {
            文字列 = 投票事由.concat(投票事由コード);
        } else if (投票事由コード.isEmpty() && !期日前投票日開始.isEmpty() && 投票時刻開始.isEmpty()) {
            文字列 = 期日前投票日.concat(期日前投票日開始).concat(記号).concat(期日前投票日終了);
        } else if (投票事由コード.isEmpty() && 期日前投票日開始.isEmpty() && !投票時刻開始.isEmpty()) {
            文字列 = 投票時刻.concat(投票時刻開始).concat(記号).concat(投票時刻終了);
        }
        return 文字列;
    }

    private RString edit期日前作成条件２件書式(RString 投票事由コード, RString 期日前投票日開始, RString 期日前投票日終了, RString 投票時刻開始, RString 投票時刻終了) {
        RString 文字列 = RString.EMPTY;
        if (!投票事由コード.isEmpty() && !期日前投票日開始.isEmpty() && 投票時刻開始.isEmpty()) {
            文字列 = 投票事由.concat(投票事由コード).concat(全角スペース_2桁).concat(投票時刻).concat(投票時刻開始).concat(記号).concat(投票時刻終了);
        } else if (投票事由コード.isEmpty() && !期日前投票日開始.isEmpty() && !投票時刻開始.isEmpty()) {
            文字列 = 期日前投票日.concat(期日前投票日開始).concat(記号).concat(期日前投票日終了).concat(全角スペース_2桁).concat(投票時刻).concat(投票時刻開始).concat(記号).concat(投票時刻終了);
        } else if (!投票事由コード.isEmpty() && 期日前投票日開始.isEmpty() && !投票時刻開始.isEmpty()) {
            文字列 = 投票事由.concat(投票事由コード).concat(全角スペース_2桁).concat(投票時刻).concat(投票時刻開始).concat(記号).concat(投票時刻終了);
        }
        return 文字列;
    }

    private void edit不在者作成条件(TohyoshaListSenkyoAllSource source, RString 交付日開始, RString 交付日終了,
            RString 受理日開始, RString 受理日終了, RString 受理時刻開始, RString 受理時刻終了) {
        if (条件件数(交付日開始, 受理日開始, 受理時刻開始) == ZERO) {
            source.sakuseiJoken1 = new RString("指定なし");
        } else if (条件件数(交付日開始, 受理日開始, 受理時刻開始) == ONE) {
            source.sakuseiJoken1 = edit不在者作成条件１件書式(交付日開始, 交付日終了, 受理日開始, 受理日終了, 受理時刻開始, 受理時刻終了);
        } else if (条件件数(交付日開始, 受理日開始, 受理時刻開始) == TWO) {
            source.sakuseiJoken1 = edit不在者作成条件２件書式(交付日開始, 交付日終了, 受理日開始, 受理日終了, 受理時刻開始, 受理時刻終了);
        } else if (条件件数(交付日開始, 受理日開始, 受理時刻開始) == THREE) {
            source.sakuseiJoken1 = 交付日.concat(交付日開始).concat(記号).concat(交付日終了).concat(全角スペース_2桁)
                    .concat(受理日).concat(受理日開始).concat(記号).concat(受理日終了).concat(全角スペース_2桁)
                    .concat(受理時刻).concat(受理時刻開始).concat(記号).concat(受理時刻終了);
        }
    }

    private RString edit不在者作成条件１件書式(RString 交付日開始, RString 交付日終了,
            RString 受理日開始, RString 受理日終了, RString 受理時刻開始, RString 受理時刻終了) {
        RString 文字列 = RString.EMPTY;
        if (!交付日開始.isEmpty() && 受理日開始.isEmpty() && 受理時刻開始.isEmpty()) {
            文字列 = 交付日.concat(交付日開始).concat(記号).concat(交付日終了);
        } else if (交付日開始.isEmpty() && !受理日開始.isEmpty() && 受理時刻開始.isEmpty()) {
            文字列 = 受理日.concat(受理日開始).concat(記号).concat(受理日終了);
        } else if (交付日開始.isEmpty() && 受理日開始.isEmpty() && !受理時刻開始.isEmpty()) {
            文字列 = 受理時刻.concat(受理時刻開始).concat(記号).concat(受理時刻終了);
        }
        return 文字列;
    }

    private RString edit不在者作成条件２件書式(RString 交付日開始, RString 交付日終了,
            RString 受理日開始, RString 受理日終了, RString 受理時刻開始, RString 受理時刻終了) {
        RString 文字列 = RString.EMPTY;
        if (!交付日開始.isEmpty() && !受理日開始.isEmpty() && 受理時刻開始.isEmpty()) {
            文字列 = 交付日.concat(交付日開始).concat(記号).concat(交付日終了).concat(全角スペース_2桁)
                    .concat(受理日).concat(受理日開始).concat(記号).concat(受理日終了);
        } else if (交付日開始.isEmpty() && !受理日開始.isEmpty() && !受理時刻開始.isEmpty()) {
            文字列 = 受理日.concat(受理日開始).concat(記号).concat(受理日終了).concat(全角スペース_2桁)
                    .concat(受理時刻).concat(受理時刻開始).concat(記号).concat(受理時刻終了);
        } else if (!交付日開始.isEmpty() && 受理日開始.isEmpty() && !受理時刻開始.isEmpty()) {
            文字列 = 交付日.concat(交付日開始).concat(記号).concat(交付日終了).concat(全角スペース_2桁)
                    .concat(受理時刻).concat(受理時刻開始).concat(記号).concat(受理時刻終了);
        }
        return 文字列;
    }

    private int 条件件数(RString 文字1, RString 文字2, RString 文字3) {
        int 件数 = 0;
        if (!文字1.isEmpty()) {
            件数++;
        }
        if (!文字2.isEmpty()) {
            件数++;
        }
        if (!文字3.isEmpty()) {
            件数++;
        }
        return 件数;
    }

    private RString get年齢(RDate 生年月日) {
        int currentYear = Integer.valueOf(RDate.getNowDate().getYear().toString());
        return new RString(currentYear - Integer.valueOf(生年月日.getYear().toString()));

    }

    private RString get生年月日(RDate 生年月日, RString 住民種別) {
        RString 生年月日_文字列 = RString.EMPTY;
        if (住民種別_日本人.equals(住民種別)) {
            生年月日_文字列 = 生年月日.wareki().toDateString();
        }
        if (住民種別_外国人.equals(住民種別)) {
            生年月日_文字列 = 生年月日.seireki().toDateString();
        }
        return 生年月日_文字列;
    }

    private RString get投票状況(RString 投票状況) {
        RString 投票状況_文字 = RString.EMPTY;
        if (投票状況_1.equals(投票状況)) {
            投票状況_文字 = new RString("請");
        }
        if (投票状況_2.equals(投票状況)) {
            投票状況_文字 = new RString("交");
        }
        if (投票状況_3.equals(投票状況)) {
            投票状況_文字 = new RString("受");
        }
        if (投票状況_4.equals(投票状況)) {
            投票状況_文字 = new RString("返");
        }
        if (投票状況_5.equals(投票状況)) {
            投票状況_文字 = new RString("棄");
        }
        if (投票状況_6.equals(投票状況)) {
            投票状況_文字 = new RString("前");
        }
        if (投票状況_8.equals(投票状況)) {
            投票状況_文字 = new RString("拒");
        }
        if (投票状況_9.equals(投票状況)) {
            投票状況_文字 = new RString("仮");
        }
        return 投票状況_文字;
    }

    private RString get方法等(RString 交付方法, boolean 代理投票有フラグ, boolean 点字フラグ) {
        RString 名称 = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), new Code(交付方法));
        RString 印字 = new RString("");
        if (代理投票有フラグ) {
            印字 = 文字_代;
        }
        if (点字フラグ) {
            印字 = 印字.concat(文字_点);
        }
        return changeNullToEmpty(名称).concat(全角スペース_1桁).concat(印字);
    }

    private RString changeNullToEmpty(RString 名称) {
        return 名称 == null ? RString.EMPTY : 名称;
    }

    private void edit改ページ(TohyoshaListSenkyoAllSource source) {
        if (data.get改頁リスト().size() >= 2
                && !RString.isNullOrEmpty(data.get改頁リスト().get(1))) {
            source.key2 = get改ページKey(data.get改頁リスト().get(1));
        }
        if (data.get改頁リスト().size() >= 1
                && !RString.isNullOrEmpty(data.get改頁リスト().get(0))) {
            source.key1 = get改ページKey(data.get改頁リスト().get(0));
        }
    }

    private RString get改ページKey(RString ページキー) {
        if (投票区コード名.equals(ページキー)) {
            return data.get投票状況Entity().get投票区();
        } else if (受付番号名.equals(ページキー)) {
            return data.get投票状況Entity().get受付番号();
        } else {
            return RString.EMPTY;
        }
    }

    private void editアクセスログ出力(TohyoshaListSenkyoAllSource source) {
        if (null != data.get投票状況Entity().get識別コード()) {
            source.識別コード = new ShikibetsuCode(data.get投票状況Entity().get識別コード());
        }
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get混在条件(RString 投票区コード開始, RString 投票区コード終了, RString 施設コード開始, RString 施設コード終了) {
        RString 条件_混在 = RString.EMPTY;
        if (投票区コード開始.isEmpty() && 施設コード開始.isEmpty()) {
            条件_混在 = new RString("指定なし");
        } else if (!投票区コード開始.isEmpty() && 施設コード開始.isEmpty()) {
            投票区コード_内容 = 投票区コード.concat(投票区コード開始).concat(記号).concat(投票区コード終了);
            条件_混在 = 投票区コード_内容;
        } else if (投票区コード開始.isEmpty() && !施設コード開始.isEmpty()) {
            施設コード_内容 = 施設コード.concat(施設コード開始).concat(記号).concat(施設コード終了);
            条件_混在 = 施設コード_内容;
        } else {
            投票区コード_内容 = 投票区コード.concat(投票区コード開始).concat(記号).concat(投票区コード終了);
            施設コード_内容 = 施設コード.concat(施設コード開始).concat(記号).concat(施設コード終了);
            条件_混在 = 投票区コード_内容.concat(全角スペース_2桁).concat(施設コード_内容);
        }
        return 条件_混在;
    }
}
