/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1020;

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
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaSeniKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaViewStateHolderKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.AFAGMG1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.dgKokuminShusei_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiHandler;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.senkyoshusei.SenkyoShuseiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMG1020 国民投票情報修正 <br />
 * KokuminTohyoJohoShuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public class KokuminTohyoJohoShusei {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.憲法改正国民投票;
    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString メニューID = new RString("AFAMNG1020");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyoJohoShuseiDiv
     * @return ResponseData<KokuminTohyoJohoShuseiDiv>
     */
    public ResponseData<KokuminTohyoJohoShuseiDiv> onLoad(KokuminTohyoJohoShuseiDiv mainPanel) {
        ResponseData<KokuminTohyoJohoShuseiDiv> response = new ResponseData<>();
        mainPanel.getKokuminShusei().getDgKokuminShusei().getDataSource().clear();
        if (!ResponseHolder.isReRequest()) {
            ViewStateHolder.put(AfaViewStateHolderKey.遷移元画面Key, AfaSeniKey.国民投票情報修正);

            mainPanel.getCcdKokuminShuseiShohon().initialize(SENKYO_SHURUI);
            int 抄本List = mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().getShohonListSize();
            if (抄本List == 0) {
                return ResponseData.of(mainPanel).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }
            RString shohon未来抄本番号 = mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().get一番近い未来抄本番号();
            if (!shohon未来抄本番号.isEmpty()) {
                mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().selectedShohon(shohon未来抄本番号);
            }

            RString 抄本番号 = mainPanel.getCcdKokuminShuseiShohon().getHidShohonNo();
            ShohonManager shohonManager = ShohonManager.createInstance();
            Shohon 抄本選挙情報 = shohonManager.get抄本(new ShohonNo(抄本番号));
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
                KokuminTohyoJohoShuseiHandler.of(mainPanel).set選挙一覧(KokuminShusei.setData(senkyo));
                KokuminTohyoJohoShuseiHandler.of(mainPanel).set抄本情報と選挙情報(mainPanel, senkyo);
            }
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMG1020TransitionEventName.メニューへ戻る).respond();
        }

        response.data = mainPanel;
        return response;
    }

    /**
     * 選挙一覧で無投票チェックボックスを選択時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyoJohoShuseiDiv
     * @return ResponseData<KokuminTohyoJohoShuseiDiv>
     */
    public ResponseData<KokuminTohyoJohoShuseiDiv> onChange_chkMutohyoSenkyoFlag(KokuminTohyoJohoShuseiDiv mainPanel) {

        Boolean 無投票フラグ = mainPanel.getKokuminShusei().getDgKokuminShusei().getClickedItem().getChkMutohyoSenkyoFlag();
        RDate 受付開始日 = RDate.getNowDate();
        if (mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtTohyoUketsukeYMD().getValue() != null) {
            受付開始日 = new RDate(mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報()
                    .getTxtTohyoUketsukeYMD().getValue().toString());

            if (!ResponseHolder.isReRequest() && 受付開始日.compareTo(RDate.getNowDate()) > 0) {
                return ResponseData.of(mainPanel).addMessage(AfWarningMessages.受付開始日経過.getMessage()).respond();
            }
        }
        if (!ResponseHolder.isReRequest() && 受付開始日.compareTo(RDate.getNowDate()) < 0 || 受付開始日.compareTo(RDate.getNowDate()) == 1) {
            mainPanel.getKokuminShusei().getDgKokuminShusei().getClickedItem().setChkMutohyoSenkyoFlag(無投票フラグ);
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            mainPanel.getKokuminShusei().getDgKokuminShusei().getClickedItem().setChkMutohyoSenkyoFlag(無投票フラグ);
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            mainPanel.getKokuminShusei().getDgKokuminShusei().getClickedItem().setChkMutohyoSenkyoFlag(!無投票フラグ);
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyoJohoShuseiDiv
     * @return ResponseData<KokuminTohyoJohoShuseiDiv>
     */
    public ResponseData<KokuminTohyoJohoShuseiDiv> onChange_ccdShohonNameList(KokuminTohyoJohoShuseiDiv mainPanel) {
        mainPanel.getCcdKokuminShuseiShohon().initialSetting();
        RString shohonNo = mainPanel.getCcdKokuminShuseiShohon().getHidShohonNo();
        if (RString.isNullOrEmpty(shohonNo)) {
            KokuminTohyoJohoShuseiHandler.of(mainPanel).clean選挙一覧();
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
                KokuminTohyoJohoShuseiHandler.of(mainPanel).set選挙一覧(KokuminShusei.setData(senkyo));
                KokuminTohyoJohoShuseiHandler.of(mainPanel).set抄本情報と選挙情報(mainPanel, senkyo);
                ViewStateHolder.put(ViewStateKeys.選挙情報, (Serializable) senkyo);
            } else {
                KokuminTohyoJohoShuseiHandler.of(mainPanel).clean選挙一覧();
                ViewStateHolder.remove(ViewStateKeys.選挙情報.toString());
            }
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 保存ボタンを押下するイベントメソッドです。
     *
     * @param mainPanel KokuminTohyoJohoShuseiDiv
     * @return ResponseData<KokuminTohyoJohoShuseiDiv>
     */
    public ResponseData<KokuminTohyoJohoShuseiDiv> onClick_btnUpdate(KokuminTohyoJohoShuseiDiv mainPanel) {
        ResponseData<KokuminTohyoJohoShuseiDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            int 投票状況の合計 = 0;
            ViewStateHolder.put(ViewStateKeys.投票状況の合計, 投票状況の合計);
            List<dgKokuminShusei_Row> 選挙リスト = mainPanel.getKokuminShusei().getDgKokuminShusei().getDataSource();
            List<SenkyoNo> 選挙番号リスト = new ArrayList<>();
            for (dgKokuminShusei_Row row : 選挙リスト) {
                if (row.getChkMutohyoSenkyoFlag()) {
                    選挙番号リスト.add(new SenkyoNo(row.getTxtNo()));
                }
            }
            if (!選挙番号リスト.isEmpty()) {
                SenkyoShuseiFinder finder = SenkyoShuseiFinder.createInstance();
                投票状況の合計 = finder.count投票状況By抄本選挙番号(
                        new ShohonNo(mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().getSelectedShohonNo()), 選挙番号リスト);
            }
            if (投票状況の合計 > 0) {
                ViewStateHolder.put(ViewStateKeys.投票状況の合計, 投票状況の合計);
                return ResponseData.of(mainPanel).addMessage(
                        AfWarningMessages.無投票入力_データ削除確認.getMessage().replace(String.valueOf(投票状況の合計))).respond();
            } else {
                return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }

        int 無投票の投票状況 = ViewStateHolder.get(ViewStateKeys.投票状況の合計, int.class);
        if (無投票の投票状況 > 0 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.投票状況の合計, 0);
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (無投票の投票状況 == 0 && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShohonManager manger = ShohonManager.createInstance();
            Boolean 完了状況 = manger.updateForSenkyoShusei(creat抄本情報(mainPanel), creat選挙情報(mainPanel));
            KanryoKakuninParameter paramter = new KanryoKakuninParameter();
            paramter.setメニューID(メニューID);
            paramter.set処理結果(完了状況);
            paramter.set抄本番号(new ShohonNo(mainPanel.getCcdKokuminShuseiShohon().getHidShohonNo()));
            paramter.set抄本名(mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtShohonName().getValue());
            ViewStateHolder.put(ViewStateKeys.完了確認, paramter);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMG1020TransitionEventName.更新).respond();
        }

        response.data = mainPanel;
        return response;
    }

    private Shohon creat抄本情報(KokuminTohyoJohoShuseiDiv mainPanel) {
        Shohon 抄本選挙情報 = ViewStateHolder.get(ViewStateKeys.選択した抄本情報, Shohon.class);
        ShohonBuilder 抄本選挙 = 抄本選挙情報.createBuilderForEdit();
        抄本選挙.set抄本名(mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtShohonName().getValue());
        抄本選挙情報 = 抄本選挙.build();
        return 抄本選挙情報;
    }

    private List<Senkyo> creat選挙情報(KokuminTohyoJohoShuseiDiv div) {
        List<Senkyo> 元選挙情報 = ViewStateHolder.get(ViewStateKeys.選挙情報, List.class);
        List<Senkyo> 選挙情報 = new ArrayList<>();
        List<dgKokuminShusei_Row> 選挙一覧情報 = div.getKokuminShusei().getDgKokuminShusei().getDataSource();
        for (dgKokuminShusei_Row row : 選挙一覧情報) {
            for (Senkyo senkyo : 元選挙情報) {
                if (row.getTxtNo().toString().equals(senkyo.get選挙番号().toString())) {
                    SenkyoBuilder builder = senkyo.createBuilderForEdit();
                    builder.set選挙名称(row.getTxtKaiseianName().getValue());
                    builder.set選挙略称(row.getTxtRyakusho().getValue());
                    builder.set無投票選挙フラグ(row.getChkMutohyoSenkyoFlag());
                    senkyo = builder.build();
                    選挙情報.add(senkyo);
                    break;
                }
            }
        }
        return 選挙情報;
    }

}
