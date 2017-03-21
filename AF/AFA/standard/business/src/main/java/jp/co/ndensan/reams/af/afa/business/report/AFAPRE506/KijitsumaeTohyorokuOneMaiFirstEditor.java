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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KijitsumaeTohyorokuReportSource}を編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuOneMaiFirstEditor extends KijitsumaeTohyorokuCommon implements IKijitsumaeTohyorokuEditor {

    private final TohyorokuChohyo item;
    private boolean lastFlg = true;

    /**
     * コンストラクタです。
     *
     * @param item {@link TohyorokuChohyo}
     */
    public KijitsumaeTohyorokuOneMaiFirstEditor(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public KijitsumaeTohyorokuReportSource edit(KijitsumaeTohyorokuReportSource source) {
        set帳票情報(source);
        source.layout = KijitsumaeTohyorokuReportSource.Layouts.AFAPRE506_KijitsumaeTohyoroku1mai1;
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
            set投票拒否者法1リスト(source);
            set投票拒否者法2リスト(source);
        }
        set代理投票者リスト(source);

    }

    private void set投票基本情報(KijitsumaeTohyorokuReportSource source) {
        source.shikkoYmd = getKanjiYmd(item.get執行年月日());
        source.title = item.getタイトル().concat(タイトル_期日前投票所投票録);
        source.tohyoYmd = getKanjiYmd(item.get投票年月日());
        source.secchJjokyo = item.get設置状況();
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
        source.kariTohyoshaSuMan = getFormatNumber(item.get仮投票者男数());
        source.tohyoshaWoman = getFormatNumber(item.get投票者女数());
        source.kariTohyoshaSuWoman = getFormatNumber(item.get仮投票者女数());
        source.tohyoshaKei = getFormatNumber(item.get投票者合計());
        source.kariTohyoshaSuKei = getFormatNumber(item.get仮投票者合計());
        source.tenji = getFormatNumber(item.get点字投票者数());
        source.jimuSosu = getFormatNumber(item.get従事者総数());
        source.jimu1 = getFormatNumber(item.get選挙管理委員会書記数());
        source.jimu2 = getFormatNumber(item.get職員数());
        source.jimu3 = getFormatNumber(item.getその他数());
        source.choseiYmd = getKanjiYmd(item.get調整年月日());
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
            source.shimei1 = 選任.get氏名();
            source.senninYmd1 = null != 選任.get選任年月日() ? 選任.get選任年月日().wareki().toDateString() : RString.EMPTY;
            source.tachiaiJikan1 = getTachiaiJikan(選任.get立会時間開始(), 選任.get立会時間終了());
            source.sankaiJikoku1 = getFormatTimeEn(選任.get参会時刻());
            source.jishokuJikoku1 = getFormatTimeEn(選任.get辞職時刻());
            source.jishokuRiyu1 = 選任.get事由();
        }

        if (選任リスト.size() >= TohyoshaIndex.選任者2.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者2.getListIndex());
            source.toha2 = 選任.get党派();
            source.shimei2 = 選任.get氏名();
            source.senninYmd2 = null != 選任.get選任年月日() ? 選任.get選任年月日().wareki().toDateString() : RString.EMPTY;
            source.tachiaiJikan2 = getTachiaiJikan(選任.get立会時間開始(), 選任.get立会時間終了());
            source.sankaiJikoku2 = getFormatTimeEn(選任.get参会時刻());
            source.jishokuJikoku2 = getFormatTimeEn(選任.get辞職時刻());
            source.jishokuRiyu2 = 選任.get事由();
        }

        if (選任リスト.size() >= TohyoshaIndex.選任者3.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者3.getListIndex());
            source.toha3 = 選任.get党派();
            source.shimei3 = 選任.get氏名();
            source.senninYmd3 = null != 選任.get選任年月日() ? 選任.get選任年月日().wareki().toDateString() : RString.EMPTY;
            source.tachiaiJikan3 = getTachiaiJikan(選任.get立会時間開始(), 選任.get立会時間終了());
            source.sankaiJikoku3 = getFormatTimeEn(選任.get参会時刻());
            source.jishokuJikoku3 = getFormatTimeEn(選任.get辞職時刻());
            source.jishokuRiyu3 = 選任.get事由();
        }
        if (選任リスト.size() >= TohyoshaIndex.選任者4.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者4.getListIndex());
            source.toha4 = 選任.get党派();
            source.shimei4 = 選任.get氏名();
            source.senninYmd4 = null != 選任.get選任年月日() ? 選任.get選任年月日().wareki().toDateString() : RString.EMPTY;
            source.tachiaiJikan4 = getTachiaiJikan(選任.get立会時間開始(), 選任.get立会時間終了());
            source.sankaiJikoku4 = getFormatTimeEn(選任.get参会時刻());
            source.jishokuJikoku4 = getFormatTimeEn(選任.get辞職時刻());
            source.jishokuRiyu4 = 選任.get事由();
        }
        if (選任リスト.size() >= TohyoshaIndex.選任者5.getIndex()) {
            選任 = 選任リスト.get(TohyoshaIndex.選任者5.getListIndex());
            source.toha5 = 選任.get党派();
            source.shimei5 = 選任.get氏名();
            source.senninYmd5 = null != 選任.get選任年月日() ? 選任.get選任年月日().wareki().toDateString() : RString.EMPTY;
            source.tachiaiJikan5 = getTachiaiJikan(選任.get立会時間開始(), 選任.get立会時間終了());
            source.sankaiJikoku5 = getFormatTimeEn(選任.get参会時刻());
            source.jishokuJikoku5 = getFormatTimeEn(選任.get辞職時刻());
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
            source.tShimei1 = 投票管理者.get氏名();
            source.tSankaiJikoku1 = getFormatTimeEn(投票管理者.get参会時刻());
        }

        if (投票管理者リスト.size() >= TohyoshaIndex.投票管理者2.getIndex()) {
            投票管理者 = 投票管理者リスト.get(TohyoshaIndex.投票管理者2.getListIndex());
            source.tToha2 = 投票管理者.get党派();
            source.tShimei2 = 投票管理者.get氏名();
            source.tSankaiJikoku2 = getFormatTimeEn(投票管理者.get参会時刻());
        }

        if (投票管理者リスト.size() >= TohyoshaIndex.投票管理者3.getIndex()) {
            投票管理者 = 投票管理者リスト.get(TohyoshaIndex.投票管理者3.getListIndex());
            source.tToha3 = 投票管理者.get党派();
            source.tShimei3 = 投票管理者.get氏名();
            source.tSankaiJikoku3 = getFormatTimeEn(投票管理者.get参会時刻());
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

    private void set代理投票者リスト(KijitsumaeTohyorokuReportSource source) {
        source.dairiTohyoshaSu = getFormatNumber(item.get代理投票者数());
        source.shuruiTitle = item.get種類タイトル();

        List<TohyouSha> 代理投票者リスト = item.get代理投票者リスト();
        if (null == 代理投票者リスト || 代理投票者リスト.isEmpty()) {
            return;
        }

        if (代理投票者リスト.size() <= 代理投票者_表示可能数) {
            TohyouSha 代理投票者 = 代理投票者リスト.get(item.get代理投票者Index());
            source.listDairitohyo_1 = 代理投票者.get氏名();
            source.listDairitohyo_2 = 代理投票者.get補助者1氏名();
            source.listDairitohyo_3 = 代理投票者.get補助者2氏名();
        } else {
            source.besshiUmu = 別紙に記載;
        }

    }

    private void set投票拒否者法1リスト(KijitsumaeTohyorokuReportSource source) {
        source.hoNo1 = item.get法1();

        List<TohyouSha> 法1リスト = item.get投票拒否者法1リスト();
        if (null == 法1リスト || 法1リスト.isEmpty()) {
            return;
        }
        TohyouSha 法投票者;
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者1.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者1.getListIndex());
            source.kyohiShimei1 = 法投票者.get氏名();
            source.kyohiJiyu1 = 法投票者.get事由();
            source.kariUmu1 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者2.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者2.getListIndex());
            source.kyohiShimei2 = 法投票者.get氏名();
            source.kyohiJiyu2 = 法投票者.get事由();
            source.kariUmu2 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法1リスト.size() >= TohyoshaIndex.法1投票拒否者3.getIndex()) {
            法投票者 = 法1リスト.get(TohyoshaIndex.法1投票拒否者3.getListIndex());
            source.kyohiShimei3 = 法投票者.get氏名();
            source.kyohiJiyu3 = 法投票者.get事由();
            source.kariUmu3 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
    }

    private void set投票拒否者法2リスト(KijitsumaeTohyorokuReportSource source) {
        source.hoNo2 = item.get法2();

        List<TohyouSha> 法2リスト = item.get投票拒否者法2リスト();
        if (null == 法2リスト || 法2リスト.isEmpty()) {
            return;
        }
        TohyouSha 法投票者;
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者1.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者1.getListIndex());
            source.dKyohiShimei1 = 法投票者.get氏名();
            source.dKyohiJiyu1 = 法投票者.get事由();
            source.dKariUmu1 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者2.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者2.getListIndex());
            source.dKyohiShimei2 = 法投票者.get氏名();
            source.dKyohiJiyu2 = 法投票者.get事由();
            source.dDariUmu2 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
        if (法2リスト.size() >= TohyoshaIndex.法2投票拒否者3.getIndex()) {
            法投票者 = 法2リスト.get(TohyoshaIndex.法2投票拒否者3.getListIndex());
            source.dKyohiShimei3 = 法投票者.get氏名();
            source.dKyohiJiyu3 = 法投票者.get事由();
            source.dKariUmu3 = 法投票者.is仮投票フラグ() ? 仮投票あり : 仮投票なし;
        }
    }

    @Override
    public boolean isLastFlg() {
        return this.lastFlg;
    }

    @Override
    public void setLastFlg(boolean lastFlg) {
        this.lastFlg = lastFlg;
    }

}
