var AFA;
(function (AFA) {
    (function (KaikuSakuseiChohyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaikuSakuseiChohyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaikuSakuseiChohyo.ModeController = ModeController;
    })(AFA.KaikuSakuseiChohyo || (AFA.KaikuSakuseiChohyo = {}));
    var KaikuSakuseiChohyo = AFA.KaikuSakuseiChohyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KaikuSakuseiChohyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaikuSakuseiChohyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KaikuSakuseiChohyoIdoTorokushaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoHyojishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getKaikuSakuseiChohyoIdoTorokushaMeibo_displayNone = function () {
                return this.controls.KaikuSakuseiChohyoIdoTorokushaMeibo().displayNone;
            };

            PublicProperties.prototype.setKaikuSakuseiChohyoIdoTorokushaMeibo_displayNone = function (value) {
                this.controls.KaikuSakuseiChohyoIdoTorokushaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getKaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone = function () {
                return this.controls.KaikuSakuseiChohyoIdoMasshoshaMeibo().displayNone;
            };

            PublicProperties.prototype.setKaikuSakuseiChohyoIdoMasshoshaMeibo_displayNone = function (value) {
                this.controls.KaikuSakuseiChohyoIdoMasshoshaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getKaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone = function () {
                return this.controls.KaikuSakuseiChohyoIdoShikkenshaMeibo().displayNone;
            };

            PublicProperties.prototype.setKaikuSakuseiChohyoIdoShikkenshaMeibo_displayNone = function (value) {
                this.controls.KaikuSakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getKaikuSakuseiChohyoIdoHyojishaMeibo_displayNone = function () {
                return this.controls.KaikuSakuseiChohyoIdoHyojishaMeibo().displayNone;
            };

            PublicProperties.prototype.setKaikuSakuseiChohyoIdoHyojishaMeibo_displayNone = function (value) {
                this.controls.KaikuSakuseiChohyoIdoHyojishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getKaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone = function () {
                return this.controls.KaikuSakuseiChohyoIdoTeiseishaMeibo().displayNone;
            };

            PublicProperties.prototype.setKaikuSakuseiChohyoIdoTeiseishaMeibo_displayNone = function (value) {
                this.controls.KaikuSakuseiChohyoIdoTeiseishaMeibo().displayNone = value;
            };
            return PublicProperties;
        })();
        KaikuSakuseiChohyo.PublicProperties = PublicProperties;
    })(AFA.KaikuSakuseiChohyo || (AFA.KaikuSakuseiChohyo = {}));
    var KaikuSakuseiChohyo = AFA.KaikuSakuseiChohyo;
})(AFA || (AFA = {}));
