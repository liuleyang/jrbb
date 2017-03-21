var AFA;
(function (AFA) {
    (function (SenkyokuSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SenkyokuSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SenkyokuSelectDialog.ModeController = ModeController;
    })(AFA.SenkyokuSelectDialog || (AFA.SenkyokuSelectDialog = {}));
    var SenkyokuSelectDialog = AFA.SenkyokuSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SenkyokuSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SenkyokuSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SenkyokuSelectDialog.PublicProperties = PublicProperties;
    })(AFA.SenkyokuSelectDialog || (AFA.SenkyokuSelectDialog = {}));
    var SenkyokuSelectDialog = AFA.SenkyokuSelectDialog;
})(AFA || (AFA = {}));
