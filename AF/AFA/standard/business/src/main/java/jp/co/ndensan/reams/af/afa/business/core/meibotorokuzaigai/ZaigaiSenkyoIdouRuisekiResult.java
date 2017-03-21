/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙異動累積情報のBusiness
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public class ZaigaiSenkyoIdouRuisekiResult {

    private final ZaigaiSenkyoIdouRuisekiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ZaigaiSenkyoIdouRuisekiEntity}より{@link MeibotorokuZaigaiResult}を生成します。
     *
     * @param entity DBより取得した{@link ZaigaiSenkyoIdouRuisekiEntity}
     */
    public ZaigaiSenkyoIdouRuisekiResult(ZaigaiSenkyoIdouRuisekiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙異動累積情報"));
    }

    /**
     * 本籍全国住所コードを返します。
     *
     * @return 本籍全国住所コード
     */
    public ZenkokuJushoCode get本籍全国住所コード() {
        return this.entity.get本籍全国住所コード();
    }

    /**
     * 本籍住所を返します。
     *
     * @return 本籍住所
     */
    public AtenaJusho get本籍住所() {
        return this.entity.get本籍住所();
    }

    /**
     * 本籍番地を返します。
     *
     * @return 本籍番地
     */
    public AtenaBanchi get本籍番地() {
        return this.entity.get本籍番地();
    }

    /**
     * 最終住所を返します。
     *
     * @return 最終住所
     */
    public AtenaJusho get最終住所() {
        return this.entity.get最終住所();
    }

    /**
     * 最終番地を返します。
     *
     * @return 最終番地
     */
    public AtenaBanchi get最終番地() {
        return this.entity.get最終番地();
    }

    /**
     * 最終方書を返します。
     *
     * @return 最終方書
     */
    public Katagaki get最終方書() {
        return this.entity.get最終方書();
    }

    /**
     * 現住所を返します。
     *
     * @return 現住所
     */
    public AtenaJusho get現住所() {
        return this.entity.get現住所();
    }

    /**
     * 送付先を返します。
     *
     * @return 送付先
     */
    public AtenaJusho get送付先() {
        return this.entity.get送付先();
    }

    /**
     * 選挙登録年月日を返します。
     *
     * @return 選挙登録年月日
     */
    public FlexibleDate get選挙登録年月日() {
        return this.entity.get在外選挙資格().getMeiboTorokuYMD();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.entity.get在外選挙資格().getTohyokuCode();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return this.entity.get在外選挙資格().getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        return this.entity.get在外選挙資格().getHyojiJiyuCode();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return this.entity.get在外選挙資格().getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        return this.entity.get在外選挙資格().getMasshoJiyuCode();
    }

    /**
     * 記載事項変更事由コードを返します。
     *
     * @return 記載事項変更事由コード
     */
    public Code get記載事項変更事由コード() {
        return this.entity.get在外選挙資格().getHenkoJiyuCode();
    }

    /**
     * 本籍地登録区分を返します。
     *
     * @return 本籍地登録区分
     */
    public Code get本籍地登録区分() {
        return this.entity.get在外選挙資格().getHonsekiTorokuKubun();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return this.entity.get在外選挙資格().getShikakuKubun();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return this.entity.get在外選挙資格().getKofuNo();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return this.entity.get在外選挙資格().getKofuYMD();
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return this.entity.get在外選挙人申請情報().getShinseiNo();
    }

    /**
     * 申請区分を返します。
     *
     * @return 申請区分
     */
    public Code get申請区分() {
        return this.entity.get在外選挙人申請情報().getShinseiKubun();
    }

    /**
     * 漢字氏名を返します。
     *
     * @return 漢字氏名
     */
    public AtenaMeisho get漢字氏名() {
        return this.entity.get在外選挙人申請情報().getShinseishaShimei();
    }

    /**
     * カナ氏名を返します。
     *
     * @return カナ氏名
     */
    public AtenaKanaMeisho getカナ氏名() {
        return this.entity.get在外選挙人申請情報().getShinseishaKanaShimei();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return this.entity.get在外選挙人申請情報().getSeinengappiYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return this.entity.get在外選挙人申請情報().getSeibetsuCode();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return this.entity.get在外選挙人申請情報().getShinseiYMD();
    }

    /**
     * 修正年月日を返します。
     *
     * @return 修正年月日
     */
    public FlexibleDate get修正年月日() {
        return this.entity.get在外選挙人申請情報().getHenkoYMD();
    }

    /**
     * 本籍地照会年月日を返します。
     *
     * @return 本籍地照会年月日
     */
    public FlexibleDate get本籍地照会年月日() {
        return this.entity.get在外選挙人申請情報().getHonsekiShokaiYMD();
    }

    /**
     * 本籍地回答年月日を返します。
     *
     * @return 本籍地回答年月日
     */
    public FlexibleDate get本籍地回答年月日() {
        return this.entity.get在外選挙人申請情報().getHonsekiKaitoYMD();
    }

    /**
     * 本籍地通知年月日を返します。
     *
     * @return 本籍地通知年月日
     */
    public FlexibleDate get本籍地通知年月日() {
        return this.entity.get在外選挙人申請情報().getHonsekiTsuchiYMD();
    }

    /**
     * 領事官コードを返します。
     *
     * @return 領事官コード
     */
    public RString get領事官コード() {
        return this.entity.get在外選挙人申請情報().getRyojikanCode();
    }

    /**
     * 却下事由コードを返します。
     *
     * @return 却下事由コード
     */
    public Code get却下事由コード() {
        return this.entity.get在外選挙人申請情報().getKyakkaJiyuCode();
    }
}
