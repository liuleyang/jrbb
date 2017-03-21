/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module ShisetsuCodeSelect {

        export class Events {

            public static onBlur_txtShisetsuCode(): string {
                return "onBlur_txtShisetsuCode";
            }

            public static onChange_txtShisetsuCode(): string {
                return "onChange_txtShisetsuCode";
            }

            public static onOKClose_btnShisetsuCode(): string {
                return "onOKClose_btnShisetsuCode";
            }

            public static onBeforeOpenDialog_btnShisetsuCode(): string {
                return "onBeforeOpenDialog_btnShisetsuCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShisetsuCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShisetsuCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShisetsuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            }

            public btnShisetsuCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShisetsuCode"));
            }

            public txtShisetsuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShisetsuName"));
            }

        }

     }

}

