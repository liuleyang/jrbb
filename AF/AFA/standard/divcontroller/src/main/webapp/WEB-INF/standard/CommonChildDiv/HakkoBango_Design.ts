/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module HakkoBango {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HakkoBango";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.HakkoBango.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.HakkoBango.Controls.myType() + "_" + fieldName;
            }

            public HakkoBango(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHakkoNoDai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoDai"));
            }

            public txtHakkoNoBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoBango"));
            }

            public txtHakkoNoGo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoGo"));
            }

        }

     }

}

