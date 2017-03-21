/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB1020;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.SenkyoBuilder;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.ShohonBuilder;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.AFAGMB1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.SenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.dgSenkyoShusei_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020.SenkyoJohoShuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020.SenkyoJohoShuseiValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuDateKeisan;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.af.afa.service.senkyoshusei.SenkyoShuseiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMB1020　選挙　選挙情報修正 <br />
 * SenkyoJohoShuseiDivに対応するコントローラです。
 *
 */
public class SenkyoJohoShusei {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.国政選挙_地方選挙;
    private static final RString AFAGMB1020_選挙情報修正 = new RString("AFAGMB1020");
    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString シミュレーション選挙情報修正 = new RString("【シミュレーション】選挙情報修正");
    private static final RString 選挙情報修正 = new RString("選挙情報修正");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onLoad(SenkyoJohoShuseiDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            SenkyoJohoShuseiHandler handler = getHandler(mainPanel);
            ViewState.setメニューID(ResponseHolder.getMenuID());
            ViewStateHolder.put(ViewStateKeys.画面ID, AFAGMB1020_選挙情報修正);
            handler.set選挙情報入力の表示状態(Boolean.TRUE);
            mainPanel.getCcdSenkyoShuseiShohon().initialize(SENKYO_SHURUI);
            RString shohonNo = mainPanel.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo();
            if (RString.isNullOrEmpty(shohonNo)) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }
            ShohonManager shohonManager = ShohonManager.createInstance();
            Shohon 抄本選挙情報 = shohonManager.get抄本(new ShohonNo(shohonNo));
            ViewStateHolder.put(ViewStateKeys.選択した抄本情報, 抄本選挙情報);
            List<Senkyo> senkyo = 抄本選挙情報.getSenkyoList();
            ViewStateHolder.put(ViewStateKeys.選挙情報, (Serializable) senkyo);
            if (!senkyo.isEmpty()) {
                Collections.sort(senkyo, new Comparator<Senkyo>() {
                    @Override
                    public int compare(Senkyo o1, Senkyo o2) {
                        return o1.get選挙番号().compareTo(o2.get選挙番号());
                    }
                });
                handler.set選挙一覧(SenkyoShusei.setData(senkyo));
            }
            handler.set保存ボタンの状態(Boolean.FALSE);
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMB1020TransitionEventName.メニューへ戻る).respond();
        }

        RString rootTitle = 選挙情報修正;
        if (AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(ResponseHolder.getMenuID())) {
            rootTitle = シミュレーション選挙情報修正;
        }
        return ResponseData.of(mainPanel).rootTitle(rootTitle).respond();
    }

    /**
     * 選挙一覧で無投票チェックボックスを選択時のイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onChange_mutohyoSenkyoFlag(SenkyoJohoShuseiDiv div) {
        Boolean 無投票フラグ = div.getSenkyoShusei().getDgSenkyoShusei().getClickedItem().getChkMutohyoSenkyoFlag();
        if (!ResponseHolder.isReRequest() && RDate.getNowDate().compareTo(
                new RDate(div.getSenkyoShusei().getDgSenkyoShusei().getClickedItem().getTxtTohyoUketsukeYMD().getValue().toString())) > 0) {
            return ResponseData.of(div).addMessage(AfWarningMessages.受付開始日経過.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getSenkyoShusei().getDgSenkyoShusei().getClickedItem().setChkMutohyoSenkyoFlag(!無投票フラグ);
        } else {
            div.getSenkyoShusei().getDgSenkyoShusei().getClickedItem().setChkMutohyoSenkyoFlag(無投票フラグ);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onChange_ccdShohonNameList(SenkyoJohoShuseiDiv div) {
        SenkyoJohoShuseiHandler handler = getHandler(div);
        div.getCcdSenkyoShuseiShohon().getHandler().initialSetting();
        RString shohonNo = div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo();
        if (RString.isNullOrEmpty(shohonNo)) {
            handler.clean選挙一覧();
            ViewStateHolder.remove(ViewStateKeys.選択した抄本情報.toString());
            ViewStateHolder.remove(ViewStateKeys.選挙情報.toString());
        } else {
            ShohonManager shohonManager = ShohonManager.createInstance();
            Shohon 抄本選挙情報 = shohonManager.get抄本(new ShohonNo(shohonNo));
            ViewStateHolder.put(ViewStateKeys.選択した抄本情報, 抄本選挙情報);
            List<Senkyo> senkyo = 抄本選挙情報.getSenkyoList();
            if (!senkyo.isEmpty()) {
                Collections.sort(senkyo, new Comparator<Senkyo>() {
                    @Override
                    public int compare(Senkyo o1, Senkyo o2) {
                        return o1.get選挙番号().compareTo(o2.get選挙番号());
                    }
                });
                handler.set選挙一覧(SenkyoShusei.setData(senkyo));
                ViewStateHolder.put(ViewStateKeys.選挙情報, (Serializable) senkyo);
            } else {
                handler.clean選挙一覧();
                ViewStateHolder.remove(ViewStateKeys.選挙情報.toString());
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 選択情報修正の選挙追加ボタンを押下するイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onClick_addSenkyo(SenkyoJohoShuseiDiv div) {
        SenkyoJohoShuseiHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs
                    = new SenkyoJohoShuseiValidationHandler(div).senkyoAddValidateチェック();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            return ResponseData.of(div).addMessage(
                    AfWarningMessages.選挙追加確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.set選挙一覧の状態(Boolean.TRUE);
            handler.set選挙情報入力の表示状態(Boolean.FALSE);
            handler.set修正対象抄本の状態(Boolean.TRUE);
            RString shohonNo = div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo();
            if (!RString.isNullOrEmpty(shohonNo)) {
                SenkyoManager manager = SenkyoManager.createInstance();
                List<Senkyo> senkyo = manager.get選挙By抄本番号(new ShohonNo(shohonNo));
                handler.initial選挙情報入力By選挙追加(senkyo);
            }

            handler.set保存ボタンの状態(Boolean.TRUE);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 選挙情報入力の日付を自動設定するイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onBlur_calcDate(SenkyoJohoShuseiDiv div) {

        SenkyojiTourokuFinder finder = SenkyojiTourokuFinder.createInstance();
        RDate 基準日 = div.getSenkyoInput().getTxtKijunYMD().getValue();
        if (基準日 != null) {
            TeijiTourokuDateKeisan 日付の自動設定結果 = finder.calcDateInfo(new FlexibleDate(基準日.toDateString()));
            if (日付の自動設定結果 != null) {
                div.getSenkyoInput().getTxtTorokuYMD().setValue(
                        new RDate(日付の自動設定結果.get登録日().toString()));
                div.getSenkyoInput().getTxtTenshutsuKigenYMD().setValue(
                        new RDate(日付の自動設定結果.get転出期限日().toString()));
                div.getSenkyoInput().getTxtTennyuKigenYMD().setValue(
                        new RDate(日付の自動設定結果.get転入期限日().toString()));
                div.getSenkyoInput().getTxtKokujiYMD().setValue(
                        new RDate(日付の自動設定結果.get告示公示日().toString()));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択情報入力の選挙の追加をやめるボタンを押下するイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onClick_cancelSenkyo(SenkyoJohoShuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoName().getValue())
                    && RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoRyakusho().getValue())
                    && RString.isNullOrEmpty(div.getSenkyoInput().getTxtSenkyoMark().getValue())
                    && div.getSenkyoInput().getTxtKijunYMD().getValue() == null
                    && div.getSenkyoInput().getTxtUketsukeYMD().getValue() == null
                    && div.getSenkyoInput().getChkMutohyoFlag().getSelectedItems().isEmpty()
                    && div.getSenkyoInput().getDdlSenkyoLevel().getSelectedIndex() == 0) {
                SenkyoJohoShuseiHandler handler = getHandler(div);
                handler.set選挙情報入力の表示状態(Boolean.TRUE);
                handler.set選挙情報入力の必須チェック(Boolean.FALSE);
                handler.set選挙一覧の状態(Boolean.FALSE);
                handler.set修正対象抄本の状態(Boolean.FALSE);
                handler.set保存ボタンの状態(Boolean.FALSE);
            } else {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SenkyoJohoShuseiHandler handler = getHandler(div);
            handler.set選挙情報入力の表示状態(Boolean.TRUE);
            handler.set選挙情報入力の必須チェック(Boolean.FALSE);
            handler.set選挙一覧の状態(Boolean.FALSE);
            handler.set修正対象抄本の状態(Boolean.FALSE);
            handler.set保存ボタンの状態(Boolean.FALSE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択情報入力の選挙の追加をするボタンを押下するイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onClick_addInputSenkyo(SenkyoJohoShuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            Boolean isSimulation = Boolean.FALSE;
            if (AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(ResponseHolder.getMenuID())) {
                isSimulation = Boolean.TRUE;
            }
            ValidationMessageControlPairs controlPairs
                    = new SenkyoJohoShuseiValidationHandler(div).senkyoAddValidate関連チェック(isSimulation);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SenkyoJohoShuseiHandler handler = getHandler(div);
            Senkyo 選挙 = new Senkyo(new ShohonNo(div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo()),
                    new SenkyoNo(div.getSenkyoInput().getTxtSenkyoNo().getValue().intValue()));
            選挙 = creat選挙情報(選挙, div);
            SenkyoManager manager = SenkyoManager.createInstance();
            manager.save選挙(選挙);

            RString shohonNo = div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo();
            ShohonManager shohonManager = ShohonManager.createInstance();
            Shohon 抄本選挙情報 = shohonManager.get抄本(new ShohonNo(shohonNo));
            ViewStateHolder.put(ViewStateKeys.選択した抄本情報, 抄本選挙情報);
            List<Senkyo> senkyo = 抄本選挙情報.getSenkyoList();
            ViewStateHolder.put(ViewStateKeys.選挙情報, (Serializable) senkyo);
            if (!senkyo.isEmpty()) {
                Collections.sort(senkyo, new Comparator<Senkyo>() {
                    @Override
                    public int compare(Senkyo o1, Senkyo o2) {
                        return o1.get選挙番号().compareTo(o2.get選挙番号());
                    }
                });
                handler.set選挙一覧(SenkyoShusei.setData(senkyo));
            }
            handler.set選挙情報入力の表示状態(Boolean.TRUE);
            handler.set選挙情報入力の必須チェック(Boolean.FALSE);
            handler.set選挙一覧の状態(Boolean.FALSE);
            handler.set修正対象抄本の状態(Boolean.FALSE);
            handler.set保存ボタンの状態(Boolean.FALSE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンを押下するイベントメソッドです。
     *
     * @param div SenkyoJohoShuseiDiv
     * @return ResponseData<SenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyoJohoShuseiDiv> onClick_btnUpdate(SenkyoJohoShuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            int 投票状況の合計 = 0;
            ViewStateHolder.put(ViewStateKeys.投票状況の合計, 投票状況の合計);
            ValidationMessageControlPairs controlPairs
                    = new SenkyoJohoShuseiValidationHandler(div).senkyoUpdateValidate関連チェック();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            List<dgSenkyoShusei_Row> 選挙リスト = div.getSenkyoShusei().getDgSenkyoShusei().getDataSource();
            List<SenkyoNo> 選挙番号リスト = new ArrayList<>();
            for (dgSenkyoShusei_Row row : 選挙リスト) {
                if (row.getChkMutohyoSenkyoFlag()) {
                    選挙番号リスト.add(new SenkyoNo(row.getTxtNo()));
                }
            }
            if (!選挙番号リスト.isEmpty()) {
                SenkyoShuseiFinder finder = SenkyoShuseiFinder.createInstance();
                投票状況の合計 = finder.count投票状況By抄本選挙番号(
                        new ShohonNo(div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo()), 選挙番号リスト);
            }
            if (投票状況の合計 > 0) {
                ViewStateHolder.put(ViewStateKeys.投票状況の合計, 投票状況の合計);
                return ResponseData.of(div).addMessage(
                        AfWarningMessages.無投票入力_データ削除確認.getMessage().replace(String.valueOf(投票状況の合計))).respond();
            } else {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }
        int 無投票の投票状況 = ViewStateHolder.get(ViewStateKeys.投票状況の合計, int.class);
        if (無投票の投票状況 > 0 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.投票状況の合計, 0);
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (無投票の投票状況 == 0 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShohonManager manger = ShohonManager.createInstance();
            Boolean 完了状況 = manger.updateForSenkyoShusei(creat抄本情報(div), creat選挙情報(div));
            KanryoKakuninParameter paramter = new KanryoKakuninParameter();
            paramter.setメニューID(ResponseHolder.getMenuID());
            paramter.set処理結果(完了状況);
            paramter.set抄本番号(new ShohonNo(div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo()));
            paramter.set抄本名(div.getCcdSenkyoShuseiShohon().getTxtShohonName().getValue());
            ViewStateHolder.put(ViewStateKeys.完了確認, paramter);
            return ResponseData.of(div).forwardWithEventName(AFAGMB1020TransitionEventName.更新).respond();
        }

        return ResponseData.of(div).respond();
    }

    private SenkyoJohoShuseiHandler getHandler(SenkyoJohoShuseiDiv panel) {
        return new SenkyoJohoShuseiHandler(panel);
    }

    private Senkyo creat選挙情報(Senkyo 選挙, SenkyoJohoShuseiDiv div) {
        SenkyoBuilder builder = 選挙.createBuilderForEdit();
        builder.set選挙番号(new SenkyoNo(div.getSenkyoInput().getTxtSenkyoNo().getValue().intValue()));
        builder.set選挙レベル(new Code(div.getSenkyoInput().getDdlSenkyoLevel().getSelectedKey()));
        builder.set選挙名称(div.getSenkyoInput().getTxtSenkyoName().getValue());
        builder.set選挙略称(div.getSenkyoInput().getTxtSenkyoRyakusho().getValue());
        builder.set選挙マーク(div.getSenkyoInput().getTxtSenkyoMark().getValue());
        builder.set名簿基準年月日(new FlexibleDate(div.getSenkyoInput().getTxtKijunYMD().getValue().toDateString()));
        builder.set投票受付開始年月日(new FlexibleDate(div.getSenkyoInput().getTxtUketsukeYMD().getValue().toDateString()));
        builder.set名簿登録年月日(new FlexibleDate(div.getSenkyoInput().getTxtTorokuYMD().getValue().toDateString()));
        builder.set告示_公示年月日(new FlexibleDate(div.getSenkyoInput().getTxtKokujiYMD().getValue().toDateString()));
        builder.set転出期限年月日(new FlexibleDate(div.getSenkyoInput().getTxtTenshutsuKigenYMD().getValue().toDateString()));
        builder.set転入期限年月日(new FlexibleDate(div.getSenkyoInput().getTxtTennyuKigenYMD().getValue().toDateString()));
        if (div.getSenkyoInput().getChkMutohyoFlag().getSelectedItems().isEmpty()) {
            builder.set無投票選挙フラグ(Boolean.FALSE);
        } else {
            builder.set無投票選挙フラグ(Boolean.TRUE);
        }
        return builder.build();
    }

    private Shohon creat抄本情報(SenkyoJohoShuseiDiv div) {
        Shohon 抄本選挙情報 = ViewStateHolder.get(ViewStateKeys.選択した抄本情報, Shohon.class);
        ShohonBuilder 抄本選挙 = 抄本選挙情報.createBuilderForEdit();
        抄本選挙.set抄本名(div.getCcdSenkyoShuseiShohon().getTxtShohonName().getValue());
        抄本選挙情報 = 抄本選挙.build();
        return 抄本選挙情報;
    }

    private List<Senkyo> creat選挙情報(SenkyoJohoShuseiDiv div) {
        List<Senkyo> 元選挙情報 = ViewStateHolder.get(ViewStateKeys.選挙情報, List.class);
        List<Senkyo> 選挙情報 = new ArrayList<>();
        List<dgSenkyoShusei_Row> 選挙一覧情報 = div.getSenkyoShusei().getDgSenkyoShusei().getDataSource();
        for (dgSenkyoShusei_Row row : 選挙一覧情報) {
            for (Senkyo senkyo : 元選挙情報) {
                if (row.getTxtNo().toString().equals(senkyo.get選挙番号().toString())) {
                    SenkyoBuilder builder = senkyo.createBuilderForEdit();
                    builder.set選挙名称(row.getTxtSenkyoName().getValue());
                    builder.set選挙略称(row.getTxtSenkyoRyakusho().getValue());
                    builder.set選挙マーク(row.getTxtSenkyoMark().getValue());
                    builder.set無投票選挙フラグ(row.getChkMutohyoSenkyoFlag());
                    builder.set投票受付開始年月日(row.getTxtTohyoUketsukeYMD().getValue());
                    senkyo = builder.build();
                    選挙情報.add(senkyo);
                    break;
                }
            }
        }
        return 選挙情報;
    }
}
