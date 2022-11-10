package com.orange.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.model.system.SysLoginLog;
import com.orange.model.vo.SysLoginLogQueryVo;
import com.orange.system.mapper.SysLoginLogMapper;
import com.orange.system.service.SysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Li ZhiCheng
 * @create: 2022-11-2022/11/10 14:46
 * @description:
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo) {
        return sysLoginLogMapper.selectPage(pageParam, sysLoginLogQueryVo);
    }
}
