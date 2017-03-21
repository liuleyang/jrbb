/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票資格情報
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class TohyoJokyoJoho {

    private RString 選挙名称;
    private RString 住登内郵便番号;
    private RString 郵便番号;
    private RString 施設情報郵便番号;
    private RString 住登内住所;
    private RString 住登内番地;
    private RString 住登内方書;
    private RString 行政区名;
    private RString 住所;
    private RString 施設情報住所;
    private RString 番地;
    private RString 方書;
    private RString 名称;
    private RString カナ名称;
    private RString 世帯主名;
    private RString 施設名称;
    private RString 施設宛名;
    private ShikibetsuCode 識別コード;
    private RString 投票区コード;
    private RString 頁;
    private RString 行;
    private RDate 生年月日;
    private RString 施設コード;
    private RString 性別コード;
    private RString 施設種別;
    private RString 通し番号;
    private RString 住登内町域コード;
    private RString 行政区コード;
    private RString 地区コード１;
    private RString 地区コード２;
    private RString 地区コード３;
    private RString 地区名１;
    private RString 地区名２;
    private RString 地区名３;
    private RString 世帯コード;
    private RString 抄本名;
    private RString 帳票出力た郵便番号;
    private RString 帳票出力た住所;
    private RString 施設情報_電話番号;
    private RString 住民種別コード;
    private RDate 消除異動年月日;
    private RDate 登録届出年月日;

    /**
     * 抄本名を返します。
     *
     * @return 抄本名 RString
     */
    public RString get抄本名() {
        return this.抄本名;
    }

    /**
     * 帳票出力た郵便番号を返します。
     *
     * @return 帳票出力た郵便番号 RString
     */
    public RString get帳票出力た郵便番号() {
        return this.帳票出力た郵便番号;
    }

    /**
     * 帳票出力た住所を返します。
     *
     * @return 帳票出力た住所 RString
     */
    public RString get帳票出力た住所() {
        return this.帳票出力た住所;
    }

    /**
     * 抄本名を設定します。
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
    }

    /**
     * 帳票出力た郵便番号を設定します。
     *
     * @param 帳票出力た郵便番号 RString
     */
    public void set帳票出力た郵便番号(RString 帳票出力た郵便番号) {
        this.帳票出力た郵便番号 = 帳票出力た郵便番号;
    }

    /**
     * 帳票出力た住所を設定します。
     *
     * @param 帳票出力た住所 RString
     */
    public void set帳票出力た住所(RString 帳票出力た住所) {
        this.帳票出力た住所 = 帳票出力た住所;
    }

    /**
     * 登録届出年月日を設定します。
     *
     * @param 登録届出年月日 RDate
     */
    public void set登録届出年月日(RDate 登録届出年月日) {
        this.登録届出年月日 = 登録届出年月日;
    }

    /**
     * 登録届出年月日
     *
     * @return 登録届出年月日 RDate
     */
    public RDate get登録届出年月日() {
        return 登録届出年月日;
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
     * 住民種別コードを返します。
     *
     * @return 住民種別コード RString
     */
    public RString get住民種別コード() {
        return 住民種別コード;
    }

    /**
     * 施設情報_電話番号を設定します。
     *
     * @param 施設情報_電話番号 RString
     */
    public void set施設情報_電話番号(RString 施設情報_電話番号) {
        this.施設情報_電話番号 = 施設情報_電話番号;
    }

    /**
     * 施設情報_電話番号を返します。
     *
     * @return 施設情報_電話番号 RString
     */
    public RString get施設情報_電話番号() {
        return 施設情報_電話番号;
    }

    /**
     * 消除異動年月日を設定します。
     *
     * @param 消除異動年月日 RDate
     */
    public void set消除異動年月日(RDate 消除異動年月日) {
        this.消除異動年月日 = 消除異動年月日;
    }

    /**
     * 消除異動年月日を返します。
     *
     * @return 消除異動年月日 RDate
     */
    public RDate get消除異動年月日() {
        return 消除異動年月日;
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
     * 世帯コードを返します。
     *
     * @return 世帯コード RString
     */
    public RString get世帯コード() {
        return 世帯コード;
    }

    /**
     * 施設情報郵便番号を設定します。
     *
     * @param 施設情報郵便番号 RString
     */
    public void set施設情報郵便番号(RString 施設情報郵便番号) {
        this.施設情報郵便番号 = 施設情報郵便番号;
    }

    /**
     * 施設情報郵便番号を返します。
     *
     * @return 施設情報郵便番号 RString
     */
    public RString get施設情報郵便番号() {
        return this.施設情報郵便番号;
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号 RString
     */
    public RString get通し番号() {
        return this.通し番号;
    }

    /**
     * 住登内町域コードを返します。
     *
     * @return 住登内町域コード RString
     */
    public RString get住登内町域コード() {
        return this.住登内町域コード;
    }

    /**
     * 行政区コードを返します。
     *
     * @return 行政区コード RString
     */
    public RString get行政区コード() {
        return this.行政区コード;
    }

    /**
     * 地区コード１を返します。
     *
     * @return 地区コード１ RString
     */
    public RString get地区コード１() {
        return this.地区コード１;
    }

    /**
     * 地区コード２を返します。
     *
     * @return 地区コード２ RString
     */
    public RString get地区コード２() {
        return this.地区コード２;
    }

    /**
     * 地区コード３を返します。
     *
     * @return 地区コード３ RString
     */
    public RString get地区コード３() {
        return this.地区コード３;
    }

    /**
     * 地区名１を返します。
     *
     * @return 地区名１ RString
     */
    public RString get地区名１() {
        return this.地区名１;
    }

    /**
     * 地区名２を返します。
     *
     * @return 地区名２ RString
     */
    public RString get地区名２() {
        return this.地区名２;
    }

    /**
     * 地区名３を返します。
     *
     * @return 地区名３ RString
     */
    public RString get地区名３() {
        return this.地区名３;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 RString
     */
    public void set通し番号(RString 通し番号) {
        this.通し番号 = 通し番号;
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
     * 行政区コードを設定します。
     *
     * @param 行政区コード RString
     */
    public void set行政区コード(RString 行政区コード) {
        this.行政区コード = 行政区コード;
    }

    /**
     * 地区コード１を設定します。
     *
     * @param 地区コード１ RString
     */
    public void set地区コード１(RString 地区コード１) {
        this.地区コード１ = 地区コード１;
    }

    /**
     * 地区コード２を設定します。
     *
     * @param 地区コード２ RString
     */
    public void set地区コード２(RString 地区コード２) {
        this.地区コード２ = 地区コード２;
    }

    /**
     * 地区コード３を設定します。
     *
     * @param 地区コード３ RString
     */
    public void set地区コード３(RString 地区コード３) {
        this.地区コード３ = 地区コード３;
    }

    /**
     * 地区名１を設定します。
     *
     * @param 地区名１ RString
     */
    public void set地区名１(RString 地区名１) {
        this.地区名１ = 地区名１;
    }

    /**
     * 地区名２を設定します。
     *
     * @param 地区名２ RString
     */
    public void set地区名２(RString 地区名２) {
        this.地区名２ = 地区名２;
    }

    /**
     * 地区名３を設定します。
     *
     * @param 地区名３ RString
     */
    public void set地区名３(RString 地区名３) {
        this.地区名３ = 地区名３;
    }

    /**
     * 施設情報住所を設定します。
     *
     * @param 施設情報住所 RString
     */
    public void set施設情報住所(RString 施設情報住所) {
        this.施設情報住所 = 施設情報住所;
    }

    /**
     * 施設情報住所を設定します。
     *
     * @return 施設情報住所 RString
     */
    public RString get施設情報住所() {
        return 施設情報住所;
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
     * 頁を設定します。
     *
     * @param 頁 RString
     */
    public void set頁(RString 頁) {
        this.頁 = 頁;
    }

    /**
     * 行を設定します。
     *
     * @param 行 RString
     */
    public void set行(RString 行) {
        this.行 = 行;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 RDate
     */
    public void set生年月日(RDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード RString
     */
    public void set施設コード(RString 施設コード) {
        this.施設コード = 施設コード;
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
     * 施設種別を設定します。
     *
     * @param 施設種別 RString
     */
    public void set施設種別(RString 施設種別) {
        this.施設種別 = 施設種別;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        return this.投票区コード;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 RString
     */
    public RString get頁() {
        return this.頁;
    }

    /**
     * 行を返します。
     *
     * @return 行 RString
     */
    public RString get行() {
        return this.行;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日 RDate
     */
    public RDate get生年月日() {
        return this.生年月日;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return this.施設コード;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード RString
     */
    public RString get性別コード() {
        return this.性別コード;
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別 RString
     */
    public RString get施設種別() {
        return this.施設種別;
    }

    /**
     * 選挙名称を設定します。
     *
     * @param 選挙名称 RString
     */
    public void set選挙名称(RString 選挙名称) {
        this.選挙名称 = 選挙名称;
    }

    /**
     * 住登内郵便番号を設定します。
     *
     * @param 住登内郵便番号 RString
     */
    public void set住登内郵便番号(RString 住登内郵便番号) {
        this.住登内郵便番号 = 住登内郵便番号;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 RString
     */
    public void set郵便番号(RString 郵便番号) {
        this.郵便番号 = 郵便番号;
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
     * 行政区名を設定します。
     *
     * @param 行政区名 RString
     */
    public void set行政区名(RString 行政区名) {
        this.行政区名 = 行政区名;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 RString
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

    /**
     * 番地を設定します。
     *
     * @param 番地 RString
     */
    public void set番地(RString 番地) {
        this.番地 = 番地;
    }

    /**
     * 方書を設定します。
     *
     * @param 方書 RString
     */
    public void set方書(RString 方書) {
        this.方書 = 方書;
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
     * カナ名称を設定します。
     *
     * @param カナ名称 RString
     */
    public void setカナ名称(RString カナ名称) {
        this.カナ名称 = カナ名称;
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
     * 施設名称を設定します。
     *
     * @param 施設名称 RString
     */
    public void set施設名称(RString 施設名称) {
        this.施設名称 = 施設名称;
    }

    /**
     * 施設宛名を設定します。
     *
     * @param 施設宛名 RString
     */
    public void set施設宛名(RString 施設宛名) {
        this.施設宛名 = 施設宛名;
    }

    /**
     * 識別コード を設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称 RString
     */
    public RString get選挙名称() {
        return this.選挙名称;
    }

    /**
     * 住登内郵便番号を返します。
     *
     * @return 住登内郵便番号 RString
     */
    public RString get住登内郵便番号() {
        return this.住登内郵便番号;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号 RString
     */
    public RString get郵便番号() {
        return this.郵便番号;
    }

    /**
     * 住登内住所を返します。
     *
     * @return 住登内住所 RString
     */
    public RString get住登内住所() {
        return this.住登内住所;
    }

    /**
     * 住登内番地を返します。
     *
     * @return 住登内番地 RString
     */
    public RString get住登内番地() {
        return this.住登内番地;
    }

    /**
     * 住登内方書を返します。
     *
     * @return 住登内方書 RString
     */
    public RString get住登内方書() {
        return this.住登内方書;
    }

    /**
     * 行政区名を返します。
     *
     * @return 行政区名 RString
     */
    public RString get行政区名() {
        return this.行政区名;
    }

    /**
     * 住所を返します。
     *
     * @return 住所 RString
     */
    public RString get住所() {
        return this.住所;
    }

    /**
     * 番地を返します。
     *
     * @return 番地 RString
     */
    public RString get番地() {
        return this.番地;
    }

    /**
     * 方書を返します。
     *
     * @return 方書 RString
     */
    public RString get方書() {
        return this.方書;
    }

    /**
     * 名称を返します。
     *
     * @return 名称 RString
     */
    public RString get名称() {
        return this.名称;
    }

    /**
     * カナ名称を返します。
     *
     * @return カナ名称 RString
     */
    public RString getカナ名称() {
        return this.カナ名称;
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名 RString
     */
    public RString get世帯主名() {
        return this.世帯主名;
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称 RString
     */
    public RString get施設名称() {
        return this.施設名称;
    }

    /**
     * 施設宛名を返します。
     *
     * @return 施設宛名 RString
     */
    public RString get施設宛名() {
        return this.施設宛名;
    }

    /**
     * 識別コード を返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return this.識別コード;
    }

}
