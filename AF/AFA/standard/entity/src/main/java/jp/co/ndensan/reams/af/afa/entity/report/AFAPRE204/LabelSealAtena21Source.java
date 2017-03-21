package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204;

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
 * ラベルシール（宛名シール用紙21面）ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21Source implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonCode", length = 6, order = 1)
    public RString shichosonCode;
    @ReportItem(name = "title", length = 32, order = 2)
    public RString title;
    @ReportItem(name = "sichosonMei", length = 20, order = 3)
    public RString sichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "shoNaiyo11", length = 42, order = 5)
    public RString shoNaiyo11;
    @ReportItem(name = "title11", length = 12, order = 6)
    public RString title11;
    @ReportItem(name = "naiyo11", length = 24, order = 7)
    public RString naiyo11;
    @ReportItem(name = "shoNaiyo12", length = 42, order = 8)
    public RString shoNaiyo12;
    @ReportItem(name = "title12", length = 12, order = 9)
    public RString title12;
    @ReportItem(name = "naiyo12", length = 24, order = 10)
    public RString naiyo12;
    @ReportItem(name = "shoNaiyo13", length = 42, order = 11)
    public RString shoNaiyo13;
    @ReportItem(name = "title13", length = 12, order = 12)
    public RString title13;
    @ReportItem(name = "naiyo13", length = 24, order = 13)
    public RString naiyo13;
    @ReportItem(name = "shoNaiyo21", length = 42, order = 14)
    public RString shoNaiyo21;
    @ReportItem(name = "shoNaiyo22", length = 42, order = 15)
    public RString shoNaiyo22;
    @ReportItem(name = "shoNaiyo23", length = 42, order = 16)
    public RString shoNaiyo23;
    @ReportItem(name = "title23", length = 12, order = 17)
    public RString title23;
    @ReportItem(name = "naiyo23", length = 24, order = 18)
    public RString naiyo23;
    @ReportItem(name = "title21", length = 12, order = 19)
    public RString title21;
    @ReportItem(name = "naiyo21", length = 24, order = 20)
    public RString naiyo21;
    @ReportItem(name = "title22", length = 12, order = 21)
    public RString title22;
    @ReportItem(name = "naiyo22", length = 24, order = 22)
    public RString naiyo22;
    @ReportItem(name = "shoNaiyo31", length = 42, order = 23)
    public RString shoNaiyo31;
    @ReportItem(name = "shoNaiyo32", length = 42, order = 24)
    public RString shoNaiyo32;
    @ReportItem(name = "shoNaiyo33", length = 42, order = 25)
    public RString shoNaiyo33;
    @ReportItem(name = "shoNaiyo41", length = 42, order = 26)
    public RString shoNaiyo41;
    @ReportItem(name = "shoNaiyo42", length = 42, order = 27)
    public RString shoNaiyo42;
    @ReportItem(name = "shoNaiyo43", length = 42, order = 28)
    public RString shoNaiyo43;
    @ReportItem(name = "title31", length = 12, order = 29)
    public RString title31;
    @ReportItem(name = "naiyo31", length = 24, order = 30)
    public RString naiyo31;
    @ReportItem(name = "title32", length = 12, order = 31)
    public RString title32;
    @ReportItem(name = "naiyo32", length = 24, order = 32)
    public RString naiyo32;
    @ReportItem(name = "title33", length = 12, order = 33)
    public RString title33;
    @ReportItem(name = "naiyo33", length = 24, order = 34)
    public RString naiyo33;
    @ReportItem(name = "shoNaiyo51", length = 42, order = 35)
    public RString shoNaiyo51;
    @ReportItem(name = "shoNaiyo52", length = 42, order = 36)
    public RString shoNaiyo52;
    @ReportItem(name = "shoNaiyo53", length = 42, order = 37)
    public RString shoNaiyo53;
    @ReportItem(name = "title43", length = 12, order = 38)
    public RString title43;
    @ReportItem(name = "naiyo43", length = 24, order = 39)
    public RString naiyo43;
    @ReportItem(name = "title41", length = 12, order = 40)
    public RString title41;
    @ReportItem(name = "naiyo41", length = 24, order = 41)
    public RString naiyo41;
    @ReportItem(name = "title42", length = 12, order = 42)
    public RString title42;
    @ReportItem(name = "naiyo42", length = 24, order = 43)
    public RString naiyo42;
    @ReportItem(name = "title51", length = 12, order = 44)
    public RString title51;
    @ReportItem(name = "naiyo51", length = 24, order = 45)
    public RString naiyo51;
    @ReportItem(name = "title52", length = 12, order = 46)
    public RString title52;
    @ReportItem(name = "naiyo52", length = 24, order = 47)
    public RString naiyo52;
    @ReportItem(name = "title53", length = 12, order = 48)
    public RString title53;
    @ReportItem(name = "naiyo53", length = 24, order = 49)
    public RString naiyo53;
    @ReportItem(name = "barcodeBarcode1", order = 50)
    public RString barcodeBarcode1;
    @ReportItem(name = "barcodeBarcode2", order = 51)
    public RString barcodeBarcode2;
    @ReportItem(name = "barcodeBarcode3", order = 52)
    public RString barcodeBarcode3;
    @ReportItem(name = "code2", length = 20, order = 53)
    public RString code2;
    @ReportItem(name = "code3", length = 20, order = 54)
    public RString code3;
    @ReportItem(name = "code1", length = 20, order = 55)
    public RString code1;
    @ReportItem(name = "title16", length = 12, order = 56)
    public RString title16;
    @ReportItem(name = "naiyo16", length = 24, order = 57)
    public RString naiyo16;
    @ReportItem(name = "shoNaiyo14", length = 42, order = 58)
    public RString shoNaiyo14;
    @ReportItem(name = "title14", length = 12, order = 59)
    public RString title14;
    @ReportItem(name = "naiyo14", length = 24, order = 60)
    public RString naiyo14;
    @ReportItem(name = "title15", length = 12, order = 61)
    public RString title15;
    @ReportItem(name = "shoNaiyo15", length = 42, order = 62)
    public RString shoNaiyo15;
    @ReportItem(name = "naiyo15", length = 24, order = 63)
    public RString naiyo15;
    @ReportItem(name = "shoNaiyo16", length = 42, order = 64)
    public RString shoNaiyo16;
    @ReportItem(name = "shoNaiyo24", length = 42, order = 65)
    public RString shoNaiyo24;
    @ReportItem(name = "shoNaiyo25", length = 42, order = 66)
    public RString shoNaiyo25;
    @ReportItem(name = "shoNaiyo26", length = 42, order = 67)
    public RString shoNaiyo26;
    @ReportItem(name = "title26", length = 12, order = 68)
    public RString title26;
    @ReportItem(name = "naiyo26", length = 24, order = 69)
    public RString naiyo26;
    @ReportItem(name = "title24", length = 12, order = 70)
    public RString title24;
    @ReportItem(name = "naiyo24", length = 24, order = 71)
    public RString naiyo24;
    @ReportItem(name = "title25", length = 12, order = 72)
    public RString title25;
    @ReportItem(name = "naiyo25", length = 24, order = 73)
    public RString naiyo25;
    @ReportItem(name = "shoNaiyo34", length = 42, order = 74)
    public RString shoNaiyo34;
    @ReportItem(name = "shoNaiyo35", length = 42, order = 75)
    public RString shoNaiyo35;
    @ReportItem(name = "shoNaiyo36", length = 42, order = 76)
    public RString shoNaiyo36;
    @ReportItem(name = "shoNaiyo44", length = 42, order = 77)
    public RString shoNaiyo44;
    @ReportItem(name = "shoNaiyo45", length = 42, order = 78)
    public RString shoNaiyo45;
    @ReportItem(name = "shoNaiyo46", length = 42, order = 79)
    public RString shoNaiyo46;
    @ReportItem(name = "title36", length = 12, order = 80)
    public RString title36;
    @ReportItem(name = "naiyo36", length = 24, order = 81)
    public RString naiyo36;
    @ReportItem(name = "title34", length = 12, order = 82)
    public RString title34;
    @ReportItem(name = "naiyo34", length = 24, order = 83)
    public RString naiyo34;
    @ReportItem(name = "title35", length = 12, order = 84)
    public RString title35;
    @ReportItem(name = "naiyo35", length = 24, order = 85)
    public RString naiyo35;
    @ReportItem(name = "shoNaiyo54", length = 42, order = 86)
    public RString shoNaiyo54;
    @ReportItem(name = "shoNaiyo55", length = 42, order = 87)
    public RString shoNaiyo55;
    @ReportItem(name = "shoNaiyo56", length = 42, order = 88)
    public RString shoNaiyo56;
    @ReportItem(name = "title46", length = 12, order = 89)
    public RString title46;
    @ReportItem(name = "naiyo46", length = 24, order = 90)
    public RString naiyo46;
    @ReportItem(name = "title44", length = 12, order = 91)
    public RString title44;
    @ReportItem(name = "naiyo44", length = 24, order = 92)
    public RString naiyo44;
    @ReportItem(name = "title45", length = 12, order = 93)
    public RString title45;
    @ReportItem(name = "naiyo45", length = 24, order = 94)
    public RString naiyo45;
    @ReportItem(name = "title56", length = 12, order = 95)
    public RString title56;
    @ReportItem(name = "naiyo56", length = 24, order = 96)
    public RString naiyo56;
    @ReportItem(name = "title54", length = 12, order = 97)
    public RString title54;
    @ReportItem(name = "naiyo54", length = 24, order = 98)
    public RString naiyo54;
    @ReportItem(name = "title55", length = 12, order = 99)
    public RString title55;
    @ReportItem(name = "naiyo55", length = 24, order = 100)
    public RString naiyo55;
    @ReportItem(name = "barcodeBarcode4", order = 101)
    public RString barcodeBarcode4;
    @ReportItem(name = "barcodeBarcode5", order = 102)
    public RString barcodeBarcode5;
    @ReportItem(name = "barcodeBarcode6", order = 103)
    public RString barcodeBarcode6;
    @ReportItem(name = "code6", length = 20, order = 104)
    public RString code6;
    @ReportItem(name = "code4", length = 20, order = 105)
    public RString code4;
    @ReportItem(name = "code5", length = 20, order = 106)
    public RString code5;
    @ReportItem(name = "shoNaiyo17", length = 42, order = 107)
    public RString shoNaiyo17;
    @ReportItem(name = "title17", length = 12, order = 108)
    public RString title17;
    @ReportItem(name = "naiyo17", length = 24, order = 109)
    public RString naiyo17;
    @ReportItem(name = "shoNaiyo18", length = 42, order = 110)
    public RString shoNaiyo18;
    @ReportItem(name = "title18", length = 12, order = 111)
    public RString title18;
    @ReportItem(name = "naiyo18", length = 24, order = 112)
    public RString naiyo18;
    @ReportItem(name = "shoNaiyo19", length = 42, order = 113)
    public RString shoNaiyo19;
    @ReportItem(name = "title19", length = 12, order = 114)
    public RString title19;
    @ReportItem(name = "naiyo19", length = 24, order = 115)
    public RString naiyo19;
    @ReportItem(name = "shoNaiyo27", length = 42, order = 116)
    public RString shoNaiyo27;
    @ReportItem(name = "shoNaiyo28", length = 42, order = 117)
    public RString shoNaiyo28;
    @ReportItem(name = "shoNaiyo29", length = 42, order = 118)
    public RString shoNaiyo29;
    @ReportItem(name = "title27", length = 12, order = 119)
    public RString title27;
    @ReportItem(name = "naiyo27", length = 24, order = 120)
    public RString naiyo27;
    @ReportItem(name = "title28", length = 12, order = 121)
    public RString title28;
    @ReportItem(name = "naiyo28", length = 24, order = 122)
    public RString naiyo28;
    @ReportItem(name = "title29", length = 12, order = 123)
    public RString title29;
    @ReportItem(name = "naiyo29", length = 24, order = 124)
    public RString naiyo29;
    @ReportItem(name = "shoNaiyo37", length = 42, order = 125)
    public RString shoNaiyo37;
    @ReportItem(name = "shoNaiyo38", length = 42, order = 126)
    public RString shoNaiyo38;
    @ReportItem(name = "shoNaiyo39", length = 42, order = 127)
    public RString shoNaiyo39;
    @ReportItem(name = "shoNaiyo47", length = 42, order = 128)
    public RString shoNaiyo47;
    @ReportItem(name = "shoNaiyo48", length = 42, order = 129)
    public RString shoNaiyo48;
    @ReportItem(name = "shoNaiyo49", length = 42, order = 130)
    public RString shoNaiyo49;
    @ReportItem(name = "title37", length = 12, order = 131)
    public RString title37;
    @ReportItem(name = "naiyo37", length = 24, order = 132)
    public RString naiyo37;
    @ReportItem(name = "title38", length = 12, order = 133)
    public RString title38;
    @ReportItem(name = "naiyo38", length = 24, order = 134)
    public RString naiyo38;
    @ReportItem(name = "title39", length = 12, order = 135)
    public RString title39;
    @ReportItem(name = "naiyo39", length = 24, order = 136)
    public RString naiyo39;
    @ReportItem(name = "shoNaiyo57", length = 42, order = 137)
    public RString shoNaiyo57;
    @ReportItem(name = "shoNaiyo58", length = 42, order = 138)
    public RString shoNaiyo58;
    @ReportItem(name = "shoNaiyo59", length = 42, order = 139)
    public RString shoNaiyo59;
    @ReportItem(name = "title47", length = 12, order = 140)
    public RString title47;
    @ReportItem(name = "naiyo47", length = 24, order = 141)
    public RString naiyo47;
    @ReportItem(name = "title48", length = 12, order = 142)
    public RString title48;
    @ReportItem(name = "naiyo48", length = 24, order = 143)
    public RString naiyo48;
    @ReportItem(name = "title49", length = 12, order = 144)
    public RString title49;
    @ReportItem(name = "naiyo49", length = 24, order = 145)
    public RString naiyo49;
    @ReportItem(name = "title57", length = 12, order = 146)
    public RString title57;
    @ReportItem(name = "naiyo57", length = 24, order = 147)
    public RString naiyo57;
    @ReportItem(name = "title58", length = 12, order = 148)
    public RString title58;
    @ReportItem(name = "naiyo58", length = 24, order = 149)
    public RString naiyo58;
    @ReportItem(name = "title59", length = 12, order = 150)
    public RString title59;
    @ReportItem(name = "naiyo59", length = 24, order = 151)
    public RString naiyo59;
    @ReportItem(name = "barcodeBarcode7", order = 152)
    public RString barcodeBarcode7;
    @ReportItem(name = "barcodeBarcode8", order = 153)
    public RString barcodeBarcode8;
    @ReportItem(name = "barcodeBarcode9", order = 154)
    public RString barcodeBarcode9;
    @ReportItem(name = "code7", length = 20, order = 155)
    public RString code7;
    @ReportItem(name = "code8", length = 20, order = 156)
    public RString code8;
    @ReportItem(name = "code9", length = 20, order = 157)
    public RString code9;
    @ReportItem(name = "shoNaiyo110", length = 42, order = 158)
    public RString shoNaiyo110;
    @ReportItem(name = "title110", length = 12, order = 159)
    public RString title110;
    @ReportItem(name = "naiyo110", length = 24, order = 160)
    public RString naiyo110;
    @ReportItem(name = "title111", length = 12, order = 161)
    public RString title111;
    @ReportItem(name = "shoNaiyo111", length = 42, order = 162)
    public RString shoNaiyo111;
    @ReportItem(name = "naiyo111", length = 24, order = 163)
    public RString naiyo111;
    @ReportItem(name = "shoNaiyo112", length = 42, order = 164)
    public RString shoNaiyo112;
    @ReportItem(name = "title112", length = 12, order = 165)
    public RString title112;
    @ReportItem(name = "naiyo112", length = 24, order = 166)
    public RString naiyo112;
    @ReportItem(name = "shoNaiyo210", length = 42, order = 167)
    public RString shoNaiyo210;
    @ReportItem(name = "shoNaiyo211", length = 42, order = 168)
    public RString shoNaiyo211;
    @ReportItem(name = "shoNaiyo212", length = 42, order = 169)
    public RString shoNaiyo212;
    @ReportItem(name = "title211", length = 12, order = 170)
    public RString title211;
    @ReportItem(name = "naiyo211", length = 24, order = 171)
    public RString naiyo211;
    @ReportItem(name = "title210", length = 12, order = 172)
    public RString title210;
    @ReportItem(name = "naiyo210", length = 24, order = 173)
    public RString naiyo210;
    @ReportItem(name = "title212", length = 12, order = 174)
    public RString title212;
    @ReportItem(name = "naiyo212", length = 24, order = 175)
    public RString naiyo212;
    @ReportItem(name = "shoNaiyo310", length = 42, order = 176)
    public RString shoNaiyo310;
    @ReportItem(name = "shoNaiyo311", length = 42, order = 177)
    public RString shoNaiyo311;
    @ReportItem(name = "shoNaiyo312", length = 42, order = 178)
    public RString shoNaiyo312;
    @ReportItem(name = "shoNaiyo410", length = 42, order = 179)
    public RString shoNaiyo410;
    @ReportItem(name = "shoNaiyo411", length = 42, order = 180)
    public RString shoNaiyo411;
    @ReportItem(name = "shoNaiyo412", length = 42, order = 181)
    public RString shoNaiyo412;
    @ReportItem(name = "title310", length = 12, order = 182)
    public RString title310;
    @ReportItem(name = "naiyo310", length = 24, order = 183)
    public RString naiyo310;
    @ReportItem(name = "title311", length = 12, order = 184)
    public RString title311;
    @ReportItem(name = "naiyo311", length = 24, order = 185)
    public RString naiyo311;
    @ReportItem(name = "title312", length = 12, order = 186)
    public RString title312;
    @ReportItem(name = "naiyo312", length = 24, order = 187)
    public RString naiyo312;
    @ReportItem(name = "shoNaiyo510", length = 42, order = 188)
    public RString shoNaiyo510;
    @ReportItem(name = "shoNaiyo511", length = 42, order = 189)
    public RString shoNaiyo511;
    @ReportItem(name = "shoNaiyo512", length = 42, order = 190)
    public RString shoNaiyo512;
    @ReportItem(name = "title411", length = 12, order = 191)
    public RString title411;
    @ReportItem(name = "naiyo411", length = 24, order = 192)
    public RString naiyo411;
    @ReportItem(name = "title410", length = 12, order = 193)
    public RString title410;
    @ReportItem(name = "naiyo410", length = 24, order = 194)
    public RString naiyo410;
    @ReportItem(name = "title412", length = 12, order = 195)
    public RString title412;
    @ReportItem(name = "naiyo412", length = 24, order = 196)
    public RString naiyo412;
    @ReportItem(name = "title510", length = 12, order = 197)
    public RString title510;
    @ReportItem(name = "naiyo510", length = 24, order = 198)
    public RString naiyo510;
    @ReportItem(name = "title511", length = 12, order = 199)
    public RString title511;
    @ReportItem(name = "naiyo511", length = 24, order = 200)
    public RString naiyo511;
    @ReportItem(name = "title512", length = 12, order = 201)
    public RString title512;
    @ReportItem(name = "naiyo512", length = 24, order = 202)
    public RString naiyo512;
    @ReportItem(name = "barcodeBarcode10", order = 203)
    public RString barcodeBarcode10;
    @ReportItem(name = "barcodeBarcode11", order = 204)
    public RString barcodeBarcode11;
    @ReportItem(name = "barcodeBarcode12", order = 205)
    public RString barcodeBarcode12;
    @ReportItem(name = "code11", length = 20, order = 206)
    public RString code11;
    @ReportItem(name = "code10", length = 20, order = 207)
    public RString code10;
    @ReportItem(name = "code12", length = 20, order = 208)
    public RString code12;
    @ReportItem(name = "shoNaiyo113", length = 42, order = 209)
    public RString shoNaiyo113;
    @ReportItem(name = "title113", length = 12, order = 210)
    public RString title113;
    @ReportItem(name = "naiyo113", length = 24, order = 211)
    public RString naiyo113;
    @ReportItem(name = "title114", length = 12, order = 212)
    public RString title114;
    @ReportItem(name = "shoNaiyo114", length = 42, order = 213)
    public RString shoNaiyo114;
    @ReportItem(name = "naiyo114", length = 24, order = 214)
    public RString naiyo114;
    @ReportItem(name = "shoNaiyo115", length = 42, order = 215)
    public RString shoNaiyo115;
    @ReportItem(name = "title115", length = 12, order = 216)
    public RString title115;
    @ReportItem(name = "naiyo115", length = 24, order = 217)
    public RString naiyo115;
    @ReportItem(name = "shoNaiyo213", length = 42, order = 218)
    public RString shoNaiyo213;
    @ReportItem(name = "shoNaiyo214", length = 42, order = 219)
    public RString shoNaiyo214;
    @ReportItem(name = "shoNaiyo215", length = 42, order = 220)
    public RString shoNaiyo215;
    @ReportItem(name = "title213", length = 12, order = 221)
    public RString title213;
    @ReportItem(name = "naiyo213", length = 24, order = 222)
    public RString naiyo213;
    @ReportItem(name = "title214", length = 12, order = 223)
    public RString title214;
    @ReportItem(name = "naiyo214", length = 24, order = 224)
    public RString naiyo214;
    @ReportItem(name = "title215", length = 12, order = 225)
    public RString title215;
    @ReportItem(name = "naiyo215", length = 24, order = 226)
    public RString naiyo215;
    @ReportItem(name = "shoNaiyo313", length = 42, order = 227)
    public RString shoNaiyo313;
    @ReportItem(name = "shoNaiyo314", length = 42, order = 228)
    public RString shoNaiyo314;
    @ReportItem(name = "shoNaiyo315", length = 42, order = 229)
    public RString shoNaiyo315;
    @ReportItem(name = "shoNaiyo413", length = 42, order = 230)
    public RString shoNaiyo413;
    @ReportItem(name = "shoNaiyo414", length = 42, order = 231)
    public RString shoNaiyo414;
    @ReportItem(name = "shoNaiyo415", length = 42, order = 232)
    public RString shoNaiyo415;
    @ReportItem(name = "title313", length = 12, order = 233)
    public RString title313;
    @ReportItem(name = "naiyo313", length = 24, order = 234)
    public RString naiyo313;
    @ReportItem(name = "title314", length = 12, order = 235)
    public RString title314;
    @ReportItem(name = "naiyo314", length = 24, order = 236)
    public RString naiyo314;
    @ReportItem(name = "title315", length = 12, order = 237)
    public RString title315;
    @ReportItem(name = "naiyo315", length = 24, order = 238)
    public RString naiyo315;
    @ReportItem(name = "shoNaiyo513", length = 42, order = 239)
    public RString shoNaiyo513;
    @ReportItem(name = "shoNaiyo514", length = 42, order = 240)
    public RString shoNaiyo514;
    @ReportItem(name = "shoNaiyo515", length = 42, order = 241)
    public RString shoNaiyo515;
    @ReportItem(name = "title413", length = 12, order = 242)
    public RString title413;
    @ReportItem(name = "naiyo413", length = 24, order = 243)
    public RString naiyo413;
    @ReportItem(name = "title414", length = 12, order = 244)
    public RString title414;
    @ReportItem(name = "naiyo414", length = 24, order = 245)
    public RString naiyo414;
    @ReportItem(name = "title415", length = 12, order = 246)
    public RString title415;
    @ReportItem(name = "naiyo415", length = 24, order = 247)
    public RString naiyo415;
    @ReportItem(name = "title513", length = 12, order = 248)
    public RString title513;
    @ReportItem(name = "naiyo513", length = 24, order = 249)
    public RString naiyo513;
    @ReportItem(name = "title514", length = 12, order = 250)
    public RString title514;
    @ReportItem(name = "naiyo514", length = 24, order = 251)
    public RString naiyo514;
    @ReportItem(name = "title515", length = 12, order = 252)
    public RString title515;
    @ReportItem(name = "naiyo515", length = 24, order = 253)
    public RString naiyo515;
    @ReportItem(name = "barcodeBarcode13", order = 254)
    public RString barcodeBarcode13;
    @ReportItem(name = "barcodeBarcode14", order = 255)
    public RString barcodeBarcode14;
    @ReportItem(name = "barcodeBarcode15", order = 256)
    public RString barcodeBarcode15;
    @ReportItem(name = "code13", length = 20, order = 257)
    public RString code13;
    @ReportItem(name = "code14", length = 20, order = 258)
    public RString code14;
    @ReportItem(name = "code15", length = 20, order = 259)
    public RString code15;
    @ReportItem(name = "title116", length = 12, order = 260)
    public RString title116;
    @ReportItem(name = "naiyo116", length = 24, order = 261)
    public RString naiyo116;
    @ReportItem(name = "title117", length = 12, order = 262)
    public RString title117;
    @ReportItem(name = "naiyo117", length = 24, order = 263)
    public RString naiyo117;
    @ReportItem(name = "title118", length = 12, order = 264)
    public RString title118;
    @ReportItem(name = "naiyo118", length = 24, order = 265)
    public RString naiyo118;
    @ReportItem(name = "shoNaiyo116", length = 42, order = 266)
    public RString shoNaiyo116;
    @ReportItem(name = "shoNaiyo117", length = 42, order = 267)
    public RString shoNaiyo117;
    @ReportItem(name = "shoNaiyo118", length = 42, order = 268)
    public RString shoNaiyo118;
    @ReportItem(name = "shoNaiyo216", length = 42, order = 269)
    public RString shoNaiyo216;
    @ReportItem(name = "shoNaiyo217", length = 42, order = 270)
    public RString shoNaiyo217;
    @ReportItem(name = "shoNaiyo218", length = 42, order = 271)
    public RString shoNaiyo218;
    @ReportItem(name = "title218", length = 12, order = 272)
    public RString title218;
    @ReportItem(name = "naiyo218", length = 24, order = 273)
    public RString naiyo218;
    @ReportItem(name = "title216", length = 12, order = 274)
    public RString title216;
    @ReportItem(name = "naiyo216", length = 24, order = 275)
    public RString naiyo216;
    @ReportItem(name = "title217", length = 12, order = 276)
    public RString title217;
    @ReportItem(name = "naiyo217", length = 24, order = 277)
    public RString naiyo217;
    @ReportItem(name = "shoNaiyo316", length = 42, order = 278)
    public RString shoNaiyo316;
    @ReportItem(name = "shoNaiyo317", length = 42, order = 279)
    public RString shoNaiyo317;
    @ReportItem(name = "shoNaiyo318", length = 42, order = 280)
    public RString shoNaiyo318;
    @ReportItem(name = "shoNaiyo416", length = 42, order = 281)
    public RString shoNaiyo416;
    @ReportItem(name = "shoNaiyo417", length = 42, order = 282)
    public RString shoNaiyo417;
    @ReportItem(name = "shoNaiyo418", length = 42, order = 283)
    public RString shoNaiyo418;
    @ReportItem(name = "title316", length = 12, order = 284)
    public RString title316;
    @ReportItem(name = "naiyo316", length = 24, order = 285)
    public RString naiyo316;
    @ReportItem(name = "title317", length = 12, order = 286)
    public RString title317;
    @ReportItem(name = "naiyo317", length = 24, order = 287)
    public RString naiyo317;
    @ReportItem(name = "title318", length = 12, order = 288)
    public RString title318;
    @ReportItem(name = "naiyo318", length = 24, order = 289)
    public RString naiyo318;
    @ReportItem(name = "shoNaiyo516", length = 42, order = 290)
    public RString shoNaiyo516;
    @ReportItem(name = "shoNaiyo517", length = 42, order = 291)
    public RString shoNaiyo517;
    @ReportItem(name = "shoNaiyo518", length = 42, order = 292)
    public RString shoNaiyo518;
    @ReportItem(name = "title418", length = 12, order = 293)
    public RString title418;
    @ReportItem(name = "naiyo418", length = 24, order = 294)
    public RString naiyo418;
    @ReportItem(name = "title416", length = 12, order = 295)
    public RString title416;
    @ReportItem(name = "naiyo416", length = 24, order = 296)
    public RString naiyo416;
    @ReportItem(name = "title417", length = 12, order = 297)
    public RString title417;
    @ReportItem(name = "naiyo417", length = 24, order = 298)
    public RString naiyo417;
    @ReportItem(name = "title516", length = 12, order = 299)
    public RString title516;
    @ReportItem(name = "naiyo516", length = 24, order = 300)
    public RString naiyo516;
    @ReportItem(name = "title517", length = 12, order = 301)
    public RString title517;
    @ReportItem(name = "naiyo517", length = 24, order = 302)
    public RString naiyo517;
    @ReportItem(name = "title518", length = 12, order = 303)
    public RString title518;
    @ReportItem(name = "naiyo518", length = 24, order = 304)
    public RString naiyo518;
    @ReportItem(name = "barcodeBarcode16", order = 305)
    public RString barcodeBarcode16;
    @ReportItem(name = "barcodeBarcode18", order = 306)
    public RString barcodeBarcode18;
    @ReportItem(name = "barcodeBarcode17", order = 307)
    public RString barcodeBarcode17;
    @ReportItem(name = "code18", length = 20, order = 308)
    public RString code18;
    @ReportItem(name = "code16", length = 20, order = 309)
    public RString code16;
    @ReportItem(name = "code17", length = 20, order = 310)
    public RString code17;
    @ReportItem(name = "title119", length = 12, order = 311)
    public RString title119;
    @ReportItem(name = "naiyo119", length = 24, order = 312)
    public RString naiyo119;
    @ReportItem(name = "title121", length = 12, order = 313)
    public RString title121;
    @ReportItem(name = "naiyo121", length = 24, order = 314)
    public RString naiyo121;
    @ReportItem(name = "shoNaiyo119", length = 42, order = 315)
    public RString shoNaiyo119;
    @ReportItem(name = "shoNaiyo120", length = 42, order = 316)
    public RString shoNaiyo120;
    @ReportItem(name = "title120", length = 12, order = 317)
    public RString title120;
    @ReportItem(name = "naiyo120", length = 24, order = 318)
    public RString naiyo120;
    @ReportItem(name = "shoNaiyo121", length = 42, order = 319)
    public RString shoNaiyo121;
    @ReportItem(name = "shoNaiyo219", length = 42, order = 320)
    public RString shoNaiyo219;
    @ReportItem(name = "shoNaiyo220", length = 42, order = 321)
    public RString shoNaiyo220;
    @ReportItem(name = "shoNaiyo221", length = 42, order = 322)
    public RString shoNaiyo221;
    @ReportItem(name = "title219", length = 12, order = 323)
    public RString title219;
    @ReportItem(name = "naiyo219", length = 24, order = 324)
    public RString naiyo219;
    @ReportItem(name = "title220", length = 12, order = 325)
    public RString title220;
    @ReportItem(name = "naiyo220", length = 24, order = 326)
    public RString naiyo220;
    @ReportItem(name = "title221", length = 12, order = 327)
    public RString title221;
    @ReportItem(name = "naiyo221", length = 24, order = 328)
    public RString naiyo221;
    @ReportItem(name = "shoNaiyo319", length = 42, order = 329)
    public RString shoNaiyo319;
    @ReportItem(name = "shoNaiyo320", length = 42, order = 330)
    public RString shoNaiyo320;
    @ReportItem(name = "shoNaiyo321", length = 42, order = 331)
    public RString shoNaiyo321;
    @ReportItem(name = "shoNaiyo419", length = 42, order = 332)
    public RString shoNaiyo419;
    @ReportItem(name = "shoNaiyo420", length = 42, order = 333)
    public RString shoNaiyo420;
    @ReportItem(name = "shoNaiyo421", length = 42, order = 334)
    public RString shoNaiyo421;
    @ReportItem(name = "title319", length = 12, order = 335)
    public RString title319;
    @ReportItem(name = "naiyo319", length = 24, order = 336)
    public RString naiyo319;
    @ReportItem(name = "title321", length = 12, order = 337)
    public RString title321;
    @ReportItem(name = "naiyo321", length = 24, order = 338)
    public RString naiyo321;
    @ReportItem(name = "title320", length = 12, order = 339)
    public RString title320;
    @ReportItem(name = "naiyo320", length = 24, order = 340)
    public RString naiyo320;
    @ReportItem(name = "shoNaiyo519", length = 42, order = 341)
    public RString shoNaiyo519;
    @ReportItem(name = "shoNaiyo520", length = 42, order = 342)
    public RString shoNaiyo520;
    @ReportItem(name = "shoNaiyo521", length = 42, order = 343)
    public RString shoNaiyo521;
    @ReportItem(name = "title419", length = 12, order = 344)
    public RString title419;
    @ReportItem(name = "naiyo419", length = 24, order = 345)
    public RString naiyo419;
    @ReportItem(name = "title420", length = 12, order = 346)
    public RString title420;
    @ReportItem(name = "naiyo420", length = 24, order = 347)
    public RString naiyo420;
    @ReportItem(name = "title421", length = 12, order = 348)
    public RString title421;
    @ReportItem(name = "naiyo421", length = 24, order = 349)
    public RString naiyo421;
    @ReportItem(name = "title519", length = 12, order = 350)
    public RString title519;
    @ReportItem(name = "naiyo519", length = 24, order = 351)
    public RString naiyo519;
    @ReportItem(name = "title521", length = 12, order = 352)
    public RString title521;
    @ReportItem(name = "naiyo521", length = 24, order = 353)
    public RString naiyo521;
    @ReportItem(name = "title520", length = 12, order = 354)
    public RString title520;
    @ReportItem(name = "naiyo520", length = 24, order = 355)
    public RString naiyo520;
    @ReportItem(name = "barcodeBarcode21", order = 356)
    public RString barcodeBarcode21;
    @ReportItem(name = "barcodeBarcode19", order = 357)
    public RString barcodeBarcode19;
    @ReportItem(name = "barcodeBarcode20", order = 358)
    public RString barcodeBarcode20;
    @ReportItem(name = "code19", length = 20, order = 359)
    public RString code19;
    @ReportItem(name = "code20", length = 20, order = 360)
    public RString code20;
    @ReportItem(name = "code21", length = 20, order = 361)
    public RString code21;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportItem(name = "kanaMeisho1", order = 362)
    public RString kanaMeisho1;
    @ReportItem(name = "kanaMeisho2", order = 363)
    public RString kanaMeisho2;
    @ReportItem(name = "kanaMeisho3", order = 364)
    public RString kanaMeisho3;
    @ReportItem(name = "kanaMeisho4", order = 365)
    public RString kanaMeisho4;
    @ReportItem(name = "kanaMeisho5", order = 366)
    public RString kanaMeisho5;
    @ReportItem(name = "kanaMeisho6", order = 367)
    public RString kanaMeisho6;
    @ReportItem(name = "kanaMeisho7", order = 368)
    public RString kanaMeisho7;
    @ReportItem(name = "kanaMeisho8", order = 369)
    public RString kanaMeisho8;
    @ReportItem(name = "kanaMeisho9", order = 370)
    public RString kanaMeisho9;
    @ReportItem(name = "kanaMeisho10", order = 371)
    public RString kanaMeisho10;
    @ReportItem(name = "kanaMeisho11", order = 372)
    public RString kanaMeisho11;
    @ReportItem(name = "kanaMeisho12", order = 373)
    public RString kanaMeisho12;
    @ReportItem(name = "kanaMeisho13", order = 374)
    public RString kanaMeisho13;
    @ReportItem(name = "kanaMeisho14", order = 375)
    public RString kanaMeisho14;
    @ReportItem(name = "kanaMeisho15", order = 376)
    public RString kanaMeisho15;
    @ReportItem(name = "kanaMeisho16", order = 377)
    public RString kanaMeisho16;
    @ReportItem(name = "kanaMeisho17", order = 378)
    public RString kanaMeisho17;
    @ReportItem(name = "kanaMeisho18", order = 379)
    public RString kanaMeisho18;
    @ReportItem(name = "kanaMeisho19", order = 380)
    public RString kanaMeisho19;
    @ReportItem(name = "kanaMeisho20", order = 381)
    public RString kanaMeisho20;
    @ReportItem(name = "kanaMeisho21", order = 382)
    public RString kanaMeisho21;
    @ReportItem(name = "shikibetsuCode1", order = 383)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", order = 384)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode3", order = 385)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", order = 386)
    public RString shikibetsuCode4;
    @ReportItem(name = "shikibetsuCode5", order = 387)
    public RString shikibetsuCode5;
    @ReportItem(name = "shikibetsuCode6", order = 388)
    public RString shikibetsuCode6;
    @ReportItem(name = "shikibetsuCode7", order = 389)
    public RString shikibetsuCode7;
    @ReportItem(name = "shikibetsuCode8", order = 390)
    public RString shikibetsuCode8;
    @ReportItem(name = "shikibetsuCode9", order = 391)
    public RString shikibetsuCode9;
    @ReportItem(name = "shikibetsuCode10", order = 392)
    public RString shikibetsuCode10;
    @ReportItem(name = "shikibetsuCode11", order = 393)
    public RString shikibetsuCode11;
    @ReportItem(name = "shikibetsuCode12", order = 394)
    public RString shikibetsuCode12;
    @ReportItem(name = "shikibetsuCode13", order = 395)
    public RString shikibetsuCode13;
    @ReportItem(name = "shikibetsuCode14", order = 396)
    public RString shikibetsuCode14;
    @ReportItem(name = "shikibetsuCode15", order = 397)
    public RString shikibetsuCode15;
    @ReportItem(name = "shikibetsuCode16", order = 398)
    public RString shikibetsuCode16;
    @ReportItem(name = "shikibetsuCode17", order = 399)
    public RString shikibetsuCode17;
    @ReportItem(name = "shikibetsuCode18", order = 400)
    public RString shikibetsuCode18;
    @ReportItem(name = "shikibetsuCode19", order = 401)
    public RString shikibetsuCode19;
    @ReportItem(name = "shikibetsuCode20", order = 402)
    public RString shikibetsuCode20;
    @ReportItem(name = "shikibetsuCode21", order = 403)
    public RString shikibetsuCode21;
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
    @ReportPerson(id = "X13")
    public ShikibetsuCode 識別コード13;
    @ReportKojinNo(id = "X13")
    public KojinNo 個人番号使用13;
    @ReportHojinNo(id = "X13")
    public HojinNo 法人番号使用13;
    @ReportPerson(id = "X14")
    public ShikibetsuCode 識別コード14;
    @ReportKojinNo(id = "X14")
    public KojinNo 個人番号使用14;
    @ReportHojinNo(id = "X14")
    public HojinNo 法人番号使用14;
    @ReportPerson(id = "X15")
    public ShikibetsuCode 識別コード15;
    @ReportKojinNo(id = "X15")
    public KojinNo 個人番号使用15;
    @ReportHojinNo(id = "X15")
    public HojinNo 法人番号使用15;
    @ReportPerson(id = "X16")
    public ShikibetsuCode 識別コード16;
    @ReportKojinNo(id = "X16")
    public KojinNo 個人番号使用16;
    @ReportHojinNo(id = "X16")
    public HojinNo 法人番号使用16;
    @ReportPerson(id = "X17")
    public ShikibetsuCode 識別コード17;
    @ReportKojinNo(id = "X17")
    public KojinNo 個人番号使用17;
    @ReportHojinNo(id = "X17")
    public HojinNo 法人番号使用17;
    @ReportPerson(id = "X18")
    public ShikibetsuCode 識別コード18;
    @ReportKojinNo(id = "X18")
    public KojinNo 個人番号使用18;
    @ReportHojinNo(id = "X18")
    public HojinNo 法人番号使用18;
    @ReportPerson(id = "X19")
    public ShikibetsuCode 識別コード19;
    @ReportKojinNo(id = "X19")
    public KojinNo 個人番号使用19;
    @ReportHojinNo(id = "X19")
    public HojinNo 法人番号使用19;
    @ReportPerson(id = "X20")
    public ShikibetsuCode 識別コード20;
    @ReportKojinNo(id = "X20")
    public KojinNo 個人番号使用20;
    @ReportHojinNo(id = "X20")
    public HojinNo 法人番号使用20;
    @ReportPerson(id = "X21")
    public ShikibetsuCode 識別コード21;
    @ReportKojinNo(id = "X21")
    public KojinNo 個人番号使用21;
    @ReportHojinNo(id = "X21")
    public HojinNo 法人番号使用21;
// </editor-fold>
}
