package utils;

import model.OrderItem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by mario on 04.05.2017.
 */
public class FileAction {

    public static String fileGenertator(){
        String fileName = "";

        return fileName;
    }


    public static void writeOrderListToFile(ArrayList<OrderItem> list, String fileName) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(list);
            oos.close();
            System.out.println("zapisane lista user");

        } catch (FileNotFoundException e) {
            System.out.println("cos sie niezapisane");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("cos sie niezapisane");
            e.printStackTrace();
        }
    }
}
