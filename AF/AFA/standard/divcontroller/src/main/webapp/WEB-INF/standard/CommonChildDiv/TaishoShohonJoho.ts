/// <reference path='TaishoShohonJoho_Design.ts' />
module AFA
{
    export module TaishoShohonJoho
    {
        export class ModeController {
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

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }

    }
}



module AFA {

    export module TaishoShohonJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtShohonName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TaishoShohonJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTenshutsuKigenYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTennyuKigenYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtShohonName_required() {
                return this.controls.txtShohonName().required;
            }

            public settxtShohonName_required(value) {
                this.controls.txtShohonName().required = value;
            }

            public getTaishoShohonJoho_title() {
                return this.controls.TaishoShohonJoho().title;
            }

            public setTaishoShohonJoho_title(value) {
                this.controls.TaishoShohonJoho().title = value;
            }

            public gettxtTenshutsuKigenYMD_displayNone() {
                return this.controls.txtTenshutsuKigenYMD().displayNone;
            }

            public settxtTenshutsuKigenYMD_displayNone(value) {
                this.controls.txtTenshutsuKigenYMD().displayNone = value;
            }

            public gettxtTennyuKigenYMD_displayNone() {
                return this.controls.txtTennyuKigenYMD().displayNone;
            }

            public settxtTennyuKigenYMD_displayNone(value) {
                this.controls.txtTennyuKigenYMD().displayNone = value;
            }

            public getccdShohonNameList_displayNone() {
                return this.controls.ccdShohonNameList().Properties().displayNone;
            }

            public setccdShohonNameList_displayNone(value) {
                this.controls.ccdShohonNameList().Properties().displayNone = value;
            }

        }
    }
}




