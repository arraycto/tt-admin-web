package com.tt.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.tt.common.utils.BeanUtil;
import com.tt.admin.dao.UserDao;
import com.tt.admin.dao.UserDeptDao;
import com.tt.admin.dao.UserRoleDao;
import com.tt.admin.handler.UserHandler;
import com.tt.admin.model.User;
import com.tt.admin.model.UserDept;
import com.tt.admin.model.UserRole;
import com.tt.admin.service.UserService;
import com.tt.admin.vo.UserVO;
import com.tt.common.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDeptDao userDeptDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserVO> findByCondition(UserVO userVO) {
        PageHelper.startPage(userVO.getPageNum(), userVO.getPageSize());
        if (userVO.getDeptId().equals(0)) {
            userVO.setDeptId(null);
        }
        return userDao.findByCondition(userVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserVO userVO) {
        User user = BeanUtil.copyProperties(userVO, User.class);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userDao.save(user);

        UserDept userDept = new UserDept();
        userDept.setDeptId(userVO.getDeptId());
        userDept.setUserId(user.getId());
        userDeptDao.save(userDept);

        UserRole userRole = new UserRole();
        userRole.setRoleId(userVO.getRoleId());
        userRole.setUserId(user.getId());
        userRoleDao.save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserVO userVO) {
        User user = BeanUtil.copyProperties(userVO, User.class);
        user.setUpdateTime(new Date());
        userDao.update(user);
        if (userVO.getDeptId() != null) {
            UserDept userDept = userDeptDao.findByUserId(user.getId());
            if (userDept == null) {
                userDept = new UserDept();
                userDept.setDeptId(userVO.getDeptId());
                userDept.setUserId(user.getId());
                userDeptDao.save(userDept);
            } else {
                userDept.setDeptId(userVO.getDeptId());
                userDeptDao.update(userDept);
            }
        }
        if (userVO.getRoleId() != null) {
            UserRole userRole = userRoleDao.findByUserId(user.getId());
            if (userRole == null) {
                userRole = new UserRole();
                userRole.setRoleId(userVO.getRoleId());
                userRole.setUserId(user.getId());
                userRoleDao.save(userRole);
            } else {
                userRole.setRoleId(userVO.getRoleId());
                userRoleDao.update(userRole);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        userDao.deleteById(id);
        userDeptDao.deleteByUserId(id);
    }

    @Override
    public UserVO findByUsername(String username) {
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        List<UserVO> userList = userDao.findByCondition(userVO);
        if (CollectionUtils.isEmpty(userList)) {
            log.error("{}-用户不存在", username);
            throw new RuntimeException("用户不存在");
        }
        if (userList.size() > 1) {
            log.error("{}-查询到多个用户", username);
            throw new RuntimeException("查询到多个用户");
        }
        return userList.get(0);
    }

    @Override
    public void updateCurrentUser(UserVO userVO) {
        User user = BeanUtil.copyProperties(userVO, User.class);
        user.setUpdateTime(new Date());
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        }
        userDao.update(user);
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.encrypt("superadmin", "admin"));
    }
}
