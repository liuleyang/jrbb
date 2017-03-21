var AFA;
(function (AFA) {
    (function (SearchSimpleTojitsuDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchSimpleTojitsuDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SearchSimpleTojitsuDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SearchSimpleTojitsuDialog.ModeController = ModeController;
    })(AFA.SearchSimpleTojitsuDialog || (AFA.SearchSimpleTojitsuDialog = {}));
    var SearchSimpleTojitsuDialog = AFA.SearchSimpleTojitsuDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SearchSimpleTojitsuDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchSimpleTojitsuDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SearchSimpleTojitsuDialog.PublicProperties = PublicProperties;
    })(AFA.SearchSimpleTojitsuDialog || (AFA.SearchSimpleTojitsuDialog = {}));
    var SearchSimpleTojitsuDialog = AFA.SearchSimpleTojitsuDialog;
})(AFA || (AFA = {}));
