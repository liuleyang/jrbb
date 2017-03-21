/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />

module AFA {

     export module ShikakuJoho {

        export class Events {

            public static onChange_SenkyoShikaku(): string {
                return "onChange_SenkyoShikaku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikakuJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShikakuJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShikakuJoho.Controls.myType() + "_" + fieldName;
            }

            public ShikakuJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdTohyokuCode(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            }

            public radSenkyoShikaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSenkyoShikaku"));
            }

            public lblTohyoShikakuShurui(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTohyoShikakuShurui"));
            }

            public btnYubin(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnYubin"));
            }

            public btnSenin(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSenin"));
            }

            public btnNankyoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNankyoku"));
            }

            public txtMeiboTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            }

            public ccdMeiboTorokuJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMeiboTorokuJiyu"));
            }

            public txtTorokuTeishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokuTeishiYMD"));
            }

            public ccdTorokuTeishiJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdTorokuTeishiJiyu"));
            }

            public txtMasshoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            }

            public ccdMasshoJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            }

            public txtHyojiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiYMD"));
            }

            public ccdHyojiJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHyojiJiyu"));
            }

            public txtHyojiShojoYoteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiShojoYoteiYMD"));
            }

            public txtHyojiShojoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiShojoYMD"));
            }

            public txtKeikiShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikiShuryoYMD"));
            }

            public chk2keiMochi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk2keiMochi"));
            }

        }

     }

}

