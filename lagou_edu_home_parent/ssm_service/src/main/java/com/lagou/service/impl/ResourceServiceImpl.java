package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {

        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);

        PageInfo<Resource> adPageInfo = new PageInfo<Resource>(allResource);

        return adPageInfo;
    }

    /*
        添加资源
     */
    @Override
    public void saveResource(Resource resource) {

        resource.setCreatedTime(new Date());
        resource.setUpdatedTime(new Date());
        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");


        resourceMapper.saveResource(resource);
    }

    /*
        更新资源
     */
    @Override
    public void updateResource(Resource resource) {

        resource.setCreatedTime(new Date());
        resource.setUpdatedTime(new Date());
        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");

        resourceMapper.updateResource(resource);
    }


    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }
}
