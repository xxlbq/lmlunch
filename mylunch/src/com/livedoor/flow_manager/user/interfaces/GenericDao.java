package com.livedoor.flow_manager.user.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,ID extends Serializable> {

    T findById( ID id, boolean lock );

    List findAll();

    List findByExample( T exampleInstance );

    T makePersistent( T entity );

    void makeTransient( T entity );
}
