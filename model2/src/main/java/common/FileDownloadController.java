package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownloadController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "C:\\files\\board\\article_image";	// 상수로 선언

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("download.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("download.doGet() 실행");

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("download.doPost() 실행");

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String imageFileName = request.getParameter("imageFileName");
		String articleNO = request.getParameter("articleNO");
		System.out.println("imageFileName: " + imageFileName);
		OutputStream out = response.getOutputStream();
		String path = ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + imageFileName;	// 글 번호에 대한 파일 경로를 설정
		File imageFile = new File(path);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);	// 이미지 파일을 내려받는데 필요한 response에 헤더 정보를 설정
		FileInputStream in = new FileInputStream(imageFile);
		byte[] buffer = new byte[1024 * 8];	// 버퍼를 이용해 한 번에 8kb씩 전송

		while (true) {

			int count = in.read(buffer);
			if (count == -1) break;
			out.write(buffer, 0, count);

		}

		in.close();
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("download.destroy() 실행");

	}

}
