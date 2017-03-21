/// <reference path='SakuseiChohyo_Design.ts' />
module AFA
{
    export module SakuseiChohyo
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

    export module SakuseiChohyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("SakuseiChohyoNijuChosahyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoMasshoYoteishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdo19saishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoZaigaiTohyoKanrihyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getSakuseiChohyoNijuChosahyo_displayNone() {
                return this.controls.SakuseiChohyoNijuChosahyo().displayNone;
            }

            public setSakuseiChohyoNijuChosahyo_displayNone(value) {
                this.controls.SakuseiChohyoNijuChosahyo().displayNone = value;
            }

            public getSakuseiChohyoIdoMasshoYoteishaMeibo_displayNone() {
                return this.controls.SakuseiChohyoIdoMasshoYoteishaMeibo().displayNone;
            }

            public setSakuseiChohyoIdoMasshoYoteishaMeibo_displayNone(value) {
                this.controls.SakuseiChohyoIdoMasshoYoteishaMeibo().displayNone = value;
            }

            public getSakuseiChohyoIdoShikkenshaMeibo_displayNone() {
                return this.controls.SakuseiChohyoIdoShikkenshaMeibo().displayNone;
            }

            public setSakuseiChohyoIdoShikkenshaMeibo_displayNone(value) {
                this.controls.SakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            }

            public getSakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone() {
                return this.controls.SakuseiChohyoIdoHyojiShojoYoteishaMeibo().displayNone;
            }

            public setSakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone(value) {
                this.controls.SakuseiChohyoIdoHyojiShojoYoteishaMeibo().displayNone = value;
            }

            public getSakuseiChohyoIdo19saishaMeibo_displayNone() {
                return this.controls.SakuseiChohyoIdo19saishaMeibo().displayNone;
            }

            public setSakuseiChohyoIdo19saishaMeibo_displayNone(value) {
                this.controls.SakuseiChohyoIdo19saishaMeibo().displayNone = value;
            }

            public getSakuseiChohyoZaigaiTohyoKanrihyo_displayNone() {
                return this.controls.SakuseiChohyoZaigaiTohyoKanrihyo().displayNone;
            }

            public setSakuseiChohyoZaigaiTohyoKanrihyo_displayNone(value) {
                this.controls.SakuseiChohyoZaigaiTohyoKanrihyo().displayNone = value;
            }

        }
    }
}




