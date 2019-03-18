package com.lhq.cloud.security.sso.userPart.service;

import java.util.List;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role;

public interface SysRoleService {

	Sys_Role selectRoleById(int id);

	List<Sys_Role> selectRoles();
}
