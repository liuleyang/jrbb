/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="MeiboSakuseiKijun_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module AFA
{
    export module MeiboSakuseiKijun {

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

    export module MeiboSakuseiKijun {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SenkyoNyuryoku_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSetChohyoYmd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSetYmd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtMeiboTorokuYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTenshutsuYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTennyuYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblTenshutsuYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblTennyuYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtTohyoYMD_displayNone() {
                return this.controls.txtTohyoYMD().displayNone;
            }

            public settxtTohyoYMD_displayNone(value) {
                this.controls.txtTohyoYMD().displayNone = value;
            }

            public getSenkyoNyuryoku_displayNone() {
                return this.controls.SenkyoNyuryoku().displayNone;
            }

            public setSenkyoNyuryoku_displayNone(value) {
                this.controls.SenkyoNyuryoku().displayNone = value;
            }

            public getbtnSetChohyoYmd_displayNone() {
                return this.controls.btnSetChohyoYmd().displayNone;
            }

            public setbtnSetChohyoYmd_displayNone(value) {
                this.controls.btnSetChohyoYmd().displayNone = value;
            }

            public getbtnSetYmd_displayNone() {
                return this.controls.btnSetYmd().displayNone;
            }

            public setbtnSetYmd_displayNone(value) {
                this.controls.btnSetYmd().displayNone = value;
            }

            public gettxtKijunYMD_displayNone() {
                return this.controls.txtKijunYMD().displayNone;
            }

            public settxtKijunYMD_displayNone(value) {
                this.controls.txtKijunYMD().displayNone = value;
            }

            public gettxtMeiboTorokuYMD_displayNone() {
                return this.controls.txtMeiboTorokuYMD().displayNone;
            }

            public settxtMeiboTorokuYMD_displayNone(value) {
                this.controls.txtMeiboTorokuYMD().displayNone = value;
            }

            public gettxtTenshutsuYMD_displayNone() {
                return this.controls.txtTenshutsuYMD().displayNone;
            }

            public settxtTenshutsuYMD_displayNone(value) {
                this.controls.txtTenshutsuYMD().displayNone = value;
            }

            public gettxtTennyuYMD_displayNone() {
                return this.controls.txtTennyuYMD().displayNone;
            }

            public settxtTennyuYMD_displayNone(value) {
                this.controls.txtTennyuYMD().displayNone = value;
            }

            public getlblTenshutsuYMD_displayNone() {
                return this.controls.lblTenshutsuYMD().displayNone;
            }

            public setlblTenshutsuYMD_displayNone(value) {
                this.controls.lblTenshutsuYMD().displayNone = value;
            }

            public getlblTennyuYMD_displayNone() {
                return this.controls.lblTennyuYMD().displayNone;
            }

            public setlblTennyuYMD_displayNone(value) {
                this.controls.lblTennyuYMD().displayNone = value;
            }

        }
    }
}




