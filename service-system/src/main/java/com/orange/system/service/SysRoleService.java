package com.orange.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.model.system.SysRole;
import com.orange.model.vo.AssginRoleVo;
import com.orange.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 17:03
 * @description:
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * @description: 分页查询系统角色
     * @author: Li ZhiCheng
     * @date: 2022/10/27 19:00
     * @param: [page, roleQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.orange.model.system.SysRole>
     **/
    IPage<SysRole> selectPage(Page<SysRole> page, @Param("vo") SysRoleQueryVo roleQueryVo);
    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> getRolesByUserId(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);

}
