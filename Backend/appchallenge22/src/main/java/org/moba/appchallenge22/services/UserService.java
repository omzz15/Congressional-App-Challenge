package org.moba.appchallenge22.services;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.moba.appchallenge22.domains.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class UserService {

    EntityManagerFactory emf;

    public UserService(){
        //makeData();
    }

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<User> getList(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();
    }

    public User getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    public User saveOrUpdateUser(User user){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User u = em.merge(user);
        em.getTransaction().commit();

        return u;
    }

    public void deleteUser(Long id){
        EntityManager em = emf.createEntityManager();
        em.remove(em.find(User.class, id));
    }

    public void makeData(){
        Faker faker = new Faker();

        for(int i = 0; i < 10; i++){
            User u = new User();
            Name name = faker.name();

            u.setFirstName(name.firstName());
            u.setLastName(name.lastName());
            u.setEmail(faker.internet().emailAddress());
            u.setPhoneNumber(faker.phoneNumber().phoneNumber());
        }
    }
}
