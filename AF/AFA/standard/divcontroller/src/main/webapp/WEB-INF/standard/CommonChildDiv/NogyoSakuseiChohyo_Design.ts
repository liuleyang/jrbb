/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module NogyoSakuseiChohyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NogyoSakuseiChohyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.NogyoSakuseiChohyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.NogyoSakuseiChohyo.Controls.myType() + "_" + fieldName;
            }

            public NogyoSakuseiChohyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public NogyoSakuseiChohyoCheckList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoCheckList"));
            }

            public NogyoSakuseiChohyoMeiboShohon(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoMeiboShohon"));
            }

            public NogyoSakuseiChohyoTorokushasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoTorokushasuList"));
            }

            public NogyoSakuseiChohyoYukenshasuList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoYukenshasuList"));
            }

            public NogyoSakuseiChohyoIdoTorokushaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoTorokushaMeibo"));
            }

            public NogyoSakuseiChohyoIdoMasshoshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoMasshoshaMeibo"));
            }

            public NogyoSakuseiChohyoIdoShikkenshaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoShikkenshaMeibo"));
            }

            public NogyoSakuseiChohyoIdoHyojishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoHyojishaMeibo"));
            }

            public NogyoSakuseiChohyoIdoTeiseishaMeibo(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoTeiseishaMeibo"));
            }

            public NogyoSakuseiChohyoIdoJukiIdoshaList(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoJukiIdoshaList"));
            }

        }

     }

}

