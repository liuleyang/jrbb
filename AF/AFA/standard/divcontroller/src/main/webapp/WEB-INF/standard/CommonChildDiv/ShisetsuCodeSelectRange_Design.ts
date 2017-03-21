/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./ShisetsuCodeSelect.ts" />
// <reference path="./ShisetsuCodeSelect.ts" />

module AFA {

     export module ShisetsuCodeSelectRange {

        export class Events {

            public static onClick_txtShisetsuCodeFrom(): string {
                return "onClick_txtShisetsuCodeFrom";
            }

            public static onClick_txtShisetsuCodeTo(): string {
                return "onClick_txtShisetsuCodeTo";
            }

            public static onClick_OKCloseFrom(): string {
                return "onClick_OKCloseFrom";
            }

            public static onClick_OKCloseTo(): string {
                return "onClick_OKCloseTo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuCodeSelectRange";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShisetsuCodeSelectRange.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShisetsuCodeSelectRange.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuCodeSelectRange(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdShisetsuCodeFrom(): AFA.ShisetsuCodeSelect.ModeController {
            //    return new AFA.ShisetsuCodeSelect.ModeController(this.convFiledName("ccdShisetsuCodeFrom"));
            //}

            //public ccdShisetsuCodeTo(): AFA.ShisetsuCodeSelect.ModeController {
            //    return new AFA.ShisetsuCodeSelect.ModeController(this.convFiledName("ccdShisetsuCodeTo"));
            //}

            public btnHiddenFrom(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHiddenFrom"));
            }

            public btnHiddenTo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHiddenTo"));
            }

            public btnHiddenOKCloseFrom(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHiddenOKCloseFrom"));
            }

            public btnHiddenOKCloseTo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHiddenOKCloseTo"));
            }

        }

     }

}

