/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補正登録者名簿
 *
 * @reamsid_L AF-0360-051 guancy
 */
public class SenkyoninShikakuInfo {

    private RString 帳票ID;
    private RString 投票区コード;
    private RString 住登内町域コード;
    private RString 世帯コード;
    private RString 住登内住所;
    private RString 住登内番地;
    private RString 住登内方書;
    private RString 名称;
    private RString 性別コード;
    private FlexibleDate 生年月日;
    private RString 識別コード;
    private RString 続柄;
    private RString 世帯主名;
    private RString 住民種別コード;
    private RString 登録事由コード;
    private RString 抹消事由コード;
    private RDate 登録届出年月;
    private RDate 登録異動年月;
    private RDate 名簿登録年月日;
    private RDate 表示年月日;
    private RDate 消除届出年月;
    private RDate 消除異動年月;
    private RDate 抹消年月日;
    private boolean 空白行_フラグ;
    private boolean 合計行_フラグ;

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID RString
     */
    public RString get帳票ID() {
        return 帳票ID;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        return 投票区コード;
    }

    /**
     * 住登内町域コードを返します。
     *
     * @return 住登内町域コード RString
     */
    public RString get住登内町域コード() {
        return 住登内町域コード;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード RString
     */
    public RString get世帯コード() {
        return 世帯コード;
    }

    /**
     * 住登内住所を返します。
     *
     * @return 住登内住所 RString
     */
    public RString get住登内住所() {
        return 住登内住所;
    }

    /**
     * 住登内番地を返します。
     *
     * @return 住登内番地 RString
     */
    public RString get住登内番地() {
        return 住登内番地;
    }

    /**
     * 住登内方書を返します。
     *
     * @return 住登内方書 RString
     */
    public RString get住登内方書() {
        return 住登内方書;
    }

    /**
     * 名称を返します。
     *
     * @return 名称 RString
     */
    public RString get名称() {
        return 名称;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード RString
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日 FlexibleDate
     */
    public FlexibleDate get生年月日() {
        return 生年月日;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * 続柄を返します。
     *
     * @return 続柄 RString
     */
    public RString get続柄() {
        return 続柄;
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名 RString
     */
    public RString get世帯主名() {
        return 世帯主名;
    }

    /**
     * 住民種別コードを返します。
     *
     * @return 住民種別コード RString
     */
    public RString get住民種別コード() {
        return 住民種別コード;
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード RString
     */
    public RString get登録事由コード() {
        return 登録事由コード;
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード RString
     */
    public RString get抹消事由コード() {
        return 抹消事由コード;
    }

    /**
     * 登録届出年月を返します。
     *
     * @return 登録届出年月 RDate
     */
    public RDate get登録届出年月() {
        return 登録届出年月;
    }

    /**
     * 登録異動年月を返します。
     *
     * @return 登録異動年月 RDate
     */
    public RDate get登録異動年月() {
        return 登録異動年月;
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日 RDate
     */
    public RDate get名簿登録年月日() {
        return 名簿登録年月日;
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日 RDate
     */
    public RDate get表示年月日() {
        return 表示年月日;
    }

    /**
     * 消除届出年月を返します。
     *
     * @return 消除届出年月 RDate
     */
    public RDate get消除届出年月() {
        return 消除届出年月;
    }

    /**
     * 消除異動年月を返します。
     *
     * @return 消除異動年月 RDate
     */
    public RDate get消除異動年月() {
        return 消除異動年月;
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日 RDate
     */
    public RDate get抹消年月日() {
        return 抹消年月日;
    }

    /**
     * 空白行_フラグを返します。
     *
     * @return 空白行_フラグ boolean
     */
    public boolean is空白行_フラグ() {
        return 空白行_フラグ;
    }

    /**
     * 合計行_フラグを返します。
     *
     * @return 合計行_フラグ boolean
     */
    public boolean is合計行_フラグ() {
        return 合計行_フラグ;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID RString
     */
    public void set帳票ID(RString 帳票ID) {
        this.帳票ID = 帳票ID;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 住登内町域コードを設定します。
     *
     * @param 住登内町域コード RString
     */
    public void set住登内町域コード(RString 住登内町域コード) {
        this.住登内町域コード = 住登内町域コード;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード RString
     */
    public void set世帯コード(RString 世帯コード) {
        this.世帯コード = 世帯コード;
    }

    /**
     * 住登内住所を設定します。
     *
     * @param 住登内住所 RString
     */
    public void set住登内住所(RString 住登内住所) {
        this.住登内住所 = 住登内住所;
    }

    /**
     * 住登内番地を設定します。
     *
     * @param 住登内番地 RString
     */
    public void set住登内番地(RString 住登内番地) {
        this.住登内番地 = 住登内番地;
    }

    /**
     * 住登内方書を設定します。
     *
     * @param 住登内方書 RString
     */
    public void set住登内方書(RString 住登内方書) {
        this.住登内方書 = 住登内方書;
    }

    /**
     * 名称を設定します。
     *
     * @param 名称 RString
     */
    public void set名称(RString 名称) {
        this.名称 = 名称;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード RString
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 FlexibleDate
     */
    public void set生年月日(FlexibleDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード RString
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 続柄を設定します。
     *
     * @param 続柄 RString
     */
    public void set続柄(RString 続柄) {
        this.続柄 = 続柄;
    }

    /**
     * 世帯主名を設定します。
     *
     * @param 世帯主名 RString
     */
    public void set世帯主名(RString 世帯主名) {
        this.世帯主名 = 世帯主名;
    }

    /**
     * 住民種別コードを設定します。
     *
     * @param 住民種別コード RString
     */
    public void set住民種別コード(RString 住民種別コード) {
        this.住民種別コード = 住民種別コード;
    }

    /**
     * 登録事由コードを設定します。
     *
     * @param 登録事由コード RString
     */
    public void set登録事由コード(RString 登録事由コード) {
        this.登録事由コード = 登録事由コード;
    }

    /**
     * 抹消事由コードを設定します。
     *
     * @param 抹消事由コード RString
     */
    public void set抹消事由コード(RString 抹消事由コード) {
        this.抹消事由コード = 抹消事由コード;
    }

    /**
     * 登録届出年月を設定します。
     *
     * @param 登録届出年月 RDate
     */
    public void set登録届出年月(RDate 登録届出年月) {
        this.登録届出年月 = 登録届出年月;
    }

    /**
     * 登録異動年月を設定します。
     *
     * @param 登録異動年月 RDate
     */
    public void set登録異動年月(RDate 登録異動年月) {
        this.登録異動年月 = 登録異動年月;
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 RDate
     */
    public void set名簿登録年月日(RDate 名簿登録年月日) {
        this.名簿登録年月日 = 名簿登録年月日;
    }

    /**
     * 表示年月日を設定します。
     *
     * @param 表示年月日 RDate
     */
    public void set表示年月日(RDate 表示年月日) {
        this.表示年月日 = 表示年月日;
    }

    /**
     * 消除届出年月を設定します。
     *
     * @param 消除届出年月 RDate
     */
    public void set消除届出年月(RDate 消除届出年月) {
        this.消除届出年月 = 消除届出年月;
    }

    /**
     * 消除異動年月を設定します。
     *
     * @param 消除異動年月 RDate
     */
    public void set消除異動年月(RDate 消除異動年月) {
        this.消除異動年月 = 消除異動年月;
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param 抹消年月日 RDate
     */
    public void set抹消年月日(RDate 抹消年月日) {
        this.抹消年月日 = 抹消年月日;
    }

    /**
     * 空白行_フラグを設定します。
     *
     * @param 空白行_フラグ boolean
     */
    public void set空白行_フラグ(boolean 空白行_フラグ) {
        this.空白行_フラグ = 空白行_フラグ;
    }

    /**
     * 合計行_フラグを設定します。
     *
     * @param 合計行_フラグ boolean
     */
    public void set合計行_フラグ(boolean 合計行_フラグ) {
        this.合計行_フラグ = 合計行_フラグ;
    }

}
