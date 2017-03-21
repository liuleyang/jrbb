/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE509;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表のパラメータクラスです。
 *
 * @reamsid_L AF-0280-026 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JurijokyoIchiranhyoParam {

    private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
    private final int page;
    private final List<RString> 選挙名称リスト;
    private final List<AfT201TohyoJokyoEntity> 投票状況リスト;
    private final AfT112SenkyoninMeiboEntity 選挙人名簿;
    private final RString 氏名;
    private final RString 作成条件;

    private JurijokyoIchiranhyoParam(ZenjitsuCommonJohoItem 選挙帳票共通情報,
            int page,
            List<RString> 選挙名称リスト,
            List<AfT201TohyoJokyoEntity> 投票状況リスト,
            AfT112SenkyoninMeiboEntity 選挙人名簿,
            RString 氏名,
            RString 作成条件) {
        this.選挙帳票共通情報 = 選挙帳票共通情報;
        this.page = page;
        this.選挙名称リスト = 選挙名称リスト;
        this.投票状況リスト = 投票状況リスト;
        this.選挙人名簿 = 選挙人名簿;
        this.氏名 = 氏名;
        this.作成条件 = 作成条件;
    }

    /**
     * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表のパラメータbuilderクラスです。
     *
     */
    public static class JurijokyoIchiranhyoParamBuilder {

        private static final int 選挙列 = 9;
        private static final int ONE_PAGE_COUNT = 25;
        private static final RString 作成条件_ヘッダ = new RString("受理日：");
        private static final RString 作成条件_中 = new RString("～");

        private final ZenjitsuCommonJohoItem 選挙帳票共通情報;
        private final List<SenkyoNo> 選挙番号リスト;
        private final List<RString> 選挙名称リスト;
        private final RString 作成条件;

        private int count;
        private List<AfT201TohyoJokyoEntity> 投票状況リスト;
        private AfT112SenkyoninMeiboEntity 選挙人名簿;
        private RString 氏名;

        /**
         * コンストラクタです。
         *
         * @param 選挙帳票共通情報 ZenjitsuCommonJohoItem
         * @param 選挙番号リスト List<SenkyoNo>
         * @param 選挙名称リスト List<RString>
         * @param 受理日From FlexibleDate
         * @param 受理日To FlexibleDate
         */
        public JurijokyoIchiranhyoParamBuilder(ZenjitsuCommonJohoItem 選挙帳票共通情報,
                List<SenkyoNo> 選挙番号リスト,
                List<RString> 選挙名称リスト,
                FlexibleDate 受理日From,
                FlexibleDate 受理日To) {

            this.選挙帳票共通情報 = 選挙帳票共通情報;
            this.count = -1;
            this.選挙番号リスト = 選挙番号リスト;
            if (!受理日From.isEmpty()) {
                this.作成条件 = 作成条件_ヘッダ.concat(受理日From.wareki().toDateString()).concat(作成条件_中).concat(受理日To.wareki().toDateString());
            } else {
                this.作成条件 = RString.EMPTY;
            }
            this.init(null, null);
            this.選挙名称リスト = 選挙名称リスト;
        }

        /**
         * パラメータを作成します。
         *
         * @param 選挙 AfT111SenkyoEntity
         * @param 投票状況 AfT201TohyoJokyoEntity
         * @param 選挙人名簿 AfT112SenkyoninMeiboEntity
         * @param 宛名識別対象 IShikibetsuTaisho
         * @return JurijokyoIchiranhyoParam
         */
        public JurijokyoIchiranhyoParam getParam(AfT111SenkyoEntity 選挙,
                AfT201TohyoJokyoEntity 投票状況,
                AfT112SenkyoninMeiboEntity 選挙人名簿,
                IShikibetsuTaisho 宛名識別対象) {

            JurijokyoIchiranhyoParam rslt = null;
            if (this.選挙人名簿 != null) {
                if (equalsKeys(this.選挙人名簿, 選挙人名簿)) {
                    setリスト(選挙, 投票状況);
                    return rslt;
                }
                rslt = new JurijokyoIchiranhyoParam(this.選挙帳票共通情報,
                        this.count / ONE_PAGE_COUNT + 1,
                        this.選挙名称リスト,
                        this.投票状況リスト,
                        this.選挙人名簿,
                        this.氏名,
                        this.作成条件);
            }
            init(選挙人名簿, 宛名識別対象);
            setリスト(選挙, 投票状況);
            return rslt;
        }

        /**
         * 最後のパラメータを作成します。
         *
         * @return JurijokyoIchiranhyoParam
         */
        public JurijokyoIchiranhyoParam getLastParam() {
            if (this.選挙人名簿 != null) {
                return new JurijokyoIchiranhyoParam(this.選挙帳票共通情報,
                        this.count / ONE_PAGE_COUNT + 1,
                        this.選挙名称リスト,
                        this.投票状況リスト,
                        this.選挙人名簿,
                        this.氏名,
                        this.作成条件);
            }
            return null;
        }

        private void init(AfT112SenkyoninMeiboEntity 選挙人名簿, IShikibetsuTaisho 宛名識別対象) {
            投票状況リスト = new ArrayList<>();
            for (int i = 0; i < 選挙番号リスト.size() || i < 選挙列; i++) {
                投票状況リスト.add(null);
            }
            this.選挙人名簿 = 選挙人名簿;
            this.氏名 = 宛名識別対象 == null ? RString.EMPTY : 宛名識別対象.get名称().getName().getColumnValue();
            count++;
        }

        private void setリスト(AfT111SenkyoEntity 選挙, AfT201TohyoJokyoEntity 投票状況) {
            int index = 選挙番号リスト.lastIndexOf(選挙.getSenkyoNo());
            if (index != -1) {
                投票状況リスト.set(index, 投票状況);
            }
        }

        private boolean equalsKeys(AfT112SenkyoninMeiboEntity entity, AfT112SenkyoninMeiboEntity entityOther) {
            return entity.getShohonNo().equals(entityOther.getShohonNo())
                    && entity.getTohyokuCode().equals(entityOther.getTohyokuCode())
                    && (BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体).equals(抄本_冊区分管理_使用しない.getValue())
                    || Objects.equals(entity.getSatsu(), entityOther.getSatsu()))
                    && entity.getPage() == entityOther.getPage()
                    && entity.getGyo() == entityOther.getGyo();
        }

    }
}
