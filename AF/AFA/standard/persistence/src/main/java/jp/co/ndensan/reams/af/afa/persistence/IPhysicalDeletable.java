/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * テーブルデータを物理削除するためのインタフェースです。
 *
 * @author N1823 有澤 礼恵
 * @param <T> データの型
 */
public interface IPhysicalDeletable<T extends IDbAccessable> {

    /**
     * データの物理削除を行います。
     *
     * @param data 対象のエンティティ
     * @return 削除件数
     */
    int deletePhysical(T data);

}
