package ir.karafarinbank.service;

import ir.karafarinbank.dao.MatcherDao;
import ir.karafarinbank.model.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatcherService {

    @Autowired
    MatcherDao matcherDao;

    @Transactional(readOnly = true)
    public List<Matcher> loadMatcherByPageName() {

        List<Matcher> matcher = matcherDao.findMatcherByPageName();
        return matcher;
    }
}
