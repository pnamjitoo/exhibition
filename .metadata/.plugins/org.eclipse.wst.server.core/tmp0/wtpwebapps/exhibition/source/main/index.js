/***** 

var makeAjaxCall = function (url, success_callback) {
  $.ajax ({  
    type: 'POST',  
    url: url,
    data: 'some data',
    success: success_callback
  });
};



makeAjaxCall(
  'some_url1',
  makeAjaxCall(
    'some_url2',
    function() {}
  )
);

*****/

var makeAjaxCall = function (url, success_callback) {
  $.ajax ({  
    type: 'POST',  
    url: url,
    data: 'some data',
    success: success_callback
  });
};

makeAjaxCall(
  'some_url1',
  makeAjaxCall(
    'some_url2',
    function() {}
  )
);