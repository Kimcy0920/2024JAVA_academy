package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.BoardDTO;
import file.FileDAO;
import file.FileDTO;
import mem.memDAO;
import mem.memDTO;
import service.Service;
import shop.CartDAO;
import shop.Product;
import shop.ProductDAO;

@WebServlet("/")
public class Controller extends HttpServlet {
	// 시작위치, 모든 요청은 컨트롤러에서 받아서 처리함
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String view = null;
		HttpSession session = request.getSession();

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

//---------------------------------MEMBER CONTROLLER------------------------------
		// 메인 화면 동작
		if (com.equals("/main") || (com.equals("/"))) { // 메인화면
			request.setCharacterEncoding("utf-8");
			view = "main.jsp";
			// 로그인 동작 수행
		} else if (com.equals("/login_view")) { // 로그인 화면
			view = "login_form.jsp";
			
		} else if (com.equals("/login_view")) {
			view = "login_form.jsp";
			
		} else if (com.equals("/login_form")) {
			
			request.setCharacterEncoding("utf-8");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			memDAO mdao = new memDAO();
			memDTO mdto = mdao.memLogin(new memDTO(id, pw, "", ""));
			
			if (mdto != null) { // 로그인 정보 확인
				session.setAttribute("id", mdto.getId());
				session.setAttribute("name", mdto.getName());
				view = "redirect:main";
			} else {
				out.println("<script>alert('아이디 또는 비밀번호가 틀립니다!');" + "history.back()</script>");
				out.close();
				view = "redirect:login_form";
			}

		} else if (com.equals("/logout")) { // 로그아웃
			session.invalidate();
			view = "redirect:main";

		} else if (com.equals("/login_notice")) { // 로그인 안내문
			out.println("<script>alert('로그인 후 이용이 가능합니다.');"
					+ "location.href='login_view'; </script>");
			
		} else if (com.equals("/mem_update_view")){ // 회원정보 수정
			view = "mem_update_form.jsp";
			
		} else if (com.equals("/mem_update_form")) {
			request.setCharacterEncoding("utf-8");
			String id = (String) session.getAttribute("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");

			memDAO dao = new memDAO();
			dao.memUpdate(new memDTO(id, pw, name, tel));
			out.println("<script>alert('수정이 완료되었습니다.');"
					+ "location.href='logout'; </script>");

		} else if (com.equals("/mem_delete")) {
			String id = (String) session.getAttribute("id");
			memDAO dao = new memDAO();
			dao.memDelete(id);
			out.println("<script>alert('회원 탈퇴되었습니다.');"
					+ "location.href='logout'; </script>");
			
		} else if (com.equals("/signup_view")) { // 회원가입 화면
			view = "signup_form.jsp";
			
		} else if (com.equals("/signup_form")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");

			memDAO dao = new memDAO();
			memDTO dto = dao.memCheck(id);
			memDTO dto2 = new memDTO(id, pw, name, tel);

			if (dto != null) { // 회원정보 비교
				out.println("<script>alert('이미 등록된 아이디입니다.');" + "history.back(); </script>");
				out.close();
			} else {
				dao.memSignup(dto2);
				out.println("<script>alert('가입이 완료되었습니다.');" + "location.href='login_view'; </script>");
			}
		}

//---------------------------------BOARD CONTROLLER------------------------------
		else if (com.equals("/list")) { // 게시판 화면
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;

			request.setAttribute("msgList", new Service().getMsgList(pageNo));
			request.setAttribute("pgnList", new Service().getPagination(pageNo));
			view = "/list.jsp";

		} else if (com.equals("/view")) { // 게시판 글 화면
			int num = Integer.parseInt(request.getParameter("num"));

			request.setAttribute("msg", new Service().getMsg(num));
			String id = request.getParameter("id");
			view = "/view.jsp";
			
		} else if (com.equals("/write")) { // 게시판 작성 화면
			String tmp = request.getParameter("num");
			int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;
			
			String name = (String) session.getAttribute("name");
			BoardDTO dto = new BoardDTO();
			String action = "insert";

			if (num > 0) {
				dto = new Service().getMsgForWrite(num);
				action = "update?num=" + num;
			}

			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "/write.jsp";

		} else if (com.equals("/insert")) { // 게시판 글 작성 화면
			request.setCharacterEncoding("utf-8");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String regtime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);

			try {
				new Service().writeMsg(writer, title, content, regtime);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "/errorBack.jsp";
			}

		} else if (com.equals("/update")) { // 게시판 글 수정 화면
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			try {
				new Service().updateMsg(writer, title, content, num);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "/errorBack.jsp";
			}

		} else if (com.equals("/delete")) { // 게시판 글 삭제
			int num = Integer.parseInt(request.getParameter("num"));

			new Service().deleteMsg(num);
			view = "redirect:list";
		}

