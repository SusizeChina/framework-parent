package com.lhq.cloud.security.sso.userPart.service;

import java.util.List;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission_Role;

public interface SysPermissionRoleService {

	List<Sys_Permission_Role> selectPermissionRole(int role_id);

}
