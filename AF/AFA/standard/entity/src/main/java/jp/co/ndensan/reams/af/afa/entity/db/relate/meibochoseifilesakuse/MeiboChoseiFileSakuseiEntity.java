/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibochoseifilesakuse;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 名簿調製用連携ファイル作成マッパーのインタフェースです。
 *
 * @reamsid_L AF-0300-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboChoseiFileSakuseiEntity {

    private RString 識別コード;
    private RString 名称;
    private FlexibleDate 生年月日;
    private RString 郵便番号;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 本籍住所;
    private RString 本籍番地;
    private RString 選挙資格区分;

}
