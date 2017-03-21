/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="../d.ts/UAXCommonChildDiv.d.ts" />

module AFA {

     export module KojinJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KojinJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KojinJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KojinJoho.Controls.myType() + "_" + fieldName;
            }

            public KojinJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdKojinJohoUR(): UAX.AtenaShokaiSimple.ModeController {
                return new UAX.AtenaShokaiSimple.ModeController(this.convFiledName("ccdKojinJohoUR"));
            }

        }

     }

}

