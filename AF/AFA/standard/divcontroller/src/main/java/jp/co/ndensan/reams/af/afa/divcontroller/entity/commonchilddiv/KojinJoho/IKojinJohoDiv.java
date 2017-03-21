package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho;

import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *@reamsid_L AF-0180-014 liuyj
 */
public interface IKojinJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * IAtenaShokaiSimpleDivのgetter
     *
     * @return IAtenaShokaiSimpleDiv
     */
    IAtenaShokaiSimpleDiv getCcdKojinJohoUR();

    /**
     * 初期化イベントです。
     *
     * @param 識別コード ShikibetsuCode
     */
    void initialize(ShikibetsuCode 識別コード);

    /**
     * カナ名称を戻る
     *
     * @return RString
     */
    RString getカナ名称();

    /**
     * 漢字名称を戻る
     *
     * @return RString
     */
    RString get漢字名称();
}
