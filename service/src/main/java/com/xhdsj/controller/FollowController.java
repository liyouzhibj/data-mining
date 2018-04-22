package com.xhdsj.controller;


import com.xhdsj.model.Follow;
import com.xhdsj.model.sup.Code;
import com.xhdsj.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述: 控制类
 *
 * @auther: njw
 * @date: 2018/4/17
 */

@Controller
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService FollowService;

    @RequestMapping("/selectFollowById")
    @ResponseBody
    public Follow getFollow(int id){
        Follow follo = FollowService.selectByPrimaryKey(id);

        return follo;
    }

    @RequestMapping("/saveFollow")
    @ResponseBody
    public Code saveFollow(Follow follow){

        return FollowService.insert(follow);
    }
}
