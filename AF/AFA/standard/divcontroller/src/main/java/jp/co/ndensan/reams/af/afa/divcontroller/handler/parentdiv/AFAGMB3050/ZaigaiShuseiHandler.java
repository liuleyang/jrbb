/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JushoShuruiKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.ZaigaiShuseiDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KatagakiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 在外選挙人名簿修正に対応するHandlerクラスです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public final class ZaigaiShuseiHandler {

    private final ZaigaiShuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ZaigaiShuseiDiv
     */
    private ZaigaiShuseiHandler(ZaigaiShuseiDiv div) {
        this.div = div;
    }

    /**
     * 在外選挙人名簿修正のHandler初期化
     *
     * @param div 在外選挙人名簿修正DIV
     * @return 在外選挙人名簿修正のHandler
     */
    public static ZaigaiShuseiHandler of(ZaigaiShuseiDiv div) {
        return new ZaigaiShuseiHandler(div);
    }

    /**
     * 在外選挙人名簿修正画面初期化。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     * @param 名簿情報 ZaigaiSenkyoninMeiboResult
     */
    public void initialize(ShikibetsuCode 識別コード,
            RString 申請番号,
            ZaigaiSenkyoninMeiboResult 名簿情報) {
        div.getCcdShohonNameList().initialize();
        div.getCcdKojinJoho().initialize(識別コード);
        div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().initialize(申請番号, 識別コード);

        div.getZaigaiShuseiShikakuJoho().getTxtGroupCode().setValue(名簿情報.getグループコード());
        div.getZaigaiShuseiShikakuJoho().getTxtGroupCode().setReadOnly(Boolean.TRUE);
        if (名簿情報.get投票区コード() == null) {
            div.getZaigaiShuseiShikakuJoho().getCcdTohyokuCodeMeibo().initialize();
        } else {
            div.getZaigaiShuseiShikakuJoho().getCcdTohyokuCodeMeibo().initialize(名簿情報.get投票区コード());
        }

        div.getZaigaiShuseiShikakuJoho().getCcdTohyokuCodeMeibo().setReadOnlyMode(Boolean.TRUE);
        div.getZaigaiShuseiShikakuJoho().getTxtKokugaiBunruiCode().setValue(名簿情報.get国外分類コード());
        div.getZaigaiShuseiShikakuJoho().getTxtKokugaiBunruiCode().setReadOnly(Boolean.TRUE);
        div.getZaigaiShuseiShikakuJoho().getCcdMeiboBango().initialize(
                名簿情報.get冊(),
                new Decimal(名簿情報.get頁()),
                new Decimal(名簿情報.get行()));
        div.getZaigaiShuseiShikakuJoho().getCcdMeiboBango().setReadOnly(Boolean.TRUE);

    }

    /**
     * 在外選挙資格更新引数を設定する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     * @return ZaigaiSenkyoShikakuResult
     */
    public ZaigaiSenkyoShikakuResult set在外選挙資格更新引数(ShikibetsuCode 識別コード,
            RString 申請番号) {
        ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult = new ZaigaiSenkyoShikakuResult();
        zaigaiSenkyoShikakuResult.set識別コード(識別コード);
        zaigaiSenkyoShikakuResult.set申請番号(申請番号 == null ? 0 : Integer.parseInt(申請番号.toString()));
        ShohonNo shohon = new ShohonNo(div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho()
                .get在外名簿情報().getCcdShohonNameList().getSelectedShohonNo());
        zaigaiSenkyoShikakuResult.set国民投票抄本番号(shohon);
        RDate 表示年月日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtHyojiYMD().getValue();
        zaigaiSenkyoShikakuResult.set表示年月日(表示年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(表示年月日.toDateString()));
        RString 表示事由 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdHyojiJiyu().getSelectJiyuCode();
        zaigaiSenkyoShikakuResult.set表示事由コード(表示事由 == null ? Code.EMPTY : new Code(表示事由));
        RString 特記事項 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtBiko().getValue();
        zaigaiSenkyoShikakuResult.set特記事項(特記事項);
        return zaigaiSenkyoShikakuResult;
    }

    /**
     * 在外選挙人住所情報更新引数を設定する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult set在外選挙人住所情報更新引数(ShikibetsuCode 識別コード,
            RString 申請番号) {
        ZaigaiSenkyoninJushoResult zaigaiSenkyoninJushoResult = new ZaigaiSenkyoninJushoResult();
        zaigaiSenkyoninJushoResult.set識別コード(識別コード);
        zaigaiSenkyoninJushoResult.set申請番号(申請番号 == null ? 0 : Integer.parseInt(申請番号.toString()));
        zaigaiSenkyoninJushoResult.set住所種類区分(JushoShuruiKubun.国内転入先住所.getコード());
        YubinNo 郵便番号 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuJusho().get郵便番号();
        zaigaiSenkyoninJushoResult.set郵便番号(郵便番号 == null ? YubinNo.EMPTY : 郵便番号);
        ZenkokuJushoCode 全国住所コード = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuJusho().get全国住所コード();
        zaigaiSenkyoninJushoResult.set全国住所コード(全国住所コード == null ? ZenkokuJushoCode.EMPTY : 全国住所コード);
        RString 住所 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuJusho().get全国住所名称();
        zaigaiSenkyoninJushoResult.set住所(住所 == null ? AtenaJusho.EMPTY : new AtenaJusho(住所));
        AtenaBanchi 番地 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuBanchi().get番地();
        zaigaiSenkyoninJushoResult.set番地(番地 == null ? AtenaBanchi.EMPTY : 番地);
        KatagakiCode 方書コード = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuKatagaki().get方書コード();
        zaigaiSenkyoninJushoResult.set方書コード(方書コード == null ? KatagakiCode.EMPTY : 方書コード);
        Katagaki 方書 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getCcdKokunaiTennyuKatagaki().get方書();
        zaigaiSenkyoninJushoResult.set方書(方書 == null ? Katagaki.EMPTY : 方書);
        RDate 国内転入年月日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().
                get在外名簿情報().getTxtKokunaiTennyuYMD().getValue();
        zaigaiSenkyoninJushoResult.set国内転入年月日(
                国内転入年月日 == null ? FlexibleDate.EMPTY : new FlexibleDate(国内転入年月日.toDateString()));
        return zaigaiSenkyoninJushoResult;
    }

}
