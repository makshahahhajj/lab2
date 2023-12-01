package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class WordPersistance_GetAll_Test {
    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("getAll method is passed")
    public void getAllTest() {
       wordPersistence.putWord("Max", "love tennis");
       wordPersistence.putWord("Alex", "love football");
       wordPersistence.putWord("Bob", "love gaming");

        List<Word> all = wordPersistence.getAll();

        then(all.get(0).getWord()).isEqualTo("Max");
        then(all.get(0).getDef()).isEqualTo("love tennis");
        then(all.get(1).getWord()).isEqualTo("Alex");
        then(all.get(1).getDef()).isEqualTo("love football");
        then(all.get(2).getWord()).isEqualTo("Bob");
        then(all.get(2).getDef()).isEqualTo("love gaming");

    }
}
