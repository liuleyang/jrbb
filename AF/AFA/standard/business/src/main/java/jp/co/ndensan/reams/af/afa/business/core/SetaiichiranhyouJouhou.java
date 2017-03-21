/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯一覧表情報
 *
 * @reamsid_L AF-0160-030 jihb
 */
public class SetaiichiranhyouJouhou {

    private RString 投票区コード;
    private SetaiCode 世帯コード;
    private AtenaMeisho 世帯主名;
    private int 世帯員数;
    private RString 名簿番号_頁;
    private RString 名簿番号_行;
    private AtenaJusho 住登内住所;
    private AtenaBanchi 住登内番地;
    private Katagaki 住登内方書;
    private RString 行政区名;
    private RString 投票区名;
    private RString 地区名1;
    private RString 地区名2;
    private RString 地区名3;
    private RString 住登内町域コード;
    private RString 行政区コード;
    private RString 地区コード1;
    private RString 地区コード2;
    private RString 地区コード3;
    private RString 郵便番号;
    private int 抽出対象世帯人数;
    private boolean 合計Flag;
    private RString 印刷世帯数集計した値;
    private RString 印刷枚数集計した値;
    private RString 人数集計した値;
    private RString 集計単位名称;
    private RString 集計コード;
    private RString 集計コード名称;

    /**
     * 合計Flag
     *
     * @param 合計Flag boolean
     */
    public void set合計Flag(boolean 合計Flag) {
        this.合計Flag = 合計Flag;
    }

    /**
     * 集計した値を返します。
     *
     * @return 印刷世帯数集計した値 RString
     */
    public RString get印刷世帯数集計した値() {
        return this.印刷世帯数集計した値;
    }

    /**
     * 印刷枚数集計した値を返します。
     *
     * @return 印刷枚数集計した値 RString
     */
    public RString get印刷枚数集計した値() {
        return this.印刷枚数集計した値;
    }

    /**
     * 人数集計した値を返します。
     *
     * @return 人数集計した値 RString
     */
    public RString get人数集計した値() {
        return this.人数集計した値;
    }

    /**
     * 集計した値を設定します。
     *
     * @param 印刷世帯数集計した値 int
     */
    public void set印刷世帯数集計した値(RString 印刷世帯数集計した値) {
        this.印刷世帯数集計した値 = 印刷世帯数集計した値;
    }

    /**
     * 印刷枚数集計した値を設定します。
     *
     * @param 印刷枚数集計した値 int
     */
    public void set印刷枚数集計した値(RString 印刷枚数集計した値) {
        this.印刷枚数集計した値 = 印刷枚数集計した値;
    }

    /**
     * 人数集計した値を設定します。
     *
     * @param 人数集計した値 int
     */
    public void set人数集計した値(RString 人数集計した値) {
        this.人数集計した値 = 人数集計した値;
    }

