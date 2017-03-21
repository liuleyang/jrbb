/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1030;

import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojikaiku.AFABTK103BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.KaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho.IKaikuTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1030.KaikuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 海区漁業調整委員会委員選挙時登録のHandlerクラス
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class KaikuSenkyojiTorokuHandler {

    private final KaikuSenkyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaikuSenkyojiTorokuDiv
     */
    public KaikuSenkyojiTorokuHandler(KaikuSenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 「実行する」ボタン押下でバッチパラメータを設定する。
     *
     * @return parameter AFABTK103BatchParameter
     */
    public AFABTK103BatchParameter setバッチパラメータ() {

        AFABTK103BatchParameter param = new AFABTK103BatchParameter();

        IKaikuTaishoShohonJohoDiv johoDiv = div.getKaikuSenkyojiTorokuParam().getCcdKaikuSenkyojiSenkyoNyuryoku();
        param.set処理種別(johoDiv.getRadShori().getSelectedKey());
        param.set抄本番号(johoDiv.getCcdShohonNameList().getSelectedShohonNo());
        param.set抄本名(johoDiv.getTxtShohonName().getText());
        param.set選挙名(johoDiv.getTxtSenkyoName().getText());
        param.set基準日(new FlexibleDate(johoDiv.getTxtKijunYMD().getValue().toString()));
        param.set投票日(new FlexibleDate(johoDiv.getTxtTohyoYMD().getValue().toString()));
        param.set受付開始日(new FlexibleDate(johoDiv.getTxtTohyoUketsukeYMD().getValue().toString()));

        KaikuSakuseiChohyoDiv chohyoDiv = div
                .getKaikuSenkyojiTorokuParam().getCcdKaikuSenkyojiSakuseiChohyo().get海区作成帳票情報();
        param.set選挙人名簿抄本出力有無(chohyoDiv.getKaikuSakuseiChohyoMeiboShohon().isIsPublish());
        param.set登録者数リスト出力有無(chohyoDiv.getKaikuSakuseiChohyoTorokushasuList().isIsPublish());
        if (null == chohyoDiv.getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue()) {
            param.set時点日(new FlexibleDate(johoDiv.getTxtKijunYMD().getValue().toString()));
        } else {
            param.set時点日(new FlexibleDate(
                    chohyoDiv.getKaikuSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue().toString()));
        }
        param.set登録者名簿出力有無(chohyoDiv.getKaikuSakuseiChohyoIdoTorokushaMeibo().isIsPublish());
        param.set新規登録者宛名シール作成有無(
                chohyoDiv.getKaikuSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeibo().isAllSelected());
        param.set抹消者名簿出力有無(chohyoDiv.getKaikuSakuseiChohyoIdoMasshoshaMeibo().isIsPublish());
        param.set失権者名簿出力有無(chohyoDiv.getKaikuSakuseiChohyoIdoShikkenshaMeibo().isIsPublish());
        param.set表示者名簿出力有無(chohyoDiv.getKaikuSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        param.set訂正者名簿出力有無(chohyoDiv.getKaikuSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());

//        param.set処理種別(zaisankuDiv.getRadShori().getSelectedKey());
//        param.set抄本番号(zaisankuDiv.getCcdShohonNameList().getSelectedShohonNo());
//        param.set抄本名(zaisankuDiv.getTxtShohonName().getText());
//        param.set投票日(new FlexibleDate(zaisankuDiv.getTxtTohyoYMD().getText()));
//        param.set基準日(new FlexibleDate(zaisankuDiv.getTxtKijunYMD().getText()));
//        param.set登録日(new FlexibleDate(zaisankuDiv.getTxtMeiboTorokuYMD().getText()));
//        param.set転出期限日(new FlexibleDate(zaisankuDiv.getTxtTenshutsuYMD().getText()));
//        param.set転入期限日(new FlexibleDate(zaisankuDiv.getTxtTennyuYMD().getText()));
//        param.set年齢期限日(new FlexibleDate(zaisankuDiv.getTxtNenreiTotatsuYMD().getText()));
//        param.set財産区内居住年数(Integer.parseInt(zaisankuDiv.getTxtKyojuNensu().getText().toString()));
//        param.set投票開始日(new FlexibleDate(zaisankuDiv.getTxtTohyoKaishiYMD().getText()));
        return param;
    }
}
