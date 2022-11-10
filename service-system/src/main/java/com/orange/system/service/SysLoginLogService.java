package com.orange.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.model.system.SysLoginLog;
import com.orange.model.vo.SysLoginLogQueryVo;

/**
 * @author: Li ZhiCheng
 * @create: 2022-11-2022/11/10 14:42
 * @description:
 */
public interface SysLoginLogService extends IService<SysLoginLog> {
    //列表显示
    IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo);
}
