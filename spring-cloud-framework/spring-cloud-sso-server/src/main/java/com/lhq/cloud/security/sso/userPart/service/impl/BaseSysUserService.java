package com.lhq.cloud.security.sso.userPart.service.impl;

import com.lhq.cloud.security.sso.userPart.entity.Sys_User;
import com.lhq.cloud.security.sso.userPart.mapper.SysUserMapper;
import com.lhq.cloud.security.sso.userPart.service.SysUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BaseSysUserService implements SysUserService {

    private final SysUserMapper sysUserMapper;

    public BaseSysUserService(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public Sys_User selectById(int id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public Sys_User selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }
}
