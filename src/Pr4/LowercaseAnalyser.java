package Pr4;

// Класс использующий интерфейс StringAnalyser
class LowercaseAnalyser implements StringAnalyser {

  private StringAnalyser analyser =
      str -> {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
            count++;
          }
        }

        return count;
      };

  public int analyse(String str) {
    return analyser.analyse(str);
  }
}
