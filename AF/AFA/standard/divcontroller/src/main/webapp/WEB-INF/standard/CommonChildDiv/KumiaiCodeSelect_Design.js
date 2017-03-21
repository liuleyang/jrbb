var AFA;
(function (AFA) {
    (function (KumiaiCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtSenkyokuCode = function () {
                return "onBlur_txtSenkyokuCode";
            };

            Events.onBeforeOpenDialog_checkBtnKumiaiCode = function () {
                return "onBeforeOpenDialog_checkBtnKumiaiCode";
            };
            return Events;
        })();
        KumiaiCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KumiaiCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KumiaiCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KumiaiCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KumiaiCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKumiaiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKumiaiCode"));
            };

            Controls.prototype.btnKumiaiCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKumiaiCode"));
            };

            Controls.prototype.txtKumiaiName = function () {
                return new UZA.TextBox(this.convFiledName("txtKumiaiName"));
            };
            return Controls;
        })();
        KumiaiCodeSelect.Controls = Controls;
    })(AFA.KumiaiCodeSelect || (AFA.KumiaiCodeSelect = {}));
    var KumiaiCodeSelect = AFA.KumiaiCodeSelect;
})(AFA || (AFA = {}));
