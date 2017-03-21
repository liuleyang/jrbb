/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.tohyokekkaprint.AFABTE505BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaSakuseiChohyoNendaibetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaSakuseiChohyoNenreibetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME5050 投票結果集計表 のhandler
 *
 * @reamsid_L AF-0290-010 lit
 */
public class TohyoKekkaShukeiSakuseiHandler {

    private static final List<RString> NO_OPEN_PLANE = Arrays.asList(new RString("投票所時間別投票者集計表"));

    private final TohyoKekkaShukeiSakuseiDiv div;

    private enum EUC出力 {

        投票区行政区毎のEUCデータを作成する(new RString("1"), new RString("投票区行政区毎のEUCデータを作成する"));

        private final RString key;
        private final RString value;

        private EUC出力(RString key, RString value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 投票結果集計表Div
     */
    public TohyoKekkaShukeiSakuseiHandler(TohyoKekkaShukeiSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     *
     * @return Success : true || Fail : false
     */
    public boolean initialize() {
        ViewState.setメニューID(AFAMenuId.AFAMNE5050_投票結果集計表.menuId());
        div.getCcdTohyoKekkaShohonSenkyoList().initialize(SenkyoShurui.国政選挙_地方選挙);
        if (div.getCcdTohyoKekkaShohonSenkyoList().getCcdShohonNameList().getShohonListSize() == 0) {
            return false;
        }

        SenkyoShurui 選挙種類 = div.getCcdTohyoKekkaShohonSenkyoList().getCcdShohonNameList().getSelectedSenkyoShurui();
        TohyoKekkaSakuseiChohyoDiv chohyoDiv = div.getTohyoKekkaSakuseiChohyo();
        chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().getCcdNenreibetsuTohyokuCode().initialize(選挙種類);
        chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().getCcdNendaibetsuTohyokuCode().initialize(選挙種類);

        List<PanelPublish> list = getAllPanelPublish();
        for (PanelPublish panel : list) {
            if (!panel.isDisplayNone()) {
                setPanelProperty(panel, ConfigKeysAFA.toValue(new RString("帳票出力初期値_結果集計_").concat(panel.getTitle())));
            }
        }

        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValueDataSource(EUC出力.投票区行政区毎のEUCデータを作成する.key, EUC出力.投票区行政区毎のEUCデータを作成する.value));
        chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().getChkNenreibetsuEUC().setDataSource(keyValueList);
        chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().getChkNenreibetsuEUC().setSelectedItems(keyValueList);
        chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().getChkNendaibetsuEUC().setDataSource(keyValueList);
        chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().getChkNendaibetsuEUC().setSelectedItems(keyValueList);

        return true;
    }

    /**
     * 条件エリアのデータを設定する。
     */
    public void changeShohonName() {
        div.getCcdTohyoKekkaShohonSenkyoList().initialSetting();
    }

    /**
     * 帳票印刷
     *
     * @return AFABTE505BatchParameter AFABTE505BatchParameter
     */
    public AFABTE505BatchParameter createBatchParameter() {
        AFABTE505BatchParameter param = new AFABTE505BatchParameter();

        IShohonSenkyoListDiv 抄本選挙 = div.getCcdTohyoKekkaShohonSenkyoList();
        param.set抄本番号(抄本選挙.getCcdShohonNameList().getSelectedShohonNo());
        param.set選挙種類(抄本選挙.getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        param.set無投票選挙出力有無(抄本選挙.無投票選挙check());

        TohyoKekkaSakuseiChohyoDiv chohyoDiv = div.getTohyoKekkaSakuseiChohyo();
        TohyoKekkaSakuseiChohyoNendaibetsuDiv nendaibetsuDiv = chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu();
        param.set年代別集計表出力有無(nendaibetsuDiv.isIsPublish());
        param.set年代別集計表EUCフラグ(nendaibetsuDiv.getChkNendaibetsuEUC().isAllSelected());
        param.set年代別集計表投票区from(nendaibetsuDiv.getCcdNendaibetsuTohyokuCode().get投票区コードFROM());
        param.set年代別集計表投票区to(nendaibetsuDiv.getCcdNendaibetsuTohyokuCode().get投票区コードTO());

        TohyoKekkaSakuseiChohyoNenreibetsuDiv nenreibetsuDiv = chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu();
        param.set年齢別集計表出力有無(nenreibetsuDiv.isIsPublish());
        param.set年齢別集計表EUCフラグ(nenreibetsuDiv.getChkNenreibetsuEUC().isAllSelected());
        param.set年齢別集計表投票区from(nenreibetsuDiv.getCcdNenreibetsuTohyokuCode().get投票区コードFROM());
        param.set年齢別集計表投票区to(nenreibetsuDiv.getCcdNenreibetsuTohyokuCode().get投票区コードTO());

        param.set時間別集計表出力有無(chohyoDiv.getTohyoKekkaSakuseiChohyoJikanbetsu().isIsPublish());
        return param;
    }

    private List<PanelPublish> getAllPanelPublish() {
        List<PanelPublish> list = new ArrayList<>();
        TohyoKekkaSakuseiChohyoDiv chohyoDiv = div.getTohyoKekkaSakuseiChohyo();
        list.add(chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu());
        list.add(chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu());
        list.add(chohyoDiv.getTohyoKekkaSakuseiChohyoJikanbetsu());
        return list;
    }

    private void setPanelProperty(PanelPublish div, ConfigKeysAFA key) {
        div.setIsPublish(InnjiFlg.印字する.value().equals(BusinessConfig.get(key, SubGyomuCode.AFA選挙本体)));
        if (!NO_OPEN_PLANE.contains(div.getTitle())) {
            div.setIsOpen(false);
        }
    }

}
