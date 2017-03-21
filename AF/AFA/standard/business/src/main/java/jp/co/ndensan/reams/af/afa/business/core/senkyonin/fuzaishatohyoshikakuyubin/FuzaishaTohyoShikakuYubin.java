/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 郵便投票資格付随情報を管理するクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class FuzaishaTohyoShikakuYubin extends
        ModelBase<FuzaishaTohyoShikakuYubinIdentifier, AfT115FuzaishaTohyoShikakuYubinEntity, FuzaishaTohyoShikakuYubin> implements Serializable {

    private final AfT115FuzaishaTohyoShikakuYubinEntity entity;
    private final FuzaishaTohyoShikakuYubinIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 郵便投票資格付随情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public FuzaishaTohyoShikakuYubin(ShikibetsuCode 識別コード, BigSerial 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new AfT115FuzaishaTohyoShikakuYubinEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setSeq(履歴番号);
        this.id = new FuzaishaTohyoShikakuYubinIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT115FuzaishaTohyoShikakuYubinEntity}より{@link FuzaishaTohyoShikakuYubin}を生成します。
     *
     * @param entity DBより取得した{@link AfT115FuzaishaTohyoShikakuYubinEntity}
     */
    public FuzaishaTohyoShikakuYubin(AfT115FuzaishaTohyoShikakuYubinEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報"));
        this.id = new FuzaishaTohyoShikakuYubinIdentifier(
                entity.getShikibetsuCode(),
                entity.getSeq());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT115FuzaishaTohyoShikakuYubinEntity}
     * @param id {@link FuzaishaTohyoShikakuYubinIdentifier}
     */
    FuzaishaTohyoShikakuYubin(
            AfT115FuzaishaTohyoShikakuYubinEntity entity,
            FuzaishaTohyoShikakuYubinIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return entity.getSeq();
    }

    /**
     * 身体障害者手帳有フラグを返します。
     *
     * @return 身体障害者手帳有フラグ
     */
    public boolean is身体障害者手帳有() {
        return entity.getShogaiTechoAriFlag();
    }

    /**
     * 戦傷病者手帳有フラグを返します。
     *
     * @return 戦傷病者手帳有フラグ
     */
    public boolean is戦傷病者手帳有() {
        return entity.getSenshoTechoAriFlag();
    }

    /**
     * 介護保険被保険者証有フラグを返します。
     *
     * @return 介護保険被保険者証有フラグ
     */
    public boolean is介護保険被保険者証有() {
        return entity.getKaigoHokenshoAriFlag();
    }

    /**
     * 代理記載者入力区分を返します。
     *
     * @return 代理記載者入力区分
     */
    public Code get代理記載者入力区分() {
        return entity.getDairiInputKubun();
    }

    /**
     * 代理記載者識別コードを返します。
     *
     * @return 代理記載者識別コード
     */
    public ShikibetsuCode get代理記載者識別コード() {
        return entity.getDairiShikibetsuCode();
    }

    /**
     * 代理記載者漢字氏名を返します。
     *
     * @return 代理記載者漢字氏名
     */
    public AtenaMeisho get代理記載者漢字氏名() {
        return entity.getDairiKanjiShimei();
    }

    /**
     * 代理記載者カナ氏名を返します。
     *
     * @return 代理記載者カナ氏名
     */
    public AtenaKanaMeisho get代理記載者カナ氏名() {
        return entity.getDairiKanaShimei();
    }

    /**
     * 代理記載者生年月日を返します。
     *
     * @return 代理記載者生年月日
     */
    public FlexibleDate get代理記載者生年月日() {
        return entity.getDairiSeinengappiYMD();
    }

    /**
     * 代理記載者性別コードを返します。
     *
     * @return 代理記載者性別コード
     */
    public RString get代理記載者性別コード() {
        return entity.getDairiSeibetsuCode();
    }

    /**
     * 代理記載者郵便番号を返します。
     *
     * @return 代理記載者郵便番号
     */
    public YubinNo get代理記載者郵便番号() {
        return entity.getDairiYubinNo();
    }

    /**
     * 代理記載者住所を返します。
     *
     * @return 代理記載者住所
     */
    public AtenaJusho get代理記載者住所() {
        return entity.getDairiJusho();
    }

    /**
     * {@link AfT115FuzaishaTohyoShikakuYubinEntity}のクローンを返します。
     *
     * @return {@link AfT115FuzaishaTohyoShikakuYubinEntity}のクローン
     */
    @Override
    public AfT115FuzaishaTohyoShikakuYubinEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 郵便投票資格付随情報の識別子{@link FuzaishaTohyoShikakuYubinIdentifier}を返します。
     *
     * @return 郵便投票資格付随情報の識別子{@link FuzaishaTohyoShikakuYubinIdentifier}
     */
    @Override
    public FuzaishaTohyoShikakuYubinIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する郵便投票資格付随情報を削除対象とします。<br/>
     * {@link AfT115FuzaishaTohyoShikakuYubinEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FuzaishaTohyoShikakuYubin}
     * @throws IllegalStateException AfT115FuzaishaTohyoShikakuYubinEntityのデータ状態が変更の場合
     */
    @Override
    public FuzaishaTohyoShikakuYubin deleted() {
        AfT115FuzaishaTohyoShikakuYubinEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FuzaishaTohyoShikakuYubin(deletedEntity, id);
    }

    /**
     * {@link FuzaishaTohyoShikakuYubin}のシリアライズ形式を提供します。
     *
     * @return {@link FuzaishaTohyoShikakuYubin}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4437773484321568993L;
        private final AfT115FuzaishaTohyoShikakuYubinEntity entity;
        private final FuzaishaTohyoShikakuYubinIdentifier id;

        private _SerializationProxy(AfT115FuzaishaTohyoShikakuYubinEntity entity, FuzaishaTohyoShikakuYubinIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FuzaishaTohyoShikakuYubin(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FuzaishaTohyoShikakuYubinBuilder createBuilderForEdit() {
        return new FuzaishaTohyoShikakuYubinBuilder(entity, id);
    }

}
