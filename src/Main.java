import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        notebook.addSampleNotes();
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        while (play) {
            try {
                    System.out.println("***********************************");
                    System.out.println("1. Add note");
                    System.out.println("2. Remove note");
                    System.out.println("3. Search for note by phrase");
                    System.out.println("4. Search for note by author");
                    System.out.println("5. Remove author's notes");
                    System.out.println("6. Search for notes by date");
                    System.out.println("7. Sort notes Ascending");
                    System.out.println("8. Print all notes");
                    System.out.println("9. Print notes from notebook");
                    System.out.println("10. Remove notebook");
                    System.out.println("11. Print notebooks");
                    System.out.println("0. End");
                    System.out.println("***********************************");
                    int userChoice = sc.nextInt();
                    switch (userChoice) {
                        case 1 -> {
                            notebook.addNote();
                        }
                        case 2 -> {
                            notebook.removeNote();
                        }
                        case 3 -> {
                            notebook.searchNotes();
                        }
                        case 4 -> {
                            notebook.getNotesByAuthor();
                        }
                        case 5 -> {
                            notebook.removeNotesByAuthor();
                        }
                        case 6 -> {
                            notebook.getNotesByDate();
                        }
                        case 7 -> {
                            notebook.sortNotes();
                        }
                        case 8 -> {
                            notebook.printNote();
                        }
                        case 9 -> {
                            notebook.searchNotesByNotebook();
                        }
                        case 10 -> {
                            notebook.removeNotebook();
                        }
                        case 11 -> {
                            notebook.printNotebooks();
                        }
                        case 0 -> {
                            play = false;
                        }
                    }
            } catch (Exception e) {
                System.out.println("Something went wrong :/");
            }
        }
    }
}