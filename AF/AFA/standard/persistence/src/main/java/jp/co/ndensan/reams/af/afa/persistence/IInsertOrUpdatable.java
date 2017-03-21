/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * テーブルエンティティをインサート、またはアップデートするためのインタフェースです。
 *
 * @author N1823 有澤 礼恵
 * @param <T> データの型
 */
public interface IInsertOrUpdatable<T extends IDbAccessable> {

    /**
     * エンティティのインサート、またはアップデートを行います。
     *
     * @param entity 対象のエンティティ
     * @return 処理件数
     */
    int insertOrUpdate(T entity);

}
