/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.atenasealsakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12GamenJoho;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealListGamenJoho;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJokyoJoho;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.JushoIchiranMeisai;
import jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei.AFABTE601SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.atenasealsakusei.AtenaSealSakuseiJyohouEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成の編集クラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSealSakuseiEditor {

    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");

    /**
     * 宛名シール12面画面情報を編集する。
     *
     * @param parameter AFABTE601SelectProcessParameter
     * @return AtenaSeal12GamenJoho
     */
    public AtenaSeal12GamenJoho get宛名シール画面情報(
            AFABTE601SelectProcessParameter parameter) {
        AtenaSeal12GamenJoho 画面情報 = new AtenaSeal12GamenJoho();
        画面情報.set四隅項目_左下隅_コード(parameter.get四隅項目コード_左下隅());
        画面情報.set四隅項目_右上隅_コード(parameter.get四隅項目コード_右上隅());
        画面情報.set四隅項目_右下隅_コード(parameter.get四隅項目コード_右下隅());
        画面情報.set四隅項目_右上隅(parameter.get四隅項目_右上隅());
        画面情報.set四隅項目_右下隅(parameter.get四隅項目_右下隅());
        画面情報.set四隅項目_左下隅(parameter.get四隅項目_左下隅());
        画面情報.set本人敬称(parameter.get本人敬称());
        画面情報.set世帯主敬称(parameter.get世帯主敬称());
        画面情報.set本人敬称コード(parameter.get本人敬称コード());
        画面情報.set世帯主敬称コード(parameter.get世帯主敬称コード());
        画面情報.set住所(parameter.get住所コード名称());
        画面情報.set宛名コード(parameter.get宛名コード());
        画面情報.set住所の前に市町村名を付加(parameter.get住所の前に市町村名を付加());
        画面情報.set住所コード(parameter.get住所コード());
        return 画面情報;
    }

    /**
     * 宛名シール12面画面情報を編集する。
     *
     * @param parameter AFABTE601SelectProcessParameter
     * @return AtenaSealListGamenJoho
     */
    public AtenaSealListGamenJoho get宛名シール出力対象者一覧画面情報(
            AFABTE601SelectProcessParameter parameter) {
        AtenaSealListGamenJoho 画面情報 = new AtenaSealListGamenJoho();
        画面情報.set住所条件(parameter.get住所条件());
        List<RString> 住所一覧リスト_コード = new ArrayList<>();
        if (null != parameter.get住所一覧リスト()) {
            for (JushoIchiranMeisai 住所一覧 : parameter.get住所一覧リスト()) {
                住所一覧リスト_コード.add(住所一覧.getコード());
            }
        }
        画面情報.set住所一覧リスト_コード(住所一覧リスト_コード);
        画面情報.set対象期間FROM(parameter.get対象期間FROM());
        画面情報.set対象期間TO(parameter.get対象期間TO());
        画面情報.set施設種別(parameter.get施設種別());
        画面情報.set施設コードFROM(parameter.get施設コードFROM());
        画面情報.set施設コードTO(parameter.get施設コードTO());
        画面情報.set右上項目コード(parameter.get四隅項目コード_右上隅());
        画面情報.set右下項目コード(parameter.get四隅項目コード_右下隅());
        画面情報.set左下項目コード(parameter.get四隅項目コード_左下隅());

        return 画面情報;
    }

    /**
     * 投票資格情報を編集する。
     *
     * @param 宛名シール12面 AtenaSealSakuseiJyohouEntity
     * @return SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get投票資格情報(AtenaSealSakuseiJyohouEntity 宛名シール12面) {
        SenkyoninTohyoJokyoEntity 投票資格情報 = new SenkyoninTohyoJokyoEntity();
        投票資格情報.setAtenaPSMEntity(宛名シール12面.get宛名PSM情報());
        投票資格情報.setSenkyoninMeiboEntity(宛名シール12面.get選挙人名簿情報());
        投票資格情報.setSenkyoEntity(宛名シール12面.get選挙情報());
        return 投票資格情報;
    }

    /**
     * 出力対象者一覧投票資格情報を編集する。
     *
     * @param 宛名シール出力対象者一覧情報 AtenaSealSakuseiJyohouEntity
     * @param 起動画面ID RString
     * @return TohyoJokyoJoho
     */
    public TohyoJokyoJoho get出力対象者一覧投票資格情報(
            AtenaSealSakuseiJyohouEntity 宛名シール出力対象者一覧情報,
            RString 起動画面ID) {
        TohyoJokyoJoho 投票資格情報 = new TohyoJokyoJoho();
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            投票資格情報 = get選挙人宛名シール_投票資格情報(宛名シール出力対象者一覧情報);
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            投票資格情報 = get転出者宛名シール_投票資格情報(宛名シール出力対象者一覧情報);
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            投票資格情報 = get施設宛名シール_投票資格情報(宛名シール出力対象者一覧情報);
        }
        return 投票資格情報;
    }

    private TohyoJokyoJoho get選挙人宛名シール_投票資格情報(
            AtenaSealSakuseiJyohouEntity 宛名シール出力対象者一覧情報) {
        TohyoJokyoJoho 投票資格情報 = new TohyoJokyoJoho();
        if (null != 宛名シール出力対象者一覧情報.get選挙人名簿情報()) {
            投票資格情報.set投票区コード(宛名シール出力対象者一覧情報.get選挙人名簿情報().getTohyokuCode());
            投票資格情報.set頁(new RString(宛名シール出力対象者一覧情報.get選挙人名簿情報().getPage()));
            投票資格情報.set行(new RString(宛名シール出力対象者一覧情報.get選挙人名簿情報().getGyo()));
        }
        if (null != 宛名シール出力対象者一覧情報.get宛名PSM情報()) {
            AtenaMeisho 名称 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getMeisho();
            投票資格情報.set名称(名称 == null ? RString.EMPTY : 名称.getColumnValue());
            FlexibleDate 生年月日 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getSeinengappiYMD();
            if (null != 生年月日 && 生年月日.isValid()) {
                投票資格情報.set生年月日(new RDate(生年月日.toString()));
            }
            投票資格情報.set性別コード(宛名シール出力対象者一覧情報.get宛名PSM情報().getSeibetsuCode());
            YubinNo 住登内郵便番号 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getJutonaiYubinNo();
            投票資格情報.set住登内郵便番号(住登内郵便番号 == null ? RString.EMPTY : 住登内郵便番号.getColumnValue());
            投票資格情報.set住登内住所(宛名シール出力対象者一覧情報.get宛名PSM情報().getJutonaiJusho());
            AtenaBanchi 住登内番地 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getJutonaiBanchi();
            投票資格情報.set住登内番地(住登内番地 == null ? RString.EMPTY : 住登内番地.getColumnValue());
            Katagaki 住登内方書 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getJutonaiKatagaki();
            投票資格情報.set住登内方書(住登内方書 == null ? RString.EMPTY : 住登内方書.getColumnValue());
            投票資格情報.set識別コード(宛名シール出力対象者一覧情報.get宛名PSM情報().getShikibetsuCode());
            SetaiCode 世帯コード = 宛名シール出力対象者一覧情報.get宛名PSM情報().getSetaiCode();
            投票資格情報.set世帯コード(世帯コード == null ? RString.EMPTY : 世帯コード.getColumnValue());
            ChoikiCode 住登内町域コード = 宛名シール出力対象者一覧情報.get宛名PSM情報().getJutonaiChoikiCode();
            投票資格情報.set住登内町域コード(住登内町域コード == null ? RString.EMPTY : 住登内町域コード.getColumnValue());
            GyoseikuCode 行政区コード = 宛名シール出力対象者一覧情報.get宛名PSM情報().getGyoseikuCode();
            投票資格情報.set行政区コード(行政区コード == null ? RString.EMPTY : 行政区コード.getColumnValue());
            ChikuCode 地区コード１ = 宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuCode1();
            投票資格情報.set地区コード１(地区コード１ == null ? RString.EMPTY : 地区コード１.getColumnValue());
            ChikuCode 地区コード２ = 宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuCode2();
            投票資格情報.set地区コード２(地区コード２ == null ? RString.EMPTY : 地区コード２.getColumnValue());
            ChikuCode 地区コード３ = 宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuCode3();
            投票資格情報.set地区コード３(地区コード３ == null ? RString.EMPTY : 地区コード３.getColumnValue());
            投票資格情報.set行政区名(宛名シール出力対象者一覧情報.get宛名PSM情報().getGyoseikuName());
            投票資格情報.set地区名１(宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuName1());
            投票資格情報.set地区名２(宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuName2());
            投票資格情報.set地区名３(宛名シール出力対象者一覧情報.get宛名PSM情報().getChikuName3());
        }

        return 投票資格情報;
    }

    private TohyoJokyoJoho get転出者宛名シール_投票資格情報(AtenaSealSakuseiJyohouEntity 宛名シール出力対象者一覧情報) {
        TohyoJokyoJoho 投票資格情報 = new TohyoJokyoJoho();
        if (null != 宛名シール出力対象者一覧情報.get選挙人名簿情報()) {
            投票資格情報.set投票区コード(宛名シール出力対象者一覧情報.get選挙人名簿情報().getTohyokuCode());
            投票資格情報.set頁(new RString(宛名シール出力対象者一覧情報.get選挙人名簿情報().getPage()));
            投票資格情報.set行(new RString(宛名シール出力対象者一覧情報.get選挙人名簿情報().getGyo()));
        }
        if (null != 宛名シール出力対象者一覧情報.get宛名PSM情報()) {
            AtenaMeisho 名称 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getMeisho();
            投票資格情報.set名称(名称 == null ? RString.EMPTY : 名称.getColumnValue());
            FlexibleDate 生年月日 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getSeinengappiYMD();
            if (null != 生年月日 && 生年月日.isValid()) {
                投票資格情報.set生年月日(new RDate(生年月日.toString()));
            }
            投票資格情報.set性別コード(宛名シール出力対象者一覧情報.get宛名PSM情報().getSeibetsuCode());
            YubinNo 郵便番号 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getYubinNo();
            投票資格情報.set郵便番号(郵便番号 == null ? RString.EMPTY : 郵便番号.getColumnValue());
            AtenaJusho 住所 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getJusho();
            投票資格情報.set住所(住所 == null ? RString.EMPTY : 住所.getColumnValue());
            AtenaBanchi 番地 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getBanchi();
            投票資格情報.set番地(番地 == null ? RString.EMPTY : 番地.getColumnValue());
            Katagaki 方書 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getKatagaki();
            投票資格情報.set方書(方書 == null ? RString.EMPTY : 方書.getColumnValue());
            FlexibleDate 消除異動年月日 = 宛名シール出力対象者一覧情報.get宛名PSM情報().getShojoIdoYMD();
            if (null != 消除異動年月日 && 消除異動年月日.isValid()) {
                投票資格情報.set消除異動年月日(new RDate(消除異動年月日.toString()));
            }
        }

        return 投票資格情報;
    }

    private TohyoJokyoJoho get施設宛名シール_投票資格情報(AtenaSealSakuseiJyohouEntity 宛名シール出力対象者一覧情報) {
        TohyoJokyoJoho 投票資格情報 = new TohyoJokyoJoho();
        if (null != 宛名シール出力対象者一覧情報.get施設情報()) {
            投票資格情報.set名称(宛名シール出力対象者一覧情報.get施設情報().getShisetsuName());
            AtenaMeisho 施設宛名 = 宛名シール出力対象者一覧情報.get施設情報().getShisetsuAtena();
            投票資格情報.set施設宛名(施設宛名 == null ? RString.EMPTY : 施設宛名.getColumnValue());
            投票資格情報.set施設コード(宛名シール出力対象者一覧情報.get施設情報().getShisetsuCode());
            Code 施設種別 = 宛名シール出力対象者一覧情報.get施設情報().getShisetsuShubetsu();
            投票資格情報.set施設種別(施設種別 == null ? RString.EMPTY : 施設種別.getColumnValue());
            YubinNo 郵便番号 = 宛名シール出力対象者一覧情報.get施設情報().getYubinNo();
            投票資格情報.set施設情報郵便番号(郵便番号 == null ? RString.EMPTY : 郵便番号.getColumnValue());
            AtenaJusho 住所 = 宛名シール出力対象者一覧情報.get施設情報().getJusho();
            投票資格情報.set施設情報住所(住所 == null ? RString.EMPTY : 住所.getColumnValue());
            TelNo 電話番号 = 宛名シール出力対象者一覧情報.get施設情報().getTelNo();
            投票資格情報.set施設情報_電話番号(電話番号 == null ? RString.EMPTY : 電話番号.getColumnValue());
        }

        return 投票資格情報;
    }
}
