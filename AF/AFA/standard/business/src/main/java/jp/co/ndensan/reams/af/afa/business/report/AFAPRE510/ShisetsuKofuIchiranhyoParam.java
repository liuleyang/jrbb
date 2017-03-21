/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE510;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のパラメータクラスです。
 *
 * @reamsid_L AF-0280-027 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShisetsuKofuIchiranhyoParam {

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
    private final int page;
    private final SenkyoNo 選挙番号;
    private final RString 選挙名称;
    private final RString 施設コード;
    private final RString 施設名称;
    private final RString 住所;
    private final Integer 請求人数;
    private final FlexibleDate 交付年月日;
    private final FlexibleDate 受理年月日;
    private final Integer 受理人数;

    private ShisetsuKofuIchiranhyoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            int page,
            SenkyoNo 選挙番号,
            RString 選挙名称,
            RString 施設コード,
            RString 施設名称,
            RString 住所,
            Integer 請求人数,
            FlexibleDate 交付年月日,
            FlexibleDate 受理年月日,
            Integer 受理人数
    ) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.page = page;
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;
        this.施設コード = 施設コード;
        this.施設名称 = 施設名称;
        this.住所 = 住所;
        this.請求人数 = 請求人数;
        this.交付年月日 = 交付年月日;
        this.受理年月日 = 受理年月日;
        this.受理人数 = 受理人数;
    }

    private ShisetsuKofuIchiranhyoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            int page,
            SenkyoNo 選挙番号,
            RString 選挙名称,
            RString 施設コード,
            RString 施設名称,
            RString 住所,
            Integer 請求人数,
            FlexibleDate 交付年月日) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.page = page;
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;
        this.施設コード = 施設コード;
        this.施設名称 = 施設名称;
        this.住所 = 住所;
        this.請求人数 = 請求人数;
        this.交付年月日 = 交付年月日;
        this.受理年月日 = null;
        this.受理人数 = null;

    }

    private ShisetsuKofuIchiranhyoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            int page,
            SenkyoNo 選挙番号,
            RString 選挙名称,
            FlexibleDate 受理年月日,
            Integer 受理人数) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.page = page;
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;
        this.施設コード = null;
        this.施設名称 = null;
        this.住所 = null;
        this.請求人数 = null;
        this.交付年月日 = null;
        this.受理年月日 = 受理年月日;
        this.受理人数 = 受理人数;
    }

    /**
     * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のパラメータbuilderクラスです。
     *
     */
    public static class ShisetsuKofuIchiranhyoParamBuilder {

        private static final int ONE_PAGE_COUNT = 25;

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;

        private int count;
        private SenkyoNo 選挙番号;
        private RString 選挙名称;
        private RString 施設コード;
        private RString 施設名称;
        private RString 住所;
        private Integer 請求人数;
        private FlexibleDate 交付年月日;
        private List<FlexibleDate> 受理年月日リスト;
        private List<Integer> 受理人数リスト;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         *
         */
        public ShisetsuKofuIchiranhyoParamBuilder(ZenjitsuCommonJohoItem 選挙帳票共通情報) {

            this.選挙帳票共通情報 = 選挙帳票共通情報;
            this.count = -1;
            選挙番号 = null;
            選挙名称 = null;
            施設コード = null;
            施設名称 = null;
            住所 = null;
            請求人数 = 0;
            交付年月日 = null;
            受理年月日リスト = null;
            受理人数リスト = null;

        }

        /**
         * パラメータを作成します。
         *
         * @param 選挙 AfT111SenkyoEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 施設 AfT507ShisetsuEntity
         * @return List<ShisetsuKofuIchiranhyoParam>
         */
        public List<ShisetsuKofuIchiranhyoParam> getParam(AfT111SenkyoEntity 選挙, AfT201TohyoJokyoEntity 投票状況,
                AfT507ShisetsuEntity 施設) {
            List<ShisetsuKofuIchiranhyoParam> rslt = null;

            if (count >= 0) {
                if (選挙番号.equals(投票状況.getSenkyoNo())
                        && 施設コード.equals(投票状況.getShisetsuCode())
                        && equlaFlexibleDate(交付年月日, 投票状況.getKofuYMD())) {
                    請求人数++;
                    int 受理年月日リストLastIndex = 受理年月日リスト.size() - 1;
                    FlexibleDate 受理年月日 = 投票状況.getJuriYMD();
                    //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 9 LINES
                    if (受理年月日 != null) {
                        if (equlaFlexibleDate(受理年月日リスト.get(受理年月日リストLastIndex), 受理年月日)) {
                            受理人数リスト.set(受理年月日リストLastIndex, 受理人数リスト.get(受理年月日リストLastIndex) + 1);
                        } else {
                            受理年月日リスト.add(受理年月日);
                            受理人数リスト.add(1);
                        }
                    }
                    return rslt;
                }
                rslt = getParam();
                if (!選挙番号.equals(投票状況.getSenkyoNo())) {
                    pageBreak();
                }

            } else {
                count++;
            }
            init(選挙, 投票状況, 施設);

            return rslt;
        }

        private void init(AfT111SenkyoEntity 選挙, AfT201TohyoJokyoEntity 投票状況,
                AfT507ShisetsuEntity 施設) {
            選挙番号 = 投票状況.getSenkyoNo();
            選挙名称 = 選挙.getSenkyoName();
            施設コード = 投票状況.getShisetsuCode();
            施設名称 = 施設.getShisetsuName();
            AtenaJusho jusho = 施設.getJusho();
            住所 = jusho == null ? RString.EMPTY : jusho.getColumnValue();
            請求人数 = 1;
            交付年月日 = 投票状況.getKofuYMD();
            受理年月日リスト = new ArrayList<>();
            受理年月日リスト.add(投票状況.getJuriYMD());
            受理人数リスト = new ArrayList<>();
            受理人数リスト.add(1);

        }

        /**
         * 最後のパラメータを作成します。
         *
         * @return List<ShisetsuKofuIchiranhyoParam>
         */
        public List<ShisetsuKofuIchiranhyoParam> getLastParam() {
            if (count >= 0) {
                return getParam();
            }
            return new ArrayList<>();
        }

        private List<ShisetsuKofuIchiranhyoParam> getParam() {
            List<ShisetsuKofuIchiranhyoParam> rslt = new ArrayList<>();
            if (受理年月日リスト.size() == 1) {
                rslt.add(new ShisetsuKofuIchiranhyoParam(選挙帳票共通情報,
                        count++ / ONE_PAGE_COUNT,
                        選挙番号,
                        選挙名称,
                        施設コード,
                        施設名称,
                        住所,
                        交付年月日 == null ? null : 請求人数,
                        交付年月日,
                        受理年月日リスト.get(0),
                        受理人数リスト.get(0)));
            } else {
                rslt.add(new ShisetsuKofuIchiranhyoParam(選挙帳票共通情報,
                        count++ / ONE_PAGE_COUNT,
                        選挙番号,
                        選挙名称,
                        施設コード,
                        施設名称,
                        住所,
                        交付年月日 == null ? null : 請求人数,
                        交付年月日));

                for (int i = 0; i < 受理年月日リスト.size(); i++) {
                    rslt.add(new ShisetsuKofuIchiranhyoParam(選挙帳票共通情報,
                            count++ / ONE_PAGE_COUNT,
                            選挙番号,
                            選挙名称,
                            受理年月日リスト.get(i),
                            受理人数リスト.get(i)));

                }
            }
            return rslt;
        }

        private void pageBreak() {
            count = (((count - 1) / ONE_PAGE_COUNT) + 1) * ONE_PAGE_COUNT;
        }

        private boolean equlaFlexibleDate(FlexibleDate date1, FlexibleDate date2) {
            if (date1 == null) {
                return date2 == null;
            }
            return date1.equals(date2);
        }
    }

}
