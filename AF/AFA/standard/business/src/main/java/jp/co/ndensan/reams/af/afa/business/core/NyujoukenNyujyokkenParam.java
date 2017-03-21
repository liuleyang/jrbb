/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 投票所入場券情報
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujoukenNyujyokkenParam {

    private SoufusakiJouhou 送付先情報;
    private List<MeisaiJouhou> 明細情報リスト;

    /**
     * コンストラクタです。
     *
     *
     */
    public NyujoukenNyujyokkenParam() {
        送付先情報 = new SoufusakiJouhou();
        明細情報リスト = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     *
     * @param 送付先情報 SoufusakiJouhou
     *
     * @param 明細情報リスト List<MeisaiJouhou>
     *
     */
    public NyujoukenNyujyokkenParam(SoufusakiJouhou 送付先情報,
            List<MeisaiJouhou> 明細情報リスト) {

        this.送付先情報 = 送付先情報;

        this.明細情報リスト = 明細情報リスト;

    }

    /**
     * 送付先情報
     *
     * @return 送付先情報 SoufusakiJouhou
     */
    public SoufusakiJouhou get送付先情報() {
        return 送付先情報;
    }

    /**
     * 明細情報リスト
     *
     * @return 明細情報リスト List<MeisaiJouhou>
     */
    public List<MeisaiJouhou> get明細情報リスト() {
        return 明細情報リスト;
    }

    /**
     * 送付先情報
     *
     * @param 送付先情報 SoufusakiJouhou
     */
    public void set送付先情報(SoufusakiJouhou 送付先情報) {
        this.送付先情報 = 送付先情報;
    }

    /**
     * 明細情報リスト
     *
     * @param 明細情報リスト List<MeisaiJouhou>
     */
    public void set明細情報リスト(List<MeisaiJouhou> 明細情報リスト) {
        this.明細情報リスト = 明細情報リスト;
    }

}
