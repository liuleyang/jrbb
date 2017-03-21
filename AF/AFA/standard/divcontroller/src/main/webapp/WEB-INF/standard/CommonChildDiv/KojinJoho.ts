/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="KojinJoho_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module KojinJoho {

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

    export module KojinJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KojinJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getKojinJoho_title() {
                return this.controls.KojinJoho().title;
            }

            public setKojinJoho_title(value) {
                this.controls.KojinJoho().title = value;
            }

        }
    }
}




