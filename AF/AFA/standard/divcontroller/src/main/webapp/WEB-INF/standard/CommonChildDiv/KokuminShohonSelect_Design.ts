/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module KokuminShohonSelect {

        export class Events {

            public static onSelect_dgIdoSearchKekkaList(): string {
                return "onSelect_dgIdoSearchKekkaList";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KokuminShohonSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KokuminShohonSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KokuminShohonSelect.Controls.myType() + "_" + fieldName;
            }

            public KokuminShohonSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKokuminShohon(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKokuminShohon"));
            }

        }

     }

}

