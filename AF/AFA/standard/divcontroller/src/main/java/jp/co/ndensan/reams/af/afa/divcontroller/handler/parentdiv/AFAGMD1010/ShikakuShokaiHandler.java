/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakushokai.FuzaishaTohyoShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010.ShikakuShokaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010.dgShikakuShokaiFuzaisha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010.dgShikakuShokai_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * ShikakuShokaiDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
public class ShikakuShokaiHandler {

    private final ShikakuShokaiDiv div;
    private final RString 選挙資格 = new RString("txtSenkyoShikaku");
    private final RString 投票区 = new RString("txtTohyokuCode");
    private final RString 名簿登録年月日 = new RString("txtMeiboTorokuYMD");
    private final RString 登録事由 = new RString("txtTorokuJiyu");
    private final RString 登録停止年月日 = new RString("txtTorokuTeshiYMD");
    private final RString 登録停止事由 = new RString("txtTorokuTeishiJiyu");
    private final RString 表示年月日 = new RString("txtHyojiYMD");
    private final RString 表示事由 = new RString("txtHyojiJiyu");
    private final RString 表示消除年月日 = new RString("txtHyojiShojoYMD");
    private final RString 表示消除予定年月日 = new RString("txtHyojiShojoYoteiYMD");
    private final RString 抹消年月日 = new RString("txtMasshoYMD");
    private final RString 抹消事由 = new RString("txtMasshoJiyu");
    private final RString 刑期終了年月日 = new RString("txtKeikiShuryoYMD");
    private final RString 二刑持ち = new RString("chkNikeiMochi");
    private final RString 国民投票区分 = new RString("txtKokuminTohyoKubun");
    private final RString 抄本番号 = new RString("txtKokuminShohonNo");
    private final RString 本籍地登録区分 = new RString("txtHonsekiTorokuKubun");
    private final RString 交付番号 = new RString("txtKofuNo");
    private final RString 交付年月日 = new RString("txtKofuYMD");
    private final RString 修正区分 = new RString("txtShuseiKubun");
    private final RString 修正年月日 = new RString("txtShuseiYMD");
    private final RString 再交付事由 = new RString("txtSaiKofuJiyu");
    private final RString 記載事項変更事由 = new RString("txtHenkoJiyu");
    private final RString 特記事項 = new RString("txtTokkiJiko");
    private final RString 検索結果一覧へ = new RString("btnSearchResult");

