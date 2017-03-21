/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.SenkyoninMybatisParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJuriJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaKofuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoDiv;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.fuzaishatohyo.SenkyoninFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGME2010 不在者投票のチェックロジックです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public enum FuzaishaTohyoSpec implements IPredicate<FuzaishaTohyoDiv> {

    /**
     * 施設コード有無チェック。
     */
    施設コード有無チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    RString 施設コード = div.getFuzaishaJohoSearch().getCcdShisetsuCode().get施設コード();
                    ShisetsuManager manager = new ShisetsuManager();
                    return !RString.isNullOrEmpty(施設コード) || manager.get施設By施設コード(施設コード) != null;
                }
            },
    /**
     * 入場券確認をチェックします。
     */
    入場券確認チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    IBarCodeNyuryokuDiv barCodeDiv = div.getFuzaishaSenkyoninSearch().getCcdFuzaishaBarCode();
                    RString shohonNo = div.getFuzaishaSenkyoninSearch().getTxtHdnShohonNo();
                    if (!barCodeDiv.getBarCode().isEmpty()) {
                        return barCodeDiv.isMatchShohonNo(shohonNo);
                    }
                    return true;
                }
            },
    /**
     * 選挙人なしチェックします。
     */
    選挙人なしチェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    return div.getFuzaishaSenkyoninSearch().getDgFuzaishaSenkyoninSearch().getDataSource().size() > 0;
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    グリッドの選択チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    return !div.getFuzaishaTohyoJokyo().getDgFuzaishaTohyoJokyo().getSelectedItems().isEmpty();
                }
            },
    /**
     * 交付日と請求日の相関性チェックします。
     */
    交付日と請求日の相関性チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    FuzaishaKofuJohoDiv 交付Div = div.getFuzaishaTohyoJokyo().getFuzaishaKofuJoho();
                    if (!交付Div.isDisplayNone() && !交付Div.getTxtKofuYMD().isDisabled()) {
                        RDate 請求日 = div.getFuzaishaTohyoJokyo().getFuzaishaSeikyuJoho().getTxtSeikyuYMD().getValue();
                        RDate 交付日 = 交付Div.getTxtKofuYMD().getValue();
                        return null != 請求日 && null != 交付日 && 請求日.isBeforeOrEquals(交付日);
                    }
                    return true;
                }
            },
    /**
     * 交付日と受理日の相関性チェックします。
     */
    交付日と受理日の相関性チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    FuzaishaKofuJohoDiv 交付Div = div.getFuzaishaTohyoJokyo().getFuzaishaKofuJoho();
                    FuzaishaJuriJohoDiv 受理Div = div.getFuzaishaTohyoJokyo().getFuzaishaJuriJoho();
                    if (!交付Div.isDisplayNone() && !受理Div.isDisplayNone()) {
                        RDate 交付日 = 交付Div.getTxtKofuYMD().getValue();
                        RDate 受理日 = 受理Div.getTxtJuriYMD().getValue();
                        return null != 受理日 && null != 交付日 && 交付日.isBeforeOrEquals(受理日);
                    }
                    return true;
                }
            },
    /**
     * 選挙人の存在性チェックします。
     */
    選挙人の存在性チェック {
                @Override
                public boolean apply(FuzaishaTohyoDiv div) {
                    RString shohonNo = div.getFuzaishaSenkyoninSearch().getTxtHdnShohonNo();
                    RString 識別コードHdn = div.getFuzaishaSenkyoninSearch().getTxtHdnShikibetsuCodeList();
                    List<RString> 識別コードリスト = 識別コードHdn.split(RString.FULL_SPACE.toString());
                    ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                            createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
                    SenkyoninMybatisParameter param = new SenkyoninMybatisParameter(
                            false, new ShohonNo(shohonNo), 識別コードリスト, RString.EMPTY, key.getPSM検索キー());
                    List<SenkyoninSearchResult> searchResult = SenkyoninFinder.createInstance().getSenkyoninListByShikibetsuCode(param);

                    return null != searchResult && !searchResult.isEmpty();
                }
            };
}
