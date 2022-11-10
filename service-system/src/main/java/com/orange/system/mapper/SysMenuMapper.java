package com.orange.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.model.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-11-2022/11/2 18:41
 * @description:
 */
@Mapper
public interface SysMenuMapper  extends BaseMapper<SysMenu> {

    /**
     * @description: 通过用户id查找菜单列表
     * @author: Li ZhiCheng
     * @date: 2022/11/3 14:09
     * @param: [userId]
     * @return: java.util.List<com.orange.model.system.SysMenu>
     **/
    List<SysMenu> findListByUserId(@Param("userId") Long userId);
}
