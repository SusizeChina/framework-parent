package com.lhq.cloud.security.sso.userPart.service.impl;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission_Role;
import com.lhq.cloud.security.sso.userPart.mapper.SysPermissionRoleMapper;
import com.lhq.cloud.security.sso.userPart.service.SysPermissionRoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class BaseSysPermissionRoleService implements SysPermissionRoleService {

    private final SysPermissionRoleMapper SysPermissionRoleMapper;

    public BaseSysPermissionRoleService(SysPermissionRoleMapper SysPermissionRoleMapper) {
        this.SysPermissionRoleMapper = SysPermissionRoleMapper;
    }

    public List<Sys_Permission_Role> selectPermissionRole(int role_id) {
        return SysPermissionRoleMapper.selectPermissionRole(role_id);
    }

}
