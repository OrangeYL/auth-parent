package com.orange.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.model.system.SysRole;
import com.orange.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 16:59
 * @description: 系统角色
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * @description: 分页查询系统角色
     * @author: Li ZhiCheng
     * @date: 2022/10/27 19:00
     * @param: [page, roleQueryVo]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.orange.model.system.SysRole>
     **/
    IPage<SysRole> selectPage(Page<SysRole> page, @Param("vo") SysRoleQueryVo roleQueryVo);
}
