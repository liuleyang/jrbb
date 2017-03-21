/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE101;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJiyuCode;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE101.SenseishoSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * {@link SenseishoSource}を編集します。
 *
 * @reamsid_L AF-0070-020 liss
 */
public class SenseishoEditor implements ISenseishoEditor {

    private final SenseishoParam item;
    private static final int 選挙１ = 0;
    private static final int 選挙２ = 1;
    private static final int 選挙３ = 2;
    private static final int 選挙４ = 3;
    private static final int 選挙５ = 4;
    private static final int 選挙６ = 5;
    private static final int 選挙７ = 6;
    private static final int 選挙８ = 7;
    private static final int 選挙９ = 8;
    private static final RString 帳票タイトル_宣誓書 = new RString("宣誓書");
    private static final RString 帳票タイトル_請求書兼宣誓書 = new RString("投票用紙等の請求書兼宣誓書");
    private static final RString 投票種類_期日前用 = new RString("期日前投票");
    private static final RString 投票種類_不在者用 = new RString("不在者投票");
    private static final RString 選挙管理委員長名 = new RString("選挙管理委員会委員長");
    private static final RString 標識 = new RString("○");

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link SenseishoParam}
     */
    public SenseishoEditor(SenseishoParam item) {
        this.item = item;
    }

    @Override
    public SenseishoSource edit(SenseishoSource source) {
        edit帳票タイトル(source);
        edit郵便番号(source);
        edit住所(source);
        editカナ氏名(source);
        edit漢字氏名(source);
        edit生年月日(source);
        edit投票年月日(source);
        edit選挙名1(source);
        edit選挙名2(source);
        edit選挙名3(source);
        edit選挙名4(source);
        edit選挙名5(source);
        edit選挙名6(source);
        edit選挙名7(source);
        edit選挙名8(source);
        edit選挙名9(source);
        edit宣誓年月日(source);
        edit選挙管理委員長名(source);
        edit投票種類(source);
        edit投票事由(source);
        edit投票区コード(source);
        edit名簿番号の頁(source);
        edit名簿番号の行(source);
        edit整理番号(source);
        editログの出力(source);

        return source;
    }

    private void edit帳票タイトル(SenseishoSource source) {
        if (KijitsumaeFuzaishaKubun.期日前投票.value().equals(item.get期日前不在者区分())) {
            source.title = 帳票タイトル_宣誓書;
        } else {
            source.title = 帳票タイトル_請求書兼宣誓書;
        }
    }

    private void edit郵便番号(SenseishoSource source) {
        YubinNo 郵便番号 = item.get選挙人資格情報().getAtenaPSMEntity().getJutonaiYubinNo();
        if (郵便番号 != null) {
            source.yubinNo = 郵便番号.getEditedYubinNo();
        }
    }

    private void edit住所(SenseishoSource source) {
        RString 住所 = item.get選挙人資格情報().getAtenaPSMEntity().getJutonaiJusho();
        RString 住登内住所 = RString.EMPTY;
        if (住所 != null) {
            住登内住所 = 住所;
        }
        AtenaBanchi 番地 = item.get選挙人資格情報().getAtenaPSMEntity().getJutonaiBanchi();
        RString 住登内番地 = RString.EMPTY;
        if (番地 != null) {
            住登内番地 = 番地.value();
        }
        Katagaki 方書 = item.get選挙人資格情報().getAtenaPSMEntity().getJutonaiKatagaki();
        RString 住登内方書 = RString.EMPTY;
        if (方書 != null) {
            住登内方書 = 方書.value();
        }
        source.jusho = 住登内住所.concat(住登内番地).concat(RString.FULL_SPACE).concat(住登内方書);
    }

    private void editカナ氏名(SenseishoSource source) {
        AtenaKanaMeisho カナ氏名 = item.get選挙人資格情報().getAtenaPSMEntity().getKanaShimei();
        if (カナ氏名 != null) {
            source.kanaShimei = カナ氏名.value();
        }
    }

    private void edit漢字氏名(SenseishoSource source) {
        AtenaMeisho 漢字氏名 = item.get選挙人資格情報().getAtenaPSMEntity().getKanjiShimei();
        if (漢字氏名 != null) {
            source.shimei = 漢字氏名.value();
        }
    }

    private void edit生年月日(SenseishoSource source) {
        FlexibleDate 生年月日 = item.get選挙人資格情報().getAtenaPSMEntity().getSeinengappiYMD();
        if (生年月日 != null) {
            source.seinengappi = 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit投票年月日(SenseishoSource source) {
        FlexibleDate 投票年月日 = item.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();
        if (投票年月日 != null) {
            source.tohyoYmd = 投票年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit選挙名1(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙１) {
            source.senkyoName1 = 選挙名称リスト.get(選挙１);
        }
    }

    private void edit選挙名2(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙２) {
            source.senkyoName2 = 選挙名称リスト.get(選挙２);
        }
    }

    private void edit選挙名3(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙３) {
            source.senkyoName3 = 選挙名称リスト.get(選挙３);
        }
    }

    private void edit選挙名4(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙４) {
            source.senkyoName4 = 選挙名称リスト.get(選挙４);
        }
    }

    private void edit選挙名5(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙５) {
            source.senkyoName5 = 選挙名称リスト.get(選挙５);
        }
    }

    private void edit選挙名6(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙６) {
            source.senkyoName6 = 選挙名称リスト.get(選挙６);
        }
    }

    private void edit選挙名7(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙７) {
            source.senkyoName7 = 選挙名称リスト.get(選挙７);
        }
    }

    private void edit選挙名8(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙８) {
            source.senkyoName8 = 選挙名称リスト.get(選挙８);
        }
    }

    private void edit選挙名9(SenseishoSource source) {
        List<RString> 選挙名称リスト = item.get選挙名称リスト();
        if (選挙名称リスト.size() > 選挙９) {
            source.senkyoName9 = 選挙名称リスト.get(選挙９);
        }
    }

    private void edit宣誓年月日(SenseishoSource source) {
        source.senseiYmd = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit選挙管理委員長名(SenseishoSource source) {
        RString 市町村名 = item.get帳票共通ヘッダー().get市町村名();
        source.senkyoKanri = 市町村名.concat(選挙管理委員長名);
    }

    private void edit投票種類(SenseishoSource source) {
        if (KijitsumaeFuzaishaKubun.期日前投票.value().equals(item.get期日前不在者区分())) {
            source.senkyoShurui = 投票種類_期日前用;
        } else {
            source.senkyoShurui = 投票種類_不在者用;
        }
    }

    private void edit投票事由(SenseishoSource source) {
        List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList = item.get選挙人資格情報().getTohyoJokyoEntityList();
        for (AfT201TohyoJokyoEntity entity : tohyoJokyoEntityList) {
            Code 投票事由コード = entity.getTohyoJiyuCode();
            if (投票事由コード != null) {
                RString 投票事由 = 投票事由コード.getKey();
                if (TohyoJiyuCode.仕事等.getCode().equals(投票事由)) {
                    source.jiyu1 = 標識;
                } else if (TohyoJiyuCode.旅行等.getCode().equals(投票事由)) {
                    source.jiyu2 = 標識;
                } else if (TohyoJiyuCode.病院_施設等.getCode().equals(投票事由)) {
                    source.jiyu3 = 標識;
                } else if (TohyoJiyuCode.交通至難等.getCode().equals(投票事由)) {
                    source.jiyu4 = 標識;
                } else if (TohyoJiyuCode.住所移転.getCode().equals(投票事由)) {
                    source.jiyu5 = 標識;
                }
            }
        }

    }

    private void edit投票区コード(SenseishoSource source) {
        source.tohyokuCode = item.get選挙人資格情報().getSenkyoShikakuEntity().getTohyokuCode();
    }

    private void edit名簿番号の頁(SenseishoSource source) {
        source.meiboPage = new RString(String.valueOf(item.get選挙人資格情報().getSenkyoninMeiboEntity().getPage()));
    }

    private void edit名簿番号の行(SenseishoSource source) {
        source.meiboGyo = new RString(String.valueOf(item.get選挙人資格情報().getSenkyoninMeiboEntity().getGyo()));
    }

    private void edit整理番号(SenseishoSource source) {
        ShikibetsuCode 整理番号 = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
        if (整理番号 != null) {
            source.shikibetsuCode = 整理番号.value();
        }
    }

    private void editログの出力(SenseishoSource source) {
        source.識別コード1 = item.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }
}
