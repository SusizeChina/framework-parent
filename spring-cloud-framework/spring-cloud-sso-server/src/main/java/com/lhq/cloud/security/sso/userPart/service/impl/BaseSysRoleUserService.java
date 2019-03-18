package com.lhq.cloud.security.sso.userPart.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role_User;
import com.lhq.cloud.security.sso.userPart.mapper.SysRoleUserMapper;
import com.lhq.cloud.security.sso.userPart.service.SysRoleUserService;

@Service
@Primary
public class BaseSysRoleUserService implements SysRoleUserService {

	private final SysRoleUserMapper SysRoleUserMapper;

	public BaseSysRoleUserService(SysRoleUserMapper SysRoleUserMapper){
		this.SysRoleUserMapper = SysRoleUserMapper;
	}


	@Override
	public List<Sys_Role_User> selectByUser_id(int user_id) {
		return SysRoleUserMapper.selectByUser_id(user_id);
	}
}
