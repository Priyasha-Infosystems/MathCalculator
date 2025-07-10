package ccordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void add(JSONArray args, CallbackContext callbackContext) {
        if (args != null) {
            try {
                AddRequest addRequest = new AddRequest();
                addRequest.setParam1(Integer.parseInt(args.getJSONObject(0).getString("param1")));
                addRequest.setParam2(Integer.parseInt(args.getJSONObject(0).getString("param2")));
                addRequest.setResult(addRequest.getParam1() + addRequest.getParam2());
                callbackContext.success(addRequest);
            }
            catch(Exception ex) {
                callbackContext.error("Somthing went wrong -"+ex);
            }
        }
        else {
            callbackContext.error("geting null value");
        }
    }

    private class AddRequest {
        private int param1;
        private int param2;
        private int result;

        public int getParam1(){
            return param1;
        }
        public int getParam2(){
            return param2;
        }
        public int getResult(){
            return result;
        }
        public void setParam1(int param1){
            param1 = param1;
        }
        public void setParam2(int param2){
            param2 = param2;
        }
        public void setResult(int result){
            result = result;
        }

    }
}
