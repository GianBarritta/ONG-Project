package com.alkemy.ong.utils.seeder;

public interface ISeederDataBase {
    
    void seedActivitiesTable(int amount);

    /*
      TODO:Example pattern for next seeders:

      -> void seed+tableName+Table(int amount);
    */
}