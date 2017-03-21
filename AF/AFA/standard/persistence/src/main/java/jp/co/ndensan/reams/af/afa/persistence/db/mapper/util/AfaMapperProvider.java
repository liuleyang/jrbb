/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.util;

import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * sessionからMapperを取得するクラスです。
 *
 */
public class AfaMapperProvider {

    @InjectSession
    private SqlSession session;

    /**
     * sessionからMapperを取得して返します。
     *
     * @param <T> Mapper
     * @param clazz Mapperインタフェース
     * @return Mapper
     */
    @Transaction
    public <T> T create(Class<T> clazz) {
        return this.session.getMapper(clazz);
    }
}
