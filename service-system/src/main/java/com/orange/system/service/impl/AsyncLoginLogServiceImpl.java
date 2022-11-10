package com.orange.system.service.impl;

import com.orange.model.system.SysLoginLog;
import com.orange.system.mapper.SysLoginLogMapper;
import com.orange.system.service.AsyncLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AsyncLoginLogServiceImpl implements AsyncLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status 状态
     * @param ipaddr ip
     * @param message 消息内容
     * @return
     */
    public void recordLoginLog(String username, Integer status, String ipaddr, String message) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setIpaddr(ipaddr);
        sysLoginLog.setMsg(message);
        // 日志状态
        sysLoginLog.setStatus(status);
        sysLoginLogMapper.insert(sysLoginLog);
    }
}
