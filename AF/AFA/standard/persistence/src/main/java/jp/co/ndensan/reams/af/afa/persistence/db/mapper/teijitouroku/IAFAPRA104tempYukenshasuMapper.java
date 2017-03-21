/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104Entity;

/**
 * 登録者数リストデータのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public interface IAFAPRA104tempYukenshasuMapper {

    /**
     * 登録者名簿用情報を取得します。
     *
     * @return 選挙人一覧情報 List<AFAPRA104Entity>
     */
    List<AFAPRA104Entity> selectYukenshasuList();

}
