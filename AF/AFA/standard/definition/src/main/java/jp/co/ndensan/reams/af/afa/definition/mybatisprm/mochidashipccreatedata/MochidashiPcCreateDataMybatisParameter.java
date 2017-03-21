/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.cautionsha.UaFt400FindeCautionShaMapperParam;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 持出端末用データ作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class MochidashiPcCreateDataMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleDate 投票日;
    private RString 地方公共団体コード;
    private ShohonNo 抄本番号;
    private Integer 地方公共団体コード連番;
    private RString riyoKubun;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyUaFt400 UaFt400FindeCautionShaMapperParam
     * @param 投票日 FlexibleDate
     *
     */
    public MochidashiPcCreateDataMybatisParameter(
            IShikibetsuTaishoPSMSearchKey key,
            UaFt400FindeCautionShaMapperParam keyUaFt400,
            FlexibleDate 投票日) {
        super(key);
        this.投票日 = 投票日;
        if (null != keyUaFt400) {
            this.riyoKubun = keyUaFt400.getRiyoKubun();
            this.chushutsuKubun = keyUaFt400.getChushutsuKubun();
            this.zenkaiChushutsu = keyUaFt400.getZenkaiChushutsu();
            this.konkaiChushutsu = keyUaFt400.getKonkaiChushutsu();
            this.chuiShuruiCode = keyUaFt400.getChuiShuruiCode();
            this.yukoKigenKubun = keyUaFt400.getYukoKigenKubun();
        }
    }

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return 抄本番号;
    }

    /**
     * 抄本番号のsetメソッドです。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 地方公共団体コードのgetメソッドです。
     *
     * @return 地方公共団体コード
     */
    public RString get地方公共団体コード() {
        return 地方公共団体コード;
    }

    /**
     * 地方公共団体コードのsetメソッドです。
     *
     * @param 地方公共団体コード 地方公共団体コード
     */
    public void set地方公共団体コード(RString 地方公共団体コード) {
        this.地方公共団体コード = 地方公共団体コード;
    }

    /**
     * 地方公共団体コード連番のgetメソッドです。
     *
     * @return 地方公共団体コード連番
     */
    public Integer get地方公共団体コード連番() {
        return 地方公共団体コード連番;
    }

    /**
     * 地方公共団体コード連番のsetメソッドです。
     *
     * @param 地方公共団体コード連番 地方公共団体コード連番
     */
    public void set地方公共団体コード連番(Integer 地方公共団体コード連番) {
        this.地方公共団体コード連番 = 地方公共団体コード連番;
    }
}
