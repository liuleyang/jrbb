var AFA;
(function (AFA) {
    (function (LabelSealPrintTaisho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_chkLabelSenseisho = function () {
                return "onChange_chkLabelSenseisho";
            };

            Events.onChange_chkLabelFuto = function () {
                return "onChange_chkLabelFuto";
            };

            Events.onChange_chkLabelShohon = function () {
                return "onChange_chkLabelShohon";
            };

            Events.onChange_chkLabelNyujoken = function () {
                return "onChange_chkLabelNyujoken";
            };
            return Events;
        })();
        LabelSealPrintTaisho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "LabelSealPrintTaisho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.LabelSealPrintTaisho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.LabelSealPrintTaisho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.LabelSealPrintTaisho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.chkFuzaishaTohyoShomeisho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaishaTohyoShomeisho"));
            };

            Controls.prototype.chkSenseisho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSenseisho"));
            };

            Controls.prototype.lblLabelSeal = function () {
                return new UZA.Label(this.convFiledName("lblLabelSeal"));
            };

            Controls.prototype.chkLabelSenseisho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelSenseisho"));
            };

            Controls.prototype.txtMaisuSenseisho = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuSenseisho"));
            };

            Controls.prototype.chkLabelFuto = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelFuto"));
            };

            Controls.prototype.txtMaisuFuto = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuFuto"));
            };

            Controls.prototype.chkSenkyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSenkyo"));
            };

            Controls.prototype.chkLabelShohon = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelShohon"));
            };

            Controls.prototype.txtMaisuShohon = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuShohon"));
            };

            Controls.prototype.chkLabelNyujoken = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelNyujoken"));
            };

            Controls.prototype.txtMaisuNyujoken = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuNyujoken"));
            };
            return Controls;
        })();
        LabelSealPrintTaisho.Controls = Controls;
    })(AFA.LabelSealPrintTaisho || (AFA.LabelSealPrintTaisho = {}));
    var LabelSealPrintTaisho = AFA.LabelSealPrintTaisho;
})(AFA || (AFA = {}));
