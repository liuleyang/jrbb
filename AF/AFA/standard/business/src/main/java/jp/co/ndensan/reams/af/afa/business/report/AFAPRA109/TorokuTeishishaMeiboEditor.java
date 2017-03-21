/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA109;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109.TorokuTeishishaMeiboSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 登録停止者名簿Editorです。
 *
 * @reamsid_L AF-0010-043 wangm
 */
public class TorokuTeishishaMeiboEditor implements ITorokuTeishishaMeiboEditor {

    private static final int 地区コードタイトル = 0;
    private static final int 地区コード内容 = 1;
    private static final int 地区名タイトル = 2;
    private static final int 地区名内容 = 3;

    private final EikyuSenkyoninMeiboEntity entity;
    private final TorokuTeishishaMeiboParam param;
    private final IKojin 宛名識別対象;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final List<RString> 地区行政区判断;

    /**
     * コンストラクタです。
     *
     * @param param TorokuTeishishaMeiboParam
     */
    public TorokuTeishishaMeiboEditor(TorokuTeishishaMeiboParam param) {
        this.param = param;
        this.entity = param.getEntity();
        this.idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        this.宛名識別対象 = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity());
        this.帳票共通ヘッダー = param.get帳票共通ヘッダー();

        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());

        this.地区行政区判断 = idouSenkyoninIchiran.is行政区_地区(senkyoninTohyoJokyoEntity);
    }

    @Override
    public TorokuTeishishaMeiboSource edit(TorokuTeishishaMeiboSource source) {

        setヘッダフッタ(source);

        if (param.is合計行()) {
            source.listMeisai1_5 = param.get合計行();
        } else if (!param.isEmpty()) {
            set明細(source);
        }
        return source;
    }

    private void setヘッダフッタ(TorokuTeishishaMeiboSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();

        source.chikuCodeMei = 地区行政区判断.get(地区コードタイトル);
        source.chikuMei = 地区行政区判断.get(地区名タイトル);
        source.sakuseiYmdTime = param.get作成日時();
    }

    private void set明細(TorokuTeishishaMeiboSource source) {

        source.listMeisai1_1 = entity.getSenkyoninMeiboEntity().getTohyokuCode();
        source.listMeisai1_2 = 宛名識別対象.get世帯コード().value();
        IName 名称 = 宛名識別対象.get名称();
        source.listMeisai1_3 = 名称.getKana().getColumnValue();
        source.listMeisai2_3 = 名称.getName().getColumnValue();

        source.listMeisai1_4 = 宛名識別対象.get住登内住所().get町域コード().getColumnValue();

        IJusho 住登内住所 = 宛名識別対象.get住登内住所();
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(getTrimValue(住登内住所.get住所()));
        住所.append(getTrimValue(住登内住所.get番地().getBanchi().getColumnValue()));
        Katagaki 方書 = 住登内住所.get方書();
        if (方書 != null && !方書.isEmpty()) {
            住所.append(RString.FULL_SPACE);
            住所.append(getTrimValue(方書.getColumnValue()));
        }
        source.listMeisai1_5 = 住所.toRString();

        source.listMeisai1_6 = idouSenkyoninIchiran.get生年月日(宛名識別対象.get住民種別().getCode(), 宛名識別対象.get生年月日().toFlexibleDate());
        source.listMeisai2_2 = 宛名識別対象.get識別コード().getColumnValue();
        source.listMeisai2_4 = 地区行政区判断.get(地区コード内容);
        source.listMeisai2_5 = 地区行政区判断.get(地区名内容);

        AfT113SenkyoShikakuEntity aft113 = entity.getSenkyoShikakuEntity();

        FlexibleDate 停止年月日 = aft113.getTorokuTeishiYMD();
        source.listMeisai2_6 = get日付ToRString(停止年月日);

        Code 停止理由 = aft113.getTorokuTeishiJiyuCode();
        source.listMeisai2_7 = 停止理由 == null || 停止理由.isEmpty() ? RString.EMPTY : aft113.getTorokuTeishiJiyuCodeMeisho();

        source.listMeisai2_8 = 宛名識別対象.get性別().getCommonName();
        RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(登録年月日検索基準)) {
            source.listMeisai2_9 = get日付ToRString(宛名識別対象.get登録異動年月日());
        } else if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(登録年月日検索基準)) {
            source.listMeisai2_9 = get日付ToRString(宛名識別対象.get登録届出年月日());
        } else {
            source.listMeisai2_9 = RString.EMPTY;
        }

    }

    private RString getTrimValue(RString value) {
        if (null == value) {
            return RString.EMPTY;
        }
        return value.trim('　').trim();
    }

    private RString get日付ToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

}
