package com;

public interface ComandoCrud<T> {

    void crear(T t);

    void actualizar(T t);

    void eliminar(T t);

    void crearGrupo();

    void eliminarGrupo();
}
