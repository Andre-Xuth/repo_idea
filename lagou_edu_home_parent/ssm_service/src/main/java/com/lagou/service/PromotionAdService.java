package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdService {

    /*
    分页获取所有的广告列表
*/
    public PageInfo findAllAdByPage(PromotionAdVo adVo);

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    void updatePromotionAdStatus(int id, int status);

    PromotionAd findPromotionAdById(int id);


}
