/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.TohyouSha;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 当日/期日前投票録帳票用対象クラスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyorokuChohyo {

    private FlexibleDate 執行年月日;
    private RString タイトル;
    private FlexibleDate 投票年月日;
    private RString 設置状況;
    private RString 投票区コード;
    private RString 投票場所;
    private FlexibleDate 投票期間_開始年月日;
    private FlexibleDate 投票期間_終了年月日;
    private List<TohyouSha> 選任リスト;
    private List<TohyouSha> 投票管理者リスト;
    private RTime 投票時刻開始;
    private RTime 投票時刻閉鎖;
    private Decimal 投票者男数;
    private Decimal 仮投票者男数;
    private Decimal 名簿登録者男数;
    private Decimal 当日有権者男数;
    private Decimal 投票者女数;
    private Decimal 仮投票者女数;
    private Decimal 名簿登録者女数;
    private Decimal 当日有権者女数;
    private Decimal 投票者合計;
    private Decimal 仮投票者合計;
    private Decimal 名簿登録者合計;
    private Decimal 当日有権者合計;
    private List<TohyouSha> 再交付者リスト;
    private List<TohyouSha> 決定投票者リスト;
    private List<TohyouSha> 返還者リスト;
    private Decimal 点字投票者数;
    private Decimal 代理投票者数;
    private RString 種類タイトル;
    private List<TohyouSha> 代理投票者リスト;
    private RString 法1;
    private RString 法2;
    private RString 法3;
    private List<TohyouSha> 投票拒否者法1リスト;
    private List<TohyouSha> 投票拒否者法2リスト;
    private FlexibleDate 調整年月日;
    private Decimal 従事者総数;
    private Decimal 選挙管理委員会書記数;
    private Decimal 職員数;
    private Decimal その他数;

    private int 代理投票者Index = 0;

    /**
     * コンストラクタです。
     *
     */
    public TohyorokuChohyo() {
    }
}
