package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210;

import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportHojinNo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportKojinNo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 転出者お知らせハガキのReportSourceです。
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo11", length = 3, order = 1)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo21", length = 4, order = 2)
    public RString yubinNo21;
    @ReportItem(name = "yubinNo12", length = 3, order = 3)
    public RString yubinNo12;
    @ReportItem(name = "yubinNo22", length = 4, order = 4)
    public RString yubinNo22;
    @ReportItem(name = "jusho11", length = 18, order = 5)
    public RString jusho11;
    @ReportItem(name = "jusho12", length = 18, order = 6)
    public RString jusho12;
    @ReportItem(name = "jusho21", length = 18, order = 7)
    public RString jusho21;
    @ReportItem(name = "jusho22", length = 18, order = 8)
    public RString jusho22;
    @ReportItem(name = "jusho31", length = 18, order = 9)
    public RString jusho31;
    @ReportItem(name = "jusho32", length = 18, order = 10)
    public RString jusho32;
    @ReportItem(name = "jusho41", length = 18, order = 11)
    public RString jusho41;
    @ReportItem(name = "jusho42", length = 18, order = 12)
    public RString jusho42;
    @ReportItem(name = "jusho51", length = 18, order = 13)
    public RString jusho51;
    @ReportItem(name = "jusho52", length = 18, order = 14)
    public RString jusho52;
    @ReportItem(name = "name11", length = 14, order = 15)
    public RString name11;
    @ReportItem(name = "name12", length = 14, order = 16)
    public RString name12;
    @ReportItem(name = "name21", length = 14, order = 17)
    public RString name21;
    @ReportItem(name = "name22", length = 14, order = 18)
    public RString name22;
    @ReportItem(name = "name31", length = 14, order = 19)
    public RString name31;
    @ReportItem(name = "name32", length = 14, order = 20)
    public RString name32;
    @ReportItem(name = "barcodeCustombarcode1", order = 21)
    public RString barcodeCustombarcode1;
    @ReportItem(name = "barcodeCustombarcode2", order = 22)
    public RString barcodeCustombarcode2;
    @ReportItem(name = "seiriNo1", length = 7, order = 23)
    public RString seiriNo1;
    @ReportItem(name = "seiriNo2", length = 7, order = 24)
    public RString seiriNo2;
    @ReportItem(name = "tohyokuCode1", length = 4, order = 25)
    public RString tohyokuCode1;
    @ReportItem(name = "tohyokuCode2", length = 4, order = 26)
    public RString tohyokuCode2;
    @ReportItem(name = "meiboPage1", length = 6, order = 27)
    public RString meiboPage1;
    @ReportItem(name = "meiboNo1", length = 2, order = 28)
    public RString meiboNo1;
    @ReportItem(name = "meiboPage2", length = 6, order = 29)
    public RString meiboPage2;
    @ReportItem(name = "meiboNo2", length = 2, order = 30)
    public RString meiboNo2;
    @ReportItem(name = "tohyojoName11", length = 29, order = 31)
    public RString tohyojoName11;
    @ReportItem(name = "tohyojoName21", length = 33, order = 32)
    public RString tohyojoName21;
    @ReportItem(name = "tohyojoName12", length = 29, order = 33)
    public RString tohyojoName12;
    @ReportItem(name = "tohyojoName22", length = 33, order = 34)
    public RString tohyojoName22;
    @ReportItem(name = "oldJusho11", length = 29, order = 35)
    public RString oldJusho11;
    @ReportItem(name = "oldJusho12", length = 29, order = 36)
    public RString oldJusho12;
    @ReportItem(name = "oldJusho21", length = 29, order = 37)
    public RString oldJusho21;
    @ReportItem(name = "oldJusho22", length = 29, order = 38)
    public RString oldJusho22;
    @ReportItem(name = "oldJusho31", length = 29, order = 39)
    public RString oldJusho31;
    @ReportItem(name = "oldJusho32", length = 29, order = 40)
    public RString oldJusho32;
    @ReportItem(name = "barcodeBarcode1", order = 41)
    public RString barcodeBarcode1;
    @ReportItem(name = "barcodeBarcode2", order = 42)
    public RString barcodeBarcode2;
    @ReportItem(name = "data1", length = 20, order = 43)
    public RString data1;
    @ReportItem(name = "data2", length = 20, order = 44)
    public RString data2;
    @ReportItem(name = "tohyoTimeStart1_hh", length = 4, order = 45)
    public RString tohyoTimeStart1_hh;
    @ReportItem(name = "tohyoTimeEnd1_hh", length = 4, order = 46)
    public RString tohyoTimeEnd1_hh;
    @ReportItem(name = "tohyoTimeStart2_hh", length = 4, order = 47)
    public RString tohyoTimeStart2_hh;
    @ReportItem(name = "tohyoTimeEnd2_hh", length = 4, order = 48)
    public RString tohyoTimeEnd2_hh;
    @ReportItem(name = "yubinNo13", length = 3, order = 49)
    public RString yubinNo13;
    @ReportItem(name = "yubinNo23", length = 4, order = 50)
    public RString yubinNo23;
    @ReportItem(name = "yubinNo14", length = 3, order = 51)
    public RString yubinNo14;
    @ReportItem(name = "yubinNo24", length = 4, order = 52)
    public RString yubinNo24;
    @ReportItem(name = "jusho13", length = 18, order = 53)
    public RString jusho13;
    @ReportItem(name = "jusho14", length = 18, order = 54)
    public RString jusho14;
    @ReportItem(name = "jusho23", length = 18, order = 55)
    public RString jusho23;
    @ReportItem(name = "jusho24", length = 18, order = 56)
    public RString jusho24;
    @ReportItem(name = "jusho33", length = 18, order = 57)
    public RString jusho33;
    @ReportItem(name = "jusho34", length = 18, order = 58)
    public RString jusho34;
    @ReportItem(name = "jusho43", length = 18, order = 59)
    public RString jusho43;
    @ReportItem(name = "jusho44", length = 18, order = 60)
    public RString jusho44;
    @ReportItem(name = "jusho53", length = 18, order = 61)
    public RString jusho53;
    @ReportItem(name = "jusho54", length = 18, order = 62)
    public RString jusho54;
    @ReportItem(name = "name13", length = 14, order = 63)
    public RString name13;
    @ReportItem(name = "name14", length = 14, order = 64)
    public RString name14;
    @ReportItem(name = "name23", length = 14, order = 65)
    public RString name23;
    @ReportItem(name = "name24", length = 14, order = 66)
    public RString name24;
    @ReportItem(name = "name33", length = 14, order = 67)
    public RString name33;
    @ReportItem(name = "name34", length = 14, order = 68)
    public RString name34;
    @ReportItem(name = "barcodeCustombarcode3", order = 69)
    public RString barcodeCustombarcode3;
    @ReportItem(name = "barcodeCustombarcode4", order = 70)
    public RString barcodeCustombarcode4;
    @ReportItem(name = "seiriNo3", length = 7, order = 71)
    public RString seiriNo3;
    @ReportItem(name = "seiriNo4", length = 7, order = 72)
    public RString seiriNo4;
    @ReportItem(name = "meiboPage3", length = 6, order = 73)
    public RString meiboPage3;
    @ReportItem(name = "meiboNo3", length = 2, order = 74)
    public RString meiboNo3;
    @ReportItem(name = "meiboPage4", length = 6, order = 75)
    public RString meiboPage4;
    @ReportItem(name = "meiboNo4", length = 2, order = 76)
    public RString meiboNo4;
    @ReportItem(name = "tohyokuCode3", length = 4, order = 77)
    public RString tohyokuCode3;
    @ReportItem(name = "tohyokuCode4", length = 4, order = 78)
    public RString tohyokuCode4;
    @ReportItem(name = "tohyojoName13", length = 29, order = 79)
    public RString tohyojoName13;
    @ReportItem(name = "tohyojoName14", length = 29, order = 80)
    public RString tohyojoName14;
    @ReportItem(name = "tohyojoName23", length = 33, order = 81)
    public RString tohyojoName23;
    @ReportItem(name = "tohyojoName24", length = 33, order = 82)
    public RString tohyojoName24;
    @ReportItem(name = "oldJusho13", length = 29, order = 83)
    public RString oldJusho13;
    @ReportItem(name = "oldJusho14", length = 29, order = 84)
    public RString oldJusho14;
    @ReportItem(name = "oldJusho24", length = 29, order = 85)
    public RString oldJusho24;
    @ReportItem(name = "oldJusho23", length = 29, order = 86)
    public RString oldJusho23;
    @ReportItem(name = "oldJusho33", length = 29, order = 87)
    public RString oldJusho33;
    @ReportItem(name = "oldJusho34", length = 29, order = 88)
    public RString oldJusho34;
    @ReportItem(name = "barcodeBarcode3", order = 89)
    public RString barcodeBarcode3;
    @ReportItem(name = "barcodeBarcode4", order = 90)
    public RString barcodeBarcode4;
    @ReportItem(name = "data3", length = 20, order = 91)
    public RString data3;
    @ReportItem(name = "data4", length = 20, order = 92)
    public RString data4;
    @ReportItem(name = "tohyoTimeStart3_hh", length = 4, order = 93)
    public RString tohyoTimeStart3_hh;
    @ReportItem(name = "tohyoTimeEnd3_hh", length = 4, order = 94)
    public RString tohyoTimeEnd3_hh;
    @ReportItem(name = "tohyoTimeStart4_hh", length = 4, order = 95)
    public RString tohyoTimeStart4_hh;
    @ReportItem(name = "tohyoTimeEnd4_hh", length = 4, order = 96)
    public RString tohyoTimeEnd4_hh;
    @ReportPerson(id = "X1")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X1")
    public KojinNo 個人番号使用1;
    @ReportHojinNo(id = "X1")
    public HojinNo 法人番号使用1;
    @ReportPerson(id = "X2")
    public ShikibetsuCode 識別コード2;
    @ReportKojinNo(id = "X2")
    public KojinNo 個人番号使用2;
    @ReportHojinNo(id = "X2")
    public HojinNo 法人番号使用2;
    @ReportPerson(id = "X3")
    public ShikibetsuCode 識別コード3;
    @ReportKojinNo(id = "X3")
    public KojinNo 個人番号使用3;
    @ReportHojinNo(id = "X3")
    public HojinNo 法人番号使用3;
    @ReportPerson(id = "X4")
    public ShikibetsuCode 識別コード4;
    @ReportKojinNo(id = "X4")
    public KojinNo 個人番号使用4;
    @ReportHojinNo(id = "X4")
    public HojinNo 法人番号使用4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "mapJoho1", order = 97)
    public RString mapJoho1;
    @ReportItem(name = "mapJoho2", order = 98)
    public RString mapJoho2;
    @ReportItem(name = "mapJoho3", order = 99)
    public RString mapJoho3;
    @ReportItem(name = "mapJoho4", order = 100)
    public RString mapJoho4;
    @ReportItem(name = "seibetu1", order = 101)
    public RString seibetu1;
    @ReportItem(name = "kanaMeisho1", order = 102)
    public RString kanaMeisho1;
    @ReportItem(name = "seinengappi1", order = 103)
    public RString seinengappi1;
    @ReportItem(name = "gyoseikuCode1", order = 104)
    public RString gyoseikuCode1;
    @ReportItem(name = "gyoseikuMei1", order = 105)
    public RString gyoseikuMei1;
    @ReportItem(name = "chikuCode11", order = 106)
    public RString chikuCode11;
    @ReportItem(name = "chikuName11", order = 107)
    public RString chikuName11;
    @ReportItem(name = "chikuCode21", order = 108)
    public RString chikuCode21;
    @ReportItem(name = "chikuName21", order = 109)
    public RString chikuName21;
    @ReportItem(name = "chikuCode31", order = 110)
    public RString chikuCode31;
    @ReportItem(name = "chikuName31", order = 111)
    public RString chikuName31;
    @ReportItem(name = "setaiCode1", order = 112)
    public RString setaiCode1;
    @ReportItem(name = "setainushiMei1", order = 113)
    public RString setainushiMei1;
    @ReportItem(name = "seibetu2", order = 114)
    public RString seibetu2;
    @ReportItem(name = "kanaMeisho2", order = 115)
    public RString kanaMeisho2;
    @ReportItem(name = "seinengappi2", order = 116)
    public RString seinengappi2;
    @ReportItem(name = "gyoseikuCode2", order = 117)
    public RString gyoseikuCode2;
    @ReportItem(name = "gyoseikuMei2", order = 118)
    public RString gyoseikuMei2;
    @ReportItem(name = "chikuCode12", order = 119)
    public RString chikuCode12;
    @ReportItem(name = "chikuName12", order = 120)
    public RString chikuName12;
    @ReportItem(name = "chikuCode22", order = 121)
    public RString chikuCode22;
    @ReportItem(name = "chikuName22", order = 122)
    public RString chikuName22;
    @ReportItem(name = "chikuCode32", order = 123)
    public RString chikuCode32;
    @ReportItem(name = "chikuName32", order = 124)
    public RString chikuName32;
    @ReportItem(name = "setaiCode2", order = 125)
    public RString setaiCode2;
    @ReportItem(name = "setainushiMei2", order = 126)
    public RString setainushiMei2;
    @ReportItem(name = "seibetu3", order = 127)
    public RString seibetu3;
    @ReportItem(name = "kanaMeisho3", order = 128)
    public RString kanaMeisho3;
    @ReportItem(name = "seinengappi3", order = 129)
    public RString seinengappi3;
    @ReportItem(name = "gyoseikuCode3", order = 130)
    public RString gyoseikuCode3;
    @ReportItem(name = "gyoseikuMei3", order = 131)
    public RString gyoseikuMei3;
    @ReportItem(name = "chikuCode13", order = 132)
    public RString chikuCode13;
    @ReportItem(name = "chikuName13", order = 133)
    public RString chikuName13;
    @ReportItem(name = "chikuCode23", order = 134)
    public RString chikuCode23;
    @ReportItem(name = "chikuName23", order = 135)
    public RString chikuName23;
    @ReportItem(name = "chikuCode33", order = 136)
    public RString chikuCode33;
    @ReportItem(name = "chikuName33", order = 137)
    public RString chikuName33;
    @ReportItem(name = "setaiCode3", order = 138)
    public RString setaiCode3;
    @ReportItem(name = "setainushiMei3", order = 139)
    public RString setainushiMei3;
    @ReportItem(name = "seibetu4", order = 140)
    public RString seibetu4;
    @ReportItem(name = "kanaMeisho4", order = 141)
    public RString kanaMeisho4;
    @ReportItem(name = "seinengappi4", order = 142)
    public RString seinengappi4;
    @ReportItem(name = "gyoseikuCode4", order = 143)
    public RString gyoseikuCode4;
    @ReportItem(name = "gyoseikuMei4", order = 144)
    public RString gyoseikuMei4;
    @ReportItem(name = "chikuCode14", order = 145)
    public RString chikuCode14;
    @ReportItem(name = "chikuName14", order = 146)
    public RString chikuName14;
    @ReportItem(name = "chikuCode24", order = 147)
    public RString chikuCode24;
    @ReportItem(name = "chikuName24", order = 148)
    public RString chikuName24;
    @ReportItem(name = "chikuCode34", order = 149)
    public RString chikuCode34;
    @ReportItem(name = "chikuName34", order = 150)
    public RString chikuName34;
    @ReportItem(name = "setaiCode4", order = 151)
    public RString setaiCode4;
    @ReportItem(name = "setainushiMei4", order = 152)
    public RString setainushiMei4;
    @ReportItem(name = "jusho_1", length = 90, order = 153)
    public RString jusho_1;
    @ReportItem(name = "oldJusho_1", length = 87, order = 154)
    public RString oldJusho_1;
    @ReportItem(name = "shimei_1", length = 42, order = 155)
    public RString shimei_1;
    @ReportItem(name = "tohyojoMei_1", length = 63, order = 156)
    public RString tohyojoMei_1;
    @ReportItem(name = "shikibetsuCode", order = 169)
    public RString shikibetsuCode;
    @ReportItem(name = "jusho_2", length = 90, order = 157)
    public RString jusho_2;
    @ReportItem(name = "jusho_3", length = 90, order = 158)
    public RString jusho_3;
    @ReportItem(name = "jusho_4", length = 90, order = 159)
    public RString jusho_4;
    @ReportItem(name = "oldJusho_2", length = 87, order = 160)
    public RString oldJusho_2;
    @ReportItem(name = "oldJusho_3", length = 87, order = 161)
    public RString oldJusho_3;
    @ReportItem(name = "oldJusho_4", length = 87, order = 162)
    public RString oldJusho_4;
    @ReportItem(name = "shimei_2", length = 42, order = 163)
    public RString shimei_2;
    @ReportItem(name = "shimei_3", length = 42, order = 164)
    public RString shimei_3;
    @ReportItem(name = "shimei_4", length = 42, order = 165)
    public RString shimei_4;
    @ReportItem(name = "tohyojoMei_2", length = 63, order = 166)
    public RString tohyojoMei_2;
    @ReportItem(name = "tohyojoMei_3", length = 63, order = 167)
    public RString tohyojoMei_3;
    @ReportItem(name = "tohyojoMei_4", length = 63, order = 168)
    public RString tohyojoMei_4;
    @ReportItem(name = "tohyoTimeStart1_nn", order = 169)
    public RString tohyoTimeStart1_nn;
    @ReportItem(name = "tohyoTimeEnd1_nn", order = 170)
    public RString tohyoTimeEnd1_nn;
    @ReportItem(name = "tohyoTimeStart2_nn", order = 171)
    public RString tohyoTimeStart2_nn;
    @ReportItem(name = "tohyoTimeEnd2_nn", order = 172)
    public RString tohyoTimeEnd2_nn;
    @ReportItem(name = "tohyoTimeStart3_nn", order = 173)
    public RString tohyoTimeStart3_nn;
    @ReportItem(name = "tohyoTimeEnd3_nn", order = 174)
    public RString tohyoTimeEnd3_nn;
    @ReportItem(name = "tohyoTimeStart4_nn", order = 175)
    public RString tohyoTimeStart4_nn;
    @ReportItem(name = "tohyoTimeEnd4_nn", order = 176)
    public RString tohyoTimeEnd4_nn;
    @ReportItem(name = "shikibetsuCode_TenshutsushaHagaki_1", order = 177)
    public RString shikibetsuCode_TenshutsushaHagaki_1;
    @ReportItem(name = "shikibetsuCode_TenshutsushaHagaki_2", order = 178)
    public RString shikibetsuCode_TenshutsushaHagaki_2;
    @ReportItem(name = "shikibetsuCode_TenshutsushaHagaki_3", order = 179)
    public RString shikibetsuCode_TenshutsushaHagaki_3;
    @ReportItem(name = "shikibetsuCode_TenshutsushaHagaki_4", order = 180)
    public RString shikibetsuCode_TenshutsushaHagaki_4;

    /**
     * 転出者お知らせハガキエンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        yubinNo11,
        yubinNo21,
        yubinNo12,
        yubinNo22,
        jusho11,
        jusho12,
        jusho21,
        jusho22,
        jusho31,
        jusho32,
        jusho41,
        jusho42,
        jusho51,
        jusho52,
        name11,
        name12,
        name21,
        name22,
        name31,
        name32,
        barcodeCustombarcode1,
        barcodeCustombarcode2,
        seiriNo1,
        seiriNo2,
        tohyokuCode1,
        tohyokuCode2,
        meiboPage1,
        meiboNo1,
        meiboPage2,
        meiboNo2,
        tohyojoName11,
        tohyojoName21,
        tohyojoName12,
        tohyojoName22,
        oldJusho11,
        oldJusho12,
        oldJusho21,
        oldJusho22,
        oldJusho31,
        oldJusho32,
        barcodeBarcode1,
        barcodeBarcode2,
        data1,
        data2,
        tohyoTimeStart1,
        tohyoTimeEnd1,
        tohyoTimeStart2,
        tohyoTimeEnd2,
        yubinNo13,
        yubinNo23,
        yubinNo14,
        yubinNo24,
        jusho13,
        jusho14,
        jusho23,
        jusho24,
        jusho33,
        jusho34,
        jusho43,
        jusho44,
        jusho53,
        jusho54,
        name13,
        name14,
        name23,
        name24,
        name33,
        name34,
        barcodeCustombarcode3,
        barcodeCustombarcode4,
        seiriNo3,
        seiriNo4,
        meiboPage3,
        meiboNo3,
        meiboPage4,
        meiboNo4,
        tohyokuCode3,
        tohyokuCode4,
        tohyojoName13,
        tohyojoName14,
        tohyojoName23,
        tohyojoName24,
        oldJusho13,
        oldJusho14,
        oldJusho24,
        oldJusho23,
        oldJusho33,
        oldJusho34,
        barcodeBarcode3,
        barcodeBarcode4,
        data3,
        data4,
        tohyoTimeStart3,
        tohyoTimeEnd3,
        tohyoTimeStart4,
        tohyoTimeEnd4;
    }
// </editor-fold>
}
