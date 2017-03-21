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
 * 海区選挙人名簿の情報
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class ShisetsuTorokuMeiboJoho {

    private RString 住登内住所;
    private RString 住登内番地;
    private RString 行政区名;
    private RString 住登内方書;
    private RString 性別コード;
    private RString 住民状態コード;
    private RString 続柄;
    private RString 抹消事由コード;
    private RString 組合コード;
    private ShikibetsuCode 識別コード;
    private RString カナ名称;
    private RString 名称;
    private RString 抹消事由_略称;
    private RString 抄本名;
    private RDate 生年月日;
    private boolean 投票区変更抹消フラグ;
    private RString 投票区コード;
    private RString 全国住所コード;
    private RString 住登内町域コード;
    private RString 世帯コード;
    private RString 番地;
    private RString 方書;
    private RString 氏名;
    private RString 住所;
    private RString 性別;
    private RString 漁業日数_漁業者;
    private RString 漁業日数_漁業従事者;
    private RString 住民種別コード;
    private RString エラー事由1;
    private RString エラー事由2;
    private RString エラー事由3;
    private RString 選挙種類;
    private RDate 表示消除年月日;
    private RDate 名簿基準年月日;
    private RDate 登録届出年月日;
    private RDate 登録異動年月日;
    private RDate 住定届出年月日;
    private RDate 処理年月日;
    private RDate 消除異動年月日;
    private RDate 異動年月日;
    private RDate 表示年月日;
    private RDate 名簿登録年月日;
    private RDate 抹消年月日;
    private RDate 消除届出年月日;
    private RString 集計地区名;
    private RString 異動事由コード;

    /**
     * 異動事由コード
     *
     * @return 異動事由コード RString
     */
    public RString get異動事由コード() {
        return 異動事由コード;
    }

    /**
     * 異動事由コード
     *
     * @param 異動事由コード RString
     */
    public void set異動事由コード(RString 異動事由コード) {
        this.異動事由コード = 異動事由コード;
    }

    /**
     * 異動年月日
     *
     * @return 異動年月日 RDate
     */
    public RDate get異動年月日() {
        return 異動年月日;
    }

    /**
     * 異動年月日
     *
     * @param 異動年月日 RDate
     */
    public void set異動年月日(RDate 異動年月日) {
        this.異動年月日 = 異動年月日;
    }

    /**
     * 住定届出年月日
     *
     * @param 住定届出年月日 RDate
     */
    public void set住定届出年月日(RDate 住定届出年月日) {
        this.住定届出年月日 = 住定届出年月日;
    }

    /**
     * 住定届出年月日
     *
     * @return 住定届出年月日 RDate
     */
    public RDate get住定届出年月日() {
        return 住定届出年月日;
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
     * 名簿基準年月日を設定します。
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
     * 住登内町域コードを設定します。
     *
     * @param 住登内町域コード RString
     */
    public void set住登内町域コード(RString 住登内町域コード) {
        this.住登内町域コード = 住登内町域コード;
    }

    /**
     * 住登内町域コード
     *
     * @return 住登内町域コード RString
     */
    public RString get住登内町域コード() {
        return 住登内町域コード;
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
     * 選挙種類
     *
     * @return 選挙種類 RString
     */
    public RString get選挙種類() {
        return 選挙種類;
    }

    /**
     * エラー事由3を設定します。
     *
     * @param エラー事由3 RString
     */
    public void setエラー事由3(RString エラー事由3) {
        this.エラー事由3 = エラー事由3;
    }

    /**
     * エラー事由3
     *
     * @return エラーコード3 RString
     */
    public RString getエラー事由3() {
        return エラー事由3;
    }

    /**
     * エラー事由2を設定します。
     *
     * @param エラー事由2 RString
     */
    public void setエラー事由2(RString エラー事由2) {
        this.エラー事由2 = エラー事由2;
    }

    /**
     * エラー事由
     *
     * @return エラーコード RString
     */
    public RString getエラー事由2() {
        return エラー事由2;
    }

    /**
     * エラー事由1を設定します。
     *
     * @param エラー事由1 RString
     */
    public void setエラー事由1(RString エラー事由1) {
        this.エラー事由1 = エラー事由1;
    }

    /**
     * エラー事由1
     *
     * @return エラーコード RString
     */
    public RString getエラー事由1() {
        return エラー事由1;
    }

    /**
     * 住民種別コード
     *
     * @return 住民種別コード RString
     */
    public RString get住民種別コード() {
        return 住民種別コード;
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
     * 名称
     *
     * @param 名称 RString
     */
    public void set名称(RString 名称) {
        this.名称 = 名称;
    }

    /**
     * 名称
     *
     * @return 名称 RString
     */
    public RString get名称() {
        return 名称;
    }

    /**
     * 続柄を設定します。
     *
     * @param 続柄 RString
     */
    public void set続柄(RString 続柄) {
        this.続柄 = 続柄;
    }

    /**
     * 続柄
     *
     * @return 続柄 RString
     */
    public RString get続柄() {
        return 続柄;
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
     * 住民状態コードを設定します。
     *
     * @param 住民状態コード RString
     */
    public void set住民状態コード(RString 住民状態コード) {
        this.住民状態コード = 住民状態コード;
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
     * 投票区変更抹消フラグ
     *
     * @param 投票区変更抹消フラグ boolean
     */
    public void set投票区変更抹消フラグ(boolean 投票区変更抹消フラグ) {
        this.投票区変更抹消フラグ = 投票区変更抹消フラグ;
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
     * カナ名称を設定します。
     *
     * @param カナ名称 RString
     */
    public void setカナ名称(RString カナ名称) {
        this.カナ名称 = カナ名称;
    }

    /**
     * 抹消事由_略称を設定します。
     *
     * @param 抹消事由_略称 RString
     */
    public void set抹消事由_略称(RString 抹消事由_略称) {
        this.抹消事由_略称 = 抹消事由_略称;
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
     * 生年月日を設定します。
     *
     * @param 生年月日 RDate
     */
    public void set生年月日(RDate 生年月日) {
        this.生年月日 = 生年月日;
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
     * 組合コードを設定します。
     *
     * @param 組合コード RString
     */
    public void set組合コード(RString 組合コード) {
        this.組合コード = 組合コード;
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
     * 行政区名を返します。
     *
     * @return 行政区名 RString
     */
    public RString get行政区名() {
        return this.行政区名;
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
     * 性別コードを返します。
     *
     * @return 性別コード RString
     */
    public RString get性別コード() {
        return this.性別コード;
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 住民状態コード RString
     */
    public RString get住民状態コード() {
        return this.住民状態コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return this.識別コード;
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
     * 抹消事由_略称を返します。
     *
     * @return 抹消事由_略称 RString
     */
    public RString get抹消事由_略称() {
        return this.抹消事由_略称;
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
     * 生年月日を返します。
     *
     * @return 生年月日 RDate
     */
    public RDate get生年月日() {
        return this.生年月日;
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
     * 組合コードを返します。
     *
     * @return 組合コード RString
     */
    public RString get組合コード() {
        return this.組合コード;
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
     * 全国住所コードを設定します。
     *
     * @param 全国住所コード RString
     */
    public void set全国住所コード(RString 全国住所コード) {
        this.全国住所コード = 全国住所コード;
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
     * 氏名を設定します。
     *
     * @param 氏名 RString
     */
    public void set氏名(RString 氏名) {
        this.氏名 = 氏名;
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
     * 性別を設定します。
     *
     * @param 性別 RString
     */
    public void set性別(RString 性別) {
        this.性別 = 性別;
    }

    /**
     * 漁業日数_漁業者を設定します。
     *
     * @param 漁業日数_漁業者 RString
     */
    public void set漁業日数_漁業者(RString 漁業日数_漁業者) {
        this.漁業日数_漁業者 = 漁業日数_漁業者;
    }

    /**
     * 漁業日数_漁業従事者を設定します。
     *
     * @param 漁業日数_漁業従事者 RString
     */
    public void set漁業日数_漁業従事者(RString 漁業日数_漁業従事者) {
        this.漁業日数_漁業従事者 = 漁業日数_漁業従事者;
    }

    /**
     * 表示消除年月日を設定します。
     *
     * @param 表示消除年月日 RDate
     */
    public void set表示消除年月日(RDate 表示消除年月日) {
        this.表示消除年月日 = 表示消除年月日;
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
     * 全国住所コードを返します。
     *
     * @return 全国住所コード RString
     */
    public RString get全国住所コード() {
        return this.全国住所コード;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード RString
     */
    public RString get世帯コード() {
        return this.世帯コード;
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
     * 氏名を返します。
     *
     * @return 氏名 RString
     */
    public RString get氏名() {
        return this.氏名;
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
     * 性別を返します。
     *
     * @return 性別 RString
     */
    public RString get性別() {
        return this.性別;
    }

    /**
     * 漁業日数_漁業者を返します。
     *
     * @return 漁業日数_漁業者 RString
     */
    public RString get漁業日数_漁業者() {
        return this.漁業日数_漁業者;
    }

    /**
     * 漁業日数_漁業従事者を返します。
     *
     * @return 漁業日数_漁業従事者 RString
     */
    public RString get漁業日数_漁業従事者() {
        return this.漁業日数_漁業従事者;
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日 RDate
     */
    public RDate get表示消除年月日() {
        return this.表示消除年月日;
    }

    /**
     * 集計地区名を返します。
     *
     * @return 集計地区名 RString
     */
    public RString get集計地区名() {
        return this.集計地区名;
    }

    /**
     * 集計地区名を設定します。
     *
     * @param 集計地区名 RString
     */
    public void set集計地区名(RString 集計地区名) {
        this.集計地区名 = 集計地区名;
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
     * 登録異動年月日を設定します。
     *
     * @param 登録異動年月日 RDate
     */
    public void set登録異動年月日(RDate 登録異動年月日) {
        this.登録異動年月日 = 登録異動年月日;
    }

    /**
     * 処理年月日を設定します。
     *
     * @param 処理年月日 RDate
     */
    public void set処理年月日(RDate 処理年月日) {
        this.処理年月日 = 処理年月日;
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
     * 表示年月日を設定します。
     *
     * @param 表示年月日 RDate
     */
    public void set表示年月日(RDate 表示年月日) {
        this.表示年月日 = 表示年月日;
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 RDate
     */
    public void set名簿登録年月日(RDate 名簿登録年月日) {
        this.名簿登録年月日 = 名簿登録年月日;
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param 抹消年月日 RDate
     */
    public void set抹消年月日(RDate 抹消年月日) {
        this.抹消年月日 = 抹消年月日;
    }

    /**
     * 消除届出年月日を設定します。
     *
     * @param 消除届出年月日 RDate
     */
    public void set消除届出年月日(RDate 消除届出年月日) {
        this.消除届出年月日 = 消除届出年月日;
    }

    /**
     * 登録届出年月日を返します。
     *
     * @return 登録届出年月日 RDate
     */
    public RDate get登録届出年月日() {
        return this.登録届出年月日;
    }

    /**
     * 登録異動年月日を返します。
     *
     * @return 登録異動年月日 RDate
     */
    public RDate get登録異動年月日() {
        return this.登録異動年月日;
    }

    /**
     * 処理年月日を返します。
     *
     * @return 処理年月日 RDate
     */
    public RDate get処理年月日() {
        return this.処理年月日;
    }

    /**
     * 消除異動年月日を返します。
     *
     * @return 消除異動年月日 RDate
     */
    public RDate get消除異動年月日() {
        return this.消除異動年月日;
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日 RDate
     */
    public RDate get表示年月日() {
        return this.表示年月日;
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日 RDate
     */
    public RDate get名簿登録年月日() {
        return this.名簿登録年月日;
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日 RDate
     */
    public RDate get抹消年月日() {
        return this.抹消年月日;
    }

    /**
     * 消除届出年月日を返します。
     *
     * @return 消除届出年月日 RDate
     */
    public RDate get消除届出年月日() {
        return this.消除届出年月日;
    }

}
