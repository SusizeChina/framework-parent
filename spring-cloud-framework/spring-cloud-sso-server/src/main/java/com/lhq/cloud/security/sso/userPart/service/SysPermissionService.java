package com.lhq.cloud.security.sso.userPart.service;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission;

import java.util.List;

public interface SysPermissionService {

    Sys_Permission selectSysPermissionById(int id);

    List<Sys_Permission> selectSysPermissions();
}
