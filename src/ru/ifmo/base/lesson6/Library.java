package ru.ifmo.base.lesson6;

public class Library {
   private String name = "Библиотека"; // свойство по умолчанию
   private  Book[] books = new Book[5];
    public String getName() {
        return name;
    }

    public void addBook(Book newBook) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null){ newBook.setInLibrary(true); books[i] = newBook; break;}
        }
        }

        public void addBook(Book ...newBooks) {
        for (int i = 0; i < newBooks.length; i++) {
            for (int j = 0; j < books.length; j++) {
                if (books[j] == null){ books[j] = newBooks[i]; books[j].setInLibrary(true);break;}
                if (j == books.length-1){ return;}
            }

        }
        }

//        public Book getHome(String title) {
//            for (int i = 0; i < books.length; i++) {
//                if(books[i]!=null&&
//                        books[i].getTitle().equals(title)&&
//                        books[i].isForHome()&&
//                        books[i].isInLibrary()
//                )
//                {
//                    books[i].setInLibrary(false);
//                return books[i];}
//            }
//            return null;
//        }
 //   }


}
