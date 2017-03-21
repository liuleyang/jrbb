/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./SenkyoShuruiSelect.ts" />
/// <reference path="./ShohonNameList.ts" />
/// <reference path="./SenkyokuCodeSelect.ts" />

module AFA {

     export module TasenTaishoShohonJoho {

        export class Events {

            public static onClick_radShori(): string {
                return "onClick_radShori";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TasenTaishoShohonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TasenTaishoShohonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TasenTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            }

            public TasenTaishoShohonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdSenkyoShurui(): AFA.SenkyoShuruiSelect.ModeController {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
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

            public ccdSenkyokuCode(): AFA.SenkyokuCodeSelect.ModeController {
                return new AFA.SenkyokuCodeSelect.ModeController(this.convFiledName("ccdSenkyokuCode"));
            }

        }

     }

}

