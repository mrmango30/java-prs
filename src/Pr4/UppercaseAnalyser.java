package Pr4;

// Класс использующий интерфейс StringAnalyser
class UppercaseAnalyser implements StringAnalyser {

  private StringAnalyser analyser =
      str -> {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
            count++;
          }
        }

        return count;
      };

  public int analyse(String str) {
    return analyser.analyse(str);
  }
}
