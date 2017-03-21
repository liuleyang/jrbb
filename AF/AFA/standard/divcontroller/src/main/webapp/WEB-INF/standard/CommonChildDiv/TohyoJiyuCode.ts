/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="TohyoJiyuCode_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module TohyoJiyuCode {

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

    export module TohyoJiyuCode {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyoJiyuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoJiyuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlTohyoJiyu_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtTohyoJiyuCode_required() {
                return this.controls.txtTohyoJiyuCode().required;
            }

            public settxtTohyoJiyuCode_required(value) {
                this.controls.txtTohyoJiyuCode().required = value;
            }

            public gettxtTohyoJiyuCode_labelLWidth() {
                return this.controls.txtTohyoJiyuCode().labelLWidth;
            }

            public settxtTohyoJiyuCode_labelLWidth(value) {
                this.controls.txtTohyoJiyuCode().labelLWidth = value;
            }

            public getddlTohyoJiyu_required() {
                return this.controls.ddlTohyoJiyu().required;
            }

            public setddlTohyoJiyu_required(value) {
                this.controls.ddlTohyoJiyu().required = value;
            }

        }
    }
}




