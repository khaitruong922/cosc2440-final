package s3818074.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import s3818074.models.AbstractEntity;
import s3818074.services.AbstractService;

import java.util.List;

public abstract class AbstractController<T extends AbstractEntity, ID> {
    protected AbstractService<T, ID> service;

    public AbstractController(AbstractService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll(@RequestParam(value = "page", required = false) Integer page) {
        return service.getAll(page);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable("id") ID id) {
        return service.getById(id);
    }

    @PostMapping
    public T add(@RequestBody T t) {
        return service.add(t);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id") ID id) {
        return service.deleteById(id);
    }

    @DeleteMapping
    public HttpStatus deleteAll() {
        return service.deleteAll();
    }

    @PatchMapping(value = "/{id}")
    public T updateById(@RequestBody T t, @PathVariable("id") ID id) {
        return service.updateById(t, id);
    }
}