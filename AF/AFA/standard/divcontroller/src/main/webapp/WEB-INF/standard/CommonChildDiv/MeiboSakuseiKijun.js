var AFA;
(function (AFA) {
    (function (MeiboSakuseiKijun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new MeiboSakuseiKijun.Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onChange_ddlShohon", function () {
                    (_this.controls.btnHdnChangeShohon()._control).fireEvent("onClick_btnHdnChangeShohon");
                });
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        MeiboSakuseiKijun.ModeController = ModeController;
    })(AFA.MeiboSakuseiKijun || (AFA.MeiboSakuseiKijun = {}));
    var MeiboSakuseiKijun = AFA.MeiboSakuseiKijun;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (MeiboSakuseiKijun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new MeiboSakuseiKijun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
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
            };

            PublicProperties.prototype.gettxtTohyoYMD_displayNone = function () {
                return this.controls.txtTohyoYMD().displayNone;
            };

            PublicProperties.prototype.settxtTohyoYMD_displayNone = function (value) {
                this.controls.txtTohyoYMD().displayNone = value;
            };

            PublicProperties.prototype.getSenkyoNyuryoku_displayNone = function () {
                return this.controls.SenkyoNyuryoku().displayNone;
            };

            PublicProperties.prototype.setSenkyoNyuryoku_displayNone = function (value) {
                this.controls.SenkyoNyuryoku().displayNone = value;
            };

            PublicProperties.prototype.getbtnSetChohyoYmd_displayNone = function () {
                return this.controls.btnSetChohyoYmd().displayNone;
            };

            PublicProperties.prototype.setbtnSetChohyoYmd_displayNone = function (value) {
                this.controls.btnSetChohyoYmd().displayNone = value;
            };

            PublicProperties.prototype.getbtnSetYmd_displayNone = function () {
                return this.controls.btnSetYmd().displayNone;
            };

            PublicProperties.prototype.setbtnSetYmd_displayNone = function (value) {
                this.controls.btnSetYmd().displayNone = value;
            };

            PublicProperties.prototype.gettxtKijunYMD_displayNone = function () {
                return this.controls.txtKijunYMD().displayNone;
            };

            PublicProperties.prototype.settxtKijunYMD_displayNone = function (value) {
                this.controls.txtKijunYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtMeiboTorokuYMD_displayNone = function () {
                return this.controls.txtMeiboTorokuYMD().displayNone;
            };

            PublicProperties.prototype.settxtMeiboTorokuYMD_displayNone = function (value) {
                this.controls.txtMeiboTorokuYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtTenshutsuYMD_displayNone = function () {
                return this.controls.txtTenshutsuYMD().displayNone;
            };

            PublicProperties.prototype.settxtTenshutsuYMD_displayNone = function (value) {
                this.controls.txtTenshutsuYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtTennyuYMD_displayNone = function () {
                return this.controls.txtTennyuYMD().displayNone;
            };

            PublicProperties.prototype.settxtTennyuYMD_displayNone = function (value) {
                this.controls.txtTennyuYMD().displayNone = value;
            };

            PublicProperties.prototype.getlblTenshutsuYMD_displayNone = function () {
                return this.controls.lblTenshutsuYMD().displayNone;
            };

            PublicProperties.prototype.setlblTenshutsuYMD_displayNone = function (value) {
                this.controls.lblTenshutsuYMD().displayNone = value;
            };

            PublicProperties.prototype.getlblTennyuYMD_displayNone = function () {
                return this.controls.lblTennyuYMD().displayNone;
            };

            PublicProperties.prototype.setlblTennyuYMD_displayNone = function (value) {
                this.controls.lblTennyuYMD().displayNone = value;
            };
            return PublicProperties;
        })();
        MeiboSakuseiKijun.PublicProperties = PublicProperties;
    })(AFA.MeiboSakuseiKijun || (AFA.MeiboSakuseiKijun = {}));
    var MeiboSakuseiKijun = AFA.MeiboSakuseiKijun;
})(AFA || (AFA = {}));
