/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module ShohonSelect {

        export class Events {

            public static onClick_btnHdnChangeShohon(): string {
                return "onClick_btnHdnChangeShohon";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShohonSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShohonSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShohonSelect.Controls.myType() + "_" + fieldName;
            }

            public ShohonSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public txtTohyoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            }

            public txtPrintJotai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtPrintJotai"));
            }

            public btnHdnChangeShohon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            }

            public dgShohonSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShohonSelect"));
            }

        }

     }

}

