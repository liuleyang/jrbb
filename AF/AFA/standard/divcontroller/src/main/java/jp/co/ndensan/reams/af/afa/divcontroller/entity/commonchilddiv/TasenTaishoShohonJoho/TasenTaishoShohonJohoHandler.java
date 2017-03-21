/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TasenTaishoShohonJoho;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TasenTaishoShohonJohoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTasenTaishoShohonJohoDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class TasenTaishoShohonJohoHandler {

    private final TasenTaishoShohonJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他選対象抄本情報Div
     */
    public TasenTaishoShohonJohoHandler(TasenTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     * @param displayMode DisplayMode 画面表示モード
     */
    public void initialize(SenkyoShurui senkyoShurui, DisplayMode displayMode) {
        if (displayMode == DisplayMode.修正) {
            div.getCcdShohonNameList().initialize(senkyoShurui);
        } else {
            div.getCcdShohonNameList().initialize(senkyoShurui, Boolean.TRUE);
        }

        div.getCcdSenkyoShurui().initialize();
        div.getCcdSenkyoShurui().initialize(new Code(senkyoShurui.getCode()));

        div.getCcdSenkyokuCode().initialize(senkyoShurui);

        setShiyoShohonMongon(RDate.getNowDate());

        if (!div.getCcdShohonNameList().getSelectedShohonNo().isEmpty()) {
            set選択抄本情報(div.getCcdShohonNameList().getSelectedShohonNo());
        }
    }

    public void clearThisPanel() {

        div.getCcdShohonNameList().selectedShohon(RString.EMPTY);
        div.getTxtShohonName().clearValue();
        div.getTxtSenkyoName().clearValue();

        div.getTxtTohyoYMD().clearValue();
        div.getTxtTohyoUketsukeYMD().clearValue();
        div.getChkMutohyo().getSelectedItems().clear();
        div.getCcdSenkyokuCode().clear();
        if (div.isDisabled()) {
            div.getCcdSenkyokuCode().setReadOnlyMode(Boolean.TRUE);
        }
    }

    public void set選択抄本情報(RString shohonNo) throws IllegalArgumentException {

        RString yamlShohonFile = new RString("ShohonNogyo.yml");
        List<HashMap> source = YamlLoader.loadAsList(yamlShohonFile);
        for (HashMap item : source) {
            if (new RString(item.get("key").toString()).equals(shohonNo)) {
                div.getTxtShohonName().setValue(YamlLoader.getStringText(item, "抄本名"));
                div.getTxtSenkyoName().setValue(YamlLoader.getStringText(item, "選挙名"));
                div.getTxtTohyoYMD().setValue(YamlLoader.getTextBoxDateText(item, "投票年月日").getValue());
                div.getTxtTohyoUketsukeYMD().setValue(YamlLoader.getTextBoxDateText(item, "受付開始日").getValue());
//                div.getCcdSenkyokuCode().getTxtSenkyokuCode().setValue(YamlLoader.getStringText(item, "選挙区コード"));
//                div.getCcdSenkyokuCode().getTxtSenkyokuName().setValue(YamlLoader.getStringText(item, "選挙区名"));
                div.getCcdSenkyokuCode().initialize(YamlLoader.getStringText(item, "選挙区コード"));
                break;
            }
        }
        setShiyoShohonMongon(div.getTxtTohyoYMD().getValue());
    }

    private void setShiyoShohonMongon(RDate kijunYmd) {
        // 本来は、投票年月日から年部分を取得する。（1月から3月は前年）
        div.getTxtShiyoShohon().setValue(new RString("平成26年3月31日確定の名簿抄本から作成します。"));
        kijunYmd.equals(kijunYmd);
    }

}
