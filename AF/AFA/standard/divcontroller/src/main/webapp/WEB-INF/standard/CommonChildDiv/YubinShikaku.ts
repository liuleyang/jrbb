/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="YubinShikaku_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module YubinShikaku {

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

    export module YubinShikaku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("radShikakuKubun_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("chkShikakuJoken_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSearchSimple_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnDirectInput_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnClear_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaiban_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnCancel_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getradShikakuKubun_required() {
                return this.controls.radShikakuKubun().required;
            }

            public setradShikakuKubun_required(value) {
                this.controls.radShikakuKubun().required = value;
            }

            public getchkShikakuJoken_required() {
                return this.controls.chkShikakuJoken().required;
            }

            public setchkShikakuJoken_required(value) {
                this.controls.chkShikakuJoken().required = value;
            }

            public getbtnSearchSimple_displayNone() {
                return this.controls.btnSearchSimple().displayNone;
            }

            public setbtnSearchSimple_displayNone(value) {
                this.controls.btnSearchSimple().displayNone = value;
            }

            public getbtnDirectInput_displayNone() {
                return this.controls.btnDirectInput().displayNone;
            }

            public setbtnDirectInput_displayNone(value) {
                this.controls.btnDirectInput().displayNone = value;
            }

            public getbtnClear_displayNone() {
                return this.controls.btnClear().displayNone;
            }

            public setbtnClear_displayNone(value) {
                this.controls.btnClear().displayNone = value;
            }

            public getbtnSaiban_displayNone() {
                return this.controls.btnSaiban().displayNone;
            }

            public setbtnSaiban_displayNone(value) {
                this.controls.btnSaiban().displayNone = value;
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




