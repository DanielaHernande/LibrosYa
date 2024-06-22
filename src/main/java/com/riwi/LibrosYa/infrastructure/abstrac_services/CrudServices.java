package com.riwi.LibrosYa.infrastructure.abstrac_services;

public interface CrudServices <RQ, RS, ID> {
    
    public RS create(RQ request);

    public RS get(ID id);

    public RS update(RQ request, ID id);

    public void delete (ID id);
}
