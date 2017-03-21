/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA106;

import java.util.Arrays;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新規登録者名簿縦覧のパラメータクラスです。
 *
 * @reamsid_L AF-0010-040 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinkiTorokushaMeiboJuranParameter {

    private final TorokushaMeiboEntity 選挙人資格の情報;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 出力区分;
    private final RString 登録年月日検索基準国民投票用;
    private RString 集計;

    /**
     * コンストラクタです。
     *
     * @param 選挙人資格の情報 TorokushaMeiboEntity
     * @param 出力区分 出力区分
     * @param 帳票共通ヘッダー 帳票共通ヘッダー
     * @param 登録年月日検索基準国民投票用 RString
     */
    public ShinkiTorokushaMeiboJuranParameter(TorokushaMeiboEntity 選挙人資格の情報,
            RString 出力区分, TeijiCommonJohoItem 帳票共通ヘッダー, RString 登録年月日検索基準国民投票用) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.出力区分 = 出力区分;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.登録年月日検索基準国民投票用 = 登録年月日検索基準国民投票用;
    }

    /**
     * 異動選挙人一覧に変換します。
     *
     * @param entity TorokushaMeiboEntity
     * @return 選挙人資格の情報
     */
    public SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(TorokushaMeiboEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        AfT111SenkyoEntity senkyoEntity = new AfT111SenkyoEntity();
        senkyoEntity.setKijunYMD(entity.getKijunYMD());
        senkyoJohoEntity.setShohonEntity(entity.getShohonEntity());
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(senkyoEntity));
        targetEntity.setSenkyoJohoEntity(senkyoJohoEntity);
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());

        return targetEntity;
    }
}
