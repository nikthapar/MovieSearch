
let $output = $("#output");
let data = null;
let $submit = $('#submit');
let $mydiv = $('#mydiv');
let $row1 = $('#row1');
function myFunction(){
	$output.empty();
	let APIKEY = "1f39dea1e4239caa8c1ae2c4975e9926";
	let baseURL="https://api.themoviedb.org/3/";
	let url="".concat(baseURL,'configuration?api_key=',APIKEY);
	
	fetch(url)
	.then((result)=>{
	    console.log("hello");
	    return result.json();
	})
	.then((data)=>{
	    var temp=document.getElementById('searchText').value;
	    console.log(temp);
	    runSearch(temp);
	})
}

let runSearch=function(keyword){
    let url=''.concat('https://api.themoviedb.org/3/','search/movie?api_key=','1f39dea1e4239caa8c1ae2c4975e9926','&query=',keyword);
    fetch(url)
    .then(result=>result.json())
    .then(resp=>{
    	data = resp;
    	inner();
    })
}

function inner(){
	$mydiv.empty();
	$row1.empty();
	let movieList = data ? data.results : [];
	for(let i = 0; i < movieList.length; i++){
		let item = movieList[i];
		$output.append(getMovieItemHTML(item,i));
	}
};

function getMovieItemHTML(item,i){
	let html = "";
	html = "<div class='movie-item'>" +
	        '<div class="items"><img src="http://image.tmdb.org/t/p/w500' + data.results[i].poster_path + '" width=200 height=300>'+"</div>"+
			"<div style='padding-left:10px'><input type='checkbox' name='movie'/></div>"+
			"</div>"
	return html;
};

$submit.on('click', function(){
	if(!data){alert('no movie selected'); return}
	let checkedResults = [];
	let $movieItems = $('.movie-item');
	for(let i = 0; i< $movieItems.length; i++){
		if($($movieItems[i]).find('input').is(':checked')){
			checkedResults.push(data.results[i].id)
		}
	}
	count(checkedResults);
	
})



function action1(){
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			alert("hello");
			var arr = JSON.parse(this.responseText);
			if(arr.Movies.length==0){
				alert("No Movie In Cart");
				window.location.href="/MovieCart1/"
			}
			else{
				$mydiv.empty();
				$row1.empty();
			    Detail(arr.Movies);
			    $row1.append("<br><span ><h5 id='count'>Total Movies In Cart "+arr.Movies.length+"</h5></span>");
			}
		}
	};
	
	var params = "type=0";
	xmlhttp.open('GET',"http://localhost:8084/MovieCart1/view?"+params, true);
	xmlhttp.send();
}


function remove(index){
	var xmlhttp = new XMLHttpRequest();
		
		xmlhttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				var arr = JSON.parse(this.responseText);
				if(arr.flag == "1"){
					alert("Deleate Succesfully");
					$("#movie-"+index).remove();
					var a =$('#count');
					a.text("Total Movie in Cart "+arr.count);
				}
				else{
					alert("Failed");
				}
				

			}
		};
		
		var params = "type=1&"+"index="+index;
		xmlhttp.open('GET',"http://localhost:8084/MovieCart1/view?"+params, true);
		xmlhttp.send();
}

var count = function(checkedResults){
var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var arr = JSON.parse(this.responseText);
			let type;
			if(arr == null)
				type = checkedResults.length;
			else{
				type = arr.count+checkedResults.length;
			}
			console.log(type);
			//document.getElementById("count").innerHTML="<p>Total Movie " +
			//"ADDED is "+arr.count;
			if(checkedResults.length ==0){
				alert('no movie selected');
			}
			else if(type > 10){
				alert("Cant Add More Movies");
				window.location.href="/MovieCart1/";
			}
			else{
				alert("Movies Add In Cart");
				window.location.href="/MovieCart1/add?ids="+checkedResults.join(',')
			}
		}
	};
	
	var params = "type=2";
	xmlhttp.open('GET',"http://localhost:8084/MovieCart1/view?"+params, true);
	xmlhttp.send();
}
let Detail = function Details(str){
	for(let i=0;i<str.length;i++){
		let id = str[i];
		let APIKEY = "1f39dea1e4239caa8c1ae2c4975e9926";
		let baseURL="https://api.themoviedb.org/3/movie/";
		let url = baseURL+id+"?api_key="+APIKEY+"&language=en-US";
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				let movieObj="";
				var data = JSON.parse(this.responseText);
				movieObj+="<div class='items'>";
		        movieObj += '<div class="list-item" id="movie-' + data.id+ '"> <img src="http://image.tmdb.org/t/p/w500' + data.poster_path + '" width=200 height=300/><button class="remove-item" onclick="remove('+data.id+')">Remove</button></div>';
		        movieObj+="</div>";
		        $mydiv.append(movieObj);
			}
		}
	}
}