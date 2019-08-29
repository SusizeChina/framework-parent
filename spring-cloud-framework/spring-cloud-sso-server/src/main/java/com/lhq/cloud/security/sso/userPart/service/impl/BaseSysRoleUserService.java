package com.lhq.cloud.security.sso.userPart.service.impl;

import com.lhq.cloud.security.sso.userPart.entity.Sys_Role_User;
import com.lhq.cloud.security.sso.userPart.mapper.SysRoleUserMapper;
import com.lhq.cloud.security.sso.userPart.service.SysRoleUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class BaseSysRoleUserService implements SysRoleUserService {

    private final SysRoleUserMapper SysRoleUserMapper;

    public BaseSysRoleUserService(SysRoleUserMapper SysRoleUserMapper) {
        this.SysRoleUserMapper = SysRoleUserMapper;
    }


    @Override
    public List<Sys_Role_User> selectByUser_id(int user_id) {
        return SysRoleUserMapper.selectByUser_id(user_id);
    }
}
