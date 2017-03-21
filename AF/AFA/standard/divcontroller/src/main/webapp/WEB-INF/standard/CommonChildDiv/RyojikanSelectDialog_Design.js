var AFA;
(function (AFA) {
    (function (RyojikanSelectDialog) {
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
        RyojikanSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RyojikanSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.RyojikanSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.RyojikanSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RyojikanSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgRyojikanSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgRyojikanSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        RyojikanSelectDialog.Controls = Controls;
    })(AFA.RyojikanSelectDialog || (AFA.RyojikanSelectDialog = {}));
    var RyojikanSelectDialog = AFA.RyojikanSelectDialog;
})(AFA || (AFA = {}));
