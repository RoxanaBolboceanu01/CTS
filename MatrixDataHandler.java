import java.io.*;

public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;
    private String filename;

    //metoda initializare matrice
    public void initializeMatrix(int height, int width, String filename) {
        this.height = height;
        this.width = width;
        this.filename = filename;
        matrix = new int[height][];
        for(int i=0; i< height; i++) {
            this.matrix[i] = new int[width];
        }
    }

    //metoda pentru citire matrice
    public void readMatrixFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();

            for (int i = 0; i < height; i++) {
                line = bufferedReader.readLine();
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Integer.parseInt(line.split("")[j]);
                }
            }
            bufferedReader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    //metoda pentru scriere matrice
    public void writeMatrixToFile() {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fileWriter.write(matrix[i][j] + "");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());

        }
    }
    public MatrixDataHandler(int height, int width, String filename) {
            initializeMatrix(height,width,filename);
            writeMatrixToFile();
        }


    public int getValueFromPosition(String filename, int posH, int posW) {
        try {
            // !!!
            int valueFromPosition = -1;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            readMatrixFromFile();

            if(posH < height-1 && posW<width-1)
                valueFromPosition = matrix[posH][posW];
            return valueFromPosition;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public void modifyValueAndUpdateFile(String filename, int posH, int posW, int val) {
        try {
            // !!!
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            initializeMatrix(height,width,filename);

            readMatrixFromFile();

            if(posH<height-1 && posW < width-1)
                matrix[posH][posW] = val;
            else
                val = -1;

            writeMatrixToFile();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
