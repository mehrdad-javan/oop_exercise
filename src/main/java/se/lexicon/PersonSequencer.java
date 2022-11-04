package se.lexicon;

public class PersonSequencer {

  private static int sequencer = 0;

  public static int getNextId(){
    return ++sequencer;
  }

}
