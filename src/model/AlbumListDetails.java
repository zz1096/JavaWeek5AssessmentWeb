package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Feb 9, 2023
 */
@Entity
public class AlbumListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Album> albumList;

	public AlbumListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumListDetails(int id, String listName, User user, List<Album> albumList) {
		super();
		this.id = id;
		this.listName = listName;
		this.user = user;
		this.albumList = albumList;
	}
	
	public AlbumListDetails(String listName, User user, List<Album> albumList) {
		super();
		this.listName = listName;
		this.user = user;
		this.albumList = albumList;
	}

	public AlbumListDetails(String listName, User user) {
		super();
		this.listName = listName;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	@Override
	public String toString() {
		return "AlbumListDetails [id=" + id + ", listName=" + listName + ", user=" + user + ", albumList=" + albumList
				+ "]";
	}
	
	
}
