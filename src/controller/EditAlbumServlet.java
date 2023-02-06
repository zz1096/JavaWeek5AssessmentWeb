package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

/**
 * Servlet implementation class EditAlbumServlet
 */
@WebServlet("/editAlbumServlet")
public class EditAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlbumServlet() {
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
		AlbumHelper ah = new AlbumHelper();
		String albumName = request.getParameter("albumName");
		String artist = request.getParameter("artist");
		String genre = request.getParameter("genre");
		int numberOfSongs = Integer.parseInt(request.getParameter("numSongs"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Album edit = ah.findAlbumID(tempId);
		edit.setAlbumName(albumName);
		edit.setArtist(artist);
		edit.setGenre(genre);
		edit.setNumberOfSongs(numberOfSongs);
		ah.editAlbum(edit);
		getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);

	}

}
