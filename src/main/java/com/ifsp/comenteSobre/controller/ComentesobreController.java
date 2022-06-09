package com.ifsp.comenteSobre.controller;


import com.ifsp.comenteSobre.model.Post;
import com.ifsp.comenteSobre.service.ComentesobreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ComentesobreController {

    @Autowired
    ComentesobreService comentesobreService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = comentesobreService.findAll();
        mv.addObject("posts",posts);
        return mv;
    }

}
