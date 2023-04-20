#include "Adafruit_seesaw.h"
#include <Wire.h>
#include <BH1750.h>
#include <stdio.h>
#include <string.h>

Adafruit_seesaw soil_sensor;
BH1750 light_Meter;
char sensor_data[20] = "";

void setup(){
    Serial.begin(9600);
    Wire.begin();
    light_meter.begin();
    ss.begin(0x36); 
}

void loop(){
    float tempC = ss.getTemp();
    float lux = light_Meter.readLightLevel();
    uint16_t capread = ss.touchRead(0);

    snprintf(sensor_data, 20, "%f %f %d", tempC, lux, capread);
    Serial.print(sensor_data);
    delay(100);
}