package com.tt.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.tt.admin.dao.MenuDao;
import com.tt.admin.handler.UserHandler;
import com.tt.admin.model.Menu;
import com.tt.admin.service.MenuService;
import com.tt.admin.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author TONGXIN
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu findById(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    public List<MenuVO> findByCondition(MenuVO menuVO) {
        PageHelper.startPage(menuVO.getPageNum(), menuVO.getPageSize());
        List<MenuVO> menuList = menuDao.findByCondition(menuVO);
        //查询子节点
        buildTreeData(menuList);
        return menuList;
    }

    private void buildTreeData(List<MenuVO> menuList) {
        Stack<MenuVO> stack = new Stack<>();
        stack.addAll(menuList);
        while (!stack.empty()) {
            MenuVO pop = stack.pop();
            pop.setKey(pop.getId());
            pop.setTitle(pop.getName());
            MenuVO temp = new MenuVO();
            temp.setParentId(pop.getId());
            List<MenuVO> children = menuDao.findByCondition(temp);
            if (CollectionUtils.isNotEmpty(children)) {
                pop.setChildren(children);
                children.forEach(item->{
                    item.setParentName(pop.getName());
                    stack.push(item);
                });
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Menu menu) {
        menu.setUpdateTime(new Date());
        menuDao.update(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        menuDao.deleteById(id);
        //递归删除子节点
        MenuVO menuVO = new MenuVO();
        menuVO.setParentId(id);
        List<MenuVO> menuVOList = menuDao.findByCondition(menuVO);
        Stack<MenuVO> stack = new Stack<>();
        stack.addAll(menuVOList);
        while (!stack.empty()) {
            MenuVO pop = stack.pop();
            menuDao.deleteById(pop.getId());
            menuVO.setParentId(pop.getId());
            List<MenuVO> temp = menuDao.findByCondition(menuVO);
            if (CollectionUtils.isNotEmpty(temp)) {
                temp.forEach(stack::push);
            }
        }
    }

    @Override
    public List<MenuVO> getPermissionList(MenuVO menuVO) {
        menuVO.setRoleSign(UserHandler.getRoleSign());
        List<MenuVO> menuList = menuDao.findPermissionMenu(menuVO);
        //查询子节点
        return buildTreeDataWithoutQuery(menuList);
    }

    @Override
    public List<MenuVO> findAll(MenuVO menuVO) {
        List<MenuVO> menuList = menuDao.findByCondition(menuVO);
        //查询子节点
        buildTreeData(menuList);
        return buildTreeDataWithoutQuery(menuList);
    }

    private List<MenuVO> buildTreeDataWithoutQuery(List<MenuVO> menuList) {
        Stack<MenuVO> stack = new Stack<>();
        List<MenuVO> parentMenu = menuList.stream().filter(item -> item.getParentId() == 0).collect(Collectors.toList());
        stack.addAll(parentMenu);
        while (!stack.empty()) {
            MenuVO pop = stack.pop();
            List<MenuVO> childrenMenu = menuList.stream().filter(item -> item.getParentId().equals(pop.getId())).collect(Collectors.toList());
            childrenMenu.forEach(item -> {
                item.setParentName(pop.getName());
                if (item.getType() == 2) {
                    item.setOperate(item.getUrl());
                    item.setUrl(pop.getUrl());
                }
            });
            if (CollectionUtils.isNotEmpty(childrenMenu)) {
                pop.setChildren(childrenMenu);
                childrenMenu.forEach(stack::push);
            }
        }
        return parentMenu;
    }

}
