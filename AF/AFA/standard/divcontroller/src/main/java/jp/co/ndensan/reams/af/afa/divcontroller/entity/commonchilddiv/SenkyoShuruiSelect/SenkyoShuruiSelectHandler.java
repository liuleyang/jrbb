/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * SenkyoShuruiSelectDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してSenkyoShuruiSelectDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0180-012 liuyj
 */
public class SenkyoShuruiSelectHandler {

    private final SenkyoShuruiSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙種類リストDiv
     */
    public SenkyoShuruiSelectHandler(SenkyoShuruiSelectDiv div) {
        this.div = div;
    }

    /**
     * この共有子Divを使用する時に必ず呼ぶメソッドです。<br />
     * メニューIDから、初期表示する選挙種類を判断し、自動セットします。
     *
     */
    public void initialize() {
        RString メニューID = ResponseHolder.getMenuID();
        set選挙種類(メニューID);
    }

    /**
     * この共有子Divを使用する時に必ず呼ぶメソッドです。<br />
     * 引数の選挙種類を初期表示します。<br />
     * あらかじめ、選挙種類がわかっている場合は、こちらを使用してください。
     *
     * @param senkyoShurui 選挙種類
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        div.getDdlSenkyoShurui().setDataSource(CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙種類.getCodeShubetsu()));

        initialize(new Code(senkyoShurui.getCode()));
    }

    /**
     * この共有子Divを使用する時に必ず呼ぶメソッドです。<br />
     * 引数の選挙資格種類を初期表示します。<br />
     * あらかじめ、選挙資格種類がわかっている場合は、こちらを使用してください。
     *
     * @param sennkyoSikakuShurui 選挙資格種類
     */
    public void initialize(SennkyoSikakuShurui sennkyoSikakuShurui) {
        div.getDdlSenkyoShurui().setDataSource(CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格種類.getCodeShubetsu()));

        initialize(new Code(sennkyoSikakuShurui.value()));
    }

    /**
     * 引数のコードから、ドロップダウンリストの初期表示を行う。
     *
     * @param code 選挙種類コード
     */
    public void initialize(Code code) {
        div.getDdlSenkyoShurui().setSelectedKey(code.getColumnValue());
    }

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        div.setDisplayNone(displayNoneSetMode);
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlyMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlyMode) {
        div.setReadOnly(readOnlyMode);
    }

    /**
     * 選択されている選挙種類を取得します。
     *
     * @return 選挙種類
     */
    public SenkyoShurui getSelectedSenkyoShurui() {
        return SenkyoShurui.toValue(div.getDdlSenkyoShurui().getSelectedKey());
    }

    /**
     * 選択されている選挙資格種類を取得します。
     *
     * @return 選挙資格種類
     */
    public SennkyoSikakuShurui getSelectedSennkyoSikakuShurui() {
        return SennkyoSikakuShurui.toValue(div.getDdlSenkyoShurui().getSelectedKey());
    }

    /**
     * メニューIDがメニューID状況1のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況1(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNA1020_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNH1010_直接請求時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND2010_定時登録.menuId());
    }

    /**
     * メニューIDがメニューID状況2のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況2(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNB1030_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMND2020_選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND2040_在外選挙.menuId());
    }

    /**
     * メニューIDがメニューID状況3のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況3(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNG1040_投票人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMND2030_国民投票.menuId());
    }

    /**
     * メニューIDがメニューID状況4のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況4(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNK1020_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMND2050_海区漁業調整委員会委員選挙.menuId());
    }

    /**
     * メニューIDがメニューID状況5のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況5(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1010_定時登録選挙時登録.menuId());
    }

    /**
     * メニューIDがメニューID状況6のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況6(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNM2011_投票区保守憲法改正国民投票.menuId());
    }

    /**
     * メニューIDがメニューID状況7のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況7(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId());
    }

    /**
     * メニューIDがメニューID状況8のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況8(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId())
                || menuID.equals(AFAMenuId.AFAMNM2012_投票区保守海区漁業調整委員会委員選挙.menuId());
    }

    /**
     * メニューIDがメニューID状況9のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況9(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNM2030_選挙区保守.menuId())
                || menuID.equals(AFAMenuId.AFAMNM2040_投票区投票所対応保守.menuId());
    }

    private void set選挙種類(RString menuId) {
        div.getDdlSenkyoShurui().setDisabled(Boolean.TRUE);
        Boolean is選挙種類 = Boolean.FALSE;
        SenkyoShurui senkyoShurui = SenkyoShurui.国政選挙_地方選挙;
        SennkyoSikakuShurui sennkyoSikakuShurui = SennkyoSikakuShurui.通常選挙;
        if (isメニューID状況1(menuId)) {
            senkyoShurui = SenkyoShurui.定時登録;
            is選挙種類 = Boolean.TRUE;
        } else if (isメニューID状況2(menuId)) {
            senkyoShurui = SenkyoShurui.国政選挙_地方選挙;
            is選挙種類 = Boolean.TRUE;
        } else if (isメニューID状況3(menuId)) {
            senkyoShurui = SenkyoShurui.憲法改正国民投票;
            is選挙種類 = Boolean.TRUE;
        } else if (isメニューID状況4(menuId)) {
            senkyoShurui = SenkyoShurui.海区漁業調整委員会委員選挙;
            is選挙種類 = Boolean.TRUE;
        } else if (isメニューID状況5(menuId)) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.通常選挙;
            is選挙種類 = Boolean.FALSE;
        } else if (isメニューID状況6(menuId)) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.憲法改正国民投票;
            is選挙種類 = Boolean.FALSE;
        } else if (isメニューID状況7(menuId)) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.在外投票;
            is選挙種類 = Boolean.FALSE;
        } else if (isメニューID状況8(menuId)) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.海区漁業調整委員会委員選挙;
            is選挙種類 = Boolean.FALSE;
        } else if (menuId.equals(AFAMenuId.AFAMNM2013_投票区保守財産区議会議員選挙.menuId())) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.財産区議会議員選挙;
            is選挙種類 = Boolean.FALSE;
        } else if (menuId.equals(AFAMenuId.AFAMNM2014_投票区保守住民投票.menuId())) {
            sennkyoSikakuShurui = SennkyoSikakuShurui.住民投票;
            is選挙種類 = Boolean.FALSE;
        } else if (isメニューID状況9(menuId)) {
            div.getDdlSenkyoShurui().setDisabled(Boolean.FALSE);
            is選挙種類 = Boolean.FALSE;
        }
        if (is選挙種類) {
            div.getDdlSenkyoShurui().setDataSource(CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙種類.getCodeShubetsu()));
            div.getDdlSenkyoShurui().setSelectedKey(senkyoShurui.getCode());
            div.getDdlSenkyoShurui().setDisabled(Boolean.TRUE);
        } else {
            List<KeyValueDataSource> 表示リスト = new ArrayList<>();
            List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格種類.getCodeShubetsu());
            if (AFAMenuId.AFAMNM2030_選挙区保守.menuId().equals(menuId)
                    || AFAMenuId.AFAMNM2040_投票区投票所対応保守.menuId().equals(menuId)) {
                for (KeyValueDataSource dataSource : source) {
                    if (!SennkyoSikakuShurui.在外投票.value().equals(dataSource.getKey())) {
                        表示リスト.add(dataSource);
                    }
                }
                div.getDdlSenkyoShurui().setDataSource(表示リスト);
            } else {
                div.getDdlSenkyoShurui().setDataSource(source);
            }
            div.getDdlSenkyoShurui().setSelectedKey(sennkyoSikakuShurui.value());
        }
    }
}
