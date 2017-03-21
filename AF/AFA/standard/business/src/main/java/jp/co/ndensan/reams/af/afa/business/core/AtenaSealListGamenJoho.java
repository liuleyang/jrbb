/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListGamenJoho {

    private RString 住所条件;
    private List<RString> 住所一覧リスト_コード;
    private RDate 対象期間FROM;
    private RDate 対象期間TO;
    private RString 施設種別;
    private RString 施設コードFROM;
    private RString 施設コードTO;
    private RString 四隅項目コード1;
    private RString 四隅項目コード2;
    private RString 右上項目コード;
    private RString 右下項目コード;
    private RString 左下項目コード;

    /**
     * 右上項目コードを返します。
     *
     * @return 右上項目コード RString
     */
    public RString get右上項目コード() {
        return this.右上項目コード;
    }

    /**
     * 右下項目コードを返します。
     *
     * @return 右下項目コード RString
     */
    public RString get右下項目コード() {
        return this.右下項目コード;
    }

    /**
     * 左下項目コードを返します。
     *
     * @return 左下項目コード RString
     */
    public RString get左下項目コード() {
        return this.左下項目コード;
    }

    /**
     * 右上項目コードを設定します。
     *
     * @param 右上項目コード RString
     */
    public void set右上項目コード(RString 右上項目コード) {
        this.右上項目コード = 右上項目コード;
    }

    /**
     * 右下項目コードを設定します。
     *
     * @param 右下項目コード RString
     */
    public void set右下項目コード(RString 右下項目コード) {
        this.右下項目コード = 右下項目コード;
    }

    /**
     * 左下項目コードを設定します。
     *
     * @param 左下項目コード RString
     */
    public void set左下項目コード(RString 左下項目コード) {
        this.左下項目コード = 左下項目コード;
    }

    /**
     * 住所条件を返します。
     *
     * @return 住所条件 RString
     */
    public RString get住所条件() {
        return this.住所条件;
    }

    /**
     * 住所一覧リスト_コードを返します。
     *
     * @return 住所一覧リスト_コード List<RString>
     */
    public List<RString> get住所一覧リスト_コード() {
        return this.住所一覧リスト_コード;
    }

    /**
     * 対象期間FROMを返します。
     *
     * @return 対象期間FROM RDate
     */
    public RDate get対象期間FROM() {
        return this.対象期間FROM;
    }

    /**
     * 対象期間TOを返します。
     *
     * @return 対象期間TO RDate
     */
    public RDate get対象期間TO() {
        return this.対象期間TO;
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別 RString
     */
    public RString get施設種別() {
        return this.施設種別;
    }

    /**
     * 施設コードFROMを返します。
     *
     * @return 施設コードFROM RString
     */
    public RString get施設コードFROM() {
        return this.施設コードFROM;
    }

    /**
     * 施設コードTOを返します。
     *
     * @return 施設コードTO RString
     */
    public RString get施設コードTO() {
        return this.施設コードTO;
    }

    /**
     * 四隅項目コード1を返します。
     *
     * @return 四隅項目コード1 RString
     */
    public RString get四隅項目コード1() {
        return this.四隅項目コード1;
    }

    /**
     * 四隅項目コード2を返します。
     *
     * @return 四隅項目コード2 RString
     */
    public RString get四隅項目コード2() {
        return this.四隅項目コード2;
    }

    /**
     * 住所条件を設定します。
     *
     * @param 住所条件 RString
     */
    public void set住所条件(RString 住所条件) {
        this.住所条件 = 住所条件;
    }

    /**
     * 住所一覧リスト_コードを設定します。
     *
     * @param 住所一覧リスト_コード List<RString>
     */
    public void set住所一覧リスト_コード(List<RString> 住所一覧リスト_コード) {
        this.住所一覧リスト_コード = 住所一覧リスト_コード;
    }

    /**
     * 対象期間FROMを設定します。
     *
     * @param 対象期間FROM RDate
     */
    public void set対象期間FROM(RDate 対象期間FROM) {
        this.対象期間FROM = 対象期間FROM;
    }

    /**
     * 対象期間TOを設定します。
     *
     * @param 対象期間TO RDate
     */
    public void set対象期間TO(RDate 対象期間TO) {
        this.対象期間TO = 対象期間TO;
    }

    /**
     * 施設種別を設定します。
     *
     * @param 施設種別 RString
     */
    public void set施設種別(RString 施設種別) {
        this.施設種別 = 施設種別;
    }

    /**
     * 施設コードFROMを設定します。
     *
     * @param 施設コードFROM RString
     */
    public void set施設コードFROM(RString 施設コードFROM) {
        this.施設コードFROM = 施設コードFROM;
    }

    /**
     * 施設コードTOを設定します。
     *
     * @param 施設コードTO RString
     */
    public void set施設コードTO(RString 施設コードTO) {
        this.施設コードTO = 施設コードTO;
    }

    /**
     * 四隅項目コード1を設定します。
     *
     * @param 四隅項目コード1 RString
     */
    public void set四隅項目コード1(RString 四隅項目コード1) {
        this.四隅項目コード1 = 四隅項目コード1;
    }

    /**
     * 四隅項目コード2を設定します。
     *
     * @param 四隅項目コード2 RString
     */
    public void set四隅項目コード2(RString 四隅項目コード2) {
        this.四隅項目コード2 = 四隅項目コード2;
    }

}
