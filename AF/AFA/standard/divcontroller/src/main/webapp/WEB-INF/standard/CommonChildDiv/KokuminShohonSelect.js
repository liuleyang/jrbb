var AFA;
(function (AFA) {
    (function (KokuminShohonSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuminShohonSelect.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KokuminShohonSelect.ModeController = ModeController;
    })(AFA.KokuminShohonSelect || (AFA.KokuminShohonSelect = {}));
    var KokuminShohonSelect = AFA.KokuminShohonSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KokuminShohonSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KokuminShohonSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KokuminShohonSelect.PublicProperties = PublicProperties;
    })(AFA.KokuminShohonSelect || (AFA.KokuminShohonSelect = {}));
    var KokuminShohonSelect = AFA.KokuminShohonSelect;
})(AFA || (AFA = {}));
