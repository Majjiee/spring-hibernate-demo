

import dao.IDao;
import entities.Product;
import entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import util.HibernateConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(HibernateConfig.class)
public class ProductDaoTest {

    @Autowired
    private IDao<Product> productDao;

    @Autowired
    private IDao<Category> categoryDao;

    @Test
    void testCreateProduct() {
        Category category = new Category("Test Category");
        categoryDao.create(category);

        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(200);
        product.setCategory(category);

        assertTrue(productDao.create(product));
        assertNotNull(productDao.findById(product.getId()));
    }
}
