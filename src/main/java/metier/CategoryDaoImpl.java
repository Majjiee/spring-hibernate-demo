package metier;

import dao.IDao;
import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean create(Category category) {
        getSession().save(category);
        return true;
    }

    @Override
    public boolean delete(Category category) {
        getSession().delete(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        getSession().update(category);
        return true;
    }

    @Override
    public Category findById(int id) {
        return getSession().get(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return getSession().createQuery("from Category", Category.class).list();
    }
}
