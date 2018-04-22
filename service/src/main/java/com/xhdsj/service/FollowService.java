package com.xhdsj.service;

import com.xhdsj.model.Follow;
import com.xhdsj.model.sup.Code;

public interface FollowService {

    Follow selectByPrimaryKey(Integer id);

    Code insert(Follow record);
}
