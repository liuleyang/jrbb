///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijiTouroku;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
//import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
//import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
//import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper;
//import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
//import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
//import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
//import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
//import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
//import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
//import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
//@RunWith(Enclosed.class)
//public class AFABTA101MapperTest extends AfaTestDacBase {
//
//    public static class AFABTA101Mapper_SelectData extends AfaTestDacBase {
//
//        @Test
//        public void 選挙人投票情報() {
//            IAFABTA101Mapper mapper = sqlSession.getMapper(IAFABTA101Mapper.class);
//            List<JuminShubetsu> 住民種別 = new ArrayList<>();
//            住民種別.add(JuminShubetsu.日本人);
//            ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
//            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
//            build.set基準日(new FlexibleDate(2015, 12, 12));
//            build.set住民種別(住民種別);
//            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
//
//            BatchMybatisParameter param = new BatchMybatisParameter(new RString("1"), new FlexibleDate(2015, 12, 12), FlexibleDate.EMPTY,
//                    FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, shikibetsuTaishoPSMSearchKey,
//                    new ShohonNo(50), RString.EMPTY, RString.EMPTY, RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, new RString("3"),
//                    new RString("000000000000039"), new FlexibleDate(2011, 1, 1), new FlexibleDate(2011, 1, 1), new RString("4"));
//            List<SenkyoninTohyoJokyoEntity> list = mapper.selectEikyuMeiboList(param);
//            assertThat("1", is("1"));
//        }
//
//    }
//}
