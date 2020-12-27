package matrix;

public class Main {
    private int first;
    private int firstTemp;
    private int second;
    private int secondTemp;

    public String matrixAndWord(String sizeMatrix, String word) {
        if (sizeMatrix == null || word == null) {
            throw new NullPointerException();
        }
        if (sizeMatrix.equals("") || word.equals("")) {
            return "";
        }
        if (!isSizeMatrixSquare(sizeMatrix) || !isFirstLargerThenSecond(sizeMatrix, word)
                || !isOnlyLowerCase(sizeMatrix, word)) {
            throw new RuntimeException("Incorrect data");
        }

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < sizeMatrix.length(); j++) {
            if (word.charAt(0) == sizeMatrix.charAt(j)) {
                first = j / (int) Math.sqrt(sizeMatrix.length());
                second = j % (int) Math.sqrt(sizeMatrix.length());
                builder.append("[").append(first).append(",").append(second)
                        .append("]").append("->");
                break;
            }
        }

        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j < sizeMatrix.length(); j++) {
                if (word.charAt(i) == sizeMatrix.charAt(j)) {
                    firstTemp = j / (int) Math.sqrt(sizeMatrix.length());
                    secondTemp = j % (int) Math.sqrt(sizeMatrix.length());
                    if (Math.abs(firstTemp - first) <= 1 && Math.abs(secondTemp - second) <= 1) {
                        first = firstTemp;
                        second = secondTemp;
                        builder.append("[").append(first).append(",").append(second)
                                .append("]").append("->");
                        break;
                    }
                }
            }
        }
        return builder.substring(0, builder.length() - 2);
    }

    public boolean isSizeMatrixSquare(String matrixLength) {
        double root = Math.sqrt(matrixLength.length());
        return root * 10 % 10 == 0;
    }

    public boolean isFirstLargerThenSecond(String first, String second) {
        return first.length() > second.length();
    }

    public boolean isOnlyLowerCase(String word, String secondWord) {
        return word.matches("[A-Z]+") && secondWord.matches("[A-Z]+");
    }
}
