/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 投票率集計表帳票出力のページ用対象クラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyoritsuData {

    private TohyoritsuListData 年代Data = new TohyoritsuListData();
    private TohyoritsuListData 当日分Data = new TohyoritsuListData();
    private TohyoritsuListData 期日前不在者分Data = new TohyoritsuListData();
    private NenreibetsuTohyoritsuReportSource.DataType type;
    private ZenjitsuCommonJohoItem commonHeader;
    private TohyokekkaPrintEntity entity;
    private AFABTE505SelectProcessParameter param;

    // CSV用
    private Decimal 行政区別有権者男数 = Decimal.ZERO;
    private Decimal 行政区別有権者女数 = Decimal.ZERO;
    private Decimal 投票区別有権者男数 = Decimal.ZERO;
    private Decimal 投票区別有権者女数 = Decimal.ZERO;
    private Decimal 選挙別有権者男数 = Decimal.ZERO;
    private Decimal 選挙別有権者女数 = Decimal.ZERO;

    /**
     * 行政区別有権者数を返す。
     *
     * @return 行政区別有権者数
     */
    public Decimal get行政区別有権者数() {
        if (null == 行政区別有権者男数 || null == 行政区別有権者女数) {
            return null;
        }
        return 行政区別有権者男数.add(行政区別有権者女数);
    }

    /**
     * 投票区別有権者数を返す。
     *
     * @return 投票区別有権者数
     */
    public Decimal get投票区別有権者数() {
        if (null == 投票区別有権者男数 || null == 投票区別有権者女数) {
            return null;
        }
        return 投票区別有権者男数.add(投票区別有権者女数);
    }

    /**
     * 選挙別有権者数を返す。
     *
     * @return 選挙別有権者数
     */
    public Decimal get選挙別有権者数() {
        if (null == 選挙別有権者男数 || null == 選挙別有権者女数) {
            return null;
        }
        return 選挙別有権者男数.add(選挙別有権者女数);
    }

}
