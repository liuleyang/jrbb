var AFA;
(function (AFA) {
    (function (ShohonSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnHdnChangeShohon = function () {
                return "onClick_btnHdnChangeShohon";
            };
            return Events;
        })();
        ShohonSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShohonSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShohonSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShohonSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShohonSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.txtPrintJotai = function () {
                return new UZA.TextBox(this.convFiledName("txtPrintJotai"));
            };

            Controls.prototype.btnHdnChangeShohon = function () {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            };

            Controls.prototype.dgShohonSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgShohonSelect"));
            };
            return Controls;
        })();
        ShohonSelect.Controls = Controls;
    })(AFA.ShohonSelect || (AFA.ShohonSelect = {}));
    var ShohonSelect = AFA.ShohonSelect;
})(AFA || (AFA = {}));
