var AFA;
(function (AFA) {
    (function (MeiboSakuseiKijun) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radShori = function () {
                return "onClick_radShori";
            };

            Events.onBlur_txtTohyoYMD = function () {
                return "onBlur_txtTohyoYMD";
            };

            Events.onClick_btnSetYmd = function () {
                return "onClick_btnSetYmd";
            };

            Events.onClick_btnAddRowSenkyo = function () {
                return "onClick_btnAddRowSenkyo";
            };

            Events.onClick_btnCopySenkyo = function () {
                return "onClick_btnCopySenkyo";
            };

            Events.onClick_btnSetChohyoYmd = function () {
                return "onClick_btnSetChohyoYmd";
            };

            Events.onClick_btnHdnChangeShohon = function () {
                return "onClick_btnHdnChangeShohon";
            };
            return Events;
        })();
        MeiboSakuseiKijun.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "MeiboSakuseiKijun";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.MeiboSakuseiKijun.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.MeiboSakuseiKijun.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.MeiboSakuseiKijun = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShori = function () {
                return new UZA.RadioButton(this.convFiledName("radShori"));
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.txtShohonName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.txtKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            };

            Controls.prototype.btnSetYmd = function () {
                return new UZA.Button(this.convFiledName("btnSetYmd"));
            };

            Controls.prototype.txtMeiboTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            };

            Controls.prototype.txtTenshutsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuYMD"));
            };

            Controls.prototype.lblTenshutsuYMD = function () {
                return new UZA.Label(this.convFiledName("lblTenshutsuYMD"));
            };

            Controls.prototype.txtTennyuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTennyuYMD"));
            };

            Controls.prototype.lblTennyuYMD = function () {
                return new UZA.Label(this.convFiledName("lblTennyuYMD"));
            };

            Controls.prototype.txtNenreiTotatsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            };

            Controls.prototype.lblNenreiTotatsuYMD = function () {
                return new UZA.Label(this.convFiledName("lblNenreiTotatsuYMD"));
            };

            Controls.prototype.SenkyoNyuryoku = function () {
                return new UZA.Panel(this.convFiledName("SenkyoNyuryoku"));
            };

            Controls.prototype.btnAddRowSenkyo = function () {
                return new UZA.Button(this.convFiledName("btnAddRowSenkyo"));
            };

            Controls.prototype.btnCopySenkyo = function () {
                return new UZA.Button(this.convFiledName("btnCopySenkyo"));
            };

            Controls.prototype.chkKenshuDataCreate = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKenshuDataCreate"));
            };

            Controls.prototype.dgSenkyojiSenkyoNyuryoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgSenkyojiSenkyoNyuryoku"));
            };

            Controls.prototype.btnSetChohyoYmd = function () {
                return new UZA.Button(this.convFiledName("btnSetChohyoYmd"));
            };

            Controls.prototype.btnHdnChangeShohon = function () {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            };
            return Controls;
        })();
        MeiboSakuseiKijun.Controls = Controls;
    })(AFA.MeiboSakuseiKijun || (AFA.MeiboSakuseiKijun = {}));
    var MeiboSakuseiKijun = AFA.MeiboSakuseiKijun;
})(AFA || (AFA = {}));
