package com.example.manytoone.CustomRepos;

import com.example.manytoone.Models.Footballer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomFootballerRepoImpl implements CustomFootballerRepo{
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<Footballer> criteriaQuery;
    private Root<Footballer> root;

    @PostConstruct
    public void init(){
        this.session = sessionFactory.openSession();
        this.criteriaBuilder = session.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(Footballer.class);
        this.root = criteriaQuery.from(Footballer.class);
    }

    @Override
    public List<Footballer> getSortedById() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("id")));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Footballer> getSortedByFirstName() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("first_name")));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Footballer> getSortedByLastName() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("last_name")));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Footballer> getSortedByTeamId() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("team_id")));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
