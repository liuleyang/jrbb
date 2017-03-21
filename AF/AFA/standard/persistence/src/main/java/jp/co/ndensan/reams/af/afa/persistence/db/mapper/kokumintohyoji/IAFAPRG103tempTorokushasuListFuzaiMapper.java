/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.TorokushasuListFuzaiShikakuDataEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103FuzaiShikakuEntity;

/**
 * 登録者数リスト不在者分データのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public interface IAFAPRG103tempTorokushasuListFuzaiMapper {

    /**
     * 登録者数リスト不在者分のデータを取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 登録者数リスト不在者分のデータリスト List<TorokushasuListFuzaiShikakuDataEntity>
     */
    List<TorokushasuListFuzaiShikakuDataEntity> selectTorokushasuListFuzaiShikaku(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 登録者数リスト不在者分帳票出力用のデータを取得します。
     *
     * @return 登録者数リスト不在者分帳票出力用のデータリスト List<AFAPRA103FuzaiShikakuEntity>
     */
    AFAPRA103FuzaiShikakuEntity selectDataForTorokushasuList();
}
