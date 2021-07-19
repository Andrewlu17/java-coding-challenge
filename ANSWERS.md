# Challenge answers

## A - The entities
I have provided a diagram of UML in images folder.
I have created Catalogue entity which contains a list of Models and Model entry which will contain Engine, Wheel and Submodels.

## B - Ingest the data
I have used the files provided in resource folder to create the Catalogue model and save the list in db.

## C - Expose data with a RESTful API
I have provided an url named "api/v1/models/{identifier}" where identifier can be ID or model name(name of the model provided in XML file). 
This will return the data in expected format.

## D - Adding images
We can use MultiPartfile to accept the file and then save that file on S3 or any other desired server and save that location in our entity as image name.

## E - Improvements
I have handled exceptions whenever car is not available for given condition. I have used global exception handler to do that.
Added swagger for API documentation it can be opened at localhost:8080/swagger-ui.html