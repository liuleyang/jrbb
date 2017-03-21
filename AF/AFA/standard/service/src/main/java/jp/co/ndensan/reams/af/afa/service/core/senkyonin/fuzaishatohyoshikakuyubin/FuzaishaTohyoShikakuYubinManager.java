/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikakuyubin;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT115FuzaishaTohyoShikakuYubinDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 郵便投票資格付随情報を管理するクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class FuzaishaTohyoShikakuYubinManager {

    private final AfT115FuzaishaTohyoShikakuYubinDac dac;

    /**
     * コンストラクタです。
     */
    public FuzaishaTohyoShikakuYubinManager() {
        dac = InstanceProvider.create(AfT115FuzaishaTohyoShikakuYubinDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT115FuzaishaTohyoShikakuYubinDac}
     */
    FuzaishaTohyoShikakuYubinManager(AfT115FuzaishaTohyoShikakuYubinDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する郵便投票資格付随情報を返します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @return FuzaishaTohyoShikakuYubin
     */
    @Transaction
    public FuzaishaTohyoShikakuYubin get郵便投票資格付随情報(
            ShikibetsuCode 識別コード,
            BigSerial 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        AfT115FuzaishaTohyoShikakuYubinEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FuzaishaTohyoShikakuYubin(entity);
    }

    /**
     * 郵便投票資格付随情報を全件返します。
     *
     * @return FuzaishaTohyoShikakuYubinの{@code list}
     */
    @Transaction
    public List<FuzaishaTohyoShikakuYubin> get郵便投票資格付随情報一覧() {
        List<FuzaishaTohyoShikakuYubin> businessList = new ArrayList<>();

        for (AfT115FuzaishaTohyoShikakuYubinEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FuzaishaTohyoShikakuYubin(entity));
        }

        return businessList;
    }

    /**
     * 郵便投票資格付随情報{@link FuzaishaTohyoShikakuYubin}を保存します。
     *
     * @param 郵便投票資格付随情報 {@link FuzaishaTohyoShikakuYubin}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save郵便投票資格付随情報(FuzaishaTohyoShikakuYubin 郵便投票資格付随情報) {
        requireNonNull(郵便投票資格付随情報, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報"));
        if (!郵便投票資格付随情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(郵便投票資格付随情報.toEntity());
    }

    /**
     * 郵便投票資格付随情報{@link FuzaishaTohyoShikakuYubin}を保存します。
     *
     * @param 郵便投票資格付随情報 {@link FuzaishaTohyoShikakuYubin}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save郵便投票(FuzaishaTohyoShikakuYubin 郵便投票資格付随情報) {
        requireNonNull(郵便投票資格付随情報, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便投票資格付随情報"));
        if (!郵便投票資格付随情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save郵便投票資格(郵便投票資格付随情報.toEntity());
    }
}
