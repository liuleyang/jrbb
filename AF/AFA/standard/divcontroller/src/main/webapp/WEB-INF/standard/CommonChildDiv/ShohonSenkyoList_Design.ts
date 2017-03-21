/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module ShohonSenkyoList {

        export class Events {

            public static onChange_checkbox(): string {
                return "onChange_checkbox";
            }

            public static onClick_btnHdnChangeShohon(): string {
                return "onClick_btnHdnChangeShohon";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShohonSenkyoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShohonSenkyoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShohonSenkyoList.Controls.myType() + "_" + fieldName;
            }

            public ShohonSenkyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public chkMutohyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMutohyo"));
            }

            public btnHdnChangeShohon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            }

            public dgSenkyoList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSenkyoList"));
            }

        }

     }

}

