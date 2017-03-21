/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./RyojikanCodeSelect.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="../d.ts/URZCommonChildDiv.d.ts" />
/// <reference path="../d.ts/URACommonChildDiv.d.ts" />

module AFA {

     export module ZaigaiSenkyoninJoho {

        export class Events {

            public static onChange_radShinseiKubun(): string {
                return "onChange_radShinseiKubun";
            }

            public static onClick_btnShinseiNoSaiban(): string {
                return "onClick_btnShinseiNoSaiban";
            }

            public static onBlur_txtKofuNo(): string {
                return "onBlur_txtKofuNo";
            }

            public static onClick_btnKofuNoSaiban(): string {
                return "onClick_btnKofuNoSaiban";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ZaigaiSenkyoninJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ZaigaiSenkyoninJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ZaigaiSenkyoninJoho.Controls.myType() + "_" + fieldName;
            }

            public ZaigaiSenkyoninJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdHenkoJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHenkoJiyu"));
            }

            public ZaigaiHonninJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaigaiHonninJoho"));
            }

            public txtShimei(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShimei"));
            }

            public txtSeinengappiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeinengappiYMD"));
            }

            public txtShimeiKana(): UZA.TextBoxAtenaKanaMeisho {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtShimeiKana"));
            }

            public ddlSeibetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            }

            public lblHonseki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHonseki"));
            }

            public ccdHonsekiJusho(): URZ.ZenkokuJushoInput.ModeController {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdHonsekiJusho"));
            }

            public ccdHonsekiBanchi(): URA.BanchiInput.ModeController {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdHonsekiBanchi"));
            }

            public lblLastJusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLastJusho"));
            }

            public ccdLastJusho(): URZ.ZenkokuJushoInput.ModeController {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdLastJusho"));
            }

            public ccdLastBanchi(): URA.BanchiInput.ModeController {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdLastBanchi"));
            }

            public ccdLastKatagaki(): URA.KatagakiInput.ModeController {
                return new URA.KatagakiInput.ModeController(this.convFiledName("ccdLastKatagaki"));
            }

            public txtTenshutsuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuYMD"));
            }

            public radHonsekichiToroku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHonsekichiToroku"));
            }

            public ZaigaiZaijuJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaigaiZaijuJoho"));
            }

            public ccdKokuseki(): URZ.CodeInput.ModeController {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdKokuseki"));
            }

            public txtKaigaiJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtKaigaiJusho"));
            }

            public txtDokyoKazoku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDokyoKazoku"));
            }

            public txtKaigaiTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtKaigaiTelNo"));
            }

            public txtKaigaiFaxNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtKaigaiFaxNo"));
            }

            public txtKaigaiMailAddress(): UZA.TextBoxMailAddress {
                return new UZA.TextBoxMailAddress(this.convFiledName("txtKaigaiMailAddress"));
            }

            public ccdRyojikan(): AFA.RyojikanCodeSelect.ModeController {
                return new AFA.RyojikanCodeSelect.ModeController(this.convFiledName("ccdRyojikan"));
            }

            public txtJuteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJuteiYMD"));
            }

            public lblSofusaki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSofusaki"));
            }

            public txtKaigaiSofusakiJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtKaigaiSofusakiJusho"));
            }

            public txtKaigaiSofusakiAtena(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaigaiSofusakiAtena"));
            }

            public ZaigaiShinseiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaigaiShinseiJoho"));
            }

            public btnKofuRireki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKofuRireki"));
            }

            public ZaigaiShinseiKubun(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaigaiShinseiKubun"));
            }

            public radShinseiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseiKubun"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public txtShinseiNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinseiNo"));
            }

            public btnShinseiNoSaiban(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShinseiNoSaiban"));
            }

            public txtTorisageYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorisageYMD"));
            }

            public ccdTorisageJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdTorisageJiyu"));
            }

            public txtHonsekiShokaiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiShokaiYMD"));
            }

            public txtHonsekiKaitoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiKaitoYMD"));
            }

            public txtHonsekiTsutiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHonsekiTsutiYMD"));
            }

            public txtKyakkaYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKyakkaYMD"));
            }

            public ccdKyakkaJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdKyakkaJiyu"));
            }

            public txtKofuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKofuYMD"));
            }

            public txtKofuNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKofuNo"));
            }

            public btnKofuNoSaiban(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKofuNoSaiban"));
            }

            public ccdSaiKofuJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSaiKofuJiyu"));
            }

        }

     }

}

