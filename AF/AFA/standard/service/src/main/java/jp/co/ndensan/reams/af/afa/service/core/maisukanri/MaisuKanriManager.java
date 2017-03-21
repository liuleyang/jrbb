/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.maisukanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResult;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResultList;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.maisukanri.MaisuKanriJouhou;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT251TohyoYoshiMaisuKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.maisukanri.IMaisuKanriMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票用紙枚数管理クラスです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class MaisuKanriManager {

    private final AfT111SenkyoDac afT111SenkyoDa;
    private final AfT251TohyoYoshiMaisuKanriDac afT251TohyoYoshiMaisuKanriDac;
    private final AfaMapperProvider mapperProvider;
    private MaisuKanriJouhou parm;

    /**
     * コンストラクタです。
     */
    public MaisuKanriManager() {
        afT111SenkyoDa = InstanceProvider.create(AfT111SenkyoDac.class);
        afT251TohyoYoshiMaisuKanriDac = InstanceProvider.create(AfT251TohyoYoshiMaisuKanriDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンス
     */
    public static MaisuKanriManager createInstance() {
        return InstanceProvider.create(MaisuKanriManager.class);
    }

    /**
     * 抄本番号に合致する選挙リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @return Senkyoリスト
     */
    @Transaction
    public List<Senkyo> get選挙By抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));

        List<AfT111SenkyoEntity> entityList = afT111SenkyoDa.selectBy抄本番号(抄本番号);
        List<Senkyo> senkyoList = new ArrayList<>();

        if (entityList.isEmpty()) {
            return senkyoList;
        }

        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoList.add(new Senkyo(entity));
        }
        return senkyoList;
    }

    /**
     * 投票用紙枚数リストを返します。
     *
     * @param 抄本番号 RString
     * @param 選挙種類 SenkyoShurui
     * @param 選挙番号 RString
     * @return Senkyoリスト
     */
    @Transaction
    public List<TohyoYoshiMaisuSearchResult> get投票用紙枚数リスト(RString 抄本番号, SenkyoShurui 選挙種類, RString 選挙番号) {
        List<TohyoYoshiMaisuSearchResult> tohyoYoshiList = new ArrayList<>();
        IMaisuKanriMapper mapper = mapperProvider.create(IMaisuKanriMapper.class);
        parm = new MaisuKanriJouhou();
        parm.set抄本番号(new ShohonNo(抄本番号));
        parm.set選挙種類(選挙種類.getCode());
        parm.set選挙番号(new SenkyoNo(選挙番号));
        List<MaisuKanriJouhou> maisuList = mapper.select投票用紙枚数リスト(parm);
        if (!maisuList.isEmpty()) {
            for (MaisuKanriJouhou maisu : maisuList) {
                TohyoYoshiMaisuSearchResult tohyoYoshi = new TohyoYoshiMaisuSearchResult();
                tohyoYoshi.setEntity(maisu);
                tohyoYoshiList.add(tohyoYoshi);
            }
        }
        return tohyoYoshiList;
    }

    /**
     * TohyoYoshiMaisuKanri tohyoYoshi get投票区コードリストを返します。
     *
     * @param 投票情報 TohyoYoshiMaisuSearchResultList
     */
    @Transaction
    public void save投票用紙枚数管理(TohyoYoshiMaisuSearchResultList 投票情報) {
        for (TohyoYoshiMaisuSearchResult data : 投票情報.get投票用紙枚数リスト()) {
            AfT251TohyoYoshiMaisuKanriEntity result = afT251TohyoYoshiMaisuKanriDac.select(data.getEntity().getAfT251Entity().getShohonNo(),
                    data.getEntity().getAfT251Entity().getSenkyoNo(), data.getEntity().getAfT251Entity().getTohyokuCode());
            if (null != result) {
                data.getEntity().getAfT251Entity().setState(EntityDataState.Modified);
                afT251TohyoYoshiMaisuKanriDac.save(data.getEntity().getAfT251Entity());
            } else {
                data.getEntity().getAfT251Entity().setState(EntityDataState.Added);
                afT251TohyoYoshiMaisuKanriDac.save(data.getEntity().getAfT251Entity());
            }
        }
    }
}
