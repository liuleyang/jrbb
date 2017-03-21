var AFA;
(function (AFA) {
    (function (TohyoJiyuCode) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyoJiyuCode.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TohyoJiyuCode.ModeController = ModeController;
    })(AFA.TohyoJiyuCode || (AFA.TohyoJiyuCode = {}));
    var TohyoJiyuCode = AFA.TohyoJiyuCode;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyoJiyuCode) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyoJiyuCode.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyoJiyuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyoJiyuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlTohyoJiyu_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtTohyoJiyuCode_required = function () {
                return this.controls.txtTohyoJiyuCode().required;
            };

            PublicProperties.prototype.settxtTohyoJiyuCode_required = function (value) {
                this.controls.txtTohyoJiyuCode().required = value;
            };

            PublicProperties.prototype.gettxtTohyoJiyuCode_labelLWidth = function () {
                return this.controls.txtTohyoJiyuCode().labelLWidth;
            };

            PublicProperties.prototype.settxtTohyoJiyuCode_labelLWidth = function (value) {
                this.controls.txtTohyoJiyuCode().labelLWidth = value;
            };

            PublicProperties.prototype.getddlTohyoJiyu_required = function () {
                return this.controls.ddlTohyoJiyu().required;
            };

            PublicProperties.prototype.setddlTohyoJiyu_required = function (value) {
                this.controls.ddlTohyoJiyu().required = value;
            };
            return PublicProperties;
        })();
        TohyoJiyuCode.PublicProperties = PublicProperties;
    })(AFA.TohyoJiyuCode || (AFA.TohyoJiyuCode = {}));
    var TohyoJiyuCode = AFA.TohyoJiyuCode;
})(AFA || (AFA = {}));
