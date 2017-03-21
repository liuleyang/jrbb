/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module TohyojoCodeSelect {

        export class Events {

            public static onBlur_txtTohyojoCode(): string {
                return "onBlur_txtTohyojoCode";
            }

            public static onOKClose_btnTohyojoCode(): string {
                return "onOKClose_btnTohyojoCode";
            }

            public static onBeforeOpenDialog_btnTohyojoCode(): string {
                return "onBeforeOpenDialog_btnTohyojoCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyojoCodeSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyojoCodeSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyojoCodeSelect.Controls.myType() + "_" + fieldName;
            }

            public TohyojoCodeSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTohyojoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyojoCode"));
            }

            public btnTohyojoCode(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTohyojoCode"));
            }

            public txtTohyojoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyojoName"));
            }

        }

     }

}

