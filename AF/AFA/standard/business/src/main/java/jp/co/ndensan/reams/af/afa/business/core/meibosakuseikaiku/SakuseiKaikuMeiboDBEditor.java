/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 選挙人名簿の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class SakuseiKaikuMeiboDBEditor {

    private final AfT112SenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public SakuseiKaikuMeiboDBEditor(AfT112SenkyoninMeiboEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙人名簿データの編集仕様
     *
     * @param meiboSakuseiKaikuEntity MeiboSakuseiKaikuEntity
     * @param 抄本番号 ShohonNo
     * @param renban int
     * @return AfT100ShohonEntity
     */
    public AfT112SenkyoninMeiboEntity edit選挙人名簿データの編集(MeiboSakuseiKaikuEntity meiboSakuseiKaikuEntity, ShohonNo 抄本番号, int renban) {
        RString ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);

        if (meiboSakuseiKaikuEntity.getAfT112SenkyoninMeibEntity() != null && meiboSakuseiKaikuEntity.getAfT100Entity() != null
                && meiboSakuseiKaikuEntity.getUaFt200Entity() != null) {
            entity.setShohonNo(抄本番号);
            entity.setGroupCode(meiboSakuseiKaikuEntity.getAfT112SenkyoninMeibEntity().getGroupCode());

            entity.setSatsu(meiboSakuseiKaikuEntity.getAfT112SenkyoninMeibEntity().getTohyokuCode());
            entity.setPage(meiboSakuseiKaikuEntity.getAfT112SenkyoninMeibEntity().getPage());
            entity.setGyo(Integer.parseInt(ページ行数.toString()));
            entity.setSeq(new BigSerial(1));

            TohyokuCode 投票区コード = meiboSakuseiKaikuEntity.getUaFt200Entity().getTohyokuCode();
            ShikibetsuCode 識別コード = meiboSakuseiKaikuEntity.getUaFt200Entity().getShikibetsuCode();
            entity.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            entity.setTohyokuCode(投票区コード != null ? 投票区コード.value() : RString.EMPTY);

            entity.setTohyokuHenkoMasshoFlag(false);
            entity.setRenban(renban);
            entity.setEdaban(0);
        }

        return entity;
    }

    /**
     * 選挙人名簿データの編集仕様
     *
     * @param meiboTempTableEntity MeiboTempTableEntity
     * @param 抄本番号 ShohonNo
     * @param page int
     * @param 連番 int
     * @return AfT100ShohonEntity
     */
    public AfT112SenkyoninMeiboEntity edit入力ファイルの選挙人名簿(MeiboTempTableEntity meiboTempTableEntity, ShohonNo 抄本番号,
            int page, int 連番) {
        RString ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);
        entity.setShohonNo(抄本番号);
        entity.setGroupCode(new RString("0"));

        entity.setSatsu(new RString("00"));

        entity.setPage(page);

        entity.setGyo(Integer.valueOf(ページ行数.toString()));
        entity.setSeq(new BigSerial(1));
        entity.setShikibetsuCode(meiboTempTableEntity.get識別コード());
        entity.setTohyokuCode(meiboTempTableEntity.get投票区コード());

        entity.setTohyokuHenkoMasshoFlag(false);
        entity.setRenban(連番);
        entity.setEdaban(0);

        return entity;
    }

    /**
     * 選挙人名簿データの編集仕様
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     * @param 頁 int
     *
     * @return AfT100ShohonEntity
     */
    public AfT112SenkyoninMeiboEntity insert選挙人名簿(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, AFABTK101tempTblEntity meiboEntity, int 頁) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            RString ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);

            entity.setShohonNo(抄本番号);
            entity.setGroupCode(meiboEntity.getGroupCode());

            entity.setSatsu(meiboEntity.getSatsu());
            int page = meiboEntity.getPage();
            if (頁 != 1) {
                entity.setPage(page + 頁);
            } else {
                entity.setPage(1);
            }

            entity.setGyo(Integer.valueOf(ページ行数.toString()));
            entity.setSeq(new BigSerial(1));
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCode());

            entity.setTohyokuCode(meiboEntity.getTohyokuCodeAdd());

            entity.setTohyokuHenkoMasshoFlag(false);
            entity.setRenban(0);
            entity.setEdaban(0);

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {

            entity.setShohonNo(抄本番号);
            entity.setGroupCode(meiboEntity.getGroupCode());

            entity.setSatsu(meiboEntity.getSatsu());

            entity.setPage(meiboEntity.getPage());

            entity.setGyo(meiboEntity.getGyo());
            entity.setSeq(new BigSerial(Decimal.valueOf(meiboEntity.getSeq().getValue()).add(1).longValue()));
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCode());

            entity.setTohyokuCode(meiboEntity.getTohyokuCodeAdd());

            entity.setTohyokuHenkoMasshoFlag(false);
            entity.setRenban(0);
            entity.setEdaban(0);
        }

        return entity;
    }

    /**
     * 選挙人名簿データの編集仕様
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK103SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     * @param 頁 int
     *
     * @return AfT100ShohonEntity
     */
    public AfT112SenkyoninMeiboEntity edit登録の選挙人名簿(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity meiboEntity, int 頁) {
        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            RString ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);

            entity.setShohonNo(抄本番号);
            entity.setGroupCode(meiboEntity.getSenkyoninMeiboEntity().getGroupCode());

            entity.setSatsu(meiboEntity.getSenkyoninMeiboEntity().getSatsu());
            int page = meiboEntity.getSenkyoninMeiboEntity().getPage();
            if (頁 != 1) {
                entity.setPage(page + 頁);
            } else {
                entity.setPage(1);
            }

            entity.setGyo(Integer.valueOf(ページ行数.toString()));
            entity.setSeq(new BigSerial(1));
            entity.setShikibetsuCode(meiboEntity.getSenkyoninMeiboEntity().getShikibetsuCode());

            entity.setTohyokuCode(meiboEntity.getSenkyoninMeiboEntity().getTohyokuCode());

            entity.setTohyokuHenkoMasshoFlag(false);
            entity.setRenban(0);
            entity.setEdaban(0);

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {

            entity.setShohonNo(抄本番号);
            entity.setGroupCode(meiboEntity.getSenkyoninMeiboEntity().getGroupCode());

            entity.setSatsu(meiboEntity.getSenkyoninMeiboEntity().getSatsu());

            entity.setPage(meiboEntity.getSenkyoninMeiboEntity().getPage());

            entity.setGyo(meiboEntity.getSenkyoninMeiboEntity().getGyo());
            entity.setSeq(new BigSerial(1));
            entity.setShikibetsuCode(meiboEntity.getSenkyoninMeiboEntity().getShikibetsuCode());

            entity.setTohyokuCode(meiboEntity.getSenkyoninMeiboEntity().getTohyokuCode());

            entity.setTohyokuHenkoMasshoFlag(false);
            entity.setRenban(0);
            entity.setEdaban(0);
        }

        return entity;
    }

}
