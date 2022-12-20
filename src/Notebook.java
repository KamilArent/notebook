import org.w3c.dom.ls.LSOutput;
import java.util.Iterator;
import java.time.LocalDate;
import java.util.*;

public class Notebook {
    private final ArrayList<Note> noteList;
    HashSet<Integer> notebooks = new HashSet<>();
    Scanner sc = new Scanner(System.in);

    public Notebook() {
        noteList = new ArrayList<>();
    }
    public void printNote(){
        for (Note n : noteList) {
            System.out.println("\nNote id: " + noteList.indexOf(n));
            System.out.println("-----");
            n.printNote();
        }
    }

    public void printNotebooks() {

        System.out.println("Notebook id's: " + notebooks);
    }

    public void addNote() {
        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Index of notebook: ");
        String notebookId = sc.nextLine();

        System.out.print("data: ");
        String data = sc.nextLine();

        int notebookIdInt = Integer.parseInt(notebookId);
        Note note = new Note(text, author, notebookIdInt, LocalDate.parse(data));
        //Note note = new Note(text, author, notebookIdInt);
        noteList.add(note);
        notebooks.add(notebookIdInt);
    }

    public void addSampleNotes(){
        String data = "2022-12-14", data1 = "2022-12-10",data2 = "2022-12-12", data3 = "2022-12-16";
        Note note = new Note("Shingle color was not something the couple had ever talked about.", "Kamil", 1, LocalDate.parse(data));
        noteList.add(note);
        Note note1 = new Note("We will not allow you to bring your pet armadillo along.", "Kamil", 2,LocalDate.parse(data1));
        noteList.add(note1);
        Note note2 = new Note("Everything was going so well until I was accosted by a purple giraffe.", "Kuba", 1, LocalDate.parse(data2));
        noteList.add(note2);
        Note note3 = new Note("A good example of a useful vegetable is medicinal rhubarb.", "Jan", 2, LocalDate.parse(data3));
        noteList.add(note3);
        notebooks.add(1);
        notebooks.add(2);
    }

    public void removeNote(){
        System.out.print("Type the index of note to remove: ");
        int index = sc.nextInt();
        noteList.remove(index);
    }

    public void removeNotebook(){
        ArrayList<Note> resultsRemove = new ArrayList<>();
        System.out.print("Type the notebook to remove: ");
        int index = sc.nextInt();
        for (Iterator<Note> it = noteList.iterator(); it.hasNext();){
            Note note = it.next();
            if(note.getNotebookId() == index) it.remove();
        }
        for(Integer i : notebooks){
            if(index == i) notebooks.remove(index);
        }
    }

    public void searchNotes(){
        ArrayList<Note> resultWord = new ArrayList<>();
        System.out.print("Type in a word: ");
        String word = sc.nextLine();
        for(Note note: noteList){
            if(note.search(word)) {
                resultWord.add(note);
            }
        }
        for (Note n : resultWord) {
            n.printNote();
        }
    }

    public void searchNotesByNotebook(){
        System.out.print("Type the index of notebook: ");
        int index = sc.nextInt();
        for(Note note : noteList){
            if(note.getNotebookId() == index) {
                note.printNote();
            }
            }
    }

    public void getNotesByAuthor() {
        ArrayList<Note> resultAuthor = new ArrayList<>();
        System.out.print("Show notes made by: ");
        String author = sc.nextLine();
        for (Note note : noteList) {
            if (note.getAuthor().equals(author)) {
                resultAuthor.add(note);
            }
        }
        for (Note n : resultAuthor){
            n.printNote();
        }
    }

    public void removeNotesByAuthor(){
        System.out.print("Remove notes made by: ");
        String author = sc.nextLine();

        for(Iterator<Note> it = noteList.iterator(); it.hasNext();){
            Note note = it.next();
            if(note.getAuthor().equals((author))) it.remove();
        }
    }

    public void getNotesByDate(){
        ArrayList<Note> resultDate = new ArrayList<>();
        String begin, end;
        System.out.print("Type begin date(YYYY-MM-DD): ");
        begin = sc.nextLine();

        System.out.print("Type end date(YYYY-MM-DD): ");
        end = sc.nextLine();

        for (Note note : noteList){
            if((note.getDate().isAfter(LocalDate.parse(begin)) || note.getDate().isEqual(LocalDate.parse(begin))) &&
                    (note.getDate().isBefore(LocalDate.parse(end)) || note.getDate().isEqual(LocalDate.parse(end)))){
                resultDate.add(note);
            }
        }
        for (Note n : resultDate){
            n.printNote();
        }
    }

    public void sortNotes(){
        Collections.sort(noteList, new Comparator<Note>() {
            public int compare(Note note, Note note2) {
                return note.getDate().compareTo(note2.getDate());
            }
        });
        printNote();
    }

}