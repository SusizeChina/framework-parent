package com.lhq.cloud.security.sso.userPart.service;

import java.util.List;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role_User;

public interface SysRoleUserService {

	List<Sys_Role_User> selectByUser_id(int user_id);
}