    /**
     * コンストラクタです。
     *
     * @param div ShikakuShokaiDiv
     */
    public ShikakuShokaiHandler(ShikakuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param メニューID RString
     */
    public void onLoad(RString メニューID) {
    }

    /**
     * メニューIDから、状態をセットする。
     *
     * @param メニューID RString
     * @param ボタン表示フラグ Boolean
     */
    public void 初期化処理_表示制御(RString メニューID, Boolean ボタン表示フラグ) {
        DataGridSetting 状態定義 = div.getShikakuShokaiJoho().getDgShikakuShokai().getGridSetting();
        if (!メニューID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())) {
            状態定義.getColumn(特記事項).setVisible(Boolean.TRUE);
            状態定義.getColumn(選挙資格).setVisible(Boolean.TRUE);
            状態定義.getColumn(投票区).setVisible(Boolean.TRUE);
            状態定義.getColumn(名簿登録年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(登録事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(登録停止年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(登録停止事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示消除年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示消除予定年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(抹消年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(抹消事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(刑期終了年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(二刑持ち).setVisible(Boolean.TRUE);
            状態定義.getColumn(国民投票区分).setVisible(Boolean.FALSE);
            状態定義.getColumn(抄本番号).setVisible(Boolean.FALSE);
            状態定義.getColumn(本籍地登録区分).setVisible(Boolean.FALSE);
            状態定義.getColumn(交付番号).setVisible(Boolean.FALSE);
            状態定義.getColumn(交付年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(修正区分).setVisible(Boolean.FALSE);
            状態定義.getColumn(修正年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(再交付事由).setVisible(Boolean.FALSE);
            状態定義.getColumn(記載事項変更事由).setVisible(Boolean.FALSE);
            状態定義.getColumn(特記事項).setVisible(Boolean.FALSE);
        } else {
            状態定義.getColumn(選挙資格).setVisible(Boolean.TRUE);
            状態定義.getColumn(投票区).setVisible(Boolean.TRUE);
            状態定義.getColumn(名簿登録年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(登録事由).setVisible(Boolean.FALSE);
            状態定義.getColumn(登録停止年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(登録停止事由).setVisible(Boolean.FALSE);
            状態定義.getColumn(表示年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(表示消除年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(表示消除予定年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(抹消年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(抹消事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(刑期終了年月日).setVisible(Boolean.FALSE);
            状態定義.getColumn(二刑持ち).setVisible(Boolean.FALSE);
            状態定義.getColumn(国民投票区分).setVisible(Boolean.TRUE);
            状態定義.getColumn(抄本番号).setVisible(Boolean.TRUE);
            状態定義.getColumn(本籍地登録区分).setVisible(Boolean.TRUE);
            状態定義.getColumn(交付番号).setVisible(Boolean.TRUE);
            状態定義.getColumn(交付年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(修正区分).setVisible(Boolean.TRUE);
            状態定義.getColumn(修正年月日).setVisible(Boolean.TRUE);
            状態定義.getColumn(再交付事由).setVisible(Boolean.TRUE);
            状態定義.getColumn(記載事項変更事由).setVisible(Boolean.TRUE);
        }

        if (ボタン表示フラグ) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, Boolean.TRUE);
        } else {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, Boolean.FALSE);
        }
    }

    /**
     * 選挙資格情報リストから、選挙資格情報をセットする。
     *
     * @param 選挙種類 SennkyoSikakuShurui
     * @param 選挙資格情報リスト List<SenkyoShikakuResult>
     */
    public void 初期化処理_選挙資格情報(SennkyoSikakuShurui 選挙種類, List<SenkyoShikakuResult> 選挙資格情報リスト) {
        List<dgShikakuShokai_Row> 画面_選挙資格情報リスト = new ArrayList<>();
        if (null == 選挙資格情報リスト || 選挙資格情報リスト.isEmpty()) {
            div.getShikakuShokaiJoho().getDgShikakuShokai().setDataSource(画面_選挙資格情報リスト);
            return;
        }
        set選挙種類(選挙種類);
        div.getShikakuShokaiJoho().getDgShikakuShokai().getDataSource().clear();
        SenkyoShikakuResult 選挙資格情報;
        dgShikakuShokai_Row 画面_選挙資格情報;

        for (int i = 0; i < 選挙資格情報リスト.size(); i++) {
            画面_選挙資格情報 = new dgShikakuShokai_Row();
            選挙資格情報 = 選挙資格情報リスト.get(i);

            画面_選挙資格情報.setTxtRirekiNo(new RString(選挙資格情報.get履歴番号().getValue()));
            set選挙資格(画面_選挙資格情報, 選挙資格情報);
            画面_選挙資格情報.setTxtTohyokuCode(選挙資格情報.get投票区コード());
            画面_選挙資格情報.getTxtMeiboTorokuYMD().setValue(選挙資格情報.get名簿登録年月日());
            set登録事由(画面_選挙資格情報, 選挙資格情報);
            画面_選挙資格情報.getTxtTorokuTeshiYMD().setValue(選挙資格情報.get登録停止年月日());
            set登録停止事由(画面_選挙資格情報, 選挙資格情報);
            画面_選挙資格情報.getTxtHyojiYMD().setValue(選挙資格情報.get表示年月日());
            set表示事由(画面_選挙資格情報, 選挙資格情報);
            画面_選挙資格情報.getTxtHyojiShojoYMD().setValue(選挙資格情報.get表示消除年月日());
            画面_選挙資格情報.getTxtHyojiShojoYoteiYMD().setValue(選挙資格情報.get表示消除予定年月日());
            画面_選挙資格情報.getTxtMasshoYMD().setValue(選挙資格情報.get抹消年月日());
            set抹消事由(画面_選挙資格情報, 選挙資格情報);
            画面_選挙資格情報.getTxtKeikiShuryoYMD().setValue(選挙資格情報.get刑期終了年月日());
            画面_選挙資格情報.setChkNikeiMochi(選挙資格情報.is2刑持ちフラグ());
            画面_選挙資格情報リスト.add(画面_選挙資格情報);
        }
        div.getShikakuShokaiJoho().getDgShikakuShokai().setDataSource(画面_選挙資格情報リスト);
    }

    /**
     * 在外選挙資格情報リストから、在外選挙資格情報をセットする。
     *
     * @param 選挙種類 SennkyoSikakuShurui
     * @param 在外選挙資格情報リスト List<ZaigaiSenkyoShikakuResult>
     */
    public void 初期化処理_在外選挙資格情報(SennkyoSikakuShurui 選挙種類, List<ZaigaiSenkyoShikakuResult> 在外選挙資格情報リスト) {

        List<dgShikakuShokai_Row> 画面_在外選挙資格情報リスト = new ArrayList<>();
        if (null == 在外選挙資格情報リスト || 在外選挙資格情報リスト.isEmpty()) {
            div.getShikakuShokaiJoho().getDgShikakuShokai().setDataSource(画面_在外選挙資格情報リスト);
            return;
        }

        set選挙種類(選挙種類);

        div.getShikakuShokaiJoho().getDgShikakuShokai().getDataSource().clear();
        ZaigaiSenkyoShikakuResult 在外選挙資格情報;
        dgShikakuShokai_Row 画面_在外選挙資格情報;
        RString 国民投票抄本番号;
        for (int i = 0; i < 在外選挙資格情報リスト.size(); i++) {
            画面_在外選挙資格情報 = new dgShikakuShokai_Row();
            在外選挙資格情報 = 在外選挙資格情報リスト.get(i);

            画面_在外選挙資格情報.setTxtRirekiNo(new RString(在外選挙資格情報.get申請番号()));
            set在外選挙資格(選挙種類, 画面_在外選挙資格情報, 在外選挙資格情報);
            画面_在外選挙資格情報.setTxtTohyokuCode(在外選挙資格情報.get投票区コード());
            画面_在外選挙資格情報.getTxtMeiboTorokuYMD().setValue(在外選挙資格情報.get名簿登録年月日());
            画面_在外選挙資格情報.getTxtHyojiYMD().setValue(在外選挙資格情報.get表示年月日());
            set在外表示事由(画面_在外選挙資格情報, 在外選挙資格情報);
            画面_在外選挙資格情報.getTxtMasshoYMD().setValue(在外選挙資格情報.get抹消年月日());
            set在外抹消事由(画面_在外選挙資格情報, 在外選挙資格情報);
            set在外国民投票区分(画面_在外選挙資格情報, 在外選挙資格情報);
            if (null == 在外選挙資格情報.get国民投票抄本番号()) {
                国民投票抄本番号 = RString.EMPTY;
            } else {
                国民投票抄本番号 = new RString(在外選挙資格情報.get国民投票抄本番号().value());
            }
            画面_在外選挙資格情報.setTxtKokuminShohonNo(国民投票抄本番号);
            set在外本籍地登録区分(画面_在外選挙資格情報, 在外選挙資格情報);
            画面_在外選挙資格情報.setTxtKofuNo(在外選挙資格情報.get交付番号());
            画面_在外選挙資格情報.getTxtKofuYMD().setValue(在外選挙資格情報.get交付年月日());
            set在外修正区分(画面_在外選挙資格情報, 在外選挙資格情報);
            画面_在外選挙資格情報.getTxtShuseiYMD().setValue(在外選挙資格情報.get修正年月日());
            set在外再交付事由(画面_在外選挙資格情報, 在外選挙資格情報);
            set在外申請内容変更事由(画面_在外選挙資格情報, 在外選挙資格情報);
            画面_在外選挙資格情報.setTxtTokkiJiko(在外選挙資格情報.get特記事項());

            画面_在外選挙資格情報リスト.add(画面_在外選挙資格情報);
        }
        div.getShikakuShokaiJoho().getDgShikakuShokai().setDataSource(画面_在外選挙資格情報リスト);

    }

    /**
     * 不在者投票資格情報リスト、不在者投票資格情報をセットする。
     *
     * @param 不在者投票資格情報リスト List<FuzaishaTohyoShikakuResult>
     */
    public void 初期化処理_不在者投票資格情報(List<FuzaishaTohyoShikakuResult> 不在者投票資格情報リスト) {

        List<dgShikakuShokaiFuzaisha_Row> 画面_不在者投票資格情報リスト = new ArrayList<>();
        if (null == 不在者投票資格情報リスト || 不在者投票資格情報リスト.isEmpty()) {
            div.getShikakuShokaiFuzaisha().getDgShikakuShokaiFuzaisha().setDataSource(画面_不在者投票資格情報リスト);
            return;
        }

        div.getShikakuShokaiFuzaisha().getDgShikakuShokaiFuzaisha().getDataSource().clear();
        FuzaishaTohyoShikakuResult 不在者投票資格情報;
        dgShikakuShokaiFuzaisha_Row 画面_不在者投票資格情報;
        RString 代理記載者識別コード;
        RString 代理記載者漢字氏名;
        RString 代理記載者カナ氏名;
        RString 代理記載者性別コード;
        RString 代理記載者郵便番号;
        RString 代理記載者住所;
        for (int i = 0; i < 不在者投票資格情報リスト.size(); i++) {
            画面_不在者投票資格情報 = new dgShikakuShokaiFuzaisha_Row();
            不在者投票資格情報 = 不在者投票資格情報リスト.get(i);

            set不在者種類(画面_不在者投票資格情報, 不在者投票資格情報);
            画面_不在者投票資格情報.setTxtRirekiNo(new RString(不在者投票資格情報.get履歴番号().getValue()));
            画面_不在者投票資格情報.getTxtKofuYMD().setValue(不在者投票資格情報.get交付年月日());
            画面_不在者投票資格情報.setTxtKofuNo(不在者投票資格情報.get交付番号());
            画面_不在者投票資格情報.getTxtShikakuTorokuYMD().setValue(不在者投票資格情報.get資格登録年月日());
            画面_不在者投票資格情報.getTxtShikakuManryoYMD().setValue(不在者投票資格情報.get資格満了年月日());
            画面_不在者投票資格情報.getTxtShikakuMasshoYMD().setValue(不在者投票資格情報.get資格抹消年月日());
            set不在者抹消事由(画面_不在者投票資格情報, 不在者投票資格情報);
            画面_不在者投票資格情報.setChkShogai(不在者投票資格情報.is身体障害者手帳有());
            画面_不在者投票資格情報.setChkSensho(不在者投票資格情報.is戦傷病者手帳有());
            画面_不在者投票資格情報.setChkKaigo(不在者投票資格情報.is介護保険被保険者証有());
            set不在者入力区分(画面_不在者投票資格情報, 不在者投票資格情報);

            if (null == 不在者投票資格情報.get代理記載者識別コード()) {
                代理記載者識別コード = RString.EMPTY;
            } else {
                代理記載者識別コード = 不在者投票資格情報.get代理記載者識別コード().value();
            }
            画面_不在者投票資格情報.setTxtDairiShikibetsuCode(代理記載者識別コード);

            if (null == 不在者投票資格情報.get代理記載者漢字氏名()) {
                代理記載者漢字氏名 = RString.EMPTY;
            } else {
                代理記載者漢字氏名 = 不在者投票資格情報.get代理記載者漢字氏名().value();
            }
            画面_不在者投票資格情報.setTxtDairiKanjiShimei(代理記載者漢字氏名);

            if (null == 不在者投票資格情報.get代理記載者カナ氏名()) {
                代理記載者カナ氏名 = RString.EMPTY;
            } else {
                代理記載者カナ氏名 = 不在者投票資格情報.get代理記載者カナ氏名().value();
            }
            画面_不在者投票資格情報.setTxtDairiKanaShimei(代理記載者カナ氏名);
            画面_不在者投票資格情報.getTxtDairiSeinengappi().setValue(不在者投票資格情報.get代理記載者生年月日());

            if (null == 不在者投票資格情報.get代理記載者性別コード()) {
                代理記載者性別コード = RString.EMPTY;
            } else {
                代理記載者性別コード = 不在者投票資格情報.get代理記載者性別コード();
            }
            画面_不在者投票資格情報.setTxtDairiSeibetsu(Gender.toValue(代理記載者性別コード).getCommonName());

            if (null == 不在者投票資格情報.get代理記載者郵便番号()) {
                代理記載者郵便番号 = RString.EMPTY;
            } else {
                代理記載者郵便番号 = 不在者投票資格情報.get代理記載者郵便番号().getYubinNo();
            }
            画面_不在者投票資格情報.setTxtDairiYubinNo(代理記載者郵便番号);

            if (null == 不在者投票資格情報.get代理記載者住所()) {
                代理記載者住所 = RString.EMPTY;
            } else {
                代理記載者住所 = 不在者投票資格情報.get代理記載者住所().value();
            }
            画面_不在者投票資格情報.setTxtDairiJusho(代理記載者住所);

            画面_不在者投票資格情報リスト.add(画面_不在者投票資格情報);
        }
        div.getShikakuShokaiFuzaisha().getDgShikakuShokaiFuzaisha().setDataSource(画面_不在者投票資格情報リスト);

    }

    private void set選挙資格(dgShikakuShokai_Row 画面_選挙資格情報, SenkyoShikakuResult 選挙資格情報) {
        List<KeyValueDataSource> 選挙資格区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
        List<KeyValueDataSource> 選挙資格区分_国民
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
        RString 選挙資格区分キー;
        if (null == 選挙資格情報.get選挙資格区分()) {
            選挙資格区分キー = RString.EMPTY;
        } else {
            選挙資格区分キー = 選挙資格情報.get選挙資格区分().getKey();
        }
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(選挙資格情報.get選挙種類().getKey())) {
            for (int j = 0; j < 選挙資格区分_国民.size(); j++) {
                if (選挙資格区分キー.equals(選挙資格区分_国民.get(j).getKey())) {
                    画面_選挙資格情報.setTxtSenkyoShikaku(選挙資格区分_国民.get(j).getValue());
                    break;
                }
            }

        } else {

            for (int j = 0; j < 選挙資格区分.size(); j++) {
                if (選挙資格区分キー.equals(選挙資格区分.get(j).getKey())) {
                    画面_選挙資格情報.setTxtSenkyoShikaku(選挙資格区分.get(j).getValue());
                    break;
                }
            }
        }
    }

    private void set登録事由(dgShikakuShokai_Row 画面_選挙資格情報, SenkyoShikakuResult 選挙資格情報) {
        List<KeyValueDataSource> 登録事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.登録事由コード.getCodeShubetsu());
        List<KeyValueDataSource> 登録事由コード_国民
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu());
        RString 登録事由コードキー;
        if (null == 選挙資格情報.get登録事由コード()) {
            登録事由コードキー = RString.EMPTY;
        } else {
            登録事由コードキー = 選挙資格情報.get登録事由コード().getKey();
        }
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(選挙資格情報.get選挙種類().getKey())) {
            for (int j = 0; j < 登録事由コード_国民.size(); j++) {
                if (登録事由コードキー.equals(登録事由コード_国民.get(j).getKey())) {
                    画面_選挙資格情報.setTxtTorokuJiyu(登録事由コード_国民.get(j).getValue());
                    break;
                }
            }
        } else {
            for (int j = 0; j < 登録事由コード.size(); j++) {
                if (登録事由コードキー.equals(登録事由コード.get(j).getKey())) {
                    画面_選挙資格情報.setTxtTorokuJiyu(登録事由コード.get(j).getValue());
                    break;
                }
            }
        }
    }

    private void set登録停止事由(dgShikakuShokai_Row 画面_選挙資格情報, SenkyoShikakuResult 選挙資格情報) {
        List<KeyValueDataSource> 登録停止事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu());
        RString 登録停止事由コードキー;
        if (null == 選挙資格情報.get登録停止事由コード()) {
            登録停止事由コードキー = RString.EMPTY;
        } else {
            登録停止事由コードキー = 選挙資格情報.get登録停止事由コード().getKey();
        }
        for (int j = 0; j < 登録停止事由コード.size(); j++) {
            if (登録停止事由コードキー.equals(登録停止事由コード.get(j).getKey())) {
                画面_選挙資格情報.setTxtTorokuTeishiJiyu(登録停止事由コード.get(j).getValue());
                break;
            }
        }
    }

    private void set表示事由(dgShikakuShokai_Row 画面_選挙資格情報, SenkyoShikakuResult 選挙資格情報) {
        List<KeyValueDataSource> 表示事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.表示事由コード.getCodeShubetsu());
        List<KeyValueDataSource> 表示事由コード_国民
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu());
        RString 表示事由コードキー;
        if (null == 選挙資格情報.get表示事由コード()) {
            表示事由コードキー = RString.EMPTY;
        } else {
            表示事由コードキー = 選挙資格情報.get表示事由コード().getKey();
        }
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(選挙資格情報.get選挙種類().getKey())) {
            for (int j = 0; j < 表示事由コード_国民.size(); j++) {
                if (表示事由コードキー.equals(表示事由コード_国民.get(j).getKey())) {
                    画面_選挙資格情報.setTxtHyojiJiyu(表示事由コード_国民.get(j).getValue());
                    break;
                }
            }
        } else {
            for (int j = 0; j < 表示事由コード.size(); j++) {
                if (表示事由コードキー.equals(表示事由コード.get(j).getKey())) {
                    画面_選挙資格情報.setTxtHyojiJiyu(表示事由コード.get(j).getValue());
                    break;
                }
            }
        }

    }

    private void set抹消事由(dgShikakuShokai_Row 画面_選挙資格情報, SenkyoShikakuResult 選挙資格情報) {
        List<KeyValueDataSource> 抹消事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.抹消事由コード.getCodeShubetsu());
        List<KeyValueDataSource> 抹消事由コード_国民
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu());
        RString 抹消事由コードキー;
        if (null == 選挙資格情報.get抹消事由コード()) {
            抹消事由コードキー = RString.EMPTY;
        } else {
            抹消事由コードキー = 選挙資格情報.get抹消事由コード().getKey();
        }
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(選挙資格情報.get選挙種類().getKey())) {
            for (int j = 0; j < 抹消事由コード_国民.size(); j++) {
                if (抹消事由コードキー.equals(抹消事由コード_国民.get(j).getKey())) {
                    画面_選挙資格情報.setTxtMasshoJiyu(抹消事由コード_国民.get(j).getValue());
                    break;
                }
            }
        } else {
            for (int j = 0; j < 抹消事由コード.size(); j++) {
                if (抹消事由コードキー.equals(抹消事由コード.get(j).getKey())) {
                    画面_選挙資格情報.setTxtMasshoJiyu(抹消事由コード.get(j).getValue());
                    break;
                }
            }
        }
    }

    private void set選挙種類(SennkyoSikakuShurui 選挙種類) {
        List<KeyValueDataSource> 選挙資格種類
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格種類.getCodeShubetsu());
        for (int i = 0; i < 選挙資格種類.size(); i++) {
            if (選挙種類.value().equals(選挙資格種類.get(i).getKey())) {
                div.getTxtSenkyoShurui().setValue(選挙資格種類.get(i).getValue());
                break;
            }
        }
    }

    private void set在外選挙資格(SennkyoSikakuShurui 選挙種類, dgShikakuShokai_Row 画面_在外選挙資格情報,
            ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 選挙資格区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
        List<KeyValueDataSource> 選挙資格区分_国民
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
        RString 表示事由コードキー;
        if (null == 在外選挙資格情報.get選挙資格区分()) {
            表示事由コードキー = RString.EMPTY;
        } else {
            表示事由コードキー = 在外選挙資格情報.get選挙資格区分().getKey();
        }
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(選挙種類.value())) {
            for (int j = 0; j < 選挙資格区分_国民.size(); j++) {
                if (表示事由コードキー.equals(選挙資格区分_国民.get(j).getKey())) {
                    画面_在外選挙資格情報.setTxtSenkyoShikaku(選挙資格区分_国民.get(j).getValue());
                    break;
                }
            }

        } else {

            for (int j = 0; j < 選挙資格区分.size(); j++) {
                if (表示事由コードキー.equals(選挙資格区分.get(j).getKey())) {
                    画面_在外選挙資格情報.setTxtSenkyoShikaku(選挙資格区分.get(j).getValue());
                    break;
                }
            }
        }
    }

    private void set在外表示事由(dgShikakuShokai_Row 画面_在外選挙資格情報, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 表示事由コード_在外
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu());
        RString 表示事由コードキー;
        if (null == 在外選挙資格情報.get表示事由コード()) {
            表示事由コードキー = RString.EMPTY;
        } else {
            表示事由コードキー = 在外選挙資格情報.get表示事由コード().getKey();
        }
        for (int j = 0; j < 表示事由コード_在外.size(); j++) {
            if (表示事由コードキー.equals(表示事由コード_在外.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtHyojiJiyu(表示事由コード_在外.get(j).getValue());
                break;
            }
        }
    }

    private void set在外抹消事由(dgShikakuShokai_Row 画面_在外選挙資格情報, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 抹消事由コード_在外
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu());
        RString 抹消事由コードキー;
        if (null == 在外選挙資格情報.get抹消事由コード()) {
            抹消事由コードキー = RString.EMPTY;
        } else {
            抹消事由コードキー = 在外選挙資格情報.get抹消事由コード().getKey();
        }
        for (int j = 0; j < 抹消事由コード_在外.size(); j++) {
            if (抹消事由コードキー.equals(抹消事由コード_在外.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtMasshoJiyu(抹消事由コード_在外.get(j).getValue());
                break;
            }
        }
    }

    private void set在外国民投票区分(dgShikakuShokai_Row 画面_在外選挙資格情報, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 国民投票区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.国民投票区分.getCodeShubetsu());
        RString 国民投票区分キー;
        if (null == 在外選挙資格情報.get国民投票区分()) {
            国民投票区分キー = RString.EMPTY;
        } else {
            国民投票区分キー = 在外選挙資格情報.get国民投票区分().getKey();
        }
        for (int j = 0; j < 国民投票区分.size(); j++) {
            if (国民投票区分キー.equals(国民投票区分.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtKokuminTohyoKubun(国民投票区分.get(j).getValue());
                break;
            }
        }
    }

    private void set在外本籍地登録区分(dgShikakuShokai_Row 画面_在外選挙資格情報,
            ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 本籍地登録区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.本籍地登録区分.getCodeShubetsu());
        RString 本籍地登録区分キー;
        if (null == 在外選挙資格情報.get本籍地登録区分()) {
            本籍地登録区分キー = RString.EMPTY;
        } else {
            本籍地登録区分キー = 在外選挙資格情報.get本籍地登録区分().getKey();
        }
        for (int j = 0; j < 本籍地登録区分.size(); j++) {
            if (本籍地登録区分キー.equals(本籍地登録区分.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtHonsekiTorokuKubun(本籍地登録区分.get(j).getValue());
                break;
            }
        }
    }

    private void set在外修正区分(dgShikakuShokai_Row 画面_在外選挙資格情報, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 修正区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.修正区分.getCodeShubetsu());
        RString 修正区分キー;
        if (null == 在外選挙資格情報.get修正区分()) {
            修正区分キー = RString.EMPTY;
        } else {
            修正区分キー = 在外選挙資格情報.get修正区分().getKey();
        }
        for (int j = 0; j < 修正区分.size(); j++) {
            if (修正区分キー.equals(修正区分.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtShuseiKubun(修正区分.get(j).getValue());
                break;
            }
        }
    }

    private void set在外再交付事由(dgShikakuShokai_Row 画面_在外選挙資格情報, ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 再交付事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.再交付事由コード.getCodeShubetsu());
        RString 再交付事由コードキー;
        if (null == 在外選挙資格情報.get再交付事由コード()) {
            再交付事由コードキー = RString.EMPTY;
        } else {
            再交付事由コードキー = 在外選挙資格情報.get再交付事由コード().getKey();
        }
        for (int j = 0; j < 再交付事由コード.size(); j++) {
            if (再交付事由コードキー.equals(再交付事由コード.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtSaiKofuJiyu(再交付事由コード.get(j).getValue());
                break;
            }
        }
    }

    private void set在外申請内容変更事由(dgShikakuShokai_Row 画面_在外選挙資格情報,
            ZaigaiSenkyoShikakuResult 在外選挙資格情報) {
        List<KeyValueDataSource> 申請内容変更事由コード
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu());
        RString 記載事項変更事由コードキー;
        if (null == 在外選挙資格情報.get記載事項変更事由コード()) {
            記載事項変更事由コードキー = RString.EMPTY;
        } else {
            記載事項変更事由コードキー = 在外選挙資格情報.get記載事項変更事由コード().getKey();
        }
        for (int j = 0; j < 申請内容変更事由コード.size(); j++) {
            if (記載事項変更事由コードキー.equals(申請内容変更事由コード.get(j).getKey())) {
                画面_在外選挙資格情報.setTxtHenkoJiyu(申請内容変更事由コード.get(j).getValue());
                break;
            }
        }
    }

