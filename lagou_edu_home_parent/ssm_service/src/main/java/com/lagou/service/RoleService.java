package com.lagou.service;

import com.lagou.domain.*;

import java.util.List;

public interface RoleService {

    public List<Role> findAllRole(RoleVo roleVo);

    public void saveRole(Role role);


    void updateRole(Role role);

    void deleteRole(Integer id);

    List<String> findMenuByRoleId(Integer roleId);

    void RoleContextMenu(RoleMenuVo roleMenuVo);

    List<ResourceCategory> findRoleHaveResource(int id);

    void roleContextResource(RoleResourceVo roleResourceVo);

}
