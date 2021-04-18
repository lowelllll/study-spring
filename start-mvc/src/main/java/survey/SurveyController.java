package survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/survey")
public class SurveyController {

    @GetMapping
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questions", createQuestions());
        modelAndView.setViewName("survey/surveyForm");
        return modelAndView;
    }

    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data) {
        return "survey/submitted";
    }

    private List<Question> createQuestions() {
        Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버", "프론트", "풀스택"));
        Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("eclipse", "intellij", "sublimetext"));
        Question q3 = new Question("하고싶은말을 적어주세요.");

        return Arrays.asList(q1, q2, q3);
    }
}
