package com.lhq.cloud.security.sso.userPart.service;

import java.util.List;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission;

public interface SysPermissionService {

	Sys_Permission selectSysPermissionById(int id);

	List<Sys_Permission> selectSysPermissions();
}
