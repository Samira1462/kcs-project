package ir.karafarinbank.dao;

import ir.karafarinbank.model.Matcher;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatcherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Matcher> findMatcherByPageName() {
        Query q = sessionFactory.getCurrentSession().createQuery("select m from Matcher m");
        List<Matcher> list = q.list();
        return list;
    }
}
