/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />

module AFA {

     export module MeiboSakuseiKijun {

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

            public static onClick_btnAddRowSenkyo(): string {
                return "onClick_btnAddRowSenkyo";
            }

            public static onClick_btnCopySenkyo(): string {
                return "onClick_btnCopySenkyo";
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
                return "MeiboSakuseiKijun";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.MeiboSakuseiKijun.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.MeiboSakuseiKijun.Controls.myType() + "_" + fieldName;
            }

            public MeiboSakuseiKijun(): UZA.Panel {
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

            public txtKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            }

            public btnSetYmd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSetYmd"));
            }

            public txtMeiboTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            }

            public txtTenshutsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuYMD"));
            }

            public lblTenshutsuYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTenshutsuYMD"));
            }

            public txtTennyuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTennyuYMD"));
            }

            public lblTennyuYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTennyuYMD"));
            }

            public txtNenreiTotatsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            }

            public lblNenreiTotatsuYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNenreiTotatsuYMD"));
            }

            public SenkyoNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SenkyoNyuryoku"));
            }

            public btnAddRowSenkyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddRowSenkyo"));
            }

            public btnCopySenkyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCopySenkyo"));
            }

            public chkKenshuDataCreate(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKenshuDataCreate"));
            }

            public dgSenkyojiSenkyoNyuryoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSenkyojiSenkyoNyuryoku"));
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

