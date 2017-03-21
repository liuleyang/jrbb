var AFA;
(function (AFA) {
    (function (YubinShikaku) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShikakuKubun = function () {
                return "onChange_radShikakuKubun";
            };

            Events.onBlur_txtKofuYMD = function () {
                return "onBlur_txtKofuYMD";
            };

            Events.onOkClose_btnSearchSimple = function () {
                return "onOkClose_btnSearchSimple";
            };

            Events.onBeforeOpenDialog_btnSearchSimple = function () {
                return "onBeforeOpenDialog_btnSearchSimple";
            };

            Events.onClick_btnDirectInput = function () {
                return "onClick_btnDirectInput";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onBlur_txtDairiSeinengappiYMD = function () {
                return "onBlur_txtDairiSeinengappiYMD";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        YubinShikaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YubinShikaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.YubinShikaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.YubinShikaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YubinShikaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShikakuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikakuKubun"));
            };

            Controls.prototype.chkShikakuJoken = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShikakuJoken"));
            };

            Controls.prototype.txtShikakuTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShikakuTorokuYMD"));
            };

            Controls.prototype.txtKofuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            };

            Controls.prototype.txtKofuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKofuNo"));
            };

            Controls.prototype.btnSaiban = function () {
                return new UZA.Button(this.convFiledName("btnSaiban"));
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

            Controls.prototype.linLine = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine"));
            };

            Controls.prototype.lblKisaisha = function () {
                return new UZA.Label(this.convFiledName("lblKisaisha"));
            };

            Controls.prototype.btnSearchSimple = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSearchSimple"));
            };

            Controls.prototype.btnDirectInput = function () {
                return new UZA.Button(this.convFiledName("btnDirectInput"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.txtDairiKanjiShimei = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtDairiKanjiShimei"));
            };

            Controls.prototype.txtDairiSeinengappiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtDairiSeinengappiYMD"));
            };

            Controls.prototype.txtDairiNenrei = function () {
                return new UZA.TextBox(this.convFiledName("txtDairiNenrei"));
            };

            Controls.prototype.ddlDairiSeibetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlDairiSeibetsu"));
            };

            Controls.prototype.txtDairiJuminShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtDairiJuminShubetsu"));
            };

            Controls.prototype.txtDairiKanaShimei = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtDairiKanaShimei"));
            };

            Controls.prototype.txtDairiShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtDairiShikibetsuCode"));
            };

            Controls.prototype.txtDairiSetaiCode = function () {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtDairiSetaiCode"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtDairiJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtDairiJusho"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        YubinShikaku.Controls = Controls;
    })(AFA.YubinShikaku || (AFA.YubinShikaku = {}));
    var YubinShikaku = AFA.YubinShikaku;
})(AFA || (AFA = {}));
