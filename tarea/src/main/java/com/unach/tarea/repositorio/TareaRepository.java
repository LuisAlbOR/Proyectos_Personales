package com.unach.tarea.repositorio;

import com.unach.tarea.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
