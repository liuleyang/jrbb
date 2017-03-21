/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 投票日前日関連帳票共通情報クラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class ZenjitsuReportHeaderEditor {

    private final Association association;

    /**
     * コンストラクタです。
     *
     */
    public ZenjitsuReportHeaderEditor() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 帳票共通ヘッダーを取得。
     *
     * @return 帳票共通ヘッダー ZenjitsuCommonJohoItem
     */
    public ZenjitsuCommonJohoItem create帳票共通ヘッダー() {
        ZenjitsuCommonJohoItem 帳票共通 = new ZenjitsuCommonJohoItem();
        帳票共通.set市町村コード(get市町村コード());
        帳票共通.set市町村名(get市町村名());
        帳票共通.set作成日時(get作成日時());
        return 帳票共通;
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
