package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import com.codegym.model.BlogForm;
import com.codegym.model.Category;
import com.codegym.service.author.IAuthorService;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IAuthorService authorService;

    @ModelAttribute("authors")
    public Iterable<Author> authors() {
        return authorService.findAll();
    }
    @ModelAttribute("categories")
    public Iterable<Author> categories() {
        return authorService.findAll();
    }

    @GetMapping("/blog")
    ModelAndView showListBlog(Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        return new ModelAndView("/list", "blogList", blogList);
    }

    @GetMapping("blog/compose")
    ModelAndView showComposeForm() {
        BlogForm newBlog = new BlogForm();
        newBlog.setId((long) (blogService.findAll().size()+1));
        return new ModelAndView("/view", "blogForm", newBlog);
    }

    @Autowired
    Environment env;
    @PostMapping("blog/compose")
    String composeBlog(@ModelAttribute("blogForm") BlogForm blogForm) {
        Blog blog = new Blog(blogForm.getId(), blogForm.getBlogName(), blogForm.getContent(), blogForm.getAuthor(),null, blogForm.getCategory());
        MultipartFile multipartFile = blogForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(blogForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        blog.setLink(fileName);
        blogService.save(blog);
        return "redirect:/blog";
    }

}
