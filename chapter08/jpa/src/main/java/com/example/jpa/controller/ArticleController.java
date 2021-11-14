package com.example.jpa.controller;

import com.example.jpa.entity.Article;
import com.example.jpa.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 新增11111111111111111111111
     *
     * @return
     */
    @GetMapping("/add")
    public String add() {
        System.out.println("add");
        return "article/add";
    }

    /**
     * 保存方法222222222222222222
     *
     * @param article
     * @return
     */
    @PostMapping("")
    public String save(Article article) {
        System.out.println("save");
        articleRepository.save(article);
        return "redirect:/article/";
    }

    /**
     *333333333333333333333333
     *
     * @param start
     * @param limit
     * @return
     */
    @RequestMapping("")
    public ModelAndView getAll(@RequestParam(value = "start", defaultValue = "0") Integer start,
                               @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        System.out.println("getAll");
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("article/list");
        mav.addObject("page", page);
        return mav;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") Integer id) {
        System.out.println("get");
        Article article = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", article);
        return mav;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("delete");
        articleRepository.deleteById(id);
        return "redirect:";
    }





    /**
     * 编辑55555555555555
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        System.out.println("edit");
        Article article = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article", article);
        return mav;
    }

    /**
     * 修改并保存6666666666666
     * @param article
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public String editAndSave(Article article, long id){
        System.out.println("editAndSave");
        article.setId(id);
        articleRepository.save(article);
        return "redirect:";
    }

}

