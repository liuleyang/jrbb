var AFA;
(function (AFA) {
    (function (ZaigaiMeiboJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZaigaiMeiboJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ZaigaiMeiboJoho.ModeController = ModeController;
    })(AFA.ZaigaiMeiboJoho || (AFA.ZaigaiMeiboJoho = {}));
    var ZaigaiMeiboJoho = AFA.ZaigaiMeiboJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ZaigaiMeiboJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ZaigaiMeiboJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZaigaiMeiboJoho.PublicProperties = PublicProperties;
    })(AFA.ZaigaiMeiboJoho || (AFA.ZaigaiMeiboJoho = {}));
    var ZaigaiMeiboJoho = AFA.ZaigaiMeiboJoho;
})(AFA || (AFA = {}));
