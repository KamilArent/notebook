import java.time.LocalDate;

public class Note {
    private String text, author;
    private LocalDate date;
    private int notebookId;

    public Note(String text, String author, int notebookId, LocalDate date) {
        this.text = text;
        this.author = author;
        this.notebookId = notebookId;
        this.date = date;
    }

    public void printNote(){;
        System.out.println("author: " + author);
        System.out.println("-----");
        System.out.println("text: " + text);
        System.out.println("-----");
        System.out.println("notebook: " + notebookId);
        System.out.println("-----");
        System.out.println("data: " + date);
        System.out.print("\n");
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getNotebookId() {
        return notebookId;
    }

    public Boolean search(String word){
        return (text.toLowerCase().contains(word.toLowerCase()));

    }

}