/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushaselect;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 請求代表者選択の画面表示用データクラスです。
 *
 * @reamsid_L AF-0140-020 wangh
 */
public class SeikyushaSelectGamenData implements Serializable {

    private final AfT401ChokusetsuSeikyuEntity entity;

    /**
     * コンストラクタです。
     */
    public SeikyushaSelectGamenData() {
        entity = new AfT401ChokusetsuSeikyuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DBより取得した{@link AfT401ChokusetsuSeikyuEntity}
     */
    public SeikyushaSelectGamenData(AfT401ChokusetsuSeikyuEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 直接請求を返します。
     *
     * @return 直接請求 AfT401ChokusetsuSeikyuEntity
     */
    public AfT401ChokusetsuSeikyuEntity getEntity() {
        return this.entity;
    }

    /**
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return entity.getSeikyuNo();
    }

    /**
     * 直接請求番号のsetメソッドです。
     *
     * @param seikyuNo 直接請求番号
     */
    public void setSeikyuNo(int seikyuNo) {
        this.entity.setSeikyuNo(seikyuNo);
    }

    /**
     * 請求年月日のgetメソッドです。
     *
     * @return 請求年月日
     */
    public FlexibleDate getSeikyuYMD() {
        return entity.getSeikyuYMD();
    }

    /**
     * 請求年月日のsetメソッドです。
     *
     * @param seikyuYMD 請求年月日
     */
    public void setSeikyuYMD(FlexibleDate seikyuYMD) {
        this.entity.setSeikyuYMD(seikyuYMD);
    }

    /**
     * 請求名のgetメソッドです。
     *
     * @return 請求名
     */
    public RString getSeikyuMei() {
        return entity.getSeikyuMei();
    }

    /**
     * 請求名のsetメソッドです。
     *
     * @param seikyuMei 請求名
     */
    public void setSeikyuMei(RString seikyuMei) {
        this.entity.setSeikyuMei(seikyuMei);
    }

    /**
     * 請求内容のgetメソッドです。
     *
     * @return 請求内容
     */
    public RString getSeikyuNaiyo() {
        return entity.getSeikyuNaiyo();
    }

    /**
     * 請求内容のsetメソッドです。
     *
     * @param seikyuNaiyo 請求内容
     */
    public void setSeikyuNaiyo(RString seikyuNaiyo) {
        this.entity.setSeikyuNaiyo(seikyuNaiyo);
    }

    /**
     * 交付年月日のgetメソッドです。
     *
     * @return 交付年月日
     */
    public FlexibleDate getKofuYMD() {
        return entity.getKofuYMD();
    }

    /**
     * 交付年月日のsetメソッドです。
     *
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.entity.setKofuYMD(kofuYMD);
    }

    /**
     * 提出期限年月日のgetメソッドです。
     *
     * @return 提出期限年月日
     */
    public FlexibleDate getTeishutsuKigenYMD() {
        return entity.getTeishutsuKigenYMD();
    }

    /**
     * 提出期限年月日のsetメソッドです。
     *
     * @param teishutsuKigenYMD 提出期限年月日
     */
    public void setTeishutsuKigenYMD(FlexibleDate teishutsuKigenYMD) {
        this.entity.setTeishutsuKigenYMD(teishutsuKigenYMD);
    }

    /**
     * 交付組織コードのgetメソッドです。
     *
     * @return 交付組織コード
     */
    public Code getKofuSoshikiCode() {
        return entity.getKofuSoshikiCode();
    }

    /**
     * 交付組織コードのsetメソッドです。
     *
     * @param kofuSoshikiCode 交付組織コード
     */
    public void setKofuSoshikiCode(Code kofuSoshikiCode) {
        this.entity.setKofuSoshikiCode(kofuSoshikiCode);
    }

    /**
     * 交付組織コードの名称のgetメソッドです。
     *
     * @return 交付組織コードの名称
     */
    public RString getKofuSoshikiCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                entity.getKofuSoshikiCode());
    }

    /**
     * 交付組織コードの略称のgetメソッドです。
     *
     * @return 交付組織コードの略称
     */
    public RString getKofuSoshikiCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                entity.getKofuSoshikiCode());
    }

    /**
     * 交付組織コードのDescriptionのgetメソッドです。
     *
     * @return 交付組織コードのDescription
     */
    public RString getKofuSoshikiCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                entity.getKofuSoshikiCode());
    }

    /**
     * 署名簿登録済フラグのgetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @return 署名簿登録済フラグ
     */
    public boolean isTorokuZumiFlag() {
        return entity.getTorokuZumiFlag();
    }

    /**
     * 署名簿登録済フラグのsetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @param torokuZumiFlag 署名簿登録済フラグ
     */
    public void setTorokuZumiFlag(boolean torokuZumiFlag) {
        this.entity.setTorokuZumiFlag(torokuZumiFlag);
    }

    /**
     * 抄本番号のgetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return entity.getShohonNo();
    }

    /**
     * 抄本番号のsetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.entity.setShohonNo(shohonNo);
    }

}
