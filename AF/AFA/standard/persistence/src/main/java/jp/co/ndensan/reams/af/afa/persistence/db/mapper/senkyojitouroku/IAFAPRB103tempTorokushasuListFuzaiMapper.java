/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku;

import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA103Entity;

/**
 * 登録者数リストデータのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public interface IAFAPRB103tempTorokushasuListFuzaiMapper {

    /**
     * 登録者名簿用情報を取得します。
     *
     * @return 選挙人一覧情報 List<AFAPRA103Entity>
     */
    AFAPRA103Entity selectTorokushasuList();

}
