package com.thayluantutor.DB;

import com.thayluantutor.models.Category;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface IDAO<T> {
    public ArrayList<T> list();
    public T add(T t);
    public int getLastId();
    public T get(int i);
    public T update(int id , T t);
    public boolean remove(int i);
}
