package figure;

public class FigureSet {
    public Figure[] figures;
    public String[] tags;
    public int length;

    public FigureSet() {
        figures = new Figure[0];
        tags = new String[0];
        this.length = 0;
    }

    public FigureSet(int length) {
        figures = new Figure[length];
        this.length = length;
    }

    public FigureSet add(Figure f, String tag){
        Figure[] newSet = new Figure[length+1];
        String[] newTags = new String[length+1];
        System.arraycopy(figures, 0, newSet, 0, length);
        System.arraycopy(tags, 0, newTags, 0, length);
        newSet[length] = f;
        newTags[length] = tag;
        figures = newSet;
        tags = newTags;
        this.length += 1;
        return this;
    }
}
