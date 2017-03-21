/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;

/**
 * 投票日前日関連帳票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public interface IAFABTE504Mapper {

    /**
     * 投票日前日関連帳票情報を取得します。
     *
     * @param 投票日前日関連帳票検索条件 ZenjitsuPrintMybatisParameter
     * @return 投票日前日関連帳票情報 List<ZenjitsuPrintEntity>
     */
    List<ZenjitsuPrintEntity> selectZenjitsuPrintList(ZenjitsuPrintMybatisParameter 投票日前日関連帳票検索条件);
}
