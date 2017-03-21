/// <reference path='ShikakuJoho_Design.ts' />
module AFA
{
    export module ShikakuJoho
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

    export module ShikakuJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTorokuTeishiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdTorokuTeishiJiyu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtHyojiShojoYoteiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtHyojiShojoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKeikiShuryoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtTorokuTeishiYMD_displayNone() {
                return this.controls.txtTorokuTeishiYMD().displayNone;
            }

            public settxtTorokuTeishiYMD_displayNone(value) {
                this.controls.txtTorokuTeishiYMD().displayNone = value;
            }

            public getccdTorokuTeishiJiyu_displayNone() {
                return this.controls.ccdTorokuTeishiJiyu().Properties().displayNone;
            }

            public setccdTorokuTeishiJiyu_displayNone(value) {
                this.controls.ccdTorokuTeishiJiyu().Properties().displayNone = value;
            }

            public gettxtHyojiShojoYoteiYMD_displayNone() {
                return this.controls.txtHyojiShojoYoteiYMD().displayNone;
            }

            public settxtHyojiShojoYoteiYMD_displayNone(value) {
                this.controls.txtHyojiShojoYoteiYMD().displayNone = value;
            }

            public gettxtHyojiShojoYMD_displayNone() {
                return this.controls.txtHyojiShojoYMD().displayNone;
            }

            public settxtHyojiShojoYMD_displayNone(value) {
                this.controls.txtHyojiShojoYMD().displayNone = value;
            }

            public gettxtKeikiShuryoYMD_displayNone() {
                return this.controls.txtKeikiShuryoYMD().displayNone;
            }

            public settxtKeikiShuryoYMD_displayNone(value) {
                this.controls.txtKeikiShuryoYMD().displayNone = value;
            }

        }
    }
}




