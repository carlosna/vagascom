package br.com.vagasapi.controllers.br.com.vagasapi.controllers.impl;

import br.com.vagasapi.controllers.VagaController;
import br.com.vagasapi.domain.Vaga;
import br.com.vagasapi.dto.VagaDTO;
import br.com.vagasapi.services.VagaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

/*      Optional<Course> course = service.createCourseBy(request);
        URI uri = URI.create("course/" + course.map(Course::getNome).orElse(0L));
        return course.map(created(uri)::body).orElseGet(notFound()::build);
*/

@VagaController
public class VagaControllerImpl {

    @Autowired
    VagaService service;

    @ApiOperation(value = "Cadastrar uma vaga")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create (@Valid @RequestBody VagaDTO vagaDTO){
        Integer id = service.insert(vagaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).body(vagaDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET , produces = {"application/json"})
    public ResponseEntity <Page <VagaDTO> > findPage(
                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage,
                            @RequestParam(value = "orderBy", defaultValue = "empresa") String orderBy){

        Page<Vaga> list = service.findPage(page, linesPerPage, orderBy);
        Page<VagaDTO> listDTO = list.map(obj -> new VagaDTO(obj));

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/hal+json"})
    public Optional<Vaga> get(@PathVariable int id){
        return service.findById(id);
    }
}
