/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.definition.core.TohyouSha;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;

/**
 * {@link KijitsumaeTohyorokuReportSource}を編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuThreeMaiFirstEditor extends KijitsumaeTohyorokuCommon implements IKijitsumaeTohyorokuEditor {

    private final TohyorokuChohyo item;

    /**
     * コンストラクタです。
     *
     * @param item {@link TohyorokuChohyo}
     */
    public KijitsumaeTohyorokuThreeMaiFirstEditor(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public KijitsumaeTohyorokuReportSource edit(KijitsumaeTohyorokuReportSource source) {
        set帳票情報(source);
        source.layout = KijitsumaeTohyorokuReportSource.Layouts.AFAPRE506_KijitsumaeTohyoroku3mai1;
        return source;
    }

    private void set帳票情報(KijitsumaeTohyorokuReportSource source) {
        if (this.isLastFlg()) {
            set投票基本情報(source);
            set選任リスト(source);
            set投票管理者リスト(source);
            set再交付者リスト(source);
            set決定投票者リスト(source);
            set返還者リスト(source);
        }
    }

    private void set投票基本情報(KijitsumaeTohyorokuReportSource source) {
        source.shikkoYmd = getKanjiYmd(item.get執行年月日());
        source.title = item.getタイトル().concat(タイトル_期日前投票所投票録);
        source.tohyoYmd = getKanjiYmd(item.get投票年月日());
        source.secchiJokyo = item.get設置状況();
        source.tohyoBasho = item.get投票場所();
        if ((null != item.get投票期間_開始年月日() && !item.get投票期間_開始年月日().isEmpty())
                || (null != item.get投票期間_終了年月日() && !item.get投票期間_終了年月日().isEmpty())) {
            source.tohyoKikan = getKanjiYmd(item.get投票期間_開始年月日())
                    .concat(から)
                    .concat(getKanjiYmd(item.get投票期間_終了年月日()));
        } else {
            source.tohyoKikan = getKanjiYmd(item.get投票期間_開始年月日())
                    .concat(getKanjiYmd(item.get投票期間_終了年月日()));
        }
        source.tohyoJikokuStart = getFormatTimeKanji(item.get投票時刻開始());
        source.tohyoJikokuEnd = getFormatTimeKanji(item.get投票時刻閉鎖());
        source.tohyoshaMan = getFormatNumber(item.get投票者男数());
        source.kariTohyoshaMan = getFormatNumber(item.get仮投票者男数());
        source.tohyoshaWoman = getFormatNumber(item.get投票者女数());
        source.kariTohyoshaWoman = getFormatNumber(item.get仮投票者女数());
        source.tohyoshaKei = getFormatNumber(item.get投票者合計());
        source.kariTohyoshaKei = getFormatNumber(item.get仮投票者合計());
        source.tenji = getFormatNumber(item.get点字投票者数());
    }

    private void set選任リスト(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 選任リスト = item.get選任リスト();
        if (null == 選任リスト || 選任リスト.isEmpty()) {
            return;
        }
        TohyouSha 選任;
        if (選任リスト.size() >= TohyoshaIndex.選任者1.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者1.getListIndex());
            source.toha1 = 選任.get党派();
            source.shimei1Jo = getSubString(選任.get氏名(), 氏名_上段表示可能数, true);
            source.shimei1Ge = getSubString(選任.get氏名(), 氏名_上段表示可能数, false);
            source.senninYmd1Jo = getSubFlexibleDate(選任.get選任年月日(), true);
            source.senninYmd1Ge = getSubFlexibleDate(選任.get選任年月日(), false);
            source.tachiaiJikan1Jo = getFormatTimeKanji(選任.get立会時間開始());
            if (null != 選任.get立会時間開始() || null != 選任.get立会時間終了()) {
                source.tachiaiJikan1Ge
                        = から.concat(getFormatTimeKanji(選任.get立会時間終了()));
            }
            source.sankaiJikoku1 = getFormatTimeKanji(選任.get参会時刻());
            source.jishokuJikoku1 = getFormatTimeKanji(選任.get辞職時刻());
            source.jishokuRiyu1 = 選任.get事由();
        }

        if (選任リスト.size() >= TohyoshaIndex.選任者2.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者2.getListIndex());
            source.toha2 = 選任.get党派();
            source.shimei2Jo = getSubString(選任.get氏名(), 氏名_上段表示可能数, true);
            source.shimei2Ge = getSubString(選任.get氏名(), 氏名_上段表示可能数, false);
            source.senninYmd2Jo = getSubFlexibleDate(選任.get選任年月日(), true);
            source.senninYmd2Ge = getSubFlexibleDate(選任.get選任年月日(), false);
            source.tachiaiJikan2Jo = getFormatTimeKanji(選任.get立会時間開始());
            if (null != 選任.get立会時間開始() || null != 選任.get立会時間終了()) {
                source.tachiaiJikan2Ge
                        = から.concat(getFormatTimeKanji(選任.get立会時間終了()));
            }
            source.sankaiJikoku2 = getFormatTimeKanji(選任.get参会時刻());
            source.jishokuJikoku2 = getFormatTimeKanji(選任.get辞職時刻());
            source.jishokuRiyu2 = 選任.get事由();
        }

        if (選任リスト.size() >= TohyoshaIndex.選任者3.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者3.getListIndex());
            source.toha3 = 選任.get党派();
            source.shimei3Jo = getSubString(選任.get氏名(), 氏名_上段表示可能数, true);
            source.shimei3Ge = getSubString(選任.get氏名(), 氏名_上段表示可能数, false);
            source.senninYmd3Jo = getSubFlexibleDate(選任.get選任年月日(), true);
            source.senninYmd3Ge = getSubFlexibleDate(選任.get選任年月日(), false);
            source.tachiaiJikan3Jo = getFormatTimeKanji(選任.get立会時間開始());
            if (null != 選任.get立会時間開始() || null != 選任.get立会時間終了()) {
                source.tachiaiJikan3Ge
                        = から.concat(getFormatTimeKanji(選任.get立会時間終了()));
            }
            source.sankaiJikoku3 = getFormatTimeKanji(選任.get参会時刻());
            source.jishokuJikoku3 = getFormatTimeKanji(選任.get辞職時刻());
            source.jishokuRiyu3 = 選任.get事由();
        }
        if (選任リスト.size() >= TohyoshaIndex.選任者4.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者4.getListIndex());
            source.toha4 = 選任.get党派();
            source.shimei4Jo = getSubString(選任.get氏名(), 氏名_上段表示可能数, true);
            source.shimei4Ge = getSubString(選任.get氏名(), 氏名_上段表示可能数, false);
            source.senninYmd4Jo = getSubFlexibleDate(選任.get選任年月日(), true);
            source.senninYmd4Ge = getSubFlexibleDate(選任.get選任年月日(), false);
            source.tachiaiJikan4Jo = getFormatTimeKanji(選任.get立会時間開始());
            if (null != 選任.get立会時間開始() || null != 選任.get立会時間終了()) {
                source.tachiaiJikan4Ge
                        = から.concat(getFormatTimeKanji(選任.get立会時間終了()));
            }
            source.sankaiJikoku4 = getFormatTimeKanji(選任.get参会時刻());
            source.jishokuJikoku4 = getFormatTimeKanji(選任.get辞職時刻());
            source.jishokuRiyu4 = 選任.get事由();
        }
        if (選任リスト.size() >= TohyoshaIndex.選任者5.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者5.getListIndex());
            source.toha5 = 選任.get党派();
            source.shimei5Jo = getSubString(選任.get氏名(), 氏名_上段表示可能数, true);
            source.shimei5Ge = getSubString(選任.get氏名(), 氏名_上段表示可能数, false);
            source.senninYmd5Jo = getSubFlexibleDate(選任.get選任年月日(), true);
            source.senninYmd5Ge = getSubFlexibleDate(選任.get選任年月日(), false);
            source.tachiaiJikan5Jo = getFormatTimeKanji(選任.get立会時間開始());
            if (null != 選任.get立会時間開始() || null != 選任.get立会時間終了()) {
                source.tachiaiJikan5Ge
                        = から.concat(getFormatTimeKanji(選任.get立会時間終了()));
            }
            source.sankaiJikoku5 = getFormatTimeKanji(選任.get参会時刻());
            source.jishokuJikoku5 = getFormatTimeKanji(選任.get辞職時刻());
            source.jishokuRiyu5 = 選任.get事由();
        }
    }

    private void set投票管理者リスト(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 投票管理者リスト = item.get投票管理者リスト();
        if (null == 投票管理者リスト || 投票管理者リスト.isEmpty()) {
            return;
        }
        TohyouSha 投票管理者;

        if (投票管理者リスト.size() >= TohyoshaIndex.投票管理者1.getIndex()) {
            投票管理者 = 投票管理者リスト.get(TohyoshaIndex.投票管理者1.getListIndex());
            source.tToha1 = 投票管理者.get党派();
            source.tShimei1Jo = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, true);
            source.tShimei1Ge = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, false);
            source.tSankaiJikoku1 = getFormatTimeKanji(投票管理者.get参会時刻());
        }

        if (投票管理者リスト.size() >= TohyoshaIndex.投票管理者2.getIndex()) {
            投票管理者 = 投票管理者リスト.get(TohyoshaIndex.投票管理者2.getListIndex());
            source.tToha2 = 投票管理者.get党派();
            source.tShimei2Jo = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, true);
            source.tShimei2Ge = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, false);
            source.tSankaiJikoku2 = getFormatTimeKanji(投票管理者.get参会時刻());
        }

        if (投票管理者リスト.size() >= TohyoshaIndex.投票管理者3.getIndex()) {
            投票管理者 = 投票管理者リスト.get(TohyoshaIndex.投票管理者3.getListIndex());
            source.tToha3 = 投票管理者.get党派();
            source.tShimei3Jo = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, true);
            source.tShimei3Ge = getSubString(投票管理者.get氏名(), 氏名_上段表示可能数, false);
            source.tSankaiJikoku3 = getFormatTimeKanji(投票管理者.get参会時刻());
        }

    }

    private void set再交付者リスト(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 再交付者リスト = item.get再交付者リスト();
        if (null == 再交付者リスト || 再交付者リスト.isEmpty()) {
            return;
        }
        TohyouSha 再交付者;

        if (再交付者リスト.size() >= TohyoshaIndex.再交付者1.getIndex()) {
            再交付者 = 再交付者リスト.get(TohyoshaIndex.再交付者1.getListIndex());
            source.saiKofusha1 = 再交付者.get氏名();
            source.saiKofuJiyu1 = 再交付者.get事由();
        }

        if (再交付者リスト.size() >= TohyoshaIndex.再交付者2.getIndex()) {
            再交付者 = 再交付者リスト.get(TohyoshaIndex.再交付者2.getListIndex());
            source.saiKofusha2 = 再交付者.get氏名();
            source.saiKofuJiyu2 = 再交付者.get事由();
        }

    }

    private void set決定投票者リスト(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 決定投票者リスト = item.get決定投票者リスト();
        if (null == 決定投票者リスト || 決定投票者リスト.isEmpty()) {
            return;
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者1.getIndex()) {
            source.ketteiTohyosha1 = 決定投票者リスト.get(TohyoshaIndex.決定投票者1.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者2.getIndex()) {
            source.ketteiTohyosha2 = 決定投票者リスト.get(TohyoshaIndex.決定投票者2.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者3.getIndex()) {
            source.ketteiTohyosha3 = 決定投票者リスト.get(TohyoshaIndex.決定投票者3.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者4.getIndex()) {
            source.ketteiTohyosha4 = 決定投票者リスト.get(TohyoshaIndex.決定投票者4.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者5.getIndex()) {
            source.ketteiTohyosha5 = 決定投票者リスト.get(TohyoshaIndex.決定投票者5.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者6.getIndex()) {
            source.ketteiTohyosha6 = 決定投票者リスト.get(TohyoshaIndex.決定投票者6.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者7.getIndex()) {
            source.ketteiTohyosha7 = 決定投票者リスト.get(TohyoshaIndex.決定投票者7.getListIndex()).get氏名();
        }
        if (決定投票者リスト.size() >= TohyoshaIndex.決定投票者8.getIndex()) {
            source.ketteiTohyosha8 = 決定投票者リスト.get(TohyoshaIndex.決定投票者8.getListIndex()).get氏名();
        }

    }

    private void set返還者リスト(KijitsumaeTohyorokuReportSource source) {
        List<TohyouSha> 返還者リスト = item.get返還者リスト();
        if (null == 返還者リスト || 返還者リスト.isEmpty()) {
            return;
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者1.getIndex()) {
            source.henkansha1 = 返還者リスト.get(TohyoshaIndex.返還者1.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者2.getIndex()) {
            source.henkansha2 = 返還者リスト.get(TohyoshaIndex.返還者2.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者3.getIndex()) {
            source.henkansha3 = 返還者リスト.get(TohyoshaIndex.返還者3.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者4.getIndex()) {
            source.henkansha4 = 返還者リスト.get(TohyoshaIndex.返還者4.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者5.getIndex()) {
            source.henkansha5 = 返還者リスト.get(TohyoshaIndex.返還者5.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者6.getIndex()) {
            source.henkansha6 = 返還者リスト.get(TohyoshaIndex.返還者6.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者7.getIndex()) {
            source.henkansha7 = 返還者リスト.get(TohyoshaIndex.返還者7.getListIndex()).get氏名();
        }
        if (返還者リスト.size() >= TohyoshaIndex.返還者8.getIndex()) {
            source.henkansha8 = 返還者リスト.get(TohyoshaIndex.返還者8.getListIndex()).get氏名();
        }

    }

    @Override
    public boolean isLastFlg() {
        return true;
    }

    @Override
    public void setLastFlg(boolean lastFlg) {
    }
}
