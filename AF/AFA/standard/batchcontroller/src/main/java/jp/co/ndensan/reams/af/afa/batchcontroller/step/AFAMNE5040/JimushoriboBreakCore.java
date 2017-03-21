/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboParam;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務処理簿帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-032 lit
 */
public class JimushoriboBreakCore {

    private final JimushoriboParam.JimushoriboParamBuilder builder;
    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクス。
     *
     * @param is期日前投票 boolean
     */
    public JimushoriboBreakCore(boolean is期日前投票) {
        帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        builder = new JimushoriboParam.JimushoriboParamBuilder(帳票共通ヘッダー, is期日前投票);
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
                IKojin 個人 = 宛名対象.to個人();
                builder.addData(current.get選挙Entity(),
                        個人.get名称().getName().getColumnValue(),
                        個人.get性別(),
                        get投票区コード(current),
                        個人.get行政区画().getGyoseiku().get名称(),
                        current.get選挙人名簿Entity(),
                        current.get投票状況Entity(),
                        current.get施設Entity());
            }
        }

    }

    private RString get投票区コード(ZenjitsuPrintEntity current) {
        if (SenkyoShurui.定時登録.getCode().equals(current.get抄本Entity().getSenkyoShurui().value())
                || SenkyoShurui.国政選挙_地方選挙.getCode().equals(current.get抄本Entity().getSenkyoShurui().value())) {
            if (current.get投票区UrEntity() == null) {
                return RString.EMPTY;
            }
            return current.get投票区UrEntity().getTohyokuCode().value();
        } else {
            if (current.get投票区Entity() == null) {
                return RString.EMPTY;
            }
            return current.get投票区Entity().getTohyokuCode();
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<DairiTohyoShukeihyoParam>
     */
    public List<JimushoriboParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
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
    public List<JimushoriboParam> createLastProcess(ZenjitsuPrintEntity before) {
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
