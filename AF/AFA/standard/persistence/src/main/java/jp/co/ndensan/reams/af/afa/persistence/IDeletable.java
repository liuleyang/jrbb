/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * テーブルエンティティを削除するためのインタフェースです。
 *
 * @author N1823 有澤 礼恵
 * @param <T> データの型
 */
public interface IDeletable<T extends IDbAccessable> {

    /**
     * エンティティの削除を行います。
     *
     * @param entity 対象のエンティティ
     * @return 削除件数
     */
    int delete(T entity);

}
