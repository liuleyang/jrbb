var AFA;
(function (AFA) {
    (function (TohyorokuShimeiNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyorokuShimeiNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TohyorokuShimeiNyuryoku.ModeController = ModeController;
    })(AFA.TohyorokuShimeiNyuryoku || (AFA.TohyorokuShimeiNyuryoku = {}));
    var TohyorokuShimeiNyuryoku = AFA.TohyorokuShimeiNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyorokuShimeiNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyorokuShimeiNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TohyorokuShimeiNyuryoku.PublicProperties = PublicProperties;
    })(AFA.TohyorokuShimeiNyuryoku || (AFA.TohyorokuShimeiNyuryoku = {}));
    var TohyorokuShimeiNyuryoku = AFA.TohyorokuShimeiNyuryoku;
})(AFA || (AFA = {}));
