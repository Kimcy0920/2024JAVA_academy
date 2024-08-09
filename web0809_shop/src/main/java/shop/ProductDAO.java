package shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public ProductDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<ProductDTO> getAllProducts() {
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		return session.selectList("ProductMapper.selectAllProducts");
	}

	public void addProduct(ProductDTO product) {
		session.insert("ProductMapper.insertProduct", product);
	}

	public ProductDTO getProductById(int id) {
		return session.selectOne("ProductMapper.selectProductById");
	}

	public void updateProduct(ProductDTO product) {
		session.update("ProductMapper.updateProduct", product);
	}

	public void deleteProduct(int id) {
		session.delete("ProductMapper.deleteProduct", id);
	}
}
