var AFA;
(function (AFA) {
    (function (KaikuTaishoShohonJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaikuTaishoShohonJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaikuTaishoShohonJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaikuTaishoShohonJoho.ModeController = ModeController;
    })(AFA.KaikuTaishoShohonJoho || (AFA.KaikuTaishoShohonJoho = {}));
    var KaikuTaishoShohonJoho = AFA.KaikuTaishoShohonJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KaikuTaishoShohonJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaikuTaishoShohonJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
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
            };

            PublicProperties.prototype.getKaikuTaishoShohonJoho_title = function () {
                return this.controls.KaikuTaishoShohonJoho().title;
            };

            PublicProperties.prototype.setKaikuTaishoShohonJoho_title = function (value) {
                this.controls.KaikuTaishoShohonJoho().title = value;
            };

            PublicProperties.prototype.gettxtShiyoShohon_displayNone = function () {
                return this.controls.txtShiyoShohon().displayNone;
            };

            PublicProperties.prototype.settxtShiyoShohon_displayNone = function (value) {
                this.controls.txtShiyoShohon().displayNone = value;
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

            PublicProperties.prototype.getchkMutohyo_displayNone = function () {
                return this.controls.chkMutohyo().displayNone;
            };

            PublicProperties.prototype.setchkMutohyo_displayNone = function (value) {
                this.controls.chkMutohyo().displayNone = value;
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

            PublicProperties.prototype.gettxtSenkyoName_readOnly = function () {
                return this.controls.txtSenkyoName().readOnly;
            };

            PublicProperties.prototype.settxtSenkyoName_readOnly = function (value) {
                this.controls.txtSenkyoName().readOnly = value;
            };

            PublicProperties.prototype.gettxtSenkyoName_required = function () {
                return this.controls.txtSenkyoName().required;
            };

            PublicProperties.prototype.settxtSenkyoName_required = function (value) {
                this.controls.txtSenkyoName().required = value;
            };
            return PublicProperties;
        })();
        KaikuTaishoShohonJoho.PublicProperties = PublicProperties;
    })(AFA.KaikuTaishoShohonJoho || (AFA.KaikuTaishoShohonJoho = {}));
    var KaikuTaishoShohonJoho = AFA.KaikuTaishoShohonJoho;
})(AFA || (AFA = {}));
