/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />
/// <reference path="../d.ts/URACommonChildDiv.d.ts" />

module AFA {

     export module ZaigaiMeiboJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ZaigaiMeiboJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ZaigaiMeiboJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ZaigaiMeiboJoho.Controls.myType() + "_" + fieldName;
            }

            public ZaigaiMeiboJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public radZaigaiShikaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZaigaiShikaku"));
            }

            public ccdTohyokuCode(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            }

            public txtTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokuYMD"));
            }

            public txtHyojiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiYMD"));
            }

            public ccdHyojiJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHyojiJiyu"));
            }

            public lblJusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblJusho"));
            }

            public ccdKokunaiTennyuJusho(): URZ.ZenkokuJushoInput.ModeController {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdKokunaiTennyuJusho"));
            }

            public ccdKokunaiTennyuBanchi(): URA.BanchiInput.ModeController {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdKokunaiTennyuBanchi"));
            }

            public ccdKokunaiTennyuKatagaki(): URA.KatagakiInput.ModeController {
                return new URA.KatagakiInput.ModeController(this.convFiledName("ccdKokunaiTennyuKatagaki"));
            }

            public txtKokunaiTennyuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKokunaiTennyuYMD"));
            }

            public txtMasshoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            }

            public ccdMasshoJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            }

            public txtShuseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShuseiYMD"));
            }

            public txtBiko(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            }

        }

     }

}

