package hh.rpaserv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @GetMapping(path = "/")
    public String Index(HttpServletRequest request) {

        return "index";
    }
}
