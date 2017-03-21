/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 海区付随情報の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class KaikuSenkyoFuzuiDBEditor {

    private final AfT133KaikuSenkyoFuzuiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public KaikuSenkyoFuzuiDBEditor(AfT133KaikuSenkyoFuzuiEntity entity) {
        this.entity = entity;
    }

    /**
     * 海区付随情報データの編集仕様
     *
     * @param meiboSakuseiKaikuEntity MeiboSakuseiKaikuEntity
     * @param 抄本番号 ShohonNo
     *
     * @return AfT100ShohonEntity
     */
    public AfT133KaikuSenkyoFuzuiEntity edit海区付随情報データ(MeiboSakuseiKaikuEntity meiboSakuseiKaikuEntity, ShohonNo 抄本番号) {
        if (meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui() != null) {
            entity.setShohonNo(抄本番号);
            entity.setShikibetsuCode(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getShikibetsuCode());
            entity.setGyogyoshaNo(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getGyogyoshaNo());
            entity.setKumiaiCode(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getKumiaiCode());
            entity.setNissuGyogyosha(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getNissuGyogyosha());
            entity.setNissuJujisha(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getNissuJujisha());
            entity.setGyogyoShurui(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getGyogyoShurui());
            entity.setGyosenShubetsu(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getGyosenShubetsu());
            entity.setSenmei(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getSenmei());
            entity.setTorokuNo(meiboSakuseiKaikuEntity.getAfT133KaikuSenkyoFuzui().getTorokuNo());
        }

        return entity;
    }

    /**
     * 海区付随情報データの編集仕様
     *
     * @param meiboTempTableEntity MeiboTempTableEntity
     * @param 抄本番号 ShohonNo
     *
     * @return AfT100ShohonEntity
     */
    public AfT133KaikuSenkyoFuzuiEntity edit海区付随情報(MeiboTempTableEntity meiboTempTableEntity, ShohonNo 抄本番号) {
        entity.setShohonNo(抄本番号);
        entity.setShikibetsuCode(meiboTempTableEntity.get識別コード());
        entity.setGyogyoshaNo(meiboTempTableEntity.get漁業者番号());
        entity.setKumiaiCode(meiboTempTableEntity.get組合コード());
        entity.setNissuGyogyosha(meiboTempTableEntity.get漁業日数漁業者());
        entity.setNissuJujisha(meiboTempTableEntity.get漁業日数漁業従事者());
        entity.setGyogyoShurui(new Code(meiboTempTableEntity.get漁業種類()));
        entity.setGyosenShubetsu(new Code(meiboTempTableEntity.get使用漁船種別()));
        entity.setSenmei(meiboTempTableEntity.get船名());
        entity.setTorokuNo(meiboTempTableEntity.get登録番号());

        return entity;
    }

    /**
     * 海区付随情報データの編集仕様
     *
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 抄本番号 ShohonNo
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT133KaikuSenkyoFuzuiEntity insert海区付随情報(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, AFABTK101tempTblEntity meiboEntity) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCodehaiku());
            entity.setGyogyoshaNo(meiboEntity.getGyogyoshaNo());
            entity.setKumiaiCode(meiboEntity.getKumiaiCode());
            entity.setNissuGyogyosha(meiboEntity.getNissuGyogyosha());
            entity.setNissuJujisha(meiboEntity.getNissuJujisha());
            entity.setGyogyoShurui(meiboEntity.getGyogyoShurui());
            entity.setGyosenShubetsu(meiboEntity.getGyosenShubetsu());
            entity.setSenmei(meiboEntity.getSenmei());
            entity.setTorokuNo(meiboEntity.getTorokuNo());
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCodehaiku());
            entity.setGyogyoshaNo(meiboEntity.getGyogyoshaNo());
            entity.setKumiaiCode(meiboEntity.getKumiaiCode());
            entity.setNissuGyogyosha(meiboEntity.getNissuGyogyosha());
            entity.setNissuJujisha(meiboEntity.getNissuJujisha());
            entity.setGyogyoShurui(meiboEntity.getGyogyoShurui());
            entity.setGyosenShubetsu(meiboEntity.getGyosenShubetsu());
            entity.setSenmei(meiboEntity.getSenmei());
            entity.setTorokuNo(meiboEntity.getTorokuNo());
        }

        return entity;
    }

    /**
     * 海区付随情報データの編集仕様
     *
     * @param processParameter AFABTK103SelectProcessParameter
     * @param 抄本番号 ShohonNo
     * @param 処理種別 RString
     * @param meiboEntity SenkyojiKaikuEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT133KaikuSenkyoFuzuiEntity edit登録の海区付随情報(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity meiboEntity) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別) && meiboEntity.getKaikuSenkyoFuzuiEntity() != null) {
            entity.setShohonNo(抄本番号);
            entity.setShikibetsuCode(meiboEntity.getKaikuSenkyoFuzuiEntity().getShikibetsuCode());
            entity.setGyogyoshaNo(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyogyoshaNo());
            entity.setKumiaiCode(meiboEntity.getKaikuSenkyoFuzuiEntity().getKumiaiCode());
            entity.setNissuGyogyosha(meiboEntity.getKaikuSenkyoFuzuiEntity().getNissuGyogyosha());
            entity.setNissuJujisha(meiboEntity.getKaikuSenkyoFuzuiEntity().getNissuJujisha());
            entity.setGyogyoShurui(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyogyoShurui());
            entity.setGyosenShubetsu(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyosenShubetsu());
            entity.setSenmei(meiboEntity.getKaikuSenkyoFuzuiEntity().getSenmei());
            entity.setTorokuNo(meiboEntity.getKaikuSenkyoFuzuiEntity().getTorokuNo());
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別) && meiboEntity.getKaikuSenkyoFuzuiEntity() != null) {
            entity.setShohonNo(抄本番号);
            entity.setShikibetsuCode(meiboEntity.getKaikuSenkyoFuzuiEntity().getShikibetsuCode());
            entity.setGyogyoshaNo(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyogyoshaNo());
            entity.setKumiaiCode(meiboEntity.getKaikuSenkyoFuzuiEntity().getKumiaiCode());
            entity.setNissuGyogyosha(meiboEntity.getKaikuSenkyoFuzuiEntity().getNissuGyogyosha());
            entity.setNissuJujisha(meiboEntity.getKaikuSenkyoFuzuiEntity().getNissuJujisha());
            entity.setGyogyoShurui(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyogyoShurui());
            entity.setGyosenShubetsu(meiboEntity.getKaikuSenkyoFuzuiEntity().getGyosenShubetsu());
            entity.setSenmei(meiboEntity.getKaikuSenkyoFuzuiEntity().getSenmei());
            entity.setTorokuNo(meiboEntity.getKaikuSenkyoFuzuiEntity().getTorokuNo());
        }

        return entity;
    }
}
