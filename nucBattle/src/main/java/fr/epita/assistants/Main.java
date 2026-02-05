package fr.epita.assistants;

import fr.epita.assistants.nucbattle.BattleManager;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

      BattleManager battleManager1 = new BattleManager(Objects.requireNonNull(BattleManager.class.getClassLoader().getResource("exampleBattle1.json")).getPath()); // exampleBattle1.json is a given file.
      battleManager1.computeBattle("output1.json");

      BattleManager battleManager2 = new BattleManager(Objects.requireNonNull(BattleManager.class.getClassLoader().getResource("exampleBattle2.json")).getPath()); // exampleBattle2.json is a given file.
      battleManager2.computeBattle("output2.json");

      BattleManager battleManager3 = new BattleManager(Objects.requireNonNull(BattleManager.class.getClassLoader().getResource("exampleBattle3.json")).getPath()); // exampleBattle3.json is a given file.
      battleManager3.computeBattle("output3.json");
    }
}
