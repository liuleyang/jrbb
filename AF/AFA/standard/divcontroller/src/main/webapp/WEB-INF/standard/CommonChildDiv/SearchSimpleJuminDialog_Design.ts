/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShohonNameList.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="../d.ts/UAXCommonChildDiv.d.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />

module AFA {

     export module SearchSimpleJuminDialog {

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

            public static onSelectByDbClick_dgSearchKekkaList(): string {
                return "onSelectByDbClick_dgSearchKekkaList";
            }

            public static onSelect_dgSearchKekkaList(): string {
                return "onSelect_dgSearchKekkaList";
            }

            public static closeOK(): string {
                return "closeOK";
            }

            public static onClick_btnReSearch(): string {
                return "onClick_btnReSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SearchSimpleJuminDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SearchSimpleJuminDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SearchSimpleJuminDialog.Controls.myType() + "_" + fieldName;
            }

            public SearchSimpleJuminDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SearchSimpleJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchSimpleJoken"));
            }

            public ccdShohonNameList(): AFA.ShohonNameList.ModeController {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            }

            public ccdSearchSimpleJukiJoho(): UAX.AtenaFinder.ModeController {
                return new UAX.AtenaFinder.ModeController(this.convFiledName("ccdSearchSimpleJukiJoho"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public ccdTohyokuCode(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            }

            public chkSearchSenkyoShikaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchSenkyoShikaku"));
            }

            public chkSearchTohyoShikaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchTohyoShikaku"));
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

            public ccdSearchSimpleSaikinShoriTaisho(): URZ.SaikinShorishaRireki.ModeController {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("ccdSearchSimpleSaikinShoriTaisho"));
            }

            public SearchSimpleKekkaList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchSimpleKekkaList"));
            }

            public dgSearchSimpleKekkaList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchSimpleKekkaList"));
            }

            public btnSelect(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelect"));
            }

            public btnReSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReSearch"));
            }

            public btnCancel2(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel2"));
            }

        }

     }

}

