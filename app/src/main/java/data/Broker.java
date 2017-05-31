package data;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import MyAndroid.MyApplication;
import domain.User;


/**
 * Created by albin_000 on 2017-05-04.
 */

/**
 * Broker-mönstret. Brokern är den klass som hanterar läsning och skrivining till långtidslager.
 *
 * Template Method-mönstret. Vi har metoder i den abstrakta klassen "Broker" och varje broker som
 * ärver från den abstrkta brokern har egna implementationer av "getAdress()" och "saveAdress(DataTransferObject dto)"
 */
public abstract class Broker {

    private HashMap<String,DataTransferObject> cacheMap;

    public Broker(){
        cacheMap = new HashMap<>();
    }
    /**
     * Sök i databasen efter input värde och skicka tillbaka en DTO med Arraylist över detalagret.
     * @param dto, file
     */
    public DataTransferObject searchDatabase(DataTransferObject dto, String file){
        ArrayList<String> databaseList = new ArrayList<>();
        MyApplication myapplication;
        try {
            Scanner reader = new Scanner(MyApplication.getInstance().getContext().getAssets().open(file));
            while(reader.hasNextLine()){
                databaseList.add(reader.nextLine());
            }
            reader.close();
            dto.setValues(databaseList);
            dto.setState("used");
            return dto;

        } catch(IOException e){
            e.getMessage();
        }
        return null;
    }
    public DataTransferObject searchDatabaseObject(DataTransferObject dto, String file){
        MyApplication myapplication;
        try{
            myapplication = MyApplication.getInstance();
            Context context = myapplication.getContext();
            FileInputStream inputStream = context.openFileInput(file);
            ObjectInputStream input = new ObjectInputStream(inputStream);


            dto.setValues((ArrayList<User>)(input.readObject()));
            dto.setState("used");
            inputStream.close();
            input.close();
            User user = (User)dto.getValues().get(0);
            return dto;

        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public DataTransferObject writeToFile(DataTransferObject dto, String file){
        MyApplication myapplication;
        try {
            myapplication = MyApplication.getInstance();
            Context context = myapplication.getContext();
            InputStream inputStream = context.getAssets().open(file);
            FileWriter fileWriter = new FileWriter(new File(file));
            fileWriter.write(dto.toString());
            dto.setState("used");
            inputStream.close();
            fileWriter.close();
            return dto;
        } catch (IOException e){
            e.getMessage();
        }
        return dto;
    }
    public DataTransferObject writeObjectToFile(DataTransferObject dto, String file){
        MyApplication myapplication;
        User user = (User)dto.getValues().get(0);

        try{
            myapplication = MyApplication.getInstance();
            Context context = myapplication.getContext();
            FileOutputStream outputStream = context.openFileOutput(file,context.MODE_PRIVATE);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            dto.setState("used"); //Hannes test
            output.writeObject(dto.getValues());
            output.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public DataTransferObject save(DataTransferObject dto){
        updateCache(dto);
        saveAdress(dto);
        return dto;
    }

    /**
     * Simple Cache-mönstret. Cachen kollas innan långtidslagret kontrolleras. Om den eftersökta
     * datan finns i cachen slipper man ladda datan från sitt långtidslager. Cachen förekommer på flera
     * ställen i brokern, vid sparning, laddning och borttagning, nedan är ett exempel.
     * @param dto
     * @return
     */
    public DataTransferObject load(DataTransferObject dto){
        if(cacheMap != null){
            for(int i = 0; i < cacheMap.size(); i++) {
                if(cacheMap.get(i)!=null) {
                    if (cacheMap.get(i).getTag().equals(dto.getTag())) {
                        return cacheMap.get(i);
                    }
                }
            }
        }

        checkCache(dto.getTag());
        dto = getAdress(dto);

        return dto;
    }
    public DataTransferObject remove(DataTransferObject dto){
        if(cacheMap != null){
            for(int i = 0; i < cacheMap.size(); i++){
                if(cacheMap.get(i).equals(dto)){
                    cacheMap.values().remove(dto);
                }
            }
        }
        return dto;
    }

    /**
     * Object Identifier-mönstret. Metoden tar reda på vad som finns i dto:n, om det är en user, produktlista osv.
     * @param dto
     * @return
     */
    public abstract DataTransferObject getAdress(DataTransferObject dto);
    /**
     * Object Identifier-mönstret. Metoden tar reda på vad som finns i dto:n, om det är en user, produktlista osv.
     * @param dto
     * @return
     */
    public DataTransferObject saveAdress(DataTransferObject dto) { return dto; }
    public boolean updateCache(DataTransferObject dto){
        this.cacheMap.put(dto.getTag(), dto);
        return true;
    }
    public DataTransferObject checkCache(String tag){
        if (cacheMap != null) {
            if (cacheMap.containsKey(tag)) {
                return cacheMap.get(tag);
            }
        }
        return null;
    }
}
