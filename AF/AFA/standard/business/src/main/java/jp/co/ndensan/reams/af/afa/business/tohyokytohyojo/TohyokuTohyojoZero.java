/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokytohyojo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo.TohyokuTohyojoZeroForMap;

/**
 * 投票区投票所情報です
 *
 * @reamsid_L AF-0720-010 liuyj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TohyokuTohyojoZero implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;
    private TohyokuTohyojoZeroForMap tohyokuTohyojoZeroForMap;
}
