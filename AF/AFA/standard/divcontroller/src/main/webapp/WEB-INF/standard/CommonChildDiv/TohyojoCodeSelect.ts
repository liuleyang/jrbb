/// <reference path='TohyojoCodeSelect_Design.ts' />
module AFA
{
    export module TohyojoCodeSelect
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        }
    }
}

module AFA
{
    export module TohyojoCodeSelect
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyojoCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnTohyojoCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtTohyojoCode_labelLText() {
                return this.controls.txtTohyojoCode().labelLText;
            }

            public settxtTohyojoCode_labelLText(value) {
                this.controls.txtTohyojoCode().labelLText = value;
            }

            public gettxtTohyojoCode_labelLWidth() {
                return this.controls.txtTohyojoCode().labelLWidth;
            }

            public settxtTohyojoCode_labelLWidth(value) {
                this.controls.txtTohyojoCode().labelLWidth = value;
            }

            public gettxtTohyojoCode_required() {
                return this.controls.txtTohyojoCode().required;
            }

            public settxtTohyojoCode_required(value) {
                this.controls.txtTohyojoCode().required = value;
            }

            public getbtnTohyojoCode_displayNone() {
                return this.controls.btnTohyojoCode().displayNone;
            }

            public setbtnTohyojoCode_displayNone(value) {
                this.controls.btnTohyojoCode().displayNone = value;
            }

            public gettxtTohyojoName_displayNone() {
                return this.controls.txtTohyojoName().displayNone;
            }

            public settxtTohyojoName_displayNone(value) {
                this.controls.txtTohyojoName().displayNone = value;
            }

            public gettxtTohyojoName_width() {
                return this.controls.txtTohyojoName().width;
            }

            public settxtTohyojoName_width(value) {
                this.controls.txtTohyojoName().width = value;
            }

            public gettxtTohyojoCode_readOnly() {
                return this.controls.txtTohyojoCode().readOnly;
            }

            public settxtTohyojoCode_readOnly(value) {
                this.controls.txtTohyojoCode().readOnly = value;
            }

            public gettxtTohyojoCode_labelLAlign() {
                return this.controls.txtTohyojoCode().labelLAlign;
            }

            public settxtTohyojoCode_labelLAlign(value) {
                this.controls.txtTohyojoCode().labelLAlign = value;
            }

        }
    }
}

