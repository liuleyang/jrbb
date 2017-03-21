/// <reference path='SakuseiChohyoPrintNaiyo_Design.ts' />
module AFA
{
    export module SakuseiChohyoPrintNaiyo
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

    export module SakuseiChohyoPrintNaiyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtIinchoName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtIinchoName_displayNone() {
                return this.controls.txtIinchoName().displayNone;
            }

            public settxtIinchoName_displayNone(value) {
                this.controls.txtIinchoName().displayNone = value;
            }

        }
    }
}




