/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoParam {

    private final NyujoukenGamenModel 入場券画面入力情報;
    private final SetaiichiranhyouJouhou 世帯一覧表情報;

    /**
     * コンストラクタです。
     *
     * @param 入場券画面入力情報 NyujoukenGamenModel
     * @param 世帯一覧表情報 SetaiichiranhyouJouhou
     */
    public NyujokenMaisuhyoParam(NyujoukenGamenModel 入場券画面入力情報, SetaiichiranhyouJouhou 世帯一覧表情報) {
        this.入場券画面入力情報 = 入場券画面入力情報;
        this.世帯一覧表情報 = 世帯一覧表情報;
    }

    /**
     * 入場券画面入力情報
     *
     * @return 入場券画面入力情報 NyujoukenGamenModel
     */
    public NyujoukenGamenModel get入場券画面入力情報() {
        return 入場券画面入力情報;
    }

    /**
     * 世帯一覧表情報
     *
     * @return 世帯一覧表情報 SetaiichiranhyouJouhou
     */
    public SetaiichiranhyouJouhou get世帯一覧表情報() {
        return 世帯一覧表情報;
    }
}
