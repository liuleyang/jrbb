/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="TohyokuCodeSelect_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module TohyokuCodeSelect {

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
                return new AFA.TohyokuCodeSelect.PublicProperties(this.fieldName);
            }
        }

    }
}



module AFA {

    export module TohyokuCodeSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyokuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnTohyokuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtTohyokuCode_labelLText() {
                return this.controls.txtTohyokuCode().labelLText;
            }

            public settxtTohyokuCode_labelLText(value) {
                this.controls.txtTohyokuCode().labelLText = value;
            }

            public gettxtTohyokuCode_labelLWidth() {
                return this.controls.txtTohyokuCode().labelLWidth;
            }

            public settxtTohyokuCode_labelLWidth(value) {
                this.controls.txtTohyokuCode().labelLWidth = value;
            }

            public gettxtTohyokuCode_required() {
                return this.controls.txtTohyokuCode().required;
            }

            public settxtTohyokuCode_required(value) {
                this.controls.txtTohyokuCode().required = value;
            }

            public getbtnTohyokuCode_displayNone() {
                return this.controls.btnTohyokuCode().displayNone;
            }

            public setbtnTohyokuCode_displayNone(value) {
                this.controls.btnTohyokuCode().displayNone = value;
            }

            public gettxtTohyokuName_displayNone() {
                return this.controls.txtTohyokuName().displayNone;
            }

            public settxtTohyokuName_displayNone(value) {
                this.controls.txtTohyokuName().displayNone = value;
            }

            public gettxtTohyokuName_width() {
                return this.controls.txtTohyokuName().width;
            }

            public settxtTohyokuName_width(value) {
                this.controls.txtTohyokuName().width = value;
            }

            public gettxtTohyokuCode_readOnly() {
                return this.controls.txtTohyokuCode().readOnly;
            }

            public settxtTohyokuCode_readOnly(value) {
                this.controls.txtTohyokuCode().readOnly = value;
            }

            public gettxtTohyokuCode_labelLAlign() {
                return this.controls.txtTohyokuCode().labelLAlign;
            }

            public settxtTohyokuCode_labelLAlign(value) {
                this.controls.txtTohyokuCode().labelLAlign = value;
            }

        }
    }
}




