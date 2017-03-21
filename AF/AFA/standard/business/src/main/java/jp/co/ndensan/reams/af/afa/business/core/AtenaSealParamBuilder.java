/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 * 宛名シール
 *
 * @reamsid_L AF-0620-032 wangm
 */
public class AtenaSealParamBuilder {

    private static final int COUNT12面 = 12;
    private static final int COUNT21面 = 21;

    private final Association 地方公共団体情報;
    private final RString 画面ID;

    private List<AtenaSealPartParam> paramList;
    private int pageCount;
    private int count;

    /**
     * コンストラクタです。
     *
     * @param 地方公共団体情報 Association
     * @param 画面ID RString
     */
    public AtenaSealParamBuilder(Association 地方公共団体情報, RString 画面ID) {
        this.地方公共団体情報 = 地方公共団体情報;
        this.画面ID = 画面ID;
        paramList = new ArrayList<>();
        pageCount = 0;
        count = 0;
    }

    /**
     * データを追加します。
     *
     * @param senkyoninMeiboEntity AfT112SenkyoninMeiboEntity
     * @param shikibetsuTaishoEntity UaFt200FindShikibetsuTaishoEntity
     * @return AtenaSeal21Param
     */
    public AtenaSeal21Param addDataForAtenaSeal21Param(AfT112SenkyoninMeiboEntity senkyoninMeiboEntity,
            UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity) {

        addData(senkyoninMeiboEntity, shikibetsuTaishoEntity);
        if (count % COUNT21面 == 0) {
            AtenaSeal21Param param = new AtenaSeal21Param(地方公共団体情報, 画面ID);
            param.set頁番号(++pageCount);
            int i = 0;
            param.setParam1(paramList.get(i++));
            param.setParam2(paramList.get(i++));
            param.setParam3(paramList.get(i++));
            param.setParam4(paramList.get(i++));
            param.setParam5(paramList.get(i++));
            param.setParam6(paramList.get(i++));
            param.setParam7(paramList.get(i++));
            param.setParam8(paramList.get(i++));
            param.setParam9(paramList.get(i++));
            param.setParam10(paramList.get(i++));
            param.setParam11(paramList.get(i++));
            param.setParam12(paramList.get(i++));
            param.setParam13(paramList.get(i++));
            param.setParam14(paramList.get(i++));
            param.setParam15(paramList.get(i++));
            param.setParam16(paramList.get(i++));
            param.setParam17(paramList.get(i++));
            param.setParam18(paramList.get(i++));
            param.setParam19(paramList.get(i++));
            param.setParam20(paramList.get(i++));
            param.setParam21(paramList.get(i++));
            paramList = new ArrayList<>();
            return param;
        }
        return null;
    }

    /**
     * 最終操作です。
     *
     * @return AtenaSeal21Param
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 100 LINES
    public AtenaSeal21Param lastForAtenaSeal21Param() {

        if (!paramList.isEmpty()) {
            AtenaSeal21Param param = new AtenaSeal21Param(地方公共団体情報, 画面ID);
            param.set頁番号(++pageCount);
            int i = 0;
            param.setParam1(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam2(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam3(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam4(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam5(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam6(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam7(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam8(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam9(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam10(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam11(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam12(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam13(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam14(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam15(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam16(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam17(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam18(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam19(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam20(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam21(paramList.get(i++));

            return param;
        }
        return null;
    }

    /**
     * データを追加します。
     *
     * @param senkyoninMeiboEntity AfT112SenkyoninMeiboEntity
     * @param shikibetsuTaishoEntity UaFt200FindShikibetsuTaishoEntity
     * @return AtenaSeal12Param
     */
    public AtenaSeal12Param addDataForAtenaSeal12Param(AfT112SenkyoninMeiboEntity senkyoninMeiboEntity,
            UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity) {
        addData(senkyoninMeiboEntity, shikibetsuTaishoEntity);
        if (count % COUNT12面 == 0) {
            AtenaSeal12Param param = new AtenaSeal12Param(地方公共団体情報, 画面ID);
            param.set頁番号(++pageCount);
            int i = 0;
            param.setParam1(paramList.get(i++));
            param.setParam2(paramList.get(i++));
            param.setParam3(paramList.get(i++));
            param.setParam4(paramList.get(i++));
            param.setParam5(paramList.get(i++));
            param.setParam6(paramList.get(i++));
            param.setParam7(paramList.get(i++));
            param.setParam8(paramList.get(i++));
            param.setParam9(paramList.get(i++));
            param.setParam10(paramList.get(i++));
            param.setParam11(paramList.get(i++));
            param.setParam12(paramList.get(i++));
            paramList = new ArrayList<>();
            return param;
        }
        return null;
    }

    /**
     * 最終操作です。
     *
     * @return AtenaSeal12Param
     */
    public AtenaSeal12Param lastForAtenaSeal12Param() {

        if (!paramList.isEmpty()) {
            AtenaSeal12Param param = new AtenaSeal12Param(地方公共団体情報, 画面ID);
            param.set頁番号(++pageCount);
            int i = 0;
            param.setParam1(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam2(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam3(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam4(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam5(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam6(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam7(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam8(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam9(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam10(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam11(paramList.get(i++));
            if (i == paramList.size()) {
                return param;
            }
            param.setParam12(paramList.get(i++));

            return param;
        }
        return null;
    }

    private void addData(AfT112SenkyoninMeiboEntity senkyoninMeiboEntity, UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity) {
        AtenaSealPartParam param = new AtenaSealPartParam();
        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(shikibetsuTaishoEntity);
        senkyoninTohyoJokyoEntity.setSenkyoninMeiboEntity(senkyoninMeiboEntity);
        param.set投票資格情報(senkyoninTohyoJokyoEntity);
        param.set通し番号(new RString(++count));
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoEntity);
        IJusho 住所 = kojin.get住所();
        param.setCustomBarCode(getCustomBarCode(住所.get郵便番号(), 住所.get住所(), 住所.get番地().getBanchi(), 住所.get方書()));
        paramList.add(param);
    }

    private RString getCustomBarCode(YubinNo 郵便番号, RString 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString 住所_変換後 = NullHandler.getNullToRString(住所);
        RString 番地_変換後 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : NullHandler.getNullToRString(番地.value());
        RString 方書_変換後 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : NullHandler.getNullToRString(方書.value());
        RString 編集用住所 = 住所_変換後.concat(番地_変換後).replace(RString.HALF_SPACE, RString.EMPTY).concat(RString.FULL_SPACE).concat(方書_変換後);
        CustomerBarCode barcode = new CustomerBarCode();
        CustomerBarCodeResult result
                = barcode.convertCustomerBarCode(郵便番号 == null ? RString.EMPTY : 郵便番号.getYubinNo(), 編集用住所);
        return result.getCustomerBarCode();
    }

}
