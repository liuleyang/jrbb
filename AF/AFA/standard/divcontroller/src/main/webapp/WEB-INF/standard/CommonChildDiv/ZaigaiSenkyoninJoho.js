var AFA;
(function (AFA) {
    (function (ZaigaiSenkyoninJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZaigaiSenkyoninJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ZaigaiSenkyoninJoho.ModeController = ModeController;
    })(AFA.ZaigaiSenkyoninJoho || (AFA.ZaigaiSenkyoninJoho = {}));
    var ZaigaiSenkyoninJoho = AFA.ZaigaiSenkyoninJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ZaigaiSenkyoninJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ZaigaiSenkyoninJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZaigaiSenkyoninJoho.PublicProperties = PublicProperties;
    })(AFA.ZaigaiSenkyoninJoho || (AFA.ZaigaiSenkyoninJoho = {}));
    var ZaigaiSenkyoninJoho = AFA.ZaigaiSenkyoninJoho;
})(AFA || (AFA = {}));
