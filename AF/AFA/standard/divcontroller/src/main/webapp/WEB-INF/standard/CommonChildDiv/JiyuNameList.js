var AFA;
(function (AFA) {
    (function (JiyuNameList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JiyuNameList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JiyuNameList.ModeController = ModeController;
    })(AFA.JiyuNameList || (AFA.JiyuNameList = {}));
    var JiyuNameList = AFA.JiyuNameList;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (JiyuNameList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JiyuNameList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlJiyuName_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlJiyuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlJiyuName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlJiyuName_isBlankLine", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getddlJiyuName_disabled = function () {
                return this.controls.ddlJiyuName().disabled;
            };

            PublicProperties.prototype.setddlJiyuName_disabled = function (value) {
                this.controls.ddlJiyuName().disabled = value;
            };

            PublicProperties.prototype.getddlJiyuName_width = function () {
                return this.controls.ddlJiyuName().width;
            };

            PublicProperties.prototype.setddlJiyuName_width = function (value) {
                this.controls.ddlJiyuName().width = value;
            };

            PublicProperties.prototype.getddlJiyuName_required = function () {
                return this.controls.ddlJiyuName().required;
            };

            PublicProperties.prototype.setddlJiyuName_required = function (value) {
                this.controls.ddlJiyuName().required = value;
            };

            PublicProperties.prototype.getddlJiyuName_labelLText = function () {
                return this.controls.ddlJiyuName().labelLText;
            };

            PublicProperties.prototype.setddlJiyuName_labelLText = function (value) {
                this.controls.ddlJiyuName().labelLText = value;
            };

            PublicProperties.prototype.getddlJiyuName_labelLWidth = function () {
                return this.controls.ddlJiyuName().labelLWidth;
            };

            PublicProperties.prototype.setddlJiyuName_labelLWidth = function (value) {
                this.controls.ddlJiyuName().labelLWidth = value;
            };

            PublicProperties.prototype.getddlJiyuName_isBlankLine = function () {
                return this.controls.ddlJiyuName().isBlankLine;
            };

            PublicProperties.prototype.setddlJiyuName_isBlankLine = function (value) {
                this.controls.ddlJiyuName().isBlankLine = value;
            };
            return PublicProperties;
        })();
        JiyuNameList.PublicProperties = PublicProperties;
    })(AFA.JiyuNameList || (AFA.JiyuNameList = {}));
    var JiyuNameList = AFA.JiyuNameList;
})(AFA || (AFA = {}));
