/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="JiyuNameList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module JiyuNameList {

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
        }

    }
}



module AFA {

    export module JiyuNameList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlJiyuName_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlJiyuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlJiyuName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_isBlankLine", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getddlJiyuName_disabled() {
                return this.controls.ddlJiyuName().disabled;
            }

            public setddlJiyuName_disabled(value) {
                this.controls.ddlJiyuName().disabled = value;
            }

            public getddlJiyuName_width() {
                return this.controls.ddlJiyuName().width;
            }

            public setddlJiyuName_width(value) {
                this.controls.ddlJiyuName().width = value;
            }

            public getddlJiyuName_required() {
                return this.controls.ddlJiyuName().required;
            }

            public setddlJiyuName_required(value) {
                this.controls.ddlJiyuName().required = value;
            }

            public getddlJiyuName_labelLText() {
                return this.controls.ddlJiyuName().labelLText;
            }

            public setddlJiyuName_labelLText(value) {
                this.controls.ddlJiyuName().labelLText = value;
            }

            public getddlJiyuName_labelLWidth() {
                return this.controls.ddlJiyuName().labelLWidth;
            }

            public setddlJiyuName_labelLWidth(value) {
                this.controls.ddlJiyuName().labelLWidth = value;
            }

            public getddlJiyuName_isBlankLine() {
                return this.controls.ddlJiyuName().isBlankLine;
            }

            public setddlJiyuName_isBlankLine(value) {
                this.controls.ddlJiyuName().isBlankLine = value;
            }

        }
    }
}




