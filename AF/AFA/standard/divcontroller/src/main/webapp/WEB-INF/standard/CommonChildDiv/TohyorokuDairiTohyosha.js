var AFA;
(function (AFA) {
    (function (TohyorokuDairiTohyosha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyorokuDairiTohyosha.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TohyorokuDairiTohyosha.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TohyorokuDairiTohyosha.ModeController = ModeController;
    })(AFA.TohyorokuDairiTohyosha || (AFA.TohyorokuDairiTohyosha = {}));
    var TohyorokuDairiTohyosha = AFA.TohyorokuDairiTohyosha;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyorokuDairiTohyosha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyorokuDairiTohyosha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyorokuDairiTohyosha.PublicProperties = PublicProperties;
    })(AFA.TohyorokuDairiTohyosha || (AFA.TohyorokuDairiTohyosha = {}));
    var TohyorokuDairiTohyosha = AFA.TohyorokuDairiTohyosha;
})(AFA || (AFA = {}));
