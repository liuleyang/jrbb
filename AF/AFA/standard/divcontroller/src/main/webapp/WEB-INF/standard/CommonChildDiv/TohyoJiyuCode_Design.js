var AFA;
(function (AFA) {
    (function (TohyoJiyuCode) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_txtTohyoJiyuCode = function () {
                return "onChange_txtTohyoJiyuCode";
            };

            Events.onBlur_txtTohyoJiyuCode = function () {
                return "onBlur_txtTohyoJiyuCode";
            };

            Events.onChange_ddlTohyoJiyu = function () {
                return "onChange_ddlTohyoJiyu";
            };
            return Events;
        })();
        TohyoJiyuCode.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyoJiyuCode";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyoJiyuCode.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyoJiyuCode.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyoJiyuCode = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTohyoJiyuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyoJiyuCode"));
            };

            Controls.prototype.ddlTohyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJiyu"));
            };
            return Controls;
        })();
        TohyoJiyuCode.Controls = Controls;
    })(AFA.TohyoJiyuCode || (AFA.TohyoJiyuCode = {}));
    var TohyoJiyuCode = AFA.TohyoJiyuCode;
})(AFA || (AFA = {}));
