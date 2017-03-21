/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nippo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 日報関連帳票バッチパラメータクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE503BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHONNO = "抄本番号";
    private static final String KEY_SENKYO_OUTFLG = "無投票選挙も出力する";
    private static final String KEY_KMNIPPO = "期日前投票日報";
    private static final String KEY_KJMAE_SHISETSU_FROM = "期日前投票施設コードFrom";
    private static final String KEY_KJMAE_SHISETSU_TO = "期日前投票施設コードTo";
    private static final String KEY_KJMAE_TOUHYOYMD_FROM = "期日前投票投票日From";
    private static final String KEY_KJMAE_TOUHYOYMD_TO = "期日前投票投票日To";
    private static final String KEY_FUZAISHANIPPO = "不在者投票日報";
    private static final String KEY_FUZAISHANIPPO_KOFU = "不在者交付日報";
    private static final String KEY_FUZAISHA_KOFUYMD_FROM = "不在者交付日From";
    private static final String KEY_FUZAISHA_KOFUYMD_TO = "不在者交付日To";
    private static final String KEY_FUZAISHANIPPO_JURI = "不在者受理日報";
    private static final String KEY_FUZAISHA_JURIYMD_FROM = "不在者受理日From";
    private static final String KEY_FUZAISHA_JURIYMD_TO = "不在者受理日To";
    private static final String KEY_KMTOHYOSHA = "期日前投票者一覧表";
    private static final String KEY_KJMTHSHA_TOHYOCODE_FROM = "期日前投票者一覧表投票区From";
    private static final String KEY_KJMTHSHA_TOHYOCODE_TO = "期日前投票者一覧表投票区To";
    private static final String KEY_KJMTHSHA_SHISETSU_FROM = "期日前投票者一覧表施設コードFrom";
    private static final String KEY_KJMTHSHA_SHISETSU_TO = "期日前投票者一覧表施設コードTo";
    private static final String KEY_KJMTHSHA_KJMAE_THYMD_FROM = "期日前投票者一覧表期日前投票日From";
    private static final String KEY_KJMTHSHA_KJMAE_THYMD_TO = "期日前投票者一覧表期日前投票日To";
    private static final String KEY_KJMTHSHA_TOHYOTIME_FROM = "期日前投票者一覧表投票時刻From";
    private static final String KEY_KJMTHSHA_TOHYOTIME_TO = "期日前投票者一覧表投票時刻To";
    private static final String KEY_KJMTHSHA_DAIRITOHYO_FLG = "期日前投票者一覧表代理投票のみ";
    private static final String KEY_KJMTHSHA_TENJI_FLG = "期日前投票者一覧表点字投票のみ";
    private static final String KEY_KJMTHSHA_KIKEN_FLG = "期日前投票者一覧表棄権のみ";
    private static final String KEY_KJMTHSHA_UKETUKEKYOHI_FLG = "期日前投票者一覧表受付拒否のみ";
    private static final String KEY_KJMTHSHA_KATITOHYOU_FLG = "期日前投票者一覧表仮投票のみ";
    private static final String KEY_FUZAISHATOHYOSHA = "不在者投票者一覧表";
    private static final String KEY_FZSTHSHA_TOHYOCODE_FROM = "不在者投票者一覧表投票区From";
    private static final String KEY_FZSTHSHA_TOHYOCODE_TO = "不在者投票者一覧表投票区To";
    private static final String KEY_FZSTHSHA_SHISETSU_FROM = "不在者投票者一覧表施設コードFrom";
    private static final String KEY_FZSTHSHA_SHISETSU_TO = "不在者投票者一覧表施設コードTo";
    private static final String KEY_FZSTHSHA_KOFUYMD_FROM = "不在者投票者一覧表交付日From";
    private static final String KEY_FZSTHSHA_KOFUYMD_TO = "不在者投票者一覧表交付日To";
    private static final String KEY_FZSTHSHA_JURIYMD_FROM = "不在者投票者一覧表受理日From";
    private static final String KEY_FZSTHSHA_JURIYMD_TO = "不在者投票者一覧表受理日To";
    private static final String KEY_FZSTHSHA_JURITIME_FROM = "不在者投票者一覧表受理時刻From";
    private static final String KEY_FZSTHSHA_JURITIME_TO = "不在者投票者一覧表受理時刻To";
    private static final String KEY_FZSTHSHA_SEIKYU_FLG = "不在者投票者一覧表請求のみ";
    private static final String KEY_FZSTHSHA_MICHAKUSHA_FLG = "不在者投票者一覧表未着者のみ";
    private static final String KEY_FZSTHSHA_DAIRITOHYO_FLG = "不在者投票者一覧表代理投票のみ";
    private static final String KEY_FZSTHSHA_TENJI_FLG = "不在者投票者一覧表点字投票のみ";
    private static final String KEY_FZSTHSHA_HENKAN_FLG = "不在者投票者一覧表返還のみ";
    private static final String KEY_FZSTHSHA_KIKEN_FLG = "不在者投票者一覧表棄権のみ";
    private static final String KEY_TOHYOSHALISTSENKYOALL = "投票者一覧表";
    private static final String KEY_THS_KJM_AND_FUZAISHA = "投票者一覧表混在";
    private static final String KEY_THS_TOHYOCODE_FROM = "投票者一覧表投票区From";
    private static final String KEY_THS_TOHYOCODE_TO = "投票者一覧表投票区To";
    private static final String KEY_THS_SHISETSU_FROM = "投票者一覧表施設コードFrom";
    private static final String KEY_THS_SHISETSU_TO = "投票者一覧表施設コードTo";
    private static final String KEY_THS_KM = "投票者一覧表期日前投票";
    private static final String KEY_THS_KJM_TOHYOUJUYU = "投票者一覧表投票事由";
    private static final String KEY_THS_KJM_TOUHYOYMD_FROM = "投票者一覧表期日前投票日From";
    private static final String KEY_THS_KJM_TOUHYOYMD__TO = "投票者一覧表期日前投票日To";
    private static final String KEY_THS_KJM_TOHYOTIME_FROM = "投票者一覧表投票時刻From";
    private static final String KEY_THS_KJM_TOHYOTIME_TO = "投票者一覧表投票時刻To";
    private static final String KEY_THS_KJM_DAIRITOHYO_FLG = "投票者一覧表期日前代理投票のみ";
    private static final String KEY_THS_KJM_TENJI_FLG = "投票者一覧表期日前点字投票のみ";
    private static final String KEY_THS_KJM_KIKEN_FLG = "投票者一覧表期日前棄権のみ";
    private static final String KEY_THS_KJM_UKETUKEKYOHI_FLG = "投票者一覧表期日前受付拒否のみ";
    private static final String KEY_THS_KJM_KATITOHYOU_FLG = "投票者一覧表期日前仮投票のみ";
    private static final String KEY_THS_FUZAISHA = "投票者一覧表不在者投票";
    private static final String KEY_THS_FZS_KOFUYMD_FROM = "投票者一覧表交付日From";
    private static final String KEY_THS_FZS_KOFUYMD_TO = "投票者一覧表交付日To";
    private static final String KEY_THS_FZS_JURIYMD_FROM = "投票者一覧表受理日From";
    private static final String KEY_THS_FZS_JURIYMD_TO = "投票者一覧表受理日To";
    private static final String KEY_THS_FZS_JURITIME_FROM = "投票者一覧表受理時刻From";
    private static final String KEY_THS_FZS_JURITIME_TO = "投票者一覧表受理時刻To";
    private static final String KEY_THS_FZS_SEIKYU_FLG = "投票者一覧表請求のみ";
    private static final String KEY_THS_FZS_MICHAKUSHA_FLG = "投票者一覧表不在者未着者のみ";
    private static final String KEY_THS_FZS_DAIRITOHYO_FLG = "投票者一覧表不在者代理投票のみ";
    private static final String KEY_THS_FZS_TENJI_FLG = "投票者一覧表不在者点字投票のみ";
    private static final String KEY_THS_FZS_HENKAN_FLG = "投票者一覧表不在者返還のみ";
    private static final String KEY_THS_FZS_KIKEN_FLG = "投票者一覧表不在者棄権のみ";
    private static final String KEY_TOHYOSJIYUCHOSHO = "投票事由調書";
    private static final String KEY_THSSHO_KM = "投票事由調書期日前投票";
    private static final String KEY_THSSHO_KM_TOUHYOYMD_FROM = "投票事由調書期日前投票日From";
    private static final String KEY_THSSHO_KM_TOUHYOYMD_TO = "投票事由調書期日前投票日To";
    private static final String KEY_THSSHO_FUZAISHA = "投票事由調書不在者投票";
    private static final String KEY_THSSHO_JURIYMD_FROM = "投票事由調書受理日From";
    private static final String KEY_THSSHO_JURIYMD_TO = "投票事由調書受理日To";
    private static final String KEY_SHUKEI = "投票集計整理表";
    private static final String KEY_SHUKEI_TOHYOCODE_FROM = "投票集計整理表投票区From";
    private static final String KEY_SHUKEI_TOHYOCODE_TO = "投票集計整理表投票区To";
    private static final String KEY_SHUKEI_JURIYMD = "投票集計整理表受理日";

    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SENKYO_OUTFLG, name = "無投票選挙も出力する", order = 2)
    private Boolean 無投票選挙も出力する;
    @BatchParameter(key = KEY_KMNIPPO, name = "期日前投票日報", order = 3)
    private Boolean 期日前投票日報;
    @BatchParameter(key = KEY_KJMAE_SHISETSU_FROM, name = "期日前投票施設コードFrom", order = 4)
    private RString 期日前投票施設コードFrom;
    @BatchParameter(key = KEY_KJMAE_SHISETSU_TO, name = "期日前投票施設コードTo", order = 5)
    private RString 期日前投票施設コードTo;
    @BatchParameter(key = KEY_KJMAE_TOUHYOYMD_FROM, name = "期日前投票投票日From", order = 6)
    private FlexibleDate 期日前投票投票日From;
    @BatchParameter(key = KEY_KJMAE_TOUHYOYMD_TO, name = "期日前投票投票日To", order = 7)
    private FlexibleDate 期日前投票投票日To;
    @BatchParameter(key = KEY_FUZAISHANIPPO, name = "不在者投票日報", order = 8)
    private Boolean 不在者投票日報;
    @BatchParameter(key = KEY_FUZAISHANIPPO_KOFU, name = "不在者交付日報", order = 9)
    private Boolean 不在者交付日報;
    @BatchParameter(key = KEY_FUZAISHA_KOFUYMD_FROM, name = "不在者交付日From", order = 10)
    private FlexibleDate 不在者交付日From;
    @BatchParameter(key = KEY_FUZAISHA_KOFUYMD_TO, name = "不在者交付日To", order = 11)
    private FlexibleDate 不在者交付日To;
    @BatchParameter(key = KEY_FUZAISHANIPPO_JURI, name = "不在者受理日報", order = 12)
    private Boolean 不在者受理日報;
    @BatchParameter(key = KEY_FUZAISHA_JURIYMD_FROM, name = "不在者受理日From", order = 13)
    private FlexibleDate 不在者受理日From;
    @BatchParameter(key = KEY_FUZAISHA_JURIYMD_TO, name = "不在者受理日To", order = 14)
    private FlexibleDate 不在者受理日To;
    @BatchParameter(key = KEY_KMTOHYOSHA, name = "期日前投票者一覧表", order = 15)
    private Boolean 期日前投票者一覧表;
    @BatchParameter(key = KEY_KJMTHSHA_TOHYOCODE_FROM, name = "期日前投票者一覧表投票区From", order = 16)
    private RString 期日前投票者一覧表投票区From;
    @BatchParameter(key = KEY_KJMTHSHA_TOHYOCODE_TO, name = "期日前投票者一覧表投票区To", order = 17)
    private RString 期日前投票者一覧表投票区To;
    @BatchParameter(key = KEY_KJMTHSHA_SHISETSU_FROM, name = "期日前投票者一覧表施設コードFrom", order = 18)
    private RString 期日前投票者一覧表施設コードFrom;
    @BatchParameter(key = KEY_KJMTHSHA_SHISETSU_TO, name = "期日前投票者一覧表施設コードTo", order = 19)
    private RString 期日前投票者一覧表施設コードTo;
    @BatchParameter(key = KEY_KJMTHSHA_KJMAE_THYMD_FROM, name = "期日前投票者一覧表期日前投票日From", order = 20)
    private FlexibleDate 期日前投票者一覧表期日前投票日From;
    @BatchParameter(key = KEY_KJMTHSHA_KJMAE_THYMD_TO, name = "期日前投票者一覧表期日前投票日To", order = 21)
    private FlexibleDate 期日前投票者一覧表期日前投票日To;
    @BatchParameter(key = KEY_KJMTHSHA_TOHYOTIME_FROM, name = "期日前投票者一覧表投票時刻From", order = 22)
    private RTime 期日前投票者一覧表投票時刻From;
    @BatchParameter(key = KEY_KJMTHSHA_TOHYOTIME_TO, name = "期日前投票者一覧表投票時刻To", order = 23)
    private RTime 期日前投票者一覧表投票時刻To;
    @BatchParameter(key = KEY_KJMTHSHA_DAIRITOHYO_FLG, name = "期日前投票者一覧表代理投票のみ", order = 24)
    private Boolean 期日前投票者一覧表代理投票のみ;
    @BatchParameter(key = KEY_KJMTHSHA_TENJI_FLG, name = "期日前投票者一覧表点字投票のみ", order = 25)
    private Boolean 期日前投票者一覧表点字投票のみ;
    @BatchParameter(key = KEY_KJMTHSHA_KIKEN_FLG, name = "期日前投票者一覧表棄権のみ", order = 26)
    private Boolean 期日前投票者一覧表棄権のみ;
    @BatchParameter(key = KEY_KJMTHSHA_UKETUKEKYOHI_FLG, name = "期日前投票者一覧表受付拒否のみ", order = 27)
    private Boolean 期日前投票者一覧表受付拒否のみ;
    @BatchParameter(key = KEY_KJMTHSHA_KATITOHYOU_FLG, name = "期日前投票者一覧表仮投票のみ", order = 28)
    private Boolean 期日前投票者一覧表仮投票のみ;
    @BatchParameter(key = KEY_FUZAISHATOHYOSHA, name = "不在者投票者一覧表", order = 29)
    private Boolean 不在者投票者一覧表;
    @BatchParameter(key = KEY_FZSTHSHA_TOHYOCODE_FROM, name = "不在者投票者一覧表投票区From", order = 30)
    private RString 不在者投票者一覧表投票区From;
    @BatchParameter(key = KEY_FZSTHSHA_TOHYOCODE_TO, name = "不在者投票者一覧表投票区To", order = 31)
    private RString 不在者投票者一覧表投票区To;
    @BatchParameter(key = KEY_FZSTHSHA_SHISETSU_FROM, name = "不在者投票者一覧表施設コードFrom", order = 32)
    private RString 不在者投票者一覧表施設コードFrom;
    @BatchParameter(key = KEY_FZSTHSHA_SHISETSU_TO, name = "不在者投票者一覧表施設コードTo", order = 33)
    private RString 不在者投票者一覧表施設コードTo;
    @BatchParameter(key = KEY_FZSTHSHA_KOFUYMD_FROM, name = "不在者投票者一覧表交付日From", order = 34)
    private FlexibleDate 不在者投票者一覧表交付日From;
    @BatchParameter(key = KEY_FZSTHSHA_KOFUYMD_TO, name = "不在者投票者一覧表交付日To", order = 35)
    private FlexibleDate 不在者投票者一覧表交付日To;
    @BatchParameter(key = KEY_FZSTHSHA_JURIYMD_FROM, name = "不在者投票者一覧表受理日From", order = 36)
    private FlexibleDate 不在者投票者一覧表受理日From;
    @BatchParameter(key = KEY_FZSTHSHA_JURIYMD_TO, name = "不在者投票者一覧表受理日To", order = 37)
    private FlexibleDate 不在者投票者一覧表受理日To;
    @BatchParameter(key = KEY_FZSTHSHA_JURITIME_FROM, name = "不在者投票者一覧表受理時刻From", order = 38)
    private RTime 不在者投票者一覧表受理時刻From;
    @BatchParameter(key = KEY_FZSTHSHA_JURITIME_TO, name = "不在者投票者一覧表受理時刻To", order = 39)
    private RTime 不在者投票者一覧表受理時刻To;
    @BatchParameter(key = KEY_FZSTHSHA_SEIKYU_FLG, name = "不在者投票者一覧表請求のみ", order = 40)
    private Boolean 不在者投票者一覧表請求のみ;
    @BatchParameter(key = KEY_FZSTHSHA_MICHAKUSHA_FLG, name = "不在者投票者一覧表未着者のみ", order = 41)
    private Boolean 不在者投票者一覧表未着者のみ;
    @BatchParameter(key = KEY_FZSTHSHA_DAIRITOHYO_FLG, name = "不在者投票者一覧表代理投票のみ", order = 42)
    private Boolean 不在者投票者一覧表代理投票のみ;
    @BatchParameter(key = KEY_FZSTHSHA_TENJI_FLG, name = "不在者投票者一覧表点字投票のみ", order = 43)
    private Boolean 不在者投票者一覧表点字投票のみ;
    @BatchParameter(key = KEY_FZSTHSHA_HENKAN_FLG, name = "不在者投票者一覧表返還のみ", order = 44)
    private Boolean 不在者投票者一覧表返還のみ;
    @BatchParameter(key = KEY_FZSTHSHA_KIKEN_FLG, name = "不在者投票者一覧表棄権のみ", order = 45)
    private Boolean 不在者投票者一覧表棄権のみ;
    @BatchParameter(key = KEY_TOHYOSHALISTSENKYOALL, name = "投票者一覧表", order = 46)
    private Boolean 投票者一覧表;
    @BatchParameter(key = KEY_THS_KJM_AND_FUZAISHA, name = "投票者一覧表混在", order = 47)
    private Boolean 投票者一覧表混在;
    @BatchParameter(key = KEY_THS_TOHYOCODE_FROM, name = "投票者一覧表投票区From", order = 48)
    private RString 投票者一覧表投票区From;
    @BatchParameter(key = KEY_THS_TOHYOCODE_TO, name = "投票者一覧表投票区To", order = 49)
    private RString 投票者一覧表投票区To;
    @BatchParameter(key = KEY_THS_SHISETSU_FROM, name = "投票者一覧表施設コードFrom", order = 50)
    private RString 投票者一覧表施設コードFrom;
    @BatchParameter(key = KEY_THS_SHISETSU_TO, name = "投票者一覧表施設コードTo", order = 51)
    private RString 投票者一覧表施設コードTo;
    @BatchParameter(key = KEY_THS_KM, name = "投票者一覧表期日前投票", order = 52)
    private Boolean 投票者一覧表期日前投票;
    @BatchParameter(key = KEY_THS_KJM_TOHYOUJUYU, name = "投票者一覧表投票事由", order = 53)
    private RString 投票者一覧表投票事由;
    @BatchParameter(key = KEY_THS_KJM_TOUHYOYMD_FROM, name = "投票者一覧表期日前投票日From", order = 54)
    private FlexibleDate 投票者一覧表期日前投票日From;
    @BatchParameter(key = KEY_THS_KJM_TOUHYOYMD__TO, name = "投票者一覧表期日前投票日To", order = 55)
    private FlexibleDate 投票者一覧表期日前投票日To;
    @BatchParameter(key = KEY_THS_KJM_TOHYOTIME_FROM, name = "投票者一覧表投票時刻From", order = 56)
    private RTime 投票者一覧表投票時刻From;
    @BatchParameter(key = KEY_THS_KJM_TOHYOTIME_TO, name = "投票者一覧表投票時刻To", order = 57)
    private RTime 投票者一覧表投票時刻To;
    @BatchParameter(key = KEY_THS_KJM_DAIRITOHYO_FLG, name = "投票者一覧表期日前代理投票のみ", order = 58)
    private Boolean 投票者一覧表期日前代理投票のみ;
    @BatchParameter(key = KEY_THS_KJM_TENJI_FLG, name = "投票者一覧表期日前点字投票のみ", order = 59)
    private Boolean 投票者一覧表期日前点字投票のみ;
    @BatchParameter(key = KEY_THS_KJM_KIKEN_FLG, name = "投票者一覧表期日前棄権のみ", order = 60)
    private Boolean 投票者一覧表期日前棄権のみ;
    @BatchParameter(key = KEY_THS_KJM_UKETUKEKYOHI_FLG, name = "投票者一覧表期日前受付拒否のみ", order = 61)
    private Boolean 投票者一覧表期日前受付拒否のみ;
    @BatchParameter(key = KEY_THS_KJM_KATITOHYOU_FLG, name = "投票者一覧表期日前仮投票のみ", order = 62)
    private Boolean 投票者一覧表期日前仮投票のみ;
    @BatchParameter(key = KEY_THS_FUZAISHA, name = "投票者一覧表不在者投票", order = 63)
    private Boolean 投票者一覧表不在者投票;
    @BatchParameter(key = KEY_THS_FZS_KOFUYMD_FROM, name = "投票者一覧表交付日From", order = 64)
    private FlexibleDate 投票者一覧表交付日From;
    @BatchParameter(key = KEY_THS_FZS_KOFUYMD_TO, name = "投票者一覧表交付日To", order = 65)
    private FlexibleDate 投票者一覧表交付日To;
    @BatchParameter(key = KEY_THS_FZS_JURIYMD_FROM, name = "投票者一覧表受理日From", order = 66)
    private FlexibleDate 投票者一覧表受理日From;
    @BatchParameter(key = KEY_THS_FZS_JURIYMD_TO, name = "投票者一覧表受理日To", order = 67)
    private FlexibleDate 投票者一覧表受理日To;
    @BatchParameter(key = KEY_THS_FZS_JURITIME_FROM, name = "投票者一覧表受理時刻From", order = 68)
    private RTime 投票者一覧表受理時刻From;
    @BatchParameter(key = KEY_THS_FZS_JURITIME_TO, name = "投票者一覧表受理時刻To", order = 69)
    private RTime 投票者一覧表受理時刻To;
    @BatchParameter(key = KEY_THS_FZS_SEIKYU_FLG, name = "投票者一覧表請求のみ", order = 70)
    private Boolean 投票者一覧表請求のみ;
    @BatchParameter(key = KEY_THS_FZS_MICHAKUSHA_FLG, name = "投票者一覧表不在者未着者のみ", order = 71)
    private Boolean 投票者一覧表不在者未着者のみ;
    @BatchParameter(key = KEY_THS_FZS_DAIRITOHYO_FLG, name = "投票者一覧表不在者代理投票のみ", order = 72)
    private Boolean 投票者一覧表不在者代理投票のみ;
    @BatchParameter(key = KEY_THS_FZS_TENJI_FLG, name = "投票者一覧表不在者点字投票のみ", order = 73)
    private Boolean 投票者一覧表不在者点字投票のみ;
    @BatchParameter(key = KEY_THS_FZS_HENKAN_FLG, name = "投票者一覧表不在者返還のみ", order = 74)
    private Boolean 投票者一覧表不在者返還のみ;
    @BatchParameter(key = KEY_THS_FZS_KIKEN_FLG, name = "投票者一覧表不在者棄権のみ", order = 75)
    private Boolean 投票者一覧表不在者棄権のみ;
    @BatchParameter(key = KEY_TOHYOSJIYUCHOSHO, name = "投票事由調書", order = 76)
    private Boolean 投票事由調書;
    @BatchParameter(key = KEY_THSSHO_KM, name = "投票事由調書期日前投票", order = 77)
    private Boolean 投票事由調書期日前投票;
    @BatchParameter(key = KEY_THSSHO_KM_TOUHYOYMD_FROM, name = "投票事由調書期日前投票日From", order = 78)
    private FlexibleDate 投票事由調書期日前投票日From;
    @BatchParameter(key = KEY_THSSHO_KM_TOUHYOYMD_TO, name = "投票事由調書期日前投票日To", order = 79)
    private FlexibleDate 投票事由調書期日前投票日To;
    @BatchParameter(key = KEY_THSSHO_FUZAISHA, name = "投票事由調書不在者投票", order = 80)
    private Boolean 投票事由調書不在者投票;
    @BatchParameter(key = KEY_THSSHO_JURIYMD_FROM, name = "投票事由調書受理日From", order = 81)
    private FlexibleDate 投票事由調書受理日From;
    @BatchParameter(key = KEY_THSSHO_JURIYMD_TO, name = "投票事由調書受理日To", order = 82)
    private FlexibleDate 投票事由調書受理日To;
    @BatchParameter(key = KEY_SHUKEI, name = "投票集計整理表", order = 83)
    private Boolean 投票集計整理表;
    @BatchParameter(key = KEY_SHUKEI_TOHYOCODE_FROM, name = "投票集計整理表投票区From", order = 84)
    private RString 投票集計整理表投票区From;
    @BatchParameter(key = KEY_SHUKEI_TOHYOCODE_TO, name = "投票集計整理表投票区To", order = 85)
    private RString 投票集計整理表投票区To;
    @BatchParameter(key = KEY_SHUKEI_JURIYMD, name = "投票集計整理表受理日", order = 86)
    private FlexibleDate 投票集計整理表受理日;

    /**
     * 期日前投票日報ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to期日前投票日報ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 期日前投票日報, false, 投票状況リスト, order順, 改頁項目);
        parameter.set施設コードFr(期日前投票施設コードFrom);
        parameter.set施設コードTo(期日前投票施設コードTo);
        parameter.set投票日Fr(期日前投票投票日From);
        parameter.set投票日To(期日前投票投票日To);
        return parameter;
    }

    /**
     * 不在者投票交付日報ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to不在者投票交付日報ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 不在者投票日報, 不在者交付日報, 投票状況リスト, order順, 改頁項目);
        parameter.set交付日Fr(不在者交付日From);
        parameter.set交付日To(不在者交付日To);
        return parameter;
    }

    /**
     * 不在者投票受理日報ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to不在者投票受理日報ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 不在者投票日報, 不在者受理日報, 投票状況リスト, order順, 改頁項目);
        parameter.set受理日Fr(不在者受理日From);
        parameter.set受理日To(不在者受理日To);
        return parameter;
    }

    /**
     * 期日前投票者一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @param 地方公共団体コード RString
     * @param 地方公共団体コード連番 int
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to期日前投票者一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目, RString 地方公共団体コード, int 地方公共団体コード連番) {
        List<RString> 投票状況リスト = new ArrayList<>();
        if (期日前投票者一覧表棄権のみ) {
            投票状況リスト.add(TohyoJokyo.棄権.getCode());
        }
        if (期日前投票者一覧表受付拒否のみ) {
            投票状況リスト.add(TohyoJokyo.受付拒否.getCode());
        }
        if (期日前投票者一覧表仮投票のみ) {
            投票状況リスト.add(TohyoJokyo.仮投票.getCode());
        }
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 期日前投票者一覧表, false, 投票状況リスト, order順, 改頁項目);
        parameter.set投票区コードFr(期日前投票者一覧表投票区From);
        parameter.set投票区コードTo(期日前投票者一覧表投票区To);
        parameter.set施設コードFr(期日前投票者一覧表施設コードFrom);
        parameter.set施設コードTo(期日前投票者一覧表施設コードTo);
        parameter.set期日前投票日Fr(期日前投票者一覧表期日前投票日From);
        parameter.set期日前投票日To(期日前投票者一覧表期日前投票日To);
        parameter.set投票時刻Fr(期日前投票者一覧表投票時刻From);
        parameter.set投票時刻To(期日前投票者一覧表投票時刻To);
        parameter.set代理投票有フラグ(期日前投票者一覧表代理投票のみ);
        parameter.set点字フラグ(期日前投票者一覧表点字投票のみ);
        parameter.set地方公共団体コード(地方公共団体コード);
        parameter.set地方公共団体コード連番(地方公共団体コード連番);
        return parameter;
    }

    /**
     * 不在者投票者一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @param 地方公共団体コード RString
     * @param 地方公共団体コード連番 int
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to不在者投票者一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目, RString 地方公共団体コード, int 地方公共団体コード連番) {
        List<RString> 投票状況リスト = new ArrayList<>();
        if ((null != 不在者投票者一覧表交付日From && !不在者投票者一覧表交付日From.isEmpty()
                && null != 不在者投票者一覧表交付日To && !不在者投票者一覧表交付日To.isEmpty())
                || 不在者投票者一覧表未着者のみ) {
            投票状況リスト.add(TohyoJokyo.交付.getCode());
        }
        if (null != 不在者投票者一覧表受理日From && !不在者投票者一覧表受理日From.isEmpty()
                && null != 不在者投票者一覧表受理日To && !不在者投票者一覧表受理日To.isEmpty()) {
            投票状況リスト.add(TohyoJokyo.受理.getCode());
        }
        if (不在者投票者一覧表請求のみ) {
            投票状況リスト.add(TohyoJokyo.請求.getCode());
        }
        if (不在者投票者一覧表返還のみ) {
            投票状況リスト.add(TohyoJokyo.返還.getCode());
        }
        if (不在者投票者一覧表棄権のみ) {
            投票状況リスト.add(TohyoJokyo.棄権.getCode());
        }
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 不在者投票者一覧表, false, 投票状況リスト, order順, 改頁項目);
        parameter.set投票区コードFr(不在者投票者一覧表投票区From);
        parameter.set投票区コードTo(不在者投票者一覧表投票区To);
        parameter.set施設コードFr(不在者投票者一覧表施設コードFrom);
        parameter.set施設コードTo(不在者投票者一覧表施設コードTo);
        parameter.set交付日Fr(不在者投票者一覧表交付日From);
        parameter.set交付日To(不在者投票者一覧表交付日To);
        parameter.set受理日Fr(不在者投票者一覧表受理日From);
        parameter.set受理日To(不在者投票者一覧表受理日To);
        parameter.set受理時刻Fr(不在者投票者一覧表受理時刻From);
        parameter.set受理時刻To(不在者投票者一覧表受理時刻To);
        parameter.set代理投票有フラグ(不在者投票者一覧表代理投票のみ);
        parameter.set点字フラグ(不在者投票者一覧表点字投票のみ);
        parameter.set地方公共団体コード(地方公共団体コード);
        parameter.set地方公共団体コード連番(地方公共団体コード連番);
        return parameter;
    }

    /**
     * 投票者一覧期日前不在者投票者一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to投票者一覧期日前不在者投票者一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票者一覧表, 投票者一覧表混在, 投票状況リスト, order順, 改頁項目);
        parameter.set投票区コードFr(投票者一覧表投票区From);
        parameter.set投票区コードTo(投票者一覧表投票区To);
        parameter.set施設コードFr(投票者一覧表施設コードFrom);
        parameter.set施設コードTo(投票者一覧表施設コードTo);
        return parameter;
    }

    /**
     * 投票者一覧期日前投票者一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to投票者一覧期日前投票者一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        投票状況リスト.add(TohyoJokyo.期日前.getCode());
        if (投票者一覧表期日前棄権のみ) {
            投票状況リスト.add(TohyoJokyo.棄権.getCode());
        }
        if (投票者一覧表期日前受付拒否のみ) {
            投票状況リスト.add(TohyoJokyo.受付拒否.getCode());
        }
        if (投票者一覧表期日前仮投票のみ) {
            投票状況リスト.add(TohyoJokyo.仮投票.getCode());
        }
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票者一覧表, 投票者一覧表期日前投票, 投票状況リスト, order順, 改頁項目);
        parameter.set投票事由コード(投票者一覧表投票事由);
        parameter.set期日前投票日Fr(投票者一覧表期日前投票日From);
        parameter.set期日前投票日To(投票者一覧表期日前投票日To);
        parameter.set投票時刻Fr(投票者一覧表投票時刻From);
        parameter.set投票時刻To(投票者一覧表投票時刻To);
        parameter.set代理投票有フラグ(投票者一覧表期日前代理投票のみ);
        parameter.set点字フラグ(投票者一覧表期日前点字投票のみ);
        return parameter;
    }

    /**
     * 投票者一覧不在者投票者一覧表ProcessParameterの変換のメソッドそうしたら
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to投票者一覧不在者投票者一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        if ((null != 投票者一覧表交付日From && !投票者一覧表交付日From.isEmpty()
                && null != 投票者一覧表交付日To && !投票者一覧表交付日To.isEmpty())) {
            投票状況リスト.add(TohyoJokyo.交付.getCode());
        }
        if (null != 投票者一覧表受理日From && !投票者一覧表受理日From.isEmpty()
                && null != 投票者一覧表受理日To && !投票者一覧表受理日To.isEmpty()) {
            投票状況リスト.add(TohyoJokyo.受理.getCode());
        }
        if (投票者一覧表請求のみ) {
            投票状況リスト.add(TohyoJokyo.請求.getCode());
        }
        if (投票者一覧表不在者未着者のみ) {
            投票状況リスト.add(TohyoJokyo.交付.getCode());
        }
        if (投票者一覧表不在者返還のみ) {
            投票状況リスト.add(TohyoJokyo.返還.getCode());
        }
        if (投票者一覧表不在者棄権のみ) {
            投票状況リスト.add(TohyoJokyo.棄権.getCode());
        }

        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票者一覧表, 投票者一覧表不在者投票, 投票状況リスト, order順, 改頁項目);
        parameter.set交付日Fr(投票者一覧表交付日From);
        parameter.set交付日To(投票者一覧表交付日To);
        parameter.set受理日Fr(投票者一覧表受理日From);
        parameter.set受理日To(投票者一覧表受理日To);
        parameter.set受理時刻Fr(投票者一覧表受理時刻From);
        parameter.set受理時刻To(投票者一覧表受理時刻To);
        parameter.set代理投票有フラグ(投票者一覧表不在者代理投票のみ);
        parameter.set点字フラグ(投票者一覧表不在者点字投票のみ);
        return parameter;
    }

    /**
     * 期日前投票の事由に関する調書ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to期日前投票の事由に関する調書ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票事由調書, 投票事由調書期日前投票, 投票状況リスト, order順, 改頁項目);
        parameter.set期日前投票日Fr(投票事由調書期日前投票日From);
        parameter.set期日前投票日To(投票事由調書期日前投票日To);
        return parameter;
    }

    /**
     * 不在者投票の事由に関する調書ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to不在者投票の事由に関する調書ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票事由調書, 投票事由調書不在者投票, 投票状況リスト, order順, 改頁項目);
        parameter.set受理日Fr(投票事由調書受理日From);
        parameter.set受理日To(投票事由調書受理日To);
        return parameter;
    }

    /**
     * 投票集計整理表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @return AFABTE503SelectProcessParameter
     */
    public AFABTE503SelectProcessParameter to投票集計整理表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, List<RString> 改頁項目) {
        List<RString> 投票状況リスト = new ArrayList<>();
        AFABTE503SelectProcessParameter parameter = new AFABTE503SelectProcessParameter(searchKey, 無投票選挙も出力する,
                get抄本番号Change(), 投票集計整理表, false, 投票状況リスト, order順, 改頁項目);
        parameter.set投票区コードFr(投票集計整理表投票区From);
        parameter.set投票区コードTo(投票集計整理表投票区To);
        parameter.set受理日(投票集計整理表受理日);
        return parameter;
    }

    private ShohonNo get抄本番号Change() {
        return RString.isNullOrEmpty(抄本番号) ? null : new ShohonNo(抄本番号);

    }

}
