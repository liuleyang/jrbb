/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module MeiboBango {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "MeiboBango";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.MeiboBango.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.MeiboBango.Controls.myType() + "_" + fieldName;
            }

            public MeiboBango(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSatsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSatsu"));
            }

            public txtPage(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtPage"));
            }

            public txtGyo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGyo"));
            }

        }

     }

}

