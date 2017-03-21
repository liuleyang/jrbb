/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.GamenParam;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiHonsekiParam;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.SaikofuTsuchiParam;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSakuseiChohyo;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShinseiResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.ISakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020.ZaigaiHenkoDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 証明書記載事項変更に対応するHandlerクラスです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public final class ZaigaiHenkoHandler {

    private final ZaigaiHenkoDiv div;
    private final Code 修正区分_記載事項変更 = new Code("2");
    private final Code 修正区分_再交付 = new Code("1");
    private final Code 申請区分_証明書交付 = new Code("4");
    private final Code 申請区分_名簿抹消 = new Code("5");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private ZaigaiHenkoHandler(ZaigaiHenkoDiv div) {
        this.div = div;
    }

    /**
     * 証明書記載事項変更のHandler初期化
     *
     * @param div 証明書記載事項変更DIV
     * @return 証明書記載事項変更のHandler
     */
    public static ZaigaiHenkoHandler of(ZaigaiHenkoDiv div) {
        return new ZaigaiHenkoHandler(div);
    }

    /**
     * 在外選挙資格編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoShikakuResult
     */
    public ZaigaiSenkyoShikakuResult eidt在外選挙資格Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoShikakuResult 在外選挙資格 = new ZaigaiSenkyoShikakuResult();
        在外選挙資格.set識別コード(識別コード);
        在外選挙資格.set申請番号(申請番号);
        在外選挙資格.set国民投票区分(在外選挙人情報のデータ.get在外選挙資格().getKokuminTohyoKubun());
        if (AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙資格.set国民投票抄本番号(new ShohonNo(div.getCcdZaigaiHenkoJoho().get在外名簿情報()
                    .getCcdShohonNameList().getSelectedShohonNo()));
        } else {
            在外選挙資格.set国民投票抄本番号(在外選挙人情報のデータ.get在外選挙資格().getKokuminShohonNo());
        }
        在外選挙資格.set本籍地登録区分(在外選挙人情報のデータ.get在外選挙資格().getHonsekiTorokuKubun());

        在外選挙資格.set投票区コード(在外選挙人情報のデータ.get在外選挙資格().getTohyokuCode());
        在外選挙資格.set名簿登録年月日(在外選挙人情報のデータ.get在外選挙資格().getMeiboTorokuYMD());
        在外選挙資格.set表示年月日(在外選挙人情報のデータ.get在外選挙資格().getHyojiYMD());
        在外選挙資格.set表示事由コード(在外選挙人情報のデータ.get在外選挙資格().getHyojiJiyuCode());

        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙資格.set交付番号(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().getValue());
            RDate 交付年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().getValue();
            在外選挙資格.set交付年月日(null == 交付年月日 ? FlexibleDate.EMPTY : new FlexibleDate(交付年月日.toDateString()));
            在外選挙資格.set選挙資格区分(new Code(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getRadZaigaiShikaku().getSelectedKey()));
            在外選挙資格.set抹消年月日(在外選挙人情報のデータ.get在外選挙資格().getMasshoYMD());
            在外選挙資格.set抹消事由コード(在外選挙人情報のデータ.get在外選挙資格().getMasshoJiyuCode());
            在外選挙資格.set修正区分(修正区分_記載事項変更);
            在外選挙資格.set修正年月日(FlexibleDate.getNowDate());
            在外選挙資格.set再交付事由コード(在外選挙人情報のデータ.get在外選挙資格().getSaiKofuJiyuCode());
            在外選挙資格.set記載事項変更事由コード(在外選挙人情報のデータ.get在外選挙資格().getHenkoJiyuCode());
            在外選挙資格.set特記事項(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtBiko().getValue());
        } else if (AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙資格.set交付番号(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().getValue());
            RDate 交付年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().getValue();
            在外選挙資格.set交付年月日(null == 交付年月日 ? FlexibleDate.EMPTY : new FlexibleDate(交付年月日.toDateString()));
            在外選挙資格.set選挙資格区分(在外選挙人情報のデータ.get在外選挙資格().getShikakuKubun());
            在外選挙資格.set抹消年月日(在外選挙人情報のデータ.get在外選挙資格().getMasshoYMD());
            在外選挙資格.set抹消事由コード(在外選挙人情報のデータ.get在外選挙資格().getMasshoJiyuCode());
            在外選挙資格.set修正区分(修正区分_再交付);
            在外選挙資格.set修正年月日(FlexibleDate.getNowDate());
            在外選挙資格.set再交付事由コード(new Code(div.getCcdZaigaiHenkoSenkyoninJoho()
                    .getZaigaiShinseiJoho().getCcdSaiKofuJiyu().getSelectJiyuCode()));
            在外選挙資格.set記載事項変更事由コード(在外選挙人情報のデータ.get在外選挙資格().getHenkoJiyuCode());
            在外選挙資格.set特記事項(在外選挙人情報のデータ.get在外選挙資格().getTokkiJiko());
        } else if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙資格.set交付番号(在外選挙人情報のデータ.get在外選挙資格().getKofuNo());
            在外選挙資格.set交付年月日(在外選挙人情報のデータ.get在外選挙資格().getKofuYMD());
            在外選挙資格.set選挙資格区分(在外選挙人情報のデータ.get在外選挙資格().getShikakuKubun());
            在外選挙資格.set抹消年月日(new FlexibleDate(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtMasshoYMD().getText()));
            在外選挙資格.set抹消事由コード(new Code(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdMasshoJiyu().getSelectJiyuCode()));
            在外選挙資格.set修正区分(new Code(RString.EMPTY));
            在外選挙資格.set修正年月日(FlexibleDate.EMPTY);
            在外選挙資格.set再交付事由コード(new Code(RString.EMPTY));
            在外選挙資格.set記載事項変更事由コード(new Code(RString.EMPTY));
            在外選挙資格.set特記事項(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtBiko().getValue());

        }
        return 在外選挙資格;
    }

    /**
     * 在外選挙人申請情報編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninShinseiResult
     */
    public ZaigaiSenkyoninShinseiResult eidt在外選挙人申請情報Forインサート(int 申請番号, ShikibetsuCode 識別コード) {
        ZaigaiSenkyoninShinseiResult 在外選挙人申請情報 = new ZaigaiSenkyoninShinseiResult();
        RDate 住定日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD().getValue();
        RString 領事官コード = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getCcdRyojikan().getTxtRyojikanCode().getValue();
        RString 国籍コード = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getCcdKokuseki().getHdnTxtCode();
        AtenaMeisho 申請者氏名 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtShimei().getDomain();
        AtenaKanaMeisho 申請者カナ氏名 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtShimeiKana().getDomain();
        FlexibleDate 生年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtSeinengappiYMD().getValue();
        RString 性別コード = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getDdlSeibetsu().getSelectedKey();
        RDate 申請日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().getValue();
        FlexibleDate 申請取下年月日 = null == div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().getValue().toDateString());
        Code 申請取下事由コード = RString.isNullOrEmpty(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getSelectJiyuCode())
                ? Code.EMPTY : new Code(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getSelectJiyuCode());
        FlexibleDate 却下年月日 = null == div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().getValue().toDateString());
        Code 却下事由コード = RString.isNullOrEmpty(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().getSelectJiyuCode())
                ? Code.EMPTY : new Code(div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().getSelectJiyuCode());
        RDate 本籍地照会年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().getValue();
        RDate 本籍地回答年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().getValue();
        RDate 本籍地通知年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().getValue();
        在外選挙人申請情報.set申請番号(申請番号);
        在外選挙人申請情報.set識別コード(識別コード);
        在外選挙人申請情報.set住定年月日(null == 住定日 ? FlexibleDate.EMPTY : new FlexibleDate(住定日.toDateString()));
        在外選挙人申請情報.set領事官コード(領事官コード);
        在外選挙人申請情報.set国籍コード(国籍コード);
        在外選挙人申請情報.set申請者氏名(申請者氏名);
        在外選挙人申請情報.set申請者カナ氏名(申請者カナ氏名);
        在外選挙人申請情報.set生年月日(生年月日);
        在外選挙人申請情報.set性別コード(性別コード);
        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙人申請情報.set申請区分(申請区分_証明書交付);
        } else if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            在外選挙人申請情報.set申請区分(申請区分_名簿抹消);
        }

        在外選挙人申請情報.set申請年月日(null == 申請日 ? FlexibleDate.EMPTY : new FlexibleDate(申請日.toDateString()));
        在外選挙人申請情報.set申請内容変更年月日(FlexibleDate.EMPTY);
        在外選挙人申請情報.set申請内容変更事由コード(Code.EMPTY);
        在外選挙人申請情報.set申請取下年月日(申請取下年月日);
        在外選挙人申請情報.set申請取下事由コード(申請取下事由コード);
        在外選挙人申請情報.set却下年月日(却下年月日);
        在外選挙人申請情報.set却下事由コード(却下事由コード);
        在外選挙人申請情報.set本籍地照会年月日(null == 本籍地照会年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地照会年月日.toDateString()));
        在外選挙人申請情報.set本籍地回答年月日(null == 本籍地回答年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地回答年月日.toDateString()));
        在外選挙人申請情報.set本籍地通知年月日(null == 本籍地通知年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地通知年月日.toDateString()));
        在外選挙人申請情報.set特記事項(div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtBiko().getValue());
        return 在外選挙人申請情報;
    }

    /**
     * 在外選挙人住所情報_本籍地住所編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_本籍地住所Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoninJushoResult result = new ZaigaiSenkyoninJushoResult(在外選挙人情報のデータ.get在外選挙人住所情報_本籍());
        result.set識別コード(識別コード);
        result.set申請番号(申請番号);
        return result;
    }

    /**
     * 在外選挙人住所情報_国外転出前最終住所編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_国外転出前最終住所Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoninJushoResult result = new ZaigaiSenkyoninJushoResult(在外選挙人情報のデータ.get在外選挙人住所情報_最終住所());
        result.set識別コード(識別コード);
        result.set申請番号(申請番号);
        return result;
    }

    /**
     * 在外選挙人住所情報_国内転入先住所編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_国内転入先住所Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoninJushoResult result = new ZaigaiSenkyoninJushoResult(在外選挙人情報のデータ.get在外選挙人住所情報_国内転入先住所());
        if (result.getEntity() != null) {
            result.set識別コード(識別コード);
            result.set申請番号(申請番号);
        }

        return result;
    }

    /**
     * 在外選挙人住所情報_海外住所編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外住所Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoninJushoResult result = new ZaigaiSenkyoninJushoResult(在外選挙人情報のデータ.get在外選挙人住所情報_海外住所());
        result.set識別コード(識別コード);
        result.set申請番号(申請番号);
        return result;
    }

    /**
     * 在外選挙人住所情報_海外送付先住所編集処理。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @param 在外選挙人情報のデータ ZaigaiSenkyoninJohoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外送付先住所Forインサート(int 申請番号, ShikibetsuCode 識別コード, ZaigaiSenkyoninJohoResult 在外選挙人情報のデータ) {
        ZaigaiSenkyoninJushoResult result = new ZaigaiSenkyoninJushoResult(在外選挙人情報のデータ.get在外選挙人住所情報_海外送付先住所());
        result.set識別コード(識別コード);
        result.set申請番号(申請番号);
        return result;
    }

    /**
     * 在外選挙人証帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @return List<ZaigaiSenkyoninShoParam>
     */
    public List<ZaigaiSenkyoninShoParam> edit在外選挙人証(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<ZaigaiSenkyoninShoParam> zaigaiSenkyoninShoList = new ArrayList<>();
        ZaigaiSenkyoninShoParam param = new ZaigaiSenkyoninShoParam(
                在外選挙人情報.get選挙情報(),
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙資格(),
                在外選挙人情報.get在外選挙人住所情報_最終住所(),
                在外選挙人情報.get在外選挙人住所情報_海外送付先住所());
        zaigaiSenkyoninShoList.add(param);
        return zaigaiSenkyoninShoList;
    }

    /**
     * 登録した旨の通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @return List<TorokuTsuchiParam>
     */
    public List<KisaijikoHenkoTsuchiHonninParam> edit記載事項変更通知_本人(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<KisaijikoHenkoTsuchiHonninParam> kisaijikoHenkoTsuchiHonninList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 記載事項変更通知_本人 = div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoToroku().getCcdPrintNaiyoTorokuTsuchi();
        画面帳票作成入力項目.set発行日(null == 記載事項変更通知_本人.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(記載事項変更通知_本人.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(記載事項変更通知_本人.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(記載事項変更通知_本人.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(記載事項変更通知_本人.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(記載事項変更通知_本人.getTxtIinchoName().getValue());
        KisaijikoHenkoTsuchiHonninParam param = new KisaijikoHenkoTsuchiHonninParam(
                在外選挙人情報.get在外選挙人申請情報(),
                画面帳票作成入力項目);
        kisaijikoHenkoTsuchiHonninList.add(param);
        return kisaijikoHenkoTsuchiHonninList;
    }

    /**
     * 登録を行わなかった旨の通知_本人の通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @param 識別コード ShikibetsuCode
     * @return List<NotTorokuTsuchiHonninParam>
     */
    public List<KisaijikoHenkoTsuchiRyojikanParam> edit記載事項変更通知_領事官(ZaigaiSenkyoninJohoResult 在外選挙人情報, ShikibetsuCode 識別コード) {
        List<KisaijikoHenkoTsuchiRyojikanParam> henkoTsuchiRyojikanList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 記載事項変更通知_領事官 = div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().getCcdPrintNaiyoTorikeshiHonnin();
        画面帳票作成入力項目.set発行日(null == 記載事項変更通知_領事官.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(記載事項変更通知_領事官.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(記載事項変更通知_領事官.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(記載事項変更通知_領事官.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(記載事項変更通知_領事官.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(記載事項変更通知_領事官.getTxtIinchoName().getValue());
        GamenParam 画面パラメータ = new GamenParam();
        画面パラメータ.set識別コード(識別コード);
        KisaijikoHenkoTsuchiRyojikanParam param = new KisaijikoHenkoTsuchiRyojikanParam(
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙資格(),
                画面帳票作成入力項目,
                画面パラメータ);
        henkoTsuchiRyojikanList.add(param);
        return henkoTsuchiRyojikanList;
    }

    /**
     * 再交付通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @param 識別コード ShikibetsuCode
     * @return List<SaikofuTsuchiParam>
     */
    public List<SaikofuTsuchiParam> edit再交付通知(ZaigaiSenkyoninJohoResult 在外選挙人情報, ShikibetsuCode 識別コード) {
        List<SaikofuTsuchiParam> saikofuTsuchiList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 再交付通知 = div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoSaiKofu().getCcdPrintNaiyoSaiKofuTsuchi();
        画面帳票作成入力項目.set発行日(null == 再交付通知.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(再交付通知.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(再交付通知.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(再交付通知.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(再交付通知.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(再交付通知.getTxtIinchoName().getValue());
        SaikofuTsuchiParam param = new SaikofuTsuchiParam(
                在外選挙人情報.get在外選挙人申請情報(),
                画面帳票作成入力項目);
        saikofuTsuchiList.add(param);
        return saikofuTsuchiList;
    }

    /**
     * 抹消通知_本籍地帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @param 識別コード ShikibetsuCode
     * @return List<MasshoTsuchiHonsekiParam>
     */
    public List<MasshoTsuchiHonsekiParam> edit抹消通知_本籍地(ZaigaiSenkyoninJohoResult 在外選挙人情報, ShikibetsuCode 識別コード) {
        List<MasshoTsuchiHonsekiParam> masshoTsuchiHonsekiList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 抹消通知_本籍地 = div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoHonsekichi().getCcdPrintNaiyoMasshoHonsekichi();
        画面帳票作成入力項目.set発行日(null == 抹消通知_本籍地.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(抹消通知_本籍地.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(抹消通知_本籍地.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(抹消通知_本籍地.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(抹消通知_本籍地.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(抹消通知_本籍地.getTxtIinchoName().getValue());
        MasshoTsuchiHonsekiParam param = new MasshoTsuchiHonsekiParam(
                在外選挙人情報.get在外選挙人住所情報_本籍(),
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙資格(),
                画面帳票作成入力項目);
        masshoTsuchiHonsekiList.add(param);
        return masshoTsuchiHonsekiList;
    }

    /**
     * 抹消通知_領事官帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @param 識別コード ShikibetsuCode
     * @return List<MasshoTsuchiRyojikanParam>
     */
    public List<MasshoTsuchiRyojikanParam> edit抹消通知_領事官(ZaigaiSenkyoninJohoResult 在外選挙人情報, ShikibetsuCode 識別コード) {
        List<MasshoTsuchiRyojikanParam> masshoTsuchiRyojikanParamList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 抹消通知_領事官 = div.getCcdZaigaiHenkoSakuseiChohyo().getZaigaiSakuseiChohyoMasshoRyojikan().getCcdPrintNaiyoMasshoRyojikan();
        画面帳票作成入力項目.set発行日(null == 抹消通知_領事官.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(抹消通知_領事官.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(抹消通知_領事官.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(抹消通知_領事官.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(抹消通知_領事官.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(抹消通知_領事官.getTxtIinchoName().getValue());
        MasshoTsuchiRyojikanParam param = new MasshoTsuchiRyojikanParam(
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙資格(),
                画面帳票作成入力項目);
        masshoTsuchiRyojikanParamList.add(param);
        return masshoTsuchiRyojikanParamList;
    }

}
