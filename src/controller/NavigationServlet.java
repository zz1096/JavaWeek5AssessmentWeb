package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("selectedValue");
		String path = "/viewAllAlbumsServlet";
		if(act.equals("Add")) {
			path = "/index.html";
		} else if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Album delete = ah.findAlbumID(tempId);
				ah.deleteAlbum(delete);
			} 
			catch(NumberFormatException e) {
				System.out.println("Album not selected");
			}
		} else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Album edit = ah.findAlbumID(tempId);
				request.setAttribute("edit", edit);
				path = "/edit-album.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Album not selected");
			}
			

		}
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
