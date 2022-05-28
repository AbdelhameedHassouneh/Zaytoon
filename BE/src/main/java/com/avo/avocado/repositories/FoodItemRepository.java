package com.avo.avocado.repositories;

import com.avo.avocado.utils.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends CrudRepository<User,Long>  {

}
