/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 期日前投票情報の集計entityクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KijitsumaeTohyoShukeiEntity {

    private RString shisetsuCode;
    private RString shisetsuMeisho;
    private int honjitsuTohyoSuMale;
    private int honjitsuTohyoSuFemale;
    private int izenTohyoSuMale;
    private int izenTohyoSuFemale;

    /**
     * コンストラクタです。
     */
    public KijitsumaeTohyoShukeiEntity() {
    }

}
