package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

/**
 * Servlet implementation class AddAlbumServlet
 */
@WebServlet("/addAlbumServlet")
public class AddAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String albumName = request.getParameter("albumName");
		String artist = request.getParameter("artist");
		String genre = request.getParameter("genre");
		int numberOfSongs = Integer.parseInt(request.getParameter("numSongs"));
		AlbumHelper ah = new AlbumHelper();
		Album newAlbum = new Album(albumName, artist, genre, numberOfSongs);
		ah.addAlbum(newAlbum);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
