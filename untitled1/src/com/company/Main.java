package com.company;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IClassDB quadrangleList = new IClassDB();
        IClassDBparallelogram parallelogramList = new IClassDBparallelogram();
        System.out.println("Input Y if you want save info or N if you want open exist file");
        Scanner input = new Scanner(System.in);
        String choseInput = input.nextLine().toUpperCase();

        switch (choseInput) {
            case "Y":
                quadrangleList.add(1, 6, 6, 6, 6, 2, 1, 2);
                quadrangleList.add(1, 6, 6, 6, 6, 2, 1, 2);
                quadrangleList.add(1, 6, 6, 6, 6, 2, 1, 2);
                quadrangleList.JKSerialize("1.json");
                quadrangleList.quadrangleArrayList.removeIf(quadrangle -> !quadrangle.isExists());
                double summ = 0;
                for (int i = 0; i < quadrangleList.quadrangleArrayList.size(); i++) {
                    summ += quadrangleList.get(i).findArea();
                }
                double middleArea = summ / quadrangleList.quadrangleArrayList.size();

                System.out.println(middleArea);

                parallelogramList.add(1, 6, 6, 6, 6, 2, 1, 2);
                parallelogramList.add(2, 8, 8, 8, 8, 4, 3, 4);

                parallelogramList.parallelogramArrayList.removeIf(parallelogram -> !parallelogram.isExists());

                Parallelogram parallelogram = Collections.min(parallelogramList.parallelogramArrayList, Comparator.comparing(s -> s.findArea()));
                Parallelogram parallelogram1 = Collections.max(parallelogramList.parallelogramArrayList, Comparator.comparing(s -> s.findArea()));
                System.out.println("min " + parallelogram.findArea());
                System.out.println("max " + parallelogram1.findArea());
                break;
            case "N":
                String filePath = "E:\\Users\\Ветрогон Александр\\IdeaProjects\\untitled1";
                File dir = new File(filePath);
                String[] reserveFiles = dir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".json");
                    }
                });
                if (reserveFiles != null && reserveFiles.length > 0) {
                    System.out.println("The list of backups:");
                    for (int i = 0; i < reserveFiles.length; i++) {
                        System.out.println((i) + " " + reserveFiles[i]);
                    }
                    System.out.println("Enter the number of backup");
                    Scanner input2 = new Scanner(System.in);
                    String chosenBackup = input2.nextLine();
                    if (Integer.parseInt(chosenBackup) < reserveFiles.length && Integer.parseInt(chosenBackup) >= 0) {
                        quadrangleList.JKDeserialize(reserveFiles[Integer.parseInt(chosenBackup)]);
                            System.out.println(quadrangleList);
                    } else
                        System.out.println("Error.");
                } else
                    System.out.println("There are no backups in the folder.");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
