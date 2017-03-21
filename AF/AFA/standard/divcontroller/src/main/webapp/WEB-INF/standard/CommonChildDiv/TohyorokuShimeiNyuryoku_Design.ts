/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module TohyorokuShimeiNyuryoku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyorokuShimeiNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyorokuShimeiNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyorokuShimeiNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public TohyorokuShimeiNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgTohyorokuShimeiNyuryoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTohyorokuShimeiNyuryoku"));
            }

        }

     }

}

