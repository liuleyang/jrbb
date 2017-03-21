/// <reference path='SearchShikaku_Design.ts' />
module AFA
{
    export module SearchShikaku
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

    export module SearchShikaku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSearchTeishiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdSearchTeishiJiyu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchShojoYoteiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchShojoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchKeikiShuryoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikakuShosai_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("chkSearchTohyoShikaku_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikaku_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("SearchShikaku_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikaku_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtSearchTeishiYMD_displayNone() {
                return this.controls.txtSearchTeishiYMD().displayNone;
            }

            public settxtSearchTeishiYMD_displayNone(value) {
                this.controls.txtSearchTeishiYMD().displayNone = value;
            }

            public getccdSearchTeishiJiyu_displayNone() {
                return this.controls.ccdSearchTeishiJiyu().Properties().displayNone;
            }

            public setccdSearchTeishiJiyu_displayNone(value) {
                this.controls.ccdSearchTeishiJiyu().Properties().displayNone = value;
            }

            public gettxtSearchShojoYoteiYMD_displayNone() {
                return this.controls.txtSearchShojoYoteiYMD().displayNone;
            }

            public settxtSearchShojoYoteiYMD_displayNone(value) {
                this.controls.txtSearchShojoYoteiYMD().displayNone = value;
            }

            public gettxtSearchShojoYMD_displayNone() {
                return this.controls.txtSearchShojoYMD().displayNone;
            }

            public settxtSearchShojoYMD_displayNone(value) {
                this.controls.txtSearchShojoYMD().displayNone = value;
            }

            public gettxtSearchKeikiShuryoYMD_displayNone() {
                return this.controls.txtSearchKeikiShuryoYMD().displayNone;
            }

            public settxtSearchKeikiShuryoYMD_displayNone(value) {
                this.controls.txtSearchKeikiShuryoYMD().displayNone = value;
            }

            public getSearchShikakuShosai_displayNone() {
                return this.controls.SearchShikakuShosai().displayNone;
            }

            public setSearchShikakuShosai_displayNone(value) {
                this.controls.SearchShikakuShosai().displayNone = value;
            }

            public getchkSearchTohyoShikaku_displayNone() {
                return this.controls.chkSearchTohyoShikaku().displayNone;
            }

            public setchkSearchTohyoShikaku_displayNone(value) {
                this.controls.chkSearchTohyoShikaku().displayNone = value;
            }

            public getSearchShikaku_title() {
                return this.controls.SearchShikaku().title;
            }

            public setSearchShikaku_title(value) {
                this.controls.SearchShikaku().title = value;
            }

            public getSearchShikaku_eraseBorder() {
                return this.controls.SearchShikaku().eraseBorder;
            }

            public setSearchShikaku_eraseBorder(value) {
                this.controls.SearchShikaku().eraseBorder = value;
            }

            public getSearchShikaku_width() {
                return this.controls.SearchShikaku().width;
            }

            public setSearchShikaku_width(value) {
                this.controls.SearchShikaku().width = value;
            }

        }
    }
}




