var AFA;
(function (AFA) {
    (function (SenkyoShuruiSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SenkyoShuruiSelect.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SenkyoShuruiSelect.ModeController = ModeController;
    })(AFA.SenkyoShuruiSelect || (AFA.SenkyoShuruiSelect = {}));
    var SenkyoShuruiSelect = AFA.SenkyoShuruiSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SenkyoShuruiSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SenkyoShuruiSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlSenkyoShurui_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlSenkyoShurui_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlSenkyoShurui_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getddlSenkyoShurui_labelLWidth = function () {
                return this.controls.ddlSenkyoShurui().labelLWidth;
            };

            PublicProperties.prototype.setddlSenkyoShurui_labelLWidth = function (value) {
                this.controls.ddlSenkyoShurui().labelLWidth = value;
            };

            PublicProperties.prototype.getddlSenkyoShurui_disabled = function () {
                return this.controls.ddlSenkyoShurui().disabled;
            };

            PublicProperties.prototype.setddlSenkyoShurui_disabled = function (value) {
                this.controls.ddlSenkyoShurui().disabled = value;
            };

            PublicProperties.prototype.getddlSenkyoShurui_required = function () {
                return this.controls.ddlSenkyoShurui().required;
            };

            PublicProperties.prototype.setddlSenkyoShurui_required = function (value) {
                this.controls.ddlSenkyoShurui().required = value;
            };
            return PublicProperties;
        })();
        SenkyoShuruiSelect.PublicProperties = PublicProperties;
    })(AFA.SenkyoShuruiSelect || (AFA.SenkyoShuruiSelect = {}));
    var SenkyoShuruiSelect = AFA.SenkyoShuruiSelect;
})(AFA || (AFA = {}));
