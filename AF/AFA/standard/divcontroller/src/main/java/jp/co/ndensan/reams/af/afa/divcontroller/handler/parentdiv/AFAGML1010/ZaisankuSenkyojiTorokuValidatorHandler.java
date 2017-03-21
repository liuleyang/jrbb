/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 財産区議会議員選挙時登録のバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiTorokuValidatorHandler {

    private final ZaisankuSenkyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     */
    public ZaisankuSenkyojiTorokuValidatorHandler(ZaisankuSenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 財産区議会議員選挙時登録のDiv
     * @return 財産区議会議員選挙時登録のハンドラ
     */
    public static ZaisankuSenkyojiTorokuValidatorHandler of(ZaisankuSenkyojiTorokuDiv div) {
        return new ZaisankuSenkyojiTorokuValidatorHandler(div);
    }

    /**
     * 「実行」ボタンをクリックの時チェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ZaisankuSenkyojiTorokuValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 「実行」ボタンをクリックの時チェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validate1() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ZaisankuSenkyojiTorokuValidator(div).validate1();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {

        List<ViewControl> kijunList = new ArrayList<>();
        kijunList.add(div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD());
        kijunList.add(div.getZaisankuMeiboKoshinKijun().getTxtMeiboTorokuYMD());
        List<ViewControl> nenreitotatsuList = new ArrayList<>();
        nenreitotatsuList.add(div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD());
        nenreitotatsuList.add(div.getZaisankuMeiboKoshinKijun().getTxtNenreiTotatsuYMD());
        List<ViewControl> tenshutsuList = new ArrayList<>();
        tenshutsuList.add(div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD());
        tenshutsuList.add(div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD());
        List<ViewControl> tennyuList = new ArrayList<>();
        tennyuList.add(div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD());
        tennyuList.add(div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD());
        List<ViewControl> tenshunyuList = new ArrayList<>();
        tenshunyuList.add(div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD());
        tenshunyuList.add(div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD());
        List<ViewControl> tohyokaishiList = new ArrayList<>();
        tohyokaishiList.add(div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD());
        tohyokaishiList.add(div.getZaisankuMeiboKoshinKijun().getTxtTohyoKaishiYMD());

        return new ValidationDictionaryBuilder()
                .add(ZaisankuSenkyojiTorokuValidatorMessage.基準日登録日大小チェック,
                        kijunList)
                .add(ZaisankuSenkyojiTorokuValidatorMessage.年齢期限日基準日大小チェック,
                        nenreitotatsuList)
                .add(ZaisankuSenkyojiTorokuValidatorMessage.転出期限日基準日大小チェック,
                        tenshutsuList)
                .add(ZaisankuSenkyojiTorokuValidatorMessage.転入期限日基準日大小チェック,
                        tennyuList)
                .add(ZaisankuSenkyojiTorokuValidatorMessage.転出期限日転入期限日大小チェック,
                        tenshunyuList)
                .add(ZaisankuSenkyojiTorokuValidatorMessage.投票開始日基準日大小チェック,
                        tohyokaishiList).
                build();
    }
}
