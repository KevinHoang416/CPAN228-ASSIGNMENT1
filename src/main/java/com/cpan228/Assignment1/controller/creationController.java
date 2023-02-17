package com.cpan228.Assignment1.controller;

import java.util.EnumSet;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cpan228.Assignment1.model.Item;
import com.cpan228.Assignment1.model.Item.Brand;
import com.cpan228.Assignment1.model.ItemPool;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/creation")
@SessionAttributes("itemPool")
public class creationController {

    @GetMapping
    public String creation() {
        return "creation";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted", brands);
    }

    @ModelAttribute(name = "itemPool")
    public ItemPool itemPool() {
        return new ItemPool();
    }

    @ModelAttribute
    public Item item() {
        return Item
                .builder()
                .build();
    }

    @PostMapping
    public String addItem(@Valid Item item,
            @ModelAttribute ItemPool pool, Errors error) {
        if (error.hasErrors()) {
            return "creation";
        }
        pool.add(item);
        return "redirect:/creation";
    }

}
