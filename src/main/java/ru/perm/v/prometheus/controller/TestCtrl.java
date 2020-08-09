package ru.perm.v.prometheus.controller;

import io.micrometer.core.instrument.Counter;
import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.perm.v.prometheus.dto.Dto;

@Controller
public class TestCtrl {
    private static final Logger LOG = Logger.getLogger(TestCtrl.class);
    private final Counter counterEcho;
    String namePage = "page";

    public TestCtrl(@Autowired Counter counterEcho) {
        this.counterEcho = counterEcho;
    }

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute(new Dto());
        return namePage;
    }

    @PostMapping("/inc")
    public String inc(
            @ModelAttribute("dto") Dto dto, Model model) {
        LOG.info(dto.toString());
        dto.incId();
        model.addAttribute("dto", dto);
        return namePage;
    }

    @GetMapping(value = {"/echo", "/echo/{msg}"})
    public ResponseEntity<String> echo(@PathVariable(name = "msg", required = false) String msg) {
        if (msg == null) {
            msg = "-";
            counterEcho.increment();
        }
        LOG.info(msg);
        return new ResponseEntity<>("ok:" + msg, HttpStatus.OK);
    }

}
