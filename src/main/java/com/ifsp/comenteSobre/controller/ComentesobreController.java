package com.ifsp.comenteSobre.controller;


import com.ifsp.comenteSobre.model.Post;
import com.ifsp.comenteSobre.service.ComentesobreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ComentesobreController {

    @Autowired
    ComentesobreService comentesobreService;

    @RequestMapping(value = "/comment-sobre", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = comentesobreService.findAll();
        mv.addObject("posts",posts);
        return mv;
    }

    @RequestMapping(value="/comment-sobre/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = comentesobreService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newcomment",method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newcomment", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newcomment";
        }
        post.setData(LocalDate.now());
        comentesobreService.save(post);
        return "redirect:/comment-sobre";
    }

}
