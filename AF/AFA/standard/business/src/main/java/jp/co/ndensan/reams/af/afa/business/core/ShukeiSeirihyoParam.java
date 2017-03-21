package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoParam {

    private final NippoGamenKyotsuKomoku 画面入力項目;
    private boolean 不在者投票フラグ;
    private RString ページ;
    private RString 選挙番号;
    private RString 投票区;
    private RString 本庁_男;
    private RString 本庁_女;
    private RString 本庁_計;
    private RString 支所_男;
    private RString 支所_女;
    private RString 支所_計;
    private RString 項目１_男;
    private RString 項目１_女;
    private RString 項目１_計;
    private RString 項目２_男;
    private RString 項目２_女;
    private RString 項目２_計;
    private RString 項目３_男;
    private RString 項目３_女;
    private RString 項目３_計;
    private RString 項目４_男;
    private RString 項目４_女;
    private RString 項目４_計;
    private RString 項目５_男;
    private RString 項目５_女;
    private RString 項目５_計;
    private RString 項目６_男;
    private RString 項目６_女;
    private RString 項目６_計;
    private RString 項目７_男;
    private RString 項目７_女;
    private RString 項目７_計;
    private RString 合計_男;
    private RString 合計_女;
    private RString 合計_計;
    private RString 累計_本庁_男;
    private RString 累計_本庁_女;
    private RString 累計_本庁_計;
    private RString 累計_支所_男;
    private RString 累計_支所_女;
    private RString 累計_支所_計;
    private RString 累計_項目１_男;
    private RString 累計_項目１_女;
    private RString 累計_項目１_計;
    private RString 累計_項目２_男;
    private RString 累計_項目２_女;
    private RString 累計_項目２_計;
    private RString 累計_項目３_男;
    private RString 累計_項目３_女;
    private RString 累計_項目３_計;
    private RString 累計_項目４_男;
    private RString 累計_項目４_女;
    private RString 累計_項目４_計;
    private RString 累計_項目５_男;
    private RString 累計_項目５_女;
    private RString 累計_項目５_計;
    private RString 累計_項目６_男;
    private RString 累計_項目６_女;
    private RString 累計_項目６_計;
    private RString 累計_項目７_男;
    private RString 累計_項目７_女;
    private RString 累計_項目７_計;
    private RString 累計_合計_男;
    private RString 累計_合計_女;
    private RString 累計_合計_計;

    /**
     * コンストラクタです。
     *
     * @param 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public ShukeiSeirihyoParam(
            NippoGamenKyotsuKomoku 画面入力項目) {
        this.画面入力項目 = 画面入力項目;
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
     * 不在者投票フラグを設定します。
     *
     * @param 不在者投票フラグ boolean
     */
    public void set不在者投票フラグ(boolean 不在者投票フラグ) {
        this.不在者投票フラグ = 不在者投票フラグ;
    }

    /**
     * ページを設定します。
     *
     * @param ページ RString
     */
    public void setページ(RString ページ) {
        this.ページ = ページ;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 投票区を設定します。
     *
     * @param 投票区 RString
     */
    public void set投票区(RString 投票区) {
        this.投票区 = 投票区;
    }

    /**
     * 本庁_男を設定します。
     *
     * @param 本庁_男 RString
     */
    public void set本庁_男(RString 本庁_男) {
        this.本庁_男 = 本庁_男;
    }

    /**
     * 本庁_女を設定します。
     *
     * @param 本庁_女 RString
     */
    public void set本庁_女(RString 本庁_女) {
        this.本庁_女 = 本庁_女;
    }

    /**
     * 本庁_計を設定します。
     *
     * @param 本庁_計 RString
     */
    public void set本庁_計(RString 本庁_計) {
        this.本庁_計 = 本庁_計;
    }

    /**
     * 支所_男を設定します。
     *
     * @param 支所_男 RString
     */
    public void set支所_男(RString 支所_男) {
        this.支所_男 = 支所_男;
    }

    /**
     * 支所_女を設定します。
     *
     * @param 支所_女 RString
     */
    public void set支所_女(RString 支所_女) {
        this.支所_女 = 支所_女;
    }

    /**
     * 支所_計を設定します。
     *
     * @param 支所_計 RString
     */
    public void set支所_計(RString 支所_計) {
        this.支所_計 = 支所_計;
    }

    /**
     * 項目１_男を設定します。
     *
     * @param 項目１_男 RString
     */
    public void set項目１_男(RString 項目１_男) {
        this.項目１_男 = 項目１_男;
    }

    /**
     * 項目１_女を設定します。
     *
     * @param 項目１_女 RString
     */
    public void set項目１_女(RString 項目１_女) {
        this.項目１_女 = 項目１_女;
    }

    /**
     * 項目１_計を設定します。
     *
     * @param 項目１_計 RString
     */
    public void set項目１_計(RString 項目１_計) {
        this.項目１_計 = 項目１_計;
    }

    /**
     * 項目２_男を設定します。
     *
     * @param 項目２_男 RString
     */
    public void set項目２_男(RString 項目２_男) {
        this.項目２_男 = 項目２_男;
    }

    /**
     * 項目２_女を設定します。
     *
     * @param 項目２_女 RString
     */
    public void set項目２_女(RString 項目２_女) {
        this.項目２_女 = 項目２_女;
    }

    /**
     * 項目２_計を設定します。
     *
     * @param 項目２_計 RString
     */
    public void set項目２_計(RString 項目２_計) {
        this.項目２_計 = 項目２_計;
    }

    /**
     * 項目３_男を設定します。
     *
     * @param 項目３_男 RString
     */
    public void set項目３_男(RString 項目３_男) {
        this.項目３_男 = 項目３_男;
    }

    /**
     * 項目３_女を設定します。
     *
     * @param 項目３_女 RString
     */
    public void set項目３_女(RString 項目３_女) {
        this.項目３_女 = 項目３_女;
    }

    /**
     * 項目３_計を設定します。
     *
     * @param 項目３_計 RString
     */
    public void set項目３_計(RString 項目３_計) {
        this.項目３_計 = 項目３_計;
    }

    /**
     * 項目４_男を設定します。
     *
     * @param 項目４_男 RString
     */
    public void set項目４_男(RString 項目４_男) {
        this.項目４_男 = 項目４_男;
    }

    /**
     * 項目４_女を設定します。
     *
     * @param 項目４_女 RString
     */
    public void set項目４_女(RString 項目４_女) {
        this.項目４_女 = 項目４_女;
    }

    /**
     * 項目４_計を設定します。
     *
     * @param 項目４_計 RString
     */
    public void set項目４_計(RString 項目４_計) {
        this.項目４_計 = 項目４_計;
    }

    /**
     * 項目５_男を設定します。
     *
     * @param 項目５_男 RString
     */
    public void set項目５_男(RString 項目５_男) {
        this.項目５_男 = 項目５_男;
    }

    /**
     * 項目５_女を設定します。
     *
     * @param 項目５_女 RString
     */
    public void set項目５_女(RString 項目５_女) {
        this.項目５_女 = 項目５_女;
    }

    /**
     * 項目５_計を設定します。
     *
     * @param 項目５_計 RString
     */
    public void set項目５_計(RString 項目５_計) {
        this.項目５_計 = 項目５_計;
    }

    /**
     * 項目６_男を設定します。
     *
     * @param 項目６_男 RString
     */
    public void set項目６_男(RString 項目６_男) {
        this.項目６_男 = 項目６_男;
    }

    /**
     * 項目６_女を設定します。
     *
     * @param 項目６_女 RString
     */
    public void set項目６_女(RString 項目６_女) {
        this.項目６_女 = 項目６_女;
    }

    /**
     * 項目６_計を設定します。
     *
     * @param 項目６_計 RString
     */
    public void set項目６_計(RString 項目６_計) {
        this.項目６_計 = 項目６_計;
    }

    /**
     * 項目７_男を設定します。
     *
     * @param 項目７_男 RString
     */
    public void set項目７_男(RString 項目７_男) {
        this.項目７_男 = 項目７_男;
    }

    /**
     * 項目７_女を設定します。
     *
     * @param 項目７_女 RString
     */
    public void set項目７_女(RString 項目７_女) {
        this.項目７_女 = 項目７_女;
    }

    /**
     * 項目７_計を設定します。
     *
     * @param 項目７_計 RString
     */
    public void set項目７_計(RString 項目７_計) {
        this.項目７_計 = 項目７_計;
    }

    /**
     * 合計_男を設定します。
     *
     * @param 合計_男 RString
     */
    public void set合計_男(RString 合計_男) {
        this.合計_男 = 合計_男;
    }

    /**
     * 合計_女を設定します。
     *
     * @param 合計_女 RString
     */
    public void set合計_女(RString 合計_女) {
        this.合計_女 = 合計_女;
    }

    /**
     * 合計_計を設定します。
     *
     * @param 合計_計 RString
     */
    public void set合計_計(RString 合計_計) {
        this.合計_計 = 合計_計;
    }

    /**
     * 累計_本庁_男を設定します。
     *
     * @param 累計_本庁_男 RString
     */
    public void set累計_本庁_男(RString 累計_本庁_男) {
        this.累計_本庁_男 = 累計_本庁_男;
    }

    /**
     * 累計_本庁_女を設定します。
     *
     * @param 累計_本庁_女 RString
     */
    public void set累計_本庁_女(RString 累計_本庁_女) {
        this.累計_本庁_女 = 累計_本庁_女;
    }

    /**
     * 累計_本庁_計を設定します。
     *
     * @param 累計_本庁_計 RString
     */
    public void set累計_本庁_計(RString 累計_本庁_計) {
        this.累計_本庁_計 = 累計_本庁_計;
    }

    /**
     * 累計_支所_男を設定します。
     *
     * @param 累計_支所_男 RString
     */
    public void set累計_支所_男(RString 累計_支所_男) {
        this.累計_支所_男 = 累計_支所_男;
    }

    /**
     * 累計_支所_女を設定します。
     *
     * @param 累計_支所_女 RString
     */
    public void set累計_支所_女(RString 累計_支所_女) {
        this.累計_支所_女 = 累計_支所_女;
    }

    /**
     * 累計_支所_計を設定します。
     *
     * @param 累計_支所_計 RString
     */
    public void set累計_支所_計(RString 累計_支所_計) {
        this.累計_支所_計 = 累計_支所_計;
    }

    /**
     * 累計_項目１_男を設定します。
     *
     * @param 累計_項目１_男 RString
     */
    public void set累計_項目１_男(RString 累計_項目１_男) {
        this.累計_項目１_男 = 累計_項目１_男;
    }

    /**
     * 累計_項目１_女を設定します。
     *
     * @param 累計_項目１_女 RString
     */
    public void set累計_項目１_女(RString 累計_項目１_女) {
        this.累計_項目１_女 = 累計_項目１_女;
    }

    /**
     * 累計_項目１_計を設定します。
     *
     * @param 累計_項目１_計 RString
     */
    public void set累計_項目１_計(RString 累計_項目１_計) {
        this.累計_項目１_計 = 累計_項目１_計;
    }

    /**
     * 累計_項目２_男を設定します。
     *
     * @param 累計_項目２_男 RString
     */
    public void set累計_項目２_男(RString 累計_項目２_男) {
        this.累計_項目２_男 = 累計_項目２_男;
    }

    /**
     * 累計_項目２_女を設定します。
     *
     * @param 累計_項目２_女 RString
     */
    public void set累計_項目２_女(RString 累計_項目２_女) {
        this.累計_項目２_女 = 累計_項目２_女;
    }

    /**
     * 累計_項目２_計を設定します。
     *
     * @param 累計_項目２_計 RString
     */
    public void set累計_項目２_計(RString 累計_項目２_計) {
        this.累計_項目２_計 = 累計_項目２_計;
    }

    /**
     * 累計_項目３_男を設定します。
     *
     * @param 累計_項目３_男 RString
     */
    public void set累計_項目３_男(RString 累計_項目３_男) {
        this.累計_項目３_男 = 累計_項目３_男;
    }

    /**
     * 累計_項目３_女を設定します。
     *
     * @param 累計_項目３_女 RString
     */
    public void set累計_項目３_女(RString 累計_項目３_女) {
        this.累計_項目３_女 = 累計_項目３_女;
    }

    /**
     * 累計_項目３_計を設定します。
     *
     * @param 累計_項目３_計 RString
     */
    public void set累計_項目３_計(RString 累計_項目３_計) {
        this.累計_項目３_計 = 累計_項目３_計;
    }

    /**
     * 累計_項目４_男を設定します。
     *
     * @param 累計_項目４_男 RString
     */
    public void set累計_項目４_男(RString 累計_項目４_男) {
        this.累計_項目４_男 = 累計_項目４_男;
    }

    /**
     * 累計_項目４_女を設定します。
     *
     * @param 累計_項目４_女 RString
     */
    public void set累計_項目４_女(RString 累計_項目４_女) {
        this.累計_項目４_女 = 累計_項目４_女;
    }

    /**
     * 累計_項目４_計を設定します。
     *
     * @param 累計_項目４_計 RString
     */
    public void set累計_項目４_計(RString 累計_項目４_計) {
        this.累計_項目４_計 = 累計_項目４_計;
    }

    /**
     * 累計_項目５_男を設定します。
     *
     * @param 累計_項目５_男 RString
     */
    public void set累計_項目５_男(RString 累計_項目５_男) {
        this.累計_項目５_男 = 累計_項目５_男;
    }

    /**
     * 累計_項目５_女を設定します。
     *
     * @param 累計_項目５_女 RString
     */
    public void set累計_項目５_女(RString 累計_項目５_女) {
        this.累計_項目５_女 = 累計_項目５_女;
    }

    /**
     * 累計_項目５_計を設定します。
     *
     * @param 累計_項目５_計 RString
     */
    public void set累計_項目５_計(RString 累計_項目５_計) {
        this.累計_項目５_計 = 累計_項目５_計;
    }

    /**
     * 累計_項目６_男を設定します。
     *
     * @param 累計_項目６_男 RString
     */
    public void set累計_項目６_男(RString 累計_項目６_男) {
        this.累計_項目６_男 = 累計_項目６_男;
    }

    /**
     * 累計_項目６_女を設定します。
     *
     * @param 累計_項目６_女 RString
     */
    public void set累計_項目６_女(RString 累計_項目６_女) {
        this.累計_項目６_女 = 累計_項目６_女;
    }

    /**
     * 累計_項目６_計を設定します。
     *
     * @param 累計_項目６_計 RString
     */
    public void set累計_項目６_計(RString 累計_項目６_計) {
        this.累計_項目６_計 = 累計_項目６_計;
    }

    /**
     * 累計_項目７_男を設定します。
     *
     * @param 累計_項目７_男 RString
     */
    public void set累計_項目７_男(RString 累計_項目７_男) {
        this.累計_項目７_男 = 累計_項目７_男;
    }

    /**
     * 累計_項目７_女を設定します。
     *
     * @param 累計_項目７_女 RString
     */
    public void set累計_項目７_女(RString 累計_項目７_女) {
        this.累計_項目７_女 = 累計_項目７_女;
    }

    /**
     * 累計_項目７_計を設定します。
     *
     * @param 累計_項目７_計 RString
     */
    public void set累計_項目７_計(RString 累計_項目７_計) {
        this.累計_項目７_計 = 累計_項目７_計;
    }

    /**
     * 累計_合計_男を設定します。
     *
     * @param 累計_合計_男 RString
     */
    public void set累計_合計_男(RString 累計_合計_男) {
        this.累計_合計_男 = 累計_合計_男;
    }

    /**
     * 累計_合計_女を設定します。
     *
     * @param 累計_合計_女 RString
     */
    public void set累計_合計_女(RString 累計_合計_女) {
        this.累計_合計_女 = 累計_合計_女;
    }

    /**
     * 累計_合計_計を設定します。
     *
     * @param 累計_合計_計 RString
     */
    public void set累計_合計_計(RString 累計_合計_計) {
        this.累計_合計_計 = 累計_合計_計;
    }

    /**
     * 不在者投票フラグを返します。
     *
     * @return 不在者投票フラグ
     */
    public boolean is不在者投票フラグ() {
        return this.不在者投票フラグ;
    }

    /**
     * ページを返します。
     *
     * @return ページ
     */
    public RString getページ() {
        return this.ページ;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public RString get選挙番号() {
        return this.選挙番号;
    }

    /**
     * 投票区を返します。
     *
     * @return 投票区
     */
    public RString get投票区() {
        return this.投票区;
    }

    /**
     * 本庁_男を返します。
     *
     * @return 本庁_男
     */
    public RString get本庁_男() {
        return this.本庁_男;
    }

    /**
     * 本庁_女を返します。
     *
     * @return 本庁_女
     */
    public RString get本庁_女() {
        return this.本庁_女;
    }

    /**
     * 本庁_計を返します。
     *
     * @return 本庁_計
     */
    public RString get本庁_計() {
        return this.本庁_計;
    }

    /**
     * 支所_男を返します。
     *
     * @return 支所_男
     */
    public RString get支所_男() {
        return this.支所_男;
    }

    /**
     * 支所_女を返します。
     *
     * @return 支所_女
     */
    public RString get支所_女() {
        return this.支所_女;
    }

    /**
     * 支所_計を返します。
     *
     * @return 支所_計
     */
    public RString get支所_計() {
        return this.支所_計;
    }

    /**
     * 項目１_男を返します。
     *
     * @return 項目１_男
     */
    public RString get項目１_男() {
        return this.項目１_男;
    }

    /**
     * 項目１_女を返します。
     *
     * @return 項目１_女
     */
    public RString get項目１_女() {
        return this.項目１_女;
    }

    /**
     * 項目１_計を返します。
     *
     * @return 項目１_計
     */
    public RString get項目１_計() {
        return this.項目１_計;
    }

    /**
     * 項目２_男を返します。
     *
     * @return 項目２_男
     */
    public RString get項目２_男() {
        return this.項目２_男;
    }

    /**
     * 項目２_女を返します。
     *
     * @return 項目２_女
     */
    public RString get項目２_女() {
        return this.項目２_女;
    }

    /**
     * 項目２_計を返します。
     *
     * @return 項目２_計
     */
    public RString get項目２_計() {
        return this.項目２_計;
    }

    /**
     * 項目３_男を返します。
     *
     * @return 項目３_男
     */
    public RString get項目３_男() {
        return this.項目３_男;
    }

    /**
     * 項目３_女を返します。
     *
     * @return 項目３_女
     */
    public RString get項目３_女() {
        return this.項目３_女;
    }

    /**
     * 項目３_計を返します。
     *
     * @return 項目３_計
     */
    public RString get項目３_計() {
        return this.項目３_計;
    }

    /**
     * 項目４_男を返します。
     *
     * @return 項目４_男
     */
    public RString get項目４_男() {
        return this.項目４_男;
    }

    /**
     * 項目４_女を返します。
     *
     * @return 項目４_女
     */
    public RString get項目４_女() {
        return this.項目４_女;
    }

    /**
     * 項目４_計を返します。
     *
     * @return 項目４_計
     */
    public RString get項目４_計() {
        return this.項目４_計;
    }

    /**
     * 項目５_男を返します。
     *
     * @return 項目５_男
     */
    public RString get項目５_男() {
        return this.項目５_男;
    }

    /**
     * 項目５_女を返します。
     *
     * @return 項目５_女
     */
    public RString get項目５_女() {
        return this.項目５_女;
    }

    /**
     * 項目５_計を返します。
     *
     * @return 項目５_計
     */
    public RString get項目５_計() {
        return this.項目５_計;
    }

    /**
     * 項目６_男を返します。
     *
     * @return 項目６_男
     */
    public RString get項目６_男() {
        return this.項目６_男;
    }

    /**
     * 項目６_女を返します。
     *
     * @return 項目６_女
     */
    public RString get項目６_女() {
        return this.項目６_女;
    }

    /**
     * 項目６_計を返します。
     *
     * @return 項目６_計
     */
    public RString get項目６_計() {
        return this.項目６_計;
    }

    /**
     * 項目７_男を返します。
     *
     * @return 項目７_男
     */
    public RString get項目７_男() {
        return this.項目７_男;
    }

    /**
     * 項目７_女を返します。
     *
     * @return 項目７_女
     */
    public RString get項目７_女() {
        return this.項目７_女;
    }

    /**
     * 項目７_計を返します。
     *
     * @return 項目７_計
     */
    public RString get項目７_計() {
        return this.項目７_計;
    }

    /**
     * 合計_男を返します。
     *
     * @return 合計_男
     */
    public RString get合計_男() {
        return this.合計_男;
    }

    /**
     * 合計_女を返します。
     *
     * @return 合計_女
     */
    public RString get合計_女() {
        return this.合計_女;
    }

    /**
     * 合計_計を返します。
     *
     * @return 合計_計
     */
    public RString get合計_計() {
        return this.合計_計;
    }

    /**
     * 累計_本庁_男を返します。
     *
     * @return 累計_本庁_男
     */
    public RString get累計_本庁_男() {
        return this.累計_本庁_男;
    }

    /**
     * 累計_本庁_女を返します。
     *
     * @return 累計_本庁_女
     */
    public RString get累計_本庁_女() {
        return this.累計_本庁_女;
    }

    /**
     * 累計_本庁_計を返します。
     *
     * @return 累計_本庁_計
     */
    public RString get累計_本庁_計() {
        return this.累計_本庁_計;
    }

    /**
     * 累計_支所_男を返します。
     *
     * @return 累計_支所_男
     */
    public RString get累計_支所_男() {
        return this.累計_支所_男;
    }

    /**
     * 累計_支所_女を返します。
     *
     * @return 累計_支所_女
     */
    public RString get累計_支所_女() {
        return this.累計_支所_女;
    }

    /**
     * 累計_支所_計を返します。
     *
     * @return 累計_支所_計
     */
    public RString get累計_支所_計() {
        return this.累計_支所_計;
    }

    /**
     * 累計_項目１_男を返します。
     *
     * @return 累計_項目１_男
     */
    public RString get累計_項目１_男() {
        return this.累計_項目１_男;
    }

    /**
     * 累計_項目１_女を返します。
     *
     * @return 累計_項目１_女
     */
    public RString get累計_項目１_女() {
        return this.累計_項目１_女;
    }

    /**
     * 累計_項目１_計を返します。
     *
     * @return 累計_項目１_計
     */
    public RString get累計_項目１_計() {
        return this.累計_項目１_計;
    }

    /**
     * 累計_項目２_男を返します。
     *
     * @return 累計_項目２_男
     */
    public RString get累計_項目２_男() {
        return this.累計_項目２_男;
    }

    /**
     * 累計_項目２_女を返します。
     *
     * @return 累計_項目２_女
     */
    public RString get累計_項目２_女() {
        return this.累計_項目２_女;
    }

    /**
     * 累計_項目２_計を返します。
     *
     * @return 累計_項目２_計
     */
    public RString get累計_項目２_計() {
        return this.累計_項目２_計;
    }

    /**
     * 累計_項目３_男を返します。
     *
     * @return 累計_項目３_男
     */
    public RString get累計_項目３_男() {
        return this.累計_項目３_男;
    }

    /**
     * 累計_項目３_女を返します。
     *
     * @return 累計_項目３_女
     */
    public RString get累計_項目３_女() {
        return this.累計_項目３_女;
    }

    /**
     * 累計_項目３_計を返します。
     *
     * @return 累計_項目３_計
     */
    public RString get累計_項目３_計() {
        return this.累計_項目３_計;
    }

    /**
     * 累計_項目４_男を返します。
     *
     * @return 累計_項目４_男
     */
    public RString get累計_項目４_男() {
        return this.累計_項目４_男;
    }

    /**
     * 累計_項目４_女を返します。
     *
     * @return 累計_項目４_女
     */
    public RString get累計_項目４_女() {
        return this.累計_項目４_女;
    }

    /**
     * 累計_項目４_計を返します。
     *
     * @return 累計_項目４_計
     */
    public RString get累計_項目４_計() {
        return this.累計_項目４_計;
    }

    /**
     * 累計_項目５_男を返します。
     *
     * @return 累計_項目５_男
     */
    public RString get累計_項目５_男() {
        return this.累計_項目５_男;
    }

    /**
     * 累計_項目５_女を返します。
     *
     * @return 累計_項目５_女
     */
    public RString get累計_項目５_女() {
        return this.累計_項目５_女;
    }

    /**
     * 累計_項目５_計を返します。
     *
     * @return 累計_項目５_計
     */
    public RString get累計_項目５_計() {
        return this.累計_項目５_計;
    }

    /**
     * 累計_項目６_男を返します。
     *
     * @return 累計_項目６_男
     */
    public RString get累計_項目６_男() {
        return this.累計_項目６_男;
    }

    /**
     * 累計_項目６_女を返します。
     *
     * @return 累計_項目６_女
     */
    public RString get累計_項目６_女() {
        return this.累計_項目６_女;
    }

    /**
     * 累計_項目６_計を返します。
     *
     * @return 累計_項目６_計
     */
    public RString get累計_項目６_計() {
        return this.累計_項目６_計;
    }

    /**
     * 累計_項目７_男を返します。
     *
     * @return 累計_項目７_男
     */
    public RString get累計_項目７_男() {
        return this.累計_項目７_男;
    }

    /**
     * 累計_項目７_女を返します。
     *
     * @return 累計_項目７_女
     */
    public RString get累計_項目７_女() {
        return this.累計_項目７_女;
    }

    /**
     * 累計_項目７_計を返します。
     *
     * @return 累計_項目７_計
     */
    public RString get累計_項目７_計() {
        return this.累計_項目７_計;
    }

    /**
     * 累計_合計_男を返します。
     *
     * @return 累計_合計_男
     */
    public RString get累計_合計_男() {
        return this.累計_合計_男;
    }

    /**
     * 累計_合計_女を返します。
     *
     * @return 累計_合計_女
     */
    public RString get累計_合計_女() {
        return this.累計_合計_女;
    }

    /**
     * 累計_合計_計を返します。
     *
     * @return 累計_合計_計
     */
    public RString get累計_合計_計() {
        return this.累計_合計_計;
    }

}
