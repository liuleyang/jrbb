var AFA;
(function (AFA) {
    (function (JiyuNameList) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlJiyuName = function () {
                return "onChange_ddlJiyuName";
            };
            return Events;
        })();
        JiyuNameList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JiyuNameList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.JiyuNameList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.JiyuNameList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JiyuNameList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlJiyuName = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJiyuName"));
            };
            return Controls;
        })();
        JiyuNameList.Controls = Controls;
    })(AFA.JiyuNameList || (AFA.JiyuNameList = {}));
    var JiyuNameList = AFA.JiyuNameList;
})(AFA || (AFA = {}));
