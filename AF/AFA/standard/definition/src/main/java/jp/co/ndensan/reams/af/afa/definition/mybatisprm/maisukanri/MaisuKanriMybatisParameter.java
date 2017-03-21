/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.maisukanri;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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
public class MaisuKanriMybatisParameter implements IMyBatisParameter {

    private RString shohonNo;
    private SenkyoShurui senkyoShurui;

    /**
     * コンストラクタ作成します。
     *
     * @param shohonNo RString
     * @param senkyoShurui SenkyoShurui
     */
    public MaisuKanriMybatisParameter(RString shohonNo, SenkyoShurui senkyoShurui) {
        this.shohonNo = shohonNo;
        this.senkyoShurui = senkyoShurui;
    }

}
