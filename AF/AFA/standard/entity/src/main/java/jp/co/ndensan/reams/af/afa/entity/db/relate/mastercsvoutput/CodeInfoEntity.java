/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0006CodeShubetsuEntity;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * コード情報Entity
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
public class CodeInfoEntity implements IDbAccessable, Serializable {

    private UzT0006CodeShubetsuEntity コード種別Entity;
    private UzT0007CodeEntity コードEntity;
}
