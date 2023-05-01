# Arduino Light and Moisture Sensor
Welcome to the Arduino Light and Moisture Sensor! 

The purpose of this project is to provide a simple tool for gardeners to measure and track the environmental conditions in their gardens. The sensors provide three sets of data: temperature, luminosity, and moisture. The average of each of these is reported through the JavaFX graphical interface, and if further analysis is desired, an Excel spreadsheet containing all the data collected is also generated so that more specific analysis on the data collected can be done. 

![This is a screenshot.](images.png)
# How to Build   
- Download the latest release containing all the files for this project from the main branch
- Compile launcher.java into a .jar file
    + This requires linking the JavaFX library
        - The easiest way to do this is to use the full JDK provided by [BellSoft](https://bell-sw.com/pages/downloads/)
- First ArduinoInterface.java must be compiled into a class file      
```
javac ArduinoInterface.java  
```
- Then the class file must be compiled into an executable .jar file
```
jar cvfe ArduinoInterface.jar ArduinoInterface ArduinoInterface.class
```
# How to run
- Connect an Arduino to your computer and using a tool such as Arduino IDE upload the soilAndLight folder containing the soilAndLight sketch to the Arduino

- With the Arduino connected to your computer, check the connected devices to see which COM the Arduino is connected to
    + if it is any COM port other than COM3, then the value 'COM3' on line 6 of ReadSensor.py will have to be changed to whichever COM port your Arduino is connected to

- Ensure that the Arduino IDE (or any analoguous tool used to upload the sketch) is closed, as it will interfere with the ability to collect data directly from the Arduino

- You can run the jar created in the How To Build section from the command line
```
java -jar ArduinoInterface.jar
```
- This will automatically start the scripts necessary for collecting data from the Arduino
- Alternatively, a tool such as [Launch4j](https://launch4j.sourceforge.net/) can be used to package the jar into an executable

- In either case, this file must be run from the same directory containing the Python scripts ReadSensor.py and SensorDataToExcel.py, or else the scripts will not run

# How to contribute
Follow this project board to know the latest status of the project: [http://...]([http://...])  

# How to build
- Use this github repository: ... 
- Specify what branch to use for a more stable release or for cutting edge development.  
- Use InteliJ 11
- Specify additional library to download if needed 
- What file and target to compile and run. 
- What is expected to happen when the app start. 
