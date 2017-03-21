/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module KokuminTaishoShohonJoho {

        export class Events {

            public static onClick_radShori(): string {
                return "onClick_radShori";
            }

            public static onBlur_txtTohyoYMD(): string {
                return "onBlur_txtTohyoYMD";
            }

            public static onClick_btnSetYmd(): string {
                return "onClick_btnSetYmd";
            }

            public static onClick_btnSetChohyoYmd(): string {
                return "onClick_btnSetChohyoYmd";
            }

            public static onClick_btnHdnChangeShohon(): string {
                return "onClick_btnHdnChangeShohon";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KokuminTaishoShohonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KokuminTaishoShohonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KokuminTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            }

            public KokuminTaishoShohonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radShori(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShori"));
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public txtShohonName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            }

            public txtTohyoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            }

            public btnSetYmd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSetYmd"));
            }

            public txtKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            }

            public txtMeiboTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            }

            public txtNenreiTotatsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            }

            public txtTokuteiKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTokuteiKigenYMD"));
            }

            public txtTohyoUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoUketsukeYMD"));
            }

            public btnSetChohyoYmd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSetChohyoYmd"));
            }

            public btnHdnChangeShohon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            }

        }

     }

}

