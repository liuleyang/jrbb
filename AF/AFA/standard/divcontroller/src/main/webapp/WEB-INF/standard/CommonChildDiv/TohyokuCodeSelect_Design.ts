/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module TohyokuCodeSelect {

        export class Events {

            public static onBlur_txtTohyokuCode(): string {
                return "onBlur_txtTohyokuCode";
            }

            public static onOkClose_txtTohyokuCode(): string {
                return "onOkClose_txtTohyokuCode";
            }

            public static onBeforeOpenDialog_btnTohyokuCode(): string {
                return "onBeforeOpenDialog_btnTohyokuCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyokuCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyokuCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyokuCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public TohyokuCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTohyokuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyokuCode"));
            }

            public btnTohyokuCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTohyokuCode"));
            }

            public txtTohyokuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyokuName"));
            }

            public txtTohyokuCodeDomain(): UZA.TextBoxTohyokuCode {
                return new UZA.TextBoxTohyokuCode(this.convFiledName("txtTohyokuCodeDomain"));
            }

        }

     }

}

