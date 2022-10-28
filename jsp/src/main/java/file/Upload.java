package file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class Upload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Upload.init() 실행");

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

		System.out.println("Upload.doHandle() 실행");

		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		File currentDirPath = new File("C:\\file_repo");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);	// 파일 경로 설정
		factory.setSizeThreshold(1024 * 1024);	// 최대 업로드 가능한 파일 크기

		ServletFileUpload upload = new ServletFileUpload(factory);

		try {

			List<FileItem> items = upload.parseRequest(request);	// request 객체에서 매개변수를 List에 저장

			for (int i = 0; i < items.size(); i++) {

				FileItem fileItem = items.get(i);	// 파일 업로드창에서 업로드 된 항목들을 하나씩 가져옴

				if (fileItem.isFormField()) {			// 폼 필드이면 전송된 매개변수 값을 출력

					System.out.println(fileItem.getFieldName() + ": " + fileItem.getString(encoding));

				} else {													// 폼 필드가 아니면 파일 업로드 기능 수행

					System.out.println("파라미터명: " + fileItem.getFieldName());
					System.out.println("파일명: " + fileItem.getName());
					System.out.println("파일크기: " + fileItem.getSize() + "bytes");
					System.out.println();

					if (fileItem.getSize() > 0) {		// 업로드한 파일 이름을 가져옴

						int idx = fileItem.getName().lastIndexOf("\\");

						if (idx == -1) {

							idx = fileItem.getName().lastIndexOf("/");

						}

						String fileName = fileItem.getName().substring(idx + 1);	// 업로드한 파일 이름으로 저장소에 파일 업로드
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void destroy() {

		System.out.println("Upload.destroy() 실행");

	}

}
