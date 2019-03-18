package com.lhq.cloud.security.sso.userPart.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission_Role;
import com.lhq.cloud.security.sso.userPart.mapper.SysPermissionRoleMapper;
import com.lhq.cloud.security.sso.userPart.service.SysPermissionRoleService;

@Service
@Primary
public class BaseSysPermissionRoleService implements SysPermissionRoleService {

	private final SysPermissionRoleMapper SysPermissionRoleMapper;

	public BaseSysPermissionRoleService(SysPermissionRoleMapper SysPermissionRoleMapper){
		this.SysPermissionRoleMapper = SysPermissionRoleMapper;
	}
	
	public List<Sys_Permission_Role> selectPermissionRole(int role_id){
		return SysPermissionRoleMapper.selectPermissionRole(role_id);
	}
	
}
