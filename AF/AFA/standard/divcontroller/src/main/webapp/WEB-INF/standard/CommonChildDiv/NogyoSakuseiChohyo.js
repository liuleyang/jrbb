var AFA;
(function (AFA) {
    (function (NogyoSakuseiChohyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NogyoSakuseiChohyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        NogyoSakuseiChohyo.ModeController = ModeController;
    })(AFA.NogyoSakuseiChohyo || (AFA.NogyoSakuseiChohyo = {}));
    var NogyoSakuseiChohyo = AFA.NogyoSakuseiChohyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (NogyoSakuseiChohyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new NogyoSakuseiChohyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("NogyoSakuseiChohyoCheckList_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoTorokushaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoHyojishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoCheckList_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoCheckList().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoCheckList_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoCheckList().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoTorokushaMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoTorokushaMeibo().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoTorokushaMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoTorokushaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoMasshoshaMeibo().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoMasshoshaMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoMasshoshaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoShikkenshaMeibo().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoShikkenshaMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoHyojishaMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoHyojishaMeibo().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoHyojishaMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoHyojishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoTeiseishaMeibo().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoTeiseishaMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoTeiseishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getNogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone = function () {
                return this.controls.NogyoSakuseiChohyoIdoJukiIdoshaList().displayNone;
            };

            PublicProperties.prototype.setNogyoSakuseiChohyoIdoJukiIdoMeibo_displayNone = function (value) {
                this.controls.NogyoSakuseiChohyoIdoJukiIdoshaList().displayNone = value;
            };
            return PublicProperties;
        })();
        NogyoSakuseiChohyo.PublicProperties = PublicProperties;
    })(AFA.NogyoSakuseiChohyo || (AFA.NogyoSakuseiChohyo = {}));
    var NogyoSakuseiChohyo = AFA.NogyoSakuseiChohyo;
})(AFA || (AFA = {}));
