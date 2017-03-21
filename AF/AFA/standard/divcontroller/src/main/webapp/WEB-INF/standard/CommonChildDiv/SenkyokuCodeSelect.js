var AFA;
(function (AFA) {
    (function (SenkyokuCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SenkyokuCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SenkyokuCodeSelect.ModeController = ModeController;
    })(AFA.SenkyokuCodeSelect || (AFA.SenkyokuCodeSelect = {}));
    var SenkyokuCodeSelect = AFA.SenkyokuCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SenkyokuCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SenkyokuCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSenkyokuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSenkyokuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyokuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSenkyokuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtSenkyokuCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtSenkyokuCode_labelLText = function () {
                return this.controls.txtSenkyokuCode().labelLText;
            };

            PublicProperties.prototype.settxtSenkyokuCode_labelLText = function (value) {
                this.controls.txtSenkyokuCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtSenkyokuCode_labelLWidth = function () {
                return this.controls.txtSenkyokuCode().labelLWidth;
            };

            PublicProperties.prototype.settxtSenkyokuCode_labelLWidth = function (value) {
                this.controls.txtSenkyokuCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtSenkyokuCode_required = function () {
                return this.controls.txtSenkyokuCode().required;
            };

            PublicProperties.prototype.settxtSenkyokuCode_required = function (value) {
                this.controls.txtSenkyokuCode().required = value;
            };

            PublicProperties.prototype.getbtnSenkyokuCode_displayNone = function () {
                return this.controls.btnSenkyokuCode().displayNone;
            };

            PublicProperties.prototype.setbtnSenkyokuCode_displayNone = function (value) {
                this.controls.btnSenkyokuCode().displayNone = value;
            };

            PublicProperties.prototype.gettxtSenkyokuName_displayNone = function () {
                return this.controls.txtSenkyokuName().displayNone;
            };

            PublicProperties.prototype.settxtSenkyokuName_displayNone = function (value) {
                this.controls.txtSenkyokuName().displayNone = value;
            };

            PublicProperties.prototype.gettxtSenkyokuName_width = function () {
                return this.controls.txtSenkyokuName().width;
            };

            PublicProperties.prototype.settxtSenkyokuName_width = function (value) {
                this.controls.txtSenkyokuName().width = value;
            };

            PublicProperties.prototype.gettxtSenkyokuCode_readOnly = function () {
                return this.controls.txtSenkyokuCode().readOnly;
            };

            PublicProperties.prototype.settxtSenkyokuCode_readOnly = function (value) {
                this.controls.txtSenkyokuCode().readOnly = value;
            };
            return PublicProperties;
        })();
        SenkyokuCodeSelect.PublicProperties = PublicProperties;
    })(AFA.SenkyokuCodeSelect || (AFA.SenkyokuCodeSelect = {}));
    var SenkyokuCodeSelect = AFA.SenkyokuCodeSelect;
})(AFA || (AFA = {}));
