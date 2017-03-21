package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202;

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
 * 投票所入場券（はがき4つ切り）のReportSourceです。
 *
 * @reamsid_L AF-0160-032 liuj2
 */
public class NyujokenHagakiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "txtSample", length = 10, order = 1)
    public RString txtSample;
    @ReportItem(name = "yubinNo11", length = 3, order = 2)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo21", length = 4, order = 3)
    public RString yubinNo21;
    @ReportItem(name = "yubinNo12", length = 3, order = 4)
    public RString yubinNo12;
    @ReportItem(name = "yubinNo22", length = 4, order = 5)
    public RString yubinNo22;
    @ReportItem(name = "sofusakiGyoseikuMei11", length = 20, order = 6)
    public RString sofusakiGyoseikuMei11;
    @ReportItem(name = "sofusakiGyoseikuMei21", length = 16, order = 7)
    public RString sofusakiGyoseikuMei21;
    @ReportItem(name = "sofusakiGyoseikuMei12", length = 20, order = 8)
    public RString sofusakiGyoseikuMei12;
    @ReportItem(name = "sofusakiGyoseikuMei22", length = 16, order = 9)
    public RString sofusakiGyoseikuMei22;
    @ReportItem(name = "sofusakiGyoseikuMei31", length = 16, order = 10)
    public RString sofusakiGyoseikuMei31;
    @ReportItem(name = "sofusakiGyoseikuMei32", length = 16, order = 11)
    public RString sofusakiGyoseikuMei32;
    @ReportItem(name = "sofusakiJusho11", length = 21, order = 12)
    public RString sofusakiJusho11;
    @ReportItem(name = "sofusakiJusho12", length = 21, order = 13)
    public RString sofusakiJusho12;
    @ReportItem(name = "sofusakiJusho21", length = 21, order = 14)
    public RString sofusakiJusho21;
    @ReportItem(name = "sofusakiJusho22", length = 21, order = 15)
    public RString sofusakiJusho22;
    @ReportItem(name = "sofusakiJusho31", length = 21, order = 16)
    public RString sofusakiJusho31;
    @ReportItem(name = "sofusakiJusho32", length = 21, order = 17)
    public RString sofusakiJusho32;
    @ReportItem(name = "sofusakiJusho41", length = 21, order = 18)
    public RString sofusakiJusho41;
    @ReportItem(name = "sofusakiJusho42", length = 21, order = 19)
    public RString sofusakiJusho42;
    @ReportItem(name = "sofusakiJusho51", length = 21, order = 20)
    public RString sofusakiJusho51;
    @ReportItem(name = "sofusakiJusho52", length = 21, order = 21)
    public RString sofusakiJusho52;
    @ReportItem(name = "atena11", length = 14, order = 22)
    public RString atena11;
    @ReportItem(name = "atena12", length = 14, order = 23)
    public RString atena12;
    @ReportItem(name = "atena21", length = 14, order = 24)
    public RString atena21;
    @ReportItem(name = "atena22", length = 14, order = 25)
    public RString atena22;
    @ReportItem(name = "atena31", length = 14, order = 26)
    public RString atena31;
    @ReportItem(name = "atena32", length = 14, order = 27)
    public RString atena32;
    @ReportItem(name = "barcodeCustombarcode1", order = 28)
    public RString barcodeCustombarcode1;
    @ReportItem(name = "barcodeCustombarcode2", order = 29)
    public RString barcodeCustombarcode2;
    @ReportItem(name = "sofusakiMeiboNo1", length = 14, order = 30)
    public RString sofusakiMeiboNo1;
    @ReportItem(name = "sofusakiMeiboNo2", length = 14, order = 31)
    public RString sofusakiMeiboNo2;
    @ReportItem(name = "seiriNo1", length = 7, order = 32)
    public RString seiriNo1;
    @ReportItem(name = "seiriNo2", length = 7, order = 33)
    public RString seiriNo2;
    @ReportItem(name = "tohyoTimeStart1_hh", length = 2, order = 34)
    public RString tohyoTimeStart1_hh;
    @ReportItem(name = "tohyoTimeEnd1_hh", length = 2, order = 35)
    public RString tohyoTimeEnd1_hh;
    @ReportItem(name = "tohyoTimeStart2_hh", length = 2, order = 36)
    public RString tohyoTimeStart2_hh;
    @ReportItem(name = "tohyoTimeEnd2_hh", length = 2, order = 37)
    public RString tohyoTimeEnd2_hh;
    @ReportItem(name = "jusho11", length = 11, order = 38)
    public RString jusho11;
    @ReportItem(name = "jusho21", length = 14, order = 39)
    public RString jusho21;
    @ReportItem(name = "setaiCode1", length = 15, order = 40)
    public RString setaiCode1;
    @ReportItem(name = "jusho12", length = 11, order = 41)
    public RString jusho12;
    @ReportItem(name = "jusho22", length = 14, order = 42)
    public RString jusho22;
    @ReportItem(name = "setaiCode2", length = 15, order = 43)
    public RString setaiCode2;
    @ReportItem(name = "shimei21", length = 17, order = 44)
    public RString shimei21;
    @ReportItem(name = "shimei22", length = 17, order = 45)
    public RString shimei22;
    @ReportItem(name = "shimei11", length = 12, order = 46)
    public RString shimei11;
    @ReportItem(name = "seibetsu1", length = 1, order = 47)
    public RString seibetsu1;
    @ReportItem(name = "shimei12", length = 12, order = 48)
    public RString shimei12;
    @ReportItem(name = "seibetsu2", length = 1, order = 49)
    public RString seibetsu2;
    @ReportItem(name = "shimei31", length = 17, order = 50)
    public RString shimei31;
    @ReportItem(name = "shimei32", length = 17, order = 51)
    public RString shimei32;
    @ReportItem(name = "tohyojoMei21", length = 15, order = 52)
    public RString tohyojoMei21;
    @ReportItem(name = "tohyojoMei22", length = 15, order = 53)
    public RString tohyojoMei22;
    @ReportItem(name = "tohyojoMei11", length = 10, order = 54)
    public RString tohyojoMei11;
    @ReportItem(name = "tohyojoMei12", length = 10, order = 55)
    public RString tohyojoMei12;
    @ReportItem(name = "tohyokuCode1", length = 4, order = 56)
    public RString tohyokuCode1;
    @ReportItem(name = "meiboPage1", length = 6, order = 57)
    public RString meiboPage1;
    @ReportItem(name = "meiboGyo1", length = 2, order = 58)
    public RString meiboGyo1;
    @ReportItem(name = "tohyokuCode2", length = 4, order = 59)
    public RString tohyokuCode2;
    @ReportItem(name = "meiboPage2", length = 6, order = 60)
    public RString meiboPage2;
    @ReportItem(name = "meiboGyo2", length = 2, order = 61)
    public RString meiboGyo2;
    @ReportItem(name = "tohyojoMei31", length = 15, order = 62)
    public RString tohyojoMei31;
    @ReportItem(name = "tohyojoMei32", length = 15, order = 63)
    public RString tohyojoMei32;
    @ReportItem(name = "barcodeNyujokenBarcode1", order = 64)
    public RString barcodeNyujokenBarcode1;
    @ReportItem(name = "barcodeNyujokenBarcode2", order = 65)
    public RString barcodeNyujokenBarcode2;
    @ReportItem(name = "shikibetsuCode1", length = 15, order = 66)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", length = 15, order = 67)
    public RString shikibetsuCode2;
    @ReportItem(name = "yubinNo13", length = 3, order = 68)
    public RString yubinNo13;
    @ReportItem(name = "yubinNo23", length = 4, order = 69)
    public RString yubinNo23;
    @ReportItem(name = "yubinNo14", length = 3, order = 70)
    public RString yubinNo14;
    @ReportItem(name = "yubinNo24", length = 4, order = 71)
    public RString yubinNo24;
    @ReportItem(name = "sofusakiGyoseikuMei13", length = 20, order = 72)
    public RString sofusakiGyoseikuMei13;
    @ReportItem(name = "sofusakiGyoseikuMei23", length = 16, order = 73)
    public RString sofusakiGyoseikuMei23;
    @ReportItem(name = "sofusakiGyoseikuMei14", length = 20, order = 74)
    public RString sofusakiGyoseikuMei14;
    @ReportItem(name = "sofusakiGyoseikuMei24", length = 16, order = 75)
    public RString sofusakiGyoseikuMei24;
    @ReportItem(name = "sofusakiGyoseikuMei33", length = 16, order = 76)
    public RString sofusakiGyoseikuMei33;
    @ReportItem(name = "sofusakiGyoseikuMei34", length = 16, order = 77)
    public RString sofusakiGyoseikuMei34;
    @ReportItem(name = "sofusakiJusho13", length = 21, order = 78)
    public RString sofusakiJusho13;
    @ReportItem(name = "sofusakiJusho14", length = 21, order = 79)
    public RString sofusakiJusho14;
    @ReportItem(name = "sofusakiJusho23", length = 21, order = 80)
    public RString sofusakiJusho23;
    @ReportItem(name = "sofusakiJusho24", length = 21, order = 81)
    public RString sofusakiJusho24;
    @ReportItem(name = "sofusakiJusho33", length = 21, order = 82)
    public RString sofusakiJusho33;
    @ReportItem(name = "sofusakiJusho34", length = 21, order = 83)
    public RString sofusakiJusho34;
    @ReportItem(name = "sofusakiJusho43", length = 21, order = 84)
    public RString sofusakiJusho43;
    @ReportItem(name = "sofusakiJusho44", length = 21, order = 85)
    public RString sofusakiJusho44;
    @ReportItem(name = "sofusakiJusho53", length = 21, order = 86)
    public RString sofusakiJusho53;
    @ReportItem(name = "sofusakiJusho54", length = 21, order = 87)
    public RString sofusakiJusho54;
    @ReportItem(name = "atena13", length = 14, order = 88)
    public RString atena13;
    @ReportItem(name = "atena14", length = 14, order = 89)
    public RString atena14;
    @ReportItem(name = "atena23", length = 14, order = 90)
    public RString atena23;
    @ReportItem(name = "atena24", length = 14, order = 91)
    public RString atena24;
    @ReportItem(name = "atena33", length = 14, order = 92)
    public RString atena33;
    @ReportItem(name = "atena34", length = 14, order = 93)
    public RString atena34;
    @ReportItem(name = "barcodeCustombarcode3", order = 94)
    public RString barcodeCustombarcode3;
    @ReportItem(name = "barcodeCustombarcode4", order = 95)
    public RString barcodeCustombarcode4;
    @ReportItem(name = "sofusakiMeiboNo3", length = 14, order = 96)
    public RString sofusakiMeiboNo3;
    @ReportItem(name = "sofusakiMeiboNo4", length = 14, order = 97)
    public RString sofusakiMeiboNo4;
    @ReportItem(name = "seiriNo3", length = 7, order = 98)
    public RString seiriNo3;
    @ReportItem(name = "seiriNo4", length = 7, order = 99)
    public RString seiriNo4;
    @ReportItem(name = "tohyoTimeStart3_hh", length = 2, order = 100)
    public RString tohyoTimeStart3_hh;
    @ReportItem(name = "tohyoTimeEnd3_hh", length = 2, order = 101)
    public RString tohyoTimeEnd3_hh;
    @ReportItem(name = "tohyoTimeStart4_hh", length = 2, order = 102)
    public RString tohyoTimeStart4_hh;
    @ReportItem(name = "tohyoTimeEnd4_hh", length = 2, order = 103)
    public RString tohyoTimeEnd4_hh;
    @ReportItem(name = "jusho13", length = 11, order = 104)
    public RString jusho13;
    @ReportItem(name = "jusho23", length = 14, order = 105)
    public RString jusho23;
    @ReportItem(name = "setaiCode3", length = 15, order = 106)
    public RString setaiCode3;
    @ReportItem(name = "jusho14", length = 11, order = 107)
    public RString jusho14;
    @ReportItem(name = "jusho24", length = 14, order = 108)
    public RString jusho24;
    @ReportItem(name = "setaiCode4", length = 15, order = 109)
    public RString setaiCode4;
    @ReportItem(name = "shimei23", length = 17, order = 110)
    public RString shimei23;
    @ReportItem(name = "shimei24", length = 17, order = 111)
    public RString shimei24;
    @ReportItem(name = "shimei13", length = 12, order = 112)
    public RString shimei13;
    @ReportItem(name = "seibetsu3", length = 1, order = 113)
    public RString seibetsu3;
    @ReportItem(name = "shimei14", length = 12, order = 114)
    public RString shimei14;
    @ReportItem(name = "seibetsu4", length = 1, order = 115)
    public RString seibetsu4;
    @ReportItem(name = "shimei33", length = 17, order = 116)
    public RString shimei33;
    @ReportItem(name = "shimei34", length = 17, order = 117)
    public RString shimei34;
    @ReportItem(name = "tohyojoMei23", length = 15, order = 118)
    public RString tohyojoMei23;
    @ReportItem(name = "tohyojoMei24", length = 15, order = 119)
    public RString tohyojoMei24;
    @ReportItem(name = "tohyojoMei13", length = 10, order = 120)
    public RString tohyojoMei13;
    @ReportItem(name = "tohyojoMei14", length = 10, order = 121)
    public RString tohyojoMei14;
    @ReportItem(name = "tohyokuCode3", length = 4, order = 122)
    public RString tohyokuCode3;
    @ReportItem(name = "meiboPage3", length = 6, order = 123)
    public RString meiboPage3;
    @ReportItem(name = "meiboGyo3", length = 2, order = 124)
    public RString meiboGyo3;
    @ReportItem(name = "tohyokuCode4", length = 4, order = 125)
    public RString tohyokuCode4;
    @ReportItem(name = "meiboPage4", length = 6, order = 126)
    public RString meiboPage4;
    @ReportItem(name = "meiboGyo4", length = 2, order = 127)
    public RString meiboGyo4;
    @ReportItem(name = "tohyojoMei33", length = 15, order = 128)
    public RString tohyojoMei33;
    @ReportItem(name = "tohyojoMei34", length = 15, order = 129)
    public RString tohyojoMei34;
    @ReportItem(name = "barcodeNyujokenBarcode3", order = 130)
    public RString barcodeNyujokenBarcode3;
    @ReportItem(name = "barcodeNyujokenBarcode4", order = 131)
    public RString barcodeNyujokenBarcode4;
    @ReportItem(name = "shikibetsuCode3", length = 15, order = 132)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", length = 15, order = 133)
    public RString shikibetsuCode4;
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
    @ReportItem(name = "nyujokenName1", order = 134)
    public RString nyujokenName1;
    @ReportItem(name = "nyujokenName2", order = 135)
    public RString nyujokenName2;
    @ReportItem(name = "nyujokenName3", order = 136)
    public RString nyujokenName3;
    @ReportItem(name = "shohonNo", order = 137)
    public RString shohonNo;
    @ReportItem(name = "shohonName", order = 138)
    public RString shohonName;
    @ReportItem(name = "senkyoMei1", order = 139)
    public RString senkyoMei1;
    @ReportItem(name = "senkyoMei2", order = 140)
    public RString senkyoMei2;
    @ReportItem(name = "senkyoMei3", order = 141)
    public RString senkyoMei3;
    @ReportItem(name = "senkyoMei4", order = 142)
    public RString senkyoMei4;
    @ReportItem(name = "senkyoMei5", order = 143)
    public RString senkyoMei5;
    @ReportItem(name = "senkyoMei6", order = 144)
    public RString senkyoMei6;
    @ReportItem(name = "senkyoMei7", order = 145)
    public RString senkyoMei7;
    @ReportItem(name = "senkyoMei8", order = 146)
    public RString senkyoMei8;
    @ReportItem(name = "senkyoMei9", order = 147)
    public RString senkyoMei9;
    @ReportItem(name = "senkyoRyakusho1", order = 148)
    public RString senkyoRyakusho1;
    @ReportItem(name = "senkyoRyakusho2", order = 149)
    public RString senkyoRyakusho2;
    @ReportItem(name = "senkyoRyakusho3", order = 150)
    public RString senkyoRyakusho3;
    @ReportItem(name = "senkyoRyakusho4", order = 151)
    public RString senkyoRyakusho4;
    @ReportItem(name = "senkyoRyakusho5", order = 152)
    public RString senkyoRyakusho5;
    @ReportItem(name = "senkyoRyakusho6", order = 153)
    public RString senkyoRyakusho6;
    @ReportItem(name = "senkyoRyakusho7", order = 154)
    public RString senkyoRyakusho7;
    @ReportItem(name = "senkyoRyakusho8", order = 155)
    public RString senkyoRyakusho8;
    @ReportItem(name = "senkyoRyakusho9", order = 156)
    public RString senkyoRyakusho9;
    @ReportItem(name = "tohyoYMD", order = 157)
    public RString tohyoYMD;
    @ReportItem(name = "tohyoYMD_gengou", order = 158)
    public RString tohyoYMD_gengou;
    @ReportItem(name = "tohyoYMD_yyyy", order = 159)
    public RString tohyoYMD_yyyy;
    @ReportItem(name = "tohyoYMD_mm", order = 160)
    public RString tohyoYMD_mm;
    @ReportItem(name = "tohyoYMD_dd", order = 161)
    public RString tohyoYMD_dd;
    @ReportItem(name = "tohyoYMD_youbi", order = 162)
    public RString tohyoYMD_youbi;
    @ReportItem(name = "kokujiYMD", order = 163)
    public RString kokujiYMD;
    @ReportItem(name = "kokujiYMD_gengou", order = 164)
    public RString kokujiYMD_gengou;
    @ReportItem(name = "kokujiYMD_yyyy", order = 165)
    public RString kokujiYMD_yyyy;
    @ReportItem(name = "kokujiYMD_mm", order = 166)
    public RString kokujiYMD_mm;
    @ReportItem(name = "kokujiYMD_dd", order = 167)
    public RString kokujiYMD_dd;
    @ReportItem(name = "kokujiYMD_youbi", order = 168)
    public RString kokujiYMD_youbi;
    @ReportItem(name = "shichosonName", order = 169)
    public RString shichosonName;
    @ReportItem(name = "yubinNo1", order = 170)
    public RString yubinNo1;
    @ReportItem(name = "sofusakiGyoseikuCode1", order = 171)
    public RString sofusakiGyoseikuCode1;
    @ReportItem(name = "sofusakiJushoCode1", order = 172)
    public RString sofusakiJushoCode1;
    @ReportItem(name = "sofusakiChikuName1", order = 173)
    public RString sofusakiChikuName1;
    @ReportItem(name = "sofusakiSetaiCode1", order = 174)
    public RString sofusakiSetaiCode1;
    @ReportItem(name = "setainushiMei1", order = 175)
    public RString setainushiMei1;
    @ReportItem(name = "mapJoho1", order = 176)
    public RString mapJoho1;
    @ReportItem(name = "jushoCode1", order = 177)
    public RString jushoCode1;
    @ReportItem(name = "jusho1", order = 178)
    public RString jusho1;
    @ReportItem(name = "shimei1", order = 179)
    public RString shimei1;
    @ReportItem(name = "shimeiKana11", order = 180)
    public RString shimeiKana11;
    @ReportItem(name = "shimeiKana21", order = 181)
    public RString shimeiKana21;
    @ReportItem(name = "shimeiKana1", order = 182)
    public RString shimeiKana1;
    @ReportItem(name = "setainushiKubun1", order = 183)
    public RString setainushiKubun1;
    @ReportItem(name = "seinengappi1", order = 184)
    public RString seinengappi1;
    @ReportItem(name = "tohyojoMei1", order = 185)
    public RString tohyojoMei1;
    @ReportItem(name = "tohyojoJusho1", order = 186)
    public RString tohyojoJusho1;
    @ReportItem(name = "tohyokuMei1", order = 187)
    public RString tohyokuMei1;
    @ReportItem(name = "meiboNo1", order = 188)
    public RString meiboNo1;
    @ReportItem(name = "gyoseikuCode1", order = 189)
    public RString gyoseikuCode1;
    @ReportItem(name = "gyoseikuMei1", order = 190)
    public RString gyoseikuMei1;
    @ReportItem(name = "chikuCode11", order = 191)
    public RString chikuCode11;
    @ReportItem(name = "chikuName11", order = 192)
    public RString chikuName11;
    @ReportItem(name = "chikuCode21", order = 193)
    public RString chikuCode21;
    @ReportItem(name = "chikuName21", order = 194)
    public RString chikuName21;
    @ReportItem(name = "chikuCode31", order = 195)
    public RString chikuCode31;
    @ReportItem(name = "chikuName31", order = 196)
    public RString chikuName31;
    @ReportItem(name = "yubinNo2", order = 197)
    public RString yubinNo2;
    @ReportItem(name = "sofusakiGyoseikuCode2", order = 198)
    public RString sofusakiGyoseikuCode2;
    @ReportItem(name = "sofusakiJushoCode2", order = 199)
    public RString sofusakiJushoCode2;
    @ReportItem(name = "sofusakiChikuName2", order = 200)
    public RString sofusakiChikuName2;
    @ReportItem(name = "sofusakiSetaiCode2", order = 201)
    public RString sofusakiSetaiCode2;
    @ReportItem(name = "setainushiMei2", order = 202)
    public RString setainushiMei2;
    @ReportItem(name = "mapJoho2", order = 203)
    public RString mapJoho2;
    @ReportItem(name = "jushoCode2", order = 204)
    public RString jushoCode2;
    @ReportItem(name = "jusho2", order = 205)
    public RString jusho2;
    @ReportItem(name = "shimei2", order = 206)
    public RString shimei2;
    @ReportItem(name = "shimeiKana12", order = 207)
    public RString shimeiKana12;
    @ReportItem(name = "shimeiKana22", order = 208)
    public RString shimeiKana22;
    @ReportItem(name = "shimeiKana2", order = 209)
    public RString shimeiKana2;
    @ReportItem(name = "setainushiKubun2", order = 210)
    public RString setainushiKubun2;
    @ReportItem(name = "seinengappi2", order = 211)
    public RString seinengappi2;
    @ReportItem(name = "tohyojoMei2", order = 212)
    public RString tohyojoMei2;
    @ReportItem(name = "tohyojoJusho2", order = 213)
    public RString tohyojoJusho2;
    @ReportItem(name = "tohyokuMei2", order = 214)
    public RString tohyokuMei2;
    @ReportItem(name = "meiboNo2", order = 215)
    public RString meiboNo2;
    @ReportItem(name = "gyoseikuCode2", order = 216)
    public RString gyoseikuCode2;
    @ReportItem(name = "gyoseikuMei2", order = 217)
    public RString gyoseikuMei2;
    @ReportItem(name = "chikuCode12", order = 218)
    public RString chikuCode12;
    @ReportItem(name = "chikuName12", order = 219)
    public RString chikuName12;
    @ReportItem(name = "chikuCode22", order = 220)
    public RString chikuCode22;
    @ReportItem(name = "chikuName22", order = 221)
    public RString chikuName22;
    @ReportItem(name = "chikuCode32", order = 222)
    public RString chikuCode32;
    @ReportItem(name = "chikuName32", order = 223)
    public RString chikuName32;
    @ReportItem(name = "yubinNo3", order = 224)
    public RString yubinNo3;
    @ReportItem(name = "sofusakiGyoseikuCode3", order = 225)
    public RString sofusakiGyoseikuCode3;
    @ReportItem(name = "sofusakiJushoCode3", order = 226)
    public RString sofusakiJushoCode3;
    @ReportItem(name = "sofusakiChikuName3", order = 227)
    public RString sofusakiChikuName3;
    @ReportItem(name = "sofusakiSetaiCode3", order = 228)
    public RString sofusakiSetaiCode3;
    @ReportItem(name = "setainushiMei3", order = 229)
    public RString setainushiMei3;
    @ReportItem(name = "mapJoho3", order = 230)
    public RString mapJoho3;
    @ReportItem(name = "jushoCode3", order = 231)
    public RString jushoCode3;
    @ReportItem(name = "jusho3", order = 232)
    public RString jusho3;
    @ReportItem(name = "shimei3", order = 233)
    public RString shimei3;
    @ReportItem(name = "shimeiKana13", order = 234)
    public RString shimeiKana13;
    @ReportItem(name = "shimeiKana23", order = 235)
    public RString shimeiKana23;
    @ReportItem(name = "shimeiKana3", order = 236)
    public RString shimeiKana3;
    @ReportItem(name = "setainushiKubun3", order = 237)
    public RString setainushiKubun3;
    @ReportItem(name = "seinengappi3", order = 238)
    public RString seinengappi3;
    @ReportItem(name = "tohyojoMei3", order = 239)
    public RString tohyojoMei3;
    @ReportItem(name = "tohyojoJusho3", order = 240)
    public RString tohyojoJusho3;
    @ReportItem(name = "tohyokuMei3", order = 241)
    public RString tohyokuMei3;
    @ReportItem(name = "meiboNo3", order = 242)
    public RString meiboNo3;
    @ReportItem(name = "gyoseikuCode3", order = 243)
    public RString gyoseikuCode3;
    @ReportItem(name = "gyoseikuMei3", order = 244)
    public RString gyoseikuMei3;
    @ReportItem(name = "chikuCode13", order = 245)
    public RString chikuCode13;
    @ReportItem(name = "chikuName13", order = 246)
    public RString chikuName13;
    @ReportItem(name = "chikuCode23", order = 247)
    public RString chikuCode23;
    @ReportItem(name = "chikuName23", order = 248)
    public RString chikuName23;
    @ReportItem(name = "chikuCode33", order = 249)
    public RString chikuCode33;
    @ReportItem(name = "chikuName33", order = 250)
    public RString chikuName33;
    @ReportItem(name = "yubinNo4", order = 251)
    public RString yubinNo4;
    @ReportItem(name = "sofusakiGyoseikuCode4", order = 252)
    public RString sofusakiGyoseikuCode4;
    @ReportItem(name = "sofusakiJushoCode4", order = 253)
    public RString sofusakiJushoCode4;
    @ReportItem(name = "sofusakiChikuName4", order = 254)
    public RString sofusakiChikuName4;
    @ReportItem(name = "sofusakiSetaiCode4", order = 255)
    public RString sofusakiSetaiCode4;
    @ReportItem(name = "setainushiMei4", order = 256)
    public RString setainushiMei4;
    @ReportItem(name = "mapJoho4", order = 257)
    public RString mapJoho4;
    @ReportItem(name = "jushoCode4", order = 258)
    public RString jushoCode4;
    @ReportItem(name = "jusho4", order = 259)
    public RString jusho4;
    @ReportItem(name = "shimei4", order = 260)
    public RString shimei4;
    @ReportItem(name = "shimeiKana14", order = 261)
    public RString shimeiKana14;
    @ReportItem(name = "shimeiKana24", order = 262)
    public RString shimeiKana24;
    @ReportItem(name = "shimeiKana4", order = 263)
    public RString shimeiKana4;
    @ReportItem(name = "setainushiKubun4", order = 264)
    public RString setainushiKubun4;
    @ReportItem(name = "seinengappi4", order = 265)
    public RString seinengappi4;
    @ReportItem(name = "tohyojoMei4", order = 266)
    public RString tohyojoMei4;
    @ReportItem(name = "tohyojoJusho4", order = 267)
    public RString tohyojoJusho4;
    @ReportItem(name = "tohyokuMei4", order = 268)
    public RString tohyokuMei4;
    @ReportItem(name = "meiboNo4", order = 269)
    public RString meiboNo4;
    @ReportItem(name = "gyoseikuCode4", order = 270)
    public RString gyoseikuCode4;
    @ReportItem(name = "gyoseikuMei4", order = 271)
    public RString gyoseikuMei4;
    @ReportItem(name = "chikuCode14", order = 272)
    public RString chikuCode14;
    @ReportItem(name = "chikuName14", order = 273)
    public RString chikuName14;
    @ReportItem(name = "chikuCode24", order = 274)
    public RString chikuCode24;
    @ReportItem(name = "chikuName24", order = 275)
    public RString chikuName24;
    @ReportItem(name = "chikuCode34", order = 276)
    public RString chikuCode34;
    @ReportItem(name = "chikuName34", order = 277)
    public RString chikuName34;
    @ReportItem(name = "atena", order = 278)
    public RString atena;
    @ReportItem(name = "jusho", order = 279)
    public RString jusho;
    @ReportItem(name = "sofusakiChikuCode1", order = 280)
    public RString sofusakiChikuCode1;
    @ReportItem(name = "sofusakiChikuCode2", order = 281)
    public RString sofusakiChikuCode2;
    @ReportItem(name = "sofusakiChikuCode3", order = 282)
    public RString sofusakiChikuCode3;
    @ReportItem(name = "sofusakiChikuCode4", order = 283)
    public RString sofusakiChikuCode4;
    @ReportItem(name = "sofusakiJusho_1", length = 105, order = 284)
    public RString sofusakiJusho_1;
    @ReportItem(name = "shimei_1", length = 46, order = 285)
    public RString shimei_1;
    @ReportItem(name = "tohyojoMei_1", length = 40, order = 286)
    public RString tohyojoMei_1;
    @ReportItem(name = "shikibetsuCode", order = 287)
    public RString shikibetsuCode;
    @ReportItem(name = "sofusakiJusho_2", length = 105, order = 288)
    public RString sofusakiJusho_2;
    @ReportItem(name = "sofusakiJusho_3", length = 105, order = 289)
    public RString sofusakiJusho_3;
    @ReportItem(name = "sofusakiJusho_4", length = 105, order = 290)
    public RString sofusakiJusho_4;
    @ReportItem(name = "shimei_2", length = 46, order = 285)
    public RString shimei_2;
    @ReportItem(name = "shimei_3", length = 46, order = 285)
    public RString shimei_3;
    @ReportItem(name = "shimei_4", length = 46, order = 285)
    public RString shimei_4;
    @ReportItem(name = "tohyojoMei_2", length = 40, order = 286)
    public RString tohyojoMei_2;
    @ReportItem(name = "tohyojoMei_3", length = 40, order = 286)
    public RString tohyojoMei_3;
    @ReportItem(name = "tohyojoMei_4", length = 40, order = 286)
    public RString tohyojoMei_4;
    @ReportItem(name = "tohyoTimeStart1_nn", order = 287)
    public RString tohyoTimeStart1_nn;
    @ReportItem(name = "tohyoTimeEnd1_nn", order = 288)
    public RString tohyoTimeEnd1_nn;
    @ReportItem(name = "tohyoTimeStart2_nn", order = 289)
    public RString tohyoTimeStart2_nn;
    @ReportItem(name = "tohyoTimeEnd2_nn", order = 290)
    public RString tohyoTimeEnd2_nn;
    @ReportItem(name = "tohyoTimeStart3_nn", order = 291)
    public RString tohyoTimeStart3_nn;
    @ReportItem(name = "tohyoTimeEnd3_nn", order = 292)
    public RString tohyoTimeEnd3_nn;
    @ReportItem(name = "tohyoTimeStart4_nn", order = 293)
    public RString tohyoTimeStart4_nn;
    @ReportItem(name = "tohyoTimeEnd4_nn", order = 294)
    public RString tohyoTimeEnd4_nn;
    @ReportItem(name = "atena_1", length = 42, order = 295)
    public RString atena_1;
    @ReportItem(name = "atena_2", length = 42, order = 296)
    public RString atena_2;
    @ReportItem(name = "atena_3", length = 42, order = 297)
    public RString atena_3;
    @ReportItem(name = "atena_4", length = 42, order = 298)
    public RString atena_4;
    @ReportItem(name = "jusho_1", length = 25, order = 299)
    public RString jusho_1;
    @ReportItem(name = "jusho_2", length = 25, order = 300)
    public RString jusho_2;
    @ReportItem(name = "jusho_3", length = 25, order = 301)
    public RString jusho_3;
    @ReportItem(name = "jusho_4", length = 25, order = 302)
    public RString jusho_4;
    @ReportItem(name = "shikibetsuCode_Hagaki_1", order = 303)
    public RString shikibetsuCode_Hagaki_1;
    @ReportItem(name = "shikibetsuCode_Hagaki_2", order = 304)
    public RString shikibetsuCode_Hagaki_2;
    @ReportItem(name = "shikibetsuCode_Hagaki_3", order = 305)
    public RString shikibetsuCode_Hagaki_3;
    @ReportItem(name = "shikibetsuCode_Hagaki_4", order = 306)
    public RString shikibetsuCode_Hagaki_4;

    /**
     * 投票所入場券（はがき4つ切り）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        yubinNo11,
        yubinNo21,
        yubinNo12,
        yubinNo22,
        sofusakiGyoseikuMei11,
        sofusakiGyoseikuMei21,
        sofusakiGyoseikuMei12,
        sofusakiGyoseikuMei22,
        sofusakiGyoseikuMei31,
        sofusakiGyoseikuMei32,
        sofusakiJusho11,
        sofusakiJusho12,
        sofusakiJusho21,
        sofusakiJusho22,
        sofusakiJusho31,
        sofusakiJusho32,
        sofusakiJusho41,
        sofusakiJusho42,
        sofusakiJusho51,
        sofusakiJusho52,
        atena11,
        atena12,
        atena21,
        atena22,
        atena31,
        atena32,
        barcodeCustombarcode1,
        barcodeCustombarcode2,
        sofusakiMeiboNo1,
        sofusakiMeiboNo2,
        seiriNo1,
        seiriNo2,
        tohyoTimeStart1,
        tohyoTimeEnd1,
        tohyoTimeStart2,
        tohyoTimeEnd2,
        jusho11,
        jusho21,
        setaiCode1,
        jusho12,
        jusho22,
        setaiCode2,
        shimei21,
        shimei22,
        shimei11,
        seibetsu1,
        shimei12,
        seibetsu2,
        shimei31,
        shimei32,
        tohyojoMei21,
        tohyojoMei22,
        tohyojoMei11,
        tohyojoMei12,
        tohyokuCode1,
        meiboPage1,
        meiboGyo1,
        tohyokuCode2,
        meiboPage2,
        meiboGyo2,
        tohyojoMei31,
        tohyojoMei32,
        barcodeNyujokenBarcode1,
        barcodeNyujokenBarcode2,
        shikibetsuCode1,
        shikibetsuCode2,
        yubinNo13,
        yubinNo23,
        yubinNo14,
        yubinNo24,
        sofusakiGyoseikuMei13,
        sofusakiGyoseikuMei23,
        sofusakiGyoseikuMei14,
        sofusakiGyoseikuMei24,
        sofusakiGyoseikuMei33,
        sofusakiGyoseikuMei34,
        sofusakiJusho13,
        sofusakiJusho14,
        sofusakiJusho23,
        sofusakiJusho24,
        sofusakiJusho33,
        sofusakiJusho34,
        sofusakiJusho43,
        sofusakiJusho44,
        sofusakiJusho53,
        sofusakiJusho54,
        atena13,
        atena14,
        atena23,
        atena24,
        atena33,
        atena34,
        barcodeCustombarcode3,
        barcodeCustombarcode4,
        sofusakiMeiboNo3,
        sofusakiMeiboNo4,
        seiriNo3,
        seiriNo4,
        tohyoTimeStart3,
        tohyoTimeEnd3,
        tohyoTimeStart4,
        tohyoTimeEnd4,
        jusho13,
        jusho23,
        setaiCode3,
        jusho14,
        jusho24,
        setaiCode4,
        shimei23,
        shimei24,
        shimei13,
        seibetsu3,
        shimei14,
        seibetsu4,
        shimei33,
        shimei34,
        tohyojoMei23,
        tohyojoMei24,
        tohyojoMei13,
        tohyojoMei14,
        tohyokuCode3,
        meiboPage3,
        meiboGyo3,
        tohyokuCode4,
        meiboPage4,
        meiboGyo4,
        tohyojoMei33,
        tohyojoMei34,
        barcodeNyujokenBarcode3,
        barcodeNyujokenBarcode4,
        shikibetsuCode3,
        shikibetsuCode4;
    }
    // </editor-fold>
}
