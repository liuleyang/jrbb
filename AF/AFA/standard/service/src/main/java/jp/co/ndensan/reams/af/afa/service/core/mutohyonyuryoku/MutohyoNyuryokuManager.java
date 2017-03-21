/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.mutohyonyuryoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.JotaiHenkoJoho;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.TohyoJokyoJoho;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.JotaiHenkoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.MutohyoNyuryokuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.JotaiHenkoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.MutohyoNyuryokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT112SenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.mutohyonyuryoku.IMutohyoNyuryokuRelateMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 投票情報を管理するクラスです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public class MutohyoNyuryokuManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT111SenkyoDac afT111SenkyoDac;
    private final AfT201TohyoJokyoDac afT201TohyoJokyoDac;
    private final AfT112SenkyoninMeiboDac afT112SenkyoninMeiboDac;

    /**
     * コンストラクタです。
     */
    public MutohyoNyuryokuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        afT111SenkyoDac = InstanceProvider.create(AfT111SenkyoDac.class);
        afT201TohyoJokyoDac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
        afT112SenkyoninMeiboDac = InstanceProvider.create(AfT112SenkyoninMeiboDac.class);
    }

    MutohyoNyuryokuManager(AfaMapperProvider mapperProvider, AfT111SenkyoDac afT111SenkyoDac, AfT201TohyoJokyoDac afT201TohyoJokyoDac,
            AfT112SenkyoninMeiboDac afT112SenkyoninMeiboDac) {
        this.mapperProvider = mapperProvider;
        this.afT111SenkyoDac = afT111SenkyoDac;
        this.afT201TohyoJokyoDac = afT201TohyoJokyoDac;
        this.afT112SenkyoninMeiboDac = afT112SenkyoninMeiboDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MutohyoNyuryokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MutohyoNyuryokuManager}のインスタンス
     */
    public static MutohyoNyuryokuManager createInstance() {
        return InstanceProvider.create(MutohyoNyuryokuManager.class);
    }

    /**
     * 投票状況情報リストを取得します。
     *
     * @param parameter MutohyoNyuryokuMybatisParameter
     * @return 投票状況情報リスト
     */
    public List<TohyoJokyoJoho> get投票状況情報(MutohyoNyuryokuMybatisParameter parameter) {
        IMutohyoNyuryokuRelateMapper mapper = mapperProvider.create(IMutohyoNyuryokuRelateMapper.class);
        List<MutohyoNyuryokuEntity> entityList = mapper.getTohyoJokyoJoho(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<TohyoJokyoJoho> tohyoJokyoList = new ArrayList<>();
        for (MutohyoNyuryokuEntity entity : entityList) {
            tohyoJokyoList.add(new TohyoJokyoJoho(entity));
        }
        return tohyoJokyoList;
    }

    /**
     * 投票状況情報リストを取得します。
     *
     * @param parameter MutohyoNyuryokuMybatisParameter
     * @return 投票状況情報リスト
     */
    public List<JotaiHenkoJoho> get状態変更情報(JotaiHenkoMybatisParameter parameter) {
        IMutohyoNyuryokuRelateMapper mapper = mapperProvider.create(IMutohyoNyuryokuRelateMapper.class);
        List<JotaiHenkoEntity> entityList = mapper.getJotaiHenkoJoho(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<JotaiHenkoJoho> jotaiHenkoJohoList = new ArrayList<>();
        for (JotaiHenkoEntity entity : entityList) {
            jotaiHenkoJohoList.add(new JotaiHenkoJoho(entity));
        }
        return jotaiHenkoJohoList;
    }

    /**
     * Senkyoを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return Senkyo
     */
    public int countSenkyo(ShohonNo 抄本番号) {
        List<AfT111SenkyoEntity> list = afT111SenkyoDac.selectBy抄本番号(抄本番号);
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /**
     * SenkyoLabelを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return Senkyolabel
     */
    public RString senkyoLabel(ShohonNo 抄本番号) {
        RString senkyoLabel = RString.EMPTY;
        List<AfT111SenkyoEntity> list = afT111SenkyoDac.selectBy抄本番号(抄本番号);
        if (list == null) {
            return RString.EMPTY;
        }
        for (AfT111SenkyoEntity entity : list) {
            senkyoLabel = senkyoLabel.concat(new RString(entity.getSenkyoNo().toString())).
                    concat(new RString("：")).
                    concat(entity.getSenkyoRyakusho() == null ? RString.EMPTY : entity.getSenkyoRyakusho()).
                    concat(entity.getMutohyoSenkyoFlag() ? new RString("（無投票）　") : RString.FULL_SPACE);
        }
        return senkyoLabel;
    }

    /**
     * AfT201TohyoJokyoEntityを登録します。
     *
     * @param shohon RString
     * @param shikibetsuCode RString
     * @param senkyoNo int
     * @param jokyo RString
     * @return 登録件数
     */
    public int save(RString shohon, RString shikibetsuCode, int senkyoNo, RString jokyo) {
        AfT201TohyoJokyoEntity entity = new AfT201TohyoJokyoEntity();
        entity.setShohonNo(new ShohonNo(shohon));
        entity.setShikibetsuCode(new ShikibetsuCode(shikibetsuCode));
        entity.setSenkyoNo(new SenkyoNo(senkyoNo));
        entity.setTohyoJokyo(new Code(jokyo));
        entity.setTohyoJiyuCode(Code.EMPTY);
        entity.setSeikyuYMD(FlexibleDate.EMPTY);
        entity.setSeikyuHoho(Code.EMPTY);
        entity.setUketsukeNo(0);
        entity.setKofuYMD(FlexibleDate.EMPTY);
        entity.setKofuTime(new RTime(new RString("0000")));
        entity.setKofuHoho(Code.EMPTY);
        entity.setShisetsuCode(RString.EMPTY);
        entity.setUketoriYMD(FlexibleDate.EMPTY);
        entity.setJuriYMD(FlexibleDate.EMPTY);
        entity.setJuriTime(new RTime(new RString("0000")));
        entity.setJuriHoho(Code.EMPTY);
        entity.setJuriShisetsuShubetsu(Code.EMPTY);
        entity.setKikenYMD(FlexibleDate.EMPTY);
        entity.setHenkanYMD(FlexibleDate.EMPTY);
        entity.setTenjiFlag(false);
        entity.setDairiTohyoAriFlag(false);
        entity.setHojoshaShikibetsuCode1(ShikibetsuCode.EMPTY);
        entity.setHojoshaShimei1(AtenaMeisho.EMPTY);
        entity.setHojoshaShikibetsuCode2(ShikibetsuCode.EMPTY);
        entity.setHojoshaShimei2(AtenaMeisho.EMPTY);
        entity.setKyohiJiyu(RString.EMPTY);
        entity.setShomeishoPrintFlag(false);
        entity.setSochiZumiFlag(false);
        entity.setKijitsuFuzaiKubun(new Code(new RString("3")));
        entity.setReamsClientId(RString.EMPTY);
        return afT201TohyoJokyoDac.save(entity);
    }

    /**
     * AfT201TohyoJokyoEntityを登録します。
     *
     * @param tohyoJokyoEntityRString RString
     * @param jokyo RString
     * @return 登録件数
     */
    public int saveJotaiHenko(RString tohyoJokyoEntityRString, RString jokyo) {
        AfT201TohyoJokyoEntity entity = DataPassingConverter.deserialize(tohyoJokyoEntityRString, AfT201TohyoJokyoEntity.class);
        entity.setTohyoJokyo(new Code(jokyo));
        return afT201TohyoJokyoDac.save(entity);
    }

    /**
     * 次ページがあるかどうかを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param グループコード RString
     * @param 投票区コード RString
     * @param 冊 RString
     * @param 頁 Decimal
     * @return boolean
     */
    public boolean hasNextPage(ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            Decimal 頁) {
        List<AfT112SenkyoninMeiboEntity> nextPage = afT112SenkyoninMeiboDac.selectNextPage(抄本番号, グループコード, 投票区コード, 冊, 頁);
        return nextPage != null && !nextPage.isEmpty();
    }

    /**
     * 資格判定情報を変更します。
     *
     * @param 投票状況 TohyoJokyoJoho
     * @return 資格判定情報
     */
    public SenkyoninTohyoJokyoEntity changeTo資格判定情報(TohyoJokyoJoho 投票状況) {
        SenkyoninTohyoJokyoEntity 資格判定情報 = new SenkyoninTohyoJokyoEntity();
        資格判定情報.setSenkyoShikakuEntity(投票状況.getMutohyoNyuryokuEntity().getSenkyoShikakuEntity());
        SenkyoJohoEntity 選挙情報 = new SenkyoJohoEntity();
        選挙情報.setShohonEntity(投票状況.getMutohyoNyuryokuEntity().getShohonEntity());
        資格判定情報.setSenkyoJohoEntity(new SenkyoJohoEntity());
        return 資格判定情報;
    }
}
