import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);
        IDao<Category> categoryDao = context.getBean(IDao.class); // only if your DAO is generic

        // 1️⃣ Create and save the Category first
        Category category = new Category();
        category.setLibelle("Electronique");
        categoryDao.create(category); // save the category first

        // 2️⃣ Now create the Product linked to it
        Product product = new Product();
        product.setName("Ordinateur Portable");
        product.setPrice(800.0);
        product.setCategory(category);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName() +
                " (Catégorie : " + category.getLibelle() + ")");
    }
}
