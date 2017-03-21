package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaikuTaishoShohonJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @return boolean
     */
    boolean initialize();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    ValidationMessageControlPairs 入力日付のチェック();

    TextBox getTxtShiyoShohon();

    RadioButton getRadShori();

    IShohonNameListDiv getCcdShohonNameList();

    TextBox getTxtShohonName();

    TextBox getTxtSenkyoName();

    TextBoxDate getTxtKijunYMD();

    TextBoxDate getTxtTohyoYMD();

    TextBoxDate getTxtTohyoUketsukeYMD();

    CheckBoxList getChkMutohyo();

    RString getHidMotoData();
}
