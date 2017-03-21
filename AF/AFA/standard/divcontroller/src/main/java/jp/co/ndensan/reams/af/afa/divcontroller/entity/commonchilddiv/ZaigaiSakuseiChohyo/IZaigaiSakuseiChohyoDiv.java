package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0320-012 zhanggs
 */
public interface IZaigaiSakuseiChohyoDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shinseiJotai RString
     */
    void initialize(RString... shinseiJotai);

    /**
     * 本籍地照会回答通知Div。
     *
     * @return ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchiDiv
     */
    ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchiDiv getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi();

    /**
     * 申請取消通知（本人）Div。
     *
     * @return ZaigaiSakuseiChohyoTorikeshiHonninDiv
     */
    ZaigaiSakuseiChohyoTorikeshiHonninDiv getZaigaiSakuseiChohyoTorikeshiHonnin();

    /**
     * 申請取消通知（領事官）Div。
     *
     * @return ZaigaiSakuseiChohyoTorikeshiRyojikanDiv
     */
    ZaigaiSakuseiChohyoTorikeshiRyojikanDiv getZaigaiSakuseiChohyoTorikeshiRyojikan();

    /**
     * 登録通知Div。
     *
     * @return ZaigaiSakuseiChohyoTorokuDiv
     */
    ZaigaiSakuseiChohyoTorokuDiv getZaigaiSakuseiChohyoToroku();

    /**
     * 記載事項変更通知（本人）Div。
     *
     * @return ZaigaiSakuseiChohyoHenkoHonninDiv
     */
    ZaigaiSakuseiChohyoHenkoHonninDiv getZaigaiSakuseiChohyoHenkoHonnin();

    /**
     * 記載事項変更通知（領事官）Div。
     *
     * @return ZaigaiSakuseiChohyoHenkoRyojikanDiv
     */
    ZaigaiSakuseiChohyoHenkoRyojikanDiv getZaigaiSakuseiChohyoHenkoRyojikan();

    /**
     * 再交付通知Div。
     *
     * @return ZaigaiSakuseiChohyoSaiKofuDiv
     */
    ZaigaiSakuseiChohyoSaiKofuDiv getZaigaiSakuseiChohyoSaiKofu();

    /**
     * 抹消通知（本籍地）Div。
     *
     * @return ZaigaiSakuseiChohyoMasshoHonsekichiDiv
     */
    ZaigaiSakuseiChohyoMasshoHonsekichiDiv getZaigaiSakuseiChohyoMasshoHonsekichi();

    /**
     * 抹消通知（領事官）Div。
     *
     * @return ZaigaiSakuseiChohyoMasshoRyojikanDiv
     */
    ZaigaiSakuseiChohyoMasshoRyojikanDiv getZaigaiSakuseiChohyoMasshoRyojikan();
}
