import java.util.*;
import java.io.*;
public class MyMall{
    private static final int TOTALSPACE = 80000;
    private static final String NAME = "Pelinator";
    private static MyMall my;
    /*Comparator<YourBusiness> c = new Comparator<YourBusiness>(){
        
        @Override
        public int compare(YourBusiness business1, YourBusiness business2){
            return business1.getName().compareTo(business1.getName());
        }
    };
    */
    
    /* Set */List <YourBusiness> list = new ArrayList<>(/*c*/);
    
    private MyMall(){
        System.out.println("Welcome to " + MyMall.NAME + "!" );
    }
    
    public static MyMall getInstance(){
        if(my == null){
            my = new MyMall();
        }
        return my;
    }
    
    public void addBusiness(YourBusiness yb){
        try{
            
             if( yb != null){
                if(YourBusiness.spaceOccupied + yb.totalSpace() > TOTALSPACE){
                    throw new ExpandTotalSpaceException();
                }else{
                    list.add(yb);
                }
            }
           System.out.println("You can use " + (MyMall.TOTALSPACE - yb.spaceOccupied) + " square for a new business.");
        }catch( ExpandTotalSpaceException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void showShops(){
        list
        .stream()
        .filter(e -> e instanceof Shop)
        .forEach(System.out::println);
    }
    
    public void showAll(){
        list.forEach(System.out::println);
    }
    
    public void showBusinesses(double totalSpace){
        list
        .stream()
        .filter(e -> e.totalSpace() > totalSpace)
        .forEach(System.out::println);
    }
    
    public void showBusinesses(){
        list
        .stream()
        .filter(e -> e.totalPrice()/e.totalSpace() > 500)
        .forEach(System.out::println);
    }
    
    public void removeBusiness( double totalPrice){
        for(YourBusiness your : list){
            if(your.totalPrice() < totalPrice){
                list.remove(your);
            }
        }
    }

     public void removeBusiness( String name){
        for(YourBusiness your : list){
            if(your.name.equals(name)){
                list.remove(your);
            }
        }
    }
    
    public void saveAll(String file){
        try(
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream  out = new ObjectOutputStream(fos);
        ){
            for(YourBusiness your: list){
              out.writeObject(your);  
            }
          
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void openAll(String file){
        try(
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream  in = new ObjectInputStream(fis);
        ){
            YourBusiness your = (YourBusiness) in.readObject();
            list.add(your);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void saveInformation(String file){
        try(PrintStream ps = new PrintStream(file);
        ){
            for(YourBusiness your : list){
                ps.println(your.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void readInformation(String file){
        try(
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader  br = new BufferedReader(isr);
        ){
            String line;
            while( (line = br.readLine()) != null){
                System.out.println(line);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
}