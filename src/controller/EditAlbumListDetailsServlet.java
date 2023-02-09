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
 * Servlet implementation class EditAlbumListDetailsServlet
 */
@WebServlet("/editAlbumListDetailsServlet")
public class EditAlbumListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlbumListDetailsServlet() {
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
		AlbumHelper ah = new AlbumHelper();
		UserHelper uh = new UserHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AlbumListDetails listToEdit = aldh.searchForAlbumListById(tempId);
		
		String newListName = request.getParameter("listName");
		String userName = request.getParameter("name");
		User newUser = uh.findUser(userName);
		try {
			String[] selectedAlbums = request.getParameterValues("allAlbumsToAdd");
			List<Album> selectedAlbumsInList = new ArrayList<Album>();
			for(int i = 0; i < selectedAlbums.length; i++) {
				System.out.println(selectedAlbums[i]);
				Album a = ah.findAlbumID(Integer.parseInt(selectedAlbums[i]));
				selectedAlbumsInList.add(a);
			}
			listToEdit.setAlbumList(selectedAlbumsInList);
		} catch(NullPointerException e) {
			List<Album> selectedAlbumsInList = new ArrayList<Album>();
			listToEdit.setAlbumList(selectedAlbumsInList);
		}
		listToEdit.setListName(newListName);
		listToEdit.setUser(newUser);
		aldh.editList(listToEdit);
		getServletContext().getRequestDispatcher("/viewAllAlbumListsServlet").forward(request, response);
		
			
	}

}
