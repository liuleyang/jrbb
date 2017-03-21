/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.shisetsusofusho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 施設送付書発行バッチパラメータクラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class AFABTE205BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_MUTOHYOSENTAKU = "無投票選挙も出力する";
    private static final String KEY_HAKKOBANGGOU = "発行番号";
    private static final String KEY_HAKKOHYO = "発行日";
    private static final String KEY_STARTSHISETSUCODE = "施設コード_開始";
    private static final String KEY_ENDSHISETSUCODE = "施設コード_終了";
    private static final String KEY_STARTKOFUYMD = "交付日_開始";
    private static final String KEY_ENDKOFUYMD = "交付日_終了";
    private static final String KEY_SENKYONO = "選挙番号";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_MUTOHYOSENTAKU, name = "無投票選挙も出力する", order = 2)
    private Boolean 無投票選挙も出力する;
    @BatchParameter(key = KEY_HAKKOBANGGOU, name = "発行番号", order = 3)
    private RString 発行番号;
    @BatchParameter(key = KEY_HAKKOHYO, name = "発行日", order = 4)
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_STARTSHISETSUCODE, name = "施設コード_開始", order = 5)
    private RString 施設コード開始;
    @BatchParameter(key = KEY_ENDSHISETSUCODE, name = "施設コード_終了", order = 6)
    private RString 施設コード終了;
    @BatchParameter(key = KEY_STARTKOFUYMD, name = "交付日_開始", order = 7)
    private FlexibleDate 交付日開始;
    @BatchParameter(key = KEY_ENDKOFUYMD, name = "交付日_終了", order = 8)
    private FlexibleDate 交付日終了;
    @BatchParameter(key = KEY_SENKYONO, name = "選挙番号", order = 9)
    private SenkyoNo 選挙番号;

    private RString order順;
    private List<RString> 改ページキーリスト;
    private Integer ページコント;
    private Integer ニンスウコント;
    private List<Decimal> 人数リスト;

    /**
     * AFABTE205BatchPrintProcessParameterの変換のメソッドです。
     *
     * @return AFABTE205BatchPrintProcessParameter
     */
    public AFABTE205BatchPrintProcessParameter toAFABTE205BatchPrintProcessParameter() {
        return new AFABTE205BatchPrintProcessParameter(
                new ShohonNo(抄本番号),
                無投票選挙も出力する == null ? Boolean.FALSE : 無投票選挙も出力する,
                発行番号 == null ? RString.EMPTY : 発行番号,
                発行日 == null ? FlexibleDate.EMPTY : 発行日,
                施設コード開始 == null ? RString.EMPTY : 発行番号,
                施設コード終了 == null ? RString.EMPTY : 発行番号,
                交付日開始 == null ? FlexibleDate.EMPTY : 交付日開始,
                交付日終了 == null ? FlexibleDate.EMPTY : 交付日終了,
                選挙番号);
    }

    /**
     * AFABTE205BatchPrintProcessParameterの変換のメソッドです。
     *
     * @return AFABTE205BatchPrintProcessParameter
     */
    public AFABTE205SelectProcessParameter toAFABTE205SelectProcessParameter() {
        return new AFABTE205SelectProcessParameter(
                施設コード開始 == null ? RString.EMPTY : 発行番号,
                施設コード終了 == null ? RString.EMPTY : 発行番号,
                交付日開始 == null ? FlexibleDate.EMPTY : 交付日開始,
                交付日終了 == null ? FlexibleDate.EMPTY : 交付日終了,
                抄本番号 == null ? new ShohonNo(0) : new ShohonNo(抄本番号),
                RString.EMPTY,
                無投票選挙も出力する == null ? Boolean.FALSE : 無投票選挙も出力する);
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public RString get抄本番号() {
        return 抄本番号;
    }

    /**
     * 無投票選挙も出力するを返します。
     *
     * @return 無投票選挙も出力する
     */
    public Boolean is無投票選挙も出力する() {
        return 無投票選挙も出力する;
    }

    /**
     * 発行番号を返します。
     *
     * @return 発行番号
     */
    public RString get発行番号() {
        return 発行番号;
    }

    /**
     * 発行日を返します。
     *
     * @return 発行日
     */
    public FlexibleDate get発行日() {
        return 発行日;
    }

    /**
     * 施設コード開始を返します。
     *
     * @return 施設コード開始
     */
    public RString get施設コード開始() {
        return 施設コード開始;
    }

    /**
     * 施設コード終了を返します。
     *
     * @return 施設コード終了
     */
    public RString get施設コード終了() {
        return 施設コード終了;
    }

    /**
     * 交付日開始を返します。
     *
     * @return 交付日開始
     */
    public FlexibleDate get交付日開始() {
        return 交付日開始;
    }

    /**
     * 交付日終了を返します。
     *
     * @return 交付日終了
     */
    public FlexibleDate get交付日終了() {
        return 交付日終了;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return 選挙番号;
    }

    /**
     * KEY_SHOHONを返します。
     *
     * @return KEY_SHOHON
     */
    public static String getKEY_SHOHON() {
        return KEY_SHOHON;
    }

    /**
     * KEY_MUTOHYOSENTAKUを返します。
     *
     * @return KEY_MUTOHYOSENTAKU
     */
    public static String getKEY_MUTOHYOSENTAKU() {
        return KEY_MUTOHYOSENTAKU;
    }

    /**
     * KEY_HAKKOBANGGOUを返します。
     *
     * @return KEY_HAKKOBANGGOU
     */
    public static String getKEY_HAKKOBANGGOU() {
        return KEY_HAKKOBANGGOU;
    }

    /**
     * KEY_HAKKOHYOを返します。
     *
     * @return KEY_HAKKOHYO
     */
    public static String getKEY_HAKKOHYO() {
        return KEY_HAKKOHYO;
    }

    /**
     * KEY_STARTSHISETSUCODEを返します。
     *
     * @return KEY_STARTSHISETSUCODE
     */
    public static String getKEY_STARTSHISETSUCODE() {
        return KEY_STARTSHISETSUCODE;
    }

    /**
     * KEY_ENDSHISETSUCODEを返します。
     *
     * @return KEY_ENDSHISETSUCODE
     */
    public static String getKEY_ENDSHISETSUCODE() {
        return KEY_ENDSHISETSUCODE;
    }

    /**
     * KEY_STARTKOFUYMDを返します。
     *
     * @return KEY_STARTKOFUYMD
     */
    public static String getKEY_STARTKOFUYMD() {
        return KEY_STARTKOFUYMD;
    }

    /**
     * KEY_ENDKOFUYMDを返します。
     *
     * @return KEY_ENDKOFUYMD
     */
    public static String getKEY_ENDKOFUYMD() {
        return KEY_ENDKOFUYMD;
    }

    /**
     * KEY_SENKYONOを返します。
     *
     * @return KEY_SENKYONO
     */
    public static String getKEY_SENKYONO() {
        return KEY_SENKYONO;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 RString
     */
    public void set抄本番号(RString 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 無投票選挙も出力するを設定します。
     *
     * @param 無投票選挙も出力する Boolean
     */
    public void set無投票選挙も出力する(Boolean 無投票選挙も出力する) {
        this.無投票選挙も出力する = 無投票選挙も出力する;
    }

    /**
     * 発行番号を設定します。
     *
     * @param 発行番号 RString
     */
    public void set発行番号(RString 発行番号) {
        this.発行番号 = 発行番号;
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 FlexibleDate
     */
    public void set発行日(FlexibleDate 発行日) {
        this.発行日 = 発行日;
    }

    /**
     * 施設コード開始を設定します。
     *
     * @param 施設コード開始 RString
     */
    public void set施設コード開始(RString 施設コード開始) {
        this.施設コード開始 = 施設コード開始;
    }

    /**
     * 施設コード終了を設定します。
     *
     * @param 施設コード終了 RString
     */
    public void set施設コード終了(RString 施設コード終了) {
        this.施設コード終了 = 施設コード終了;
    }

    /**
     * 交付日開始を設定します。
     *
     * @param 交付日開始 FlexibleDate
     */
    public void set交付日開始(FlexibleDate 交付日開始) {
        this.交付日開始 = 交付日開始;
    }

    /**
     * 交付日終了を設定します。
     *
     * @param 交付日終了 FlexibleDate
     */
    public void set交付日終了(FlexibleDate 交付日終了) {
        this.交付日終了 = 交付日終了;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 SenkyoNo
     */
    public void set選挙番号(SenkyoNo 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * order順を返します。
     *
     * @return order順
     */
    public RString getOrder順() {
        return order順;
    }

    /**
     * order順を設定します。
     *
     * @param order順 RString
     */
    public void setOrder順(RString order順) {
        this.order順 = order順;
    }

    /**
     * 改ページキーリストを返します。
     *
     * @return 改ページキーリスト
     */
    public List<RString> get改ページキーリスト() {
        return 改ページキーリスト;
    }

    /**
     * 改ページキーリストを設定します。
     *
     * @param 改ページキーリスト RString
     */
    public void set改ページキーリスト(List<RString> 改ページキーリスト) {
        this.改ページキーリスト = 改ページキーリスト;
    }

    /**
     * ページコントを返します。
     *
     * @return ページコント
     */
    public Integer getページコント() {
        return ページコント;
    }

    /**
     * ページコントを設定します。
     *
     * @param ページコント Integer
     */
    public void setページコント(Integer ページコント) {
        this.ページコント = ページコント;
    }

    /**
     * ニンスウコントを返します。
     *
     * @return ニンスウコント
     */
    public Integer getニンスウコント() {
        return ニンスウコント;
    }

    /**
     * ニンスウコントを設定します。
     *
     * @param ニンスウコント Integer
     */
    public void setニンスウコント(Integer ニンスウコント) {
        this.ニンスウコント = ニンスウコント;
    }

    /**
     * 人数リストを返します。
     *
     * @return 人数リスト
     */
    public List<Decimal> get人数リスト() {
        return 人数リスト;
    }

    /**
     * 人数リストを設定します。
     *
     * @param 人数リスト List<Decimal>
     */
    public void set人数リスト(List<Decimal> 人数リスト) {
        this.人数リスト = 人数リスト;
    }

}
