/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.KokuminTohyoji;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.batchprm.kokuminTohyoji.AFABTG101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.IKokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyo1goShikakuTsuchiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyo2goShikakuChosahyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoIdoMasshoshaMeiboDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoIdoTorokushaMeiboDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoKokugaiChosahyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoKokunaiChosahyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoMasshoTsuchiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoTorokushasuListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoZaigaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.dgKokuminTohyojiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * 国民投票時登録に対応するHandlerクラスです
 *
 * @reamsid_L AF-0360-010 fulc
 */
public final class KokuminTohyojiTorokuHandler {

    private final KokuminTohyojiTorokuDiv div;
    private final KokuminTohyoji kokuminTohyoji;

    /**
     * コンストラクタです。
     *
     * @param div KokuminTohyojiTorokuDiv
     */
    private KokuminTohyojiTorokuHandler(KokuminTohyojiTorokuDiv div) {
        this.div = div;
        kokuminTohyoji = new KokuminTohyoji();
    }

    /**
     * 国民投票時登録のHandler初期化
     *
     * @param div 国民投票時登録DIV
     * @return 国民投票時登録のHandler
     */
    public static KokuminTohyojiTorokuHandler of(KokuminTohyojiTorokuDiv div) {
        return new KokuminTohyojiTorokuHandler(div);
    }

    /**
     * 「日付を確定する」ボタン押下の作成帳票条件の日付項目の取得。
     *
     */
    public void set画面状態() {
        RDate 基準日 = div.getCcdKokuminTohyojiMeiboKijun().getTxtKijunYMD().getValue();
        RDate 投票日 = div.getCcdKokuminTohyojiMeiboKijun().getTxtTohyoYMD().getValue();
        RDate 抹消日 = kokuminTohyoji.get帳票条件_日付取得処理(投票日);
        div.getCcdKokuminTohyojiSakuseiChohyo().get投票人名簿登録者数リスト().getTxtTorokushasuListKijunYmd().setValue(基準日);
        div.getCcdKokuminTohyojiSakuseiChohyo().get抹消者名簿().getTxtMasshoYMD().setValue(抹消日);

    }

