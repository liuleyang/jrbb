var AFA;
(function (AFA) {
    (function (TohyorokuKyohiNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyorokuKyohiNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TohyorokuKyohiNyuryoku.ModeController = ModeController;
    })(AFA.TohyorokuKyohiNyuryoku || (AFA.TohyorokuKyohiNyuryoku = {}));
    var TohyorokuKyohiNyuryoku = AFA.TohyorokuKyohiNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyorokuKyohiNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyorokuKyohiNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyorokuKyohiNyuryoku.PublicProperties = PublicProperties;
    })(AFA.TohyorokuKyohiNyuryoku || (AFA.TohyorokuKyohiNyuryoku = {}));
    var TohyorokuKyohiNyuryoku = AFA.TohyorokuKyohiNyuryoku;
})(AFA || (AFA = {}));
