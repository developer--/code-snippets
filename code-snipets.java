

// Simple GET request using Volley

    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue queue;
    private void getDataFromServer(String url){
        if (queue == null){
            queue = new Volley().newRequestQueue(mActivity);
        }
        if (jsonArrayRequest == null){
            jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    your_collection = MyParser.parseJsonArray(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //eror 
                }
            });
        }
        queue.add(jsonArrayRequest);
    }
