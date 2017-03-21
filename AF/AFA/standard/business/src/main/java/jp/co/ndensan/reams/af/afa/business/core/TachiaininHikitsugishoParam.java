/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoParam {

    private final RTime 立会時間_開始時刻;
    private final RTime 立会時間_終了時刻;
    private final boolean is異常なし;
    private final boolean is異常あり;
    private final RString 異常内容;
    private final RString 投票所名;
    private final List<RString> 投票用紙再交付者情報の氏名リスト;
    private final List<RString> 決定書または裁決書により投票をした者情報の氏名リスト;
    private final List<RString> 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト;
    private final List<RString> 点字により投票をした者情報の氏名リスト;
    private final List<RString> 代理投票をした者情報の氏名リスト;
    private final List<RString> 投票拒否の決定をした者情報の氏名リスト;
    private RString 再交付氏名１列目;
    private RString 再交付氏名２列目;
    private RString 決定書氏名１列目;
    private RString 決定書氏名２列目;
    private RString 返還不在者氏名１列目;
    private RString 返還不在者氏名２列目;
    private RString 点字氏名１列目;
    private RString 点字氏名２列目;
    private RString 代理氏名１列目;
    private RString 代理氏名２列目;
    private RString 拒否氏名１列目;
    private RString 拒否氏名２列目;

    /**
     * コンストラクタです。
     *
     * @param 立会時間_開始時刻 RTime
     * @param 立会時間_終了時刻 RTime
     * @param is異常なし boolean
     * @param is異常あり boolean
     * @param 異常内容 RString
     * @param 投票所名 RString
     * @param 投票用紙再交付者情報の氏名リスト List<RString>
     * @param 決定書または裁決書により投票をした者情報の氏名リスト List<RString>
     * @param 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト List<RString>
     * @param 点字により投票をした者情報の氏名リスト List<RString>
     * @param 代理投票をした者情報の氏名リスト List<RString>
     * @param 投票拒否の決定をした者情報の氏名リスト List<RString>
     */
    public TachiaininHikitsugishoParam(
            RTime 立会時間_開始時刻,
            RTime 立会時間_終了時刻,
            boolean is異常なし,
            boolean is異常あり,
            RString 異常内容,
            RString 投票所名,
            List<RString> 投票用紙再交付者情報の氏名リスト,
            List<RString> 決定書または裁決書により投票をした者情報の氏名リスト,
            List<RString> 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト,
            List<RString> 点字により投票をした者情報の氏名リスト,
            List<RString> 代理投票をした者情報の氏名リスト,
            List<RString> 投票拒否の決定をした者情報の氏名リスト) {
        this.立会時間_開始時刻 = 立会時間_開始時刻;
        this.立会時間_終了時刻 = 立会時間_終了時刻;
        this.is異常なし = is異常なし;
        this.is異常あり = is異常あり;
        this.異常内容 = 異常内容;
        this.投票所名 = 投票所名;
        this.投票用紙再交付者情報の氏名リスト = 投票用紙再交付者情報の氏名リスト;
        this.決定書または裁決書により投票をした者情報の氏名リスト = 決定書または裁決書により投票をした者情報の氏名リスト;
        this.不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト = 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト;
        this.点字により投票をした者情報の氏名リスト = 点字により投票をした者情報の氏名リスト;
        this.代理投票をした者情報の氏名リスト = 代理投票をした者情報の氏名リスト;
        this.投票拒否の決定をした者情報の氏名リスト = 投票拒否の決定をした者情報の氏名リスト;
    }

    /**
     * 立会時間_開始時刻を返します。
     *
     * @return 立会時間_開始時刻
     */
    public RTime get立会時間_開始時刻() {
        return this.立会時間_開始時刻;
    }

    /**
     * 立会時間_終了時刻を返します。
     *
     * @return 立会時間_終了時刻
     */
    public RTime get立会時間_終了時刻() {
        return this.立会時間_終了時刻;
    }

    /**
     * is異常なしを返します。
     *
     * @return is異常なし
     */
    public boolean is異常なし() {
        return this.is異常なし;
    }

    /**
     * is異常ありを返します。
     *
     * @return is異常あり
     */
    public boolean is異常あり() {
        return this.is異常あり;
    }

    /**
     * 異常内容を返します。
     *
     * @return 異常内容
     */
    public RString get異常内容() {
        return this.異常内容;
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
     * 投票用紙再交付者情報の氏名リストを返します。
     *
     * @return 投票用紙再交付者情報の氏名リスト
     */
    public List<RString> get投票用紙再交付者情報の氏名リスト() {
        return this.投票用紙再交付者情報の氏名リスト;
    }

    /**
     * 決定書または裁決書により投票をした者情報の氏名リストを返します。
     *
     * @return 決定書または裁決書により投票をした者情報の氏名リスト
     */
    public List<RString> get決定書または裁決書により投票をした者情報の氏名リスト() {
        return this.決定書または裁決書により投票をした者情報の氏名リスト;
    }

    /**
     * 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リストを返します。
     *
     * @return 不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト
     */
    public List<RString> get不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト() {
        return this.不在者投票の用紙及び封筒を返還して投票した者情報の氏名リスト;
    }

    /**
     * 点字により投票をした者情報の氏名リストを返します。
     *
     * @return 点字により投票をした者情報の氏名リスト
     */
    public List<RString> get点字により投票をした者情報の氏名リスト() {
        return this.点字により投票をした者情報の氏名リスト;
    }

    /**
     * 代理投票をした者情報の氏名リストを返します。
     *
     * @return 代理投票をした者情報の氏名リスト
     */
    public List<RString> get代理投票をした者情報の氏名リスト() {
        return this.代理投票をした者情報の氏名リスト;
    }

    /**
     * 投票拒否の決定をした者情報の氏名リストを返します。
     *
     * @return 投票拒否の決定をした者情報の氏名リスト
     */
    public List<RString> get投票拒否の決定をした者情報の氏名リスト() {
        return this.投票拒否の決定をした者情報の氏名リスト;
    }

    /**
     * 再交付氏名１列目を返します。
     *
     * @return 再交付氏名１列目
     */
    public RString get再交付氏名１列目() {
        return this.再交付氏名１列目;
    }

    /**
     * 再交付氏名２列目を返します。
     *
     * @return 再交付氏名２列目
     */
    public RString get再交付氏名２列目() {
        return this.再交付氏名２列目;
    }

    /**
     * 決定書氏名１列目を返します。
     *
     * @return 決定書氏名１列目
     */
    public RString get決定書氏名１列目() {
        return this.決定書氏名１列目;
    }

    /**
     * 決定書氏名２列目を返します。
     *
     * @return 決定書氏名２列目
     */
    public RString get決定書氏名２列目() {
        return this.決定書氏名２列目;
    }

    /**
     * 返還不在者氏名１列目を返します。
     *
     * @return 返還不在者氏名１列目
     */
    public RString get返還不在者氏名１列目() {
        return this.返還不在者氏名１列目;
    }

    /**
     * 返還不在者氏名２列目を返します。
     *
     * @return 返還不在者氏名２列目
     */
    public RString get返還不在者氏名２列目() {
        return this.返還不在者氏名２列目;
    }

    /**
     * 点字氏名１列目を返します。
     *
     * @return 点字氏名１列目
     */
    public RString get点字氏名１列目() {
        return this.点字氏名１列目;
    }

    /**
     * 点字氏名２列目を返します。
     *
     * @return 点字氏名２列目
     */
    public RString get点字氏名２列目() {
        return this.点字氏名２列目;
    }

    /**
     * 代理氏名１列目を返します。
     *
     * @return 代理氏名１列目
     */
    public RString get代理氏名１列目() {
        return this.代理氏名１列目;
    }

    /**
     * 代理氏名２列目を返します。
     *
     * @return 代理氏名２列目
     */
    public RString get代理氏名２列目() {
        return this.代理氏名２列目;
    }

    /**
     * 拒否氏名１列目を返します。
     *
     * @return 拒否氏名１列目
     */
    public RString get拒否氏名１列目() {
        return this.拒否氏名１列目;
    }

    /**
     * 拒否氏名２列目を返します。
     *
     * @return 拒否氏名２列目
     */
    public RString get拒否氏名２列目() {
        return this.拒否氏名２列目;
    }

    /**
     * 再交付氏名１列目を設定します。
     *
     * @param 再交付氏名１列目 RString
     */
    public void set再交付氏名１列目(RString 再交付氏名１列目) {
        this.再交付氏名１列目 = 再交付氏名１列目;
    }

    /**
     * 再交付氏名２列目を設定します。
     *
     * @param 再交付氏名２列目 RString
     */
    public void set再交付氏名２列目(RString 再交付氏名２列目) {
        this.再交付氏名２列目 = 再交付氏名２列目;
    }

    /**
     * 決定書氏名１列目を設定します。
     *
     * @param 決定書氏名１列目 RString
     */
    public void set決定書氏名１列目(RString 決定書氏名１列目) {
        this.決定書氏名１列目 = 決定書氏名１列目;
    }

    /**
     * 決定書氏名２列目を設定します。
     *
     * @param 決定書氏名２列目 RString
     */
    public void set決定書氏名２列目(RString 決定書氏名２列目) {
        this.決定書氏名２列目 = 決定書氏名２列目;
    }

    /**
     * 返還不在者氏名１列目を設定します。
     *
     * @param 返還不在者氏名１列目 RString
     */
    public void set返還不在者氏名１列目(RString 返還不在者氏名１列目) {
        this.返還不在者氏名１列目 = 返還不在者氏名１列目;
    }

    /**
     * 返還不在者氏名２列目を設定します。
     *
     * @param 返還不在者氏名２列目 RString
     */
    public void set返還不在者氏名２列目(RString 返還不在者氏名２列目) {
        this.返還不在者氏名２列目 = 返還不在者氏名２列目;
    }

    /**
     * 点字氏名１列目を設定します。
     *
     * @param 点字氏名１列目 RString
     */
    public void set点字氏名１列目(RString 点字氏名１列目) {
        this.点字氏名１列目 = 点字氏名１列目;
    }

    /**
     * 点字氏名２列目を設定します。
     *
     * @param 点字氏名２列目 RString
     */
    public void set点字氏名２列目(RString 点字氏名２列目) {
        this.点字氏名２列目 = 点字氏名２列目;
    }

    /**
     * 代理氏名１列目を設定します。
     *
     * @param 代理氏名１列目 RString
     */
    public void set代理氏名１列目(RString 代理氏名１列目) {
        this.代理氏名１列目 = 代理氏名１列目;
    }

    /**
     * 代理氏名２列目を設定します。
     *
     * @param 代理氏名２列目 RString
     */
    public void set代理氏名２列目(RString 代理氏名２列目) {
        this.代理氏名２列目 = 代理氏名２列目;
    }

    /**
     * 拒否氏名１列目を設定します。
     *
     * @param 拒否氏名１列目 RString
     */
    public void set拒否氏名１列目(RString 拒否氏名１列目) {
        this.拒否氏名１列目 = 拒否氏名１列目;
    }

    /**
     * 拒否氏名２列目を設定します。
     *
     * @param 拒否氏名２列目 RString
     */
    public void set拒否氏名２列目(RString 拒否氏名２列目) {
        this.拒否氏名２列目 = 拒否氏名２列目;
    }

}
