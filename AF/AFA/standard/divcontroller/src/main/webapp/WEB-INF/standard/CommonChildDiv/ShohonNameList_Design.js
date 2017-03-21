var AFA;
(function (AFA) {
    (function (ShohonNameList) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlShohon = function () {
                return "onChange_ddlShohon";
            };

            Events.onclick_chkKakoShohon = function () {
                return "onclick_chkKakoShohon";
            };
            return Events;
        })();
        ShohonNameList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShohonNameList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShohonNameList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShohonNameList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShohonNameList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlShohon = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShohon"));
            };

            Controls.prototype.chkKakoShohon = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKakoShohon"));
            };
            return Controls;
        })();
        ShohonNameList.Controls = Controls;
    })(AFA.ShohonNameList || (AFA.ShohonNameList = {}));
    var ShohonNameList = AFA.ShohonNameList;
})(AFA || (AFA = {}));
