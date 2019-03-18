package com.lhq.cloud.security.sso.userPart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role;

import java.util.List;

@Mapper
@Component
public interface SysRoleMapper {

	@Select("select * from sys_role where id = #{id}")
	Sys_Role selectRoleById(int id);

	@Select("select * from sys_role where 1=1")
	List<Sys_Role> selectRoles();

}
