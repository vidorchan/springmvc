package main.java.vidor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloWorld {
    private static final String INDEX = "index";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printlnWelcome() {
        Map<String, Object> model = new HashMap<>();
        model.put("message","hello world");
        return new ModelAndView(INDEX, model);
    }
}
