/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.contexts;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IContext;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票受付のコンテキストです。
 *
 * @author N1823 有澤 礼恵
 */
public class TohyoUketsukeContext implements IContext {

    private final ShikibetsuCode shikibetsuCode;
    private final ShohonNo shohonNo;
    private final TohyoJokyo tohyoMode;
    private final TohyoJokyo tohyoKubun;
    private final List<SenkyoNo> senkyoNo;
    private final SeikyuHoho seikyusha;
    private final RDate tohyoYmd;
    private final RTime tohyoTime;
    private final TohyoJiyuCodeContext tohyoJiyuCodeContext;
    private final Boolean tenjiTohyo;
    private final ShisetsuCodeSelectContext shisetsuCodeContext;
    private final HojoshaNyuryokuContext hojoshaNyuryokuContext;
    private final RString kyohiJiyu;
    private final Boolean kariTohyo;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode ShikibetsuCode 投票対象者の識別コード
     * @param shohonNo ShohonNo 抄本番号
     * @param tohyoMode TohyoJokyo 投票モード（期日前or不在者or当日）
     * @param tohyoKubun TohyoJokyo 投票区分
     * @param senkyoNo List<SenkyoNo> 更新対象の選挙番号
     * @param seikyusha SeikyuHoho 請求者
     * @param tohyoYmd RDate 投票日
     * @param tohyoTime RTime 投票時間
     * @param tohyoJiyuCodeContext TohyoJiyuCodeContext 投票事由コードContext
     * @param tenjiTohyo Boolean 点字投票チェックボックス
     * @param shisetsuCodeContext ShisetsuCodeSelectContext 施設コードContext
     * @param hojoshaNyuryokuContext HojoshaNyuryokuContext 補助者入力Context
     * @param kyohiJiyu RString 拒否事由文言
     * @param kariTohyo Boolean 仮投票チェックボックス
     */
    public TohyoUketsukeContext(ShikibetsuCode shikibetsuCode, ShohonNo shohonNo, TohyoJokyo tohyoMode, TohyoJokyo tohyoKubun,
            List<SenkyoNo> senkyoNo, SeikyuHoho seikyusha, RDate tohyoYmd, RTime tohyoTime, TohyoJiyuCodeContext tohyoJiyuCodeContext,
            Boolean tenjiTohyo, ShisetsuCodeSelectContext shisetsuCodeContext, HojoshaNyuryokuContext hojoshaNyuryokuContext,
            RString kyohiJiyu, Boolean kariTohyo) {
        this.shikibetsuCode = shikibetsuCode;
        this.shohonNo = shohonNo;
        this.tohyoMode = tohyoMode;
        this.tohyoKubun = tohyoKubun;
        this.senkyoNo = senkyoNo;
        this.seikyusha = seikyusha;
        this.tohyoYmd = tohyoYmd;
        this.tohyoTime = tohyoTime;
        this.tohyoJiyuCodeContext = tohyoJiyuCodeContext;
        this.tenjiTohyo = tenjiTohyo;
        this.shisetsuCodeContext = shisetsuCodeContext;
        this.hojoshaNyuryokuContext = hojoshaNyuryokuContext;
        this.kyohiJiyu = kyohiJiyu;
        this.kariTohyo = kariTohyo;
    }

    /**
     * 投票対象者の識別コードを取得します。
     *
     * @return ShikibetsuCode 投票対象者の識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 抄本番号を取得します
     *
     * @return ShohonNo 抄本番号
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 画面起動モードを取得します
     *
     * @return TohyoJokyo 画面起動モード
     */
    public TohyoJokyo getTohyoMode() {
        return tohyoMode;
    }

    /**
     * 投票区分を取得します
     *
     * @return TohyoJokyo 投票区分
     */
    public TohyoJokyo getTohyoKubun() {
        return tohyoKubun;
    }

    /**
     * 選択中の選挙番号リストを取得します
     *
     * @return List<SenkyoNo> 選挙番号リスト
     */
    public List<SenkyoNo> getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * 請求者を取得します
     *
     * @return SeikyuHoho 請求方法
     */
    public SeikyuHoho getSeikyusha() {
        return seikyusha;
    }

    /**
     * 投票日を取得します
     *
     * @return RDate 投票日
     */
    public RDate getTohyoYmd() {
        return tohyoYmd;
    }

    /**
     * 投票時間を取得します
     *
     * @return RTime 投票時間
     */
    public RTime getTohyoTime() {
        return tohyoTime;
    }

    /**
     * 投票事由contextを取得します
     *
     * @return TohyoJiyuCodeContext 投票事由context
     */
    public TohyoJiyuCodeContext getTohyoJiyuCodeContext() {
        return tohyoJiyuCodeContext;
    }

    /**
     * 点字投票用紙を使用するかを返却します。
     *
     * @return 点字投票用紙を使用する場合trueを返します
     */
    public Boolean isTenjiTohyo() {
        return tenjiTohyo;
    }

    /**
     * 施設コードcontextを取得します
     *
     * @return ShisetsuCodeContext 施設コードcontext
     */
    public ShisetsuCodeSelectContext getShisetsuCodeContext() {
        return shisetsuCodeContext;
    }

    /**
     * 補助者入力contextを取得します
     *
     * @return HojoshaNyuryokuContext 補助者入力context
     */
    public HojoshaNyuryokuContext getHojoshaNyuryokuContext() {
        return hojoshaNyuryokuContext;
    }

    /**
     * 拒否事由を取得します
     *
     * @return RString 拒否事由
     */
    public RString getKyohiJiyu() {
        return kyohiJiyu;
    }

    /**
     * 仮投票するかどうかを取得します
     *
     * @return boolean 仮投票有無
     */
    public boolean isKariTohyo() {
        return kariTohyo;
    }

}
