package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    /*
         分页获取所有的广告列表
     */
    public List<PromotionAd> findAllAdByPage();

    /**
     * 根据id查询广告信息
     * */
    PromotionAd findPromotionAdById(int id);

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    void updatePromotionAdStatus(PromotionAd promotionAd);



}
