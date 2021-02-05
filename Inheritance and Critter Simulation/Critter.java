/*
    This class defines the methods necessary for an animal
    to be part of the simulation. Your critter animal classes
    'extend' this class or a subclass of Critter to add to its
    basic functionality.

    YOU DON'T NEED TO EDIT THIS FILE FOR YOUR ASSIGNMENT.

    Read through the provided comments to get a better idea of what
    code is given.
*/


import java.awt.*; // for Color
import java.io.*;
import javax.sound.sampled.*;

public abstract class Critter {

    /* Methods to be inherited and possibly overridden. */

    /* When your animal encounters food, out code calls this
       on it to ask whether it wants to eat (true) or not (false). */
	protected boolean eat() {
		return false;
	}

	/* When two animals of different species move onto the same square
	of the grid, they fight. When they collide, our code calls this on
	each animal to ask it what kind of attack it wants to use in a
	fight with the given opponent. */
	protected Attack fight(String opponent) {
		return Attack.FORFEIT;
	}

	/* Every time the board updates, our code calls this on your animal
	to ask it what color of which it wants to be drawn. */
	protected Color getColor() {
		return Color.BLACK;
	}

	/* Every time the board updates, our code calls this on your animal
	to ask it which way it wants to move. */
	protected Direction getMove() {
		return Direction.CENTER;
	}

	/* Every time the board updates, our code calls this on your animal
	to ask what letter with which it should be drawn. */
	public String toString() {
		return "?";
	}

	public void soundInit (){
		try {
			File soundFile = new File ("./sounds/slaughter.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			for (int i =0; i< clipN; i++){
				this.clips[i]  = AudioSystem.getClip();

			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//play the sound
	public void playSound (String soundFileName){
		if(inited ==0) this.soundInit();
		try{
			for (int i=0; i< clipN; i++){

				if (clips[i].getMicrosecondLength() == clips[i].getMicrosecondPosition()){

					File soundFile = new File ("slaughter.wav");
					AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
					this.clips[i]  = AudioSystem.getClip();
					this.clips[i].open(audioIn);
					clips[i].start();
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// I use these fields to implement the methods below such as getX and getNeighbor.
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean alive = true;
	private boolean awake = true;
	private final String[] neighbors = {" ", " ", " ", " ", " "};
	//these are sound clip, used to play sounds
	private int clipN = 40;
	private Clip[] clips = new Clip[clipN];
	private int inited = 0;

	// constants for directions
	protected static enum Direction {
		NORTH, SOUTH, EAST, WEST, CENTER
	};

	// constants for fighting
	protected static enum Attack {
		ROAR, POUNCE, SCRATCH, FORFEIT
	};

	// The following methods are provided to get information about the critter.
	// Technically the critter could call setXxxx() on itself,
	// but the game model ignores this anyway, so it's useless to do so.
	// These methods are declared 'final' so you can't override them.

	// Returns the height of the game simulation world.
	protected final int getHeight() {
		return height;
	}

	// Returns the animal that is 1 square in the given direction away
	// from this animal.  A blank space, " ", signifies an empty square.
	protected final String getNeighbor(Direction direction) {
		return neighbors[direction.ordinal()];
	}

	// Returns the width of the game simulation world.
	protected final int getWidth() {
		return width;
	}

	// Returns this animal's current x-coordinate.
	protected final int getX() {
		return x;
	}

	// Returns this animal's current y-coordinate.
	protected final int getY() {
		return y;
	}

	// Returns true if this animal is currently alive.
	// This will return false if this animal has lost a fight and died.
	protected final boolean isAlive() {
		return alive;
	}

	// Returns true if this animal is currently awake.
	// This will temporarily return false if this animal has eaten too much food
	// and fallen asleep.
	protected final boolean isAwake() {
		return awake;
	}

	// Sets whether or not this animal is currently alive.
	// This method is called by the simulator and not by your animal itself.
	protected final void setAlive(boolean alive) {
		this.alive = alive;
	}

	// Sets whether or not this animal is currently awake.
	// This method is called by the simulator and not by your animal itself.
	protected final void setAwake(boolean awake) {
		this.awake = awake;
	}

	// Sets the height of the game simulation world to be the given value,
	// so that future calls to getHeight will return this value.
	// This method is called by the simulator and not by your animal itself.
	protected final void setHeight(int height) {
		this.height = height;
	}

	// Sets the neighbor of this animal in the given direction to be the given value,
	// so that future calls to getNeighbor in that direction will return this value.
	// This method is called by the simulator and not by your animal itself.
	protected final void setNeighbor(Direction direction, String value) {
		neighbors[direction.ordinal()] = value;
	}

	// Sets the width of the game simulation world to be the given value.
	// so that future calls to getWidth will return this value.
	// This method is called by the simulator and not by your animal itself.
	protected final void setWidth(int width) {
		this.width = width;
	}

	// Sets this animal's memory of its x-coordinate to be the given value.
	// so that future calls to getX will return this value.
	// This method is called by the simulator and not by your animal itself.
	protected final void setX(int x) {
		this.x = x;
	}

	// Sets this animal's memory of its y-coordinate to be the given value.
	// so that future calls to getY will return this value.
	// This method is called by the simulator and not by your animal itself.
	protected final void setY(int y) {
		this.y = y;
	}

	// These methods are provided to inform you about the result of fights, sleeping, etc.
	// You can override these methods in your Husky to be informed of these events.

	// called when you win a fight against another animal
	protected void win() {}

	// called when you lose a fight against another animal, and die
	protected void lose() {}

	// called when your animal is put to sleep for eating too much food
	protected void sleep() {}

	// called when your animal wakes up from sleeping
	protected void wakeup() {}

	// called when the game world is reset
	protected void reset() {}

	// called when your critter mates with another critter
	protected void mate() {}

	// called when your critter is done mating with another critter
	protected void mateEnd() {}

}
