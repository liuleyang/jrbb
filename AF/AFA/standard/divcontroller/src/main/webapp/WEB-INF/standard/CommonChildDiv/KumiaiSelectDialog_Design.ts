/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module KumiaiSelectDialog {

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
                return "KumiaiSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KumiaiSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KumiaiSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public KumiaiSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKumiaiSelect(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKumiaiSelect"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

