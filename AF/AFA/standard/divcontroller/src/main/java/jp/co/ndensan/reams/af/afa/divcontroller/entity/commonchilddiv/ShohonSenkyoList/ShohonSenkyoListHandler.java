/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokekkashukeisakusei.SenkyoJoho;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.tohyokekkashukeisakusei.TohyoKekkaShukeiSakuseiManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShohonSenkyoListDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してShohonSenkyoListDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0290-011 wangxt2
 */
public class ShohonSenkyoListHandler {

    private final ShohonSenkyoListDiv div;
    private static final RString 無投票選挙も出力する = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div 抄本選挙一覧
     */
    public ShohonSenkyoListHandler(ShohonSenkyoListDiv div) {
        this.div = div;
    }

    public void initialize(SenkyoShurui senkyoShurui) {

        if (AFAMenuId.AFAMNE2050_施設送付書発行.menuId().equals(ViewState.getメニューID())) {
            div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
            div.getCcdShohonNameList().initialize(senkyoShurui);
            RString shohon未来 = div.getCcdShohonNameList().get一番近い未来抄本番号();
            if (!shohon未来.isEmpty()) {
                div.getCcdShohonNameList().selectedShohon(shohon未来);
            }
        } else {
            if (AFAMenuId.AFAMNE5050_投票結果集計表.menuId().equals(ViewState.getメニューID())) {
                div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
                div.getCcdShohonNameList().initialize(senkyoShurui);
                RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
                if (!shohon過去.isEmpty()) {
                    div.getCcdShohonNameList().selectedShohon(shohon過去);
                }
            } else {
                div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.FALSE);
                div.getCcdShohonNameList().initialize(senkyoShurui);
                RString shohon未来 = div.getCcdShohonNameList().get一番近い未来抄本番号();
                if (!shohon未来.isEmpty()) {
                    div.getCcdShohonNameList().selectedShohon(shohon未来);
                } else {
                    div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
                    RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
                    div.getCcdShohonNameList().initialize(senkyoShurui);
                    if (!shohon過去.isEmpty()) {
                        div.getCcdShohonNameList().selectedShohon(shohon過去);
                    }
                }
            }

        }
        TohyoKekkaShukeiSakuseiManager manager = TohyoKekkaShukeiSakuseiManager.createInstance();
        RString shohonNo = div.getCcdShohonNameList().getSelectedShohonNo();
        if (!RString.isNullOrEmpty(shohonNo)) {
            ShohonNo 抄本番号 = new ShohonNo(shohonNo);
            List<SenkyoJoho> senkyoList = manager.getSenkyoJoho(抄本番号);
            setSenkyoDataSource(senkyoList);
        }
    }

    public void initialize() {

        if (AFAMenuId.AFAMNE2050_施設送付書発行.menuId().equals(ViewState.getメニューID())) {
            div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
            div.getCcdShohonNameList().initialize();
            RString shohon未来 = div.getCcdShohonNameList().get一番近い未来抄本番号();
            if (!shohon未来.isEmpty()) {
                div.getCcdShohonNameList().selectedShohon(shohon未来);
            }
        } else {
            if (AFAMenuId.AFAMNE5050_投票結果集計表.menuId().equals(ViewState.getメニューID())) {
                div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
                div.getCcdShohonNameList().initialize();
                RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
                if (!shohon過去.isEmpty()) {
                    div.getCcdShohonNameList().selectedShohon(shohon過去);
                }
            } else {
                div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.FALSE);
                div.getCcdShohonNameList().initialize();
                RString shohon未来 = div.getCcdShohonNameList().get一番近い未来抄本番号();
                if (!shohon未来.isEmpty()) {
                    div.getCcdShohonNameList().selectedShohon(shohon未来);
                } else {
                    div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
                    RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
                    div.getCcdShohonNameList().initialize();
                    if (!shohon過去.isEmpty()) {
                        div.getCcdShohonNameList().selectedShohon(shohon過去);
                    }
                }
            }

        }
        TohyoKekkaShukeiSakuseiManager manager = TohyoKekkaShukeiSakuseiManager.createInstance();
        RString shohonNo = div.getCcdShohonNameList().getSelectedShohonNo();
        if (!RString.isNullOrEmpty(shohonNo)) {
            ShohonNo 抄本番号 = new ShohonNo(shohonNo);
            List<SenkyoJoho> senkyoList = manager.getSenkyoJoho(抄本番号);
            setSenkyoDataSource(senkyoList);
        }
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     */
    public void initialSetting() {
        getShohonSenkyoList();
    }

    /**
     * 無投票選挙も出力する」チェックボックス選択時の処理をするメソッドです。
     */
    public void changeflag() {
        getShohonSenkyoList();
    }

    /**
     * 過去分も含めるチェックボックス選択時の処理をするメソッドです。
     */
    public void click過去分も含める() {
        div.getCcdShohonNameList().click_chkKakoShohon();
        getShohonSenkyoList();
    }

    private void getShohonSenkyoList() {
        div.getCcdShohonNameList().changeDdlShohon();
        RString shohonNo = div.getCcdShohonNameList().getSelectedShohonNo();
        if (shohonNo.equals(RString.EMPTY)) {
            clearThisPanel();
        } else {
            List<RString> selectedKeys = div.getChkMutohyo().getSelectedKeys();
            if (selectedKeys.contains(無投票選挙も出力する)) {
                div.getDgSenkyoList().getDataSource().clear();
                TohyoKekkaShukeiSakuseiManager manager = TohyoKekkaShukeiSakuseiManager.createInstance();
                ShohonNo 抄本番号 = new ShohonNo(shohonNo);
                List<SenkyoJoho> senkyoList = manager.getSenkyoJohoWithFlag(抄本番号);
                setSenkyoDataSource(senkyoList);
            } else {
                div.getDgSenkyoList().getDataSource().clear();
                TohyoKekkaShukeiSakuseiManager manager = TohyoKekkaShukeiSakuseiManager.createInstance();
                ShohonNo 抄本番号 = new ShohonNo(shohonNo);
                List<SenkyoJoho> senkyoList = manager.getSenkyoJoho(抄本番号);
                setSenkyoDataSource(senkyoList);
            }
        }
    }

    private void setSenkyoDataSource(List<SenkyoJoho> senkyoList) {
        if (senkyoList != null) {
            List<dgSenkyoList_Row> dataSource = new ArrayList<>();
            for (SenkyoJoho senkyoJoho : senkyoList) {
                dgSenkyoList_Row senkyoRow = new dgSenkyoList_Row();
                senkyoRow.setChkMutohyoSenkyoFlag(senkyoJoho.hasMutohyoSenkyoFlag());
                senkyoRow.setTxtNo(new RString(senkyoJoho.getSenkyoNo().toString()));
                senkyoRow.setTxtSenkyoName(senkyoJoho.getSenkyoName());
                dataSource.add(senkyoRow);
            }
            div.getDgSenkyoList().setDataSource(dataSource);
        } else {
            div.getDgSenkyoList().getDataSource().clear();
        }
    }

    /**
     * 無投票選挙checkを取得します。
     *
     * @return 無投票選挙check
     */
    public boolean 無投票選挙check() {
        return div.getChkMutohyo().isAllSelected();
    }

    /**
     * SenkyoDataSourceを取得します。
     *
     * @return DataSource
     */
    public List<dgSenkyoList_Row> getSenkyoDataSource() {
        return div.getDgSenkyoList().getDataSource();
    }

    /**
     * SelectedShohonNoを取得します。
     *
     * @return ShohonNo
     */
    public RString getSelectedShohonNo() {
        return div.getCcdShohonNameList().getSelectedShohonNo();
    }

    /**
     * 抄本DDLの件数を取得します。
     *
     * @return 取得された抄本の数
     */
    public int getShohonListSize() {
        return div.getCcdShohonNameList().getShohonListSize();
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clearThisPanel() {
        div.getChkMutohyo().getSelectedItems().clear();
        div.getCcdShohonNameList().clear();
        div.getDgSenkyoList().getDataSource().clear();
    }
}
