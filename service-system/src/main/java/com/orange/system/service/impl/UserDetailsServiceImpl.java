package com.orange.system.service.impl;

import com.orange.model.system.SysUser;
import com.orange.system.custom.CustomUser;
import com.orange.system.service.SysMenuService;
import com.orange.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-11-2022/11/3 15:25
 * @description:
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUsername(username);
        if(null == sysUser){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        if(sysUser.getStatus() == 0){
            throw new RuntimeException("账号已停用！");
        }
        List<String> userPermsList = sysMenuService.findUserPermsList(Long.parseLong(sysUser.getId()));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String perm : userPermsList) {
            authorities.add(new SimpleGrantedAuthority(perm.trim()));
        }
        return new CustomUser(sysUser, authorities);
    }
}
