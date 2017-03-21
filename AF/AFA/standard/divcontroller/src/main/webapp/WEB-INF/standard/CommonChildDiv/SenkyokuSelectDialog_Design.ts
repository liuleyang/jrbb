/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./SenkyoShuruiSelect.ts" />

module AFA {

     export module SenkyokuSelectDialog {

        export class Events {

            public static onSelectBySelectButton_closeOK(): string {
                return "onSelectBySelectButton_closeOK";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SenkyokuSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SenkyokuSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SenkyokuSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public SenkyokuSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdSenkyoShurui(): AFA.SenkyoShuruiSelect.ModeController {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
            }

            public dgSenkyokuSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSenkyokuSelect"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

