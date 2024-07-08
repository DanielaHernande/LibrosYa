package com.riwi.LibrosYa.infrastructure.abstrac_services;

import org.springframework.data.domain.Page;

public interface CrudServices <RQ, RS, ID> {
    
    public RS get(ID id);

    public Page<RS> getAll(int page, int size);
    
    public RS create(RQ request);

    public RS update(RQ request, ID id);

    public void delete (ID id);
}
