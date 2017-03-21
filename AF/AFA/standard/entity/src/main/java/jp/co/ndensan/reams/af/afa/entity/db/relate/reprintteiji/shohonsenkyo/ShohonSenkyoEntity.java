/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定時登録の抄本選挙情報RelateEntityクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
public class ShohonSenkyoEntity implements Cloneable, Serializable {

    private ShohonNo shohonNo;
    private Code senkyoShurui;
    private RString shohonName;
    private FlexibleDate tohyoYMD;
    private FlexibleDate kiteiNenreiTotatsuYMD;
    private FlexibleDate shoriYMD;
    private FlexibleDate kijunYMD;
    private FlexibleDate meiboTorokuYMD;
    private FlexibleDate tenshutsuKigenYMD;
    private FlexibleDate tennyuKigenYMD;
}
