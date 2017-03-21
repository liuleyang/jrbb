/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyoku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Senkyoku}の編集を行うビルダークラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class SenkyokuBuilder {

    private final AfT503SenkyokuEntity entity;
    private final SenkyokuIdentifier id;

    /**
     * {@link AfT503SenkyokuEntity}より{@link Senkyoku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT503SenkyokuEntity}
     * @param id {@link SenkyokuIdentifier}
     *
     */
    SenkyokuBuilder(
            AfT503SenkyokuEntity entity,
            SenkyokuIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 選挙種類
     * @return {@link SenkyokuBuilder}
     */
    public SenkyokuBuilder set選挙種類(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        entity.setSenkyoShurui(選挙種類);
        return this;
    }

    /**
     * 選挙区コードを設定します。
     *
     * @param 選挙区コード 選挙区コード
     * @return {@link SenkyokuBuilder}
     */
    public SenkyokuBuilder set選挙区コード(RString 選挙区コード) {
        requireNonNull(選挙区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区コード"));
        entity.setSenkyokuCode(選挙区コード);
        return this;
    }

    /**
     * 選挙区名を設定します。
     *
     * @param 選挙区名 選挙区名
     * @return {@link SenkyokuBuilder}
     */
    public SenkyokuBuilder set選挙区名(RString 選挙区名) {
        requireNonNull(選挙区名, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区名"));
        entity.setSenkyokuName(選挙区名);
        return this;
    }

    /**
     * {@link Senkyoku}のインスタンスを生成します。
     *
     * @return {@link Senkyoku}のインスタンス
     */
    public Senkyoku build() {
        return new Senkyoku(entity, id);
    }
}
