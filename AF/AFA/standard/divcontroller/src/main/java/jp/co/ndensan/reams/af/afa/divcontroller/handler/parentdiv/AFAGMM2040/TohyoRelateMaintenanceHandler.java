/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuRelation;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuTohyojo;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuTohyojoZero;
import jp.co.ndensan.reams.af.afa.definition.core.tohyorelate.enumeratedtype.TohyoRelateEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.TohyoRelateMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.dgTohyoRelateList_Row;
import jp.co.ndensan.reams.af.afa.service.tohyokutohyojo.TohyokuTohyojoFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2040 投票区投票所対応保守Handler
 *
 * @reamsid_L AF-0740-010 lis2
 */
public final class TohyoRelateMaintenanceHandler {

    private final TohyoRelateMaintenanceDiv div;

    private TohyoRelateMaintenanceHandler(TohyoRelateMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 投票区投票所
     * @return 投票区投票所
     */
    public static TohyoRelateMaintenanceHandler of(TohyoRelateMaintenanceDiv div) {
        return new TohyoRelateMaintenanceHandler(div);
    }

    /**
     * 投票区投票所対応画面のonLoadイベント
     *
     */
    public void set投票区投票所初期化画面() {
        RString 選挙種類 = div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        List<TohyokuTohyojo> 投票区投票所対応情報リスト = new ArrayList<>();
        List<TohyokuTohyojoZero> 投票区投票所対応情報ゼロリスト = new ArrayList<>();
        TohyokuTohyojoFinder finder = TohyokuTohyojoFinder.createInstance();
        div.getDgTohyoRelateList().getDataSource().clear();
        if (TohyoRelateEnum.通常選挙.getKey().equals(選挙種類)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            LasdecCode 導入団体コード = association.get地方公共団体コード();
            int 導入団体コード連番 = association.get連番();
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            投票区投票所対応情報ゼロリスト = finder.select投票区投票所対応情報By選挙種類がゼロ(選挙種類, 導入団体コード,
                    導入団体コード連番, システム日付);
        } else {
            投票区投票所対応情報リスト = finder.select投票区投票所対応情報(選挙種類);
        }
        List<dgTohyoRelateList_Row> rowList = new ArrayList();
        if (null != 投票区投票所対応情報リスト && !投票区投票所対応情報リスト.isEmpty()) {
            for (TohyokuTohyojo 投票区投票所対応情報 : 投票区投票所対応情報リスト) {
                dgTohyoRelateList_Row row = new dgTohyoRelateList_Row();
                if (null != 投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuEntity()) {
                    row.setTxtCode(投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuEntity().getTohyokuCode());
                    row.setTxtName(投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuEntity().getTohyokuName());
                } else {
                    row.setTxtCode(RString.EMPTY);
                    row.setTxtName(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuRelationEntity()) {
                    row.setTxtTohyojoCode(投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuRelationEntity().getTohyojoCode());
                    row.setTxtSenkyokuCode(投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyokuRelationEntity().getSenkyokuCode());
                } else {
                    row.setTxtSenkyokuCode(RString.EMPTY);
                    row.setTxtTohyojoCode(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyojoEntity()) {
                    row.setTxtTohyojoName(投票区投票所対応情報.getTohyokuTohyojoForMap().getTohyojoEntity().getTohyojoName());
                } else {
                    row.setTxtTohyojoName(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報.getTohyokuTohyojoForMap().getSenkyokuEntity()) {
                    row.setTxtSenkyokuName(投票区投票所対応情報.getTohyokuTohyojoForMap().getSenkyokuEntity().getSenkyokuName());
                } else {
                    row.setTxtSenkyokuName(RString.EMPTY);
                }
                row.setHidMotoData(new RString(Base64Serializer.serialize(投票区投票所対応情報)));
                rowList.add(row);
            }
            div.getDgTohyoRelateList().setDataSource(rowList);
        }
        if (null != 投票区投票所対応情報ゼロリスト && !投票区投票所対応情報ゼロリスト.isEmpty()) {
            for (TohyokuTohyojoZero 投票区投票所対応情報ゼロ : 投票区投票所対応情報ゼロリスト) {
                dgTohyoRelateList_Row row = new dgTohyoRelateList_Row();
                if (null != 投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap()) {
                    row.setTxtCode(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().get投票区コード());
                    row.setTxtName(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().get漢字名称());
                } else {
                    row.setTxtCode(RString.EMPTY);
                    row.setTxtName(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity()) {
                    row.setTxtTohyojoCode(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().getTohyojoCode());
                    row.setTxtSenkyokuCode(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().getSenkyokuCode());
                } else {
                    row.setTxtTohyojoCode(RString.EMPTY);
                    row.setTxtSenkyokuCode(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getTohyojoEntity()) {
                    row.setTxtTohyojoName(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getTohyojoEntity().getTohyojoName());
                } else {

                    row.setTxtTohyojoName(RString.EMPTY);
                }
                if (null != 投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getSenkyokuEntity()) {
                    row.setTxtSenkyokuName(投票区投票所対応情報ゼロ.getTohyokuTohyojoZeroForMap().getSenkyokuEntity().getSenkyokuName());
                } else {
                    row.setTxtSenkyokuName(RString.EMPTY);
                }
                row.setHidMotoData(new RString(Base64Serializer.serialize(投票区投票所対応情報ゼロ)));
                rowList.add(row);
            }
            div.getDgTohyoRelateList().setDataSource(rowList);
        }
    }

    /**
     * 初期化状態
     */
    public void set初期化状態1() {
        div.getTohyoRelateSelect().getCcdSenkyoShurui().initialize();
        div.getTohyoRelateSelect().getDgTohyoRelateList().getDataSource().clear();
        div.getCcdSenkyoShurui().setDisplayNone(Boolean.FALSE);
        div.getCcdSenkyoShurui().setDisabled(Boolean.FALSE);
        div.getDgTohyoRelateList().setDisabled(Boolean.FALSE);
        div.getDgTohyoRelateList().setDisplayNone(Boolean.FALSE);
        set投票区投票所初期化画面();
    }

    /**
     * 「保存する」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check投票所必須チェック() {
        ValidationMessageControlPairs controlErrorPairs = new TohyoRelateMaintenanceValidationHandler(div).
                validate投票所必須チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他ユーザ使用チェック処理
     *
     * @return ResponseData
     */
    public ResponseData check他ユーザ使用チェック() {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlErrorPairs = new TohyoRelateMaintenanceValidationHandler(div).validate他ユーザ使用チェック();
            if (controlErrorPairs.existsError()) {
                div.getCcdSenkyoShurui().setReadOnlyMode(Boolean.TRUE);
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 投票区投票所対応テーブルの登録処理
     *
     */
    public void save投票区投票所() {
        RString select選挙種類 = div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        TohyokuRelation tohyokuRelation = new TohyokuRelation();
        if (TohyoRelateEnum.通常選挙.getKey().equals(select選挙種類)) {
            TohyokuTohyojoZero 投票区投票所 = Base64Serializer.deSerialize(div.getDgTohyoRelateList().getClickedItem().getHidMotoData().toString(), TohyokuTohyojoZero.class);
            if (null != 投票区投票所.getTohyokuTohyojoZeroForMap().getTohyojoEntity()) {
                Code senkyoshurui = null == select選挙種類 ? Code.EMPTY : new Code(select選挙種類);
                投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().setSenkyoShurui(senkyoshurui);
                投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().setTohyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtCode());
                投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().setTohyojoCode(div.getDgTohyoRelateList().getActiveRow().getTxtTohyojoCode());
                投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().setSenkyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtSenkyokuCode());
                投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity().setState(EntityDataState.Modified);
                tohyokuRelation.setEntity(投票区投票所.getTohyokuTohyojoZeroForMap().getTohyokuRelationEntity());
            } else {
                Code senkyoshurui = null == select選挙種類 ? Code.EMPTY : new Code(select選挙種類);
                tohyokuRelation.getEntity().setSenkyoShurui(senkyoshurui);
                tohyokuRelation.getEntity().setTohyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtCode());
                tohyokuRelation.getEntity().setTohyojoCode(div.getDgTohyoRelateList().getActiveRow().getTxtTohyojoCode());
                tohyokuRelation.getEntity().setSenkyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtSenkyokuCode());
                tohyokuRelation.getEntity().setState(EntityDataState.Added);
            }
        } else {
            TohyokuTohyojo 投票区投票所 = Base64Serializer.deSerialize(div.getDgTohyoRelateList().getClickedItem().getHidMotoData().toString(), TohyokuTohyojo.class);
            if (null != 投票区投票所.getTohyokuTohyojoForMap().getTohyojoEntity()) {
                Code senkyoshurui = null == select選挙種類 ? Code.EMPTY : new Code(select選挙種類);
                投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity().setSenkyoShurui(senkyoshurui);
                投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity().setTohyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtCode());
                投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity().setTohyojoCode(div.getDgTohyoRelateList().getActiveRow().getTxtTohyojoCode());
                投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity().setSenkyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtSenkyokuCode());
                投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity().setState(EntityDataState.Modified);
                tohyokuRelation.setEntity(投票区投票所.getTohyokuTohyojoForMap().getTohyokuRelationEntity());
            } else {
                Code senkyoshurui = null == select選挙種類 ? Code.EMPTY : new Code(select選挙種類);
                tohyokuRelation.getEntity().setSenkyoShurui(senkyoshurui);
                tohyokuRelation.getEntity().setSenkyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtSenkyokuCode());
                tohyokuRelation.getEntity().setTohyojoCode(div.getDgTohyoRelateList().getActiveRow().getTxtTohyojoCode());
                tohyokuRelation.getEntity().setTohyokuCode(div.getDgTohyoRelateList().getActiveRow().getTxtCode());
                tohyokuRelation.getEntity().setState(EntityDataState.Added);
            }
        }
        TohyokuTohyojoFinder finder = TohyokuTohyojoFinder.createInstance();
        int number = finder.save投票区投票所(tohyokuRelation);
        if (number > 0) {
            TohyoRelateMaintenanceHandler.of(div).set投票区投票所初期化画面();
        }
    }
}
