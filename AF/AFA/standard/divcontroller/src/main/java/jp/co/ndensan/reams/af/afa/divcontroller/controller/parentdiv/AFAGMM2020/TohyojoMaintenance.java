/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2020;

import jp.co.ndensan.reams.af.afa.business.core.TohyojoForCtrl;
import jp.co.ndensan.reams.af.afa.definition.core.TohyojoEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.TohyojoMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020.TohyojoMaintenanceHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMM2020 投票所保守 <br />
 * TohyojoMaintenanceDivに対応するコントローラです。
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public class TohyojoMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    public ResponseData<TohyojoMaintenanceDiv> onLoad(TohyojoMaintenanceDiv div) {
        TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
        return ResponseData.of(div).respond();
    }

    /**
     * 投票所選択エリア内のグリッド内の修正ボタン
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    public ResponseData<TohyojoMaintenanceDiv> onClick_btnModify(TohyojoMaintenanceDiv div) {
        TohyojoMaintenanceHandler.of(div).setコードを修正();
        return ResponseData.of(div).respond();

    }

    /**
     * 投票所選択エリア内のグリッド内の削除ボタン
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    public ResponseData<TohyojoMaintenanceDiv> onClick_btnDelete(TohyojoMaintenanceDiv div) {

        TohyojoMaintenanceHandler.of(div).setコードを削除();
        return ResponseData.of(div).respond();
    }

    /**
     * コードを追加するボタン押下時のイベントメソッドです。
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    public ResponseData<TohyojoMaintenanceDiv> onClick_btnAdd(TohyojoMaintenanceDiv div) {
        TohyojoMaintenanceHandler.of(div).setコードを追加する();
        return ResponseData.of(div).respond();
    }

    /**
     * 追加をやめるボタンと修正をやめるボタンと削除をやめるボタン押下時のイベントメソッドです。
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    public ResponseData<TohyojoMaintenanceDiv> onClick_btnStop(TohyojoMaintenanceDiv div) {
        if (TohyojoEnum.削除.getKey().equals(div.getHiddenFlag())) {
            TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
        }
        if (TohyojoEnum.追加.getKey().equals(div.getHiddenFlag())) {
            RString 画面_投票所コード = div.getTohyojoInput().getTxtCode().getValue();
            RString 画面_投票所名 = div.getTohyojoInput().getTxtName().getValue();
            RString 画面_カナ投票所名 = div.getTohyojoInput().getTxtKanaName().getValue();
            RTime 画面_投票開始時刻 = div.getTohyojoInput().getTxtTohyoTimeRange().getFromValue();
            RTime 画面_投票終了時刻 = div.getTohyojoInput().getTxtTohyoTimeRange().getToValue();
            boolean 画面_在外投票可能フラグ = div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().isAllSelected();
            RString 画面_住所 = div.getTohyojoInput().getTxtJusho().getDomain().getColumnValue();
            RString 画面_郵便番号 = div.getTohyojoInput().getTxtYubinNo().getValue().getColumnValue();
            RString 画面_投票所宛名 = div.getTohyojoInput().getTxtAtenaMeisho().getDomain().getColumnValue();
            RString 画面_電話番号 = div.getTohyojoInput().getTxtTelNo().getDomain().getColumnValue();
            RString 画面_番号FAX = div.getTohyojoInput().getTxtFaxNo().getDomain().getColumnValue();
            RString 画面_地図イメージファイル名 = div.getTohyojoInput().getTxtMapFileName().getValue();
            if (画面_投票所コード.isNullOrEmpty() && 画面_投票所名.isNullOrEmpty() && 画面_カナ投票所名.isNullOrEmpty() && 画面_投票開始時刻 == null
                    && 画面_投票終了時刻 == null && !画面_在外投票可能フラグ && 画面_郵便番号.isNullOrEmpty() && 画面_住所.isNullOrEmpty()
                    && 画面_投票所宛名.isNullOrEmpty() && 画面_電話番号.isNullOrEmpty() && 画面_番号FAX.isNullOrEmpty() && 画面_地図イメージファイル名.isNullOrEmpty()) {
                TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
            } else {
                return TohyojoMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        if (TohyojoEnum.修正.getKey().equals(div.getHiddenFlag())) {
            TohyojoForCtrl 投票所 = Base64Serializer.deSerialize(div.getDgTohyojoList().getClickedItem().getHidMotoData().toString(), TohyojoForCtrl.class);
            RString 投票所コード = changeNullToEmpty(投票所.getEntity().getTohyojoCode());
            RString 投票所名 = changeNullToEmpty(投票所.getEntity().getTohyojoName());
            RString カナ投票所名 = changeNullToEmpty(投票所.getEntity().getKanaTohyojoName());
            RString 投票開始時刻 = changeNullToEmpty(new RString(String.valueOf(投票所.getEntity().getTohyoStartTime())));
            RString 投票終了時刻 = changeNullToEmpty(new RString(String.valueOf(投票所.getEntity().getTohyoStopTime())));
            RString 在外投票可能フラグ = changeNullToEmpty(new RString(String.valueOf(投票所.getEntity().getZaigaiTohyoKanoFlag())));
            RString 郵便番号 = changeNullToEmpty(new RString(String.valueOf(投票所.getEntity().getYubinNo())));
            AtenaJusho 住所所 = 投票所.getEntity().getJusho();
            RString 住所 = null == 住所所 ? RString.EMPTY : 住所所.getColumnValue();
            AtenaMeisho 投票所宛名名 = 投票所.getEntity().getTohyojoAtena();
            RString 投票所宛名 = null == 投票所宛名名 ? RString.EMPTY : 投票所宛名名.getColumnValue();
            TelNo 電話番号号 = 投票所.getEntity().getTelNo();
            RString 電話番号 = null == 電話番号号 ? RString.EMPTY : 電話番号号.getColumnValue();
            TelNo 番号 = 投票所.getEntity().getFaxNo();
            RString 番号FAX = null == 番号 ? RString.EMPTY : 番号.getColumnValue();
            RString 地図イメージファイル名 = changeNullToEmpty(投票所.getEntity().getMapImage());
            RString 画面_投票所コード = div.getTohyojoInput().getTxtCode().getValue();
            RString 画面_投票所名 = div.getTohyojoInput().getTxtName().getValue();
            RString 画面_カナ投票所名 = div.getTohyojoInput().getTxtKanaName().getValue();
            RString 画面_投票開始時刻 = new RString(String.valueOf(div.getTohyojoInput().getTxtTohyoTimeRange().getFromValue()));
            RString 画面_投票終了時刻 = new RString(String.valueOf(div.getTohyojoInput().getTxtTohyoTimeRange().getToValue()));
            RString 画面_在外投票可能フラグ = new RString(String.valueOf(div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().isAllSelected()));
            RString 画面_郵便番号 = new RString(String.valueOf(div.getTohyojoInput().getTxtYubinNo().getValue()));
            RString 画面_住所 = div.getTohyojoInput().getTxtJusho().getDomain().getColumnValue();
            RString 画面_投票所宛名 = div.getTohyojoInput().getTxtAtenaMeisho().getDomain().getColumnValue();
            RString 画面_電話番号 = div.getTohyojoInput().getTxtTelNo().getDomain().getColumnValue();
            RString 画面_番号FAX = div.getTohyojoInput().getTxtFaxNo().getDomain().getColumnValue();
            RString 画面_地図イメージファイル名 = div.getTohyojoInput().getTxtMapFileName().getValue();
            if (投票所コード.equals(画面_投票所コード) && 投票所名.equals(画面_投票所名) && カナ投票所名.equals(画面_カナ投票所名) && 投票開始時刻.equals(画面_投票開始時刻)
                    && 投票終了時刻.equals(画面_投票終了時刻) && 在外投票可能フラグ.equals(画面_在外投票可能フラグ) && 郵便番号.equals(画面_郵便番号)
                    && 住所.equals(画面_住所) && 投票所宛名.equals(画面_投票所宛名) && 電話番号.equals(画面_電話番号) && 番号FAX.equals(画面_番号FAX)
                    && 地図イメージファイル名.equals(画面_地図イメージファイル名)) {
                TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
            } else {
                return TohyojoMaintenanceHandler.of(div).check入力内容の破棄(div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 追加するボタン押下時のイベントメソッドです。
     *
     * @param div TohyojoMaintenanceDiv
     * @return ResponseData<TohyojoMaintenanceDiv>
     */
    public ResponseData<TohyojoMaintenanceDiv> onClick_btnAddNew(TohyojoMaintenanceDiv div) {
        if (TohyojoEnum.追加.getKey().equals(div.getHiddenFlag())) {
            return btnAddTohyojo(div);
        }
        if (TohyojoEnum.修正.getKey().equals(div.getHiddenFlag())) {
            return btnUpdateTohyojo(div);
        }
        if (TohyojoEnum.削除.getKey().equals(div.getHiddenFlag())) {
            return btnDeleteTohyojo(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<TohyojoMaintenanceDiv> btnAddTohyojo(TohyojoMaintenanceDiv div) {
        TohyojoForCtrl 投票所 = new TohyojoForCtrl();
        RString 投票所コード = div.getTohyojoInput().getTxtCode().getValue();
        投票所.getEntity().setZaigaiTohyoKanoFlag(div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().isAllSelected());
        投票所.getEntity().setTelNo(new TelNo(div.getTohyojoInput().getTxtTelNo().getDomain().getColumnValue()));
        投票所.getEntity().setFaxNo(new TelNo(div.getTohyojoInput().getTxtFaxNo().getDomain().getColumnValue()));
        投票所.getEntity().setTohyojoCode(div.getTohyojoInput().getTxtCode().getValue());
        投票所.getEntity().setSearchKanaTohyojoName(RStringUtil.convertTo清音化(div.getTohyojoInput().getTxtKanaName().getValue()));
        投票所.getEntity().setTohyoStopTime(div.getTohyojoInput().getTxtTohyoTimeRange().getToValue());
        投票所.getEntity().setKanaTohyojoName(div.getTohyojoInput().getTxtKanaName().getValue());
        投票所.getEntity().setMapImage(div.getTohyojoInput().getTxtMapFileName().getValue());
        投票所.getEntity().setTohyoStartTime(div.getTohyojoInput().getTxtTohyoTimeRange().getFromValue());
        投票所.getEntity().setTohyojoName(div.getTohyojoInput().getTxtName().getValue());
        投票所.getEntity().setTohyojoAtena(new AtenaMeisho(div.getTohyojoInput().getTxtAtenaMeisho().getDomain().getColumnValue()));
        投票所.getEntity().setJusho(new AtenaJusho(div.getTohyojoInput().getTxtJusho().getDomain().getColumnValue()));
        投票所.getEntity().setYubinNo(div.getTohyojoInput().getTxtYubinNo().getValue());
        boolean 投票所件数フラグ = TohyojoMaintenanceHandler.of(div).set投票所重複チェック(投票所コード);
        if (投票所件数フラグ) {
            return TohyojoMaintenanceHandler.of(div).checkコード重複チェック();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType()
                == MessageDialogSelectedResult.Yes) {
            int number = TohyojoMaintenanceHandler.of(div).set投票所詳細コードを追加と保存する(投票所);
            if (number > 0) {
                TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<TohyojoMaintenanceDiv> btnUpdateTohyojo(TohyojoMaintenanceDiv div) {
        TohyojoForCtrl 投票所 = Base64Serializer.deSerialize(div.getDgTohyojoList().getClickedItem().getHidMotoData().toString(), TohyojoForCtrl.class);
        投票所.getEntity().setTohyojoCode(div.getTohyojoInput().getTxtCode().getValue());
        投票所.getEntity().setTohyojoName(div.getTohyojoInput().getTxtName().getValue());
        投票所.getEntity().setKanaTohyojoName(div.getTohyojoInput().getTxtKanaName().getValue());
        投票所.getEntity().setSearchKanaTohyojoName(RStringUtil.convertTo清音化(div.getTohyojoInput().getTxtKanaName().getValue()));
        投票所.getEntity().setTohyoStartTime(div.getTohyojoInput().getTxtTohyoTimeRange().getFromValue());
        投票所.getEntity().setTohyoStopTime(div.getTohyojoInput().getTxtTohyoTimeRange().getToValue());
        投票所.getEntity().setZaigaiTohyoKanoFlag(div.getTohyojoInput().getChkZaigaiTohyoKanoFlag().isAllSelected());
        投票所.getEntity().setYubinNo(div.getTohyojoInput().getTxtYubinNo().getValue());
        投票所.getEntity().setJusho(new AtenaJusho(div.getTohyojoInput().getTxtJusho().getDomain().getColumnValue()));
        投票所.getEntity().setTohyojoAtena(new AtenaMeisho(div.getTohyojoInput().getTxtAtenaMeisho().getDomain().getColumnValue()));
        投票所.getEntity().setTelNo(new TelNo(div.getTohyojoInput().getTxtTelNo().getDomain().getColumnValue()));
        投票所.getEntity().setFaxNo(new TelNo(div.getTohyojoInput().getTxtFaxNo().getDomain().getColumnValue()));
        投票所.getEntity().setMapImage(div.getTohyojoInput().getTxtMapFileName().getValue());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = TohyojoMaintenanceHandler.of(div).set投票所詳細コードを追加と保存する(投票所);
            if (number > 0) {
                TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<TohyojoMaintenanceDiv> btnDeleteTohyojo(TohyojoMaintenanceDiv div) {
        TohyojoForCtrl 投票所 = Base64Serializer.deSerialize(div.getDgTohyojoList().getClickedItem().getHidMotoData().toString(), TohyojoForCtrl.class);
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean deleteFlag = TohyojoMaintenanceHandler.of(div).set投票所詳細コードを削除する(投票所);
            if (deleteFlag) {
                TohyojoMaintenanceHandler.of(div).set投票所保守初期化画面();
            }
        }
        return ResponseData.of(div).respond();
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
