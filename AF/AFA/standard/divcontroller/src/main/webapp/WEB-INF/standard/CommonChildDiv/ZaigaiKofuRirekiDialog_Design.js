var AFA;
(function (AFA) {
    (function (ZaigaiKofuRirekiDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ZaigaiKofuRirekiDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ZaigaiKofuRirekiDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ZaigaiKofuRirekiDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ZaigaiKofuRirekiDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZaigaiKofuRirekiDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKofuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgKofuRireki"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ZaigaiKofuRirekiDialog.Controls = Controls;
    })(AFA.ZaigaiKofuRirekiDialog || (AFA.ZaigaiKofuRirekiDialog = {}));
    var ZaigaiKofuRirekiDialog = AFA.ZaigaiKofuRirekiDialog;
})(AFA || (AFA = {}));
