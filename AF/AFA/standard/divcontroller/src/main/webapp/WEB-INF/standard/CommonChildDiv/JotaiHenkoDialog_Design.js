var AFA;
(function (AFA) {
    (function (JotaiHenkoDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnOk = function () {
                return "onClick_btnOk";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        JotaiHenkoDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JotaiHenkoDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.JotaiHenkoDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.JotaiHenkoDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JotaiHenkoDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtShikibetsuCode"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtSetaiCode = function () {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtSetaiCode"));
            };

            Controls.prototype.txtGroupCode = function () {
                return new UZA.TextBox(this.convFiledName("txtGroupCode"));
            };

            Controls.prototype.txtTohyokuCode = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyokuCode"));
            };

            Controls.prototype.ccdMeiboBango = function () {
                return new AFA.MeiboBango.ModeController(this.convFiledName("ccdMeiboBango"));
            };

            Controls.prototype.linLine = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine"));
            };

            Controls.prototype.lblNo = function () {
                return new UZA.Label(this.convFiledName("lblNo"));
            };

            Controls.prototype.lblSenkyoMei = function () {
                return new UZA.Label(this.convFiledName("lblSenkyoMei"));
            };

            Controls.prototype.lblTohyoJokyo = function () {
                return new UZA.Label(this.convFiledName("lblTohyoJokyo"));
            };

            Controls.prototype.txtNo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo1"));
            };

            Controls.prototype.txtSenkyoMei1 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei1"));
            };

            Controls.prototype.txtTohyoJokyo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo1"));
            };

            Controls.prototype.ddlTohyoJokyo1 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo1"));
            };

            Controls.prototype.LabelTohyoJokyo1 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo1"));
            };

            Controls.prototype.txtNo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo2"));
            };

            Controls.prototype.txtSenkyoMei2 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei2"));
            };

            Controls.prototype.txtTohyoJokyo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo2"));
            };

            Controls.prototype.ddlTohyoJokyo2 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo2"));
            };

            Controls.prototype.LabelTohyoJokyo2 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo2"));
            };

            Controls.prototype.txtNo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo3"));
            };

            Controls.prototype.txtSenkyoMei3 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei3"));
            };

            Controls.prototype.txtTohyoJokyo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo3"));
            };

            Controls.prototype.ddlTohyoJokyo3 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo3"));
            };

            Controls.prototype.LabelTohyoJokyo3 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo3"));
            };

            Controls.prototype.txtNo4 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo4"));
            };

            Controls.prototype.txtSenkyoMei4 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei4"));
            };

            Controls.prototype.txtTohyoJokyo4 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo4"));
            };

            Controls.prototype.ddlTohyoJokyo4 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo4"));
            };

            Controls.prototype.LabelTohyoJokyo4 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo4"));
            };

            Controls.prototype.txtNo5 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo5"));
            };

            Controls.prototype.txtSenkyoMei5 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei5"));
            };

            Controls.prototype.txtTohyoJokyo5 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo5"));
            };

            Controls.prototype.ddlTohyoJokyo5 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo5"));
            };

            Controls.prototype.LabelTohyoJokyo5 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo5"));
            };

            Controls.prototype.txtNo6 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo6"));
            };

            Controls.prototype.txtSenkyoMei6 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei6"));
            };

            Controls.prototype.txtTohyoJokyo6 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo6"));
            };

            Controls.prototype.ddlTohyoJokyo6 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo6"));
            };

            Controls.prototype.LabelTohyoJokyo6 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo6"));
            };

            Controls.prototype.txtNo7 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo7"));
            };

            Controls.prototype.txtSenkyoMei7 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei7"));
            };

            Controls.prototype.txtTohyoJokyo7 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo7"));
            };

            Controls.prototype.ddlTohyoJokyo7 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo7"));
            };

            Controls.prototype.LabelTohyoJokyo7 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo7"));
            };

            Controls.prototype.txtNo8 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo8"));
            };

            Controls.prototype.txtSenkyoMei8 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei8"));
            };

            Controls.prototype.txtTohyoJokyo8 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo8"));
            };

            Controls.prototype.ddlTohyoJokyo8 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo8"));
            };

            Controls.prototype.LabelTohyoJokyo8 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo8"));
            };

            Controls.prototype.txtNo9 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo9"));
            };

            Controls.prototype.txtSenkyoMei9 = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoMei9"));
            };

            Controls.prototype.txtTohyoJokyo9 = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyoJokyo9"));
            };

            Controls.prototype.ddlTohyoJokyo9 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJokyo9"));
            };

            Controls.prototype.LabelTohyoJokyo9 = function () {
                return new UZA.Label(this.convFiledName("LabelTohyoJokyo9"));
            };

            Controls.prototype.btnOK = function () {
                return new UZA.Button(this.convFiledName("btnOK"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        JotaiHenkoDialog.Controls = Controls;
    })(AFA.JotaiHenkoDialog || (AFA.JotaiHenkoDialog = {}));
    var JotaiHenkoDialog = AFA.JotaiHenkoDialog;
})(AFA || (AFA = {}));
