/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.juminkensaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.juminkensaku.JuminKensaku;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.juminkensaku.JuminKensakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.JuminKensakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.juminkensaku.IJuminKensakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.juminkensaku.IJuminKensakuZaigaiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住民検索を管理するクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class JuminKensakuManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JuminKensakuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminKensakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JuminKensakuManager}のインスタンス
     */
    public static JuminKensakuManager createInstance() {
        return InstanceProvider.create(JuminKensakuManager.class);
    }

    /**
     * 検索結果一覧を取得します。
     *
     * @param 住民検索条件 JuminKensakuMapperParameter
     * @return List<JuminKensaku>
     */
    @Transaction
    public List<JuminKensaku> get検索結果一覧(JuminKensakuMapperParameter 住民検索条件) {
        requireNonNull(住民検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("住民検索条件"));

        List<JuminKensakuEntity> entitys;
        if (住民検索条件.is在外()) {
            IJuminKensakuZaigaiMapper mapper = mapperProvider.create(IJuminKensakuZaigaiMapper.class);
            entitys = mapper.select検索結果一覧(住民検索条件);
        } else {
            IJuminKensakuMapper mapper = mapperProvider.create(IJuminKensakuMapper.class);
//        List<JuminKensakuEntity> entitys = mapper.select検索結果一覧(住民検索条件);
            entitys = mapper.select検索結果一覧(住民検索条件);
        }

        List<JuminKensaku> juminKensakuList = new ArrayList<>();
        for (JuminKensakuEntity entity : entitys) {
            juminKensakuList.add(new JuminKensaku(entity));
        }

        return juminKensakuList;
    }

    /**
     * 総件数の取得メソッドです。
     *
     * @param 住民検索条件 JuminKensakuMapperParameter
     * @return 総件数 int
     */
    @Transaction
    public int get総件数(JuminKensakuMapperParameter 住民検索条件) {
        requireNonNull(住民検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("住民検索条件"));
        IJuminKensakuMapper mapper = mapperProvider.create(IJuminKensakuMapper.class);
        return mapper.select総件数(住民検索条件);
    }
}
