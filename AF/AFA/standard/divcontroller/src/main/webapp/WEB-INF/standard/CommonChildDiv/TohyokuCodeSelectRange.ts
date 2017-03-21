/// <reference path='TohyokuCodeSelectRange_Design.ts' />
module AFA
{
    export module TohyokuCodeSelectRange
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

    export module TohyokuCodeSelectRange {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyokuCodeFrom_DisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuCodeTo_DisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);

                return editTypes;
            }

            public gettxtTohyokuCodeFrom_DisplayNone() {
                return this.controls.ccdTohyokuCodeFrom().PublicProperties().gettxtTohyokuName_displayNone();
            }

            public settxtTohyokuCodeFrom_DisplayNone(value) {
                this.controls.ccdTohyokuCodeFrom().PublicProperties().settxtTohyokuName_displayNone(value);
            }

            public gettxtTohyokuCodeTo_DisplayNone() {
                return this.controls.ccdTohyokuCodeTo().PublicProperties().gettxtTohyokuName_displayNone();
            }

            public settxtTohyokuCodeTo_DisplayNone(value) {
                this.controls.ccdTohyokuCodeTo().PublicProperties().settxtTohyokuName_displayNone(value);
            }

        }
    }
}




