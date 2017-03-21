package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoParam {

    private TohyoJyohyoInfo 投票状況情報;
    private final NippoGamenKyotsuKomoku 画面入力項目;

    private RString 本庁数;
    private RString 本庁点字数;
    private RString 施設数;
    private RString 施設点字数;
    private RString 郵便数;
    private RString 郵便点字数;
    private RString 他市町村数;
    private RString 他市町村点字数;
    private RString 支所数;
    private RString 支所点字数;
    private RString 合計数;
    private RString 合計点字数;

    /**
     * コンストラクタです。
     *
     * @param 投票状況情報 TohyoJyohyoInfo
     * @param 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public FuzaihsaNippoParam(
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
     * 画面入力項目
     *
     * @return 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public NippoGamenKyotsuKomoku get画面入力項目() {
        return 画面入力項目;
    }

    /**
     * 本庁数を設定します。
     *
     * @param 本庁数 RString
     */
    public void set本庁数(RString 本庁数) {
        this.本庁数 = 本庁数;
    }

    /**
     * 本庁点字数を設定します。
     *
     * @param 本庁点字数 RString
     */
    public void set本庁点字数(RString 本庁点字数) {
        this.本庁点字数 = 本庁点字数;
    }

    /**
     * 施設数を設定します。
     *
     * @param 施設数 RString
     */
    public void set施設数(RString 施設数) {
        this.施設数 = 施設数;
    }

    /**
     * 施設点字数を設定します。
     *
     * @param 施設点字数 RString
     */
    public void set施設点字数(RString 施設点字数) {
        this.施設点字数 = 施設点字数;
    }

    /**
     * 郵便数を設定します。
     *
     * @param 郵便数 RString
     */
    public void set郵便数(RString 郵便数) {
        this.郵便数 = 郵便数;
    }

    /**
     * 郵便点字数を設定します。
     *
     * @param 郵便点字数 RString
     */
    public void set郵便点字数(RString 郵便点字数) {
        this.郵便点字数 = 郵便点字数;
    }

    /**
     * 他市町村数を設定します。
     *
     * @param 他市町村数 RString
     */
    public void set他市町村数(RString 他市町村数) {
        this.他市町村数 = 他市町村数;
    }

    /**
     * 他市町村点字数を設定します。
     *
     * @param 他市町村点字数 RString
     */
    public void set他市町村点字数(RString 他市町村点字数) {
        this.他市町村点字数 = 他市町村点字数;
    }

    /**
     * 支所数を設定します。
     *
     * @param 支所数 RString
     */
    public void set支所数(RString 支所数) {
        this.支所数 = 支所数;
    }

    /**
     * 支所点字数を設定します。
     *
     * @param 支所点字数 RString
     */
    public void set支所点字数(RString 支所点字数) {
        this.支所点字数 = 支所点字数;
    }

    /**
     * 合計数を設定します。
     *
     * @param 合計数 RString
     */
    public void set合計数(RString 合計数) {
        this.合計数 = 合計数;
    }

    /**
     * 合計点字数を設定します。
     *
     * @param 合計点字数 RString
     */
    public void set合計点字数(RString 合計点字数) {
        this.合計点字数 = 合計点字数;
    }

    /**
     * 本庁数を返します。
     *
     * @return 本庁数
     */
    public RString get本庁数() {
        return this.本庁数;
    }

    /**
     * 本庁点字数を返します。
     *
     * @return 本庁点字数
     */
    public RString get本庁点字数() {
        return this.本庁点字数;
    }

    /**
     * 施設数を返します。
     *
     * @return 施設数
     */
    public RString get施設数() {
        return this.施設数;
    }

    /**
     * 施設点字数を返します。
     *
     * @return 施設点字数
     */
    public RString get施設点字数() {
        return this.施設点字数;
    }

    /**
     * 郵便数を返します。
     *
     * @return 郵便数
     */
    public RString get郵便数() {
        return this.郵便数;
    }

    /**
     * 郵便点字数を返します。
     *
     * @return 郵便点字数
     */
    public RString get郵便点字数() {
        return this.郵便点字数;
    }

    /**
     * 他市町村数を返します。
     *
     * @return 他市町村数
     */
    public RString get他市町村数() {
        return this.他市町村数;
    }

    /**
     * 他市町村点字数を返します。
     *
     * @return 他市町村点字数
     */
    public RString get他市町村点字数() {
        return this.他市町村点字数;
    }

    /**
     * 支所数を返します。
     *
     * @return 支所数
     */
    public RString get支所数() {
        return this.支所数;
    }

    /**
     * 支所点字数を返します。
     *
     * @return 支所点字数
     */
    public RString get支所点字数() {
        return this.支所点字数;
    }

    /**
     * 合計数を返します。
     *
     * @return 合計数
     */
    public RString get合計数() {
        return this.合計数;
    }

    /**
     * 合計点字数を返します。
     *
     * @return 合計点字数
     */
    public RString get合計点字数() {
        return this.合計点字数;
    }

}
