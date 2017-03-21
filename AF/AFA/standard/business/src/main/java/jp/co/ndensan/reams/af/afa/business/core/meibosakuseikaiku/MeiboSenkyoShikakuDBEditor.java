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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 選挙資格の編集する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboSenkyoShikakuDBEditor {

    private final AfT113SenkyoShikakuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public MeiboSenkyoShikakuDBEditor(AfT113SenkyoShikakuEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙資格データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboSakuseiKaikuInsertEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT113SenkyoShikakuEntity edit選挙資格データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, AFABTK101tempTblEntity meiboEntity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCode());
            entity.setSeq(new BigSerial(1));

            entity.setShikakuKubun(new Code("1"));
            entity.setTohyokuCode(meiboEntity.getSenkyoTohyokuCode());

            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTorokuJiyuCode(new Code(MeiboKaikuEdited.その他.getKey()));
            set登録の選挙資格(meiboEntity);
            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);

            entity.setKeikiShuryoYMD(meiboEntity.getSubKeikiShuryoYMD());

            entity.setNikeimochiFlag(meiboEntity.isSubNikeimochiFlag());

            entity.setDataTorokuYMD(FlexibleDate.getNowDate());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {

            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.setShikibetsuCode(meiboEntity.getShikibetsuCode());

            entity.setShikakuKubun(new Code("1"));

            entity.setTohyokuCode(meiboEntity.getSenkyoTohyokuCode());
            entity.setSeq(new BigSerial(Integer.valueOf(meiboEntity.getKakuSeq().toString()) + 1));

            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTorokuJiyuCode(new Code(MeiboKaikuEdited.その他.getKey()));
            set登録の選挙資格(meiboEntity);
            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);
            entity.setKeikiShuryoYMD(meiboEntity.getSubKeikiShuryoYMD());
            entity.setNikeimochiFlag(meiboEntity.isSubNikeimochiFlag());
            entity.setDataTorokuYMD(FlexibleDate.getNowDate());
        }

        return entity;
    }

    /**
     * 選挙資格データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK101SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboTempTableEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT113SenkyoShikakuEntity edit入力ファイルの選挙資格データ(ShohonNo 抄本番号, AFABTK101SelectProcessParameter processParameter,
            RString 処理種別, MeiboTempTableEntity meiboEntity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            ShikibetsuCode 識別コード = meiboEntity.getUaFt200Entity().getShikibetsuCode();
            entity.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            entity.setSeq(new BigSerial(1));
            entity.setShikakuKubun(new Code(new RString("1")));
            entity.setTohyokuCode(meiboEntity.get投票区コード());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTorokuJiyuCode(new Code(MeiboKaikuEdited.その他.getKey()));

            set登録の選挙資格_入力ファイル(meiboEntity);

            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);
            if (meiboEntity.getSubAfT113Entity() != null) {
                entity.setKeikiShuryoYMD(meiboEntity.getSubAfT113Entity().getKeikiShuryoYMD());
            } else {
                entity.setKeikiShuryoYMD(FlexibleDate.EMPTY);
            }
            if (meiboEntity.getAfT113Entity() != null) {
                entity.setNikeimochiFlag(meiboEntity.getSubAfT113Entity().getNikeimochiFlag());
            } else {
                entity.setNikeimochiFlag(false);
            }
            entity.setDataTorokuYMD(FlexibleDate.getNowDate());
        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {

            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            ShikibetsuCode 識別コード = meiboEntity.getUaFt200Entity().getShikibetsuCode();
            entity.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            entity.setSeq(new BigSerial(1));
            entity.setShikakuKubun(new Code(new RString("1")));
            entity.setTohyokuCode(meiboEntity.get投票区コード());
            entity.setMeiboTorokuYMD(processParameter.get名簿確定日());
            entity.setTorokuJiyuCode(new Code(MeiboKaikuEdited.その他.getKey()));

            set登録の選挙資格_入力ファイル(meiboEntity);

            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);
            if (meiboEntity.getSubAfT113Entity() != null) {
                entity.setKeikiShuryoYMD(meiboEntity.getSubAfT113Entity().getKeikiShuryoYMD());
            } else {
                entity.setKeikiShuryoYMD(FlexibleDate.EMPTY);
            }
            if (meiboEntity.getSubAfT113Entity() != null) {
                entity.setNikeimochiFlag(meiboEntity.getSubAfT113Entity().getNikeimochiFlag());
            } else {
                entity.setNikeimochiFlag(false);
            }
            entity.setDataTorokuYMD(FlexibleDate.getNowDate());
        }

        return entity;
    }

    private void set登録の選挙資格(AFABTK101tempTblEntity meiboEntity) {
        if (meiboEntity.getSubTorokuTeishiJiyuCode() != null
                && (MeiboKaikuEdited.公職選挙法第11条1項2号該当.getKey().equals(meiboEntity.getSubTorokuTeishiJiyuCode().value())
                || MeiboKaikuEdited.公職選挙法第11条1項3号該当.getKey().equals(meiboEntity.getSubTorokuTeishiJiyuCode().value())
                || MeiboKaikuEdited.公職選挙法第11条1項4号該当.getKey().equals(meiboEntity.getSubTorokuTeishiJiyuCode().value())
                || MeiboKaikuEdited.公職選挙法第11条1項5号該当.getKey().equals(meiboEntity.getSubTorokuTeishiJiyuCode().value())
                || MeiboKaikuEdited.公職選挙法第11条2項該当.getKey().equals(meiboEntity.getSubTorokuTeishiJiyuCode().value()))) {
            entity.setTorokuTeishiYMD(meiboEntity.getSubTorokuTeishiYMD());
            entity.setTorokuTeishiJiyuCode(meiboEntity.getSubTorokuTeishiJiyuCode());
            entity.setHyojiYMD(meiboEntity.getSubHyojiYMD());
            entity.setHyojiJiyuCode(meiboEntity.getSubHyojiJiyuCode());
        } else {
            entity.setTorokuTeishiYMD(FlexibleDate.EMPTY);
            entity.setTorokuTeishiJiyuCode(Code.EMPTY);
            entity.setHyojiYMD(FlexibleDate.EMPTY);
            entity.setHyojiJiyuCode(Code.EMPTY);
        }
    }

    private void set登録の選挙資格_入力ファイル(MeiboTempTableEntity meiboEntity) {
        if (meiboEntity.getSubAfT113Entity() != null
                && (MeiboKaikuEdited.公職選挙法第11条1項2号該当.getKey().equals(toRString(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode()))
                || MeiboKaikuEdited.公職選挙法第11条1項3号該当.getKey().equals(toRString(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode()))
                || MeiboKaikuEdited.公職選挙法第11条1項4号該当.getKey().equals(toRString(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode()))
                || MeiboKaikuEdited.公職選挙法第11条1項5号該当.getKey().equals(toRString(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode()))
                || MeiboKaikuEdited.公職選挙法第11条2項該当.getKey().equals(toRString(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode())))) {
            entity.setTorokuTeishiYMD(meiboEntity.getSubAfT113Entity().getTorokuTeishiYMD());
            entity.setTorokuTeishiJiyuCode(meiboEntity.getSubAfT113Entity().getTorokuTeishiJiyuCode());
            entity.setHyojiYMD(meiboEntity.getSubAfT113Entity().getHyojiYMD());
            entity.setHyojiJiyuCode(meiboEntity.getSubAfT113Entity().getHyojiJiyuCode());
        } else {
            entity.setTorokuTeishiYMD(FlexibleDate.EMPTY);
            entity.setTorokuTeishiJiyuCode(Code.EMPTY);
            entity.setHyojiYMD(FlexibleDate.EMPTY);
            entity.setHyojiJiyuCode(Code.EMPTY);
        }
    }

    /**
     * 選挙資格データの編集する。
     *
     * @param 抄本番号 ShohonNo
     * @param processParameter AFABTK103SelectProcessParameter
     * @param 処理種別 RString
     * @param meiboEntity MeiboTempTableEntity
     *
     * @return AfT100ShohonEntity
     */
    public AfT113SenkyoShikakuEntity edit登録の選挙資格データ(ShohonNo 抄本番号, AFABTK103SelectProcessParameter processParameter,
            RString 処理種別, SenkyojiKaikuEntity meiboEntity) {

        if (MeiboKaikuEdited.新規処理.getKey().equals(処理種別)) {
            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            ShikibetsuCode 識別コード = meiboEntity.getSenkyoShikakuEntity().getShikibetsuCode();
            entity.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            entity.setSeq(new BigSerial(1));
            entity.setShikakuKubun(meiboEntity.getSenkyoShikakuEntity().getShikakuKubun());
            entity.setTohyokuCode(meiboEntity.getSenkyoShikakuEntity().getTohyokuCode());
            entity.setMeiboTorokuYMD(processParameter.get基準日());
            entity.setTorokuJiyuCode(meiboEntity.getSenkyoShikakuEntity().getTorokuJiyuCode());

            entity.setTorokuTeishiYMD(FlexibleDate.EMPTY);
            entity.setTorokuTeishiJiyuCode(Code.EMPTY);
            entity.setHyojiYMD(FlexibleDate.EMPTY);
            entity.setHyojiJiyuCode(Code.EMPTY);
            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);
            entity.setKeikiShuryoYMD(FlexibleDate.EMPTY);
            entity.setNikeimochiFlag(false);
            entity.setDataTorokuYMD(FlexibleDate.getNowDate());

        } else if (MeiboKaikuEdited.再処理.getKey().equals(処理種別)) {

            entity.setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.setShikibetsuCode(meiboEntity.getSenkyoShikakuEntity().getShikibetsuCode());

            entity.setShikakuKubun(meiboEntity.getSenkyoShikakuEntity().getShikakuKubun());
            entity.setTohyokuCode(meiboEntity.getSenkyoShikakuEntity().getTohyokuCode());
            entity.setSeq(new BigSerial(1));

            entity.setMeiboTorokuYMD(processParameter.get基準日());
            entity.setTorokuJiyuCode(meiboEntity.getSenkyoShikakuEntity().getTorokuJiyuCode());

            entity.setTorokuTeishiYMD(FlexibleDate.EMPTY);
            entity.setTorokuTeishiJiyuCode(Code.EMPTY);
            entity.setHyojiYMD(FlexibleDate.EMPTY);
            entity.setHyojiJiyuCode(Code.EMPTY);
            entity.setHyojiShojoYMD(FlexibleDate.EMPTY);
            entity.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
            entity.setMasshoYMD(FlexibleDate.EMPTY);
            entity.setMasshoJiyuCode(Code.EMPTY);
            entity.setKeikiShuryoYMD(FlexibleDate.EMPTY);
            entity.setNikeimochiFlag(false);
            entity.setDataTorokuYMD(FlexibleDate.getNowDate());
        }

        return entity;
    }

    private RString toRString(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

}
