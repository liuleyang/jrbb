/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.common;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
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
 * 定時登録選挙帳票共通情報クラスです。
 *
 */
public class ReportHeadEditor {

    private final Association association;

    /**
     * コンストラクタです。
     *
     */
    public ReportHeadEditor() {
        association = AssociationFinderFactory.createInstance().getAssociation();

    }

    /**
     * 帳票共通ヘッダーを取得。 定時登録の場合。
     *
     * @return 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeijiCommonJohoItem create帳票共通ヘッダー() {
        TeijiCommonJohoItem 帳票共通 = new TeijiCommonJohoItem(get市町村名(), get市町村コード(), get作成日時());
        帳票共通.set選挙名称(定時登録.toRString());
        帳票共通.set都道府県区分(get都道府県区分());
        return 帳票共通;
    }

    private RString get作成日時() {
        return getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.HALF_SPACE)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
    }

    private RString get市町村コード() {
        return association.getLasdecCode_().value();
    }

    private RString get都道府県区分() {
        return new RString(association.get都道府県区分().value().toString());
    }

    /**
     * 市町村名を取得。
     *
     * @return 市町村名 RString
     */
    private RString get市町村名() {
        return association.get市町村名();
    }
}
