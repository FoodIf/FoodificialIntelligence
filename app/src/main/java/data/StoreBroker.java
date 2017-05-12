package data;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class StoreBroker extends Broker {

    public StoreBroker() {

    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        switch(dto.getTag()){
            case "ica": dto = searchDatabase(dto, "productsIcaMaxi.txt");
                break;
            case "coop": dto = searchDatabase(dto, "productsCoop.txt");
                break;
            case "citygross": dto = searchDatabase(dto, "productsCityGross.txt");
            }
        return dto;
    }
    @Override
    public DataTransferObject saveAdress(DataTransferObject dto){
        switch(dto.getTag()){
            case "ica": writeToFile(dto, "productsIcaMaxi.txt");
                break;
            case "coop": writeToFile(dto, "productsCoop.txt");
                break;
            case "citygross": writeToFile(dto, "productsCityGross.txt");
        }
        return dto;
    }
}
