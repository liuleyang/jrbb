///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.af.afa.persistence.db.mapper.searchsimplejumin;
//
//import java.util.List;
//import jp.co.ndensan.reams.af.afa.entity.db.relate.searchsimplejumin.SearchSimpleJuminEntity;
//import jp.co.ndensan.reams.af.afa.entity.db.relate.searchsimplejumin.ShikakuShuruiParameter;
//
///**
// * 住民検索（簡易版）のマッパクラスのインタフェースです。
// *
// * @reamsid_L AF-0170-020 lis
// */
//public interface ISearchSimpleJuminMapper {
//
//    /**
//     * 選挙人情報を取得します。
//     *
//     * @param shikakuShuruiParameter ShikakuShuruiParameter
//     * @return 選挙人情報取得 List<SearchSimpleJuminEntity>
//     */
//    List<SearchSimpleJuminEntity> select選挙人情報(ShikakuShuruiParameter shikakuShuruiParameter);
//
//    /**
//     * 選挙人情報を取得します。
//     *
//     * @param shikakuShuruiParameter ShikakuShuruiParameter
//     * @return 選挙人情報取得 List<SearchSimpleJuminEntity>
//     */
//    List<SearchSimpleJuminEntity> select投票資格の不在者投票資格(ShikakuShuruiParameter shikakuShuruiParameter);
//
//    /**
//     * 選挙人情報を取得します。
//     *
//     * @param shikakuShuruiParameter ShikakuShuruiParameter
//     * @return 選挙人情報取得 List<SearchSimpleJuminEntity>
//     */
//    List<SearchSimpleJuminEntity> select投票資格の選挙資格(ShikakuShuruiParameter shikakuShuruiParameter);
//}
