/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />
/// <reference path="./SakuseiChohyoPrintNaiyo.ts" />

module AFA {

     export module ZaigaiSakuseiChohyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ZaigaiSakuseiChohyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ZaigaiSakuseiChohyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ZaigaiSakuseiChohyo.Controls.myType() + "_" + fieldName;
            }

            public ZaigaiSakuseiChohyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi"));
            }

            public ccdPrintNaiyoHonsekichiShokaiKaitoTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHonsekichiShokaiKaitoTsuchi"));
            }

            public ZaigaiSakuseiChohyoTorikeshiHonnin(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoTorikeshiHonnin"));
            }

            public ccdPrintNaiyoTorikeshiHonnin(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorikeshiHonnin"));
            }

            public ZaigaiSakuseiChohyoTorikeshiRyojikan(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoTorikeshiRyojikan"));
            }

            public ccdPrintNaiyoTorikeshiRyojikan(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorikeshiRyojikan"));
            }

            public ZaigaiSakuseiChohyoToroku(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoToroku"));
            }

            public ccdPrintNaiyoTorokuTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorokuTsuchi"));
            }

            public ZaigaiSakuseiChohyoHenkoHonnin(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHenkoHonnin"));
            }

            public ccdPrintNaiyoHenkoHonnin(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHenkoHonnin"));
            }

            public ZaigaiSakuseiChohyoHenkoRyojikan(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHenkoRyojikan"));
            }

            public ccdPrintNaiyoHenkoRyojikan(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHenkoRyojikan"));
            }

            public ZaigaiSakuseiChohyoSaiKofu(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoSaiKofu"));
            }

            public ccdPrintNaiyoSaiKofuTsuchi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoSaiKofuTsuchi"));
            }

            public ZaigaiSakuseiChohyoMasshoHonsekichi(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoMasshoHonsekichi"));
            }

            public ccdPrintNaiyoMasshoHonsekichi(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoHonsekichi"));
            }

            public ZaigaiSakuseiChohyoMasshoRyojikan(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoMasshoRyojikan"));
            }

            public ccdPrintNaiyoMasshoRyojikan(): AFA.SakuseiChohyoPrintNaiyo.ModeController {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoRyojikan"));
            }

        }

     }

}

