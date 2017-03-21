/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushatoroku;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 請求代表者証明書交付の画面表示用データクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaTorokuGamenData implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;
    private final AfT401ChokusetsuSeikyuEntity aft401Entity;
    private List<SeikyuDaihyoshaGamenData> seikyushaList;
    private List<AfT402SeikyuDaihyoshaEntity> aft402EntityList;

    /**
     * コンストラクタです。
     */
    public SeikyushaTorokuGamenData() {
        aft401Entity = new AfT401ChokusetsuSeikyuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param aft401Entity DBより取得した{@link AfT401ChokusetsuSeikyuEntity}
     */
    public SeikyushaTorokuGamenData(AfT401ChokusetsuSeikyuEntity aft401Entity) {
        this.aft401Entity = requireNonNull(aft401Entity);
    }

    /**
     * 直接請求を返します。
     *
     * @return 直接請求 AfT401ChokusetsuSeikyuEntity
     */
    public AfT401ChokusetsuSeikyuEntity getAft401Entity() {
        return this.aft401Entity;
    }

    /**
     * 識別コードリストのgetメソッドです。
     *
     * @return 識別コードリスト
     */
    public List<SeikyuDaihyoshaGamenData> getSeikyushaList() {
        return seikyushaList;
    }

    /**
     * 識別コードリストのsetメソッドです。
     *
     * @param seikyushaList List<SeikyuDaihyoshaGamenData>
     */
    public void setSeikyushaList(List<SeikyuDaihyoshaGamenData> seikyushaList) {
        this.seikyushaList = seikyushaList;
    }

    /**
     * 直接請求代表者リストのgetメソッドです。
     *
     * @return 直接請求代表者リスト
     */
    public List<AfT402SeikyuDaihyoshaEntity> getAfT402EntityList() {
        return aft402EntityList;
    }

    /**
     * 直接請求代表者リストのsetメソッドです。
     *
     * @param aft402EntityList List<AfT402SeikyuDaihyoshaEntity>
     */
    public void setAfT402EntityList(List<AfT402SeikyuDaihyoshaEntity> aft402EntityList) {
        this.aft402EntityList = aft402EntityList;
    }

    /**
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return aft401Entity.getSeikyuNo();
    }

    /**
     * 直接請求番号のsetメソッドです。
     *
     * @param seikyuNo 直接請求番号
     */
    public void setSeikyuNo(int seikyuNo) {
        this.aft401Entity.setSeikyuNo(seikyuNo);
    }

    /**
     * 請求年月日のgetメソッドです。
     *
     * @return 請求年月日
     */
    public FlexibleDate getSeikyuYMD() {
        return aft401Entity.getSeikyuYMD();
    }

    /**
     * 請求年月日のsetメソッドです。
     *
     * @param seikyuYMD 請求年月日
     */
    public void setSeikyuYMD(FlexibleDate seikyuYMD) {
        this.aft401Entity.setSeikyuYMD(seikyuYMD);
    }

    /**
     * 請求名のgetメソッドです。
     *
     * @return 請求名
     */
    public RString getSeikyuMei() {
        return aft401Entity.getSeikyuMei();
    }

    /**
     * 請求名のsetメソッドです。
     *
     * @param seikyuMei 請求名
     */
    public void setSeikyuMei(RString seikyuMei) {
        this.aft401Entity.setSeikyuMei(seikyuMei);
    }

    /**
     * 請求内容のgetメソッドです。
     *
     * @return 請求内容
     */
    public RString getSeikyuNaiyo() {
        return aft401Entity.getSeikyuNaiyo();
    }

    /**
     * 請求内容のsetメソッドです。
     *
     * @param seikyuNaiyo 請求内容
     */
    public void setSeikyuNaiyo(RString seikyuNaiyo) {
        this.aft401Entity.setSeikyuNaiyo(seikyuNaiyo);
    }

    /**
     * 交付年月日のgetメソッドです。
     *
     * @return 交付年月日
     */
    public FlexibleDate getKofuYMD() {
        return aft401Entity.getKofuYMD();
    }

    /**
     * 交付年月日のsetメソッドです。
     *
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.aft401Entity.setKofuYMD(kofuYMD);
    }

    /**
     * 提出期限年月日のgetメソッドです。
     *
     * @return 提出期限年月日
     */
    public FlexibleDate getTeishutsuKigenYMD() {
        return aft401Entity.getTeishutsuKigenYMD();
    }

    /**
     * 提出期限年月日のsetメソッドです。
     *
     * @param teishutsuKigenYMD 提出期限年月日
     */
    public void setTeishutsuKigenYMD(FlexibleDate teishutsuKigenYMD) {
        this.aft401Entity.setTeishutsuKigenYMD(teishutsuKigenYMD);
    }

    /**
     * 交付組織コードのgetメソッドです。
     *
     * @return 交付組織コード
     */
    public Code getKofuSoshikiCode() {
        return aft401Entity.getKofuSoshikiCode();
    }

    /**
     * 交付組織コードのsetメソッドです。
     *
     * @param kofuSoshikiCode 交付組織コード
     */
    public void setKofuSoshikiCode(Code kofuSoshikiCode) {
        this.aft401Entity.setKofuSoshikiCode(kofuSoshikiCode);
    }

    /**
     * 交付組織コードの名称のgetメソッドです。
     *
     * @return 交付組織コードの名称
     */
    public RString getKofuSoshikiCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                aft401Entity.getKofuSoshikiCode());
    }

    /**
     * 交付組織コードの略称のgetメソッドです。
     *
     * @return 交付組織コードの略称
     */
    public RString getKofuSoshikiCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                aft401Entity.getKofuSoshikiCode());
    }

    /**
     * 交付組織コードのDescriptionのgetメソッドです。
     *
     * @return 交付組織コードのDescription
     */
    public RString getKofuSoshikiCodeDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体,
                AFACodeShubetsu.交付組織コード.getCodeShubetsu(),
                aft401Entity.getKofuSoshikiCode());
    }

    /**
     * 署名簿登録済フラグのgetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @return 署名簿登録済フラグ
     */
    public boolean isTorokuZumiFlag() {
        return aft401Entity.getTorokuZumiFlag();
    }

    /**
     * 署名簿登録済フラグのsetメソッドです。
     * <br/>
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     *
     * @param torokuZumiFlag 署名簿登録済フラグ
     */
    public void setTorokuZumiFlag(boolean torokuZumiFlag) {
        this.aft401Entity.setTorokuZumiFlag(torokuZumiFlag);
    }

    /**
     * 抄本番号のgetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return aft401Entity.getShohonNo();
    }

    /**
     * 抄本番号のsetメソッドです。
     * <br/>
     * <br/>チェックの基準とする抄本番号を設定する
     *
     * @param shohonNo 抄本番号
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.aft401Entity.setShohonNo(shohonNo);
    }

    /**
     * DB状態メソッドです。
     *
     * @param state EntityDataState
     */
    public void setState(EntityDataState state) {
        this.aft401Entity.setState(state);
    }
}
