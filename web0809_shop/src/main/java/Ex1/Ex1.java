package Ex1;

import shop.ProductDAO;
import shop.ProductDTO;

public class Ex1 {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.getProductById(1);
		System.out.println(dto);

	}

}
