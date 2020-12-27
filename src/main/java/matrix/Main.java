package matrix;

public class Main {
    private int firstParametrCell;
    private int secondParametrCell;
    private int firstTemp;
    private int secondTemp;

    public String matrixAndWord(String squareMatrix, String word) {
        if (squareMatrix == null || word == null) {
            throw new NullPointerException();
        }
        if (squareMatrix.equals("") || word.equals("")) {
            return "";
        }
        if (!isSizeMatrixSquare(squareMatrix) || !isFirstLargerThenSecond(squareMatrix, word)
                || !isOnlyLowerCase(squareMatrix, word)) {
            throw new RuntimeException("Incorrect data");
        }

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < squareMatrix.length(); j++) {
            if (word.charAt(0) == squareMatrix.charAt(j)) {
                firstParametrCell = j / matrixSizeParametr(squareMatrix);
                secondParametrCell = j % matrixSizeParametr(squareMatrix);
                builder.append("[").append(firstParametrCell).append(",")
                        .append(secondParametrCell).append("]").append("->");
                break;
            }
        }

        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j < squareMatrix.length(); j++) {
                if (word.charAt(i) == squareMatrix.charAt(j)) {
                    firstTemp = j / matrixSizeParametr(squareMatrix);
                    secondTemp = j % matrixSizeParametr(squareMatrix);
                    if (Math.abs(firstTemp - firstParametrCell) <= 1
                            && Math.abs(secondTemp - secondParametrCell) <= 1) {
                        firstParametrCell = firstTemp;
                        secondParametrCell = secondTemp;
                        builder.append("[").append(firstParametrCell).append(",")
                                .append(secondParametrCell).append("]").append("->");
                        break;
                    }
                }
            }
        }
        return builder.substring(0, builder.length() - 2);
    }

    public int matrixSizeParametr(String matrix) {
        return (int) Math.sqrt(matrix.length());
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
