package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(RoleVo roleVo) {

        PageHelper.startPage(roleVo.getCurrentPage(),roleVo.getPageSize());
        List<Role> allRole = roleMapper.findAllRole(roleVo);
        return allRole;
    }


    @Override
    public void saveRole(Role role) {

        role.setCreatedTime(new Date());
        role.setUpdatedTime(new Date());
        role.setCreatedBy("system");
        role.setUpdatedBy("system");

        roleMapper.saveRole(role);


    }

    @Override
    public void updateRole(Role role) {
        role.setCreatedTime(new Date());
        role.setUpdatedTime(new Date());

        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }

    @Override
    public List<String> findMenuByRoleId(Integer roleId) {
        List<String> list =   roleMapper.findMenuByRoleId(roleId);
        return list;
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {

        // 清空中间表
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        for (Integer mid : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedTime(new Date());
            role_menu_relation.setUpdatedTime(new Date());
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.RoleContextMenu(role_menu_relation);
        }

    }

    @Override
    public List<ResourceCategory> findRoleHaveResource(int id) {

        //1.获取角色拥有的资源分类数据
        List<ResourceCategory> categoryList = roleMapper.findRoleHaveResourceCate(id);

        //2.获取角色拥有的资源数据
        List<Resource> resourceList = roleMapper.findRoleHaveResource(id);

        //3.将资源数据封装到对应分类下
        for (ResourceCategory category : categoryList) {
            for (Resource resource : resourceList) {
                //判断
                if(category.getId() == resource.getCategoryId()){
                    //将资源保存到集合中
                    category.getResourceList().add(resource);
                }
            }
        }

        //4.返回资源分类集合
        return categoryList;

    }

    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {

        //根据角色id 清空中间表
        Integer roleId = roleResourceVo.getRoleId();
        roleMapper.deleteRoleContextResource(roleId);

        //获取分配资源的id集合
        List<Integer> resourceIdList = roleResourceVo.getResourceIdList();

        //向中间表插入最新的关联信息
        for (Integer resId : resourceIdList) {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resId);
            Date date = new Date();
            relation.setCreatedTime(date);
            relation.setUpdatedTime(date);
            relation.setCreatedBy("system");
            relation.setUpdatedBy("system");

            roleMapper.roleContextResource(relation);
        }

    }


}
