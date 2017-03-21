var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelectRange) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_txtShisetsuCodeFrom = function () {
                return "onClick_txtShisetsuCodeFrom";
            };

            Events.onClick_txtShisetsuCodeTo = function () {
                return "onClick_txtShisetsuCodeTo";
            };

            Events.onClick_OKCloseFrom = function () {
                return "onClick_OKCloseFrom";
            };

            Events.onClick_OKCloseTo = function () {
                return "onClick_OKCloseTo";
            };
            return Events;
        })();
        ShisetsuCodeSelectRange.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuCodeSelectRange";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShisetsuCodeSelectRange.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShisetsuCodeSelectRange.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuCodeSelectRange = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnHiddenFrom = function () {
                return new UZA.Button(this.convFiledName("btnHiddenFrom"));
            };

            Controls.prototype.btnHiddenTo = function () {
                return new UZA.Button(this.convFiledName("btnHiddenTo"));
            };

            Controls.prototype.btnHiddenOKCloseFrom = function () {
                return new UZA.Button(this.convFiledName("btnHiddenOKCloseFrom"));
            };

            Controls.prototype.btnHiddenOKCloseTo = function () {
                return new UZA.Button(this.convFiledName("btnHiddenOKCloseTo"));
            };
            return Controls;
        })();
        ShisetsuCodeSelectRange.Controls = Controls;
    })(AFA.ShisetsuCodeSelectRange || (AFA.ShisetsuCodeSelectRange = {}));
    var ShisetsuCodeSelectRange = AFA.ShisetsuCodeSelectRange;
})(AFA || (AFA = {}));
