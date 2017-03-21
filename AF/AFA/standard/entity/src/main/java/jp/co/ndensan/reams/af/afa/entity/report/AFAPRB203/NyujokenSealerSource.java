package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203;

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
 * 投票所入場券（シーラー）のReportSourceです。
 *
 * @reamsid_L AF-0160-033 xul
 */
public class NyujokenSealerSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tohyoTimeStart1_hh", length = 2, order = 1)
    public RString tohyoTimeStart1_hh;
    @ReportItem(name = "tohyoTimeEnd1_hh", length = 2, order = 2)
    public RString tohyoTimeEnd1_hh;
    @ReportItem(name = "yubinNo11", length = 3, order = 3)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo21", length = 4, order = 4)
    public RString yubinNo21;
    @ReportItem(name = "jusho11", length = 11, order = 5)
    public RString jusho11;
    @ReportItem(name = "setaiCode1", length = 15, order = 6)
    public RString setaiCode1;
    @ReportItem(name = "jusho21", length = 14, order = 7)
    public RString jusho21;
    @ReportItem(name = "shimei21", length = 17, order = 8)
    public RString shimei21;
    @ReportItem(name = "shimei11", length = 12, order = 9)
    public RString shimei11;
    @ReportItem(name = "seibetsu1", length = 1, order = 10)
    public RString seibetsu1;
    @ReportItem(name = "shimei31", length = 17, order = 11)
    public RString shimei31;
    @ReportItem(name = "sofusakiGyoseikuMei11", length = 20, order = 12)
    public RString sofusakiGyoseikuMei11;
    @ReportItem(name = "sofusakiGyoseikuMei21", length = 16, order = 13)
    public RString sofusakiGyoseikuMei21;
    @ReportItem(name = "tohyojoMei21", length = 15, order = 14)
    public RString tohyojoMei21;
    @ReportItem(name = "tohyojoMei11", length = 10, order = 15)
    public RString tohyojoMei11;
    @ReportItem(name = "sofusakiGyoseikuMei31", length = 16, order = 16)
    public RString sofusakiGyoseikuMei31;
    @ReportItem(name = "tohyokuCode1", length = 4, order = 17)
    public RString tohyokuCode1;
    @ReportItem(name = "meiboPage1", length = 6, order = 18)
    public RString meiboPage1;
    @ReportItem(name = "meiboGyo1", length = 2, order = 19)
    public RString meiboGyo1;
    @ReportItem(name = "tohyojoMei31", length = 15, order = 20)
    public RString tohyojoMei31;
    @ReportItem(name = "sofusakiJusho11", length = 21, order = 21)
    public RString sofusakiJusho11;
    @ReportItem(name = "sofusakiJusho21", length = 21, order = 22)
    public RString sofusakiJusho21;
    @ReportItem(name = "sofusakiJusho31", length = 21, order = 23)
    public RString sofusakiJusho31;
    @ReportItem(name = "tohyoTimeStart2_hh", length = 2, order = 24)
    public RString tohyoTimeStart2_hh;
    @ReportItem(name = "tohyoTimeEnd2_hh", length = 2, order = 25)
    public RString tohyoTimeEnd2_hh;
    @ReportItem(name = "sofusakiJusho41", length = 21, order = 26)
    public RString sofusakiJusho41;
    @ReportItem(name = "jusho12", length = 11, order = 27)
    public RString jusho12;
    @ReportItem(name = "setaiCode2", length = 15, order = 28)
    public RString setaiCode2;
    @ReportItem(name = "jusho22", length = 14, order = 29)
    public RString jusho22;
    @ReportItem(name = "sofusakiJusho51", length = 21, order = 30)
    public RString sofusakiJusho51;
    @ReportItem(name = "shimei22", length = 17, order = 31)
    public RString shimei22;
    @ReportItem(name = "atena11", length = 14, order = 32)
    public RString atena11;
    @ReportItem(name = "shimei12", length = 12, order = 33)
    public RString shimei12;
    @ReportItem(name = "seibetsu2", length = 1, order = 34)
    public RString seibetsu2;
    @ReportItem(name = "shimei32", length = 17, order = 35)
    public RString shimei32;
    @ReportItem(name = "atena21", length = 14, order = 36)
    public RString atena21;
    @ReportItem(name = "tohyojoMei22", length = 15, order = 37)
    public RString tohyojoMei22;
    @ReportItem(name = "tohyojoMei12", length = 10, order = 38)
    public RString tohyojoMei12;
    @ReportItem(name = "tohyokuCode2", length = 4, order = 39)
    public RString tohyokuCode2;
    @ReportItem(name = "meiboPage2", length = 6, order = 40)
    public RString meiboPage2;
    @ReportItem(name = "meiboGyo2", length = 2, order = 41)
    public RString meiboGyo2;
    @ReportItem(name = "tohyojoMei32", length = 15, order = 42)
    public RString tohyojoMei32;
    @ReportItem(name = "atena31", length = 14, order = 43)
    public RString atena31;
    @ReportItem(name = "barcodeCustombarcode1", order = 44)
    public RString barcodeCustombarcode1;
    @ReportItem(name = "sofusakiMeiboNo1", length = 14, order = 45)
    public RString sofusakiMeiboNo1;
    @ReportItem(name = "seiriNo1", length = 7, order = 46)
    public RString seiriNo1;
    @ReportItem(name = "tohyoTimeStart3_hh", length = 2, order = 47)
    public RString tohyoTimeStart3_hh;
    @ReportItem(name = "tohyoTimeEnd3_hh", length = 2, order = 48)
    public RString tohyoTimeEnd3_hh;
    @ReportItem(name = "jusho13", length = 11, order = 49)
    public RString jusho13;
    @ReportItem(name = "setaiCode3", length = 15, order = 50)
    public RString setaiCode3;
    @ReportItem(name = "jusho23", length = 14, order = 51)
    public RString jusho23;
    @ReportItem(name = "shimei23", length = 17, order = 52)
    public RString shimei23;
    @ReportItem(name = "shimei13", length = 12, order = 53)
    public RString shimei13;
    @ReportItem(name = "seibetsu3", length = 1, order = 54)
    public RString seibetsu3;
    @ReportItem(name = "shimei33", length = 17, order = 55)
    public RString shimei33;
    @ReportItem(name = "tohyojoMei23", length = 15, order = 56)
    public RString tohyojoMei23;
    @ReportItem(name = "tohyojoMei13", length = 10, order = 57)
    public RString tohyojoMei13;
    @ReportItem(name = "tohyokuCode3", length = 4, order = 58)
    public RString tohyokuCode3;
    @ReportItem(name = "meiboPage3", length = 6, order = 59)
    public RString meiboPage3;
    @ReportItem(name = "meiboGyo3", length = 2, order = 60)
    public RString meiboGyo3;
    @ReportItem(name = "tohyojoMei33", length = 15, order = 61)
    public RString tohyojoMei33;
    @ReportItem(name = "tohyoTimeStart4_hh", length = 2, order = 62)
    public RString tohyoTimeStart4_hh;
    @ReportItem(name = "tohyoTimeEnd4_hh", length = 2, order = 63)
    public RString tohyoTimeEnd4_hh;
    @ReportItem(name = "jusho14", length = 11, order = 64)
    public RString jusho14;
    @ReportItem(name = "jusho24", length = 14, order = 65)
    public RString jusho24;
    @ReportItem(name = "setaiCode4", length = 15, order = 66)
    public RString setaiCode4;
    @ReportItem(name = "shimei24", length = 17, order = 67)
    public RString shimei24;
    @ReportItem(name = "shimei14", length = 12, order = 68)
    public RString shimei14;
    @ReportItem(name = "seibetsu4", length = 1, order = 69)
    public RString seibetsu4;
    @ReportItem(name = "shimei34", length = 17, order = 70)
    public RString shimei34;
    @ReportItem(name = "tohyojoMei24", length = 15, order = 71)
    public RString tohyojoMei24;
    @ReportItem(name = "tohyojoMei14", length = 10, order = 72)
    public RString tohyojoMei14;
    @ReportItem(name = "tohyokuCode4", length = 4, order = 73)
    public RString tohyokuCode4;
    @ReportItem(name = "meiboPage4", length = 6, order = 74)
    public RString meiboPage4;
    @ReportItem(name = "meiboGyo4", length = 2, order = 75)
    public RString meiboGyo4;
    @ReportItem(name = "tohyojoMei34", length = 15, order = 76)
    public RString tohyojoMei34;
    @ReportItem(name = "tohyoTimeStart5_hh", length = 2, order = 77)
    public RString tohyoTimeStart5_hh;
    @ReportItem(name = "tohyoTimeEnd5_hh", length = 2, order = 78)
    public RString tohyoTimeEnd5_hh;
    @ReportItem(name = "yubinNo12", length = 3, order = 79)
    public RString yubinNo12;
    @ReportItem(name = "yubinNo22", length = 4, order = 80)
    public RString yubinNo22;
    @ReportItem(name = "jusho15", length = 11, order = 81)
    public RString jusho15;
    @ReportItem(name = "setaiCode5", length = 15, order = 82)
    public RString setaiCode5;
    @ReportItem(name = "jusho25", length = 14, order = 83)
    public RString jusho25;
    @ReportItem(name = "shimei25", length = 17, order = 84)
    public RString shimei25;
    @ReportItem(name = "shimei15", length = 12, order = 85)
    public RString shimei15;
    @ReportItem(name = "seibetsu5", length = 1, order = 86)
    public RString seibetsu5;
    @ReportItem(name = "shimei35", length = 17, order = 87)
    public RString shimei35;
    @ReportItem(name = "sofusakiGyoseikuMei12", length = 20, order = 88)
    public RString sofusakiGyoseikuMei12;
    @ReportItem(name = "sofusakiGyoseikuMei22", length = 16, order = 89)
    public RString sofusakiGyoseikuMei22;
    @ReportItem(name = "tohyojoMei25", length = 15, order = 90)
    public RString tohyojoMei25;
    @ReportItem(name = "tohyojoMei15", length = 10, order = 91)
    public RString tohyojoMei15;
    @ReportItem(name = "sofusakiGyoseikuMei32", length = 16, order = 92)
    public RString sofusakiGyoseikuMei32;
    @ReportItem(name = "tohyokuCode5", length = 4, order = 93)
    public RString tohyokuCode5;
    @ReportItem(name = "meiboPage5", length = 6, order = 94)
    public RString meiboPage5;
    @ReportItem(name = "meiboGyo5", length = 2, order = 95)
    public RString meiboGyo5;
    @ReportItem(name = "tohyojoMei35", length = 15, order = 96)
    public RString tohyojoMei35;
    @ReportItem(name = "sofusakiJusho12", length = 21, order = 97)
    public RString sofusakiJusho12;
    @ReportItem(name = "sofusakiJusho22", length = 21, order = 98)
    public RString sofusakiJusho22;
    @ReportItem(name = "sofusakiJusho32", length = 21, order = 99)
    public RString sofusakiJusho32;
    @ReportItem(name = "tohyoTimeStart6_hh", length = 2, order = 100)
    public RString tohyoTimeStart6_hh;
    @ReportItem(name = "tohyoTimeEnd6_hh", length = 2, order = 101)
    public RString tohyoTimeEnd6_hh;
    @ReportItem(name = "sofusakiJusho42", length = 21, order = 102)
    public RString sofusakiJusho42;
    @ReportItem(name = "jusho16", length = 11, order = 103)
    public RString jusho16;
    @ReportItem(name = "setaiCode6", length = 15, order = 104)
    public RString setaiCode6;
    @ReportItem(name = "jusho26", length = 14, order = 105)
    public RString jusho26;
    @ReportItem(name = "sofusakiJusho52", length = 21, order = 106)
    public RString sofusakiJusho52;
    @ReportItem(name = "shimei26", length = 17, order = 107)
    public RString shimei26;
    @ReportItem(name = "atena12", length = 14, order = 108)
    public RString atena12;
    @ReportItem(name = "shimei16", length = 12, order = 109)
    public RString shimei16;
    @ReportItem(name = "seibetsu6", length = 1, order = 110)
    public RString seibetsu6;
    @ReportItem(name = "shimei36", length = 17, order = 111)
    public RString shimei36;
    @ReportItem(name = "atena22", length = 14, order = 112)
    public RString atena22;
    @ReportItem(name = "tohyojoMei26", length = 15, order = 113)
    public RString tohyojoMei26;
    @ReportItem(name = "tohyojoMei16", length = 10, order = 114)
    public RString tohyojoMei16;
    @ReportItem(name = "tohyokuCode6", length = 4, order = 115)
    public RString tohyokuCode6;
    @ReportItem(name = "meiboPage6", length = 6, order = 116)
    public RString meiboPage6;
    @ReportItem(name = "meiboGyo6", length = 2, order = 117)
    public RString meiboGyo6;
    @ReportItem(name = "tohyojoMei36", length = 15, order = 118)
    public RString tohyojoMei36;
    @ReportItem(name = "atena32", length = 14, order = 119)
    public RString atena32;
    @ReportItem(name = "barcodeCustombarcode2", order = 120)
    public RString barcodeCustombarcode2;
    @ReportItem(name = "sofusakiMeiboNo2", length = 14, order = 121)
    public RString sofusakiMeiboNo2;
    @ReportItem(name = "seiriNo2", length = 7, order = 122)
    public RString seiriNo2;
    @ReportItem(name = "tohyoTimeStart7_hh", length = 2, order = 123)
    public RString tohyoTimeStart7_hh;
    @ReportItem(name = "tohyoTimeEnd7_hh", length = 2, order = 124)
    public RString tohyoTimeEnd7_hh;
    @ReportItem(name = "jusho17", length = 11, order = 125)
    public RString jusho17;
    @ReportItem(name = "setaiCode7", length = 15, order = 126)
    public RString setaiCode7;
    @ReportItem(name = "jusho27", length = 14, order = 127)
    public RString jusho27;
    @ReportItem(name = "shimei27", length = 17, order = 128)
    public RString shimei27;
    @ReportItem(name = "shimei17", length = 12, order = 129)
    public RString shimei17;
    @ReportItem(name = "seibetsu7", length = 1, order = 130)
    public RString seibetsu7;
    @ReportItem(name = "shimei37", length = 17, order = 131)
    public RString shimei37;
    @ReportItem(name = "tohyojoMei27", length = 15, order = 132)
    public RString tohyojoMei27;
    @ReportItem(name = "tohyojoMei17", length = 10, order = 133)
    public RString tohyojoMei17;
    @ReportItem(name = "tohyokuCode7", length = 4, order = 134)
    public RString tohyokuCode7;
    @ReportItem(name = "meiboPage7", length = 6, order = 135)
    public RString meiboPage7;
    @ReportItem(name = "meiboGyo7", length = 2, order = 136)
    public RString meiboGyo7;
    @ReportItem(name = "tohyojoMei37", length = 15, order = 137)
    public RString tohyojoMei37;
    @ReportItem(name = "tohyoTimeStart8_hh", length = 2, order = 138)
    public RString tohyoTimeStart8_hh;
    @ReportItem(name = "tohyoTimeEnd8_hh", length = 2, order = 139)
    public RString tohyoTimeEnd8_hh;
    @ReportItem(name = "jusho18", length = 11, order = 140)
    public RString jusho18;
    @ReportItem(name = "setaiCode8", length = 15, order = 141)
    public RString setaiCode8;
    @ReportItem(name = "jusho28", length = 14, order = 142)
    public RString jusho28;
    @ReportItem(name = "shimei28", length = 17, order = 143)
    public RString shimei28;
    @ReportItem(name = "shimei18", length = 12, order = 144)
    public RString shimei18;
    @ReportItem(name = "seibetsu8", length = 1, order = 145)
    public RString seibetsu8;
    @ReportItem(name = "shimei38", length = 17, order = 146)
    public RString shimei38;
    @ReportItem(name = "tohyojoMei28", length = 15, order = 147)
    public RString tohyojoMei28;
    @ReportItem(name = "tohyojoMei18", length = 10, order = 148)
    public RString tohyojoMei18;
    @ReportItem(name = "tohyokuCode8", length = 4, order = 149)
    public RString tohyokuCode8;
    @ReportItem(name = "meiboPage8", length = 6, order = 150)
    public RString meiboPage8;
    @ReportItem(name = "meiboGyo8", length = 2, order = 151)
    public RString meiboGyo8;
    @ReportItem(name = "tohyojoMei38", length = 15, order = 152)
    public RString tohyojoMei38;
    @ReportItem(name = "txtSample", length = 10, order = 153)
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
    @ReportPerson(id = "X4")
    public ShikibetsuCode 識別コード4;
    @ReportKojinNo(id = "X4")
    public KojinNo 個人番号使用4;
    @ReportHojinNo(id = "X4")
    public HojinNo 法人番号使用4;
    @ReportPerson(id = "X5")
    public ShikibetsuCode 識別コード5;
    @ReportKojinNo(id = "X5")
    public KojinNo 個人番号使用5;
    @ReportHojinNo(id = "X5")
    public HojinNo 法人番号使用5;
    @ReportPerson(id = "X6")
    public ShikibetsuCode 識別コード6;
    @ReportKojinNo(id = "X6")
    public KojinNo 個人番号使用6;
    @ReportHojinNo(id = "X6")
    public HojinNo 法人番号使用6;
    @ReportPerson(id = "X7")
    public ShikibetsuCode 識別コード7;
    @ReportKojinNo(id = "X7")
    public KojinNo 個人番号使用7;
    @ReportHojinNo(id = "X7")
    public HojinNo 法人番号使用7;
    @ReportPerson(id = "X8")
    public ShikibetsuCode 識別コード8;
    @ReportKojinNo(id = "X8")
    public KojinNo 個人番号使用8;
    @ReportHojinNo(id = "X8")
    public HojinNo 法人番号使用8;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "nyujokenName1", order = 154)
    public RString nyujokenName1;
    @ReportItem(name = "nyujokenName2", order = 155)
    public RString nyujokenName2;
    @ReportItem(name = "nyujokenName3", order = 156)
    public RString nyujokenName3;
    @ReportItem(name = "shohonNo", order = 157)
    public RString shohonNo;
    @ReportItem(name = "shohonName", order = 158)
    public RString shohonName;
    @ReportItem(name = "senkyoMei1", order = 159)
    public RString senkyoMei1;
    @ReportItem(name = "senkyoMei2", order = 160)
    public RString senkyoMei2;
    @ReportItem(name = "senkyoMei3", order = 161)
    public RString senkyoMei3;
    @ReportItem(name = "senkyoMei4", order = 162)
    public RString senkyoMei4;
    @ReportItem(name = "senkyoMei5", order = 163)
    public RString senkyoMei5;
    @ReportItem(name = "senkyoMei6", order = 164)
    public RString senkyoMei6;
    @ReportItem(name = "senkyoMei7", order = 165)
    public RString senkyoMei7;
    @ReportItem(name = "senkyoMei8", order = 166)
    public RString senkyoMei8;
    @ReportItem(name = "senkyoMei9", order = 167)
    public RString senkyoMei9;
    @ReportItem(name = "senkyoRyakusho1", order = 168)
    public RString senkyoRyakusho1;
    @ReportItem(name = "senkyoRyakusho2", order = 169)
    public RString senkyoRyakusho2;
    @ReportItem(name = "senkyoRyakusho3", order = 170)
    public RString senkyoRyakusho3;
    @ReportItem(name = "senkyoRyakusho4", order = 171)
    public RString senkyoRyakusho4;
    @ReportItem(name = "senkyoRyakusho5", order = 172)
    public RString senkyoRyakusho5;
    @ReportItem(name = "senkyoRyakusho6", order = 173)
    public RString senkyoRyakusho6;
    @ReportItem(name = "senkyoRyakusho7", order = 174)
    public RString senkyoRyakusho7;
    @ReportItem(name = "senkyoRyakusho8", order = 175)
    public RString senkyoRyakusho8;
    @ReportItem(name = "senkyoRyakusho9", order = 176)
    public RString senkyoRyakusho9;
    @ReportItem(name = "tohyoYMD", order = 177)
    public RString tohyoYMD;
    @ReportItem(name = "tohyoYMD_gengou", order = 178)
    public RString tohyoYMD_gengou;
    @ReportItem(name = "tohyoYMD_yyyy", order = 179)
    public RString tohyoYMD_yyyy;
    @ReportItem(name = "tohyoYMD_mm", order = 180)
    public RString tohyoYMD_mm;
    @ReportItem(name = "tohyoYMD_dd", order = 181)
    public RString tohyoYMD_dd;
    @ReportItem(name = "tohyoYMD_youbi", order = 182)
    public RString tohyoYMD_youbi;
    @ReportItem(name = "kokujiYMD", order = 183)
    public RString kokujiYMD;
    @ReportItem(name = "kokujiYMD_gengou", order = 184)
    public RString kokujiYMD_gengou;
    @ReportItem(name = "kokujiYMD_yyyy", order = 185)
    public RString kokujiYMD_yyyy;
    @ReportItem(name = "kokujiYMD_mm", order = 186)
    public RString kokujiYMD_mm;
    @ReportItem(name = "kokujiYMD_dd", order = 187)
    public RString kokujiYMD_dd;
    @ReportItem(name = "kokujiYMD_youbi", order = 188)
    public RString kokujiYMD_youbi;
    @ReportItem(name = "shichosonName", order = 189)
    public RString shichosonName;
    @ReportItem(name = "yubinNo1", order = 190)
    public RString yubinNo1;
    @ReportItem(name = "sofusakiGyoseikuCode1", order = 191)
    public RString sofusakiGyoseikuCode1;
    @ReportItem(name = "sofusakiJushoCode1", order = 192)
    public RString sofusakiJushoCode1;
    @ReportItem(name = "sofusakiChikuCode1", order = 193)
    public RString sofusakiChikuCode1;
    @ReportItem(name = "sofusakiChikuName1", order = 194)
    public RString sofusakiChikuName1;
    @ReportItem(name = "sofusakiSetaiCode1", order = 195)
    public RString sofusakiSetaiCode1;
    @ReportItem(name = "setainushiMei1", order = 196)
    public RString setainushiMei1;
    @ReportItem(name = "mapJoho1", order = 197)
    public RString mapJoho1;
    @ReportItem(name = "jushoCode1", order = 198)
    public RString jushoCode1;
    @ReportItem(name = "jusho1", order = 199)
    public RString jusho1;
    @ReportItem(name = "shimei1", order = 200)
    public RString shimei1;
    @ReportItem(name = "shimeiKana11", order = 201)
    public RString shimeiKana11;
    @ReportItem(name = "shimeiKana21", order = 202)
    public RString shimeiKana21;
    @ReportItem(name = "shimeiKana1", order = 203)
    public RString shimeiKana1;
    @ReportItem(name = "setainushiKubun1", order = 204)
    public RString setainushiKubun1;
    @ReportItem(name = "seinengappi1", order = 205)
    public RString seinengappi1;
    @ReportItem(name = "tohyojoMei1", order = 206)
    public RString tohyojoMei1;
    @ReportItem(name = "tohyojoJusho1", order = 207)
    public RString tohyojoJusho1;
    @ReportItem(name = "tohyokuMei1", order = 208)
    public RString tohyokuMei1;
    @ReportItem(name = "meiboNo1", order = 209)
    public RString meiboNo1;
    @ReportItem(name = "barcodeNyujokenBarcode1", order = 210)
    public RString barcodeNyujokenBarcode1;
    @ReportItem(name = "shikibetsuCode1", order = 211)
    public RString shikibetsuCode1;
    @ReportItem(name = "gyoseikuCode1", order = 212)
    public RString gyoseikuCode1;
    @ReportItem(name = "gyoseikuMei1", order = 213)
    public RString gyoseikuMei1;
    @ReportItem(name = "chikuCode11", order = 214)
    public RString chikuCode11;
    @ReportItem(name = "chikuName11", order = 215)
    public RString chikuName11;
    @ReportItem(name = "chikuCode21", order = 216)
    public RString chikuCode21;
    @ReportItem(name = "chikuName21", order = 217)
    public RString chikuName21;
    @ReportItem(name = "chikuCode31", order = 218)
    public RString chikuCode31;
    @ReportItem(name = "chikuName31", order = 219)
    public RString chikuName31;
    @ReportItem(name = "jushoCode2", order = 220)
    public RString jushoCode2;
    @ReportItem(name = "jusho2", order = 221)
    public RString jusho2;
    @ReportItem(name = "shimei2", order = 222)
    public RString shimei2;
    @ReportItem(name = "shimeiKana12", order = 223)
    public RString shimeiKana12;
    @ReportItem(name = "shimeiKana22", order = 224)
    public RString shimeiKana22;
    @ReportItem(name = "shimeiKana2", order = 225)
    public RString shimeiKana2;
    @ReportItem(name = "setainushiKubun2", order = 226)
    public RString setainushiKubun2;
    @ReportItem(name = "seinengappi2", order = 227)
    public RString seinengappi2;
    @ReportItem(name = "tohyojoMei2", order = 228)
    public RString tohyojoMei2;
    @ReportItem(name = "tohyojoJusho2", order = 229)
    public RString tohyojoJusho2;
    @ReportItem(name = "tohyokuMei2", order = 230)
    public RString tohyokuMei2;
    @ReportItem(name = "meiboNo2", order = 231)
    public RString meiboNo2;
    @ReportItem(name = "barcodeNyujokenBarcode2", order = 232)
    public RString barcodeNyujokenBarcode2;
    @ReportItem(name = "shikibetsuCode2", order = 233)
    public RString shikibetsuCode2;
    @ReportItem(name = "gyoseikuCode2", order = 234)
    public RString gyoseikuCode2;
    @ReportItem(name = "gyoseikuMei2", order = 235)
    public RString gyoseikuMei2;
    @ReportItem(name = "chikuCode12", order = 236)
    public RString chikuCode12;
    @ReportItem(name = "chikuName12", order = 237)
    public RString chikuName12;
    @ReportItem(name = "chikuCode22", order = 238)
    public RString chikuCode22;
    @ReportItem(name = "chikuName22", order = 239)
    public RString chikuName22;
    @ReportItem(name = "chikuCode32", order = 240)
    public RString chikuCode32;
    @ReportItem(name = "chikuName32", order = 241)
    public RString chikuName32;
    @ReportItem(name = "jushoCode3", order = 242)
    public RString jushoCode3;
    @ReportItem(name = "jusho3", order = 243)
    public RString jusho3;
    @ReportItem(name = "shimei3", order = 244)
    public RString shimei3;
    @ReportItem(name = "shimeiKana13", order = 245)
    public RString shimeiKana13;
    @ReportItem(name = "shimeiKana23", order = 246)
    public RString shimeiKana23;
    @ReportItem(name = "shimeiKana3", order = 247)
    public RString shimeiKana3;
    @ReportItem(name = "setainushiKubun3", order = 248)
    public RString setainushiKubun3;
    @ReportItem(name = "seinengappi3", order = 249)
    public RString seinengappi3;
    @ReportItem(name = "tohyojoMei3", order = 250)
    public RString tohyojoMei3;
    @ReportItem(name = "tohyojoJusho3", order = 251)
    public RString tohyojoJusho3;
    @ReportItem(name = "tohyokuMei3", order = 252)
    public RString tohyokuMei3;
    @ReportItem(name = "meiboNo3", order = 253)
    public RString meiboNo3;
    @ReportItem(name = "barcodeNyujokenBarcode3", order = 254)
    public RString barcodeNyujokenBarcode3;
    @ReportItem(name = "shikibetsuCode3", order = 255)
    public RString shikibetsuCode3;
    @ReportItem(name = "gyoseikuCode3", order = 256)
    public RString gyoseikuCode3;
    @ReportItem(name = "gyoseikuMei3", order = 257)
    public RString gyoseikuMei3;
    @ReportItem(name = "chikuCode13", order = 258)
    public RString chikuCode13;
    @ReportItem(name = "chikuName13", order = 259)
    public RString chikuName13;
    @ReportItem(name = "chikuCode23", order = 260)
    public RString chikuCode23;
    @ReportItem(name = "chikuName23", order = 261)
    public RString chikuName23;
    @ReportItem(name = "chikuCode33", order = 262)
    public RString chikuCode33;
    @ReportItem(name = "chikuName33", order = 263)
    public RString chikuName33;
    @ReportItem(name = "jushoCode4", order = 264)
    public RString jushoCode4;
    @ReportItem(name = "jusho4", order = 265)
    public RString jusho4;
    @ReportItem(name = "shimei4", order = 266)
    public RString shimei4;
    @ReportItem(name = "shimeiKana14", order = 267)
    public RString shimeiKana14;
    @ReportItem(name = "shimeiKana24", order = 268)
    public RString shimeiKana24;
    @ReportItem(name = "shimeiKana4", order = 269)
    public RString shimeiKana4;
    @ReportItem(name = "setainushiKubun4", order = 270)
    public RString setainushiKubun4;
    @ReportItem(name = "seinengappi4", order = 271)
    public RString seinengappi4;
    @ReportItem(name = "tohyojoMei4", order = 272)
    public RString tohyojoMei4;
    @ReportItem(name = "tohyojoJusho4", order = 273)
    public RString tohyojoJusho4;
    @ReportItem(name = "tohyokuMei4", order = 274)
    public RString tohyokuMei4;
    @ReportItem(name = "meiboNo4", order = 275)
    public RString meiboNo4;
    @ReportItem(name = "barcodeNyujokenBarcode4", order = 276)
    public RString barcodeNyujokenBarcode4;
    @ReportItem(name = "shikibetsuCode4", order = 277)
    public RString shikibetsuCode4;
    @ReportItem(name = "gyoseikuCode4", order = 278)
    public RString gyoseikuCode4;
    @ReportItem(name = "gyoseikuMei4", order = 279)
    public RString gyoseikuMei4;
    @ReportItem(name = "chikuCode14", order = 280)
    public RString chikuCode14;
    @ReportItem(name = "chikuName14", order = 281)
    public RString chikuName14;
    @ReportItem(name = "chikuCode24", order = 282)
    public RString chikuCode24;
    @ReportItem(name = "chikuName24", order = 283)
    public RString chikuName24;
    @ReportItem(name = "chikuCode34", order = 284)
    public RString chikuCode34;
    @ReportItem(name = "chikuName34", order = 285)
    public RString chikuName34;
    @ReportItem(name = "yubinNo2", order = 286)
    public RString yubinNo2;
    @ReportItem(name = "sofusakiGyoseikuCode2", order = 287)
    public RString sofusakiGyoseikuCode2;
    @ReportItem(name = "sofusakiJushoCode2", order = 288)
    public RString sofusakiJushoCode2;
    @ReportItem(name = "sofusakiChikuCode2", order = 289)
    public RString sofusakiChikuCode2;
    @ReportItem(name = "sofusakiChikuName2", order = 290)
    public RString sofusakiChikuName2;
    @ReportItem(name = "sofusakiSetaiCode2", order = 291)
    public RString sofusakiSetaiCode2;
    @ReportItem(name = "setainushiMei2", order = 292)
    public RString setainushiMei2;
    @ReportItem(name = "mapJoho2", order = 293)
    public RString mapJoho2;
    @ReportItem(name = "jushoCode5", order = 294)
    public RString jushoCode5;
    @ReportItem(name = "jusho5", order = 295)
    public RString jusho5;
    @ReportItem(name = "shimei5", order = 296)
    public RString shimei5;
    @ReportItem(name = "shimeiKana15", order = 297)
    public RString shimeiKana15;
    @ReportItem(name = "shimeiKana25", order = 298)
    public RString shimeiKana25;
    @ReportItem(name = "shimeiKana5", order = 299)
    public RString shimeiKana5;
    @ReportItem(name = "setainushiKubun5", order = 300)
    public RString setainushiKubun5;
    @ReportItem(name = "seinengappi5", order = 301)
    public RString seinengappi5;
    @ReportItem(name = "tohyojoMei5", order = 302)
    public RString tohyojoMei5;
    @ReportItem(name = "tohyojoJusho5", order = 303)
    public RString tohyojoJusho5;
    @ReportItem(name = "tohyokuMei5", order = 304)
    public RString tohyokuMei5;
    @ReportItem(name = "meiboNo5", order = 305)
    public RString meiboNo5;
    @ReportItem(name = "barcodeNyujokenBarcode5", order = 306)
    public RString barcodeNyujokenBarcode5;
    @ReportItem(name = "shikibetsuCode5", order = 307)
    public RString shikibetsuCode5;
    @ReportItem(name = "gyoseikuCode5", order = 308)
    public RString gyoseikuCode5;
    @ReportItem(name = "gyoseikuMei5", order = 309)
    public RString gyoseikuMei5;
    @ReportItem(name = "chikuCode15", order = 310)
    public RString chikuCode15;
    @ReportItem(name = "chikuName15", order = 311)
    public RString chikuName15;
    @ReportItem(name = "chikuCode25", order = 312)
    public RString chikuCode25;
    @ReportItem(name = "chikuName25", order = 313)
    public RString chikuName25;
    @ReportItem(name = "chikuCode35", order = 314)
    public RString chikuCode35;
    @ReportItem(name = "chikuName35", order = 315)
    public RString chikuName35;
    @ReportItem(name = "jushoCode6", order = 316)
    public RString jushoCode6;
    @ReportItem(name = "jusho6", order = 317)
    public RString jusho6;
    @ReportItem(name = "shimei6", order = 318)
    public RString shimei6;
    @ReportItem(name = "shimeiKana16", order = 319)
    public RString shimeiKana16;
    @ReportItem(name = "shimeiKana26", order = 320)
    public RString shimeiKana26;
    @ReportItem(name = "shimeiKana6", order = 321)
    public RString shimeiKana6;
    @ReportItem(name = "setainushiKubun6", order = 322)
    public RString setainushiKubun6;
    @ReportItem(name = "seinengappi6", order = 323)
    public RString seinengappi6;
    @ReportItem(name = "tohyojoMei6", order = 324)
    public RString tohyojoMei6;
    @ReportItem(name = "tohyojoJusho6", order = 325)
    public RString tohyojoJusho6;
    @ReportItem(name = "tohyokuMei6", order = 326)
    public RString tohyokuMei6;
    @ReportItem(name = "meiboNo6", order = 327)
    public RString meiboNo6;
    @ReportItem(name = "barcodeNyujokenBarcode6", order = 328)
    public RString barcodeNyujokenBarcode6;
    @ReportItem(name = "shikibetsuCode6", order = 329)
    public RString shikibetsuCode6;
    @ReportItem(name = "gyoseikuCode6", order = 330)
    public RString gyoseikuCode6;
    @ReportItem(name = "gyoseikuMei6", order = 331)
    public RString gyoseikuMei6;
    @ReportItem(name = "chikuCode16", order = 332)
    public RString chikuCode16;
    @ReportItem(name = "chikuName16", order = 333)
    public RString chikuName16;
    @ReportItem(name = "chikuCode26", order = 334)
    public RString chikuCode26;
    @ReportItem(name = "chikuName26", order = 335)
    public RString chikuName26;
    @ReportItem(name = "chikuCode36", order = 336)
    public RString chikuCode36;
    @ReportItem(name = "chikuName36", order = 337)
    public RString chikuName36;
    @ReportItem(name = "jushoCode7", order = 338)
    public RString jushoCode7;
    @ReportItem(name = "jusho7", order = 339)
    public RString jusho7;
    @ReportItem(name = "shimei7", order = 340)
    public RString shimei7;
    @ReportItem(name = "shimeiKana17", order = 341)
    public RString shimeiKana17;
    @ReportItem(name = "shimeiKana27", order = 342)
    public RString shimeiKana27;
    @ReportItem(name = "shimeiKana7", order = 343)
    public RString shimeiKana7;
    @ReportItem(name = "setainushiKubun7", order = 344)
    public RString setainushiKubun7;
    @ReportItem(name = "seinengappi7", order = 345)
    public RString seinengappi7;
    @ReportItem(name = "tohyojoMei7", order = 346)
    public RString tohyojoMei7;
    @ReportItem(name = "tohyojoJusho7", order = 347)
    public RString tohyojoJusho7;
    @ReportItem(name = "tohyokuMei7", order = 348)
    public RString tohyokuMei7;
    @ReportItem(name = "meiboNo7", order = 349)
    public RString meiboNo7;
    @ReportItem(name = "barcodeNyujokenBarcode7", order = 350)
    public RString barcodeNyujokenBarcode7;
    @ReportItem(name = "shikibetsuCode7", order = 351)
    public RString shikibetsuCode7;
    @ReportItem(name = "gyoseikuCode7", order = 352)
    public RString gyoseikuCode7;
    @ReportItem(name = "gyoseikuMei7", order = 353)
    public RString gyoseikuMei7;
    @ReportItem(name = "chikuCode17", order = 354)
    public RString chikuCode17;
    @ReportItem(name = "chikuName17", order = 355)
    public RString chikuName17;
    @ReportItem(name = "chikuCode27", order = 356)
    public RString chikuCode27;
    @ReportItem(name = "chikuName27", order = 357)
    public RString chikuName27;
    @ReportItem(name = "chikuCode37", order = 358)
    public RString chikuCode37;
    @ReportItem(name = "chikuName37", order = 359)
    public RString chikuName37;
    @ReportItem(name = "jushoCode8", order = 360)
    public RString jushoCode8;
    @ReportItem(name = "jusho8", order = 361)
    public RString jusho8;
    @ReportItem(name = "shimei8", order = 362)
    public RString shimei8;
    @ReportItem(name = "shimeiKana18", order = 363)
    public RString shimeiKana18;
    @ReportItem(name = "shimeiKana28", order = 364)
    public RString shimeiKana28;
    @ReportItem(name = "shimeiKana8", order = 365)
    public RString shimeiKana8;
    @ReportItem(name = "setainushiKubun8", order = 366)
    public RString setainushiKubun8;
    @ReportItem(name = "seinengappi8", order = 367)
    public RString seinengappi8;
    @ReportItem(name = "tohyojoMei8", order = 368)
    public RString tohyojoMei8;
    @ReportItem(name = "tohyojoJusho8", order = 369)
    public RString tohyojoJusho8;
    @ReportItem(name = "tohyokuMei8", order = 370)
    public RString tohyokuMei8;
    @ReportItem(name = "meiboNo8", order = 371)
    public RString meiboNo8;
    @ReportItem(name = "barcodeNyujokenBarcode8", order = 372)
    public RString barcodeNyujokenBarcode8;
    @ReportItem(name = "shikibetsuCode8", order = 373)
    public RString shikibetsuCode8;
    @ReportItem(name = "gyoseikuCode8", order = 374)
    public RString gyoseikuCode8;
    @ReportItem(name = "gyoseikuMei8", order = 375)
    public RString gyoseikuMei8;
    @ReportItem(name = "chikuCode18", order = 376)
    public RString chikuCode18;
    @ReportItem(name = "chikuName18", order = 377)
    public RString chikuName18;
    @ReportItem(name = "chikuCode28", order = 378)
    public RString chikuCode28;
    @ReportItem(name = "chikuName28", order = 379)
    public RString chikuName28;
    @ReportItem(name = "chikuCode38", order = 380)
    public RString chikuCode38;
    @ReportItem(name = "chikuName38", order = 381)
    public RString chikuName38;
    @ReportItem(name = "shimei_1", length = 46, order = 382)
    public RString shimei_1;
    @ReportItem(name = "sofusakiJusho_1", length = 105, order = 382)
    public RString sofusakiJusho_1;
    @ReportItem(name = "atena_1", length = 42, order = 383)
    public RString atena_1;
    @ReportItem(name = "jusho_1", length = 25, order = 384)
    public RString jusho_1;
    @ReportItem(name = "tohyojoMei_1", length = 40, order = 385)
    public RString tohyojoMei_1;
    @ReportItem(name = "shikibetsuCode", order = 286)
    public RString shikibetsuCode;
    @ReportItem(name = "shimei_2", length = 46, order = 387)
    public RString shimei_2;
    @ReportItem(name = "shimei_3", length = 46, order = 388)
    public RString shimei_3;
    @ReportItem(name = "shimei_4", length = 46, order = 389)
    public RString shimei_4;
    @ReportItem(name = "shimei_5", length = 46, order = 390)
    public RString shimei_5;
    @ReportItem(name = "shimei_6", length = 46, order = 391)
    public RString shimei_6;
    @ReportItem(name = "shimei_7", length = 46, order = 392)
    public RString shimei_7;
    @ReportItem(name = "shimei_8", length = 46, order = 393)
    public RString shimei_8;
    @ReportItem(name = "sofusakiJusho_2", length = 105, order = 394)
    public RString sofusakiJusho_2;
    @ReportItem(name = "atena_2", length = 42, order = 395)
    public RString atena_2;
    @ReportItem(name = "jusho_2", length = 25, order = 396)
    public RString jusho_2;
    @ReportItem(name = "jusho_3", length = 25, order = 397)
    public RString jusho_3;
    @ReportItem(name = "jusho_4", length = 25, order = 398)
    public RString jusho_4;
    @ReportItem(name = "jusho_5", length = 25, order = 399)
    public RString jusho_5;
    @ReportItem(name = "jusho_6", length = 25, order = 400)
    public RString jusho_6;
    @ReportItem(name = "jusho_7", length = 25, order = 401)
    public RString jusho_7;
    @ReportItem(name = "jusho_8", length = 25, order = 402)
    public RString jusho_8;
    @ReportItem(name = "tohyojoMei_2", length = 40, order = 403)
    public RString tohyojoMei_2;
    @ReportItem(name = "tohyojoMei_3", length = 40, order = 404)
    public RString tohyojoMei_3;
    @ReportItem(name = "tohyojoMei_4", length = 40, order = 405)
    public RString tohyojoMei_4;
    @ReportItem(name = "tohyojoMei_5", length = 40, order = 406)
    public RString tohyojoMei_5;
    @ReportItem(name = "tohyojoMei_6", length = 40, order = 407)
    public RString tohyojoMei_6;
    @ReportItem(name = "tohyojoMei_7", length = 40, order = 408)
    public RString tohyojoMei_7;
    @ReportItem(name = "tohyojoMei_8", length = 40, order = 409)
    public RString tohyojoMei_8;
    @ReportItem(name = "tohyoTimeStart1_nn", order = 410)
    public RString tohyoTimeStart1_nn;
    @ReportItem(name = "tohyoTimeEnd1_nn", order = 411)
    public RString tohyoTimeEnd1_nn;
    @ReportItem(name = "tohyoTimeStart2_nn", order = 412)
    public RString tohyoTimeStart2_nn;
    @ReportItem(name = "tohyoTimeEnd2_nn", order = 413)
    public RString tohyoTimeEnd2_nn;
    @ReportItem(name = "tohyoTimeStart3_nn", order = 414)
    public RString tohyoTimeStart3_nn;
    @ReportItem(name = "tohyoTimeEnd3_nn", order = 415)
    public RString tohyoTimeEnd3_nn;
    @ReportItem(name = "tohyoTimeStart4_nn", order = 416)
    public RString tohyoTimeStart4_nn;
    @ReportItem(name = "tohyoTimeEnd4_nn", order = 417)
    public RString tohyoTimeEnd4_nn;
    @ReportItem(name = "tohyoTimeStart5_nn", order = 418)
    public RString tohyoTimeStart5_nn;
    @ReportItem(name = "tohyoTimeEnd5_nn", order = 419)
    public RString tohyoTimeEnd5_nn;
    @ReportItem(name = "tohyoTimeStart6_nn", order = 420)
    public RString tohyoTimeStart6_nn;
    @ReportItem(name = "tohyoTimeEnd6_nn", order = 421)
    public RString tohyoTimeEnd6_nn;
    @ReportItem(name = "tohyoTimeStart7_nn", order = 422)
    public RString tohyoTimeStart7_nn;
    @ReportItem(name = "tohyoTimeEnd7_nn", order = 423)
    public RString tohyoTimeEnd7_nn;
    @ReportItem(name = "tohyoTimeStart8_nn", order = 424)
    public RString tohyoTimeStart8_nn;
    @ReportItem(name = "tohyoTimeEnd8_nn", order = 425)
    public RString tohyoTimeEnd8_nn;
    @ReportItem(name = "shikibetsuCode_Sealer_1", order = 426)
    public RString shikibetsuCode_Sealer_1;
    @ReportItem(name = "shikibetsuCode_Sealer_2", order = 427)
    public RString shikibetsuCode_Sealer_2;
    @ReportItem(name = "shikibetsuCode_Sealer_3", order = 428)
    public RString shikibetsuCode_Sealer_3;
    @ReportItem(name = "shikibetsuCode_Sealer_4", order = 429)
    public RString shikibetsuCode_Sealer_4;
    @ReportItem(name = "shikibetsuCode_Sealer_5", order = 430)
    public RString shikibetsuCode_Sealer_5;
    @ReportItem(name = "shikibetsuCode_Sealer_6", order = 431)
    public RString shikibetsuCode_Sealer_6;
    @ReportItem(name = "shikibetsuCode_Sealer_7", order = 432)
    public RString shikibetsuCode_Sealer_7;
    @ReportItem(name = "shikibetsuCode_Sealer_8", order = 433)
    public RString shikibetsuCode_Sealer_8;

    /**
     * 投票所入場券（シーラー）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        tohyoTimeStart1,
        tohyoTimeEnd1,
        yubinNo11,
        yubinNo21,
        jusho11,
        setaiCode1,
        jusho21,
        shimei21,
        shimei11,
        seibetsu1,
        shimei31,
        sofusakiGyoseikuMei11,
        sofusakiGyoseikuMei21,
        tohyojoMei21,
        tohyojoMei11,
        sofusakiGyoseikuMei31,
        tohyokuCode1,
        meiboPage1,
        meiboGyo1,
        tohyojoMei31,
        sofusakiJusho11,
        sofusakiJusho21,
        sofusakiJusho31,
        tohyoTimeStart2,
        tohyoTimeEnd2,
        sofusakiJusho41,
        jusho12,
        setaiCode2,
        jusho22,
        sofusakiJusho51,
        shimei22,
        atena11,
        shimei12,
        seibetsu2,
        shimei32,
        atena21,
        tohyojoMei22,
        tohyojoMei12,
        tohyokuCode2,
        meiboPage2,
        meiboGyo2,
        tohyojoMei32,
        atena31,
        barcodeCustombarcode1,
        sofusakiMeiboNo1,
        seiriNo1,
        tohyoTimeStart3,
        tohyoTimeEnd3,
        jusho13,
        setaiCode3,
        jusho23,
        shimei23,
        shimei13,
        seibetsu3,
        shimei33,
        tohyojoMei23,
        tohyojoMei13,
        tohyokuCode3,
        meiboPage3,
        meiboGyo3,
        tohyojoMei33,
        tohyoTimeStart4,
        tohyoTimeEnd4,
        jusho14,
        jusho24,
        setaiCode4,
        shimei24,
        shimei14,
        seibetsu4,
        shimei34,
        tohyojoMei24,
        tohyojoMei14,
        tohyokuCode4,
        meiboPage4,
        meiboGyo4,
        tohyojoMei34,
        tohyoTimeStart5,
        tohyoTimeEnd5,
        yubinNo12,
        yubinNo22,
        jusho15,
        setaiCode5,
        jusho25,
        shimei25,
        shimei15,
        seibetsu5,
        shimei35,
        sofusakiGyoseikuMei12,
        sofusakiGyoseikuMei22,
        tohyojoMei25,
        tohyojoMei15,
        sofusakiGyoseikuMei32,
        tohyokuCode5,
        meiboPage5,
        meiboGyo5,
        tohyojoMei35,
        sofusakiJusho12,
        sofusakiJusho22,
        sofusakiJusho32,
        tohyoTimeStart6,
        tohyoTimeEnd6,
        sofusakiJusho42,
        jusho16,
        setaiCode6,
        jusho26,
        sofusakiJusho52,
        shimei26,
        atena12,
        shimei16,
        seibetsu6,
        shimei36,
        atena22,
        tohyojoMei26,
        tohyojoMei16,
        tohyokuCode6,
        meiboPage6,
        meiboGyo6,
        tohyojoMei36,
        atena32,
        barcodeCustombarcode2,
        sofusakiMeiboNo2,
        seiriNo2,
        tohyoTimeStart7,
        tohyoTimeEnd7,
        jusho17,
        setaiCode7,
        jusho27,
        shimei27,
        shimei17,
        seibetsu7,
        shimei37,
        tohyojoMei27,
        tohyojoMei17,
        tohyokuCode7,
        meiboPage7,
        meiboGyo7,
        tohyojoMei37,
        tohyoTimeStart8,
        tohyoTimeEnd8,
        jusho18,
        setaiCode8,
        jusho28,
        shimei28,
        shimei18,
        seibetsu8,
        shimei38,
        tohyojoMei28,
        tohyojoMei18,
        tohyokuCode8,
        meiboPage8,
        meiboGyo8,
        tohyojoMei38;
    }
// </editor-fold>
}
