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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 海区名簿更新日の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboKaikuSenkyoDBEditor {

    private final AfT131KaikuSenkyoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public MeiboKaikuSenkyoDBEditor(AfT131KaikuSenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 海区名簿更新日データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT131KaikuSenkyoEntity edit海区名簿更新日データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, AFABTK101tempTblEntity meiboEntity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get名簿確定日().getYear().toDateString()));
            entity.setSakuseiYMD(processParameter.get名簿確定日());
            entity.setKakuteiYMD(processParameter.get名簿確定日());
            entity.setSenkyojiTorokuFlag(false);
            entity.setSaishinkaYMD(processParameter.get名簿確定日());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get名簿確定日().getYear().toDateString()));
            entity.setSakuseiYMD(processParameter.get名簿確定日());
            entity.setKakuteiYMD(processParameter.get名簿確定日());
            entity.setSenkyojiTorokuFlag(false);
            entity.setSaishinkaYMD(processParameter.get名簿確定日());
        }

        return entity;
    }

    /**
     * 海区名簿更新日データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     *
     * @return AfT100ShohonEntity
     */
    public AfT131KaikuSenkyoEntity edit入力ファイルの海区名簿更新日データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get名簿確定日().getYear().toDateString()));
            entity.setSakuseiYMD(processParameter.get名簿確定日());
            entity.setKakuteiYMD(processParameter.get名簿確定日());
            entity.setSenkyojiTorokuFlag(false);
            entity.setSaishinkaYMD(processParameter.get名簿確定日());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get名簿確定日().getYear().toDateString()));
            entity.setSakuseiYMD(processParameter.get名簿確定日());
            entity.setKakuteiYMD(processParameter.get名簿確定日());
            entity.setSenkyojiTorokuFlag(false);
            entity.setSaishinkaYMD(processParameter.get名簿確定日());
        }

        return entity;
    }

    /**
     * 海区名簿更新日データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK103SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity SenkyojiKaikuEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT131KaikuSenkyoEntity edit登録の海区名簿更新日データ(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity meiboEntity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get基準日().getYear().toDateString()));
            entity.setSakuseiYMD(FlexibleDate.getNowDate());
            entity.setKakuteiYMD(processParameter.get基準日());
            entity.setSenkyojiTorokuFlag(true);
            entity.setSaishinkaYMD(processParameter.get基準日());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setNendo(new RYear(processParameter.get基準日().getYear().toDateString()));
            entity.setSakuseiYMD(FlexibleDate.getNowDate());
            entity.setKakuteiYMD(processParameter.get基準日());
            entity.setSenkyojiTorokuFlag(true);
            entity.setSaishinkaYMD(processParameter.get基準日());
        }

        return entity;
    }

}
