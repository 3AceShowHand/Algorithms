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
        int current = -1;
        String res = null;
        Iterable<String> netNouns = net.nouns();
        int total = 0;

        for (String v: netNouns) {
            for (int i = 0; i < nouns.length; i++) {
                total += net.distance(v, nouns[i]);
            }
            if (total > current) {
                current = total;
                res = v;
            }
        }
        return res;
    }

//    // see test client below
//    public static void main(String[] args) {
//        WordNet wordnet = new WordNet(args[0], args[1]);
//        Outcast outcast = new Outcast(wordnet);
//        for (int t = 2; t < args.length; t++) {
//            In in = new In(args[t]);
//            String[] nouns = in.readAllStrings();
//            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
//        }
//    }
}
