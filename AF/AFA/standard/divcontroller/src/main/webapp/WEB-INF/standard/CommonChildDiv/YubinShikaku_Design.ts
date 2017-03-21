/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./JiyuNameList.ts" />

module AFA {

     export module YubinShikaku {

        export class Events {

            public static onChange_radShikakuKubun(): string {
                return "onChange_radShikakuKubun";
            }

            public static onBlur_txtKofuYMD(): string {
                return "onBlur_txtKofuYMD";
            }

            public static onOkClose_btnSearchSimple(): string {
                return "onOkClose_btnSearchSimple";
            }

            public static onBeforeOpenDialog_btnSearchSimple(): string {
                return "onBeforeOpenDialog_btnSearchSimple";
            }

            public static onClick_btnDirectInput(): string {
                return "onClick_btnDirectInput";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onBlur_txtDairiSeinengappiYMD(): string {
                return "onBlur_txtDairiSeinengappiYMD";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YubinShikaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.YubinShikaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.YubinShikaku.Controls.myType() + "_" + fieldName;
            }

            public YubinShikaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radShikakuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShikakuKubun"));
            }

            public chkShikakuJoken(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShikakuJoken"));
            }

            public txtShikakuTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShikakuTorokuYMD"));
            }

            public txtKofuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            }

            public txtKofuNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofuNo"));
            }

            public btnSaiban(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaiban"));
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

            public linLine(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine"));
            }

            public lblKisaisha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKisaisha"));
            }

            public btnSearchSimple(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSearchSimple"));
            }

            public btnDirectInput(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDirectInput"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public txtDairiKanjiShimei(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtDairiKanjiShimei"));
            }

            public txtDairiSeinengappiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtDairiSeinengappiYMD"));
            }

            public txtDairiNenrei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDairiNenrei"));
            }

            public ddlDairiSeibetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlDairiSeibetsu"));
            }

            public txtDairiJuminShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDairiJuminShubetsu"));
            }

            public txtDairiKanaShimei(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtDairiKanaShimei"));
            }

            public txtDairiShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtDairiShikibetsuCode"));
            }

            public txtDairiSetaiCode(): UZA.TextBoxSetaiCode {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtDairiSetaiCode"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtDairiJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtDairiJusho"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

