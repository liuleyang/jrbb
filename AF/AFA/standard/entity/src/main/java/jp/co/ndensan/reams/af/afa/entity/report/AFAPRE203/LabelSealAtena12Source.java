package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203;

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
 * ラベルシール（宛名シール用紙12面）ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0620-030 wangh
 */
public class LabelSealAtena12Source implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title11", length = 12, order = 1)
    public RString title11;
    @ReportItem(name = "naiyo11", length = 24, order = 2)
    public RString naiyo11;
    @ReportItem(name = "title12", length = 12, order = 3)
    public RString title12;
    @ReportItem(name = "naiyo12", length = 24, order = 4)
    public RString naiyo12;
    @ReportItem(name = "shoNaiyo11", length = 42, order = 5)
    public RString shoNaiyo11;
    @ReportItem(name = "shoNaiyo12", length = 42, order = 6)
    public RString shoNaiyo12;
    @ReportItem(name = "shoNaiyo21", length = 42, order = 7)
    public RString shoNaiyo21;
    @ReportItem(name = "shoNaiyo22", length = 42, order = 8)
    public RString shoNaiyo22;
    @ReportItem(name = "title21", length = 12, order = 9)
    public RString title21;
    @ReportItem(name = "naiyo21", length = 24, order = 10)
    public RString naiyo21;
    @ReportItem(name = "title22", length = 12, order = 11)
    public RString title22;
    @ReportItem(name = "naiyo22", length = 24, order = 12)
    public RString naiyo22;
    @ReportItem(name = "shoNaiyo31", length = 42, order = 13)
    public RString shoNaiyo31;
    @ReportItem(name = "shoNaiyo32", length = 42, order = 14)
    public RString shoNaiyo32;
    @ReportItem(name = "shoNaiyo41", length = 42, order = 15)
    public RString shoNaiyo41;
    @ReportItem(name = "title31", length = 12, order = 16)
    public RString title31;
    @ReportItem(name = "naiyo31", length = 24, order = 17)
    public RString naiyo31;
    @ReportItem(name = "shoNaiyo42", length = 42, order = 18)
    public RString shoNaiyo42;
    @ReportItem(name = "title32", length = 12, order = 19)
    public RString title32;
    @ReportItem(name = "naiyo32", length = 24, order = 20)
    public RString naiyo32;
    @ReportItem(name = "shoNaiyo51", length = 42, order = 21)
    public RString shoNaiyo51;
    @ReportItem(name = "shoNaiyo52", length = 42, order = 22)
    public RString shoNaiyo52;
    @ReportItem(name = "title41", length = 12, order = 23)
    public RString title41;
    @ReportItem(name = "naiyo41", length = 24, order = 24)
    public RString naiyo41;
    @ReportItem(name = "title42", length = 12, order = 25)
    public RString title42;
    @ReportItem(name = "naiyo42", length = 24, order = 26)
    public RString naiyo42;
    @ReportItem(name = "title51", length = 12, order = 27)
    public RString title51;
    @ReportItem(name = "naiyo51", length = 24, order = 28)
    public RString naiyo51;
    @ReportItem(name = "title52", length = 12, order = 29)
    public RString title52;
    @ReportItem(name = "naiyo52", length = 24, order = 30)
    public RString naiyo52;
    @ReportItem(name = "barcodeBarcode1", order = 31)
    public RString barcodeBarcode1;
    @ReportItem(name = "barcodeBarcode2", order = 32)
    public RString barcodeBarcode2;
    @ReportItem(name = "shichosonCode", length = 6, order = 33)
    public RString shichosonCode;
    @ReportItem(name = "code1", length = 20, order = 34)
    public RString code1;
    @ReportItem(name = "code2", length = 20, order = 35)
    public RString code2;
    @ReportItem(name = "shichosonmMei", length = 12, order = 36)
    public RString shichosonmMei;
    @ReportItem(name = "title13", length = 12, order = 37)
    public RString title13;
    @ReportItem(name = "naiyo13", length = 24, order = 38)
    public RString naiyo13;
    @ReportItem(name = "title14", length = 12, order = 39)
    public RString title14;
    @ReportItem(name = "naiyo14", length = 24, order = 40)
    public RString naiyo14;
    @ReportItem(name = "shoNaiyo13", length = 42, order = 41)
    public RString shoNaiyo13;
    @ReportItem(name = "shoNaiyo14", length = 42, order = 42)
    public RString shoNaiyo14;
    @ReportItem(name = "shoNaiyo23", length = 42, order = 43)
    public RString shoNaiyo23;
    @ReportItem(name = "shoNaiyo24", length = 42, order = 44)
    public RString shoNaiyo24;
    @ReportItem(name = "title23", length = 12, order = 45)
    public RString title23;
    @ReportItem(name = "naiyo23", length = 24, order = 46)
    public RString naiyo23;
    @ReportItem(name = "title24", length = 12, order = 47)
    public RString title24;
    @ReportItem(name = "naiyo24", length = 24, order = 48)
    public RString naiyo24;
    @ReportItem(name = "shoNaiyo33", length = 42, order = 49)
    public RString shoNaiyo33;
    @ReportItem(name = "shoNaiyo34", length = 42, order = 50)
    public RString shoNaiyo34;
    @ReportItem(name = "shoNaiyo43", length = 42, order = 51)
    public RString shoNaiyo43;
    @ReportItem(name = "title33", length = 12, order = 52)
    public RString title33;
    @ReportItem(name = "naiyo33", length = 24, order = 53)
    public RString naiyo33;
    @ReportItem(name = "shoNaiyo44", length = 42, order = 54)
    public RString shoNaiyo44;
    @ReportItem(name = "title34", length = 12, order = 55)
    public RString title34;
    @ReportItem(name = "naiyo34", length = 24, order = 56)
    public RString naiyo34;
    @ReportItem(name = "shoNaiyo53", length = 42, order = 57)
    public RString shoNaiyo53;
    @ReportItem(name = "shoNaiyo54", length = 42, order = 58)
    public RString shoNaiyo54;
    @ReportItem(name = "title43", length = 12, order = 59)
    public RString title43;
    @ReportItem(name = "naiyo43", length = 24, order = 60)
    public RString naiyo43;
    @ReportItem(name = "title44", length = 12, order = 61)
    public RString title44;
    @ReportItem(name = "naiyo44", length = 24, order = 62)
    public RString naiyo44;
    @ReportItem(name = "title53", length = 12, order = 63)
    public RString title53;
    @ReportItem(name = "naiyo53", length = 24, order = 64)
    public RString naiyo53;
    @ReportItem(name = "title54", length = 12, order = 65)
    public RString title54;
    @ReportItem(name = "naiyo54", length = 24, order = 66)
    public RString naiyo54;
    @ReportItem(name = "barcodeBarcode3", order = 67)
    public RString barcodeBarcode3;
    @ReportItem(name = "barcodeBarcode4", order = 68)
    public RString barcodeBarcode4;
    @ReportItem(name = "code3", length = 20, order = 69)
    public RString code3;
    @ReportItem(name = "code4", length = 20, order = 70)
    public RString code4;
    @ReportItem(name = "title15", length = 12, order = 71)
    public RString title15;
    @ReportItem(name = "naiyo15", length = 24, order = 72)
    public RString naiyo15;
    @ReportItem(name = "title16", length = 12, order = 73)
    public RString title16;
    @ReportItem(name = "naiyo16", length = 24, order = 74)
    public RString naiyo16;
    @ReportItem(name = "shoNaiyo15", length = 42, order = 75)
    public RString shoNaiyo15;
    @ReportItem(name = "shoNaiyo16", length = 42, order = 76)
    public RString shoNaiyo16;
    @ReportItem(name = "shoNaiyo25", length = 42, order = 77)
    public RString shoNaiyo25;
    @ReportItem(name = "shoNaiyo26", length = 42, order = 78)
    public RString shoNaiyo26;
    @ReportItem(name = "title25", length = 12, order = 79)
    public RString title25;
    @ReportItem(name = "naiyo25", length = 24, order = 80)
    public RString naiyo25;
    @ReportItem(name = "title26", length = 12, order = 81)
    public RString title26;
    @ReportItem(name = "naiyo26", length = 24, order = 82)
    public RString naiyo26;
    @ReportItem(name = "title", length = 20, order = 83)
    public RString title;
    @ReportItem(name = "shoNaiyo35", length = 42, order = 84)
    public RString shoNaiyo35;
    @ReportItem(name = "shoNaiyo36", length = 42, order = 85)
    public RString shoNaiyo36;
    @ReportItem(name = "shoNaiyo45", length = 42, order = 86)
    public RString shoNaiyo45;
    @ReportItem(name = "title35", length = 12, order = 87)
    public RString title35;
    @ReportItem(name = "naiyo35", length = 24, order = 88)
    public RString naiyo35;
    @ReportItem(name = "shoNaiyo46", length = 42, order = 89)
    public RString shoNaiyo46;
    @ReportItem(name = "title36", length = 12, order = 90)
    public RString title36;
    @ReportItem(name = "naiyo36", length = 24, order = 91)
    public RString naiyo36;
    @ReportItem(name = "shoNaiyo55", length = 42, order = 92)
    public RString shoNaiyo55;
    @ReportItem(name = "shoNaiyo56", length = 42, order = 93)
    public RString shoNaiyo56;
    @ReportItem(name = "title45", length = 12, order = 94)
    public RString title45;
    @ReportItem(name = "naiyo45", length = 24, order = 95)
    public RString naiyo45;
    @ReportItem(name = "title46", length = 12, order = 96)
    public RString title46;
    @ReportItem(name = "naiyo46", length = 24, order = 97)
    public RString naiyo46;
    @ReportItem(name = "title55", length = 12, order = 98)
    public RString title55;
    @ReportItem(name = "naiyo55", length = 24, order = 99)
    public RString naiyo55;
    @ReportItem(name = "title56", length = 12, order = 100)
    public RString title56;
    @ReportItem(name = "naiyo56", length = 24, order = 101)
    public RString naiyo56;
    @ReportItem(name = "barcodeBarcode5", order = 102)
    public RString barcodeBarcode5;
    @ReportItem(name = "barcodeBarcode6", order = 103)
    public RString barcodeBarcode6;
    @ReportItem(name = "code5", length = 20, order = 104)
    public RString code5;
    @ReportItem(name = "code6", length = 20, order = 105)
    public RString code6;
    @ReportItem(name = "title17", length = 12, order = 106)
    public RString title17;
    @ReportItem(name = "naiyo17", length = 24, order = 107)
    public RString naiyo17;
    @ReportItem(name = "title18", length = 12, order = 108)
    public RString title18;
    @ReportItem(name = "naiyo18", length = 24, order = 109)
    public RString naiyo18;
    @ReportItem(name = "shoNaiyo17", length = 42, order = 110)
    public RString shoNaiyo17;
    @ReportItem(name = "shoNaiyo18", length = 42, order = 111)
    public RString shoNaiyo18;
    @ReportItem(name = "shoNaiyo27", length = 42, order = 112)
    public RString shoNaiyo27;
    @ReportItem(name = "shoNaiyo28", length = 42, order = 113)
    public RString shoNaiyo28;
    @ReportItem(name = "title27", length = 12, order = 114)
    public RString title27;
    @ReportItem(name = "naiyo27", length = 24, order = 115)
    public RString naiyo27;
    @ReportItem(name = "title28", length = 12, order = 116)
    public RString title28;
    @ReportItem(name = "naiyo28", length = 24, order = 117)
    public RString naiyo28;
    @ReportItem(name = "shoNaiyo37", length = 42, order = 118)
    public RString shoNaiyo37;
    @ReportItem(name = "shoNaiyo38", length = 42, order = 119)
    public RString shoNaiyo38;
    @ReportItem(name = "shoNaiyo47", length = 42, order = 120)
    public RString shoNaiyo47;
    @ReportItem(name = "title37", length = 12, order = 121)
    public RString title37;
    @ReportItem(name = "naiyo37", length = 24, order = 122)
    public RString naiyo37;
    @ReportItem(name = "shoNaiyo48", length = 42, order = 123)
    public RString shoNaiyo48;
    @ReportItem(name = "title38", length = 12, order = 124)
    public RString title38;
    @ReportItem(name = "naiyo38", length = 24, order = 125)
    public RString naiyo38;
    @ReportItem(name = "shoNaiyo57", length = 42, order = 126)
    public RString shoNaiyo57;
    @ReportItem(name = "shoNaiyo58", length = 42, order = 127)
    public RString shoNaiyo58;
    @ReportItem(name = "title47", length = 12, order = 128)
    public RString title47;
    @ReportItem(name = "naiyo47", length = 24, order = 129)
    public RString naiyo47;
    @ReportItem(name = "title48", length = 12, order = 130)
    public RString title48;
    @ReportItem(name = "naiyo48", length = 24, order = 131)
    public RString naiyo48;
    @ReportItem(name = "title57", length = 12, order = 132)
    public RString title57;
    @ReportItem(name = "naiyo57", length = 24, order = 133)
    public RString naiyo57;
    @ReportItem(name = "title58", length = 12, order = 134)
    public RString title58;
    @ReportItem(name = "naiyo58", length = 24, order = 135)
    public RString naiyo58;
    @ReportItem(name = "barcodeBarcode7", order = 136)
    public RString barcodeBarcode7;
    @ReportItem(name = "barcodeBarcode8", order = 137)
    public RString barcodeBarcode8;
    @ReportItem(name = "code7", length = 20, order = 138)
    public RString code7;
    @ReportItem(name = "code8", length = 20, order = 139)
    public RString code8;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 140)
    public RString sakuseiYmdTime;
    @ReportItem(name = "title19", length = 12, order = 141)
    public RString title19;
    @ReportItem(name = "naiyo19", length = 24, order = 142)
    public RString naiyo19;
    @ReportItem(name = "title110", length = 12, order = 143)
    public RString title110;
    @ReportItem(name = "naiyo110", length = 24, order = 144)
    public RString naiyo110;
    @ReportItem(name = "shoNaiyo19", length = 42, order = 145)
    public RString shoNaiyo19;
    @ReportItem(name = "shoNaiyo110", length = 42, order = 146)
    public RString shoNaiyo110;
    @ReportItem(name = "shoNaiyo29", length = 42, order = 147)
    public RString shoNaiyo29;
    @ReportItem(name = "shoNaiyo210", length = 42, order = 148)
    public RString shoNaiyo210;
    @ReportItem(name = "title29", length = 12, order = 149)
    public RString title29;
    @ReportItem(name = "naiyo29", length = 24, order = 150)
    public RString naiyo29;
    @ReportItem(name = "title210", length = 12, order = 151)
    public RString title210;
    @ReportItem(name = "naiyo210", length = 24, order = 152)
    public RString naiyo210;
    @ReportItem(name = "shoNaiyo39", length = 42, order = 153)
    public RString shoNaiyo39;
    @ReportItem(name = "shoNaiyo310", length = 42, order = 154)
    public RString shoNaiyo310;
    @ReportItem(name = "shoNaiyo49", length = 42, order = 155)
    public RString shoNaiyo49;
    @ReportItem(name = "title39", length = 12, order = 156)
    public RString title39;
    @ReportItem(name = "naiyo39", length = 24, order = 157)
    public RString naiyo39;
    @ReportItem(name = "shoNaiyo410", length = 42, order = 158)
    public RString shoNaiyo410;
    @ReportItem(name = "title310", length = 12, order = 159)
    public RString title310;
    @ReportItem(name = "naiyo310", length = 24, order = 160)
    public RString naiyo310;
    @ReportItem(name = "shoNaiyo59", length = 42, order = 161)
    public RString shoNaiyo59;
    @ReportItem(name = "shoNaiyo510", length = 42, order = 162)
    public RString shoNaiyo510;
    @ReportItem(name = "title49", length = 12, order = 163)
    public RString title49;
    @ReportItem(name = "naiyo49", length = 24, order = 164)
    public RString naiyo49;
    @ReportItem(name = "title410", length = 12, order = 165)
    public RString title410;
    @ReportItem(name = "naiyo410", length = 24, order = 166)
    public RString naiyo410;
    @ReportItem(name = "title59", length = 12, order = 167)
    public RString title59;
    @ReportItem(name = "naiyo59", length = 24, order = 168)
    public RString naiyo59;
    @ReportItem(name = "title510", length = 12, order = 169)
    public RString title510;
    @ReportItem(name = "naiyo510", length = 24, order = 170)
    public RString naiyo510;
    @ReportItem(name = "barcodeBarcode9", order = 171)
    public RString barcodeBarcode9;
    @ReportItem(name = "barcodeBarcode10", order = 172)
    public RString barcodeBarcode10;
    @ReportItem(name = "code9", length = 20, order = 173)
    public RString code9;
    @ReportItem(name = "code10", length = 20, order = 174)
    public RString code10;
    @ReportItem(name = "title111", length = 12, order = 175)
    public RString title111;
    @ReportItem(name = "naiyo111", length = 24, order = 176)
    public RString naiyo111;
    @ReportItem(name = "title112", length = 12, order = 177)
    public RString title112;
    @ReportItem(name = "naiyo112", length = 24, order = 178)
    public RString naiyo112;
    @ReportItem(name = "shoNaiyo111", length = 42, order = 179)
    public RString shoNaiyo111;
    @ReportItem(name = "shoNaiyo112", length = 42, order = 180)
    public RString shoNaiyo112;
    @ReportItem(name = "shoNaiyo211", length = 42, order = 181)
    public RString shoNaiyo211;
    @ReportItem(name = "shoNaiyo212", length = 42, order = 182)
    public RString shoNaiyo212;
    @ReportItem(name = "title211", length = 12, order = 183)
    public RString title211;
    @ReportItem(name = "naiyo211", length = 24, order = 184)
    public RString naiyo211;
    @ReportItem(name = "title212", length = 12, order = 185)
    public RString title212;
    @ReportItem(name = "naiyo212", length = 24, order = 186)
    public RString naiyo212;
    @ReportItem(name = "shoNaiyo311", length = 42, order = 187)
    public RString shoNaiyo311;
    @ReportItem(name = "shoNaiyo312", length = 42, order = 188)
    public RString shoNaiyo312;
    @ReportItem(name = "shoNaiyo411", length = 42, order = 189)
    public RString shoNaiyo411;
    @ReportItem(name = "title311", length = 12, order = 190)
    public RString title311;
    @ReportItem(name = "naiyo311", length = 24, order = 191)
    public RString naiyo311;
    @ReportItem(name = "shoNaiyo412", length = 42, order = 192)
    public RString shoNaiyo412;
    @ReportItem(name = "title312", length = 12, order = 193)
    public RString title312;
    @ReportItem(name = "naiyo312", length = 24, order = 194)
    public RString naiyo312;
    @ReportItem(name = "shoNaiyo511", length = 42, order = 195)
    public RString shoNaiyo511;
    @ReportItem(name = "shoNaiyo512", length = 42, order = 196)
    public RString shoNaiyo512;
    @ReportItem(name = "title411", length = 12, order = 197)
    public RString title411;
    @ReportItem(name = "naiyo411", length = 24, order = 198)
    public RString naiyo411;
    @ReportItem(name = "title412", length = 12, order = 199)
    public RString title412;
    @ReportItem(name = "naiyo412", length = 24, order = 200)
    public RString naiyo412;
    @ReportItem(name = "title511", length = 12, order = 201)
    public RString title511;
    @ReportItem(name = "naiyo511", length = 24, order = 202)
    public RString naiyo511;
    @ReportItem(name = "title512", length = 12, order = 203)
    public RString title512;
    @ReportItem(name = "naiyo512", length = 24, order = 204)
    public RString naiyo512;
    @ReportItem(name = "barcodeBarcode11", order = 205)
    public RString barcodeBarcode11;
    @ReportItem(name = "barcodeBarcode12", order = 206)
    public RString barcodeBarcode12;
    @ReportItem(name = "code11", length = 20, order = 207)
    public RString code11;
    @ReportItem(name = "code12", length = 20, order = 208)
    public RString code12;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "kanaMeisho1", order = 209)
    public RString kanaMeisho1;
    @ReportItem(name = "kanaMeisho2", order = 210)
    public RString kanaMeisho2;
    @ReportItem(name = "kanaMeisho3", order = 211)
    public RString kanaMeisho3;
    @ReportItem(name = "kanaMeisho4", order = 212)
    public RString kanaMeisho4;
    @ReportItem(name = "kanaMeisho5", order = 213)
    public RString kanaMeisho5;
    @ReportItem(name = "kanaMeisho6", order = 214)
    public RString kanaMeisho6;
    @ReportItem(name = "kanaMeisho7", order = 215)
    public RString kanaMeisho7;
    @ReportItem(name = "kanaMeisho8", order = 216)
    public RString kanaMeisho8;
    @ReportItem(name = "kanaMeisho9", order = 217)
    public RString kanaMeisho9;
    @ReportItem(name = "kanaMeisho10", order = 218)
    public RString kanaMeisho10;
    @ReportItem(name = "kanaMeisho11", order = 219)
    public RString kanaMeisho11;
    @ReportItem(name = "kanaMeisho12", order = 220)
    public RString kanaMeisho12;
    @ReportItem(name = "shikibetsuCode1", order = 221)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", order = 222)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode3", order = 223)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", order = 224)
    public RString shikibetsuCode4;
    @ReportItem(name = "shikibetsuCode5", order = 225)
    public RString shikibetsuCode5;
    @ReportItem(name = "shikibetsuCode6", order = 226)
    public RString shikibetsuCode6;
    @ReportItem(name = "shikibetsuCode7", order = 227)
    public RString shikibetsuCode7;
    @ReportItem(name = "shikibetsuCode8", order = 228)
    public RString shikibetsuCode8;
    @ReportItem(name = "shikibetsuCode9", order = 229)
    public RString shikibetsuCode9;
    @ReportItem(name = "shikibetsuCode10", order = 230)
    public RString shikibetsuCode10;
    @ReportItem(name = "shikibetsuCode11", order = 231)
    public RString shikibetsuCode11;
    @ReportItem(name = "shikibetsuCode12", order = 232)
    public RString shikibetsuCode12;
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
