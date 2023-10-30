import exception.SystemProductException;
import service.ServiceStockProduct;
import util.Strings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        ServiceStockProduct serviceStockProduct = new ServiceStockProduct(sc);

        boolean toBeContinued = true;

        do {
            try {
                System.out.println(Strings.MAIN_MENU.toString());
                int mainOption = sc.nextInt();
                sc.nextLine();
                switch (mainOption) {
                    case 1:
                        serviceStockProduct.createProduct();
                        break;
                    case 2:
                        serviceStockProduct.listProducts();
                        break;
                    case 3:
                        serviceStockProduct.searchByName();
                    case 4:
                        serviceStockProduct.updateData(serviceStockProduct.receiveId());
                    case 0:
                        System.out.println(Strings.CLOSING.toString());
                        toBeContinued = false;
                        break;
                    default:
                        System.out.println(Strings.INVALID_OPTION.toString());
                        break;
                }


            } catch (SystemProductException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println(Strings.INVALID_OPTION.toString());
                sc.next();
            }finally {
                Thread.sleep(1500l);
            }
        } while (toBeContinued);
    }
}