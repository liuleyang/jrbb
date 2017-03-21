/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kanryokakunin;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務の処理完了画面のパラメータクラスです。
 *
 */
public class KanryoKakuninParameter implements Serializable {

    private RString メニューID;
    private Boolean 処理結果;
    private RString 投票区コード;
    private RString 冊;
    private int 頁;
    private int 行;
    private ShikibetsuCode 識別コード;
    private RString 氏名;
    private ShohonNo 抄本番号;
    private RString 抄本名;

    /**
     * コンストラクタです。
     */
    public KanryoKakuninParameter() {
    }

    /**
     * メニューIDを取得します。
     *
     * @return メニューID
     */
    public RString getメニューID() {
        return メニューID;
    }

    /**
     * メニューIDを設定します。
     *
     * @param メニューID RString
     */
    public void setメニューID(RString メニューID) {
        this.メニューID = メニューID;
    }

    /**
     * 処理結果を取得します。
     *
     * @return 処理結果
     */
    public Boolean get処理結果() {
        return 処理結果;
    }

    /**
     * 処理結果を設定します。
     *
     * @param 処理結果 Boolean
     */
    public void set処理結果(Boolean 処理結果) {
        this.処理結果 = 処理結果;
    }

    /**
     * 投票区コードを取得します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return 投票区コード;
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
     * 冊を取得します。
     *
     * @return 冊
     */
    public RString get冊() {
        return 冊;
    }

    /**
     * 冊を設定します。
     *
     * @param 冊 RString
     */
    public void set冊(RString 冊) {
        this.冊 = 冊;
    }

    /**
     * 頁を取得します。
     *
     * @return 頁
     */
    public int get頁() {
        return 頁;
    }

    /**
     * 頁を設定します。
     *
     * @param 頁 int
     */
    public void set頁(int 頁) {
        this.頁 = 頁;
    }

    /**
     * 行を取得します。
     *
     * @return 行
     */
    public int get行() {
        return 行;
    }

    /**
     * 行を設定します。
     *
     * @param 行 int
     */
    public void set行(int 行) {
        this.行 = 行;
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
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
     * 抄本番号を取得します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return 抄本番号;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 RString
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 抄本名を取得します。
     *
     * @return 識別コード
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 抄本名を設定します。
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
    }

}
