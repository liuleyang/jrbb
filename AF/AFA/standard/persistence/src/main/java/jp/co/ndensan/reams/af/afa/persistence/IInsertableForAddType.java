/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence;

import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 追記型テーブルのデータアクセス用インターフェース
 *
 * @author N1823 有澤 礼恵
 * @param <T>
 */
public interface IInsertableForAddType<T> {

    /**
     * 対象EntityをDBに登録します。
     *
     * @param entity 登録用Entity
     * @return 登録件数
     */
    @Transaction
    int insert(T entity);

    /**
     * 対象Entityの削除データをDBに登録します。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    int insertDenialRow(T entity);

}
