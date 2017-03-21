/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./SenkyoShuruiSelect.ts" />
/// <reference path="./SenkyokuCodeSelect.ts" />

module AFA {

     export module SenkyokuTanmatsuInputDialog {

        export class Events {

            public static onClick_btnAddTanmatsu(): string {
                return "onClick_btnAddTanmatsu";
            }

            public static onClick_btnSakujo(): string {
                return "onClick_btnSakujo";
            }

            public static onClick_btnKoshi(): string {
                return "onClick_btnKoshi";
            }

            public static onClick_btnTorikeshi(): string {
                return "onClick_btnTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SenkyokuTanmatsuInputDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SenkyokuTanmatsuInputDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SenkyokuTanmatsuInputDialog.Controls.myType() + "_" + fieldName;
            }

            public SenkyokuTanmatsuInputDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdSenkyoShurui(): AFA.SenkyoShuruiSelect.ModeController {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
            }

            public ccdSenkyokuCode(): AFA.SenkyokuCodeSelect.ModeController {
                return new AFA.SenkyokuCodeSelect.ModeController(this.convFiledName("ccdSenkyokuCode"));
            }

            public btnAddRow(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddRow"));
            }

            public dgSenkyokuTanmatsuInput(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSenkyokuTanmatsuInput"));
            }

            public btnUpdate(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