    private void set不在者種類(dgShikakuShokaiFuzaisha_Row 画面_不在者投票資格情報,
            FuzaishaTohyoShikakuResult 不在者投票資格情報) {
        List<UzT0007CodeEntity> 投票資格種類 = CodeMaster.getCode(AFACodeShubetsu.投票資格種類.getCodeShubetsu());
        RString 投票資格種類キー;
        if (null == 不在者投票資格情報.get投票資格種類()) {
            投票資格種類キー = RString.EMPTY;
        } else {
            投票資格種類キー = 不在者投票資格情報.get投票資格種類().getKey();
        }
        for (int j = 0; j < 投票資格種類.size(); j++) {
            if (投票資格種類キー.equals(投票資格種類.get(j).getコード().getKey())) {
                画面_不在者投票資格情報.setTxtShurui(投票資格種類.get(j).getコード略称());
                break;
            }
        }
    }

    private void set不在者抹消事由(dgShikakuShokaiFuzaisha_Row 画面_不在者投票資格情報,
            FuzaishaTohyoShikakuResult 不在者投票資格情報) {
        List<KeyValueDataSource> 抹消事由コード_不在投票資格
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
        RString 資格抹消事由コードキー;
        if (null == 不在者投票資格情報.get資格抹消事由コード()) {
            資格抹消事由コードキー = RString.EMPTY;
        } else {
            資格抹消事由コードキー = 不在者投票資格情報.get資格抹消事由コード().getKey();
        }
        for (int j = 0; j < 抹消事由コード_不在投票資格.size(); j++) {
            if (資格抹消事由コードキー.equals(抹消事由コード_不在投票資格.get(j).getKey())) {
                画面_不在者投票資格情報.setTxtShikakuMasshoJiyu(抹消事由コード_不在投票資格.get(j).getValue());
                break;
            }
        }
    }

    private void set不在者入力区分(dgShikakuShokaiFuzaisha_Row 画面_不在者投票資格情報,
            FuzaishaTohyoShikakuResult 不在者投票資格情報) {
        List<KeyValueDataSource> 代理記載者入力区分
                = CodeMasterHelper.createDataSource(AFACodeShubetsu.代理記載者入力区分.getCodeShubetsu());
        RString 代理記載者入力区分キー;
        if (null == 不在者投票資格情報.get代理記載者入力区分()) {
            代理記載者入力区分キー = RString.EMPTY;
        } else {
            代理記載者入力区分キー = 不在者投票資格情報.get代理記載者入力区分().getKey();
        }
        for (int j = 0; j < 代理記載者入力区分.size(); j++) {
            if (代理記載者入力区分キー.equals(代理記載者入力区分.get(j).getKey())) {
                画面_不在者投票資格情報.setTxtDairiNyuryoku(代理記載者入力区分.get(j).getValue());
                break;
            }
        }
    }
}
