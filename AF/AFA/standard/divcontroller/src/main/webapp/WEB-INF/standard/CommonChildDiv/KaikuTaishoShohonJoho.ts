/// <reference path='KaikuTaishoShohonJoho_Design.ts' />
module AFA
{
    export module KaikuTaishoShohonJoho
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

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        }
    }
}

module AFA
{
    export module KaikuTaishoShohonJoho
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KaikuTaishoShohonJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShiyoShohon_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("radShori_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ccdShohonNameList_wrap", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("chkMutohyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoKaishiYMD_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoKaishiYMD_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShohonName_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShohonName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyoName_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyoName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getKaikuTaishoShohonJoho_title() {
                return this.controls.KaikuTaishoShohonJoho().title;
            }

            public setKaikuTaishoShohonJoho_title(value) {
                this.controls.KaikuTaishoShohonJoho().title = value;
            }

            public gettxtShiyoShohon_displayNone() {
                return this.controls.txtShiyoShohon().displayNone;
            }

            public settxtShiyoShohon_displayNone(value) {
                this.controls.txtShiyoShohon().displayNone = value;
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

            public getchkMutohyo_displayNone() {
                return this.controls.chkMutohyo().displayNone;
            }

            public setchkMutohyo_displayNone(value) {
                this.controls.chkMutohyo().displayNone = value;
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

            public gettxtSenkyoName_readOnly() {
                return this.controls.txtSenkyoName().readOnly;
            }

            public settxtSenkyoName_readOnly(value) {
                this.controls.txtSenkyoName().readOnly = value;
            }

            public gettxtSenkyoName_required() {
                return this.controls.txtSenkyoName().required;
            }

            public settxtSenkyoName_required(value) {
                this.controls.txtSenkyoName().required = value;
            }

        }
    }
}

