package productTest;

import java.math.BigDecimal;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.sun.service.ProductService;
import com.sun.service.impl.ProductServiceImpl;
import com.sun.vo.db.Product;

public class ProductTest {

	private Gson gson = new Gson();
	public void insert() {
		ProductService ps = new ProductServiceImpl();
		
		Product product = new Product();
		product.setpId(new ObjectId());
		product.setName("咖哩飯");
		product.setPrice(BigDecimal.TEN);
		
		ps.addProduct(product);
	}

}
