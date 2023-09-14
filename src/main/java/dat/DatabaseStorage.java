package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DatabaseStorage<T> implements DataStorage<T>
{
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private Class<T> type;

    public DatabaseStorage(Class<T> type)
    {
        this.type = type;
    }

    @Override
    public void store(T data)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }
    }

    @Override
    public T retrieve()
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            T data = em.find(type, 1);
            em.getTransaction().commit();
            return data;
        }
    }
}
