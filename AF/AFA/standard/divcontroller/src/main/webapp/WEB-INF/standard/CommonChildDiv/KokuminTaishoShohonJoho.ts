/// <reference path='KokuminTaishoShohonJoho_Design.ts' />
module AFA
{
    export module KokuminTaishoShohonJoho
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

    export module KokuminTaishoShohonJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KokuminTaishoShohonJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radShori_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ccdShohonNameList_labelWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ccdShohonNameList_wrap", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSetYmd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTorokuYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTorokuYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtNenreiTotatsuYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtNenreiTotatsuYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTokuteiKigenYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTokuteiKigenYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoKaishiYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoKaishiYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShohonName_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShohonName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSetChohyoYmd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getKokuminTaishoShohonJoho_title() {
                return this.controls.KokuminTaishoShohonJoho().title;
            }

            public setKokuminTaishoShohonJoho_title(value) {
                this.controls.KokuminTaishoShohonJoho().title = value;
            }

            public getradShori_displayNone() {
                return this.controls.radShori().displayNone;
            }

            public setradShori_displayNone(value) {
                this.controls.radShori().displayNone = value;
            }

            public getccdShohonNameList_disabled() {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_disabled();
            }

            public setccdShohonNameList_disabled(value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_disabled(value);
            }

            public getccdShohonNameList_required() {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_required();
            }

            public setccdShohonNameList_required(value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_required(value);
            }

            public getccdShohonNameList_labelLText() {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_labelText();
            }

            public setccdShohonNameList_labelLText(value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_labelText(value);
            }

            public getccdShohonNameList_labelWidth() {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_labelWidth();
            }

            public setccdShohonNameList_labelWidth(value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_labelWidth(value);
            }

            public getccdShohonNameList_wrap() {
                return this.controls.ccdShohonNameList().Properties().wrap;
            }

            public setccdShohonNameList_wrap(value) {
                this.controls.ccdShohonNameList().Properties().wrap = value;
            }

            public getccdShohonNameList_displayNone() {
                return this.controls.ccdShohonNameList().Properties().displayNone;
            }

            public setccdShohonNameList_displayNone(value) {
                this.controls.ccdShohonNameList().Properties().displayNone = value;
            }

            public gettxtTohyoYMD_readOnly() {
                return this.controls.txtTohyoYMD().readOnly;
            }

            public settxtTohyoYMD_readOnly(value) {
                this.controls.txtTohyoYMD().readOnly = value;
            }

            public gettxtTohyoYMD_required() {
                return this.controls.txtTohyoYMD().required;
            }

            public settxtTohyoYMD_required(value) {
                this.controls.txtTohyoYMD().required = value;
            }

            public getbtnSetYmd_displayNone() {
                return this.controls.btnSetYmd().displayNone;
            }

            public setbtnSetYmd_displayNone(value) {
                this.controls.btnSetYmd().displayNone = value;
            }

            public gettxtKijunYMD_readOnly() {
                return this.controls.txtKijunYMD().readOnly;
            }

            public settxtKijunYMD_readOnly(value) {
                this.controls.txtKijunYMD().readOnly = value;
            }

            public gettxtKijunYMD_required() {
                return this.controls.txtKijunYMD().required;
            }

            public settxtKijunYMD_required(value) {
                this.controls.txtKijunYMD().required = value;
            }

            public gettxtTorokuYMD_readOnly() {
                return this.controls.txtMeiboTorokuYMD().readOnly;
            }

            public settxtTorokuYMD_readOnly(value) {
                this.controls.txtMeiboTorokuYMD().readOnly = value;
            }

            public gettxtTorokuYMD_required() {
                return this.controls.txtMeiboTorokuYMD().required;
            }

            public settxtTorokuYMD_required(value) {
                this.controls.txtMeiboTorokuYMD().required = value;
            }

            public gettxtNenreiTotatsuYMD_readOnly() {
                return this.controls.txtNenreiTotatsuYMD().readOnly;
            }

            public settxtNenreiTotatsuYMD_readOnly(value) {
                this.controls.txtNenreiTotatsuYMD().readOnly = value;
            }

            public gettxtNenreiTotatsuYMD_required() {
                return this.controls.txtNenreiTotatsuYMD().required;
            }

            public settxtNenreiTotatsuYMD_required(value) {
                this.controls.txtNenreiTotatsuYMD().required = value;
            }

            public gettxtTokuteiKigenYMD_readOnly() {
                return this.controls.txtTokuteiKigenYMD().readOnly;
            }

            public settxtTokuteiKigenYMD_readOnly(value) {
                this.controls.txtTokuteiKigenYMD().readOnly = value;
            }

            public gettxtTokuteiKigenYMD_required() {
                return this.controls.txtTokuteiKigenYMD().required;
            }

            public settxtTokuteiKigenYMD_required(value) {
                this.controls.txtTokuteiKigenYMD().required = value;
            }

            public gettxtTohyoKaishiYMD_readOnly() {
                return this.controls.txtTohyoUketsukeYMD().readOnly;
            }

            public settxtTohyoKaishiYMD_readOnly(value) {
                this.controls.txtTohyoUketsukeYMD().readOnly = value;
            }

            public gettxtTohyoKaishiYMD_required() {
                return this.controls.txtTohyoUketsukeYMD().required;
            }

            public settxtTohyoKaishiYMD_required(value) {
                this.controls.txtTohyoUketsukeYMD().required = value;
            }

            public gettxtShohonName_readOnly() {
                return this.controls.txtShohonName().readOnly;
            }

            public settxtShohonName_readOnly(value) {
                this.controls.txtShohonName().readOnly = value;
            }

            public gettxtShohonName_required() {
                return this.controls.txtShohonName().required;
            }

            public settxtShohonName_required(value) {
                this.controls.txtShohonName().required = value;
            }

            public getbtnSetChohyoYmd_displayNone() {
                return this.controls.btnSetChohyoYmd().displayNone;
            }

            public setbtnSetChohyoYmd_displayNone(value) {
                this.controls.btnSetChohyoYmd().displayNone = value;
            }

        }
    }
}



