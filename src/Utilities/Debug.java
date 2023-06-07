package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 *
 */
public class Debug {

    private int debugLevel;

    public Debug(int selectedDebugLevel) {

        this.debugLevel = selectedDebugLevel;

    }

    // Getter and Setter Methods
    /**
     * @return the current debug level
     */
    public int getLevel() {
        return this.debugLevel;
    }

    /**
     * @param debugLevel - the current debug level
     */
    public void setLevel(int selectedDebugLevel) {

        if (selectedDebugLevel > 0) {

            this.debugLevel = selectedDebugLevel;
        }

    }

    // Operational Methods
    /**
     * @param msg - the debug output message
     */
    public void output(int selectedDebugLevel, String msg) {

        if (selectedDebugLevel <= this.debugLevel) {

            System.out.println(msg); // message to be displayed
        }

        /* Else debug == 0 , do nothing */
    }

    /**
     *
     * @param selectedDebugLevel - entered app level
     * @param msg - msg to display
     * @param answer - yes or no to serialize dbug output to file
     */
    public void output(int selectedDebugLevel, String msg, String answer) {

        int num = 1;

        if (selectedDebugLevel <= this.debugLevel && answer.toUpperCase().equals("YES")) {

            String fileName = "debugResults" + num + "debugLevel" + selectedDebugLevel;

            System.out.println(msg); // message to be displayed

            try {
                FileOutputStream fos = new FileOutputStream("res/debugOutput/" + fileName);

                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(msg);

                // close object first
                oos.close();
                // close file
                fos.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        /* Else debug == 0 , do nothing */
        num++;
    }

}
