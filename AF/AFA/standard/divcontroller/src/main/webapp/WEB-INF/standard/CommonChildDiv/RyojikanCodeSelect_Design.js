var AFA;
(function (AFA) {
    (function (RyojikanCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtRyojikanCode = function () {
                return "onBlur_txtRyojikanCode";
            };

            Events.onBeforeOpenDialog_checkRyojikanSelect = function () {
                return "onBeforeOpenDialog_checkRyojikanSelect";
            };
            return Events;
        })();
        RyojikanCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RyojikanCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.RyojikanCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.RyojikanCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RyojikanCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtRyojikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRyojikanCode"));
            };

            Controls.prototype.btnRyojikanCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRyojikanCode"));
            };

            Controls.prototype.txtRyojikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtRyojikanName"));
            };
            return Controls;
        })();
        RyojikanCodeSelect.Controls = Controls;
    })(AFA.RyojikanCodeSelect || (AFA.RyojikanCodeSelect = {}));
    var RyojikanCodeSelect = AFA.RyojikanCodeSelect;
})(AFA || (AFA = {}));
