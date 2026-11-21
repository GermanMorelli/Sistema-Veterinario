/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cartilla;
import java.util.List;

public interface ICartillaDao {
    Cartilla guardar(Cartilla cartilla);
    Cartilla actualizar(Cartilla cartilla);
    void eliminar(int id);
    Cartilla buscarPorId(int id);
    List<Cartilla> listar();
    Cartilla buscarPorMascota(int idMascota);
}
