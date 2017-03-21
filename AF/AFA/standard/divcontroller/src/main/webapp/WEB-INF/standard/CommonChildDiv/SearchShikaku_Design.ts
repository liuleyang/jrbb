/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./TohyokuCodeSelect.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />
/// <reference path="./JiyuNameList.ts" />

module AFA {

     export module SearchShikaku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SearchShikaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SearchShikaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SearchShikaku.Controls.myType() + "_" + fieldName;
            }

            public SearchShikaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ccdTohyokuCode(): AFA.TohyokuCodeSelect.ModeController {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            }

            public chkSearchSenkyoShikaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchSenkyoShikaku"));
            }

            public chkSearchTohyoShikaku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchTohyoShikaku"));
            }

            public SearchShikakuShosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchShikakuShosai"));
            }

            public txtSearchTorokuYmd(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchTorokuYmd"));
            }

            public ccdSearchTorokuJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchTorokuJiyu"));
            }

            public txtSearchTeishiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchTeishiYMD"));
            }

            public ccdSearchTeishiJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchTeishiJiyu"));
            }

            public txtSearchMasshoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchMasshoYMD"));
            }

            public ccdSearchMasshoJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchMasshoJiyu"));
            }

            public txtSearchHyojiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchHyojiYMD"));
            }

            public ccdSearchHyojiJiyu(): AFA.JiyuNameList.ModeController {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchHyojiJiyu"));
            }

            public txtSearchShojoYoteiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchShojoYoteiYMD"));
            }

            public txtSearchShojoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchShojoYMD"));
            }

            public txtSearchKeikiShuryoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchKeikiShuryoYMD"));
            }

            public chk2keiMochi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chk2keiMochi"));
            }

        }

     }

}

