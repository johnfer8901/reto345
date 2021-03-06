package co.usa.reto345.reto345.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.reto345.reto345.model.Category;
import co.usa.reto345.reto345.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){

        return categoryRepository.getAll();

    }

    public Optional<Category> getCategory(int id){

        return categoryRepository.getCategory(id);
    }

    public Category save(Category cate){

        if(cate.getId()==null){

            return categoryRepository.save(cate);
        }

        else{

            Optional<Category> cateaux=categoryRepository.getCategory(cate.getId());
            if(cateaux.isEmpty()){

                return categoryRepository.save(cate);
            }
            else{

                return cate;
            }
        }

    }

    public Category update(Category cate){
        if(cate.getId()!=null){
            Optional<Category>cateaux=categoryRepository.getCategory(cate.getId());
            if(!cateaux.isEmpty()){
                if(cate.getDescription()!=null){
                    cateaux.get().setDescription(cate.getDescription());
                }
                if(cate.getName()!=null){
                    cateaux.get().setName(cate.getName());
                }
                return categoryRepository.save(cateaux.get());
            }
        }
        return cate;
    }
    public boolean deleteCategory(int categoryId) {
        Boolean cateaux=getCategory(categoryId).map(cate -> {
            categoryRepository.delete(cate);
            return true;
        }).orElse(false);
        return cateaux;
    }


    
}
