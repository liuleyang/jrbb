/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SakuinboEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 索引簿パラメータクラスです。
 *
 * @reamsid_L AF-0010-036 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SakuinboParam {

    private final RString 投票区コード;
    private final AtenaKanaMeisho ヘッダ_カナ氏名;
    private final AtenaMeisho 氏名;
    private final AtenaKanaMeisho カナ氏名;
    private final RString 住所;
    private final RString 行政区;
    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 届出日;
    private final RString 住民種別コード;
    private final FlexibleDate 生年月日;
    private final Code 選挙種類;
    private final Code 資格区分;
    private final RString 抄本名;
    private final FlexibleDate 投票日;
    private final RString 性別コード;
    private final RString 冊;
    private final int 頁;
    private final int 行;
    private final List<FlexibleDate> 基準日List;

    /**
     * コンストラクタ
     *
     * @param 投票区コード RString
     * @param ヘッダ_カナ氏名 AtenaKanaMeisho
     * @param 氏名 AtenaMeisho
     * @param カナ氏名 AtenaKanaMeisho
     * @param 住所 RString
     * @param 行政区 RString
     * @param 識別コード ShikibetsuCode
     * @param 届出日 FlexibleDate
     * @param 住民種別コード RString
     * @param 生年月日 FlexibleDate
     * @param 選挙種類 Code
     * @param 資格区分 Code
     * @param 性別コード RString
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 冊 RString
     * @param 頁 int
     * @param 行 int
     * @param 基準日List List<FlexibleDate>
     */
    public SakuinboParam(RString 投票区コード,
            AtenaKanaMeisho ヘッダ_カナ氏名,
            AtenaMeisho 氏名,
            AtenaKanaMeisho カナ氏名,
            RString 住所,
            RString 行政区,
            ShikibetsuCode 識別コード,
            FlexibleDate 届出日,
            RString 住民種別コード,
            FlexibleDate 生年月日,
            Code 選挙種類,
            Code 資格区分,
            RString 抄本名,
            FlexibleDate 投票日,
            RString 性別コード,
            RString 冊,
            int 頁,
            int 行,
            List<FlexibleDate> 基準日List) {
        this.投票区コード = 投票区コード;
        this.ヘッダ_カナ氏名 = ヘッダ_カナ氏名;
        this.氏名 = 氏名;
        this.カナ氏名 = カナ氏名;
        this.住所 = 住所;
        this.行政区 = 行政区;
        this.識別コード = 識別コード;
        this.届出日 = 届出日;
        this.住民種別コード = 住民種別コード;
        this.生年月日 = 生年月日;
        this.選挙種類 = 選挙種類;
        this.資格区分 = 資格区分;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.性別コード = 性別コード;
        this.冊 = 冊;
        this.頁 = 頁;
        this.行 = 行;
        this.基準日List = 基準日List;
    }

    /**
     * 選挙人索引簿のパラメータbuilderクラスです。
     */
    public static class SakuinboParamBuilder {

        private SakuinboEntity current;
        private List<AfT111SenkyoEntity> senkyoEntityList;
        private static final List<FlexibleDate> EMPTY_基準日 = Arrays.asList(FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY);

        /**
         * コンストラクタです。
         */
        public SakuinboParamBuilder() {
            current = null;
            senkyoEntityList = null;
        }

        /**
         * 検索データを追加します。
         *
         * @param entity SakuinboEntity
         *
         * @return SakuinboParam
         */
        public SakuinboParam addData(SakuinboEntity entity) {
            SakuinboParam param = null;
            if (current == null) {
                newEntity(entity);
            } else if (is同じレコード(current, entity)) {
                addSenkyo(entity);
            } else {
                param = newParam();
                newEntity(entity);
            }
            return param;
        }

        private boolean is同じレコード(SakuinboEntity current, SakuinboEntity entity) {
            return current.getSenkyoninMeiboEntity().equalsPrimaryKeys(entity.getSenkyoninMeiboEntity());
        }

        private SakuinboParam newParam() {
            UaFt200FindShikibetsuTaishoEntity 宛名PSM = current.getShikibetsuTaishoEntity();
            RString 投票区コード = current.getSenkyoninMeiboEntity().getTohyokuCode();
            AtenaKanaMeisho ヘッダ_カナ氏名 = 宛名PSM.getKanaMeisho();
            AtenaMeisho 氏名 = 宛名PSM.getMeisho();
            AtenaKanaMeisho カナ氏名 = 宛名PSM.getKanaMeisho();
            RString 住所 = 宛名PSM.getJutonaiJusho();
            RString 行政区 = 宛名PSM.getGyoseikuName();
            ShikibetsuCode 識別コード = 宛名PSM.getShikibetsuCode();
            FlexibleDate 届出日 = 宛名PSM.getTorokuTodokedeYMD();
            RString 住民種別コード = 宛名PSM.getJuminShubetsuCode();
            FlexibleDate 生年月日 = 宛名PSM.getSeinengappiYMD();
            Code 選挙種類 = current.getShohonEntity().getSenkyoShurui();
            Code 資格区分 = current.getSenkyoShikakuEntity().getShikakuKubun();
            RString 抄本名 = current.getShohonEntity().getShohonName();
            FlexibleDate 投票日 = current.getShohonEntity().getTohyoYMD();
            List<FlexibleDate> 基準日List = new ArrayList<>(EMPTY_基準日);
            for (AfT111SenkyoEntity senkyoEntity : senkyoEntityList) {
                int index = senkyoEntity.getSenkyoNo().getColumnValue() - 1;
                if (index < 基準日List.size()) {
                    基準日List.set(index, senkyoEntity.getKijunYMD());
                }
            }
            RString 性別コード = 宛名PSM.getSeibetsuCode();
            RString 冊 = current.getSenkyoninMeiboEntity().getSatsu();
            int 頁 = current.getSenkyoninMeiboEntity().getPage();
            int 行 = current.getSenkyoninMeiboEntity().getGyo();
            return new SakuinboParam(投票区コード, ヘッダ_カナ氏名, 氏名, カナ氏名, 住所, 行政区, 識別コード, 届出日, 住民種別コード, 生年月日, 選挙種類, 資格区分, 抄本名, 投票日, 性別コード, 冊, 頁, 行, 基準日List);

        }

        private void newEntity(SakuinboEntity entity) {
            current = entity;
            senkyoEntityList = new ArrayList<>();
            addSenkyo(entity);
        }

        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 20 LINES
        private void addSenkyo(SakuinboEntity entity) {
            AfT111SenkyoEntity senkyo = entity.getSenkyoEntity();
            if (senkyo != null) {
                SenkyoNo senkyoNo = senkyo.getSenkyoNo();

                if (senkyoNo != null && senkyoNo.getColumnValue() != null) {
                    boolean hasSenkyo = false;

                    for (AfT111SenkyoEntity senkyoInList : senkyoEntityList) {
                        if (senkyoInList.getSenkyoNo().equals(senkyoNo)) {
                            hasSenkyo = true;
                        }
                    }
                    if (!hasSenkyo) {
                        senkyoEntityList.add(senkyo);
                    }
                }
            }

        }
    }
}
