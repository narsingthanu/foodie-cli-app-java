package com.foodie.app.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.foodie.app.model.Customer;
import com.foodie.app.model.Dish;
import com.foodie.app.model.Restaurant;


public class CsvReader {
	private static final String DATA_FOLDER = "data";
	
	public List<Customer> readcustomersFromCsv(){
		String customersCsvFilePath = DATA_FOLDER + "/customers.csv";
		List<Customer> customersList = new ArrayList<>();
		//java io classes (Filereader , BufferedReader)
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(customersCsvFilePath))){
			String cvsSplitBy = ",";
			br.readLine();
			while((line = br.readLine()) != null) {
				String[] data = line.split(cvsSplitBy);
				Customer customer = new Customer();
				customer.setId(data[0])
				        .setName(data[1])
				        .setEmail(data[2])
				        .setPassword(data[3]);
				customersList.add(customer);
				        
				    
			}
		}catch(IOException e) {
			System.out.println("File not found in the path" + customersCsvFilePath);
			System.exit(0);
			e.printStackTrace();
		}
		return customersList;
		
	}
	
    
    public List<Dish> readDishesFromCsv() {
        String DISHES_CSV_PATH = DATA_FOLDER + "/dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Dish dish = new Dish();
                dish.setId(data[0])
                        .setName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishesList.add(dish);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }
    
    public List<Restaurant> readRestaurantsFromCsv() {
        String RESTAURANTS_CSV_PATH = "data/restaurants.csv";
        String line;
        List<Restaurant> restaurantsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RESTAURANTS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + RESTAURANTS_CSV_PATH);
            System.exit(0);
        }
        return restaurantsList;
    }
        
}
