/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE504;

import jp.co.ndensan.reams.af.afa.business.core.TohyoJiyuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJiyuCode;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 投票事由調書
 *
 * @reamsid_L AF-0270-035 wangl
 */
public class TohyoJiyuChoshoEditor implements ITohyoJiyuChoshoEditor {

    private static final RString 帳票タイトル_期日前投票 = new RString("期日前投票の事由に関する調書");
    private static final RString 帳票タイトル_不在者投票 = new RString("不在者投票の事由に関する調書");
    private static final RString 投票状況_3 = new RString("3");
    private static final RString 投票状況_6 = new RString("6");
    private static final RString 選挙種類_2 = new RString("2");
    private static final RString 作成条件 = new RString("指定なし");
    private static final RString 記号 = new RString("～");
    private final TohyoJiyuChoshoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link TohyoJiyuChoshoParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public TohyoJiyuChoshoEditor(TohyoJiyuChoshoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public TohyoJiyuChoshoSource edit(TohyoJiyuChoshoSource source) {
        editヘッダ(source);
        edit事由(source);
        edit投票区(source);
        edit直接1(source);
        edit郵送1(source);
        edit計1(source);
        edit直接2(source);
        edit郵送2(source);
        edit計2(source);
        edit直接3(source);
        edit郵送3(source);
        edit計3(source);
        edit直接4(source);
        edit郵送4(source);
        edit計4(source);
        edit直接5(source);
        edit郵送5(source);
        edit計5(source);
        edit直接6(source);
        edit郵送6(source);
        edit計6(source);
        edit直接7(source);
        edit郵送7(source);
        edit計7(source);
        edit直接合計(source);
        edit郵送合計(source);
        edit計合計(source);
        edit作成条件(source);
        edit選挙番号(source);
        return source;
    }

    private void editヘッダ(TohyoJiyuChoshoSource source) {
        if (投票状況_6.equals(data.get投票状況Entity().get投票状況())) {
            source.title = 帳票タイトル_期日前投票;
        }
        if (投票状況_3.equals(data.get投票状況Entity().get投票状況())) {
            source.title = 帳票タイトル_不在者投票;
        }
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.senkyoMei = 帳票共通ヘッダー.get選挙名称();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void edit作成条件(TohyoJiyuChoshoSource source) {
        if (投票状況_6.equals(data.get投票状況Entity().get投票状況())) {
            RString 期日前投票日開始 = null == data.get期日前投票日開始() ? RString.EMPTY : data.get期日前投票日開始().wareki().toDateString();
            RString 期日前投票日終了 = null == data.get期日前投票日終了() ? RString.EMPTY : data.get期日前投票日終了().wareki().toDateString();
            if (期日前投票日開始 != RString.EMPTY) {
                source.sakuseiJoken1 = 計算投票日(期日前投票日開始, 期日前投票日終了);
            } else {
                source.sakuseiJoken1 = new RString("投票年月日：").concat(作成条件);
            }
        }
        if (投票状況_3.equals(data.get投票状況Entity().get投票状況())) {
            RString 受理日開始 = null == data.get受理日開始() ? RString.EMPTY : data.get受理日開始().wareki().toDateString();
            RString 受理日終了 = null == data.get受理日終了() ? RString.EMPTY : data.get受理日終了().wareki().toDateString();
            if (受理日開始 != RString.EMPTY) {
                source.sakuseiJoken1 = 計算投票日(受理日開始, 受理日終了);
            } else {
                source.sakuseiJoken1 = new RString("投票年月日：").concat(作成条件);
            }
        }
    }

    private void edit事由(TohyoJiyuChoshoSource source) {
        RString 選挙種類 = data.get投票状況Entity().get選挙種類();
        if (選挙種類_2.equals(選挙種類)) {
            source.jiyuTitle1 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.仕事等.getCode()));

            source.jiyuTitle2 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.旅行等.getCode()));

