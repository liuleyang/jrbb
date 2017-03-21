package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListParam {

    private TestDateJouhou テストデータの情報;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private RString 投票区コード;
    private int 頁;
    private int 行;

    /**
     * テストデータの情報
     *
     * @return テストデータの情報 TestDateJouhou
     */
    public TestDateJouhou getテストデータの情報() {
        return テストデータの情報;
    }

    /**
     * 帳票共通ヘッダー
     *
     * @return 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeijiCommonJohoItem get帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    /**
     * 投票区コード
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        return 投票区コード;
    }

    /**
     * 頁
     *
     * @return 頁 int
     */
    public int get頁() {
        return 頁;
    }

    /**
     * 行
     *
     * @return 行 int
     */
    public int get行() {
        return 行;
    }

    /**
     * テストデータの情報
     *
     * @param テストデータの情報 TestDateJouhou
     */
    public void setテストデータの情報(TestDateJouhou テストデータの情報) {
        this.テストデータの情報 = テストデータの情報;
    }

    /**
     * 帳票共通ヘッダー
     *
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public void set帳票共通ヘッダー(TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 投票区コード
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 頁
     *
     * @param 頁 int
     */
    public void set頁(int 頁) {
        this.頁 = 頁;
    }

    /**
     * 行
     *
     * @param 行 int
     */
    public void set行(int 行) {
        this.行 = 行;
    }

}
