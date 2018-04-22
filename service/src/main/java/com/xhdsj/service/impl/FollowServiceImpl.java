package com.xhdsj.service.impl;

import com.xhdsj.dao.FollowMapper;
import com.xhdsj.model.Follow;
import com.xhdsj.model.sup.Code;
import com.xhdsj.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public Follow selectByPrimaryKey(Integer id) {
        Follow follow = new Follow();
        if(id==null || id<0){
            follow.setCode(Code.fail("id不正确"));
            return follow;
        }
        return followMapper.selectByPrimaryKey(id);
    }

    @Override
    public Code insert(Follow record) {
        if(record.getUserId() == null || record.getUserId()<0) return Code.fail("用户id不正确");
        if(record.getArticleId() == null ||  record.getArticleId()<0) return Code.fail("文章id不正确");
        record.setDeleteFlag((short) 0);
        record.setFollowTime(new Date());
        int i= followMapper.insert(record);
        if(i==1) return Code.success();
        return Code.fail();
    }
}
