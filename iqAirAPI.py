from flask import Flask
import requests
import json
from datetime import datetime
from datetime import timedelta

class APIInfo:
    def __init__(self, data):
        self.data = data

data = {}

APIData = APIInfo(data)

def timeCheck(prevTime):
    ts_conv = datetime.strptime(prevTime, '%Y-%m-%dT%H:%M:%S.%fZ')
    now = datetime.utcnow()
    delta = timedelta(minutes=5)
    print(now - ts_conv)
    return ((now - ts_conv) > delta)
    
def jsonObjCheck(key):
    if len(APIData.data)==0:
        resp = requests.get('https://www.airvisual.com/api/v2/node/' + key)
        diction = resp.json()
        APIData.data.update(diction)
        print("The response was empty. Calling IQ Air for new data.")                
    elif timeCheck(APIData.data["current"]["ts"]) == False:
        resp = requests.get('https://www.airvisual.com/api/v2/node/' + key)
        diction = resp.json()
        APIData.data.update(diction)
        print("The time passed 5 minutes. Calling IQ Air for new data.")
    else:
        print("Returning the current data.")
    return (APIData.data)

app = Flask(__name__)

@app.route('/')
def index():
    return "Will fill with API documentation"


###################----GET METHODS----#####################

## ------------- Post GET Method -------------------

@app.route('/<string:key>', methods=['GET'])
def get(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict, sort_keys=True, indent=4)
    return(jsonResponse)

## ----------- Historical GET Methods ---------------

