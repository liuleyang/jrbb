var AFA;
(function (AFA) {
    (function (MeiboBango) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new MeiboBango.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        MeiboBango.ModeController = ModeController;
    })(AFA.MeiboBango || (AFA.MeiboBango = {}));
    var MeiboBango = AFA.MeiboBango;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (MeiboBango) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new MeiboBango.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSatsu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSatsu_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSatsu_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSatsu_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtPage_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtPage_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtGyo_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtGyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtSatsu_displayNone = function () {
                return this.controls.txtSatsu().displayNone;
            };

            PublicProperties.prototype.settxtSatsu_displayNone = function (value) {
                this.controls.txtSatsu().displayNone = value;
            };

            PublicProperties.prototype.gettxtSatsu_readOnly = function () {
                return this.controls.txtSatsu().readOnly;
            };

            PublicProperties.prototype.settxtSatsu_readOnly = function (value) {
                this.controls.txtSatsu().readOnly = value;
            };

            PublicProperties.prototype.gettxtSatsu_labelLWidth = function () {
                return this.controls.txtSatsu().labelLWidth;
            };

            PublicProperties.prototype.settxtSatsu_labelLWidth = function (value) {
                this.controls.txtSatsu().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtSatsu_required = function () {
                return this.controls.txtSatsu().required;
            };

            PublicProperties.prototype.settxtSatsu_required = function (value) {
                this.controls.txtSatsu().required = value;
            };

            PublicProperties.prototype.gettxtPage_readOnly = function () {
                return this.controls.txtPage().readOnly;
            };

            PublicProperties.prototype.settxtPage_readOnly = function (value) {
                this.controls.txtPage().readOnly = value;
            };

            PublicProperties.prototype.gettxtPage_required = function () {
                return this.controls.txtPage().required;
            };

            PublicProperties.prototype.settxtPage_required = function (value) {
                this.controls.txtPage().required = value;
            };

            PublicProperties.prototype.gettxtGyo_readOnly = function () {
                return this.controls.txtGyo().readOnly;
            };

            PublicProperties.prototype.settxtGyo_readOnly = function (value) {
                this.controls.txtGyo().readOnly = value;
            };

            PublicProperties.prototype.gettxtGyo_displayNone = function () {
                return this.controls.txtGyo().displayNone;
            };

            PublicProperties.prototype.settxtGyo_displayNone = function (value) {
                this.controls.txtGyo().displayNone = value;
            };
            return PublicProperties;
        })();
        MeiboBango.PublicProperties = PublicProperties;
    })(AFA.MeiboBango || (AFA.MeiboBango = {}));
    var MeiboBango = AFA.MeiboBango;
})(AFA || (AFA = {}));
