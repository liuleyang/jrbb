/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module ZaigaiKofuRirekiDialog {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ZaigaiKofuRirekiDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ZaigaiKofuRirekiDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ZaigaiKofuRirekiDialog.Controls.myType() + "_" + fieldName;
            }

            public ZaigaiKofuRirekiDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKofuRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKofuRireki"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

