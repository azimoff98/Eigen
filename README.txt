# Eigen
Eigen Test Project

Application runs on localhost:4444.

credentials for postgre local server :
    url=jdbc:postgresql://localhost:5432/postgres
    username=postgres
    password=admin

Installation:
  You must have installed PostgreSQL in your local and installed and configured Lombok plugin in your IDE.
  Everytime when application is being stared application creates table
  with name my_table and inserts 7 simulated data.
  When applciation is terminated all data and table will be removed due to create-drop policy.

  API :

    getLatest => "/rest/model/latest" => GET
      returns lastest record in table.

    getGoodValues => "/rest/model/goods" => GET
     example : localhost:4444/rest/model/goods?from=01-01-2000&to=01-01-2019
     returns list of good values between 01-01-2000 and 01-01-2019.

    getAverageValue => "/rest/model/average" => GET
      example : localhost:4444/rest/model/average?from=01-01-2000&to=01-01-2019
      returns average value for dates between 01-01-2000 and 01-01-2019.

     findById => "rest/model/{id}" => GET
      example : localhost:4444/rest/model/5
      returns record from table with id 5.

     findAll => "/rest/model/all" => GET
      example : localhost:4444/rest/model/all
      returns list of all models.

     save => "/rest/model/save" => POST
      example : localhost:4444/rest/model/save  => {
	                                                     "date":"2016-05-05",
	                                                     "value":74.3,
	                                                     "engineeringUnit":"Test",
	                                                     "quality":false
                                                    }
      creates new model.



     update => "/rest/model/update" => PUT
      example : localhost:4444/rest/model/update  => {
	                                                     "date":"2016-05-05",
	                                                     "value":74.3,
	                                                     "engineeringUnit":"Test",
	                                                     "quality":false
                                                     }
      updates record.


     deleteById => "/rest/model/{id}" => DELETE
      example : localhost:4444/rest/model/5
      deletes record with id 5.


     deleteAll => "/rest/model/all" => DELETE
      example : localhost:4444/rest/all
      deletes all data.



