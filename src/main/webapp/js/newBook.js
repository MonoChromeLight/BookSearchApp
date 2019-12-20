$("#publish").on("click", function() {

		var name = $('#name').val();
		var genre = $('#genre').val();
		var author = $('#author').val();
		
		
		createBook(name,genre,author);
		//$name.val('');
		
	
	})
	
	var createBook = function(name,genre,author) {
		$.ajax({
			method : "POST",
			url : "createBook",
			data : {
				name   : name,
				genre  : genre,
				author : author
				
			}
		}).done(
				function(response) {
					console.log(response);
		})
	}
////////////////////////////////////////////
$("#delete").on("click", function() {

	var delete_id = $('#delete_id').val();
	
	
	
	deleteBook(delete_id);
	//$name.val('');
	

})

var deleteBook = function(delete_id) {
	$.ajax({
		method : "POST",
		url : "deleteBook",
		data : {
			delete_id :delete_id
			
		}
	}).done(
			function(response) {
				console.log(response);
	})
}
/////////////////////////////////////////////////

$("#findall").on("click", function() {

	
	var name = $('#name').val();
	var genre = $('#genre').val();
	
	
	
	searchBook();
	//$name.val('');
	

})

	var searchBook = function() {
		$.ajax({
			method : "GET",
			url : "all",
			data : {
				
			},
		 	success: function(response){
		 		
					printTable(response);
					
		 	},
			error: function() {
		          alert("There was an error. Try again please!");
		    }
		   
		  
		});
	}

var printTable = function(books) {
	tableMaker = o => {var keys = Object.keys(o[0]),
        rowMaker = (a,t) => a.reduce((p,c,i,a) => p + (i === a.length-1 ? "<" + t + ">" + c + "</" + t + "><td id=\"crud-buttons\"></td></tr>"
                                                                        : "<" + t + ">" + c + "</" + t + ">"),"<tr>"),
            rows = o.reduce((r,c) => r + rowMaker(keys.reduce((v,k) => v.concat(c[k]),[]),"td"),rowMaker(keys,"th"));
        return "<table id=\"books-table\" class=\"table\">" + rows + "</table>";
       };

$("#books-table").html(tableMaker(books));
}
//////////////////////////////////
$("#search").on("click", function() {

	
	var name = $('#name').val();
	var genre = $('#genre').val();
	
	
	console.log($('#genre').val());
	
	searchByName(name,genre);
	//$name.val('');
	

})

	var searchByName = function(name) {
		$.ajax({
			method : "GET",
			url : "searchBy",
			data : {
				name:name
			},
		 	success: function(response){
		 		
					printTable(response);
					
		 	},
			error: function() {
		          alert("There was an error. Try again please!");
		    }
		   
		  
		});
	}
///////////////////////////////////////////////////////////
$(function() {
    $('#books-table').on('click', 'tbody tr', function(event) {
      $(this).addClass('highlight').siblings().removeClass('highlight');
      $(this).css({ background: "#28a745" }).siblings().css({ background: "none" });
      var bookId= $(this).find("td:first").text();
      editBook(bookId);
    });

 

    var getHighlightRow = function() {
      return $('table > tbody > tr.highlight');
    }

    var editBook = function(b_id) {
    	$.ajax({
    		method : "GET",
    		url : "editBook",
    		data : {
    			b_id:b_id
    		},
    	 	success: function(response){
    	 		
    				alert(response);
    				
    				
    	 	},
    		error: function() {
    	          alert("There was an error. Try again please!");
    	    }
    	   
    	  
    	});
     }
  });
