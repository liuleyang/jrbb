/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module RyojikanCodeSelect {

        export class Events {

            public static onBlur_txtRyojikanCode(): string {
                return "onBlur_txtRyojikanCode";
            }

            public static onBeforeOpenDialog_checkRyojikanSelect(): string {
                return "onBeforeOpenDialog_checkRyojikanSelect";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RyojikanCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.RyojikanCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.RyojikanCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public RyojikanCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtRyojikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtRyojikanCode"));
            }

            public btnRyojikanCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRyojikanCode"));
            }

            public txtRyojikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRyojikanName"));
            }

        }

     }

}

