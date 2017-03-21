package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201;

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
 * 投票所入場券（個票3つ折り）のReportSourceです。
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "nyujokenName1", length = 20, order = 1)
    public RString nyujokenName1;
    @ReportItem(name = "nyujokenName2", length = 20, order = 2)
    public RString nyujokenName2;
    @ReportItem(name = "nyujokenName3", length = 20, order = 3)
    public RString nyujokenName3;
    @ReportItem(name = "sofusakiJusho11", length = 21, order = 4)
    public RString sofusakiJusho11;
    @ReportItem(name = "shimeiKana11", length = 25, order = 5)
    public RString shimeiKana11;
    @ReportItem(name = "shimeiKana21", length = 34, order = 6)
    public RString shimeiKana21;
    @ReportItem(name = "sofusakiJusho21", length = 21, order = 7)
    public RString sofusakiJusho21;
    @ReportItem(name = "sofusakiJusho31", length = 21, order = 8)
    public RString sofusakiJusho31;
    @ReportItem(name = "shimei21", length = 15, order = 9)
    public RString shimei21;
    @ReportItem(name = "shimei11", length = 11, order = 10)
    public RString shimei11;
    @ReportItem(name = "sofusakiJushoCode1", length = 9, order = 11)
    public RString sofusakiJushoCode1;
    @ReportItem(name = "meiboPage1", length = 6, order = 12)
    public RString meiboPage1;
    @ReportItem(name = "meiboGyo1", length = 2, order = 13)
    public RString meiboGyo1;
    @ReportItem(name = "seibetsu1", length = 1, order = 14)
    public RString seibetsu1;
    @ReportItem(name = "sofusakiJusho41", length = 21, order = 15)
    public RString sofusakiJusho41;
    @ReportItem(name = "setainushiKubun1", length = 1, order = 16)
    public RString setainushiKubun1;
    @ReportItem(name = "shimei31", length = 15, order = 17)
    public RString shimei31;
    @ReportItem(name = "sofusakiChikuCode1", length = 8, order = 18)
    public RString sofusakiChikuCode1;
    @ReportItem(name = "sofusakiJusho51", length = 21, order = 19)
    public RString sofusakiJusho51;
    @ReportItem(name = "seinengappi1", length = 10, order = 20)
    public RString seinengappi1;
    @ReportItem(name = "shikibetsuCode1", length = 15, order = 21)
    public RString shikibetsuCode1;
    @ReportItem(name = "setainushiMei1", length = 25, order = 22)
    public RString setainushiMei1;
    @ReportItem(name = "setaiCode1", length = 15, order = 23)
    public RString setaiCode1;
    @ReportItem(name = "tohyoTimeStart1_hh", length = 2, order = 24)
    public RString tohyoTimeStart1_hh;
    @ReportItem(name = "tohyoTimeEnd1_hh", length = 2, order = 25)
    public RString tohyoTimeEnd1_hh;
    @ReportItem(name = "tohyojoMei11", length = 21, order = 26)
    public RString tohyojoMei11;
    @ReportItem(name = "tohyokuCode1", length = 4, order = 27)
    public RString tohyokuCode1;
    @ReportItem(name = "tohyojoMei21", length = 30, order = 28)
    public RString tohyojoMei21;
    @ReportItem(name = "seiriNo1", length = 7, order = 29)
    public RString seiriNo1;
    @ReportItem(name = "sofusakiJusho12", length = 21, order = 30)
    public RString sofusakiJusho12;
    @ReportItem(name = "shimeiKana12", length = 25, order = 31)
    public RString shimeiKana12;
    @ReportItem(name = "shimeiKana22", length = 34, order = 32)
    public RString shimeiKana22;
    @ReportItem(name = "sofusakiJusho22", length = 21, order = 33)
    public RString sofusakiJusho22;
    @ReportItem(name = "sofusakiJusho32", length = 21, order = 34)
    public RString sofusakiJusho32;
    @ReportItem(name = "shimei22", length = 15, order = 35)
    public RString shimei22;
    @ReportItem(name = "shimei12", length = 11, order = 36)
    public RString shimei12;
    @ReportItem(name = "sofusakiJushoCode2", length = 9, order = 37)
    public RString sofusakiJushoCode2;
    @ReportItem(name = "meiboPage2", length = 6, order = 38)
    public RString meiboPage2;
    @ReportItem(name = "meiboGyo2", length = 2, order = 39)
    public RString meiboGyo2;
    @ReportItem(name = "sofusakiJusho42", length = 21, order = 40)
    public RString sofusakiJusho42;
    @ReportItem(name = "seibetsu2", length = 1, order = 41)
    public RString seibetsu2;
    @ReportItem(name = "setainushiKubun2", length = 1, order = 42)
    public RString setainushiKubun2;
    @ReportItem(name = "shimei32", length = 15, order = 43)
    public RString shimei32;
    @ReportItem(name = "sofusakiChikuCode2", length = 8, order = 44)
    public RString sofusakiChikuCode2;
    @ReportItem(name = "sofusakiJusho52", length = 21, order = 45)
    public RString sofusakiJusho52;
    @ReportItem(name = "seinengappi2", length = 10, order = 46)
    public RString seinengappi2;
    @ReportItem(name = "shikibetsuCode2", length = 15, order = 47)
    public RString shikibetsuCode2;
    @ReportItem(name = "setainushiMei2", length = 25, order = 48)
    public RString setainushiMei2;
    @ReportItem(name = "setaiCode2", length = 15, order = 49)
    public RString setaiCode2;
    @ReportItem(name = "tohyoTimeStart2_hh", length = 2, order = 50)
    public RString tohyoTimeStart2_hh;
    @ReportItem(name = "tohyoTimeEnd2_hh", length = 2, order = 51)
    public RString tohyoTimeEnd2_hh;
    @ReportItem(name = "tohyojoMei12", length = 21, order = 52)
    public RString tohyojoMei12;
    @ReportItem(name = "tohyokuCode2", length = 4, order = 53)
    public RString tohyokuCode2;
    @ReportItem(name = "tohyojoMei22", length = 30, order = 54)
    public RString tohyojoMei22;
    @ReportItem(name = "seiriNo2", length = 7, order = 55)
    public RString seiriNo2;
    @ReportItem(name = "sofusakiJusho13", length = 21, order = 56)
    public RString sofusakiJusho13;
    @ReportItem(name = "shimeiKana13", length = 25, order = 57)
    public RString shimeiKana13;
    @ReportItem(name = "shimeiKana23", length = 34, order = 58)
    public RString shimeiKana23;
    @ReportItem(name = "sofusakiJusho23", length = 21, order = 59)
    public RString sofusakiJusho23;
    @ReportItem(name = "shimei23", length = 15, order = 60)
    public RString shimei23;
    @ReportItem(name = "sofusakiJusho33", length = 21, order = 61)
    public RString sofusakiJusho33;
    @ReportItem(name = "shimei13", length = 11, order = 62)
    public RString shimei13;
    @ReportItem(name = "sofusakiJushoCode3", length = 9, order = 63)
    public RString sofusakiJushoCode3;
    @ReportItem(name = "meiboPage3", length = 6, order = 64)
    public RString meiboPage3;
    @ReportItem(name = "meiboGyo3", length = 2, order = 65)
    public RString meiboGyo3;
    @ReportItem(name = "seibetsu3", length = 1, order = 66)
    public RString seibetsu3;
    @ReportItem(name = "sofusakiJusho43", length = 21, order = 67)
    public RString sofusakiJusho43;
    @ReportItem(name = "setainushiKubun3", length = 1, order = 68)
    public RString setainushiKubun3;
    @ReportItem(name = "shimei33", length = 15, order = 69)
    public RString shimei33;
    @ReportItem(name = "sofusakiChikuCode3", length = 8, order = 70)
    public RString sofusakiChikuCode3;
    @ReportItem(name = "sofusakiJusho53", length = 21, order = 71)
    public RString sofusakiJusho53;
    @ReportItem(name = "seinengappi3", length = 10, order = 72)
    public RString seinengappi3;
    @ReportItem(name = "shikibetsuCode3", length = 15, order = 73)
    public RString shikibetsuCode3;
    @ReportItem(name = "setainushiMei3", length = 25, order = 74)
    public RString setainushiMei3;
    @ReportItem(name = "setaiCode3", length = 15, order = 75)
    public RString setaiCode3;
    @ReportItem(name = "tohyoTimeStart3_hh", length = 2, order = 76)
    public RString tohyoTimeStart3_hh;
    @ReportItem(name = "tohyoTimeEnd3_hh", length = 2, order = 77)
    public RString tohyoTimeEnd3_hh;
    @ReportItem(name = "tohyojoMei13", length = 21, order = 78)
    public RString tohyojoMei13;
    @ReportItem(name = "tohyokuCode3", length = 4, order = 79)
    public RString tohyokuCode3;
    @ReportItem(name = "tohyojoMei23", length = 30, order = 80)
    public RString tohyojoMei23;
    @ReportItem(name = "seiriNo3", length = 7, order = 81)
    public RString seiriNo3;
    @ReportItem(name = "txtSample", length = 10, order = 82)
    public RString txtSample;
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
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "shohonNo", order = 83)
    public RString shohonNo;
    @ReportItem(name = "shohonName", order = 84)
    public RString shohonName;
    @ReportItem(name = "senkyoMei1", order = 85)
    public RString senkyoMei1;
    @ReportItem(name = "senkyoMei2", order = 86)
    public RString senkyoMei2;
    @ReportItem(name = "senkyoMei3", order = 87)
    public RString senkyoMei3;
    @ReportItem(name = "senkyoMei4", order = 88)
    public RString senkyoMei4;
    @ReportItem(name = "senkyoMei5", order = 89)
    public RString senkyoMei5;
    @ReportItem(name = "senkyoMei6", order = 90)
    public RString senkyoMei6;
    @ReportItem(name = "senkyoMei7", order = 91)
    public RString senkyoMei7;
    @ReportItem(name = "senkyoMei8", order = 92)
    public RString senkyoMei8;
    @ReportItem(name = "senkyoMei9", order = 93)
    public RString senkyoMei9;
    @ReportItem(name = "senkyoRyakusho1", order = 94)
    public RString senkyoRyakusho1;
    @ReportItem(name = "senkyoRyakusho2", order = 95)
    public RString senkyoRyakusho2;
    @ReportItem(name = "senkyoRyakusho3", order = 96)
    public RString senkyoRyakusho3;
    @ReportItem(name = "senkyoRyakusho4", order = 97)
    public RString senkyoRyakusho4;
    @ReportItem(name = "senkyoRyakusho5", order = 98)
    public RString senkyoRyakusho5;
    @ReportItem(name = "senkyoRyakusho6", order = 99)
    public RString senkyoRyakusho6;
    @ReportItem(name = "senkyoRyakusho7", order = 100)
    public RString senkyoRyakusho7;
    @ReportItem(name = "senkyoRyakusho8", order = 101)
    public RString senkyoRyakusho8;
    @ReportItem(name = "senkyoRyakusho9", order = 102)
    public RString senkyoRyakusho9;
    @ReportItem(name = "tohyoYMD", order = 103)
    public RString tohyoYMD;
    @ReportItem(name = "tohyoYMD_gengou", order = 104)
    public RString tohyoYMD_gengou;
    @ReportItem(name = "tohyoYMD_yyyy", order = 105)
    public RString tohyoYMD_yyyy;
    @ReportItem(name = "tohyoYMD_mm", order = 106)
    public RString tohyoYMD_mm;
    @ReportItem(name = "tohyoYMD_dd", order = 107)
    public RString tohyoYMD_dd;
    @ReportItem(name = "tohyoYMD_youbi", order = 108)
    public RString tohyoYMD_youbi;
    @ReportItem(name = "kokujiYMD", order = 109)
    public RString kokujiYMD;
    @ReportItem(name = "kokujiYMD_gengou", order = 110)
    public RString kokujiYMD_gengou;
    @ReportItem(name = "kokujiYMD_yyyy", order = 111)
    public RString kokujiYMD_yyyy;
    @ReportItem(name = "kokujiYMD_mm", order = 112)
    public RString kokujiYMD_mm;
    @ReportItem(name = "kokujiYMD_dd", order = 113)
    public RString kokujiYMD_dd;
    @ReportItem(name = "kokujiYMD_youbi", order = 114)
    public RString kokujiYMD_youbi;
    @ReportItem(name = "shichosonName", order = 115)
    public RString shichosonName;
    @ReportItem(name = "yubinNo11", order = 116)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo21", order = 117)
    public RString yubinNo21;
    @ReportItem(name = "yubinNo1", order = 118)
    public RString yubinNo1;
    @ReportItem(name = "barcodeCustombarcode1", order = 119)
    public RString barcodeCustombarcode1;
    @ReportItem(name = "sofusakiGyoseikuCode1", order = 120)
    public RString sofusakiGyoseikuCode1;
    @ReportItem(name = "sofusakiGyoseikuMei11", order = 121)
    public RString sofusakiGyoseikuMei11;
    @ReportItem(name = "sofusakiGyoseikuMei21", order = 122)
    public RString sofusakiGyoseikuMei21;
    @ReportItem(name = "sofusakiGyoseikuMei31", order = 123)
    public RString sofusakiGyoseikuMei31;
    @ReportItem(name = "atena11", order = 124)
    public RString atena11;
    @ReportItem(name = "atena21", order = 125)
    public RString atena21;
    @ReportItem(name = "atena31", order = 126)
    public RString atena31;
    @ReportItem(name = "sofusakiChikuName1", order = 127)
    public RString sofusakiChikuName1;
    @ReportItem(name = "sofusakiMeiboNo1", order = 128)
    public RString sofusakiMeiboNo1;
    @ReportItem(name = "mapJoho1", order = 129)
    public RString mapJoho1;
    @ReportItem(name = "jushoCode1", order = 130)
    public RString jushoCode1;
    @ReportItem(name = "jusho11", order = 131)
    public RString jusho11;
    @ReportItem(name = "jusho21", order = 132)
    public RString jusho21;
    @ReportItem(name = "jusho1", order = 133)
    public RString jusho1;
    @ReportItem(name = "shimei1", order = 134)
    public RString shimei1;
    @ReportItem(name = "shimeiKana1", order = 135)
    public RString shimeiKana1;
    @ReportItem(name = "tohyojoMei31", order = 136)
    public RString tohyojoMei31;
    @ReportItem(name = "tohyojoMei1", order = 137)
    public RString tohyojoMei1;
    @ReportItem(name = "tohyojoJusho1", order = 138)
    public RString tohyojoJusho1;
    @ReportItem(name = "tohyokuMei1", order = 139)
    public RString tohyokuMei1;
    @ReportItem(name = "meiboNo1", order = 140)
    public RString meiboNo1;
    @ReportItem(name = "barcodeNyujokenBarcode1", order = 141)
    public RString barcodeNyujokenBarcode1;
    @ReportItem(name = "gyoseikuCode1", order = 142)
    public RString gyoseikuCode1;
    @ReportItem(name = "gyoseikuMei1", order = 143)
    public RString gyoseikuMei1;
    @ReportItem(name = "chikuCode11", order = 144)
    public RString chikuCode11;
    @ReportItem(name = "chikuName11", order = 145)
    public RString chikuName11;
    @ReportItem(name = "chikuCode21", order = 146)
    public RString chikuCode21;
    @ReportItem(name = "chikuName21", order = 147)
    public RString chikuName21;
    @ReportItem(name = "chikuCode31", order = 148)
    public RString chikuCode31;
    @ReportItem(name = "chikuName31", order = 149)
    public RString chikuName31;
    @ReportItem(name = "yubinNo12", order = 150)
    public RString yubinNo12;
    @ReportItem(name = "yubinNo22", order = 151)
    public RString yubinNo22;
    @ReportItem(name = "yubinNo2", order = 152)
    public RString yubinNo2;
    @ReportItem(name = "barcodeCustombarcode2", order = 153)
    public RString barcodeCustombarcode2;
    @ReportItem(name = "sofusakiGyoseikuCode2", order = 154)
    public RString sofusakiGyoseikuCode2;
    @ReportItem(name = "sofusakiGyoseikuMei12", order = 155)
    public RString sofusakiGyoseikuMei12;
    @ReportItem(name = "sofusakiGyoseikuMei22", order = 156)
    public RString sofusakiGyoseikuMei22;
    @ReportItem(name = "sofusakiGyoseikuMei32", order = 157)
    public RString sofusakiGyoseikuMei32;
    @ReportItem(name = "atena12", order = 158)
    public RString atena12;
    @ReportItem(name = "atena22", order = 159)
    public RString atena22;
    @ReportItem(name = "atena32", order = 160)
    public RString atena32;
    @ReportItem(name = "sofusakiChikuName2", order = 161)
    public RString sofusakiChikuName2;
    @ReportItem(name = "sofusakiMeiboNo2", order = 162)
    public RString sofusakiMeiboNo2;
    @ReportItem(name = "mapJoho2", order = 163)
    public RString mapJoho2;
    @ReportItem(name = "jushoCode2", order = 164)
    public RString jushoCode2;
    @ReportItem(name = "jusho12", order = 165)
    public RString jusho12;
    @ReportItem(name = "jusho22", order = 166)
    public RString jusho22;
    @ReportItem(name = "jusho2", order = 167)
    public RString jusho2;
    @ReportItem(name = "shimei2", order = 168)
    public RString shimei2;
    @ReportItem(name = "shimeiKana2", order = 169)
    public RString shimeiKana2;
    @ReportItem(name = "tohyojoMei32", order = 170)
    public RString tohyojoMei32;
    @ReportItem(name = "tohyojoMei2", order = 171)
    public RString tohyojoMei2;
    @ReportItem(name = "tohyojoJusho2", order = 172)
    public RString tohyojoJusho2;
    @ReportItem(name = "tohyokuMei2", order = 173)
    public RString tohyokuMei2;
    @ReportItem(name = "meiboNo2", order = 174)
    public RString meiboNo2;
    @ReportItem(name = "barcodeNyujokenBarcode2", order = 175)
    public RString barcodeNyujokenBarcode2;
    @ReportItem(name = "gyoseikuCode2", order = 176)
    public RString gyoseikuCode2;
    @ReportItem(name = "gyoseikuMei2", order = 177)
    public RString gyoseikuMei2;
    @ReportItem(name = "chikuCode12", order = 178)
    public RString chikuCode12;
    @ReportItem(name = "chikuName12", order = 179)
    public RString chikuName12;
    @ReportItem(name = "chikuCode22", order = 180)
    public RString chikuCode22;
    @ReportItem(name = "chikuName22", order = 181)
    public RString chikuName22;
    @ReportItem(name = "chikuCode32", order = 182)
    public RString chikuCode32;
    @ReportItem(name = "chikuName32", order = 183)
    public RString chikuName32;
    @ReportItem(name = "yubinNo13", order = 184)
    public RString yubinNo13;
    @ReportItem(name = "yubinNo23", order = 185)
    public RString yubinNo23;
    @ReportItem(name = "yubinNo3", order = 186)
    public RString yubinNo3;
    @ReportItem(name = "barcodeCustombarcode3", order = 187)
    public RString barcodeCustombarcode3;
    @ReportItem(name = "sofusakiGyoseikuCode3", order = 188)
    public RString sofusakiGyoseikuCode3;
    @ReportItem(name = "sofusakiGyoseikuMei13", order = 189)
    public RString sofusakiGyoseikuMei13;
    @ReportItem(name = "sofusakiGyoseikuMei23", order = 190)
    public RString sofusakiGyoseikuMei23;
    @ReportItem(name = "sofusakiGyoseikuMei33", order = 191)
    public RString sofusakiGyoseikuMei33;
    @ReportItem(name = "atena13", order = 192)
    public RString atena13;
    @ReportItem(name = "atena23", order = 193)
    public RString atena23;
    @ReportItem(name = "atena33", order = 194)
    public RString atena33;
    @ReportItem(name = "sofusakiChikuName3", order = 195)
    public RString sofusakiChikuName3;
    @ReportItem(name = "sofusakiMeiboNo3", order = 196)
    public RString sofusakiMeiboNo3;
    @ReportItem(name = "mapJoho3", order = 197)
    public RString mapJoho3;
    @ReportItem(name = "jushoCode3", order = 198)
    public RString jushoCode3;
    @ReportItem(name = "jusho13", order = 199)
    public RString jusho13;
    @ReportItem(name = "jusho23", order = 200)
    public RString jusho23;
    @ReportItem(name = "jusho3", order = 201)
    public RString jusho3;
    @ReportItem(name = "shimei3", order = 202)
    public RString shimei3;
    @ReportItem(name = "shimeiKana3", order = 203)
    public RString shimeiKana3;
    @ReportItem(name = "tohyojoMei33", order = 204)
    public RString tohyojoMei33;
    @ReportItem(name = "tohyojoMei3", order = 205)
    public RString tohyojoMei3;
    @ReportItem(name = "tohyojoJusho3", order = 206)
    public RString tohyojoJusho3;
    @ReportItem(name = "tohyokuMei3", order = 207)
    public RString tohyokuMei3;
    @ReportItem(name = "meiboNo3", order = 208)
    public RString meiboNo3;
    @ReportItem(name = "barcodeNyujokenBarcode3", order = 209)
    public RString barcodeNyujokenBarcode3;
    @ReportItem(name = "gyoseikuCode3", order = 210)
    public RString gyoseikuCode3;
    @ReportItem(name = "gyoseikuMei3", order = 211)
    public RString gyoseikuMei3;
    @ReportItem(name = "chikuCode13", order = 212)
    public RString chikuCode13;
    @ReportItem(name = "chikuName13", order = 213)
    public RString chikuName13;
    @ReportItem(name = "chikuCode23", order = 214)
    public RString chikuCode23;
    @ReportItem(name = "chikuName23", order = 215)
    public RString chikuName23;
    @ReportItem(name = "chikuCode33", order = 216)
    public RString chikuCode33;
    @ReportItem(name = "chikuName33", order = 217)
    public RString chikuName33;
    @ReportItem(name = "setainushiMei_1", length = 25, order = 218)
    public RString setainushiMei_1;
    @ReportItem(name = "sofusakiSetaiCode1", order = 219)
    public RString sofusakiSetaiCode1;
    @ReportItem(name = "sofusakiSetaiCode2", order = 220)
    public RString sofusakiSetaiCode2;
    @ReportItem(name = "sofusakiSetaiCode3", order = 221)
    public RString sofusakiSetaiCode3;
    @ReportItem(name = "shimei_1", length = 41, order = 222)
    public RString shimei_1;
    @ReportItem(name = "shimeiKana_1", length = 59, order = 223)
    public RString shimeiKana_1;
    @ReportItem(name = "tohyojoMei_1", length = 51, order = 224)
    public RString tohyojoMei_1;
    @ReportItem(name = "shimei_2", length = 41, order = 225)
    public RString shimei_2;
    @ReportItem(name = "shimei_3", length = 41, order = 226)
    public RString shimei_3;
    @ReportItem(name = "shimeiKana_2", length = 59, order = 227)
    public RString shimeiKana_2;
    @ReportItem(name = "shimeiKana_3", length = 59, order = 228)
    public RString shimeiKana_3;
    @ReportItem(name = "tohyojoMei_2", length = 51, order = 229)
    public RString tohyojoMei_2;
    @ReportItem(name = "tohyojoMei_3", length = 51, order = 230)
    public RString tohyojoMei_3;
    @ReportItem(name = "setainushiMei_2", length = 25, order = 231)
    public RString setainushiMei_2;
    @ReportItem(name = "setainushiMei_3", length = 25, order = 232)
    public RString setainushiMei_3;
    @ReportItem(name = "tohyoTimeStart1_nn", order = 233)
    public RString tohyoTimeStart1_nn;
    @ReportItem(name = "tohyoTimeEnd1_nn", order = 234)
    public RString tohyoTimeEnd1_nn;
    @ReportItem(name = "tohyoTimeStart2_nn", order = 235)
    public RString tohyoTimeStart2_nn;
    @ReportItem(name = "tohyoTimeEnd2_nn", order = 236)
    public RString tohyoTimeEnd2_nn;
    @ReportItem(name = "tohyoTimeStart3_nn", order = 237)
    public RString tohyoTimeStart3_nn;
    @ReportItem(name = "tohyoTimeEnd3_nn", order = 238)
    public RString tohyoTimeEnd3_nn;
    @ReportItem(name = "shikibetsuCode_3tsuori_1", order = 239)
    public RString shikibetsuCode_3tsuori_1;
    @ReportItem(name = "shikibetsuCode_3tsuori_2", order = 240)
    public RString shikibetsuCode_3tsuori_2;
    @ReportItem(name = "shikibetsuCode_3tsuori_3", order = 241)
    public RString shikibetsuCode_3tsuori_3;

    /**
     * 投票所入場券（個票3つ折り）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        nyujokenName1,
        nyujokenName2,
        nyujokenName3,
        sofusakiJusho11,
        shimeiKana11,
        shimeiKana21,
        sofusakiJusho21,
        sofusakiJusho31,
        shimei21,
        shimei11,
        meiboPage1,
        meiboGyo1,
        seibetsu1,
        sofusakiJusho41,
        sofusakiJushoCode1,
        setainushiKubun1,
        shimei31,
        sofusakiJusho51,
        seinengappi1,
        sofusakiChikuCode1,
        shikibetsuCode1,
        setaiCode1,
        setainushiMei1,
        tohyoTimeStart1,
        tohyoTimeEnd1,
        tohyojoMei11,
        tohyokuCode1,
        tohyojoMei21,
        seiriNo1,
        sofusakiJusho12,
        shimeiKana12,
        shimeiKana22,
        sofusakiJusho22,
        sofusakiJusho32,
        shimei22,
        shimei12,
        meiboPage2,
        meiboGyo2,
        sofusakiJusho42,
        seibetsu2,
        sofusakiJushoCode2,
        setainushiKubun2,
        shimei32,
        sofusakiJusho52,
        seinengappi2,
        shikibetsuCode2,
        setainushiMei2,
        sofusakiChikuCode2,
        setaiCode2,
        tohyoTimeStart2,
        tohyoTimeEnd2,
        tohyojoMei12,
        tohyokuCode2,
        tohyojoMei22,
        seiriNo2,
        sofusakiJusho13,
        shimeiKana13,
        shimeiKana23,
        sofusakiJusho23,
        shimei23,
        sofusakiJusho33,
        shimei13,
        meiboPage3,
        meiboGyo3,
        seibetsu3,
        sofusakiJusho43,
        sofusakiJushoCode3,
        setainushiKubun3,
        shimei33,
        sofusakiJusho53,
        seinengappi3,
        shikibetsuCode3,
        sofusakiChikuCode3,
        setainushiMei3,
        setaiCode3,
        tohyoTimeStart3,
        tohyoTimeEnd3,
        tohyojoMei13,
        tohyokuCode3,
        tohyojoMei23,
        seiriNo3;
    }
    // </editor-fold>
}
