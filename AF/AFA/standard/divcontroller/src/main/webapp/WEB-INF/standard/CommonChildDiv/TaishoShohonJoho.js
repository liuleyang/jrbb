var AFA;
(function (AFA) {
    (function (TaishoShohonJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new TaishoShohonJoho.Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onChange_ddlShohon", function () {
                    (_this.controls.btnHdnChangeShohon()._control).fireEvent("onClick_btnHdnChangeShohon");
                });
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TaishoShohonJoho.ModeController = ModeController;
    })(AFA.TaishoShohonJoho || (AFA.TaishoShohonJoho = {}));
    var TaishoShohonJoho = AFA.TaishoShohonJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TaishoShohonJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TaishoShohonJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtShohonName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TaishoShohonJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTenshutsuKigenYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTennyuKigenYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdShohonNameList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtShohonName_required = function () {
                return this.controls.txtShohonName().required;
            };

            PublicProperties.prototype.settxtShohonName_required = function (value) {
                this.controls.txtShohonName().required = value;
            };

            PublicProperties.prototype.getTaishoShohonJoho_title = function () {
                return this.controls.TaishoShohonJoho().title;
            };

            PublicProperties.prototype.setTaishoShohonJoho_title = function (value) {
                this.controls.TaishoShohonJoho().title = value;
            };

            PublicProperties.prototype.gettxtTenshutsuKigenYMD_displayNone = function () {
                return this.controls.txtTenshutsuKigenYMD().displayNone;
            };

            PublicProperties.prototype.settxtTenshutsuKigenYMD_displayNone = function (value) {
                this.controls.txtTenshutsuKigenYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtTennyuKigenYMD_displayNone = function () {
                return this.controls.txtTennyuKigenYMD().displayNone;
            };

            PublicProperties.prototype.settxtTennyuKigenYMD_displayNone = function (value) {
                this.controls.txtTennyuKigenYMD().displayNone = value;
            };

            PublicProperties.prototype.getccdShohonNameList_displayNone = function () {
                return this.controls.ccdShohonNameList().Properties().displayNone;
            };

            PublicProperties.prototype.setccdShohonNameList_displayNone = function (value) {
                this.controls.ccdShohonNameList().Properties().displayNone = value;
            };
            return PublicProperties;
        })();
        TaishoShohonJoho.PublicProperties = PublicProperties;
    })(AFA.TaishoShohonJoho || (AFA.TaishoShohonJoho = {}));
    var TaishoShohonJoho = AFA.TaishoShohonJoho;
})(AFA || (AFA = {}));
