/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./TohyokuCodeSelectRange.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />

module AFA {

     export module SakuseiChohyo {

        export class Events {

            public static onOpen_SakuseiChohyoEikyuSenkyoninMeibo(): string {
                return "onOpen_SakuseiChohyoEikyuSenkyoninMeibo";
            }

            public static onClose_SakuseiChohyoEikyuSenkyoninMeibo(): string {
                return "onClose_SakuseiChohyoEikyuSenkyoninMeibo";
            }

            public static onChange_RadEikyuMeiboShoriKubun(): string {
                return "onChange_RadEikyuMeiboShoriKubun";
            }

            public static onOpen_SakuseiChohyoTorokushasuList(): string {
                return "onOpen_SakuseiChohyoTorokushasuList";
            }

            public static onClose_SakuseiChohyoTorokushasuList(): string {
                return "onClose_SakuseiChohyoTorokushasuList";
            }

            public static onOpen_SakuseiChohyoNijuTorokuTsuchi(): string {
                return "onOpen_SakuseiChohyoNijuTorokuTsuchi";
            }

            public static onClose_SakuseiChohyoNijuTorokuTsuchi(): string {
                return "onClose_SakuseiChohyoNijuTorokuTsuchi";
            }

            public static onOpen_SakuseiChohyoNijuChosahyo(): string {
                return "onOpen_SakuseiChohyoNijuChosahyo";
            }

            public static onClose_SakuseiChohyoNijuChosahyo(): string {
                return "onClose_SakuseiChohyoNijuChosahyo";
            }

            public static onOpen_SakuseiChohyoIdoTorokushaMeibo(): string {
                return "onOpen_SakuseiChohyoIdoTorokushaMeibo";
            }

            public static onClose_SakuseiChohyoIdoTorokushaMeibo(): string {
                return "onClose_SakuseiChohyoIdoTorokushaMeibo";
            }

            public static onOpen_SakuseiChohyoIdoKikaMeibo(): string {
                return "onOpen_SakuseiChohyoIdoKikaMeibo";
            }

            public static onClose_SakuseiChohyoIdoKikaMeibo(): string {
                return "onClose_SakuseiChohyoIdoKikaMeibo";
            }

            public static onOpen_SakuseiChohyoIdoMasshoshaMeibo(): string {
                return "onOpen_SakuseiChohyoIdoMasshoshaMeibo";
            }

            public static onClose_SakuseiChohyoIdoMasshoshaMeibo(): string {
                return "onClose_SakuseiChohyoIdoMasshoshaMeibo";
            }

            public static onOpen_SakuseiChohyoIdo19saishaMeibo(): string {
                return "onOpen_SakuseiChohyoIdo19saishaMeibo";
            }

            public static onClose_SakuseiChohyoIdo19saishaMeibo(): string {
                return "onClose_SakuseiChohyoIdo19saishaMeibo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SakuseiChohyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SakuseiChohyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SakuseiChohyo.Controls.myType() + "_" + fieldName;
            }

            public SakuseiChohyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SakuseiChohyoSenkyoninMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoSenkyoninMeiboShohon"));
            }

            public ccdTohyokuCodeRange(): AFA.TohyokuCodeSelectRange.ModeController {
                return new AFA.TohyokuCodeSelectRange.ModeController(this.convFiledName("ccdTohyokuCodeRange"));
            }

            public SakuseiChohyoEikyuSenkyoninMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoEikyuSenkyoninMeibo"));
            }

            public radEikyuMeiboShoriKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radEikyuMeiboShoriKubun"));
            }

            public txtEikyuMeiboShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtEikyuMeiboShikibetsuCode"));
            }

            public txtEikyuMeiboShiteiYmdRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtEikyuMeiboShiteiYmdRange"));
            }

            public ddlEikyuMeiboIdoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlEikyuMeiboIdoJiyu"));
            }

            public SakuseiChohyoSenkyoninMeiboSakuinbo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoSenkyoninMeiboSakuinbo"));
            }

            public SakuseiChohyoTorokushasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoTorokushasuList"));
            }

            public txtTorokushasuListKijunYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            }

            public lblTorokushasuListKijunYmd(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTorokushasuListKijunYmd"));
            }

            public chkTorokuListFuzaishabun(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokuListFuzaishabun"));
            }

            public chkFuzaiTohyoMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaiTohyoMeibo"));
            }

            public SakuseiChohyoYukenshasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoYukenshasuList"));
            }

            public SakuseiChohyoNijuTorokuTsuchi(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoNijuTorokuTsuchi"));
            }

            public ccdPrintNaiyoNijuTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoNijuTsuchi"));
            }

            public txtTennyuKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTennyuKikan"));
            }

            public chkSealNijuTsuchi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealNijuTsuchi"));
            }

            public chkNijuTsuchiIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNijuTsuchiIchiran"));
            }

            public SakuseiChohyoNijuChosahyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoNijuChosahyo"));
            }

            public ccdPrintNaiyoNijuChosa(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoNijuChosa"));
            }

            public txtTenshutsuKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTenshutsuKikan"));
            }

            public chkSealNijuChosahyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealNijuChosahyo"));
            }

            public chkNijuChosahyoIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNijuChosahyoIchiran"));
            }

            public SakuseiChohyoIdoTorokushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTorokushaMeibo"));
            }

            public chkTorokushaMeiboJuran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeiboJuran"));
            }

            public chkSealTorokushaMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealTorokushaMeibo"));
            }

            public SakuseiChohyoIdoKikaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoKikaMeibo"));
            }

            public txtKikaKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKikaKikan"));
            }

            public SakuseiChohyoIdoMasshoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMasshoshaMeibo"));
            }

            public chkMasshoshaMeiboJuran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoshaMeiboJuran"));
            }

            public SakuseiChohyoIdoGakuseiMasshoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoGakuseiMasshoshaMeibo"));
            }

            public SakuseiChohyoIdoMasshoYoteishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMasshoYoteishaMeibo"));
            }

            public SakuseiChohyoIdoShikkenshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoShikkenshaMeibo"));
            }

            public SakuseiChohyoIdoHyojishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojishaMeibo"));
            }

            public SakuseiChohyoIdoHyojiShojoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojiShojoshaMeibo"));
            }

            public SakuseiChohyoIdoHyojiShojoYoteishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojiShojoYoteishaMeibo"));
            }

            public SakuseiChohyoIdo19saishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdo19saishaMeibo"));
            }

            public chkSeal19saishaMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal19saishaMeibo"));
            }

            public SakuseiChohyoIdoMiseinenshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMiseinenshaMeibo"));
            }

            public SakuseiChohyoIdoSaiTennyushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoSaiTennyushaMeibo"));
            }

            public SakuseiChohyoIdoTeiseishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTeiseishaMeibo"));
            }

            public SakuseiChohyoIdoTenshutsushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTenshutsushaMeibo"));
            }

            public SakuseiChohyoIdoTeishishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTeishishaMeibo"));
            }

            public SakuseiChohyoZaigai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SakuseiChohyoZaigai"));
            }

            public SakuseiChohyoZaigaiSenkyoninMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiSenkyoninMeiboShohon"));
            }

            public SakuseiChohyoZaigaiShikakushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiShikakushaMeibo"));
            }

            public SakuseiChohyoZaigaiTohyoKanrihyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiTohyoKanrihyo"));
            }

        }

     }

}

