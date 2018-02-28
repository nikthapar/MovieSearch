let $output = $("#output");
let data = null;
let $submit = $('#submit');
function myFunction(){
	var APIKEY = "1f39dea1e4239caa8c1ae2c4975e9926";
	var baseURL="https://api.themoviedb.org/3/";
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
	let movieList = data ? data.results : [];
	for(let i = 0; i < movieList.length; i++){
		let item = movieList[i];
		$output.append(getMovieItemHTML(item));
	}
};

function getMovieItemHTML(item){
	let html = "";
	html = "<div class='movie-item'><input type='checkbox' name='movie'/><span class='movie-name'>" + item.title + "</span></div>"
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
	if(checkedResults.length ==0){
		alert('no movie selected');
	}else{
		window.location.href="/Movies/add?ids="+checkedResults.join(',')
	}
	
})