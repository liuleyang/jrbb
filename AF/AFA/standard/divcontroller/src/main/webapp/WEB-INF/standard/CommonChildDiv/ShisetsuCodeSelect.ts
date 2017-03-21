/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="ShisetsuCodeSelect_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module ShisetsuCodeSelect {

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

    export module ShisetsuCodeSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtShsietsuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnShisetsuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShisetsuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShisetsuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtShsietsuCode_labelLText() {
                return this.controls.txtShisetsuCode().labelLText;
            }

            public settxtShsietsuCode_labelLText(value) {
                this.controls.txtShisetsuCode().labelLText = value;
            }

            public gettxtShisetsuCode_labelLWidth() {
                return this.controls.txtShisetsuCode().labelLWidth;
            }

            public settxtShisetsuCode_labelLWidth(value) {
                this.controls.txtShisetsuCode().labelLWidth = value;
            }

            public gettxtShisetsuCode_required() {
                return this.controls.txtShisetsuCode().required;
            }

            public settxtShisetsuCode_required(value) {
                this.controls.txtShisetsuCode().required = value;
            }

            public getbtnShisetsuCode_displayNone() {
                return this.controls.btnShisetsuCode().displayNone;
            }

            public setbtnShisetsuCode_displayNone(value) {
                this.controls.btnShisetsuCode().displayNone = value;
            }

            public gettxtShisetsuName_displayNone() {
                return this.controls.txtShisetsuName().displayNone;
            }

            public settxtShisetsuName_displayNone(value) {
                this.controls.txtShisetsuName().displayNone = value;
            }

            public gettxtShisetsuName_width() {
                return this.controls.txtShisetsuName().width;
            }

            public settxtShisetsuName_width(value) {
                this.controls.txtShisetsuName().width = value;
            }

            public gettxtShisetsuCode_labelLAlign() {
                return this.controls.txtShisetsuCode().labelLAlign;
            }

            public settxtShisetsuCode_labelLAlign(value) {
                this.controls.txtShisetsuCode().labelLAlign = value;
            }

        }
    }
}




