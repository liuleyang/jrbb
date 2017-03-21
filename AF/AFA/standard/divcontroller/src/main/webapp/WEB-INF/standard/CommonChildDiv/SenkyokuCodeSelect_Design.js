var AFA;
(function (AFA) {
    (function (SenkyokuCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtSenkyokuCode = function () {
                return "onBlur_txtSenkyokuCode";
            };

            Events.onClick_btnDialog = function () {
                return "onClick_btnDialog";
            };

            Events.onBeforeClick_btnDialog = function () {
                return "onBeforeClick_btnDialog";
            };
            return Events;
        })();
        SenkyokuCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SenkyokuCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SenkyokuCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SenkyokuCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SenkyokuCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSenkyokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSenkyokuCode"));
            };

            Controls.prototype.btnSenkyokuCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSenkyokuCode"));
            };

            Controls.prototype.txtSenkyokuName = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyokuName"));
            };
            return Controls;
        })();
        SenkyokuCodeSelect.Controls = Controls;
    })(AFA.SenkyokuCodeSelect || (AFA.SenkyokuCodeSelect = {}));
    var SenkyokuCodeSelect = AFA.SenkyokuCodeSelect;
})(AFA || (AFA = {}));
