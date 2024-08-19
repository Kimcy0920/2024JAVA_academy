package mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class memDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public memDAO() {
		session = sqlsession_f.openSession(true);
	}

	public memDTO memLogin(memDTO dto) {
		return session.selectOne("memMapper.selectLogin", dto);
	}

	public memDTO memCheck(String id) {
		return session.selectOne("memMapper.selectId", id);
	}

	public void memSignup(memDTO dto) {
		session.insert("memMapper.insertMem", dto);
	}

	public void memUpdate(memDTO dto) {
		session.update("memMapper.updateMem", dto);
	}
}
