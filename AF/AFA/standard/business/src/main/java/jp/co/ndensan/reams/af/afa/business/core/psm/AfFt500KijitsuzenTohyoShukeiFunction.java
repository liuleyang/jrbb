/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.psm;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.special.KijitsuzenTohyoShukei;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmAccessable;

/**
 * 【期日前投票】期日前投票数集計データ取得クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfFt500KijitsuzenTohyoShukeiFunction implements IPsmAccessable {

    private static final RString FUNCTION_NAME = new RString("AfFt500KijitsuzenTohyoShukei");
    private final ShohonNo shohonNo;
    private final SenkyoNo senkyoNo;
    private final FlexibleDate kijunYMD;

    /**
     * コンストラクタです。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param kijunYMD 基準日（集計日当日）
     */
    public AfFt500KijitsuzenTohyoShukeiFunction(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate kijunYMD) {
        this.shohonNo = shohonNo;
        this.senkyoNo = senkyoNo;
        this.kijunYMD = kijunYMD;
    }

    @Override
    public String functionName() {
        return FUNCTION_NAME.toString();
    }

    @Override
    public List<Object> arguments() {
        List args = new ArrayList<>();
        args.add(shohonNo);
        args.add(senkyoNo);
        args.add(kijunYMD);
        return args;
    }

    @Override
    public Class<? extends Enum> tableType() {
        return KijitsuzenTohyoShukei.class;
    }

}
