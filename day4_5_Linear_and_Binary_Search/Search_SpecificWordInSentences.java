
public class Search_SpecificWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "This is a test sentence.",
            "Another example of a sentence.",
            "We are searching for a specific word.",
            "This sentence does not contain it."
        };
        String word = "specific";
        String result = findSentenceWithWord(sentences, word);
        System.out.println(result);
    }
}



