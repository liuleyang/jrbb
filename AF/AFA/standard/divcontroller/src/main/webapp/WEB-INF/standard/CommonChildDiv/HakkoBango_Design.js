var AFA;
(function (AFA) {
    (function (HakkoBango) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HakkoBango.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HakkoBango";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.HakkoBango.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.HakkoBango.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HakkoBango = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHakkoNoDai = function () {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoDai"));
            };

            Controls.prototype.txtHakkoNoBango = function () {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoBango"));
            };

            Controls.prototype.txtHakkoNoGo = function () {
                return new UZA.TextBox(this.convFiledName("txtHakkoNoGo"));
            };
            return Controls;
        })();
        HakkoBango.Controls = Controls;
    })(AFA.HakkoBango || (AFA.HakkoBango = {}));
    var HakkoBango = AFA.HakkoBango;
})(AFA || (AFA = {}));
