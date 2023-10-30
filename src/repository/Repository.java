package repository;

import model.DataBase;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Repository <Repo extends DataBase> {
    Map<Integer, Repo> dataBase;

    public Repository(){
        this.dataBase = new TreeMap<>();
    }

    public void save(Repo repo){this.dataBase.put(repo.getId(),repo);}

    public List<Repo> getAllProducts() {
        return  this.dataBase.values().stream().collect(Collectors.toList());
    }

    public Repo getById(int id) {
        return this.dataBase.get(id);
    }

    public void deleteById(int id) {
        this.dataBase.remove(id);
    }


}