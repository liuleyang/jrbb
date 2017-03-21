/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShinseiResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;

/**
 * ZaigaiSenkyoninJohoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してZaigaiSenkyoninJohoDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 *
 * @reamsid_L AF-0320-011 lis
 */
public class ZaigaiSenkyoninJohoHandler {

    private final ZaigaiSenkyoninJohoDiv div;
    private final RString 本籍地登録区分_国内最終住所 = new RString("0");
    private final RString 本籍地登録区分_本籍地 = new RString("1");
    private final RString メニューID_在外選挙人情報 = new RString("AFAMNB3");
    private final RString メニューID_在外投票人情報 = new RString("AFAMNG3");
    private final RString パネルタイトル_在外選挙人情報 = new RString("在外選挙人情報");
    private final RString パネルタイトル_在外投票人情報 = new RString("在外投票人情報");
    private final RString コード種別_国籍 = new RString("0006");
    private final RString ラジオボタン_申請取下げ = new RString("申請取下げ");
    private final RString ラジオボタン_申請却下 = new RString("申請却下");
    private final RString ラジオボタン_証明書交付 = new RString("証明書交付");
    private final RString ラジオボタン_申請取下げKEY = new RString("2");
    private final RString ラジオボタン_申請却下KEY = new RString("3");
    private final RString ラジオボタン_証明書交付KEY = new RString("4");

