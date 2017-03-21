/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListParam {

    private final NyujoukenGamenModel 入場券画面入力情報;
    private final SetaiichiranhyouJouhou 世帯一覧表情報;

    private RString listMeisai_2;

    /**
     * コンストラクタです。
     *
     * @param 入場券画面入力情報 NyujoukenGamenModel
     * @param 世帯一覧表情報 SetaiichiranhyouJouhou
     */
    public NninIjoSetaiListParam(NyujoukenGamenModel 入場券画面入力情報, SetaiichiranhyouJouhou 世帯一覧表情報) {
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

    /**
     * 名簿番号
     *
     * @return listMeisai_2 RString
     */
    public RString getListMeisai_2() {
        return listMeisai_2;
    }

    /**
     * 名簿番号
     *
     * @param listMeisai_2 RString
     */
    public void setListMeisai_2(RString listMeisai_2) {
        this.listMeisai_2 = listMeisai_2;
    }

}
