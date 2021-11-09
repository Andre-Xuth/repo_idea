package com.lagou.service.impl;

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
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleid) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleid);

        return menuByRoleId;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        //1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        //2. 为角色分配菜单

        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");

            roleMapper.roleContextMenu(role_menu_relation);
        }

    }

    @Override
    public void deleteRole(Integer roleid) {

        // 调用根据roleid清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }

    @Override
    public List<ResourceCategory> findAllResourceByRoleId(Integer id) {

        // 查询当前用户拥有的资源分类信息
        List<ResourceCategory> allResourceCategory = roleMapper.findAllResourceCategoryByRoleID(id);

        // 获取当前角色拥有的资源信息
        List<Resource> allResource = roleMapper.findAllResourceByRoleID(id);

        // 封装allResourceCategory
        for (Resource resource : allResource){
            for (ResourceCategory resourceCategory:allResourceCategory) {
                if (resource.getCategoryId().equals(resourceCategory.getId())){
                    resourceCategory.getResourceList().add(resource);
                }
            }
        }

        return allResourceCategory;
    }

    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        
        // 清空中间表的关联关系
        roleMapper.deleteRoleResourceRelation(roleResourceVo.getRoleId());
        
        // 为角色分配资源
        for (int resourceId:roleResourceVo.getResourceIdList()) {
            Role_Resource_Relation role_resource_relation = new Role_Resource_Relation();
            // 封装数据
            role_resource_relation.setRoleId(roleResourceVo.getRoleId());
            role_resource_relation.setResourceId(resourceId);
            Date date = new Date();
            role_resource_relation.setCreatedTime(date);
            role_resource_relation.setUpdatedTime(date);
            role_resource_relation.setCreatedBy("system");
            role_resource_relation.setUpdatedBy("system");

            roleMapper.saveRoleResourceRelation(role_resource_relation);
        }
    }


}
