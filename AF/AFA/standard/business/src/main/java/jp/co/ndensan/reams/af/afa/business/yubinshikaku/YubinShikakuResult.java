/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.yubinshikaku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.relate.yubinshikaku.YubinShikakuEntity;
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
 * 投票資格情報検索結果です。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class YubinShikakuResult {

    private final YubinShikakuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity YubinShikakuEntity
     */
    public YubinShikakuResult(YubinShikakuEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.get不在者投票資格().getShikibetsuCode();
    }

    /**
     * 投票資格種類を返します。
     *
     * @return 投票資格種類
     */
    public Code get投票資格種類() {
        return this.entity.get不在者投票資格().getTohyoShikakuShurui();
    }

    /**
     * 不在者投票資格履歴番号を返します。
     *
     * @return 不在者投票資格履歴番号
     */
    public BigSerial get不在者投票資格履歴番号() {
        return this.entity.get不在者投票資格().getSeq();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return this.entity.get不在者投票資格().getKofuYMD();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return this.entity.get不在者投票資格().getKofuNo();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格登録年月日() {
        return this.entity.get不在者投票資格().getShikakuTorokuYMD();
    }

    /**
     * 資格満了年月日を返します。
     *
     * @return 資格満了年月日
     */
    public FlexibleDate get資格満了年月日() {
        return this.entity.get不在者投票資格().getShikakuManryoYMD();
    }

    /**
     * 資格抹消年月日を返します。
     *
     * @return 資格抹消年月日
     */
    public FlexibleDate get資格抹消年月日() {
        return this.entity.get不在者投票資格().getShikakuMasshoYMD();
    }

    /**
     * 資格抹消事由コードを返します。
     *
     * @return 資格抹消事由コード
     */
    public Code get資格抹消事由コード() {
        return this.entity.get不在者投票資格().getShikakuMasshoJiyuCode();
    }

    /**
     * 郵便投票資格付随情報履歴番号を返します。
     *
     * @return 郵便投票資格付随情報履歴番号
     */
    public BigSerial get郵便投票資格付随情報履歴番号() {
        return this.entity.get郵便投票資格付随情報().getSeq();
    }

    /**
     * 身体障害者手帳有フラグを返します。
     *
     * @return 身体障害者手帳有フラグ
     */
    public boolean is身体障害者手帳有フラグ() {
        return this.entity.get郵便投票資格付随情報().getShogaiTechoAriFlag();
    }

    /**
     * 戦傷病者手帳有フラグを返します。
     *
     * @return 戦傷病者手帳有フラグ
     */
    public boolean is戦傷病者手帳有フラグ() {
        return this.entity.get郵便投票資格付随情報().getSenshoTechoAriFlag();
    }

    /**
     * 介護保険被保険者証有フラグを返します。
     *
     * @return 介護保険被保険者証有フラグ
     */
    public boolean is介護保険被保険者証有フラグ() {
        return this.entity.get郵便投票資格付随情報().getKaigoHokenshoAriFlag();
    }

    /**
     * 代理記載者入力区分を返します。
     *
     * @return 代理記載者入力区分
     */
    public Code get代理記載者入力区分() {
        return this.entity.get郵便投票資格付随情報().getDairiInputKubun();
    }

    /**
     * 代理記載者識別コードを返します。
     *
     * @return 代理記載者識別コード
     */
    public ShikibetsuCode get代理記載者識別コード() {
        return this.entity.get郵便投票資格付随情報().getDairiShikibetsuCode();
    }

    /**
     * 代理記載者漢字氏名を返します。
     *
     * @return 代理記載者漢字氏名
     */
    public AtenaMeisho get代理記載者漢字氏名() {
        return this.entity.get郵便投票資格付随情報().getDairiKanjiShimei();
    }

    /**
     * 代理記載者カナ氏名を返します。
     *
     * @return 代理記載者カナ氏名
     */
    public AtenaKanaMeisho get代理記載者カナ氏名() {
        return this.entity.get郵便投票資格付随情報().getDairiKanaShimei();
    }

    /**
     * 代理記載者生年月日を返します。
     *
     * @return 代理記載者生年月日
     */
    public FlexibleDate get代理記載者生年月日() {
        return this.entity.get郵便投票資格付随情報().getDairiSeinengappiYMD();
    }

    /**
     * 代理記載者性別コードを返します。
     *
     * @return 代理記載者性別コード
     */
    public RString get代理記載者性別コード() {
        return this.entity.get郵便投票資格付随情報().getDairiSeibetsuCode();
    }

    /**
     * 代理記載者郵便番号を返します。
     *
     * @return 代理記載者郵便番号
     */
    public YubinNo get代理記載者郵便番号() {
        return this.entity.get郵便投票資格付随情報().getDairiYubinNo();
    }

    /**
     * 代理記載者住所を返します。
     *
     * @return 代理記載者住所
     */
    public AtenaJusho get代理記載者住所() {
        return this.entity.get郵便投票資格付随情報().getDairiJusho();
    }

    /**
     * YubinShikakuEntityを返します。
     *
     * @return YubinShikakuEntity
     */
    public YubinShikakuEntity getEntity() {
        return entity;
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final YubinShikakuEntity yubinShikakuEntity;
        private static final long serialVersionUID = 351900186803745759L;

        private _SerializationProxy(YubinShikakuResult yubinShikakuResult) {
            this.yubinShikakuEntity = yubinShikakuResult.getEntity();
        }

        private Object readResolve() {
            return new YubinShikakuResult(yubinShikakuEntity);
        }
    }
}
