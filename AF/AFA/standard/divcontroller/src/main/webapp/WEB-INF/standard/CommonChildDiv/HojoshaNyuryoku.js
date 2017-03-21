var AFA;
(function (AFA) {
    (function (HojoshaNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HojoshaNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HojoshaNyuryoku.ModeController = ModeController;
    })(AFA.HojoshaNyuryoku || (AFA.HojoshaNyuryoku = {}));
    var HojoshaNyuryoku = AFA.HojoshaNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (HojoshaNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HojoshaNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HojoshaNyuryoku.PublicProperties = PublicProperties;
    })(AFA.HojoshaNyuryoku || (AFA.HojoshaNyuryoku = {}));
    var HojoshaNyuryoku = AFA.HojoshaNyuryoku;
})(AFA || (AFA = {}));
