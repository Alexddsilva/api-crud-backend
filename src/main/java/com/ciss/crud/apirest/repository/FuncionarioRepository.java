package com.ciss.crud.apirest.repository;

import com.ciss.crud.apirest.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findById (long id);

}
