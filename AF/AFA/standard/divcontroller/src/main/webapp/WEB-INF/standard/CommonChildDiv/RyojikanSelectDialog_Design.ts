/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module RyojikanSelectDialog {

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
                return "RyojikanSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.RyojikanSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.RyojikanSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public RyojikanSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgRyojikanSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRyojikanSelect"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

