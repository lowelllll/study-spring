package survey;


import java.util.List;

public class AnsweredData {
    private List<String> responses;
    private Respondent res; // 중첩 프로퍼티

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public Respondent getRes() {
        return res;
    }

    public void setRes(Respondent res) {
        this.res = res;
    }
}
