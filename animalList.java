/** This class a collection of methods used to get the random piece animal
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class animalList{
    private final static String[] ANIMALLIST = {"mouse", "cat", "wolf", "dog", "leopard", "tiger", "lion", "elephant"};

    /**
     * This method gets the rank of the animal on the list
     * @param key String of animal to be searched
     * @return position (rank) of the animal in the list
     */
    public static int linearSearch(String key){
        for(int i = 0; i < ANIMALLIST.length; i++){
            if(ANIMALLIST[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
     /**
     * This method returns a string of animal name
     * @param index random number to be called
     * @return random animal (string)
     */
    public static String getRandomAnimal(int index){
        return ANIMALLIST[index];
    }

}