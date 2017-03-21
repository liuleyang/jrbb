var AFA;
(function (AFA) {
    (function (FuzaishaShikaku) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_btnRadShikakuKubun = function () {
                return "onChange_btnRadShikakuKubun";
            };

            Events.onBlur_txtKofuYMD = function () {
                return "onBlur_txtKofuYMD";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        FuzaishaShikaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "FuzaishaShikaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.FuzaishaShikaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.FuzaishaShikaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.FuzaishaShikaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShikakuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikakuKubun"));
            };

            Controls.prototype.txtShikakuTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShikakuTorokuYMD"));
            };

            Controls.prototype.txtKofuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            };

            Controls.prototype.txtManryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtManryoYMD"));
            };

            Controls.prototype.txtMasshoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            };

            Controls.prototype.ccdMasshoJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        FuzaishaShikaku.Controls = Controls;
    })(AFA.FuzaishaShikaku || (AFA.FuzaishaShikaku = {}));
    var FuzaishaShikaku = AFA.FuzaishaShikaku;
})(AFA || (AFA = {}));
