/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.SenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.dgSenkyoShusei_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 選挙修正のハンドラクラスです。
 *
 */
public class SenkyoJohoShuseiHandler {

    private final SenkyoJohoShuseiDiv div;
    private static final RString 保存ボタン = new RString("btnUpdate");
    private static final Decimal 番号1 = new Decimal(1);

    /**
     * コンストラクタです
     *
     * @param div ProcessCompleteDiv
     */
    public SenkyoJohoShuseiHandler(SenkyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 修正対象抄本の表示状態を設定します。
     *
     * @param contralFlag Boolean
     */
    public void set修正対象抄本の状態(Boolean contralFlag) {
        div.getCcdSenkyoShuseiShohon().setDisabled(contralFlag);
    }

    /**
     * 選挙一覧を設定します。
     *
     * @param listRows List<dgSenkyoShusei_Row>
     */
    public void set選挙一覧(List<dgSenkyoShusei_Row> listRows) {
        div.getSenkyoShusei().getDgSenkyoShusei().setDataSource(listRows);
    }

    /**
     * 選挙情報入力の表示状態を設定します。
     *
     * @param displayFlag Boolean
     */
    public void set選挙情報入力の表示状態(Boolean displayFlag) {
        div.getSenkyoInput().setDisplayNone(displayFlag);
    }

    /**
     * 選挙一覧を再設定します。
     *
     */
    public void clean選挙一覧() {
        div.getSenkyoShusei().getDgSenkyoShusei().getDataSource().clear();
    }

    /**
     * 選挙情報入力の表示状態を設定します。
     *
     * @param contralFlag Boolean
     */
    public void set保存ボタンの状態(Boolean contralFlag) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, contralFlag);
    }

    /**
     * 選挙情報入力の必須チェックを設定します。
     *
     * @param contralFlag Boolean
     */
    public void set選挙情報入力の必須チェック(Boolean contralFlag) {
        div.getSenkyoInput().getDdlSenkyoLevel().setRequired(contralFlag);
        div.getSenkyoInput().getTxtSenkyoName().setRequired(contralFlag);
        div.getSenkyoInput().getTxtSenkyoRyakusho().setRequired(contralFlag);
        div.getSenkyoInput().getTxtSenkyoMark().setRequired(contralFlag);
        div.getSenkyoInput().getTxtKijunYMD().setRequired(contralFlag);
        div.getSenkyoInput().getTxtUketsukeYMD().setRequired(contralFlag);
    }

    /**
     * 選挙一覧の表示状態を設定します。
     *
     * @param disableFlag Boolean
     */
    public void set選挙一覧の状態(Boolean disableFlag) {
        div.getSenkyoShusei().getBtnSenkyoAdd().setDisabled(disableFlag);
        div.getSenkyoShusei().getDgSenkyoShusei().setDisabled(disableFlag);
    }

    /**
     * 選挙情報入力の初期表示を設定します。
     *
     * @param senkyo List<Senkyo>
     */
    public void initial選挙情報入力By選挙追加(List<Senkyo> senkyo) {
        set選挙情報入力の必須チェック(Boolean.TRUE);
        initial選挙情報入力エリア(senkyo);
        div.getSenkyoInput().getTxtSenkyoNo().setDisabled(Boolean.TRUE);
        div.getSenkyoInput().getTxtSenkyoName().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getTxtSenkyoRyakusho().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getChkMutohyoFlag().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getTxtSenkyoMark().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getTxtKijunYMD().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getTxtUketsukeYMD().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getTxtKokujiYMD().setDisabled(Boolean.TRUE);
        div.getSenkyoInput().getTxtTorokuYMD().setDisabled(Boolean.TRUE);
        div.getSenkyoInput().getTxtTennyuKigenYMD().setDisabled(Boolean.TRUE);
        div.getSenkyoInput().getTxtTenshutsuKigenYMD().setDisabled(Boolean.TRUE);
        div.getSenkyoInput().getBtnInsert().setDisabled(Boolean.FALSE);
        div.getSenkyoInput().getBtnStop().setDisabled(Boolean.FALSE);
    }

    private void initial選挙情報入力エリア(List<Senkyo> senkyo) {
        div.getSenkyoInput().getTxtSenkyoNo().clearValue();
        div.getSenkyoInput().getTxtSenkyoName().clearValue();
        div.getSenkyoInput().getTxtSenkyoRyakusho().clearValue();
        div.getSenkyoInput().getTxtSenkyoMark().clearValue();
        div.getSenkyoInput().getTxtKijunYMD().clearValue();
        div.getSenkyoInput().getTxtUketsukeYMD().clearValue();
        div.getSenkyoInput().getTxtKokujiYMD().clearValue();
        div.getSenkyoInput().getTxtTorokuYMD().clearValue();
        div.getSenkyoInput().getTxtTennyuKigenYMD().clearValue();
        div.getSenkyoInput().getTxtTenshutsuKigenYMD().clearValue();
        div.getSenkyoInput().getDdlSenkyoLevel().getDataSource().clear();
        if (!div.getSenkyoInput().getChkMutohyoFlag().getSelectedItems().isEmpty()) {
            div.getSenkyoInput().getChkMutohyoFlag().getSelectedItems().clear();
        }
        if (senkyo.isEmpty()) {
            div.getSenkyoInput().getDdlSenkyoLevel().setDataSource(CodeMasterHelper.createDataSourceRyakusho(
                    AFACodeShubetsu.選挙レベル.getCodeShubetsu(), Boolean.FALSE));
            div.getSenkyoInput().getTxtSenkyoNo().setValue(番号1);
        } else {
            create選挙レベル選挙番号(senkyo);
        }
    }

    private void create選挙レベル選挙番号(List<Senkyo> senkyo) {
        List<KeyValueDataSource> source = new ArrayList<>();
        int 番号 = 0;
        for (Senkyo item : senkyo) {
            KeyValueDataSource row = new KeyValueDataSource(item.get選挙レベル().getColumnValue(), CodeMaster.getCodeRyakusho(
                    SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), item.get選挙レベル()));
            if (source.isEmpty()) {
                source.add(row);
            } else {
                Boolean flg = Boolean.FALSE;
                for (KeyValueDataSource dataSource : source) {
                    if (row.getKey().equals(dataSource.getKey())) {
                        flg = Boolean.TRUE;
                        break;
                    }
                }
                if (!flg) {
                    source.add(row);
                }
            }

            if (item.get選挙番号().value() > 番号) {
                番号 = item.get選挙番号().value();
            }
        }
        div.getSenkyoInput().getDdlSenkyoLevel().setDataSource(source);
        if (!source.isEmpty()) {
            div.getSenkyoInput().getDdlSenkyoLevel().setSelectedIndex(0);
        }
        div.getSenkyoInput().getTxtSenkyoNo().setValue(new Decimal(番号 + 1));
    }
}
