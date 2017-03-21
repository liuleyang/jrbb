/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module KaikuSakuseiChohyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaikuSakuseiChohyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KaikuSakuseiChohyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KaikuSakuseiChohyo.Controls.myType() + "_" + fieldName;
            }

            public KaikuSakuseiChohyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KaikuSakuseiChohyoMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoMeiboShohon"));
            }

            public KaikuSakuseiChohyoTorokushasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoTorokushasuList"));
            }

            public txtTorokushasuListKijunYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            }

            public lblTorokusha(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTorokusha"));
            }

            public KaikuSakuseiChohyoIdoTorokushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoTorokushaMeibo"));
            }

            public chkTorokushaMeibo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeibo"));
            }

            public KaikuSakuseiChohyoIdoMasshoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoMasshoshaMeibo"));
            }

            public KaikuSakuseiChohyoIdoShikkenshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoShikkenshaMeibo"));
            }

            public KaikuSakuseiChohyoIdoHyojishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoHyojishaMeibo"));
            }

            public KaikuSakuseiChohyoIdoTeiseishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoTeiseishaMeibo"));
            }

            public KaikuSakuseiChohyoIdoJukiIdoshaList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoJukiIdoshaList"));
            }

        }

     }

}

