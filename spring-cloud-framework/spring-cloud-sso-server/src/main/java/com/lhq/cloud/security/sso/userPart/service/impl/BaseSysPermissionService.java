package com.lhq.cloud.security.sso.userPart.service.impl;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission;
import com.lhq.cloud.security.sso.userPart.mapper.SysPermissionMapper;
import com.lhq.cloud.security.sso.userPart.service.SysPermissionService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class BaseSysPermissionService implements SysPermissionService {

    private final SysPermissionMapper sysPermissionMapper;

    public BaseSysPermissionService(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    @Override
    public Sys_Permission selectSysPermissionById(int id) {
        return sysPermissionMapper.selectSysPermissionById(id);
    }

    @Override
    public List<Sys_Permission> selectSysPermissions() {
        return sysPermissionMapper.selectSysPermissions();
    }
}
