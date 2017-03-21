/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FuzaishaTohyoShikakuYubin}の編集を行うビルダークラスです。
 */
public class FuzaishaTohyoShikakuYubinBuilder {

    private final AfT115FuzaishaTohyoShikakuYubinEntity entity;
    private final FuzaishaTohyoShikakuYubinIdentifier id;

    /**
     * {@link AfT115FuzaishaTohyoShikakuYubinEntity}より{@link FuzaishaTohyoShikakuYubin}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT115FuzaishaTohyoShikakuYubinEntity}
     * @param id {@link FuzaishaTohyoShikakuYubinIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    FuzaishaTohyoShikakuYubinBuilder(
            AfT115FuzaishaTohyoShikakuYubinEntity entity,
            FuzaishaTohyoShikakuYubinIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set履歴番号(BigSerial 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setSeq(履歴番号);
        return this;
    }

    /**
     * 身体障害者手帳有フラグを設定します。
     *
     * @param 身体障害者手帳有フラグ 身体障害者手帳有フラグ
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set身体障害者手帳有フラグ(boolean 身体障害者手帳有フラグ) {
        requireNonNull(身体障害者手帳有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("身体障害者手帳有フラグ"));
        entity.setShogaiTechoAriFlag(身体障害者手帳有フラグ);
        return this;
    }

    /**
     * 戦傷病者手帳有フラグを設定します。
     *
     * @param 戦傷病者手帳有フラグ 戦傷病者手帳有フラグ
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set戦傷病者手帳有フラグ(boolean 戦傷病者手帳有フラグ) {
        requireNonNull(戦傷病者手帳有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("戦傷病者手帳有フラグ"));
        entity.setSenshoTechoAriFlag(戦傷病者手帳有フラグ);
        return this;
    }

    /**
     * 介護保険被保険者証有フラグを設定します。
     *
     * @param 介護保険被保険者証有フラグ 介護保険被保険者証有フラグ
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set介護保険被保険者証有フラグ(boolean 介護保険被保険者証有フラグ) {
        requireNonNull(介護保険被保険者証有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険被保険者証有フラグ"));
        entity.setKaigoHokenshoAriFlag(介護保険被保険者証有フラグ);
        return this;
    }

    /**
     * 代理記載者入力区分を設定します。
     *
     * @param 代理記載者入力区分 代理記載者入力区分
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者入力区分(Code 代理記載者入力区分) {
        requireNonNull(代理記載者入力区分, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者入力区分"));
        entity.setDairiInputKubun(代理記載者入力区分);
        return this;
    }

    /**
     * 代理記載者識別コードを設定します。
     *
     * @param 代理記載者識別コード 代理記載者識別コード
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者識別コード(ShikibetsuCode 代理記載者識別コード) {
        requireNonNull(代理記載者識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者識別コード"));
        entity.setDairiShikibetsuCode(代理記載者識別コード);
        return this;
    }

    /**
     * 代理記載者漢字氏名を設定します。
     *
     * @param 代理記載者漢字氏名 代理記載者漢字氏名
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者漢字氏名(AtenaMeisho 代理記載者漢字氏名) {
        requireNonNull(代理記載者漢字氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者漢字氏名"));
        entity.setDairiKanjiShimei(代理記載者漢字氏名);
        return this;
    }

    /**
     * 代理記載者カナ氏名を設定します。
     *
     * @param 代理記載者カナ氏名 代理記載者カナ氏名
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者カナ氏名(AtenaKanaMeisho 代理記載者カナ氏名) {
        requireNonNull(代理記載者カナ氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者カナ氏名"));
        entity.setDairiKanaShimei(代理記載者カナ氏名);
        return this;
    }

    /**
     * 代理記載者生年月日を設定します。
     *
     * @param 代理記載者生年月日 代理記載者生年月日
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者生年月日(FlexibleDate 代理記載者生年月日) {
        requireNonNull(代理記載者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者生年月日"));
        entity.setDairiSeinengappiYMD(代理記載者生年月日);
        return this;
    }

    /**
     * 代理記載者性別コードを設定します。
     *
     * @param 代理記載者性別コード 代理記載者性別コード
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者性別コード(RString 代理記載者性別コード) {
        requireNonNull(代理記載者性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者性別コード"));
        entity.setDairiSeibetsuCode(代理記載者性別コード);
        return this;
    }

    /**
     * 代理記載者郵便番号を設定します。
     *
     * @param 代理記載者郵便番号 代理記載者郵便番号
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者郵便番号(YubinNo 代理記載者郵便番号) {
        requireNonNull(代理記載者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者郵便番号"));
        entity.setDairiYubinNo(代理記載者郵便番号);
        return this;
    }

    /**
     * 代理記載者住所を設定します。
     *
     * @param 代理記載者住所 代理記載者住所
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     */
    public FuzaishaTohyoShikakuYubinBuilder set代理記載者住所(AtenaJusho 代理記載者住所) {
        requireNonNull(代理記載者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("代理記載者住所"));
        entity.setDairiJusho(代理記載者住所);
        return this;
    }

    /**
     * {@link FuzaishaTohyoShikakuYubin}のインスタンスを生成します。
     *
     * @return {@link FuzaishaTohyoShikakuYubin}のインスタンス
     */
    public FuzaishaTohyoShikakuYubin build() {
        return new FuzaishaTohyoShikakuYubin(entity, id);
    }
}
