package com.ecommerce.sb_ecommerce.repositories;

import com.ecommerce.sb_ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
