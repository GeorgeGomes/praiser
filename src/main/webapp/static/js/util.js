function getSegment(url, segment){
	try{
		url = url.replace("http://","");
		url = url.replace("https://","");
	
		url = url.split("/");
		
		return url[segment-1];
	}catch(e){
		return "";
	}
}