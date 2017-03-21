/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />

module AFA {

     export module KokuminSakuseiChohyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KokuminSakuseiChohyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KokuminSakuseiChohyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KokuminSakuseiChohyo.Controls.myType() + "_" + fieldName;
            }

            public KokuminSakuseiChohyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KokuminSakuseiChohyoMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoMeiboShohon"));
            }

            public KokuminSakuseiChohyoTorokushasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoTorokushasuList"));
            }

            public txtTorokushasuListKijunYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            }

            public lblTorokushasuList(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTorokushasuList"));
            }

            public chkTorokuListFuzaishabun(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokuListFuzaishabun"));
            }

            public chkFuzaiTohyoMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaiTohyoMeibo"));
            }

            public KokuminSakuseiChohyo1goShikakuTsuchi(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo1goShikakuTsuchi"));
            }

            public ccdPrintNaiyo1goTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyo1goTsuchi"));
            }

            public chkSeal1goTsuchi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal1goTsuchi"));
            }

            public chk1goTsuchiIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk1goTsuchiIchiran"));
            }

            public KokuminSakuseiChohyo2goShikakuChosahyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo2goShikakuChosahyo"));
            }

            public ccdPrintNaiyo2goChosahyo(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyo2goChosahyo"));
            }

            public chkSeal2goChosahyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal2goChosahyo"));
            }

            public chk2goChosaIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk2goChosaIchiran"));
            }

            public KokuminSakuseiChohyo2goKohoList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo2goKohoList"));
            }

            public KokuminSakuseiChohyoIdoTorokushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoTorokushaMeibo"));
            }

            public chkTorokushaMeiboJuran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeiboJuran"));
            }

            public chkSealTorokushaMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealTorokushaMeibo"));
            }

            public KokuminSakuseiChohyoIdoMasshoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoMasshoshaMeibo"));
            }

            public txtMasshoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            }

            public lblMasshoshaMeibo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMasshoshaMeibo"));
            }

            public chkMasshoshaMeiboJuran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoshaMeiboJuran"));
            }

            public KokuminSakuseiChohyoIdoTeiseishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoTeiseishaMeibo"));
            }

            public KokuminSakuseiChohyoMasshoTsuchi(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoMasshoTsuchi"));
            }

            public ccdPrintNaiyoMasshoTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoTsuchi"));
            }

            public chkSealMasshoTsuchi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealMasshoTsuchi"));
            }

            public chkMasshoTsuchiIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoTsuchiIchiran"));
            }

            public KokuminSakuseiChohyoKokunaiChosahyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoKokunaiChosahyo"));
            }

            public ccdPrintNaiyoKokunaiChosa(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoKokunaiChosa"));
            }

            public chkSealKokunaiChosa(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealKokunaiChosa"));
            }

            public chkKokunaiChosaIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKokunaiChosaIchiran"));
            }

            public KokuminSakuseiChohyoKokugaiChosahyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoKokugaiChosahyo"));
            }

            public ccdPrintNaiyoKokugaiChosa(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoKokugaiChosa"));
            }

            public chkSealKokugaiChosa(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSealKokugaiChosa"));
            }

            public chkKokugaiChosaIchiran(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKokugaiChosaIchiran"));
            }

            public KokuminSakuseiChohyoZaigai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokuminSakuseiChohyoZaigai"));
            }

            public KokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon"));
            }

            public KokuminSakuseiChohyoZaigaiShikakushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiShikakushaMeibo"));
            }

            public KokuminSakuseiChohyoZaigaiTohyoKanrihyo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiTohyoKanrihyo"));
            }

        }

     }

}

