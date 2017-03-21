/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shikakushokai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者投票資格情報を管理するクラスです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
public class FuzaishaTohyoShikakuResult {

    private final AfT114FuzaishaTohyoShikakuEntity 不在者投票資格Entity;
    private final AfT115FuzaishaTohyoShikakuYubinEntity 郵便投票資格付随情報Entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity},{@link AfT115FuzaishaTohyoShikakuYubinEntity}
     * より{@link FuzaishaTohyoShikakuResult}を生成します。
     *
     * @param 不在者投票資格Entity DBより取得した{@link AfT114FuzaishaTohyoShikakuEntity}
     * @param 郵便投票資格付随情報Entity DBより取得した{@link AfT115FuzaishaTohyoShikakuYubinEntity}
     */
    public FuzaishaTohyoShikakuResult(AfT114FuzaishaTohyoShikakuEntity 不在者投票資格Entity,
            AfT115FuzaishaTohyoShikakuYubinEntity 郵便投票資格付随情報Entity) {
        this.不在者投票資格Entity = requireNonNull(不在者投票資格Entity,
                UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格"));
        this.郵便投票資格付随情報Entity = requireNonNull(郵便投票資格付随情報Entity,
                UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報Entity"));
    }

    /**
     * 投票資格種類を返します。
     *
     * @return 投票資格種類
     */
    public Code get投票資格種類() {
        return this.不在者投票資格Entity.getTohyoShikakuShurui();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return this.不在者投票資格Entity.getSeq();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return this.不在者投票資格Entity.getKofuYMD();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return this.不在者投票資格Entity.getKofuNo();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格登録年月日() {
        return this.不在者投票資格Entity.getShikakuTorokuYMD();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格満了年月日() {
        return this.不在者投票資格Entity.getShikakuManryoYMD();
    }

    /**
     * 資格抹消年月日を返します。
     *
     * @return 資格抹消年月日
     */
    public FlexibleDate get資格抹消年月日() {
        return this.不在者投票資格Entity.getShikakuMasshoYMD();
    }

    /**
     * 資格抹消事由コードを返します。
     *
     * @return 資格抹消事由コード
     */
    public Code get資格抹消事由コード() {
        return this.不在者投票資格Entity.getShikakuMasshoJiyuCode();
    }

    /**
     * 身体障害者手帳有フラグを返します。
     *
     * @return 身体障害者手帳有フラグ
     */
    public boolean is身体障害者手帳有() {
        return 郵便投票資格付随情報Entity.getShogaiTechoAriFlag();
    }

    /**
     * 戦傷病者手帳有フラグを返します。
     *
     * @return 戦傷病者手帳有フラグ
     */
    public boolean is戦傷病者手帳有() {
        return 郵便投票資格付随情報Entity.getSenshoTechoAriFlag();
    }

    /**
     * 介護保険被保険者証有フラグを返します。
     *
     * @return 介護保険被保険者証有フラグ
     */
    public boolean is介護保険被保険者証有() {
        return 郵便投票資格付随情報Entity.getKaigoHokenshoAriFlag();
    }

    /**
     * 代理記載者入力区分を返します。
     *
     * @return 代理記載者入力区分
     */
    public Code get代理記載者入力区分() {
        return 郵便投票資格付随情報Entity.getDairiInputKubun();
    }

    /**
     * 代理記載者識別コードを返します。
     *
     * @return 代理記載者識別コード
     */
    public ShikibetsuCode get代理記載者識別コード() {
        return 郵便投票資格付随情報Entity.getDairiShikibetsuCode();
    }

    /**
     * 代理記載者漢字氏名を返します。
     *
     * @return 代理記載者漢字氏名
     */
    public AtenaMeisho get代理記載者漢字氏名() {
        return 郵便投票資格付随情報Entity.getDairiKanjiShimei();
    }

    /**
     * 代理記載者カナ氏名を返します。
     *
     * @return 代理記載者カナ氏名
     */
    public AtenaKanaMeisho get代理記載者カナ氏名() {
        return 郵便投票資格付随情報Entity.getDairiKanaShimei();
    }

    /**
     * 代理記載者生年月日を返します。
     *
     * @return 代理記載者生年月日
     */
    public FlexibleDate get代理記載者生年月日() {
        return 郵便投票資格付随情報Entity.getDairiSeinengappiYMD();
    }

    /**
     * 代理記載者性別コードを返します。
     *
     * @return 代理記載者性別コード
     */
    public RString get代理記載者性別コード() {
        return 郵便投票資格付随情報Entity.getDairiSeibetsuCode();
    }

    /**
     * 代理記載者郵便番号を返します。
     *
     * @return 代理記載者郵便番号
     */
    public YubinNo get代理記載者郵便番号() {
        return 郵便投票資格付随情報Entity.getDairiYubinNo();
    }

    /**
     * 代理記載者住所を返します。
     *
     * @return 代理記載者住所
     */
    public AtenaJusho get代理記載者住所() {
        return 郵便投票資格付随情報Entity.getDairiJusho();
    }
}
