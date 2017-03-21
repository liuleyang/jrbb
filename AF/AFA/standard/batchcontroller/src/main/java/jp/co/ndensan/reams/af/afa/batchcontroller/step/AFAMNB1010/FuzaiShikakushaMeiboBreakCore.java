/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.FuzaiShikakushaMeiboEntity;

/**
 * 不在者投票資格者名簿のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0030-036 liss
 */
public class FuzaiShikakushaMeiboBreakCore {

    private List<FuzaiShikakushaMeiboEntity> lists;

    /**
     * コンストラクス。
     *
     */
    public FuzaiShikakushaMeiboBreakCore() {
        lists = new ArrayList<>();
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(FuzaiShikakushaMeiboEntity current) {
        if (null != current) {
            lists.add(current);
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<FuzaiShikakushaMeiboEntity>
     */
    public List<FuzaiShikakushaMeiboEntity> keyBreakProcess(FuzaiShikakushaMeiboEntity before, FuzaiShikakushaMeiboEntity current) {

        List<FuzaiShikakushaMeiboEntity> rslt = null;
        if (isNewData(before, current)) {
            rslt = lists;
            lists = new ArrayList<>();
            return rslt;
        }
        return rslt;
    }

    /**
     * createLastProcess
     *
     * @return List<FuzaiShikakushaMeiboEntity>
     */
    public List<FuzaiShikakushaMeiboEntity> createLastProcess() {
        return lists;
    }

    private boolean isNewData(FuzaiShikakushaMeiboEntity before, FuzaiShikakushaMeiboEntity current) {

        return !before.getFuzaishaTohyoShikakuEntity().getTohyoShikakuShurui().equals(
                current.getFuzaishaTohyoShikakuEntity().getTohyoShikakuShurui())
                || !before.getBreakPage().equals(current.getBreakPage());

    }

}