    /**
     * 郵便番号
     *
     * @param 郵便番号 RString
     */
    public void set郵便番号(RString 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * 郵便番号
     *
     * @return 郵便番号 RString
     */
    public RString get郵便番号() {
        return 郵便番号;
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
     * 世帯コードを返します。
     *
     * @return 世帯コード SetaiCode
     */
    public SetaiCode get世帯コード() {
        return this.世帯コード;
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名 AtenaMeisho
     */
    public AtenaMeisho get世帯主名() {
        return this.世帯主名;
    }

    /**
     * 世帯員数を返します。
     *
     * @return 世帯員数 int
     */
    public int get世帯員数() {
        return this.世帯員数;
    }

    /**
     * 抽出対象世帯人数を返します。
     *
     * @return 抽出対象世帯人数 int
     */
    public int get抽出対象世帯人数() {
        return this.抽出対象世帯人数;
    }

    /**
     * 名簿番号_頁を返します。
     *
     * @return 名簿番号_頁 RString
     */
    public RString get名簿番号_頁() {
        return this.名簿番号_頁;
    }

    /**
     * 名簿番号_行を返します。
     *
     * @return 名簿番号_行 RString
     */
    public RString get名簿番号_行() {
        return this.名簿番号_行;
    }

    /**
     * 住登内住所を返します。
     *
     * @return 住登内住所 AtenaJusho
     */
    public AtenaJusho get住登内住所() {
        return this.住登内住所;
    }

    /**
     * 住登内番地を返します。
     *
     * @return 住登内番地 AtenaBanchi
     */
    public AtenaBanchi get住登内番地() {
        return this.住登内番地;
    }

    /**
     * 住登内方書を返します。
     *
     * @return 住登内方書 Katagaki
     */
    public Katagaki get住登内方書() {
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
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード SetaiCode
     */
    public void set世帯コード(SetaiCode 世帯コード) {
        this.世帯コード = 世帯コード;
    }

    /**
     * 世帯主名を設定します。
     *
     * @param 世帯主名 AtenaMeisho
     */
    public void set世帯主名(AtenaMeisho 世帯主名) {
        this.世帯主名 = 世帯主名;
    }

    /**
     * 世帯員数を設定します。
     *
     * @param 世帯員数 int
     */
    public void set世帯員数(int 世帯員数) {
        this.世帯員数 = 世帯員数;
    }

    /**
     * 名簿番号_頁を設定します。
     *
     * @param 名簿番号_頁 RString
     */
    public void set名簿番号_頁(RString 名簿番号_頁) {
        this.名簿番号_頁 = 名簿番号_頁;
    }

    /**
     * 名簿番号_行を設定します。
     *
     * @param 名簿番号_行 RString
     */
    public void set名簿番号_行(RString 名簿番号_行) {
        this.名簿番号_行 = 名簿番号_行;
    }

    /**
     * 住登内住所を設定します。
     *
     * @param 住登内住所 AtenaJusho
     */
    public void set住登内住所(AtenaJusho 住登内住所) {
        this.住登内住所 = 住登内住所;
    }

    /**
     * 住登内番地を設定します。
     *
     * @param 住登内番地 AtenaBanchi
     */
    public void set住登内番地(AtenaBanchi 住登内番地) {
        this.住登内番地 = 住登内番地;
    }

    /**
     * 住登内方書を設定します。
     *
     * @param 住登内方書 Katagaki
     */
    public void set住登内方書(Katagaki 住登内方書) {
        this.住登内方書 = 住登内方書;
    }

    /**
     * 抽出対象世帯人数を設定します。
     *
     * @param 抽出対象世帯人数 int
     */
    public void set抽出対象世帯人数(int 抽出対象世帯人数) {
        this.抽出対象世帯人数 = 抽出対象世帯人数;
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
     * 投票区名を設定します。
     *
     * @param 投票区名 RString
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
    }

    /**
     * 地区名1を設定します。
     *
     * @param 地区名1 RString
     */
    public void set地区名1(RString 地区名1) {
        this.地区名1 = 地区名1;
    }

    /**
     * 地区名2を設定します。
     *
     * @param 地区名2 RString
     */
    public void set地区名2(RString 地区名2) {
        this.地区名2 = 地区名2;
    }

    /**
     * 地区名3を設定します。
     *
     * @param 地区名3 RString
     */
    public void set地区名3(RString 地区名3) {
        this.地区名3 = 地区名3;
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
     * 地区名1を返します。
     *
     * @return 地区名1 RString
     */
    public RString get地区名1() {
        return this.地区名1;
    }

    /**
     * 地区名2を返します。
     *
     * @return 地区名2 RString
     */
    public RString get地区名2() {
        return this.地区名2;
    }

    /**
     * 地区名3を返します。
     *
     * @return 地区名3 RString
     */
    public RString get地区名3() {
        return this.地区名3;
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
     * 地区コード1を設定します。
     *
     * @param 地区コード1 RString
     */
    public void set地区コード1(RString 地区コード1) {
        this.地区コード1 = 地区コード1;
    }

    /**
     * 地区コード2を設定します。
     *
     * @param 地区コード2 RString
     */
    public void set地区コード2(RString 地区コード2) {
        this.地区コード2 = 地区コード2;
    }

    /**
     * 地区コード3を設定します。
     *
     * @param 地区コード3 RString
     */
    public void set地区コード3(RString 地区コード3) {
        this.地区コード3 = 地区コード3;
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
     * 地区コード1を返します。
     *
     * @return 地区コード1 RString
     */
    public RString get地区コード1() {
        return this.地区コード1;
    }

    /**
     * 地区コード2を返します。
     *
     * @return 地区コード2 RString
     */
    public RString get地区コード2() {
        return this.地区コード2;
    }

    /**
     * 地区コード3を返します。
     *
     * @return 地区コード3 RString
     */
    public RString get地区コード3() {
        return this.地区コード3;
    }

    /**
     * 合計Flagを返します。
     *
     * @return 合計Flag RString
     */
    public boolean is合計Flag() {
        return 合計Flag;
    }

    /**
     * 集計単位名称を返します。
     *
     * @return 集計単位名称 RString
     */
    public RString get集計単位名称() {
        return 集計単位名称;
    }

    /**
     * 集計コードを返します。
     *
     * @return 集計コード RString
     */
    public RString get集計コード() {
        return 集計コード;
    }

    /**
     * 集計コード名称を返します。
     *
     * @return 集計コード名称 RString
     */
    public RString get集計コード名称() {
        return 集計コード名称;
    }

    /**
     * 集計単位名称を設定します。
     *
     * @param 集計単位名称 RString
     */
    public void set集計単位名称(RString 集計単位名称) {
        this.集計単位名称 = 集計単位名称;
    }

    /**
     * 集計コードを設定します。
     *
     * @param 集計コード RString
     */
    public void set集計コード(RString 集計コード) {
        this.集計コード = 集計コード;
    }

    /**
     * 集計コード名称を設定します。
     *
     * @param 集計コード名称 RString
     */
    public void set集計コード名称(RString 集計コード名称) {
        this.集計コード名称 = 集計コード名称;
    }

}
