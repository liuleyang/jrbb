var AFA;
(function (AFA) {
    (function (KojinJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KojinJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KojinJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KojinJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KojinJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KojinJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKojinJohoUR = function () {
                return new UAX.AtenaShokaiSimple.ModeController(this.convFiledName("ccdKojinJohoUR"));
            };
            return Controls;
        })();
        KojinJoho.Controls = Controls;
    })(AFA.KojinJoho || (AFA.KojinJoho = {}));
    var KojinJoho = AFA.KojinJoho;
})(AFA || (AFA = {}));
