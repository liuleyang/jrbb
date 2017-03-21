/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JotaiHenkoDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.JotaiHenkoJoho;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.JotaiHenkoModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.JotaiHenkoMybatisParameter;
import jp.co.ndensan.reams.af.afa.service.core.mutohyonyuryoku.MutohyoNyuryokuManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ダイアログに対するハンドラークラスです。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
public class JotaiHenkoDialogHandler {

    private final JotaiHenkoDialogDiv div;
    List<JotaiHenkoJoho> jotaiHenkoJohoList = new ArrayList<>();
    private static final KeyValueDataSource 棄権 = new KeyValueDataSource(new RString("5"), new RString("棄権"));
    private static final KeyValueDataSource 当日 = new KeyValueDataSource(new RString("7"), new RString("当日"));

    /**
     * コンストラクタです。
     *
     * @param div JotaiHenkoDialogDiv
     */
    public JotaiHenkoDialogHandler(JotaiHenkoDialogDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッドです。
     *
     * @param model JotaiHenkoModel
     */
    public void initialize(JotaiHenkoModel model) {
        div.getTxtGroupCode().setDisplayNone(BusinessConfig.get(ConfigKeysAFA.抄本_グループコード, SubGyomuCode.AFA選挙本体).equals(AFAConfigKeysValue.抄本_グループコード_未使用.configKeyValue()));
        List<TextBox> txtNoList = getTxtNoList();
        List<TextBox> txtSenkyoMeiList = getTxtSenkyoMeiList();
        List<TextBox> txtTohyoJokyoList = getTxtTohyoJokyoList();
        List<DropDownList> ddlTohyoJokyoList = getDdlTohyoJokyoList();
        List<Label> labelTohyoJokyoList = getLabelTohyoJokyoList();
        JotaiHenkoMybatisParameter para = new JotaiHenkoMybatisParameter(model.getShohonNo(), model.getShikibetsuCode());
        MutohyoNyuryokuManager manager = MutohyoNyuryokuManager.createInstance();
        jotaiHenkoJohoList = manager.get状態変更情報(para);
        div.getCcdMeiboBango().initialize();
        div.getTxtShikibetsuCode().setDomain(model.getShikibetsuCode());
        div.getTxtShimei().setDomain(model.getMeisho());
        div.getTxtSetaiCode().setDomain(model.getSetaiCode());
        div.getTxtGroupCode().setValue(model.getGroupCode());
        div.getTxtTohyokuCode().setValue(model.getTohyokuCode());
        div.getCcdMeiboBango().initialize(model.getSatsu(), model.getPage(), model.getGyo());
        //一覧エリアの初期化
        for (int i = 0; i < 9; i++) {
            if (jotaiHenkoJohoList != null && i < jotaiHenkoJohoList.size()) {
                initialize一覧(txtNoList.get(i), txtSenkyoMeiList.get(i), txtTohyoJokyoList.get(i), ddlTohyoJokyoList.get(i), labelTohyoJokyoList.get(i), jotaiHenkoJohoList.get(i));
            } else {
                set非表示(txtNoList.get(i), txtSenkyoMeiList.get(i), txtTohyoJokyoList.get(i), ddlTohyoJokyoList.get(i));
            }
        }

    }

    /**
     * 投票状況を保存します。
     */
    public void save() {
        MutohyoNyuryokuManager manager = MutohyoNyuryokuManager.createInstance();
        List<DropDownList> ddlTohyoJokyoList = getDdlTohyoJokyoList();
        List<Label> labelTohyoJokyoList = getLabelTohyoJokyoList();

        for (int i = 0; i < 9; i++) {
            if (!ddlTohyoJokyoList.get(i).isDisplayNone() && !labelTohyoJokyoList.get(i).getText().isEmpty()) {
                RString tohyoJokyoCode = ddlTohyoJokyoList.get(i).getSelectedKey();
                manager.saveJotaiHenko(labelTohyoJokyoList.get(i).getText(), tohyoJokyoCode);
            }
        }
    }

    private void initialize一覧(TextBox txtNo, TextBox txtSenkyoMei, TextBox txtTohyoJokyo, DropDownList ddlTohyoJokyo, Label labelTohyoJokyo, JotaiHenkoJoho 状態変更情報) {
        txtNo.setValue(状態変更情報.getSenkyoNo());
        txtSenkyoMei.setValue(状態変更情報.getSenkyoName());
        if (is棄権Or当日(状態変更情報)) {
            txtTohyoJokyo.setDisplayNone(true);
            ddlTohyoJokyo.setDataSource(createDataSourceForDdlTohyoJokyo());
            ddlTohyoJokyo.setSelectedKey(状態変更情報.getTohyoJokyo().value());
            labelTohyoJokyo.setText(状態変更情報.toTohyoJokyo());
        } else if (状態変更情報.getTohyoJokyoEntity() == null) {
            txtTohyoJokyo.setDisplayNone(true);
            ddlTohyoJokyo.setDataSource(createDataSourceForDdlTohyoJokyo());
            ddlTohyoJokyo.setSelectedKey(当日.getKey());
            labelTohyoJokyo.setText(状態変更情報.toTohyoJokyo());
        } else {
            txtTohyoJokyo.setValue(状態変更情報.getTohyoJokyo().isEmpty() ? RString.EMPTY : new TohyoJokyo(状態変更情報.getTohyoJokyo()).getMeisho());
            ddlTohyoJokyo.setDisplayNone(true);
        }
    }

    private void set非表示(TextBox txtNo, TextBox txtSenkyoMei, TextBox txtTohyoJokyo, DropDownList ddlTohyoJokyo) {
        txtNo.setDisplayNone(true);
        txtSenkyoMei.setDisplayNone(true);
        txtTohyoJokyo.setDisplayNone(true);
        ddlTohyoJokyo.setDisplayNone(true);
    }

    private List<KeyValueDataSource> createDataSourceForDdlTohyoJokyo() {
        return Arrays.asList(棄権, 当日);
    }

    private boolean is棄権Or当日(JotaiHenkoJoho 状態情報) {
        return 状態情報.getTohyoJokyoEntity() != null && (状態情報.getTohyoJokyo().getColumnValue().equals(棄権.getKey()) || 状態情報.getTohyoJokyo().getColumnValue().equals(当日.getKey()));
    }

    /**
     * 投票状況リストの取得メソッドです。
     *
     * @return 投票状況リスト　List<RString>
     */
    public List<RString> get投票状況リストFromDDL() {
        List<RString> 投票状況リスト = new ArrayList<>();
        List<DropDownList> ddlTohyoJokyoList = getDdlTohyoJokyoList();
        for (int i = 0; i < 9; i++) {
            投票状況リスト.add(ddlTohyoJokyoList.get(i).isDisplayNone() ? RString.EMPTY : ddlTohyoJokyoList.get(i).getSelectedValue());
        }
        return 投票状況リスト;
    }

    private List<TextBox> getTxtNoList() {
        return Arrays.asList(div.getTxtNo1(),
                div.getTxtNo2(),
                div.getTxtNo3(),
                div.getTxtNo4(),
                div.getTxtNo5(),
                div.getTxtNo6(),
                div.getTxtNo7(),
                div.getTxtNo8(),
                div.getTxtNo9());
    }

    private List<TextBox> getTxtSenkyoMeiList() {
        return Arrays.asList(div.getTxtSenkyoMei1(),
                div.getTxtSenkyoMei2(),
                div.getTxtSenkyoMei3(),
                div.getTxtSenkyoMei4(),
                div.getTxtSenkyoMei5(),
                div.getTxtSenkyoMei6(),
                div.getTxtSenkyoMei7(),
                div.getTxtSenkyoMei8(),
                div.getTxtSenkyoMei9());
    }

    private List<TextBox> getTxtTohyoJokyoList() {
        return Arrays.asList(div.getTxtTohyoJokyo1(),
                div.getTxtTohyoJokyo2(),
                div.getTxtTohyoJokyo3(),
                div.getTxtTohyoJokyo4(),
                div.getTxtTohyoJokyo5(),
                div.getTxtTohyoJokyo6(),
                div.getTxtTohyoJokyo7(),
                div.getTxtTohyoJokyo8(),
                div.getTxtTohyoJokyo9());
    }

    private List<DropDownList> getDdlTohyoJokyoList() {
        return Arrays.asList(div.getDdlTohyoJokyo1(),
                div.getDdlTohyoJokyo2(),
                div.getDdlTohyoJokyo3(),
                div.getDdlTohyoJokyo4(),
                div.getDdlTohyoJokyo5(),
                div.getDdlTohyoJokyo6(),
                div.getDdlTohyoJokyo7(),
                div.getDdlTohyoJokyo8(),
                div.getDdlTohyoJokyo9());
    }

    private List<Label> getLabelTohyoJokyoList() {
        return Arrays.asList(div.getLabelTohyoJokyo1(),
                div.getLabelTohyoJokyo2(),
                div.getLabelTohyoJokyo3(),
                div.getLabelTohyoJokyo4(),
                div.getLabelTohyoJokyo5(),
                div.getLabelTohyoJokyo6(),
                div.getLabelTohyoJokyo7(),
                div.getLabelTohyoJokyo8(),
                div.getLabelTohyoJokyo9());
    }
}
