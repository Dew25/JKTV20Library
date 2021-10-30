/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Reader;
import entity.Book;
import entity.Author;
import entity.History;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import keeper.FileKeeper;

/**
 *
 * @author Melnikov
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    List<History> histories = new ArrayList<>();
    Keeping keeper = new FileKeeper();
    //Keeping keeper = new BaseKeeper();

    public App() {
        books = keeper.loadBooks();
        readers = keeper.loadReaders();
        histories = keeper.loadHistories();
    }
    
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить книгу");
            System.out.println("2: Список книг");
            System.out.println("3: Добавить читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдать книгу");
            System.out.println("6: Список выданных книг");
            System.out.println("7: Вернуть книгу");
            
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0: 
                    repeat="q";
                    System.out.println("Программа закончена");
                    break;
                case 1: 
                    addBook();
                    break;
                case 2: 
                    printListBooks();
                    break;
                case 3: 
                    addReader();
                    break;
                case 4: 
                    printListReaders();
                    break;
                case 5: 
                    addHistory();
                    break;
                case 6: 
                    printGivenBooks();
                    break;
                case 7: 
                    returnBook();
                    break;
            }
        }while("y".equals(repeat));
    }
    private void printGivenBooks(){
        System.out.println("Список выданных книг: ");
        int n = 0;
        for (int i = 0; i < histories.size(); i++) {
            //если history не null и книга не возварщена и книг в наличии меньше
            // чем записано в quantity -
            // печатаем книгу
            if(histories.get(i) != null 
                    && histories.get(i).getReturnDate() == null
                    && histories.get(i).getBook().getCount()
                        <histories.get(i).getBook().getQuantity()
                    ){
                System.out.printf("%d. Книгу: %s читает %s %s%n",
                        i+1,
                        histories.get(i).getBook().getCaption(),
                        histories.get(i).getReader().getFirstname(),
                        histories.get(i).getReader().getLastname()
                );
                n++;
            }
        }
        if(n < 1){
            System.out.println("Выданных книг нет");
        }
    }
    private void addHistory(){
        System.out.println("Выдача книги: ");
        History history = new History();
        /**
         * 1. Вывести нумерованный список книг
         * 2. получить от пользователя номер книги: bookNumber
         * 3. Вывести список читателей
         * 4. получить от пользователя номер читателя: readerNumber
         * 5. В history инициировать поле book объектом, который лежит в
         *      массиве books[bookNumber-1].
         * 6. В history инициировать поле reader объектом, который лежит в 
         *      массиве readers[readerNumber-1].
         * 7. Получить текущую дату и положить ее в поле history.givenDate
         * 
         */
        printListBooks();
        System.out.print("Введите номер книги: ");
        int bookNumber = scanner.nextInt(); scanner.nextLine();
        history.setBook(books.get(bookNumber-1));
        System.out.println();
        System.out.println("Список читателей: ");
        printListReaders();
        System.out.print("Введите номер читателя: ");
        int readerNumber = scanner.nextInt(); scanner.nextLine();
        history.setReader(readers.get(readerNumber-1));
        Calendar c = new GregorianCalendar();
        history.setGivenDate(c.getTime());
        books.get(bookNumber-1).setCount(history.getBook().getCount() - 1);
        keeper.saveBooks(books);
        histories.add(history);
        keeper.saveHistories(histories);
    }
    private void addReader(){
        System.out.println("Добавление читателя: ");
        Reader reader = new Reader();
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона читателя: ");
        reader.setPhone(scanner.nextLine());
        readers.add(reader);
        keeper.saveReaders(readers);
    }
    private void addBook(){
        System.out.println("Добавление книги: ");
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setCaption(scanner.nextLine());
        System.out.print("Введите год издания: ");
        book.setPublishedYear(scanner.nextInt()); scanner.nextLine();
        System.out.print("Введите количество экземпляров книги: ");
        book.setQuantity(scanner.nextInt()); scanner.nextLine();
        book.setCount(book.getQuantity());
        System.out.print("Сколько авторов у книги: ");
        int countAuthors=scanner.nextInt(); scanner.nextLine();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < countAuthors; i++) {
            System.out.println("Добавление автора "+(i+1));
            Author author = new Author();
            System.out.print("Имя автора: ");
            author.setName(scanner.nextLine());
            System.out.print("Фамилия автора: ");
            author.setLastname(scanner.nextLine());
            System.out.print("Год рождения автора: ");
            author.setYear(scanner.nextInt());
            System.out.print("День рождения автора: ");
            author.setDay(scanner.nextInt());
            System.out.print("Месяц рождения автора: ");
            author.setMonth(scanner.nextInt()); scanner.nextLine();
            authors.add(author);
        }
        book.setAuthor(authors);
        books.add(book);
        keeper.saveBooks(books);
    }

    private void printListBooks() {
       System.out.println("Список книг: ");
        books = keeper.loadBooks();
        for (int i = 0; i < books.size(); i++) {
            StringBuilder cbAutors = new StringBuilder();
            for (int j = 0; j < books.get(i).getAuthor().size(); j++) {
                cbAutors.append(books.get(i).getAuthor().get(j).getName())
                        .append(" ")
                        .append(books.get(i).getAuthor().get(j).getLastname())
                        .append(". ");
            }
            if(books.get(i) != null && books.get(i).getCount() > 0){
                System.out.printf("%d. %s. %s В наличии экземпряров: %d%n"
                        ,i+1
                        ,books.get(i).getCaption()
                        ,cbAutors.toString()
                        ,books.get(i).getCount()
                );
            }
        }
    }

    private void printListReaders() {
        System.out.println("Список читателей: ");
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i) != null){
                System.out.printf("%d. %s%n",i+1,readers.get(i).toString());
            }
        }
    }

    private void returnBook() {
        System.out.println("Вернуть книгу: ");
        printGivenBooks();
        System.out.print("Выберите возвращаемую книгу: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        Calendar c = new GregorianCalendar();
        histories.get(historyNumber - 1).setReturnDate(c.getTime());
        for (int i = 0; i < books.size(); i++) {
          if(books.get(i).getCaption().equals(histories.get(historyNumber-1).getBook().getCaption())){
            books.get(i).setCount(books.get(i).getCount()+1);
          }
        }
        keeper.saveBooks(books);
        keeper.saveHistories(histories);
    }
    
}