    /**
     * 抄本番号に合致する選挙リストを返します。
     *
     * @param shohonNo 抄本番号
     */
    public void createSenkyoDataSource(RString shohonNo) {
        List<Senkyo> 選挙 = SenkyoManager.createInstance().get選挙By抄本番号(new ShohonNo(shohonNo));
        List<dgKokuminTohyojiNyuryoku_Row> dataSource = new ArrayList<>();
        for (Senkyo item : 選挙) {
            dgKokuminTohyojiNyuryoku_Row row = new dgKokuminTohyojiNyuryoku_Row();

            Button deleteButton = new Button();
            deleteButton.setText(new RString("×"));
            row.setBtnDelete(deleteButton);
            row.setTxtNo(new RString(item.get選挙番号().getColumnValue()));
            row.setTxtKaiseianName(createTextBox(new RString(item.get選挙名称().toString())));
            row.setTxtRyakusho(createTextBox(new RString(item.get選挙略称().toString())));
            dataSource.add(row);
        }
        div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().setDataSource(dataSource);

    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @return AFABTG101BatchParameter
     */
    public AFABTG101BatchParameter setBatchParameter() {
        AFABTG101BatchParameter parm = new AFABTG101BatchParameter();
        parm.set処理種別(div.getCcdKokuminTohyojiMeiboKijun().getShoriMode());
        parm.set受付開始日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtTohyoUketsukeYMD().getValue()));
        parm.set名簿登録日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtMeiboTorokuYMD().getValue()));
        parm.set基準日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtKijunYMD().getValue()));
        parm.set年齢到達日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtNenreiTotatsuYMD().getValue()));
        parm.set抄本名(div.getCcdKokuminTohyojiMeiboKijun().getTxtShohonName().getText());
        if (ShoriShubetsu.再処理.getShoriShubetsu().equals(parm.get処理種別())) {
            parm.set抄本番号(div.getCcdKokuminTohyojiMeiboKijun().getHidShohonNo());
        }
        parm.set投票日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtTohyoYMD().getValue()));
        parm.set特定期間開始日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtKijunYMD().getValue()).plusDay(1));
        parm.set特定期限日(toFlexibleDate(div.getCcdKokuminTohyojiMeiboKijun().getTxtTokuteiKigenYMD().getValue()));
        List<dgKokuminTohyojiNyuryoku_Row> rows = div.getKokuminTohyojiTorokuParam().getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource();
        ArrayList<RString> 選挙番号リスト = new ArrayList<>();
        ArrayList<RString> 選挙名称リスト = new ArrayList<>();
        ArrayList<RString> 選挙略称リスト = new ArrayList<>();
        for (dgKokuminTohyojiNyuryoku_Row row : rows) {
            選挙名称リスト.add(row.getTxtKaiseianName().getValue());
            選挙略称リスト.add(row.getTxtRyakusho().getValue());
            選挙番号リスト.add(row.getTxtNo());
        }
        parm.set選挙番号リスト(選挙番号リスト);
        parm.set選挙名称リスト(選挙名称リスト);
        parm.set選挙略称リスト(選挙略称リスト);
        IKokuminSakuseiChohyoDiv sakuseiChohyo = div.getCcdKokuminTohyojiSakuseiChohyo();

        // 投票人名簿抄本
        parm.set投票人名簿抄本出力有無(sakuseiChohyo.get投票人名簿抄本().isIsPublish());

        // 投票人名簿登録者数リスト
        KokuminSakuseiChohyoTorokushasuListDiv 投票人名簿登録者数リスト = sakuseiChohyo.get投票人名簿登録者数リスト();
        parm.set投票人名簿登録者数リスト出力有無(投票人名簿登録者数リスト.isIsPublish());
        parm.set不在者投票資格者分出力有無(!投票人名簿登録者数リスト.getChkTorokuListFuzaishabun().getSelectedKeys().isEmpty());
        parm.set不在資格対象者名簿出力有無(!投票人名簿登録者数リスト.getChkFuzaiTohyoMeibo().getSelectedKeys().isEmpty());
        parm.set時点日(toFlexibleDate(投票人名簿登録者数リスト.getTxtTorokushasuListKijunYmd().getValue()));

        // 1号資格登録通知
        KokuminSakuseiChohyo1goShikakuTsuchiDiv 一号資格登録通知 = sakuseiChohyo.get1号資格登録通知();
        parm.set一号資格登録通知出力有無(一号資格登録通知.isIsPublish());
        parm.set発行日_1号資格登録(toFlexibleDate(一号資格登録通知.getCcdPrintNaiyo1goTsuchi().getTxtHakkoYMD().getValue()));
        parm.set発行番号の号_1号資格(一号資格登録通知.getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_号());
        parm.set発行番号の番号_1号資格(一号資格登録通知.getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_番号());
        parm.set発行番号の第_1号資格(一号資格登録通知.getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_第());
        parm.set一号資格登録通知一覧表出力有無(!一号資格登録通知.getChk1goTsuchiIchiran().getSelectedKeys().isEmpty());
        parm.set送付先宛名シール出力有無_1号資格(!一号資格登録通知.getChkSeal1goTsuchi().getSelectedKeys().isEmpty());

        // 2号資格調査票
        KokuminSakuseiChohyo2goShikakuChosahyoDiv 二号資格調査票 = sakuseiChohyo.get2号資格調査票();
        parm.set二号資格調査票出力有無(二号資格調査票.isIsPublish());
        parm.set二号資格調査一覧表出力有無(!二号資格調査票.getChk2goChosaIchiran().getSelectedKeys().isEmpty());
        parm.set発行日_2号資格(toFlexibleDate(二号資格調査票.getCcdPrintNaiyo2goChosahyo().getTxtHakkoYMD().getValue()));
        parm.set発行番号の号_2号資格(二号資格調査票.getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_号());
        parm.set発行番号の番号_2号資格(二号資格調査票.getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_番号());
        parm.set発行番号の第_2号資格(二号資格調査票.getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_第());
        parm.set送付先宛名シール出力有無_2号資格(!二号資格調査票.getChkSeal2goChosahyo().getSelectedKeys().isEmpty());

        // 2号資格候補者一覧表
        parm.set二号資格候補者一覧表出力有無(sakuseiChohyo.get2号資格候補者一覧表().isIsPublish());

        // 補正登録者名簿
        KokuminSakuseiChohyoIdoTorokushaMeiboDiv 補正登録者名簿 = sakuseiChohyo.get補正登録者名簿();
        parm.set補正登録者名簿出力有無(補正登録者名簿.isIsPublish());
        parm.set縦覧用も作成する出力有無(!補正登録者名簿.getChkTorokushaMeiboJuran().getSelectedKeys().isEmpty());
        parm.set補正登録者宛名シール出力有無(!補正登録者名簿.getChkSealTorokushaMeibo().getSelectedKeys().isEmpty());

        // 抹消者名簿
        KokuminSakuseiChohyoIdoMasshoshaMeiboDiv 抹消者名簿 = sakuseiChohyo.get抹消者名簿();
        parm.set抹消者名簿出力有無(抹消者名簿.isIsPublish());
        parm.set抹消日(toFlexibleDate(抹消者名簿.getTxtMasshoYMD().getValue()));
        parm.set縦覧用も作成する出力有無_抹消者(!抹消者名簿.getChkMasshoshaMeiboJuran().getSelectedKeys().isEmpty());

        // 訂正者名簿
        parm.set訂正者名簿出力有無(sakuseiChohyo.get訂正者名簿().isIsPublish());

        // 未登録者抹消通知
        KokuminSakuseiChohyoMasshoTsuchiDiv 未登録者抹消通知 = sakuseiChohyo.get未登録者抹消通知();
        parm.set未登録者抹消通知出力有無(未登録者抹消通知.isIsPublish());
        parm.set発行日_未登録者抹消(toFlexibleDate(未登録者抹消通知.getCcdPrintNaiyoMasshoTsuchi().getTxtHakkoYMD().getValue()));
        parm.set発行番号の号_未登録者抹消(未登録者抹消通知.getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_号());
        parm.set発行番号の番号_未登録者抹消(未登録者抹消通知.getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_番号());
        parm.set発行番号の第_未登録者抹消(未登録者抹消通知.getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_第());
        parm.set送付先宛名シール出力有無_未登録者抹消(!未登録者抹消通知.getChkSealMasshoTsuchi().getSelectedKeys().isEmpty());
        parm.set未登録者抹消通知一覧出力有無(!未登録者抹消通知.getChkMasshoTsuchiIchiran().getSelectedKeys().isEmpty());

        // 国内転入者調査票
        KokuminSakuseiChohyoKokunaiChosahyoDiv 国内転入者調査票 = sakuseiChohyo.get国内転入者調査票();
        parm.set国内転入者調査票出力有無(国内転入者調査票.isIsPublish());
        parm.set発行日_国内転入者調査票(toFlexibleDate(国内転入者調査票.getCcdPrintNaiyoKokunaiChosa().getTxtHakkoYMD().getValue()));
        parm.set発行番号の号_国内転入者調査票(国内転入者調査票.getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_号());
        parm.set発行番号の番号_国内転入者調査票(国内転入者調査票.getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_番号());
        parm.set発行番号の第_国内転入者調査票(国内転入者調査票.getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_第());
        parm.set送付先宛名シール出力有無_国内転入者調査票(!国内転入者調査票.getChkSealKokunaiChosa().getSelectedKeys().isEmpty());
        parm.set国内転入者調査一覧表出力有無(!国内転入者調査票.getChkKokunaiChosaIchiran().getSelectedKeys().isEmpty());

        // 国外転入者調査票
        KokuminSakuseiChohyoKokugaiChosahyoDiv 国外転入者調査票 = sakuseiChohyo.get国外転入者調査票();
        parm.set国外転入者調査票出力有無(国外転入者調査票.isIsPublish());
        parm.set発行日_国外転入者調査票(toFlexibleDate(国外転入者調査票.getCcdPrintNaiyoKokugaiChosa().getTxtHakkoYMD().getValue()));
        parm.set発行番号の号_国外転入者調査票(国外転入者調査票.getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_号());
        parm.set発行番号の番号_国外転入者調査票(国外転入者調査票.getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_番号());
        parm.set発行番号の第_国外転入者調査票(国外転入者調査票.getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_第());
        parm.set送付先宛名シール出力有無_国外転入者調査票(!国外転入者調査票.getChkSealKokugaiChosa().getSelectedKeys().isEmpty());
        parm.set国外転入者調査一覧表出力有無(!国外転入者調査票.getChkKokugaiChosaIchiran().getSelectedKeys().isEmpty());

        KokuminSakuseiChohyoZaigaiDiv 在外投票関連 = sakuseiChohyo.get在外投票関連();
        // 在外投票人名簿抄本
        parm.set在外投票人名簿抄本出力有無(在外投票関連.getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());

        // 在外投票資格者名簿
        parm.set在外投票資格者名簿出力有無(在外投票関連.getKokuminSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());

        // 在外投票管理表
        parm.set在外投票管理表出力有無(在外投票関連.getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish());

        return parm;
    }

    private FlexibleDate toFlexibleDate(RDate target) {
        if (null == target) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(target.toDateString());
    }

    private TextBox createTextBox(RString shohonNo) {
        TextBox text = new TextBox();
        text.setValue(shohonNo);
        return text;
    }
}
