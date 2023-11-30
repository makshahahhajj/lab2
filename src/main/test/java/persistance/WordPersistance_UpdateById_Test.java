package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class WordPersistance_UpdateById_Test {
    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("update method is passed")
    public void whenStudentExistsInDbThenReturnNull() {
        wordPersistence.deleteAll();
        wordPersistence.putWord("Alex", "love football"); // id = 1
        Map<String, String> values = new HashMap<>();
        values.put("word", "Max");
        values.put("definition", "my name is");

        wordPersistence.updatById(1, values);

        Word word = wordPersistence.getById(1);

        then(word).isNotNull();
        then(word.getWord()).isEqualTo("Max");
        then(word.getDef()).isEqualTo("my name is");
    }
}
