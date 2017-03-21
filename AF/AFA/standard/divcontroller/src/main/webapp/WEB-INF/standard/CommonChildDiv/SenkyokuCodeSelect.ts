/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="SenkyokuCodeSelect_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module SenkyokuCodeSelect {

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

    export module SenkyokuCodeSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSenkyokuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSenkyokuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyokuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyokuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtSenkyokuCode_labelLText() {
                return this.controls.txtSenkyokuCode().labelLText;
            }

            public settxtSenkyokuCode_labelLText(value) {
                this.controls.txtSenkyokuCode().labelLText = value;
            }

            public gettxtSenkyokuCode_labelLWidth() {
                return this.controls.txtSenkyokuCode().labelLWidth;
            }

            public settxtSenkyokuCode_labelLWidth(value) {
                this.controls.txtSenkyokuCode().labelLWidth = value;
            }

            public gettxtSenkyokuCode_required() {
                return this.controls.txtSenkyokuCode().required;
            }

            public settxtSenkyokuCode_required(value) {
                this.controls.txtSenkyokuCode().required = value;
            }

            public getbtnSenkyokuCode_displayNone() {
                return this.controls.btnSenkyokuCode().displayNone;
            }

            public setbtnSenkyokuCode_displayNone(value) {
                this.controls.btnSenkyokuCode().displayNone = value;
            }

            public gettxtSenkyokuName_displayNone() {
                return this.controls.txtSenkyokuName().displayNone;
            }

            public settxtSenkyokuName_displayNone(value) {
                this.controls.txtSenkyokuName().displayNone = value;
            }

            public gettxtSenkyokuName_width() {
                return this.controls.txtSenkyokuName().width;
            }

            public settxtSenkyokuName_width(value) {
                this.controls.txtSenkyokuName().width = value;
            }

            public gettxtSenkyokuCode_readOnly() {
                return this.controls.txtSenkyokuCode().readOnly;
            }

            public settxtSenkyokuCode_readOnly(value) {
                this.controls.txtSenkyokuCode().readOnly = value;
            }

        }
    }
}




