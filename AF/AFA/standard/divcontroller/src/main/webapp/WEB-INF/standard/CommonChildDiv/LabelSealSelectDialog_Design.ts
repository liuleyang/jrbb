/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./LabelSealPrintTaisho.ts" />
/// <reference path="../d.ts/UAXCommonChildDiv.d.ts" />

module AFA {

     export module LabelSealSelectDialog {

        export class Events {

            public static onClick_btnPrint(): string {
                return "onClick_btnPrint";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "LabelSealSelectDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.LabelSealSelectDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.LabelSealSelectDialog.Controls.myType() + "_" + fieldName;
            }

            public LabelSealSelectDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdLabelSealPrintTaisho(): AFA.LabelSealPrintTaisho.ModeController {
                return new AFA.LabelSealPrintTaisho.ModeController(this.convFiledName("ccdLabelSealPrintTaisho"));
            }

            public ccdSealPosition(): UAX.AtenaSealPositionGuide.ModeController {
                return new UAX.AtenaSealPositionGuide.ModeController(this.convFiledName("ccdSealPosition"));
            }

            public btnPrint(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnPrint"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

