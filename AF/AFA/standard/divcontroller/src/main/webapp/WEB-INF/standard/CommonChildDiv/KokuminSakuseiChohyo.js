var AFA;
(function (AFA) {
    (function (KokuminSakuseiChohyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuminSakuseiChohyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KokuminSakuseiChohyo.ModeController = ModeController;
    })(AFA.KokuminSakuseiChohyo || (AFA.KokuminSakuseiChohyo = {}));
    var KokuminSakuseiChohyo = AFA.KokuminSakuseiChohyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KokuminSakuseiChohyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KokuminSakuseiChohyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KokuminSakuseiChohyo.PublicProperties = PublicProperties;
    })(AFA.KokuminSakuseiChohyo || (AFA.KokuminSakuseiChohyo = {}));
    var KokuminSakuseiChohyo = AFA.KokuminSakuseiChohyo;
})(AFA || (AFA = {}));
