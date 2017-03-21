var AFA;
(function (AFA) {
    (function (KumiaiSelectDialog) {
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
        KumiaiSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KumiaiSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KumiaiSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KumiaiSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KumiaiSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKumiaiSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgKumiaiSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        KumiaiSelectDialog.Controls = Controls;
    })(AFA.KumiaiSelectDialog || (AFA.KumiaiSelectDialog = {}));
    var KumiaiSelectDialog = AFA.KumiaiSelectDialog;
})(AFA || (AFA = {}));
