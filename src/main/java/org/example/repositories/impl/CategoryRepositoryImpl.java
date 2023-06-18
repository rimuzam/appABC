package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;
import org.example.models.Category;
import org.example.repositories.CategoryRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private AppDbContext context;
    public CategoryRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    public Category createCategory(Category category){
        String query = "insert into category values ('"+category.getId()+"', '"+category.getName()+"')";
        try{
            context.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new ErrorException(e.getMessage());
        } finally {
            context.closeResources();
        }
        return category;
    }
    public Category findCategoryName(String name){
        String query = "select * from category where name = '"+name+"'";
        Category category = new Category();
        try {
            ResultSet resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                category.setId(resultSet.getString("id"));
                category.setName(resultSet.getString("name"));
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally {
            context.closeResources();
        }
        return category;
    }

    public List<Category> findAllCategory(){
        String query = "select * from category order by name";
        List<Category> result = new ArrayList<Category>();
        try {
            ResultSet resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                result.add(new Category(id, name));
            }
        } catch (Exception e){
            throw new ErrorException(e.getMessage());
        } finally {
            context.closeResources();
        }
        return result;
    }


}
