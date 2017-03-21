package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214;

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
 * 宛名シール21面ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21Source implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 10, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "yubinNo1", length = 9, order = 5)
    public RString yubinNo1;
    @ReportItem(name = "komokuA1", length = 18, order = 6)
    public RString komokuA1;
    @ReportItem(name = "yubinNo2", length = 9, order = 7)
    public RString yubinNo2;
    @ReportItem(name = "komokuA2", length = 18, order = 8)
    public RString komokuA2;
    @ReportItem(name = "yubinNo3", length = 9, order = 9)
    public RString yubinNo3;
    @ReportItem(name = "komokuA3", length = 18, order = 10)
    public RString komokuA3;
    @ReportItem(name = "jushoA1", length = 14, order = 11)
    public RString jushoA1;
    @ReportItem(name = "jushoA2", length = 14, order = 12)
    public RString jushoA2;
    @ReportItem(name = "jushoA3", length = 14, order = 13)
    public RString jushoA3;
    @ReportItem(name = "jushoLa1", length = 16, order = 14)
    public RString jushoLa1;
    @ReportItem(name = "jushoLa2", length = 16, order = 15)
    public RString jushoLa2;
    @ReportItem(name = "jushoLa3", length = 16, order = 16)
    public RString jushoLa3;
    @ReportItem(name = "jushoLb1", length = 16, order = 17)
    public RString jushoLb1;
    @ReportItem(name = "jushoLb2", length = 16, order = 18)
    public RString jushoLb2;
    @ReportItem(name = "jushoLb3", length = 16, order = 19)
    public RString jushoLb3;
    @ReportItem(name = "jushoB1", length = 14, order = 20)
    public RString jushoB1;
    @ReportItem(name = "jushoB2", length = 14, order = 21)
    public RString jushoB2;
    @ReportItem(name = "jushoB3", length = 14, order = 22)
    public RString jushoB3;
    @ReportItem(name = "jushoLc1", length = 16, order = 23)
    public RString jushoLc1;
    @ReportItem(name = "jushoLc2", length = 16, order = 24)
    public RString jushoLc2;
    @ReportItem(name = "jushoLc3", length = 16, order = 25)
    public RString jushoLc3;
    @ReportItem(name = "jushoLd1", length = 16, order = 26)
    public RString jushoLd1;
    @ReportItem(name = "jushoC1", length = 14, order = 27)
    public RString jushoC1;
    @ReportItem(name = "jushoLd2", length = 16, order = 28)
    public RString jushoLd2;
    @ReportItem(name = "jushoC2", length = 14, order = 29)
    public RString jushoC2;
    @ReportItem(name = "jushoC3", length = 14, order = 30)
    public RString jushoC3;
    @ReportItem(name = "jushoLd3", length = 16, order = 31)
    public RString jushoLd3;
    @ReportItem(name = "atenaA1", length = 28, order = 32)
    public RString atenaA1;
    @ReportItem(name = "atenaLa1", length = 38, order = 33)
    public RString atenaLa1;
    @ReportItem(name = "atenaA2", length = 28, order = 34)
    public RString atenaA2;
    @ReportItem(name = "atenaLa2", length = 38, order = 35)
    public RString atenaLa2;
    @ReportItem(name = "atenaA3", length = 28, order = 36)
    public RString atenaA3;
    @ReportItem(name = "atenaLa3", length = 38, order = 37)
    public RString atenaLa3;
    @ReportItem(name = "atenaB1", length = 28, order = 38)
    public RString atenaB1;
    @ReportItem(name = "atenaLb1", length = 38, order = 39)
    public RString atenaLb1;
    @ReportItem(name = "atenaB2", length = 28, order = 40)
    public RString atenaB2;
    @ReportItem(name = "atenaLb2", length = 38, order = 41)
    public RString atenaLb2;
    @ReportItem(name = "atenaB3", length = 28, order = 42)
    public RString atenaB3;
    @ReportItem(name = "atenaLb3", length = 38, order = 43)
    public RString atenaLb3;
    @ReportItem(name = "komokuB2", length = 18, order = 44)
    public RString komokuB2;
    @ReportItem(name = "komokuC2", length = 18, order = 45)
    public RString komokuC2;
    @ReportItem(name = "komokuB3", length = 18, order = 46)
    public RString komokuB3;
    @ReportItem(name = "komokuC3", length = 18, order = 47)
    public RString komokuC3;
    @ReportItem(name = "komokuB1", length = 18, order = 48)
    public RString komokuB1;
    @ReportItem(name = "komokuC1", length = 18, order = 49)
    public RString komokuC1;
    @ReportItem(name = "yubinNo4", length = 9, order = 50)
    public RString yubinNo4;
    @ReportItem(name = "komokuA4", length = 18, order = 51)
    public RString komokuA4;
    @ReportItem(name = "yubinNo5", length = 9, order = 52)
    public RString yubinNo5;
    @ReportItem(name = "komokuA5", length = 18, order = 53)
    public RString komokuA5;
    @ReportItem(name = "yubinNo6", length = 9, order = 54)
    public RString yubinNo6;
    @ReportItem(name = "komokuA6", length = 18, order = 55)
    public RString komokuA6;
    @ReportItem(name = "jushoA4", length = 14, order = 56)
    public RString jushoA4;
    @ReportItem(name = "jushoA5", length = 14, order = 57)
    public RString jushoA5;
    @ReportItem(name = "jushoA6", length = 14, order = 58)
    public RString jushoA6;
    @ReportItem(name = "jushoLa4", length = 16, order = 59)
    public RString jushoLa4;
    @ReportItem(name = "jushoLa5", length = 16, order = 60)
    public RString jushoLa5;
    @ReportItem(name = "jushoLa6", length = 16, order = 61)
    public RString jushoLa6;
    @ReportItem(name = "jushoLb4", length = 16, order = 62)
    public RString jushoLb4;
    @ReportItem(name = "jushoLb5", length = 16, order = 63)
    public RString jushoLb5;
    @ReportItem(name = "jushoLb6", length = 16, order = 64)
    public RString jushoLb6;
    @ReportItem(name = "jushoB4", length = 14, order = 65)
    public RString jushoB4;
    @ReportItem(name = "jushoB5", length = 14, order = 66)
    public RString jushoB5;
    @ReportItem(name = "jushoB6", length = 14, order = 67)
    public RString jushoB6;
    @ReportItem(name = "jushoLc4", length = 16, order = 68)
    public RString jushoLc4;
    @ReportItem(name = "jushoLc5", length = 16, order = 69)
    public RString jushoLc5;
    @ReportItem(name = "jushoLc6", length = 16, order = 70)
    public RString jushoLc6;
    @ReportItem(name = "jushoLd4", length = 16, order = 71)
    public RString jushoLd4;
    @ReportItem(name = "jushoLd5", length = 16, order = 72)
    public RString jushoLd5;
    @ReportItem(name = "jushoLd6", length = 16, order = 73)
    public RString jushoLd6;
    @ReportItem(name = "jushoC4", length = 14, order = 74)
    public RString jushoC4;
    @ReportItem(name = "jushoC5", length = 14, order = 75)
    public RString jushoC5;
    @ReportItem(name = "jushoC6", length = 14, order = 76)
    public RString jushoC6;
    @ReportItem(name = "atenaA4", length = 28, order = 77)
    public RString atenaA4;
    @ReportItem(name = "atenaLa4", length = 38, order = 78)
    public RString atenaLa4;
    @ReportItem(name = "atenaA5", length = 28, order = 79)
    public RString atenaA5;
    @ReportItem(name = "atenaLa5", length = 38, order = 80)
    public RString atenaLa5;
    @ReportItem(name = "atenaA6", length = 28, order = 81)
    public RString atenaA6;
    @ReportItem(name = "atenaLa6", length = 38, order = 82)
    public RString atenaLa6;
    @ReportItem(name = "atenaB4", length = 28, order = 83)
    public RString atenaB4;
    @ReportItem(name = "atenaLb4", length = 38, order = 84)
    public RString atenaLb4;
    @ReportItem(name = "atenaB5", length = 28, order = 85)
    public RString atenaB5;
    @ReportItem(name = "atenaLb5", length = 38, order = 86)
    public RString atenaLb5;
    @ReportItem(name = "atenaB6", length = 28, order = 87)
    public RString atenaB6;
    @ReportItem(name = "atenaLb6", length = 38, order = 88)
    public RString atenaLb6;
    @ReportItem(name = "komokuB4", length = 18, order = 89)
    public RString komokuB4;
    @ReportItem(name = "komokuC4", length = 18, order = 90)
    public RString komokuC4;
    @ReportItem(name = "komokuB5", length = 18, order = 91)
    public RString komokuB5;
    @ReportItem(name = "komokuC5", length = 18, order = 92)
    public RString komokuC5;
    @ReportItem(name = "komokuB6", length = 18, order = 93)
    public RString komokuB6;
    @ReportItem(name = "komokuC6", length = 18, order = 94)
    public RString komokuC6;
    @ReportItem(name = "yubinNo7", length = 9, order = 95)
    public RString yubinNo7;
    @ReportItem(name = "komokuA7", length = 18, order = 96)
    public RString komokuA7;
    @ReportItem(name = "yubinNo8", length = 9, order = 97)
    public RString yubinNo8;
    @ReportItem(name = "komokuA8", length = 18, order = 98)
    public RString komokuA8;
    @ReportItem(name = "yubinNo9", length = 9, order = 99)
    public RString yubinNo9;
    @ReportItem(name = "komokuA9", length = 18, order = 100)
    public RString komokuA9;
    @ReportItem(name = "jushoA7", length = 14, order = 101)
    public RString jushoA7;
    @ReportItem(name = "jushoA8", length = 14, order = 102)
    public RString jushoA8;
    @ReportItem(name = "jushoA9", length = 14, order = 103)
    public RString jushoA9;
    @ReportItem(name = "jushoLa7", length = 16, order = 104)
    public RString jushoLa7;
    @ReportItem(name = "jushoLa8", length = 16, order = 105)
    public RString jushoLa8;
    @ReportItem(name = "jushoLa9", length = 16, order = 106)
    public RString jushoLa9;
    @ReportItem(name = "jushoLb7", length = 16, order = 107)
    public RString jushoLb7;
    @ReportItem(name = "jushoLb8", length = 16, order = 108)
    public RString jushoLb8;
    @ReportItem(name = "jushoLb9", length = 16, order = 109)
    public RString jushoLb9;
    @ReportItem(name = "jushoB7", length = 14, order = 110)
    public RString jushoB7;
    @ReportItem(name = "jushoB8", length = 14, order = 111)
    public RString jushoB8;
    @ReportItem(name = "jushoB9", length = 14, order = 112)
    public RString jushoB9;
    @ReportItem(name = "jushoLc7", length = 16, order = 113)
    public RString jushoLc7;
    @ReportItem(name = "jushoLc8", length = 16, order = 114)
    public RString jushoLc8;
    @ReportItem(name = "jushoLc9", length = 16, order = 115)
    public RString jushoLc9;
    @ReportItem(name = "jushoLd7", length = 16, order = 116)
    public RString jushoLd7;
    @ReportItem(name = "jushoLd8", length = 16, order = 117)
    public RString jushoLd8;
    @ReportItem(name = "jushoLd9", length = 16, order = 118)
    public RString jushoLd9;
    @ReportItem(name = "jushoC7", length = 14, order = 119)
    public RString jushoC7;
    @ReportItem(name = "jushoC8", length = 14, order = 120)
    public RString jushoC8;
    @ReportItem(name = "jushoC9", length = 14, order = 121)
    public RString jushoC9;
    @ReportItem(name = "atenaA7", length = 28, order = 122)
    public RString atenaA7;
    @ReportItem(name = "atenaLa7", length = 38, order = 123)
    public RString atenaLa7;
    @ReportItem(name = "atenaA8", length = 28, order = 124)
    public RString atenaA8;
    @ReportItem(name = "atenaLa8", length = 38, order = 125)
    public RString atenaLa8;
    @ReportItem(name = "atenaA9", length = 28, order = 126)
    public RString atenaA9;
    @ReportItem(name = "atenaLa9", length = 38, order = 127)
    public RString atenaLa9;
    @ReportItem(name = "atenaB7", length = 28, order = 128)
    public RString atenaB7;
    @ReportItem(name = "atenaLb7", length = 38, order = 129)
    public RString atenaLb7;
    @ReportItem(name = "atenaB8", length = 28, order = 130)
    public RString atenaB8;
    @ReportItem(name = "atenaLb8", length = 38, order = 131)
    public RString atenaLb8;
    @ReportItem(name = "atenaB9", length = 28, order = 132)
    public RString atenaB9;
    @ReportItem(name = "atenaLb9", length = 38, order = 133)
    public RString atenaLb9;
    @ReportItem(name = "komokuB7", length = 18, order = 134)
    public RString komokuB7;
    @ReportItem(name = "komokuC7", length = 18, order = 135)
    public RString komokuC7;
    @ReportItem(name = "komokuB8", length = 18, order = 136)
    public RString komokuB8;
    @ReportItem(name = "komokuC8", length = 18, order = 137)
    public RString komokuC8;
    @ReportItem(name = "komokuB9", length = 18, order = 138)
    public RString komokuB9;
    @ReportItem(name = "komokuC9", length = 18, order = 139)
    public RString komokuC9;
    @ReportItem(name = "komokuA10", length = 18, order = 140)
    public RString komokuA10;
    @ReportItem(name = "komokuA11", length = 18, order = 141)
    public RString komokuA11;
    @ReportItem(name = "komokuA12", length = 18, order = 142)
    public RString komokuA12;
    @ReportItem(name = "yubinNo10", length = 9, order = 143)
    public RString yubinNo10;
    @ReportItem(name = "yubinNo11", length = 9, order = 144)
    public RString yubinNo11;
    @ReportItem(name = "yubinNo12", length = 9, order = 145)
    public RString yubinNo12;
    @ReportItem(name = "jushoA10", length = 14, order = 146)
    public RString jushoA10;
    @ReportItem(name = "jushoA11", length = 14, order = 147)
    public RString jushoA11;
    @ReportItem(name = "jushoA12", length = 14, order = 148)
    public RString jushoA12;
    @ReportItem(name = "jushoLa10", length = 16, order = 149)
    public RString jushoLa10;
    @ReportItem(name = "jushoLa11", length = 16, order = 150)
    public RString jushoLa11;
    @ReportItem(name = "jushoLa12", length = 16, order = 151)
    public RString jushoLa12;
    @ReportItem(name = "jushoLb10", length = 16, order = 152)
    public RString jushoLb10;
    @ReportItem(name = "jushoLb11", length = 16, order = 153)
    public RString jushoLb11;
    @ReportItem(name = "jushoLb12", length = 16, order = 154)
    public RString jushoLb12;
    @ReportItem(name = "jushoB10", length = 14, order = 155)
    public RString jushoB10;
    @ReportItem(name = "jushoB11", length = 14, order = 156)
    public RString jushoB11;
    @ReportItem(name = "jushoB12", length = 14, order = 157)
    public RString jushoB12;
    @ReportItem(name = "jushoLc10", length = 16, order = 158)
    public RString jushoLc10;
    @ReportItem(name = "jushoLc11", length = 16, order = 159)
    public RString jushoLc11;
    @ReportItem(name = "jushoLc12", length = 16, order = 160)
    public RString jushoLc12;
    @ReportItem(name = "jushoLd10", length = 16, order = 161)
    public RString jushoLd10;
    @ReportItem(name = "jushoC10", length = 14, order = 162)
    public RString jushoC10;
    @ReportItem(name = "jushoLd11", length = 16, order = 163)
    public RString jushoLd11;
    @ReportItem(name = "jushoC11", length = 14, order = 164)
    public RString jushoC11;
    @ReportItem(name = "jushoLd12", length = 16, order = 165)
    public RString jushoLd12;
    @ReportItem(name = "jushoC12", length = 14, order = 166)
    public RString jushoC12;
    @ReportItem(name = "atenaA10", length = 28, order = 167)
    public RString atenaA10;
    @ReportItem(name = "atenaLa10", length = 38, order = 168)
    public RString atenaLa10;
    @ReportItem(name = "atenaA11", length = 28, order = 169)
    public RString atenaA11;
    @ReportItem(name = "atenaLa11", length = 38, order = 170)
    public RString atenaLa11;
    @ReportItem(name = "atenaA12", length = 28, order = 171)
    public RString atenaA12;
    @ReportItem(name = "atenaLa12", length = 38, order = 172)
    public RString atenaLa12;
    @ReportItem(name = "atenaB10", length = 28, order = 173)
    public RString atenaB10;
    @ReportItem(name = "atenaLb10", length = 38, order = 174)
    public RString atenaLb10;
    @ReportItem(name = "atenaB11", length = 28, order = 175)
    public RString atenaB11;
    @ReportItem(name = "atenaLb11", length = 38, order = 176)
    public RString atenaLb11;
    @ReportItem(name = "atenaB12", length = 28, order = 177)
    public RString atenaB12;
    @ReportItem(name = "atenaLb12", length = 38, order = 178)
    public RString atenaLb12;
    @ReportItem(name = "komokuB10", length = 18, order = 179)
    public RString komokuB10;
    @ReportItem(name = "komokuC10", length = 18, order = 180)
    public RString komokuC10;
    @ReportItem(name = "komokuB11", length = 18, order = 181)
    public RString komokuB11;
    @ReportItem(name = "komokuC11", length = 18, order = 182)
    public RString komokuC11;
    @ReportItem(name = "komokuB12", length = 18, order = 183)
    public RString komokuB12;
    @ReportItem(name = "komokuC12", length = 18, order = 184)
    public RString komokuC12;
    @ReportItem(name = "komokuA14", length = 18, order = 185)
    public RString komokuA14;
    @ReportItem(name = "komokuA15", length = 18, order = 186)
    public RString komokuA15;
    @ReportItem(name = "yubinNo13", length = 9, order = 187)
    public RString yubinNo13;
    @ReportItem(name = "komokuA13", length = 18, order = 188)
    public RString komokuA13;
    @ReportItem(name = "yubinNo14", length = 9, order = 189)
    public RString yubinNo14;
    @ReportItem(name = "yubinNo15", length = 9, order = 190)
    public RString yubinNo15;
    @ReportItem(name = "jushoA13", length = 14, order = 191)
    public RString jushoA13;
    @ReportItem(name = "jushoA14", length = 14, order = 192)
    public RString jushoA14;
    @ReportItem(name = "jushoA15", length = 14, order = 193)
    public RString jushoA15;
    @ReportItem(name = "jushoLa13", length = 16, order = 194)
    public RString jushoLa13;
    @ReportItem(name = "jushoLa14", length = 16, order = 195)
    public RString jushoLa14;
    @ReportItem(name = "jushoLa15", length = 16, order = 196)
    public RString jushoLa15;
    @ReportItem(name = "jushoLb13", length = 16, order = 197)
    public RString jushoLb13;
    @ReportItem(name = "jushoLb14", length = 16, order = 198)
    public RString jushoLb14;
    @ReportItem(name = "jushoLb15", length = 16, order = 199)
    public RString jushoLb15;
    @ReportItem(name = "jushoB13", length = 14, order = 200)
    public RString jushoB13;
    @ReportItem(name = "jushoB14", length = 14, order = 201)
    public RString jushoB14;
    @ReportItem(name = "jushoB15", length = 14, order = 202)
    public RString jushoB15;
    @ReportItem(name = "jushoLc13", length = 16, order = 203)
    public RString jushoLc13;
    @ReportItem(name = "jushoLc14", length = 16, order = 204)
    public RString jushoLc14;
    @ReportItem(name = "jushoLc15", length = 16, order = 205)
    public RString jushoLc15;
    @ReportItem(name = "jushoLd13", length = 16, order = 206)
    public RString jushoLd13;
    @ReportItem(name = "jushoC13", length = 14, order = 207)
    public RString jushoC13;
    @ReportItem(name = "jushoLd14", length = 16, order = 208)
    public RString jushoLd14;
    @ReportItem(name = "jushoC14", length = 14, order = 209)
    public RString jushoC14;
    @ReportItem(name = "jushoLd15", length = 16, order = 210)
    public RString jushoLd15;
    @ReportItem(name = "jushoC15", length = 14, order = 211)
    public RString jushoC15;
    @ReportItem(name = "atenaA13", length = 28, order = 212)
    public RString atenaA13;
    @ReportItem(name = "atenaLa13", length = 38, order = 213)
    public RString atenaLa13;
    @ReportItem(name = "atenaA14", length = 28, order = 214)
    public RString atenaA14;
    @ReportItem(name = "atenaLa14", length = 38, order = 215)
    public RString atenaLa14;
    @ReportItem(name = "atenaA15", length = 28, order = 216)
    public RString atenaA15;
    @ReportItem(name = "atenaLa15", length = 38, order = 217)
    public RString atenaLa15;
    @ReportItem(name = "atenaB13", length = 28, order = 218)
    public RString atenaB13;
    @ReportItem(name = "atenaLb13", length = 38, order = 219)
    public RString atenaLb13;
    @ReportItem(name = "atenaB14", length = 28, order = 220)
    public RString atenaB14;
    @ReportItem(name = "atenaLb14", length = 38, order = 221)
    public RString atenaLb14;
    @ReportItem(name = "atenaB15", length = 28, order = 222)
    public RString atenaB15;
    @ReportItem(name = "atenaLb15", length = 38, order = 223)
    public RString atenaLb15;
    @ReportItem(name = "komokuB13", length = 18, order = 224)
    public RString komokuB13;
    @ReportItem(name = "komokuC13", length = 18, order = 225)
    public RString komokuC13;
    @ReportItem(name = "komokuB14", length = 18, order = 226)
    public RString komokuB14;
    @ReportItem(name = "komokuC14", length = 18, order = 227)
    public RString komokuC14;
    @ReportItem(name = "komokuB15", length = 18, order = 228)
    public RString komokuB15;
    @ReportItem(name = "komokuC15", length = 18, order = 229)
    public RString komokuC15;
    @ReportItem(name = "yubinNo16", length = 9, order = 230)
    public RString yubinNo16;
    @ReportItem(name = "komokuA16", length = 18, order = 231)
    public RString komokuA16;
    @ReportItem(name = "yubinNo17", length = 9, order = 232)
    public RString yubinNo17;
    @ReportItem(name = "komokuA17", length = 18, order = 233)
    public RString komokuA17;
    @ReportItem(name = "yubinNo18", length = 9, order = 234)
    public RString yubinNo18;
    @ReportItem(name = "komokuA18", length = 18, order = 235)
    public RString komokuA18;
    @ReportItem(name = "jushoA16", length = 14, order = 236)
    public RString jushoA16;
    @ReportItem(name = "jushoA17", length = 14, order = 237)
    public RString jushoA17;
    @ReportItem(name = "jushoA18", length = 14, order = 238)
    public RString jushoA18;
    @ReportItem(name = "jushoLa16", length = 16, order = 239)
    public RString jushoLa16;
    @ReportItem(name = "jushoLa17", length = 16, order = 240)
    public RString jushoLa17;
    @ReportItem(name = "jushoLa18", length = 16, order = 241)
    public RString jushoLa18;
    @ReportItem(name = "jushoLb16", length = 16, order = 242)
    public RString jushoLb16;
    @ReportItem(name = "jushoLb17", length = 16, order = 243)
    public RString jushoLb17;
    @ReportItem(name = "jushoLb18", length = 16, order = 244)
    public RString jushoLb18;
    @ReportItem(name = "jushoB16", length = 14, order = 245)
    public RString jushoB16;
    @ReportItem(name = "jushoB17", length = 14, order = 246)
    public RString jushoB17;
    @ReportItem(name = "jushoB18", length = 14, order = 247)
    public RString jushoB18;
    @ReportItem(name = "jushoLc16", length = 16, order = 248)
    public RString jushoLc16;
    @ReportItem(name = "jushoLc17", length = 16, order = 249)
    public RString jushoLc17;
    @ReportItem(name = "jushoLc18", length = 16, order = 250)
    public RString jushoLc18;
    @ReportItem(name = "jushoLd16", length = 16, order = 251)
    public RString jushoLd16;
    @ReportItem(name = "jushoC16", length = 14, order = 252)
    public RString jushoC16;
    @ReportItem(name = "jushoLd17", length = 16, order = 253)
    public RString jushoLd17;
    @ReportItem(name = "jushoC17", length = 14, order = 254)
    public RString jushoC17;
    @ReportItem(name = "jushoLd18", length = 16, order = 255)
    public RString jushoLd18;
    @ReportItem(name = "jushoC18", length = 14, order = 256)
    public RString jushoC18;
    @ReportItem(name = "atenaA16", length = 28, order = 257)
    public RString atenaA16;
    @ReportItem(name = "atenaLa16", length = 38, order = 258)
    public RString atenaLa16;
    @ReportItem(name = "atenaA17", length = 28, order = 259)
    public RString atenaA17;
    @ReportItem(name = "atenaLa17", length = 38, order = 260)
    public RString atenaLa17;
    @ReportItem(name = "atenaA18", length = 28, order = 261)
    public RString atenaA18;
    @ReportItem(name = "atenaLa18", length = 38, order = 262)
    public RString atenaLa18;
    @ReportItem(name = "atenaB16", length = 28, order = 263)
    public RString atenaB16;
    @ReportItem(name = "atenaLb16", length = 38, order = 264)
    public RString atenaLb16;
    @ReportItem(name = "atenaB17", length = 28, order = 265)
    public RString atenaB17;
    @ReportItem(name = "atenaLb17", length = 38, order = 266)
    public RString atenaLb17;
    @ReportItem(name = "atenaB18", length = 28, order = 267)
    public RString atenaB18;
    @ReportItem(name = "atenaLb18", length = 38, order = 268)
    public RString atenaLb18;
    @ReportItem(name = "komokuB16", length = 18, order = 269)
    public RString komokuB16;
    @ReportItem(name = "komokuC16", length = 18, order = 270)
    public RString komokuC16;
    @ReportItem(name = "komokuB17", length = 18, order = 271)
    public RString komokuB17;
    @ReportItem(name = "komokuC17", length = 18, order = 272)
    public RString komokuC17;
    @ReportItem(name = "komokuB18", length = 18, order = 273)
    public RString komokuB18;
    @ReportItem(name = "komokuC18", length = 18, order = 274)
    public RString komokuC18;
    @ReportItem(name = "yubinNo19", length = 9, order = 275)
    public RString yubinNo19;
    @ReportItem(name = "komokuA19", length = 18, order = 276)
    public RString komokuA19;
    @ReportItem(name = "yubinNo20", length = 9, order = 277)
    public RString yubinNo20;
    @ReportItem(name = "komokuA20", length = 18, order = 278)
    public RString komokuA20;
    @ReportItem(name = "yubinNo21", length = 9, order = 279)
    public RString yubinNo21;
    @ReportItem(name = "komokuA21", length = 18, order = 280)
    public RString komokuA21;
    @ReportItem(name = "jushoA19", length = 14, order = 281)
    public RString jushoA19;
    @ReportItem(name = "jushoA20", length = 14, order = 282)
    public RString jushoA20;
    @ReportItem(name = "jushoA21", length = 14, order = 283)
    public RString jushoA21;
    @ReportItem(name = "jushoLa19", length = 16, order = 284)
    public RString jushoLa19;
    @ReportItem(name = "jushoLa20", length = 16, order = 285)
    public RString jushoLa20;
    @ReportItem(name = "jushoLa21", length = 16, order = 286)
    public RString jushoLa21;
    @ReportItem(name = "jushoLb19", length = 16, order = 287)
    public RString jushoLb19;
    @ReportItem(name = "jushoLb20", length = 16, order = 288)
    public RString jushoLb20;
    @ReportItem(name = "jushoLb21", length = 16, order = 289)
    public RString jushoLb21;
    @ReportItem(name = "jushoB19", length = 14, order = 290)
    public RString jushoB19;
    @ReportItem(name = "jushoB20", length = 14, order = 291)
    public RString jushoB20;
    @ReportItem(name = "jushoB21", length = 14, order = 292)
    public RString jushoB21;
    @ReportItem(name = "jushoLc19", length = 16, order = 293)
    public RString jushoLc19;
    @ReportItem(name = "jushoLc20", length = 16, order = 294)
    public RString jushoLc20;
    @ReportItem(name = "jushoLc21", length = 16, order = 295)
    public RString jushoLc21;
    @ReportItem(name = "jushoLd19", length = 16, order = 296)
    public RString jushoLd19;
    @ReportItem(name = "jushoC19", length = 14, order = 297)
    public RString jushoC19;
    @ReportItem(name = "jushoLd20", length = 16, order = 298)
    public RString jushoLd20;
    @ReportItem(name = "jushoC20", length = 14, order = 299)
    public RString jushoC20;
    @ReportItem(name = "jushoLd21", length = 16, order = 300)
    public RString jushoLd21;
    @ReportItem(name = "jushoC21", length = 14, order = 301)
    public RString jushoC21;
    @ReportItem(name = "atenaA19", length = 28, order = 302)
    public RString atenaA19;
    @ReportItem(name = "atenaLa19", length = 38, order = 303)
    public RString atenaLa19;
    @ReportItem(name = "atenaA20", length = 28, order = 304)
    public RString atenaA20;
    @ReportItem(name = "atenaLa20", length = 38, order = 305)
    public RString atenaLa20;
    @ReportItem(name = "atenaA21", length = 28, order = 306)
    public RString atenaA21;
    @ReportItem(name = "atenaLa21", length = 38, order = 307)
    public RString atenaLa21;
    @ReportItem(name = "atenaB19", length = 28, order = 308)
    public RString atenaB19;
    @ReportItem(name = "atenaLb19", length = 38, order = 309)
    public RString atenaLb19;
    @ReportItem(name = "atenaB20", length = 28, order = 310)
    public RString atenaB20;
    @ReportItem(name = "atenaLb20", length = 38, order = 311)
    public RString atenaLb20;
    @ReportItem(name = "atenaB21", length = 28, order = 312)
    public RString atenaB21;
    @ReportItem(name = "atenaLb21", length = 38, order = 313)
    public RString atenaLb21;
    @ReportItem(name = "komokuB20", length = 18, order = 314)
    public RString komokuB20;
    @ReportItem(name = "komokuC20", length = 18, order = 315)
    public RString komokuC20;
    @ReportItem(name = "komokuB19", length = 18, order = 316)
    public RString komokuB19;
    @ReportItem(name = "komokuC19", length = 18, order = 317)
    public RString komokuC19;
    @ReportItem(name = "komokuB21", length = 18, order = 318)
    public RString komokuB21;
    @ReportItem(name = "komokuC21", length = 18, order = 319)
    public RString komokuC21;
    @ReportItem(name = "senkyoMei", length = 40, order = 320)
    public RString senkyoMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "barcodeBarcode1", order = 321)
    public RString barcodeBarcode1;
    @ReportItem(name = "barcodeBarcode2", order = 322)
    public RString barcodeBarcode2;
    @ReportItem(name = "barcodeBarcode3", order = 323)
    public RString barcodeBarcode3;
    @ReportItem(name = "barcodeBarcode4", order = 324)
    public RString barcodeBarcode4;
    @ReportItem(name = "barcodeBarcode5", order = 325)
    public RString barcodeBarcode5;
    @ReportItem(name = "barcodeBarcode6", order = 326)
    public RString barcodeBarcode6;
    @ReportItem(name = "barcodeBarcode7", order = 327)
    public RString barcodeBarcode7;
    @ReportItem(name = "barcodeBarcode8", order = 328)
    public RString barcodeBarcode8;
    @ReportItem(name = "barcodeBarcode9", order = 329)
    public RString barcodeBarcode9;
    @ReportItem(name = "barcodeBarcode10", order = 330)
    public RString barcodeBarcode10;
    @ReportItem(name = "barcodeBarcode11", order = 331)
    public RString barcodeBarcode11;
    @ReportItem(name = "barcodeBarcode12", order = 332)
    public RString barcodeBarcode12;
    @ReportItem(name = "barcodeBarcode13", order = 333)
    public RString barcodeBarcode13;
    @ReportItem(name = "barcodeBarcode14", order = 334)
    public RString barcodeBarcode14;
    @ReportItem(name = "barcodeBarcode15", order = 335)
    public RString barcodeBarcode15;
    @ReportItem(name = "barcodeBarcode16", order = 336)
    public RString barcodeBarcode16;
    @ReportItem(name = "barcodeBarcode17", order = 337)
    public RString barcodeBarcode17;
    @ReportItem(name = "barcodeBarcode18", order = 338)
    public RString barcodeBarcode18;
    @ReportItem(name = "barcodeBarcode19", order = 339)
    public RString barcodeBarcode19;
    @ReportItem(name = "barcodeBarcode20", order = 340)
    public RString barcodeBarcode20;
    @ReportItem(name = "barcodeBarcode21", order = 341)
    public RString barcodeBarcode21;
    @ReportItem(name = "shikibetsuCode1", order = 342)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", order = 343)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode3", order = 344)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", order = 345)
    public RString shikibetsuCode4;
    @ReportItem(name = "shikibetsuCode5", order = 346)
    public RString shikibetsuCode5;
    @ReportItem(name = "shikibetsuCode6", order = 347)
    public RString shikibetsuCode6;
    @ReportItem(name = "shikibetsuCode7", order = 348)
    public RString shikibetsuCode7;
    @ReportItem(name = "shikibetsuCode8", order = 349)
    public RString shikibetsuCode8;
    @ReportItem(name = "shikibetsuCode9", order = 350)
    public RString shikibetsuCode9;
    @ReportItem(name = "shikibetsuCode10", order = 351)
    public RString shikibetsuCode10;
    @ReportItem(name = "shikibetsuCode11", order = 352)
    public RString shikibetsuCode11;
    @ReportItem(name = "shikibetsuCode12", order = 353)
    public RString shikibetsuCode12;
    @ReportItem(name = "shikibetsuCode13", order = 354)
    public RString shikibetsuCode13;
    @ReportItem(name = "shikibetsuCode14", order = 355)
    public RString shikibetsuCode14;
    @ReportItem(name = "shikibetsuCode15", order = 356)
    public RString shikibetsuCode15;
    @ReportItem(name = "shikibetsuCode16", order = 357)
    public RString shikibetsuCode16;
    @ReportItem(name = "shikibetsuCode17", order = 358)
    public RString shikibetsuCode17;
    @ReportItem(name = "shikibetsuCode18", order = 359)
    public RString shikibetsuCode18;
    @ReportItem(name = "shikibetsuCode19", order = 360)
    public RString shikibetsuCode19;
    @ReportItem(name = "shikibetsuCode20", order = 361)
    public RString shikibetsuCode20;
    @ReportItem(name = "shikibetsuCode21", order = 362)
    public RString shikibetsuCode21;
    @ReportItem(name = "pageCount", order = 363)
    public Integer pageCount;
    @ReportItem(name = "jushoList1", length = 64, order = 364)
    public RString jushoList1;
    @ReportItem(name = "jushoList2", length = 64, order = 365)
    public RString jushoList2;
    @ReportItem(name = "jushoList3", length = 64, order = 366)
    public RString jushoList3;
    @ReportItem(name = "jushoList4", length = 64, order = 367)
    public RString jushoList4;
    @ReportItem(name = "jushoList5", length = 64, order = 368)
    public RString jushoList5;
    @ReportItem(name = "jushoList6", length = 64, order = 369)
    public RString jushoList6;
    @ReportItem(name = "jushoList7", length = 64, order = 370)
    public RString jushoList7;
    @ReportItem(name = "jushoList8", length = 64, order = 371)
    public RString jushoList8;
    @ReportItem(name = "jushoList9", length = 64, order = 372)
    public RString jushoList9;
    @ReportItem(name = "jushoList10", length = 64, order = 373)
    public RString jushoList10;
    @ReportItem(name = "jushoList11", length = 64, order = 374)
    public RString jushoList11;
    @ReportItem(name = "jushoList12", length = 64, order = 375)
    public RString jushoList12;
    @ReportItem(name = "jushoList13", length = 64, order = 376)
    public RString jushoList13;
    @ReportItem(name = "jushoList14", length = 64, order = 377)
    public RString jushoList14;
    @ReportItem(name = "jushoList15", length = 64, order = 378)
    public RString jushoList15;
    @ReportItem(name = "jushoList16", length = 64, order = 379)
    public RString jushoList16;
    @ReportItem(name = "jushoList17", length = 64, order = 380)
    public RString jushoList17;
    @ReportItem(name = "jushoList18", length = 64, order = 381)
    public RString jushoList18;
    @ReportItem(name = "jushoList19", length = 64, order = 382)
    public RString jushoList19;
    @ReportItem(name = "jushoList20", length = 64, order = 383)
    public RString jushoList20;
    @ReportItem(name = "jushoList21", length = 64, order = 384)
    public RString jushoList21;
    @ReportItem(name = "meishoList1", length = 76, order = 385)
    public RString meishoList1;
    @ReportItem(name = "meishoList2", length = 76, order = 386)
    public RString meishoList2;
    @ReportItem(name = "meishoList3", length = 76, order = 387)
    public RString meishoList3;
    @ReportItem(name = "meishoList4", length = 76, order = 388)
    public RString meishoList4;
    @ReportItem(name = "meishoList5", length = 76, order = 389)
    public RString meishoList5;
    @ReportItem(name = "meishoList6", length = 76, order = 390)
    public RString meishoList6;
    @ReportItem(name = "meishoList7", length = 76, order = 391)
    public RString meishoList7;
    @ReportItem(name = "meishoList8", length = 76, order = 392)
    public RString meishoList8;
    @ReportItem(name = "meishoList9", length = 76, order = 393)
    public RString meishoList9;
    @ReportItem(name = "meishoList10", length = 76, order = 394)
    public RString meishoList10;
    @ReportItem(name = "meishoList11", length = 76, order = 395)
    public RString meishoList11;
    @ReportItem(name = "meishoList12", length = 76, order = 396)
    public RString meishoList12;
    @ReportItem(name = "meishoList13", length = 76, order = 397)
    public RString meishoList13;
    @ReportItem(name = "meishoList14", length = 76, order = 398)
    public RString meishoList14;
    @ReportItem(name = "meishoList15", length = 76, order = 399)
    public RString meishoList15;
    @ReportItem(name = "meishoList16", length = 76, order = 400)
    public RString meishoList16;
    @ReportItem(name = "meishoList17", length = 76, order = 401)
    public RString meishoList17;
    @ReportItem(name = "meishoList18", length = 76, order = 402)
    public RString meishoList18;
    @ReportItem(name = "meishoList19", length = 76, order = 403)
    public RString meishoList19;
    @ReportItem(name = "meishoList20", length = 76, order = 404)
    public RString meishoList20;
    @ReportItem(name = "meishoList21", length = 76, order = 405)
    public RString meishoList21;
    @ReportItem(name = "jushoList", length = 64, order = 406)
    public RString jushoList;
    @ReportItem(name = "meishoList", length = 76, order = 407)
    public RString meishoList;
    @ReportItem(name = "shikibetsuCode_1", order = 408)
    public RString shikibetsuCode_1;
    @ReportItem(name = "shikibetsuCode_2", order = 409)
    public RString shikibetsuCode_2;
    @ReportItem(name = "shikibetsuCode_3", order = 410)
    public RString shikibetsuCode_3;
    @ReportItem(name = "shikibetsuCode_4", order = 411)
    public RString shikibetsuCode_4;
    @ReportItem(name = "shikibetsuCode_5", order = 412)
    public RString shikibetsuCode_5;
    @ReportItem(name = "shikibetsuCode_6", order = 413)
    public RString shikibetsuCode_6;
    @ReportItem(name = "shikibetsuCode_7", order = 414)
    public RString shikibetsuCode_7;
    @ReportItem(name = "shikibetsuCode_8", order = 415)
    public RString shikibetsuCode_8;
    @ReportItem(name = "shikibetsuCode_9", order = 416)
    public RString shikibetsuCode_9;
    @ReportItem(name = "shikibetsuCode_10", order = 417)
    public RString shikibetsuCode_10;
    @ReportItem(name = "shikibetsuCode_11", order = 418)
    public RString shikibetsuCode_11;
    @ReportItem(name = "shikibetsuCode_12", order = 419)
    public RString shikibetsuCode_12;
    @ReportItem(name = "shikibetsuCode_13", order = 420)
    public RString shikibetsuCode_13;
    @ReportItem(name = "shikibetsuCode_14", order = 421)
    public RString shikibetsuCode_14;
    @ReportItem(name = "shikibetsuCode_15", order = 422)
    public RString shikibetsuCode_15;
    @ReportItem(name = "shikibetsuCode_16", order = 423)
    public RString shikibetsuCode_16;
    @ReportItem(name = "shikibetsuCode_17", order = 424)
    public RString shikibetsuCode_17;
    @ReportItem(name = "shikibetsuCode_18", order = 425)
    public RString shikibetsuCode_18;
    @ReportItem(name = "shikibetsuCode_19", order = 426)
    public RString shikibetsuCode_19;
    @ReportItem(name = "shikibetsuCode_20", order = 427)
    public RString shikibetsuCode_20;
    @ReportItem(name = "shikibetsuCode_21", order = 428)
    public RString shikibetsuCode_21;

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
