package com.lhq.cloud.security.sso.userPart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Permission_Role;

import java.util.List;

@Mapper
@Component
public interface SysPermissionRoleMapper {

	@Select("select * from sys_permission_role where role_id = #{role_id}")
	List<Sys_Permission_Role> selectPermissionRole(int role_id);

}