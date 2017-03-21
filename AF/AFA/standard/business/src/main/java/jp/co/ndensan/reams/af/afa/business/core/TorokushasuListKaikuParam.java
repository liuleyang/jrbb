/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListKaikuParam {

    private GoukeiJouhou 合計情報;
    private TorokushasuListKaikuParentParam 登録者情報;

    /**
     * コンストラクタです。
     *
     * @param 合計情報 GoukeiJouhou
     * @param 登録者情報 TorokushasuListKaikuParentParam
     */
    public TorokushasuListKaikuParam(GoukeiJouhou 合計情報, TorokushasuListKaikuParentParam 登録者情報) {
        this.合計情報 = 合計情報;
        this.登録者情報 = 登録者情報;
    }

    /**
     * 合計情報
     *
     * @param 合計情報 GoukeiJouhou
     */
    public void set合計情報(GoukeiJouhou 合計情報) {
        this.合計情報 = 合計情報;
    }

    /**
     * 合計情報
     *
     * @return 合計情報
     */
    public GoukeiJouhou get合計情報() {
        return 合計情報;
    }

    /**
     * 登録者情報
     *
     * @param 登録者情報 TorokushasuListKaikuParentParam
     */
    public void set登録者情報(TorokushasuListKaikuParentParam 登録者情報) {
        this.登録者情報 = 登録者情報;
    }

    /**
     * 登録者情報
     *
     * @return 登録者情報 TorokushasuListKaikuParentParam
     */
    public TorokushasuListKaikuParentParam get登録者情報() {
        return 登録者情報;
    }

}
