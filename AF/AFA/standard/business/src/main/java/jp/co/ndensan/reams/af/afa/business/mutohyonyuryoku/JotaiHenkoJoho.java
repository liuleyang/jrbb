/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.JotaiHenkoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 状態変更情報です。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
public class JotaiHenkoJoho implements Serializable {

    private final JotaiHenkoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public JotaiHenkoJoho(JotaiHenkoEntity entity) {
        this.entity = entity;
    }

    /**
     * 投票情報のgetメソッドです。
     *
     * @return AfT201TohyoJokyoEntity
     */
    public AfT201TohyoJokyoEntity getTohyoJokyoEntity() {
        return entity.getTohyoJokyoEntity();
    }

    /**
     * 選挙番号のgetメソッドです。
     *
     * @return 選挙番号
     */
    public RString getSenkyoNo() {
        return entity.getSenkyoEntity() == null ? RString.EMPTY : new RString(entity.getSenkyoEntity().getSenkyoNo().toString());
    }

    /**
     * 選挙名称のgetメソッドです。
     *
     * @return 選挙名称
     */
    public RString getSenkyoName() {
        return entity.getSenkyoEntity().getSenkyoName() == null ? RString.EMPTY : entity.getSenkyoEntity().getSenkyoName();
    }

    /**
     * 投票状況のgetメソッドです。
     *
     * @return 投票状況
     */
    public Code getTohyoJokyo() {
        return entity.getTohyoJokyoEntity() == null ? Code.EMPTY : entity.getTohyoJokyoEntity().getTohyoJokyo();
    }

    /**
     * {@link TohyoJokyo}を返します。
     *
     * @return {@link TohyoJokyo}
     */
    public RString toTohyoJokyo() {
        AfT201TohyoJokyoEntity aft201 = entity.getTohyoJokyoEntity();
        if (aft201 == null) {
            return RString.EMPTY;
        }
        aft201.initializeMd5();
        return DataPassingConverter.serialize(aft201);
    }
}
