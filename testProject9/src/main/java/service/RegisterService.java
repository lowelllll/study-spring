package service;

import dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import word.WordSet;

public class RegisterService {

    private WordDao wordDao;

    @Autowired
    public RegisterService(WordDao wordDao) {
        this.wordDao = wordDao;
    }

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

}