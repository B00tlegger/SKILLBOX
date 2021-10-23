public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
                //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        StringBuffer bigX = new StringBuffer();

        char[][] x = new char[size][size];
        for (int i = 0 ; i < x.length ; i++){
            x[i][i] = symbol;
            x[i][(x[i].length - 1) - i] = symbol;
            for (int j = 0 ; j < x[i].length ; j++ ){
                if (x[i][j] != symbol){
                    x[i][j] = ' ';
                }
                bigX.append(x[i][j]);
            }

            bigX.append("\n");
        }
        System.out.println(bigX);

        return x;
    }
}