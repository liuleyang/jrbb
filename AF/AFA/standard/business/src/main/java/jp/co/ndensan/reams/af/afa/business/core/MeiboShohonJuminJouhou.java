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
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminJouhou {

    private RString 帳票タイトル;
    private RString 投票区名;
    private RString 投票区コード;
    private RString 町域コード;
    private RString 住登内住所;
    private RString 住登内番地;
    private RString 住登内方書;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 地区コード１;
    private RString 地区名１;
    private RString 地区コード２;
    private RString 地区名２;
    private RString 地区コード３;
    private RString 地区名３;
    private RString 識別コード;
    private RString 名称;
    private RString カナ名称;
    private RString 生年月日;
    private RString 性別コード;
    private RString 抹消事由コード;
    private RString 抄本名;
    private RString 投票年月日;
    private RString 世帯主;
    private RString 選挙番号;
    private RString 組合名称;
    private RDate 名簿基準年月日;
    private FlexibleDate 規定年齢到達年月日;
    private RString 住民種別;
    private int ページ;
    private RString totalPage;
    private int 帳票フラグ;
    private boolean 投票区変更抹消フラグ;

    private RString key1;
    private RString key2;
    private RString key3;
    private RString key4;

    /**
     * 投票区変更抹消フラグ
     *
     * @param 投票区変更抹消フラグ boolean
     */
    public void set投票区変更抹消フラグ(boolean 投票区変更抹消フラグ) {
        this.投票区変更抹消フラグ = 投票区変更抹消フラグ;
    }

    /**
     * 投票区変更抹消フラグ
     *
     * @return 投票区変更抹消フラグ boolean
     */
    public boolean is投票区変更抹消フラグ() {
        return 投票区変更抹消フラグ;
    }

    /**
     * 組合名称
     *
     * @param 組合名称 RString
     */
    public void set組合名称(RString 組合名称) {
        this.組合名称 = 組合名称;
    }

    /**
     * 組合名称
     *
     * @return 組合名称
     */
    public RString get組合名称() {
        return 組合名称;
    }

    /**
     * 名簿基準年月日
     *
     * @param 名簿基準年月日 RDate
     */
    public void set名簿基準年月日(RDate 名簿基準年月日) {
        this.名簿基準年月日 = 名簿基準年月日;
    }

    /**
     * 名簿基準年月日
     *
     * @return 名簿基準年月日 RDate
     */
    public RDate get名簿基準年月日() {
        return 名簿基準年月日;
    }

    /**
     * 選挙番号
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 選挙番号
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        return 選挙番号;
    }

    /**
     * 世帯主を返します。
     *
     * @return 世帯主
     */
    public RString get世帯主() {
        return 世帯主;
    }

    /**
     * 世帯主
     *
     * @param 世帯主 RString
     */
    public void set世帯主(RString 世帯主) {
        this.世帯主 = 世帯主;
    }

    /**
     * 帳票タイトルを返します。
     *
     * @return 帳票タイトル RString
     */
    public RString get帳票タイトル() {
        return this.帳票タイトル;
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名 RString
     */
    public RString get投票区名() {
        return this.投票区名;
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
     * 町域コードを返します。
     *
     * @return 町域コード RString
     */
    public RString get町域コード() {
        return this.町域コード;
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
     * 行政区コードを返します。
     *
     * @return 行政区コード RString
     */
    public RString get行政区コード() {
        return this.行政区コード;
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
     * 地区コード１を返します。
     *
     * @return 地区コード１ RString
     */
    public RString get地区コード１() {
        return this.地区コード１;
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
     * 地区コード２を返します。
     *
     * @return 地区コード２ RString
     */
    public RString get地区コード２() {
        return this.地区コード２;
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
     * 地区コード３を返します。
     *
     * @return 地区コード３ RString
     */
    public RString get地区コード３() {
        return this.地区コード３;
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
     * 識別コードを返します。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        return this.識別コード;
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
     * 生年月日を返します。
     *
     * @return 生年月日 RString
     */
    public RString get生年月日() {
        return this.生年月日;
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
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード RString
     */
    public RString get抹消事由コード() {
        return this.抹消事由コード;
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名 RString
     */
    public RString get抄本名() {
        return this.抄本名;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日 RString
     */
    public RString get投票年月日() {
        return this.投票年月日;
    }

    /**
     * 住民種別を返します。
     *
     * @return 住民種別 RString
     */
    public RString get住民種別() {
        return this.住民種別;
    }

    /**
     * 規定年齢到達年月日を返します。
     *
     * @return 規定年齢到達年月日 FlexibleDate
     */
    public FlexibleDate get規定年齢到達年月日() {
        return this.規定年齢到達年月日;
    }

    /**
     * ページを返します。
     *
     * @return ページ int
     */
    public int getページ() {
        return this.ページ;
    }

    /**
     * トータルページを返します。
     *
     * @return トータルページ RString
     */
    public RString getTotalPage() {
        return this.totalPage;
    }

    /**
     * 帳票フラグを返します。
     *
     * @return 帳票フラグ int
     */
    public int get帳票フラグ() {
        return this.帳票フラグ;
    }

    /**
     * 帳票タイトルを設定します。
     *
     * @param 帳票タイトル RString
     */
    public void set帳票タイトル(RString 帳票タイトル) {
        this.帳票タイトル = 帳票タイトル;
    }

    /**
     * 投票区名を設定します。
     *
     * @param 投票区名 RString
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
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
     * 町域コードを設定します。
     *
     * @param 町域コード RString
     */
    public void set町域コード(RString 町域コード) {
        this.町域コード = 町域コード;
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
     * 行政区コードを設定します。
     *
     * @param 行政区コード RString
     */
    public void set行政区コード(RString 行政区コード) {
        this.行政区コード = 行政区コード;
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
     * 地区コード１を設定します。
     *
     * @param 地区コード１ RString
     */
    public void set地区コード１(RString 地区コード１) {
        this.地区コード１ = 地区コード１;
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
     * 地区コード２を設定します。
     *
     * @param 地区コード２ RString
     */
    public void set地区コード２(RString 地区コード２) {
        this.地区コード２ = 地区コード２;
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
     * 地区コード３を設定します。
     *
     * @param 地区コード３ RString
     */
    public void set地区コード３(RString 地区コード３) {
        this.地区コード３ = 地区コード３;
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
     * 識別コードを設定します。
     *
     * @param 識別コード RString
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
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
     * 生年月日を設定します。
     *
     * @param 生年月日 RString
     */
    public void set生年月日(RString 生年月日) {
        this.生年月日 = 生年月日;
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
     * 抹消事由コードを設定します。
     *
     * @param 抹消事由コード RString
     */
    public void set抹消事由コード(RString 抹消事由コード) {
        this.抹消事由コード = 抹消事由コード;
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
     * 投票年月日を設定します。
     *
     * @param 投票年月日 RString
     */
    public void set投票年月日(RString 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

    /**
     * 住民種別を設定します。
     *
     * @param 住民種別 RString
     */
    public void set住民種別(RString 住民種別) {
        this.住民種別 = 住民種別;
    }

    /**
     * 規定年齢到達年月日
     *
     * @param 規定年齢到達年月日 FlexibleDate
     */
    public void set規定年齢到達年月日(FlexibleDate 規定年齢到達年月日) {
        this.規定年齢到達年月日 = 規定年齢到達年月日;
    }

    /**
     * ページを設定します。
     *
     * @param ページ int
     */
    public void setページ(int ページ) {
        this.ページ = ページ;
    }

    /**
     * トータルページを設定します。
     *
     * @param totalPage RString
     */
    public void setTotalPage(RString totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 帳票フラグを設定します。
     *
     * @param 帳票フラグ int
     */
    public void set帳票フラグ(int 帳票フラグ) {
        this.帳票フラグ = 帳票フラグ;
    }

    /**
     * key1を設定します。
     *
     * @param key1 RString
     */
    public void setKey1(RString key1) {
        this.key1 = key1;
    }

    /**
     * key1を返します。
     *
     * @return key1 RString
     */
    public RString getKey1() {
        return this.key1;
    }

    /**
     * key2を返します。
     *
     * @return key2 RString
     */
    public RString getKey2() {
        return this.key2;
    }

    /**
     * key2を設定します。
     *
     * @param key2 RString
     */
    public void setKey2(RString key2) {
        this.key2 = key2;
    }

    /**
     * key3を設定します。
     *
     * @param key3 RString
     */
    public void setKey3(RString key3) {
        this.key3 = key3;
    }

    /**
     * key3を返します。
     *
     * @return key3 RString
     */
    public RString getKey3() {
        return this.key3;
    }

    /**
     * key4を設定します。
     *
     * @param key4 RString
     */
    public void setKey4(RString key4) {
        this.key4 = key4;
    }

    /**
     * key4を返します。
     *
     * @return key4 RString
     */
    public RString getKey4() {
        return this.key4;
    }
}