    /**
     * コンストラクタです。
     *
     * @param div 在外選挙人情報共有子DIV
     */
    public ZaigaiSenkyoninJohoHandler(ZaigaiSenkyoninJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 在外選挙人情報共有子DIV
     * @return 在外選挙人情報共有子DIVのバリデーションハンドラ
     */
    public static ZaigaiSenkyoninJohoHandler of(ZaigaiSenkyoninJohoDiv div) {
        return new ZaigaiSenkyoninJohoHandler(div);
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     */
    public void initialize(ShikibetsuCode 識別コード, RString 申請番号) {

        if (RString.isNullOrEmpty(申請番号)) {
            set本人情報初期情報(識別コード);
        } else {
            set在外選挙人情報(識別コード, 申請番号);
        }
        if (ResponseHolder.getMenuID().startsWith(メニューID_在外選挙人情報)) {
            div.setTitle(パネルタイトル_在外選挙人情報);
        } else if (ResponseHolder.getMenuID().startsWith(メニューID_在外投票人情報)) {
            div.setTitle(パネルタイトル_在外投票人情報);
        }
        div.setHiddenShikibetsuCode(識別コード.getColumnValue());
    }

    private void set本人情報初期情報(ShikibetsuCode 識別コード) {
        MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
        HonninJohoResult honninJohoResult = meibotorokuZaigai.get本人情報初期情報(識別コード);
        div.getCcdHenkoJiyu().setDisplayNone(Boolean.TRUE);
        div.getZaigaiHonninJoho().getTxtShimei().clearDomain();
        div.getZaigaiHonninJoho().getTxtShimeiKana().clearDomain();
        div.getZaigaiHonninJoho().getTxtSeinengappiYMD().clearValue();
        div.getZaigaiHonninJoho().getDdlSeibetsu().setIsBlankLine(Boolean.TRUE);
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
        keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
        div.getZaigaiHonninJoho().getDdlSeibetsu().setDataSource(keyList);

        div.getZaigaiHonninJoho().getCcdHonsekiJusho().initialize();
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.コード);

        div.getZaigaiHonninJoho().getCcdLastJusho().initialize();
        div.getZaigaiHonninJoho().getCcdLastJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.コード);
        div.getZaigaiHonninJoho().getCcdLastKatagaki().initialize();

        if (honninJohoResult != null) {
            RString honsekiJushoValue = RString.EMPTY;
            if (honninJohoResult.get宛名PSM() != null) {
                AtenaJusho honsekiJusho = honninJohoResult.get宛名PSM().getHonsekiJusho();
                if (honsekiJusho != null) {
                    honsekiJushoValue = honsekiJusho.value();
                }
                YubinNo yubinNo = honninJohoResult.get宛名PSM().getYubinNo();
                div.getZaigaiHonninJoho().getCcdHonsekiJusho().load(honninJohoResult.get宛名PSM().getHonsekiZenkokuJushoCode(),
                        honsekiJushoValue,
                        yubinNo == null ? YubinNo.EMPTY : yubinNo);

                RString honsekiBanchiValue = RString.EMPTY;
                AtenaBanchi atenaBanchi = honninJohoResult.get宛名PSM().getHonsekiBanchi();
                if (atenaBanchi != null && !atenaBanchi.isEmpty()) {
                    honsekiBanchiValue = atenaBanchi.getColumnValue();
                }
                div.getZaigaiHonninJoho().getCcdHonsekiBanchi().setBanchiMeisho(honsekiBanchiValue);
                RString saishuJutochiJushoValue = RString.EMPTY;
                AtenaJusho saishuJutochiJusho = honninJohoResult.get宛名PSM().getSaishuJutochiJusho();
                if (saishuJutochiJusho != null && !saishuJutochiJusho.isEmpty()) {
                    saishuJutochiJushoValue = saishuJutochiJusho.getColumnValue();
                }
                YubinNo saishuJutochiYubinNo = honninJohoResult.get宛名PSM().getSaishuJutochiYubinNo();
                div.getZaigaiHonninJoho().getCcdLastJusho().load(honninJohoResult.get宛名PSM().getSaishuJutochiZenkokuJushoCode(),
                        saishuJutochiJushoValue,
                        saishuJutochiYubinNo == null ? YubinNo.EMPTY : saishuJutochiYubinNo);

                RString saishuJutochiBanchiValue = RString.EMPTY;
                AtenaBanchi saishuJutochiBanchi = honninJohoResult.get宛名PSM().getSaishuJutochiBanchi();
                if (saishuJutochiBanchi != null && !saishuJutochiBanchi.isEmpty()) {
                    saishuJutochiBanchiValue = saishuJutochiBanchi.getColumnValue();
                }
                div.getZaigaiHonninJoho().getCcdLastBanchi().setBanchiMeisho(saishuJutochiBanchiValue);
                div.getZaigaiHonninJoho().getCcdLastKatagaki().load(honninJohoResult.get宛名PSM().getSaishuJutochiKatagaki());
                FlexibleDate tenshutsuKakuteiTsuchiYMD = honninJohoResult.get宛名PSM().getTenshutsuKakuteiTsuchiYMD();
                if (tenshutsuKakuteiTsuchiYMD != null && !tenshutsuKakuteiTsuchiYMD.isEmpty()) {
                    div.getZaigaiHonninJoho().getTxtTenshutsuYMD().setValue(
                            new RDate(tenshutsuKakuteiTsuchiYMD.toString()));
                }
            }

        }
        div.getZaigaiHonninJoho().getRadHonsekichiToroku().setSelectedIndex(0);
        List<KeyValueDataSource> disabledItem = new ArrayList<>();
        KeyValueDataSource 申請取下げ = new KeyValueDataSource();
        申請取下げ.setKey(ラジオボタン_申請取下げKEY);
        申請取下げ.setValue(ラジオボタン_申請取下げ);
        disabledItem.add(申請取下げ);
        KeyValueDataSource 申請却下 = new KeyValueDataSource();
        申請却下.setKey(ラジオボタン_申請却下KEY);
        申請却下.setValue(ラジオボタン_申請却下);
        disabledItem.add(申請却下);
        KeyValueDataSource 証明書交付 = new KeyValueDataSource();
        証明書交付.setKey(ラジオボタン_証明書交付KEY);
        証明書交付.setValue(ラジオボタン_証明書交付);
        disabledItem.add(証明書交付);
        div.getZaigaiHonninJoho().getRadHonsekichiToroku().setDisabledItem(disabledItem);
        div.getZaigaiZaijuJoho().getTxtKaigaiJusho().clearDomain();
        div.getZaigaiZaijuJoho().getTxtDokyoKazoku().clearValue();
        div.getZaigaiZaijuJoho().getTxtKaigaiTelNo().clearDomain();
        div.getZaigaiZaijuJoho().getTxtKaigaiFaxNo().clearDomain();
        div.getZaigaiZaijuJoho().getTxtKaigaiMailAddress().clearDomain();
        div.getZaigaiZaijuJoho().getCcdRyojikan().clear();
        div.getZaigaiZaijuJoho().getTxtJuteiYMD().clearValue();
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().clearDomain();
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().clearValue();
        div.getZaigaiZaijuJoho().getCcdKokuseki().load(SubGyomuCode.UAA宛名管理, new CodeShubetsu(コード種別_国籍));
        div.getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setSelectedIndex(0);
        div.getZaigaiShinseiJoho().getTxtShinseiYMD().clearValue();
        div.getZaigaiShinseiJoho().getTxtShinseiNo().clearValue();
        div.getZaigaiShinseiJoho().getTxtTorisageYMD().clearValue();
        div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().clearValue();
        div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().clearValue();
        div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().clearValue();
        div.getZaigaiShinseiJoho().getTxtKyakkaYMD().clearValue();
        div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(AFACodeShubetsu.却下事由コード.getCodeShubetsu(), Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtKofuYMD().clearValue();
        div.getZaigaiShinseiJoho().getTxtKofuNo().clearValue();
        div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), Boolean.TRUE);
    }

    private void set在外選挙人情報(ShikibetsuCode 識別コード, RString 申請番号) {
        MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
        ZaigaiSenkyoninJohoResult zaigaiSenkyoninJohoResult
                = meibotorokuZaigai.get在外選挙人情報のデータ(Integer.parseInt(申請番号.toString()), 識別コード);
        div.setHdnZaigaiSenkyoninShinsei(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoninShinseiResult(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報()).serialize())));
        div.setHdnZaigaiSenkyoShikaku(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoShikakuResult(zaigaiSenkyoninJohoResult.get在外選挙資格()).serialize())));
        div.setHdnJushoShuruiKubun1(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍()).serialize())));
        div.setHdnJushoShuruiKubun2(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所()).serialize())));
        if (zaigaiSenkyoninJohoResult.get在外選挙人住所情報_国内転入先住所() != null) {
            div.setHdnJushoShuruiKubun3(new RString(_Base64Serializer.serialize(
                    new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_国内転入先住所()).serialize())));
        }
        div.setHdnJushoShuruiKubun4(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所()).serialize())));
        div.setHdnJushoShuruiKubun5(new RString(_Base64Serializer.serialize(
                new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外送付先住所()).serialize())));
        Boolean 在外選挙資格flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙資格() != null) {
            在外選挙資格flag = Boolean.TRUE;
        }
        div.getCcdHenkoJiyu().initialize(AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), Boolean.TRUE);
        if (在外選挙資格flag) {
            div.getCcdHenkoJiyu().initialize(zaigaiSenkyoninJohoResult.get在外選挙資格().getHenkoJiyuCode());
        }

        div.getCcdHenkoJiyu().setDisplayNoneMode(Boolean.TRUE);

        Boolean 在外選挙人申請情報flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙人申請情報() != null) {
            在外選挙人申請情報flag = Boolean.TRUE;
        }
        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keyList.add(new KeyValueDataSource(MALE.getCode(), MALE.getCommonName()));
        keyList.add(new KeyValueDataSource(FEMALE.getCode(), FEMALE.getCommonName()));
        div.getZaigaiHonninJoho().getDdlSeibetsu().setDataSource(keyList);
        if (在外選挙人申請情報flag) {
            div.getZaigaiHonninJoho().getTxtShimei().setDomain(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseishaShimei());
            div.getZaigaiHonninJoho().getTxtShimeiKana().setDomain(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseishaKanaShimei());
            div.getZaigaiHonninJoho().getTxtSeinengappiYMD().setValue(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getSeinengappiYMD());
            div.getZaigaiHonninJoho().getDdlSeibetsu().setSelectedKey(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getSeibetsuCode());
        }
        Boolean 在外選挙人住所情報_本籍flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍() != null) {
            在外選挙人住所情報_本籍flag = Boolean.TRUE;
        }
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().initialize();
        div.getZaigaiHonninJoho().getCcdHonsekiJusho();
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdHonsekiBanchi().initialize();
        if (在外選挙人住所情報_本籍flag) {
            AtenaJusho 本籍jusho = zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍().getJusho();
            RString 本籍jushoStr = RString.EMPTY;
            if (null != 本籍jusho && !本籍jusho.isEmpty()) {
                本籍jushoStr = 本籍jusho.value();
            }
            YubinNo yubinNo = zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍().getYubinNo();
            div.getZaigaiHonninJoho().getCcdHonsekiJusho().load(
                    zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍().getZenkokuJushoCode(),
                    本籍jushoStr, yubinNo == null ? YubinNo.EMPTY : yubinNo);
            div.getZaigaiHonninJoho().getCcdHonsekiBanchi().load(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_本籍().getBanchi());
        }
        Boolean 在外選挙人住所情報_最終住所flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所() != null) {
            在外選挙人住所情報_最終住所flag = Boolean.TRUE;
        }
        div.getZaigaiHonninJoho().getCcdLastJusho().initialize();
        div.getZaigaiHonninJoho().getCcdLastJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdLastBanchi().initialize();
        div.getZaigaiHonninJoho().getCcdLastKatagaki().initialize();
        if (在外選挙人住所情報_最終住所flag) {
            AtenaJusho 最終住所jusho = zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getJusho();
            YubinNo saishuJutochiYubinNo = zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getYubinNo();
            div.getZaigaiHonninJoho().getCcdLastJusho().load(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getZenkokuJushoCode(),
                    最終住所jusho == null ? RString.EMPTY : 最終住所jusho.getColumnValue(),
                    saishuJutochiYubinNo == null ? YubinNo.EMPTY : saishuJutochiYubinNo);
            div.getZaigaiHonninJoho().getCcdLastBanchi().load(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getBanchi());
            div.getZaigaiHonninJoho().getCcdLastKatagaki().load(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getKatagaki());
            FlexibleDate 最終住所KokugaiTenshutsuYMD = zaigaiSenkyoninJohoResult.get在外選挙人住所情報_最終住所().getKokugaiTenshutsuYMD();
            div.getZaigaiHonninJoho().getTxtTenshutsuYMD().setValue(
                    null == 最終住所KokugaiTenshutsuYMD || 最終住所KokugaiTenshutsuYMD.isEmpty() ? null : new RDate(最終住所KokugaiTenshutsuYMD.toString()));
        }
        if (在外選挙資格flag) {
            Code honsekiTorokuKubun = zaigaiSenkyoninJohoResult.get在外選挙資格().getHonsekiTorokuKubun();
            if (honsekiTorokuKubun != null && 本籍地登録区分_国内最終住所.equals(honsekiTorokuKubun.getColumnValue())) {
                div.getZaigaiHonninJoho().getRadHonsekichiToroku().setSelectedIndex(0);
            } else if (honsekiTorokuKubun != null && 本籍地登録区分_本籍地.equals(honsekiTorokuKubun.getColumnValue())) {
                div.getZaigaiHonninJoho().getRadHonsekichiToroku().setSelectedIndex(1);
            }
        }
        div.getZaigaiZaijuJoho().getCcdKokuseki().load(SubGyomuCode.UAA宛名管理, new CodeShubetsu(コード種別_国籍));
        if (在外選挙人申請情報flag) {
            RString 国籍コード = zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getKokusekiCode();
            div.getZaigaiZaijuJoho().getCcdKokuseki().load(
                    SubGyomuCode.UAA宛名管理,
                    new CodeShubetsu(コード種別_国籍),
                    RString.isNullOrEmpty(国籍コード) ? Code.EMPTY : new Code(国籍コード));
        }
        Boolean 在外選挙人住所情報_海外住所flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所() != null) {
            在外選挙人住所情報_海外住所flag = Boolean.TRUE;
        }
        if (在外選挙人住所情報_海外住所flag) {
            div.getZaigaiZaijuJoho().getTxtKaigaiJusho().setDomain(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所().getJusho());
            div.getZaigaiZaijuJoho().getTxtDokyoKazoku().setValue(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所().getDokyoKazokuShimei());
            div.getZaigaiZaijuJoho().getTxtKaigaiTelNo().setDomain(new TelNo(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所().getTel()));
            div.getZaigaiZaijuJoho().getTxtKaigaiFaxNo().setDomain(new TelNo(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所().getFax()));
            div.getZaigaiZaijuJoho().getTxtKaigaiMailAddress().setDomain(zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外住所().getMail());
        }
        if (在外選挙人申請情報flag) {
            div.getZaigaiZaijuJoho().getCcdRyojikan().initialize(
                    zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getRyojikanCode());
            div.getZaigaiZaijuJoho().getTxtJuteiYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getJuteiYMD()));
        }
        Boolean 海外送付先住所flag = Boolean.FALSE;
        if (zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外送付先住所() != null) {
            海外送付先住所flag = Boolean.TRUE;
        }
        if (海外送付先住所flag) {
            div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().setDomain(
                    zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外送付先住所().getJusho());
            div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().setValue(
                    zaigaiSenkyoninJohoResult.get在外選挙人住所情報_海外送付先住所().getDokyoKazokuShimei());
        }
        div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(AFACodeShubetsu.却下事由コード.getCodeShubetsu(), Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), Boolean.TRUE);
        div.getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setSelectedIndex(4);
        if (在外選挙人申請情報flag) {
            div.getZaigaiShinseiJoho().getTxtShinseiYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseiYMD()));
            div.getZaigaiShinseiJoho().getTxtShinseiNo().setValue(
                    new RString(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseiNo()));
            div.getZaigaiShinseiJoho().getTxtTorisageYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getTorisageYMD()));
            div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(
                    zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getTorisageJiyuCode());
            div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiShokaiYMD()));
            div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiKaitoYMD()));
            div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiTsuchiYMD()));
            div.getZaigaiShinseiJoho().getTxtKyakkaYMD().setValue(
                    changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getKyakkaYMD()));
            div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(
                    zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getKyakkaJiyuCode());

        }

        div.getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.FALSE);

        if (在外選挙資格flag) {
            div.getZaigaiShinseiJoho().getTxtKofuYMD().setValue(changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙資格().getKofuYMD()));
            div.getZaigaiShinseiJoho().getTxtKofuNo().setValue(zaigaiSenkyoninJohoResult.get在外選挙資格().getKofuNo());
            div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(zaigaiSenkyoninJohoResult.get在外選挙資格().getSaiKofuJiyuCode());
        }
        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(ResponseHolder.getMenuID())) {
            set証明書記載事項変更_表示制御();
        } else if (AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(ResponseHolder.getMenuID())) {
            set証明書再交付_表示制御();
        } else if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(ResponseHolder.getMenuID())) {
            set名簿抹消_表示制御();
        }
    }

    private void set証明書記載事項変更_表示制御() {
        div.getCcdHenkoJiyu().setDisplayNoneMode(Boolean.FALSE);
        div.getCcdHenkoJiyu().setReadOnlyMode(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtShimei().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtShimeiKana().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtSeinengappiYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getDdlSeibetsu().setDisabled(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdHonsekiBanchi().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdLastBanchi().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getCcdLastKatagaki().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtTenshutsuYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getRadHonsekichiToroku().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getCcdKokuseki().setReadOnly(Boolean.FALSE);

        div.getZaigaiZaijuJoho().getTxtKaigaiJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtDokyoKazoku().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtKaigaiTelNo().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtKaigaiFaxNo().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtKaigaiMailAddress().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getCcdRyojikan().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtJuteiYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().setReadOnly(Boolean.FALSE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().setReadOnly(Boolean.FALSE);

        div.getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnKofuRireki().setDisabled(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getTxtShinseiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtShinseiNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnShinseiNoSaiban().setDisabled(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtTorisageYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdTorisageJiyu().setDisabledMode(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setReadOnly(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKyakkaYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().setDisabledMode(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKofuYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getTxtKofuNo().setReadOnly(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().setDisabledMode(Boolean.TRUE);
    }

    private void set証明書再交付_表示制御() {
        div.getCcdHenkoJiyu().setDisplayNoneMode(Boolean.TRUE);
        div.getZaigaiHonninJoho().getTxtShimei().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtShimeiKana().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtSeinengappiYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getDdlSeibetsu().setDisabled(Boolean.FALSE);

        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdHonsekiBanchi().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdLastBanchi().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastKatagaki().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getTxtTenshutsuYMD().setReadOnly(Boolean.TRUE);

        div.getZaigaiHonninJoho().getRadHonsekichiToroku().setReadOnly(Boolean.TRUE);

        div.getZaigaiZaijuJoho().getCcdKokuseki().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtDokyoKazoku().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiTelNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiFaxNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiMailAddress().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getCcdRyojikan().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtJuteiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().setReadOnly(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnKofuRireki().setDisabled(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getTxtShinseiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtShinseiNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnShinseiNoSaiban().setDisabled(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtTorisageYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdTorisageJiyu().setDisabledMode(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setReadOnly(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKyakkaYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().setDisabledMode(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKofuYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getTxtKofuNo().setReadOnly(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().setDisabledMode(Boolean.FALSE);
    }

    private void set名簿抹消_表示制御() {
        div.getCcdHenkoJiyu().setDisplayNoneMode(Boolean.TRUE);
        div.getZaigaiHonninJoho().getTxtShimei().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtShimeiKana().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getTxtSeinengappiYMD().setReadOnly(Boolean.FALSE);
        div.getZaigaiHonninJoho().getDdlSeibetsu().setDisabled(Boolean.FALSE);

        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdHonsekiJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdHonsekiBanchi().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastJusho().setInputMode(ZenkokuJushoInputDiv.InputMode.名称及びコード);
        div.getZaigaiHonninJoho().getCcdLastBanchi().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getCcdLastKatagaki().setReadOnly(Boolean.TRUE);
        div.getZaigaiHonninJoho().getTxtTenshutsuYMD().setReadOnly(Boolean.TRUE);

        div.getZaigaiHonninJoho().getRadHonsekichiToroku().setReadOnly(Boolean.TRUE);

        div.getZaigaiZaijuJoho().getCcdKokuseki().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtDokyoKazoku().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiTelNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiFaxNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiMailAddress().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getCcdRyojikan().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtJuteiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiJusho().setReadOnly(Boolean.TRUE);
        div.getZaigaiZaijuJoho().getTxtKaigaiSofusakiAtena().setReadOnly(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getZaigaiShinseiKubun().getRadShinseiKubun().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnKofuRireki().setDisabled(Boolean.FALSE);
        div.getZaigaiShinseiJoho().getTxtShinseiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtShinseiNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnShinseiNoSaiban().setDisabled(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtTorisageYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdTorisageJiyu().setDisabledMode(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setReadOnly(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKyakkaYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().setDisabledMode(Boolean.TRUE);

        div.getZaigaiShinseiJoho().getTxtKofuYMD().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getTxtKofuNo().setReadOnly(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getBtnKofuNoSaiban().setDisabled(Boolean.TRUE);
        div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().setDisabledMode(Boolean.TRUE);
    }

    private RDate changeFlexibleDateToRDate(FlexibleDate flexibleDate) {
        if (flexibleDate != null && !flexibleDate.isEmpty() && flexibleDate.isValid()) {
            return new RDate(flexibleDate.toString());
        } else {
            return null;
        }
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param 識別コード ShikibetsuCode
     * @param 申請番号 RString
     */
    public void initializeSenkyojyohou(ShikibetsuCode 識別コード, RString 申請番号) {
        if (RString.isNullOrEmpty(申請番号)) {
            div.getZaigaiShinseiJoho().getTxtShinseiYMD().clearValue();
            div.getZaigaiShinseiJoho().getTxtShinseiNo().clearValue();
            div.getZaigaiShinseiJoho().getTxtTorisageYMD().clearValue();
            div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), Boolean.TRUE);
            div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().clearValue();
            div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().clearValue();
            div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().clearValue();
            div.getZaigaiShinseiJoho().getTxtKyakkaYMD().clearValue();
            div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(AFACodeShubetsu.却下事由コード.getCodeShubetsu(), Boolean.TRUE);
            div.getZaigaiShinseiJoho().getTxtKofuYMD().clearValue();
            div.getZaigaiShinseiJoho().getTxtKofuNo().clearValue();
            div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), Boolean.TRUE);
        } else {
            MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
            ZaigaiSenkyoninJohoResult zaigaiSenkyoninJohoResult
                    = meibotorokuZaigai.get在外選挙人情報のデータ(Integer.parseInt(申請番号.toString()), 識別コード);
            Boolean 在外選挙人申請情報flag = Boolean.FALSE;
            if (zaigaiSenkyoninJohoResult.get在外選挙人申請情報() != null) {
                在外選挙人申請情報flag = Boolean.TRUE;
            }
            div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), Boolean.TRUE);
            div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(AFACodeShubetsu.却下事由コード.getCodeShubetsu(), Boolean.TRUE);
            div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), Boolean.TRUE);
            if (在外選挙人申請情報flag) {
                div.getZaigaiShinseiJoho().getTxtShinseiYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseiYMD()));
                div.getZaigaiShinseiJoho().getTxtShinseiNo().setValue(
                        new RString(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getShinseiNo()));
                div.getZaigaiShinseiJoho().getTxtTorisageYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getTorisageYMD()));
                div.getZaigaiShinseiJoho().getCcdTorisageJiyu().initialize(
                        zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getTorisageJiyuCode());
                div.getZaigaiShinseiJoho().getTxtHonsekiShokaiYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiShokaiYMD()));
                div.getZaigaiShinseiJoho().getTxtHonsekiKaitoYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiKaitoYMD()));
                div.getZaigaiShinseiJoho().getTxtHonsekiTsutiYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getHonsekiTsuchiYMD()));
                div.getZaigaiShinseiJoho().getTxtKyakkaYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getKyakkaYMD()));
                div.getZaigaiShinseiJoho().getCcdKyakkaJiyu().initialize(
                        zaigaiSenkyoninJohoResult.get在外選挙人申請情報().get申請情報().getKyakkaJiyuCode());
            }
            Boolean 在外選挙資格flag = Boolean.FALSE;
            if (zaigaiSenkyoninJohoResult.get在外選挙資格() != null) {
                在外選挙資格flag = Boolean.TRUE;
            }
            if (在外選挙資格flag) {
                div.getZaigaiShinseiJoho().getTxtKofuYMD().setValue(
                        changeFlexibleDateToRDate(zaigaiSenkyoninJohoResult.get在外選挙資格().getKofuYMD()));
                div.getZaigaiShinseiJoho().getTxtKofuNo().setValue(zaigaiSenkyoninJohoResult.get在外選挙資格().getKofuNo());
                div.getZaigaiShinseiJoho().getCcdSaiKofuJiyu().initialize(zaigaiSenkyoninJohoResult.get在外選挙資格().getSaiKofuJiyuCode());
            }
        }
    }
}
