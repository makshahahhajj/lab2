import database.domain.Word;
import database.persistance.WordPersistence;


public class Main {
    public static void main(String[] args) {
        WordPersistence words = new WordPersistence();
        Word word = words.getById(1);

        System.out.println(word.getId());

    }
}
