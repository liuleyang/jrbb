/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面側から帳票作成入力項目
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ZaigaiSakuseiChohyo {

    private FlexibleDate 発行日;
    private RString 発行番号_第;
    private RString 発行番号_号;
    private RString 発行番号;
    private RString 選管委員長名;

    /**
     * 発行日
     *
     * @return 発行日 FlexibleDate
     */
    public FlexibleDate get発行日() {
        return 発行日;
    }

    /**
     * 発行番号_第
     *
     * @return 発行番号_第
     */
    public RString get発行番号_第() {
        return 発行番号_第;
    }

    /**
     * 発行番号_号
     *
     * @return 発行番号_号
     */
    public RString get発行番号_号() {
        return 発行番号_号;
    }

    /**
     * 発行番号
     *
     * @return 発行番号
     */
    public RString get発行番号() {
        return 発行番号;
    }

    /**
     * 選管委員長名
     *
     * @return 選管委員長名
     */
    public RString get選管委員長名() {
        return 選管委員長名;
    }

    /**
     * 発行日
     *
     * @param 発行日 FlexibleDate
     */
    public void set発行日(FlexibleDate 発行日) {
        this.発行日 = 発行日;
    }

    /**
     * 発行番号
     *
     * @param 発行番号 RString
     */
    public void set発行番号(RString 発行番号) {
        this.発行番号 = 発行番号;
    }

    /**
     * 選管委員長名
     *
     * @param 選管委員長名 RString
     */
    public void set選管委員長名(RString 選管委員長名) {
        this.選管委員長名 = 選管委員長名;
    }

    /**
     * 発行番号_第
     *
     * @param 発行番号_第 RString
     */
    public void set発行番号_第(RString 発行番号_第) {
        this.発行番号_第 = 発行番号_第;
    }

    /**
     * 発行番号_号
     *
     * @param 発行番号_号 RString
     */
    public void set発行番号_号(RString 発行番号_号) {
        this.発行番号_号 = 発行番号_号;
    }

}
