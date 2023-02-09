package BookShelf.BookShelfApp.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
	private int id;

	@Column(name="name", nullable = false, length = 32)
	private String name;
	
	@Column(name="surname" , nullable = false, length = 32)
	private String surname;
	
	@Column(name="born_date", nullable = false)
	private LocalDate born_date;
	
	@Column(name="death_date")
	private LocalDate death_date;
	
	@Column(name="country" , nullable = false, length = 32)
	private String country;
	
	@Column(name="genre" , nullable = false, length = 32)
	private String genre;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="alive", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean alive;
	
	@Column(name="comment")
	private String comment;
	
	
	


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public LocalDate getBorn_date() {
		return born_date;
	}


	public void setBorn_date(LocalDate born_date) {
		this.born_date = born_date;
	}


	public LocalDate getDeath_date() {
		return death_date;
	}


	public void setDeath_date(LocalDate death_date) {
		this.death_date = death_date;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", born_date=" + born_date
				+ ", death_date=" + death_date + ", country=" + country + ", genre=" + genre + ", description="
				+ description + ", alive=" + alive + ", comment=" + comment + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(alive, born_date, comment, country, death_date, description, genre, id, name, surname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return alive == other.alive && Objects.equals(born_date, other.born_date)
				&& Objects.equals(comment, other.comment) && Objects.equals(country, other.country)
				&& Objects.equals(death_date, other.death_date) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}


	

}
