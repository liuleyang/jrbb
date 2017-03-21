var AFA;
(function (AFA) {
    (function (KokuminTaishoShohonJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuminTaishoShohonJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KokuminTaishoShohonJoho.ModeController = ModeController;
    })(AFA.KokuminTaishoShohonJoho || (AFA.KokuminTaishoShohonJoho = {}));
    var KokuminTaishoShohonJoho = AFA.KokuminTaishoShohonJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KokuminTaishoShohonJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KokuminTaishoShohonJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
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
            };

            PublicProperties.prototype.getKokuminTaishoShohonJoho_title = function () {
                return this.controls.KokuminTaishoShohonJoho().title;
            };

            PublicProperties.prototype.setKokuminTaishoShohonJoho_title = function (value) {
                this.controls.KokuminTaishoShohonJoho().title = value;
            };

            PublicProperties.prototype.getradShori_displayNone = function () {
                return this.controls.radShori().displayNone;
            };

            PublicProperties.prototype.setradShori_displayNone = function (value) {
                this.controls.radShori().displayNone = value;
            };

            PublicProperties.prototype.getccdShohonNameList_disabled = function () {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_disabled();
            };

            PublicProperties.prototype.setccdShohonNameList_disabled = function (value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_disabled(value);
            };

            PublicProperties.prototype.getccdShohonNameList_required = function () {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_required();
            };

            PublicProperties.prototype.setccdShohonNameList_required = function (value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_required(value);
            };

            PublicProperties.prototype.getccdShohonNameList_labelLText = function () {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_labelText();
            };

            PublicProperties.prototype.setccdShohonNameList_labelLText = function (value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_labelText(value);
            };

            PublicProperties.prototype.getccdShohonNameList_labelWidth = function () {
                return this.controls.ccdShohonNameList().PublicProperties().getddlShohon_labelWidth();
            };

            PublicProperties.prototype.setccdShohonNameList_labelWidth = function (value) {
                this.controls.ccdShohonNameList().PublicProperties().setddlShohon_labelWidth(value);
            };

            PublicProperties.prototype.getccdShohonNameList_wrap = function () {
                return this.controls.ccdShohonNameList().Properties().wrap;
            };

            PublicProperties.prototype.setccdShohonNameList_wrap = function (value) {
                this.controls.ccdShohonNameList().Properties().wrap = value;
            };

            PublicProperties.prototype.getccdShohonNameList_displayNone = function () {
                return this.controls.ccdShohonNameList().Properties().displayNone;
            };

            PublicProperties.prototype.setccdShohonNameList_displayNone = function (value) {
                this.controls.ccdShohonNameList().Properties().displayNone = value;
            };

            PublicProperties.prototype.gettxtTohyoYMD_readOnly = function () {
                return this.controls.txtTohyoYMD().readOnly;
            };

            PublicProperties.prototype.settxtTohyoYMD_readOnly = function (value) {
                this.controls.txtTohyoYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtTohyoYMD_required = function () {
                return this.controls.txtTohyoYMD().required;
            };

            PublicProperties.prototype.settxtTohyoYMD_required = function (value) {
                this.controls.txtTohyoYMD().required = value;
            };

            PublicProperties.prototype.getbtnSetYmd_displayNone = function () {
                return this.controls.btnSetYmd().displayNone;
            };

            PublicProperties.prototype.setbtnSetYmd_displayNone = function (value) {
                this.controls.btnSetYmd().displayNone = value;
            };

            PublicProperties.prototype.gettxtKijunYMD_readOnly = function () {
                return this.controls.txtKijunYMD().readOnly;
            };

            PublicProperties.prototype.settxtKijunYMD_readOnly = function (value) {
                this.controls.txtKijunYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtKijunYMD_required = function () {
                return this.controls.txtKijunYMD().required;
            };

            PublicProperties.prototype.settxtKijunYMD_required = function (value) {
                this.controls.txtKijunYMD().required = value;
            };

            PublicProperties.prototype.gettxtTorokuYMD_readOnly = function () {
                return this.controls.txtMeiboTorokuYMD().readOnly;
            };

            PublicProperties.prototype.settxtTorokuYMD_readOnly = function (value) {
                this.controls.txtMeiboTorokuYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtTorokuYMD_required = function () {
                return this.controls.txtMeiboTorokuYMD().required;
            };

            PublicProperties.prototype.settxtTorokuYMD_required = function (value) {
                this.controls.txtMeiboTorokuYMD().required = value;
            };

            PublicProperties.prototype.gettxtNenreiTotatsuYMD_readOnly = function () {
                return this.controls.txtNenreiTotatsuYMD().readOnly;
            };

            PublicProperties.prototype.settxtNenreiTotatsuYMD_readOnly = function (value) {
                this.controls.txtNenreiTotatsuYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtNenreiTotatsuYMD_required = function () {
                return this.controls.txtNenreiTotatsuYMD().required;
            };

            PublicProperties.prototype.settxtNenreiTotatsuYMD_required = function (value) {
                this.controls.txtNenreiTotatsuYMD().required = value;
            };

            PublicProperties.prototype.gettxtTokuteiKigenYMD_readOnly = function () {
                return this.controls.txtTokuteiKigenYMD().readOnly;
            };

            PublicProperties.prototype.settxtTokuteiKigenYMD_readOnly = function (value) {
                this.controls.txtTokuteiKigenYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtTokuteiKigenYMD_required = function () {
                return this.controls.txtTokuteiKigenYMD().required;
            };

            PublicProperties.prototype.settxtTokuteiKigenYMD_required = function (value) {
                this.controls.txtTokuteiKigenYMD().required = value;
            };

            PublicProperties.prototype.gettxtTohyoKaishiYMD_readOnly = function () {
                return this.controls.txtTohyoUketsukeYMD().readOnly;
            };

            PublicProperties.prototype.settxtTohyoKaishiYMD_readOnly = function (value) {
                this.controls.txtTohyoUketsukeYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtTohyoKaishiYMD_required = function () {
                return this.controls.txtTohyoUketsukeYMD().required;
            };

            PublicProperties.prototype.settxtTohyoKaishiYMD_required = function (value) {
                this.controls.txtTohyoUketsukeYMD().required = value;
            };

            PublicProperties.prototype.gettxtShohonName_readOnly = function () {
                return this.controls.txtShohonName().readOnly;
            };

            PublicProperties.prototype.settxtShohonName_readOnly = function (value) {
                this.controls.txtShohonName().readOnly = value;
            };

            PublicProperties.prototype.gettxtShohonName_required = function () {
                return this.controls.txtShohonName().required;
            };

            PublicProperties.prototype.settxtShohonName_required = function (value) {
                this.controls.txtShohonName().required = value;
            };

            PublicProperties.prototype.getbtnSetChohyoYmd_displayNone = function () {
                return this.controls.btnSetChohyoYmd().displayNone;
            };

            PublicProperties.prototype.setbtnSetChohyoYmd_displayNone = function (value) {
                this.controls.btnSetChohyoYmd().displayNone = value;
            };
            return PublicProperties;
        })();
        KokuminTaishoShohonJoho.PublicProperties = PublicProperties;
    })(AFA.KokuminTaishoShohonJoho || (AFA.KokuminTaishoShohonJoho = {}));
    var KokuminTaishoShohonJoho = AFA.KokuminTaishoShohonJoho;
})(AFA || (AFA = {}));
