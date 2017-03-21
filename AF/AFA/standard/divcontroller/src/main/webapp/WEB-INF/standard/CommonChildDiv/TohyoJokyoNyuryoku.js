var AFA;
(function (AFA) {
    (function (TohyoJokyoNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyoJokyoNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TohyoJokyoNyuryoku.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TohyoJokyoNyuryoku.ModeController = ModeController;
    })(AFA.TohyoJokyoNyuryoku || (AFA.TohyoJokyoNyuryoku = {}));
    var TohyoJokyoNyuryoku = AFA.TohyoJokyoNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyoJokyoNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyoJokyoNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyoJokyoNyuryoku.PublicProperties = PublicProperties;
    })(AFA.TohyoJokyoNyuryoku || (AFA.TohyoJokyoNyuryoku = {}));
    var TohyoJokyoNyuryoku = AFA.TohyoJokyoNyuryoku;
})(AFA || (AFA = {}));
