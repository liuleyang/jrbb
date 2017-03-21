/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module HojoshaSelectDialog {

        export class Events {

            public static onSelectBySelectButton(): string {
                return "onSelectBySelectButton";
            }

            public static cancel(): string {
                return "cancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HojoshaSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.HojoshaSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.HojoshaSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public HojoshaSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonName(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonName"));
            }

            public dgHojoshaSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHojoshaSelect"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