//---------------------------------FILE CONTROLLER------------------------------
		else if (com.equals("/webhard")) { // 자료실 화면
			FileDAO fdao = new FileDAO();
			request.setAttribute("list", fdao.getAllwebhard());
			view = "/webhard.jsp";
		} else if (com.equals("/add_file")) { // 자료실 파일 등록

			MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/files"), 100 * 1024 * 1024,
					"utf-8", new DefaultFileRenamePolicy());

			File file = multi.getFile("upload");

			if (file != null) {
				String curTime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);

				FileDAO dao = new FileDAO();
				FileDTO dto = new FileDTO(0, file.getName(), curTime, (int) file.length());
				dao.insertFile(dto);

				// 메인 페이지로 돌아가기
				view = "redirect:webhard";
			} else {
				out.println("<script>alert('업로드할 파일을 선택해주세요.');" + "history.back();</script>");
			}
		} else if (com.equals("/del_file")) { // 자료실 파일 삭제
			int num = Integer.parseInt(request.getParameter("num"));
			FileDAO dao = new FileDAO();
			FileDTO dto = dao.getFileByNum(num);

			if (dto != null) {
				// 지정된 파일 삭제
				File file = new File(request.getServletContext().getRealPath("/files/") + dto.getFname());
				if (file != null) {
					file.delete();
				}
				dao.deleteFile(num);
			}
			view = "redirect:webhard";
		}
		
//---------------------------------PRODUCT CONTROLLER------------------------------
		else if (com.equals("/productList")) { // 쇼핑몰 화면
			ProductDAO pdao = new ProductDAO();
			List<Product> products = pdao.getAllProducts();
			request.setAttribute("products", products);
//			out.println("<script>let flag = $ {flag};"
//					+ "if (flag) { alert('선택하신 상품은 삭제하실 수 없습니다.'); }</script>");
			view = "productList.jsp";
			
		} else if (com.equals("/registProduct_view")) {
			view = "registProduct.jsp";
			
		} else if (com.equals("/registProduct")) { // 물품 등록 화면
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			Product product = new Product(0, name, description, Double.parseDouble(price), Integer.parseInt(stock));
			ProductDAO productDAO = new ProductDAO();
			productDAO.addProduct(product);
			view = "redirect:productList";
			
		} else if (com.equals("/modifyProduct")) {	// 물품 정보 수정 화면
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.getProductById(Integer.parseInt(id));
			request.setAttribute("product", product);
			view = "modifyProduct.jsp";
			
		} else if (com.equals("/updateProduct")) { // 물품 정보 수정
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			Product product = new Product(Integer.parseInt(id), name, description, Double.parseDouble(price), Integer.parseInt(stock));
			ProductDAO productDAO = new ProductDAO();
			productDAO.updateProduct(product);	
			view = "redirect:productList";
			
		} else if (com.equals("/deleteProduct")) { // 물품 삭제
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");

			ProductDAO productDAO = new ProductDAO();
			boolean ret = productDAO.deleteProduct(Integer.parseInt(id));
			request.setAttribute("flag", ret);
			view = "redirect:productList";
		}
		
//---------------------------------CART CONTROLLER------------------------------
		else if (com.equals("/viewCart")) { // 장바구니 화면
			CartDAO dao = new CartDAO();
			request.setAttribute("list", dao.viewCart());
//			out.println("<script>let flag = $ {flag};"
//					+ "if (flag) { alert('선택하신 상품은 수량이 부족합니다.');"
//					+ "location.href='productList' }</script>");
			view = "viewCart.jsp";
			
		} else if (com.equals("/addToCart")) {
			String id = request.getParameter("id");
			CartDAO dao = new CartDAO();
			ProductDAO pdao = new ProductDAO();
			System.out.println(pdao.countProducts(Integer.parseInt(id)));
			if (pdao.countProducts(Integer.parseInt(id)) <= 0) {

				out.println("장바구니에 담을 수량이 부족합니다!");
				request.setAttribute("flag", true);
			} else {
				pdao.decreaseStock(Integer.parseInt(id));
				
				dao.addToCart(Integer.parseInt(id));
			}

			request.setAttribute("list", dao.viewCart());
			view = "redirect:productList";
		
		} else if (com.equals("/deleteCart")) {
			String id = request.getParameter("id");
			CartDAO dao = new CartDAO();
			dao.deleteProduct(Integer.parseInt(id));
			view = "redirect:viewCart";
		}
		
		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}