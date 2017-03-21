/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 施設送付書発行クラス。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class ShisetsusofushoEntity {

    private int 受付番号;
    private int 頁;
    private int 行;
    private RString 投票区コード;
    private RString 名簿番号;
    private RString 住登内住所;
    private RString 住登内番地;
    private RString 名称;
    private RString 性別コード;
    private AtenaMeisho 施設宛名;
    private SenkyoNo 選挙番号;
    private RString 施設コード;
    private RString 施設名称;
    private RString 選挙名称;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 名簿基準年月日;
    private RString 住所;

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
     * 受付番号を返します。
     *
     * @return 受付番号
     */
    public int get受付番号() {
        return 受付番号;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return 投票区コード;
    }

    /**
     * 名簿番号を返します。
     *
     * @return 名簿番号
     */
    public RString get名簿番号() {
        return 名簿番号;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称() {
        return 名称;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 施設宛名を返します。
     *
     * @return 施設宛名
     */
    public AtenaMeisho get施設宛名() {
        return 施設宛名;
    }

    /**
     * 選挙番号を設定します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return 選挙番号;
    }

    /**
     * 施設コードを設定します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return 施設コード;
    }

    /**
     * 施設名称を設定します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return 施設名称;
    }

    /**
     * 選挙名称を設定します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return 選挙名称;
    }

    /**
     * 識別コードを設定します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 受付番号を設定します。
     *
     * @param 受付番号 int
     */
    public void set受付番号(int 受付番号) {
        this.受付番号 = 受付番号;
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
     * 名簿番号を設定します。
     *
     * @param 名簿番号 RString
     */
    public void set名簿番号(RString 名簿番号) {
        this.名簿番号 = 名簿番号;
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
     * 性別コードを設定します。
     *
     * @param 性別コード RString
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
    }

    /**
     * 施設宛名を設定します。
     *
     * @param 施設宛名 AtenaMeisho
     */
    public void set施設宛名(AtenaMeisho 施設宛名) {
        this.施設宛名 = 施設宛名;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 SenkyoNo
     */
    public void set選挙番号(SenkyoNo 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード RString
     */
    public void set施設コード(RString 施設コード) {
        this.施設コード = 施設コード;
    }

    /**
     * 施設名称を設定します。
     *
     * @param 施設名称 RString
     */
    public void set施設名称(RString 施設名称) {
        this.施設名称 = 施設名称;
    }

    /**
     * 選挙名称を設定します。
     *
     * @param 選挙名称 RString
     */
    public void set選挙名称(RString 選挙名称) {
        this.選挙名称 = 選挙名称;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード RString
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 頁を設定します。
     *
     * @return 頁
     */
    public int get頁() {
        return 頁;
    }

    /**
     * 行を設定します。
     *
     * @return 行
     */
    public int get行() {
        return 行;
    }

    /**
     * 頁を設定します。
     *
     * @param 頁 RString
     */
    public void set頁(int 頁) {
        this.頁 = 頁;
    }

    /**
     * 行を設定します。
     *
     * @param 行 RString
     */
    public void set行(int 行) {
        this.行 = 行;
    }

    /**
     * 名簿基準年月日を設定します。
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
     * 住所を設定します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 RString
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

}
