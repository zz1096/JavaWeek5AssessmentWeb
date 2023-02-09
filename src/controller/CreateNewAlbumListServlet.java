package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.AlbumListDetails;
import model.User;

/**
 * Servlet implementation class CreateNewAlbumListServlet
 */
@WebServlet("/createNewAlbumListServlet")
public class CreateNewAlbumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAlbumListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlbumHelper ah = new AlbumHelper();
		String listName = request.getParameter("listName");
		String userName = request.getParameter("name");
		String[] selectedAlbums = request.getParameterValues("allAlbumsToAdd");
		List<Album> selectedAlbumsInList = new ArrayList<Album>();
		if(selectedAlbums != null && selectedAlbums.length > 0) {
			for(int i = 0; i < selectedAlbums.length; i++) {
				Album a = ah.findAlbumID(Integer.parseInt(selectedAlbums[i]));
				selectedAlbumsInList.add(a);
			}
			User user = new User(userName);
			AlbumListDetails ald = new AlbumListDetails(listName, user);
			ald.setAlbumList(selectedAlbumsInList);
			AlbumListDetailsHelper aldh = new AlbumListDetailsHelper();
			aldh.insertNewAlbumListDetails(ald);
		}
		getServletContext().getRequestDispatcher("/viewAllAlbumListsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
