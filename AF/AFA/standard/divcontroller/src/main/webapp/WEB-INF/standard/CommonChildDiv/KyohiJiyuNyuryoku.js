var AFA;
(function (AFA) {
    (function (KyohiJiyuNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyohiJiyuNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyohiJiyuNyuryoku.ModeController = ModeController;
    })(AFA.KyohiJiyuNyuryoku || (AFA.KyohiJiyuNyuryoku = {}));
    var KyohiJiyuNyuryoku = AFA.KyohiJiyuNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KyohiJiyuNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyohiJiyuNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlKyohiJiyu_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKyohiJiyu_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKyohiJiyu_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getddlKyohiJiyu_disabled = function () {
                return this.controls.ddlKyohiJiyu().disabled;
            };

            PublicProperties.prototype.setddlKyohiJiyu_disabled = function (value) {
                this.controls.ddlKyohiJiyu().disabled = value;
            };

            PublicProperties.prototype.getddlKyohiJiyu_labelLWidth = function () {
                return this.controls.ddlKyohiJiyu().labelLWidth;
            };

            PublicProperties.prototype.setddlKyohiJiyu_labelLWidth = function (value) {
                this.controls.ddlKyohiJiyu().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtKyohiJiyu_readOnly = function () {
                return this.controls.txtKyohiJiyu().readOnly;
            };

            PublicProperties.prototype.settxtKyohiJiyu_readOnly = function (value) {
                this.controls.txtKyohiJiyu().readOnly = value;
            };
            return PublicProperties;
        })();
        KyohiJiyuNyuryoku.PublicProperties = PublicProperties;
    })(AFA.KyohiJiyuNyuryoku || (AFA.KyohiJiyuNyuryoku = {}));
    var KyohiJiyuNyuryoku = AFA.KyohiJiyuNyuryoku;
})(AFA || (AFA = {}));
