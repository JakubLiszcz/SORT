<div align="center">
  <h1>Sort</h1>
</div>

# Sort your characters
This project is for people who want to sort their games characters.
User can add character whit parameters such as: class, name and lvl. Then add it to the list and sort by any of this paremeters.

# Sort methods

In this project I added four methods to sort.

## Method 1
Sort by name
This method is possible because CharacterClass implements Comparable interface.
Order of elements is determine by method compareTo() and parameters inside it (in this case charName).

## Method 2
Sort by character class
This method used ClassComparator (which must implements Comparator interface) and compare method.

## Method 3
Sort by lvl
This method used lambda expression. The whole logic of this method is in this one line expression. Code is clear and simple. 

## Method 4
Sort by name using TreeSet
Objects were stored in a sorted and ascending order. This method doesnt allow to duplicate character name. If user add new character with name which already exist in the list and then want to sort this list, his new character will disappear from sorted list.
