package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;

	public BoardDAO() {

		try {

			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 게시글 조회
	public List<ArticleVO> selectAllArticles() {

		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();

		try {

			conn = dataFactory.getConnection();
			String query = "select level, articleNO, parentNO, title, content, id, writeDate from t_board start with parentNO = 0 connect by prior articleNO = parentNO order siblings by articleNO desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);

			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return articlesList;

	}

	// 최신 글
	private int getNewArticleNO() {

		try {

			conn = dataFactory.getConnection();
			String query = "select max(articleNO) from t_board";	// 가장 큰 글 번호
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next()) return (rs.getInt(1) + 1);	// 가장 큰 글 번호에 1을 더함
			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;

	}

	// 글 등록
	public int insertNewArticle(ArticleVO article) {

		int articleNO = getNewArticleNO();	// 새 글을 추가하기 전에 새 글에 대한 글 번호를 가져옴

		try {

			conn = dataFactory.getConnection();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			String query = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id) values (?, ? ,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return articleNO;

	}

}
