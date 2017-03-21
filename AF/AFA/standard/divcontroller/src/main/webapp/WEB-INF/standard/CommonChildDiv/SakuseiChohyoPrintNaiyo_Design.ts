/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./HakkoBango.ts" />

module AFA {

     export module SakuseiChohyoPrintNaiyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SakuseiChohyoPrintNaiyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SakuseiChohyoPrintNaiyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SakuseiChohyoPrintNaiyo.Controls.myType() + "_" + fieldName;
            }

            public SakuseiChohyoPrintNaiyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHakkoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoYMD"));
            }

            public ccdHakkoBango(): AFA.HakkoBango.ModeController {
                return new AFA.HakkoBango.ModeController(this.convFiledName("ccdHakkoBango"));
            }

            public txtIinchoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIinchoName"));
            }

        }

     }

}

