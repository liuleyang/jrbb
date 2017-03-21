/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="ShohonNameList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module ShohonNameList {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return [];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new AFA.ShohonNameList.PublicProperties(this.fieldName);
            }

            public KakoHyojiCheckBoxSelected() {
                return new Modes.KakoHyojiCheckBoxSelected(this.controls);
            }
        }

        export module Modes {
            // 過去分も含めるチェックボックスの選択・非選択定義
            export class KakoHyojiCheckBoxSelected {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 選択する(): void {
                    this.controls.chkKakoShohon().selectedItem = "key0";
                }

                public 選択しない(): void {
                    this.controls.chkKakoShohon().selectedItem = "";
                }
            }
        }

    }
}



module AFA {

    export module ShohonNameList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlShohon_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlShohon_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlShohon_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlShohon_labelWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlShohon_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("chkKakoShohon_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                //editTypes.addEditType("chkKakoShohon_selectedItems", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getddlShohon_disabled() {
                return this.controls.ddlShohon().disabled;
            }

            public setddlShohon_disabled(value) {
                this.controls.ddlShohon().disabled = value;
            }

            public getddlShohon_required() {
                return this.controls.ddlShohon().required;
            }

            public setddlShohon_required(value) {
                this.controls.ddlShohon().required = value;
            }

            public getddlShohon_labelText() {
                return this.controls.ddlShohon().labelLText;
            }

            public setddlShohon_labelText(value) {
                this.controls.ddlShohon().labelLText = value;
            }

            public getddlShohon_labelWidth() {
                return this.controls.ddlShohon().labelLWidth;
            }

            public setddlShohon_labelWidth(value) {
                this.controls.ddlShohon().labelLWidth = value;
            }

            public getddlShohon_width() {
                return this.controls.ddlShohon().width;
            }

            public setddlShohon_width(value) {
                this.controls.ddlShohon().width = value;
            }

            public getchkKakoShohon_displayNone() {
                return this.controls.chkKakoShohon().displayNone;
            }

            public setchkKakoShohon_displayNone(value) {
                this.controls.chkKakoShohon().displayNone = value;
            }

            //public getchkKakoShohon_selectedItems() {
            //    return this.controls.chkKakoShohon().selectedItems;
            //}

            //public setchkKakoShohon_selectedItems(value) {
            //    this.controls.chkKakoShohon().selectedItems = value;
            //}

        }
    }
}




