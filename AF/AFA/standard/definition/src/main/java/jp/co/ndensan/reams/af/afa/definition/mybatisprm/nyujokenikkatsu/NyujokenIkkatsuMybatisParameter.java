/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 入場券発行
 *
 * @reamsid_L AF-0160-026 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NyujokenIkkatsuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private ShohonNo shohonNo;
    private FlexibleDate kijunYMD;
    private ShikibetsuCode 識別コード;
    private RString 選挙種類;
    private RString 出力順;
    private LasdecCode 地方公共団体コード;
    private int 連番;
    private FlexibleDate システム日付;
    private RString table;
    private RString table1;
    private RString groupKubun;
    private SetaiCode setaiCode;
    private IShikibetsuTaishoPSMSearchKey key;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタ作成します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param 選挙種類 RString
     * @param 出力順 RString
     * @param 地方公共団体コード LasdecCode
     * @param 連番 int
     * @param システム日付 FlexibleDate
     */
    public NyujokenIkkatsuMybatisParameter(IShikibetsuTaishoPSMSearchKey key, ShohonNo shohonNo, RString 選挙種類,
            RString 出力順, LasdecCode 地方公共団体コード, int 連番, FlexibleDate システム日付) {
        super(key);
        shikibetsutaishoParam =new UaFt200FindShikibetsuTaishoParam(key);
        this.shohonNo = shohonNo;
        this.選挙種類 = 選挙種類;
        this.出力順 = 出力順;
        this.地方公共団体コード = 地方公共団体コード;
        this.連番 = 連番;
        this.システム日付 = システム日付;
    }

    /**
     * コンストラクタ作成します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param table RString
     * @param groupKubun RString
     * @param setaiCode SetaiCode
     */
    public NyujokenIkkatsuMybatisParameter(IShikibetsuTaishoPSMSearchKey key, RString table,
            RString groupKubun,
            SetaiCode setaiCode) {
        super(key);
         shikibetsutaishoParam =new UaFt200FindShikibetsuTaishoParam(key);
        this.table = table;
        this.groupKubun = groupKubun;
        this.setaiCode = setaiCode;

    }
}
