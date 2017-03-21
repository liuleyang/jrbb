var AFA;
(function (AFA) {
    (function (MeiboBango) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        MeiboBango.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "MeiboBango";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.MeiboBango.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.MeiboBango.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.MeiboBango = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSatsu = function () {
                return new UZA.TextBox(this.convFiledName("txtSatsu"));
            };

            Controls.prototype.txtPage = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPage"));
            };

            Controls.prototype.txtGyo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGyo"));
            };
            return Controls;
        })();
        MeiboBango.Controls = Controls;
    })(AFA.MeiboBango || (AFA.MeiboBango = {}));
    var MeiboBango = AFA.MeiboBango;
})(AFA || (AFA = {}));
