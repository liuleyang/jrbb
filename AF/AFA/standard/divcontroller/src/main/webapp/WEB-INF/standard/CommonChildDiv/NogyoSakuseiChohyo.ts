/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="NogyoSakuseiChohyo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module NogyoSakuseiChohyo {

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

    export module NogyoSakuseiChohyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("NogyoSakuseiChohyoCheckList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoTorokushaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoHyojishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getNogyoSakuseiChohyoCheckList_displayNone() {
                return this.controls.NogyoSakuseiChohyoCheckList().displayNone;
            }

            public setNogyoSakuseiChohyoCheckList_displayNone(value) {
                this.controls.NogyoSakuseiChohyoCheckList().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoTorokushaMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoTorokushaMeibo().displayNone;
            }

            public setNogyoSakuseiChohyoIdoTorokushaMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoTorokushaMeibo().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoMasshoshaMeibo().displayNone;
            }

            public setNogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoMasshoshaMeibo().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoShikkenshaMeibo().displayNone;
            }

            public setNogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoHyojishaMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoHyojishaMeibo().displayNone;
            }

            public setNogyoSakuseiChohyoIdoHyojishaMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoHyojishaMeibo().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoTeiseishaMeibo().displayNone;
            }

            public setNogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoTeiseishaMeibo().displayNone = value;
            }

            public getNogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone() {
                return this.controls.NogyoSakuseiChohyoIdoJukiIdoshaList().displayNone;
            }

            public setNogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone(value) {
                this.controls.NogyoSakuseiChohyoIdoJukiIdoshaList().displayNone = value;
            }

        }
    }
}




