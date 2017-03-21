/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="BarCodeNyuryoku_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module BarCodeNyuryoku {

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

    export module BarCodeNyuryoku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtBarCode_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_labelWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_helpMessageID", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtBarCode_labelText() {
                return this.controls.txtBarCode().labelLText;
            }

            public settxtBarCode_labelText(value) {
                this.controls.txtBarCode().labelLText = value;
            }

            public gettxtBarCode_labelWidth() {
                return this.controls.txtBarCode().labelLWidth;
            }

            public settxtBarCode_labelWidth(value) {
                this.controls.txtBarCode().labelLWidth = value;
            }

            public gettxtBarCode_width() {
                return this.controls.txtBarCode().width;
            }

            public settxtBarCode_width(value) {
                this.controls.txtBarCode().width = value;
            }

            public gettxtBarCode_helpMessageID() {
                return this.controls.txtBarCode().helpMessageID;
            }

            public settxtBarCode_helpMessageID(value) {
                this.controls.txtBarCode().helpMessageID = value;
            }

        }
    }
}




