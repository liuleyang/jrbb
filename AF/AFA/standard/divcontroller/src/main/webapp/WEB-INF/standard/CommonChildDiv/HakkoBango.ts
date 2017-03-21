/// <reference path='HakkoBango_Design.ts' />
module AFA
{
    export module HakkoBango
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

    export module HakkoBango {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtHakkoNoDai_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtHakkoNoDai_labelLWidth() {
                return this.controls.txtHakkoNoDai().labelLWidth;
            }

            public settxtHakkoNoDai_labelLWidth(value) {
                this.controls.txtHakkoNoDai().labelLWidth = value;
            }

        }
    }
}




