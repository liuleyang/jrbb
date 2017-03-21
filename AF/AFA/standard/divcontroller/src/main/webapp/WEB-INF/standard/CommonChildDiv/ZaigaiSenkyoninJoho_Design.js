var AFA;
(function (AFA) {
    (function (ZaigaiSenkyoninJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShinseiKubun = function () {
                return "onChange_radShinseiKubun";
            };

            Events.onClick_btnShinseiNoSaiban = function () {
                return "onClick_btnShinseiNoSaiban";
            };

            Events.onBlur_txtKofuNo = function () {
                return "onBlur_txtKofuNo";
            };

            Events.onClick_btnKofuNoSaiban = function () {
                return "onClick_btnKofuNoSaiban";
            };
            return Events;
        })();
        ZaigaiSenkyoninJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ZaigaiSenkyoninJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ZaigaiSenkyoninJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ZaigaiSenkyoninJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZaigaiSenkyoninJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdHenkoJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHenkoJiyu"));
            };

            Controls.prototype.ZaigaiHonninJoho = function () {
                return new UZA.Panel(this.convFiledName("ZaigaiHonninJoho"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtSeinengappiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeinengappiYMD"));
            };

            Controls.prototype.txtShimeiKana = function () {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtShimeiKana"));
            };

            Controls.prototype.ddlSeibetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            };

            Controls.prototype.lblHonseki = function () {
                return new UZA.Label(this.convFiledName("lblHonseki"));
            };

            Controls.prototype.ccdHonsekiJusho = function () {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdHonsekiJusho"));
            };

            Controls.prototype.ccdHonsekiBanchi = function () {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdHonsekiBanchi"));
            };

            Controls.prototype.lblLastJusho = function () {
                return new UZA.Label(this.convFiledName("lblLastJusho"));
            };

            Controls.prototype.ccdLastJusho = function () {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdLastJusho"));
            };

            Controls.prototype.ccdLastBanchi = function () {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdLastBanchi"));
            };

            Controls.prototype.ccdLastKatagaki = function () {
                return new URA.KatagakiInput.ModeController(this.convFiledName("ccdLastKatagaki"));
            };

            Controls.prototype.txtTenshutsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuYMD"));
            };

            Controls.prototype.radHonsekichiToroku = function () {
                return new UZA.RadioButton(this.convFiledName("radHonsekichiToroku"));
            };

            Controls.prototype.ZaigaiZaijuJoho = function () {
                return new UZA.Panel(this.convFiledName("ZaigaiZaijuJoho"));
            };

            Controls.prototype.ccdKokuseki = function () {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdKokuseki"));
            };

            Controls.prototype.txtKaigaiJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtKaigaiJusho"));
            };

            Controls.prototype.txtDokyoKazoku = function () {
                return new UZA.TextBox(this.convFiledName("txtDokyoKazoku"));
            };

            Controls.prototype.txtKaigaiTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtKaigaiTelNo"));
            };

            Controls.prototype.txtKaigaiFaxNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtKaigaiFaxNo"));
            };

            Controls.prototype.txtKaigaiMailAddress = function () {
                return new UZA.TextBoxMailAddress(this.convFiledName("txtKaigaiMailAddress"));
            };

            Controls.prototype.ccdRyojikan = function () {
                return new AFA.RyojikanCodeSelect.ModeController(this.convFiledName("ccdRyojikan"));
            };

            Controls.prototype.txtJuteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJuteiYMD"));
            };

            Controls.prototype.lblSofusaki = function () {
                return new UZA.Label(this.convFiledName("lblSofusaki"));
            };

            Controls.prototype.txtKaigaiSofusakiJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtKaigaiSofusakiJusho"));
            };

            Controls.prototype.txtKaigaiSofusakiAtena = function () {
                return new UZA.TextBox(this.convFiledName("txtKaigaiSofusakiAtena"));
            };

            Controls.prototype.ZaigaiShinseiJoho = function () {
                return new UZA.Panel(this.convFiledName("ZaigaiShinseiJoho"));
            };

            Controls.prototype.btnKofuRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKofuRireki"));
            };

            Controls.prototype.ZaigaiShinseiKubun = function () {
                return new UZA.Panel(this.convFiledName("ZaigaiShinseiKubun"));
            };

            Controls.prototype.radShinseiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseiKubun"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtShinseiNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinseiNo"));
            };

            Controls.prototype.btnShinseiNoSaiban = function () {
                return new UZA.Button(this.convFiledName("btnShinseiNoSaiban"));
            };

            Controls.prototype.txtTorisageYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorisageYMD"));
            };

            Controls.prototype.ccdTorisageJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdTorisageJiyu"));
            };

            Controls.prototype.txtHonsekiShokaiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiShokaiYMD"));
            };

            Controls.prototype.txtHonsekiKaitoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiKaitoYMD"));
            };

            Controls.prototype.txtHonsekiTsutiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiTsutiYMD"));
            };

            Controls.prototype.txtKyakkaYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKyakkaYMD"));
            };

            Controls.prototype.ccdKyakkaJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdKyakkaJiyu"));
            };

            Controls.prototype.txtKofuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            };

            Controls.prototype.txtKofuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKofuNo"));
            };

            Controls.prototype.btnKofuNoSaiban = function () {
                return new UZA.Button(this.convFiledName("btnKofuNoSaiban"));
            };

            Controls.prototype.ccdSaiKofuJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSaiKofuJiyu"));
            };
            return Controls;
        })();
        ZaigaiSenkyoninJoho.Controls = Controls;
    })(AFA.ZaigaiSenkyoninJoho || (AFA.ZaigaiSenkyoninJoho = {}));
    var ZaigaiSenkyoninJoho = AFA.ZaigaiSenkyoninJoho;
})(AFA || (AFA = {}));
