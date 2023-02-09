package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumListDetails;

/**
 * Servlet implementation class AlbumListNavServlet
 */
@WebServlet("/albumListNavServlet")
public class AlbumListNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumListNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlbumListDetailsHelper aldh = new AlbumListDetailsHelper();
		String act = request.getParameter("selectedValue");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllAlbumListsServlet").forward(request, response);
		}
		else if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AlbumListDetails deleteAlbumList = aldh.searchForAlbumListById(tempId);
				aldh.deleteAlbumList(deleteAlbumList);
			} catch(NumberFormatException e) {
				System.out.println("Nothing was selected");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAlbumListsServlet").forward(request, response);
			}
		}
		else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AlbumListDetails editAlbumList = aldh.searchForAlbumListById(tempId);
				request.setAttribute("editAlbumList", editAlbumList);
				AlbumHelper ah = new AlbumHelper();
				request.setAttribute("allAlbums", ah.showAllAlbums());
				if(ah.showAllAlbums().isEmpty()) {
					request.setAttribute("allAlbums", "");
				}
				getServletContext().getRequestDispatcher("/edit-album-list.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAlbumListsServlet").forward(request, response);
			}
		}
		else if(act.equals("Add")) {
			getServletContext().getRequestDispatcher("/addNewAlbumListServlet").forward(request, response);
		}
	}

}
