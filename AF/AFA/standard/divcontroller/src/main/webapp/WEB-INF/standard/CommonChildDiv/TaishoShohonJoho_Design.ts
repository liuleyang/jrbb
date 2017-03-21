/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module TaishoShohonJoho {

        export class Events {

            public static onClick_btnHdnChangeShohon(): string {
                return "onClick_btnHdnChangeShohon";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TaishoShohonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TaishoShohonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TaishoShohonJoho.Controls.myType() + "_" + fieldName;
            }

            public TaishoShohonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public txtShohonName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            }

            public txtKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            }

            public txtTohyoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            }

            public txtMeiboTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            }

            public txtNenreiTotatsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            }

            public txtTenshutsuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuKigenYMD"));
            }

            public txtTennyuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTennyuKigenYMD"));
            }

            public btnHdnChangeShohon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            }

        }

     }

}

