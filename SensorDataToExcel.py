import pandas
import openpyxl

f = open("SensorData.txt", "r")
sensorInfo = ""
dataFrame = pandas.DataFrame(columns=['temperature', 'lux', 'moisture'])

sensorInfo = f.readline()
sensorInfo = sensorInfo.strip()
sensorInfo = sensorInfo.split(" ")
while sensorInfo != ['']:
    dataFrame.loc[len(dataFrame.index)] = sensorInfo
    sensorInfo = f.readline()
    sensorInfo = sensorInfo.strip()
    sensorInfo = sensorInfo.split(" ")
    

dataFrame.to_excel('SensorDataToExcel.xlsx')
print(dataFrame)

f.close()