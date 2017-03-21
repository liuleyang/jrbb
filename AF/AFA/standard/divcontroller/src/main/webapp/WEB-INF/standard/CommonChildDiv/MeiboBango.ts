/// <reference path='MeiboBango_Design.ts' />
module AFA
{
    export module MeiboBango
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

    export module MeiboBango {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSatsu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSatsu_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSatsu_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSatsu_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtPage_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtPage_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtGyo_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtGyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtSatsu_displayNone() {
                return this.controls.txtSatsu().displayNone;
            }

            public settxtSatsu_displayNone(value) {
                this.controls.txtSatsu().displayNone = value;
            }

            public gettxtSatsu_readOnly() {
                return this.controls.txtSatsu().readOnly;
            }

            public settxtSatsu_readOnly(value) {
                this.controls.txtSatsu().readOnly = value;
            }

            public gettxtSatsu_labelLWidth() {
                return this.controls.txtSatsu().labelLWidth;
            }

            public settxtSatsu_labelLWidth(value) {
                this.controls.txtSatsu().labelLWidth = value;
            }

            public gettxtSatsu_required() {
                return this.controls.txtSatsu().required;
            }

            public settxtSatsu_required(value) {
                this.controls.txtSatsu().required = value;
            }

            public gettxtPage_readOnly() {
                return this.controls.txtPage().readOnly;
            }

            public settxtPage_readOnly(value) {
                this.controls.txtPage().readOnly = value;
            }

            public gettxtPage_required() {
                return this.controls.txtPage().required;
            }

            public settxtPage_required(value) {
                this.controls.txtPage().required = value;
            }

            public gettxtGyo_readOnly() {
                return this.controls.txtGyo().readOnly;
            }

            public settxtGyo_readOnly(value) {
                this.controls.txtGyo().readOnly = value;
            }

            public gettxtGyo_displayNone() {
                return this.controls.txtGyo().displayNone;
            }

            public settxtGyo_displayNone(value) {
                this.controls.txtGyo().displayNone = value;
            }

        }
    }
}




