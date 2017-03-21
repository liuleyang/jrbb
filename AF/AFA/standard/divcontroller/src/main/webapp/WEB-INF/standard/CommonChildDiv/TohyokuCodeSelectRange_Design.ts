/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />

module AFA {

     export module TohyokuCodeSelectRange {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyokuCodeSelectRange";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyokuCodeSelectRange.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyokuCodeSelectRange.Controls.myType() + "_" + fieldName;
            }

            public TohyokuCodeSelectRange(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdTohyokuCodeFrom(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCodeFrom"));
            }

            public ccdTohyokuCodeTo(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCodeTo"));
            }

        }

     }

}

