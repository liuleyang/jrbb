/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGM01000;

import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGM01000.ProcessCompleteDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 処理完了のハンドラクラスです。
 *
 */
public class ProcessCompleteHandler {

    private final ProcessCompleteDiv div;
    private static final RString 在外投票人名簿修正 = new RString("在外投票人名簿修正");
    private static final RString 在外選挙人 = new RString("在外選挙人");
    private static final RString 在外投票人 = new RString("在外投票人");
    private static final RString 保存完了 = new RString("の保存が完了しました。");
    private static final RString 保存完了メッセージ = new RString("保存が完了しました。");

    private static final RString 名簿番号 = new RString("名簿番号");
    private static final RString 抄本名 = new RString("抄本名");
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 符号マイナス = new RString("-");
    private static final RString 海区漁業調整委員会委員選挙 = new RString("海区漁業調整委員会委員選挙：");

    /**
     * コンストラクタです
     *
     * @param div ProcessCompleteDiv
     */
    public ProcessCompleteHandler(ProcessCompleteDiv div) {
        this.div = div;
    }

    /**
     * 完了メッセージを設定します。
     *
     * @param kanryoKakuninParam KanryoKakuninParameter
     */
    public void set完了メッセージ(KanryoKakuninParameter kanryoKakuninParam) {

        RString メニューID = kanryoKakuninParam.getメニューID();
        RString 対象レベル = RString.EMPTY;
        RString 対象情報１ = RString.EMPTY;
        RString 対象情報２ = RString.EMPTY;

        RString メッセージ = set名簿番号の対象レベル完了メッセージ(メニューID);
        if (!メッセージ.equals(保存完了メッセージ)) {
            対象レベル = 名簿番号;
            対象情報１ = set名簿番号(kanryoKakuninParam);
            対象情報２ = kanryoKakuninParam.get氏名();
        }

        if (RString.isNullOrEmpty(対象レベル)) {
            メッセージ = set抄本名の対象レベル完了メッセージ(メニューID);
            if (!メッセージ.equals(保存完了メッセージ)) {
                対象レベル = 抄本名;
                対象情報１ = kanryoKakuninParam.get抄本番号() == null ? RString.EMPTY : new RString(kanryoKakuninParam.get抄本番号().toString());
                対象情報２ = kanryoKakuninParam.get抄本名();
            }
        }

        if (RString.isNullOrEmpty(対象レベル)) {
            メッセージ = set識別コードの対象レベル完了メッセージ(メニューID);
            if (!メッセージ.equals(保存完了メッセージ)) {
                対象レベル = 識別コード;
                対象情報１ = kanryoKakuninParam.get識別コード().value();
                対象情報２ = kanryoKakuninParam.get氏名();

                AccessLogger.log(AccessLogType.照会, PersonalData.of(kanryoKakuninParam.get識別コード()));
            }
        }

        div.getCcdKanryoMessage().setMessage(メッセージ, 対象レベル, 対象情報１, 対象情報２, kanryoKakuninParam.get処理結果());
    }

