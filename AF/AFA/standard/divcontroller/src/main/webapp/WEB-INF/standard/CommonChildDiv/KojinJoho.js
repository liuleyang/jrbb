var AFA;
(function (AFA) {
    (function (KojinJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KojinJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KojinJoho.ModeController = ModeController;
    })(AFA.KojinJoho || (AFA.KojinJoho = {}));
    var KojinJoho = AFA.KojinJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KojinJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KojinJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KojinJoho_title", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getKojinJoho_title = function () {
                return this.controls.KojinJoho().title;
            };

            PublicProperties.prototype.setKojinJoho_title = function (value) {
                this.controls.KojinJoho().title = value;
            };
            return PublicProperties;
        })();
        KojinJoho.PublicProperties = PublicProperties;
    })(AFA.KojinJoho || (AFA.KojinJoho = {}));
    var KojinJoho = AFA.KojinJoho;
})(AFA || (AFA = {}));
