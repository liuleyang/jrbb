/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;

/**
 * 在外選挙異動累積情報RelateEntityクラスです。
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
@lombok.Getter
@lombok.Setter
public class ZaigaiSenkyoIdouRuisekiEntity implements Cloneable, Serializable {

    private ZenkokuJushoCode 本籍全国住所コード;
    private AtenaJusho 本籍住所;
    private AtenaBanchi 本籍番地;
    private AtenaJusho 最終住所;
    private AtenaBanchi 最終番地;
    private Katagaki 最終方書;
    private AtenaJusho 現住所;
    private AtenaJusho 送付先;
    private AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報;
}
