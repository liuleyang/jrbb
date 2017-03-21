var AFA;
(function (AFA) {
    (function (ShisetsuSelectDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlShisetsuShubetsu = function () {
                return "onChange_ddlShisetsuShubetsu";
            };

            Events.onSelectBySelectButton_closeOK = function () {
                return "onSelectBySelectButton_closeOK";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        ShisetsuSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShisetsuSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShisetsuSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlShisetsuShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShisetsuShubetsu"));
            };

            Controls.prototype.dgShisetsuSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        ShisetsuSelectDialog.Controls = Controls;
    })(AFA.ShisetsuSelectDialog || (AFA.ShisetsuSelectDialog = {}));
    var ShisetsuSelectDialog = AFA.ShisetsuSelectDialog;
})(AFA || (AFA = {}));
