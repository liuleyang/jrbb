var AFA;
(function (AFA) {
    (function (TohyojoSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyojoSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TohyojoSelectDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TohyojoSelectDialog.ModeController = ModeController;
    })(AFA.TohyojoSelectDialog || (AFA.TohyojoSelectDialog = {}));
    var TohyojoSelectDialog = AFA.TohyojoSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyojoSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyojoSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyojoSelectDialog.PublicProperties = PublicProperties;
    })(AFA.TohyojoSelectDialog || (AFA.TohyojoSelectDialog = {}));
    var TohyojoSelectDialog = AFA.TohyojoSelectDialog;
})(AFA || (AFA = {}));
