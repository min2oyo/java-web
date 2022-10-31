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

	public List<ArticleVO> selectAllArticles() {	// 게시글 조회

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

}
