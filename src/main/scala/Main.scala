import java.security.MessageDigest


import scala.io.Source

object Main extends App {
  trait TreeWord {
    def getWord: String
  }
  case class Root(firstWord:String, contiguous: List[TreeWord], charactersToUse:Array[Char]) extends TreeWord {
    def getWord:String = firstWord + contiguous.foldLeft("") { (z,i) => z + " " +i.getWord }
  }
  case class Leaf(word:String) extends TreeWord {
    def getWord: String = word
  }

  object Rabbit {
    def calculateMD5Hash(phrase: String): String = {
        MessageDigest.getInstance("MD5").digest(phrase.getBytes())
          .map(0xFF & _)
          .map { "%02x".format(_) }
          .foldLeft(""){_ + _}
    }
    def getLinesFromFile : List[String] = {
      //TODO should be by chunks?..maybe
      Source.fromResource("wordList").getLines.toList
    }

    def rabbitRecursive(wordToStart: String , charsToUse: Array[Char], wordsToUse: List[String]) : List[String] = Nil

    def fitsWell(wordToStart: String , charsToUse: Array[Char]) : Array[Char] = {
      wordToStart match {
        case Nil =>
        case Nil =>
      }
    }

    lazy val firstHash = "e4820b45d2277f3844eac66c903e84be"
    lazy val sndHash = "23170acc097c24edb98fc5488ab033fe"
    lazy val trdHash = "665e5bcb0c20062fe8abaaf4628bb154"
    lazy val anagram = "poultry outwits ants"
    lazy val wordsDictionary = getLinesFromFile

    val possiblePhrases:List[String] = rabbitRecursive(wordToStart = wordsDictionary.head ,
      charsToUse = anagram.trim.toCharArray,
      wordsToUse = wordsDictionary )
  }
}