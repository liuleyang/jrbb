/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 *
 * 選挙人情報
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenKobetsuJouhou {

    private RString 住所;
    private RString 名称;
    private RString カナ名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private ShikibetsuCode 識別コード;
    private GyoseikuCode 行政区コード;
    private RString 行政区名;
    private ChikuCode 地区コード１;
    private ChikuCode 地区コード２;
    private ChikuCode 地区コード３;
    private RString 地区名１;
    private RString 地区名２;
    private RString 地区名３;
    private SetaiCode 世帯コード;
    private TsuzukigaraCode 続柄コード;
    private ZenkokuJushoCode 全国住所コード;
    private ChoikiCode 町域コード;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString 住民種別コード;
    private int 住民票表示順;
    private AtenaJusho 転出先住所;
    private AtenaBanchi 転出先番地;
    private Katagaki 転出先方書;
    private YubinNo 転出先郵便番号;
    private FlexibleDate 登録届出年月日;
    private AtenaMeisho 世帯主名;
    private YubinNo 郵便番号;
    private RString 投票区コード;
    private RString 投票区名;
    private RString 投票所コード;
    private RString 投票所名;
    private RTime 投票開始時刻;
    private RTime 投票終了時刻;
    private AtenaJusho 投票所の住所;
    private int 頁;
    private int 行;
    private FlexibleDate 転出期限日;
    private FlexibleDate 転入期限日;
    private FlexibleDate 年齢到達期限日;
    private FlexibleDate 前回基準日;
    private FlexibleDate 消除届出年月日;
    private FlexibleDate 消除異動年月日;
    private FlexibleDate 名簿基準年月日;
    private FlexibleDate 登録異動年月日;

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return this.住所;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称() {
        return this.名称;
    }

    /**
     * カナ名称を返します。
     *
     * @return カナ名称
     */
    public RString getカナ名称() {
        return this.カナ名称;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return this.生年月日;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return this.性別コード;
    }

    /**
     * 全国住所コードを返します。
     *
     * @return 全国住所コード
     */
    public ZenkokuJushoCode get全国住所コード() {
        return 全国住所コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.識別コード;
    }

    /**
     * 行政区コードを返します。
     *
     * @return 行政区コード
     */
    public GyoseikuCode get行政区コード() {
        return this.行政区コード;
    }

    /**
     * 行政区名を返します。
     *
     * @return 行政区名
     */
    public RString get行政区名() {
        return this.行政区名;
    }

    /**
     * 地区コード１を返します。
     *
     * @return 地区コード１
     */
    public ChikuCode get地区コード１() {
        return this.地区コード１;
    }

    /**
     * 地区コード２を返します。
     *
     * @return 地区コード２
     */
    public ChikuCode get地区コード２() {
        return this.地区コード２;
    }

    /**
     * 地区コード３を返します。
     *
     * @return 地区コード３
     */
    public ChikuCode get地区コード３() {
        return this.地区コード３;
    }

    /**
     * 地区名１を返します。
     *
     * @return 地区名１
     */
    public RString get地区名１() {
        return this.地区名１;
    }

    /**
     * 地区名２を返します。
     *
     * @return 地区名２
     */
    public RString get地区名２() {
        return this.地区名２;
    }

    /**
     * 地区名３を返します。
     *
     * @return 地区名３
     */
    public RString get地区名３() {
        return this.地区名３;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return this.世帯コード;
    }

    /**
     * 続柄コードを返します。
     *
     * @return 続柄コード
     */
    public TsuzukigaraCode get続柄コード() {
        return this.続柄コード;
    }

    /**
     * 町域コードを返します。
     *
     * @return 町域コード
     */
    public ChoikiCode get町域コード() {
        return this.町域コード;
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return this.番地;
    }

    /**
     * 方書を返します。
     *
     * @return 方書
     */
    public Katagaki get方書() {
        return this.方書;
    }

    /**
     * 住民種別コードを返します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return this.住民種別コード;
    }

    /**
     * 住民票表示順を返します。
     *
     * @return 住民票表示順
     */
    public int get住民票表示順() {
        return this.住民票表示順;
    }

    /**
     * 転出先住所を返します。
     *
     * @return 転出先住所
     */
    public AtenaJusho get転出先住所() {
        return this.転出先住所;
    }

    /**
     * 転出先番地を返します。
     *
     * @return 転出先番地
     */
    public AtenaBanchi get転出先番地() {
        return this.転出先番地;
    }

    /**
     * 転出先方書を返します。
     *
     * @return 転出先方書
     */
    public Katagaki get転出先方書() {
        return this.転出先方書;
    }

    /**
     * 転出先郵便番号を返します。
     *
     * @return 転出先郵便番号
     */
    public YubinNo get転出先郵便番号() {
        return this.転出先郵便番号;
    }

    /**
     * 登録届出年月日を返します。
     *
     * @return 登録届出年月日
     */
    public FlexibleDate get登録届出年月日() {
        return this.登録届出年月日;
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名
     */
    public AtenaMeisho get世帯主名() {
        return this.世帯主名;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return this.郵便番号;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.投票区コード;
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return this.投票区名;
    }

    /**
     * 投票所コードを返します。
     *
     * @return 投票所コード
     */
    public RString get投票所コード() {
        return this.投票所コード;
    }

    /**
     * 投票所名を返します。
     *
     * @return 投票所名
     */
    public RString get投票所名() {
        return this.投票所名;
    }

    /**
     * 投票開始時刻を返します。
     *
     * @return 投票開始時刻
     */
    public RTime get投票開始時刻() {
        return this.投票開始時刻;
    }

    /**
     * 投票終了時刻を返します。
     *
     * @return 投票終了時刻
     */
    public RTime get投票終了時刻() {
        return this.投票終了時刻;
    }

    /**
     * 投票所の住所を返します。
     *
     * @return 投票所の住所
     */
    public AtenaJusho get投票所の住所() {
        return this.投票所の住所;
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return this.頁;
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return this.行;
    }

    /**
     * 転出期限日を返します。
     *
     * @return 転出期限日
     */
    public FlexibleDate get転出期限日() {
        return 転出期限日;
    }

    /**
     * 転入期限日を返します。
     *
     * @return 転入期限日
     */
    public FlexibleDate get転入期限日() {
        return 転入期限日;
    }

    /**
     * 年齢到達期限日を返します。
     *
     * @return 年齢到達期限日
     */
    public FlexibleDate get年齢到達期限日() {
        return 年齢到達期限日;
    }

    /**
     * 前回基準日を返します。
     *
     * @return 前回基準日
     */
    public FlexibleDate get前回基準日() {
        return 前回基準日;
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
     * @param 生年月日 FlexibleDate
     */
    public void set生年月日(FlexibleDate 生年月日) {
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
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 行政区コードを設定します。
     *
     * @param 行政区コード GyoseikuCode
     */
    public void set行政区コード(GyoseikuCode 行政区コード) {
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
     * @param 地区コード１ ChikuCode
     */
    public void set地区コード１(ChikuCode 地区コード１) {
        this.地区コード１ = 地区コード１;
    }

    /**
     * 地区コード２を設定します。
     *
     * @param 地区コード２ ChikuCode
     */
    public void set地区コード２(ChikuCode 地区コード２) {
        this.地区コード２ = 地区コード２;
    }

    /**
     * 地区コード３を設定します。
     *
     * @param 地区コード３ ChikuCode
     */
    public void set地区コード３(ChikuCode 地区コード３) {
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
     * 世帯コードを設定します。
     *
     * @param 世帯コード SetaiCode
     */
    public void set世帯コード(SetaiCode 世帯コード) {
        this.世帯コード = 世帯コード;
    }

    /**
     * 続柄コードを設定します。
     *
     * @param 続柄コード TsuzukigaraCode
     */
    public void set続柄コード(TsuzukigaraCode 続柄コード) {
        this.続柄コード = 続柄コード;
    }

    /**
     * 町域コードを設定します。
     *
     * @param 町域コード ChoikiCode
     */
    public void set町域コード(ChoikiCode 町域コード) {
        this.町域コード = 町域コード;
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
     * 住民種別コードを設定します。
     *
     * @param 住民種別コード RString
     */
    public void set住民種別コード(RString 住民種別コード) {
        this.住民種別コード = 住民種別コード;
    }

    /**
     * 住民票表示順を設定します。
     *
     * @param 住民票表示順 int
     */
    public void set住民票表示順(int 住民票表示順) {
        this.住民票表示順 = 住民票表示順;
    }

    /**
     * 転出先住所を設定します。
     *
     * @param 転出先住所 AtenaJusho
     */
    public void set転出先住所(AtenaJusho 転出先住所) {
        this.転出先住所 = 転出先住所;
    }

    /**
     * 転出先番地を設定します。
     *
     * @param 転出先番地 AtenaBanchi
     */
    public void set転出先番地(AtenaBanchi 転出先番地) {
        this.転出先番地 = 転出先番地;
    }

    /**
     * 転出先方書を設定します。
     *
     * @param 転出先方書 Katagaki
     */
    public void set転出先方書(Katagaki 転出先方書) {
        this.転出先方書 = 転出先方書;
    }

    /**
     * 転出先郵便番号を設定します。
     *
     * @param 転出先郵便番号 YubinNo
     */
    public void set転出先郵便番号(YubinNo 転出先郵便番号) {
        this.転出先郵便番号 = 転出先郵便番号;
    }

    /**
     * 登録届出年月日を設定します。
     *
     * @param 登録届出年月日 FlexibleDate
     */
    public void set登録届出年月日(FlexibleDate 登録届出年月日) {
        this.登録届出年月日 = 登録届出年月日;
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
     * 郵便番号を設定します。
     *
     * @param 郵便番号 YubinNo
     */
    public void set郵便番号(YubinNo 郵便番号) {
        this.郵便番号 = 郵便番号;
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
     * 投票区名を設定します。
     *
     * @param 投票区名 RString
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
    }

    /**
     * 全国住所コードを設定します。
     *
     * @param 全国住所コード ZenkokuJushoCode
     */
    public void set全国住所コード(ZenkokuJushoCode 全国住所コード) {
        this.全国住所コード = 全国住所コード;
    }

    /**
     * 投票所コードを設定します。
     *
     * @param 投票所コード RString
     */
    public void set投票所コード(RString 投票所コード) {
        this.投票所コード = 投票所コード;
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
     * 投票所の住所を設定します。
     *
     * @param 投票所の住所 AtenaJusho
     */
    public void set投票所の住所(AtenaJusho 投票所の住所) {
        this.投票所の住所 = 投票所の住所;
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
     * 転出期限日を設定します。
     *
     * @param 転出期限日 FlexibleDate
     */
    public void set転出期限日(FlexibleDate 転出期限日) {
        this.転出期限日 = 転出期限日;
    }

    /**
     * 転入期限日を設定します。
     *
     * @param 転入期限日 FlexibleDate
     */
    public void set転入期限日(FlexibleDate 転入期限日) {
        this.転入期限日 = 転入期限日;
    }

    /**
     * 年齢到達期限日を設定します。
     *
     * @param 年齢到達期限日 FlexibleDate
     */
    public void set年齢到達期限日(FlexibleDate 年齢到達期限日) {
        this.年齢到達期限日 = 年齢到達期限日;
    }

    /**
     * 前回基準日を設定します。
     *
     * @param 前回基準日 FlexibleDate
     */
    public void set前回基準日(FlexibleDate 前回基準日) {
        this.前回基準日 = 前回基準日;
    }

    /**
     * 消除届出年月日を返します。
     *
     * @return 消除届出年月日
     */
    public FlexibleDate get消除届出年月日() {
        return 消除届出年月日;
    }

    /**
     * 消除異動年月日を返します。
     *
     * @return 消除異動年月日
     */
    public FlexibleDate get消除異動年月日() {
        return 消除異動年月日;
    }

    /**
     * 登録異動年月日を返します。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate get登録異動年月日() {
        return 登録異動年月日;
    }

    /**
     * 消除届出年月日を設定します。
     *
     * @param 消除届出年月日 FlexibleDate
     */
    public void set消除届出年月日(FlexibleDate 消除届出年月日) {
        this.消除届出年月日 = 消除届出年月日;
    }

    /**
     * 前消除異動年月日を設定します。
     *
     * @param 消除異動年月日 FlexibleDate
     */
    public void set消除異動年月日(FlexibleDate 消除異動年月日) {
        this.消除異動年月日 = 消除異動年月日;
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return 名簿基準年月日;
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param 名簿基準年月日 FlexibleDate
     */
    public void set名簿基準年月日(FlexibleDate 名簿基準年月日) {
        this.名簿基準年月日 = 名簿基準年月日;
    }

    /**
     * 登録異動年月日を設定します。
     *
     * @param 登録異動年月日 FlexibleDate
     */
    public void set登録異動年月日(FlexibleDate 登録異動年月日) {
        this.登録異動年月日 = 登録異動年月日;
    }

}
