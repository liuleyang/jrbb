/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="KaikuSakuseiChohyo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module KaikuSakuseiChohyo {

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

    export module KaikuSakuseiChohyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KaikuSakuseiChohyoIdoTorokushaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoHyojishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getKaikuSakuseiChohyoIdoTorokushaMeibo_displayNone() {
                return this.controls.KaikuSakuseiChohyoIdoTorokushaMeibo().displayNone;
            }

            public setKaikuSakuseiChohyoIdoTorokushaMeibo_displayNone(value) {
                this.controls.KaikuSakuseiChohyoIdoTorokushaMeibo().displayNone = value;
            }

            public getKaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone() {
                return this.controls.KaikuSakuseiChohyoIdoMasshoshaMeibo().displayNone;
            }

            public setKaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone(value) {
                this.controls.KaikuSakuseiChohyoIdoMasshoshaMeibo().displayNone = value;
            }

            public getKaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone() {
                return this.controls.KaikuSakuseiChohyoIdoShikkenshaMeibo().displayNone;
            }

            public setKaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone(value) {
                this.controls.KaikuSakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            }

            public getKaikuSakuseiChohyoIdoHyojishaMeibo_displayNone() {
                return this.controls.KaikuSakuseiChohyoIdoHyojishaMeibo().displayNone;
            }

            public setKaikuSakuseiChohyoIdoHyojishaMeibo_displayNone(value) {
                this.controls.KaikuSakuseiChohyoIdoHyojishaMeibo().displayNone = value;
            }

            public getKaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone() {
                return this.controls.KaikuSakuseiChohyoIdoTeiseishaMeibo().displayNone;
            }

            public setKaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone(value) {
                this.controls.KaikuSakuseiChohyoIdoTeiseishaMeibo().displayNone = value;
            }

        }
    }
}




