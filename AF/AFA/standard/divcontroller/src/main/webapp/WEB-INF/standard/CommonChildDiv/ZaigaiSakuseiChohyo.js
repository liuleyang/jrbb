var AFA;
(function (AFA) {
    (function (ZaigaiSakuseiChohyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZaigaiSakuseiChohyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ZaigaiSakuseiChohyo.ModeController = ModeController;
    })(AFA.ZaigaiSakuseiChohyo || (AFA.ZaigaiSakuseiChohyo = {}));
    var ZaigaiSakuseiChohyo = AFA.ZaigaiSakuseiChohyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ZaigaiSakuseiChohyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ZaigaiSakuseiChohyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZaigaiSakuseiChohyo.PublicProperties = PublicProperties;
    })(AFA.ZaigaiSakuseiChohyo || (AFA.ZaigaiSakuseiChohyo = {}));
    var ZaigaiSakuseiChohyo = AFA.ZaigaiSakuseiChohyo;
})(AFA || (AFA = {}));
