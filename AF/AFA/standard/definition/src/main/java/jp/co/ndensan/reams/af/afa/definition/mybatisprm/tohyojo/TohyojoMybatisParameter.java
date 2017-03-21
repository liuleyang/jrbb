/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyojo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 投票所のパラメータクラスです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class TohyojoMybatisParameter implements IMyBatisParameter {

    private final Code senkyoShurui;
    private final RString tohyokuCode;

    /**
     * コンストラクタです。
     *
     * @param senkyoShurui Code
     * @param tohyokuCode RString
     */
    public TohyojoMybatisParameter(Code senkyoShurui, RString tohyokuCode) {
        this.senkyoShurui = senkyoShurui;
        this.tohyokuCode = tohyokuCode;
    }

}
