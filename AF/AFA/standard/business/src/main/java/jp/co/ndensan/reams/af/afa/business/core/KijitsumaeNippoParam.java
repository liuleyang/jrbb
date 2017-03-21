package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoParam {

    private TohyoJyohyoInfo 投票状況情報;
    private final NippoGamenKyotsuKomoku 画面入力項目;

    private RString 施設名称;
    private RString 投票日;
    private RString 投票数_男;
    private RString 投票数_女;
    private RString 投票数_計;
    private RString 内数_点字用紙_男;
    private RString 内数_点字用紙_女;
    private RString 内数_点字用紙_計;
    private RString 内数_代理投票_男;
    private RString 内数_代理投票_女;
    private RString 内数_代理投票_計;

    /**
     * コンストラクタです。
     *
     * @param 投票状況情報 TohyoJyohyoInfo
     * @param 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public KijitsumaeNippoParam(
            TohyoJyohyoInfo 投票状況情報,
            NippoGamenKyotsuKomoku 画面入力項目) {
        this.投票状況情報 = 投票状況情報;
        this.画面入力項目 = 画面入力項目;
    }

    /**
     * 投票状況情報
     *
     * @return 投票状況情報 TohyoJyohyoInfo
     */
    public TohyoJyohyoInfo get投票状況情報() {
        return 投票状況情報;
    }

    /**
     * 投票状況情報
     *
     * @param 投票状況情報 TohyoJyohyoInfo
     */
    public void set投票状況情報(TohyoJyohyoInfo 投票状況情報) {
        this.投票状況情報 = 投票状況情報;
    }

    /**
     * 画面入力項目
     *
     * @return 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public NippoGamenKyotsuKomoku get画面入力項目() {
        return 画面入力項目;
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
     * 投票日を設定します。
     *
     * @param 投票日 RString
     */
    public void set投票日(RString 投票日) {
        this.投票日 = 投票日;
    }

    /**
     * 投票数_男を設定します。
     *
     * @param 投票数_男 RString
     */
    public void set投票数_男(RString 投票数_男) {
        this.投票数_男 = 投票数_男;
    }

    /**
     * 投票数_女を設定します。
     *
     * @param 投票数_女 RString
     */
    public void set投票数_女(RString 投票数_女) {
        this.投票数_女 = 投票数_女;
    }

    /**
     * 投票数_計を設定します。
     *
     * @param 投票数_計 RString
     */
    public void set投票数_計(RString 投票数_計) {
        this.投票数_計 = 投票数_計;
    }

    /**
     * 内数_点字用紙_男を設定します。
     *
     * @param 内数_点字用紙_男 RString
     */
    public void set内数_点字用紙_男(RString 内数_点字用紙_男) {
        this.内数_点字用紙_男 = 内数_点字用紙_男;
    }

    /**
     * 内数_点字用紙_女を設定します。
     *
     * @param 内数_点字用紙_女 RString
     */
    public void set内数_点字用紙_女(RString 内数_点字用紙_女) {
        this.内数_点字用紙_女 = 内数_点字用紙_女;
    }

    /**
     * 内数_点字用紙_計を設定します。
     *
     * @param 内数_点字用紙_計 RString
     */
    public void set内数_点字用紙_計(RString 内数_点字用紙_計) {
        this.内数_点字用紙_計 = 内数_点字用紙_計;
    }

    /**
     * 内数_代理投票_男を設定します。
     *
     * @param 内数_代理投票_男 RString
     */
    public void set内数_代理投票_男(RString 内数_代理投票_男) {
        this.内数_代理投票_男 = 内数_代理投票_男;
    }

    /**
     * 内数_代理投票_女を設定します。
     *
     * @param 内数_代理投票_女 RString
     */
    public void set内数_代理投票_女(RString 内数_代理投票_女) {
        this.内数_代理投票_女 = 内数_代理投票_女;
    }

    /**
     * 内数_代理投票_計を設定します。
     *
     * @param 内数_代理投票_計 RString
     */
    public void set内数_代理投票_計(RString 内数_代理投票_計) {
        this.内数_代理投票_計 = 内数_代理投票_計;
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return this.施設名称;
    }

    /**
     * 投票日を返します。
     *
     * @return 投票日
     */
    public RString get投票日() {
        return this.投票日;
    }

    /**
     * 投票数_男を返します。
     *
     * @return 投票数_男
     */
    public RString get投票数_男() {
        return this.投票数_男;
    }

    /**
     * 投票数_女を返します。
     *
     * @return 投票数_女
     */
    public RString get投票数_女() {
        return this.投票数_女;
    }

    /**
     * 投票数_計を返します。
     *
     * @return 投票数_計
     */
    public RString get投票数_計() {
        return this.投票数_計;
    }

    /**
     * 内数_点字用紙_男を返します。
     *
     * @return 内数_点字用紙_男
     */
    public RString get内数_点字用紙_男() {
        return this.内数_点字用紙_男;
    }

    /**
     * 内数_点字用紙_女を返します。
     *
     * @return 内数_点字用紙_女
     */
    public RString get内数_点字用紙_女() {
        return this.内数_点字用紙_女;
    }

    /**
     * 内数_点字用紙_計を返します。
     *
     * @return 内数_点字用紙_計
     */
    public RString get内数_点字用紙_計() {
        return this.内数_点字用紙_計;
    }

    /**
     * 内数_代理投票_男を返します。
     *
     * @return 内数_代理投票_男
     */
    public RString get内数_代理投票_男() {
        return this.内数_代理投票_男;
    }

    /**
     * 内数_代理投票_女を返します。
     *
     * @return 内数_代理投票_女
     */
    public RString get内数_代理投票_女() {
        return this.内数_代理投票_女;
    }

    /**
     * 内数_代理投票_計を返します。
     *
     * @return 内数_代理投票_計
     */
    public RString get内数_代理投票_計() {
        return this.内数_代理投票_計;
    }

}
