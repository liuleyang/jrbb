/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiParam.JikanbetsuJokyoGokeiParamBuilder;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 時間別投票状況表　合計帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-030 lit
 */
public class JikanbetsuGokeiBreakCore {

    private final JikanbetsuJokyoGokeiParamBuilder builder;
    private final Association association;

    /**
     * コンストラクス。
     */
    public JikanbetsuGokeiBreakCore() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        TeijiCommonJohoItem 選挙帳票共通情報 = new TeijiCommonJohoItem(get市町村名(), get市町村コード(), get作成日時());
        builder = new JikanbetsuJokyoGokeiParam.JikanbetsuJokyoGokeiParamBuilder(選挙帳票共通情報, FlexibleDate.getNowDate());
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(ZenjitsuPrintEntity current) {
        if (null != current) {
            builder.addData(current.get抄本Entity(), current.get選挙Entity(), current.get投票状況Entity());
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<JikanbetsuJokyoGokeiParam>
     */
    public List<JikanbetsuJokyoGokeiParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (isNewData(before, current)) {
            return builder.sum();
        }
        return new ArrayList();
    }

    /**
     * createLastProcess
     *
     * @return List<JikanbetsuJokyoGokeiParam>
     */
    public List<JikanbetsuJokyoGokeiParam> createLastProcess() {
        return builder.sum();
    }

    /**
     * NewDataかどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }

    private RString get作成日時() {
        return getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
    }

    private RString get市町村コード() {
        return association.getLasdecCode_().value();
    }

    private RString get市町村名() {
        return association.get市町村名();
    }
}
