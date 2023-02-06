import java.util.List;
import java.util.Scanner;

import controller.AlbumHelper;
import model.Album;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Jan 23, 2023
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static AlbumHelper ah = new AlbumHelper();
	
	public static void main(String[] args) {
		boolean runProgram = true;	

		while(runProgram) {
			System.out.println("Welcome to the Album List Creator");
			System.out.println("1 : Add an Album");
			System.out.println("2 : Edit an Album");
			System.out.println("3 : Delete an Album");
			System.out.println("4 : View all Albums");
			System.out.println("5 : Exit Program");
			System.out.print("Make a Selection: ");
			int select = in.nextInt();
			in.nextLine();

			//Add Album
			if(select == 1) {
				addAlbum();
			}
			//Edit Album
			else if(select == 2) {
				editAlbum();
			}
			//Delete Album
			else if(select == 3) {
				deleteAlbum();
			}
			//Show all Albums
			else if(select == 4) {
				viewAlbum();
			}
			//Exit
			else {
				System.out.println("Thank you for using the app.");
				runProgram = false;
			}
		}
	}
	private static void addAlbum() {
		System.out.println("");
		System.out.print("Enter Album Name: ");
		String name = in.nextLine();
		System.out.print("Enter Artist Name: ");
		String artist = in.nextLine();
		System.out.print("Enter Genre: ");
		String genre = in.nextLine();
		System.out.print("Enter Number of Songs: ");
		int songs = in.nextInt();
		
		Album add = new Album(name, artist, genre, songs);
		ah.addAlbum(add);
	}
	
	private static void editAlbum() {
		System.out.print("Enter Album Name: ");
		String name = in.nextLine();
		System.out.print("Enter Artist Name: ");
		String artist = in.nextLine();
		Album find = new Album(name, artist);
		Album found = ah.findAlbum(find);
		if(found != null){
			boolean runEdit = true;
			
			while(runEdit) {
				System.out.println("");
				System.out.println("Found Album: " + found.printFullAlbum());
				System.out.println("1: Edit Name ");
				System.out.println("2: Edit Artist Name ");
				System.out.println("3: Edit Genre ");
				System.out.println("4: Edit Number of Songs ");
				System.out.println("5: Save ");
				System.out.print("Make Selection: ");
				int makeSelection = in.nextInt();
				in.nextLine();
				if(makeSelection == 1) {
					System.out.print("Enter Album Name: ");
					String editName = in.nextLine();
					found.setAlbumName(editName);
				}
				else if(makeSelection == 2) {
					System.out.print("Enter Artist Name: ");
					String editArtist = in.nextLine();
					found.setArtist(editArtist);
				}
				else if(makeSelection == 3) {
					System.out.print("Enter Genre: ");
					String editGenre = in.nextLine();
					found.setGenre(editGenre);
				}
				else if(makeSelection == 4) {
					System.out.print("Enter Number of Songs: ");
					int editSongs = in.nextInt();
					found.setNumberOfSongs(editSongs);
				}
				else {
					runEdit = false;
					ah.editAlbum(found);
				}
			}
			
		} else {
			System.out.println(name + " by " + artist + ": Album Not Found");
		}
	}
	
	private static void deleteAlbum() {
		System.out.println("");
		System.out.print("Enter Album Name: ");
		String name = in.nextLine();
		System.out.print("Enter Artist Name: ");
		String artist = in.nextLine();
		
		Album delete = new Album(name, artist);
		ah.deleteAlbum(delete);
	}
	private static void viewAlbum() {
		List<Album> allAlbums = ah.showAllAlbums();
		System.out.println("");
		for(Album album : allAlbums) {
			System.out.println(album.printFullAlbum());
		}
		System.out.println("");

	}
	
}
