/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nippo.AFABTE503BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME5030_日報のhandler
 *
 * @reamsid_L AF-0270-010 xul
 */
public final class NippoSakuseiHandler {

    private final NippoSakuseiDiv div;
    private static final RString RST_0 = new RString("0");
    private static final RString RST_1 = new RString("1");
    private static final RString RST_2 = new RString("2");
    private static final RString RST_3 = new RString("3");
    private static final RString RST_4 = new RString("4");
    private static final RString RST_5 = new RString("5");

    private static final RString 請求のみ = new RString("請求のみ");
    private static final RString 未着者のみ = new RString("未着者のみ");
    private static final RString 代理投票のみ = new RString("代理投票のみ");
    private static final RString 点字投票のみ = new RString("点字投票のみ");
    private static final RString 返還のみ = new RString("返還のみ");
    private static final RString 棄権のみ = new RString("棄権のみ");
    private static final RString 受付拒否のみ = new RString("受付拒否のみ");
    private static final RString 仮投票のみ = new RString("仮投票のみ");

    private NippoSakuseiHandler(NippoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 日報Div
     * @return KojiKessaiShinseiPanelHandler
     */
    public static NippoSakuseiHandler of(NippoSakuseiDiv div) {
        return new NippoSakuseiHandler(div);
    }

    /**
     * コンストラクタ
     */
    public void set初期化状態() {
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().setIsOpen(false);
        div.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().setIsOpen(false);
    }

    /**
     * 各帳票の出力チェックボックスの初期表示する。
     */
    public void set帳票の出力() {

        RString 期日前投票日報 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_期日前投票日報, SubGyomuCode.AFA選挙本体);

        if (期日前投票日報.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().setIsPublish(false);
        } else if (期日前投票日報.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().setIsPublish(true);
        }
        RString 不在者投票日報 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_不在者投票日報, SubGyomuCode.AFA選挙本体);

        if (不在者投票日報.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().setIsPublish(false);
        } else if (不在者投票日報.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().setIsPublish(true);
        }

