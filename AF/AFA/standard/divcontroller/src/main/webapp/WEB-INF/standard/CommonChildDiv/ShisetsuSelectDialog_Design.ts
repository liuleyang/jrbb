/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module ShisetsuSelectDialog {

        export class Events {

            public static onChange_ddlShisetsuShubetsu(): string {
                return "onChange_ddlShisetsuShubetsu";
            }

            public static onSelectBySelectButton_closeOK(): string {
                return "onSelectBySelectButton_closeOK";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShisetsuSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShisetsuSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlShisetsuShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShisetsuShubetsu"));
            }

            public dgShisetsuSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuSelect"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

