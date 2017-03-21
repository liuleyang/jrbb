var AFA;
(function (AFA) {
    (function (KyohiJiyuNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyohiJiyuNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyohiJiyuNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KyohiJiyuNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KyohiJiyuNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyohiJiyuNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlKyohiJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKyohiJiyu"));
            };

            Controls.prototype.txtKyohiJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKyohiJiyu"));
            };
            return Controls;
        })();
        KyohiJiyuNyuryoku.Controls = Controls;
    })(AFA.KyohiJiyuNyuryoku || (AFA.KyohiJiyuNyuryoku = {}));
    var KyohiJiyuNyuryoku = AFA.KyohiJiyuNyuryoku;
})(AFA || (AFA = {}));
