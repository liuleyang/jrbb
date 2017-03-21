/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="ShohonSelect_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module ShohonSelect {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);

                // 抄本名ドロップダウンリストのChangeAriasを購読し、隠しボタンのクリックイベントを発火させる
                Uz.GyomuJSHelper.registOriginalEvent("onChange_ddlShohon", () => {
                    (<any>this.controls.btnHdnChangeShohon()._control).fireEvent("onClick_btnHdnChangeShohon");
                });
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

    export module ShohonSelect {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}




