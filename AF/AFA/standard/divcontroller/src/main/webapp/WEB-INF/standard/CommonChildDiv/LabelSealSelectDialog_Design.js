var AFA;
(function (AFA) {
    (function (LabelSealSelectDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnPrint = function () {
                return "onClick_btnPrint";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        LabelSealSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "LabelSealSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.LabelSealSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.LabelSealSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.LabelSealSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdLabelSealPrintTaisho = function () {
                return new AFA.LabelSealPrintTaisho.ModeController(this.convFiledName("ccdLabelSealPrintTaisho"));
            };

            Controls.prototype.ccdSealPosition = function () {
                return new UAX.AtenaSealPositionGuide.ModeController(this.convFiledName("ccdSealPosition"));
            };

            Controls.prototype.btnPrint = function () {
                return new UZA.Button(this.convFiledName("btnPrint"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        LabelSealSelectDialog.Controls = Controls;
    })(AFA.LabelSealSelectDialog || (AFA.LabelSealSelectDialog = {}));
    var LabelSealSelectDialog = AFA.LabelSealSelectDialog;
})(AFA || (AFA = {}));
