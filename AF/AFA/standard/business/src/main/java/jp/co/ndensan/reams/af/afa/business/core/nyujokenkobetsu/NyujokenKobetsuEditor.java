/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nyujokenkobetsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeisaiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenHagakiParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenSealerParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenHakkouMeishoWithCheckListParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenNyujyokkenParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenNyujyokkenWithCheckListParam;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.business.core.SoufusakiJouhou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.processprm.nyujokenikkatsu.AFABTB202SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.SofusakiJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（個別）の編集クラスです。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujokenKobetsuEditor {

    private static final int 改ページ_個票3つ折り = 3;
    private static final int 改ページ_はがき4つ切り = 4;
    private static final int ページ_INDEX_0 = 0;
    private static final int ページ_INDEX_1 = 1;
    private static final int ページ_INDEX_2 = 2;
    private static final int ページ_INDEX_3 = 3;
    private static final int ページ_INDEX_4 = 4;
    private static final int ページ_INDEX_5 = 5;
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
    private static final RString 長さ_送付先住所1 = new RString("sofusakiJusho11");
    private static final RString 長さ_送付先住所2 = new RString("sofusakiJusho21");
    private static final RString 長さ_送付先住所3 = new RString("sofusakiJusho31");
    private static final RString 長さ_送付先住所4 = new RString("sofusakiJusho41");
    private static final RString 長さ_送付先住所5 = new RString("sofusakiJusho51");

    /**
     * 選挙人個別情報と世帯コードに対応する送付先情報を合併してセットする。
     *
     * @param 選挙人個別情報リスト List<NyujokenKobetsuJouhou>
     * @param 送付先情報リスト List<SofusakiJouhou>
     * @return List<NyujoukenNyujyokkenParam>
     */
    public List<NyujoukenNyujyokkenParam> edit入場券_選挙人個別情報_対象者を作成する有(
            List<NyujokenKobetsuJouhou> 選挙人個別情報リスト,
            List<SofusakiJouhou> 送付先情報リスト) {
        List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト = new ArrayList<>();
        for (SofusakiJouhou 送付先情報 : 送付先情報リスト) {
            SetaiCode 世帯コード = 送付先情報.get送付先世帯コード();
            SoufusakiJouhou 送付先情報1 = new SoufusakiJouhou();
            送付先情報1.set世帯主名(送付先情報.get送付先世帯主名());
            送付先情報1.set送付先世帯コード(送付先情報.get送付先世帯コード());
            送付先情報1.set送付先住所(送付先情報.get送付先住所());
            送付先情報1.set送付先名簿_行(送付先情報.get送付先名簿_行());
            送付先情報1.set送付先名簿_頁(送付先情報.get送付先名簿_頁());
            送付先情報1.set送付先地区コード1(送付先情報.get送付先地区コード1());
            送付先情報1.set送付先地区名1(送付先情報.get送付先地区名1());
            送付先情報1.set送付先宛名(送付先情報.get送付先宛名());
            送付先情報1.set送付先投票区コード(送付先情報.get送付先投票区コード());
            送付先情報1.set送付先方書(送付先情報.get送付先方書());
            送付先情報1.set送付先番地(送付先情報.get送付先番地());
            送付先情報1.set送付先行政区コード(送付先情報.get送付先行政区コード());
            送付先情報1.set送付先行政区名(送付先情報.get送付先行政区名());
            送付先情報1.set送付先郵便番号(送付先情報.get送付先郵便番号());
            List<MeisaiJouhou> 明細情報リスト = new ArrayList<>();
            for (NyujokenKobetsuJouhou 選挙人個別情報 : 選挙人個別情報リスト) {
                if (世帯コード.equals(選挙人個別情報.get世帯コード())) {
                    MeisaiJouhou 明細情報 = edit明細情報(選挙人個別情報);
                    明細情報リスト.add(明細情報);
                }
            }
            NyujoukenNyujyokkenParam param = new NyujoukenNyujyokkenParam(送付先情報1,
                    明細情報リスト);
            投票所入場券情報リスト.add(param);
        }
        return 投票所入場券情報リスト;
    }

    /**
     * 入場券_個票3つ折を判断する。
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenNyujyokkenWithCheckListParam
     */
    public NyujoukenNyujyokkenWithCheckListParam check入場券For個票3つ折(
            List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        List<Nyujoken3tsuoriParam> 投票所入場券リスト = new ArrayList();
        List<Nyujoken3tsuoriParam> 投票所入場券チェックリスト = new ArrayList<>();
        for (NyujoukenNyujyokkenParam nyujoukenGameParam : 投票所入場券情報リスト) {
            SoufusakiJouhou 送付先情報 = nyujoukenGameParam.get送付先情報();
            List<MeisaiJouhou> 明細情報リスト = nyujoukenGameParam.get明細情報リスト();
            for (MeisaiJouhou 明細情報 : 明細情報リスト) {
                Nyujoken3tsuoriParam nyujoken3tsuoriParam = new Nyujoken3tsuoriParam(
                        get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                        edit送付先情報(送付先情報),
                        null,
                        null, null,
                        明細情報,
                        null,
                        null, null,
                        null, null, null, null);
                nyujoken3tsuoriParam.set地方公共団体情報(地方公共団体情報);
                if (check文字切れFor個票3つ折(送付先情報, 明細情報)) {
                    投票所入場券チェックリスト.add(nyujoken3tsuoriParam);
                } else {
                    投票所入場券リスト.add(nyujoken3tsuoriParam);
                }
            }
        }
        return new NyujoukenNyujyokkenWithCheckListParam(投票所入場券リスト, 投票所入場券チェックリスト);
    }

    /**
     * 入場券_はがき4つ切を判断する。
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>s
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenNyujyokkenWithCheckListParam
     */
    public NyujoukenNyujyokkenWithCheckListParam check入場券Forはがき4つ切(
            List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        List<Nyujoken3tsuoriParam> 投票所入場券リスト = new ArrayList();
        List<Nyujoken3tsuoriParam> 投票所入場券チェックリスト = new ArrayList<>();
        for (NyujoukenNyujyokkenParam nyujoukenGameParam : 投票所入場券情報リスト) {
            SoufusakiJouhou 送付先情報 = nyujoukenGameParam.get送付先情報();
            List<MeisaiJouhou> 明細情報リスト = nyujoukenGameParam.get明細情報リスト();
            for (MeisaiJouhou 明細情報 : 明細情報リスト) {
                Nyujoken3tsuoriParam nyujoken3tsuoriParam = new Nyujoken3tsuoriParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                        edit送付先情報(送付先情報),
                        null,
                        null, null,
                        明細情報,
                        null,
                        null, null,
                        null, null, null, null);
                nyujoken3tsuoriParam.set地方公共団体情報(地方公共団体情報);
                if (check文字切れForはがき4つ切(送付先情報, 明細情報)) {
                    投票所入場券チェックリスト.add(nyujoken3tsuoriParam);

                } else {
                    投票所入場券リスト.add(nyujoken3tsuoriParam);
                }
            }
        }
        return new NyujoukenNyujyokkenWithCheckListParam(投票所入場券リスト, 投票所入場券チェックリスト);
    }

    /**
     * 文字切れ_個票3つ折を判断する。
     *
     * @param 送付先情報 SoufusakiJouhou
     * @param 明細情報 MeisaiJouhou
     * @return Boolean
     */
    public Boolean check文字切れFor個票3つ折(SoufusakiJouhou 送付先情報, MeisaiJouhou 明細情報) {
        AtenaMeisho 世帯主名 = 送付先情報.get世帯主名();
        RString 長さ世帯主名 = null == 世帯主名 ? RString.EMPTY : 世帯主名.getColumnValue();
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_世帯主名1), 長さ世帯主名)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_名称1)
                + getNyujoken3tsuoriItemLength(長さ_名称2)
                + getNyujoken3tsuoriItemLength(長さ_名称3), 明細情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_カナ名称1)
                + getNyujoken3tsuoriItemLength(長さ_カナ名称2), 明細情報.getカナ名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujoken3tsuoriItemLength(長さ_投票所名1)
                + getNyujoken3tsuoriItemLength(長さ_投票所名2), 明細情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_はがき4つ切を判断する。
     *
     * @param 送付先情報 SoufusakiJouhou
     * @param 明細情報 MeisaiJouhou
     * @return Boolean
     */
    public Boolean check文字切れForはがき4つ切(SoufusakiJouhou 送付先情報, MeisaiJouhou 明細情報) {
        RString 送付先宛名 = 送付先情報.get送付先宛名();
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_宛名1)
                + getNyujokenHagakiSourceItemLength(長さ_宛名2)
                + getNyujokenHagakiSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_住所1)
                + getNyujokenHagakiSourceItemLength(長さ_住所2), 明細情報.get投票所＿住所())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 送付先情報.get送付先住所();
        RString 長さ送付先住所 = null == 送付先住所 ? RString.EMPTY : 送付先住所.getColumnValue();

        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_送付先住所1)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所2)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所3)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所4)
                + getNyujokenHagakiSourceItemLength(長さ_送付先住所5), 長さ送付先住所)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_名称1)
                + getNyujokenHagakiSourceItemLength(長さ_名称2)
                + getNyujokenHagakiSourceItemLength(長さ_名称3), 明細情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenHagakiSourceItemLength(長さ_投票所名1)
                + getNyujokenHagakiSourceItemLength(長さ_投票所名2), 明細情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_シーラーを判断する。
     *
     * @param 送付先情報 SoufusakiJouhou
     * @param 明細情報 MeisaiJouhou
     * @return Boolean
     */
    public Boolean check文字切れForシーラー(SoufusakiJouhou 送付先情報, MeisaiJouhou 明細情報) {
        RString 送付先宛名 = 送付先情報.get送付先宛名();
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_宛名1)
                + getNyujokenSealerSourceSourceItemLength(長さ_宛名2)
                + getNyujokenSealerSourceSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_住所1)
                + getNyujokenSealerSourceSourceItemLength(長さ_住所2), 明細情報.get投票所＿住所())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 送付先情報.get送付先住所();
        RString 長さ送付先住所 = null == 送付先住所 ? RString.EMPTY : 送付先住所.getColumnValue();
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_送付先住所1)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所2)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所3)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所4)
                + getNyujokenSealerSourceSourceItemLength(長さ_送付先住所5), 長さ送付先住所)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_名称1)
                + getNyujokenSealerSourceSourceItemLength(長さ_名称2)
                + getNyujokenSealerSourceSourceItemLength(長さ_名称3), 明細情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenSealerSourceSourceItemLength(長さ_投票所名1)
                + getNyujokenSealerSourceSourceItemLength(長さ_投票所名2), 明細情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 文字切れ_ポステックスを判断する。
     *
     * @param 送付先情報 SoufusakiJouhou
     * @param 明細情報 MeisaiJouhou
     * @return Boolean
     */
    public Boolean check文字切れForポステックス(SoufusakiJouhou 送付先情報, MeisaiJouhou 明細情報) {
        RString 送付先宛名 = 送付先情報.get送付先宛名();
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_宛名1)
                + getNyujokenPostexSourceSourceItemLength(長さ_宛名2)
                + getNyujokenPostexSourceSourceItemLength(長さ_宛名3), 送付先宛名)) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_住所1)
                + getNyujokenPostexSourceSourceItemLength(長さ_住所2), 明細情報.get投票所＿住所())) {
            return Boolean.TRUE;
        }
        AtenaJusho 送付先住所 = 送付先情報.get送付先住所();
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
                + getNyujokenPostexSourceSourceItemLength(長さ_名称3), 明細情報.get名称())) {
            return Boolean.TRUE;
        }
        if (is文字切れ(getNyujokenPostexSourceSourceItemLength(長さ_投票所名1)
                + getNyujokenPostexSourceSourceItemLength(長さ_投票所名2), 明細情報.get投票所名())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 入場券個票3つ折、はがき4つ切を編集する。
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return List<Nyujoken3tsuoriParam>
     */
    public List<Nyujoken3tsuoriParam> edit入場券For個票3つ折とはがき4つ切(
            List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        List<Nyujoken3tsuoriParam> 投票所入場券情報 = new ArrayList<>();
        for (NyujoukenNyujyokkenParam nyujoukenGameParam : 投票所入場券情報リスト) {
            SoufusakiJouhou 送付先情報 = nyujoukenGameParam.get送付先情報();
            List<MeisaiJouhou> 明細情報リスト = nyujoukenGameParam.get明細情報リスト();
            for (MeisaiJouhou meisaiJouhou : 明細情報リスト) {
                Nyujoken3tsuoriParam nyujoken3tsuoriParam = new Nyujoken3tsuoriParam(
                        get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                        edit送付先情報(送付先情報),
                        null,
                        null, null,
                        meisaiJouhou,
                        null,
                        null, null,
                        null, null, null, null);
                nyujoken3tsuoriParam.set地方公共団体情報(地方公共団体情報);
                投票所入場券情報.add(nyujoken3tsuoriParam);
            }
        }
        return 投票所入場券情報;
    }

    /**
     * 入場券帳票_個票3つ折を編集する。
     *
     * @param 投票所入場券情報リスト List<Nyujoken3tsuoriParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @param 改ページキーリスト List<RString>
     * @return List<Nyujoken3tsuoriParam>
     */
    public List<Nyujoken3tsuoriParam> edit入場券_個票3つ折(
            List<Nyujoken3tsuoriParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報,
            List<RString> 改ページキーリスト) {
        if (投票所入場券情報リスト == null || 投票所入場券情報リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Nyujoken3tsuoriParam> targets = new ArrayList<>();
        for (int i = 0; i < 投票所入場券情報リスト.size(); i = i + 改ページ_個票3つ折り) {
            SoufusakiJouhou 送付先情報1 = 投票所入場券情報リスト.get(i).get送付先情報1();
            MeisaiJouhou 明細情報1 = 投票所入場券情報リスト.get(i).get明細情報1();
            送付先情報1.set整理番号(i + 1);
            SoufusakiJouhou 送付先情報2 = null;
            MeisaiJouhou 明細情報2 = null;
            if (i + 1 < 投票所入場券情報リスト.size()) {
                明細情報2 = 投票所入場券情報リスト.get(i + 1).get明細情報1();
                if (is改ページ(改ページキーリスト, 明細情報1, 明細情報2)) {
                    Nyujoken3tsuoriParam param = new Nyujoken3tsuoriParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                            送付先情報1,
                            null,
                            null, null,
                            明細情報1,
                            null,
                            null, null,
                            null, null, null, null);
                    param.set地方公共団体情報(地方公共団体情報);
                    targets.add(param);
                    i = i - 2;
                    continue;
                }
                送付先情報2 = 投票所入場券情報リスト.get(i + 1).get送付先情報1();
                送付先情報2.set整理番号(i + 2);
            }
            SoufusakiJouhou 送付先情報3 = null;
            MeisaiJouhou 明細情報3 = null;
            if (i + 2 < 投票所入場券情報リスト.size()) {
                明細情報3 = 投票所入場券情報リスト.get(i + 2).get明細情報1();
                if (is改ページ(改ページキーリスト, 明細情報2, 明細情報3)) {
                    Nyujoken3tsuoriParam param = new Nyujoken3tsuoriParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                            送付先情報1,
                            送付先情報2,
                            null, null,
                            明細情報1,
                            明細情報2,
                            null, null,
                            null, null, null, null);
                    param.set地方公共団体情報(地方公共団体情報);
                    targets.add(param);
                    i = i - 1;
                    continue;
                }
                送付先情報3 = 投票所入場券情報リスト.get(i + 2).get送付先情報1();
                送付先情報3.set整理番号(i + 改ページ_個票3つ折り);
            }

            Nyujoken3tsuoriParam param = new Nyujoken3tsuoriParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                    送付先情報1,
                    送付先情報2,
                    送付先情報3, null,
                    明細情報1,
                    明細情報2,
                    明細情報3, null,
                    null, null, null, null);
            param.set地方公共団体情報(地方公共団体情報);
            targets.add(param);
        }
        return targets;
    }

    /**
     * 入場券帳票_はがき4つ切を編集する。
     *
     * @param 投票所入場券情報 List<Nyujoken3tsuoriParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @param 改ページキーリスト List<RString>
     * @return List<NyujokenHagakiParam>
     */
    public List<NyujokenHagakiParam> edit入場券_はがき4つ切り(
            List<Nyujoken3tsuoriParam> 投票所入場券情報,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報,
            List<RString> 改ページキーリスト) {
        if (投票所入場券情報 == null || 投票所入場券情報.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<NyujokenHagakiParam> targets = new ArrayList<>();
        for (int i = 0; i < 投票所入場券情報.size(); i = i + 改ページ_はがき4つ切り) {
            SoufusakiJouhou 送付先情報1 = 投票所入場券情報.get(i).get送付先情報1();
            MeisaiJouhou 明細情報1 = 投票所入場券情報.get(i).get明細情報1();
            送付先情報1.set整理番号(i + 1);
            SoufusakiJouhou 送付先情報2 = null;
            MeisaiJouhou 明細情報2 = null;
            if (i + 1 < 投票所入場券情報.size()) {
                明細情報2 = 投票所入場券情報.get(i + 1).get明細情報1();
                if (is改ページ(改ページキーリスト, 明細情報1, 明細情報2)) {
                    NyujokenHagakiParam param = new NyujokenHagakiParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                            送付先情報1,
                            null,
                            null, null,
                            明細情報1,
                            null,
                            null, null,
                            null, null, null, null);
                    param.set地方公共団体情報(地方公共団体情報);
                    targets.add(param);
                    i = i - 改ページ_個票3つ折り;
                    continue;
                }
                送付先情報2 = 投票所入場券情報.get(i + 1).get送付先情報1();
                送付先情報2.set整理番号(i + 2);
            }
            SoufusakiJouhou 送付先情報3 = null;
            MeisaiJouhou 明細情報3 = null;
            if (i + 2 < 投票所入場券情報.size()) {
                明細情報3 = 投票所入場券情報.get(i + 2).get明細情報1();
                if (is改ページ(改ページキーリスト, 明細情報2, 明細情報3)) {
                    NyujokenHagakiParam param = new NyujokenHagakiParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                            送付先情報1,
                            送付先情報2,
                            null, null,
                            明細情報1,
                            明細情報2,
                            null, null,
                            null, null, null, null);
                    param.set地方公共団体情報(地方公共団体情報);
                    targets.add(param);
                    i = i - 2;
                    continue;
                }
                送付先情報3 = 投票所入場券情報.get(i + 2).get送付先情報1();
                送付先情報3.set整理番号(i + 改ページ_個票3つ折り);
            }
            SoufusakiJouhou 送付先情報4 = null;
            MeisaiJouhou 明細情報4 = null;
            if (i + 改ページ_個票3つ折り < 投票所入場券情報.size()) {
                明細情報4 = 投票所入場券情報.get(i + 改ページ_個票3つ折り).get明細情報1();
                if (is改ページ(改ページキーリスト, 明細情報3, 明細情報4)) {
                    NyujokenHagakiParam param = new NyujokenHagakiParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                            送付先情報1,
                            送付先情報2,
                            送付先情報3, null,
                            明細情報1,
                            明細情報2,
                            明細情報3, null,
                            null, null, null, null);
                    param.set地方公共団体情報(地方公共団体情報);
                    targets.add(param);
                    i = i - 1;
                    continue;
                }
                送付先情報4 = 投票所入場券情報.get(i + 改ページ_個票3つ折り).get送付先情報1();
                送付先情報4.set整理番号(i + 改ページ_はがき4つ切り);
            }
            NyujokenHagakiParam param = new NyujokenHagakiParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                    送付先情報1,
                    送付先情報2,
                    送付先情報3, 送付先情報4,
                    明細情報1,
                    明細情報2,
                    明細情報3, 明細情報4,
                    null, null, null, null);
            param.set地方公共団体情報(地方公共団体情報);
            targets.add(param);
        }

        return targets;
    }

    /**
     * 入場券_シーラーをチェックする。
     *
     * @param 入場券発行明細情報リスト List<NyujoukenNyujyokkenParam>
     * @return NyujoukenHakkouMeishoWithCheckListParam
     */
    public NyujoukenHakkouMeishoWithCheckListParam check入場券Forシーラー(
            List<NyujoukenNyujyokkenParam> 入場券発行明細情報リスト) {
        List<NyujoukenNyujyokkenParam> targets = new ArrayList<>();
        List<NyujoukenNyujyokkenParam> targetsWithCheckList = new ArrayList<>();
        if (入場券発行明細情報リスト == null || 入場券発行明細情報リスト.isEmpty()) {
            return new NyujoukenHakkouMeishoWithCheckListParam();
        }
        for (NyujoukenNyujyokkenParam 入場券発行明細情報 : 入場券発行明細情報リスト) {
            List<MeisaiJouhou> 明細情報リスト = 入場券発行明細情報.get明細情報リスト();
            List<MeisaiJouhou> 明細情報リストnew = new ArrayList<>();
            List<MeisaiJouhou> 明細情報リストチェックリストnew = new ArrayList<>();
            SoufusakiJouhou 送付先情報 = 入場券発行明細情報.get送付先情報();
            for (MeisaiJouhou 明細情報 : 明細情報リスト) {
                if (check文字切れForシーラー(送付先情報, 明細情報)) {
                    明細情報リストチェックリストnew.add(明細情報);
                } else {
                    明細情報リストnew.add(明細情報);
                }
            }
            targetsWithCheckList.add(
                    new NyujoukenNyujyokkenParam(入場券発行明細情報.get送付先情報(), 明細情報リストチェックリストnew));
            targets.add(
                    new NyujoukenNyujyokkenParam(入場券発行明細情報.get送付先情報(), 明細情報リストnew));
        }
        return new NyujoukenHakkouMeishoWithCheckListParam(targets, targetsWithCheckList);
    }

    /**
     * 入場券_ステックスをチェックする。
     *
     * @param 入場券発行明細情報リスト List<NyujoukenNyujyokkenParam>
     * @return NyujoukenHakkouMeishoWithCheckListParam
     */
    public NyujoukenHakkouMeishoWithCheckListParam check入場券Forポステックス(
            List<NyujoukenNyujyokkenParam> 入場券発行明細情報リスト) {
        List<NyujoukenNyujyokkenParam> targets = new ArrayList<>();
        List<NyujoukenNyujyokkenParam> targetsWithCheckList = new ArrayList<>();
        if (入場券発行明細情報リスト == null || 入場券発行明細情報リスト.isEmpty()) {
            return new NyujoukenHakkouMeishoWithCheckListParam();
        }
        for (NyujoukenNyujyokkenParam 入場券発行明細情報 : 入場券発行明細情報リスト) {
            List<MeisaiJouhou> 明細情報リスト = 入場券発行明細情報.get明細情報リスト();
            List<MeisaiJouhou> 明細情報リストnew = new ArrayList<>();
            List<MeisaiJouhou> 明細情報リストチェックリストnew = new ArrayList<>();
            SoufusakiJouhou 送付先情報 = 入場券発行明細情報.get送付先情報();
            for (MeisaiJouhou 明細情報 : 明細情報リスト) {
                if (check文字切れForポステックス(送付先情報, 明細情報)) {
                    明細情報リストチェックリストnew.add(明細情報);
                } else {
                    明細情報リストnew.add(明細情報);
                }
            }
            targetsWithCheckList.add(
                    new NyujoukenNyujyokkenParam(入場券発行明細情報.get送付先情報(), 明細情報リストチェックリストnew));
            targets.add(
                    new NyujoukenNyujyokkenParam(入場券発行明細情報.get送付先情報(), 明細情報リストnew));
        }
        return new NyujoukenHakkouMeishoWithCheckListParam(targets, targetsWithCheckList);
    }

    /**
     * 入場券_シーラーとポステックスを編集する。
     *
     * @param 入場券発行明細情報リスト List<NyujoukenNyujyokkenParam>
     * @param 改ページキーリスト List<RString>
     * @return List<NyujoukenNyujyokkenParam>
     */
    public List<NyujoukenNyujyokkenParam> edit入場券Forシーラーとポステックス(
            List<NyujoukenNyujyokkenParam> 入場券発行明細情報リスト,
            List<RString> 改ページキーリスト) {
        List<NyujoukenNyujyokkenParam> targets = new ArrayList<>();
        if (入場券発行明細情報リスト == null || 入場券発行明細情報リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        RString 世帯印字人数 = BusinessConfig.get(ConfigKeysAFA.入場券_世帯印字人数, SubGyomuCode.AFA選挙本体);
        int 印字人数 = RString.isNullOrEmpty(世帯印字人数) ? 0 : Integer.parseInt(世帯印字人数.toString());
        for (NyujoukenNyujyokkenParam 入場券発行明細情報 : 入場券発行明細情報リスト) {
            List<MeisaiJouhou> 明細情報リスト = 入場券発行明細情報.get明細情報リスト();
            List<MeisaiJouhou> 明細情報リストnew = new ArrayList<>();
            int count = 0;
            MeisaiJouhou 明細情報Before = new MeisaiJouhou();
            for (MeisaiJouhou 明細情報 : 明細情報リスト) {
                if (明細情報リストnew.size() < 印字人数
                        && !is改ページ(改ページキーリスト, 明細情報Before, 明細情報)) {
                    明細情報リストnew.add(明細情報);
                    明細情報Before = 明細情報;
                    if (明細情報リスト.size() == count + 1) {
                        targets.add(
                                new NyujoukenNyujyokkenParam(edit送付先情報(入場券発行明細情報.get送付先情報()), 明細情報リストnew));
                    }
                } else {
                    targets.add(
                            new NyujoukenNyujyokkenParam(edit送付先情報(入場券発行明細情報.get送付先情報()), 明細情報リストnew));
                    明細情報リストnew = new ArrayList<>();
                }
                count++;
            }
        }
        return targets;
    }

    /**
     * 入場券_ポステックスを編集する。
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return List<NyujokenPostexParam>
     */
    public List<NyujokenPostexParam> edit入場券_ポステックス(
            List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        if (投票所入場券情報リスト == null || 投票所入場券情報リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<NyujokenPostexParam> targets = new ArrayList<>();
        for (int i = 0; i < 投票所入場券情報リスト.size(); i++) {
            SoufusakiJouhou 送付先情報 = 投票所入場券情報リスト.get(i).get送付先情報();
            送付先情報.set整理番号(i + 1);
            List<MeisaiJouhou> 明細情報リスト = 投票所入場券情報リスト.get(i).get明細情報リスト();
            MeisaiJouhou 明細情報1 = null;
            MeisaiJouhou 明細情報2 = null;
            MeisaiJouhou 明細情報3 = null;
            MeisaiJouhou 明細情報4 = null;
            MeisaiJouhou 明細情報5 = null;
            MeisaiJouhou 明細情報6 = null;
            if (明細情報リスト.size() > ページ_INDEX_0) {
                明細情報1 = 明細情報リスト.get(ページ_INDEX_0);
            }
            if (明細情報リスト.size() > ページ_INDEX_1) {
                明細情報2 = 明細情報リスト.get(ページ_INDEX_1);
            }
            if (明細情報リスト.size() > ページ_INDEX_2) {
                明細情報3 = 明細情報リスト.get(ページ_INDEX_2);
            }
            if (明細情報リスト.size() > ページ_INDEX_3) {
                明細情報4 = 明細情報リスト.get(ページ_INDEX_3);
            }
            if (明細情報リスト.size() > ページ_INDEX_4) {
                明細情報5 = 明細情報リスト.get(ページ_INDEX_4);
            }
            if (明細情報リスト.size() > ページ_INDEX_5) {
                明細情報6 = 明細情報リスト.get(ページ_INDEX_5);
            }

            NyujokenPostexParam param = new NyujokenPostexParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                    送付先情報,
                    null,
                    null, null,
                    明細情報1,
                    明細情報2,
                    明細情報3, 明細情報4,
                    明細情報5, 明細情報6, null, null);
            param.set地方公共団体情報(地方公共団体情報);
            targets.add(param);
        }

        return targets;
    }

    /**
     * 入場券_シーラーを編集する。
     *
     * @param 投票所入場券情報リスト List<NyujoukenNyujyokkenParam>
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return List<NyujokenSealerParam>
     */
    public List<NyujokenSealerParam> edit入場券_シーラー(
            List<NyujoukenNyujyokkenParam> 投票所入場券情報リスト,
            AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        if (投票所入場券情報リスト == null || 投票所入場券情報リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<NyujokenSealerParam> targets = new ArrayList<>();
        for (int i = 0; i < 投票所入場券情報リスト.size(); i = i + 2) {
            SoufusakiJouhou 送付先情報1 = 投票所入場券情報リスト.get(i).get送付先情報();
            送付先情報1.set整理番号(i + 1);
            List<MeisaiJouhou> 明細情報明細情報リスト1 = 投票所入場券情報リスト.get(i).get明細情報リスト();
            MeisaiJouhou 明細情報1 = null;
            MeisaiJouhou 明細情報2 = null;
            MeisaiJouhou 明細情報3 = null;
            MeisaiJouhou 明細情報4 = null;

            if (明細情報明細情報リスト1.size() > ページ_INDEX_0) {
                明細情報1 = 明細情報明細情報リスト1.get(ページ_INDEX_0);

            }
            if (明細情報明細情報リスト1.size() > ページ_INDEX_1) {
                明細情報2 = 明細情報明細情報リスト1.get(ページ_INDEX_1);
            }
            if (明細情報明細情報リスト1.size() > ページ_INDEX_2) {
                明細情報3 = 明細情報明細情報リスト1.get(ページ_INDEX_2);
            }
            if (明細情報明細情報リスト1.size() > ページ_INDEX_3) {
                明細情報4 = 明細情報明細情報リスト1.get(ページ_INDEX_3);
            }
            MeisaiJouhou 明細情報5 = null;
            MeisaiJouhou 明細情報6 = null;
            MeisaiJouhou 明細情報7 = null;
            MeisaiJouhou 明細情報8 = null;
            SoufusakiJouhou 送付先情報2 = null;
            if (i + 1 < 投票所入場券情報リスト.size()) {
                送付先情報2 = 投票所入場券情報リスト.get(i + 1).get送付先情報();
                送付先情報2.set整理番号(i + 2);
                List<MeisaiJouhou> 明細情報明細情報リスト2 = 投票所入場券情報リスト.get(i + 1).get明細情報リスト();
                if (明細情報明細情報リスト2.size() > ページ_INDEX_0) {
                    明細情報5 = 明細情報明細情報リスト2.get(ページ_INDEX_0);
                }
                if (明細情報明細情報リスト2.size() > ページ_INDEX_1) {
                    明細情報6 = 明細情報明細情報リスト2.get(ページ_INDEX_1);
                }
                if (明細情報明細情報リスト2.size() > ページ_INDEX_2) {
                    明細情報7 = 明細情報明細情報リスト2.get(ページ_INDEX_2);
                }
                if (明細情報明細情報リスト2.size() > ページ_INDEX_3) {
                    明細情報8 = 明細情報明細情報リスト2.get(ページ_INDEX_3);
                }
            }

            NyujokenSealerParam param = new NyujokenSealerParam(get選挙共通情報(selectProcessParameter, 地方公共団体情報),
                    送付先情報1,
                    送付先情報2,
                    null, null,
                    明細情報1,
                    明細情報2,
                    明細情報3, 明細情報4,
                    明細情報5, 明細情報6, 明細情報7, 明細情報8);
            param.set地方公共団体情報(地方公共団体情報);
            targets.add(param);
        }

        return targets;
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報(AFABTB202SelectProcessParameter selectProcessParameter,
            Association 地方公共団体情報) {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        nyujoukenGamenModel.set抄本番号(new RString(selectProcessParameter.get抄本番号().getColumnValue()));
        nyujoukenGamenModel.set抄本名(selectProcessParameter.get抄本名());
        nyujoukenGamenModel.set入場券名称1(selectProcessParameter.get入場券名1());
        nyujoukenGamenModel.set入場券名称2(selectProcessParameter.get入場券名2());
        nyujoukenGamenModel.set入場券名称3(selectProcessParameter.get入場券名3());
        nyujoukenGamenModel.setサンプル文字(selectProcessParameter.getサンプル文字());
        FlexibleDate 投票日 = selectProcessParameter.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(selectProcessParameter.get投票日().toString()));
        List<SenkyomeishouParam> 選挙名称リスト = new ArrayList<>();
        if (selectProcessParameter.get選挙リスト() != null
                && !selectProcessParameter.get選挙リスト().isEmpty()) {
            for (Senkyomeishou senkyomeishou : selectProcessParameter.get選挙リスト()) {
                SenkyomeishouParam senkyomeishouParam = new SenkyomeishouParam();
                senkyomeishouParam.set選挙名称(senkyomeishou.get選挙名称());
                senkyomeishouParam.set選挙略称(senkyomeishou.get選挙略称());
                選挙名称リスト.add(senkyomeishouParam);
            }
            nyujoukenGamenModel.set選挙名称(選挙名称リスト);
        }
        nyujoukenGamenModel.set告示年月日(RDate.MAX);
        nyujoukenGamenModel.set地方公共団体情報(地方公共団体情報);
        return nyujoukenGamenModel;
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

    private RDate changeFlexibleDateToRDate(FlexibleDate flexibleDate) {
        if (flexibleDate != null && !flexibleDate.isEmpty() && flexibleDate.isValid()) {
            return new RDate(flexibleDate.toString());
        } else {
            return null;
        }
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

    private SoufusakiJouhou edit送付先情報(SoufusakiJouhou 送付先情報) {
        SoufusakiJouhou soufusakiJouhou = new SoufusakiJouhou();
        soufusakiJouhou.set世帯主名(送付先情報.get世帯主名());
        soufusakiJouhou.set送付先世帯コード(送付先情報.get送付先世帯コード());
        soufusakiJouhou.set送付先住所(送付先情報.get送付先住所());
        soufusakiJouhou.set送付先名簿_行(送付先情報.get送付先名簿_行());
        soufusakiJouhou.set送付先名簿_頁(送付先情報.get送付先名簿_頁());
        soufusakiJouhou.set送付先地区コード1(送付先情報.get送付先地区コード1());
        soufusakiJouhou.set送付先地区名1(送付先情報.get送付先地区名1());
        soufusakiJouhou.set送付先宛名(送付先情報.get送付先宛名());
        soufusakiJouhou.set送付先投票区コード(送付先情報.get送付先投票区コード());
        soufusakiJouhou.set送付先方書(送付先情報.get送付先方書());
        soufusakiJouhou.set送付先番地(送付先情報.get送付先番地());
        soufusakiJouhou.set送付先行政区コード(送付先情報.get送付先行政区コード());
        soufusakiJouhou.set送付先行政区名(送付先情報.get送付先行政区名());
        soufusakiJouhou.set送付先郵便番号(送付先情報.get送付先郵便番号());
        return soufusakiJouhou;
    }

    private MeisaiJouhou edit明細情報(NyujokenKobetsuJouhou 選挙人個別情報) {
        MeisaiJouhou 明細情報 = new MeisaiJouhou();
        明細情報.setカナ名称(選挙人個別情報.getカナ名称());
        明細情報.set世帯コード(選挙人個別情報.get世帯コード());
        明細情報.set世帯主名(選挙人個別情報.get世帯主名());
        明細情報.set住民種別コード(選挙人個別情報.get住民種別コード());
        明細情報.set住登内住所(
                選挙人個別情報.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(選挙人個別情報.get住所()));
        if (選挙人個別情報.get全国住所コード() == null) {
            明細情報.set住登内町域コード(選挙人個別情報.get全国住所コード().getColumnValue());
        } else {
            明細情報.set住登内町域コード(RString.EMPTY);
        }
        明細情報.set住登内番地(選挙人個別情報.get番地());
        if (選挙人個別情報.get地区コード１() == null) {
            明細情報.set地区コード1(選挙人個別情報.get地区コード１().getColumnValue());
        } else {
            明細情報.set地区コード1(RString.EMPTY);
        }
        if (選挙人個別情報.get地区コード２() == null) {
            明細情報.set地区コード2(選挙人個別情報.get地区コード２().getColumnValue());
        } else {
            明細情報.set地区コード2(RString.EMPTY);
        }
        if (選挙人個別情報.get地区コード３() == null) {
            明細情報.set地区コード3(選挙人個別情報.get地区コード３().getColumnValue());
        } else {
            明細情報.set地区コード3(RString.EMPTY);
        }
        明細情報.set地区名1(選挙人個別情報.get地区名１());
        明細情報.set地区名2(選挙人個別情報.get地区名２());
        明細情報.set地区名3(選挙人個別情報.get地区名３());
        明細情報.set性別コード(選挙人個別情報.get性別コード());
        明細情報.set投票区コード(選挙人個別情報.get投票区コード());
        明細情報.set投票区名(選挙人個別情報.get投票区名());
        明細情報.set投票所名(選挙人個別情報.get投票所名());
        if (選挙人個別情報.get投票所の住所() == null) {
            明細情報.set投票所＿住所(選挙人個別情報.get投票所の住所().getColumnValue());
        } else {
            明細情報.set投票所＿住所(RString.EMPTY);
        }
        明細情報.set続柄コード(選挙人個別情報.get続柄コード().getColumnValue());
        明細情報.set生年月日(changeFlexibleDateToRDate(選挙人個別情報.get生年月日()));

        明細情報.set投票開始時刻(選挙人個別情報.get投票開始時刻());
        明細情報.set投票終了時刻(選挙人個別情報.get投票終了時刻());
        if (選挙人個別情報.get行政区コード() == null) {
            明細情報.set行政区コード(選挙人個別情報.get行政区コード().getColumnValue());
        } else {
            明細情報.set行政区コード(RString.EMPTY);
        }
        明細情報.set行政区名(選挙人個別情報.get行政区名());
        明細情報.set名称(選挙人個別情報.get名称());
        明細情報.set頁(選挙人個別情報.get頁());
        明細情報.set行(選挙人個別情報.get行());
        明細情報.set識別コード(選挙人個別情報.get識別コード());
        明細情報.set住民票表示順(選挙人個別情報.get住民票表示順());
        return 明細情報;
    }

    private boolean is改ページ(List<RString> 改ページキーリスト,
            MeisaiJouhou 明細情報Before,
            MeisaiJouhou 明細情報After) {
        if (改ページキーリスト == null || 改ページキーリスト.isEmpty()) {
            return Boolean.FALSE;
        }
        RString 投票区コードBefore = 明細情報Before.get投票区コード();
        RString 投票区コードAfter = 明細情報After.get投票区コード();
        Boolean is改ページ = is改ページ_投票区コード(改ページキーリスト, 投票区コードBefore, 投票区コードAfter);
        if (is改ページ) {
            return is改ページ;
        }
        RString 行政区コードBefore = 明細情報Before.get行政区コード();
        RString 行政区コードAfter = 明細情報After.get行政区コード();
        is改ページ = is改ページ_行政区コード(改ページキーリスト, 行政区コードBefore, 行政区コードAfter);
        if (is改ページ) {
            return is改ページ;
        }
        AtenaMeisho カナ世帯主名Before = 明細情報Before.get世帯主名();
        AtenaMeisho カナ世帯主名After = 明細情報After.get世帯主名();
        is改ページ = is改ページ_カナ世帯主名(改ページキーリスト, カナ世帯主名Before, カナ世帯主名After);
        if (is改ページ) {
            return is改ページ;
        }
        SetaiCode 世帯コードBefore = 明細情報Before.get世帯コード();
        SetaiCode 世帯コードAfter = 明細情報After.get世帯コード();
        is改ページ = is改ページ_世帯コード(改ページキーリスト, 世帯コードBefore, 世帯コードAfter);
        if (is改ページ) {
            return is改ページ;
        }
        int 住基表示順Before = 明細情報Before.get住民票表示順();
        int 住基表示順After = 明細情報After.get住民票表示順();
        is改ページ = is改ページ_住基表示順(改ページキーリスト, 住基表示順Before, 住基表示順After);
        return is改ページ;
    }

    private boolean is改ページ_投票区コード(List<RString> 改ページキーリスト,
            RString 投票区コードBefore,
            RString 投票区コードAfter) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.投票区コード.get項目ID())) {
            if (RString.isNullOrEmpty(投票区コードBefore) && RString.isNullOrEmpty(投票区コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(投票区コードBefore)
                    && !RString.isNullOrEmpty(投票区コードAfter)
                    && 投票区コードBefore.equals(投票区コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }

    private boolean is改ページ_行政区コード(List<RString> 改ページキーリスト,
            RString 行政区コードBefore,
            RString 行政区コードAfter) {
        Boolean is改ページ = Boolean.FALSE;

        if (改ページキーリスト.contains(ReportOutputType.行政区コード.get項目ID())) {
            if (RString.isNullOrEmpty(行政区コードBefore) && RString.isNullOrEmpty(行政区コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(行政区コードBefore)
                    && !RString.isNullOrEmpty(行政区コードAfter)
                    && 行政区コードBefore.equals(行政区コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }

    private boolean is改ページ_カナ世帯主名(List<RString> 改ページキーリスト,
            AtenaMeisho カナ世帯主名Before,
            AtenaMeisho カナ世帯主名After) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.カナ世帯主名.get項目ID())) {

            if (カナ世帯主名Before == null && カナ世帯主名After == null) {
                is改ページ = Boolean.FALSE;
            } else if (カナ世帯主名Before != null
                    && カナ世帯主名After != null
                    && カナ世帯主名Before.equals(カナ世帯主名After)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }

    private boolean is改ページ_世帯コード(List<RString> 改ページキーリスト,
            SetaiCode 世帯コードBefore,
            SetaiCode 世帯コードAfter) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.世帯コード.get項目ID())) {

            if (世帯コードBefore == null && 世帯コードAfter == null) {
                is改ページ = Boolean.FALSE;
            } else if (世帯コードBefore != null
                    && 世帯コードAfter != null
                    && 世帯コードBefore.equals(世帯コードAfter)) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }

    private boolean is改ページ_住基表示順(List<RString> 改ページキーリスト,
            int 住基表示順Before,
            int 住基表示順After) {
        Boolean is改ページ = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.住民票表示順.get項目ID())) {
            if (住基表示順Before == 住基表示順After) {
                is改ページ = Boolean.FALSE;
            } else {
                is改ページ = Boolean.TRUE;
            }
        }
        return is改ページ;
    }
}
