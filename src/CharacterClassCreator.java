import java.util.ArrayList;
import java.util.*;
public class CharacterClassCreator {
    public static List<CharacterClass> ShowCharacterList(){ //static because doesnt have and doesnt need any instance variable

        List<CharacterClass> charClasses = new ArrayList<>();
        charClasses.add(new CharacterClass("BARBARIAN" + " ", "JAMES" + " ", 10));
        charClasses.add(new CharacterClass("ROGUE" + " ","MARCO" + " ", 1));
        charClasses.add(new CharacterClass("DRUID" + " ", "MONICA" + " ",9));
        charClasses.add(new CharacterClass("DRUID" + " ", "BOB" + " ",9));

        return charClasses;
    }
}
