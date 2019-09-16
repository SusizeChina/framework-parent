package com.lhq.cloud.security.sso.userPart.service;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission_Role;

import java.util.List;

public interface SysPermissionRoleService {

    List<Sys_Permission_Role> selectPermissionRole(int role_id);

}
