package data;

import model.StockProduct;
import repository.Repository;

public class Registration {

    Repository<StockProduct> repository;

    public Registration(Repository<StockProduct> repository) {
        repository.save(new StockProduct("TS-Wyse", "ThinClient","Cx0","Wyse","Amazon"));
        repository.save(new StockProduct("Samgung Printer", "Printer","ML-5010ND","Samsung","Arcelor"));
        repository.save(new StockProduct("Fuser Printer", "Fuser","JC61-04092A","Samsung","Amazon"));
        repository.save(new StockProduct("Print Server - Printer Production", "Print Server","DPR-1061","D-Link","Amazon"));
        repository.save(new StockProduct("Printer Assets - Bematech", "Printer Assets","MP-4000 TH","Bematech","Amazon"));
    }

}