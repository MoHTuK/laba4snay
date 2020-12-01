package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IClassDB implements IDBinterface, Serializable {
    public ArrayList<Quadrangle> quadrangleArrayList;

    public void add(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.quadrangleArrayList.add(new Quadrangle(x1, y1, x2, y2, x3, y3, x4, y4));
    }

    public IClassDB(){
        quadrangleArrayList = new ArrayList<>();
    }

    public void add(Point pointOne, Point pointTwo,Point pointThree, Point pointFour){
        this.quadrangleArrayList.add(new Quadrangle(pointOne, pointTwo, pointThree, pointFour));
    }

    public Quadrangle get(int index) {
        return this.quadrangleArrayList.get(index);
    }

    public Quadrangle remove(int index) {
        return this.quadrangleArrayList.remove(index);
    }

    public void clear() {
        this.quadrangleArrayList.clear();
    }

    @Override
    public String toString() {
        return quadrangleArrayList.toString();
    }

    public void save(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(outStream);
        for (Quadrangle triangle : quadrangleArrayList) {
            try {
                bufferedWriter.write(String.valueOf(triangle.pointOne.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointOne.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointTwo.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointTwo.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointThree.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointThree.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointFour.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(triangle.pointFour.getY()));
                bufferedWriter.write(System.lineSeparator());
            } catch (IOException IOexception) {
                System.out.println("An I / O error has occurred");
            }
        }
        bufferedWriter.close();
        outStream.close();
    }

    public void load(String filename) throws IOException {
        this.clear();
        Scanner scanner = new Scanner(new FileReader(filename));
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        double x4;
        double y4;
        while (scanner.hasNextLine()) {
            x1 = Double.parseDouble(scanner.nextLine());
            y1 = Double.parseDouble(scanner.nextLine());
            x2 = Double.parseDouble(scanner.nextLine());
            y2 = Double.parseDouble(scanner.nextLine());
            x3 = Double.parseDouble(scanner.nextLine());
            y3 = Double.parseDouble(scanner.nextLine());
            x4 = Double.parseDouble(scanner.nextLine());
            y4 = Double.parseDouble(scanner.nextLine());
            this.quadrangleArrayList.add(new Quadrangle(x1, y1, x2, y2, x3, y3, x4, y4));
        }
        scanner.close();
    }

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.quadrangleArrayList);
            out.close();
            fileOut.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void deserialize(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            this.quadrangleArrayList = (ArrayList<Quadrangle>) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Quadrangle is  class not found");
        }
    }
    public void JKSerialize(String filename) throws IOException {
        ObjectMapper objectMapperList = new ObjectMapper();
        objectMapperList.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapperList.writeValue(new File(filename), this);
    }

    public void JKDeserialize(String filename) throws IOException {
        IClassDB trDB1 = new ObjectMapper().readValue(new File(filename), IClassDB.class);
        this.quadrangleArrayList = trDB1.quadrangleArrayList;
    }
}

