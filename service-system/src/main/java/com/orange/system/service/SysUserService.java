package com.orange.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.model.system.SysUser;
import com.orange.model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 17:03
 * @description:
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * @description: 分页查询系统角色
     * @author: Li ZhiCheng
     * @date: 2022/10/27 19:00
     * @param: [page, roleQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.orange.model.system.SysUser>
     **/
    IPage<SysUser> selectPage(Page<SysUser> page, @Param("vo") SysUserQueryVo roleQueryVo);

    /**
     * @description: 更新用户状态
     * @author: Li ZhiCheng
     * @date: 2022/11/3 13:44
     * @param: [id, status]
     * @return: void
     **/
    void updateStatus(Long id, Integer status);

    /**
     * @description: 通过用户名获取用户
     * @author: Li ZhiCheng
     * @date: 2022/11/3 13:44
     * @param: [username]
     * @return: com.orange.model.system.SysUser
     **/
    SysUser getByUsername(String username);

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    Map<String, Object> getUserInfo(String username);

}
