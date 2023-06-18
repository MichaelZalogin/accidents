package com.mch.accidents.repository.hibernate;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.repository.AccidentRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccidentRepositoryHibernate implements AccidentRepository {

    private final SessionFactory sf;

    @Override
    public Accident create(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    @Override
    public List<Accident> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    @Override
    public boolean update(Accident accident) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            """
                                    UPDATE Accident
                                    SET name = :fName,
                                    description = :fDescription,
                                    address = :fAddress,
                                    accident_type_id = :fAccident_type_id
                                    WHERE id = :fId
                                    """)
                    .setParameter("fName", accident.getName())
                    .setParameter("fDescription", accident.getText())
                    .setParameter("fAddress", accident.getAddress())
                    .setParameter("fAccident_type_id", accident.getType())
                    .setParameter("fAccident_type_id", accident.getRules())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return true;
    }

    @Override
    public Optional<Accident> findById(int id) {
        try (Session session = sf.openSession()) {
            return Optional.ofNullable(session.get(Accident.class, id));
        }
    }


}