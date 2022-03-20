package com.example.manytoone.CustomRepos;

import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.Team;
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
public class CustomTeamRepoImpl implements CustomTeamRepo{
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<Team> criteriaQuery;
    private Root<Team> root;

    @PostConstruct
    public void init(){
        this.session = sessionFactory.openSession();
        this.criteriaBuilder = session.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(Team.class);
        this.root = criteriaQuery.from(Team.class);
    }

    @Override
    public List<Team> getSortedById() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("id")));
        Query<Team> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Team> getSortedByName() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("name")));
        Query<Team> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Team> getSortedByCreationDate() {
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("creation_date")));
        Query<Team> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
