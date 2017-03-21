/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoParam;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;

/**
 * 代理投票集計表帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-028 lit
 */
public class DairiTohyoShukeihyoBreakCore {

    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final DairiTohyoShukeihyoParam.DairiTohyoShukeihyoParamBuilder builder;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE504SelectProcessParameter
     */
    public DairiTohyoShukeihyoBreakCore(AFABTE504SelectProcessParameter parameter) {
        帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        TohyoJokyo 投票状況 = TohyoJokyo.toValue(parameter.get投票状況リスト().get(0));
        builder = new DairiTohyoShukeihyoParam.DairiTohyoShukeihyoParamBuilder(投票状況,
                帳票共通ヘッダー,
                parameter.get受理日FROM(),
                parameter.get受理日TO());
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(ZenjitsuPrintEntity current) {
        if (null != current) {
            IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(current.get宛名情報Entity());
            if (宛名対象.canBe個人()) {
                builder.addData(current.get抄本Entity(),
                        current.get選挙Entity(),
                        current.get選挙人名簿Entity(),
                        current.get投票区Entity(),
                        current.get投票区UrEntity(),
                        current.get投票状況Entity(),
                        宛名対象.to個人().get性別());
            }
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<DairiTohyoShukeihyoParam>
     */
    public List<DairiTohyoShukeihyoParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (isNewData(before, current)) {
            return builder.合計();
        }
        return new ArrayList<>();
    }

    /**
     * createLastProcess
     *
     * @param before before
     * @return List<DairiTohyoShukeihyoParam>
     */
    public List<DairiTohyoShukeihyoParam> createLastProcess(ZenjitsuPrintEntity before) {
        if (null != before) {
            return builder.合計();
        }
        return new ArrayList<>();
    }

    /**
     * NewDataかどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    private boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));

    }

    /**
     * 5.12納品用無効なソース、temp対応、納品後、削除すると予定です。
     *
     * @return 帳票共通ヘッダー
     */
    public ZenjitsuCommonJohoItem getZenjitsuCommonJohoItem() {
        return 帳票共通ヘッダー;
    }
}
