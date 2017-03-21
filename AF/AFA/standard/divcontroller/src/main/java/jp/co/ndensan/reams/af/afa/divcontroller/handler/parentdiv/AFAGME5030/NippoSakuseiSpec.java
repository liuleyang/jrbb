/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * AFAGME5030_日報のチェックロジックです。
 *
 * @reamsid_L AF-0270-010 xul
 */
public enum NippoSakuseiSpec implements IPredicate<NippoSakuseiDiv> {

    /**
     * 出力対象選択チェック
     */
    出力対象選択チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is出力対象選択 = true;
                    boolean 期日前投票日報 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().isIsPublish();
                    boolean 不在者投票日報 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().isIsPublish();
                    boolean 期日前投票者一覧表 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().isIsPublish();
                    boolean 不在者投票者一覧表 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().isIsPublish();
                    boolean 投票者一覧表 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().isIsPublish();
                    boolean 投票事由調書 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().isIsPublish();
                    boolean 投票集計整理表 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoSeirihyo().isIsPublish();

                    if (!期日前投票日報 && !不在者投票日報 && !期日前投票者一覧表 && !不在者投票者一覧表 && !投票者一覧表 && !投票事由調書 && !投票集計整理表) {
                        is出力対象選択 = false;
                    }

                    return is出力対象選択;
                }
            },
    /**
     * 期日前投票日報　出力チェックボックスがONの場合,投票日開始チェック
     */
    期日前投票日報の投票日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票日報 = true;
                    RDate 投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getFromValue();
                    RDate 投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getToValue();

                    if (投票日From == null && 投票日To != null) {
                        is期日前投票日報 = false;
                    }

                    return is期日前投票日報;
                }
            },
    /**
     * 期日前投票日報　出力チェックボックスがONの場合,投票日終了チェック
     */
    期日前投票日報の投票日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票日報 = true;
                    RDate 投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getFromValue();
                    RDate 投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getToValue();

                    if (投票日From != null && 投票日To == null) {
                        is期日前投票日報 = false;
                    }

                    return is期日前投票日報;
                }
            },
    /**
     * 期日前投票日報　出力チェックボックスがONの場合,投票日開始と終了関係性チェック
     */
    期日前投票日報の投票日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票日報 = true;
                    RDate 投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getFromValue();
                    RDate 投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeNippo().getTxtKijitsumaNippoTohyoYMD().getToValue();

                    if (投票日From != null && 投票日To != null && 投票日To.isBefore(投票日From)) {
                        is期日前投票日報 = false;
                    }
                    return is期日前投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日と受理日の未選択チェック
     */
    不在者投票日報の交付日と受理日の未選択チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    List<KeyValueDataSource> 交付日報 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getChkJuriNippo().getSelectedItems();
                    List<KeyValueDataSource> 受理日報 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getChkKofuNippo().getSelectedItems();
                    boolean 不在者投票日報 = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().isIsPublish();

                    if (不在者投票日報 && 交付日報.isEmpty() && 受理日報.isEmpty()) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日開始チェック
     */
    不在者投票日報の交付日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getToValue();
                    if (交付日From == null && 交付日To != null) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日終了チェック
     */
    不在者投票日報の交付日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getToValue();

                    if (交付日From != null && 交付日To == null) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日開始と終了の関係性チェック
     */
    不在者投票日報の交付日開始と終了の関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoKofuYMD().getToValue();
                    if (交付日From != null && 交付日To != null && 交付日To.isBefore(交付日From)) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,投票日開始チェック
     */
    不在者投票日報の受理日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getToValue();
                    if (受理日From == null && 受理日To != null) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,投票日開始～終了の関係性チェック
     */
    不在者投票日報の受理日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getToValue();
                    if (受理日From != null && 受理日To == null) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,受理日開始と終了の関係性チェック
     */
    不在者投票日報の受理日開始と終了の関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票日報 = true;
                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaNippo().getTxtFuzaishaNippoJuriYMD().getToValue();
                    if (受理日From != null && 受理日To != null && 受理日To.isBefore(受理日From)) {
                        is不在者投票日報 = false;
                    }

                    return is不在者投票日報;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,期日前投票日開始と終了チェック
     */
    期日前投票者一覧表の期日前投票日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RDate 期日前投票日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getToValue();
                    if (期日前投票日開始From == null && 期日前投票日終了To != null) {
                        is期日前投票者一覧表 = false;
                    }

                    return is期日前投票者一覧表;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,期日前投票日開始と終了チェック
     */
    期日前投票者一覧表の期日前投票日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RDate 期日前投票日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getToValue();

                    if (期日前投票日開始From != null && 期日前投票日終了To == null) {
                        is期日前投票者一覧表 = false;
                    }

                    return is期日前投票者一覧表;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,期日前投票日開始と終了の関係性チェック
     */
    期日前投票者一覧表の期日前投票日開始と終了の関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RDate 期日前投票日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoYMD().getToValue();
                    if (期日前投票日開始From != null && 期日前投票日終了To != null && 期日前投票日終了To.isBefore(期日前投票日開始From)) {
                        is期日前投票者一覧表 = false;
                    }

                    return is期日前投票者一覧表;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,投票時刻開始と終了チェック
     */
    期日前投票者一覧表の投票時刻開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RTime 投票時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getFromValue();
                    RTime 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getToValue();
                    if (投票時刻開始From == null && 期日前投票日終了To != null) {
                        is期日前投票者一覧表 = false;
                    }

                    return is期日前投票者一覧表;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,投票時刻開始と終了チェック
     */
    期日前投票者一覧表の投票時刻終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RTime 投票時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getFromValue();
                    RTime 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getToValue();
                    if (投票時刻開始From != null && 期日前投票日終了To == null) {
                        is期日前投票者一覧表 = false;
                    }
                    return is期日前投票者一覧表;
                }
            },
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合,投票時刻開始と終了関係性チェック
     */
    期日前投票者一覧表の投票時刻開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is期日前投票者一覧表 = true;
                    RTime 投票時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getFromValue();
                    RTime 期日前投票日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoKijitsumaeIchiran().getTxtKijitsumaeIchiranTohyoTime().getToValue();
                    if (投票時刻開始From != null && 期日前投票日終了To != null && 期日前投票日終了To.isBefore(投票時刻開始From)) {
                        is期日前投票者一覧表 = false;
                    }

                    return is期日前投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了チェック
     */
    不在者投票者一覧表の交付日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 交付日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getFromValue();
                    RDate 交付日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getToValue();
                    if (交付日開始From == null && 交付日終了To != null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了チェック
     */
    不在者投票者一覧表の交付日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 交付日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getFromValue();
                    RDate 交付日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getToValue();
                    if (交付日開始From != null && 交付日終了To == null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了関係性チェック
     */
    不在者投票者一覧表の交付日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 交付日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getFromValue();
                    RDate 交付日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranKofuYMD().getToValue();
                    if (交付日開始From != null && 交付日終了To != null && 交付日終了To.isBefore(交付日開始From)) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了チェック
     */
    不在者投票者一覧表の受理日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 受理日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getFromValue();
                    RDate 受理日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getToValue();
                    if (受理日開始From == null && 受理日終了To != null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了チェック
     */
    不在者投票者一覧表の受理日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 受理日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getFromValue();
                    RDate 受理日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getToValue();
                    if (受理日開始From != null && 受理日終了To == null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了関係性チェック
     */
    不在者投票者一覧表の受理日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RDate 受理日開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getFromValue();
                    RDate 受理日終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriYMD().getToValue();
                    if (受理日開始From != null && 受理日終了To != null && 受理日終了To.isBefore(受理日開始From)) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理時刻開始と終了チェック
     */
    不在者投票者一覧表の受理時刻開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RTime 受理時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getFromValue();
                    RTime 受理時刻終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getToValue();
                    if (受理時刻開始From == null && 受理時刻終了To != null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理時刻開始と終了チェック
     */
    不在者投票者一覧表の受理時刻終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RTime 受理時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getFromValue();
                    RTime 受理時刻終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getToValue();
                    if (受理時刻開始From != null && 受理時刻終了To == null) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理時刻開始と終了関係性チェック
     */
    不在者投票者一覧表の受理時刻開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is不在者投票者一覧表 = true;
                    RTime 受理時刻開始From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getFromValue();
                    RTime 受理時刻終了To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoFuzaishaIchiran().getTxtFuzaishaIchiranJuriTime().getToValue();
                    if (受理時刻開始From != null && 受理時刻終了To != null && 受理時刻終了To.isBefore(受理時刻開始From)) {
                        is不在者投票者一覧表 = false;
                    }

                    return is不在者投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合
     */
    期日前投票者の期日前投票日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 期日前投票日From == null && 期日前投票日To != null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合
     */
    期日前投票者の期日前投票日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 期日前投票日From != null && 期日前投票日To == null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合
     */
    期日前投票者の期日前投票日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 期日前投票日From != null && 期日前投票日To != null && 期日前投票日To.isBefore(期日前投票日From)) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合<br/>
     * 投票時刻開始と終了チェック
     */
    期日前投票者の投票時刻開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 投票時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getFromValue();
                    RTime 投票時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 投票時刻From == null && 投票時刻To != null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合<br/>
     * 投票時刻開始と終了チェック
     */
    期日前投票者の投票時刻終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 投票時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getFromValue();
                    RTime 投票時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 投票時刻From != null && 投票時刻To == null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 期日前投票者のチェックボックスがONの場合
     */
    期日前投票者の投票時刻開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 投票時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getFromValue();
                    RTime 投票時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranTohyoTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranKijitsumae().getSelectedItems();
                    if (!dataSource.isEmpty() && 投票時刻From != null && 投票時刻To != null && 投票時刻To.isBefore(投票時刻From)) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 交付日開始と終了チェック
     */
    不在者投票者の交付日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();

                    if (!dataSource.isEmpty() && 交付日From == null && 交付日To != null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 交付日開始と終了チェック
     */
    不在者投票者の交付日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 交付日From != null && 交付日To == null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 交付日開始と終了関係性チェック
     */
    不在者投票者の交付日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 交付日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getFromValue();
                    RDate 交付日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranKofuYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 交付日From != null && 交付日To != null && 交付日To.isBefore(交付日From)) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理日開始と終了チェック
     */
    不在者投票者の受理日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();

                    if (!dataSource.isEmpty() && 受理日From == null && 受理日To != null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理日開始と終了チェック
     */
    不在者投票者の受理日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 受理日From != null && 受理日To == null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理日開始と終了関係性チェック
     */
    不在者投票者の受理日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriYMD().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 受理日From != null && 受理日To != null && 受理日To.isBefore(受理日From)) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理時刻開始と終了
     */
    不在者投票者の受理時刻開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 受理時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getFromValue();
                    RTime 受理時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 受理時刻From == null && 受理時刻To != null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理時刻開始と終了
     */
    不在者投票者の受理時刻終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 受理時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getFromValue();
                    RTime 受理時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 受理時刻From != null && 受理時刻To == null) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票者一覧表　出力チェックボックスがONの場合<br/>
     * 不在者投票者のチェックボックスがONの場合<br/>
     * 受理時刻開始と終了関係性チェック
     */
    不在者投票者の受理時刻開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票者一覧表 = true;

                    RTime 受理時刻From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getFromValue();
                    RTime 受理時刻To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getTxtTohyoshaIchiranJuriTime().getToValue();
                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoTohyoshaIchiran().getChkTohyoshaIchiranFuzaisha().getSelectedItems();
                    if (!dataSource.isEmpty() && 受理時刻From != null && 受理時刻To != null && 受理時刻To.isBefore(受理時刻From)) {
                        is投票者一覧表 = false;
                    }

                    return is投票者一覧表;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 期日前投票日開始と終了チェック
     */
    投票事由調書の期日前投票日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkKijitsumaeJiyuChosho().getSelectedItems();

                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getToValue();

                    if (!dataSource.isEmpty() && 期日前投票日From == null && 期日前投票日To != null) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 期日前投票日開始と終了チェック
     */
    投票事由調書の期日前投票日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkKijitsumaeJiyuChosho().getSelectedItems();

                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getToValue();

                    if (!dataSource.isEmpty() && 期日前投票日From != null && 期日前投票日To == null) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 期日前投票日開始と終了関係性チェック
     */
    投票事由調書の期日前投票日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkKijitsumaeJiyuChosho().getSelectedItems();
                    RDate 期日前投票日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getFromValue();
                    RDate 期日前投票日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoKijitsumaeTohyoYMD().getToValue();

                    if (!dataSource.isEmpty() && 期日前投票日From != null && 期日前投票日To != null && 期日前投票日To.isBefore(期日前投票日From)) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 受理日開始と終了チェック
     */
    投票事由調書の受理日開始チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkFuzaishaJiyuChosho().getSelectedItems();

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getToValue();

                    if (!dataSource.isEmpty() && 受理日From == null && 受理日To != null) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 受理日開始と終了チェック
     */
    投票事由調書の受理日終了チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkFuzaishaJiyuChosho().getSelectedItems();

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getToValue();

                    if (!dataSource.isEmpty() && 受理日From != null && 受理日To == null) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            },
    /**
     * 投票事由調書　出力チェックボックスがONの場合<br/>
     * 期日前投票チェックボックスがONの場合<br/>
     * 受理日開始と終了関係性チェック
     */
    投票事由調書の受理日開始と終了関係性チェック {
                @Override
                public boolean apply(NippoSakuseiDiv div) {
                    boolean is投票事由調書 = true;

                    List<KeyValueDataSource> dataSource = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getChkFuzaishaJiyuChosho().getSelectedItems();

                    RDate 受理日From = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getFromValue();
                    RDate 受理日To = div.getNippoSakuseiChohyo().getNippoSakuseiChohyoJiyuChosho().getTxtJiyuChoshoJuriYMD().getToValue();

                    if (!dataSource.isEmpty() && 受理日From != null && 受理日To != null && 受理日To.isBefore(受理日From)) {
                        is投票事由調書 = false;
                    }

                    return is投票事由調書;
                }
            };
}
