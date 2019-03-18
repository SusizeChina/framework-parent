package com.lhq.cloud.security.sso.userPart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role_User;

import java.util.List;

@Mapper
@Component
public interface SysRoleUserMapper {

	@Select("select * from sys_role_user where sys_user_id = #{user_id}")
	List<Sys_Role_User> selectByUser_id(int user_id);
}
