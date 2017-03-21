/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 選挙の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboSenkyoDBEditor {

    private final AfT111SenkyoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public MeiboSenkyoDBEditor(AfT111SenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT111SenkyoEntity edit選挙データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, AFABTK101tempTblEntity meiboEntity) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(new SenkyoNo(OutputKeys.選挙番号.getValue()));
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoName(processParameter.get抄本名());
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(processParameter.get基準日().plusDay(1));
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(FlexibleDate.EMPTY);
            entity.setMutohyoSenkyoFlag(false);
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(meiboEntity.getSenkyoNo());
            entity.setSenkyoName(meiboEntity.getShohonName());
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(processParameter.get基準日().plusDay(1));
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(FlexibleDate.EMPTY);
            entity.setMutohyoSenkyoFlag(false);
        }
        return entity;
    }

    /**
     * 選挙データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboentity MeiboTempTableEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT111SenkyoEntity edit入力ファイルの選挙データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, MeiboTempTableEntity meiboentity) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(new SenkyoNo(new RString("1")));
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoName(processParameter.get抄本名());
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(processParameter.get基準日().plusDay(1));
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(FlexibleDate.EMPTY);
            entity.setMutohyoSenkyoFlag(false);
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(meiboentity.getAfT111SenkyoEntity().getSenkyoNo());
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoName(processParameter.get抄本名());
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(processParameter.get基準日().plusDay(1));
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(FlexibleDate.EMPTY);
            entity.setMutohyoSenkyoFlag(false);
        }
        return entity;
    }

    /**
     * 選挙データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK103SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT111SenkyoEntity edit登録の選挙データ(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity meiboEntity) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(new SenkyoNo(OutputKeys.選挙番号.getValue()));
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoName(processParameter.get抄本名());
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(FlexibleDate.EMPTY);
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get基準日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(processParameter.get受付開始日());
            entity.setMutohyoSenkyoFlag(false);
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {
            entity.setShohonNo(抄本番号);
            entity.setSenkyoNo(new SenkyoNo(OutputKeys.選挙番号.getValue()));
            entity.setSenkyoName(processParameter.get選挙名());
            entity.setSenkyoLevel(new Code(OutputKeys.選挙レベル.getValue()));
            entity.setSenkyoRyakusho(OutputKeys.海区.getValue());
            entity.setSenkyoMark(OutputKeys.海区.getValue());
            entity.setKokujiYMD(FlexibleDate.EMPTY);
            entity.setKijunYMD(processParameter.get基準日());
            entity.setMeiboTorokuYMD(processParameter.get基準日());
            entity.setTenshutsuKigenYMD(FlexibleDate.EMPTY);
            entity.setTennyuKigenYMD(FlexibleDate.EMPTY);
            entity.setTohyoUketsukeYMD(processParameter.get受付開始日());
            entity.setMutohyoSenkyoFlag(false);
        }
        return entity;
    }

}
