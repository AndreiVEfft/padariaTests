/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author andre
 */
public interface ICrud<T> {
    T salvar(T obj);
    T update(T obj);
    List<T> consultar();
    void delete(T t);
    boolean delete(int id);
    T consultarPeloId(int id);
}
