/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./MeiboBango.ts" />

module AFA {

     export module JotaiHenkoDialog {

        export class Events {

            public static onClick_btnOk(): string {
                return "onClick_btnOk";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JotaiHenkoDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.JotaiHenkoDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.JotaiHenkoDialog.Controls.myType() + "_" + fieldName;
            }

            public JotaiHenkoDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtShikibetsuCode"));
            }

            public txtShimei(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShimei"));
            }

            public txtSetaiCode(): UZA.TextBoxSetaiCode {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtSetaiCode"));
            }

            public txtGroupCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGroupCode"));
            }

            public txtTohyokuCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyokuCode"));
            }

            public ccdMeiboBango(): AFA.MeiboBango.ModeController {
                return new AFA.MeiboBango.ModeController(this.convFiledName("ccdMeiboBango"));
            }

            public linLine(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine"));
            }

            public lblNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNo"));
            }

            public lblSenkyoMei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSenkyoMei"));
            }

            public lblTohyoJokyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTohyoJokyo"));
            }

            public txtNo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo1"));
            }

            public txtSenkyoMei1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei1"));
            }

            public txtTohyoJokyo1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo1"));
            }

            public ddlTohyoJokyo1(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo1"));
            }

            public LabelTohyoJokyo1(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo1"));
            }

            public txtNo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo2"));
            }

            public txtSenkyoMei2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei2"));
            }

            public txtTohyoJokyo2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo2"));
            }

            public ddlTohyoJokyo2(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo2"));
            }

            public LabelTohyoJokyo2(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo2"));
            }

            public txtNo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo3"));
            }

            public txtSenkyoMei3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei3"));
            }

            public txtTohyoJokyo3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo3"));
            }

            public ddlTohyoJokyo3(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo3"));
            }

            public LabelTohyoJokyo3(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo3"));
            }

            public txtNo4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo4"));
            }

            public txtSenkyoMei4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei4"));
            }

            public txtTohyoJokyo4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo4"));
            }

            public ddlTohyoJokyo4(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo4"));
            }

            public LabelTohyoJokyo4(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo4"));
            }

            public txtNo5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo5"));
            }

            public txtSenkyoMei5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei5"));
            }

            public txtTohyoJokyo5(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo5"));
            }

            public ddlTohyoJokyo5(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo5"));
            }

            public LabelTohyoJokyo5(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo5"));
            }

            public txtNo6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo6"));
            }

            public txtSenkyoMei6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei6"));
            }

            public txtTohyoJokyo6(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo6"));
            }

            public ddlTohyoJokyo6(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo6"));
            }

            public LabelTohyoJokyo6(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo6"));
            }

            public txtNo7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo7"));
            }

            public txtSenkyoMei7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei7"));
            }

            public txtTohyoJokyo7(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo7"));
            }

            public ddlTohyoJokyo7(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo7"));
            }

            public LabelTohyoJokyo7(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo7"));
            }

            public txtNo8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo8"));
            }

            public txtSenkyoMei8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei8"));
            }

            public txtTohyoJokyo8(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo8"));
            }

            public ddlTohyoJokyo8(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo8"));
            }

            public LabelTohyoJokyo8(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo8"));
            }

            public txtNo9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNo9"));
            }

            public txtSenkyoMei9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei9"));
            }

            public txtTohyoJokyo9(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo9"));
            }

            public ddlTohyoJokyo9(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo9"));
            }

            public LabelTohyoJokyo9(): UZA.Label {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo9"));
            }

            public btnOK(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOK"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

