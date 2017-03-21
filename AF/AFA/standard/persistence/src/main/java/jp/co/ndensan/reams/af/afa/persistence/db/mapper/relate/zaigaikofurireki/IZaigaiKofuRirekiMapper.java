/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaikofurireki;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zaigaikofurirekidialog.ZaigaiKofuRirekiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.apache.ibatis.annotations.Param;

/**
 * 在外交付履歴ダイアログのMapperクラス
 *
 * @reamsid_L AF-0320-014 xul
 */
public interface IZaigaiKofuRirekiMapper {

    /**
     * 引数.識別コードによって、交付履歴情報を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return List<ZaigaiKofuRirekiEntity>
     */
    List<ZaigaiKofuRirekiEntity> select交付履歴情報(@Param("shikibetsuCode") ShikibetsuCode shikibetsuCode);
}
