/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import java.util.UUID;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ICharacterConvertable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ReamsUnicodeToUnicodeConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.externalcharacter.UnicodeCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.UnicodeCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 共通メッソド
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class MochidashiPcCommonUtil {

    private final ICharacterConvertable<RString, RString> converter;

    /**
     * {@link InstanceProvider#create}にて生成した{@link MochidashiPcCommonUtil}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MochidashiPcCommonUtil}のインスタンス
     */
    public static MochidashiPcCommonUtil createInstance() {
        return new MochidashiPcCommonUtil();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MochidashiPcCommonUtil}のインスタンスを返します。
     *
     *
     */
    public MochidashiPcCommonUtil() {
        UnicodeCharacterConvertParameter convertParameter = new UnicodeCharacterConvertParameterBuilder(new RecordConvertMaterial(
                new CharacterConvertTable(new RString("UnicodeMs51"), true), CharacterAttribute.漢字))
                .enabledConvertError(false) // デフォルト値：true
                .errorReplaceCharacter(new RString("▲")) // デフォルト値：？
                .build();
        converter = new ReamsUnicodeToUnicodeConverter(convertParameter);
    }

    /**
     * toRString
     *
     * @param kanji FlexibleDate
     * @return RString
     */
    public RString convertTtoRString(RString kanji) {
        if (RString.isNullOrEmpty(kanji)) {
            kanji = RString.EMPTY;
        }
        converter.convert(kanji);
        return converter.convert(kanji);
    }

    /**
     * toRString
     *
     * @param date FlexibleDate
     * @return RString
     */
    public RString toRString(FlexibleDate date) {
        if (null == date || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    /**
     * toRString
     *
     * @param code Code
     * @return RString
     */
    public RString toRString(Code code) {
        if (null == code || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param no ShohonNo
     * @return RString
     */
    public RString toRString(ShohonNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no.value());
    }

    /**
     * toRString
     *
     * @param no SenkyoNo
     * @return RString
     */
    public RString toRString(SenkyoNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no.value());
    }

    /**
     * toRString
     *
     * @param no YubinNo
     * @return RString
     */
    public RString toRString(YubinNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return no.getYubinNo();
    }

    /**
     * toRString
     *
     * @param code ChoikiCode
     * @return RString
     */
    public RString toRString(ChoikiCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code GyoseikuCode
     * @return RString
     */
    public RString toRString(GyoseikuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code SubGyomuCode
     * @return RString
     */
    public RString toRString(SubGyomuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code CodeShubetsu
     * @return RString
     */
    public RString toRString(CodeShubetsu code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code ChikuCode
     * @return RString
     */
    public RString toRString(ChikuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code BanchiCode
     * @return RString
     */
    public RString toRString(BanchiCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code BanchiCode
     * @return RString
     */
    public RString toRString(SetaiCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param atenaBanchi ChikuCode
     * @return RString
     */
    public RString toRString(AtenaBanchi atenaBanchi) {
        if (null == atenaBanchi) {
            return RString.EMPTY;
        }
        return atenaBanchi.value();
    }

    /**
     * toRString
     *
     * @param code ShikibetsuCode
     * @return RString
     */
    public RString toRString(ShikibetsuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param katagaki Katagaki
     * @return RString
     */
    public RString toRString(Katagaki katagaki) {
        if (null == katagaki) {
            return RString.EMPTY;
        }
        return katagaki.value();
    }

    /**
     * toRString
     *
     * @param zenkokuJushoCode ZenkokuJushoCode
     * @return RString
     */
    public RString toRString(ZenkokuJushoCode zenkokuJushoCode) {
        if (null == zenkokuJushoCode) {
            return RString.EMPTY;
        }
        return zenkokuJushoCode.value();
    }

    /**
     * toRString
     *
     * @param code LasdecCode
     * @return RString
     */
    public RString toRString(LasdecCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code TsuzukigaraCode
     * @return RString
     */
    public RString toRString(TsuzukigaraCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param jusho AtenaJusho
     * @return RString
     */
    public RString toRString(AtenaJusho jusho) {
        if (null == jusho) {
            return RString.EMPTY;
        }
        return jusho.value();
    }

    /**
     * toRString
     *
     * @param meisho AtenaMeisho
     * @return RString
     */
    public RString toRString(AtenaMeisho meisho) {
        if (null == meisho) {
            return RString.EMPTY;
        }
        return meisho.value();
    }

    /**
     * toRString
     *
     * @param kanaMeisho AtenaKanaMeisho
     * @return RString
     */
    public RString toRString(AtenaKanaMeisho kanaMeisho) {
        if (null == kanaMeisho) {
            return RString.EMPTY;
        }
        return kanaMeisho.value();
    }

    /**
     * toRString
     *
     * @param time RDateTime
     * @return RString
     */
    public RString toRString(RDateTime time) {
        if (null == time) {
            return RString.EMPTY;
        }
        return new RString(time.toString());
    }

    /**
     * toRString
     *
     * @param time RTime
     * @return RString
     */
    public RString toRString(RTime time) {
        if (null == time) {
            return RString.EMPTY;
        }
        return time.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
    }

    /**
     * toRString
     *
     * @param integer Integer
     * @return RString
     */
    public RString toRString(Integer integer) {
        if (null == integer) {
            return RString.EMPTY;
        }
        return new RString(integer);
    }

    /**
     * toRString
     *
     * @param str String
     * @return RString
     */
    public RString toRString(String str) {
        if (null == str) {
            return RString.EMPTY;
        }
        return new RString(str);
    }

    /**
     * toRString
     *
     * @param uuid UUID
     * @return RString
     */
    public RString toRString(UUID uuid) {
        if (null == uuid) {
            return RString.EMPTY;
        }
        return new RString(uuid.toString());
    }

    /**
     * toRString
     *
     * @param rString RString
     * @return RString
     */
    public RString nullToRString(RString rString) {
        if (RString.isNullOrEmpty(rString)) {
            return RString.EMPTY;
        }
        return rString;
    }

    /**
     * toRString
     *
     * @param flg Boolean
     * @return RString
     */
    public RString booleanToRString(Boolean flg) {
        if (null == flg) {
            return RString.EMPTY;
        }
        if (flg) {
            return new RString(1);
        }
        return new RString(0);
    }

    /**
     * toRString
     *
     * @param str RString
     * @param length RString
     * @return RString
     */
    public RString subRString(RString str, Integer length) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        if (str.length() > length) {
            str = str.substring(0, length);
        }
        return str;
    }

    /**
     * toRString
     *
     * @param str RString
     * @param length RString
     * @return RString
     */
    public RString subRStringRight(RString str, Integer length) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        if (str.length() > length) {
            str = str.substring(length);
        }
        return str;
    }

    /**
     * toRString
     *
     * @param str RString
     * @return RString
     */
    public RString padZeroToLeft(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        str = str.padZeroToLeft(MochidashiPcCreateDataEnum.FOUR.getInteger());
        return str;
    }

}
