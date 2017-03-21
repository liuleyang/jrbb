/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./TohyoJiyuCode.ts" />
/// <reference path="./ShisetsuCodeSelect.ts" />
/// <reference path="./HojoshaNyuryoku.ts" />
/// <reference path="./KyohiJiyuNyuryoku.ts" />

module AFA {

     export module TohyoJokyoNyuryoku {

        export class Events {

            public static onClick_radTohyoJokyo(): string {
                return "onClick_radTohyoJokyo";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyoJokyoNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyoJokyoNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyoJokyoNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public TohyoJokyoNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TohyoJokyoSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TohyoJokyoSelect"));
            }

            public radTohyoJokyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTohyoJokyo"));
            }

            public dgTohyoJokyo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTohyoJokyo"));
            }

            public radSeikyusha(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeikyusha"));
            }

            public txtTohyoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            }

            public txtTohyoTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtTohyoTime"));
            }

            public ccdTohyoJiyu(): AFA.TohyoJiyuCode.ModeController {
                return new AFA.TohyoJiyuCode.ModeController(this.convFiledName("ccdTohyoJiyu"));
            }

            public chkTenjiYoshi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTenjiYoshi"));
            }

            public ccdKofuShisetsu(): AFA.ShisetsuCodeSelect.ModeController {
                return new AFA.ShisetsuCodeSelect.ModeController(this.convFiledName("ccdKofuShisetsu"));
            }

            public ccdDairiTohyo(): AFA.HojoshaNyuryoku.ModeController {
                return new AFA.HojoshaNyuryoku.ModeController(this.convFiledName("ccdDairiTohyo"));
            }

            public ccdKyohiJiyuNyuryoku(): AFA.KyohiJiyuNyuryoku.ModeController {
                return new AFA.KyohiJiyuNyuryoku.ModeController(this.convFiledName("ccdKyohiJiyuNyuryoku"));
            }

            public chkKariTohyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKariTohyo"));
            }

        }

     }

}

