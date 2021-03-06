/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module KaikuTaishoShohonJoho {

        export class Events {

            public static onChange_radShori(): string {
                return "onChange_radShori";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaikuTaishoShohonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KaikuTaishoShohonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KaikuTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            }

            public KaikuTaishoShohonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShiyoShohon(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiyoShohon"));
            }

            public radShori(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShori"));
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public txtShohonName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            }

            public txtSenkyoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoName"));
            }

            public txtKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            }

            public txtTohyoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            }

            public txtTohyoUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoUketsukeYMD"));
            }

            public chkMutohyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMutohyo"));
            }

        }

     }

}

