/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名識別対象の一時テーブル検索用entityクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTA101tempTblForSelectEntity {

    private RString groupCode;
    private RString tohyokuCodeAdd;
    private RString satsu;
    private int page;
    private int gyo;
    private int renban;
    private SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity;

}