    private RString set名簿番号(KanryoKakuninParameter kanryoKakuninParam) {
        RString meiboNo = RString.EMPTY;
        if (BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体).equals(
                抄本_冊区分管理_使用しない.getValue())) {
            if (!kanryoKakuninParam.get投票区コード().isNullOrEmpty()
                    && kanryoKakuninParam.get頁() != 0 && kanryoKakuninParam.get行() != 0) {
                meiboNo = new RString(String.format("%1$4s", kanryoKakuninParam.get投票区コード().toString()).replace(" ", "0")).concat(符号マイナス).
                        concat(new RString(String.format("%06d", kanryoKakuninParam.get頁()))).concat(符号マイナス).
                        concat(new RString(String.format("%02d", kanryoKakuninParam.get行())));
            }
        } else {
            if (!kanryoKakuninParam.get投票区コード().isNullOrEmpty() && !kanryoKakuninParam.get冊().isNullOrEmpty()
                    && kanryoKakuninParam.get頁() != 0 && kanryoKakuninParam.get行() != 0) {
                meiboNo = new RString(String.format("%1$4s", kanryoKakuninParam.get投票区コード().toString()).replace(" ", "0")).concat(符号マイナス).
                        concat(new RString(String.format("%1$2s", kanryoKakuninParam.get冊().toString()).replace(" ", "0"))).concat(符号マイナス).
                        concat(new RString(String.format("%06d", kanryoKakuninParam.get頁()))).concat(符号マイナス).
                        concat(new RString(String.format("%02d", kanryoKakuninParam.get行())));
            }
        }
        return meiboNo;
    }

    private RString set名簿番号の対象レベル完了メッセージ(RString メニューID) {

        RString メッセージ = 保存完了メッセージ;
        if (AFAMenuId.AFAMNA1020_選挙人の投票区変更.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNA1020_選挙人の投票区変更.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNC2020_洋上投票資格登録.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNC2030_南極投票資格登録.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNC2030_南極投票資格登録.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNK1020_選挙人の投票区変更.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNK1020_選挙人の投票区変更.menuName().concat(保存完了);
        }
        return メッセージ;
    }

    private RString set抄本名の対象レベル完了メッセージ(RString メニューID) {

        RString メッセージ = 保存完了メッセージ;
        if (AFAMenuId.AFAMNB1020_選挙情報修正.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNB1020_選挙情報修正.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNB4020_選挙情報修正.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNG1020_国民投票情報修正.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNG1020_国民投票情報修正.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNK1050_選挙情報修正.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNK1050_選挙情報修正.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNE4020_バーコード一括当日投票入力.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNE4020_バーコード一括当日投票入力.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId().equals(メニューID)) {
            メッセージ = 海区漁業調整委員会委員選挙.concat(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuName().concat(保存完了));
        } else if (AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId().equals(メニューID)) {
            メッセージ = 海区漁業調整委員会委員選挙.concat(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuName().concat(保存完了));
        } else if (AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId().equals(メニューID)) {
            メッセージ = 海区漁業調整委員会委員選挙.concat(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuName().concat(保存完了));
        }
        return メッセージ;
    }

    private RString set識別コードの対象レベル完了メッセージ(RString メニューID) {

        RString メッセージ = 保存完了メッセージ;
        if (AFAMenuId.AFAMNC1010_選挙人資格異動.menuId().equals(メニューID)) {
            メッセージ = AFAMenuId.AFAMNC1010_選挙人資格異動.menuName().concat(保存完了);
        } else if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(メニューID)) {
            メッセージ = 在外選挙人.concat(AFAMenuId.AFAMNB3010_名簿登録.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(メニューID)) {
            メッセージ = 在外選挙人.concat(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(メニューID)) {
            メッセージ = 在外選挙人.concat(AFAMenuId.AFAMNB3030_証明書再交付.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(メニューID)) {
            メッセージ = 在外選挙人.concat(AFAMenuId.AFAMNB3040_名簿抹消.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId().equals(メニューID)) {
            メッセージ = 在外選挙人.concat(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(メニューID)) {
            メッセージ = 在外投票人.concat(AFAMenuId.AFAMNG3010_名簿登録.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(メニューID)) {
            メッセージ = 在外投票人.concat(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(メニューID)) {
            メッセージ = 在外投票人.concat(AFAMenuId.AFAMNG3030_証明書再交付.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(メニューID)) {
            メッセージ = 在外投票人.concat(AFAMenuId.AFAMNG3040_名簿抹消.menuName()).concat(保存完了);
        } else if (AFAMenuId.AFAMNG3050_投票人名簿修正.menuId().equals(メニューID)) {
            メッセージ = 在外投票人名簿修正.concat(保存完了);
        }
        return メッセージ;
    }
}
