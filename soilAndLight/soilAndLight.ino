#include "Adafruit_seesaw.h"
#include <Wire.h>
#include "BH1750.h"
#include <stdio.h>

Adafruit_seesaw soil_sensor;
BH1750 light_meter;
char sensor_data[20] = "";
char Str_Lux[10];
char Str_Temp[10];

void setup(){
    Serial.begin(9600);
    Wire.begin();
    // check to make sure the light sensor initiates properly. If not, don't run the sketch
    if(!light_meter.begin()){
        Serial.println("light sensor not found!");
        exit(0); // loops infinitely
    }
    // check to make the soil sensor initiates properly. If not, don't run the sketch
    if(!soil_sensor.begin(0x36)){
        Serial.println("soil sensor not found!");
        exit(0); // loops infinitely
    } 
}

void loop(){
    //Storing the variables from the sensors
    float soil_temp = soil_sensor.getTemp();
    float lux = light_meter.readLightLevel();
    uint16_t soil_moisture = soil_sensor.touchRead(0);

    //Converting floats to string due to Arduino IDE does not take Floats
    dtostrf(lux,4,2,Str_Lux);
    dtostrf(soil_temp, 4, 2, Str_Temp);

    //Taking the data and sending it to the COM port to be read by ReadSensor.py 
    snprintf(sensor_data, 20, "%s %s %d", Str_Temp, Str_Lux, soil_moisture);
    Serial.println(sensor_data);
    delay(1000);
}