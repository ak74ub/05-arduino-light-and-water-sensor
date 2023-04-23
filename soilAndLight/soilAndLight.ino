#include "Adafruit_seesaw.h"
#include <Wire.h>
#include "BH1750.h"
#include <stdio.h>
#include <string.h>

Adafruit_seesaw soil_sensor;
BH1750 light_meter;
char sensor_data[20] = "";
char Str_Lux[30];
char Str_Capread[30];
char Str_Temp[30];

void setup(){
    Serial.begin(9600);
    Wire.begin();
    light_meter.begin();
    soil_sensor.begin(0x36); 
}

void loop(){
    //Storing the variables from the sensors
    float tempC = soil_sensor.getTemp();
    float lux = light_meter.readLightLevel();
    uint16_t capread = soil_sensor.touchRead(0);

    Serial.println(tempC);

    //Converting floats to string due to Arduino IDE does not take Floats
    dtostrf(lux,4,2,Str_Lux);
    dtostrf(capread,4,2, Str_Capread);
    dtostrf(tempC, 4, 2, Str_Temp);

    //Taking the data and printing it to a file. 
    snprintf(sensor_data, 20, "%s %s %s", Str_Temp, Str_Lux, Str_Capread);
    Serial.println(sensor_data);
    delay(1000);
}