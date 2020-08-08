package ru.perm.v.prometheus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.perm.v.prometheus.dto.Dto;

@Controller
@RequestMapping("")
public class TestCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(TestCtrl.class);
    String namePage = "page";

    @GetMapping("/")
    public String echo(Model model) {
        model.addAttribute(new Dto());
        return namePage;
    }

    @PostMapping("/inc")
    public String inc(
            @ModelAttribute("dto") Dto dto, Model model) {
        LOG.info("{}", dto);
        dto.incId();
        model.addAttribute("dto", dto);
        return namePage;
    }
}
