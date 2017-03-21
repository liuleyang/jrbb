/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="FuzaishaShikaku_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module FuzaishaShikaku {

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

    export module FuzaishaShikaku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("FuzaishaShikaku_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtManryoYMD_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radShikakuKubun_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuzaishaShikaku_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnCancel_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getFuzaishaShikaku_title() {
                return this.controls.FuzaishaShikaku().title;
            }

            public setFuzaishaShikaku_title(value) {
                this.controls.FuzaishaShikaku().title = value;
            }

            public gettxtManryoYMD_labelText() {
                return this.controls.txtManryoYMD().labelLText;
            }

            public settxtManryoYMD_labelText(value) {
                this.controls.txtManryoYMD().labelLText = value;
            }

            public getradShikakuKubun_required() {
                return this.controls.radShikakuKubun().required;
            }

            public setradShikakuKubun_required(value) {
                this.controls.radShikakuKubun().required = value;
            }

            public getFuzaishaShikaku_width() {
                return this.controls.FuzaishaShikaku().width;
            }

            public setFuzaishaShikaku_width(value) {
                this.controls.FuzaishaShikaku().width = value;
            }

            public getbtnCancel_displayNone() {
                return this.controls.btnCancel().displayNone;
            }

            public setbtnCancel_displayNone(value) {
                this.controls.btnCancel().displayNone = value;
            }

        }
    }
}