@app.route('/<string:key>/historical', methods=['GET'])
def getHistorical(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

# ------------ Historical DAILY GET Methods --------------
@app.route('/<string:key>/historical/daily', methods=['GET'])
def getHistoricalDaily(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>', methods=['GET'])
def getHistoricalDaily_id(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/co_count', methods=['GET'])
def getHistoricalDaily_id_coCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['co_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/co_sum', methods=['GET'])
def getHistoricalDaily_id_coSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['co_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/hm_count', methods=['GET'])
def getHistoricalDaily_id_hmCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['hm_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/hm_sum', methods=['GET'])
def getHistoricalDaily_id_hmSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['hm_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/outdoor_station', methods=['GET'])
def getHistoricalDaily_id_outdoorStation(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['outdoor_station'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p01_count', methods=['GET'])
def getHistoricalDaily_id_p01Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p01_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p01_sum', methods=['GET'])
def getHistoricalDaily_id_p01Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p01_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p1_sum', methods=['GET'])
def getHistoricalDaily_id_p1Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p1_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p1_count', methods=['GET'])
def getHistoricalDaily_id_p1Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p1_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p2_sum', methods=['GET'])
def getHistoricalDaily_id_p2Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p2_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/p2_count', methods=['GET'])
def getHistoricalDaily_id_p2Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['p2_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/tp_sum', methods=['GET'])
def getHistoricalDaily_id_tpSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['tp_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/tp_count', methods=['GET'])
def getHistoricalDaily_id_tpCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['tp_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/daily/<int:num>/ts', methods=['GET'])
def getHistoricalDaily_id_ts(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['daily'][num]['ts'], sort_keys=True, indent=4)
    return (jsonResponse)

# ------------ Historical HOURLY GET Methods ---------------

@app.route('/<string:key>/historical/hourly', methods=['GET'])
def getHistoricalHourly(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>', methods=['GET'])
def getHistoricalHourly_id(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/co_count', methods=['GET'])
def getHistoricalHourly_id_coCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/co_sum', methods=['GET'])
def getHistoricalHourly_id_coSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['co_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/hm_count', methods=['GET'])
def getHistoricalHourly_id_hmCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['hm_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/hm_sum', methods=['GET'])
def getHistoricalHourly_id_hmSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['hm_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/outdoor_station', methods=['GET'])
def getHistoricalHourly_id_outdoorStation(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['outdoor_station'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p01_count', methods=['GET'])
def getHistoricalHourly_id_p01Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p01_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p01_sum', methods=['GET'])
def getHistoricalHourly_id_p01Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p01_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p1_sum', methods=['GET'])
def getHistoricalHourly_id_p1Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p1_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p1_count', methods=['GET'])
def getHistoricalHourly_id_p1Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p1_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p2_sum', methods=['GET'])
def getHistoricalHourly_id_p2Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p2_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/p2_count', methods=['GET'])
def getHistoricalHourly_id_p2Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['p2_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/tp_sum', methods=['GET'])
def getHistoricalHourly_id_tpSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['tp_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/tp_count', methods=['GET'])
def getHistoricalHourly_id_tpCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['tp_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/hourly/<int:num>/ts', methods=['GET'])
def getHistoricalHourly_id_ts(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['hourly'][num]['ts'], sort_keys=True, indent=4)
    return (jsonResponse)

# ------------ Historical INSTANT GET Methods ---------------

@app.route('/<string:key>/historical/instant', methods=['GET'])
def getHistoricalInstant(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>', methods=['GET'])
def getHistoricalInstant_id(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/co', methods=['GET'])
def getHistoricalInstant_id_co(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/errors', methods=['GET'])
def getHistoricalInstant_id_errors(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/errors/voc', methods=['GET'])
def getHistoricalInstant_id_errors_voc(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/hm', methods=['GET'])
def getHistoricalInstant_id_hm(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/p01', methods=['GET'])
def getHistoricalInstant_id_p01(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/p1', methods=['GET'])
def getHistoricalInstant_id_p1(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/p2', methods=['GET'])
def getHistoricalInstant_id_p2(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/tp', methods=['GET'])
def getHistoricalInstant_id_tp(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/instant/<int:num>/ts', methods=['GET'])
def getHistoricalInstant_id_ts(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical'], sort_keys=True, indent=4)
    return (jsonResponse)

# ------------ Historical MONTHLY GET Methods ---------------

@app.route('/<string:key>/historical/monthly', methods=['GET'])
def getHistoricalMonthly(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>', methods=['GET'])
def getHistoricalMonthly_id(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/co_count', methods=['GET'])
def getHistoricalMonthly_id_coCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['co_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/co_sum', methods=['GET'])
def getHistoricalMonthly_id_coSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['co_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/hm_count', methods=['GET'])
def getHistoricalMonthly_id_hmCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['hm_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/hm_sum', methods=['GET'])
def getHistoricalMonthly_id_hmSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['hm_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p01_count', methods=['GET'])
def getHistoricalMonthly_id_p01Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p01_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p01_sum', methods=['GET'])
def getHistoricalMonthly_id_p01Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p01_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p1_sum', methods=['GET'])
def getHistoricalMonthly_id_p1Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p1_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p1_count', methods=['GET'])
def getHistoricalMonthly_id_p1Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p1_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p2_sum', methods=['GET'])
def getHistoricalMonthly_id_p2Sum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p2_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/p2_count', methods=['GET'])
def getHistoricalMonthly_id_p2Count(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['p2_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/tp_sum', methods=['GET'])
def getHistoricalMonthly_id_tpSum(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['tp_sum'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/tp_count', methods=['GET'])
def getHistoricalMonthly_id_tpCount(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['tp_count'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/historical/monthly/<int:num>/ts', methods=['GET'])
def getHistoricalMonthly_id_ts(key,num):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['historical']['monthly'][num]['ts'], sort_keys=True, indent=4)
    return (jsonResponse)

## ---------------- Current GET Methods ---------------------

@app.route('/<string:key>/current', methods=['GET'])
def getCurrent(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/co', methods=['GET'])
def getCurrent_co(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['co'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/errors', methods=['GET'])
def getCurrent_errors(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['errors'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/errors/voc', methods=['GET'])
def getCurrent_errors_voc(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['errors']['voc'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/hm', methods=['GET'])
def getCurrent_hm(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['hm'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/p01', methods=['GET'])
def getCurrent_p01(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['p01'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/p1', methods=['GET'])
def getCurrent_p1(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['p1'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/p2', methods=['GET'])
def getCurrent_p2(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['p2'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/tp', methods=['GET'])
def getCurrent_tp(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['tp'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/current/ts', methods=['GET'])
def getCurrent_ts(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['current']['ts'], sort_keys=True, indent=4)
    return (jsonResponse)

## ---------------- Current GET Methods ---------------------

@app.route('/<string:key>/settings', methods=['GET'])
def getSettings(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['settings'], sort_keys=True, indent=4)
    return (jsonResponse)

@app.route('/<string:key>/settings/node_name', methods=['GET'])
def getSettings_nodeName(key):
    newDict = jsonObjCheck(key)
    jsonResponse = json.dumps(newDict['settings']['node_name'], sort_keys=True, indent=4)
    return (jsonResponse)

###################----END GET METHODS----#####################

if (__name__) == '__main__':
    app.run(debug=True)

