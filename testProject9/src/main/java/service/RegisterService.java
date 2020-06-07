package service;

import dao.WordDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import word.WordSet;

public class RegisterService implements InitializingBean, DisposableBean {

    @Autowired
    private WordDao wordDao;

    public void register(WordSet wordSet) {
        String wordKey = wordSet.getWordKey();
        if(verify(wordKey)) {
            wordDao.insert(wordSet);
            System.out.println("registered.");
        } else {
            System.out.println("The word has already registered.");
        }
    }

    public boolean verify(String wordKey){
        WordSet wordSet = wordDao.select(wordKey);
        return wordSet == null;
    }

    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("빈이 생성됬어용");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("빈이 소멸됬어요ㅠ");
    }
}