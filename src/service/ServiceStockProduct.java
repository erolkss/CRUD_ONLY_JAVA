package service;

import data.Registration;
import exception.SystemProductException;
import model.StockProduct;
import repository.Repository;
import util.Strings;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceStockProduct {
    Repository<StockProduct> repository = new Repository<>();

    Registration registration = new Registration(repository);

    Scanner sc;

    public ServiceStockProduct(Scanner sc) {
        this.sc = sc;
    }

    public void createProduct() {
        System.out.println(Strings.REGISTRATION.toString());
        String nameProduct = toReceiveNameProduct();
        String typeProduct = toReceiveTypeProduct();
        String modelProduct = toReceiveModelProduct();
        String brandProduct = toReceiveBrandProduct();
        String companyProduct = toReceiveCompanyProduct();
        StockProduct product = null;

        product = new StockProduct(nameProduct, typeProduct, modelProduct, brandProduct, companyProduct);

        this.repository.save(product);
        System.out.println(Strings.REGISTERED.toString() + product);
    }


    private String toReceiveNameProduct() {
        System.out.println(Strings.NAME.toString());
        String name = sc.nextLine();
        return name;

    }

    private String toReceiveTypeProduct() {
        System.out.println(Strings.TYPE.toString());
        String type = sc.nextLine();
        return type;

    }

    private String toReceiveModelProduct() {
        System.out.println(Strings.MODEL.toString());
        String model = sc.nextLine();
        return model;
    }

    private String toReceiveBrandProduct() {
        System.out.println(Strings.BRAND.toString());
        String brand = sc.nextLine();
        return brand;
    }

    private String toReceiveCompanyProduct() {
        System.out.println(Strings.COMPANY.toString());
        String company = sc.nextLine();
        return company;
    }

    public void listProducts() throws SystemProductException {
        List<StockProduct> products = this.orderByIdProducts(this.repository.getAllProducts()).collect(Collectors.toList());
        List<StockProduct> products2 = this.orderByNameProducts(this.repository.getAllProducts()).collect(Collectors.toList());

        System.out.println(Strings.REGISTRATION_MENU.toString());
        int option = sc.nextInt();

        // Exception
        if (option < 0 || option > 3) {
            throw new SystemProductException(Strings.INVALID_OPTION.toString());
        } else if (option == 0) {
            System.out.println(Strings.RETURNING_MENU.toString());
        }

        if (option != 0) {
            System.out.println(Strings.LIST.toString());
        }

        if (option == 1) {
            products.stream().forEach(product -> System.out.println(product));
        } else if (option == 2) {
            products2.stream().forEach(product -> System.out.println(product));
        }

    }

    private Stream<StockProduct> orderByNameProducts(List<StockProduct> list) {
        Stream<StockProduct> order = this.repository.getAllProducts()
                .stream().sorted(Comparator.comparing(StockProduct::getProductName, Comparator
                        .comparing((String s) -> !s.equals("None"))
                        .thenComparing(Comparator.reverseOrder())));

        return order;
    }

    private Stream<StockProduct> orderByIdProducts(List<StockProduct> list) {
        Stream<StockProduct> order = this.repository.getAllProducts()
                .stream().sorted(Comparator.comparing(StockProduct::getId));
        return order;
    }


    public int receiveId() throws SystemProductException {
        System.out.println(Strings.REPORT_ID.toString());
        int id = sc.nextInt();
        if (id == 0) {
            throw new SystemProductException(Strings.RETURNING_MENU.toString());
        }
        return id;
    }


    public void searchByName() throws SystemProductException {
        System.out.println(Strings.REPORT_NAME.toString());
        String bitName = sc.next().toLowerCase();

        List<StockProduct> products = this.orderByNameProducts(this.repository.getAllProducts())
                .filter(product -> product.getProductName().toLowerCase().contains(bitName))
                .collect(Collectors.toList());

        if (products.size() > 1) {
            products.forEach(product -> System.out.println(product));
            this.updateData(this.receiveId());
        } else if (products.size() == 1) {
            this.updateData(products.get(0).getId());
        } else if (products.isEmpty()) {
            throw new SystemProductException(Strings.NO_OCCURRENCE.toString()
                    + bitName + Strings.NO_OCCURRENCE_2);
        }
    }

    public void updateData(int id) throws SystemProductException {
        StockProduct product = this.verifyRepository(id);

        int mainOption;
        boolean procced = true;

        while (procced == true) {
            System.out.println(Strings.HEADER_UPDATE.toString()
                    + product
                    + Strings.OPTIONS_UPDATE);

            mainOption = sc.nextInt();
            sc.nextLine();

            if (mainOption == 1) {
                product.setProductName(toReceiveNameProduct());
            } else if (mainOption == 2) {
                product.setProductType(toReceiveTypeProduct());
            } else if (mainOption == 3) {
                product.setProductModel(toReceiveModelProduct());
            } else if (mainOption == 4) {
                product.setProductBrand(toReceiveBrandProduct());
            } else if (mainOption == 5) {
                product.setProductCompany(toReceiveCompanyProduct());
            } else if (mainOption == 6) {
                this.deleteProduct(product.getId());
                break;
            } else if (mainOption == 0) {
                procced = false;
                throw new SystemProductException(Strings.RETURNING_MENU.toString());
            } else if (mainOption < 0 || mainOption > 6) {
                System.out.println(Strings.DESIRED_OPTION.toString());
            } else {
                System.out.println(Strings.UPDATE.toString());
            }
            product.setChangeDate(new Date());
        }

    }


    private StockProduct verifyRepository(int id) throws SystemProductException {
        StockProduct product = this.repository.getById(id);
        if (product == null) {
            throw new SystemProductException(Strings.NOT_FOUND.toString());
        }
        return product;
    }

    private void deleteProduct(int id) throws SystemProductException {
        StockProduct product = this.verifyRepository(id);

        System.out.println(Strings.DELETE_PRODUCT.toString()
                + product.getProductName()
                + Strings.DELETE_PRODUCT_2.toString());

        String delete = sc.next().toUpperCase();

        if (delete.equals("N")) {
            System.out.println(Strings.RETURNING_MENU.toString());
        } else if (delete.equals("Y")) {
            repository.deleteById(id);
            System.out.println(Strings.DELETED.toString()
                    + Strings.RETURNING_MENU.toString());;
        } else {
            throw new SystemProductException(Strings.INVALID_OPTION_RETURN_MENU.toString());
        }

    }


}