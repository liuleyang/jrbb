/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.dgSenkyojiSenkyoNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010.TeijiTorokuValidationMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【共有子Div】MeiboSakuseiKijunDivに対するコントローラです。
 *
 */
public class MeiboSakuseiKijun {

    private final RString 定時登録 = new RString("AFAMNA1010");
    private final RString 定時登録_シミュレーション = new RString("AFAMNA2010");
    private static final int 選挙一覧の行数 = 9;

    /**
     * 「日付を自動計算出するボタン」ボタンのイベントメソッドです。
     *
     * @param div MeiboSakuseiKijunDiv
     * @return ResponseData<MeiboSakuseiKijunDiv>
     */
    public ResponseData<MeiboSakuseiKijunDiv> onClick_btnSetYmd(MeiboSakuseiKijunDiv div) {
        if (is定時登録()) {
            if (null == div.getTxtKijunYMD().getValue()) {
                ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
                pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getTxtKijunYMD()));
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).onClick_btnSetYmdBy定時登録();
        } else {
//            if (null != div.getTxtTohyoYMD().getValue()) {
//                getHandler(div).onClick_btnSetYmdBy選挙時登録();
//            }
            if (null == div.getTxtKijunYMD().getValue()) {
                ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
                pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getTxtKijunYMD()));
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            } else if (null == div.getTxtTohyoYMD().getValue()) {
                ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
                pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日必須項目を入力, div.getTxtTohyoYMD()));
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            } else if (!(div.getTxtTohyoYMD().getValue().compareTo(div.getTxtKijunYMD().getValue()) > 0)) {
                ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
                pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日と基準日の関係性チェック, div.getTxtKijunYMD()));
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).onClick_btnSetYmdBy選挙時登録();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「選挙を追加する」ボタンのイベントメソッドです。
     *
     * @param div MeiboSakuseiKijunDiv
     * @return ResponseData<MeiboSakuseiKijunDiv>
     */
    public ResponseData<MeiboSakuseiKijunDiv> onClick_btnAddRowSenkyo(MeiboSakuseiKijunDiv div) {
        if (div.get選挙情報().size() >= 選挙一覧の行数) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(MeiboSakuseiKijunMessage.最大登録選挙数のチェック, div.getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (null == div.getTxtKijunYMD().getValue()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else if (null == div.getTxtTohyoYMD().getValue()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日必須項目を入力, div.getTxtTohyoYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else if (!(div.getTxtTohyoYMD().getValue().compareTo(div.getTxtKijunYMD().getValue()) > 0)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日と基準日の関係性チェック, div.getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        dgSenkyojiSenkyoNyuryoku_Row row = new dgSenkyojiSenkyoNyuryoku_Row();
        row.setTxtKijunYMD(div.getTxtKijunYMD());
        row.setTxtTenshutsuKigenYMD(div.getTxtTenshutsuYMD());
        row.setTxtTennyuKigenYMD(div.getTxtTennyuYMD());
        row.setTxtMeiboTorokuYMD(div.getTxtMeiboTorokuYMD());
        row.getTxtKokujiYMD().setValue(div.getTxtKijunYMD().getValue().plusDay(1));
        div.get選挙情報().add(row);

        return ResponseData.of(div).respond();

    }

    /**
     * 「選択した選挙を複写する」ボタンのイベントメソッドです。
     *
     * @param div MeiboSakuseiKijunDiv
     * @return ResponseData<MeiboSakuseiKijunDiv>
     */
    public ResponseData<MeiboSakuseiKijunDiv> onClick_btnCopySenkyo(MeiboSakuseiKijunDiv div) {
        if (div.get選挙情報().size() >= 選挙一覧の行数) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(MeiboSakuseiKijunMessage.最大登録選挙数のチェック, div.getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<dgSenkyojiSenkyoNyuryoku_Row> selectItems = div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().getSelectedItems();
        if (!selectItems.isEmpty()) {
            List<dgSenkyojiSenkyoNyuryoku_Row> rows = div.get選挙情報();
            rows.add(selectItems.get(0));
            div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().setDataSource(rows);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選挙一覧．削除イメージのイベントメソッドです。
     *
     * @param div MeiboSakuseiKijunDiv
     * @return ResponseData<MeiboSakuseiKijunDiv>
     */
    public ResponseData<MeiboSakuseiKijunDiv> onSelectByDeleteButton(MeiboSakuseiKijunDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            dgSenkyojiSenkyoNyuryoku_Row row = div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().getClickedItem();
            List<dgSenkyojiSenkyoNyuryoku_Row> rows = div.get選挙情報();
            rows.remove(row);
            div.getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku().setDataSource(rows);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 選挙一覧.基準日を入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div MeiboSakuseiKijunDiv
     * @return ResponseData<MeiboSakuseiKijunDiv>
     */
    public ResponseData<MeiboSakuseiKijunDiv> onChange_dgSenkyojiSenkyoNyuryoku_txtKijunYMD(MeiboSakuseiKijunDiv div) {
        getHandler(div).onChange_dgSenkyojiSenkyoNyuryoku_txtKijunYMD();
        return ResponseData.of(div).respond();

    }

    private MeiboSakuseiKijunHandler getHandler(MeiboSakuseiKijunDiv div) {
        return new MeiboSakuseiKijunHandler(div);
    }

    /**
     * メニューIDの判定です。
     *
     * @return Boolean true:定時登録;false:選挙時登録
     */
    private Boolean is定時登録() {
        return 定時登録.equals(ViewState.getメニューID()) || 定時登録_シミュレーション.equals(ViewState.getメニューID());
    }
}
