package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumListDetails;

/**
 * Servlet implementation class ViewAllAlbumListsServlet
 */
@WebServlet("/viewAllAlbumListsServlet")
public class ViewAllAlbumListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAlbumListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlbumListDetailsHelper aldh = new AlbumListDetailsHelper();
		List<AlbumListDetails> ald = aldh.getAlbumLists();
		request.setAttribute("allAlbums", ald);
		if(ald.isEmpty()) {
			request.setAttribute("allAlbums", "");
		}
		getServletContext().getRequestDispatcher("/user-album-lists.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
