package file;

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
public class Download extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Download.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Download.doHandle() 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String file_repo = "C:\\file_repo";
		String fileName = request.getParameter("fileName");	// 매개변수로 전송된 파일 이름을 읽어옴
		System.out.println("fileName: " + fileName);

		OutputStream out = response.getOutputStream();			// response에서 OutputStream 객체를 가져옴

		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName= " + fileName);	// 파일을 다운로드할 수 있음
		FileInputStream in = new FileInputStream(f);

		byte[] buffer = new byte[1024 * 8];									// 버퍼 기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력

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

		System.out.println("Download.destroy() 실행");

	}

}
