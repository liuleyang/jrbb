/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.TakeOutPcDataCaptureDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 持出端末データ取込のSpecです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public enum TakeOutPcDataCaptureSpec implements IPredicate<TakeOutPcDataCaptureDiv> {

    /**
     * グリッドの選択をチェックします。
     */
    取込対象ファイル必須チェック {
                @Override
                public boolean apply(TakeOutPcDataCaptureDiv div) {
                    return !div.getHdnUpLoad().isNullOrEmpty();
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    投票日確認 {
                @Override
                public boolean apply(TakeOutPcDataCaptureDiv div) {
                    List<RString> 共有ファイルlist = ViewStateHolder.get(ViewStateKeys.共有ファイル, List.class);
                    for (RString 共有ファイル : 共有ファイルlist) {
                        if (!共有ファイル.split(横線.toString()).get(1)
                        .equals(div.getHdnTohyoYMD())) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    投票区確認 {
                @Override
                public boolean apply(TakeOutPcDataCaptureDiv div) {
                    List<RString> 共有ファイルlist = ViewStateHolder.get(ViewStateKeys.共有ファイル, List.class);
                    for (RString 共有ファイル : 共有ファイルlist) {
                        if (!共有ファイル.split(横線.toString()).get(2).substring(0, 出力条件投票区の長).padLeft(new RString("0"), 出力条件投票区の長)
                        .equals(div.getHdnTohyokuCode().padLeft(new RString("0"), 出力条件投票区の長))) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    抄本ファイルチェック {
                @Override
                public boolean apply(TakeOutPcDataCaptureDiv div) {
                    List<RString> 共有ファイルlist = ViewStateHolder.get(ViewStateKeys.共有ファイル, List.class);
                    for (RString 共有ファイル : 共有ファイルlist) {
                        if (共有ファイル.split(横線.toString()).get(0).equals(抄本ファイル名)) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    /**
     * グリッドの選択をチェックします。
     */
    投票状況ファイルチェック {
                @Override
                public boolean apply(TakeOutPcDataCaptureDiv div) {
                    List<RString> 共有ファイルlist = ViewStateHolder.get(ViewStateKeys.共有ファイル, List.class);
                    for (RString 共有ファイル : 共有ファイルlist) {
                        if (共有ファイル.split(横線.toString()).get(0).equals(投票状況ファイル名)) {
                            return true;
                        }
                    }
                    return false;
                }
            };

    private static final RString 横線 = new RString("-");
    private static final int 出力条件投票区の長 = 4;

    private static final RString 抄本ファイル名 = new RString("ANShohon");

    private static final RString 投票状況ファイル名 = new RString("ANTohyojokyo");

}
