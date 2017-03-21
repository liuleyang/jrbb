var AFA;
(function (AFA) {
    (function (SenkyoShuruiSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlSenkyoShurui = function () {
                return "onChange_ddlSenkyoShurui";
            };
            return Events;
        })();
        SenkyoShuruiSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SenkyoShuruiSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SenkyoShuruiSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SenkyoShuruiSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SenkyoShuruiSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlSenkyoShurui = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSenkyoShurui"));
            };
            return Controls;
        })();
        SenkyoShuruiSelect.Controls = Controls;
    })(AFA.SenkyoShuruiSelect || (AFA.SenkyoShuruiSelect = {}));
    var SenkyoShuruiSelect = AFA.SenkyoShuruiSelect;
})(AFA || (AFA = {}));
