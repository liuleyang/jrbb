var AFA;
(function (AFA) {
    (function (SakuseiChohyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SakuseiChohyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SakuseiChohyo.ModeController = ModeController;
    })(AFA.SakuseiChohyo || (AFA.SakuseiChohyo = {}));
    var SakuseiChohyo = AFA.SakuseiChohyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SakuseiChohyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SakuseiChohyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("SakuseiChohyoNijuChosahyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoMasshoYoteishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoShikkenshaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoIdo19saishaMeibo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SakuseiChohyoZaigaiTohyoKanrihyo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getSakuseiChohyoNijuChosahyo_displayNone = function () {
                return this.controls.SakuseiChohyoNijuChosahyo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoNijuChosahyo_displayNone = function (value) {
                this.controls.SakuseiChohyoNijuChosahyo().displayNone = value;
            };

            PublicProperties.prototype.getSakuseiChohyoIdoMasshoYoteishaMeibo_displayNone = function () {
                return this.controls.SakuseiChohyoIdoMasshoYoteishaMeibo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoIdoMasshoYoteishaMeibo_displayNone = function (value) {
                this.controls.SakuseiChohyoIdoMasshoYoteishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getSakuseiChohyoIdoShikkenshaMeibo_displayNone = function () {
                return this.controls.SakuseiChohyoIdoShikkenshaMeibo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoIdoShikkenshaMeibo_displayNone = function (value) {
                this.controls.SakuseiChohyoIdoShikkenshaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getSakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone = function () {
                return this.controls.SakuseiChohyoIdoHyojiShojoYoteishaMeibo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoIdoHyojiShojoYoteishaMeibo_displayNone = function (value) {
                this.controls.SakuseiChohyoIdoHyojiShojoYoteishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getSakuseiChohyoIdo19saishaMeibo_displayNone = function () {
                return this.controls.SakuseiChohyoIdo19saishaMeibo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoIdo19saishaMeibo_displayNone = function (value) {
                this.controls.SakuseiChohyoIdo19saishaMeibo().displayNone = value;
            };

            PublicProperties.prototype.getSakuseiChohyoZaigaiTohyoKanrihyo_displayNone = function () {
                return this.controls.SakuseiChohyoZaigaiTohyoKanrihyo().displayNone;
            };

            PublicProperties.prototype.setSakuseiChohyoZaigaiTohyoKanrihyo_displayNone = function (value) {
                this.controls.SakuseiChohyoZaigaiTohyoKanrihyo().displayNone = value;
            };
            return PublicProperties;
        })();
        SakuseiChohyo.PublicProperties = PublicProperties;
    })(AFA.SakuseiChohyo || (AFA.SakuseiChohyo = {}));
    var SakuseiChohyo = AFA.SakuseiChohyo;
})(AFA || (AFA = {}));
