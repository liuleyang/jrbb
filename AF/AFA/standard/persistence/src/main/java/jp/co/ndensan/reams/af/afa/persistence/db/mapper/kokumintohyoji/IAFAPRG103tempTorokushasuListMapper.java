/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji;

import jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku.AFAPRG103Entity;

/**
 * 登録者数リストデータのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public interface IAFAPRG103tempTorokushasuListMapper {

    /**
     * 登録者数リスト用情報を取得します。
     *
     * @return 登録者数リストのデータリスト List<AFAPRG103Entity>
     */
    AFAPRG103Entity selectDataForTorokushasuList();
}
