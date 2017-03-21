/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.contexts.TohyoJiyuCodeContext;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * TohyoJiyuCodeDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyoJiyuCodeDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-013 liss
 */
public class TohyoJiyuCodeHandler {

    private final TohyoJiyuCodeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票事由コード入力Div
     */
    public TohyoJiyuCodeHandler(TohyoJiyuCodeDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     * @param tohyoJokyo TohyoJokyo
     */
    public void initialize(SenkyoShurui senkyoShurui, TohyoJokyo tohyoJokyo) {
        clearThisPanel();
        div.getTxtTohyoJiyuCode().setValue(this.get投票事由コード());
        div.getDdlTohyoJiyu().setDataSource(createDataSource(senkyoShurui));
        set投票事由();
    }

    /**
     * この共有子Divの初期表示を行います。
     *
     */
    public void initialSetting() {
        clearThisPanel();
        set投票事由();
    }

    /**
     * 引数の投票事由コードから、この共有子Divの初期表示を行います。
     *
     * @param code RString
     */
    public void setData(RString code) {
        div.getTxtTohyoJiyuCode().setValue(code);
        set投票事由();
    }

    public void set投票事由() {
        if (div.getTxtTohyoJiyuCode().getValue().isEmpty()) {
            div.getDdlTohyoJiyu().setSelectedKey(RString.EMPTY);
        }
        div.getDdlTohyoJiyu().setSelectedKey(div.getTxtTohyoJiyuCode().getValue());
    }

    /**
     * 画面クリアのメソッドです。
     *
     */
    public void clearThisPanel() {
        List<KeyValueDataSource> dataSource = div.getDdlTohyoJiyu().getDataSource();
        if (dataSource == null || dataSource.isEmpty()) {
            div.getTxtTohyoJiyuCode().clearValue();
            div.getDdlTohyoJiyu().setSelectedIndex(0);
        } else {
            div.getTxtTohyoJiyuCode().setValue(this.get投票事由コード());
            set投票事由();
        }
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.getTxtTohyoJiyuCode().setRequired(!readOnlySetMode);
        div.getDdlTohyoJiyu().setRequired(false);
        div.setReadOnly(readOnlySetMode);
    }

    private RString get投票事由コード() {
        RString menuID = ResponseHolder.getMenuID();
        if (menuID.equals(AFAMenuId.AFAMNE1010_期日前投票.menuId()) || menuID.equals(AFAMenuId.AFAMNE7010_期日前投票.menuId())) {
            return BusinessConfig.get(ConfigKeysAFA.期日前_投票事由の初期値, SubGyomuCode.AFA選挙本体);
        } else {
            return BusinessConfig.get(ConfigKeysAFA.不在者_投票事由の初期値, SubGyomuCode.AFA選挙本体);
        }
    }

    private List<KeyValueDataSource> createDataSource(SenkyoShurui senkyoShurui) {
        div.setInitialValue(senkyoShurui.getCode());
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            return CodeMasterHelper.createDataSource(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), Boolean.TRUE);
        } else {
            return CodeMasterHelper.createDataSource(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), Boolean.TRUE);
        }
    }

    /**
     * 投票事由コード存在を判断します
     *
     * @return 判断結果
     */
    public boolean is投票事由コード存在() {
        RString senkyoShurui = div.getInitialValue();
        RString 投票事由コード = div.getTxtTohyoJiyuCode().getValue();

        RString meisho;
        if (SenkyoShurui.憲法改正国民投票.getCode().equals(senkyoShurui)) {
            meisho = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(),
                    new Code(投票事由コード));
        } else {
            meisho = CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票事由コード.getCodeShubetsu(),
                    new Code(投票事由コード));
        }
        return !RString.isNullOrEmpty(meisho);
    }

    /**
     * 投票事由コードのContextを取得します。
     *
     * @return TohyoJiyuCodeContext 投票事由コードContext
     */
    public TohyoJiyuCodeContext getTohyoJiyuCodeContext() {
        return new TohyoJiyuCodeContext(new Code(div.getTxtTohyoJiyuCode().getValue()), div.getDdlTohyoJiyu().getDataSource());
    }

    public ResponseData<TohyoJiyuCodeDiv> onChange投票事由コード() {
        if (is事由名称存在()) {
            set投票事由();
            return ResponseData.of(div).respond();
        } else {
            div.getDdlTohyoJiyu().setSelectedIndex(0);
            return ResponseData.of(div)
                    .addMessage(UrErrorMessages.存在しない.getMessage()
                            .replace("投票事由コード")).respond();
        }
    }

    private Boolean is事由名称存在() {
        RString 投票事由コード = div.getTxtTohyoJiyuCode().getValue();
        List<KeyValueDataSource> keyValueDataSourceList = div.getDdlTohyoJiyu().getDataSource();
        Boolean flag = Boolean.FALSE;
        for (KeyValueDataSource keyValueDataSource : keyValueDataSourceList) {
            if (投票事由コード.equals(keyValueDataSource.getKey())) {
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }

}
