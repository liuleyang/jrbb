/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.persistence.mapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;
import jp.co.ndensan.reams.af.afx.entity.renkeijuki.KobetsuJikoSenkyoEntity;
import jp.co.ndensan.reams.af.afx.testhelper.AfxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKobetsuJikoSenkyoMapper}のテストクラスです。
 *
 * @author
 */
@RunWith(Enclosed.class)
public class IKobetsuJikoSenkyoMapperTest extends AfxTestDacBase {

    private static DbTestHelper dbTestHelper;
    private static final String T113_TESTDATA = "AfT113SenkyoShikaku.csv";

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
    }

    public static class selectTest extends AfxTestDacBase {

        private static IKobetsuJikoSenkyoMapper sut;

        @Before
        public void setUp() {
            sut = AfxTestDacBase.sqlSession.getMapper(IKobetsuJikoSenkyoMapper.class);
            dbTestHelper.cleanInsertTestDataFiles(sqlSession, new RString("AfT113SenkyoShikaku"), getDataPath(T113_TESTDATA));
        }

        @Test
        public void aaa() {
            List<ShikibetsuCode> codes = Arrays.asList(
                    new ShikibetsuCode("000000000661662"),
                    new ShikibetsuCode("000000000601632"),
                    new ShikibetsuCode("000000001414127"),
                    new ShikibetsuCode("000000000752371"));

            KobetsuJikoSenkyoFinderParameter parameter = new KobetsuJikoSenkyoFinderParameter(codes, new FlexibleDate("20160901"));
            List<KobetsuJikoSenkyoEntity> result = sut.select(parameter);
            assertThat(result.size(), is(3));
        }
    }

    private static RString getDataPath(String fileName) {
        RStringBuilder filePath = new RStringBuilder();
        filePath.append("src");
        filePath.append(File.separator).append("test");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("resources");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("jp");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("co");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("ndensan");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("reams");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("af");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("afx");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("persistence");
        filePath.append(jp.co.ndensan.reams.uz.uza.io.File.separator).append("helper");
        if (!Directory.exists(filePath.toRString())) {
            Directory.createDirectories(filePath.toRString());
        }
        filePath.append(java.io.File.separator).append(fileName);
        return filePath.toRString();
    }
}
