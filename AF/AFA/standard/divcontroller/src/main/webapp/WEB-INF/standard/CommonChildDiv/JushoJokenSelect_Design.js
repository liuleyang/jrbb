var AFA;
(function (AFA) {
    (function (JushoJokenSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radJushoJoken = function () {
                return "onChange_radJushoJoken";
            };
            return Events;
        })();
        JushoJokenSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushoJokenSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.JushoJokenSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.JushoJokenSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushoJokenSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radJushoJoken = function () {
                return new UZA.RadioButton(this.convFiledName("radJushoJoken"));
            };

            Controls.prototype.dgJushoJokenList = function () {
                return new UZA.DataGrid(this.convFiledName("dgJushoJokenList"));
            };
            return Controls;
        })();
        JushoJokenSelect.Controls = Controls;
    })(AFA.JushoJokenSelect || (AFA.JushoJokenSelect = {}));
    var JushoJokenSelect = AFA.JushoJokenSelect;
})(AFA || (AFA = {}));
