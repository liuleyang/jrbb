/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.AFABTB202BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.SenkyoninIrain;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.dgShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.dgNyujokenKobetsuTaishosha_Row;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 入場券発行（個別）Handlerクラスです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public final class NyujokenSakuseiKobetsuHandler {

    private final NyujokenSakuseiKobetsuDiv div;
    private static final RString 固定文字 = new RString("Sample");
    private static final RString シミュレーション入場券発行個別 = new RString("【シミュレーション】入場券発行（個別）");
    private static final RString 入場券発行個別 = new RString("入場券発行（個別）");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private NyujokenSakuseiKobetsuHandler(NyujokenSakuseiKobetsuDiv div) {
        this.div = div;
    }

    /**
     * 在外選挙人名簿登録のHandler初期化
     *
     * @param div 在外選挙人名簿登録DIV
     * @return 在外選挙人名簿登録のHandler
     */
    public static NyujokenSakuseiKobetsuHandler of(NyujokenSakuseiKobetsuDiv div) {
        return new NyujokenSakuseiKobetsuHandler(div);
    }

    /**
     * 画面状態を設定する。
     *
     * @param 印刷タイプ RString
     */
    public void set画面状態(RString 印刷タイプ) {
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText1().setDisabled(false);
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText2().setDisabled(false);
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText3().setDisabled(false);
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getBtnSearchSimple().setDisabled(false);
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtNyujokenType().setDisabled(true);
        if (new RString("0").equals(印刷タイプ) || new RString("1").equals(印刷タイプ)) {
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setDisplayNone(true);
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getRadHakkoTani().setDisabled(false);
        }

        if (new RString("2").equals(印刷タイプ) || new RString("3").equals(印刷タイプ)) {
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setDisabled(true);
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getRadHakkoTani().setDisplayNone(true);
        }

    }

    /**
     * 画面タイトルを設定する。
     *
     * @param menuId RString
     * @return RString Title
     */
    public RString setTitle(RString menuId) {
        RString rootTitle = 入場券発行個別;
        if (AFAMenuId.AFAMNA2010_定時登録.menuId().equals(menuId) || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4030_入場券発行個別.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7010_期日前投票.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7020_当日投票.menuId().equals(menuId)) {
            rootTitle = シミュレーション入場券発行個別;
        }
        return rootTitle;
    }

    /**
     * 「選挙人を検索する」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check入力内容() {
        ValidationMessageControlPairs controlErrorPairs = new NyujokenSakuseiKobetsuValidationHandler(div).validateエラーチェックです();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlWarningPairs = new NyujokenSakuseiKobetsuValidationHandler(div).validateウォーニングチェックです();
            if (controlWarningPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlWarningPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下のチェックする。
     *
     * @param menuId RString
     * @return parameter AFABTB202BatchParameter
     */
    public AFABTB202BatchParameter set画面入力内容(RString menuId) {
        AFABTB202BatchParameter parameter = new AFABTB202BatchParameter();
        parameter.set抄本番号(div.getCcdNyujokenKobetsuShohonSelect().get抄本番号());
        parameter.set選挙種類(div.getCcdNyujokenKobetsuShohonSelect().get選挙種類());
        RString 抄本名 = div.getCcdNyujokenKobetsuShohonSelect().get抄本選択共有情報().getHidShohonName();
        parameter.set抄本名(抄本名 == null ? RString.EMPTY : 抄本名);
        parameter.set投票日(FlexibleDate.EMPTY);
        if (div.getCcdNyujokenKobetsuShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue() != null) {
            parameter.set投票日(new FlexibleDate(div.getCcdNyujokenKobetsuShohonSelect().get抄本選択共有情報().getTxtTohyoYMD().getValue().toDateString()));
        }
        parameter.set入場券名1(div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText1().getValue());
        parameter.set入場券名2(div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText2().getValue());
        parameter.set入場券名3(div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtFreeText3().getValue());
        parameter.set印刷タイプ(AFAInsakuTypeEnum.getAFAInsakuTypeEnumByValue(
                div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtNyujokenType().getValue()).getKey());
        if (!div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().isDisplayNone()) {
            parameter.set世帯印字人数(new RString(div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().getValue().toString()));
        }
        parameter.set対象者を個々に作成する有無(Boolean.FALSE);
        parameter.set対象者の世帯で作成する有無(Boolean.FALSE);
        RString 対象者rad = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getRadHakkoTani().getSelectedKey();
        if (!div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getRadHakkoTani().isDisplayNone()) {
            if (対象者rad.equals(new RString("key0"))) {
                parameter.set対象者を個々に作成する有無(Boolean.TRUE);
                parameter.set対象者の世帯で作成する有無(Boolean.FALSE);
            } else {
                parameter.set対象者を個々に作成する有無(Boolean.FALSE);
                parameter.set対象者の世帯で作成する有無(Boolean.TRUE);

            }
        }

        List<Senkyomeishou> 選挙リスト = new ArrayList<>();

        List<dgShohonSelect_Row> dgShohonSelect_Row = div.getCcdNyujokenKobetsuShohonSelect().get抄本選択共有情報().getDgShohonSelect().getDataSource();
        for (dgShohonSelect_Row shohonSelect : dgShohonSelect_Row) {
            Senkyomeishou senkyomeishou = new Senkyomeishou();
            senkyomeishou.set選挙名称(shohonSelect.getTxtSenkyoName());
            senkyomeishou.set選挙略称(shohonSelect.getTxtLevel());
            senkyomeishou.set選挙番号(shohonSelect.getTxtNo());
            選挙リスト.add(senkyomeishou);
        }

        parameter.set選挙リスト(選挙リスト);

        List<SenkyoninIrain> 選挙人一覧リスト = new ArrayList<>();
        List<dgNyujokenKobetsuTaishosha_Row> dataList = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku()
                .getDgNyujokenKobetsuTaishosha().getDataSource();
        for (dgNyujokenKobetsuTaishosha_Row nyujokenKobetsuTaishosha_Row : dataList) {
            SenkyoninIrain senkyoninIrain = new SenkyoninIrain();
            senkyoninIrain.set世帯コード(new SetaiCode(nyujokenKobetsuTaishosha_Row.getTxtSetaiCode()));
            senkyoninIrain.set識別コード(new ShikibetsuCode(nyujokenKobetsuTaishosha_Row.getTxtShikibetsuCode()));
            選挙人一覧リスト.add(senkyoninIrain);
        }

        parameter.set選挙人一覧リスト(選挙人一覧リスト);

        RString サンプル文字 = setサンプル文字(menuId);
        parameter.setサンプル文字(サンプル文字);
        return parameter;
    }

    private RString setサンプル文字(RString menuId) {
        RString サンプル文字 = RString.EMPTY;
        if (AFAMenuId.AFAMNA2010_定時登録.menuId().equals(menuId) || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4030_入場券発行個別.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7010_期日前投票.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7020_当日投票.menuId().equals(menuId)) {
            サンプル文字 = 固定文字;
        }
        return サンプル文字;
    }

}
