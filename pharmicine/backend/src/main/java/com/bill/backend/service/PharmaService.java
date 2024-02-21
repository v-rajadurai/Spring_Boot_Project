package com.bill.backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bill.backend.model.PharmaModel;
import com.bill.backend.repository.PharmaRepo;

@Service
public class PharmaService 
{
    private PharmaRepo pharmaRepo;
    public PharmaService(PharmaRepo pharmaRepo)
    {
        this.pharmaRepo=pharmaRepo;
    }
    public PharmaModel savePharma(PharmaModel pharmaModel)
    {
        pharmaRepo.save(pharmaModel);
        return pharmaModel;
    }
    public List<PharmaModel> getPharma()
    {
        return pharmaRepo.findAll();
    }
    public Optional<PharmaModel> searchId(int id)
    {
        return pharmaRepo.findById(id);
    }
    public List<PharmaModel> searchName(String name)
    {
        return pharmaRepo.findByname(name);
    }
    public List<PharmaModel> sortPriceAsc()
    {
        return pharmaRepo.sortBypriceAsc();
    }
    public List<PharmaModel> sortPriceDesc()
    {
        return pharmaRepo.sortBypriceDesc();
    }
    public List<PharmaModel> sortNameAsc()
    {
        return pharmaRepo.sortByNameAsc();
    }
    public List<PharmaModel> sortNameDesc()
    {
        return pharmaRepo.sortByNameDesc();
    }
    public void delId(int id)
    {
        pharmaRepo.deleteById(id);;
    }
    public boolean updatePharma(int id,PharmaModel pharmaModel)
    {
        if(this.searchId(id)==null)
        {
            return false;
        }
        try{
            pharmaRepo.save(pharmaModel);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