            source.jiyuTitle3 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.病院_施設等.getCode()));

            source.jiyuTitle4 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.交通至難等.getCode()));

            source.jiyuTitle5 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.住所移転.getCode()));

            source.jiyuTitle6 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.重度の障害.getCode()));

            source.jiyuTitle7 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.特定国外.getCode()));
        } else {
            source.jiyuTitle1 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.仕事等.getCode()));

            source.jiyuTitle2 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.旅行等.getCode()));

            source.jiyuTitle3 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.病院_施設等.getCode()));

            source.jiyuTitle4 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.交通至難等.getCode()));

            source.jiyuTitle5 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.住所移転.getCode()));

            source.jiyuTitle6 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.重度の障害.getCode()));

            source.jiyuTitle7 = CodeMaster.getOption2(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(TohyoJiyuCode.特定国外.getCode()));
        }
    }

    private void edit投票区(TohyoJiyuChoshoSource source) {
        source.listMeisai_1 = data.get投票状況Entity().get投票区();
    }

    private void edit直接1(TohyoJiyuChoshoSource source) {
        source.listMeisai_2 = data.get直接1();
    }

    private void edit郵送1(TohyoJiyuChoshoSource source) {
        source.listMeisai_3 = data.get郵送1();
    }

    private void edit計1(TohyoJiyuChoshoSource source) {
        source.listMeisai_4 = data.get計1();
    }

    private void edit直接2(TohyoJiyuChoshoSource source) {
        source.listMeisai_5 = data.get直接2();
    }

    private void edit郵送2(TohyoJiyuChoshoSource source) {
        source.listMeisai_6 = data.get郵送2();
    }

    private void edit計2(TohyoJiyuChoshoSource source) {
        source.listMeisai_7 = data.get計2();
    }

    private void edit直接3(TohyoJiyuChoshoSource source) {
        source.listMeisai_8 = data.get直接3();
    }

    private void edit郵送3(TohyoJiyuChoshoSource source) {
        source.listMeisai_9 = data.get郵送3();
    }

    private void edit計3(TohyoJiyuChoshoSource source) {
        source.listMeisai_10 = data.get計3();
    }

    private void edit直接4(TohyoJiyuChoshoSource source) {
        source.listMeisai_11 = data.get直接4();
    }

    private void edit郵送4(TohyoJiyuChoshoSource source) {
        source.listMeisai_12 = data.get郵送4();
    }

    private void edit計4(TohyoJiyuChoshoSource source) {
        source.listMeisai_13 = data.get計4();
    }

    private void edit直接5(TohyoJiyuChoshoSource source) {
        source.listMeisai_14 = data.get直接5();
    }

    private void edit郵送5(TohyoJiyuChoshoSource source) {
        source.listMeisai_15 = data.get郵送5();
    }

    private void edit計5(TohyoJiyuChoshoSource source) {
        source.listMeisai_16 = data.get計5();
    }

    private void edit直接6(TohyoJiyuChoshoSource source) {
        source.listMeisai_17 = data.get直接6();
    }

    private void edit郵送6(TohyoJiyuChoshoSource source) {
        source.listMeisai_18 = data.get郵送6();
    }

    private void edit計6(TohyoJiyuChoshoSource source) {
        source.listMeisai_19 = data.get計6();
    }

    private void edit直接7(TohyoJiyuChoshoSource source) {
        source.listMeisai_20 = data.get直接7();
    }

    private void edit郵送7(TohyoJiyuChoshoSource source) {
        source.listMeisai_21 = data.get郵送7();
    }

    private void edit計7(TohyoJiyuChoshoSource source) {
        source.listMeisai_22 = data.get計7();
    }

    private void edit直接合計(TohyoJiyuChoshoSource source) {
        source.listMeisai_23 = data.get直接合計();
    }

    private void edit郵送合計(TohyoJiyuChoshoSource source) {
        source.listMeisai_24 = data.get郵送合計();
    }

    private void edit計合計(TohyoJiyuChoshoSource source) {
        source.listMeisai_25 = data.get計合計();
    }

    private void edit選挙番号(TohyoJiyuChoshoSource source) {
        source.senkyoNo = data.get投票状況Entity().get選挙番号();
    }

    private RString 計算投票日(RString 投票日開始, RString 投票日終了) {
        return new RString("投票年月日：").concat(投票日開始).concat(記号).concat(投票日終了);
    }
}