        RString 期日前投票者一覧表 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_期日前投票者一覧表, SubGyomuCode.AFA選挙本体);

        if (期日前投票者一覧表.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().setIsPublish(false);
        } else if (期日前投票者一覧表.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().setIsPublish(true);
        }

        RString 不在者投票者一覧表 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_不在者投票者一覧表, SubGyomuCode.AFA選挙本体);

        if (不在者投票者一覧表.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().setIsPublish(false);
        } else if (不在者投票者一覧表.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().setIsPublish(true);
        }

        RString 投票者一覧表 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_投票者一覧表, SubGyomuCode.AFA選挙本体);

        if (投票者一覧表.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().setIsPublish(false);
        } else if (投票者一覧表.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().setIsPublish(true);
        }

        RString 投票事由調書 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_投票事由調書, SubGyomuCode.AFA選挙本体);

        if (投票事由調書.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().setIsPublish(false);
        } else if (投票事由調書.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().setIsPublish(true);
        }

        RString 投票集計整理表 = getコンフィグ値(ConfigKeysAFA.帳票出力初期値_日報_投票集計整理表, SubGyomuCode.AFA選挙本体);

        if (投票集計整理表.equals(RST_0)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().setIsPublish(false);
        } else if (投票集計整理表.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().setIsPublish(true);
        }

        RString 不在者_請求のみ = getコンフィグ値(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);
        if (不在者_請求のみ.equals(RST_1)) {
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getChkFuzaishaIchiranTaisho().getDataSource().clear();
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaishaTaisho().getDataSource().clear();
            List<KeyValueDataSource> sourceList = new ArrayList();
            KeyValueDataSource source6 = new KeyValueDataSource();
            source6.setKey(RST_0);
            source6.setValue(請求のみ);
            sourceList.add(source6);
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(RST_1);
            source.setValue(未着者のみ);
            sourceList.add(source);
            KeyValueDataSource source1 = new KeyValueDataSource();
            source1.setKey(RST_2);
            source1.setValue(代理投票のみ);
            sourceList.add(source1);
            KeyValueDataSource source3 = new KeyValueDataSource();
            source3.setKey(RST_3);
            source3.setValue(点字投票のみ);
            sourceList.add(source3);

            KeyValueDataSource source4 = new KeyValueDataSource();
            source4.setKey(RST_4);
            source4.setValue(返還のみ);
            sourceList.add(source4);

            KeyValueDataSource source5 = new KeyValueDataSource();
            source5.setKey(RST_5);
            source5.setValue(棄権のみ);
            sourceList.add(source5);
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getChkFuzaishaIchiranTaisho().setDataSource(sourceList);
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaishaTaisho().setDataSource(sourceList);
        } else if (不在者_請求のみ.equals(RST_0)) {
            List<KeyValueDataSource> keyValueDataSource = setDataSource();
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getChkFuzaishaIchiranTaisho().setDataSource(keyValueDataSource);
            div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaishaTaisho().setDataSource(keyValueDataSource);
        }

    }

    private List<KeyValueDataSource> setDataSource() {
        List<KeyValueDataSource> sourceList = new ArrayList();
        KeyValueDataSource source = new KeyValueDataSource();
        source.setKey(RST_1);
        source.setValue(未着者のみ);
        sourceList.add(source);
        KeyValueDataSource source1 = new KeyValueDataSource();
        source1.setKey(RST_2);
        source1.setValue(代理投票のみ);
        sourceList.add(source1);
        KeyValueDataSource source3 = new KeyValueDataSource();
        source3.setKey(RST_3);
        source3.setValue(点字投票のみ);
        sourceList.add(source3);

        KeyValueDataSource source4 = new KeyValueDataSource();
        source4.setKey(RST_4);
        source4.setValue(返還のみ);
        sourceList.add(source4);

        KeyValueDataSource source5 = new KeyValueDataSource();
        source5.setKey(RST_5);
        source5.setValue(棄権のみ);
        sourceList.add(source5);
        return sourceList;
    }

    private RString getコンフィグ値(ConfigKeysAFA cnfigKeysAFA, SubGyomuCode code) {
        RString コンフィグ値;
        コンフィグ値 = BusinessConfig.get(cnfigKeysAFA, code);
        return コンフィグ値;
    }

    /**
     * 「実行するボタン」押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check入力内容() {
        ValidationMessageControlPairs controlErrorPairs = new NippoSakuseiValidationHandler(div).validate出力対象チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        controlErrorPairs = new NippoSakuseiValidationHandler(div).validate出力帳票チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタン」押下時、バッチのパラーメタを設定する。
     *
     * @return ResponseData
     */
    public ResponseData<AFABTE503BatchParameter> set画面入力内容() {

        AFABTE503BatchParameter parameter = new AFABTE503BatchParameter();
        NippoSakuseiChohyoDiv chohyoDiv = div.getNippoSakuseiChohyo();

        parameter.set不在者投票日報(false);
        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().isIsPublish()) {
            parameter.set不在者交付日From(edit日付(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getFromValue()));
            parameter.set不在者交付日To(edit日付(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getToValue()));
            parameter.set不在者交付日報(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getChkKofuNippo().isAllSelected());
            parameter.set不在者受理日From(edit日付(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getFromValue()));
            parameter.set不在者受理日To(edit日付(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getToValue()));
            parameter.set不在者受理日報(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().getChkJuriNippo().isAllSelected());
            parameter.set不在者投票日報(chohyoDiv.getNippoSakuseiChohyoFuzaishaNippo().isIsPublish());
        }

        parameter.set期日前投票日報(false);
        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().isIsPublish()) {
            if (null != chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getFromValue()) {
                parameter.set期日前投票投票日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getFromValue().toDateString()));
            }
            if (null != chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getToValue()) {
                parameter.set期日前投票投票日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getToValue().toDateString()));
            }
            parameter.set期日前投票施設コードFrom(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getCcdKijitsumaeNippoShisetsuCode().get施設コードFROM());
            parameter.set期日前投票施設コードTo(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().getCcdKijitsumaeNippoShisetsuCode().get施設コードTO());
            parameter.set期日前投票日報(chohyoDiv.getNippoSakuseiChohyoKijitsumaeNippo().isIsPublish());
        }

        parameter.set期日前投票者一覧表(false);
        if (chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish()) {

            parameter.set期日前投票者一覧表(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish());
            parameter.set期日前投票者一覧表代理投票のみ(Boolean.FALSE);
            parameter.set期日前投票者一覧表仮投票のみ(Boolean.FALSE);
            parameter.set期日前投票者一覧表受付拒否のみ(Boolean.FALSE);
            parameter.set期日前投票者一覧表棄権のみ(Boolean.FALSE);
            parameter.set期日前投票者一覧表点字投票のみ(Boolean.FALSE);
            List<KeyValueDataSource> dataSource = chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getChkKjitsuzenIchiranTaisho().getSelectedItems();
            if (!dataSource.isEmpty()) {
                set期日前投票者一覧表(dataSource, parameter);
            }

            parameter.set期日前投票者一覧表投票区From(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranTohyokuCode().get投票区コードFROM());
            parameter.set期日前投票者一覧表投票区To(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranTohyokuCode().get投票区コードTO());
            parameter.set期日前投票者一覧表投票時刻From(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getFromValue());
            parameter.set期日前投票者一覧表投票時刻To(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getToValue());
            parameter.set期日前投票者一覧表施設コードFrom(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranShisetsuCode().get施設コードFROM());
            parameter.set期日前投票者一覧表施設コードTo(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getCcdKijitsumaeIchiranShisetsuCode().get施設コードTO());
            if (null != chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getFromValue()) {
                parameter.set期日前投票者一覧表期日前投票日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getFromValue().toDateString()));
            }
            if (null != chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getToValue()) {
                parameter.set期日前投票者一覧表期日前投票日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getToValue().toDateString()));
            }

        }

        parameter.set不在者投票者一覧表(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish());
        if (chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish()) {
            set不在者投票者一覧表(parameter, chohyoDiv);
        }

        parameter.set投票事由調書(false);
        if (chohyoDiv.getNippoSakuseiChohyoJiyuChosho().isIsPublish()) {
            parameter.set投票事由調書(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().isIsPublish());
            parameter.set投票事由調書不在者投票(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getChkFuzaishaJiyuChosho().isAllSelected());
            if (null != chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getFromValue()) {
                parameter.set投票事由調書受理日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getFromValue().toDateString()));
            }
            if (null != chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getToValue()) {
                parameter.set投票事由調書受理日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getToValue().toDateString()));
            }
            parameter.set投票事由調書期日前投票(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getChkKijitsumaeJiyuChosho().isAllSelected());
            if (null != chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getFromValue()) {
                parameter.set投票事由調書期日前投票日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getFromValue().toDateString()));
            }
            if (null != chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getToValue()) {
                parameter.set投票事由調書期日前投票日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getToValue().toDateString()));
            }
        }

        parameter.set投票者一覧表(false);
        if (chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish()) {
            set投票者一覧表のデータ(parameter, chohyoDiv);
        }

        parameter.set投票集計整理表(false);
        if (chohyoDiv.getNippoSakuseiChohyoSeirihyo().isIsPublish()) {
            parameter.set投票集計整理表(chohyoDiv.getNippoSakuseiChohyoSeirihyo().isIsPublish());
            parameter.set投票集計整理表受理日(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoSeirihyo().getTxtSeirihyoJuriYMD().getValue().toDateString()));
            parameter.set投票集計整理表投票区From(chohyoDiv.getNippoSakuseiChohyoSeirihyo().getCcdSeirihyoTohyokuCode().get投票区コードFROM());
            parameter.set投票集計整理表投票区To(chohyoDiv.getNippoSakuseiChohyoSeirihyo().getCcdSeirihyoTohyokuCode().get投票区コードTO());
        }
        parameter.set抄本番号(div.getCcdNippoShohonSenkyoList().getSelectedShohonNo());
        parameter.set無投票選挙も出力する(div.getCcdNippoShohonSenkyoList().無投票選挙check());

        return ResponseData.of(parameter).respond();
    }

    private FlexibleDate edit日付(RDate 日付) {
        if (null != 日付) {
            return new FlexibleDate(日付.toDateString());
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    private void set不在者投票者一覧表(AFABTE503BatchParameter parameter, NippoSakuseiChohyoDiv chohyoDiv) {
        parameter.set不在者投票者一覧表(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish());
        if (null != chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getFromValue()) {
            parameter.set不在者投票者一覧表交付日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getFromValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getToValue()) {
            parameter.set不在者投票者一覧表交付日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getToValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getFromValue()) {
            parameter.set不在者投票者一覧表受理日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getFromValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getToValue()) {
            parameter.set不在者投票者一覧表受理日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getToValue().toDateString()));
        }
        parameter.set不在者投票者一覧表受理時刻From(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getFromValue());
        parameter.set不在者投票者一覧表受理時刻To(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getToValue());
        parameter.set不在者投票者一覧表施設コードFrom(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranShisetsuCode().get施設コードFROM());
        parameter.set不在者投票者一覧表施設コードTo(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranShisetsuCode().get施設コードTO());
        parameter.set不在者投票者一覧表投票区From(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranTohyokuCode().get投票区コードFROM());
        parameter.set不在者投票者一覧表投票区To(chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getCcdFuzaishaIchiranTohyokuCode().get投票区コードTO());

        parameter.set不在者投票者一覧表代理投票のみ(Boolean.FALSE);
        parameter.set不在者投票者一覧表未着者のみ(Boolean.FALSE);
        parameter.set不在者投票者一覧表棄権のみ(Boolean.FALSE);
        parameter.set不在者投票者一覧表点字投票のみ(Boolean.FALSE);
        parameter.set不在者投票者一覧表請求のみ(Boolean.FALSE);
        parameter.set不在者投票者一覧表返還のみ(Boolean.FALSE);
        List<KeyValueDataSource> 不在者投票者一覧表dataSource = chohyoDiv.getNippoSakuseiChohyoFuzaishaIchiran().getChkFuzaishaIchiranTaisho().getSelectedItems();
        if (!不在者投票者一覧表dataSource.isEmpty()) {
            for (KeyValueDataSource keyValueDataSource : 不在者投票者一覧表dataSource) {
                if (keyValueDataSource.getValue().equals(請求のみ)) {
                    parameter.set不在者投票者一覧表請求のみ(Boolean.TRUE);
                }
                if (keyValueDataSource.getValue().equals(未着者のみ)) {
                    parameter.set不在者投票者一覧表未着者のみ(Boolean.TRUE);
                }
                if (keyValueDataSource.getValue().equals(代理投票のみ)) {
                    parameter.set不在者投票者一覧表代理投票のみ(Boolean.TRUE);
                }
                if (keyValueDataSource.getValue().equals(点字投票のみ)) {
                    parameter.set不在者投票者一覧表点字投票のみ(Boolean.TRUE);
                }
                if (keyValueDataSource.getValue().equals(返還のみ)) {
                    parameter.set不在者投票者一覧表返還のみ(Boolean.TRUE);
                }
                if (keyValueDataSource.getValue().equals(棄権のみ)) {
                    parameter.set不在者投票者一覧表棄権のみ(Boolean.TRUE);
                }
            }
        }
    }

    private void set期日前投票者一覧表(List<KeyValueDataSource> dataSource, AFABTE503BatchParameter parameter) {
        for (KeyValueDataSource keyValueDataSource : dataSource) {
            if (keyValueDataSource.getValue().equals(代理投票のみ)) {
                parameter.set期日前投票者一覧表代理投票のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(点字投票のみ)) {
                parameter.set期日前投票者一覧表点字投票のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(棄権のみ)) {
                parameter.set期日前投票者一覧表棄権のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(受付拒否のみ)) {
                parameter.set期日前投票者一覧表受付拒否のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(仮投票のみ)) {
                parameter.set期日前投票者一覧表仮投票のみ(Boolean.TRUE);
            }
        }
    }

    private void set投票者一覧表のデータ(AFABTE503BatchParameter parameter, NippoSakuseiChohyoDiv chohyoDiv) {
        parameter.set投票者一覧表(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish());
        parameter.set投票者一覧表混在(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkKonzaiPrint().isAllSelected());
        parameter.set投票者一覧表不在者投票(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().isAllSelected());
        parameter.set投票者一覧表期日前投票(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().isAllSelected());
        parameter.set投票者一覧表請求のみ(Boolean.FALSE);
        parameter.set投票者一覧表不在者未着者のみ(Boolean.FALSE);
        parameter.set投票者一覧表不在者代理投票のみ(Boolean.FALSE);
        parameter.set投票者一覧表不在者点字投票のみ(Boolean.FALSE);
        parameter.set投票者一覧表不在者棄権のみ(Boolean.FALSE);
        parameter.set投票者一覧表不在者返還のみ(Boolean.FALSE);

        List<KeyValueDataSource> 投票者一覧表DataSource = chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaishaTaisho().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 投票者一覧表DataSource) {
            edit投票者一覧表Parameter(parameter, keyValueDataSource);
        }

        parameter.set投票者一覧表期日前代理投票のみ(Boolean.FALSE);
        parameter.set投票者一覧表期日前点字投票のみ(Boolean.FALSE);
        parameter.set投票者一覧表期日前棄権のみ(Boolean.FALSE);
        parameter.set投票者一覧表期日前受付拒否のみ(Boolean.FALSE);
        parameter.set投票者一覧表期日前仮投票のみ(Boolean.FALSE);

        List<KeyValueDataSource> 期日前投票DataSource = chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumaeTaisho().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 期日前投票DataSource) {
            if (keyValueDataSource.getValue().equals(代理投票のみ)) {
                parameter.set投票者一覧表期日前代理投票のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(点字投票のみ)) {
                parameter.set投票者一覧表期日前点字投票のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(棄権のみ)) {
                parameter.set投票者一覧表期日前棄権のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(受付拒否のみ)) {
                parameter.set投票者一覧表期日前受付拒否のみ(Boolean.TRUE);
            }
            if (keyValueDataSource.getValue().equals(仮投票のみ)) {
                parameter.set投票者一覧表期日前仮投票のみ(Boolean.TRUE);
            }
        }

        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getFromValue()) {
            parameter.set投票者一覧表交付日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getFromValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getToValue()) {
            parameter.set投票者一覧表交付日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getToValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getFromValue()) {
            parameter.set投票者一覧表受理日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getFromValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getToValue()) {
            parameter.set投票者一覧表受理日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getToValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getFromValue()) {
            parameter.set投票者一覧表期日前投票日From(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getFromValue().toDateString()));
        }
        if (null != chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getToValue()) {
            parameter.set投票者一覧表期日前投票日To(new FlexibleDate(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getToValue().toDateString()));
        }
        parameter.set投票者一覧表投票時刻From(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getFromValue());
        parameter.set投票者一覧表受理時刻To(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getToValue());
        parameter.set投票者一覧表投票時刻From(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getFromValue());
        parameter.set投票者一覧表投票時刻To(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getToValue());
        parameter.set投票者一覧表投票事由(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoJiyu().getDdlJiyuNameList().getSelectedValue());
        parameter.set投票者一覧表投票区From(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranTohyokuCode().get投票区コードFROM());
        parameter.set投票者一覧表投票区To(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranTohyokuCode().get投票区コードTO());
        parameter.set投票者一覧表施設コードFrom(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranShisetsuCode().get施設コードFROM());
        parameter.set投票者一覧表施設コードTo(chohyoDiv.getNippoSakuseiChohyoTohyoshaIchiran().getCcdTohyoshaIchiranShisetsuCode().get施設コードTO());
    }

    private void edit投票者一覧表Parameter(AFABTE503BatchParameter parameter, KeyValueDataSource keyValueDataSource) {
        if (keyValueDataSource.getValue().equals(請求のみ)) {
            parameter.set投票者一覧表請求のみ(Boolean.TRUE);
        }
        if (keyValueDataSource.getValue().equals(未着者のみ)) {
            parameter.set投票者一覧表不在者未着者のみ(Boolean.TRUE);
        }
        if (keyValueDataSource.getValue().equals(代理投票のみ)) {
            parameter.set投票者一覧表不在者代理投票のみ(Boolean.TRUE);
        }
        if (keyValueDataSource.getValue().equals(点字投票のみ)) {
            parameter.set投票者一覧表不在者点字投票のみ(Boolean.TRUE);
        }
        if (keyValueDataSource.getValue().equals(返還のみ)) {
            parameter.set投票者一覧表不在者棄権のみ(Boolean.TRUE);
        }
        if (keyValueDataSource.getValue().equals(棄権のみ)) {
            parameter.set投票者一覧表不在者返還のみ(Boolean.TRUE);
        }
    }
}
