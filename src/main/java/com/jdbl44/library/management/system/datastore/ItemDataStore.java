package com.jdbl44.library.management.system.datastore;

import com.jdbl44.library.management.system.database.ConnectionManager;
import com.jdbl44.library.management.system.model.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Builder
@Getter
@Setter
@Component
public class ItemDataStore {
    private static final String INSERT_ITEM = "insert into item(name,author,publisher,category) values(?,?,?,?)";

    private static final String GET_ITEM_COUNT = "select availableCopies from item where name=? and author=? and publisher=? and catagory=?";
    private static final String UPDATE_ITEM = "update table item set availableCopies=? where name=? and author=? and publisher=? and catagory=?";

    private static Connection connection = ConnectionManager.getConnection();

    public static int addNewItem(Item item){

            int updateCount =0;
            try {
                boolean isAvailable = false;
                int copies = checkIfItemAlreadyExist(item,isAvailable);
                if (isAvailable) {
                    PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ITEM);
                    preparedStatement.setInt(1, copies+1);

                    preparedStatement.setString(2, item.getName());
                    preparedStatement.setString(3, item.getAuthor());
                    preparedStatement.setString(4, item.getPublisher());
                    preparedStatement.setString(5, item.getCatagory());

                    updateCount = preparedStatement.executeUpdate();
                    if (updateCount > 0) {
                        System.out.println("Item updated Successfully..");
                    } else {
                        System.out.println("Failed to update..");
                    }

                } else {
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM);

                    preparedStatement.setString(1, item.getName());
                    preparedStatement.setString(2, item.getAuthor());
                    preparedStatement.setString(3, item.getPublisher());
                    preparedStatement.setString(4, item.getCatagory());

                    updateCount = preparedStatement.executeUpdate();

                    if (updateCount > 0) {
                        System.out.println("Item inserted Successfully..");
                    } else {
                        System.out.println("Failed to insert..");
                    }
                }
            }
            catch (Exception sqlException) {
                System.out.println(sqlException.getMessage());
            }
            return updateCount;

    }

    public static int checkIfItemAlreadyExist(Item item,boolean isAvailable){

        int currentCopies=0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getAuthor());
            preparedStatement.setString(3, item.getPublisher());
            preparedStatement.setString(4, item.getCatagory());

            ResultSet resultSet = preparedStatement.executeQuery(GET_ITEM_COUNT);

            while (resultSet.next()){
                currentCopies=resultSet.getInt(1);
                isAvailable=true;
            }
        }
        catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());

        }
        return currentCopies;

    }


}
