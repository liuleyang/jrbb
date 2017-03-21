/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoParam;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者投票用紙等の調書帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-034 lit
 */
public class FuzaishaTohyoYoshiChoshoBreakCore {

    private final FuzaishaTohyoYoshiChoshoParam.FuzaishaTohyoYoshiChoshoParamBuilder builder;
    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final RString 投票区コード = new RString("～");

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE504SelectProcessParameter
     */
    public FuzaishaTohyoYoshiChoshoBreakCore(AFABTE504SelectProcessParameter parameter) {
        帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        RString 指示画面投票区コード = RString.EMPTY;
        if (!parameter.get投票区コードFROM().isEmpty()) {
            指示画面投票区コード = parameter.get投票区コードFROM().concat(投票区コード).concat(parameter.get投票区コードTO());
        }
        builder = new FuzaishaTohyoYoshiChoshoParam.FuzaishaTohyoYoshiChoshoParamBuilder(帳票共通ヘッダー, 指示画面投票区コード);
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(ZenjitsuPrintEntity current) {

        builder.addData(current.get選挙Entity(), current.get投票区UrEntity(), current.get投票状況Entity());

    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<DairiTohyoShukeihyoParam>
     */
    public List<FuzaishaTohyoYoshiChoshoParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        List<FuzaishaTohyoYoshiChoshoParam> rslt = new ArrayList<>();
        if (isNew選挙番号(before, current)) {
            rslt.add(builder.投票区合計());
            rslt.add(builder.選挙合計());
        } else if (isNew投票区(before, current)) {
            rslt.add(builder.投票区合計());
        }
        return rslt;
    }

    /**
     * createLastProcess
     *
     * @param before before
     * @return List<DairiTohyoShukeihyoParam>
     */
    public List<FuzaishaTohyoYoshiChoshoParam> createLastProcess(ZenjitsuPrintEntity before) {
        List<FuzaishaTohyoYoshiChoshoParam> rslt = new ArrayList<>();
        if (null != before) {
            rslt.add(builder.投票区合計());
            rslt.add(builder.選挙合計());
        }
        return rslt;
    }

    /**
     * New選挙番号かどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    private boolean isNew選挙番号(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));

    }

    /**
     * New投票区かどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    private boolean isNew投票区(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        UrT0159TohyokuEntity 投票区前Entity = before.get投票区UrEntity();
        UrT0159TohyokuEntity 投票区現Entity = current.get投票区UrEntity();
        RString 投票区コード前 = 投票区前Entity == null ? RString.EMPTY : 投票区前Entity.getTohyokuCode().value();
        RString 投票区コード現 = 投票区現Entity == null ? RString.EMPTY : 投票区現Entity.getTohyokuCode().value();
        return !投票区コード前.equals(投票区コード現);
    }
}
