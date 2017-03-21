/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT123ZaigaiSenkyoninJushoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT510RyojikanDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のサービスクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuService {

    private final AfT123ZaigaiSenkyoninJushoDac 在外選挙人国内住所情報Dac;
    private final AfT510RyojikanDac 領事官Dac;
    private final AfT501TohyokuDac 投票区Dac;

    /**
     * コンストラクタです。
     */
    SenkyojiTourokuService() {
        this.在外選挙人国内住所情報Dac = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
        this.領事官Dac = InstanceProvider.create(AfT510RyojikanDac.class);
        this.投票区Dac = InstanceProvider.create(AfT501TohyokuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 在外選挙人国内住所情報Dac 在外選挙人国内住所情報Dac
     * @param 領事官Dac 領事官Dac
     * @param 投票区Dac 投票区Dac
     */
    SenkyojiTourokuService(AfT123ZaigaiSenkyoninJushoDac 在外選挙人国内住所情報Dac, AfT510RyojikanDac 領事官Dac, AfT501TohyokuDac 投票区Dac) {
        this.在外選挙人国内住所情報Dac = 在外選挙人国内住所情報Dac;
        this.領事官Dac = 領事官Dac;
        this.投票区Dac = 投票区Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyojiTourokuService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyojiTourokuService}のインスタンス
     */
    public static SenkyojiTourokuService createInstance() {
        return InstanceProvider.create(SenkyojiTourokuService.class);
    }

    /**
     * 指定された識別コード、申請番号、住所種類区分に該当する、在外選挙人国内住所を取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param shinseiNo 申請番号
     * @param jushoShuruiKubun 住所種類区分
     * @return 該当した在外選挙人国内住所情報エンティティ
     */
    @Transaction
    public RString get在外選挙人国内住所(ShikibetsuCode shikibetsuCode, int shinseiNo, Code jushoShuruiKubun) {
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人国内住所情報
                = 在外選挙人国内住所情報Dac.select(shikibetsuCode, shinseiNo, jushoShuruiKubun);
        RString 在外選挙人国内住所 = RString.EMPTY;
        if (在外選挙人国内住所情報 != null) {
            AtenaJusho 住所情報 = 在外選挙人国内住所情報.getJusho();
            if (住所情報 != null) {
                在外選挙人国内住所 = 住所情報.value();
            }
            AtenaBanchi 番地 = 在外選挙人国内住所情報.getBanchi();
            if (番地 != null) {
                在外選挙人国内住所 = 在外選挙人国内住所.concat(番地.value());
            }
        }
        return 在外選挙人国内住所;
    }

    /**
     * 指定された領事官コードに該当する、領事官名称を取得します。
     *
     * @param ryojikanCode 領事官コード
     * @return 該当した領事官名称
     */
    @Transaction
    public RString get領事官名称(RString ryojikanCode) {
        AfT510RyojikanEntity 領事官Entity = 領事官Dac.select(ryojikanCode);
        if (領事官Entity != null) {
            return 領事官Entity.getRyojikanName();
        }
        return RString.EMPTY;
    }

    /**
     * 指定された選挙種類、投票区コードに該当する投票区名称を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param tohyokuCode 投票区コード
     * @return 該当した領事官名称
     */
    @Transaction
    public RString get投票区名称(Code senkyoShurui, RString tohyokuCode) {
        AfT501TohyokuEntity 投票区Entity = 投票区Dac.select(senkyoShurui, tohyokuCode);
        if (投票区Entity != null) {
            return 投票区Entity.getTohyokuName();
        }
        return RString.EMPTY;
    }

}
