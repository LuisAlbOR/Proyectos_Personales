package com.unach.tarea.servicio;

import com.unach.tarea.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    List<Tarea> listarTareas();
    Tarea buscarTareaPorId(Integer id);
    void guardarTarea(Tarea tarea);
    void eliminarTarea(Tarea tarea);
}
