package co.com.suramericana.controller;

import co.com.suramericana.service.rules.RulesManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan({"co.com.suramericana.service"})
@RequestMapping("/")
public class RulesController {

    @Autowired
    RulesManagement rulesManagement;

    @RequestMapping(value = "/rules", method = RequestMethod.POST)
    public void processRule(@RequestParam("id") String idRule)  {
        rulesManagement.processRule(idRule);
    }
}
