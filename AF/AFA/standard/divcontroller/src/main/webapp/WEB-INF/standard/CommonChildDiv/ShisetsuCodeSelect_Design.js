var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtShisetsuCode = function () {
                return "onBlur_txtShisetsuCode";
            };

            Events.onChange_txtShisetsuCode = function () {
                return "onChange_txtShisetsuCode";
            };

            Events.onOKClose_btnShisetsuCode = function () {
                return "onOKClose_btnShisetsuCode";
            };

            Events.onBeforeOpenDialog_btnShisetsuCode = function () {
                return "onBeforeOpenDialog_btnShisetsuCode";
            };
            return Events;
        })();
        ShisetsuCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShisetsuCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShisetsuCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShisetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            };

            Controls.prototype.btnShisetsuCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShisetsuCode"));
            };

            Controls.prototype.txtShisetsuName = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuName"));
            };
            return Controls;
        })();
        ShisetsuCodeSelect.Controls = Controls;
    })(AFA.ShisetsuCodeSelect || (AFA.ShisetsuCodeSelect = {}));
    var ShisetsuCodeSelect = AFA.ShisetsuCodeSelect;
})(AFA || (AFA = {}));
