/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格を管理するクラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuSenkyoShikaku {

    private final AfT113SenkyoShikakuEntity entity;

    /**
     * コンストラクタです。<br/>
     * 選挙資格の新規作成時に使用します。
     *
     * @param 選挙種類 選挙種類
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @param 選挙資格区分 選挙資格区分
     * @param 投票区コード 投票区コード
     * @param 名簿登録年月日 名簿登録年月日
     * @param 登録事由コード 登録事由コード
     * @param 登録停止年月日 登録停止年月日
     * @param 登録停止事由コード 登録停止事由コード
     * @param 表示年月日 表示年月日
     * @param 表示事由コード 表示事由コード
     * @param 表示消除年月日 表示消除年月日
     * @param 表示消除予定年月日 表示消除予定年月日
     * @param 抹消年月日 抹消年月日
     * @param 抹消事由コード 抹消事由コード
     * @param 刑期終了年月日 刑期終了年月日
     * @param 刑持ち 刑持ち
     * @param データ登録年月日 データ登録年月日
     */
    public KaikuSenkyoShikaku(Code 選挙種類,
            ShikibetsuCode 識別コード,
            BigSerial 履歴番号,
            Code 選挙資格区分,
            RString 投票区コード,
            FlexibleDate 名簿登録年月日,
            Code 登録事由コード,
            FlexibleDate 登録停止年月日,
            Code 登録停止事由コード,
            FlexibleDate 表示年月日,
            Code 表示事由コード,
            FlexibleDate 表示消除年月日,
            FlexibleDate 表示消除予定年月日,
            FlexibleDate 抹消年月日,
            Code 抹消事由コード,
            FlexibleDate 刑期終了年月日,
            boolean 刑持ち,
            FlexibleDate データ登録年月日) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(刑持ち, UrSystemErrorMessages.値がnull.getReplacedMessage("2刑持ち"));
        this.entity = new AfT113SenkyoShikakuEntity();
        this.entity.setSenkyoShurui(選挙種類);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setSeq(履歴番号);
        this.entity.setShikakuKubun(選挙資格区分);
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setMeiboTorokuYMD(名簿登録年月日);
        this.entity.setTorokuJiyuCode(登録事由コード);
        this.entity.setTorokuTeishiYMD(登録停止年月日);
        this.entity.setTorokuTeishiJiyuCode(登録停止事由コード);
        this.entity.setHyojiYMD(表示年月日);
        this.entity.setHyojiJiyuCode(表示事由コード);
        this.entity.setHyojiShojoYMD(表示消除年月日);
        this.entity.setHyojiShojoYoteiYMD(表示消除予定年月日);
        this.entity.setMasshoYMD(抹消年月日);
        this.entity.setMasshoJiyuCode(抹消事由コード);
        this.entity.setKeikiShuryoYMD(刑期終了年月日);
        this.entity.setNikeimochiFlag(刑持ち);
        this.entity.setDataTorokuYMD(データ登録年月日);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT113SenkyoShikakuEntity}
     */
    KaikuSenkyoShikaku(
            AfT113SenkyoShikakuEntity entity
    ) {
        this.entity = entity;
    }

    /**
     * {@link AfT113SenkyoShikakuEntity}のクローンを返します。
     *
     * @return {@link AfT113SenkyoShikakuEntity}のクローン
     */
    public AfT113SenkyoShikakuEntity toEntity() {
        return this.entity.clone();
    }
}
