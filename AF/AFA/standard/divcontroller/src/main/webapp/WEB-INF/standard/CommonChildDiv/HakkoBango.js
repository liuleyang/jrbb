var AFA;
(function (AFA) {
    (function (HakkoBango) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HakkoBango.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HakkoBango.ModeController = ModeController;
    })(AFA.HakkoBango || (AFA.HakkoBango = {}));
    var HakkoBango = AFA.HakkoBango;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (HakkoBango) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HakkoBango.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtHakkoNoDai_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtHakkoNoDai_labelLWidth = function () {
                return this.controls.txtHakkoNoDai().labelLWidth;
            };

            PublicProperties.prototype.settxtHakkoNoDai_labelLWidth = function (value) {
                this.controls.txtHakkoNoDai().labelLWidth = value;
            };
            return PublicProperties;
        })();
        HakkoBango.PublicProperties = PublicProperties;
    })(AFA.HakkoBango || (AFA.HakkoBango = {}));
    var HakkoBango = AFA.HakkoBango;
})(AFA || (AFA = {}));
