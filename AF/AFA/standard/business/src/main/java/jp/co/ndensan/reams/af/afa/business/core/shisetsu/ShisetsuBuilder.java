/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shisetsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Shisetsu}の編集を行うビルダークラスです。
 */
public class ShisetsuBuilder {

    private final AfT507ShisetsuEntity entity;
    private final ShisetsuIdentifier id;

    /**
     * {@link AfT507ShisetsuEntity}より{@link Shisetsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT507ShisetsuEntity}
     * @param id {@link ShisetsuIdentifier}
     *
     */
    ShisetsuBuilder(
            AfT507ShisetsuEntity entity,
            ShisetsuIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set施設コード(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * 施設種別を設定します。
     *
     * @param 施設種別 施設種別
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set施設種別(Code 施設種別) {
        requireNonNull(施設種別, UrSystemErrorMessages.値がnull.getReplacedMessage("施設種別"));
        entity.setShisetsuShubetsu(施設種別);
        return this;
    }

    /**
     * 施設名称を設定します。
     *
     * @param 施設名称 施設名称
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set施設名称(RString 施設名称) {
        requireNonNull(施設名称, UrSystemErrorMessages.値がnull.getReplacedMessage("施設名称"));
        entity.setShisetsuName(施設名称);
        return this;
    }

    /**
     * カナ施設名称を設定します。
     *
     * @param カナ施設名称 カナ施設名称
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder setカナ施設名称(RString カナ施設名称) {
        requireNonNull(カナ施設名称, UrSystemErrorMessages.値がnull.getReplacedMessage("カナ施設名称"));
        entity.setKanaShisetsuName(カナ施設名称);
        return this;
    }

    /**
     * 検索用カナ施設名称を設定します。
     *
     * @param 検索用カナ施設名称 検索用カナ施設名称
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set検索用カナ施設名称(RString 検索用カナ施設名称) {
        requireNonNull(検索用カナ施設名称, UrSystemErrorMessages.値がnull.getReplacedMessage("検索用カナ施設名称"));
        entity.setSearchKanaShisetsuName(検索用カナ施設名称);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 施設宛名を設定します。
     *
     * @param 施設宛名 施設宛名
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set施設宛名(AtenaMeisho 施設宛名) {
        requireNonNull(施設宛名, UrSystemErrorMessages.値がnull.getReplacedMessage("施設宛名"));
        entity.setShisetsuAtena(施設宛名);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param faxNo faxNo
     * @return {@link ShisetsuBuilder}
     */
    public ShisetsuBuilder setFaxNo(TelNo faxNo) {
        requireNonNull(faxNo, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(faxNo);
        return this;
    }

    /**
     * {@link Shisetsu}のインスタンスを生成します。
     *
     * @return {@link Shisetsu}のインスタンス
     */
    public Shisetsu build() {
        return new Shisetsu(entity, id);
    }
}
