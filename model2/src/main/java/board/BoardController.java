package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	BoardService boardService;
	ArticleVO articleVO;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("board.init() 실행");

		boardService = new BoardService();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("board.doGet() 실행");

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("board.doPost() 실행");

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String nextPage;
		String action = request.getPathInfo();	// URL에서 요청명을 가져옴

		try {

			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();

			if (action == null) {

				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/views/board/list.jsp";

			} else if (action.equals("/list")) {	// 게시글 조회

				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/views/board/list.jsp";

			} else {

				nextPage = "/views/board/list.jsp";

			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void destroy() {

		System.out.println("board.destroy() 실행");

	}

}
