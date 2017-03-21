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
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 guyq
 */
public class SeikyuDaihyoshaShomeishoParam {

    private List<RString> 氏名Lst;
    private RString 請求名;
    private RDate 交付日;
    private RString 市町村名;
    private RString 請求代表者名;

    /**
     * コンストラクタです。
     *
     * @param 氏名Lst List<RString>
     * @param 請求名 RString
     * @param 交付日 RDate
     */
    public SeikyuDaihyoshaShomeishoParam(
            List<RString> 氏名Lst,
            RString 請求名,
            RDate 交付日) {
        this.氏名Lst = 氏名Lst;
        this.請求名 = 請求名;
        this.交付日 = 交付日;
    }

    /**
     * 氏名Lstを返します。
     *
     * @return 氏名Lst List<RString>
     */
    public List<RString> get氏名Lst() {
        return 氏名Lst;
    }

    /**
     * 請求名を返します。
     *
     * @return 請求名 RString
     */
    public RString get請求名() {
        return 請求名;
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日 RDate
     */
    public RDate get交付日() {
        return 交付日;
    }

    /**
     * 市町村名を返します。
     *
     * @return 市町村名 RString
     */
    public RString get市町村名() {
        return 市町村名;
    }

    /**
     * 請求代表者名を返します。
     *
     * @return 請求代表者名 RString
     */
    public RString get請求代表者名() {
        return 請求代表者名;
    }

    /**
     * 氏名Lstを設定します。
     *
     * @param 氏名Lst List<RString>
     */
    public void set氏名Lst(List<RString> 氏名Lst) {
        this.氏名Lst = 氏名Lst;
    }

    /**
     * 請求名を設定します。
     *
     * @param 請求名 RString
     */
    public void set請求名(RString 請求名) {
        this.請求名 = 請求名;
    }

    /**
     * 交付日を設定します。
     *
     * @param 交付日 RString
     */
    public void set交付日(RDate 交付日) {
        this.交付日 = 交付日;
    }

    /**
     * 市町村名を設定します。
     *
     * @param 市町村名 RString
     */
    public void set市町村名(RString 市町村名) {
        this.市町村名 = 市町村名;
    }

    /**
     * 請求代表者名を設定します。
     *
     * @param 請求代表者名 RString
     */
    public void set請求代表者名(RString 請求代表者名) {
        this.請求代表者名 = 請求代表者名;
    }

}
