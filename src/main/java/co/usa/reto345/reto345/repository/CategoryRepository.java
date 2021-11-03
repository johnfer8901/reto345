package co.usa.reto345.reto345.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto345.reto345.model.Category;
import co.usa.reto345.reto345.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;


    public List<Category> getAll(){

        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){

        return categoryCrudRepository.findById(id);

    }

    public Category save(Category cate){

        return categoryCrudRepository.save(cate);
    }

    public void delete(Category cate){

        categoryCrudRepository.delete(cate);
    }
    
}
