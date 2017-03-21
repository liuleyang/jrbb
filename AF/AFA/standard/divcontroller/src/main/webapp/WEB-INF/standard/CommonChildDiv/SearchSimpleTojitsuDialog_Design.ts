/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="./MeiboBango.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module AFA {

     export module SearchSimpleTojitsuDialog {

        export class Events {

            public static CloseCancel(): string {
                return "CloseCancel";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onClick_btnSearch(): string {
                return "onClick_btnSearch";
            }

            public static onSelect_dgSearchKekkaList(): string {
                return "onSelect_dgSearchKekkaList";
            }

            public static onClick_btnReSearch(): string {
                return "onClick_btnReSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SearchSimpleTojitsuDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SearchSimpleTojitsuDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SearchSimpleTojitsuDialog.Controls.myType() + "_" + fieldName;
            }

            public SearchSimpleTojitsuDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SearchTojitsuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchTojitsuJoken"));
            }

            public ccdShohon(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohon"));
            }

            public lin3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            }

            public txtMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtMeisho"));
            }

            public ddlMeishoKensaku(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlMeishoKensaku"));
            }

            public txtSeinengappi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeinengappi"));
            }

            public txtSeibetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("txtSeibetsu"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public ccdTohyokuCode(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            }

            public ccdMeiboBango(): AFA.MeiboBango.ModeController {
                return new AFA.MeiboBango.ModeController(this.convFiledName("ccdMeiboBango"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            }

            public txtMaxDisplayCount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxDisplayCount"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearch"));
            }

            public ccdSearchTojitsuSaikinShoriTaisho(): URZ.SaikinShorishaRireki.ModeController {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("ccdSearchTojitsuSaikinShoriTaisho"));
            }

            public SearchTojitsuKekkaList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchTojitsuKekkaList"));
            }

            public dgSearchTojitsuKekkaList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchTojitsuKekkaList"));
            }

            public btnCancel2(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel2"));
            }

            public btnReSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReSearch"));
            }

        }

     }

}

