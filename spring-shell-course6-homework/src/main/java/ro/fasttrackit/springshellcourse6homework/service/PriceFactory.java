package ro.fasttrackit.springshellcourse6homework.service;

import org.springframework.stereotype.Component;

@Component
public class PriceFactory implements CustomFactory<Double>{
    @Override
    public Double getFromString(String priceString) {
        try{
            return Double.parseDouble(priceString);
        }catch (Exception e){
            throw new RuntimeException("Invalid price format");
        }
    }
}
