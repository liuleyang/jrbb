/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />
/// <reference path="./KumiaiCodeSelect.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module AFA {

     export module KaikuFuzuiJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaikuFuzuiJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KaikuFuzuiJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KaikuFuzuiJoho.Controls.myType() + "_" + fieldName;
            }

            public KaikuFuzuiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public txtGyogyoshaBango(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoshaBango"));
            }

            public ccdGyogyoKumiaiCode(): AFA.KumiaiCodeSelect.ModeController {
                return new AFA.KumiaiCodeSelect.ModeController(this.convFiledName("ccdGyogyoKumiaiCode"));
            }

            public lblGyogyoNissu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGyogyoNissu"));
            }

            public txtGyogyoshaNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoshaNissu"));
            }

            public txtGyogyoJujishaNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoJujishaNissu"));
            }

            public ccdGyogyoShurui(): URZ.CodeInput.ModeController {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdGyogyoShurui"));
            }

            public ccdGyosenShubetsu(): URZ.CodeInput.ModeController {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdGyosenShubetsu"));
            }

            public txtSenmei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenmei"));
            }

            public txtTorokuBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuBango"));
            }

        }

     }

}

