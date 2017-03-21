/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishaShokaiBunshoParam;
import jp.co.ndensan.reams.af.afa.business.core.TorokuTsuchiParam;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSakuseiChohyo;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShinseiResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JushoShuruiKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShinseiJotai;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ZaigaiKokugaiKindCode;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.ISakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuDiv;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KatagakiCode;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 在外選挙人名簿登録に対応するHandlerクラスです。
 *
 * @reamsid_L AF-0320-010 lis
 */
public final class ZaigaiMeiboTorokuHandler {

    private final ZaigaiMeiboTorokuDiv div;
    private final Code 国民投票区分_在外選挙資格 = new Code("1");
    private final Code 国民投票区分_在外国民投票資格 = new Code("2");
    private final ShohonNo 国民投票抄本番号 = new ShohonNo(0);
    private final RString グループコード_デフォルト = new RString("0");
    private final RString 国外分類コード_デフォルト = new RString("000");
    private final RString 冊_デフォルト = new RString("00");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private ZaigaiMeiboTorokuHandler(ZaigaiMeiboTorokuDiv div) {
        this.div = div;
    }

    /**
     * 在外選挙人名簿登録のHandler初期化
     *
     * @param div 在外選挙人名簿登録DIV
     * @return 在外選挙人名簿登録のHandler
     */
    public static ZaigaiMeiboTorokuHandler of(ZaigaiMeiboTorokuDiv div) {
        return new ZaigaiMeiboTorokuHandler(div);
    }

    /**
     * 在外選挙人名簿編集処理。
     *
     * @param 抄本番号リスト List<ShohonNo>
     * @param 識別コード ShikibetsuCode
     * @return List<ZaigaiSenkyoninMeiboResult>
     */
    public List<ZaigaiSenkyoninMeiboResult> eidt在外選挙人名簿Forインサート(List<ShohonResult> 抄本番号リスト, ShikibetsuCode 識別コード) {
        if (null == 抄本番号リスト || 抄本番号リスト.isEmpty()) {
            return null;
        }
        List<ZaigaiSenkyoninMeiboResult> 在外選挙人名簿リスト = new ArrayList<>();
        for (ShohonResult 抄本番号 : 抄本番号リスト) {
            ZaigaiSenkyoninMeiboResult result = new ZaigaiSenkyoninMeiboResult();
            RString 投票区コード = div.getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdTohyokuCode().get投票区コード();
            RString 領事官コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                    .getCcdRyojikan().getTxtRyojikanCode().getValue();
            RString 国籍コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                    .getCcdKokuseki().getHdnTxtCode();
            RString 国外分類コード = 国外分類コード_デフォルト;
            RString 在外_国外分類コード = BusinessConfig.get(ConfigKeysAFA.在外_国外分類コード, SubGyomuCode.AFA選挙本体);
            if (ZaigaiKokugaiKindCode.国籍コード使用する.value().equals(在外_国外分類コード)) {
                国外分類コード = 国籍コード;
            }
            if (ZaigaiKokugaiKindCode.領事官コード使用する.value().equals(在外_国外分類コード)) {
                国外分類コード = 領事官コード;
            }
            List<Integer> list = MeibotorokuZaigai.createInstance().get在外選挙人名簿_頁と行(抄本番号.get抄本番号(), 投票区コード, 国外分類コード);
            result.set抄本番号(抄本番号.get抄本番号());
            result.setグループコード(グループコード_デフォルト);
            result.set投票区コード(投票区コード);
            result.set国外分類コード(国外分類コード);
            result.set冊(冊_デフォルト);
            result.set頁(list.get(0));
            result.set行(list.get(1));
            result.set識別コード(識別コード);
            在外選挙人名簿リスト.add(result);
        }

        return 在外選挙人名簿リスト;
    }

