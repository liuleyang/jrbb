/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./JiyuNameList.ts" />

module AFA {

     export module FuzaishaShikaku {

        export class Events {

            public static onChange_btnRadShikakuKubun(): string {
                return "onChange_btnRadShikakuKubun";
            }

            public static onBlur_txtKofuYMD(): string {
                return "onBlur_txtKofuYMD";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "FuzaishaShikaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.FuzaishaShikaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.FuzaishaShikaku.Controls.myType() + "_" + fieldName;
            }

            public FuzaishaShikaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radShikakuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShikakuKubun"));
            }

            public txtShikakuTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShikakuTorokuYMD"));
            }

            public txtKofuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            }

            public txtManryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtManryoYMD"));
            }

            public txtMasshoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            }

            public ccdMasshoJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

