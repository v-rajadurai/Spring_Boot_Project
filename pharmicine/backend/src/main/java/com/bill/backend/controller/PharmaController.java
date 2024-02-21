package com.bill.backend.controller;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bill.backend.model.PharmaModel;
import com.bill.backend.service.PharmaService;

@RestController
public class PharmaController 
{
    private PharmaService pharmaService;
    public PharmaController(PharmaService pharmaService)
    {
        this.pharmaService=pharmaService;
    }
    @PostMapping("/bill")

    public PharmaModel addPharmaModel(@RequestBody PharmaModel pharmaModel)
    {
        pharmaService.savePharma(pharmaModel);
        return pharmaModel;
    }
    @GetMapping("/getbill")
    public List<PharmaModel> getMedicine()
    {
        return pharmaService.getPharma();
    }
    @GetMapping("/searchid/{id}")
    public Optional<PharmaModel> search(@PathVariable int id)
    {
        return pharmaService.searchId(id);
    }
    @GetMapping("/searchname/{name}")
    public List<PharmaModel> getSearch(@PathVariable String name)
    {
        return pharmaService.searchName(name);
    }
    @GetMapping("/sortpriceAsc")
    public List<PharmaModel> getSortPriceAsc()
    {
        return pharmaService.sortPriceAsc();
    }
    @GetMapping("/sortpriceDesc")
    public List<PharmaModel> getSortPriceDes()
    {
        return pharmaService.sortPriceDesc();
    }
    @GetMapping("/sortNameAsc")
    public List<PharmaModel> getSortNameAsc()
    {
        return pharmaService.sortNameAsc();
    }
    @GetMapping("/sortNameDesc")
    public List<PharmaModel> getSortNameDesc()
    {
        return pharmaService.sortNameDesc();
    }
    @DeleteMapping("/delete/{id}")
    public void getDeleteId(@PathVariable("id") int id)
    {
        pharmaService.delId(id);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editPharma(@PathVariable int id,@RequestBody PharmaModel pharmaModel)
    {
        if(pharmaService.updatePharma(id,pharmaModel))
        {
            return new ResponseEntity<String>("Update Succesfull",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Update UnSuccesfull",HttpStatus.NOT_FOUND);
    }
    
}
