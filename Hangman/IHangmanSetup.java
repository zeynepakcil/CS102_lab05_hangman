package Hangman;

// Source code is decompiled from a .class file using FernFlower decompiler.


public interface IHangmanSetup {
   String version = "v1.0";

   int getMaxAllowedIncorrectTries();

   char getBlankChar();

   String getCharsToPreserve();

   String getAllLetters();

   String chooseSecretWord();
}
