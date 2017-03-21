/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.maisukanri;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.maisukanri.MaisuKanriJouhou;

/**
 * 投票用紙枚数管理のマッパーインタフェースです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public interface IMaisuKanriMapper {

    /**
     * 投票用紙枚数リスト取得する。
     *
     * @param parm MaisuKanriJouhou
     * @return 投票用紙枚数情報 MaisuKanriJouhou
     */
    List<MaisuKanriJouhou> select投票用紙枚数リスト(MaisuKanriJouhou parm);

}
