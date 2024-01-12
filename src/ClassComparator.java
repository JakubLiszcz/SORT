//This class is used in method 2
import java.util.*;
public class ClassComparator implements Comparator<CharacterClass>{
    public int compare (CharacterClass first, CharacterClass second){
        return first.getCharClass().compareTo(second.getCharClass());
    }
}
