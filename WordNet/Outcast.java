public class Outcast {

    // constructor takes a WordNet object
    private final WordNet net;

    public Outcast(WordNet wordnet) {
        if (wordnet == null) {
            throw new IllegalArgumentException("Given a null object to argument wordnet");
        }
        net = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        if (nouns == null) {
            throw new IllegalArgumentException("Given a null object to argument nouns");
        }
        String res = null;
        int threshold = -1;
        for (String s: nouns) {
            int total = 0;
            for (int i = 0; i < nouns.length; i++) {
                if (!s.equals(nouns[i])) {
                    total += net.distance(s, nouns[i]);
                }
            }
            if (total > threshold) {
                threshold = total;
                res = s;
            }
        }
        return res;
    }
}
