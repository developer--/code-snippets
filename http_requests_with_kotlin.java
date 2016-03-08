  //Request with kotlin library 

  Manager.instance.basePath = "https://httpbin.org"
  Fuel.get("/get").responseJson { request, response, result ->
    println(response)
  }
  
  
  
  //an extension over string (support GET, PUT, POST, DELETE with httpGet(), httpPut(), httpPost(), httpDelete())
  "http://httpbin.org/get".httpGet().responseString { request, response, result ->
    //do something with response
    when (result) {
        is Result.Failure -> {
            error = result.getAs()
        }
        is Result.Success -> {
            data = result.getAs()
        }
    }
  }


  //if you prefer this a little longer way, you can always do
  //get
  Fuel.get("http://httpbin.org/get").responseString { request, response, result ->
    //do something with response
    result.fold({ d ->
        //do something with data
    }, { err ->
        //do something with error
    })
  }
  
  
  Fuel.post("http://httpbin.org/post").response { request, response, result ->
    println(response)
  }

  //if you have body to post it manually
  Fuel.post("http://httpbin.org/post").body("{ \"foo\" : \"bar\" }").response { request, response, result ->
    println(response)
  }
  
  Fuel.get("http://httpbin.org/get", listOf("foo" to "foo", "bar" to "bar")).response { request, response, result -> {
    //resolve to http://httpbin.org/get?foo=foo&bar=bar
  }

  Fuel.delete("http://httpbin.org/delete", listOf("foo" to "foo", "bar" to "bar")).response { request, response, result ->
    //resolve to http://httpbin.org/get?foo=foo&bar=bar
  }
  //Support x-www-form-urlencoded for PUT & POST
  Fuel.post("http://httpbin.org/post", listOf("foo" to "foo", "bar" to "bar")).response { request, response, result ->
     //http body includes foo=foo&bar=bar
  }

  Fuel.put("http://httpbin.org/put", listOf("foo" to "foo", "bar" to "bar")).response { request, response, result ->
    //http body includes foo=foo&bar=bar
  }


  compile 'com.github.kittinunf.fuel:fuel:1.1.0' //for JVM
  compile 'com.github.kittinunf.fuel:fuel-android:1.1.0' //for Android
  compile 'com.github.kittinunf.fuel:fuel-rxjava:1.1.0' //for RxJava support
