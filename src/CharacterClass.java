public class CharacterClass implements Comparable<CharacterClass>{ //interface Comparable to compare CharacterClass

    //characters attributes (Class, Name, Lvl)
    private String charClass;
    private String charName;
    private int charLvl;

    //class constructor
    CharacterClass(String classP, String name, Integer lvl){
        this.charClass = classP;
        this.charName = name;
        this.charLvl = lvl;
    }

    //sort method passes object CharacterClass to the compareTo(),
    // so that compare this object with object used in a method call
    public int compareTo(CharacterClass other){
        return charName.compareTo(other.getCharName());
    }


    public String getCharClass(){
        return charClass;
    }
    public String getCharName(){
        return charName;
    }
    public Integer getCharLvl(){
        return charLvl;
    }

    //method override
    @Override
    public String toString(){
        return (charClass + charName + charLvl);
    }
}
