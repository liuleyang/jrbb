/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="SenkyoShuruiSelect_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module SenkyoShuruiSelect {

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

    export module SenkyoShuruiSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlSenkyoShurui_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlSenkyoShurui_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlSenkyoShurui_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getddlSenkyoShurui_labelLWidth() {
                return this.controls.ddlSenkyoShurui().labelLWidth;
            }

            public setddlSenkyoShurui_labelLWidth(value) {
                this.controls.ddlSenkyoShurui().labelLWidth = value;
            }

            public getddlSenkyoShurui_disabled() {
                return this.controls.ddlSenkyoShurui().disabled;
            }

            public setddlSenkyoShurui_disabled(value) {
                this.controls.ddlSenkyoShurui().disabled = value;
            }

            public getddlSenkyoShurui_required() {
                return this.controls.ddlSenkyoShurui().required;
            }

            public setddlSenkyoShurui_required(value) {
                this.controls.ddlSenkyoShurui().required = value;
            }

        }
    }
}




