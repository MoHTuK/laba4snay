package com.company;

import java.io.IOException;

public interface IDBinterface {
    void add(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);

    Object get(int index);

    Object remove(int index);

    void clear();

    void save(String filename) throws IOException;

    void load(String filename) throws IOException;
}
