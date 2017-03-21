/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module JushoJokenSelect {

        export class Events {

            public static onChange_radJushoJoken(): string {
                return "onChange_radJushoJoken";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushoJokenSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.JushoJokenSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.JushoJokenSelect.Controls.myType() + "_" + fieldName;
            }

            public JushoJokenSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radJushoJoken(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJushoJoken"));
            }

            public dgJushoJokenList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJushoJokenList"));
            }

        }

     }

}

