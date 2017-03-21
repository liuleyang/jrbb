/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListParam {

    private AtenaSealListGamenJoho 画面情報;
    private RString 画面ID;
    private Association 地方公共団体情報;
    private TohyoJokyoJoho 投票資格情報;
    private RString 宛名シール;
    private RString 右上隅コード;
    private RString 右下隅コード;
    private RString 左下隅コード;
    //1：有権者、2：表示者
    private RString 出力対象;

    /**
     * コンストラクタです。
     *
     * @param 画面情報 AtenaSealListGamenJoho
     * @param 画面ID RString
     * @param 地方公共団体情報 Association
     * @param 投票資格情報 TohyoJokyoJoho
     * @param 宛名シール RString
     */
    public AtenaSealListParam(AtenaSealListGamenJoho 画面情報, RString 画面ID,
            Association 地方公共団体情報, TohyoJokyoJoho 投票資格情報, RString 宛名シール) {
        this.画面情報 = 画面情報;
        this.画面ID = 画面ID;
        this.地方公共団体情報 = 地方公共団体情報;
        this.投票資格情報 = 投票資格情報;
        this.宛名シール = 宛名シール;
    }

    /**
     * 出力対象
     *
     * @param 出力対象 RString
     */
    public void set出力対象(RString 出力対象) {
        this.出力対象 = 出力対象;
    }

    /**
     * 出力対象
     *
     * @return 出力対象
     */
    public RString get出力対象() {
        return 出力対象;
    }

    /**
     * 右上隅コードを返します。
     *
     * @return 右上隅コード RString
     */
    public RString get右上隅コード() {
        return this.右上隅コード;
    }

    /**
     * 右下隅コードを返します。
     *
     * @return 右下隅コード RString
     */
    public RString get右下隅コード() {
        return this.右下隅コード;
    }

    /**
     * 左下隅コードを返します。
     *
     * @return 左下隅コード RString
     */
    public RString get左下隅コード() {
        return this.左下隅コード;
    }

    /**
     * 右上隅コードを設定します。
     *
     * @param 右上隅コード RString
     */
    public void set右上隅コード(RString 右上隅コード) {
        this.右上隅コード = 右上隅コード;
    }

    /**
     * 右下隅コードを設定します。
     *
     * @param 右下隅コード RString
     */
    public void set右下隅コード(RString 右下隅コード) {
        this.右下隅コード = 右下隅コード;
    }

    /**
     * 左下隅コードを設定します。
     *
     * @param 左下隅コード RString
     */
    public void set左下隅コード(RString 左下隅コード) {
        this.左下隅コード = 左下隅コード;
    }

    /**
     * 画面情報を設定します。
     *
     * @param 画面情報 AtenaSealListGamenJoho
     */
    public void set画面情報(AtenaSealListGamenJoho 画面情報) {
        this.画面情報 = 画面情報;
    }

    /**
     * 画面IDを設定します。
     *
     * @param 画面ID RString
     */
    public void set画面ID(RString 画面ID) {
        this.画面ID = 画面ID;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

    /**
     * 投票資格情報を設定します。
     *
     * @param 投票資格情報 TohyoJokyoJoho
     */
    public void set投票資格情報(TohyoJokyoJoho 投票資格情報) {
        this.投票資格情報 = 投票資格情報;
    }

    /**
     * 宛名シールを設定します。
     *
     * @param 宛名シール RString
     */
    public void set宛名シール(RString 宛名シール) {
        this.宛名シール = 宛名シール;
    }

    /**
     * 画面情報を返します。
     *
     * @return 画面情報 AtenaSealListGamenJoho
     */
    public AtenaSealListGamenJoho get画面情報() {
        return this.画面情報;
    }

    /**
     * 画面IDを返します。
     *
     * @return 画面ID RString
     */
    public RString get画面ID() {
        return this.画面ID;
    }

    /**
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return this.地方公共団体情報;
    }

    /**
     * 投票資格情報を返します。
     *
     * @return 投票資格情報 TohyoJokyoJoho
     */
    public TohyoJokyoJoho get投票資格情報() {
        return this.投票資格情報;
    }

    /**
     * 宛名シールを返します。
     *
     * @return 宛名シール RString
     */
    public RString get宛名シール() {
        return this.宛名シール;
    }

}
