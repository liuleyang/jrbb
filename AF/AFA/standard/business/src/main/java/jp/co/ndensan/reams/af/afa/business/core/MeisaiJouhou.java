/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 明細情報
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class MeisaiJouhou {

    private RString 住登内町域コード;
    private RString 投票所＿住所;
    private RString 投票区名;
    private RString 行政区コード;
    private RString 続柄コード;
    private YubinNo 送付先郵便番号;
    private RString 整理番号;
    private AtenaJusho 住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private Katagaki 住登内方書;
    private SetaiCode 世帯コード;
    private AtenaMeisho 世帯主名;
    private AtenaJusho 住登内住所;
    private AtenaBanchi 住登内番地;
    private RString 行政区名;
    private RString 投票区コード;
    private RString 地区名1;
    private RString 地区名2;
    private RString 地区名3;
    private RString 地区コード1;
    private RString 地区コード2;
    private RString 地区コード3;
    private RString 名称;
    private RString カナ名称;
    private RString 投票所名;
    private ShohonNo 抄本番号;
    private RDate 生年月日;
    private RString 帳票ID;
    private RString 性別コード;
    private RString 住民種別コード;
    private RTime 投票開始時刻;
    private RTime 投票終了時刻;
    private ShikibetsuCode 識別コード;
    private int 頁;
    private int 行;
    private int 住民票表示順;

    /**
     * 住所を返します。
     *
     * @return 住所 AtenaJusho
     */
    public AtenaJusho get住所() {
        return this.住所;
    }

    /**
     * 番地を返します。
     *
     * @return 番地 AtenaBanchi
     */
    public AtenaBanchi get番地() {
        return this.番地;
    }

    /**
     * 方書を返します。
     *
     * @return 方書 Katagaki
     */
    public Katagaki get方書() {
        return this.方書;
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
     * 住所を設定します。
     *
     * @param 住所 AtenaJusho
     */
    public void set住所(AtenaJusho 住所) {
        this.住所 = 住所;
    }

    /**
     * 番地を設定します。
     *
     * @param 番地 AtenaBanchi
     */
    public void set番地(AtenaBanchi 番地) {
        this.番地 = 番地;
    }

    /**
     * 方書を設定します。
     *
     * @param 方書 Katagaki
     */
    public void set方書(Katagaki 方書) {
        this.方書 = 方書;
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
     * 送付先郵便番号を返します。
     *
     * @return 送付先郵便番号 YubinNo
     */
    public YubinNo get送付先郵便番号() {
        return this.送付先郵便番号;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号 RString
     */
    public RString get整理番号() {
        return this.整理番号;
    }

    /**
     * 送付先郵便番号を設定します。
     *
     * @param 送付先郵便番号 YubinNo
     */
    public void set送付先郵便番号(YubinNo 送付先郵便番号) {
        this.送付先郵便番号 = 送付先郵便番号;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 RString
     */
    public void set整理番号(RString 整理番号) {
        this.整理番号 = 整理番号;
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
     * 投票所＿住所を返します。
     *
     * @return 投票所＿住所 RString
     */
    public RString get投票所＿住所() {
        return this.投票所＿住所;
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
     * 識別コードを返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
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
     * 続柄コードを返します。
     *
     * @return 続柄コード RString
     */
    public RString get続柄コード() {
        return this.続柄コード;
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
     * 行政区名を返します。
     *
     * @return 行政区名 RString
     */
    public RString get行政区名() {
        return this.行政区名;
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
     * 投票所名を返します。
     *
     * @return 投票所名 RString
     */
    public RString get投票所名() {
        return this.投票所名;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 ShohonNo
     */
    public ShohonNo get抄本番号() {
        return this.抄本番号;
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
     * 帳票IDを返します。
     *
     * @return 帳票ID RString
     */
    public RString get帳票ID() {
        return this.帳票ID;
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
     * 住民種別コードを返します。
     *
     * @return 住民種別コード RString
     */
    public RString get住民種別コード() {
        return this.住民種別コード;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻 RTime
     */
    public RTime get投票開始時刻() {
        return this.投票開始時刻;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻 RTime
     */
    public RTime get投票終了時刻() {
        return this.投票終了時刻;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 int
     */
    public int get頁() {
        return this.頁;
    }

    /**
     * 行を返します。
     *
     * @return 行 int
     */
    public int get行() {
        return this.行;
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
     * 投票所＿住所を設定します。
     *
     * @param 投票所＿住所 RString
     */
    public void set投票所＿住所(RString 投票所＿住所) {
        this.投票所＿住所 = 投票所＿住所;
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
     * 行政区コードを設定します。
     *
     * @param 行政区コード RString
     */
    public void set行政区コード(RString 行政区コード) {
        this.行政区コード = 行政区コード;
    }

    /**
     * 続柄コードを設定します。
     *
     * @param 続柄コード RString
     */
    public void set続柄コード(RString 続柄コード) {
        this.続柄コード = 続柄コード;
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
     * 行政区名を設定します。
     *
     * @param 行政区名 RString
     */
    public void set行政区名(RString 行政区名) {
        this.行政区名 = 行政区名;
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
     * 投票所名を設定します。
     *
     * @param 投票所名 RString
     */
    public void set投票所名(RString 投票所名) {
        this.投票所名 = 投票所名;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
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
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
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
     * 性別コードを設定します。
     *
     * @param 性別コード RString
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
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
     * 投票開始時刻を設定します。
     *
     * @param 投票開始時刻 RTime
     */
    public void set投票開始時刻(RTime 投票開始時刻) {
        this.投票開始時刻 = 投票開始時刻;
    }

    /**
     * 投票終了時刻を設定します。
     *
     * @param 投票終了時刻 RTime
     */
    public void set投票終了時刻(RTime 投票終了時刻) {
        this.投票終了時刻 = 投票終了時刻;
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
     * 行を設定します。
     *
     * @param 行 int
     */
    public void set行(int 行) {
        this.行 = 行;
    }

    /**
     * 地区コード1
     *
     * @return 地区コード1 RString
     */
    public RString get地区コード1() {
        return 地区コード1;
    }

    /**
     * 地区コード2
     *
     * @return 地区コード2 RString
     */
    public RString get地区コード2() {
        return 地区コード2;
    }

    /**
     * 地区コード3
     *
     * @return 地区コード3 RString
     */
    public RString get地区コード3() {
        return 地区コード3;
    }

    /**
     * 地区コード1
     *
     * @param 地区コード1 RString
     */
    public void set地区コード1(RString 地区コード1) {
        this.地区コード1 = 地区コード1;
    }

    /**
     * 地区コード2
     *
     * @param 地区コード2 RString
     */
    public void set地区コード2(RString 地区コード2) {
        this.地区コード2 = 地区コード2;
    }

    /**
     * 地区コード3
     *
     * @param 地区コード3 RString
     */
    public void set地区コード3(RString 地区コード3) {
        this.地区コード3 = 地区コード3;
    }

    /**
     * 住民票表示順を設定します。
     *
     * @return int
     */
    public int get住民票表示順() {
        return 住民票表示順;
    }

    /**
     * 住民票表示順を設定します。
     *
     * @param 住民票表示順 int
     */
    public void set住民票表示順(int 住民票表示順) {
        this.住民票表示順 = 住民票表示順;
    }
}
