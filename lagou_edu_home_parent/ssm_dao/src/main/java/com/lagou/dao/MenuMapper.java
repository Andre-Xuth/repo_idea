package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuMapper {

    /**
     * 查询菜单列表
     * */
    public List<Menu> findAllMenu();

    /**
     * 根据ID查询父菜单ID
     * */
    public Menu findMenuById(int id);

    /**
     * 查询全部的父子菜单信息
     * */
    public List<Menu> findSubMenuListByPid(int pid);

    /**
     * 保存菜单
     * */
    public void saveMenu(Menu menu);

    /**
     * 修改菜单
     * */
    public void updateMenu(Menu menu);

    /*
        查询所有菜单信息
     */
    List<Menu> findAllMenu2();
}
