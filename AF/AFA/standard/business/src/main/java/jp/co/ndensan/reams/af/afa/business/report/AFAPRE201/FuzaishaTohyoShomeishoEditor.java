/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE201;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201.FuzaishaTohyoShomeishoReportSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link FuzaishaTohyoShomeishoReportSource}を編集します。
 *
 * @reamsid_L AF-0090-020 lit
 */
public class FuzaishaTohyoShomeishoEditor implements IFuzaishaTohyoShomeishoEditor {

    private final SenseishoParam item;
    private final Association association;
    private static final int 選挙名称_0 = 0;
    private static final int 選挙名称_1 = 1;
    private static final int 選挙名称_2 = 2;
    private static final int 選挙名称_3 = 3;
    private static final int 選挙名称_4 = 4;
    private static final int 選挙名称_5 = 5;
    private static final int 選挙名称_6 = 6;
    private static final int 選挙名称_7 = 7;
    private static final int 選挙名称_8 = 8;

    /**
     * コンストラクタです。
     *
     * @param item {@link SenseishoParam}
     * @param association {@link Association}
     */
    public FuzaishaTohyoShomeishoEditor(SenseishoParam item, Association association) {
        this.item = item;
        this.association = association;
    }

    @Override
    public FuzaishaTohyoShomeishoReportSource edit(FuzaishaTohyoShomeishoReportSource source) {

        UaFt200FindShikibetsuTaishoEntity 選挙人対象 = item.get選挙人資格情報().getAtenaPSMEntity();
        source.kanaShimei = 選挙人対象.getKanaName();
        AtenaMeisho 氏名 = 選挙人対象.getKanjiShimei();
        if (null != 氏名) {
            source.shimei = 氏名.value();
        }
        source.seinengappi = convertFlexiableToPattern12(選挙人対象.getSeinengappiYMD()).concat(new RString("生"));
        AfT100ShohonEntity 抄本対象 = item.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity();
        source.shikkoYmd = convertFlexiableToPattern12(抄本対象.getTohyoYMD()).concat(new RString("執行"));
        source.hakkoYmd = convertFlexiableToPattern12(FlexibleDate.getNowDate());
        source.senkyoKanri = get委員長名();

        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() <= 選挙名称_5) {
            source.senkyoNameA = 選挙名称リスト.get(選挙名称_0);
            if (選挙名称リスト.size() >= 選挙名称_1 + 1) {
                source.senkyoNameB = 選挙名称リスト.get(選挙名称_1);
            }
            if (選挙名称リスト.size() >= 選挙名称_2 + 1) {
                source.senkyoNameC = 選挙名称リスト.get(選挙名称_2);
            }
            if (選挙名称リスト.size() >= 選挙名称_3 + 1) {
                source.senkyoNameD = 選挙名称リスト.get(選挙名称_3);
            }
            if (選挙名称リスト.size() == 選挙名称_4 + 1) {
                source.senkyoNameE = 選挙名称リスト.get(選挙名称_4);
            }

        } else {
            source.sSenkyoNameA = 選挙名称リスト.get(選挙名称_0);
            source.sSenkyoNameB = 選挙名称リスト.get(選挙名称_1);
            source.sSenkyoNameC = 選挙名称リスト.get(選挙名称_2);
            source.sSenkyoNameD = 選挙名称リスト.get(選挙名称_3);
            source.sSenkyoNameE = 選挙名称リスト.get(選挙名称_4);
            source.sSenkyoNameF = 選挙名称リスト.get(選挙名称_5);

            if (選挙名称リスト.size() >= 選挙名称_6 + 1) {
                source.sSenkyoNameG = 選挙名称リスト.get(選挙名称_6);
            }
            if (選挙名称リスト.size() >= 選挙名称_7 + 1) {
                source.sSenkyoNameH = 選挙名称リスト.get(選挙名称_7);
            }
            if (選挙名称リスト.size() == 選挙名称_8 + 1) {
                source.sSenkyoNameI = 選挙名称リスト.get(選挙名称_8);
            }
        }
        editログの出力(source);
        return source;
    }

    private RString get委員長名() {
        if (null == association) {
            return RString.EMPTY;
        }
        RString 委員長名 = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
        return association.get市町村名().concat(new RString("選挙管理委員会委員長　")).concat(委員長名);
    }

    private RString convertFlexiableToPattern12(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }
        return target
                .wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();

    }

    private void editログの出力(FuzaishaTohyoShomeishoReportSource source) {
        source.識別コード1 = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
