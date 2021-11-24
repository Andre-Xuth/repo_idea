package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody RoleVo roleVo){

        List<Role> allRole = roleService.findAllRole(roleVo);

        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allRole);
        return responseResult;
    }


    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveRole(@RequestBody Role role){

        if(role.getId() == null){
            roleService.saveRole(role);
        }else {
            roleService.updateRole(role);
        }


        ResponseResult responseResult = new ResponseResult(true,200,"响应成功","");
        return responseResult;
    }


    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);

        ResponseResult responseResult = new ResponseResult(true,200,"响应成功","");
        return responseResult;
    }


    @Autowired
    private MenuService menuService;


    /*
       查询所有菜单信息
    */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        //-1 表示查询所有菜单数据
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        Map<String,Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);

        ResponseResult result = new ResponseResult(true,200,"响应成功",map);
        return result;
    }


    /**
     * 查询角色关联菜单列表ID
     * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<String> menuList = roleService.findMenuByRoleId(roleId);

        ResponseResult result = new ResponseResult(true,200,"响应成功",menuList);
        return result;
    }

    /*
        角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        ResponseResult result = new ResponseResult(true,200,"响应成功","");
        return result;
    }

    /**
     * 获取当前角色拥有的 资源信息(包括资源分类以及资源信息)
     * */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(int roleId){

        //1.获取角色拥有的资源分类信息
        List<ResourceCategory> categoryList = roleService.findRoleHaveResource(roleId);

        ResponseResult result = new ResponseResult(true,200,"响应成功",categoryList);
        return result;
    }


    /*
       角色分配资源
    */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo roleResourceVo){
        roleService.roleContextResource(roleResourceVo);
        ResponseResult result = new ResponseResult(true,200,"响应成功","");
        return result;
    }

}
