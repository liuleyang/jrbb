/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module KumiaiCodeSelect {

        export class Events {

            public static onBlur_txtSenkyokuCode(): string {
                return "onBlur_txtSenkyokuCode";
            }

            public static onBeforeOpenDialog_checkBtnKumiaiCode(): string {
                return "onBeforeOpenDialog_checkBtnKumiaiCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KumiaiCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KumiaiCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KumiaiCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public KumiaiCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKumiaiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKumiaiCode"));
            }

            public btnKumiaiCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKumiaiCode"));
            }

            public txtKumiaiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKumiaiName"));
            }

        }

     }

}

