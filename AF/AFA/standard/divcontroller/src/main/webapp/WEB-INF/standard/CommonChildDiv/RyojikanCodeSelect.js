var AFA;
(function (AFA) {
    (function (RyojikanCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RyojikanCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RyojikanCodeSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RyojikanCodeSelect.ModeController = ModeController;
    })(AFA.RyojikanCodeSelect || (AFA.RyojikanCodeSelect = {}));
    var RyojikanCodeSelect = AFA.RyojikanCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (RyojikanCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RyojikanCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RyojikanCodeSelect.PublicProperties = PublicProperties;
    })(AFA.RyojikanCodeSelect || (AFA.RyojikanCodeSelect = {}));
    var RyojikanCodeSelect = AFA.RyojikanCodeSelect;
})(AFA || (AFA = {}));
