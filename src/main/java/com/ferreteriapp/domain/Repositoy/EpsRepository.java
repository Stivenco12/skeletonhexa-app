package com.ferreteriapp.domain.Repositoy;

import java.util.List;
import com.ferreteriapp.domain.entities.eps;

public interface EpsRepository {
    void save(eps eps);
    eps findById(int id);
    List<eps> fiadAll();
    void update(eps eps);
    void delete(int id);
}
