package com.ciss.crud.apirest.resources;

import com.ciss.crud.apirest.models.Funcionario;
import com.ciss.crud.apirest.repository.FuncionarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Funcionarios")
@CrossOrigin(origins = "*") //liberação de acesso aos domínios (* indica acesso liberado a qualquer domínio).
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionarios")
    @ApiOperation(value = "Retorna uma lista de funcionários")
    public List<Funcionario> listaFunc (){
        return funcionarioRepository.findAll();
    }

    @GetMapping("/funcionarios/{id}")
    @ApiOperation(value = "Retorna um funcionário à partir do id.")
    public Funcionario buscaFunc(@PathVariable(value = "id") long id){
        return funcionarioRepository.findById(id);
    }

    @PostMapping("/funcionarios")
    @ApiOperation(value = "Salva um novo funcionário")
    public Funcionario addFunc(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/funcionarios")
    @ApiOperation(value = "Deleta um funcionário")
    public void delFunc(@RequestBody Funcionario funcionario){
        funcionarioRepository.delete(funcionario);
    }

    @PutMapping("/funcionarios")
    @ApiOperation(value = "Atualiza um funcionário")
    public Funcionario attFunc(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
