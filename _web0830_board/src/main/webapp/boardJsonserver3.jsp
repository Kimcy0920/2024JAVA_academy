<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
	String jdbcUrl = "jdbc:mysql://localhost:3307/spring5fs";
	String jdbcUser = "root";
	String jdbcPassword = "mysql";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String action = ""; // request.getParameter("action") / json으로 받아서 필요 없어짐
    String responseJson = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        // JSON 데이터 파싱 ----------------------------------------
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) { // 라인단위로 읽어옴
            sb.append(line);
        }
        // System.out.println(sb); // println으로 확인하기
        JSONObject jsonData = new JSONObject(sb.toString());
        action = jsonData.getString("action");
        // ------------------------------------------------------

        if ("create".equalsIgnoreCase(action)) {
        	String writer = jsonData.getString("writer");
            String title = jsonData.getString("title");
            String content = jsonData.getString("content");
            
            String sql = "INSERT INTO board (writer, title, content, regtime, hits) VALUES (?, ?, ?, now(), 0)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("read".equalsIgnoreCase(action)) {
            String sql = "SELECT * FROM board";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("num", rs.getInt("num"));
                jsonObject.put("writer", rs.getString("writer"));
                jsonObject.put("title", rs.getString("title"));
                jsonObject.put("content", rs.getString("content"));
                jsonObject.put("regtime", rs.getString("regtime"));
                jsonObject.put("hits", rs.getInt("hits"));
                jsonArray.put(jsonObject);
            }
            responseJson = jsonArray.toString();

        } else if ("update".equalsIgnoreCase(action)) {
        	int num = jsonData.getInt("num");
        	String writer = jsonData.getString("writer");
            String title = jsonData.getString("title");
            String content = jsonData.getString("content");
            String regtime = jsonData.getString("regtime");
            int hits = jsonData.getInt("hits");

            String sql = "UPDATE board SET writer=?, title=?, content=? WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.setInt(4, num);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("delete".equalsIgnoreCase(action)) {
            int num = jsonData.getInt("num");

            String sql = "DELETE FROM board WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseJson = "{\"error\":\"An error occurred while processing the request.\"}";
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }

    out.print(responseJson);
%>