

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




    //POST StringRequest using Volley

    private void makePostRequest() {
        // Add custom implementation, as needed.
        final String value1 = "Jemo";
        final String value2 = "Mgebrishvili";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //error
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("param1", value1);
                params.put("param2", value2);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }