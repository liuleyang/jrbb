/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam.JikanbetsuJokyoTohyojoParamBuilder;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
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
 * 時間別投票状況表　投票所別帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-031 lit
 */
public class JikanbetsuTohyoshoBreakCore {

    private JikanbetsuJokyoTohyojoParamBuilder builder;
    private final Association association;

    /**
     * コンストラクス。
     */
    public JikanbetsuTohyoshoBreakCore() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        TeijiCommonJohoItem 選挙帳票共通情報 = new TeijiCommonJohoItem(get市町村名(), get市町村コード(), get作成日時());
        builder = new JikanbetsuJokyoTohyojoParam.JikanbetsuJokyoTohyojoParamBuilder(選挙帳票共通情報, FlexibleDate.getNowDate());
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
                builder.addData(current.get抄本Entity(), current.get選挙Entity(), current.get施設Entity(), current.get投票状況Entity(), 宛名対象.to個人().get性別());
            }
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<JikanbetsuJokyoTohyojoParam>
     */
    public List<JikanbetsuJokyoTohyojoParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        List<JikanbetsuJokyoTohyojoParam> resultList = new ArrayList<>();
        if (isNew選挙(before, current)) {
            resultList.addAll(builder.合計());
            resultList.addAll(builder.全施設合計());
        } else if (isNew施設(before, current)) {
            resultList.addAll(builder.合計());
        }
        return resultList;
    }

    /**
     * createLastProcess
     *
     * @param before before
     * @return List<JikanbetsuJokyoTohyojoParam>
     */
    public List<JikanbetsuJokyoTohyojoParam> createLastProcess(ZenjitsuPrintEntity before) {
        List<JikanbetsuJokyoTohyojoParam> resultList = new ArrayList<>();
        if (null != before) {
            resultList.addAll(builder.合計());
            resultList.addAll(builder.全施設合計());
        }
        return resultList;
    }

    /**
     * New選挙かどうか。
     *
     * @param before before
     * @param current current
     * @return New選挙かどうか
     */
    protected boolean isNew選挙(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }

    /**
     * New施設かどうか。
     *
     * @param before before
     * @param current current
     * @return New施設かどうか
     */
    protected boolean isNew施設(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        RString 施設コード前 = before.get投票状況Entity().getShisetsuCode();
        RString 施設コード現 = current.get投票状況Entity().getShisetsuCode();

        return !(null != 施設コード前 && null != 施設コード現 && 施設コード前.equals(施設コード現));
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
