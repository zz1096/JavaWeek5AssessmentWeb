package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Jan 23, 2023
 */
@Entity
@Table(name="albums")
public class Album {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="ALBUMNAME")
	private String albumName;
	@Column(name="ARTIST")
	private String artist;
	@Column(name="NUMBEROFSONGS")
	private int numberOfSongs;
	@Column(name="GENRE")
	private String genre;
	
	public Album() {
		super();
	}
	public Album(String albumName, String artist) {
		super();
		this.albumName = albumName;
		this.artist = artist;
	}
	public Album(String albumName, String artist, String genre, int numberOfSongs) {
		super();
		this.albumName = albumName;
		this.artist = artist;
		this.genre = genre;
		this.numberOfSongs = numberOfSongs;
	}

	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getNumberOfSongs() {
		return numberOfSongs;
	}
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String printFullAlbum() {
		return albumName + " by " + artist + " Genre: " + genre 
				+ " Songs: " + numberOfSongs;
	}
	public String printAlbum() {
		return albumName + " by " + artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
