/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu;

import java.io.Serializable;
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
public class NyujokenIkkatsuMybatisTokyo implements Serializable {

    private RString tohyokuCode;
    private RString tohyokuName;

}
