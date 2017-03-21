var AFA;
(function (AFA) {
    (function (JushoJokenSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushoJokenSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushoJokenSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JushoJokenSelect.ModeController = ModeController;
    })(AFA.JushoJokenSelect || (AFA.JushoJokenSelect = {}));
    var JushoJokenSelect = AFA.JushoJokenSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (JushoJokenSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushoJokenSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushoJokenSelect.PublicProperties = PublicProperties;
    })(AFA.JushoJokenSelect || (AFA.JushoJokenSelect = {}));
    var JushoJokenSelect = AFA.JushoJokenSelect;
})(AFA || (AFA = {}));
