/// <reference path='KumiaiCodeSelect_Design.ts' />
module AFA
{
    export module KumiaiCodeSelect
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
        }
    }
}



module AFA {

    export module KumiaiCodeSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtKumiaiCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnKumiaiCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKumiaiName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKumiaiName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtKumiaiCode_labelLText() {
                return this.controls.txtKumiaiCode().labelLText;
            }

            public settxtKumiaiCode_labelLText(value) {
                this.controls.txtKumiaiCode().labelLText = value;
            }

            public gettxtKumiaiCode_labelLWidth() {
                return this.controls.txtKumiaiCode().labelLWidth;
            }

            public settxtKumiaiCode_labelLWidth(value) {
                this.controls.txtKumiaiCode().labelLWidth = value;
            }

            public gettxtKumiaiCode_required() {
                return this.controls.txtKumiaiCode().required;
            }

            public settxtKumiaiCode_required(value) {
                this.controls.txtKumiaiCode().required = value;
            }

            public getbtnKumiaiCode_displayNone() {
                return this.controls.btnKumiaiCode().displayNone;
            }

            public setbtnKumiaiCode_displayNone(value) {
                this.controls.btnKumiaiCode().displayNone = value;
            }

            public gettxtKumiaiName_displayNone() {
                return this.controls.txtKumiaiName().displayNone;
            }

            public settxtKumiaiName_displayNone(value) {
                this.controls.txtKumiaiName().displayNone = value;
            }

            public gettxtKumiaiName_width() {
                return this.controls.txtKumiaiName().width;
            }

            public settxtKumiaiName_width(value) {
                this.controls.txtKumiaiName().width = value;
            }

            public gettxtKumiaiCode_readOnly() {
                return this.controls.txtKumiaiCode().readOnly;
            }

            public settxtKumiaiCode_readOnly(value) {
                this.controls.txtKumiaiCode().readOnly = value;
            }

        }
    }
}




