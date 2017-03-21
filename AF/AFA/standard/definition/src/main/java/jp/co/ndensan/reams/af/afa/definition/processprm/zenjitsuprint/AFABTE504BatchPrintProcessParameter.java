/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票日前日関連帳票バッチ出力条件表のパラメータクラスです。
 *
 * @reamsid_L AF-0280-020 zhanggs
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE504BatchPrintProcessParameter implements IBatchProcessParameter {

    private Long ジョブ番号;
    private ShohonNo 抄本番号;
    private Boolean 無投票選挙有無;
    private Boolean 投票集計表出力有無;
    private RString 投票集計表_投票区from;
    private RString 投票集計表_投票区to;
    private FlexibleDate 投票集計表_受理日from;
    private FlexibleDate 投票集計表_受理日to;
    private Boolean 代理投票集計表出力有無;
    private Boolean 代理投票集計表_出力対象_期日前投票有無;
    private Boolean 代理投票集計表_出力対象_不在者投票有無;
    private RString 代理投票集計表_投票区from;
    private RString 代理投票集計表_投票区to;
    private FlexibleDate 代理投票集計表_受理日from;
    private FlexibleDate 代理投票集計表_受理日to;
    private Boolean 年代別投票状況調べ表出力有無;
    private RString 年代別投票状況調べ表_投票区from;
    private RString 年代別投票状況調べ表_投票区to;
    private Boolean 時間別投票状況表出力有無;
    private RString 時間別投票状況表_投票区from;
    private RString 時間別投票状況表_投票区to;
    private Boolean 受理状況一覧表出力有無;
    private FlexibleDate 期日前_受理状況一覧表_受理日from;
    private FlexibleDate 期日前_受理状況一覧表_受理日to;
    private Boolean 施設交付一覧表出力有無;
    private RString 施設交付一覧表_施設from;
    private RString 施設交付一覧表_施設to;
    private FlexibleDate 施設交付一覧表_交付日from;
    private FlexibleDate 施設交付一覧表_交付日to;
    private Boolean 事務処理簿出力有無;
    private Boolean 事務処理簿_出力対象_期日前投票有無;
    private Boolean 事務処理簿_出力対象_不在者投票有無;
    private RString 事務処理簿_投票区from;
    private RString 事務処理簿_投票区to;
    private Boolean 不在者投票に関する調書_25号様式出力有無;
    private Boolean 不在者投票に関する調書_備考欄印字する有無;
    private RString 不在者投票に関する調書投票区from;
    private RString 不在者投票に関する調書投票区to;
    private Boolean 不在者投票用紙等の調書出力有無;
    private RString 不在者投票用紙等の調書_投票区from;
    private RString 不在者投票用紙等の調書_投票区to;
    private Boolean 不在者投票管理者別の調書出力有無;
    private RString 不在者投票管理者別の調書_投票区from;
    private RString 不在者投票管理者別の調書_投票区to;
    private Boolean 登録者数リスト出力有無;
    private Boolean 登録者数リスト_不在者投票資格者分出力有無;
    private RString 登録者数リスト_投票区from;
    private RString 登録者数リスト_投票区to;
    private Boolean 有権者数調べ出力有無;
    private RString 有権者数調べ_投票区from;
    private RString 有権者数調べ_投票区to;
    private Boolean 選挙人名簿抄本出力有無;
    private RString 選挙人名簿抄本_投票区from;
    private RString 選挙人名簿抄本_投票区to;
    private Boolean 送致書出力有無;
    private RString 送致書_投票区from;
    private RString 送致書_投票区to;
    private Boolean 送致書_人数を印字しない有無;

    private Integer 投票集計表出力数;
    private Integer 代理投票集計表_期日前出力数;
    private Integer 代理投票集計表_不在者出力数;
    private Integer 年代別投票状況調べ表出力数;
    private Integer 時間別投票状況表合計出力数;
    private Integer 時間別投票状況表投票所別出力数;
    private Integer 受理状況一覧表出力数;
    private Integer 施設交付一覧表出力数;
    private Integer 事務処理簿_期日前出力数;
    private Integer 事務処理簿_不在者出力数;
    private Integer 不在者投票に関する調書_25号様式出力数;
    private Integer 不在者投票用紙等の調書出力数;
    private Integer 不在者投票管理者別の調書出力数;
    private Integer 登録者数リスト出力数;
    private Integer 登録者数リスト_不在者投票資格者分出力数;
    private Integer 有権者数調べ出力数;
    private Integer 選挙人名簿抄本出力数;
    private Integer 送致書出力数;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 無投票選挙有無 Boolean
     * @param 投票集計表出力有無 Boolean
     * @param 投票集計表_投票区from RString
     * @param 投票集計表_投票区to RString
     * @param 投票集計表_受理日from FlexibleDate
     * @param 投票集計表_受理日to FlexibleDate
     * @param 代理投票集計表出力有無 Boolean
     * @param 代理投票集計表_出力対象_期日前投票有無 Boolean
     * @param 代理投票集計表_出力対象_不在者投票有無 Boolean
     * @param 代理投票集計表_投票区from RString
     * @param 代理投票集計表_投票区to RString
     * @param 代理投票集計表_受理日from FlexibleDate
     * @param 代理投票集計表_受理日to FlexibleDate
     * @param 年代別投票状況調べ表出力有無 Boolean
     * @param 年代別投票状況調べ表_投票区from RString
     * @param 年代別投票状況調べ表_投票区to RString
     * @param 時間別投票状況表出力有無 Boolean
     * @param 時間別投票状況表_投票区from RString
     * @param 時間別投票状況表_投票区to RString
     * @param 受理状況一覧表出力有無 Boolean
     * @param 期日前_受理状況一覧表_受理日from FlexibleDate
     * @param 期日前_受理状況一覧表_受理日to FlexibleDate
     * @param 施設交付一覧表出力有無 Boolean
     * @param 施設交付一覧表_施設from RString
     * @param 施設交付一覧表_施設to RString
     * @param 施設交付一覧表_交付日from FlexibleDate
     * @param 施設交付一覧表_交付日to FlexibleDate
     * @param 事務処理簿出力有無 Boolean
     * @param 事務処理簿_出力対象_期日前投票有無 Boolean
     * @param 事務処理簿_出力対象_不在者投票有無 Boolean
     * @param 事務処理簿_投票区from RString
     * @param 事務処理簿_投票区to RString
     * @param 不在者投票に関する調書_25号様式出力有無 Boolean
     * @param 不在者投票に関する調書_備考欄印字する有無 Boolean
     * @param 不在者投票に関する調書投票区from RString
     * @param 不在者投票に関する調書投票区to RString
     * @param 不在者投票用紙等の調書出力有無 Boolean
     * @param 不在者投票用紙等の調書_投票区from RString
     * @param 不在者投票用紙等の調書_投票区to RString
     * @param 不在者投票管理者別の調書出力有無 Boolean
     * @param 不在者投票管理者別の調書_投票区from RString
     * @param 不在者投票管理者別の調書_投票区to RString
     * @param 登録者数リスト出力有無 Boolean
     * @param 登録者数リスト_不在者投票資格者分出力有無 Boolean
     * @param 登録者数リスト_投票区from RString
     * @param 登録者数リスト_投票区to RString
     * @param 有権者数調べ出力有無 Boolean
     * @param 有権者数調べ_投票区from RString
     * @param 有権者数調べ_投票区to RString
     * @param 選挙人名簿抄本出力有無 Boolean
     * @param 選挙人名簿抄本_投票区from RString
     * @param 選挙人名簿抄本_投票区to RString
     * @param 送致書出力有無 Boolean
     * @param 送致書_投票区from RString
     * @param 送致書_投票区to RString
     * @param 送致書_人数を印字しない有無 Boolean
     */
    public AFABTE504BatchPrintProcessParameter(
            ShohonNo 抄本番号,
            Boolean 無投票選挙有無,
            Boolean 投票集計表出力有無,
            RString 投票集計表_投票区from,
            RString 投票集計表_投票区to,
            FlexibleDate 投票集計表_受理日from,
            FlexibleDate 投票集計表_受理日to,
            Boolean 代理投票集計表出力有無,
            Boolean 代理投票集計表_出力対象_期日前投票有無,
            Boolean 代理投票集計表_出力対象_不在者投票有無,
            RString 代理投票集計表_投票区from,
            RString 代理投票集計表_投票区to,
            FlexibleDate 代理投票集計表_受理日from,
            FlexibleDate 代理投票集計表_受理日to,
            Boolean 年代別投票状況調べ表出力有無,
            RString 年代別投票状況調べ表_投票区from,
            RString 年代別投票状況調べ表_投票区to,
            Boolean 時間別投票状況表出力有無,
            RString 時間別投票状況表_投票区from,
            RString 時間別投票状況表_投票区to,
            Boolean 受理状況一覧表出力有無,
            FlexibleDate 期日前_受理状況一覧表_受理日from,
            FlexibleDate 期日前_受理状況一覧表_受理日to,
            Boolean 施設交付一覧表出力有無,
            RString 施設交付一覧表_施設from,
            RString 施設交付一覧表_施設to,
            FlexibleDate 施設交付一覧表_交付日from,
            FlexibleDate 施設交付一覧表_交付日to,
            Boolean 事務処理簿出力有無,
            Boolean 事務処理簿_出力対象_期日前投票有無,
            Boolean 事務処理簿_出力対象_不在者投票有無,
            RString 事務処理簿_投票区from,
            RString 事務処理簿_投票区to,
            Boolean 不在者投票に関する調書_25号様式出力有無,
            Boolean 不在者投票に関する調書_備考欄印字する有無,
            RString 不在者投票に関する調書投票区from,
            RString 不在者投票に関する調書投票区to,
            Boolean 不在者投票用紙等の調書出力有無,
            RString 不在者投票用紙等の調書_投票区from,
            RString 不在者投票用紙等の調書_投票区to,
            Boolean 不在者投票管理者別の調書出力有無,
            RString 不在者投票管理者別の調書_投票区from,
            RString 不在者投票管理者別の調書_投票区to,
            Boolean 登録者数リスト出力有無,
            Boolean 登録者数リスト_不在者投票資格者分出力有無,
            RString 登録者数リスト_投票区from,
            RString 登録者数リスト_投票区to,
            Boolean 有権者数調べ出力有無,
            RString 有権者数調べ_投票区from,
            RString 有権者数調べ_投票区to,
            Boolean 選挙人名簿抄本出力有無,
            RString 選挙人名簿抄本_投票区from,
            RString 選挙人名簿抄本_投票区to,
            Boolean 送致書出力有無,
            RString 送致書_投票区from,
            RString 送致書_投票区to,
            Boolean 送致書_人数を印字しない有無) {
        this.抄本番号 = 抄本番号;
        this.無投票選挙有無 = 無投票選挙有無;
        this.投票集計表出力有無 = 投票集計表出力有無;
        this.投票集計表_投票区from = 投票集計表_投票区from;
        this.投票集計表_投票区to = 投票集計表_投票区to;
        this.投票集計表_受理日from = 投票集計表_受理日from;
        this.投票集計表_受理日to = 投票集計表_受理日to;
        this.代理投票集計表出力有無 = 代理投票集計表出力有無;
        this.代理投票集計表_出力対象_期日前投票有無 = 代理投票集計表_出力対象_期日前投票有無;
        this.代理投票集計表_出力対象_不在者投票有無 = 代理投票集計表_出力対象_不在者投票有無;
        this.代理投票集計表_投票区from = 代理投票集計表_投票区from;
        this.代理投票集計表_投票区to = 代理投票集計表_投票区to;
        this.代理投票集計表_受理日from = 代理投票集計表_受理日from;
        this.代理投票集計表_受理日to = 代理投票集計表_受理日to;
        this.年代別投票状況調べ表出力有無 = 年代別投票状況調べ表出力有無;
        this.年代別投票状況調べ表_投票区from = 年代別投票状況調べ表_投票区from;
        this.年代別投票状況調べ表_投票区to = 年代別投票状況調べ表_投票区to;
        this.時間別投票状況表出力有無 = 時間別投票状況表出力有無;
        this.時間別投票状況表_投票区from = 時間別投票状況表_投票区from;
        this.時間別投票状況表_投票区to = 時間別投票状況表_投票区to;
        this.受理状況一覧表出力有無 = 受理状況一覧表出力有無;
        this.期日前_受理状況一覧表_受理日from = 期日前_受理状況一覧表_受理日from;
        this.期日前_受理状況一覧表_受理日to = 期日前_受理状況一覧表_受理日to;
        this.施設交付一覧表出力有無 = 施設交付一覧表出力有無;
        this.施設交付一覧表_施設from = 施設交付一覧表_施設from;
        this.施設交付一覧表_施設to = 施設交付一覧表_施設to;
        this.施設交付一覧表_交付日from = 施設交付一覧表_交付日from;
        this.施設交付一覧表_交付日to = 施設交付一覧表_交付日to;
        this.事務処理簿出力有無 = 事務処理簿出力有無;
        this.事務処理簿_出力対象_期日前投票有無 = 事務処理簿_出力対象_期日前投票有無;
        this.事務処理簿_出力対象_不在者投票有無 = 事務処理簿_出力対象_不在者投票有無;
        this.事務処理簿_投票区from = 事務処理簿_投票区from;
        this.事務処理簿_投票区to = 事務処理簿_投票区to;
        this.不在者投票に関する調書_25号様式出力有無 = 不在者投票に関する調書_25号様式出力有無;
        this.不在者投票に関する調書_備考欄印字する有無 = 不在者投票に関する調書_備考欄印字する有無;
        this.不在者投票に関する調書投票区from = 不在者投票に関する調書投票区from;
        this.不在者投票に関する調書投票区to = 不在者投票に関する調書投票区to;
        this.不在者投票用紙等の調書出力有無 = 不在者投票用紙等の調書出力有無;
        this.不在者投票用紙等の調書_投票区from = 不在者投票用紙等の調書_投票区from;
        this.不在者投票用紙等の調書_投票区to = 不在者投票用紙等の調書_投票区to;
        this.不在者投票管理者別の調書出力有無 = 不在者投票管理者別の調書出力有無;
        this.不在者投票管理者別の調書_投票区from = 不在者投票管理者別の調書_投票区from;
        this.不在者投票管理者別の調書_投票区to = 不在者投票管理者別の調書_投票区to;
        this.登録者数リスト出力有無 = 登録者数リスト出力有無;
        this.登録者数リスト_不在者投票資格者分出力有無 = 登録者数リスト_不在者投票資格者分出力有無;
        this.登録者数リスト_投票区from = 登録者数リスト_投票区from;
        this.登録者数リスト_投票区to = 登録者数リスト_投票区to;
        this.有権者数調べ出力有無 = 有権者数調べ出力有無;
        this.有権者数調べ_投票区from = 有権者数調べ_投票区from;
        this.有権者数調べ_投票区to = 有権者数調べ_投票区to;
        this.選挙人名簿抄本出力有無 = 選挙人名簿抄本出力有無;
        this.選挙人名簿抄本_投票区from = 選挙人名簿抄本_投票区from;
        this.選挙人名簿抄本_投票区to = 選挙人名簿抄本_投票区to;
        this.送致書出力有無 = 送致書出力有無;
        this.送致書_投票区from = 送致書_投票区from;
        this.送致書_投票区to = 送致書_投票区to;
        this.送致書_人数を印字しない有無 = 送致書_人数を印字しない有無;
    }
}
