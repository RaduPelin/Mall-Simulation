import java.io.*;
public class Program{
    public static void main(String [] args){
        try(
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        ){
            while(true){
                System.out.println("Type:");
                String line = br.readLine();

                String [] buffer = line.split("\\s+");

                switch(buffer[0]){
                    case "Exit":
                    System.out.println("Closing...");
                    return;

                    case "AddShop":

                    int index = 0;
                    int nr = 0;
                    for( int i = 4;  i <  buffer.length; i++){
                        if(buffer[i].equals("1")|| buffer[i].equals("2") || buffer[i].equals("3")){
                           nr++;
                        }
                    }

                    int [] floor = new int[nr];

                    for( int i = 4;  i <  buffer.length; i++){
                        if(buffer[i].equals("1")|| buffer[i].equals("2") || buffer[i].equals("3")){
                           floor[index] = Integer.parseInt(buffer[i]);
                           index++;
                        }
                    }

                    Shop shop = new Shop(buffer[1], Double.parseDouble(buffer[2]), buffer[3], floor, Double.parseDouble(buffer[buffer.length - 1]));
                    MyMall.getInstance().addBusiness(shop);
                    System.out.println("A shop was add in the mall!");
                    break;

                    case "AddRestaurant":
                    Restaurant rest = new Restaurant(buffer[1], Double.parseDouble(buffer[2]), buffer[3], Double.parseDouble(buffer[4]), Integer.parseInt(buffer[5]));
                    MyMall.getInstance().addBusiness(rest);
                    System.out.println("A restaurant was add in the mall!");
                    break;

                    case "AddFastFood":
                    FastFood fast = new FastFood(buffer[1], Double.parseDouble(buffer[2]), buffer[3], Double.parseDouble(buffer[4]), Double.parseDouble(buffer[5]));
                    MyMall.getInstance().addBusiness(fast);
                    System.out.println("A FastFood restaurant was add in the mall!");
                    break;

                    case "AddCinema":
                    Cinema cinema = Cinema.getInstance(buffer[1], Double.parseDouble(buffer[2]), Integer.parseInt(buffer[3]), Double.parseDouble(buffer[4]), Double.parseDouble(buffer[5]));
                    MyMall.getInstance().addBusiness(cinema);
                    System.out.println("A cinema was add in the mall!");
                    break;

                    case "ShowShops":
                    MyMall.getInstance().showShops();
                    break;

                    case "ShowAll":
                    MyMall.getInstance().showAll();
                    break;

                    case "ShowBusinesses":
                    MyMall.getInstance().showBusinesses(Double.parseDouble(buffer[1]));
                    break;

                    case "ShowProfi":
                    MyMall.getInstance().showBusinesses();
                    break;

                    case "RemoveByPrice":
                    MyMall.getInstance().removeBusiness(Double.parseDouble(buffer[1]));
                    System.out.println("Romove with succes!");
                    break;

                    case "RemoveByName":
                    MyMall.getInstance().removeBusiness(buffer[1]);
                    System.out.println("Romove with succes!");
                    break;

                    case "SaveInfo":
                    MyMall.getInstance().saveInformation(buffer[1]);
                    System.out.println("All information was saved in " + buffer[1]);
                    break;

                    case "ReadInfo":
                    MyMall.getInstance().readInformation(buffer[1]);
                    break;

                    case "SaveAll":
                    MyMall.getInstance().saveAll(buffer[1]);
                    System.out.println("The information was saved in " + buffer[1]);
                    break;

                    case "OpenAll":
                    MyMall.getInstance().openAll(buffer[1]);
                    break;

                    default :
                    System.out.println("Try another option");
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
