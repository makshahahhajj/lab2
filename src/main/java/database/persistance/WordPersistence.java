package database.persistance;

import database.Database;
import database.domain.Word;

import java.util.List;
import java.util.Map;

public class WordPersistence {

    private final Database database = Database.getInstance();
    private static final String WORD_NAME = "word";
    private static final String DEF_NAME = "definition";

    public void putWord(String word, String definition) {
        String sql = """
        insert into scanword.words
        (word, definition)
        values
        ('%s', '%s')
        """;
        database.execute(String.format(sql, word, definition));
    }

    public Word convertWord(Map<String, String> fromBd) {
        return new Word(
                fromBd.get(WORD_NAME),
                fromBd.get(DEF_NAME)
        );
    }

    public void updatById(int id, Map<String, String> values) {
        database.updateById(id, values);
    }


    public Word getById(int id) {
        Map<String, String> fromBd = database.selectById(
                id,
                WORD_NAME,
                DEF_NAME
        );
        if (fromBd == null && fromBd.isEmpty()) {
            return null;
        }

        return convertWord(fromBd);
    }

    public void deleteById(int id) {
        database.deleteById(id);
    }

    public void deleteAll() {
        database.clear();
    }

    public List<Word> getAll() {
        List<Map<String, String>> fromDB = database.selectAll(
                WORD_NAME,
                DEF_NAME
        );

        return fromDB.stream()
                .map(this::convertWord)
                .toList();
    }
}
