package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区選挙人名簿の情報
 *
 * @reamsid_L AF-0600-030 lis
 */
public class ShohonZaisankuMeiboJoho {

    private RString 帳票タイトル;
    private RString 投票区名;
    private RString 投票区コード;
    private RString 住登内住所;
    private RString 住登内番地;
    private RString 行政区名;
    private RString 住登内方書;
    private RDate 生年月日;
    private RString 性別コード;
    private RString 住民状態コードと続柄;
    private RString 名称;
    private RString 識別コード;
    private RString カナ名称;
    private RString 抹消事由コード;
    private RString 抄本名;
    private RDate 投票年月日;
    private RDate 名簿基準年月日;
    private RString 選挙番号;
    private RString 住民種別コード;
    private RString totalPage;
    private int page;
    private int 帳票フラグ;
    private FlexibleDate 規定年齢到達年月日;
    private RString key1;
    private RString key2;
    private RString key3;
    private RString key4;

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
        return 投票区名;
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
     * 行政区名を返します。
     *
     * @return 行政区名 RString
     */
    public RString get行政区名() {
        return 行政区名;
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
     * 生年月日を返します。
     *
     * @return 生年月日 RDate
     */
    public RDate get生年月日() {
        return 生年月日;
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
     * 住民状態コードと続柄を返します。
     *
     * @return 住民状態コードと続柄 RString
     */
    public RString get住民状態コードと続柄() {
        return 住民状態コードと続柄;
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
     * 識別コードを返します。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * カナ名称を返します。
     *
     * @return カナ名称 RString
     */
    public RString getカナ名称() {
        return カナ名称;
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
     * 抄本名を返します。
     *
     * @return 抄本名 RString
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日 RDate
     */
    public RDate get投票年月日() {
        return 投票年月日;
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日 RDate
     */
    public RDate get名簿基準年月日() {
        return 名簿基準年月日;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        return 選挙番号;
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
     * 帳票フラグを返します。
     *
     * @return 帳票フラグ int
     */
    public int get帳票フラグ() {
        return this.帳票フラグ;
    }

    /**
     * totalPageを返します。
     *
     * @return totalPage RString
     */
    public RString getTotalPage() {
        return totalPage;
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
     * pageを返します。
     *
     * @return page int
     */
    public int getPage() {
        return page;
    }

    /**
     * 規定年齢到達年月日を返します。
     *
     * @return 規定年齢到達年月日 FlexibleDate
     */
    public FlexibleDate get規定年齢到達年月日() {
        return 規定年齢到達年月日;
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
     * 行政区名を設定します。
     *
     * @param 行政区名 RString
     */
    public void set行政区名(RString 行政区名) {
        this.行政区名 = 行政区名;
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
     * 生年月日を設定します。
     *
     * @param 生年月日 RDate
     */
    public void set生年月日(RDate 生年月日) {
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
     * 住民状態コードと続柄を設定します。
     *
     * @param 住民状態コードと続柄 RString
     */
    public void set住民状態コードと続柄(RString 住民状態コードと続柄) {
        this.住民状態コードと続柄 = 住民状態コードと続柄;
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
     * 識別コードを設定します。
     *
     * @param 識別コード RString
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
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
     * @param 投票年月日 RDate
     */
    public void set投票年月日(RDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param 名簿基準年月日 RDate
     */
    public void set名簿基準年月日(RDate 名簿基準年月日) {
        this.名簿基準年月日 = 名簿基準年月日;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
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
     * totalPageを設定します。
     *
     * @param totalPage RString
     */
    public void setTotalPage(RString totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * pageを設定します。
     *
     * @param page int
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 規定年齢到達年月日を設定します。
     *
     * @param 規定年齢到達年月日 FlexibleDate
     */
    public void set規定年齢到達年月日(FlexibleDate 規定年齢到達年月日) {
        this.規定年齢到達年月日 = 規定年齢到達年月日;
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

    /**
     * 帳票フラグを設定します。
     *
     * @param 帳票フラグ int
     */
    public void set帳票フラグ(int 帳票フラグ) {
        this.帳票フラグ = 帳票フラグ;
    }
}
