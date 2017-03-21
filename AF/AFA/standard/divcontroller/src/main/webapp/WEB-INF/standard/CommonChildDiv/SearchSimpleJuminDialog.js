var AFA;
(function (AFA) {
    (function (SearchSimpleJuminDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchSimpleJuminDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SearchSimpleJuminDialog.ModeController = ModeController;
    })(AFA.SearchSimpleJuminDialog || (AFA.SearchSimpleJuminDialog = {}));
    var SearchSimpleJuminDialog = AFA.SearchSimpleJuminDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SearchSimpleJuminDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SearchSimpleJuminDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SearchSimpleJuminDialog.PublicProperties = PublicProperties;
    })(AFA.SearchSimpleJuminDialog || (AFA.SearchSimpleJuminDialog = {}));
    var SearchSimpleJuminDialog = AFA.SearchSimpleJuminDialog;
})(AFA || (AFA = {}));
