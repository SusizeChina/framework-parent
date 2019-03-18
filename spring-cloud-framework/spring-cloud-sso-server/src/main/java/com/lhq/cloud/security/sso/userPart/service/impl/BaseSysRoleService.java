package com.lhq.cloud.security.sso.userPart.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role;
import com.lhq.cloud.security.sso.userPart.mapper.SysRoleMapper;
import com.lhq.cloud.security.sso.userPart.service.SysRoleService;

@Service
@Primary
public class BaseSysRoleService implements SysRoleService {

	private final SysRoleMapper sysRoleMapper;

	public BaseSysRoleService(SysRoleMapper sysRoleMapper){
		this.sysRoleMapper = sysRoleMapper;
	}

	@Override
	public Sys_Role selectRoleById(int id) {
		return sysRoleMapper.selectRoleById(id);
	}

	@Override
	public List<Sys_Role> selectRoles() {
		return sysRoleMapper.selectRoles();
	}
}
