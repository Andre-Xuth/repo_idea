package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface RoleMapper {

    /*
        分页查询角色
     */
    public List<Role> findAllRole(RoleVo roleVo);

    /*
        添加角色
     */
    public void saveRole(Role role);


    /*
        更新角色
     */
    void updateRole(Role role);

    /*
        删除角色
     */
    void deleteRole(Integer id);

    /*
        根据角色ID查询菜单信息
     */
    List<String> findMenuByRoleId(Integer roleId);

    /*
       为角色分配菜单
     */
    void RoleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色和菜单的关联信息
     */
    void deleteRoleContextMenu(Integer roleId);

    /**
     * 获取角色拥有的资源分类数据
     * */
    List<ResourceCategory> findRoleHaveResourceCate(int id);


    /**
     * 获取角色拥有的资源数据
     * */
    List<Resource> findRoleHaveResource(int id);

    /*
     删除角色和资源的关联信息
    */
    void deleteRoleContextResource(Integer roleId);

    /**
     * 为角色分配资源
     * */
    void roleContextResource(RoleResourceRelation resourceRelation);

}
