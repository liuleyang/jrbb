package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class TestDateJouhou {

    private RString 抽出条件;
    private RString 名簿番号;
    private RString 氏名;
    private RString 該当項目;
    private RString 識別コード;
    private RString 選挙種類;
    private RDate 名簿基準年月日;
    private RDate 投票年月日;

    /**
     * 抽出条件を返します。
     *
     * @return 抽出条件 RString
     */
    public RString get抽出条件() {
        return 抽出条件;
    }

    /**
     * 名簿番号を返します。
     *
     * @return 名簿番号 RString
     */
    public RString get名簿番号() {
        return 名簿番号;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名 RString
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * 該当項目を返します。
     *
     * @return 該当項目 RString
     */
    public RString get該当項目() {
        return 該当項目;
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
     * 選挙種類を返します。
     *
     * @return 選挙種類 RString
     */
    public RString get選挙種類() {
        return 選挙種類;
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
     * 投票年月日を返します。
     *
     * @return 投票年月日 RDate
     */
    public RDate get投票年月日() {
        return 投票年月日;
    }

    /**
     * 抽出条件を設定します。
     *
     * @param 抽出条件 RString
     */
    public void set抽出条件(RString 抽出条件) {
        this.抽出条件 = 抽出条件;
    }

    /**
     * 名簿番号を設定します。
     *
     * @param 名簿番号 RString
     */
    public void set名簿番号(RString 名簿番号) {
        this.名簿番号 = 名簿番号;
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 RString
     */
    public void set氏名(RString 氏名) {
        this.氏名 = 氏名;
    }

    /**
     * 該当項目を設定します。
     *
     * @param 該当項目 RString
     */
    public void set該当項目(RString 該当項目) {
        this.該当項目 = 該当項目;
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
     * 選挙種類を設定します。
     *
     * @param 選挙種類 RString
     */
    public void set選挙種類(RString 選挙種類) {
        this.選挙種類 = 選挙種類;
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
     * 投票年月日を設定します。
     *
     * @param 投票年月日 RDate
     */
    public void set投票年月日(RDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

}
