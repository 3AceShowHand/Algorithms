/**
 * Created by Christopher on 2017/3/28.
 */
public class OffByN implements CharacterComparator {

    private int step;

    public OffByN(int n) {
        this.step = n;
    }

    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x - y) == this.step;
    }

}
