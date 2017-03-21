/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.zenjitsuprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票日前日関連帳票バッチパラメータクラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE504BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHONNO = "抄本番号Param";
    private static final String KEY_SENKYO_OUTFLG = "無投票選挙出力有無";
    private static final String KEY_SENKYOLIST = "選挙名リストParam";
    private static final String KEY_SENKYONOLIST = "選挙番号リストParam";
    private static final String KEY_TOHYOSHUKEI_TOHYOROKU_FROM = "投票集計表投票区from";
    private static final String KEY_TOHYOSHUKEI_TOHYOROKU_TO = "投票集計表投票区to";
    private static final String KEY_TOHYOSHUKEI_JURIYMD_FROM = "投票集計表受理日from";
    private static final String KEY_TOHYOSHUKEI_JURIYMD_TO = "投票集計表受理日to";
    private static final String KEY_TOHYOSHUKEI_OUTFLG = "投票集計表出力有無";
    private static final String KEY_DAIRISHUKEI_KIJITSUCHK = "代理投票集計表期日前投票有無";
    private static final String KEY_DAIRISHUKEI_FUZAISHACHK = "代理投票集計表不在者投票有無";
    private static final String KEY_DAIRISHUKEI_TOHYOROKU_FROM = "代理投票集計表投票区from";
    private static final String KEY_DAIRISHUKEI_TOHYOROKU_TO = "代理投票集計表投票区to";
    private static final String KEY_DAIRISHUKEI_JURIYMD_FROM = "代理投票集計表受理日from";
    private static final String KEY_DAIRISHUKEI_JURIYMD_TO = "代理投票集計表受理日to";
    private static final String KEY_DAIRISHUKEI_OUTFLG = "代理投票集計表出力有無";
    private static final String KEY_NENDAIBETSU_TOHYOROKU_FROM = "年代別投票状況調べ投票区from";
    private static final String KEY_NENDAIBETSU_TOHYOROKU_TO = "年代別投票状況調べ投票区to";
    private static final String KEY_NENDAIBETSU_OUTFLG = "年代別投票状況調べ出力有無";
    private static final String KEY_JIKANBETSU_TOHYOROKU_FROM = "時間別投票状況表投票区from";
    private static final String KEY_JIKANBETSU_TOHYOROKU_TO = "時間別投票状況表投票区to";
    private static final String KEY_JIKANBETSU_OUTFLG = "時間別投票状況表出力有無";
    private static final String KEY_JURIJOKYO_JURIYMD_FROM = "期日前受理状況一覧表受理日from";
    private static final String KEY_JURIJOKYO_JURIYMD_TO = "期日前受理状況一覧表受理日to";
    private static final String KEY_JURIJOKYO_OUTFLG = "期日前受理状況一覧表出力有無";
    private static final String KEY_KOFUICHIRAN_SHISETSU_FROM = "施設交付一覧表施設from";
    private static final String KEY_KOFUICHIRAN_SHISETSU_TO = "施設交付一覧表施設to";
    private static final String KEY_KOFUICHIRAN_KOFUYMD_FROM = "施設交付一覧表交付日from";
    private static final String KEY_KOFUICHIRAN_KOFUYMD_TO = "施設交付一覧表交付日to";
    private static final String KEY_KOFUICHIRAN_OUTFLG = "施設交付一覧表出力有無";
    private static final String KEY_JIMUSHORIBO_KIJITSUCHK = "事務処理簿期日前投票有無";
    private static final String KEY_JIMUSHORIBO_FUZAISHACHK = "事務処理簿不在者投票有無";
    private static final String KEY_JIMUSHORIBO_TOHYOROKU_FROM = "事務処理簿投票区from";
    private static final String KEY_JIMUSHORIBO_TOHYOROKU_TO = "事務処理簿投票区to";
    private static final String KEY_JIMUSHORIBO_OUTFLG = "事務処理簿出力有無";
    private static final String KEY_FUZAISHACHOSHO_INJIFLG = "　不在者投票に関する調書_代理投票者数と点字投票者数を備考欄に印字する有無";
    private static final String KEY_FUZAISHA_TOHYOROKU_FROM = "不在者投票に関する調書投票区from";
    private static final String KEY_FUZAISHA_TOHYOROKU_TO = "不在者投票に関する調書投票区to";
    private static final String KEY_FUZAISHA_OUTFLG = "不在者投票に関する調書出力有無";
    private static final String KEY_KOFUCHOSHO_TOHYOROKU_FROM = "不在者投票用紙調書投票区from";
    private static final String KEY_KOFUCHOSHO_TOHYOROKU_TO = "不在者投票用紙調書投票区to";
    private static final String KEY_KOFUCHOSHO_OUTFLG = "不在者投票用紙調書出力有無";
    private static final String KEY_KANRISHA_TOHYOROKU_FROM = "不在者投票管理者調書投票区from";
    private static final String KEY_KANRISHA_TOHYOROKU_TO = "不在者投票管理者調書投票区to";
    private static final String KEY_KANRISHA_OUTFLG = "不在者投票管理者調書出力有無";
    private static final String KEY_TOROKULIST_TOHYOROKU_FROM = "登録者数リスト投票区from";
    private static final String KEY_TOROKULIST_TOHYOROKU_TO = "登録者数リスト投票区to";
    private static final String KEY_TOROKULIST_SAKUSEIFLG = "登録者数リスト_不在者投票資格者分の作成有無";
    private static final String KEY_TOROKULIST_OUTFLG = "登録者数リスト出力有無";
    private static final String KEY_YUKENLIST_TOHYOROKU_FROM = "有権者数調べ投票区from";
    private static final String KEY_YUKENLIST_TOHYOROKU_TO = "有権者数調べ投票区to";
    private static final String KEY_YUKENLIST_OUTFLG = "有権者数調べ出力有無";
    private static final String KEY_SHOHON_TOHYOROKU_FROM = "選挙人名簿抄本投票区from";
    private static final String KEY_SHOHON_TOHYOROKU_TO = "選挙人名簿抄本投票区to";
    private static final String KEY_SHOHON_OUTFLG = "選挙人名簿抄本出力有無";
    private static final String KEY_SOCHISHO_TOHYOROKU_FROM = "送致書投票区from";
    private static final String KEY_SOCHISHO_TOHYOROKU_TO = "送致書投票区to";
    private static final String KEY_SOCHISHO_INJIFLG = "送致書人数印字有無";
    private static final String KEY_SOCHISHO_OUTFLG = "送致書出力有無";
    private static final String KEY_KIJUNBI = "基準日";
    private static final String KEY_NENREI_KIGENBI = "年齢到達期限日";

    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号Param", order = 1)
    private RString 抄本番号Param;
    @BatchParameter(key = KEY_SENKYO_OUTFLG, name = "無投票選挙出力有無", order = 2)
    private Boolean 無投票選挙出力有無;
    @BatchParameter(key = KEY_SENKYOLIST, name = "選挙名リストParam", order = 3)
    private RString 選挙名リストParam;
    @BatchParameter(key = KEY_SENKYONOLIST, name = "選挙番号リストParam", order = 4)
    private RString 選挙番号リストParam;
    @BatchParameter(key = KEY_TOHYOSHUKEI_TOHYOROKU_FROM, name = "投票集計表投票区from", order = 5)
    private RString 投票集計表投票区from;
    @BatchParameter(key = KEY_TOHYOSHUKEI_TOHYOROKU_TO, name = "投票集計表投票区to", order = 6)
    private RString 投票集計表投票区to;
    @BatchParameter(key = KEY_TOHYOSHUKEI_JURIYMD_FROM, name = "投票集計表受理日from", order = 7)
    private FlexibleDate 投票集計表受理日from;
    @BatchParameter(key = KEY_TOHYOSHUKEI_JURIYMD_TO, name = "投票集計表受理日to", order = 8)
    private FlexibleDate 投票集計表受理日to;
    @BatchParameter(key = KEY_TOHYOSHUKEI_OUTFLG, name = "投票集計表出力有無", order = 9)
    private Boolean 投票集計表出力有無;
    @BatchParameter(key = KEY_DAIRISHUKEI_KIJITSUCHK, name = "代理投票集計表期日前投票有無", order = 10)
    private Boolean 代理投票集計表期日前投票有無;
    @BatchParameter(key = KEY_DAIRISHUKEI_FUZAISHACHK, name = "代理投票集計表不在者投票有無", order = 11)
    private Boolean 代理投票集計表不在者投票有無;
    @BatchParameter(key = KEY_DAIRISHUKEI_TOHYOROKU_FROM, name = "代理投票集計表投票区from", order = 12)
    private RString 代理投票集計表投票区from;
    @BatchParameter(key = KEY_DAIRISHUKEI_TOHYOROKU_TO, name = "代理投票集計表投票区to", order = 13)
    private RString 代理投票集計表投票区to;
    @BatchParameter(key = KEY_DAIRISHUKEI_JURIYMD_FROM, name = "代理投票集計表受理日from", order = 14)
    private FlexibleDate 代理投票集計表受理日from;
    @BatchParameter(key = KEY_DAIRISHUKEI_JURIYMD_TO, name = "代理投票集計表受理日to", order = 15)
    private FlexibleDate 代理投票集計表受理日to;
    @BatchParameter(key = KEY_DAIRISHUKEI_OUTFLG, name = "代理投票集計表出力有無", order = 16)
    private Boolean 代理投票集計表出力有無;
    @BatchParameter(key = KEY_NENDAIBETSU_TOHYOROKU_FROM, name = "年代別投票状況調べ投票区from", order = 17)
    private RString 年代別投票状況調べ投票区from;
    @BatchParameter(key = KEY_NENDAIBETSU_TOHYOROKU_TO, name = "年代別投票状況調べ投票区to", order = 18)
    private RString 年代別投票状況調べ投票区to;
    @BatchParameter(key = KEY_NENDAIBETSU_OUTFLG, name = "年代別投票状況調べ出力有無", order = 19)
    private Boolean 年代別投票状況調べ出力有無;
    @BatchParameter(key = KEY_JIKANBETSU_TOHYOROKU_FROM, name = "時間別投票状況表投票区from", order = 20)
    private RString 時間別投票状況表投票区from;
    @BatchParameter(key = KEY_JIKANBETSU_TOHYOROKU_TO, name = "時間別投票状況表投票区to", order = 21)
    private RString 時間別投票状況表投票区to;
    @BatchParameter(key = KEY_JIKANBETSU_OUTFLG, name = "時間別投票状況表出力有無", order = 22)
    private Boolean 時間別投票状況表出力有無;
    @BatchParameter(key = KEY_JURIJOKYO_JURIYMD_FROM, name = "期日前受理状況一覧表受理日from", order = 23)
    private FlexibleDate 期日前受理状況一覧表受理日from;
    @BatchParameter(key = KEY_JURIJOKYO_JURIYMD_TO, name = "期日前受理状況一覧表受理日to", order = 24)
    private FlexibleDate 期日前受理状況一覧表受理日to;
    @BatchParameter(key = KEY_JURIJOKYO_OUTFLG, name = "期日前受理状況一覧表出力有無", order = 25)
    private Boolean 期日前受理状況一覧表出力有無;
    @BatchParameter(key = KEY_KOFUICHIRAN_SHISETSU_FROM, name = "施設交付一覧表施設from", order = 26)
    private RString 施設交付一覧表施設from;
    @BatchParameter(key = KEY_KOFUICHIRAN_SHISETSU_TO, name = "施設交付一覧表施設to", order = 27)
    private RString 施設交付一覧表施設to;
    @BatchParameter(key = KEY_KOFUICHIRAN_KOFUYMD_FROM, name = "施設交付一覧表交付日from", order = 28)
    private FlexibleDate 施設交付一覧表交付日from;
    @BatchParameter(key = KEY_KOFUICHIRAN_KOFUYMD_TO, name = "施設交付一覧表交付日to", order = 29)
    private FlexibleDate 施設交付一覧表交付日to;
    @BatchParameter(key = KEY_KOFUICHIRAN_OUTFLG, name = "施設交付一覧表出力有無", order = 30)
    private Boolean 施設交付一覧表出力有無;
    @BatchParameter(key = KEY_JIMUSHORIBO_KIJITSUCHK, name = "事務処理簿期日前投票有無", order = 31)
    private Boolean 事務処理簿期日前投票有無;
    @BatchParameter(key = KEY_JIMUSHORIBO_FUZAISHACHK, name = "事務処理簿不在者投票有無", order = 32)
    private Boolean 事務処理簿不在者投票有無;
    @BatchParameter(key = KEY_JIMUSHORIBO_TOHYOROKU_FROM, name = "事務処理簿投票区from", order = 33)
    private RString 事務処理簿投票区from;
    @BatchParameter(key = KEY_JIMUSHORIBO_TOHYOROKU_TO, name = "事務処理簿投票区to", order = 34)
    private RString 事務処理簿投票区to;
    @BatchParameter(key = KEY_JIMUSHORIBO_OUTFLG, name = "事務処理簿出力有無", order = 35)
    private Boolean 事務処理簿出力有無;
    @BatchParameter(key = KEY_FUZAISHACHOSHO_INJIFLG, name = "不在者投票に関する調書_代理投票者数と点字投票者数を備考欄に印字する有無", order = 36)
    private Boolean 不在者投票印字有無;
    @BatchParameter(key = KEY_FUZAISHA_TOHYOROKU_FROM, name = "不在者投票に関する調書投票区from", order = 37)
    private RString 不在者投票投票区from;
    @BatchParameter(key = KEY_FUZAISHA_TOHYOROKU_TO, name = "不在者投票に関する調書投票区to", order = 38)
    private RString 不在者投票投票区to;
    @BatchParameter(key = KEY_FUZAISHA_OUTFLG, name = "不在者投票に関する調書出力有無", order = 39)
    private Boolean 不在者投票出力有無;
    @BatchParameter(key = KEY_KOFUCHOSHO_TOHYOROKU_FROM, name = "不在者投票用紙調書投票区from", order = 40)
    private RString 不在者投票用紙調書投票区from;
    @BatchParameter(key = KEY_KOFUCHOSHO_TOHYOROKU_TO, name = "不在者投票用紙調書投票区to", order = 41)
    private RString 不在者投票用紙調書投票区to;
    @BatchParameter(key = KEY_KOFUCHOSHO_OUTFLG, name = "不在者投票用紙調書出力有無", order = 42)
    private Boolean 不在者投票用紙調書出力有無;
    @BatchParameter(key = KEY_KANRISHA_TOHYOROKU_FROM, name = "不在者投票管理者調書投票区from", order = 43)
    private RString 不在者投票管理者調書投票区from;
    @BatchParameter(key = KEY_KANRISHA_TOHYOROKU_TO, name = "不在者投票管理者調書投票区to", order = 44)
    private RString 不在者投票管理者調書投票区to;
    @BatchParameter(key = KEY_KANRISHA_OUTFLG, name = "不在者投票管理者調書出力有無", order = 45)
    private Boolean 不在者投票管理者調書出力有無;
    @BatchParameter(key = KEY_TOROKULIST_TOHYOROKU_FROM, name = "登録者数リスト投票区from", order = 46)
    private RString 登録者数リスト投票区from;
    @BatchParameter(key = KEY_TOROKULIST_TOHYOROKU_TO, name = "登録者数リスト投票区to", order = 47)
    private RString 登録者数リスト投票区to;
    @BatchParameter(key = KEY_TOROKULIST_SAKUSEIFLG, name = "登録者数リスト_不在者投票資格者分の作成有無", order = 48)
    private Boolean 登録者数リスト作成有無;
    @BatchParameter(key = KEY_TOROKULIST_OUTFLG, name = "登録者数リスト出力有無", order = 49)
    private Boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_YUKENLIST_TOHYOROKU_FROM, name = "有権者数調べ投票区from", order = 50)
    private RString 有権者数調べ投票区from;
    @BatchParameter(key = KEY_YUKENLIST_TOHYOROKU_TO, name = "有権者数調べ投票区to", order = 51)
    private RString 有権者数調べ投票区to;
    @BatchParameter(key = KEY_YUKENLIST_OUTFLG, name = "有権者数調べ出力有無", order = 52)
    private Boolean 有権者数調べ出力有無;
    @BatchParameter(key = KEY_SHOHON_TOHYOROKU_FROM, name = "選挙人名簿抄本投票区from", order = 53)
    private RString 選挙人名簿抄本投票区from;
    @BatchParameter(key = KEY_SHOHON_TOHYOROKU_TO, name = "選挙人名簿抄本投票区to", order = 54)
    private RString 選挙人名簿抄本投票区to;
    @BatchParameter(key = KEY_SHOHON_OUTFLG, name = "選挙人名簿抄本出力有無", order = 55)
    private Boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_SOCHISHO_TOHYOROKU_FROM, name = "送致書投票区from", order = 56)
    private RString 送致書投票区from;
    @BatchParameter(key = KEY_SOCHISHO_TOHYOROKU_TO, name = "送致書投票区to", order = 57)
    private RString 送致書投票区to;
    @BatchParameter(key = KEY_SOCHISHO_INJIFLG, name = "送致書人数印字有無", order = 58)
    private Boolean 送致書人数印字有無;
    @BatchParameter(key = KEY_SOCHISHO_OUTFLG, name = "送致書出力有無", order = 59)
    private Boolean 送致書出力有無;
    @BatchParameter(key = KEY_KIJUNBI, name = "基準日", order = 60)
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_NENREI_KIGENBI, name = "年齢到達期限日", order = 61)
    private FlexibleDate 年齢到達期限日;

    private ShohonNo 抄本番号;
    private List<RString> 選挙名リスト = new ArrayList();
    private List<SenkyoNo> 選挙番号リスト = new ArrayList();

    /**
     * 投票集計表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to投票集計表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.期日前.getCode());
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                投票集計表投票区from, 投票集計表投票区to,
                投票集計表受理日from, 投票集計表受理日to,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 代理投票集計表ProcessParameterの変換のメソッド
     *
     * @param 投票状況 TohyoJokyo
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to代理投票集計表ProcessParameter(TohyoJokyo 投票状況, IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = new ArrayList<>();
        投票状況リスト.add(投票状況.getCode());
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                代理投票集計表投票区from, 代理投票集計表投票区to,
                代理投票集計表受理日from, 代理投票集計表受理日to,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 年代別投票状況調べProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to年代別投票状況調べProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                年代別投票状況調べ投票区from, 年代別投票状況調べ投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, null,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 時間別投票状況表合計ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to時間別投票状況表合計ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.期日前.getCode());
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                時間別投票状況表投票区from, 時間別投票状況表投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 時間別投票状況表投票所別ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to時間別投票状況表投票所別ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(TohyoJokyo.期日前.getCode());
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                時間別投票状況表投票区from, 時間別投票状況表投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 受理状況一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to受理状況一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = TohyoJokyo.getTohyoJokyoList();
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                RString.EMPTY, RString.EMPTY,
                期日前受理状況一覧表受理日from, 期日前受理状況一覧表受理日to,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 施設交付一覧表ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to施設交付一覧表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = new ArrayList<>();
        covertParamToList();
        AFABTE504SelectProcessParameter parameter = new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                RString.EMPTY, RString.EMPTY,
                施設交付一覧表交付日from, 施設交付一覧表交付日to,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
        parameter.set施設コードFROM(施設交付一覧表施設from);
        parameter.set施設コードTO(施設交付一覧表施設to);
        parameter.set施設交付一覧FLG(true);
        return parameter;
    }

    /**
     * 事務処理簿ProcessParameterの変換のメソッド
     *
     * @param 投票状況リスト List<RString>
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to事務処理簿ProcessParameter(List<RString> 投票状況リスト, IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        covertParamToList();
        return new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                事務処理簿投票区from, 事務処理簿投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
    }

    /**
     * 不在者投票25号様式ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to不在者投票25号様式ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(TohyoJokyo.受理.getCode(), TohyoJokyo.交付.getCode());
        covertParamToList();
        AFABTE504SelectProcessParameter parameter = new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                不在者投票投票区from, 不在者投票投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
        parameter.set印字有無フラグ(不在者投票印字有無);
        return parameter;
    }

    /**
     * 不在者投票用紙調書ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to不在者投票用紙調書ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(
                TohyoJokyo.請求.getCode(), TohyoJokyo.交付.getCode(),
                TohyoJokyo.受理.getCode(), TohyoJokyo.返還.getCode());
        covertParamToList();
        AFABTE504SelectProcessParameter parameter = new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                不在者投票用紙調書投票区from, 不在者投票用紙調書投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
        parameter.set期日前不在者区分FLG(true);
        return parameter;
    }

    /**
     * 不在者投票管理者調書ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to不在者投票管理者調書ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = Arrays.asList(
                TohyoJokyo.交付.getCode(),
                TohyoJokyo.受理.getCode(),
                TohyoJokyo.返還.getCode());
        covertParamToList();
        AFABTE504SelectProcessParameter parameter = new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                不在者投票管理者調書投票区from, 不在者投票管理者調書投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
        parameter.set投票事由コードFLG(true);
        parameter.set期日前不在者区分FLG(true);
        return parameter;
    }

    /**
     * 登録者数リストProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter to登録者数リストProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        AFABTA101SelectProcessParameter processParameter = new AFABTA101SelectProcessParameter();
        processParameter.setKey(searchKey);
        processParameter.setShohonNo(抄本番号);
        processParameter.setKijunbi(基準日);
        processParameter.setNenreiKigenbi(年齢到達期限日);
        processParameter.set登録者数リスト_投票区From(登録者数リスト投票区from);
        processParameter.set登録者数リスト_投票区To(登録者数リスト投票区to);
        return processParameter;
    }

    /**
     * 有権者数調べProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter to有権者数調べProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        covertParamToList();
        AFABTA101SelectProcessParameter processParameter = new AFABTA101SelectProcessParameter();
        processParameter.setKey(searchKey);
        processParameter.setShohonNo(抄本番号);
        processParameter.setKijunbi(基準日);
        processParameter.setNenreiKigenbi(年齢到達期限日);
        processParameter.set有権者数調べ_投票区From(有権者数調べ投票区from);
        processParameter.set有権者数調べ_投票区To(有権者数調べ投票区to);
        return processParameter;
    }

    /**
     * 選挙人名簿抄本ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter to選挙人名簿抄本ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        AFABTA101SelectProcessParameter processParameter = new AFABTA101SelectProcessParameter();
        processParameter.setKey(searchKey);
        processParameter.setShohonNo(抄本番号);
        processParameter.setKijunbi(基準日);
        processParameter.setNenreiKigenbi(年齢到達期限日);
        processParameter.set投票区From(選挙人名簿抄本投票区from);
        processParameter.set投票区To(選挙人名簿抄本投票区to);
        return processParameter;
    }

    /**
     * 送致書ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     * @return AFABTE504SelectProcessParameter
     */
    public AFABTE504SelectProcessParameter to送致書ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, RString 地方公共団体コード, int 連番) {
        List<RString> 投票状況リスト = new ArrayList<>();
        covertParamToList();
        AFABTE504SelectProcessParameter parameter = new AFABTE504SelectProcessParameter(
                無投票選挙出力有無,
                送致書投票区from, 送致書投票区to,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                選挙番号リスト, 投票状況リスト,
                searchKey, 抄本番号,
                order順, 地方公共団体コード, 連番);
        parameter.set印字有無フラグ(送致書人数印字有無);
        return parameter;
    }

    private void covertParamToList() {
        if (null != 抄本番号Param) {
            抄本番号 = new ShohonNo(抄本番号Param);
        }

        if (null != 選挙名リストParam && !選挙名リスト.isEmpty()) {
            選挙名リスト = 選挙名リストParam.split(",");
        }

        if (null != 選挙番号リストParam && !選挙番号リストParam.isEmpty()) {
            List<RString> 選挙番号リストStr = 選挙番号リストParam.split(",");
            for (RString 選挙番号 : 選挙番号リストStr) {
                選挙番号リスト.add(new SenkyoNo(選挙番号));
            }
        }
    }

    /**
     * 投票日前日関連帳票バッチ出力条件表のパラメータへの変換のメソッド
     *
     * @return 投票日前日関連帳票バッチ出力条件表のパラメータ
     */
    public AFABTE504BatchPrintProcessParameter toAFABTE504BatchPrintProcessParameter() {
        covertParamToList();
        return new AFABTE504BatchPrintProcessParameter(抄本番号,
                無投票選挙出力有無,
                投票集計表出力有無,
                投票集計表投票区from,
                投票集計表投票区to,
                投票集計表受理日from,
                投票集計表受理日to,
                代理投票集計表出力有無,
                代理投票集計表期日前投票有無,
                代理投票集計表不在者投票有無,
                代理投票集計表投票区from,
                代理投票集計表投票区to,
                代理投票集計表受理日from,
                代理投票集計表受理日to,
                年代別投票状況調べ出力有無,
                年代別投票状況調べ投票区from,
                年代別投票状況調べ投票区to,
                時間別投票状況表出力有無,
                時間別投票状況表投票区from,
                時間別投票状況表投票区to,
                期日前受理状況一覧表出力有無,
                期日前受理状況一覧表受理日from,
                期日前受理状況一覧表受理日to,
                施設交付一覧表出力有無,
                施設交付一覧表施設from,
                施設交付一覧表施設to,
                施設交付一覧表交付日from,
                施設交付一覧表交付日to,
                事務処理簿出力有無,
                事務処理簿期日前投票有無,
                事務処理簿不在者投票有無,
                事務処理簿投票区from,
                事務処理簿投票区to,
                不在者投票用紙調書出力有無,
                不在者投票印字有無,
                不在者投票用紙調書投票区from,
                不在者投票用紙調書投票区to,
                不在者投票用紙調書出力有無,
                不在者投票用紙調書投票区from,
                不在者投票用紙調書投票区to,
                不在者投票管理者調書出力有無,
                不在者投票管理者調書投票区from,
                不在者投票管理者調書投票区to,
                登録者数リスト出力有無,
                登録者数リスト出力有無,
                登録者数リスト投票区from,
                登録者数リスト投票区to,
                有権者数調べ出力有無,
                有権者数調べ投票区from,
                有権者数調べ投票区to,
                選挙人名簿抄本出力有無,
                選挙人名簿抄本投票区from,
                選挙人名簿抄本投票区to,
                送致書出力有無,
                送致書投票区from,
                送致書投票区to,
                送致書人数印字有無);
    }
}
