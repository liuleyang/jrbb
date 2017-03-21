package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0320-011 lis
 */
public interface IZaigaiSenkyoninJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param 識別コード Code
     * @param 申請番号 RString
     */
    void initialize(ShikibetsuCode 識別コード, RString 申請番号);

    /**
     * この共有子Divの取得。
     *
     * @return ZaigaiShinseiJohoDiv
     */
    ZaigaiShinseiJohoDiv getZaigaiShinseiJoho();

    /**
     * この共有子Divの取得。
     *
     * @return ZaigaiHonninJohoDiv
     */
    ZaigaiHonninJohoDiv getZaigaiHonninJoho();

    /**
     * この共有子Divの取得。
     *
     * @return ZaigaiZaijuJohoDiv
     */
    ZaigaiZaijuJohoDiv getZaigaiZaijuJoho();

    /**
     * 在外選挙資格取得。
     *
     * @return 在外選挙資格
     */
    RString getHdnZaigaiSenkyoShikaku();

    /**
     * 在外選挙人申請情報。
     *
     * @return 在外選挙人申請情報
     */
    RString getHdnZaigaiSenkyoninShinsei();

    /**
     * 本籍取得。
     *
     * @return 本籍
     */
    RString getHdnJushoShuruiKubun1();

    /**
     * 最終住所取得。
     *
     * @return 最終住所
     */
    RString getHdnJushoShuruiKubun2();

    /**
     * 国内転入先住所取得。
     *
     * @return 国内転入先住所
     */
    RString getHdnJushoShuruiKubun3();

    /**
     * 現住所取得。
     *
     * @return 現住所
     */
    RString getHdnJushoShuruiKubun4();

    /**
     * 送付先_住所取得。
     *
     * @return 送付先_住所
     */
    RString getHdnJushoShuruiKubun5();

    /**
     * この共有子Divの申請情報初期再表示を行います。
     *
     * @param 識別コード Code
     * @param 申請番号 RString
     */
    void 申請情報再表示(ShikibetsuCode 識別コード, RString 申請番号);
}
