<<<<<<< HEAD
package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item{

    private String author;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
=======
package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item{

    private String author;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
>>>>>>> 7ef2dc0fd420941bf2eef0bbc256547f91d7a77f
