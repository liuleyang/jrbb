package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213;

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
 * 宛名シール12面ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12Source implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinno1", length = 9, order = 1)
    public RString yubinno1;
    @ReportItem(name = "koumokuc1", length = 24, order = 2)
    public RString koumokuc1;
    @ReportItem(name = "yubinno2", length = 9, order = 3)
    public RString yubinno2;
    @ReportItem(name = "koumokuc2", length = 24, order = 4)
    public RString koumokuc2;
    @ReportItem(name = "jushoa1", length = 20, order = 5)
    public RString jushoa1;
    @ReportItem(name = "jushola1", length = 22, order = 6)
    public RString jushola1;
    @ReportItem(name = "jushoa2", length = 20, order = 7)
    public RString jushoa2;
    @ReportItem(name = "jushola2", length = 22, order = 8)
    public RString jushola2;
    @ReportItem(name = "jusholb1", length = 22, order = 9)
    public RString jusholb1;
    @ReportItem(name = "jusholb2", length = 22, order = 10)
    public RString jusholb2;
    @ReportItem(name = "jushob1", length = 20, order = 11)
    public RString jushob1;
    @ReportItem(name = "jushob2", length = 20, order = 12)
    public RString jushob2;
    @ReportItem(name = "jusholc1", length = 22, order = 13)
    public RString jusholc1;
    @ReportItem(name = "jusholc2", length = 22, order = 14)
    public RString jusholc2;
    @ReportItem(name = "jushoc1", length = 20, order = 15)
    public RString jushoc1;
    @ReportItem(name = "jushoc2", length = 20, order = 16)
    public RString jushoc2;
    @ReportItem(name = "jushold1", length = 22, order = 17)
    public RString jushold1;
    @ReportItem(name = "jushold2", length = 22, order = 18)
    public RString jushold2;
    @ReportItem(name = "atenaa1", length = 42, order = 19)
    public RString atenaa1;
    @ReportItem(name = "atenala1", length = 52, order = 20)
    public RString atenala1;
    @ReportItem(name = "atenaa2", length = 42, order = 21)
    public RString atenaa2;
    @ReportItem(name = "atenala2", length = 52, order = 22)
    public RString atenala2;
    @ReportItem(name = "shichosonCode", length = 6, order = 23)
    public RString shichosonCode;
    @ReportItem(name = "senkyoMei", length = 20, order = 24)
    public RString senkyoMei;
    @ReportItem(name = "atenab1", length = 21, order = 25)
    public RString atenab1;
    @ReportItem(name = "atenalb1", length = 26, order = 26)
    public RString atenalb1;
    @ReportItem(name = "atenab2", length = 21, order = 27)
    public RString atenab2;
    @ReportItem(name = "atenalb2", length = 26, order = 28)
    public RString atenalb2;
    @ReportItem(name = "koumokua1", length = 24, order = 29)
    public RString koumokua1;
    @ReportItem(name = "koumokub1", length = 24, order = 30)
    public RString koumokub1;
    @ReportItem(name = "koumokua2", length = 24, order = 31)
    public RString koumokua2;
    @ReportItem(name = "koumokub2", length = 24, order = 32)
    public RString koumokub2;
    @ReportItem(name = "barcodeBarcode1", order = 33)
    public RString barcodeBarcode1;
    @ReportItem(name = "barcodeBarcode2", order = 34)
    public RString barcodeBarcode2;
    @ReportItem(name = "shichosonMei", length = 12, order = 35)
    public RString shichosonMei;
    @ReportItem(name = "yubinno3", length = 9, order = 36)
    public RString yubinno3;
    @ReportItem(name = "koumokuc3", length = 24, order = 37)
    public RString koumokuc3;
    @ReportItem(name = "yubinno4", length = 9, order = 38)
    public RString yubinno4;
    @ReportItem(name = "koumokuc4", length = 24, order = 39)
    public RString koumokuc4;
    @ReportItem(name = "jushoa3", length = 20, order = 40)
    public RString jushoa3;
    @ReportItem(name = "jushola3", length = 22, order = 41)
    public RString jushola3;
    @ReportItem(name = "jushoa4", length = 20, order = 42)
    public RString jushoa4;
    @ReportItem(name = "jushola4", length = 22, order = 43)
    public RString jushola4;
    @ReportItem(name = "jusholb4", length = 22, order = 44)
    public RString jusholb4;
    @ReportItem(name = "jusholb3", length = 22, order = 45)
    public RString jusholb3;
    @ReportItem(name = "jushob3", length = 20, order = 46)
    public RString jushob3;
    @ReportItem(name = "jushob4", length = 20, order = 47)
    public RString jushob4;
    @ReportItem(name = "jusholc3", length = 22, order = 48)
    public RString jusholc3;
    @ReportItem(name = "jusholc4", length = 22, order = 49)
    public RString jusholc4;
    @ReportItem(name = "jushoc3", length = 20, order = 50)
    public RString jushoc3;
    @ReportItem(name = "jushoc4", length = 20, order = 51)
    public RString jushoc4;
    @ReportItem(name = "jushold3", length = 22, order = 52)
    public RString jushold3;
    @ReportItem(name = "jushold4", length = 22, order = 53)
    public RString jushold4;
    @ReportItem(name = "atenaa3", length = 42, order = 54)
    public RString atenaa3;
    @ReportItem(name = "atenala3", length = 52, order = 55)
    public RString atenala3;
    @ReportItem(name = "atenaa4", length = 42, order = 56)
    public RString atenaa4;
    @ReportItem(name = "atenala4", length = 52, order = 57)
    public RString atenala4;
    @ReportItem(name = "atenab3", length = 21, order = 58)
    public RString atenab3;
    @ReportItem(name = "atenalb3", length = 26, order = 59)
    public RString atenalb3;
    @ReportItem(name = "atenab4", length = 21, order = 60)
    public RString atenab4;
    @ReportItem(name = "atenalb4", length = 26, order = 61)
    public RString atenalb4;
    @ReportItem(name = "koumokua3", length = 24, order = 62)
    public RString koumokua3;
    @ReportItem(name = "koumokub3", length = 24, order = 63)
    public RString koumokub3;
    @ReportItem(name = "koumokua4", length = 24, order = 64)
    public RString koumokua4;
    @ReportItem(name = "koumokub4", length = 24, order = 65)
    public RString koumokub4;
    @ReportItem(name = "barcodeBarcode3", order = 66)
    public RString barcodeBarcode3;
    @ReportItem(name = "barcodeBarcode4", order = 67)
    public RString barcodeBarcode4;
    @ReportItem(name = "yubinno5", length = 9, order = 68)
    public RString yubinno5;
    @ReportItem(name = "koumokuc5", length = 24, order = 69)
    public RString koumokuc5;
    @ReportItem(name = "yubinno6", length = 9, order = 70)
    public RString yubinno6;
    @ReportItem(name = "koumokuc6", length = 24, order = 71)
    public RString koumokuc6;
    @ReportItem(name = "jushoa5", length = 20, order = 72)
    public RString jushoa5;
    @ReportItem(name = "jushola5", length = 22, order = 73)
    public RString jushola5;
    @ReportItem(name = "jushoa6", length = 20, order = 74)
    public RString jushoa6;
    @ReportItem(name = "jushola6", length = 22, order = 75)
    public RString jushola6;
    @ReportItem(name = "title", length = 20, order = 76)
    public RString title;
    @ReportItem(name = "jusholb5", length = 22, order = 77)
    public RString jusholb5;
    @ReportItem(name = "jusholb6", length = 22, order = 78)
    public RString jusholb6;
    @ReportItem(name = "jushob5", length = 20, order = 79)
    public RString jushob5;
    @ReportItem(name = "jushob6", length = 20, order = 80)
    public RString jushob6;
    @ReportItem(name = "jusholc5", length = 22, order = 81)
    public RString jusholc5;
    @ReportItem(name = "jusholc6", length = 22, order = 82)
    public RString jusholc6;
    @ReportItem(name = "jushoc5", length = 20, order = 83)
    public RString jushoc5;
    @ReportItem(name = "jushoc6", length = 20, order = 84)
    public RString jushoc6;
    @ReportItem(name = "jushold5", length = 22, order = 85)
    public RString jushold5;
    @ReportItem(name = "jushold6", length = 22, order = 86)
    public RString jushold6;
    @ReportItem(name = "atenaa5", length = 42, order = 87)
    public RString atenaa5;
    @ReportItem(name = "atenala5", length = 52, order = 88)
    public RString atenala5;
    @ReportItem(name = "atenaa6", length = 42, order = 89)
    public RString atenaa6;
    @ReportItem(name = "atenala6", length = 52, order = 90)
    public RString atenala6;
    @ReportItem(name = "atenab5", length = 21, order = 91)
    public RString atenab5;
    @ReportItem(name = "atenalb5", length = 26, order = 92)
    public RString atenalb5;
    @ReportItem(name = "atenab6", length = 21, order = 93)
    public RString atenab6;
    @ReportItem(name = "atenalb6", length = 26, order = 94)
    public RString atenalb6;
    @ReportItem(name = "koumokua5", length = 24, order = 95)
    public RString koumokua5;
    @ReportItem(name = "koumokub5", length = 24, order = 96)
    public RString koumokub5;
    @ReportItem(name = "koumokua6", length = 24, order = 97)
    public RString koumokua6;
    @ReportItem(name = "koumokub6", length = 24, order = 98)
    public RString koumokub6;
    @ReportItem(name = "barcodeBarcode5", order = 99)
    public RString barcodeBarcode5;
    @ReportItem(name = "barcodeBarcode6", order = 100)
    public RString barcodeBarcode6;
    @ReportItem(name = "yubinno7", length = 9, order = 101)
    public RString yubinno7;
    @ReportItem(name = "koumokuc7", length = 24, order = 102)
    public RString koumokuc7;
    @ReportItem(name = "yubinno8", length = 9, order = 103)
    public RString yubinno8;
    @ReportItem(name = "koumokuc8", length = 24, order = 104)
    public RString koumokuc8;
    @ReportItem(name = "jushoa7", length = 20, order = 105)
    public RString jushoa7;
    @ReportItem(name = "jushola7", length = 22, order = 106)
    public RString jushola7;
    @ReportItem(name = "jushoa8", length = 20, order = 107)
    public RString jushoa8;
    @ReportItem(name = "jushola8", length = 22, order = 108)
    public RString jushola8;
    @ReportItem(name = "jusholb7", length = 22, order = 109)
    public RString jusholb7;
    @ReportItem(name = "jusholb8", length = 22, order = 110)
    public RString jusholb8;
    @ReportItem(name = "jushob7", length = 20, order = 111)
    public RString jushob7;
    @ReportItem(name = "jushob8", length = 20, order = 112)
    public RString jushob8;
    @ReportItem(name = "jusholc7", length = 22, order = 113)
    public RString jusholc7;
    @ReportItem(name = "jusholc8", length = 22, order = 114)
    public RString jusholc8;
    @ReportItem(name = "jushoc7", length = 20, order = 115)
    public RString jushoc7;
    @ReportItem(name = "jushoc8", length = 20, order = 116)
    public RString jushoc8;
    @ReportItem(name = "jushold7", length = 22, order = 117)
    public RString jushold7;
    @ReportItem(name = "jushold8", length = 22, order = 118)
    public RString jushold8;
    @ReportItem(name = "atenaa7", length = 42, order = 119)
    public RString atenaa7;
    @ReportItem(name = "atenala7", length = 52, order = 120)
    public RString atenala7;
    @ReportItem(name = "atenaa8", length = 42, order = 121)
    public RString atenaa8;
    @ReportItem(name = "atenala8", length = 52, order = 122)
    public RString atenala8;
    @ReportItem(name = "atenab7", length = 21, order = 123)
    public RString atenab7;
    @ReportItem(name = "atenalb7", length = 26, order = 124)
    public RString atenalb7;
    @ReportItem(name = "atenab8", length = 21, order = 125)
    public RString atenab8;
    @ReportItem(name = "atenalb8", length = 26, order = 126)
    public RString atenalb8;
    @ReportItem(name = "koumokua7", length = 24, order = 127)
    public RString koumokua7;
    @ReportItem(name = "koumokub7", length = 24, order = 128)
    public RString koumokub7;
    @ReportItem(name = "koumokua8", length = 24, order = 129)
    public RString koumokua8;
    @ReportItem(name = "koumokub8", length = 24, order = 130)
    public RString koumokub8;
    @ReportItem(name = "barcodeBarcode7", order = 131)
    public RString barcodeBarcode7;
    @ReportItem(name = "barcodeBarcode8", order = 132)
    public RString barcodeBarcode8;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 133)
    public RString sakuseiYmdTime;
    @ReportItem(name = "yubinno9", length = 9, order = 134)
    public RString yubinno9;
    @ReportItem(name = "koumokuc9", length = 24, order = 135)
    public RString koumokuc9;
    @ReportItem(name = "yubinno10", length = 9, order = 136)
    public RString yubinno10;
    @ReportItem(name = "koumokuc10", length = 24, order = 137)
    public RString koumokuc10;
    @ReportItem(name = "jushoa9", length = 20, order = 138)
    public RString jushoa9;
    @ReportItem(name = "jushola9", length = 22, order = 139)
    public RString jushola9;
    @ReportItem(name = "jushoa10", length = 20, order = 140)
    public RString jushoa10;
    @ReportItem(name = "jushola10", length = 22, order = 141)
    public RString jushola10;
    @ReportItem(name = "jusholb9", length = 22, order = 142)
    public RString jusholb9;
    @ReportItem(name = "jusholb10", length = 22, order = 143)
    public RString jusholb10;
    @ReportItem(name = "jushob9", length = 20, order = 144)
    public RString jushob9;
    @ReportItem(name = "jushob10", length = 20, order = 145)
    public RString jushob10;
    @ReportItem(name = "jusholc9", length = 22, order = 146)
    public RString jusholc9;
    @ReportItem(name = "jusholc10", length = 22, order = 147)
    public RString jusholc10;
    @ReportItem(name = "jushoc9", length = 20, order = 148)
    public RString jushoc9;
    @ReportItem(name = "jushoc10", length = 20, order = 149)
    public RString jushoc10;
    @ReportItem(name = "jushold9", length = 22, order = 150)
    public RString jushold9;
    @ReportItem(name = "jushold10", length = 22, order = 151)
    public RString jushold10;
    @ReportItem(name = "atenaa9", length = 42, order = 152)
    public RString atenaa9;
    @ReportItem(name = "atenala9", length = 52, order = 153)
    public RString atenala9;
    @ReportItem(name = "atenaa10", length = 42, order = 154)
    public RString atenaa10;
    @ReportItem(name = "atenala10", length = 52, order = 155)
    public RString atenala10;
    @ReportItem(name = "atenab9", length = 21, order = 156)
    public RString atenab9;
    @ReportItem(name = "atenalb9", length = 26, order = 157)
    public RString atenalb9;
    @ReportItem(name = "atenab10", length = 21, order = 158)
    public RString atenab10;
    @ReportItem(name = "atenalb10", length = 26, order = 159)
    public RString atenalb10;
    @ReportItem(name = "koumokua9", length = 24, order = 160)
    public RString koumokua9;
    @ReportItem(name = "koumokub9", length = 24, order = 161)
    public RString koumokub9;
    @ReportItem(name = "koumokua10", length = 24, order = 162)
    public RString koumokua10;
    @ReportItem(name = "koumokub10", length = 24, order = 163)
    public RString koumokub10;
    @ReportItem(name = "barcodeBarcode9", order = 164)
    public RString barcodeBarcode9;
    @ReportItem(name = "barcodeBarcode10", order = 165)
    public RString barcodeBarcode10;
    @ReportItem(name = "yubinno11", length = 9, order = 166)
    public RString yubinno11;
    @ReportItem(name = "koumokuc11", length = 24, order = 167)
    public RString koumokuc11;
    @ReportItem(name = "yubinno12", length = 9, order = 168)
    public RString yubinno12;
    @ReportItem(name = "koumokuc12", length = 24, order = 169)
    public RString koumokuc12;
    @ReportItem(name = "jushoa11", length = 20, order = 170)
    public RString jushoa11;
    @ReportItem(name = "jushola11", length = 22, order = 171)
    public RString jushola11;
    @ReportItem(name = "jushoa12", length = 20, order = 172)
    public RString jushoa12;
    @ReportItem(name = "jushola12", length = 22, order = 173)
    public RString jushola12;
    @ReportItem(name = "jusholb11", length = 22, order = 174)
    public RString jusholb11;
    @ReportItem(name = "jusholb12", length = 22, order = 175)
    public RString jusholb12;
    @ReportItem(name = "jushob11", length = 20, order = 176)
    public RString jushob11;
    @ReportItem(name = "jushob12", length = 20, order = 177)
    public RString jushob12;
    @ReportItem(name = "jusholc11", length = 22, order = 178)
    public RString jusholc11;
    @ReportItem(name = "jusholc12", length = 22, order = 179)
    public RString jusholc12;
    @ReportItem(name = "jushoc11", length = 20, order = 180)
    public RString jushoc11;
    @ReportItem(name = "jushoc12", length = 20, order = 181)
    public RString jushoc12;
    @ReportItem(name = "jushold11", length = 22, order = 182)
    public RString jushold11;
    @ReportItem(name = "jushold12", length = 22, order = 183)
    public RString jushold12;
    @ReportItem(name = "atenaa11", length = 42, order = 184)
    public RString atenaa11;
    @ReportItem(name = "atenala11", length = 52, order = 185)
    public RString atenala11;
    @ReportItem(name = "atenaa12", length = 42, order = 186)
    public RString atenaa12;
    @ReportItem(name = "atenala12", length = 52, order = 187)
    public RString atenala12;
    @ReportItem(name = "atenab11", length = 21, order = 188)
    public RString atenab11;
    @ReportItem(name = "atenalb11", length = 26, order = 189)
    public RString atenalb11;
    @ReportItem(name = "atenab12", length = 21, order = 190)
    public RString atenab12;
    @ReportItem(name = "atenalb12", length = 26, order = 191)
    public RString atenalb12;
    @ReportItem(name = "koumokua11", length = 24, order = 192)
    public RString koumokua11;
    @ReportItem(name = "koumokub11", length = 24, order = 193)
    public RString koumokub11;
    @ReportItem(name = "koumokua12", length = 24, order = 194)
    public RString koumokua12;
    @ReportItem(name = "koumokub12", length = 24, order = 195)
    public RString koumokub12;
    @ReportItem(name = "barcodeBarcode11", order = 196)
    public RString barcodeBarcode11;
    @ReportItem(name = "barcodeBarcode12", order = 197)
    public RString barcodeBarcode12;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "pageCount", order = 198)
    public Integer pageCount;
    @ReportItem(name = "jushoList", length = 88, order = 199)
    public RString jushoList;
    @ReportItem(name = "meishoList", length = 78, order = 200)
    public RString meishoList;
    @ReportItem(name = "shikibetsuCode1", order = 201)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", order = 202)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode3", order = 203)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", order = 204)
    public RString shikibetsuCode4;
    @ReportItem(name = "shikibetsuCode5", order = 205)
    public RString shikibetsuCode5;
    @ReportItem(name = "shikibetsuCode6", order = 206)
    public RString shikibetsuCode6;
    @ReportItem(name = "shikibetsuCode7", order = 207)
    public RString shikibetsuCode7;
    @ReportItem(name = "shikibetsuCode8", order = 208)
    public RString shikibetsuCode8;
    @ReportItem(name = "shikibetsuCode9", order = 209)
    public RString shikibetsuCode9;
    @ReportItem(name = "shikibetsuCode10", order = 210)
    public RString shikibetsuCode10;
    @ReportItem(name = "shikibetsuCode11", order = 211)
    public RString shikibetsuCode11;
    @ReportItem(name = "shikibetsuCode12", order = 212)
    public RString shikibetsuCode12;
    @ReportItem(name = "jushoList1", length = 88, order = 213)
    public RString jushoList1;
    @ReportItem(name = "jushoList2", length = 88, order = 214)
    public RString jushoList2;
    @ReportItem(name = "jushoList3", length = 88, order = 215)
    public RString jushoList3;
    @ReportItem(name = "jushoList4", length = 88, order = 216)
    public RString jushoList4;
    @ReportItem(name = "jushoList5", length = 88, order = 217)
    public RString jushoList5;
    @ReportItem(name = "jushoList6", length = 88, order = 218)
    public RString jushoList6;
    @ReportItem(name = "jushoList7", length = 88, order = 219)
    public RString jushoList7;
    @ReportItem(name = "jushoList8", length = 88, order = 220)
    public RString jushoList8;
    @ReportItem(name = "jushoList9", length = 88, order = 221)
    public RString jushoList9;
    @ReportItem(name = "jushoList10", length = 88, order = 222)
    public RString jushoList10;
    @ReportItem(name = "jushoList11", length = 88, order = 223)
    public RString jushoList11;
    @ReportItem(name = "jushoList12", length = 88, order = 224)
    public RString jushoList12;
    @ReportItem(name = "meishoList1", length = 78, order = 225)
    public RString meishoList1;
    @ReportItem(name = "meishoList2", length = 78, order = 226)
    public RString meishoList2;
    @ReportItem(name = "meishoList3", length = 78, order = 227)
    public RString meishoList3;
    @ReportItem(name = "meishoList4", length = 78, order = 228)
    public RString meishoList4;
    @ReportItem(name = "meishoList5", length = 78, order = 229)
    public RString meishoList5;
    @ReportItem(name = "meishoList6", length = 78, order = 230)
    public RString meishoList6;
    @ReportItem(name = "meishoList7", length = 78, order = 231)
    public RString meishoList7;
    @ReportItem(name = "meishoList8", length = 78, order = 232)
    public RString meishoList8;
    @ReportItem(name = "meishoList9", length = 78, order = 233)
    public RString meishoList9;
    @ReportItem(name = "meishoList10", length = 78, order = 234)
    public RString meishoList10;
    @ReportItem(name = "meishoList11", length = 78, order = 235)
    public RString meishoList11;
    @ReportItem(name = "meishoList12", length = 78, order = 236)
    public RString meishoList12;
    @ReportItem(name = "shikibetsuCode_1", order = 237)
    public RString shikibetsuCode_1;
    @ReportItem(name = "shikibetsuCode_2", order = 238)
    public RString shikibetsuCode_2;
    @ReportItem(name = "shikibetsuCode_3", order = 239)
    public RString shikibetsuCode_3;
    @ReportItem(name = "shikibetsuCode_4", order = 241)
    public RString shikibetsuCode_4;
    @ReportItem(name = "shikibetsuCode_5", order = 242)
    public RString shikibetsuCode_5;
    @ReportItem(name = "shikibetsuCode_6", order = 243)
    public RString shikibetsuCode_6;
    @ReportItem(name = "shikibetsuCode_7", order = 244)
    public RString shikibetsuCode_7;
    @ReportItem(name = "shikibetsuCode_8", order = 245)
    public RString shikibetsuCode_8;
    @ReportItem(name = "shikibetsuCode_9", order = 246)
    public RString shikibetsuCode_9;
    @ReportItem(name = "shikibetsuCode_10", order = 247)
    public RString shikibetsuCode_10;
    @ReportItem(name = "shikibetsuCode_11", order = 248)
    public RString shikibetsuCode_11;
    @ReportItem(name = "shikibetsuCode_12", order = 249)
    public RString shikibetsuCode_12;

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
    @ReportPerson(id = "X9")
    public ShikibetsuCode 識別コード9;
    @ReportKojinNo(id = "X9")
    public KojinNo 個人番号使用9;
    @ReportHojinNo(id = "X9")
    public HojinNo 法人番号使用9;
    @ReportPerson(id = "X10")
    public ShikibetsuCode 識別コード10;
    @ReportKojinNo(id = "X10")
    public KojinNo 個人番号使用10;
    @ReportHojinNo(id = "X10")
    public HojinNo 法人番号使用10;
    @ReportPerson(id = "X11")
    public ShikibetsuCode 識別コード11;
    @ReportKojinNo(id = "X11")
    public KojinNo 個人番号使用11;
    @ReportHojinNo(id = "X11")
    public HojinNo 法人番号使用11;
    @ReportPerson(id = "X12")
    public ShikibetsuCode 識別コード12;
    @ReportKojinNo(id = "X12")
    public KojinNo 個人番号使用12;
    @ReportHojinNo(id = "X12")
    public HojinNo 法人番号使用12;
// </editor-fold>
}
