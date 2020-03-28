package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.Category;
import org.springframework.stereotype.Service;


public interface CategoryService {

    Category selectByPrimaryKey(Integer id);
}
