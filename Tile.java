/**
 * This class is what comprises the gameboard, and stores animal and terrain
 * @author Alyssa Ysabellele Meneses
 * @author Lind Matthew Tan
 * @version 1.0
 */

public class Tile {
    private Terrain TERRAIN;
    private Animal animal = null;

    /**
     * This constructor initializes the terrain
     * @param t terrain
     */
    public Tile(Terrain t){
        TERRAIN = t;
        this.animal = null;
    }

    /**
     * This constructor initializes the terrain and animal on the tile
     * @param t terrain
     * @param a animal on the tile
     */
    public Tile(Terrain t, Animal a ){
        TERRAIN = t;
        this.animal = a;
    }

    /**
     * This method returns the animal placed on the tile
     * @return animal on the tile, null if none
     */
    public Animal getAnimal(){
        return animal;
    }

    /**
     * This method removes the animal placed on the tile
     * @return animal on the tile, null if none
     */
    public void removeAnimal(){
        animal = null;
    }

    /**
     * This method initializes the animal that will be placed on the tile
     * @param animal animal on the tile
     */
    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    /**
     * This method returns the Terrain object
     * @return returns a Terrain Object
     */
    public Terrain getTerrain(){
        return TERRAIN;
    }
}
