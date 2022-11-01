package board;

import java.util.List;

public class BoardService {

	BoardDAO boardDAO;

	public BoardService() {

		boardDAO = new BoardDAO();

	}

	// 게시글 조회
	public List<ArticleVO> listArticles() {

		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;

	}

	// 글 등록
	public int addArticle(ArticleVO article) {

		return boardDAO.insertNewArticle(article);

	}

	// 글 보기
	public ArticleVO viewArticle(int articleNO) {

		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		return article;

	}

	// 글 수정
	public void modArticle(ArticleVO article) {

		boardDAO.updateArticle(article);

	}

	// 글 삭제
	public List<Integer> removeArticle(int articleNO) {

		List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return articleNOList;

	}

}
