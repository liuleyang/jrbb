var AFA;
(function (AFA) {
    (function (BarCodeNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_txtBarCode = function () {
                return "onChange_txtBarCode";
            };

            Events.onBlur_txtBarCode = function () {
                return "onBlur_txtBarCode";
            };

            Events.onClick_btnBarCode = function () {
                return "onClick_btnBarCode";
            };
            return Events;
        })();
        BarCodeNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "BarCodeNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.BarCodeNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.BarCodeNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.BarCodeNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtBarCode = function () {
                return new UZA.TextBox(this.convFiledName("txtBarCode"));
            };

            Controls.prototype.btnBarCode = function () {
                return new UZA.Button(this.convFiledName("btnBarCode"));
            };

            Controls.prototype.length = function () {
                return new UZA.Label(this.convFiledName("length"));
            };
            return Controls;
        })();
        BarCodeNyuryoku.Controls = Controls;
    })(AFA.BarCodeNyuryoku || (AFA.BarCodeNyuryoku = {}));
    var BarCodeNyuryoku = AFA.BarCodeNyuryoku;
})(AFA || (AFA = {}));
