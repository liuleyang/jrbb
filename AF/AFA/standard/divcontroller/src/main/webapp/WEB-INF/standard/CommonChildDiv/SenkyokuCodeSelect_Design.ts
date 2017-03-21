/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module SenkyokuCodeSelect {

        export class Events {

            public static onBlur_txtSenkyokuCode(): string {
                return "onBlur_txtSenkyokuCode";
            }

            public static onClick_btnDialog(): string {
                return "onClick_btnDialog";
            }

            public static onBeforeClick_btnDialog(): string {
                return "onBeforeClick_btnDialog";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SenkyokuCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SenkyokuCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SenkyokuCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public SenkyokuCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSenkyokuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSenkyokuCode"));
            }

            public btnSenkyokuCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSenkyokuCode"));
            }

            public txtSenkyokuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyokuName"));
            }

        }

     }

}

