/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateZaigaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙時登録データ更新(在外)のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuDataUpdateZaigaiProcess extends BatchProcessBase<TeijiTourokuDataUpdateZaigaiEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;

    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.select在外選挙人名簿By抄本番号");
    private static final RString グループコード_0 = new RString("0");
    private static final RString 国外分類コード_000 = new RString("000");
    private static final RString 冊_00 = new RString("00");

    @BatchWriter
    private BatchPermanentTableWriter<AfT121ZaigaiSenkyoninMeiboEntity> aft121Writer;

    private RString 在外国外分類コード;
    private int page;
    private int gyo;
    private int maxGyo;
    private AfT121ZaigaiSenkyoninMeiboEntity last在外選挙人名簿;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toSenkyojiMybatisParameter();

        在外国外分類コード = BusinessConfig.get(ConfigKeysAFA.在外_国外分類コード, SubGyomuCode.AFA選挙本体);
        mybatisparameter.set在外国外分類コード(在外国外分類コード);
        page = 1;
        gyo = 1;
        maxGyo = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_在外_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        last在外選挙人名簿 = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新データ抽出, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        aft121Writer = new BatchPermanentTableWriter<>(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    @Override
    protected void process(TeijiTourokuDataUpdateZaigaiEntity entity) {

        insert(entity, parameter.getShohonNo());
        if (parameter.get研修用データも作成有無()) {
            insert(entity, parameter.get研修用発番抄本番号());
        }

    }

    private void insert(TeijiTourokuDataUpdateZaigaiEntity entity, ShohonNo 抄本番号) {

        if (抄本番号 == null) {
            return;
        }
        AfT121ZaigaiSenkyoninMeiboEntity 在外選挙人名簿 = new AfT121ZaigaiSenkyoninMeiboEntity();

        AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity = entity.getZaigaiSenkyoShikakuEntity();
        AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity = entity.getZaigaiSenkyoninShinseiEntity();

        在外選挙人名簿.setShohonNo(抄本番号);
        在外選挙人名簿.setGroupCode(グループコード_0);
        在外選挙人名簿.setTohyokuCode(getNullToRString(zaigaiSenkyoShikakuEntity.getTohyokuCode()));

        if (AFAConfigKeysValue.在外_国外分類コード_国籍コードを使用する.isEqual(在外国外分類コード)) {
            在外選挙人名簿.setKokugaiBunruiCode(getNullToRString(zaigaiSenkyoninShinseiEntity.getKokusekiCode()));
        } else if (AFAConfigKeysValue.在外_国外分類コード_領事官コードを使用する.isEqual(在外国外分類コード)) {
            在外選挙人名簿.setKokugaiBunruiCode(getNullToRString(zaigaiSenkyoninShinseiEntity.getRyojikanCode()));
        } else {
            在外選挙人名簿.setKokugaiBunruiCode(国外分類コード_000);
        }
        在外選挙人名簿.setSatsu(冊_00);

        if (!is同じ頁(在外選挙人名簿)) {
            page++;
            gyo = 1;
        }
        在外選挙人名簿.setPage(page);
        在外選挙人名簿.setGyo(gyo);
        在外選挙人名簿.setShikibetsuCode(zaigaiSenkyoShikakuEntity.getShikibetsuCode());
        if (gyo >= maxGyo) {
            page++;
            gyo = 1;
            last在外選挙人名簿 = null;
        } else {
            gyo++;
            last在外選挙人名簿 = 在外選挙人名簿;
        }

        aft121Writer.insert(在外選挙人名簿);

    }

    @Override
    protected void afterExecute() {

    }

    private RString getNullToRString(RString value) {
        if (null == value) {
            return RString.EMPTY;
        }
        return value;
    }

    private boolean is同じ頁(AfT121ZaigaiSenkyoninMeiboEntity 在外選挙人名簿) {
        return last在外選挙人名簿 == null
                || (last在外選挙人名簿.getTohyokuCode().equals(在外選挙人名簿.getTohyokuCode())
                && last在外選挙人名簿.getKokugaiBunruiCode().equals(在外選挙人名簿.getKokugaiBunruiCode()));
    }

}
