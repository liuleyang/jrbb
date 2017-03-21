var AFA;
(function (AFA) {
    (function (SenkyokuSelectDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton_closeOK = function () {
                return "onSelectBySelectButton_closeOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        SenkyokuSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SenkyokuSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SenkyokuSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SenkyokuSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SenkyokuSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdSenkyoShurui = function () {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
            };

            Controls.prototype.dgSenkyokuSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgSenkyokuSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        SenkyokuSelectDialog.Controls = Controls;
    })(AFA.SenkyokuSelectDialog || (AFA.SenkyokuSelectDialog = {}));
    var SenkyokuSelectDialog = AFA.SenkyokuSelectDialog;
})(AFA || (AFA = {}));
