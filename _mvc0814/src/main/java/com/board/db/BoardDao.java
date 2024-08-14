package com.board.db;

import java.sql.*;
import java.time.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public BoardDao() {
		session = sqlsession_f.openSession(true);
	}

    // 현재 시간을 문자열 형태로 반환
    private String getCurrentTime() {
        return LocalDate.now() + " " +
               LocalTime.now().toString().substring(0, 8);
    }

    // 게시글 갯수 얻기
    public int getNumRecords() {
        int numRecords = 0;

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select count(*) from board");
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return numRecords;
    }

    // 게시글 리스트 읽기
    public List<BoardDto> selectAllList() {
    	return session.selectList("BoardMapper.selectAllList");
    }
    
//        ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
//
//        try (
//            Connection conn = getConnection();
//            Statement stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery(String.format(
//                    "select * from board order by num desc limit %d, %d",
//                    start, listSize));
//        ) {
//            while (rs.next()) {
//
//                // 새 DTO 객체를 만들고 글 데이터를 이 객체에 저장
//                BoardDto dto = new BoardDto();
//
//                dto.setNum    (rs.getInt   ("num"    ));
//                dto.setWriter (rs.getString("writer" ));
//                dto.setTitle  (rs.getString("title"  ));
//                dto.setContent(rs.getString("content"));
//                dto.setRegtime(rs.getString("regtime"));
//                dto.setHits   (rs.getInt   ("hits"   ));
//
//                // 이 DTO 객체를 ArrayList에 추가
//                dtoList.add(dto);
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return dtoList;
//    }

    public BoardDto selectOne(int num) {
    	return session.selectOne("BoardMapper.selectOne", num);
    }
    
    public void updateHits(int num) {
    	session.update("BoardMapper.updateHits", num);
    }

    // DTO에 담긴 내용으로 새로운 레코드 저장
    public void insertOne(BoardDto dto) {
    	session.insert("BoardMapper.insertBoard", dto);
    }

    // DTO에 담긴 내용으로 게시글 데이터 업데이트
    public void updateOne(BoardDto dto) {
    	session.update("BoardMapper.updateBoard", dto);
    }

    // 지정된 글 번호의 레코드 삭제
    public void deleteOne(int num) {
    	session.delete("BoardMapper.deleteBoard", num);
    }
}