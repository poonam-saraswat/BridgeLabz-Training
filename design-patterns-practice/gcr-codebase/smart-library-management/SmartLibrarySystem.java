public class SmartLibrarySystem {
    public static void main(String[] args){
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student  = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");
        User librarian = UserFactory.createUser("librarian", "Mr. John");

        student.showRole();
        faculty.showRole();
        librarian.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);

        Book book = new Book.BookBuilder("Design Patterns")
                            .author("Gang Of Four")
                            .edition("2nd Edition")
                            .genre("Software Engineering")
                            .build();
        
        catalog.addBook(book);
    }
}
