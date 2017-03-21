/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu;

import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（一括）の編集クラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuEditor {

    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_カナ名称1 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称2 = new RString("shimeiKana21");
    private static final RString 長さ_投票所名1 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名2 = new RString("tohyojoMei21");
    private static final RString 長さ_名称1 = new RString("shimei11");
    private static final RString 長さ_名称2 = new RString("shimei21");
    private static final RString 長さ_名称3 = new RString("shimei31");
    private static final RString 長さ_宛名1 = new RString("atena11");
    private static final RString 長さ_宛名2 = new RString("atena21");
    private static final RString 長さ_宛名3 = new RString("atena31");
    private static final RString 長さ_住所1 = new RString("jusho11");
    private static final RString 長さ_住所2 = new RString("jusho21");
    private static final RString 長さ_送付先住所11 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先住所21 = new RString("sofusakiJusho21");
    private static final RString 長さ_送付先住所31 = new RString("sofusakiJusho31");
    private static final RString 長さ_送付先住所41 = new RString("sofusakiJusho41");
    private static final RString 長さ_送付先住所51 = new RString("sofusakiJusho51");
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho1");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho2");
    private static final RString 長さ_送付先住所3 = new RString("sofusakiJusho3");
    private static final RString 長さ_送付先住所4 = new RString("sofusakiJusho4");
    private static final RString 長さ_送付先住所5 = new RString("sofusakiJusho5");

    /**
     * 文字切れ_個票3つ折を判断する。
     *
     * @param 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     * @return Boolean
     */
    public Boolean check文字切れFor個票3つ折(AFABTB201MeiciJyohouSoufusakiEntity 投票所入場券情報) {
        AtenaMeisho 世帯主名 = 投票所入場券情報.get送付先世帯主名();
        RString 長さ世帯主名 = null == 世帯主名 ? RString.EMPTY : 世帯主名.getColumnValue();
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_世帯主名1), 長さ世帯主名)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_名称1)
                + getNyujoken3tsuoriItemLength(長さ_名称2)
                + getNyujoken3tsuoriItemLength(長さ_名称3), 投票所入場券情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_カナ名称1)
                + getNyujoken3tsuoriItemLength(長さ_カナ名称2), 投票所入場券情報.getカナ名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_投票所名1)
                + getNyujoken3tsuoriItemLength(長さ_投票所名2), 投票所入場券情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_はがき4つ切を判断する。
     *
     * @param 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     * @return Boolean
     */
    public Boolean check文字切れForはがき4つ切(AFABTB201MeiciJyohouSoufusakiEntity 投票所入場券情報) {
        RString 送付先宛名 = 投票所入場券情報.get送付先宛名();
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_宛名1)
                + getNyujokenHagakiSourceItemLength(長さ_宛名2)
                + getNyujokenHagakiSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        AtenaJusho 投票所の住所 = 投票所入場券情報.get投票所の住所();

        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_住所1)
                + getNyujokenHagakiSourceItemLength(長さ_住所2),
                投票所の住所 == null ? RString.EMPTY : 投票所の住所.getColumnValue())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 投票所入場券情報.get送付先住所();
        RString 長さ送付先住所 = null == 送付先住所 ? RString.EMPTY : 送付先住所.getColumnValue();

        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_送付先住所11)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所21)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所31)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所41)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所51), 長さ送付先住所)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_名称1)
                + getNyujokenHagakiSourceItemLength(長さ_名称2)
                + getNyujokenHagakiSourceItemLength(長さ_名称3), 投票所入場券情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_投票所名1)
                + getNyujokenHagakiSourceItemLength(長さ_投票所名2), 投票所入場券情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_シーラーを判断する。
     *
     * @param 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     * @return Boolean
     */
    public Boolean check文字切れForシーラー(AFABTB201MeiciJyohouSoufusakiEntity 投票所入場券情報) {
        RString 送付先宛名 = 投票所入場券情報.get送付先宛名();
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_宛名1)
                + getNyujokenSealerSourceSourceItemLength(長さ_宛名2)
                + getNyujokenSealerSourceSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        AtenaJusho 投票所の住所 = 投票所入場券情報.get投票所の住所();
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_住所1)
                + getNyujokenSealerSourceSourceItemLength(長さ_住所2),
                投票所の住所 == null ? RString.EMPTY : 投票所の住所.getColumnValue())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 投票所入場券情報.get送付先住所();
        RString 長さ送付先住所 = null == 送付先住所 ? RString.EMPTY : 送付先住所.getColumnValue();
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_送付先住所11)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所21)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所31)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所41)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所51), 長さ送付先住所)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_名称1)
                + getNyujokenSealerSourceSourceItemLength(長さ_名称2)
                + getNyujokenSealerSourceSourceItemLength(長さ_名称3), 投票所入場券情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_投票所名1)
                + getNyujokenSealerSourceSourceItemLength(長さ_投票所名2), 投票所入場券情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_ポステックスを判断する。
     *
     * @param 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     * @return Boolean
     */
    public Boolean check文字切れForポステックス(AFABTB201MeiciJyohouSoufusakiEntity 投票所入場券情報) {
        RString 送付先宛名 = 投票所入場券情報.get送付先宛名();
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_宛名1)
                + getNyujokenPostexSourceSourceItemLength(長さ_宛名2)
                + getNyujokenPostexSourceSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        AtenaJusho 投票所の住所 = 投票所入場券情報.get投票所の住所();
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_住所1)
                + getNyujokenPostexSourceSourceItemLength(長さ_住所2),
                投票所の住所 == null ? RString.EMPTY : 投票所の住所.getColumnValue())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 投票所入場券情報.get送付先住所();
        RString 長さ送付先住所 = null == 送付先住所 ? RString.EMPTY : 送付先住所.getColumnValue();

        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_送付先住所1)
                + getNyujokenPostexSourceSourceItemLength(長さ_送付先住所2)
                + getNyujokenPostexSourceSourceItemLength(長さ_送付先住所3)
                + getNyujokenPostexSourceSourceItemLength(長さ_送付先住所4)
                + getNyujokenPostexSourceSourceItemLength(長さ_送付先住所5), 長さ送付先住所)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_名称1)
                + getNyujokenPostexSourceSourceItemLength(長さ_名称2)
                + getNyujokenPostexSourceSourceItemLength(長さ_名称3), 投票所入場券情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_投票所名1)
                + getNyujokenPostexSourceSourceItemLength(長さ_投票所名2), 投票所入場券情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean is文字切れ(int 文字最大数, RString 編集文字) {
        if (RString.isNullOrEmpty(編集文字)) {
            return Boolean.FALSE;
        }
        if (編集文字.length() > 文字最大数) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private int getNyujoken3tsuoriItemLength(RString itemName) {
        if (RString.isNullOrEmpty(itemName)) {
            return 0;
        }
        return ReportDataInfoLoader.getMaxLength(Nyujoken3tsuoriSource.class, itemName);
    }

    private int getNyujokenHagakiSourceItemLength(RString itemName) {
        if (RString.isNullOrEmpty(itemName)) {
            return 0;
        }
        return ReportDataInfoLoader.getMaxLength(NyujokenHagakiSource.class, itemName);
    }

    private int getNyujokenSealerSourceSourceItemLength(RString itemName) {
        if (RString.isNullOrEmpty(itemName)) {
            return 0;
        }
        return ReportDataInfoLoader.getMaxLength(NyujokenSealerSource.class, itemName);
    }

    private int getNyujokenPostexSourceSourceItemLength(RString itemName) {
        if (RString.isNullOrEmpty(itemName)) {
            return 0;
        }
        return ReportDataInfoLoader.getMaxLength(NyujokenPostexSource.class, itemName);
    }

    /**
     * 文字切れ_ポステックスを判断する。
     *
     * @param コピー先パース RString
     * @param コピー先パースチェックリスト RString
     */
    public void 地図情報のイメージファイルのコピー(RString コピー先パース, RString コピー先パースチェックリスト) {
        RString 地図印字フラッグ = BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.印字有無_印字する.configKeyValue().equals(地図印字フラッグ)) {
            return;
        }
        RString コピー元パース = BusinessConfig.get(ConfigKeysAFA.入場券_地図格納フォルダ, SubGyomuCode.AFA選挙本体);
        if (!RString.isNullOrEmpty(コピー先パースチェックリスト)) {
            if (Directory.exists(コピー先パースチェックリスト) && Directory.exists(コピー元パース)) {
                Directory.copy(コピー元パース, コピー先パースチェックリスト);
            } else if (Directory.exists(コピー先パースチェックリスト) && !Directory.exists(コピー元パース)) {
                コピー元パース = Directory.createDirectories(コピー元パース);
                Directory.copy(コピー元パース, コピー先パースチェックリスト);
            }
        }
        if (!RString.isNullOrEmpty(コピー先パース)) {
            if (Directory.exists(コピー先パース) && Directory.exists(コピー元パース)) {
                Directory.copy(コピー元パース, コピー先パース);
            } else if (Directory.exists(コピー元パース) && !Directory.exists(コピー元パース)) {
                コピー元パース = Directory.createDirectories(コピー元パース);
                Directory.copy(コピー元パース, コピー先パース);
            }
        }

    }

    /**
     * 文字切れ_ポステックスを判断する。
     *
     * @param コピー先パースチェックリスト RString
     */
    public void 地図情報のイメージファイルのコピー(RString コピー先パースチェックリスト) {
        RString コピー元パース = BusinessConfig.get(ConfigKeysAFA.入場券_地図格納フォルダ, SubGyomuCode.AFA選挙本体);
        if (!RString.isNullOrEmpty(コピー先パースチェックリスト)) {
            if (Directory.exists(コピー先パースチェックリスト) && Directory.exists(コピー元パース)) {
                Directory.copy(コピー元パース, コピー先パースチェックリスト);
            } else if (Directory.exists(コピー先パースチェックリスト) && !Directory.exists(コピー元パース)) {
                コピー元パース = Directory.createDirectories(コピー元パース);
                Directory.copy(コピー元パース, コピー先パースチェックリスト);
            }
        }

    }

    /**
     * 投票資格情報を編集する。
     *
     * @param 宛名シール12面 AFABTB201MeiciJyohouSoufusakiEntity
     * @return SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get投票資格情報(AFABTB201MeiciJyohouSoufusakiEntity 宛名シール12面) {
        SenkyoninTohyoJokyoEntity 投票資格情報 = new SenkyoninTohyoJokyoEntity();
        投票資格情報.setAtenaPSMEntity();
        投票資格情報.getAtenaPSMEntity().setJusho(
                宛名シール12面.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(宛名シール12面.get住所()));
        投票資格情報.getAtenaPSMEntity().setBanchi(
                宛名シール12面.get番地() == null ? AtenaBanchi.EMPTY : 宛名シール12面.get番地());
        投票資格情報.getAtenaPSMEntity().setKatagaki(
                宛名シール12面.get方書() == null ? Katagaki.EMPTY : 宛名シール12面.get方書());
        投票資格情報.getAtenaPSMEntity().setMeisho(
                宛名シール12面.get名称() == null ? AtenaMeisho.EMPTY : new AtenaMeisho(宛名シール12面.get名称()));
        return 投票資格情報;
    }

    /**
     * 投票資格情報を編集する。
     *
     * @param 宛名シール12面 AFABTB201MeiciJyohouSoufusakiEntity
     * @return SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get投票資格情報(SenkyojiKaikuEntity 宛名シール12面) {
        SenkyoninTohyoJokyoEntity 投票資格情報_海区 = new SenkyoninTohyoJokyoEntity();
        投票資格情報_海区.setAtenaPSMEntity();
        投票資格情報_海区.getAtenaPSMEntity().setJusho(
                宛名シール12面.getShikibetsuTaishoEntity().getJusho() == null ? AtenaJusho.EMPTY : 宛名シール12面.getShikibetsuTaishoEntity().getJusho());
        投票資格情報_海区.getAtenaPSMEntity().setBanchi(
                宛名シール12面.getShikibetsuTaishoEntity().getBanchi() == null ? AtenaBanchi.EMPTY : 宛名シール12面.getShikibetsuTaishoEntity().getBanchi());
        投票資格情報_海区.getAtenaPSMEntity().setKatagaki(
                宛名シール12面.getShikibetsuTaishoEntity().getKatagaki() == null ? Katagaki.EMPTY : 宛名シール12面.getShikibetsuTaishoEntity().getKatagaki());
        投票資格情報_海区.getAtenaPSMEntity().setMeisho(
                宛名シール12面.getShikibetsuTaishoEntity().getMeisho() == null ? AtenaMeisho.EMPTY : 宛名シール12面.getShikibetsuTaishoEntity().getMeisho());
        return 投票資格情報_海区;
    }
}
