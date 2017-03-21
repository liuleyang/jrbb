/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module BarCodeNyuryoku {

        export class Events {

            public static onChange_txtBarCode(): string {
                return "onChange_txtBarCode";
            }

            public static onBlur_txtBarCode(): string {
                return "onBlur_txtBarCode";
            }

            public static onClick_btnBarCode(): string {
                return "onClick_btnBarCode";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "BarCodeNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.BarCodeNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.BarCodeNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public BarCodeNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtBarCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBarCode"));
            }

            public btnBarCode(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBarCode"));
            }

            public length(): UZA.Label {
                return new UZA.Label(this.convFiledName("length"));
            }

        }

     }

}

