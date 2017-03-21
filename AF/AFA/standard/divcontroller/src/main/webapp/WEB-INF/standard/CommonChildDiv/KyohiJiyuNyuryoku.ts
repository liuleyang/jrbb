/// <reference path='KyohiJiyuNyuryoku_Design.ts' />
module AFA
{
    export module KyohiJiyuNyuryoku
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

    export module KyohiJiyuNyuryoku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlKyohiJiyu_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKyohiJiyu_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKyohiJiyu_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getddlKyohiJiyu_disabled() {
                return this.controls.ddlKyohiJiyu().disabled;
            }

            public setddlKyohiJiyu_disabled(value) {
                this.controls.ddlKyohiJiyu().disabled = value;
            }

            public getddlKyohiJiyu_labelLWidth() {
                return this.controls.ddlKyohiJiyu().labelLWidth;
            }

            public setddlKyohiJiyu_labelLWidth(value) {
                this.controls.ddlKyohiJiyu().labelLWidth = value;
            }

            public gettxtKyohiJiyu_readOnly() {
                return this.controls.txtKyohiJiyu().readOnly;
            }

            public settxtKyohiJiyu_readOnly(value) {
                this.controls.txtKyohiJiyu().readOnly = value;
            }

        }
    }
}




