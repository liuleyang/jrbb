package jp.co.ndensan.reams.af.afa.service.report.AFAPRE213;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.entity.db.relate.atenasealsakusei.AtenaSealSakuseiJyohouEntity;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSeal12PrintEditor {

    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");

    /**
     * 宛名シール21面
     *
     * @param atenaSealPartParam AtenaSealPartParam
     * @param entity AtenaSealSakuseiJyohouEntity
     * @param 画面ID RString
     * @return AtenaSealPartParam
     */
    public AtenaSealPartParam eidtAtenaSealPartParam(AtenaSealPartParam atenaSealPartParam,
            AtenaSealSakuseiJyohouEntity entity,
            RString 画面ID) {
        YubinNo 郵便番号 = YubinNo.EMPTY;
        AtenaJusho 住所 = AtenaJusho.EMPTY;
        AtenaBanchi 番地 = AtenaBanchi.EMPTY;
        Katagaki 方書 = Katagaki.EMPTY;
        if (選挙人宛名シール_画面ID.equals(画面ID) && entity.get宛名PSM情報() != null) {
            郵便番号 = entity.get宛名PSM情報().getJutonaiYubinNo();
            住所 = RString.isNullOrEmpty(entity.get宛名PSM情報().getJutonaiJusho())
                    ? AtenaJusho.EMPTY : new AtenaJusho(entity.get宛名PSM情報().getJutonaiJusho());
            番地 = entity.get宛名PSM情報().getJutonaiBanchi();
            方書 = entity.get宛名PSM情報().getJutonaiKatagaki();
        } else if (転出者宛名シール_画面ID.equals(画面ID) && entity.get宛名PSM情報() != null) {
            郵便番号 = entity.get宛名PSM情報().getYubinNo();
            住所 = entity.get宛名PSM情報().getJusho();
            番地 = entity.get宛名PSM情報().getBanchi();
            方書 = entity.get宛名PSM情報().getKatagaki();
        } else if (施設宛名シール_画面ID.equals(画面ID) && entity.get宛名PSM情報() != null) {
            郵便番号 = entity.get宛名PSM情報().getYubinNo();
            住所 = entity.get宛名PSM情報().getJusho();
            番地 = AtenaBanchi.EMPTY;
            方書 = Katagaki.EMPTY;
        }
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        atenaSealPartParam.setCustomBarCode(nyujoken3tsuori.getCustomBarCode(郵便番号, 住所, 番地, 方書));
        return atenaSealPartParam;
    }
}
