var AFA;
(function (AFA) {
    (function (HojoshaSelectDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton = function () {
                return "onSelectBySelectButton";
            };

            Events.cancel = function () {
                return "cancel";
            };
            return Events;
        })();
        HojoshaSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HojoshaSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.HojoshaSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.HojoshaSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HojoshaSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonName = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonName"));
            };

            Controls.prototype.dgHojoshaSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgHojoshaSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        HojoshaSelectDialog.Controls = Controls;
    })(AFA.HojoshaSelectDialog || (AFA.HojoshaSelectDialog = {}));
    var HojoshaSelectDialog = AFA.HojoshaSelectDialog;
})(AFA || (AFA = {}));
