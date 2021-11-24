package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

public interface ResourceService {

    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);

    void saveResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(Integer id);


}
