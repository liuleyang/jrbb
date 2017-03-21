var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuCodeSelect.ModeController = ModeController;
    })(AFA.ShisetsuCodeSelect || (AFA.ShisetsuCodeSelect = {}));
    var ShisetsuCodeSelect = AFA.ShisetsuCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtShsietsuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnShisetsuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShisetsuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShisetsuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtShisetsuCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtShsietsuCode_labelLText = function () {
                return this.controls.txtShisetsuCode().labelLText;
            };

            PublicProperties.prototype.settxtShsietsuCode_labelLText = function (value) {
                this.controls.txtShisetsuCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtShisetsuCode_labelLWidth = function () {
                return this.controls.txtShisetsuCode().labelLWidth;
            };

            PublicProperties.prototype.settxtShisetsuCode_labelLWidth = function (value) {
                this.controls.txtShisetsuCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtShisetsuCode_required = function () {
                return this.controls.txtShisetsuCode().required;
            };

            PublicProperties.prototype.settxtShisetsuCode_required = function (value) {
                this.controls.txtShisetsuCode().required = value;
            };

            PublicProperties.prototype.getbtnShisetsuCode_displayNone = function () {
                return this.controls.btnShisetsuCode().displayNone;
            };

            PublicProperties.prototype.setbtnShisetsuCode_displayNone = function (value) {
                this.controls.btnShisetsuCode().displayNone = value;
            };

            PublicProperties.prototype.gettxtShisetsuName_displayNone = function () {
                return this.controls.txtShisetsuName().displayNone;
            };

            PublicProperties.prototype.settxtShisetsuName_displayNone = function (value) {
                this.controls.txtShisetsuName().displayNone = value;
            };

            PublicProperties.prototype.gettxtShisetsuName_width = function () {
                return this.controls.txtShisetsuName().width;
            };

            PublicProperties.prototype.settxtShisetsuName_width = function (value) {
                this.controls.txtShisetsuName().width = value;
            };

            PublicProperties.prototype.gettxtShisetsuCode_labelLAlign = function () {
                return this.controls.txtShisetsuCode().labelLAlign;
            };

            PublicProperties.prototype.settxtShisetsuCode_labelLAlign = function (value) {
                this.controls.txtShisetsuCode().labelLAlign = value;
            };
            return PublicProperties;
        })();
        ShisetsuCodeSelect.PublicProperties = PublicProperties;
    })(AFA.ShisetsuCodeSelect || (AFA.ShisetsuCodeSelect = {}));
    var ShisetsuCodeSelect = AFA.ShisetsuCodeSelect;
})(AFA || (AFA = {}));
