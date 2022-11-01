package board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "C:\\files\\board\\article_image";	// 상수로 선언
	BoardService boardService;
	ArticleVO articleVO;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("board.init() 실행");

		boardService = new BoardService();
		articleVO = new ArticleVO();

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

			} else if (action.equals("/write")) {	// 글쓰기 페이지

				nextPage = "/views/board/write.jsp";

			} else if (action.equals("/create")) {	// 글 등록

				int articleNO = 0;

				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");

				articleVO.setParentNO(0);	// 새 글의 부모 글 번호를 0으로 설정
				articleVO.setId("hong");	// 새 글 작성자 ID를 hong으로 설정
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO);	// 테이블에 새 글을 추가한 후 새 글에 대한 글 번호를 가져옴

				if (imageFileName != null && imageFileName.length() != 0) {	// 파일을 첨부한 경우에만 수행함

					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);	// temp 폴더에 임시로 업로드된 파일 객체를 생성
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);	// CURR_IMAGE_REPO_PATH의 경로 하위에 글 번호로 폴더를 생성
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);	// tmep 폴더의 파일을 글 번호를 이름으로 하는 폴더로 이동

				}

				PrintWriter out = response.getWriter();	// 새 글 등록 메시지를 나타낸 후 자바스크립트 location 객체의 href 속성을 이용해 글 목록을 요청함
				out.print("<script>alert(`새 글을 추가했습니다.`); location.href=`/model2/board/list`;</script>");

				return;

			} else {

				nextPage = "/views/board/list.jsp";

			}

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 업로드
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);	// 글 이미지 저장 폴더에 대해 파일 객체를 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {

			List<FileItem> items = upload.parseRequest(request);

			for (int i = 0; i < items.size(); i++) {

				FileItem fileItem = items.get(i);

				if (fileItem.isFormField()) {

					System.out.println(fileItem.getFieldName() + ": " + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));	// 파일 업로드로 같이 전송된 새 글 관련 매개변수를 Map에 (key, value)로 저장한 후 반환하고, 새 글과 관련된 title, content를 Map에 저장

				} else {

					System.out.println("파라미터명: " + fileItem.getFieldName());
					System.out.println("파일명: " + fileItem.getName());
					System.out.println("파일크기: " + fileItem.getSize() + "bytes");

					// articleMap.put(fileItem.getFieldName(), fileItem.getName());
					if (fileItem.getSize() > 0) {	// 업로드한 파일이 존재하는 경우 업로드한 파일의 파일 이름으로 저장소에 업로드

						int idx = fileItem.getName().lastIndexOf("\\");

						if (idx == -1) {

							idx = fileItem.getName().lastIndexOf("/");

						}

						String fileName = fileItem.getName().substring(idx + 1);	// 첨부한 파일을 먼저 temp 폴더에 업로드
						System.out.println("파일명: " + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);  // 업로드된 파일의 파일 이름을 Map에 ("imageFileName", "업로드파일이름")으로 저장 // 익스플로러에서 업로드 파일의 경로 제거 후 map에 파일명 저장
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return articleMap;

	}

	@Override
	public void destroy() {

		System.out.println("board.destroy() 실행");

	}

}
