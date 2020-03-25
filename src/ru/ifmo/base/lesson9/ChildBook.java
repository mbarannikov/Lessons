package ru.ifmo.base.lesson9;

import java.util.Arrays;

public class ChildBook extends Book implements Cloneable {
    private String[] pics;

    @Override
    public ChildBook clone() throws CloneNotSupportedException {
        ChildBook book =  (ChildBook) super.clone();
        book.setAuthor(author.clone());
//        ChildBook book = new ChildBook(pics);
//        book.setAuthor(author.clone());
//        book.setTitle(title);
        return book;
    }

    public ChildBook(String[] pics) {
        this.pics = pics;
    }

    @Override
    public String toString() {
        return "ChildBook{" +
                "pics=" + Arrays.toString(pics) +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }

    public void setPics(String[] pics) {
        this.pics = pics;
    }

    public String[] getPics() {
        return pics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildBook childBook = (ChildBook) o;
        return Arrays.equals(pics, childBook.pics);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(pics);
        return result;
    }
}
