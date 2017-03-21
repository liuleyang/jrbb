/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE509;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表を編集するクラスです。
 *
 * @reamsid_L AF-0280-026 wangm
 */
public class JurijokyoIchiranhyoEditor implements IJurijokyoIchiranhyoEditor {

    private static final RString 名簿番号_SEPARATOR = new RString("-");
    private static final Map<RString, RString> 投票状況_MAP = new HashMap<>();

    static {
        投票状況_MAP.put(new RString("1"), new RString("□請求"));
        投票状況_MAP.put(new RString("2"), new RString("□交付"));
        投票状況_MAP.put(new RString("3"), new RString("□受理"));
        投票状況_MAP.put(new RString("4"), new RString("□返還"));
        投票状況_MAP.put(new RString("5"), new RString("□棄権"));
        投票状況_MAP.put(new RString("6"), new RString("□期日前"));
        投票状況_MAP.put(new RString("7"), new RString("□当日"));
        投票状況_MAP.put(new RString("8"), new RString("□拒否"));
        投票状況_MAP.put(new RString("9"), new RString("□仮投票"));
    }

    private final JurijokyoIchiranhyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link JurijokyoIchiranhyoParam}
     */
    public JurijokyoIchiranhyoEditor(JurijokyoIchiranhyoParam target) {
        this.target = target;
    }

    @Override
    public JurijokyoIchiranhyoSource edit(JurijokyoIchiranhyoSource source) {

        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();

        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();

        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();

        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();

        // ページ
        // 1から連番
        source.pagecnt = new RString(String.valueOf(target.getPage()));

        // 作成条件１
        source.sakuseiJoken1 = target.get作成条件();

        // 作成条件２
        source.sakuseiJoken2 = RString.EMPTY;

        AfT112SenkyoninMeiboEntity 選挙人名簿 = target.get選挙人名簿();

        // 投票区
        // 投票区コード
        source.listMeisai_1 = 選挙人名簿.getTohyokuCode();

        // 名簿番号
        RStringBuilder 名簿番号 = new RStringBuilder();
        名簿番号.append(選挙人名簿.getTohyokuCode());
        名簿番号.append(名簿番号_SEPARATOR);
        if (!BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体).equals(
                抄本_冊区分管理_使用しない.getValue())) {
            名簿番号.append(選挙人名簿.getSatsu());
            名簿番号.append(名簿番号_SEPARATOR);
        }
        名簿番号.append(選挙人名簿.getPage());
        名簿番号.append(名簿番号_SEPARATOR);
        名簿番号.append(選挙人名簿.getGyo());

        source.listMeisai_2 = 名簿番号.toRString();

        // 氏名
        source.listMeisai_3 = target.get氏名();

        editDetail(source);

        return source;
    }

    private void editDetail(JurijokyoIchiranhyoSource source) {

        int i = 0;
        List<RString> 選挙名称リスト = target.get選挙名称リスト();
        List<AfT201TohyoJokyoEntity> 投票状況リスト = target.get投票状況リスト();

        // 選挙名称１
        source.senkyoMei1 = 選挙名称リスト.get(i);
        // 選挙1
        source.listMeisai_4 = edit投票状況(投票状況リスト, i++);

        // 選挙名称２
        source.senkyoMei2 = 選挙名称リスト.get(i);
        // 選挙2
        source.listMeisai_5 = edit投票状況(投票状況リスト, i++);

        // 選挙名称３
        source.senkyoMei3 = 選挙名称リスト.get(i);
        // 選挙3
        source.listMeisai_6 = edit投票状況(投票状況リスト, i++);

        // 選挙名称４
        source.senkyoMei4 = 選挙名称リスト.get(i);
        // 選挙4
        source.listMeisai_7 = edit投票状況(投票状況リスト, i++);

        // 選挙名称５
        source.senkyoMei5 = 選挙名称リスト.get(i);
        // 選挙5
        source.listMeisai_8 = edit投票状況(投票状況リスト, i++);

        // 選挙名称６
        source.senkyoMei6 = 選挙名称リスト.get(i);
        // 選挙6
        source.listMeisai_9 = edit投票状況(投票状況リスト, i++);

        // 選挙名称７
        source.senkyoMei7 = 選挙名称リスト.get(i);
        // 選挙7
        source.listMeisai_10 = edit投票状況(投票状況リスト, i++);

        // 選挙名称８
        source.senkyoMei8 = 選挙名称リスト.get(i);
        // 選挙8
        source.listMeisai_11 = edit投票状況(投票状況リスト, i++);

        // 選挙名称９
        source.senkyoMei9 = 選挙名称リスト.get(i);
        // 選挙9
        source.listMeisai_12 = edit投票状況(投票状況リスト, i++);

    }

    private RString edit投票状況(List<AfT201TohyoJokyoEntity> 投票状況リスト, int i) {

        RString 投票状況 = RString.EMPTY;
        AfT201TohyoJokyoEntity aft201 = 投票状況リスト.get(i);

        if (aft201 != null) {
            Code tohyoJokyo = aft201.getTohyoJokyo();
            if (tohyoJokyo != null) {
                投票状況 = 投票状況_MAP.get(tohyoJokyo.getColumnValue());
            }
        }

        return 投票状況;

    }

}