    /**
     * 在外選挙資格編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoShikakuResult
     */
    public ZaigaiSenkyoShikakuResult eidt在外選挙資格Forインサート(ShikibetsuCode 識別コード) {
        ZaigaiSenkyoShikakuResult result_insert = new ZaigaiSenkyoShikakuResult();
        int 申請番号 = get申請番号();
        Code 本籍地登録区分 = new Code(String.valueOf(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho()
                .getRadHonsekichiToroku().getSelectedIndex()));
        result_insert.set識別コード(識別コード);
        if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())) {
            result_insert.set国民投票区分(国民投票区分_在外選挙資格);
        } else if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())) {
            result_insert.set国民投票区分(国民投票区分_在外国民投票資格);
        }

        result_insert.set国民投票抄本番号(国民投票抄本番号);
        result_insert.set選挙資格区分(new Code(SennkyoSikakuKubun.資格なし.value()));
        result_insert.set申請番号(申請番号);
        result_insert.set本籍地登録区分(本籍地登録区分);
        result_insert.set交付番号(RString.EMPTY);
        result_insert.set交付年月日(FlexibleDate.EMPTY);
        result_insert.set投票区コード(RString.EMPTY);
        result_insert.set名簿登録年月日(FlexibleDate.EMPTY);
        result_insert.set表示年月日(FlexibleDate.EMPTY);
        result_insert.set表示事由コード(Code.EMPTY);
        result_insert.set抹消年月日(FlexibleDate.EMPTY);
        result_insert.set抹消事由コード(Code.EMPTY);
        result_insert.set修正区分(Code.EMPTY);
        result_insert.set修正年月日(FlexibleDate.EMPTY);
        result_insert.set再交付事由コード(Code.EMPTY);
        result_insert.set記載事項変更事由コード(Code.EMPTY);
        result_insert.set特記事項(RString.EMPTY);
        return result_insert;
    }

    /**
     * 在外選挙資格編集処理。
     *
     * @param 在外選挙資格 ZaigaiSenkyoShikakuResult
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoShikakuResult
     */
    public ZaigaiSenkyoShikakuResult eidt在外選挙資格For更新(ZaigaiSenkyoShikakuResult 在外選挙資格, ShikibetsuCode 識別コード) {
        Code 本籍地登録区分 = new Code(String.valueOf(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho()
                .getRadHonsekichiToroku().getSelectedIndex()));
        RString 交付番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().getValue();
        交付番号 = RString.isNullOrEmpty(交付番号) ? RString.EMPTY : 交付番号;
        FlexibleDate 交付年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().getValue().toDateString());
        Code 選挙資格区分 = new Code(String.valueOf(div.getCcdZaigaiMeiboJoho().get在外名簿情報().getRadZaigaiShikaku().getSelectedIndex()));
        RString 投票区コード = div.getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdTohyokuCode().get投票区コード();
        投票区コード = RString.isNullOrEmpty(投票区コード) ? RString.EMPTY : 投票区コード;
        FlexibleDate 名簿登録年月日 = null == div.getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtTorokuYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtTorokuYMD().getValue().toDateString());
        在外選挙資格.set国民投票抄本番号(new ShohonNo(
                div.getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdShohonNameList().getSelectedShohonNo()));
        在外選挙資格.set本籍地登録区分(本籍地登録区分);
        在外選挙資格.set交付番号(交付番号);
        在外選挙資格.set交付年月日(交付年月日);
        在外選挙資格.set選挙資格区分(選挙資格区分);
        在外選挙資格.set投票区コード(投票区コード);
        在外選挙資格.set名簿登録年月日(名簿登録年月日);
        return 在外選挙資格;
    }

    /**
     * 在外選挙人申請情報編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninShinseiResult
     */
    public ZaigaiSenkyoninShinseiResult eidt在外選挙人申請情報Forインサート(ShikibetsuCode 識別コード) {
        ZaigaiSenkyoninShinseiResult result_insert = new ZaigaiSenkyoninShinseiResult();
        int 申請番号 = get申請番号();
        RDate 住定日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD().getValue();
        RString 領事官コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                .getCcdRyojikan().getTxtRyojikanCode().getValue();
        RString 国籍コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                .getCcdKokuseki().getHdnTxtCode();
        AtenaMeisho 申請者氏名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtShimei().getDomain();
        AtenaKanaMeisho 申請者カナ氏名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtShimeiKana().getDomain();
        FlexibleDate 生年月日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtSeinengappiYMD().getValue();
        RString 性別コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getDdlSeibetsu().getSelectedKey();
        RString 申請区分 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getZaigaiShinseiKubun()
                .getRadShinseiKubun().getSelectedKey();
        RDate 申請日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().getValue();
        RDate 本籍地照会年月日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().getValue();
        RDate 本籍地回答年月日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().getValue();
        RDate 本籍地通知年月日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().getValue();
        result_insert.set申請番号(申請番号);
        result_insert.set識別コード(識別コード);
        result_insert.set住定年月日(null == 住定日 ? FlexibleDate.EMPTY : new FlexibleDate(住定日.toDateString()));
        result_insert.set領事官コード(領事官コード);
        result_insert.set国籍コード(国籍コード);
        result_insert.set申請者氏名(申請者氏名);
        result_insert.set申請者カナ氏名(申請者カナ氏名);
        result_insert.set生年月日(生年月日);
        result_insert.set性別コード(性別コード);
        result_insert.set申請区分(RString.isNullOrEmpty(申請区分) ? Code.EMPTY : new Code(申請区分));
        result_insert.set申請年月日(null == 申請日 ? FlexibleDate.EMPTY : new FlexibleDate(申請日.toDateString()));
        result_insert.set申請内容変更年月日(FlexibleDate.EMPTY);
        result_insert.set申請内容変更事由コード(Code.EMPTY);
        result_insert.set申請取下年月日(FlexibleDate.EMPTY);
        result_insert.set申請取下事由コード(Code.EMPTY);
        result_insert.set却下年月日(FlexibleDate.EMPTY);
        result_insert.set却下事由コード(Code.EMPTY);
        result_insert.set本籍地照会年月日(null == 本籍地照会年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地照会年月日.toDateString()));
        result_insert.set本籍地回答年月日(null == 本籍地回答年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地回答年月日.toDateString()));
        result_insert.set本籍地通知年月日(null == 本籍地通知年月日 ? FlexibleDate.EMPTY : new FlexibleDate(本籍地通知年月日.toDateString()));
        result_insert.set特記事項(RString.EMPTY);
        return result_insert;
    }

    /**
     * 在外選挙人申請情報編集処理。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiResult
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninShinseiResult
     */
    public ZaigaiSenkyoninShinseiResult eidt在外選挙人申請情報For更新(ZaigaiSenkyoninShinseiResult 在外選挙人申請情報, ShikibetsuCode 識別コード) {
        FlexibleDate 住定日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD().getValue().toDateString());
        RString 領事官コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                .getCcdRyojikan().getTxtRyojikanCode().getValue();
        RString 国籍コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho()
                .getCcdKokuseki().getHdnTxtCode();
        AtenaMeisho 申請者氏名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtShimei().getDomain();
        AtenaKanaMeisho 申請者カナ氏名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtShimeiKana().getDomain();
        FlexibleDate 生年月日 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getTxtSeinengappiYMD().getValue();
        RString 性別コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getDdlSeibetsu().getSelectedKey();
        Code 申請区分 = new Code(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getZaigaiShinseiKubun()
                .getRadShinseiKubun().getSelectedKey());
        FlexibleDate 申請日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().getValue().toDateString());
        FlexibleDate 申請取下年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().getValue().toDateString());
        Code 申請取下事由コード = RString.isNullOrEmpty(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getSelectJiyuCode())
                ? Code.EMPTY : new Code(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getSelectJiyuCode());
        FlexibleDate 却下年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().getValue().toDateString());
        Code 却下事由コード = RString.isNullOrEmpty(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().getSelectJiyuCode())
                ? Code.EMPTY : new Code(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().getSelectJiyuCode());
        FlexibleDate 本籍地照会年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().getValue().toDateString());
        FlexibleDate 本籍地回答年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().getValue().toDateString());
        FlexibleDate 本籍地通知年月日 = null == div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().getValue().toDateString());
        RString 特記事項 = div.getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtBiko().getValue();
        在外選挙人申請情報.set住定年月日(住定日);
        在外選挙人申請情報.set領事官コード(領事官コード);
        在外選挙人申請情報.set国籍コード(国籍コード);
        在外選挙人申請情報.set申請者氏名(申請者氏名);
        在外選挙人申請情報.set申請者カナ氏名(申請者カナ氏名);
        在外選挙人申請情報.set生年月日(生年月日);
        在外選挙人申請情報.set性別コード(性別コード);
        在外選挙人申請情報.set申請区分(申請区分);
        在外選挙人申請情報.set申請年月日(申請日);
        在外選挙人申請情報.set申請取下年月日(申請取下年月日);
        在外選挙人申請情報.set申請取下事由コード(申請取下事由コード);
        在外選挙人申請情報.set却下年月日(却下年月日);
        在外選挙人申請情報.set却下事由コード(却下事由コード);
        在外選挙人申請情報.set本籍地照会年月日(本籍地照会年月日);
        在外選挙人申請情報.set本籍地回答年月日(本籍地回答年月日);
        在外選挙人申請情報.set本籍地通知年月日(本籍地通知年月日);
        在外選挙人申請情報.set特記事項(特記事項);
        return 在外選挙人申請情報;
    }

    /**
     * 在外選挙人住所情報_本籍地住所編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_本籍地住所Forインサート(ShikibetsuCode 識別コード) {
        return edit本籍地住所(識別コード, get申請番号());
    }

    /**
     * 在外選挙人住所情報_本籍地住所編集処理。
     *
     * @param 本籍住所 ZaigaiSenkyoninJushoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_本籍地住所For更新(ZaigaiSenkyoninJushoResult 本籍住所) {
        YubinNo 本籍住所_郵便番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get郵便番号();
        ZenkokuJushoCode 本籍住所_全国住所コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get全国住所コード();
        AtenaJusho 本籍住所_住所 = new AtenaJusho(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get全国住所名称());
        AtenaBanchi 本籍住所_番地 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiBanchi().get番地();
        本籍住所.set住所種類区分(JushoShuruiKubun.本籍地住所.getコード());
        本籍住所.set郵便番号(本籍住所_郵便番号);
        本籍住所.set全国住所コード(本籍住所_全国住所コード);
        本籍住所.set住所(本籍住所_住所);
        本籍住所.set番地(本籍住所_番地);
        本籍住所.set方書コード(KatagakiCode.EMPTY);
        本籍住所.set方書(Katagaki.EMPTY);
        本籍住所.set同居家族氏名(RString.EMPTY);
        本籍住所.set電話番号(RString.EMPTY);
        本籍住所.setFAX番号(RString.EMPTY);
        本籍住所.setメールアドレス(MailAddress.EMPTY);
        本籍住所.set国外転出年月日(FlexibleDate.EMPTY);
        本籍住所.set国内転入年月日(FlexibleDate.EMPTY);
        return 本籍住所;
    }

    private ZaigaiSenkyoninJushoResult edit本籍地住所(ShikibetsuCode 識別コード, int 申請番号) {
        ZaigaiSenkyoninJushoResult honsekiJusho = new ZaigaiSenkyoninJushoResult();
        YubinNo 本籍_郵便番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get郵便番号();
        ZenkokuJushoCode 本籍_全国住所コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get全国住所コード();
        AtenaJusho 本籍_住所 = new AtenaJusho(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiJusho().get全国住所名称());
        AtenaBanchi 本籍_番地 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdHonsekiBanchi().get番地();
        honsekiJusho.set識別コード(識別コード);
        honsekiJusho.set申請番号(申請番号);
        honsekiJusho.set住所種類区分(JushoShuruiKubun.本籍地住所.getコード());
        honsekiJusho.set郵便番号(本籍_郵便番号);
        honsekiJusho.set全国住所コード(本籍_全国住所コード);
        honsekiJusho.set住所(本籍_住所);
        honsekiJusho.set番地(本籍_番地);
        honsekiJusho.set方書コード(KatagakiCode.EMPTY);
        honsekiJusho.set方書(Katagaki.EMPTY);
        honsekiJusho.set同居家族氏名(RString.EMPTY);
        honsekiJusho.set電話番号(RString.EMPTY);
        honsekiJusho.setFAX番号(RString.EMPTY);
        honsekiJusho.setメールアドレス(MailAddress.EMPTY);
        honsekiJusho.set国外転出年月日(FlexibleDate.EMPTY);
        honsekiJusho.set国内転入年月日(FlexibleDate.EMPTY);
        return honsekiJusho;
    }

    /**
     * 在外選挙人住所情報_国外転出前最終住所編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_国外転出前最終住所Forインサート(ShikibetsuCode 識別コード) {
        return edit国外転出前最終住所(識別コード, get申請番号());
    }

    /**
     * 在外選挙人住所情報_国外転出前最終住所編集処理。
     *
     * @param 最終住所 ZaigaiSenkyoninJushoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_国外転出前最終住所For更新(ZaigaiSenkyoninJushoResult 最終住所) {
        YubinNo 最終_郵便番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get郵便番号();
        ZenkokuJushoCode 最終_全国住所コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get全国住所コード();
        AtenaJusho 最終_住所 = new AtenaJusho(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get全国住所名称());
        AtenaBanchi 最終_番地 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastBanchi().get番地();
        KatagakiCode 最終_方書コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastKatagaki().get方書コード();
        Katagaki 最終_方書 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastKatagaki().get方書();
        最終住所.set住所種類区分(JushoShuruiKubun.国外転出前最終住所.getコード());
        最終住所.set郵便番号(最終_郵便番号);
        最終住所.set全国住所コード(最終_全国住所コード);
        最終住所.set住所(最終_住所);
        最終住所.set番地(最終_番地);
        最終住所.set方書コード(最終_方書コード);
        最終住所.set方書(最終_方書);
        最終住所.set同居家族氏名(RString.EMPTY);
        最終住所.set電話番号(RString.EMPTY);
        最終住所.setFAX番号(RString.EMPTY);
        最終住所.setメールアドレス(MailAddress.EMPTY);
        最終住所.set国外転出年月日(FlexibleDate.EMPTY);
        最終住所.set国内転入年月日(FlexibleDate.EMPTY);
        return 最終住所;
    }

    private ZaigaiSenkyoninJushoResult edit国外転出前最終住所(ShikibetsuCode 識別コード, int 申請番号) {
        ZaigaiSenkyoninJushoResult lastJusho = new ZaigaiSenkyoninJushoResult();
        YubinNo 最終住所_郵便番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get郵便番号();
        ZenkokuJushoCode 最終住所_全国住所コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get全国住所コード();
        AtenaJusho 最終住所_住所 = new AtenaJusho(div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastJusho().get全国住所名称());
        AtenaBanchi 最終住所_番地 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastBanchi().get番地();
        KatagakiCode 最終住所_方書コード = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastKatagaki().get方書コード();
        Katagaki 最終住所_方書 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiHonninJoho().getCcdLastKatagaki().get方書();
        lastJusho.set識別コード(識別コード);
        lastJusho.set申請番号(申請番号);
        lastJusho.set住所種類区分(JushoShuruiKubun.国外転出前最終住所.getコード());
        lastJusho.set郵便番号(最終住所_郵便番号);
        lastJusho.set全国住所コード(最終住所_全国住所コード);
        lastJusho.set住所(最終住所_住所);
        lastJusho.set番地(最終住所_番地);
        lastJusho.set方書コード(最終住所_方書コード);
        lastJusho.set方書(最終住所_方書);
        lastJusho.set同居家族氏名(RString.EMPTY);
        lastJusho.set電話番号(RString.EMPTY);
        lastJusho.setFAX番号(RString.EMPTY);
        lastJusho.setメールアドレス(MailAddress.EMPTY);
        lastJusho.set国外転出年月日(FlexibleDate.EMPTY);
        lastJusho.set国内転入年月日(FlexibleDate.EMPTY);
        return lastJusho;
    }

    /**
     * 在外選挙人住所情報_海外住所編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外住所Forインサート(ShikibetsuCode 識別コード) {
        return edit海外住所(識別コード, get申請番号());
    }

    /**
     * 在外選挙人住所情報_海外住所編集処理。
     *
     * @param 海外住所 ZaigaiSenkyoninJushoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外住所For更新(ZaigaiSenkyoninJushoResult 海外住所) {
        AtenaJusho 現住所_海外住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiJusho().getDomain();
        RString 同居家族氏名_海外住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtDokyoKazoku().getValue();
        RString 電話番号_海外住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiTelNo().getDomain().getColumnValue();
        RString ファクス番号_海外住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiFaxNo().getDomain().getColumnValue();
        MailAddress メールアドレス_海外住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiMailAddress().getDomain();
        海外住所.set住所種類区分(JushoShuruiKubun.海外住所.getコード());
        海外住所.set郵便番号(YubinNo.EMPTY);
        海外住所.set全国住所コード(ZenkokuJushoCode.EMPTY);
        海外住所.set住所(現住所_海外住所);
        海外住所.set番地(AtenaBanchi.EMPTY);
        海外住所.set方書コード(KatagakiCode.EMPTY);
        海外住所.set方書(Katagaki.EMPTY);
        海外住所.set同居家族氏名(同居家族氏名_海外住所);
        海外住所.set電話番号(電話番号_海外住所);
        海外住所.setFAX番号(ファクス番号_海外住所);
        海外住所.setメールアドレス(メールアドレス_海外住所);
        海外住所.set国外転出年月日(FlexibleDate.EMPTY);
        海外住所.set国内転入年月日(FlexibleDate.EMPTY);
        return 海外住所;
    }

    private ZaigaiSenkyoninJushoResult edit海外住所(ShikibetsuCode 識別コード, int 申請番号) {
        ZaigaiSenkyoninJushoResult kaigaiJusho = new ZaigaiSenkyoninJushoResult();
        AtenaJusho 現住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiJusho().getDomain();
        RString 同居家族氏名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtDokyoKazoku().getValue();
        RString 電話番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiTelNo().getDomain().getColumnValue();
        RString ファクス番号 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiFaxNo().getDomain().getColumnValue();
        MailAddress メールアドレス = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiMailAddress().getDomain();
        kaigaiJusho.set識別コード(識別コード);
        kaigaiJusho.set申請番号(申請番号);
        kaigaiJusho.set住所種類区分(JushoShuruiKubun.海外住所.getコード());
        kaigaiJusho.set郵便番号(YubinNo.EMPTY);
        kaigaiJusho.set全国住所コード(ZenkokuJushoCode.EMPTY);
        kaigaiJusho.set住所(現住所);
        kaigaiJusho.set番地(AtenaBanchi.EMPTY);
        kaigaiJusho.set方書コード(KatagakiCode.EMPTY);
        kaigaiJusho.set方書(Katagaki.EMPTY);
        kaigaiJusho.set同居家族氏名(同居家族氏名);
        kaigaiJusho.set電話番号(電話番号);
        kaigaiJusho.setFAX番号(ファクス番号);
        kaigaiJusho.setメールアドレス(メールアドレス);
        kaigaiJusho.set国外転出年月日(FlexibleDate.EMPTY);
        kaigaiJusho.set国内転入年月日(FlexibleDate.EMPTY);
        return kaigaiJusho;
    }

    /**
     * 在外選挙人住所情報_海外送付先住所編集処理。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外送付先住所Forインサート(ShikibetsuCode 識別コード) {
        return edit海外送付先住所(識別コード, get申請番号());
    }

    /**
     * 在外選挙人住所情報_海外送付先住所編集処理。
     *
     * @param 海外送付先住所 ZaigaiSenkyoninJushoResult
     * @return ZaigaiSenkyoninJushoResult
     */
    public ZaigaiSenkyoninJushoResult eidt在外選挙人住所情報_海外送付先住所For更新(ZaigaiSenkyoninJushoResult 海外送付先住所) {
        AtenaJusho 海外送付先_住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().getDomain();
        RString 海外送付先_宛名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().getValue();
        海外送付先住所.set住所種類区分(JushoShuruiKubun.海外送付先住所.getコード());
        海外送付先住所.set郵便番号(YubinNo.EMPTY);
        海外送付先住所.set全国住所コード(ZenkokuJushoCode.EMPTY);
        海外送付先住所.set住所(海外送付先_住所);
        海外送付先住所.set番地(AtenaBanchi.EMPTY);
        海外送付先住所.set方書コード(KatagakiCode.EMPTY);
        海外送付先住所.set方書(Katagaki.EMPTY);
        海外送付先住所.set同居家族氏名(海外送付先_宛名);
        海外送付先住所.set電話番号(RString.EMPTY);
        海外送付先住所.setFAX番号(RString.EMPTY);
        海外送付先住所.setメールアドレス(MailAddress.EMPTY);
        海外送付先住所.set国外転出年月日(FlexibleDate.EMPTY);
        海外送付先住所.set国内転入年月日(FlexibleDate.EMPTY);
        return 海外送付先住所;
    }

    private ZaigaiSenkyoninJushoResult edit海外送付先住所(ShikibetsuCode 識別コード, int 申請番号) {
        ZaigaiSenkyoninJushoResult kaigaiSoufuSakiJusho = new ZaigaiSenkyoninJushoResult();
        AtenaJusho 送付先_住所 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().getDomain();
        RString 送付先_宛名 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().getValue();
        kaigaiSoufuSakiJusho.set識別コード(識別コード);
        kaigaiSoufuSakiJusho.set申請番号(申請番号);
        kaigaiSoufuSakiJusho.set住所種類区分(JushoShuruiKubun.海外送付先住所.getコード());
        kaigaiSoufuSakiJusho.set郵便番号(YubinNo.EMPTY);
        kaigaiSoufuSakiJusho.set全国住所コード(ZenkokuJushoCode.EMPTY);
        kaigaiSoufuSakiJusho.set住所(送付先_住所);
        kaigaiSoufuSakiJusho.set番地(AtenaBanchi.EMPTY);
        kaigaiSoufuSakiJusho.set方書コード(KatagakiCode.EMPTY);
        kaigaiSoufuSakiJusho.set方書(Katagaki.EMPTY);
        kaigaiSoufuSakiJusho.set同居家族氏名(送付先_宛名);
        kaigaiSoufuSakiJusho.set電話番号(RString.EMPTY);
        kaigaiSoufuSakiJusho.setFAX番号(RString.EMPTY);
        kaigaiSoufuSakiJusho.setメールアドレス(MailAddress.EMPTY);
        kaigaiSoufuSakiJusho.set国外転出年月日(FlexibleDate.EMPTY);
        kaigaiSoufuSakiJusho.set国内転入年月日(FlexibleDate.EMPTY);
        return kaigaiSoufuSakiJusho;
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
    public List<TorokuTsuchiParam> edit登録した旨の通知(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<TorokuTsuchiParam> notTorokuTsuchiList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 登録した旨の通知DIV = div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoToroku().getCcdPrintNaiyoTorokuTsuchi();
        画面帳票作成入力項目.set発行日(null == 登録した旨の通知DIV.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(登録した旨の通知DIV.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(登録した旨の通知DIV.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(登録した旨の通知DIV.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(登録した旨の通知DIV.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(登録した旨の通知DIV.getTxtIinchoName().getValue());
        TorokuTsuchiParam param = new TorokuTsuchiParam(
                在外選挙人情報.get在外選挙人住所情報_本籍(),
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙資格(),
                画面帳票作成入力項目);
        notTorokuTsuchiList.add(param);
        return notTorokuTsuchiList;
    }

    /**
     * 登録を行わなかった旨の通知_本人の通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @return List<NotTorokuTsuchiHonninParam>
     */
    public List<NotTorokuTsuchiHonninParam> edit登録を行わなかった旨の通知_本人(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<NotTorokuTsuchiHonninParam> notTorokuTsuchiHonninList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 登録を行わなかった旨の通知_本人DIV = div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().getCcdPrintNaiyoTorikeshiHonnin();
        画面帳票作成入力項目.set発行日(null == 登録を行わなかった旨の通知_本人DIV.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(登録を行わなかった旨の通知_本人DIV.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(登録を行わなかった旨の通知_本人DIV.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(登録を行わなかった旨の通知_本人DIV.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(登録を行わなかった旨の通知_本人DIV.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(登録を行わなかった旨の通知_本人DIV.getTxtIinchoName().getValue());
        NotTorokuTsuchiHonninParam param = new NotTorokuTsuchiHonninParam(
                在外選挙人情報.get在外選挙人申請情報(),
                画面帳票作成入力項目);
        notTorokuTsuchiHonninList.add(param);
        return notTorokuTsuchiHonninList;
    }

    /**
     * 登録を行わなかった旨の通知_領事官の通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @return List<NotTorokuTsuchiRyojikanParam>
     */
    public List<NotTorokuTsuchiRyojikanParam> edit登録を行わなかった旨の通知_領事官(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<NotTorokuTsuchiRyojikanParam> notTorokuTsuchiRyojikanList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 登録を行わなかった旨の通知_領事官DIV = div.getCcdZaigaiMeiboSakuseiChohyo()
                .getZaigaiSakuseiChohyoTorikeshiRyojikan().getCcdPrintNaiyoTorikeshiRyojikan();
        画面帳票作成入力項目.set発行日(null == 登録を行わなかった旨の通知_領事官DIV.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(登録を行わなかった旨の通知_領事官DIV.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(登録を行わなかった旨の通知_領事官DIV.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(登録を行わなかった旨の通知_領事官DIV.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(登録を行わなかった旨の通知_領事官DIV.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(登録を行わなかった旨の通知_領事官DIV.getTxtIinchoName().getValue());
        NotTorokuTsuchiRyojikanParam param = new NotTorokuTsuchiRyojikanParam(
                在外選挙人情報.get在外選挙人申請情報(),
                画面帳票作成入力項目);
        notTorokuTsuchiRyojikanList.add(param);
        return notTorokuTsuchiRyojikanList;
    }

    /**
     * 申請者の被登録資格の照会文書の通知帳票編集処理。
     *
     * @param 在外選挙人情報 ZaigaiSenkyoninJohoResult
     * @return List<ShinseishaShokaiBunshoParam>
     */
    public List<ShinseishaShokaiBunshoParam> edit申請者の被登録資格の照会文書(ZaigaiSenkyoninJohoResult 在外選挙人情報) {
        List<ShinseishaShokaiBunshoParam> shinseishaShokaiBunshoList = new ArrayList<>();
        ZaigaiSakuseiChohyo 画面帳票作成入力項目 = new ZaigaiSakuseiChohyo();
        ISakuseiChohyoPrintNaiyoDiv 申請者の被登録資格の照会文書DIV = div.getCcdZaigaiMeiboSakuseiChohyo()
                .getZaigaiSakuseiChohyoTorikeshiRyojikan().getCcdPrintNaiyoTorikeshiRyojikan();
        画面帳票作成入力項目.set発行日(null == 申請者の被登録資格の照会文書DIV.getTxtHakkoYMD().getValue()
                ? FlexibleDate.EMPTY : new FlexibleDate(申請者の被登録資格の照会文書DIV.getTxtHakkoYMD().getValue().toDateString()));
        画面帳票作成入力項目.set発行番号(申請者の被登録資格の照会文書DIV.getCcdHakkoBango().get発行番号_番号());
        画面帳票作成入力項目.set発行番号_第(申請者の被登録資格の照会文書DIV.getCcdHakkoBango().get発行番号_第());
        画面帳票作成入力項目.set発行番号_号(申請者の被登録資格の照会文書DIV.getCcdHakkoBango().get発行番号_号());
        画面帳票作成入力項目.set選管委員長名(申請者の被登録資格の照会文書DIV.getTxtIinchoName().getValue());
        ShinseishaShokaiBunshoParam param = new ShinseishaShokaiBunshoParam(
                在外選挙人情報.get在外選挙人申請情報(),
                在外選挙人情報.get在外選挙人住所情報_本籍(),
                在外選挙人情報.get在外選挙人住所情報_最終住所(),
                在外選挙人情報.get在外選挙資格(),
                画面帳票作成入力項目);
        shinseishaShokaiBunshoList.add(param);
        return shinseishaShokaiBunshoList;
    }

    /**
     * 「申請状態」ラジオボタン選択時申請情報部分の制御の変更。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     */
    public void change申請情報部分の制御(ShikibetsuCode 識別コード, RString 申請番号) {
        div.getCcdZaigaiMeiboSenkyoninJoho().申請情報再表示(識別コード, 申請番号);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getBtnShinseiNoSaiban().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setReadOnly(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().setRequiredMode(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().setDisabledMode(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getDdlJiyuNameList().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getDdlJiyuNameList().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setReadOnly(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().setDisabledMode(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().setRequiredMode(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setReadOnly(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setRequired(Boolean.FALSE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setReadOnly(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdSaiKofuJiyu().setDisplayNoneMode(Boolean.TRUE);
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdSaiKofuJiyu().setRequiredMode(Boolean.FALSE);
        RString shinseiJotai = div.getCcdZaigaiMeiboSenkyoninJoho().
                getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey();
        if (ShinseiJotai.未届.getKey().equals(shinseiJotai) || ShinseiJotai.申請.getKey().equals(shinseiJotai)
                || ShinseiJotai.証明書交付.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD().setRequired(Boolean.TRUE);
            if (null == 申請番号 || 申請番号.isEmpty()) {
                div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().setDisabled(Boolean.FALSE);
                div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().setRequired(Boolean.TRUE);
                div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getBtnShinseiNoSaiban().setDisabled(Boolean.FALSE);
            }
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setRequired(Boolean.TRUE);
        }
        if (ShinseiJotai.申請.getKey().equals(shinseiJotai) && (null == 申請番号 || 申請番号.isEmpty())) {
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setRequired(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setRequired(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setRequired(Boolean.FALSE);
        }

        if (ShinseiJotai.申請取下げ.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD().setReadOnly(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().setRequiredMode(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().setDisabledMode(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getDdlJiyuNameList().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu().getDdlJiyuNameList().setDisabled(Boolean.FALSE);
        }
        if (ShinseiJotai.申請却下.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD().setReadOnly(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().setDisabledMode(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu().setRequiredMode(Boolean.TRUE);
        }
        if (ShinseiJotai.証明書交付.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD().setReadOnly(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setDisabled(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setRequired(Boolean.TRUE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuNo().setReadOnly(Boolean.FALSE);
            div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.FALSE);
        }
    }

    /**
     * 「申請状態」ラジオボタン選択時作成帳票部分の制御の変更。
     *
     */
    public void change作成帳票部分の制御() {
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiRyojikan().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHenkoHonnin().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHenkoRyojikan().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoSaiKofu().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoToroku().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoMasshoHonsekichi().setDisplayNone(Boolean.TRUE);
        div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoMasshoRyojikan().setDisplayNone(Boolean.TRUE);
        RString shinseiJotai = div.getCcdZaigaiMeiboSenkyoninJoho().
                getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().getSelectedKey();
        if (ShinseiJotai.申請.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().setDisplayNone(Boolean.FALSE);
        }
        if (ShinseiJotai.申請却下.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiHonnin().setDisplayNone(Boolean.FALSE);
            div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoTorikeshiRyojikan().setDisplayNone(Boolean.FALSE);
        }
        if (ShinseiJotai.証明書交付.getKey().equals(shinseiJotai)) {
            div.getCcdZaigaiMeiboSakuseiChohyo().getZaigaiSakuseiChohyoToroku().setDisplayNone(Boolean.FALSE);
        }
    }

    private int get申請番号() {
        RString 申請番号_画面入力 = div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiNo().getValue();
        return RString.isNullOrEmpty(申請番号_画面入力) ? 0 : Integer.valueOf(申請番号_画面入力.toString());
    }

    /**
     * メニューから遷移場合、「未届」「申請」のみ活性
     *
     */
    public void set申請状態ラジオボタン非活性() {
        List<KeyValueDataSource> disabledItem = new ArrayList<>();
        disabledItem.add(new KeyValueDataSource(ShinseiJotai.申請却下.getKey(), ShinseiJotai.申請却下.getValue()));
        disabledItem.add(new KeyValueDataSource(ShinseiJotai.申請取下げ.getKey(), ShinseiJotai.申請取下げ.getValue()));
        disabledItem.add(new KeyValueDataSource(ShinseiJotai.証明書交付.getKey(), ShinseiJotai.証明書交付.getValue()));
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setDisabledItem(disabledItem);
    }

    /**
     * 回答タスクから遷移場合、活性
     *
     */
    public void cancle申請状態ラジオボタン非活性制御() {
        List<KeyValueDataSource> disabledItem = new ArrayList<>();
        div.getCcdZaigaiMeiboSenkyoninJoho().getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setDisabledItem(disabledItem);
    }
}
