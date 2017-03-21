var AFA;
(function (AFA) {
    (function (TohyokuSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyokuSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TohyokuSelectDialog.ModeController = ModeController;
    })(AFA.TohyokuSelectDialog || (AFA.TohyokuSelectDialog = {}));
    var TohyokuSelectDialog = AFA.TohyokuSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyokuSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyokuSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyokuSelectDialog.PublicProperties = PublicProperties;
    })(AFA.TohyokuSelectDialog || (AFA.TohyokuSelectDialog = {}));
    var TohyokuSelectDialog = AFA.TohyokuSelectDialog;
})(AFA || (AFA = {}));
