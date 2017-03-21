/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 抄本の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class ShohonDBEditor {

    private final AfT100ShohonEntity shohonEntity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public ShohonDBEditor(AfT100ShohonEntity entity) {
        this.shohonEntity = entity;
    }

    /**
     * 抄本データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     *
     * @return AfT100ShohonEntity
     */
    public AfT100ShohonEntity edit抄本データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get名簿確定日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get年齢到達日());
            shohonEntity.setShohonName(processParameter.get抄本名());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get名簿確定日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get年齢到達日());
            shohonEntity.setShohonName(processParameter.get抄本名());

        }
        return shohonEntity;
    }

    /**
     * 抄本データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     *
     * @return AfT100ShohonEntity
     */
    public AfT100ShohonEntity edit入力ファイルの抄本データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get名簿確定日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get年齢到達日());
            shohonEntity.setShohonName(processParameter.get抄本名());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get名簿確定日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get年齢到達日());
            shohonEntity.setShohonName(processParameter.get抄本名());

        }
        return shohonEntity;
    }

    /**
     * 抄本データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param entity SenkyojiKaikuEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT100ShohonEntity edit登録の抄本データ(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity entity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get投票日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get投票日().plusDay(1));
            shohonEntity.setShohonName(processParameter.get抄本名());
            shohonEntity.setNyujokenReportIndex(Decimal.ZERO);

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            shohonEntity.setShohonNo(抄本番号);
            shohonEntity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            shohonEntity.setShoriYMD(FlexibleDate.getNowDate());
            shohonEntity.setTohyoYMD(processParameter.get投票日());
            shohonEntity.setKiteiNenreiTotatsuYMD(processParameter.get投票日().plusDay(1));
            shohonEntity.setShohonName(processParameter.get抄本名());
            shohonEntity.setNyujokenReportIndex(Decimal.ZERO);

        }
        return shohonEntity;
    }

}
