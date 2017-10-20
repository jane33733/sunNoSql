package productTest;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.Gson;
import com.sun.service.ProductService;
import com.sun.service.impl.ProductServiceImpl;
import com.sun.vo.db.Product;

public class ProductTest {

	private Gson gson = new Gson();
	
	public void insert() {
		ProductService ps = new ProductServiceImpl();
		
		Product product = new Product();
		product.setpId("A001");
		product.setName("咖哩飯");
		product.setPrice(BigDecimal.TEN);
		
		System.out.println("新增" + gson.toJson(product) );
		
		ps.addProduct(product);
	}

	public void query() {
		ProductService ps = new ProductServiceImpl();
		List<Product> result = ps.queryAll();
		System.out.println("所有產品" + gson.toJson(result));
	}
	
	public void delete() {
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct("A001");
		
	}
	
}
