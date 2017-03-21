/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module TohyorokuKyohiNyuryoku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyorokuKyohiNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyorokuKyohiNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyorokuKyohiNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public TohyorokuKyohiNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgTohyorokuKyohiNyuryoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTohyorokuKyohiNyuryoku"));
            }

        }

     }

}

