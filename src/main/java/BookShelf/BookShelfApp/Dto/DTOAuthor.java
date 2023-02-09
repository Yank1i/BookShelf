package BookShelf.BookShelfApp.Dto;

import java.time.LocalDate;
import java.util.Objects;

public class DTOAuthor {

	private int id;
	private String name;
	private String surname;
	private LocalDate born_date;
	private LocalDate death_date;
	private String country;
	private String genre;
	private String description;
	private boolean alive;
	private String comment;
	
	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(born_date, country, death_date, description, genre, id, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOAuthor other = (DTOAuthor) obj;
		return Objects.equals(born_date, other.born_date) && Objects.equals(country, other.country)
				&& Objects.equals(death_date, other.death_date) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "DTOAuthor [id=" + id + ", name=" + name + ", surname=" + surname + ", born_date=" + born_date
				+ ", death_date=" + death_date + ", country=" + country + ", genre=" + genre + ", description="
				+ description + "]";
	}

}
