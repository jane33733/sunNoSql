package productTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.service.ProductService;
import com.sun.service.impl.ProductServiceImpl;
import com.sun.vo.db.Product;
import com.sun.vo.output.ProductInfoVO;

public class ProductTest {

	private String testExcel = "D:\\testCase.xlsx";
	private Gson gson = new Gson();
	
	public void create5() {
		ProductService ps = new ProductServiceImpl();
		
		List<Product> pList = new ArrayList();
		String[] nameArr = {"伯爵紅茶", "梅子綠茶", "珍珠奶茶", "美式咖啡", "抹茶拿鐵"};
		int[] priceArr = {20, 35, 50, 80, 130};
		
		for (int i = 0; i < 5; i++) {
			pList.add(Product.create("A00"+i, nameArr[i], priceArr[i]));
		}
		
		System.out.println("新增" + gson.toJson(pList) );
		ps.addProductList(pList);
		
	}
	
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
		List<ProductInfoVO> result = ps.queryAll();
		System.out.println("所有產品" + gson.toJson(result));
	}
	
	public void delete() {
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct("A001");
	}
	
//	public List<BoardVO> getTestData() {
//	
//	List<BoardVO> dataList = new ArrayList<>();
//	try {
//		FileInputStream fis = new FileInputStream(new File(testExcel));
//		
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sh = wb.getSheetAt(0);
//		int colNum = sh.getRow(0).getLastCellNum();
//		int rowNum = sh.getLastRowNum()+1;
//		
//		for (int i = 1; i < rowNum; i++) {
//			XSSFRow row = sh.getRow(i);
//			BoardVO inputVO = new BoardVO();
//			inputVO.setPlant(row.getCell(0).getStringCellValue());
//			inputVO.setStartTime( Integer.parseInt(row.getCell(1).getStringCellValue()) );
//			inputVO.setLine(row.getCell(2).getStringCellValue());
//			inputVO.setQty( (int)(row.getCell(3).getNumericCellValue()));
//			inputVO.setPn(row.getCell(4).getStringCellValue());
//			inputVO.setModel(row.getCell(5).getStringCellValue());
//			dataList.add(inputVO);
////			for (int j = 1; j < colNum; j++) {
////				XSSFCell col = row.getCell(j);
////			}
//		}
//	
//		System.out.println("[test data]"+gson.toJson(dataList));
//		
////		fun.addCalendar(inputList, userId);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return dataList;
//}

	
}
