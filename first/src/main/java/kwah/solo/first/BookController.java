package kwah.solo.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String, Object> map) { // @RequestParam 어노테이션을 통해서, HTTP 파라미터를 map 변수에 자동으로 바인딩한다.
        ModelAndView mav = new ModelAndView();

        String bookId = this.bookService.create(map);
        if (bookId == null) {
            mav.setViewName("redirect:/create"); // redirect는 refresh와 비슷한 역할이라 보면 된다.
            // setViewName() 메서드를 통해서, View의 경로를 지정한다.
        } else {
            mav.setViewName("redirect:detail?bookId="+bookId);
        }

        return mav;
    }
}
