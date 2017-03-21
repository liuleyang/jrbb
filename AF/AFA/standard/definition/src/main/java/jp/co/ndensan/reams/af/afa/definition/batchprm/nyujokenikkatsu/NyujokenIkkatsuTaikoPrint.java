/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区情報
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuTaikoPrint {

    private RString 帳票名;
    private RString ページ数;
    private NyujokenIkkatsuWriteProcessParameter 抽出条件;
    private RString 出力順;
    private RString 改頁条件;
    private RString 詳細設定;
    private RString ジョブ番号;

    /**
     * コンストラクタです。
     */
    public NyujokenIkkatsuTaikoPrint() {
    }

    /**
     * コンストラクタです。
     *
     * @param 帳票名 RString
     * @param ページ数 RString
     * @param 抽出条件 NyujokenIkkatsuWriteProcessParameter
     * @param 出力順 RString
     * @param 改頁条件 RString
     * @param 詳細設定 RString
     * @param ジョブ番号 RString
     */
    public NyujokenIkkatsuTaikoPrint(RString 帳票名,
            RString ページ数,
            NyujokenIkkatsuWriteProcessParameter 抽出条件,
            RString 出力順,
            RString 改頁条件,
            RString 詳細設定,
            RString ジョブ番号) {
        this.帳票名 = 帳票名;
        this.ページ数 = ページ数;
        this.抽出条件 = 抽出条件;
        this.出力順 = 出力順;
        this.改頁条件 = 改頁条件;
        this.詳細設定 = 詳細設定;
        this.ジョブ番号 = ジョブ番号;

    }

    /**
     * 帳票名を返します。
     *
     * @return 帳票名
     */
    public RString get帳票名() {
        return 帳票名;
    }

    /**
     * ページ数を返します。
     *
     * @return ページ数
     */
    public RString getページ数() {
        return ページ数;
    }

    /**
     * 抽出条件を返します。
     *
     * @return 抽出条件
     */
    public NyujokenIkkatsuWriteProcessParameter get抽出条件() {
        return 抽出条件;
    }

    /**
     * 出力順を返します。
     *
     * @return 出力順
     */
    public RString get出力順() {
        return 出力順;
    }

    /**
     * 改頁条件を返します。
     *
     * @return 改頁条件
     */
    public RString get改頁条件() {
        return 改頁条件;
    }

    /**
     * 詳細設定を返します。
     *
     * @return 詳細設定
     */
    public RString get詳細設定() {
        return 詳細設定;
    }

    /**
     * ジョブ番号を返します。
     *
     * @return ジョブ番号
     */
    public RString getジョブ番号() {
        return ジョブ番号;
    }

    /**
     * 帳票名を設定します。
     *
     * @param 帳票名 RString
     */
    public void set帳票名(RString 帳票名) {
        this.帳票名 = 帳票名;
    }

    /**
     * ページ数を設定します。
     *
     * @param ページ数 RString
     */
    public void setページ数(RString ページ数) {
        this.ページ数 = ページ数;
    }

    /**
     * 抽出条件を設定します。
     *
     * @param 抽出条件 NyujokenIkkatsuWriteProcessParameter
     */
    public void set抽出条件(NyujokenIkkatsuWriteProcessParameter 抽出条件) {
        this.抽出条件 = 抽出条件;
    }

    /**
     * 出力順を設定します。
     *
     * @param 出力順 RString
     */
    public void set出力順(RString 出力順) {
        this.出力順 = 出力順;
    }

    /**
     * 改頁条件を設定します。
     *
     * @param 改頁条件 RString
     */
    public void set改頁条件(RString 改頁条件) {
        this.改頁条件 = 改頁条件;
    }

    /**
     * 詳細設定を設定します。
     *
     * @param 詳細設定 RString
     */
    public void set詳細設定(RString 詳細設定) {
        this.詳細設定 = 詳細設定;
    }

    /**
     * ジョブ番号を設定します。
     *
     * @param ジョブ番号 RString
     */
    public void setジョブ番号(RString ジョブ番号) {
        this.ジョブ番号 = ジョブ番号;
    }

}
