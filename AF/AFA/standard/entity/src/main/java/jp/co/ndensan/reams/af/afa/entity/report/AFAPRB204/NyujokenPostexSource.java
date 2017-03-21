package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204;

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
 * 投票所入場券（ポステックス）のReportSourceです。
 *
 * @reamsid_L AF-0160-034 liuj2
 */
public class NyujokenPostexSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tohyoTimeEnd1_hh", length = 2, order = 1)
    public RString tohyoTimeEnd1_hh;
    @ReportItem(name = "tohyoTimeStart4_hh", length = 2, order = 2)
    public RString tohyoTimeStart4_hh;
    @ReportItem(name = "tohyoTimeEnd4_hh", length = 2, order = 3)
    public RString tohyoTimeEnd4_hh;
    @ReportItem(name = "tohyoTimeStart1_hh", length = 2, order = 4)
    public RString tohyoTimeStart1_hh;
    @ReportItem(name = "yubinNo11", length = 3, order = 5)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo21", length = 4, order = 6)
    public RString yubinNo21;
    @ReportItem(name = "jusho11", length = 11, order = 7)
    public RString jusho11;
    @ReportItem(name = "jusho14", length = 11, order = 8)
    public RString jusho14;
    @ReportItem(name = "setaiCode1", length = 15, order = 9)
    public RString setaiCode1;
    @ReportItem(name = "setaiCode4", length = 15, order = 10)
    public RString setaiCode4;
    @ReportItem(name = "jusho21", length = 14, order = 11)
    public RString jusho21;
    @ReportItem(name = "jusho24", length = 14, order = 12)
    public RString jusho24;
    @ReportItem(name = "shimei21", length = 17, order = 13)
    public RString shimei21;
    @ReportItem(name = "shimei24", length = 17, order = 14)
    public RString shimei24;
    @ReportItem(name = "shimei11", length = 12, order = 15)
    public RString shimei11;
    @ReportItem(name = "seibetsu1", length = 1, order = 16)
    public RString seibetsu1;
    @ReportItem(name = "shimei14", length = 12, order = 17)
    public RString shimei14;
    @ReportItem(name = "seibetsu4", length = 1, order = 18)
    public RString seibetsu4;
    @ReportItem(name = "shimei31", length = 17, order = 19)
    public RString shimei31;
    @ReportItem(name = "shimei34", length = 17, order = 20)
    public RString shimei34;
    @ReportItem(name = "sofusakiGyoseikuMei1", length = 20, order = 21)
    public RString sofusakiGyoseikuMei1;
    @ReportItem(name = "sofusakiGyoseikuMei2", length = 16, order = 22)
    public RString sofusakiGyoseikuMei2;
    @ReportItem(name = "tohyojoMei21", length = 15, order = 23)
    public RString tohyojoMei21;
    @ReportItem(name = "tohyojoMei24", length = 15, order = 24)
    public RString tohyojoMei24;
    @ReportItem(name = "tohyojoMei14", length = 10, order = 25)
    public RString tohyojoMei14;
    @ReportItem(name = "tohyojoMei11", length = 10, order = 26)
    public RString tohyojoMei11;
    @ReportItem(name = "tohyokuCode1", length = 4, order = 27)
    public RString tohyokuCode1;
    @ReportItem(name = "meiboPage1", length = 6, order = 28)
    public RString meiboPage1;
    @ReportItem(name = "meiboGyo1", length = 2, order = 29)
    public RString meiboGyo1;
    @ReportItem(name = "tohyokuCode4", length = 4, order = 30)
    public RString tohyokuCode4;
    @ReportItem(name = "meiboPage4", length = 6, order = 31)
    public RString meiboPage4;
    @ReportItem(name = "meiboGyo4", length = 2, order = 32)
    public RString meiboGyo4;
    @ReportItem(name = "sofusakiGyoseikuMei3", length = 16, order = 33)
    public RString sofusakiGyoseikuMei3;
    @ReportItem(name = "tohyojoMei31", length = 15, order = 34)
    public RString tohyojoMei31;
    @ReportItem(name = "tohyojoMei34", length = 15, order = 35)
    public RString tohyojoMei34;
    @ReportItem(name = "barcodeNyujokenBarcode1", order = 36)
    public RString barcodeNyujokenBarcode1;
    @ReportItem(name = "barcodeNyujokenBarcode4", order = 37)
    public RString barcodeNyujokenBarcode4;
    @ReportItem(name = "sofusakiJusho1", length = 21, order = 38)
    public RString sofusakiJusho1;
    @ReportItem(name = "sofusakiJusho2", length = 21, order = 39)
    public RString sofusakiJusho2;
    @ReportItem(name = "shikibetsuCode1", length = 15, order = 40)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode4", length = 15, order = 41)
    public RString shikibetsuCode4;
    @ReportItem(name = "sofusakiJusho3", length = 21, order = 42)
    public RString sofusakiJusho3;
    @ReportItem(name = "sofusakiJusho4", length = 21, order = 43)
    public RString sofusakiJusho4;
    @ReportItem(name = "sofusakiJusho5", length = 21, order = 44)
    public RString sofusakiJusho5;
    @ReportItem(name = "atena11", length = 14, order = 45)
    public RString atena11;
    @ReportItem(name = "tohyoTimeStart2_hh", length = 2, order = 46)
    public RString tohyoTimeStart2_hh;
    @ReportItem(name = "tohyoTimeEnd2_hh", length = 2, order = 47)
    public RString tohyoTimeEnd2_hh;
    @ReportItem(name = "tohyoTimeStart5_hh", length = 2, order = 48)
    public RString tohyoTimeStart5_hh;
    @ReportItem(name = "tohyoTimeEnd5_hh", length = 2, order = 49)
    public RString tohyoTimeEnd5_hh;
    @ReportItem(name = "atena21", length = 14, order = 50)
    public RString atena21;
    @ReportItem(name = "jusho12", length = 11, order = 51)
    public RString jusho12;
    @ReportItem(name = "setaiCode2", length = 15, order = 52)
    public RString setaiCode2;
    @ReportItem(name = "jusho15", length = 11, order = 53)
    public RString jusho15;
    @ReportItem(name = "setaiCode5", length = 15, order = 54)
    public RString setaiCode5;
    @ReportItem(name = "jusho25", length = 14, order = 55)
    public RString jusho25;
    @ReportItem(name = "jusho22", length = 14, order = 56)
    public RString jusho22;
    @ReportItem(name = "atena31", length = 14, order = 57)
    public RString atena31;
    @ReportItem(name = "shimei22", length = 17, order = 58)
    public RString shimei22;
    @ReportItem(name = "shimei25", length = 17, order = 59)
    public RString shimei25;
    @ReportItem(name = "shimei12", length = 12, order = 60)
    public RString shimei12;
    @ReportItem(name = "seibetsu2", length = 1, order = 61)
    public RString seibetsu2;
    @ReportItem(name = "shimei15", length = 12, order = 62)
    public RString shimei15;
    @ReportItem(name = "seibetsu5", length = 1, order = 63)
    public RString seibetsu5;
    @ReportItem(name = "shimei32", length = 17, order = 64)
    public RString shimei32;
    @ReportItem(name = "shimei35", length = 17, order = 65)
    public RString shimei35;
    @ReportItem(name = "barcodeCustombarcode1", order = 66)
    public RString barcodeCustombarcode1;
    @ReportItem(name = "tohyojoMei22", length = 15, order = 67)
    public RString tohyojoMei22;
    @ReportItem(name = "tohyojoMei25", length = 15, order = 68)
    public RString tohyojoMei25;
    @ReportItem(name = "tohyojoMei12", length = 10, order = 69)
    public RString tohyojoMei12;
    @ReportItem(name = "tohyojoMei15", length = 10, order = 70)
    public RString tohyojoMei15;
    @ReportItem(name = "tohyokuCode2", length = 4, order = 71)
    public RString tohyokuCode2;
    @ReportItem(name = "meiboPage2", length = 6, order = 72)
    public RString meiboPage2;
    @ReportItem(name = "meiboGyo2", length = 2, order = 73)
    public RString meiboGyo2;
    @ReportItem(name = "tohyokuCode5", length = 4, order = 74)
    public RString tohyokuCode5;
    @ReportItem(name = "meiboPage5", length = 6, order = 75)
    public RString meiboPage5;
    @ReportItem(name = "meiboGyo5", length = 2, order = 76)
    public RString meiboGyo5;
    @ReportItem(name = "tohyojoMei32", length = 15, order = 77)
    public RString tohyojoMei32;
    @ReportItem(name = "tohyojoMei35", length = 15, order = 78)
    public RString tohyojoMei35;
    @ReportItem(name = "sofusakiMeiboNo1", length = 14, order = 79)
    public RString sofusakiMeiboNo1;
    @ReportItem(name = "seiriNo1", length = 7, order = 80)
    public RString seiriNo1;
    @ReportItem(name = "barcodeNyujokenBarcode2", order = 81)
    public RString barcodeNyujokenBarcode2;
    @ReportItem(name = "barcodeNyujokenBarcode5", order = 82)
    public RString barcodeNyujokenBarcode5;
    @ReportItem(name = "shikibetsuCode2", length = 15, order = 83)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode5", length = 15, order = 84)
    public RString shikibetsuCode5;
    @ReportItem(name = "tohyoTimeStart3_hh", length = 2, order = 85)
    public RString tohyoTimeStart3_hh;
    @ReportItem(name = "tohyoTimeEnd3_hh", length = 2, order = 86)
    public RString tohyoTimeEnd3_hh;
    @ReportItem(name = "tohyoTimeStart6_hh", length = 2, order = 87)
    public RString tohyoTimeStart6_hh;
    @ReportItem(name = "tohyoTimeEnd6_hh", length = 2, order = 88)
    public RString tohyoTimeEnd6_hh;
    @ReportItem(name = "jusho13", length = 11, order = 89)
    public RString jusho13;
    @ReportItem(name = "jusho16", length = 11, order = 90)
    public RString jusho16;
    @ReportItem(name = "setaiCode3", length = 15, order = 91)
    public RString setaiCode3;
    @ReportItem(name = "setaiCode6", length = 15, order = 92)
    public RString setaiCode6;
    @ReportItem(name = "jusho23", length = 14, order = 93)
    public RString jusho23;
    @ReportItem(name = "jusho26", length = 14, order = 94)
    public RString jusho26;
    @ReportItem(name = "shimei23", length = 17, order = 95)
    public RString shimei23;
    @ReportItem(name = "shimei26", length = 17, order = 96)
    public RString shimei26;
    @ReportItem(name = "shimei13", length = 12, order = 97)
    public RString shimei13;
    @ReportItem(name = "seibetsu3", length = 1, order = 98)
    public RString seibetsu3;
    @ReportItem(name = "shimei16", length = 12, order = 99)
    public RString shimei16;
    @ReportItem(name = "seibetsu6", length = 1, order = 100)
    public RString seibetsu6;
    @ReportItem(name = "shimei33", length = 17, order = 101)
    public RString shimei33;
    @ReportItem(name = "shimei36", length = 17, order = 102)
    public RString shimei36;
    @ReportItem(name = "tohyojoMei23", length = 15, order = 103)
    public RString tohyojoMei23;
    @ReportItem(name = "tohyojoMei26", length = 15, order = 104)
    public RString tohyojoMei26;
    @ReportItem(name = "tohyojoMei13", length = 10, order = 105)
    public RString tohyojoMei13;
    @ReportItem(name = "tohyojoMei16", length = 10, order = 106)
    public RString tohyojoMei16;
    @ReportItem(name = "tohyokuCode3", length = 4, order = 107)
    public RString tohyokuCode3;
    @ReportItem(name = "meiboPage3", length = 6, order = 108)
    public RString meiboPage3;
    @ReportItem(name = "meiboGyo3", length = 2, order = 109)
    public RString meiboGyo3;
    @ReportItem(name = "tohyokuCode6", length = 4, order = 110)
    public RString tohyokuCode6;
    @ReportItem(name = "meiboPage6", length = 6, order = 111)
    public RString meiboPage6;
    @ReportItem(name = "meiboGyo6", length = 2, order = 112)
    public RString meiboGyo6;
    @ReportItem(name = "tohyojoMei33", length = 15, order = 113)
    public RString tohyojoMei33;
    @ReportItem(name = "tohyojoMei36", length = 15, order = 114)
    public RString tohyojoMei36;
    @ReportItem(name = "barcodeNyujokenBarcode3", order = 115)
    public RString barcodeNyujokenBarcode3;
    @ReportItem(name = "barcodeNyujokenBarcode6", order = 116)
    public RString barcodeNyujokenBarcode6;
    @ReportItem(name = "shikibetsuCode3", length = 15, order = 117)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode6", length = 15, order = 118)
    public RString shikibetsuCode6;
    @ReportItem(name = "txtSample", length = 10, order = 119)
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
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "nyujokenName1", order = 120)
    public RString nyujokenName1;
    @ReportItem(name = "nyujokenName2", order = 121)
    public RString nyujokenName2;
    @ReportItem(name = "nyujokenName3", order = 122)
    public RString nyujokenName3;
    @ReportItem(name = "shohonNo", order = 123)
    public RString shohonNo;
    @ReportItem(name = "shohonName", order = 124)
    public RString shohonName;
    @ReportItem(name = "senkyoMei1", order = 125)
    public RString senkyoMei1;
    @ReportItem(name = "senkyoMei2", order = 126)
    public RString senkyoMei2;
    @ReportItem(name = "senkyoMei3", order = 127)
    public RString senkyoMei3;
    @ReportItem(name = "senkyoMei4", order = 128)
    public RString senkyoMei4;
    @ReportItem(name = "senkyoMei5", order = 129)
    public RString senkyoMei5;
    @ReportItem(name = "senkyoMei6", order = 130)
    public RString senkyoMei6;
    @ReportItem(name = "senkyoMei7", order = 131)
    public RString senkyoMei7;
    @ReportItem(name = "senkyoMei8", order = 132)
    public RString senkyoMei8;
    @ReportItem(name = "senkyoMei9", order = 133)
    public RString senkyoMei9;
    @ReportItem(name = "senkyoRyakusho1", order = 134)
    public RString senkyoRyakusho1;
    @ReportItem(name = "senkyoRyakusho2", order = 135)
    public RString senkyoRyakusho2;
    @ReportItem(name = "senkyoRyakusho3", order = 136)
    public RString senkyoRyakusho3;
    @ReportItem(name = "senkyoRyakusho4", order = 137)
    public RString senkyoRyakusho4;
    @ReportItem(name = "senkyoRyakusho5", order = 138)
    public RString senkyoRyakusho5;
    @ReportItem(name = "senkyoRyakusho6", order = 139)
    public RString senkyoRyakusho6;
    @ReportItem(name = "senkyoRyakusho7", order = 140)
    public RString senkyoRyakusho7;
    @ReportItem(name = "senkyoRyakusho8", order = 141)
    public RString senkyoRyakusho8;
    @ReportItem(name = "senkyoRyakusho9", order = 142)
    public RString senkyoRyakusho9;
    @ReportItem(name = "tohyoYMD", order = 143)
    public RString tohyoYMD;
    @ReportItem(name = "tohyoYMD_gengou", order = 144)
    public RString tohyoYMD_gengou;
    @ReportItem(name = "tohyoYMD_yyyy", order = 145)
    public RString tohyoYMD_yyyy;
    @ReportItem(name = "tohyoYMD_mm", order = 146)
    public RString tohyoYMD_mm;
    @ReportItem(name = "tohyoYMD_dd", order = 147)
    public RString tohyoYMD_dd;
    @ReportItem(name = "tohyoYMD_youbi", order = 148)
    public RString tohyoYMD_youbi;
    @ReportItem(name = "kokujiYMD", order = 149)
    public RString kokujiYMD;
    @ReportItem(name = "kokujiYMD_gengou", order = 150)
    public RString kokujiYMD_gengou;
    @ReportItem(name = "kokujiYMD_yyyy", order = 151)
    public RString kokujiYMD_yyyy;
    @ReportItem(name = "kokujiYMD_mm", order = 152)
    public RString kokujiYMD_mm;
    @ReportItem(name = "kokujiYMD_dd", order = 153)
    public RString kokujiYMD_dd;
    @ReportItem(name = "kokujiYMD_youbi", order = 154)
    public RString kokujiYMD_youbi;
    @ReportItem(name = "shichosonName", order = 155)
    public RString shichosonName;
    @ReportItem(name = "yubinNo1", order = 156)
    public RString yubinNo1;
    @ReportItem(name = "sofusakiGyoseikuCode1", order = 157)
    public RString sofusakiGyoseikuCode1;
    @ReportItem(name = "sofusakiJushoCode1", order = 158)
    public RString sofusakiJushoCode1;
    @ReportItem(name = "sofusakiChikuCode1", order = 159)
    public RString sofusakiChikuCode1;
    @ReportItem(name = "sofusakiChikuName1", order = 160)
    public RString sofusakiChikuName1;
    @ReportItem(name = "sofusakiSetaiCode1", order = 161)
    public RString sofusakiSetaiCode1;
    @ReportItem(name = "setainushiMei1", order = 162)
    public RString setainushiMei1;
    @ReportItem(name = "mapJoho1", order = 163)
    public RString mapJoho1;
    @ReportItem(name = "jushoCode1", order = 164)
    public RString jushoCode1;
    @ReportItem(name = "jusho1", order = 165)
    public RString jusho1;
    @ReportItem(name = "shimei1", order = 166)
    public RString shimei1;
    @ReportItem(name = "shimeiKana11", order = 167)
    public RString shimeiKana11;
    @ReportItem(name = "shimeiKana21", order = 168)
    public RString shimeiKana21;
    @ReportItem(name = "shimeiKana1", order = 169)
    public RString shimeiKana1;
    @ReportItem(name = "setainushiKubun1", order = 170)
    public RString setainushiKubun1;
    @ReportItem(name = "seinengappi1", order = 171)
    public RString seinengappi1;
    @ReportItem(name = "tohyojoMei1", order = 172)
    public RString tohyojoMei1;
    @ReportItem(name = "tohyojoJusho1", order = 173)
    public RString tohyojoJusho1;
    @ReportItem(name = "tohyokuMei1", order = 174)
    public RString tohyokuMei1;
    @ReportItem(name = "meiboNo1", order = 175)
    public RString meiboNo1;
    @ReportItem(name = "gyoseikuCode1", order = 176)
    public RString gyoseikuCode1;
    @ReportItem(name = "gyoseikuMei1", order = 177)
    public RString gyoseikuMei1;
    @ReportItem(name = "chikuCode11", order = 178)
    public RString chikuCode11;
    @ReportItem(name = "chikuName11", order = 179)
    public RString chikuName11;
    @ReportItem(name = "chikuCode21", order = 180)
    public RString chikuCode21;
    @ReportItem(name = "chikuName21", order = 181)
    public RString chikuName21;
    @ReportItem(name = "chikuCode31", order = 182)
    public RString chikuCode31;
    @ReportItem(name = "chikuName31", order = 183)
    public RString chikuName31;
    @ReportItem(name = "jushoCode2", order = 184)
    public RString jushoCode2;
    @ReportItem(name = "jusho2", order = 185)
    public RString jusho2;
    @ReportItem(name = "shimei2", order = 186)
    public RString shimei2;
    @ReportItem(name = "shimeiKana12", order = 187)
    public RString shimeiKana12;
    @ReportItem(name = "shimeiKana22", order = 188)
    public RString shimeiKana22;
    @ReportItem(name = "shimeiKana2", order = 189)
    public RString shimeiKana2;
    @ReportItem(name = "setainushiKubun2", order = 190)
    public RString setainushiKubun2;
    @ReportItem(name = "seinengappi2", order = 191)
    public RString seinengappi2;
    @ReportItem(name = "tohyojoMei2", order = 192)
    public RString tohyojoMei2;
    @ReportItem(name = "tohyojoJusho2", order = 193)
    public RString tohyojoJusho2;
    @ReportItem(name = "tohyokuMei2", order = 194)
    public RString tohyokuMei2;
    @ReportItem(name = "meiboNo2", order = 195)
    public RString meiboNo2;
    @ReportItem(name = "gyoseikuCode2", order = 196)
    public RString gyoseikuCode2;
    @ReportItem(name = "gyoseikuMei2", order = 197)
    public RString gyoseikuMei2;
    @ReportItem(name = "chikuCode12", order = 198)
    public RString chikuCode12;
    @ReportItem(name = "chikuName12", order = 199)
    public RString chikuName12;
    @ReportItem(name = "chikuCode22", order = 200)
    public RString chikuCode22;
    @ReportItem(name = "chikuName22", order = 201)
    public RString chikuName22;
    @ReportItem(name = "chikuCode32", order = 202)
    public RString chikuCode32;
    @ReportItem(name = "chikuName32", order = 203)
    public RString chikuName32;
    @ReportItem(name = "jushoCode3", order = 204)
    public RString jushoCode3;
    @ReportItem(name = "jusho3", order = 205)
    public RString jusho3;
    @ReportItem(name = "shimei3", order = 206)
    public RString shimei3;
    @ReportItem(name = "shimeiKana13", order = 207)
    public RString shimeiKana13;
    @ReportItem(name = "shimeiKana23", order = 208)
    public RString shimeiKana23;
    @ReportItem(name = "shimeiKana3", order = 209)
    public RString shimeiKana3;
    @ReportItem(name = "setainushiKubun3", order = 210)
    public RString setainushiKubun3;
    @ReportItem(name = "seinengappi3", order = 211)
    public RString seinengappi3;
    @ReportItem(name = "tohyojoMei3", order = 212)
    public RString tohyojoMei3;
    @ReportItem(name = "tohyojoJusho3", order = 213)
    public RString tohyojoJusho3;
    @ReportItem(name = "tohyokuMei3", order = 214)
    public RString tohyokuMei3;
    @ReportItem(name = "meiboNo3", order = 215)
    public RString meiboNo3;
    @ReportItem(name = "gyoseikuCode3", order = 216)
    public RString gyoseikuCode3;
    @ReportItem(name = "gyoseikuMei3", order = 217)
    public RString gyoseikuMei3;
    @ReportItem(name = "chikuCode13", order = 218)
    public RString chikuCode13;
    @ReportItem(name = "chikuName13", order = 219)
    public RString chikuName13;
    @ReportItem(name = "chikuCode23", order = 220)
    public RString chikuCode23;
    @ReportItem(name = "chikuName23", order = 221)
    public RString chikuName23;
    @ReportItem(name = "chikuCode33", order = 222)
    public RString chikuCode33;
    @ReportItem(name = "chikuName33", order = 223)
    public RString chikuName33;
    @ReportItem(name = "shimei_1", length = 46, order = 224)
    public RString shimei_1;
    @ReportItem(name = "tohyojoMei_1", length = 40, order = 225)
    public RString tohyojoMei_1;
    @ReportItem(name = "atena_1", length = 42, order = 226)
    public RString atena_1;
    @ReportItem(name = "jusho_1", length = 25, order = 227)
    public RString jusho_1;
    @ReportItem(name = "sofusakiJusho_1", length = 105, order = 228)
    public RString sofusakiJusho_1;
    @ReportItem(name = "shikibetsuCode", order = 229)
    public RString shikibetsuCode;
    @ReportItem(name = "shimei_2", length = 46, order = 230)
    public RString shimei_2;
    @ReportItem(name = "shimei_3", length = 46, order = 231)
    public RString shimei_3;
    @ReportItem(name = "shimei_4", length = 46, order = 232)
    public RString shimei_4;
    @ReportItem(name = "shimei_5", length = 46, order = 233)
    public RString shimei_5;
    @ReportItem(name = "shimei_6", length = 46, order = 234)
    public RString shimei_6;
    @ReportItem(name = "tohyojoMei_2", length = 40, order = 235)
    public RString tohyojoMei_2;
    @ReportItem(name = "tohyojoMei_3", length = 40, order = 236)
    public RString tohyojoMei_3;
    @ReportItem(name = "tohyojoMei_4", length = 40, order = 237)
    public RString tohyojoMei_4;
    @ReportItem(name = "tohyojoMei_5", length = 40, order = 238)
    public RString tohyojoMei_5;
    @ReportItem(name = "tohyojoMei_6", length = 40, order = 239)
    public RString tohyojoMei_6;
    @ReportItem(name = "jusho_2", length = 25, order = 240)
    public RString jusho_2;
    @ReportItem(name = "jusho_3", length = 25, order = 241)
    public RString jusho_3;
    @ReportItem(name = "jusho_4", length = 25, order = 242)
    public RString jusho_4;
    @ReportItem(name = "jusho_5", length = 25, order = 243)
    public RString jusho_5;
    @ReportItem(name = "jusho_6", length = 25, order = 244)
    public RString jusho_6;
    @ReportItem(name = "chikuCode14", order = 245)
    public RString chikuCode14;
    @ReportItem(name = "chikuCode24", order = 246)
    public RString chikuCode24;
    @ReportItem(name = "chikuCode34", order = 247)
    public RString chikuCode34;
    @ReportItem(name = "chikuName14", order = 248)
    public RString chikuName14;
    @ReportItem(name = "chikuName24", order = 249)
    public RString chikuName24;
    @ReportItem(name = "chikuName34", order = 250)
    public RString chikuName34;
    @ReportItem(name = "chikuCode15", order = 251)
    public RString chikuCode15;
    @ReportItem(name = "chikuCode25", order = 252)
    public RString chikuCode25;
    @ReportItem(name = "chikuCode35", order = 253)
    public RString chikuCode35;
    @ReportItem(name = "chikuCode16", order = 254)
    public RString chikuCode16;
    @ReportItem(name = "chikuCode26", order = 255)
    public RString chikuCode26;
    @ReportItem(name = "chikuCode36", order = 256)
    public RString chikuCode36;
    @ReportItem(name = "chikuName15", order = 257)
    public RString chikuName15;
    @ReportItem(name = "chikuName25", order = 258)
    public RString chikuName25;
    @ReportItem(name = "chikuName35", order = 259)
    public RString chikuName35;
    @ReportItem(name = "chikuName16", order = 260)
    public RString chikuName16;
    @ReportItem(name = "chikuName26", order = 261)
    public RString chikuName26;
    @ReportItem(name = "chikuName36", order = 262)
    public RString chikuName36;
    @ReportItem(name = "seinengappi4", order = 263)
    public RString seinengappi4;
    @ReportItem(name = "seinengappi5", order = 264)
    public RString seinengappi5;
    @ReportItem(name = "seinengappi6", order = 265)
    public RString seinengappi6;
    @ReportItem(name = "gyoseikuCode4", order = 266)
    public RString gyoseikuCode4;
    @ReportItem(name = "gyoseikuCode5", order = 267)
    public RString gyoseikuCode5;
    @ReportItem(name = "gyoseikuCode6", order = 268)
    public RString gyoseikuCode6;
    @ReportItem(name = "gyoseikuMei4", order = 269)
    public RString gyoseikuMei4;
    @ReportItem(name = "gyoseikuMei5", order = 270)
    public RString gyoseikuMei5;
    @ReportItem(name = "gyoseikuMei6", order = 271)
    public RString gyoseikuMei6;
    @ReportItem(name = "meiboNo4", order = 272)
    public RString meiboNo4;
    @ReportItem(name = "meiboNo5", order = 273)
    public RString meiboNo5;
    @ReportItem(name = "meiboNo6", order = 274)
    public RString meiboNo6;
    @ReportItem(name = "shimeiKana4", order = 275)
    public RString shimeiKana4;
    @ReportItem(name = "shimeiKana5", order = 276)
    public RString shimeiKana5;
    @ReportItem(name = "shimeiKana6", order = 277)
    public RString shimeiKana6;
    @ReportItem(name = "shimeiKana14", order = 278)
    public RString shimeiKana14;
    @ReportItem(name = "shimeiKana24", order = 279)
    public RString shimeiKana24;
    @ReportItem(name = "shimeiKana15", order = 280)
    public RString shimeiKana15;
    @ReportItem(name = "shimeiKana25", order = 281)
    public RString shimeiKana25;
    @ReportItem(name = "shimeiKana16", order = 282)
    public RString shimeiKana16;
    @ReportItem(name = "shimeiKana26", order = 283)
    public RString shimeiKana26;
    @ReportItem(name = "sofusakiGyoseikuMei11", order = 284)
    public RString sofusakiGyoseikuMei11;
    @ReportItem(name = "sofusakiGyoseikuMei21", order = 285)
    public RString sofusakiGyoseikuMei21;
    @ReportItem(name = "sofusakiGyoseikuMei31", order = 286)
    public RString sofusakiGyoseikuMei31;
    @ReportItem(name = "jushoCode4", order = 287)
    public RString jushoCode4;
    @ReportItem(name = "jushoCode5", order = 288)
    public RString jushoCode5;
    @ReportItem(name = "jushoCode6", order = 289)
    public RString jushoCode6;
    @ReportItem(name = "jusho4", order = 290)
    public RString jusho4;
    @ReportItem(name = "jusho5", order = 291)
    public RString jusho5;
    @ReportItem(name = "jusho6", order = 292)
    public RString jusho6;
    @ReportItem(name = "tohyoTimeStart1_nn", order = 293)
    public RString tohyoTimeStart1_nn;
    @ReportItem(name = "tohyoTimeEnd1_nn", order = 294)
    public RString tohyoTimeEnd1_nn;
    @ReportItem(name = "tohyoTimeStart2_nn", order = 295)
    public RString tohyoTimeStart2_nn;
    @ReportItem(name = "tohyoTimeEnd2_nn", order = 296)
    public RString tohyoTimeEnd2_nn;
    @ReportItem(name = "tohyoTimeStart3_nn", order = 297)
    public RString tohyoTimeStart3_nn;
    @ReportItem(name = "tohyoTimeEnd3_nn", order = 298)
    public RString tohyoTimeEnd3_nn;
    @ReportItem(name = "tohyoTimeStart4_nn", order = 299)
    public RString tohyoTimeStart4_nn;
    @ReportItem(name = "tohyoTimeEnd4_nn", order = 300)
    public RString tohyoTimeEnd4_nn;
    @ReportItem(name = "tohyoTimeStart5_nn", order = 301)
    public RString tohyoTimeStart5_nn;
    @ReportItem(name = "tohyoTimeEnd5_nn", order = 302)
    public RString tohyoTimeEnd5_nn;
    @ReportItem(name = "tohyoTimeStart6_nn", order = 303)
    public RString tohyoTimeStart6_nn;
    @ReportItem(name = "tohyoTimeEnd6_nn", order = 304)
    public RString tohyoTimeEnd6_nn;
    @ReportItem(name = "shikibetsuCode_Postex_1", order = 305)
    public RString shikibetsuCode_Postex_1;
    @ReportItem(name = "shikibetsuCode_Postex_2", order = 306)
    public RString shikibetsuCode_Postex_2;
    @ReportItem(name = "shikibetsuCode_Postex_3", order = 307)
    public RString shikibetsuCode_Postex_3;
    @ReportItem(name = "shikibetsuCode_Postex_4", order = 308)
    public RString shikibetsuCode_Postex_4;
    @ReportItem(name = "shikibetsuCode_Postex_5", order = 309)
    public RString shikibetsuCode_Postex_5;
    @ReportItem(name = "shikibetsuCode_Postex_6", order = 310)
    public RString shikibetsuCode_Postex_6;
    @ReportItem(name = "shimei4", order = 311)
    public RString shimei4;
    @ReportItem(name = "shimei5", order = 312)
    public RString shimei5;
    @ReportItem(name = "shimei6", order = 313)
    public RString shimei6;
    @ReportItem(name = "setainushiKubun4", order = 314)
    public RString setainushiKubun4;
    @ReportItem(name = "setainushiKubun5", order = 315)
    public RString setainushiKubun5;
    @ReportItem(name = "setainushiKubun6", order = 316)
    public RString setainushiKubun6;
    @ReportItem(name = "tohyojoMei4", order = 317)
    public RString tohyojoMei4;
    @ReportItem(name = "tohyojoMei5", order = 318)
    public RString tohyojoMei5;
    @ReportItem(name = "tohyojoMei6", order = 319)
    public RString tohyojoMei6;
    @ReportItem(name = "tohyojoJusho4", order = 320)
    public RString tohyojoJusho4;
    @ReportItem(name = "tohyojoJusho5", order = 321)
    public RString tohyojoJusho5;
    @ReportItem(name = "tohyojoJusho6", order = 322)
    public RString tohyojoJusho6;
    @ReportItem(name = "tohyokuMei4", order = 323)
    public RString tohyokuMei4;
    @ReportItem(name = "tohyokuMei5", order = 324)
    public RString tohyokuMei5;
    @ReportItem(name = "tohyokuMei6", order = 325)
    public RString tohyokuMei6;

    /**
     * 投票所入場券（ポステックス）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        tohyoTimeEnd1,
        tohyoTimeStart4,
        tohyoTimeEnd4,
        tohyoTimeStart1,
        yubinNo11,
        yubinNo21,
        jusho11,
        jusho14,
        setaiCode1,
        setaiCode4,
        jusho21,
        jusho24,
        shimei21,
        shimei24,
        shimei11,
        seibetsu1,
        shimei14,
        seibetsu4,
        shimei31,
        shimei34,
        sofusakiGyoseikuMei1,
        sofusakiGyoseikuMei2,
        tohyojoMei21,
        tohyojoMei24,
        tohyojoMei14,
        tohyojoMei11,
        tohyokuCode1,
        meiboPage1,
        meiboGyo1,
        tohyokuCode4,
        meiboPage4,
        meiboGyo4,
        sofusakiGyoseikuMei3,
        tohyojoMei31,
        tohyojoMei34,
        barcodeNyujokenBarcode1,
        barcodeNyujokenBarcode4,
        sofusakiJusho1,
        sofusakiJusho2,
        shikibetsuCode1,
        shikibetsuCode4,
        sofusakiJusho3,
        sofusakiJusho4,
        sofusakiJusho5,
        atena11,
        tohyoTimeStart2,
        tohyoTimeEnd2,
        tohyoTimeStart5,
        tohyoTimeEnd5,
        atena21,
        jusho12,
        setaiCode2,
        jusho15,
        setaiCode5,
        jusho25,
        jusho22,
        atena31,
        shimei22,
        shimei25,
        shimei12,
        seibetsu2,
        shimei15,
        seibetsu5,
        shimei32,
        shimei35,
        barcodeCustombarcode1,
        tohyojoMei22,
        tohyojoMei25,
        tohyojoMei12,
        tohyojoMei15,
        tohyokuCode2,
        meiboPage2,
        meiboGyo2,
        tohyokuCode5,
        meiboPage5,
        meiboGyo5,
        tohyojoMei32,
        tohyojoMei35,
        sofusakiMeiboNo1,
        seiriNo1,
        barcodeNyujokenBarcode2,
        barcodeNyujokenBarcode5,
        shikibetsuCode2,
        shikibetsuCode5,
        tohyoTimeStart3,
        tohyoTimeEnd3,
        tohyoTimeStart6,
        tohyoTimeEnd6,
        jusho13,
        jusho16,
        setaiCode3,
        setaiCode6,
        jusho23,
        jusho26,
        shimei23,
        shimei26,
        shimei13,
        seibetsu3,
        shimei16,
        seibetsu6,
        shimei33,
        shimei36,
        tohyojoMei23,
        tohyojoMei26,
        tohyojoMei13,
        tohyojoMei16,
        tohyokuCode3,
        meiboPage3,
        meiboGyo3,
        tohyokuCode6,
        meiboPage6,
        meiboGyo6,
        tohyojoMei33,
        tohyojoMei36,
        barcodeNyujokenBarcode3,
        barcodeNyujokenBarcode6,
        shikibetsuCode3,
        shikibetsuCode6;
    }
// </editor-fold>
}
